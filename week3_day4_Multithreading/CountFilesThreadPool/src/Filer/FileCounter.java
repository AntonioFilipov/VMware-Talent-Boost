package Filer;

import java.io.File;

public class FileCounter {
    private String directoryName="";
    private String currentDirectoryName;
    
    public FileCounter(String directoryName){
        this.directoryName = directoryName;
        currentDirectoryName = this.directoryName;
    }
    
    public String getDirectoryName(){
        return this.directoryName;
    }
    
    public long countFiles() {
        long counter = 0;
        File f = new File(currentDirectoryName);
        File[] files = f.listFiles();

        if (files != null){
            for (int i = 0; i < files.length; i++) {
                counter++;
                File file = files[i];

                if (file.isDirectory()) {
                    currentDirectoryName = file.getAbsolutePath();
                    counter += countFiles();
                }
            }
        }
        return counter;
    }


}
