
package geekystuff;

import java.util.*;
import java.io.*;

/**
 * 
 * 
 * @author Kelechi
 */
public class GeekMatcher {
    
    /**
    * main - Entry point. This is the main method. It makes use 
    * of gamesInCommon and compatible methods
    * @param args Unused.
    */
    public static void main(String[] args) {
        
        ArrayList<Geek> geekCollection = new ArrayList<>();
        
        String path = "allGeeks.txt";
        
        try
        {
            BufferedReader in = new BufferedReader(new FileReader(path));
            
            
            String line;
            String[] values = new String[30];
            while ((line = in.readLine()) != null)
            {
                String replacedLine1 = line.replace("[", "\"");
                String replacedLine2 = replacedLine1.replace("]", "\"");
            
                values = replacedLine2.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                String geekName = values[1];
                String geekSign = values[5];

                Geek nerd = new Geek(geekName);
                ArrayList<String> comGames = new ArrayList<>();
                
                comGames.addAll(Arrays.asList(values[7]));
               
                nerd.setStarSign(geekSign);
                nerd.setGames(comGames);
                
                geekCollection.add(nerd);
                
            }
            in.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter Name:");
        String name = sc.nextLine();
        System.out.println("Enter Star Sign:");
        String star_sign = sc.nextLine();
        ArrayList<String> games = new ArrayList<>();
        System.out.println("Please type in the number of games to be entered: ");
        int loopCounter = sc.nextInt();
        
        System.out.println("Enter Computer Games: ");
        
        int i = 0;
        while (i <= loopCounter)
        {
            games.add(sc.nextLine());
            i++;
        }
        
        Geek geek = new Geek(name);
        geek.setStarSign(star_sign);
        geek.setGames(games);  
        
        
        Map<Geek,List<String>> common_games = new HashMap<>(gamesInCommon(geekCollection, geek));
        ArrayList<Geek> compatible_geeks = new ArrayList<>(compatible(geekCollection, geek));
        
        Map<Geek,List<String>> jointGeeks = new HashMap<>();
        
        for (Map.Entry<Geek,List<String>> entry:common_games.entrySet())
        {
            for (Geek item:compatible_geeks)
            {
                if (entry.getKey() == item)
                {
                    jointGeeks.put(item, entry.getValue());
                }
            }
        }
      
        System.out.println();
        System.out.println("Geeks with games in common with " + geek.name);
        for (Map.Entry<Geek,List<String>> entry:common_games.entrySet())
        {
            
            System.out.println(entry.getKey().name + ": Number of games in common " + entry.getValue().size());
        }
        
        System.out.println();
        System.out.println("Geeks with compatible star signs");
        for (Geek element:compatible_geeks)
        {
            System.out.println(element.name + " is compatible with " + geek.name + " with star sign: " + element.starSign);
        }
        System.out.println();
        System.out.println("Geeks with both compatible star sign and games");
        for (Map.Entry<Geek,List<String>> entry:jointGeeks.entrySet())
        {
            System.out.println(entry.getKey().name + ": with star sign " + entry.getKey().starSign + " and " + entry.getValue().size() + " games in common");
        }
        
        
    }
    
    
    /**
    * This method is used to show which geeks have common games.
    * @param geeks This is the first parameter to compatible method
    * @param individual  This is the second parameter to compatible method
    * @return Map This returns a collection of geeks with common games.
    */
    public static Map gamesInCommon(ArrayList<Geek> geeks, Geek individual) {
        
        Map<Geek,List<String>> xyz = new HashMap<>();
        List<String> collectionGames = new ArrayList<>();
        
        
        for (Geek i:geeks)
        {
            List<String> array = new ArrayList<>(individual.commonGames(i));
            
            if (array.size() > 1)
            {
                for (String j:array)
                {
                    collectionGames.add(j);
                }
                xyz.put(i, collectionGames);
            }
            
        }
        return xyz;
    }
    
    
    /**
    * This method is used to show which geeks are compatible
    * depending on star signs.
    * @param geeks This is the first parameter to compatible method
    * @param individual  This is the second parameter to compatible method
    * @return ArrayList This returns a collection of geeks with compatible star signs.
    */
    public static ArrayList compatible(ArrayList<Geek> geeks, Geek individual)
    {
        
        ArrayList<Geek> compatibleGeeks = new ArrayList<>();
        
        for (Geek i:geeks)
        {
            boolean value = individual.geekCompat(i); 
            if (value == true)
            {
                compatibleGeeks.add(i);
            }
        }
        return compatibleGeeks;
        
    }
        
}
