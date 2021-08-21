package dev.victorugons.meetingroom.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
public class ErrorDetails {

    @Schema(example = "Resource id 1 not found.")
    private String message;
    @Schema(example = "2001-01-01T00:00:00.000+00:00")
    private Date timeStamp;
    @Schema(example = "uri=/api/v1/rooms/1")
    private String details;

    public ErrorDetails (String message, Date timeStamp, String details) {
        super();
        this.message = message;
        this.timeStamp = timeStamp;
        this.details = details;
    }

}
