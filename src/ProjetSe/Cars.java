
package ProjetSe;

import java.util.concurrent.Semaphore;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import static ProjetSe.ProjetSe.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;

public class Cars extends Thread {
      
    
    private final Semaphore red; // This Semapbore of The red color
    private final Semaphore green; // This Semapbore of the green color
    private final Semaphore mutex1;
    private final Semaphore mutex2;
    private final Semaphore mutex;
    
    
    
    Cars (Semaphore mutex,Semaphore red, String name, Semaphore green, Semaphore mutex1, Semaphore mutex2) {
        this.red = red;
        this.green = green;
        this.mutex1 = mutex1;
        this.mutex2 = mutex2;
        this.mutex = mutex;
        this.setName(name); // Change the name of Thread
        this.start(); // Start Execution the Thread
    }

    @Override
    public void run () {
        
        try {
          
           
            waitingCars();
                        
            while(true){
            
        /// mutex.acquire();  
        
        
           change(); 
         
            
         executCare2();
            
            chang2();
         
           excCares1();
         // mutex.release();

 }           
        
            
     
        } catch (InterruptedException ex) {}

    }
    
    public void change() throws InterruptedException{
 sleep(6000);
        red.acquire();
   //sleep(4000);
   green1.setFill(Color.GREENYELLOW);
            green3.setFill(Color.GREENYELLOW);
        red2.setFill(Color.RED);
            red4.setFill(Color.RED);
            red1.setFill(Color.SILVER);
            red3.setFill(Color.SILVER);
            
            green2.setFill(Color.SILVER);
            green4.setFill(Color.SILVER);
        
        
        green.release();

       
   //sleep(4000);
  
        green.acquire();
        
            red1.setFill(Color.RED);
            red3.setFill(Color.RED);
            red2.setFill(Color.SILVER);
            red4.setFill(Color.SILVER);
            green2.setFill(Color.GREENYELLOW);
            green4.setFill(Color.GREENYELLOW);
            green1.setFill(Color.SILVER);
            green3.setFill(Color.SILVER);
          
            
            
        red.release();
        
        // sleep(4000);
    }
    
    public void chang2() throws InterruptedException{
        
       //sleep(4000);
        red.acquire();
        
         red1.setFill(Color.RED);
            red3.setFill(Color.RED);
            red2.setFill(Color.SILVER);
            red4.setFill(Color.SILVER);
            green2.setFill(Color.GREENYELLOW);
            green4.setFill(Color.GREENYELLOW);
            green1.setFill(Color.SILVER);
            green3.setFill(Color.SILVER);
          

        
        
        green.release();

       
   sleep(5000);
  
        green.acquire();
        

        
        
        red2.setFill(Color.RED);
            red4.setFill(Color.RED);
            red1.setFill(Color.SILVER);
            red3.setFill(Color.SILVER);
            green1.setFill(Color.GREENYELLOW);
            green3.setFill(Color.GREENYELLOW);
            green2.setFill(Color.SILVER);
            green4.setFill(Color.SILVER);                       
            
        red.release();
        
        
    
    }
    
    public void waitingCars() {
        try {
            
            for(int i = 0; i < nameCarLeft.length; i++){
                //if (this.getName().equals(nameCarLeft[i])) {
                  fadeTransition(carImageL[i]);
                  //  break;
                //}
                }
            for(int i = 0; i < nameCarRight.length; i++){
                //if (this.getName().equals(nameCarRight[i])) {
                    fadeTransition(carImageR[i]);
                    break;
                    
                //}
                }
                        
             
            
            for(int i = 0; i < nameCarTop.length; i++){
              //  if (this.getName().equals(nameCarTop[i])) {
                    fadeTransition(carImageT[i]);
                  //  break;
                }
                //}
            for(int i = 0; i < nameCarBottom.length; i++){
            ////    if (this.getName().equals(nameCarBottom[i])) {
                    fadeTransition(carImageB[i]);
                  //  break;
             ///   }
                }
            
            
            
           
        } catch (Exception ex) {}
    
    }
    
    public void excCares1() {
        try {
            //
            
            
            mutex1.acquire();
            red.acquire();
            sleep(2000);
           
           
                travers1();
            
            
                  //}
           red.release();
           mutex1.release();
           
           
            sleep(1800);
        } catch (Exception ex) {}
            
    }
    
    
    public void executCare2(){
        
        
        try {
            mutex1.acquire();
            green.acquire();
            
            
            travers2();
            
            
            green.release();
            mutex1.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Cars.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void travers1(){
        
          for(int i = 0; i < nameCarTop.length; i++){
                      //    carImageT[0].setLayoutY(-10);
                      
                    transition(0, 90, carImageT[0]);
                    
                    
                    
                if (green1.getFill().equals(Color.GREENYELLOW)) {
                    
                    carImageT[0].setLayoutY(-160);
                    transition(0, 3400, carImageT[0]);
                    transition(0, 3800, carImageT[1]);  
                    transition(0, 2800, carImageT[i]);
                    
                    
                    
                    //break;
                }
                
                for(int j = 0; j < nameCarTop.length; j++){    
                
                carImageT[j].setTranslateX(0);
                carImageT[j].setTranslateY(0);
               // carImageT[0].setLayoutY(-400);
                
            }
            
                  }
           
            for(int i = 1; i < nameCarBottom.length; i++){
                
                if (green3.getFill().equals(Color.GREENYELLOW)) {
                    transition(0, -4400, carImageB[0]);
                    transition(0, -4000, carImageB[1]);
                    transition(0, -3400, carImageB[2]);
                    transition(0, -2400, carImageB[i]);
                    
                }
                 for(int j = 0; j < nameCarBottom.length; j++){    
                carImageB[j].setTranslateX(0);
                carImageB[j].setTranslateY(0);
                
            }
                }
        
    }
    
    
    void travers2(){
        
        
            for(int i = 0; i < nameCarRight.length -1; i++){
                
                
                if (green2.getFill().equals(Color.GREENYELLOW)) {
                    
                    transition(-6700, 0, carImageR[4]);
                    transition(-5000, 0, carImageR[3]);
                    transition(-4400, 0, carImageR[0]);
                    transition(-3800, 0, carImageR[1]);
                    transition(-3900, 0, carImageR[2]);
                    
                }
                
                
                
                
                for(int j = 0; j < nameCarRight.length; j++){    
                carImageR[j].setTranslateX(0);
                carImageR[j].setTranslateY(0);
            }
            
                  }
            
            for(int i = 2; i < nameCarLeft.length; i++){
                
               // transition(150, 0, carImageL[i]);
                if (green4.getFill().equals(Color.GREENYELLOW)) {
                    
                    transition(4850, 0, carImageL[0]);
                    transition(3850, 0, carImageL[1]);
                    transition(2950, 0, carImageL[2]);
                    transition(2850, 0, carImageL[i]);
                    
                    
                }
                for(int j = 0; j < nameCarLeft.length; j++){    
                carImageL[j].setTranslateX(0);
                carImageL[j].setTranslateY(0);
                
            }
            
                  }
        
    }
    
    
   synchronized void transition(int x , int y , ImageView image){

    
 
            // mutex.acquire();
            TranslateTransition t = new TranslateTransition( Duration.seconds(7.5),image);
            
            
            t.setToX(x);
            t.setToY(y);
            t.play();
     
       
            
              
            }
       
    
    
    public void fadeTransition(ImageView image) {
        FadeTransition ft = new FadeTransition(Duration.millis(2000), image); // Duration Is The Time to do it
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
    }
    
}