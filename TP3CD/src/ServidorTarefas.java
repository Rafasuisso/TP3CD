
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FaelT
 */
public class ServidorTarefas {
    static List<Tache> sac = new ArrayList<Tache>();
    // List<ClienteTarefa> clientes = new ArrayList<ClienteTarefa>();
    static List<Boolean> resposta = new ArrayList<Boolean>();
    static double dedans = 0;
    
    static int taille = resposta.size();
    static void numResp(){
             for(int i = 0; i <taille; i++){
                 if(resposta.get(i)==true){
                     dedans +=1;
                 }
             }
             
    }
    
    public static void main(String []args){
       
        System.out.println("Creation de 40 tâches");
        for(int i = 0; i<40;i++){
            sac.add(new Tache());
        }
        
        
        try{
            System.out.println("Début du serveur");
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Serveur ouvert dans la porte 12345");
            
            System.out.print("En attendant de clients");
            while(true){
                Socket cliente = servidor.accept();
                new ClienteTarefa(cliente).start();
                
                
                ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
              
                             
            }
            
            
        }catch (Exception e) {
            System.out.println("Erro: "+e.getMessage());
        }
    }
}
