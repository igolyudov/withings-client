package ml.bigbrains.withings.model.sleep;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SleepData {
    @JsonProperty("breathing_disturbances_intensity")
    private Integer breathingDisturbancesIntensity;
    @JsonProperty("deepsleepduration")
    private Integer deepSleepDuration;
    @JsonProperty("durationtosleep")
    private Integer durationToSleep;
    @JsonProperty("durationtowakeup")
    private Integer durationtoWakeup;
    @JsonProperty("hr_average")
    private Integer hrAverage;
    @JsonProperty("hr_max")
    private Integer hrMax;
    @JsonProperty("hr_min")
    private Integer hrMin;
    @JsonProperty("lightsleepduration")
    private Integer lightSleepDuration;
    @JsonProperty("nb_rem_episodes")
    private Integer nbRemEpisodes;
    @JsonProperty("out_of_bed_count")
    private Integer outOfBedCount;
    @JsonProperty("remsleepduration")
    private Integer remSleepDuration;
    @JsonProperty("rr_average")
    private Integer rrAverage;
    @JsonProperty("rr_max")
    private Integer rrMax;
    @JsonProperty("rr_min")
    private Integer rrMin;
    @JsonProperty("sleep_efficiency")
    private Integer sleepEfficiency;
    @JsonProperty("sleep_latency")
    private Integer sleepLatency;
    @JsonProperty("sleep_score")
    private Integer sleepScore;
    @JsonProperty("snoring")
    private Integer snoring;
    @JsonProperty("snoringepisodecount")
    private Integer snoringEpisodeCount;
    @JsonProperty("total_sleep_time")
    private Integer totalSleepTime;
    @JsonProperty("total_timeinbed")
    private Integer totalTimeInBed;
    @JsonProperty("wakeup_latency")
    private Integer wakeupLatency;
    @JsonProperty("wakeupcount")
    private Integer wakeupCount;
    @JsonProperty("wakeupduration")
    private Integer wakeupDuration;
    @JsonProperty("waso")
    private Integer waso;
}
