import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
public class MainClass {
    public static Player gamer;
    public static Enemy _enemy;
    public static Item[] ground={Item.Empty,Item.Empty,Item.Empty,Item.Empty,Item.Empty,Item.Empty,};
    public static int welle;
    public static int enem;
    public static void main(String[] args)
    {
        welle=0;
        enem=0;
        System.out.println("Hello, World!");
        for (int i = 0; i < args.length; i++) 
        {
            for (int j = 0; j < args.length; j++) 
            {
                
            }
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