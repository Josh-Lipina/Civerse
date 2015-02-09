package civerse.world.entity.creature;

/**
 *
 * @author Idest
 */
class Disposition {
    
    public final String name;
    
    public final byte strength;
    public final byte dexterity;
    public final byte speed;
    
    public final byte intelligence;
    public final byte willpower;
    public final byte wisdom;
    
    public final byte power;
    public final byte resistence;
    public final byte resiliance;
    
    public Disposition(String name,
            byte percentStrength,
            byte percentDexterity,
            byte percentSpeed,
            byte percentIntelligence,
            byte percentWillpower,
            byte percentWisdom,
            byte percentPower,
            byte percentResistence,
            byte percentResiliance) {
        
        this.name = name;
        
        this.strength = percentStrength;
        this.dexterity = percentDexterity;
        this.speed = percentSpeed;
        
        this.intelligence = percentIntelligence;
        this.willpower = percentWillpower;
        this.wisdom = percentWisdom;
        
        this.power = percentPower;
        this.resistence = percentResistence;
        this.resiliance = percentResiliance;
    }
    
   
    
}
