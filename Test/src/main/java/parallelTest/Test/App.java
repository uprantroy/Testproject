package parallelTest.Test;

import java.io.*;

import net.sourceforge.tess4j.*;
public class App {
    public static String getImgText(File f) {
      ITesseract instance = new Tesseract();
      try 
      {
         String imgText = instance.doOCR(f);
         return imgText;
      } 
      catch (TesseractException e) 
      {
         e.getMessage();
         return "Error while reading image";
      }
   }
    public static File lastFileModified(String dir) {
        File fl = new File(dir);
        File[] files = fl.listFiles(new FileFilter() {          
            public boolean accept(File file) {
                return file.isFile();
            }
        });
        long lastMod = Long.MIN_VALUE;
        File choice = null;
        for (File file : files) {
            if (file.lastModified() > lastMod) {
                choice = file;
                lastMod = file.lastModified();
            }
        }
        return choice;
    }
}