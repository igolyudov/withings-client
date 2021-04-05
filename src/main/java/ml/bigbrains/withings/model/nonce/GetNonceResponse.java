package ml.bigbrains.withings.model.nonce;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import ml.bigbrains.withings.model.GenericResponse;

@Data
@ToString(callSuper = true)
public class GetNonceResponse extends GenericResponse {
    @JsonProperty("body")
    private NonceBody body;
}
