package ml.bigbrains.withings.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Device {
    @JsonProperty("type")
    private String type;
    @JsonProperty("model")
    private String model;
    @JsonProperty("model_id")
    private Long modelId;
    @JsonProperty("battery")
    private String battery;
    @JsonProperty("deviceid")
    private String deviceId;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("last_session_date")
    private String lastSessionData;
}
