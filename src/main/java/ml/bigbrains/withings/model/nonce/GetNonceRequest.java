package ml.bigbrains.withings.model.nonce;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import ml.bigbrains.withings.SignUtility;
import ml.bigbrains.withings.model.GenericRequest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@ToString
public class GetNonceRequest implements GenericRequest {

    @Getter
    private String requestUrl = "signature";

    private String action="getnonce";
    private String clientId;
    //unix timestamp
    private Long timestamp;
    private String signature;
    private String secret;

    public GetNonceRequest(String clientId, String secret) {
        this.clientId = clientId;
        this.secret = secret;
        this.timestamp = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    @Override
    public Map<String, String> getParamMap() {
        Map<String,String> map = new HashMap<>();
        if(action!=null && !action.equals("")) {
            map.put("action", action);
        }
        if(clientId!=null && !clientId.equals("")) {
            map.put("client_id", clientId);
        }
        if(timestamp!=null && timestamp!=0) {
            map.put("timestamp", Long.toString(timestamp));
        }
        map.put("signature", SignUtility.sign(map,secret));
        return map;
    }


}
