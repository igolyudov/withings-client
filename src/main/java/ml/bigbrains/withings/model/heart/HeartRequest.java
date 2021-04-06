package ml.bigbrains.withings.model.heart;

import lombok.Getter;
import lombok.ToString;
import ml.bigbrains.withings.model.GenericRequest;

import java.util.HashMap;
import java.util.Map;

@ToString
public class HeartRequest implements GenericRequest {

    @Getter
    private String requestUrl = "heart";

    private String action = "get";
    private String signalId;

    public HeartRequest(String signalId) {
        this.signalId = signalId;
    }

    @Override
    public Map<String, String> getParamMap() {
        Map<String,String> map = new HashMap<>();
        map.put("action",action);
        map.put("signalid",signalId);
        return map;
    }
}
