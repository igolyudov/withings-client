package ml.bigbrains.withings.model.sleep;

import lombok.Getter;
import ml.bigbrains.withings.model.GenericRequest;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SleepRequest implements GenericRequest {

    @Getter
    private String requestUrl = "sleep";

    private String action = "get";
    private LocalDate startDate;
    private List<String> dataFields;

    public SleepRequest(LocalDate startDate, List<String> dataFields) {
        this.startDate = startDate;
        this.dataFields = dataFields;
    }

    @Override
    public Map<String, String> getParamMap() {
        Map<String,String> map = new HashMap<>();
        map.put("action",action);
        if(startDate!=null)
        {
            map.put("startdate",Long.toString(startDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().getEpochSecond()));
            map.put("enddate",Long.toString(startDate.plusDays(1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant().getEpochSecond()));
        }
        if(dataFields!=null && !dataFields.isEmpty())
            map.put("data_fields",String.join(",",dataFields));

        return map;
    }
}
