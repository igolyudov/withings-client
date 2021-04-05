package ml.bigbrains.withings.model.sleep;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SleepSeries {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("model")
    private String model;
    @JsonProperty("model_id")
    private Long modelId;
    @JsonProperty("startdate")
    private Long startDate;
    @JsonProperty("enddate")
    private Long endDate;
    @JsonProperty("date")
    private String date;
    @JsonProperty("created")
    private Long created;
    @JsonProperty("modified")
    private Long modified;
    @JsonProperty("data")
    private SleepData data;
    @JsonProperty("state")
    private Long state;
}
