package com.example.ubersocketserver.services;

import com.example.ubersocketserver.dto.DriverResponseDto;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class BookingRestClient {

    private final WebClient webClient ;

    public BookingRestClient(@LoadBalanced WebClient.Builder builder){
        this.webClient = builder.baseUrl("http://UberBookingService").build() ;
    }

    public void sendDriverResponseToBooking(DriverResponseDto response){
        System.out.println("Sending response to Booking Service...");

        webClient.post()
                .uri("/api/va/booking/driver-response")
                .bodyValue(response)
                .retrieve() //Executes the request and prepares to read the response.
                .bodyToMono(Void.class) // we expect no body in the response and converting  the response to a Mono<Void>.
                .subscribe(); //executes the REST call asynchronously.
    }
}
