package com.medisupply.platform.u202423775.procurement.domain.model.valueobjects;

public record RequestCode(String code) {

    public RequestCode {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException(
                    "Request code cannot be null or blank"
            );
        }
    }
}
