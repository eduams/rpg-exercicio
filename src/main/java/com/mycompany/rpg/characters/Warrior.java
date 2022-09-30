/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpg.characters;

/**
 *
 * @author eduar
 */
public class Warrior extends Human{
    
    private String name;
    private float hp;
    private int power;
    private int xp;
    
    
    public Warrior (String name, int hp, int power, int xp) {
        super(name);
        this.hp = hp;
        this.power = power;
        this.xp = xp;
    }
    
    public int Attack (){
        return power + xp;
    }
    
    public float damageTaken (float dano){
        return hp = hp - dano;
    }
    
    public float heal(){
        System.out.println("Você não tem essa habilidade!");
        return 0;
    }

    public float getHp() {
        return hp;
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

    public void setHp(float hp) {
        this.hp = hp;
    }
}
