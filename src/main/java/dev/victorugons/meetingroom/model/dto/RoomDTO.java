package dev.victorugons.meetingroom.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RoomDTO {

    @Schema(example = "1")
    private long id;
    @Schema(example = "RoomName")
    @NotNull
    private String name;
    @Schema(example = "01/01/2000")
    @NotNull
    private String date;
    @Schema(example = "00:00")
    @NotNull
    private String startHour;
    @Schema(example = "00:00")
    @NotNull
    private String endHour;
}
