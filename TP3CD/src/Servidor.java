/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 *
 * @author FaelT
 */
public class Servidor {
    public static void main(String [] args){
        try{
            ServerSocket servidor =  new ServerSocket(12345);
            System.out.println("Servidor ouvindo a porta 12345");
            while(true){
               Socket cliente = servidor.accept();
               System.out.println("Cliente conectado: "+ cliente.getInetAddress().getHostAddress());
               ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
               saida.flush();
               saida.writeObject(new Date());
               saida.close();
               cliente.close();
            }
        }catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
//        finally{...}
    }
}
