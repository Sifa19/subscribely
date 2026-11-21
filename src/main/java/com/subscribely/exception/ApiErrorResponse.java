package com.subscribely.exception;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrorResponse{

    private LocalDateTime timestamp;
    private String message;
    private int status;
    private String error;

    private Map<String,String> validationErrors;

    public ApiErrorResponse(LocalDateTime timestamp, String message, int status, String error) {
        this.timestamp = timestamp;
        this.message = message;
        this.status = status;
        this.error = error;
    }

}