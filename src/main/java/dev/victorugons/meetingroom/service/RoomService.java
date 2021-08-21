package dev.victorugons.meetingroom.service;

import dev.victorugons.meetingroom.exception.ResourceNotFoundException;
import dev.victorugons.meetingroom.mapper.RoomMapper;
import dev.victorugons.meetingroom.model.Room;
import dev.victorugons.meetingroom.model.dto.RoomDTO;
import dev.victorugons.meetingroom.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    private RoomRepository repository;

    private RoomMapper mapper;

    @Autowired
    public RoomService(RoomRepository repository, RoomMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public RoomDTO create(RoomDTO roomDTO) {
        Room room = mapper.toEntity(roomDTO);
        repository.save(room);
        return mapper.toDTO(room);
    }

    public RoomDTO update(RoomDTO roomDTO) {
        this.findById(roomDTO.getId());
        Room room = mapper.toEntity(roomDTO);
        repository.save(room);
        return mapper.toDTO(room);
    }

    public List<RoomDTO> findAll() {
        return mapper.toDTO(repository.findAll());
    }

    public RoomDTO findById(long id) {
        return repository.findById(id).map(mapper::toDTO).orElseThrow(() -> new ResourceNotFoundException("Resource id "+id+" not found."));
    }

    public void delete(long id) {
        RoomDTO roomDTO = this.findById(id);
        repository.deleteById(roomDTO.getId());
    }
}
