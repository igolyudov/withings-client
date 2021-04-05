package ml.bigbrains.withings.model.sleep;

import lombok.Getter;
import ml.bigbrains.withings.model.GenericRequest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SleepSummaryRequest implements GenericRequest {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Getter
    private String requestUrl = "sleep";

    private String action = "getsummary";

    private LocalDate startDate;
    private LocalDate endDate;
    private long lastUpdate;
    private List<String> dataFields;

    public SleepSummaryRequest(LocalDate startDate, LocalDate endDate, List<String> dataFields) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.dataFields = dataFields;
    }

    public SleepSummaryRequest(long lastUpdate, List<String> dataFields) {
        this.lastUpdate = lastUpdate;
        this.dataFields = dataFields;
    }

    @Override
    public Map<String, String> getParamMap() {
        Map<String,String> map = new HashMap<>();
        map.put("action",action);
        if(startDate!=null && endDate!=null)
        {
            map.put("startdateymd",startDate.format(formatter));
            map.put("enddateymd",endDate.format(formatter));
        }
        else
            map.put("lastupdate",Long.toString(lastUpdate));
        if(dataFields!=null && !dataFields.isEmpty())
            map.put("data_fields",String.join(",",dataFields));
        return map;
    }

}
