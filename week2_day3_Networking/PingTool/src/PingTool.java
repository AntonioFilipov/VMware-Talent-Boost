import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class PingTool {

	  public static boolean ping(String hostName, int port) throws IOException {
		  boolean isReachable = true;
		  try{
			  new Socket(hostName, port);
		  }catch(UnknownHostException e){
			  e.printStackTrace();
			  isReachable = false;
		  }catch(IOException e){
			  e.printStackTrace();
			  isReachable = false;
		  }
		  
		  return isReachable;
	  }
	  
	  public static boolean ping(String hostName) throws IOException {
		  InetAddress byName = InetAddress.getByName(hostName);
		  return byName.isReachable(5000);
	  }
	  
	  public static void getHostName(String ip) throws UnknownHostException{
	      InetAddress address = InetAddress.getByName(ip);
	      System.out.printf("Host name of %s is %s \n", ip, address.getHostName());
	  }
	 
	  public static void getIp(String hostName) throws UnknownHostException{
	      InetAddress address = InetAddress.getByName(hostName);
	      System.out.printf("IP of %s is %s \n", hostName, address.getHostAddress());
	  }
	 
	  public static void main(String[] args) throws IOException {
		  String ip = "192.168.15.122";
          getHostName("178.62.12.118");
		  getIp("www.akfilipov.com");

		  long start = System.currentTimeMillis();
		  System.out.println(ping(ip, 80));
		  long stop = System.currentTimeMillis();
		  long result = stop - start;
		  System.out.println("Time:"+result+"ms");
	  }

}
