package com.example.ubersocketserver.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DriverResponseDto {
    private String bookingId;
    private String driverId;
    private String status; // ACCEPTED / REJECTED
}
