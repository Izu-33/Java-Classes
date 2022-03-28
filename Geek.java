
package geekystuff;

import java.util.*;

/**
 * 
 * @author Kelechi
 */
public class Geek {
    public String name;
    public String starSign;
    public List<String> favComGame = new ArrayList<>();
    public Map<String,List<String>> compatSigns = new HashMap<>();
    
    public Geek(String nom) {
        this.name = nom;
        
        List<String> sign1 = new ArrayList<>();
        List<String> sign2 = new ArrayList<>();
        List<String> sign3 = new ArrayList<>();
        List<String> sign4 = new ArrayList<>();
        List<String> sign5 = new ArrayList<>();
        List<String> sign6 = new ArrayList<>();
        List<String> sign7 = new ArrayList<>();
        List<String> sign8 = new ArrayList<>();
        List<String> sign9 = new ArrayList<>();
        List<String> sign10 = new ArrayList<>();
        List<String> sign11= new ArrayList<>();
        List<String> sign12 = new ArrayList<>();


        sign1.add("Aquarius");
        sign1.add("Virgo");
        sign1.add("Capricorn");
        
        sign2.add("Capricorn");
        sign2.add("Sagittarius");
        sign2.add("Gemini");
        
        sign3.add("Taurus");
        sign3.add("Cancer");
        sign3.add("Scorpio");
        
        sign4.add("Gemini");
        sign4.add("Leo");
        sign4.add("Sagittarius");
        
        sign5.add("Pisces");
        sign5.add("Cancer");
        sign5.add("Virgo");
        
        sign6.add("Aries");
        sign6.add("Leo");
        sign6.add("Libra");
        
        sign7.add("Scorpio");
        sign7.add("Pisces");
        sign7.add("Virgo");
        
        sign8.add("Aries");
        sign8.add("Gemini");
        sign8.add("Libra");
        
        sign9.add("Cancer");
        sign9.add("Taurus");
        sign9.add("Capricorn");
        
        sign10.add("Gemini");
        sign10.add("Leo");
        sign10.add("Sagittarius");
        
        sign11.add("Taurus");
        sign11.add("Cancer");
        sign11.add("Capricorn");
        
        sign12.add("Aries");
        sign12.add("Leo");
        sign12.add("Aquarius");
        
        compatSigns.put("Capricorn", sign1);
        compatSigns.put("Aquarius", sign2);
        compatSigns.put("Pisces", sign3);
        compatSigns.put("Aries", sign4);
        compatSigns.put("Taurus", sign5);
        compatSigns.put("Gemini", sign6);
        compatSigns.put("Cancer", sign7);
        compatSigns.put("Leo", sign8);
        compatSigns.put("Virgo", sign9);
        compatSigns.put("Libra", sign10);
        compatSigns.put("Scorpio", sign11);
        compatSigns.put("Sagittarius", sign12);
    }
    
    
//    Getter Methods
    public String getName()
    {
        return name;
    }
    
    public String getStarSign()
    {
        return starSign;
    }
    
    public List getGames()
    {
        return favComGame;
    }
    
//    Setter Methods
    public void setName(String newName)
    {
        name = newName;
    }
    
    public void setStarSign(String newSign)
    {
        starSign = newSign;
    }
    
    public void setGames(ArrayList<String> newGames)
    {
        favComGame.clear();
        
        for(String element:newGames)
        {
            favComGame.add(element);
        }
    }
    
    
    /**
    * This method is used to add a game to the list
    * of a geek's favorite games
    * @param game This is the first and only parameter to geekCompat method
    */
    public void addGame(String game)
    {
        favComGame.add(game);
    }
    
    
    /**
    * This method is used to show if a geek has common games with another
    * @param geek This is the first and only parameter to geekCompat method
    * @return ArrayList This returns an array of common games
    */
    public List<String> commonGames(Geek geek)
    {
        List<String> list1 = new ArrayList<>(geek.favComGame);
        List<String> list2 = new ArrayList<>(this.favComGame);
        Set<String> set = new HashSet<>();
        
        for (String i:list1)
        { 
            for (String j:list2)
            {
                if (i.contains(j))
                {
                    set.add(j);
                }
            }
        }
        
        List<String> arrayList = new ArrayList<>(set);
        return arrayList;
    }
    
    
    /**
    * This method is used to show if a geek is compatible with another
    * @param geek This is the first and only parameter to geekCompat method
    * @return boolean This returns true or false
    */
    public boolean geekCompat(Geek geek)
    {
        List zodiacs = compatSigns.get(this.starSign);
        
        if (zodiacs.contains(geek.starSign))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    
    
}
