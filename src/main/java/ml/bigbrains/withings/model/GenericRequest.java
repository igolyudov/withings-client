package ml.bigbrains.withings.model;


import java.util.Map;

public interface GenericRequest {
    public Map<String,String> getParamMap();
    public String getRequestUrl();
}
