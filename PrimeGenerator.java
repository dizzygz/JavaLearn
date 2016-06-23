import java.io.*;

public class PrimeGenerator{
   public static void main(String[] args){
      Thread primeGenerator = new Thread(new WorkerThread());
      primeGenerator.setDaemon(true);
      primeGenerator.start();
      
      try{
         Thread.sleep(5);
      }catch(InterruptedException e){
         //e.printStack();
      }
      System.out.printf("current thread group %s has %d threads running %n", 
         primeGenerator.getThreadGroup().getName(), Thread.activeCount());
   }

}

class WorkerThread implements Runnable{
    private long i=1;
   public void run(){
         long j;
           while(true){
         for(j=2; j<=i; j++){
            long n= i%j;
            if(n==0)break;
         }
         
         if(i==j){
            System.out.println(" "+i);
         }
         i++;
      }
   
   }
      
}


