package com.medisupply.platform.u202423775.procurement.domain.model.valueobjects;

import java.time.LocalDate;

public record FulfillmentPeriod(
        LocalDate startDate,
        LocalDate endDate
) {

    public FulfillmentPeriod {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException(
                    "Start date and end date cannot be null"
            );
        }

        if (!endDate.isAfter(startDate)) {
            throw new IllegalArgumentException(
                    "End date must be after start date"
            );
        }
    }

    public boolean contains(LocalDate checkDate) {
        if (checkDate == null) {
            throw new IllegalArgumentException(
                    "Check date cannot be null"
            );
        }

        return !checkDate.isBefore(startDate)
                && !checkDate.isAfter(endDate);
    }
}
