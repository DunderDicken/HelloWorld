

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Checks if a ip adress is a known spammer.
 * <p>
 * Takes a string and checks if given adress in string is present in "Spamhaus.org" 
 * list of known spamsites.
 * 
 * @author Dick Karlsson
 *
 */
public class SpamChecker {
	  
	  public static final String BLACKHOLE = "sbl.spamhaus.org";

	  public static void main(String[] args) throws UnknownHostException {
		String arg = "130.243.96.139";
	      if (isSpammer(arg)) {
	        System.out.println(arg + " is a known spammer.");
	      } else {
	        System.out.println(arg + " appears legitimate.");
	      }
	    }

	  /**
	   * Takes a string and check against given adress in BLACKHOLE.
	   * @param arg Ip adress or name of site that will be checked
	   * @return Boolean. True if arg was a known spammer, else returns false
	   * 
	   */
	  private static boolean isSpammer(String arg) {
	    try {
	      InetAddress address = InetAddress.getByName(arg);
	      byte[] quad = address.getAddress();
	      String query = BLACKHOLE;
	      for (byte octet : quad) {
	        int unsignedByte = octet < 0 ? octet + 256 : octet;
	        query = unsignedByte + "." + query;
	      }
	      InetAddress.getByName(query);
	      return true;
	    } catch (UnknownHostException e) {
	      return false;
	    }
	  }
	
}
