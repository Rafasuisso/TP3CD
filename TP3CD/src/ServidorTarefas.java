
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
    List<Tarefa> bag = new ArrayList<Tarefa>();
    // List<ClienteTarefa> clientes = new ArrayList<ClienteTarefa>();
    //List<Boolean> resposta = new ArrayList<Boolean>();
    
    public static void main(String []args){
        if(args.length<1){
            System.out.println("Informe a porta a ser ouvida pelos servidor");
            System.exit(0);
        }
        try{
            int port = Integer.parseInt(args[0]);
            System.out.println("Inicializando o servidor");
            ServerSocket servidor = new ServerSocket(port);
            System.out.println("Servidor iniciado, ouvindo porta "+ port);
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
