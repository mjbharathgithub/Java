package IOStreams;
import java.io.FileInputStream;
import java.io.IOException;
public class FileinputstreamInJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FileInputStream fileInputStream=null;
		try {
		fileInputStream=new  FileInputStream("src/IOStreams/sample.txt");
		fileInputStream.skip(100);
		System.out.println("fileChannel : "+fileInputStream.getChannel()+"\nFileDescriptor :"+fileInputStream.getFD());
		
		int byteData;
		
		byte []buffer=new byte[150];
		while((byteData= fileInputStream.read(buffer,0,buffer.length))!=-1) {
			String chunkString=new String(buffer,0,byteData);
			System.out.print(chunkString);
		}
		
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("IO exception has occured \n");e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("other exception has occured");e.printStackTrace();
		}
		finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

	}

}
