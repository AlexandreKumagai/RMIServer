/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradordocumentosserver;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author unifrasilva
 */
public class GeradorCliente {
    
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException, InterruptedException{
        
        GeradorInterface remoto = null;
        Registry reg=LocateRegistry.getRegistry("169.254.40.49",1429);
        remoto = (GeradorInterface) reg.lookup("japones");
        int option = 3;
        Scanner s = new Scanner(System.in);      
        String doc = null;
        while(option != 0){
            
            System.out.println("Favor informar: 1 para CPF  -  2 para CNPJ  -  0 para sair\nValor: ");
            option = s.nextInt();
            if(option == 1){
                System.out.println("\nFavor digitar 9 digitos para CPF:");
                doc = s.next();
                if(doc.length() == 9 )
                    remoto.executa(doc,option);
                else
                    System.out.println("\nNumero de digitos invalido");    
            }
            if(option == 2){
                System.out.println("\nFavor digitar 11 digitos para CNPJ:");
                doc = s.next();
                if(doc.length() == 9 )
                    remoto.executa(doc,option);
                else
                    System.out.println("\nNumero de digitos invalido");    
            }
            
        }
    }
}
