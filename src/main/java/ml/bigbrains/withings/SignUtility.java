package ml.bigbrains.withings;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;;

@Slf4j
public class SignUtility {
    public static String sign(Map<String,String> mapForSing, String secret)
    {
        if(mapForSing==null || secret==null)
        {
            log.error("Empty MAP or SECRET for sign");
            return null;
        }
        String hash = null;
        Map<String,String> sortedMap = mapForSing.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        String forSign = String.join(",", sortedMap.values());

        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            hash = Hex.encodeHexString(sha256_HMAC.doFinal(forSign.getBytes(StandardCharsets.UTF_8)));
        }
        catch (Exception e)
        {
            log.error("Ошибка подписи запроса",e);
        }
        return hash;
    }
}
