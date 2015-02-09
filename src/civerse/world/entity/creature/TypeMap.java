package civerse.world.entity.creature;

import java.util.Set;

/**
 *
 * @author Idest
 */
public class TypeMap {
    
    private static int[][] modifierMap;
    
    public static void generateTypeMap(Set<Type> typeSet, int[][] map) {
        
        if(typeSet.size() == map.length) {
            modifierMap = map;
        }
        
    }
    
    public static int getModifier(Type attacker, Type defender) {
        return modifierMap[attacker.indexVal][defender.indexVal];
    }
}
