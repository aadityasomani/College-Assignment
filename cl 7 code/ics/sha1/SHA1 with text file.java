import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.security.DigestInputStream;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.security.Security;
import java.io.*;
public class Main
{

  public static void main(String[] args) throws Exception 
  {
	 FileInputStream fstream = new FileInputStream("textfile.txt");

	 DataInputStream in = new DataInputStream(fstream);
  BufferedReader br = new BufferedReader(new      InputStreamReader(in));
  String strLine;
  strLine = br.readLine();
            
    byte[] input = strLine.getBytes();
    System.out.println("input     : " + new String(input));    
    MessageDigest hash = MessageDigest.getInstance("SHA1");

ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input);
    DigestInputStream digestInputStream = new DigestInputStream(byteArrayInputStream, hash);
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    int ch;
    
while ((ch = digestInputStream.read()) >= 0) {
      byteArrayOutputStream.write(ch);
    }

    byte[] newInput = byteArrayOutputStream.toByteArray();
    System.out.println("in digest : " + new String(digestInputStream.getMessageDigest().digest()));

    byteArrayOutputStream = new ByteArrayOutputStream();
    DigestOutputStream digestOutputStream = new DigestOutputStream(byteArrayOutputStream, hash);
    digestOutputStream.write(newInput);
    digestOutputStream.close();

    System.out.println("out digest: " + new String(digestOutputStream.getMessageDigest().digest()));
  }
}