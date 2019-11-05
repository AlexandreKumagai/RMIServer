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

/**
 *
 * @author unifrasilva
 */
public class GeradorCliente {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException, InterruptedException{
        GeradorInterface remoto = null;
        Registry reg=LocateRegistry.getRegistry("169.254.40.49",1429);
        remoto = (GeradorInterface) reg.lookup("japones");
        while(true){
            remoto.executa((float)45.0);
            new Thread().sleep(5000);
        }
    }
}
