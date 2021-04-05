package ml.bigbrains.withings.model.heart;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HeartSeries {
    @JsonProperty("deviceid")
    private String deviceId;
    @JsonProperty("model")
    private Long model;
    @JsonProperty("ecg")
    private Ecg ecg;
    @JsonProperty("bloodpressure")
    private BloodPressure bloodPressure;
    @JsonProperty("heart_rate")
    private Long heartRate;
    @JsonProperty("timestamp")
    private Long  timestamp;
}
