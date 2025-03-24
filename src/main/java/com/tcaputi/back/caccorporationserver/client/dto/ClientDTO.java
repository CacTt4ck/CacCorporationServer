package com.tcaputi.back.caccorporationserver.client.dto;

import java.util.UUID;

public record ClientDTO(UUID id, String name, String email, String phone, String address, String city, String state, String zip) {
}
