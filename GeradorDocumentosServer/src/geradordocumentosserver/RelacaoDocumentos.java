/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradordocumentosserver;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author unifrasilva
 */
public class RelacaoDocumentos {
    
    private static Map<Integer,GeradorDigito> mapper = new HashMap<Integer, GeradorDigito>();
    
    static{
        mapper.put(1,new GeradorCpf());
        mapper.put(2, new GeradorCnpj());
    }
    
    public GeradorDigito getInstance(Integer cod){
        return mapper.get(cod);
    }
}
