
package ProjetSe;

import com.jfoenix.controls.JFXButton;
import java.util.concurrent.Semaphore;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ProjetSe extends Application {
    
    static ImageView [] carImageR,carImageT,carImageR1,carImageL,carImageB; // This is the car Images
       
    static JFXButton btnStart , btnReset; // This Button using to start the Thread
    
    VBox pane1,pane3;
    HBox  pane2,pane4;
  public static Circle red1,red2,red3,red4;
  public static Circle orang1,orang2,orang3,orang4;
  public static Circle green1,green2,green3,green4;
  
    final static String [] nameCarRight ={"car3","car22","car3","car3","car22"};
    final static String [] nameCarLeft ={"car1","bus2","car1","bus2"};
    final static String [] nameCarTop ={"car2","car12","car2"};
    final static String [] nameCarBottom ={"bus","car13","bus","car13"};
        
    @Override
    public void start(Stage primaryStage) {
        /* Start Initialize Part */
        
        AnchorPane root = new AnchorPane();
       
         Color gray = Color.SILVER;
         
                
                /******* road sign1 *******/ 
        pane1 = new VBox();
        pane1.setLayoutX(140);
        pane1.setLayoutY(60);
        pane1.setPrefWidth(49);
        pane1.setPrefHeight(100);       
        red1 = new Circle(0, 0, 14,gray);
        orang1 = new Circle(0, 0, 14,gray);
        green1 = new Circle(0, 0, 14,gray);
        
        pane1.getChildren().addAll(red1,orang1,green1);
        
        
                /******* road sign 2 *******/ 
        pane2 = new HBox();
        pane2.setLayoutX(600);
        pane2.setLayoutY(115);
        pane2.setPrefWidth(100);
        pane2.setPrefHeight(49);
        red2 = new Circle(0, 0, 14,gray);
        orang2 = new Circle(0, 0, 14,gray);
        green2 = new Circle(0, 0, 14,gray);
        
        pane2.getChildren().addAll(red2,orang2,green2);
        
        
                /******* road sign 3 *******/ 
        pane3 = new VBox();
        pane3.setLayoutX(607);
        pane3.setLayoutY(450);
        pane3.setPrefWidth(49);
        pane3.setPrefHeight(100);
       
        red3 = new Circle(0, 0, 14,gray);
        orang3 = new Circle(0, 0, 14,gray);
        green3 = new Circle(0, 0, 14,gray);
        
        pane3.getChildren().addAll(red3,orang3,green3);
        
        
        /******* road sign 4 *******/ 
        pane4 = new HBox();
        pane4.setLayoutX(90);
        pane4.setLayoutY(455);
        pane4.setPrefWidth(100);
        pane4.setPrefHeight(49);
        red4 = new Circle(0, 0, 14,gray);
        orang4 = new Circle(0, 0, 14,gray);
        green4 = new Circle(0, 0, 14,gray);
        
        pane4.getChildren().addAll(red4,orang4,green4);
        
        
        
        
        
        btnStart = new JFXButton("Start");
        btnStart.setLayoutX(750);
        btnStart.setLayoutY(30);
        
        btnReset = new JFXButton("Reset");
        btnReset.setLayoutX(750);
        btnReset.setLayoutY(90);
        btnReset.setDisable(false); // Diable the btnReset => you can't Click of the Button
        
        
                /* Image Car For Left road */
        carImageL = new ImageView[nameCarLeft.length];
        
        for (int i = 0; i < carImageL.length; i++) {
            carImageL[i] = new ImageView(nameCarLeft[i] + ".PNG");
            carImageL[i].setLayoutX(-40 - 250 * i);
            carImageL[i].setLayoutY(350);
            carImageL[i].setFitWidth(215);
            carImageL[i].setFitHeight(70);
        }
                /* Image Car For Right road */
        carImageR = new ImageView[nameCarRight.length];
        
        carImageR[3] = new ImageView(nameCarRight[3] + ".PNG");
            carImageR[3].setLayoutX(630 + 350 * 10);
            carImageR[3].setLayoutY(190);
            carImageR[3].setFitWidth(215);
            carImageR[3].setFitHeight(70);
            
            carImageR[4] = new ImageView(nameCarRight[4] + ".PNG");
            carImageR[4].setLayoutX(730 + 400 * 10);
            carImageR[4].setLayoutY(190);
            carImageR[4].setFitWidth(215);
            carImageR[4].setFitHeight(70);
            
            
        for (int i = 0; i < carImageR.length - 2; i++) {
            carImageR[i] = new ImageView(nameCarRight[i] + ".PNG");
            carImageR[i].setLayoutX(690 + 350 * i);
            carImageR[i].setLayoutY(190);
            carImageR[i].setFitWidth(215);
            carImageR[i].setFitHeight(70);
        }
          
        
        
                /* Image Car For Top road */
        carImageT = new ImageView[nameCarTop.length];
        
        for (int i = 0; i < carImageT.length; i++) {
            carImageT[i] = new ImageView(nameCarTop[i] + ".PNG");
            carImageT[i].setLayoutX(250);
            carImageT[i].setLayoutY(-220 - 450 * i);
            carImageT[i].setFitWidth(70);
            carImageT[i].setFitHeight(215);
        }
        
                   /* Image Car For Bottom road */
        carImageB = new ImageView[nameCarBottom.length];
        
        for (int i = 0; i < carImageB.length; i++) {
            carImageB[i] = new ImageView(nameCarBottom[i] + ".PNG");
            carImageB[i].setLayoutX(480);
            carImageB[i].setLayoutY(500 + 250 * i);
            carImageB[i].setFitWidth(70);
            carImageB[i].setFitHeight(215);
        }
        
        
        /* End Initialize Part */
        
        /* Start Action Part */
        
     
        
        btnStart.setOnAction(e -> {
      
      
            Semaphore redSem = new Semaphore(1);
            Semaphore greenSem = new Semaphore(1);
            Semaphore mutex1 = new Semaphore(1);
            Semaphore mutex2 = new Semaphore(1);
            Semaphore mutex = new Semaphore(1);
            
           // for(int i = 0; i < 3; i++)
                new Cars(mutex,redSem, nameCarBottom[0], greenSem,mutex1,mutex2);
            
//            for(int i = 0; i < 2; i++)
//                new Cars(redSem, nameCarTop[i], greenSem);
//            
//            for(int i = 0; i < 2; i++)
//                new Cars(redSem, nameCarLeft[i], greenSem);
//            
//            for(int i = 0; i < 1; i++)
//                new Cars(redSem, nameCarRight[i], greenSem);
            
        });
        
       btnReset.setOnAction(e -> {
            
            for(int i = 0; i < carImageB.length; i++){
                carImageB[i].setTranslateX(0);
                carImageB[i].setTranslateY(0);
           }
            for(int i = 0; i < carImageR.length; i++){     
                carImageR[i].setTranslateX(0);
                carImageR[i].setTranslateY(0);
            }
            for(int i = 0; i < carImageL.length; i++){
                carImageL[i].setTranslateX(0);
                carImageL[i].setTranslateY(0);
            }
                
            for(int i = 0; i < carImageT.length; i++){    
                carImageT[i].setTranslateX(0);
                carImageT[i].setTranslateY(0);
            }     
               
           
       });
  
                
        /* End Action Part */
        
        root.getChildren().addAll( btnStart, btnReset,pane1, pane2,pane3,pane4);
        for(ImageView image0 : carImageL){ // Add all man Image to the Scane
            root.getChildren().add(image0);
        }
        for(ImageView image1 : carImageT){ // Add all man Image to the Scane
            root.getChildren().add(image1);
        }
        for(ImageView image2 : carImageR){ // Add all man Image to the Scane
            root.getChildren().add(image2);
        }
        for(ImageView image3 : carImageB){ // Add all man Image to the Scane
            root.getChildren().add(image3);
        }
        Scene scene = new Scene(root, 900, 650);
        
        scene.getStylesheets().add("ProjetSe/style.css");
        primaryStage.setTitle("Carrefour Managment System");
        primaryStage.setScene(scene);
        //primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    
   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}