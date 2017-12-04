
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FaelT
 */
public class ClienteTarefa {
    private Socket cliente;
    
    public ClienteTarefa(Socket cliente){
        this.cliente = cliente;
    }
    
    public static boolean verifica(){
        return true;
    }
        
    public void run(){
        try{
         ObjectInputStream   entrada = new ObjectInputStream(cliente.getInputStream());
         Tarefa tarefa = (Tarefa)entrada.readObject();
         
         DataOutputStream dado = new DataOutputStream(cliente.getOutputStream()); 
         dado.writeBoolean(verifica());
         
                 
        }catch(Exception e){
            System.out.println("Excecao ocorrida na thread: " + e.getMessage());
            
        }
    }
}
