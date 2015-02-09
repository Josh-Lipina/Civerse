package civerse.world.entity.creature;

import civerse.io.AttributeFile;
import java.util.Set;

/**
 * Contains basic information for every species in the game.
 * 
 * @author Idest
 */
public class Species {
    
    public static final int STRENGTH = 0;
    public static final int DEXTERITY = 1;
    public static final int SPEED = 2;
    public static final int INTELLIGENCE = 3;
    public static final int WILLPOWER = 4;
    public static final int WISDOM = 5;
    public static final int POWER = 6;
    public static final int RESISTANCE = 7;
    public static final int RESILIENCE = 8;
    
    private static Set<Species> speciesSet;
    
    /**
     * Accepts a file in which it builds the class upon. The file must follow
     * the .species file type format for it to work correctly.
     * @param attFile 
     */
    public static void registerSpecies(AttributeFile attFile) {
        AttributeFile[] attFiles = {attFile};
        Species.registerSpecies(attFiles);
    }
    
    /**
     * Accepts an array of files in which it builds the classes upon. The files
     * must follow the .species file type format for it to work correctly.
     * @param attFiles 
     */
    public static void registerSpecies(AttributeFile[] attFiles) {
        
        Species[] species = new Species[attFiles.length];
        
        for(int i= 0; i < attFiles.length; i++) {
            
            //variables we require for the cosntructor in string format
            String name = attFiles[i].getAttribute("species");
            
            Type primary = Type.getType(attFiles[i].getAttribute("primaryType"));
            Type secondary = Type.getType(attFiles[i].getAttribute("secondaryType"));
            byte catchRate = Byte.parseByte(attFiles[i].getAttribute("catchRate"));
            
            int[] baseStats = {
                Integer.getInteger(attFiles[i].getAttribute("baseStrength")),
                Integer.getInteger(attFiles[i].getAttribute("baseDexterity")),
                Integer.getInteger(attFiles[i].getAttribute("baseSpeed")),
                Integer.getInteger(attFiles[i].getAttribute("baseIntelligence")),
                Integer.getInteger(attFiles[i].getAttribute("baseWillpower")),
                Integer.getInteger(attFiles[i].getAttribute("baseWisdom")),
                Integer.getInteger(attFiles[i].getAttribute("basePower")),
                Integer.getInteger(attFiles[i].getAttribute("baseResistance")),
                Integer.getInteger(attFiles[i].getAttribute("baseResilience"))
            };
            
            int[] trainValues = {
                Integer.getInteger(attFiles[i].getAttribute("trainStrength")),
                Integer.getInteger(attFiles[i].getAttribute("trainDexterity")),
                Integer.getInteger(attFiles[i].getAttribute("trainSpeed")),
                Integer.getInteger(attFiles[i].getAttribute("trainIntelligence")),
                Integer.getInteger(attFiles[i].getAttribute("trainWillpower")),
                Integer.getInteger(attFiles[i].getAttribute("trainWisdom")),
                Integer.getInteger(attFiles[i].getAttribute("trainPower")),
                Integer.getInteger(attFiles[i].getAttribute("trainResistance")),
                Integer.getInteger(attFiles[i].getAttribute("trainResilience"))
            };
            
            
            LevelRate levelRate = LevelRate.getLevelRate(attFiles[i].getAttribute("levelRate"));
            
            //create the species object and register it to the set
            registerSpecies(new Species(name,primary,secondary,catchRate,baseStats,trainValues,levelRate));
        }
        
    }
    
    /**
     * Registers the species to the set. Duplicates will not be added as they
     * already exist.
     * @param species
     */
    public static void registerSpecies(Species species) {
        speciesSet.add(species);
    }
    
    /**
     * Returns the species set.
     * @return 
     */
    public static Set<Species> getSpeciesSet() {
        return speciesSet;
    }

