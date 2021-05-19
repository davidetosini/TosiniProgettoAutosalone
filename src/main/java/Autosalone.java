/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Roberta
 */
public class AutoSalone 
{
    private Auto [] elencoVendita;
    private final int N_MAX_VENDITE=100;
    private int nVenditeCliente;
    private int nVenditeModello;
    
        public AutoSalone()
        {
            elencoVendita=new Auto[N_MAX_VENDITE];
        }
        
        public AutoSalone(AutoSalone a)
    {
       elencoVendita=new Auto[N_MAX_VENDITE];
        for(int i=0;i<getN_MAX_VENDITE();i++)
        {
            elencoVendita[i]=a.getAuto(i);
        }
    }

    public Auto[] getElencoVendita() {
        return elencoVendita;
    }

    public int getN_MAX_VENDITE() {
        return N_MAX_VENDITE;
    }

    public int getnVenditeCliente() {
        return nVenditeCliente;
    }

    public int getnVenditeModello() {
        return nVenditeModello;
    }

    public void setElencoVendita(Auto[] aggiungiVendita) {
        this.elencoVendita = aggiungiVendita;
    }

    public void setnVenditeCliente(int nVenditeCliente) {
        this.nVenditeCliente = nVenditeCliente;
    }

    public void setnVenditeModello(int nVenditeModello) {
        this.nVenditeModello = nVenditeModello;
    }
    public Auto getAuto(int posizione)
    {
        if(posizione<0||posizione>=getN_MAX_VENDITE())
            return null;
        if(elencoVendita[posizione]==null)
            return null;
        return new Auto(elencoVendita[posizione]);
    }
        
}

   