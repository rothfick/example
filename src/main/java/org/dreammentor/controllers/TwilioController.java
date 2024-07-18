package org.dreammentor.controllers;

import org.dreammentor.services.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/video")
public class TwilioController {

    @Autowired
    private TwilioService twilioService;

    @Operation(summary = "Create a new video room")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Room created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping("/room")
    public ResponseEntity<?> createRoom(@RequestParam String roomName) {
        return ResponseEntity.ok(twilioService.createRoom(roomName));
    }

    @Operation(summary = "Get details of a video room")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Room details retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Room not found")
    })
    @GetMapping("/room")
    public ResponseEntity<?> getRoom(@RequestParam String roomName) {
        return ResponseEntity.ok(twilioService.getRoom(roomName));
    }

    @Operation(summary = "Generate a token for video room access")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Token generated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping("/token")
    public ResponseEntity<?> generateToken(@RequestParam String identity, @RequestParam String roomName) {
        return ResponseEntity.ok(twilioService.generateToken(identity, roomName));
    }
}
