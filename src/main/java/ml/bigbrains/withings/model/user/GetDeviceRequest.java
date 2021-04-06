package ml.bigbrains.withings.model.user;


import lombok.Getter;
import lombok.ToString;
import ml.bigbrains.withings.model.GenericRequest;

import java.util.HashMap;
import java.util.Map;

@ToString
public class GetDeviceRequest implements GenericRequest {

    @Getter
    private String requestUrl = "user";

    private String action = "getdevice";

    @Override
    public Map<String, String> getParamMap() {
        Map<String,String> map = new HashMap<>();
        map.put("action",action);
        return map;
    }
}
