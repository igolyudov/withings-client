package ml.bigbrains.withings.model.sleep;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SleepSummaryBody {
    @JsonProperty("series")
    private List<SleepSeries> series;
    @JsonProperty("more")
    private Boolean more;
    @JsonProperty("offset")
    private Integer offset;
}
