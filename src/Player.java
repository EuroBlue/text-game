public class Player extends MainClass{
    
    private float health;
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

    public static void InHand(int b)
    {
        Item zl=MainClass.gamer.inventar[0];
        MainClass.gamer.inventar[0]=MainClass.gamer.inventar[b];
        MainClass.gamer.inventar[b]=zl;
        
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
            if(MainClass.gamer.inventar[0]!=Item.Empty||MainClass.gamer.inventar[1]!=Item.Empty||MainClass.gamer.inventar[2]!=Item.Empty||MainClass.gamer.inventar[3]!=Item.Empty||MainClass.gamer.inventar[4]!=Item.Empty)
            {
                for (Item i : MainClass.ground) 
                {
                    if(i==Item.Empty)
                    {
                        i=MainClass.ground[c];
                    }
                }
            }
            else
            {
                System.out.println("Your inventory is full.");  
            }
        }
    }
    public static void DamagePlayer(float dam)
    {
        Enemy e=Enemy.cur_enemy[MainClass.welle][MainClass.enem];
        if (MainClass.gamer.inventar[0].shield)
        {
            float block=generateRandomInRange(MainClass.gamer.inventar[0].block_min, gamer.inventar[0].block_max);
            gamer.health=gamer.health-(dam-block);
            System.out.println(e.name+" attacked you with "+dam+" damage, but your "+gamer.inventar[0].name+" blocked "+block+" of it.");

        }
        else
        {
            gamer.health=gamer.health-dam;
            System.out.println(e.name+" attacked you with "+dam+" damage.");
        }
        if(gamer.health<=0)
        {
            System.out.println("You have been killed by "+ e.name);
        }
        else
        {
            System.out.println("You have now only "+gamer.health+"health left.");
        }
    }
    public static void PlayerAttack()
    {
        float att=generateRandomInRange(MainClass.gamer.inventar[0].damage, MainClass.gamer.inventar[0].critical);
        System.out.println("You taked away "+att+" health from"+Enemy.cur_enemy[MainClass.welle][MainClass.enem].name);
        Enemy.cur_enemy[MainClass.welle][MainClass.enem].EnemyDamage(att);
    }
}
