package civerse.world.entity.creature;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Idest
 */
public class Type {
    
    //These are the "default" types for the game.
    //Eventually this will be read from a file
    public static final Type normal = new Type("normal");
    public static final Type spark = new Type("spark");
    public static final Type plasma = new Type("plasma");
    public static final Type cold = new Type("cold");
    public static final Type fire = new Type("fire");
    public static final Type toxic = new Type("toxic");
    public static final Type acid = new Type("acid");
    public static final Type poison = new Type("poison");
    public static final Type force = new Type("force");
    public static final Type psychic = new Type("psychic");
    public static final Type light = new Type("light");
    public static final Type rock = new Type("rock");
    public static final Type metal = new Type("metal");
    public static final Type air = new Type("air");
    public static final Type water = new Type("water");
    public static final Type nature = new Type("nature");
    public static final Type v0id = new Type("void");
    public static final Type scale = new Type("scale");
    public static final Type mystic = new Type("mystic");
    public static final Type ethereal = new Type("ethereal");
    public static final Type dark = new Type("dark");
    public static final Type crystal = new Type("crystal");
    public static final Type decay = new Type("decay");
    
    private static int nextIndex = 0;
    
    private static Set<Type> typeSet = new HashSet<>();
    
    public static Type getType(String s) {
        Type[] typeArray = (Type[]) typeSet.toArray();
        for(int i = 0; i < 0; i++) {
            if(typeArray[i].equals(s)) {
                return typeArray[i];
            }
        }
        return null;
    }
    
    public final String name;
    public final int indexVal;
    
    @SuppressWarnings("LeakingThisInConstructor")
    public Type(String name) {
        this.name = name;
        this.indexVal = nextIndex++;
        
        //this instruction MUST be last
        typeSet.add(this);
    }
    
    @Override
    public boolean equals(Object object) {
        
        if(object instanceof Type) {
            return ((Type) object).name.equals(this.name);
        }
    
        return false;
    }
    
    public boolean equals(String string) {
        return (string.equals(this.name));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.indexVal;
        return hash;
    }
}
