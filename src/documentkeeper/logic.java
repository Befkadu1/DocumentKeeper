package documentkeeper;

/**
 *
 * @author wuzoink
 */
public class logic {
    
    private static logic instance = null;
    
       private logic() {
      // Exists only to defeat instantiation.
   }
    
    public static logic getInstance(){
        if(instance == null){
            instance = new logic();
        } 
        return instance;
    }
    
}
