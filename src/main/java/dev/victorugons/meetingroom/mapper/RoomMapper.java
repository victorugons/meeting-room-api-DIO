package dev.victorugons.meetingroom.mapper;

import dev.victorugons.meetingroom.model.Room;
import dev.victorugons.meetingroom.model.dto.RoomDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RoomMapper {

    public Room toEntity (RoomDTO roomDTO) {
        Room room = new Room();

        room.setId(roomDTO.getId());
        room.setName(roomDTO.getName());
        room.setDate(roomDTO.getDate());
        room.setStartHour(roomDTO.getStartHour());
        room.setEndHour(roomDTO.getEndHour());

        return room;
    }

    public RoomDTO toDTO (Room room) {
        RoomDTO roomDTO = new RoomDTO();

        roomDTO.setId(room.getId());
        roomDTO.setName(room.getName());
        roomDTO.setDate(room.getDate());
        roomDTO.setStartHour(room.getStartHour());
        roomDTO.setEndHour(room.getEndHour());

        return roomDTO;
    }

    public List<RoomDTO> toDTO (List<Room> rooms) {
        return rooms.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
