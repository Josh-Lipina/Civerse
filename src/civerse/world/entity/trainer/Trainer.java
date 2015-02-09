package civerse.world.entity.trainer;

import civerse.world.entity.Entity;
import civerse.world.entity.creature.Creature;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Idest
 */
public class Trainer extends Entity {
    
    //The name of the trainer
    private String name;
    
    //The indentifcation number of the trainer
    private long ident;
    
    private List<Creature> party = new ArrayList<>();
    private List<Inventory> inventory = new ArrayList();
    
    /**
     * Creates a trainer with a random name with random creatures of a random
     * level.
     */
    public Trainer() {
        //unimplemented
    }
    
    /**
     * Creates a new trainer class with the specified name.
     * @param name 
     */
    public Trainer(String name) {
        this.name = name;
    }
    
    public Trainer(String name, String archType, int level) {
        //todo
    }
}
