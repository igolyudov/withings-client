package ml.bigbrains.withings.model;

import lombok.Data;

@Data
public class GenericResponse {
    protected Integer status;
    protected String error;
}
