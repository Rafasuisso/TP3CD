
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
public class ClienteTarefa extends Thread{
    private Socket cliente;
    
    public ClienteTarefa(Socket cliente){
        this.cliente = cliente;
    }
    
    
        
    public void run(){
        try{
         ObjectInputStream   entrada = new ObjectInputStream(cliente.getInputStream());
         Tarefa tarefa = (Tarefa)entrada.readObject();
         boolean resposta = tarefa.verifica();
         
         DataOutputStream dado = new DataOutputStream(cliente.getOutputStream()); 
         dado.writeBoolean(resposta);
         
                 
        }catch(Exception e){
            System.out.println("Excecao ocorrida na thread: " + e.getMessage());
            
        }
    }
}
