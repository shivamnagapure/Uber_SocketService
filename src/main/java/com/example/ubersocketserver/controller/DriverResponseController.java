package com.example.ubersocketserver.controller;

import com.example.ubersocketserver.dto.DriverResponseDto;
import com.example.ubersocketserver.services.BookingRestClient;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DriverResponseController {

    private final SimpMessagingTemplate simpMessagingTemplate ;

    private final BookingRestClient bookingRestClient ;

    public DriverResponseController(SimpMessagingTemplate simpMessagingTemplate,
                                   BookingRestClient bookingRestClient ){
        this.bookingRestClient = bookingRestClient ;
        this.simpMessagingTemplate = simpMessagingTemplate ;
    }

    @MessageMapping("/driver/response")
    public void handleDriverResponse(DriverResponseDto response){

        //Notify booking service about driver response
        bookingRestClient.sendDriverResponseToBooking(response);

        // (Optional) Notify passenger over websocket
        //messagingTemplate.convertAndSend("/topic/driverResponse", response);
    }

}


