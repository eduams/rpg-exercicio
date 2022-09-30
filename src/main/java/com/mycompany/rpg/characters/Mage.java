/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpg.characters;

/**
 *
 * @author eduar
 */
public class Mage extends Human{
    public String name;
    private float hp;
    private int magicP;
    private int cureP;
    private int xp;
    private float maxHp;
        
    public Mage (String name, int hp, int magicP, int cureP, int xp, float maxHp) {
        super(name);
        this.hp = hp;
        this.magicP = magicP;
        this.cureP = cureP;
        this.xp = xp;
        this.maxHp = hp;
    }
    
    public int Attack (){
        return magicP + xp;
    }
    
    public float damageTaken (float dano){
        return hp = hp - dano;

    }
    
    public float heal(){
        try{
        return hp = hp + cureP;
        }
        finally{
            if (hp > maxHp){
            hp = maxHp;
        }
        }
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public float getHp() {
        return hp;
    }

    public float getCureP() {
        return cureP;
    }
    public int xpAdd(){
    return xp = xp + 1;
    }
    public void death(String nome){
            System.out.println("O " + nome + " morreu!");
    }
        @Override
    	public String toString () {
            return "HP: "+ hp + " XP: " + xp + " Poder de luta atual: " + Attack();
	}

}
