/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradordocumentosserver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeradorCliente {
    
    public static void main(String[] args) throws NotBoundException, InterruptedException, IOException{
    	/*
    	FileReader arq = new FileReader("C:/Users/igor_/Documents/GitHub/RMIServer/GeradorDocumentosServer/src/geradordocumentosserver/teste.txt");
        BufferedReader lerArq = new BufferedReader(arq);
        List<String> lista = new ArrayList<String>();
        String linha = lerArq.readLine();
        while (linha != null) {
        	lista.add(linha);
          System.out.printf("%s\n", linha);
          linha = lerArq.readLine(); // lê da segunda até a última linha
          
        }
        arq.close();
    	*/
        GeradorInterface remoto = null;
        Registry reg=LocateRegistry.getRegistry("169.254.37.149",1429);
        String cavalo;
        remoto = (GeradorInterface) reg.lookup("japones");
        //cavalo = remoto.executa(lista,1);
        int option = 3;
        Scanner s = new Scanner(System.in);      
        String doc = null;
        while(option != 0){
            
            System.out.println("Favor informar: 1 para CPF  -  2 para CNPJ  -  0 para sair\nValor: ");
            option = s.nextInt();
            if(option == 1){
                System.out.println("\nFavor digitar 9 digitos para CPF:");
                doc = s.next();
                
                if(doc.length() == 9 ) {
                	cavalo = remoto.executa(doc,option);
                	System.out.println("CNPJ gerado" + cavalo);
                }
                else
                    System.out.println("\nNumero de digitos invalido");    
            }
            if(option == 2){
                System.out.println("\nFavor digitar 12 digitos para CNPJ:");
                doc = s.next();
                if(doc.length() == 12 ) {
                	cavalo = remoto.executa(doc,option);
                	System.out.println("CPF gerado" + cavalo);
                }
                else
                    System.out.println("\nNumero de digitos invalido");    
            }
            
        }
    }
}
