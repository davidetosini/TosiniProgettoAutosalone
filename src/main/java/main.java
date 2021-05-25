/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Roberta
 */

//import eccezioni.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Roberta
 */
public class main 
{
    public static void main(String[] args)
    {
        AutoSalone b1=new AutoSalone();
        String[] vociMenu=new String[8];
        Scanner tastiera=new Scanner(System.in);
        int sceltaUtente=0;
        Auto auto;
        int giorno=0,mese=0,anno=0;
        int posizione;
        LocalDate data;
        String nomeFile=".txt";
        
        
        

        vociMenu[0]="Esci";
        vociMenu[1]="Inserisci una nuova vendita";
        vociMenu[2]="Elimina una vendita";
        vociMenu[3]="Visualizza dati relativi a tutte le auto acquistate da un cliente";
        vociMenu[4]="Visualizza il numero di auto vendute dello stesso modello ";
        vociMenu[5]="Visualizza auto vendute in un det. giorno in ordine alfabetico del cliente";
        vociMenu[6]="Salva dati su file binario";
        vociMenu[7]="Esporta in formato CSV tutte le vendite";

        
        try
        {
            FileInputStream f1=new FileInputStream("nVenditeCliente.bin");
            ObjectInputStream reader=new ObjectInputStream(f1);
            try
            {
                b1=(AutoSalone)reader.readObject();
                reader.close();
                System.out.println("\nLettura da file avvevuta correttamente");

            }
            catch(ClassNotFoundException ex)
            {
                reader.close();
                System.out.println("\nErrore nella lettura");
            }
        }
        catch(IOException ex)
        {
            System.out.println("\nImpossibile accedere al file");
        }
        Menu menu=new Menu(vociMenu);
        int id=0;
        do
        {
            try
            {
                sceltaUtente=menu.sceltaMenu();
                
            switch(sceltaUtente)
            {
                case 0:
                {
                    System.out.println("L'applicazione e' stata chiusa");
                    break;
                }
                case 1:
                {
                    System.out.println("Targa-->");
                    String targa = tastiera.nextLine();
                                System.out.println("Nome-->");
                    String nome = tastiera.nextLine();
                                System.out.println("Cognome-->");
                    String cognome = tastiera.nextLine();
                                System.out.println("Marca-->");
                    String Marca = tastiera.nextLine();
                                System.out.println("Modello-->");
                    String Modello = tastiera.nextLine();
                                
                                
                                System.out.println("Data: ");
                                System.out.println("Giorno --> ");
                                giorno=tastiera.nextInt();
                                System.out.println("Mese --> ");
                                mese=tastiera.nextInt();
                                System.out.println("Anno --> ");
                                anno=tastiera.nextInt();
                        
                                

                                id++;
                                Auto autoo;
                                autoo=new Auto(id, nome, cognome, Marca, Modello, targa, anno, mese, giorno);

                                b1.AggiungiAuto(autoo);
         break;
                }

                case 2:
                {
                    System.out.println("Inserisci la posizione dell auto da eliminare");
                    System.out.println("Posizione-->");
                    posizione=tastiera.nextInt();
                    

                    tastiera.nextLine();

         
                    b1.EliminaAuto(posizione);

                    System.out.println("premi un pulsante per continuare");
                    tastiera.nextLine();
                    
                    System.out.println(b1.toString());
                    break;
                }
                case 3:
                {
                    Auto[] t1;
                    String Nome;
                    String Cognome;
                    tastiera.nextLine();
                    System.out.println("Nome-->");
                    Nome = tastiera.nextLine();
                    System.out.println("Cognome-->");
                    Cognome = tastiera.nextLine();
                    
                    
                    
                    t1=b1.VisualizzaAuto(Nome, Cognome);
                    for(int i=0;i<t1.length;i++)
                    {
                        if(t1[i]!=null)
                            System.out.println(t1[i]);
                    }
                    break;
                }
                case 4:
                {
                     Auto[] t1;
                     
                    String Modello;
                    tastiera.nextLine();
                    System.out.println("Modello-->");
                    Modello=tastiera.nextLine();
                    t1=b1.VisualizzaModello(Modello);
                     for(int i=0;i<t1.length;i++)
                    {
                        if(t1[i]!=null)
                            System.out.println(t1[i]);
                    }
                    

                    System.out.println("premi un pulsante per continuare");
                   
                    break;
                }
                case 5:
                {
                    Auto[] t1;
                    System.out.println("Anno-->");
                    anno=tastiera.nextInt();
                    System.out.println("Mese-->");
                    mese=tastiera.nextInt();
                    System.out.println("Giorno-->");
                    giorno=tastiera.nextInt();
                    
                    
                    t1=b1.VisualizzaGiorno(anno, mese, giorno);
                    for(int i=0;i<t1.length;i++)
                    {
                        if(t1[i]!=null)
                            System.out.println(t1[i]);
                    }
                    break;
                }
                case 6:
                {
                   try
                    {
                      b1.salvaAutoBinario("nVenditeCliente.bin");  
                        System.out.println("Salvataggio avvenuto correttamente");
                    }
                    catch(IOException e1)
                    {
                        System.out.println("Impossibile accedere al file. Le auto non sono state salvate");
                    }
                   /* catch (FileException e2)
                    {
                        System.out.println(e2.toString());
                    }*/
                    break;
                }
                case 7:
                {
                    try
                    {
                      b1.salvaAuto(nomeFile);  
                        System.out.println("Salvataggio avvenuto correttamente");
                    }
                    catch(IOException e1)
                    {
                        System.out.println("Impossibile accedere al file. Le vendite non sono stati salvati");
                    }
                    catch (FileException e2)
                    {
                        System.out.println(e2.toString());
                    }
                    break;
                }
                
                
            }
                
         }
            catch(InputMismatchException | NumberFormatException e1)
            {
                tastiera.nextLine();
                System.out.println("Input non corretto");
            }
        
        
        }while(sceltaUtente!=0);
    }
            
}
        
        
        