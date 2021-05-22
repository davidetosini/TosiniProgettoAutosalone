
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Month;

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
    private int nVenditeCliente=0;
    
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

   

    public void setElencoVendita(Auto[] aggiungiVendita) {
        this.elencoVendita = aggiungiVendita;
    }

    public void setnVenditeCliente(int nVenditeCliente) {
        this.nVenditeCliente = nVenditeCliente;
    }

   
    public Auto getAuto(int posizione)
    {
        if(posizione<0||posizione>=getN_MAX_VENDITE())
            return null;
        if(elencoVendita[posizione]==null)
            return null;
        return new Auto(elencoVendita[posizione]);
    }
    
    public void AggiungiAuto (Auto a)
    {
        elencoVendita[nVenditeCliente]=new Auto(a);
        nVenditeCliente++;
    }
       
    public void EliminaAuto (int Codice)
    {
        
        for (int i=0; i<nVenditeCliente; i++)
                {
                    if (elencoVendita [i].getCodice()==Codice)
                    {
                        AggiornaPosizioneAuto(i);
                    }
                        
                }
    }
    
    private void AggiornaPosizioneAuto(int posizione)
    {
        for (int i=posizione;i<nVenditeCliente-1;i++)
        {
            elencoVendita[i]=elencoVendita[i+1];
        }
        elencoVendita[nVenditeCliente-1]=null;     
        nVenditeCliente--;
    }
    
    public Auto[] VisualizzaAuto(String nome, String cognome)
    {
        Auto[] AutoPersona=new Auto[nVenditeCliente];
        Auto auto;
        int x=0;
         for (int i=0;i<nVenditeCliente;i++)
         {
             if (elencoVendita[i].getnome().compareToIgnoreCase(nome)==0 && elencoVendita[i].getcognome().compareToIgnoreCase(cognome)==0)
             {
               auto=elencoVendita[i];
               AutoPersona[x]=auto;
               x++;
             }
         }
         return AutoPersona;
             
             
    }
    
     public Auto[] VisualizzaModello(String Modello)
    {
        Auto[] AutoPersona=new Auto[nVenditeCliente];
        Auto auto;
        int x=0;
         for (int i=0;i<nVenditeCliente;i++)
         {
             if (elencoVendita[i].getModello().compareToIgnoreCase(Modello)==0)
             {
               auto=elencoVendita[i];
               AutoPersona[x]=auto;
               x++;
             }
         }
         return AutoPersona;
             
             
    }
     
      public Auto[] VisualizzaGiorno(int anno,int mese,int giorno)
    {
        LocalDate Data=LocalDate.of(anno, mese, giorno);
        Auto[] AutoPersona=new Auto[nVenditeCliente];
        Auto auto;
        int x=0;
         for (int i=0;i<nVenditeCliente;i++)
         {
             if (elencoVendita[i].getVendita().isEqual(Data)== true)
             {
               auto=elencoVendita[i];
               AutoPersona[x]=auto;
               x++;
             }
         }
         
         AutoPersona=Ordinatore.selectionSortAlfabeticoAutoPersona(AutoPersona);
         
         
         return AutoPersona;
             
             
    }
      
      public Auto getAutoPosizione(int posizione)
    {
        return elencoVendita[posizione];
    }
      
    public void salvaAuto(String nomeFile) throws IOException
    {
        TextFile f1=new TextFile(nomeFile,'W');
        Auto auto;
        for(int i=0;i<nVenditeCliente;i++)
            {
               auto=getAutoPosizione(i);
                if(auto!=null)
               /* {
                    f1.toFile(auto.getCodice()+";"+auto.getTarga()+";"+auto.getnome()+";"+auto.getcognome()+";"+auto.getModello()+";"+auto.getMarca()+";"+auto.getVendita()+";");
                } */
            }
        f1.close();
    }
    
    public void salvaAutoBinario(String nomeFile) throws IOException
    {
        FileOutputStream f1=new FileOutputStream(nomeFile);
        ObjectOutputStream writer=new ObjectOutputStream(f1);
        writer.writeObject(this);
        writer.flush();
        writer.close();
    }
}

   