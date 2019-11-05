/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradordocumentosserver;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author unifrasilva
 */
public class GeradorDocumentosServer extends UnicastRemoteObject implements GeradorInterface {


    public GeradorDocumentosServer() throws RemoteException{
    }

    @Override
    public String executa(String doc , int flag) throws RemoteException {
        
            System.out.println("recebeu  :" +  doc);     
        
            return "Documento gerado : " + new Gerador(flag).getGerador().gerar(doc);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            
            Registry r = LocateRegistry.createRegistry(1429);          
            GeradorDocumentosServer servidor = new GeradorDocumentosServer();
            r.rebind("japones", servidor);
            System.out.println("Servidor pronto "+r.lookup("japones"));     
            
        }catch(NotBoundException | RemoteException e){
           
            e.printStackTrace();
        
        }
    }
    
}
