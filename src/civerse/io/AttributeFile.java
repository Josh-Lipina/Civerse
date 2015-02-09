package civerse.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Idest
 */
public class AttributeFile {
    
    //The file in which this class is referenced to
    private final File file;
    
    //This is used as a "cache" of sorts so we can modify files and reload if we
    //desire without any issue
    private List<String> key;
    private List<String> value;
    
    public AttributeFile(File file) throws IOException {

        this.file = file;
        
        read();
    }
    
    private void read() throws IOException {
        //Either this erases the previous value or prepares the variable to
        //be a usable object that we can build from
        key = new ArrayList<>();
        value = new ArrayList<>();
        
        //Modify this to support more charsets?
        //worth it?
        Charset charset = Charset.forName("UTF-8");
        
        try (BufferedReader reader = Files.newBufferedReader(file.toPath(), charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                //if this is not a comment
                if( (!line.startsWith("[")) && line.contains("=")) {
                    //seperate the key and value
                    
                    String[] part = line.split("=");

                    //Make sure there is only two parts
                    //that's how it's supposed to be
                    //otherwise just don't mess with it
                    if(part.length == 2) {
                        //set the key
                        key.add(part[0]);
                        
                        //set the value
                        value.add(part[1]);
                    }
                    
                }
            }
        }
    
    
    }
    
    /**
     * Returns the value of the key otherwise returns null. Null should be
     * treated as a valid return from this function.
     * @param key
     * @return 
     */
    public String getAttribute(String key) {
        if(this.key.contains(key)) {
            return value.get(this.key.indexOf(key));
        }
        return null;
    }
    
    /**
     * Sets the attribute to the value provided. It will create a new 
     * @param key
     * @param value 
     */
    public void setAttribute(String key, String value) {
        //if the key already exists
        if(this.key.contains(key)) {
            //set the new value
            this.value.set(this.key.indexOf(key), value);
            
        } else {
            //else add the key and the value
            this.key.add(key);
            this.value.add(value);
        }
    }
}
