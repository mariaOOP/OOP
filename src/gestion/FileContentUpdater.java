/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class FileContentUpdater {

    public static void main(String args[]) throws IOException {
        
        
        String ID, Name;
        String modify;

        Scanner console = new Scanner(System.in);
        System.out.print("Enter ID : ");
        String pID = console.nextLine();
        System.out.print("Enter modification Value: ");
        modify = console.nextLine();

        File originalFile = new File("/home/tato/Documentos/misEstudiantes.txt");
        BufferedReader br = new BufferedReader(new FileReader(originalFile));

        // Construct the new file that will later be renamed to the original
        // filename.
        File tempFile = new File("/home/tato/Documentos/auxiliar.txt");
        PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

        String line = null;
        // Read from the original file and write to the new
        // unless content matches data to be removed.
        while ((line = br.readLine()) != null) {

            if (line.contains(pID)) {
                
                String estudianteModificado [] = line.split(",");
                estudianteModificado[5]= modify;
                
                //line = "";
                line= estudianteModificado[0]+","+estudianteModificado[1]+","+ estudianteModificado[2]+","+estudianteModificado[3]+","+estudianteModificado[4]+","+estudianteModificado[5];
                System.out.println(line);
            }
            pw.println(line);
            pw.flush();
        }
        pw.close();
        br.close();

        // Delete the original file
        if (!originalFile.delete()) {
            System.out.println("Could not delete file");
            return;
        }

        // Rename the new file to the filename the original file had.
        if (!tempFile.renameTo(originalFile))
            System.out.println("Could not rename file");

    }
    static void modifyFile(String filePath, String oldString, String newString)
    {
        File fileToBeModified = new File(filePath);
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
         
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            //Reading all the lines of input text file into oldContent
            String line = reader.readLine();
             
            while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();
            }
             
            //Replacing oldString with newString in the oldContent
           String newContent = oldContent.replaceAll(oldString, newString);
             
            //Rewriting the input text file with newContent
            writer = new FileWriter(fileToBeModified);
            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources
                reader.close();
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }

}