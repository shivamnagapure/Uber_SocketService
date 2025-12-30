package com.example.ubersocketserver.controller;

import com.example.ubersocketserver.dto.DriverAssignedEvent;
import com.example.ubersocketserver.dto.RideRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/socket")
public class DriverRequestController {

    private final SimpMessagingTemplate simpMessagingTemplate ;

    public DriverRequestController(SimpMessagingTemplate simpMessagingTemplate){
        this.simpMessagingTemplate = simpMessagingTemplate ;
    }

    @PostMapping("/newride")
    @CrossOrigin(originPatterns = "*")
    public ResponseEntity<Boolean> raiseRideRequest(@RequestBody RideRequestDto requestDto) {
        System.out.println("request for rides received");
        System.out.println(requestDto.getPassengerId());
        requestDto.getNearbyDrivers().forEach(System.out::print);
        sendBookingToDrivers(requestDto);
        System.out.println("Req completed");
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

    public void sendBookingToDrivers(RideRequestDto requestDto){
        System.out.println("Executed periodic function");
        // TODO: Ideally the request should only go to nearby drivers, but for simplicity we send it everyone
        simpMessagingTemplate.convertAndSend("/topic/rideRequest", requestDto);
    }

    @PostMapping("/notify-driver-assigned")
    public void notifyPassenger(@RequestBody DriverAssignedEvent event) {

        System.out.println("Notifying passenger about driver assignment...");

        simpMessagingTemplate.convertAndSend(
                "/topic/driverAssigned/" + event.getPassengerId(),
                event
        );
    }
}
