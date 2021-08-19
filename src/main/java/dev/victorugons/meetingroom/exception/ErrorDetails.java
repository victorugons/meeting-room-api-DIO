package dev.victorugons.meetingroom.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
public class ErrorDetails {

    private String message;
    private Date timeStamp;
    private String details;

    public ErrorDetails (String message, Date timeStamp, String details) {
        super();
        this.message = message;
        this.timeStamp = timeStamp;
        this.details = details;
    }

}
