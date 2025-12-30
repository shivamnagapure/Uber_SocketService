package com.example.ubersocketserver.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DriverAssignedEvent {
    private String bookingId;
    private String passengerId;
    private String driverId;
}

