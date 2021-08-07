public class Item extends MainClass{
    // Item
    public String name;
    public float damage;
    public float critical;
    public boolean shield;
    public boolean potion;
    public int drate;
    
    // Shield
    public float block_min;
    public float block_max;
    public float shield_hp;

    public static Item[] lvl_1=
    {
        new Item("Sword - Level 1",12,18,false,0,0,0,false,7),
        new Item("Shield - Level 1",0,0,true,6,8,30,false,13),
        new Item("Healpotion - Level 1",10,20,false,0,0,0,true,20),
    };
    public static Item[] lvl_2=
    {
        new Item("Sword - Level 2",24,36,false,0,0,0,false,5),
        new Item("Shield - Level 2",0,0,true,12,16,60,false,11),
        new Item("Healpotion - Level 2",25,35,false,0,0,0,true,18),
    };
    public static Item[] lvl_3=
    {
        new Item("Sword - Level 3",36,54,false,0,0,0,false,3),
        new Item("Shield - Level 3",0,0,true,18,24,90,false,9),
        new Item("Healpotion - Level 3",40,50,false,0,0,0,true,16),
    };

    public static Item[][] items=
    {
        lvl_1,
        lvl_2,
        lvl_3
    };

    public static Item Empty=new Item("Empty",5,7.5f,false,0,0,0,false,0);

    
    public static String GetItemStats(Item i)
    {
        if(!i.shield)
        {
            return("This item is a"+ i.name+". It´s normal damage is "+i.damage+" damage, but it can rise up to "+i.critical+" damage.");
        }
        else
        {
            return("This item is a"+ i.name+". It´s minimal damage reduction is "+i.block_min+" damage, but it can rise up to "+i.block_max+" damage.");
        }
    }

    public static void rateItem()
    {
        for (Item item : items[welle]) 
        {
            if(genRanInt(1, 100)<=item.drate)
            {
                System.out.println("\n"+Enemy.cur_enemy[welle][enem].name+" dropped after his death a "+item.name+".");
                for (int i = 0; i < ground.length; i++)
                {
                    if(ground[i].drate==0)
                    {
                        ground[i]=item;
                        break;
                    }   
                }
                break;
            }
        }
    }

    public Item(String nam, float dam, float crit, boolean sshield, float _block_min, float _block_max, float _shield_hp,boolean p,int rate)
    {
        this.name=nam;
        this.damage=dam;
        this.critical=crit;
        this.shield=sshield;
        this.potion=p;
        this.drate=rate;
        if (this.shield)
        {
            this.block_min=_block_min;
            this.block_max=_block_max;
            this.shield_hp=_shield_hp;
        }
    }


}