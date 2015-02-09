package civerse.world.entity.item;

import civerse.world.entity.Entity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Idest
 */
public class Item extends Entity {
    
    private String name;
    private String description;
    private List<String> tags = new ArrayList<>();
    
    public void Item(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public void Item(String name, String description, String[] tags) {
        this.name = name;
        this.description = description;
        
        for(int i = 0; i < tags.length; i++) {
            this.tags.add(tags[i]);
        }
    }
    
    public List<String> getTags() {
        return this.tags;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void use(Entity target) {
        //to implement
    }
}
