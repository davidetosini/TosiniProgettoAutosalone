/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.time.LocalDate;

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
    
    

         
         public int getCodice() 
    {
        return Codice;
    }

    public String getnome() 
    {
        return nome;
    }

    public String getcognome() 
    {
        return cognome;
    }

    public String getMarca() 
    {
        return Marca;
    }
    public String getModello() 
    {
        return Modello;
    }
    
    public String getTarga() 
    {
        return Targa;
    }
    

   public LocalDate getVendita() 
    {
        return Vendita;
    }

  
    public void setCodice(int Codice) 
    {
        this.Codice = Codice;
    }

    public void setNome(String Nome) 
    {
        this.nome = Nome;
    }

    public void setCognome(String Cognome) 
    {
        this.cognome = Cognome;
    }

    public void setMarca(String Marca) 
    {
        this.Marca = Marca;
    }
     public void setModello(String Modello) 
    {
        this.Marca = Modello;
    }
      public void setTarga(String Targa) 
    {
        this.Targa = Targa;
    }
    

    public void setVendita(LocalDate Vendita) 
    {
        this.Vendita=Vendita;
    }

  public String toString()
   {
       String s;
       s="Codice: "+getCodice()+"; Nome: "+getnome()+"; Cognome: "+getcognome()+"; Marca: "+getMarca()+"; Modello: "+getModello()+"; Targa: "+getTarga()+ " Vendita: "+getVendita();
       return s;
   }
}