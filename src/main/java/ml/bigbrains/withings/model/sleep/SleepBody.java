package ml.bigbrains.withings.model.sleep;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SleepBody {
    private List<SleepSeries> series;
    @JsonProperty("more")
    private Boolean more;
    @JsonProperty("offset")
    private Integer offset;
    @JsonProperty("model")
    private String model;
    @JsonProperty("model_id")
    private Long modelId;
}
