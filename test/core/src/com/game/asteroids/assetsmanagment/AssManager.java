package com.game.asteroids.assetsmanagment;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.JsonValue;
import static com.game.asteroids.utils.JsonUtils.returnJsonvalue;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;



/**
 *
 * @author Ariel Costa
 */
public class AssManager {
    
    public final AssetManager manager = new AssetManager();
    public final HashMap<String,JsonValue> templates = new HashMap<>();
    public final Assets assets = new Assets();
    
     /**
      * 
      * @author Ariel Costa
    */
    public void loadTemplates(){
        File folder = new File("entitytemplates");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println("File " + file.getName());
                JsonValue json = returnJsonvalue(file.getPath());
                String key = file.getName().replace(".json", "");
                System.out.println("Added to asset manager " + key + "," + json); 
                templates.put(key, json);
            } else if (file.isDirectory()) {
                System.out.println("Directory " + file.getName());
            }
        }
    }
    
    /**
      * 
      * @author Ariel Costa
    */
    public void loadTemplatesWithKey(){
        File folder = new File("entitytemplates");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println("File " + file.getName());
                JsonValue json = returnJsonvalue(file.getPath());
                String key = json.getString("key");
                System.out.println("Added to asset manager " + key + "," + json); 
                templates.put(key, json);
            } else if (file.isDirectory()) {
                System.out.println("Directory " + file.getName());
            }
        }
    }
        
    private void loadTextureAtlas(){
        File folder = new File("textureatlas");
        File[] listOfFiles = folder.listFiles();
        System.out.println("Loading atlas");
        for (File file : listOfFiles) {
            if ((file.isFile()) && (file.getName().contains(".atlas"))) {
                System.out.println("File " + file.getName());
               // JsonValue json = returnJsonvalue(file);
                String key = file.getName().replace(".atlas", "");
                manager.load(file.getPath(),TextureAtlas.class);
            } else if (file.isDirectory()) {
                System.out.println("Directory " + file.getName());
            }
        }
    }
    
    private void loadTextureAtlasFromJsonFile(){
              
        JsonValue resourcelist = returnJsonvalue("Resources.json"); 
        
        //array objects in json if you would have more components
        for (JsonValue texture : resourcelist.get("textures"))
        {
            String key = texture.getString("key");
            String path = texture.getString("path");
            System.out.println(key);
            manager.load(path, TextureAtlas.class);
            assets.addResource(key, path);
        }
    
    }
     
  /**
   * Load all game resources to the manager
   */ 
    public void loadResources(){
        loadTemplatesWithKey();
        loadTextureAtlasFromJsonFile();
        printAtlas();
        manager.finishLoading();
    }
    
    /**
     * Returns a JsonValue with the template data
     * 
     * @param key String with the name of the template
     * @return return a JsonValue
    */
    public JsonValue getTemplate(String key){
        return templates.get(key);
    }
    
    public TextureRegion getTextureRegion(String atlas, String region){
        return manager.get(assets.getResource(atlas), TextureAtlas.class).findRegion(region);
    }
    
    private void printAtlas(){
      System.out.println(assets.assets.keySet());
    }
    
   
}
