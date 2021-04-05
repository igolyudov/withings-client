package ml.bigbrains.withings.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class DeviceBody {
    @JsonProperty("devices")
    private List<Device> devices;
}
