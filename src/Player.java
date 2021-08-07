public class Player extends MainClass{
    
    public float health;
    public String nickname;

    public Item[] inventar;

    public Player(String n)
    {
        this.nickname=n;
        this.health=100f;
        this.inventar=new Item[5];
        for(int c=0;c<5;c++)
        {
            this.inventar[c] = Item.Empty;
        }
    }

    public static void InHand(int b,int c)
    {
        if (MainClass.gamer.inventar[b].potion)
        {
            float a=MainClass.generateRandomInRange(MainClass.gamer.inventar[b].damage,MainClass.gamer.inventar[b].critical);
            MainClass.gamer.health=MainClass.gamer.health+a;
            System.out.println("You have consumed a "+MainClass.gamer.inventar[b].name);
            System.out.println(MainClass.gamer.inventar[b].name+" gave you "+a+" HP");
            System.out.println("You have now "+MainClass.gamer.health+" HP");
            MainClass.gamer.inventar[b]=Item.Empty;
        }
        else
        {
        Item zl=MainClass.gamer.inventar[c];
        MainClass.gamer.inventar[c]=MainClass.gamer.inventar[b];
        MainClass.gamer.inventar[b]=zl;
        }
        
    }

    public static void DropItem(int c)
    {
        for (Item i : MainClass.ground) 
        {
            if(i==Item.Empty)
            {
                i=MainClass.gamer.inventar[c];
                MainClass.gamer.inventar[c]=Item.Empty;
                break;
            }    
        }
    }
    public static void TakeItem(int c)
    {
        if(MainClass.ground[c]==Item.Empty)
        {
            System.out.println("There is no "+c+"th item on the ground.");
        }
        else
        {
            if(MainClass.gamer.inventar[0].drate==0||MainClass.gamer.inventar[1].drate==0||MainClass.gamer.inventar[2].drate==0||MainClass.gamer.inventar[3].drate==0||MainClass.gamer.inventar[4].drate==0)
            {
                for (int i = 0; i < MainClass.gamer.inventar.length; i++) 
                {
                    if(MainClass.gamer.inventar[i]==Item.Empty)
                    {
                        MainClass.gamer.inventar[i]=MainClass.ground[c];
                        MainClass.ground[c]=Item.Empty;
                        break;
                    }
                }
            }
            else
            {
                System.out.println("\nYour inventory is full.");  
            }
        }
    }
    public static void DamagePlayer(float dam)
    {
        Enemy e=Enemy.cur_enemy[MainClass.welle][MainClass.enem];
        if (MainClass.gamer.inventar[0].shield||MainClass.gamer.inventar[1].shield)
        {
            if(MainClass.gamer.inventar[0].shield)
            {
                float block=generateRandomInRange(MainClass.gamer.inventar[0].block_min, gamer.inventar[0].block_max);
                gamer.health=gamer.health-(dam-block);
                System.out.println(e.name+" attacked you with "+dam+" damage, but your "+gamer.inventar[0].name+" blocked "+block+" of it.");
                MainClass.gamer.inventar[0].shield_hp=MainClass.gamer.inventar[0].shield_hp-block;
                if(gamer.inventar[0].shield_hp>0)
                {
                    System.out.println("Your shield have "+gamer.inventar[0].shield_hp+" left.");
                }
                else
                {
                    System.out.println("Your shield was destroyed.");
                    MainClass.gamer.inventar[0]=Item.Empty;
                }
            }
            else
            {
                float block=generateRandomInRange(MainClass.gamer.inventar[1].block_min, gamer.inventar[1].block_max);
                gamer.health=gamer.health-(dam-block);
                System.out.println(e.name+" attacked you with "+dam+" damage, but your "+gamer.inventar[1].name+" blocked "+block+" of it.");
                MainClass.gamer.inventar[1].shield_hp=MainClass.gamer.inventar[1].shield_hp-block;
                if(gamer.inventar[1].shield_hp>0)
                {
                    System.out.println("Your shield have "+gamer.inventar[1].shield_hp+" left.");
                }
                else
                {
                    System.out.println("Your shield was destroyed.");
                    MainClass.gamer.inventar[1]=Item.Empty;
                }
            }

        }
        else
        {
            gamer.health=gamer.health-dam;
            System.out.println(e.name+" attacked you with "+dam+" damage.");
        }
        if(gamer.health<=0)
        {
            System.out.println("You have been killed by "+ e.name);
            System.out.println("You died");
        }
        else
        {
            System.out.println("You have now only "+gamer.health+" health left.");
        }
    }
    public static void PlayerAttack()
    {
        float att=generateRandomInRange(MainClass.gamer.inventar[0].damage, MainClass.gamer.inventar[0].critical)+generateRandomInRange(MainClass.gamer.inventar[1].damage, MainClass.gamer.inventar[1].critical);
        System.out.println("\nYou dealt "+att+" damage to "+Enemy.cur_enemy[MainClass.welle][MainClass.enem].name);
        Enemy.cur_enemy[MainClass.welle][MainClass.enem].EnemyDamage(att);
    }
}
