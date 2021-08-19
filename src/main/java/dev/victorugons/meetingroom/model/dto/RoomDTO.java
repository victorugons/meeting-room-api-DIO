package dev.victorugons.meetingroom.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RoomDTO {

    private long id;
    @NotNull
    private String name;
    @NotNull
    private String date;
    @NotNull
    private String startHour;
    @NotNull
    private String endHour;
}
