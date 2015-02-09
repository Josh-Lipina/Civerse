package civerse.world;

/**
 *
 * @author Idest
 */
public class World {
    
    double seed;
    
    public World() {
        seed = new Double(Math.random());
    }
    
    public World(double seed) {
        this.seed = seed;
    }
    
}