    private Exception SpeciesConstructorException() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public enum LevelRate{
        medium, slow, fast, erratic, steady;
        
        /**
         * This function returns the level for which the experience was earned
         * for base on the rate provided.
         * @param rate
         * @param experience
         * @return The level that the parameters meet.
         */
        public static int getLevel(LevelRate rate, int experience) {
            
            double requirement;
            
            switch(rate) {
                case slow:
                    
                    //calculate up until the requirement is no longer met
                    //and then we have our level
                    for(int i = 0; i < 100; i++) {
                        
                        //calculate the requirement to reach the level
                        requirement = Math.floor(Math.pow(i,3.1d) + (80d * i) + 80d);
                        
                        if(experience <= requirement) {
                            return i + 1;
                        }
                    }
                    
                    //experience is beyond level 100 but level 100 is max so
                    //return the max value for level
                    return 100;
                case medium:
                    
                    //calculate up until the requirement is no longer met
                    //and then we have our level
                    for(int i = 0; i < 100; i++) {
                        //calculate the requirement to reach the level
                        requirement = Math.pow(i,3d) + (80d * i) + 80d;
                        
                        if(experience <= requirement)
                            return i + 1;
                    }
                    
                    return 100;
                case erratic:
                    
                    //calculate up until the requirement is no longer met
                    //and then we have our level
                    for(int i = 0; i < 100; i++) {
                        
                        //calculate the requirement to reach the level
                        requirement = Math.floor(((i % 29d) * 27d) + ((i % 7d) * 625d) + (80d * Math.pow(i,2d)) + 80);
                        
                        if(experience <= requirement) {
                            return i + 1;
                        }
                    }
                    
                    return 100;
                case steady:
                    
                    //calculate up until the requirement is no longer met
                    //and then we have our level
                    for(int i = 0; i < 100; i++) {
                        
                        //calculate the requirement to reach the level
                        requirement = Math.floor(Math.pow(80d * i,1.5d) + 80);
                        
                        if(experience <= requirement) {
                            return i + 1;
                        }
                    }
                    
                    return 100;
                case fast:
                    
                    //calculate up until the requirement is no longer met
                    //and then we have our level
                    for(int i = 0; i < 100; i++) {
                        
                        //calculate the requirement to reach the level
                        requirement = Math.floor(Math.pow(i,2.9d) + (80d * i) + 80d);
                        
                        if(experience <= requirement) {
                            return i + 1;
                        }
                    }
                    
                    return 100;
            }
           
            return 0;
        }
        
        /**
         * Returns the string equivalent of the level rate.
         * @param s
         * @return 
         */
        public static LevelRate getLevelRate(String s) {
            for(int i = 0; i < LevelRate.values().length; i++) {
                if(LevelRate.values()[i].name().equals(s)) {
                    return LevelRate.values()[i];
                }
            }
            return null;
        }
    }
    
    //The name of the species
    public final String name;
    
    //The two types of the species. Secondary type can be null if the species
    // only has one type.
    public final Type primaryType;
    public final Type secondaryType;

    //This value is a percentage that ranges from 1 to 100
    //This is the base number used to determine the success rate
    public final byte catchRate;
    
    //The species base stats
    //The min-max values range from 1 to 300
    /**
     * The order goes as follows:
     *  0 Strength
     *  1 Dexterity
     *  2 Speed
     *  3 Intelligence
     *  4 Willpower
     *  5 Wisdom
     *  6 Power
     *  7 Resistance
     *  8 Resilience
     */
    public final int baseStats[];
    
    /**
     * The order goes as follows:
     *  0 Strength
     *  1 Dexterity
     *  2 Speed
     *  3 Intelligence
     *  4 Willpower
     *  5 Wisdom
     *  6 Power
     *  7 Resistance
     *  8 Resilience
     */
    public final int[] trainValues;
    
    //How the species will level
    public final LevelRate levelRate;
    
    public Species(
            String speciesName,
            Type primary,
            Type secondary,
            byte catchRate,
            int[] baseStats,
            int[] trainValues,
            LevelRate levelRate
                    ) {
        //Assign Name/ID
        this.name = speciesName;
        
        //Assign Types
        this.primaryType = primary;
        this.secondaryType = secondary;
        
        //Assign catch rate
        this.catchRate = catchRate;
        
        this.baseStats = baseStats;
        this.trainValues = trainValues;
        
        this.levelRate = levelRate;
        
    }

}