package com.example.ubersocketserver.dto;

import com.example.ubersocketserver.Models.ExactLocation;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RideRequestDto {
    private String bookingId;
    private String passengerId;
    private double pickupLat;
    private double pickupLng;
    private List<DriverLocationDto> nearbyDrivers;
}
