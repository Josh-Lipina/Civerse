package civerse.world.entity.trainer;

import civerse.world.entity.item.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Idest
 */
public class Inventory {
    
    private List<Item> inventory = new ArrayList<>();
    private String inventoryName;
    
    public Inventory(String name) {
        this.inventoryName = name;
    }
    
    public String getName() {
        return inventoryName;
    }
    
    public Item getItem(int index) {
        return inventory.get(index);
    }
    
    public int getItemAmount(int index) {
        return 1;
    }
}
