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
    private Long passengerId;
//    private ExactLocation startLocation;
//    private ExactLocation endLocation ;
    private List<String> driverIds;
}
