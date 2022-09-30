package com.mycompany.rpg;

import com.mycompany.rpg.characters.Archer;
import com.mycompany.rpg.characters.Mage;
import com.mycompany.rpg.characters.Warrior;
import java.util.Scanner;

/**
 *
 * @author visitante
 */
public class BattleThings {   
    static Mage playerMage = new Mage("Dumbledore", 25, 10, 12, 0,25);
    static Archer playerArcher = new Archer("Arqueiro Verde", 20, 5, 0);
    static Warrior playerWarrior = new Warrior("Conan", 50, 6, 0);   

    static Mage playerMageEnemy = new Mage("Snape", 25, 10, 12, 0,25);
    static Archer playerArcherEnemy = new Archer("Gavião Arqueiro", 20, 5, 0);
    static Warrior playerWarriorEnemy = new Warrior("Griffith", 50, 6, 0);   
    
    static Mage playerMageEnemyBackup = new Mage("Snape", 25, 10, 12, 0,25);
    static Archer playerArcherEnemyBackup = new Archer("Gavião Arqueiro", 20, 5, 0);
    static Warrior playerWarriorEnemyBackup = new Warrior("Griffith", 50, 6, 0);   

    public static void battle(){                     
        System.out.println("Escolha a sua classe:");
        System.out.println("Mago "+playerMage.getName()+": 1");
        System.out.println("Arqueiro "+playerArcher.getName()+": 2");
        System.out.println("Guerreiro "+playerWarrior.getName()+": 3");
        Scanner scn = new Scanner(System.in);   
        int playerClass = scn.nextInt();
        Boolean battling = true;
        while(battling == true){
        System.out.println("Escolha a classe de seu oponente:");
        System.out.println("Mago "+playerMageEnemy.getName()+": 1");
        System.out.println("Arqueiro "+playerArcherEnemy.getName()+": 2");
        System.out.println("Guerreiro "+playerWarriorEnemy.getName()+": 3");
        int enemyClass = scn.nextInt();

        do{
            System.out.println("Escolha sua próxima ação:");
            System.out.println("1-Atacar");
            System.out.println("2-Curar");
             
            int opt = scn.nextInt();
            
            switch(opt){
                case 1:
                    GetDamagefoe(enemyClass, Action(playerClass));
                    System.out.println("Você atacou o inimigo");
                    System.out.println("Inimigo está com " + GetHpfoe(enemyClass) + " de HP");
                    XpAdd(playerClass);
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Você curou " + GetCureP(playerClass) + " HP!");
                    GetCure(playerClass);
                    System.out.println("Você agora está com " +GetHp(playerClass)+ " HP!");
                    break;
                default:
                    System.out.println("Entrada inválida. Turno perdido!");
                    break;
            }
            if(GetHpfoe(enemyClass) <= 0){
            break;
            }
            GetDamage(playerClass,Actionfoe(enemyClass));
            System.out.println("Você recebeu dano!");
            System.out.println(Stats(playerClass));
        }
        while(GetHp(playerClass)>0 && GetHpfoe(enemyClass)>0); 
        
        if (GetHpfoe(enemyClass) <= 0 && GetHp(playerClass)<= 0) {
            System.out.println("Ambos perderam!");
            break;
        }        
        if (GetHp(playerClass)<= 0) {
            Death(playerClass);
            System.out.println("O inimigo venceu!");
            break;
        }
        if (GetHpfoe(enemyClass) <= 0) {
            Deathfoe(enemyClass);
            System.out.println("Você venceu!");
        }
            System.out.println("Continuar a batalhar?");
            System.out.println("Sim (true) Não(false)");
            battling = scn.nextBoolean();
            playerMageEnemy.setHp(playerMageEnemyBackup.getHp());
            playerArcherEnemy.setHp(playerArcherEnemyBackup.getHp());
            playerWarriorEnemy.setHp(playerWarriorEnemyBackup.getHp());
            
        }
    }
    
        //player actions
        public static String Stats(int playerClass){
                switch(playerClass){
            case 1:
                return playerMage.toString();
            case 2:
                return playerArcher.toString();
            case 3:
                return playerWarrior.toString();
            default:
                return null;
        }
    }

    public static float Death(int playerClass){
                switch(playerClass){
            case 1:
                playerMage.death(playerMage.getName());
                break;
            case 2:
                playerArcher.death(playerArcher.getName());
                break;
            case 3:
                playerWarrior.death(playerWarrior.getName());
                break;
            default:
                return 0;
                }
        return 0;
    }
        public static float Deathfoe(int playerClass){
                switch(playerClass){
            case 1:
                playerMageEnemy.death(playerMageEnemy.getName());
                break;
            case 2:
                playerArcherEnemy.death(playerArcherEnemy.getName());
                break;
            case 3:
                playerWarriorEnemy.death(playerWarriorEnemy.getName());
                break;
            default:
                return 0;
                }
            return 0;
    }
    public static float GetHp(int playerClass){
                switch(playerClass){
            case 1:
                return playerMage.getHp();
            case 2:
                return playerArcher.getHp();
            case 3:
                return playerWarrior.getHp();
            default:
                return 0;
        }
    }
    public static int Action(int playerClass){
        switch(playerClass){
            case 1:
                return playerMage.Attack();
            case 2:
                return playerArcher.Attack();
            case 3:
                return playerWarrior.Attack();
            default:
                return 0;
        }
    }
    public static int XpAdd(int playerClass){
            switch(playerClass){
            case 1:
                return playerMage.xpAdd();
            case 2:
                return playerArcher.xpAdd();
            case 3:
                return playerWarrior.xpAdd();
            default:
                return 0;
        }
    }
        public static float GetCure(int playerClass){
            switch(playerClass){
            case 1:
                return playerMage.heal();
            case 2:
                return playerArcher.heal();
            case 3:
                return playerWarrior.heal();
            default:
                return 0;
        }
}
                public static float GetCureP(int playerClass){
            switch(playerClass){
            case 1:
                return playerMage.getCureP();
            default:
                return 0;
        }
}
        public static float GetDamage(int playerClass, int enemyDamage){
            switch(playerClass){
            case 1:
                return playerMage.damageTaken(enemyDamage);
            case 2:
                return playerArcher.damageTaken(enemyDamage);
            case 3:
                return playerWarrior.damageTaken(enemyDamage);
            default:
                return 0;
        }
}
    //enemy actions
    public static float GetHpfoe(int playerClass){
                switch(playerClass){
            case 1:
                return playerMageEnemy.getHp();
            case 2:
                return playerArcherEnemy.getHp();
            case 3:
                return playerWarriorEnemy.getHp();
            default:
                return 0;
        }
    }
    public static int Actionfoe(int playerClass){
        switch(playerClass){
            case 1:
                return playerMageEnemy.Attack();
            case 2:
                return playerArcherEnemy.Attack();
            case 3:
                return playerWarriorEnemy.Attack();
            default:
            return 0;
        }
    }
        public static float GetDamagefoe(int playerClass, int playerDamage){
            switch(playerClass){
            case 1:
                return playerMageEnemy.damageTaken(playerDamage);
            case 2:
                return playerArcherEnemy.damageTaken(playerDamage);
            case 3:
                return playerWarriorEnemy.damageTaken(playerDamage);
            default:
                return 0;
        }
        }
}
