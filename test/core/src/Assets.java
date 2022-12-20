

import java.util.HashMap;

/**
 * This class contains a dictionary with 
 * all the resources loaded in order to 
 * keep track of them
 * 
 * 
 * @author Ariel Costa
 */
public class Assets {
    
    public HashMap<String, String> assets = new HashMap<>();
    
    public void addResource(String key, String path){
        assets.put(key, path);
        
    }
    
    public String getResource(String key){
        return assets.get(key);
    }
    
}
