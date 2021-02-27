import java.io.*;
import java.util.regex.*;

/**
 * A Java application to demonstrate the Java package 
 * java.util.regex.  We take one command-line argument, 
 * which is treated as a regexp and compiled into a
 * Pattern.  We then use that pattern to filter the
 * standard input, echoing to standard output only
 * those lines that match the Pattern.
 */
 
 
 
 //java RegexFilter '^(0|1(01*0)*1)*$'

class RegexFilter {
  public static void main(String[] args) 
        throws IOException {

    Pattern p = Pattern.compile(args[0]); // the regexp
    BufferedReader in =  // standard input
      new BufferedReader(new InputStreamReader(System.in));

    // Read and echo lines until EOF.

    String s = in.readLine();
    while (s!=null) {
      Matcher m = p.matcher(s);
      if (m.matches()) System.out.println(s);
      s = in.readLine();
    }
  }
}
