
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FaelT
 */
public class Tache implements Serializable{
    boolean dedans;
    double x,y, distance;
    public Tache(){
        dedans=false;
    }
    
    public boolean verifier(){
        x = Math.random();
        y = Math.random();
        distance = Math.sqrt(Math.pow(x,2)+ Math.pow(y,2));
        if(distance<1){
            dedans=true;
            System.out.println("Le point "+x+" "+y+"est dans le circle" );
        }else{
            System.out.println("Le point "+x+" "+y+"n'est pas dans le circle" );
        }
        
        
        return true;
    }
}
