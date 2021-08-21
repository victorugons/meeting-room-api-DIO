package dev.victorugons.meetingroom.controller;

import dev.victorugons.meetingroom.exception.ErrorDetails;
import dev.victorugons.meetingroom.model.dto.RoomDTO;
import dev.victorugons.meetingroom.service.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/rooms")
@Tag(name = "rooms", description = "Rooms operations.")
public class RoomController {

    public RoomService service;

    @Autowired
    public RoomController(RoomService service) {
        this.service = service;
    }


    @Operation(summary = "Creates a new room.",
            description = "Creates a new room.",
            tags = {"rooms"},
            operationId = "create")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Room successfully created.",
                            content = @Content(
                                            schema = @Schema(
                                                    implementation = RoomDTO.class
                                    )
                            ))
            })
    @PostMapping
    public ResponseEntity<RoomDTO> create(@Valid @RequestBody RoomDTO roomDTO) {
        return ResponseEntity.ok(service.create(roomDTO));
    }

    @Operation(summary = "Updates an existing room.",
            description = "Updates an existing room.",
            tags = {"rooms"},
            operationId = "update")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Room successfully updated.",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = RoomDTO.class
                                    )
                            ))
            })
    @PutMapping
    public ResponseEntity<RoomDTO> update(@Valid @RequestBody RoomDTO roomDTO) {
        return ResponseEntity.ok(service.update(roomDTO));
    }

    @Operation(summary = "Returns a list of current rooms.",
            description = "Returns a list of current rooms.",
            tags = {"rooms"},
            operationId = "findAll")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Returned a list of current rooms.",
                            content = @Content(
                                    array = @ArraySchema(
                                            schema = @Schema(
                                                    implementation = RoomDTO.class
                                            )
                                    )
                            ))
                    })
    @GetMapping
    public ResponseEntity<List<RoomDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Operation(summary = "Returns an existing room with the specified id.",
            description = "Returns an existing room with the specified id.",
            tags = {"rooms"},
            operationId = "findById")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully returned the room with the specified id.",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = RoomDTO.class
                                    )
                            )),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Room with specified id not found.",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = ErrorDetails.class
                                    )
                            ))
            })
    @GetMapping("/{id}")
    public ResponseEntity<RoomDTO> findById(@PathVariable long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Operation(summary = "Deletes an existing room.",
            description = "Deletes an existing room.",
            tags = {"rooms"},
            operationId = "delete")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Room successfully deleted."
                           ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Room with specified id not found.",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = ErrorDetails.class
                                    )
                            ))
            })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
