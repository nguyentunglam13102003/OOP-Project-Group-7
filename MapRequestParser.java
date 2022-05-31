import java.io.*;
import java.security.*;
import java.util.*;
import java.net.*;
// import java.security.spec.ECGenParameterSpec;
public class MapRequestParser {
	public static List<Map<String,String>> getmap(){
		List<Map<String,String>> mapofrecord = new ArrayList<Map<String,String>>();
		try { 
			URL u = new URL("https://x8ki-letl-twmt.n7.xano.io/api:GLxEw1ZB/transactions?fbclid=IwAR1LNQ00bVITxLLzbR6u48gQO66ProY4IsvqNC28CaYbySJnbdEyiAp0b4k");
			// transactions/new?sender="Billy"&receiver="Dzuong"
			HttpURLConnection hr = (HttpURLConnection)u.openConnection();
			System.out.println(hr.getResponseCode());
			if (hr.getResponseCode()==200) {
				InputStream im = hr.getInputStream();
				StringBuffer sb = new StringBuffer();
				BufferedReader br = new BufferedReader(new InputStreamReader(im));
				String line = br.readLine();
//				System.out.println("here"+line);
//				while(line!= null) {
				String processedline = line.substring(2,line.length()-2);
				System.out.println(processedline +" pro");
				String[] splitthelines = processedline.split("},");
				String[] equallines = new String[splitthelines.length];
				int counter = 0;
				for (String s:splitthelines) {
					Character ch = new Character('{');
					if (Character.valueOf(s.charAt(0)).compareTo(Character.valueOf(ch))==0) {
						s = s.substring(1,s.length());
					}
					
					equallines[counter]= s;
					counter++;
				}
				for (String s:equallines) {
					System.out.println(s);
				}
				for (String s:equallines) {
					String[] processed = s.split(",");
					Map<String,String> smallmap = new HashMap<String,String>();
					for (String pro:processed) {
						String[] diccompo = pro.split(":");
						smallmap.put(diccompo[0].trim(), diccompo[1].trim());
					}
					mapofrecord.add(smallmap);
				}
				System.out.println("final map" + mapofrecord);
//				String[] splitline = processedline.split(",");
//
//				for (String mini:splitline) {
//					String[] diccompo = mini.split(":");
//				}
//			}
		
		}
		}catch (Exception e) {
				System.out.println(e);
			}
		return mapofrecord;
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException  {
		List<Map<String,String>> map = getmap();
		System.out.println(map.get(0).get("\"sender\""));
		

    // simple for printing.
	}

}