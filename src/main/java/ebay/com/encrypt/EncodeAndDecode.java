package ebay.com.encrypt;

import java.util.Base64;

public class EncodeAndDecode {
    public static String encode(String message) {
        String str = "EbayPassRole" + Base64.getEncoder().encodeToString(message.getBytes()) + "thuan++Pluss///.com";
        return str;
    }

    public static String decode(String message) {
        message = message.replace("thuan++Pluss///.com", "");
        message = message.replace("EbayPassRole", "");
        return new String(Base64.getDecoder().decode(message));
    }
}
