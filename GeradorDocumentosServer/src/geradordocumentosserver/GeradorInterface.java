/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradordocumentosserver;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author unifrasilva
 */
public interface GeradorInterface extends Remote{
    public void executa(float i) throws RemoteException;
}
