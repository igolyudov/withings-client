package ml.bigbrains.withings.model.nonce;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NonceBody {
    @JsonProperty("nonce")
    private String nonce;
}
