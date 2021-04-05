package ml.bigbrains.withings.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import ml.bigbrains.withings.model.GenericResponse;

@Data
@ToString(callSuper = true)
public class GetGoalsResponse extends GenericResponse {
    @JsonProperty("body")
    private GoalsBody body;
}
