package Filer;

public class Filer implements Runnable{
    private String directoryName="";
    
    public Filer(String directoryName){
        this.directoryName = directoryName;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        FileCounter fc =  new FileCounter(this.directoryName);
        System.out.println("Files in "+this.directoryName+":"+ fc.countFiles());
    }

}
