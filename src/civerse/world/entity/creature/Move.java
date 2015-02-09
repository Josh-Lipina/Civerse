package civerse.world.entity.creature;

import java.util.Set;

/**
 *
 * @author Idest
 */
public class Move {
    
    private static Set<Move> moveSet;
    
    public static void registerMoves(Move[] moves) {
        for (int i = 0; i < moves.length; i++) {
            moveSet.add(moves[i]);
        }
    }
    
    public static void registerMove(Move move) {
        moveSet.add(move);
    }

    public static Set<Move> getMoveSet() {
        return moveSet;
    }
    
    public enum Category {
        physical, mental, elemental, status;
    }
    
    public enum Target {
        all,
        all_others,
        all_enemy,
        all_friendly,
        all_friendly_noself,
        all_adjacent,
        all_surrounding,
        
        self,
        
        target_any,
        target_friendly,
        target_friendly_noself,
        
        target_enemy_frontrow,
        target_enemy_backrow,
        target_row,
        target_column,
        target_enemy_column,
        target_friendly_column,
        target_center_column,
        target_enemy,
        
        front,

        enemy_backrow,
        enemy_frontrow,
        enemy_row,
        
        friendly_row,
        friendly_colum,
        friendly_adjacent,
        
        random_friendly,
        random_enemy,
        random_column,
        random_row,
        random_enemy_row,
        random_enemy_column,
        random_friendly_row,
        random_friendly_column,
        random_adjacent,
        random_noself,
        random
    }
    
    /**
     * The name of the move. This will be displayed.
     */
    public final String name;
    
    /**
     * The description of the move.
     */
    public final String description;
    
    /*
     * The lowest priority move will go first in a battle. Zero is considered
     * normal priority. Most moves will be a normal priority.
     */
    public final int priority;
    
    /**
     * The power modifier is a percentage number that modifies the power or
     * attack of the move calculation. 100 is considered a neutral modifier
     * where it will not increase or decrease the calculated attack.
     */
    public final int powerModifier;
    
    /**
     * The accuracy modifier is the calculated chance to miss the target. This
     * is multiplied with other calculations in combat. A number of 100 means
     * that it will not effect the normal calculation. This is a percentage
     * number that is multiplied against the total calculation of accuracy.
     */
    public final int accuracyModifier;
    
    /**
     * The speed modifier alters the movement speed that is calculated. A number
     * of 100 means that the move will not be modified. In combat this can
     * determine if a move goes before or after another move because it takes
     * longer to do this move or it can be done more quickly than other normal
     * moves (but does not have a different priority).
     */
    public final int speedModifier;
    
    /**
     * The amount of times this move can be used without recharging. Having zero
     * move points means that you can no longer use this move. This variable
     * sets the upper limit of this number unless it is modified outside this
     * class such as a creature holding an items, consuming and item, or
     * some other reason.
     */
    public final int baseMovePoints;
    
    /**
     * How and what is targeted. This determines some calculations of the move
     * and what it will effect.
     */
    public final Target target;
    
    /**
     * The percent change that this effect can occur. Zero is for when an effect
     * does not occur and 100 is for when this effect always occurs. The value
     * is a percentage value between 0 and 100.
     */
    public final int chanceOfEffect;
    
    /**
     * The effect that is to be applied to this move. This may be null is no
     * effect is to take place.
     */
    public final Effect effect;
    
    /**
     * Does this require the move to be accurate (hit its mark) in order for the
     * effect to take place?
     */
    public final boolean doesEffectRequireHit;
    
    /**
     * The type in which the move works.
     */
    public final Type type;
    
    protected Move(String name,
            String description,
            int priority,
            int powerModifier,
            int accuracyModifier,
            int speedModifier,
            int baseMovePoints,
            Target target,
            int chanceOfEffect,
            Effect effect,
            boolean doesEffectrequireHit,
            Type type) {
        
        /*
         More assertions should probably go here so if moves are acting "weird"
         we should add more assertions here to increase the strictness as some
         values could possibly have bad effects.
        
        */
        assert(name != null);
        assert(description != null);
        assert(type != null);
        
        
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.powerModifier = powerModifier;
        this.accuracyModifier = accuracyModifier;
        this.speedModifier = speedModifier;
        this.baseMovePoints = baseMovePoints;
        this.target = target;
        this.chanceOfEffect = chanceOfEffect;
        this.effect = effect;
        this.doesEffectRequireHit = doesEffectrequireHit;
        this.type = type;
    }

    
    
}
