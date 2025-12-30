package com.example.ubersocketserver.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DriverResponseDto {
    private Long bookingId;
    private Long driverId;
    private String status; // ACCEPTED / REJECTED
}
