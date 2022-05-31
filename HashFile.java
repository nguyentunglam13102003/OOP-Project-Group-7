import java.security.MessageDigest;
import java.util.*;
import java.security.NoSuchAlgorithmException;

public class HashFile {
    public static String hash(String input) throws NoSuchAlgorithmException{
        String result;
        MessageDigest md  = MessageDigest.getInstance("SHA-256");
        md.update(input.getBytes());
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b :digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        result =sb.toString();
        return result;

    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Map<String, Map<String, String>> map = new HashMap<>();
        // genesis
        NavigableMap<String, String> details = new TreeMap<>();
        details.put("sender", "Gayson");
        details.put("receiver", "Duong");
        long currentUnixtime = System.currentTimeMillis() / 1000L;
        details.put("unixtime", String.valueOf(currentUnixtime));
        map.put("genesis", details);
        map();
        System.out.println(map);
    }
}
