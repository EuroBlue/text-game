public class Item extends MainClass{
    // Item
    public String name;
    public float damage;
    public float critical;
    public boolean shield;
    
    // Shield
    public float block_min;
    public float block_max;
    public float shield_hp;

    public static Item Empty=new Item("Fists",5,7.5f,false,0,0,0);
    // Level 1 Items
    public static Item Sword_lv1=new Item("Sword - Level 1",12,18,false,0,0,0);
    public static Item Shield_lv1=new Item("Shield - Level 1",0,0,true,6,8,30);
    // Level 2 Items
    public static Item Sword_lv2=new Item("Sword - Level 2",24,36,false,0,0,0);
    public static Item Shield_lv2=new Item("Shield - Level 2",0,0,true,12,16,60);
    // Level 3 Items
    public static Item Sword_lv3=new Item("Sword - Level 3",36,54,false,0,0,0);
    public static Item Shield_lv33=new Item("Shield - Level 3",0,0,true,18,24,90);
    
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

    public Item(String nam, float dam, float crit, boolean sshield, float _block_min, float _block_max, float _shield_hp)
    {
        this.name=nam;
        this.damage=dam;
        this.critical=crit;
        this.shield=sshield;
        if (this.shield)
        {
            this.block_min=_block_min;
            this.block_max=_block_max;
            this.shield_hp=_shield_hp;
        }
    }


}