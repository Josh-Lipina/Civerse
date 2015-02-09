package civerse.world.entity.creature;

import civerse.world.entity.Entity;
import java.util.List;

/**
 *
 * @author Idest
 */
public class Creature extends Entity {
    
    private static int maxTotalTraining = 704;
    private static int maxTraining = 128;
    
    private Species species;
    private String name;
    private int experience;
    private int level;
    
    //EV
    private int trainStrength;
    private int trainDexterity;
    private int trainSpeed;
    
    private int trainIntelligence;
    private int trainWillpower;
    private int trainWisdom;
    
    private int trainPower;
    private int trainResistance;
    private int trainResilience;
    
    //IV
    private Genes genes;
    
    //SV
    private int statStrength;
    private int statDexterity;
    private int statSpeed;
    
    private int statIntelligence;
    private int statWillpower;
    private int statWisdom;
    
    private int statPower;
    private int statResistence;
    private int statResiliance;
    
    //Known moves of this creature
    private List<Move> moves;
    
    //disposition or stat modifier of the creature
    private Disposition disposition;
    
    //Gender
    public final Gender gender;
    
    public Creature(Species species, int experience) {
        this.species = species;
        this.name = species.name;
        this.experience = experience;
        
        this.gender = Gender.genderless;
        
    }
    
