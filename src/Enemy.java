public class Enemy extends MainClass{
    public String name;
    public int level;
    public float health;
    public float damage;
    public float critdamage;

    static public Enemy[] level_1=
    {
    new Enemy("Zombie - lv1",1,100f,5f,7.5f),
    new Enemy("Skeleton - lv1",1,125f,6f,7.5f),
    new Enemy("Spider - lv1",1,60f,4f,7.5f),
    new Enemy("Bandit - lv1",1,90f,7f,7.5f),
    new Enemy("Traveller - lv1",1,120f,6f,7.5f),
    new Enemy("Dragon - lv1",1,180f,9f,7.5f),
    new Enemy("Hangman - lv1",1,80f,6f,7.5f),
    new Enemy("Witch - lv1",1,110f,5f,7.5f),
    new Enemy("Golem - lv1",1,150f,7f,7.5f),
    new Enemy("Goblin - lv1",1,75f,3f,7.5f)
    
    };
    static public Enemy[] level_2=
    {
    new Enemy("Zombie - lv2",2,200f,9f,13.5f),
    new Enemy("Skeleton - lv2",2,250f,10f,13.5f),
    new Enemy("Spider - lv2",2,120f,8f,13.5f),
    new Enemy("Bandit - lv2",2,180f,11f,13.5f),
    new Enemy("Traveller - lv2",2,240f,10f,13.5f),
    new Enemy("Dragon - lv2",2,360f,13f,13.5f),
    new Enemy("Hangman - lv2",2,160f,10f,13.5f),
    new Enemy("WItch - lv2",2,220f,9f,13.5f),
    new Enemy("Golem - lv2",2,300f,11f,13.5f),
    new Enemy("Goblin - lv2",2,150f,7f,13.5f)
    };
    static public Enemy[] level_3=
    {
    new Enemy("Zombie - lv3",2,300f,14f,21f),
    new Enemy("Skeleton - lv3",2,375f,15f,21f),
    new Enemy("Spider - lv3",2,280f,13f,21f),
    new Enemy("Bandit - lv3",2,270f,16f,21f),
    new Enemy("Traveller - lv3",2,360f,15f,21f),
    new Enemy("Dragon - lv3",2,440f,18f,21f),
    new Enemy("Hangman - lv3",2,240f,15f,21f),
    new Enemy("Witch - lv3",2,330f,14f,21f),
    new Enemy("Golem - lv3",2,450f,16f,21f),
    new Enemy("Goblin - lv3",2,225f,12f,21f)
    };

    public static Enemy[] wave_1=MainClass.shuffleArray(level_1);
    public static Enemy[] wave_2=MainClass.shuffleArray(level_2);
    public static Enemy[] wave_3=MainClass.shuffleArray(level_3);

    public static Enemy[][] cur_enemy={wave_1,wave_2,wave_3};

    public Enemy(String _name,int lv,float healtf, float dam, float crit)
    {
        this.name = _name;
        this.level = lv;
        this.health = healtf;
        this.damage = dam;
        this.critdamage = crit;
    }
    public void EnemyDamage(float dam)
    {
        this.health=this.health-dam;
        if (this.health <= 0)
        {
            System.out.println(gamer.nickname+" has killed an "+this.name);
            if (MainClass.enem==9)
            {
                if (MainClass.welle==2)
                {
                    System.out.println("You are the victorious");
                }
            }
        }
        else
        {
            System.out.println(this.name+" has "+this.health+" left.");
        }
    }
    public void EnemyAttack()
    {
        float att=generateRandomInRange(Enemy.cur_enemy[MainClass.welle][MainClass.enem].damage,Enemy.cur_enemy[MainClass.welle][MainClass.enem].critdamage);
        Player.DamagePlayer(att);
    }
    
}