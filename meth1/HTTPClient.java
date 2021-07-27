/** Refer to CodeHS Lessons 2.1-2.6 */
/** Code sourced from Perry Xiao, p. 152*/

/*
Type this code into an editor. Get it to run. Then answer the questions below.
1. What objects are being created? Give the object variable names. What classes are these objects instances of?
2. Identify at least 2 constructor calls in this code.
3. What methods are being called on these objects?
4. What parameters do these methods take?
5. List 1 void method and 1 non-void method found in this code. How can you tell which is which?
6. What do you think this program is actually printing to the console?
*/

import java.net.*;
import java.io.*;
public class HTTPClient {
  public static void main(String[] args) throws Exception
  {
    URL url = new URL("http://apple.com");
    URLConnection uConn = url.openConnection();
    InputStream io = uConn.getInputStream();
    BufferedReader in = new BufferedReader(new InputStreamReader(io));
    String inputLine = in.readLine();
    while((inputLine != null))
    {
      System.out.println(inputLine);
      inputLine = in.readLine();
    }
    in.close();
  }
}
