/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geradordocumentosserver;

/**
 *
 * @author unifrasilva
 */
public class Gerador {
    private GeradorDigito gerador;
    Gerador(Integer codigo){
        gerador = new RelacaoDocumentos().getInstance(codigo);
    }
    public GeradorDigito getGerador(){
        return this.gerador;
    }
}