    public Creature(Species species, byte level) {
        this.species = species;
        this.name = species.name;
        
        this.gender = Gender.genderless;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void addExperience(int amount) {
        experience += amount;
        calcStats();
    }
    
    public Species getSpecies() {
        return this.species;
    }
    
    public int getStrength() {
        return this.statStrength;
    }
    
    public int getDexterity() {
        return this.statDexterity;
    }
    
    public int getSpeed() {
        return this.statSpeed;
    }
    
    public int getIntelligence() {
        return this.statIntelligence;
    }
    
    public int getWillpower() {
        return this.statWillpower;
    }
    
    public int getWisdom() {
        return this.statWisdom;
    }
    
    public int getPower() {
        return this.statPower;
    }
    
    public int getResistance() {
        return this.statResistence;
    }
    
    public int getResilience() {
        return this.statResiliance;
    }
    
    private boolean isTrainingMaxed() {
        //704 should be the highest accumulated training
        return totalTraining() >= maxTotalTraining;
    }
    
    private int totalTraining() {
        //calculates the total trained
        return this.trainDexterity + this.trainIntelligence + this.trainPower + this.trainResilience + this.trainResistance + this.trainSpeed + this.trainWillpower + this.trainWisdom + this.trainStrength;
    }
    
    public void trainStrength(int amount) {
        //some bad catching to future problems we may have with modding
        if(amount > 3 || amount < 0) {
            System.out.println("We should not be training by: " + amount);
            
            if(amount > 3)
                amount = 3;
            
            if(amount < 0)
                amount = 0;
        }
        
        //train the value
        this.trainStrength += amount;
        
        //if it went over then we reduce it to the highest value it is supposed
        //to be
        if(this.trainStrength > maxTraining) {
            this.trainStrength = maxTraining;
        }
        
        //if the total training went over then we reduce the train strength by
        //that amount
        if(totalTraining() > maxTotalTraining) {
            this.trainStrength = this.trainStrength - (totalTraining() - maxTotalTraining);
        }
        
        calcStrength();
    }
    
    public void trainDexterity(int amount) {
        //some bad catching to future problems we may have with modding
        if(amount > 3 || amount < 0) {
            System.out.println("We should not be training by: " + amount);
            
            if(amount > 3)
                amount = 3;
            
            if(amount < 0)
                amount = 0;
        }
        
        //train the value
        this.trainDexterity += amount;
        
        //if it went over then we reduce it to the highest value it is supposed
        //to be
        if(this.trainDexterity > maxTraining) {
            this.trainDexterity = maxTraining;
        }
        
        //if the total training went over then we reduce the train strength by
        //that amount
        if(totalTraining() > maxTotalTraining) {
            this.trainDexterity = this.trainDexterity - (totalTraining() - maxTotalTraining);
        }
        
        calcDexterity();
    }
    
    public void trainSpeed(int amount) {
        //some bad catching to future problems we may have with modding
        if(amount > 3 || amount < 0) {
            System.out.println("We should not be training by: " + amount);
            
            if(amount > 3)
                amount = 3;
            
            if(amount < 0)
                amount = 0;
        }
        
        //train the value
        this.trainSpeed += amount;
        
        //if it went over then we reduce it to the highest value it is supposed
        //to be
        if(this.trainSpeed > maxTraining) {
            this.trainSpeed = maxTraining;
        }
        
        //if the total training went over then we reduce the train strength by
        //that amount
        if(totalTraining() > maxTotalTraining) {
            this.trainSpeed = this.trainSpeed - (totalTraining() - maxTotalTraining);
        }
        
        calcSpeed();
    }
    
    public void trainIntelligence(int amount) {
        //some bad catching to future problems we may have with modding
        if(amount > 3 || amount < 0) {
            System.out.println("We should not be training by: " + amount);
            
            if(amount > 3)
                amount = 3;
            
            if(amount < 0)
                amount = 0;
        }
        
        //train the value
        this.trainIntelligence += amount;
        
        //if it went over then we reduce it to the highest value it is supposed
        //to be
        if(this.trainIntelligence > maxTraining) {
            this.trainIntelligence = maxTraining;
        }
        
        //if the total training went over then we reduce the train strength by
        //that amount
        if(totalTraining() > maxTotalTraining) {
            this.trainIntelligence = this.trainDexterity - (totalTraining() - maxTotalTraining);
        }
        
        calcIntelligence();
    }
    
    public void trainWillpower(int amount) {
        //some bad catching to future problems we may have with modding
        if(amount > 3 || amount < 0) {
            System.out.println("We should not be training by: " + amount);
            
            if(amount > 3)
                amount = 3;
            
            if(amount < 0)
                amount = 0;
        }
        
        //train the value
        this.trainIntelligence += amount;
        
        //if it went over then we reduce it to the highest value it is supposed
        //to be
        if(this.trainWillpower > maxTraining) {
            this.trainWillpower = maxTraining;
        }
        
        //if the total training went over then we reduce the train strength by
        //that amount
        if(totalTraining() > maxTotalTraining) {
            this.trainWillpower = this.trainWillpower - (totalTraining() - maxTotalTraining);
        }
        
        calcWillpower();
    }
    
    public void trainWisdom(int amount) {
        //some bad catching to future problems we may have with modding
        if(amount > 3 || amount < 0) {
            System.out.println("We should not be training by: " + amount);
            
            if(amount > 3)
                amount = 3;
            
            if(amount < 0)
                amount = 0;
        }
        
        //train the value
        this.trainWisdom += amount;
        
        //if it went over then we reduce it to the highest value it is supposed
        //to be
        if(this.trainWisdom > maxTraining) {
            this.trainWisdom = maxTraining;
        }
        
        //if the total training went over then we reduce the train strength by
        //that amount
        if(totalTraining() > maxTotalTraining) {
            this.trainWisdom = this.trainWisdom - (totalTraining() - maxTotalTraining);
        }
        
        calcWisdom();
    }
    
    public void trainPower(int amount) {
        //some bad catching to future problems we may have with modding
        if(amount > 3 || amount < 0) {
            System.out.println("We should not be training by: " + amount);
            
            if(amount > 3)
                amount = 3;
            
            if(amount < 0)
                amount = 0;
        }
        
        //train the value
        this.trainPower += amount;
        
        //if it went over then we reduce it to the highest value it is supposed
        //to be
        if(this.trainPower > maxTraining) {
            this.trainPower = maxTraining;
        }
        
        //if the total training went over then we reduce the train strength by
        //that amount
        if(totalTraining() > maxTotalTraining) {
            this.trainPower = this.trainPower - (totalTraining() - maxTotalTraining);
        }
    }
    
    public void trainResistance(int amount) {
        //some bad catching to future problems we may have with modding
        if(amount > 3 || amount < 0) {
            System.out.println("We should not be training by: " + amount);
            
            if(amount > 3)
                amount = 3;
            
            if(amount < 0)
                amount = 0;
        }
        
        //train the value
        this.trainResistance += amount;
        
        //if it went over then we reduce it to the highest value it is supposed
        //to be
        if(this.trainResistance > maxTraining) {
            this.trainResistance = maxTraining;
        }
        
        //if the total training went over then we reduce the train strength by
        //that amount
        if(totalTraining() > maxTotalTraining) {
            this.trainResistance = this.trainResistance - (totalTraining() - maxTotalTraining);
        }
        
        calcResistance();
    }
    
    public void trainResilience(int amount) {
        //some bad catching to future problems we may have with modding
        if(amount > 3 || amount < 0) {
            System.out.println("We should not be training by: " + amount);
            
            if(amount > 3)
                amount = 3;
            
            if(amount < 0)
                amount = 0;
        }
        
        //train the value
        this.trainResilience += amount;
        
        //if it went over then we reduce it to the highest value it is supposed
        //to be
        if(this.trainResilience > maxTraining) {
            this.trainResilience = maxTraining;
        }
        
        //if the total training went over then we reduce the train strength by
        //that amount
        if(totalTraining() > maxTotalTraining) {
            this.trainResilience = this.trainResilience - (totalTraining() - maxTotalTraining);
        }
        
        calcResiliance();
    }
    
    private void calcStats() {
        calcLevel();
        calcStrength();
        calcDexterity();
        calcSpeed();
        calcIntelligence();
        calcWillpower();
        calcWisdom();
        calcPower();
        calcResistance();
        calcResiliance();
    }
    
    private void calcLevel() {
        this.level = Species.LevelRate.getLevel(this.species.levelRate, this.experience);
    }
    
    private void calcStrength() {
        this.statStrength = (int) Math.ceil( ((this.trainStrength / 4) + (this.species.baseStats[Species.STRENGTH]) + (this.genes.getStrength())) / (100 / this.level) );
    }
    
    private void calcDexterity() {
        this.statDexterity = (int) Math.ceil( ((this.trainDexterity / 4) + (this.species.baseStats[Species.DEXTERITY]) + (this.genes.getDexterity())) / (100 / this.level) );
    }
    
    private void calcSpeed() {
        this.statSpeed = (int) Math.ceil( ((this.trainSpeed / 4) + (this.species.baseStats[Species.SPEED]) + (this.genes.getSpeed())) / (100 / this.level) );
    }
    
    private void calcIntelligence() {
        this.statIntelligence = (int) Math.ceil( ((this.trainIntelligence / 4) + (this.species.baseStats[Species.INTELLIGENCE]) + (this.genes.getIntelligence())) / (100 / this.level) );
    }
    
    private void calcWillpower() {
        this.statWillpower = (int) Math.ceil( ((this.trainWillpower / 4) + (this.species.baseStats[Species.WILLPOWER]) + (this.genes.getWillpower())) / (100 / this.level) );
    }
    
    private void calcWisdom() {
        this.statWisdom = (int) Math.ceil( ((this.trainWisdom / 4) + (this.species.baseStats[Species.WISDOM]) + (this.genes.getWisdom())) / (100 / this.level) );
    }
    
    private void calcPower() {
        this.statPower = (int) Math.ceil( ((this.trainPower / 4) + (this.species.baseStats[Species.POWER]) + (this.genes.getPower())) / (100 / this.level) );
    }
    
    private void calcResistance() {
        this.statResistence = (int) Math.ceil( ((this.trainResistance / 4) + (this.species.baseStats[Species.RESISTANCE]) + (this.genes.getResistance())) / (100 / this.level) );
    }
    
    private void calcResiliance() {
        this.statResiliance = (int) Math.ceil( ((this.trainResilience / 4) + (this.species.baseStats[Species.RESILIENCE]) + (this.genes.getResiliance())) / (100 / this.level) );
    }
    
    /**
     * Returns the level of this creature. This number will range from 1 to 100.
     * @return 
     */
    public int getLevel() {
        return this.level;
    }
    
    public void addTrainValues(int[] trainValues) {

        //the order is
        // 0 strength
        // 1 dexterity
        // 2 speed
        // 3 intelligence
        // 4 willpower
        // 5 wisdom
        // 6 power
        // 7 resistance
        // 8 resiliance
        
        if(trainValues.length == 9) {
        
            this.trainStrength(trainValues[0]);
            this.trainDexterity(trainValues[1]);
            this.trainSpeed(trainValues[2]);
            this.trainIntelligence(trainValues[3]);
            this.trainWillpower(trainValues[4]);
            this.trainWisdom(trainValues[5]);
            this.trainPower(trainValues[6]);
            this.trainResistance(trainValues[7]);
            this.trainResilience(trainValues[8]);
            
            
        } else {
            System.out.println("Creature.addTrainValues is getting bad input... [ " + trainValues.length + "]");
        }
    }
}
