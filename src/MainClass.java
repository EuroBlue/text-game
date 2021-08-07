import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class MainClass {
    public static String[] welle_names={"First","Second","Third"};
    public static Player gamer;
    public static Enemy _enemy;
    public static Item[] ground={Item.Empty,Item.Empty,Item.Empty,Item.Empty,Item.Empty,Item.Empty,};
    public static int welle;
    public static int enem;
    public static String pName;
    public static void main(String[] args)
    {
        System.out.println("Hello, World!");
        MainClass.gamer=new Player(PlayerName());
        for (welle = 0; welle < 2; welle++)
        {
            if (welle>0)
            {
                System.out.println("Greetings adventurer you survived the "+welle_names[welle]+" wave.");
            }
            else
            {
                System.out.println("Welcome to the game.");
            }
            for (enem = 0; enem < 9; enem++) 
            {
                if (enem == 0)
                {
                    System.out.println("Welcome to your first wave.\nKill the enemys to get to a higher to a wave.\nThe enemys spawn in diffrent waves but the order is not fixed so don't expect it to be too easy.\nAfter you killed all mobs of one type the naxt wave is going to start with other types of enemys.\nGive your best to survive all waves and become the king of the creatures");
                }
                youCan();
                System.out.println("You are now competing against "+Enemy.cur_enemy[welle][enem].name);
                while (Enemy.cur_enemy[welle][enem].health>0&&gamer.health>0) 
                {
                    youCan_att();
                    Enemy.EnemyAttack();
                }
                if(Enemy.cur_enemy[welle][enem].health>0)
                {
                    enem=0;
                    welle=0;
                }
                else
                {
                    System.out.println("Congratulations! you survived this type of creature. Let's see how you can handle the next creatures. Good luck.");
                }
            }
        }

    }

    public static String PlayerName()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hey ... you have no name?\nPlease enter a Username below.");
        String input=scan.nextLine();
        scan.close();    

        if (input == null||input =="")
        {
            System.out.println("Hey this name is not possible!\nPlease chose another name!");
            return PlayerName();
        }
        else
        {
            return input;
        }
    }

    public static void youCan()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("You can now\n1. View available Items and enter the inventory\n2. View Player Stats\n3. Move on to the enemy");
        String input=scan.nextLine();
        if(input =="1")
        {
            int c=1;
            System.out.print("In your Inventory are:");
            for (Item item : gamer.inventar) 
            {
                if(c==1&&item.name=="Empty")
                {
                    System.out.print("1. Fists");
                }
                else
                {
                    System.out.print(c+". "+item.name);
                }
                c++;
            }
            c=1;
            System.out.print("On the ground are:");
            for (Item item : ground) 
            {
                if(item!=Item.Empty)
                {
                System.out.print(c+". "+item.name);
                c++;
                }
            }
            if (c==1)
            {
                System.out.print("Nothing");
            }
            scan.close();
            invActions();
        }
        else if(input =="2")
        {
            System.out.println(String.format("Your minumum damage is %f",gamer.inventar[0].damage));
            System.out.println(String.format("Your maximum damage is %f",gamer.inventar[0].critical));
            System.out.println(String.format("Your minumum damage reduction is %f",gamer.inventar[0].block_min));
            System.out.println(String.format("Your maximum damage reduction is %f",gamer.inventar[0].block_max));
            System.out.println(String.format("Your Shield HP is %f",gamer.inventar[0].shield_hp));
            System.out.println(String.format("Your Health is %f",gamer.health));
        }
        else if(input =="3")
        {
            
        }
        else
        {
            youCan();
        }
    }
    public static void youCan_att()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("You can now\n1. View available Items and enter the inventory\n2. View Player Stats\n3. Attack the enemy");
        String input=scan.nextLine();
        if(input =="1")
        {
            int c=1;
            System.out.print("In your Inventory are:");
            for (Item item : gamer.inventar) 
            {
                if(c==1&&item.name=="Empty")
                {
                    System.out.print("1. Fists");
                }
                else
                {
                    System.out.print(c+". "+item.name);
                }
                c++;
            }
            c=1;
            System.out.print("On the ground are:");
            for (Item item : ground) 
            {
                if(item!=Item.Empty)
                {
                System.out.print(c+". "+item.name);
                c++;
                }
            }
            if (c==1)
            {
                System.out.print("Nothing");
            }
            scan.close();
            invActions();
        }
        else if(input =="2")
        {
            System.out.println(String.format("Your minumum damage is %f",gamer.inventar[0].damage));
            System.out.println(String.format("Your maximum damage is %f",gamer.inventar[0].critical));
            System.out.println(String.format("Your minumum damage reduction is %f",gamer.inventar[0].block_min));
            System.out.println(String.format("Your maximum damage reduction is %f",gamer.inventar[0].block_max));
            System.out.println(String.format("Your Shield HP is %f",gamer.inventar[0].shield_hp));
            System.out.println(String.format("Your Health is %f",gamer.health));
        }
        else if(input =="3")
        {
            Player.PlayerAttack();
        }
        else
        {
            youCan();
        }
    }
    public static void invActions()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("You can now\n0. Back\n1. Take an item from the ground\n2. Drop an item on the ground");
        String input=scan.nextLine();
        if(input =="0")
        {
            youCan();
        }
        else if(input =="1")
        {
            System.out.println("What item do you want to take?");
            input=scan.nextLine();
            scan.close();
            Player.TakeItem((Integer.parseInt(input)-1));
        }
        else if(input =="2")
        {
            
            input=scan.nextLine();
            scan.close();
            Player.DropItem((Integer.parseInt(input)-1));
        }
        else
        {
            invActions();
        }
    }
    public static float generateRandomInRange(float min, float max) {
        Random r=new Random();
        return min + r.nextFloat() * (max - min);
    }
    public static Enemy[] shuffleArray(Enemy[] ea) 
    {
		List<Enemy> intList = Arrays.asList(ea);
		Collections.shuffle(intList);
		return intList.toArray(ea);
	}


}