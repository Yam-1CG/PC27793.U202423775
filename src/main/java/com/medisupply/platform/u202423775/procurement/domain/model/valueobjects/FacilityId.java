package com.medisupply.platform.u202423775.procurement.domain.model.valueobjects;

import java.util.UUID;

public record FacilityId(UUID value) {

    public FacilityId {
        if (value == null) {
            throw new IllegalArgumentException(
                    "Facility ID cannot be null"
            );
        }
    }
}
