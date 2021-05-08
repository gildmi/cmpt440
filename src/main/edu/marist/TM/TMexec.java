 import java.io.*;

public class TMexec {
  public static void main(String[] args) 
        throws IOException {

    Boolean debug = false;
    TM m = new TM(); // the TM
    BufferedReader in =  // standard input
      new BufferedReader(new InputStreamReader(System.in));


    // Read and echo lines until EOF.
    System.out.println("Enter string to evaulate: ");
    String s = in.readLine();
    while (s!=null) {
      // exit condition
      if (s.toLowerCase().contains("exit") || s.toLowerCase().contains("quit") || s.toLowerCase().contains("end")) {
          break;
      }
      // exit condition
      if (s.toLowerCase().contains("debug")) {
        if (debug) {
          debug = false;
        }
        else {
          debug = true;
        }
          
          System.out.println("Debug mode: " + debug);
      }
      // help menu
      else if (s.toLowerCase().contains("help")) {
          System.out.println("Enter a string to evaluate by the Turing Machine or 'exit' to terminate.  Enter 'debug' to see moves.  The language defined in a^nb^nC^n.\n"
            );
      }
      else {
        if (m.accepts(s, debug)) {
              System.out.println("Accepted: " + s);
        }
        else {
              System.out.println("Rejected: " + s);
        }
      }
        System.out.println("Enter string to evaulate: ");
        s = in.readLine();
    }
  }
}
