/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package civerse.world.entity.creature;

import java.util.Random;

/**
 *
 * @author Idest
 */
public class Genes {
    
    public enum Coloration {
        normal,leuco,melano;
    }
    
    //The masks for getting values and dominance of a trait
    private static final long valMask  = 0b1111L;
    private static final long domMask = 0b11L;
    private static final long traitMask = 0b11_1111L;
    
    private long setA;
    private long setB;
    
    public static void main(String[] args) {
        
        Genes mother = new Genes();
        Genes father = new Genes();
        Genes child = combineGenes(mother,father);
        
        mother.printGenes();
        father.printGenes();
        child.printGenes();
        
    }
    
    public static Genes combineGenes(Genes a, Genes b) {
        
        //do not touch these magic numbers
        int bit[] = {58,52,46,40,34,28,22,16,10};
        
        float chanceNotToMutate = 0.96F;
        
        Random random = new Random();
        
        long tempA;
        long tempB;
        
        //The new genes
        long setA = 0b0L;
        long setB = 0b0L;
        
        //Used if there is a mutation
        long setM  = random.nextLong();
        
        //Go through each part
        for(int i = 0; i < bit.length; i++) {
            
            //calc father
            if(Math.random() > chanceNotToMutate) {
                tempA = setM >>> bit[i] << (bit[i] + (i * 6L)) >>> (i * 6L);
            } else if(Math.random() > 0.50) {
                tempA = a.setA >>> bit[i] << (bit[i] + (i * 6L)) >>> (i * 6L);
            } else {
                tempA = a.setB >>> bit[i] << (bit[i] + (i * 6L)) >>> (i * 6L);
            }
            
            //calc mother
            if(Math.random() > chanceNotToMutate) {
                tempB = setM >>> bit[i] << (bit[i] + (i * 6L)) >>> (i * 6L);
            } else if(Math.random() > 0.50) {
                tempB = a.setA >>> bit[i] << (bit[i] + (i * 6L)) >>> (i * 6L);
            } else {
                tempB = a.setB >>> bit[i] << (bit[i] + (i * 6L)) >>> (i * 6L);
            }
            
            //attach trait to setA
            setA = setA | tempA;
            setB = setB | tempB;
            
        }
        
        
        return new Genes(setA,setB);
    }
    
    public Genes(long a, long b) {
        setA = a;
        setB = b;
    }
    
    public Genes() {
        
        Random random = new Random();

        //generate random genes
        setA = random.nextLong();
        setB = random.nextLong();
        
    }
    
    public void printGenes() {
        
        System.out.println("The genes are:");
        System.out.println(setA);
        System.out.println(setB);
        
        System.out.println();
        System.out.println("In binary:");
        System.out.println(String.format("%64s", Long.toBinaryString(setA)).replace(' ', '0'));
        System.out.println(String.format("%64s", Long.toBinaryString(setB)).replace(' ', '0'));
        System.out.println();
        
        System.out.println("The outcome of the two are as follows:");
        System.out.println("Strength:\t" + getStrength());
        System.out.println("Dexterity:\t" + getDexterity());
        System.out.println("Speed:\t\t" + getSpeed());
        System.out.println("Intelligence:\t" + getIntelligence());
        System.out.println("Willpower:\t" + getWillpower());
        System.out.println("Willpower:\t" + getWillpower());
        System.out.println("Wisdom:\t\t" + getWisdom());
        System.out.println("Power:\t\t" + getPower());
        System.out.println("Resistance:\t" + getResistance());
        System.out.println("Resiliance:\t" + getResiliance());
        
        System.out.println();
        System.out.println("Coloration: " + getColoration().name());
    }
    
    public byte getStrength() {
        
        long traitA = (setA >> 62) & domMask;
        long traitB = (setB >> 62) & domMask;
        
        //if setA is more dominate than setB
        if( traitA > traitB ) {
            //return setA
            return (byte) ((setA >> 58) & valMask);
        } else if (traitB > traitA) {
            //return setB
            return (byte) ((setB >> 58) & valMask);
        } else {
            //return the average of the two
            return (byte) ( (((setA >> 58) & valMask) + ((setB >> 58) & valMask) ) / 2);
        }
    }
    
    public byte getDexterity() {
        
        long traitA = (setA >> 56) & domMask;
        long traitB = (setB >> 56) & domMask;
        
        //if setA is more dominate than setB
        if( traitA > traitB ) {
            //return setA
            return (byte) ((setA >> 52) & valMask);
        } else if (traitB > traitA) {
            //return setB
            return (byte) ((setB >> 52) & valMask);
        } else {
            //return the average of the two
            return (byte) ( (((setA >> 52) & valMask) + ((setB >> 52) & valMask) ) / 2);
        }
    }
    
