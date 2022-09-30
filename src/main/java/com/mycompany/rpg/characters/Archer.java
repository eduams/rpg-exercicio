/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpg.characters;

/**
 *
 * @author eduar
 */
public class Archer extends Human{
    

    private String name;
    private float hp;
    private int xp;
    private int speed;

    
    public Archer (String name, int hp, int speed, int xp) {
        super(name);
        this.hp = hp;
        this.xp = xp;
        this.speed = speed;
    }
    
    public int Attack (){
        return speed;
    }
    
    public float damageTaken (float dano){
        return hp = hp - dano;
    }
    
    public float heal(){
        System.out.println("Você não tem esse poder!");
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

    public void setHp(float hp) {
        this.hp = hp;
    }
        @Override
    	public String toString () {
            return "HP: "+ hp + " XP: " + xp + " Poder de luta atual: " + Attack();
	}

}
