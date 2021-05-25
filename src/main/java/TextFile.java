/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author Roberta
 */
public class TextFile 
{
    private char mode;
    private BufferedReader reader;
    private BufferedWriter writer;
    
    public TextFile (String nomeFile, char mode) throws IOException
    {
        this.mode='R';
        if (mode=='w' || mode=='W')
            this.mode='w';
        if (this.mode=='W')
            reader=new BufferedReader (new FileReader (nomeFile));
        else
            writer=new BufferedWriter(new FileWriter (nomeFile));
    }
    
     TextFile (String nomeFile, char mode, boolean append) throws IOException
    {
        this.mode='R';
        if (mode=='w' || mode=='W')
            this.mode='w';
        if (this.mode=='W')
            reader=new BufferedReader (new FileReader (nomeFile));
        else
            writer=new BufferedWriter(new FileWriter (nomeFile, append));
    }
     
     public void toFile (String line) throws IOException, FileException
     {
         if (mode=='R')
             throw new FileException("impossibile scrivere sul file. File aperto in lettura");
         writer.write(line);
         writer.newLine();
     }
     
     public String FromFile() throws FileException, IOException
     {
         String s;
          if (mode=='W')
             throw new FileException("impossibile scrivere da file. File aperto in scrittura");
         s=reader.readLine();
         if (s==null)
              throw new FileException("Fine dei file raggiunta");
         return s;
     }
     
     public void close() throws IOException
     {
         if (mode=='R')
             reader.close();
         else
             writer.close();
     }
}