    public byte getSpeed() {
        
        long traitA = (setA >> 50) & domMask;
        long traitB = (setB >> 50) & domMask;
        
        //if setA is more dominate than setB
        if( traitA > traitB ) {
            //return setA
            return (byte) ((setA >> 46) & valMask);
        } else if (traitB > traitA) {
            //return setB
            return (byte) ((setB >> 46) & valMask);
        } else {
            //return the average of the two
            return (byte) ( (((setA >> 46) & valMask) + ((setB >> 46) & valMask) ) / 2);
        }
    }
    
    public byte getIntelligence() {
        
        long traitA = (setA >> 44) & domMask;
        long traitB = (setB >> 44) & domMask;
        
        //if setA is more dominate than setB
        if( traitA > traitB ) {
            //return setA
            return (byte) ((setA >> 40) & valMask);
        } else if (traitB > traitA) {
            //return setB
            return (byte) ((setB >> 40) & valMask);
        } else {
            //return the average of the two
            return (byte) ( (((setA >> 40) & valMask) + ((setB >> 40) & valMask) ) / 2);
        }
    }
    
    public byte getWillpower() {
        
        long traitA = (setA >> 38) & domMask;
        long traitB = (setB >> 38) & domMask;
        
        //if setA is more dominate than setB
        if( traitA > traitB ) {
            //return setA
            return (byte) ((setA >> 34) & valMask);
        } else if (traitB > traitA) {
            //return setB
            return (byte) ((setB >> 34) & valMask);
        } else {
            //return the average of the two
            return (byte) ( (((setA >> 34) & valMask) + ((setB >> 34) & valMask) ) / 2);
        }
    }
    
    public byte getWisdom() {
        
        long traitA = (setA >> 32) & domMask;
        long traitB = (setB >> 32) & domMask;
        
        //if setA is more dominate than setB
        if( traitA > traitB ) {
            //return setA
            return (byte) ((setA >> 28) & valMask);
        } else if (traitB > traitA) {
            //return setB
            return (byte) ((setB >> 28) & valMask);
        } else {
            //return the average of the two
            return (byte) ( (((setA >> 28) & valMask) + ((setB >> 28) & valMask) ) / 2);
        }
    }
    
    public byte getPower() {
        
        long traitA = (setA >> 26) & domMask;
        long traitB = (setB >> 26) & domMask;
        
        //if setA is more dominate than setB
        if( traitA > traitB ) {
            //return setA
            return (byte) ((setA >> 22) & valMask);
        } else if (traitB > traitA) {
            //return setB
            return (byte) ((setB >> 22) & valMask);
        } else {
            //return the average of the two
            return (byte) ( (((setA >> 22) & valMask) + ((setB >> 22) & valMask) ) / 2);
        }
    }
    
    public byte getResistance() {
        
        long traitA = (setA >> 20) & domMask;
        long traitB = (setB >> 20) & domMask;
        
        //if setA is more dominate than setB
        if( traitA > traitB ) {
            //return setA
            return (byte) ((setA >> 16) & valMask);
        } else if (traitB > traitA) {
            //return setB
            return (byte) ((setB >> 16) & valMask);
        } else {
            //return the average of the two
            return (byte) ( (((setA >> 16) & valMask) + ((setB >> 16) & valMask) ) / 2);
        }
    }
    
    public byte getResiliance() {
        
        long traitA = (setA >> 14) & domMask;
        long traitB = (setB >> 14) & domMask;
        
        //if setA is more dominate than setB
        if( traitA > traitB ) {
            //return setA
            return (byte) ((setA >> 10) & valMask);
        } else if (traitB > traitA) {
            //return setB
            return (byte) ((setB >> 10) & valMask);
        } else {
            //return the average of the two
            return (byte) ( (((setA >> 10) & valMask) + ((setB >> 10) & valMask) ) / 2);
        }
    }
    
    public Coloration getColoration() {
        
        int bit[] = {62,56,50,44,38,32,26,20,14};
        int count = 0;
        
        for(int i = 0; i < bit.length; i++) {
            count += ((setA >> bit[i]) & domMask) + ((setB >> bit[i]) & domMask);
        }

        switch(count) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return Coloration.leuco;
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
                return Coloration.melano;
            default:
                if(count > 52) {
                    System.out.println(count);
                }
                return Coloration.normal;
        }
    }
}
