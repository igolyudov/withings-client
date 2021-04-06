package ml.bigbrains.withings.model.heart;

import lombok.Getter;
import lombok.ToString;
import ml.bigbrains.withings.model.GenericRequest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

@ToString
public class HeartListRequest implements GenericRequest {

    @Getter
    private String requestUrl = "heart";

    private String action = "list";
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long offset;

    public HeartListRequest(LocalDateTime startDate, LocalDateTime endDate, Long offset) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.offset = offset;
    }


    @Override
    public Map<String, String> getParamMap() {
        Map<String,String> map = new HashMap<>();
        map.put("action",action);
        if(startDate!=null)
            map.put("startdate",Long.toString(startDate.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond()));
        if(endDate!=null)
            map.put("enddate",Long.toString(endDate.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond()));
        if(offset!=null)
            map.put("offset",Long.toString(offset));
        return map;

    }
}
