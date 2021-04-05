package ml.bigbrains.withings.model.heart;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Ecg {
    @JsonProperty("signalid")
    private Long signalId;
    @JsonProperty("afib")
    private Afib afib;
}
