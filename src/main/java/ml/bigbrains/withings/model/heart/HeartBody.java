package ml.bigbrains.withings.model.heart;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class HeartBody {
    @JsonProperty("signal")
    private Long signal; //Signal value in micro-volt (μV).
    @JsonProperty("sampling_frequency")
    private Long samplingFrequency; //Signal Sampling Frequency (Hz).
    @JsonProperty("wearposition")
    private WearPosition wearPosition;
    @JsonProperty("series")
    private List<HeartSeries> series;
    @JsonProperty("more")
    private Boolean more;
    @JsonProperty("offset")
    private Long offset;
}
