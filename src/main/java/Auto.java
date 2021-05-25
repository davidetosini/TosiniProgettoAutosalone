/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.time.LocalDate;

/**
 * 
 * /**
 * la classe rappresenta un Auto
 * i suoi attributi sono:codice
 * nome
 * cognome
 * marca
 * modello
 * targa
 * vendita
 * @version 1.0
 *
 * @author Roberta
 */

/**
 * 
 * @author Roberta
 */
public class Auto 
    {
        private int Codice;
        private String nome;
        private String cognome;
        private String Marca;
        private String Modello;
        private String Targa;
        private LocalDate Vendita;

        /**
         * 
         * @param Codice 
         * @param Nome nome cliente
         * @param Cognome cognome cliente
         * @param Marca marca auto
         * @param Modello modello auto
         * @param Targa targa auto
         * @param anno 
         * @param mese
         * @param giorno 
         * Attraverso anno, mese, giorno si troverà l'auto venduta in det. giorno
         */
         public Auto(int Codice, String Nome, String Cognome, String Marca, String Modello, String Targa,  int anno,int mese,int giorno)
         {
             this.Codice = Codice;
             this.nome = Nome;
             this.cognome = Cognome;
             this.Marca = Marca;
             this.Modello = Modello;
             this.Targa = Targa;
             this.Vendita=LocalDate.of(anno,mese,giorno);
             
         }
         
         /**
          * 
          * @param a Auto da cui sarà istanziata una nuova auto
          * 
          */
         
         public Auto (Auto a)
                 
          {
                 this.Codice=a.getCodice();
                 this.nome=a.getnome();
                 this.cognome=a.getcognome();
                 this.Marca=a.getMarca();
                 this.Modello=a.getModello();
                 this.Targa=a.getTarga();
                 this.Vendita=a.getVendita();
         
          }
         
         
         
            public Auto()
    {
        this.nome=null;
        this.cognome=null;
        this.Codice=0;
        this.Marca=null;
        this.Modello=null;
        this.Targa=null;
        this.Vendita=null;

    }
    
    
           
         public int getCodice() 
    {
        return Codice;
    }

         /**
          * 
  
          * @return 
          * Assegna nome al cliente
          */
    public String getnome() 
    {
        return nome;
    }

    /**
          * 
  
          * @return 
          * Assegna cognome al cliente
          */
    public String getcognome() 
    {
        return cognome;
    }

    /**
          * 
  
          * @return 
          * Assegna marca all auto
          */
    public String getMarca() 
    {
        return Marca;
    }
    
    /**
          * 
  
          * @return 
          * Assegna modello all auto
          */
    public String getModello() 
    {
        return Modello;
    }
    
    /**
          * 
  
          * @return 
          * Assegna targa all'auto
          */
    public String getTarga() 
    {
        return Targa;
    }
    /**
          * 
  
          * @return 
          * Assegna vendita al cliente
          */

   public LocalDate getVendita() 
    {
        return Vendita;
    }

  
    public void setCodice(int Codice) 
    {
        this.Codice = Codice;
    }

    /**
     * 
     * @param Nome restituisce il nome
     */
    public void setNome(String Nome) 
    {
        this.nome = Nome;
    }

    /**
     * 
     * @param Cognome restituisce il cognome
     */
    public void setCognome(String Cognome) 
    {
        this.cognome = Cognome;
    }

    /**
     * 
     * @param Marca restituisce la marca
     */
    public void setMarca(String Marca) 
    {
        this.Marca = Marca;
    }
    
    /**
     * 
     * @param Modello restituisce il modello
     */
    
     public void setModello(String Modello) 
    {
        this.Marca = Modello;
    }
     
     /**
     * 
     * @param Targa restituisce la targa
     */
     
      public void setTarga(String Targa) 
    {
        this.Targa = Targa;
    }
    
      /**
       * 
       * @param Vendita restituisce la vendita
       */

    public void setVendita(LocalDate Vendita) 
    {
        this.Vendita=Vendita;
    }
    
   /**
     * restituisce una stringa contenente tutti gli attributi di un auto
     * @return s stringa contente attributi dell auto
     */ 

  public String toString()
   {
       String s;
       s="Codice: "+getCodice()+"; Nome: "+getnome()+"; Cognome: "+getcognome()+"; Marca: "+getMarca()+"; Modello: "+getModello()+"; Targa: "+getTarga()+ " Vendita: "+getVendita();
       return s;
   }
}

    