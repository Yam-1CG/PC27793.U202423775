package com.medisupply.platform.u202423775.procurement.application.commands;

import com.medisupply.platform.u202423775.procurement.domain.model.valueobjects.SupplyRequestStatus;

import java.time.LocalDate;
import java.util.UUID;

public record CreateSupplyRequestCommand(
        String requestCode,
        UUID facilityId,
        LocalDate fulfillmentPeriodStartDate,
        LocalDate fulfillmentPeriodEndDate,
        Integer supplyBatchQuantity,
        String supplyBatchUnit,
        Integer urgencyLevel,
        SupplyRequestStatus status,
        String requestNotes
) {

    public CreateSupplyRequestCommand {

        if (requestCode == null || requestCode.isBlank()) {
            throw new IllegalArgumentException(
                    "Request code is required"
            );
        }

        if (facilityId == null) {
            throw new IllegalArgumentException(
                    "Facility ID is required"
            );
        }

        if (fulfillmentPeriodStartDate == null
                || fulfillmentPeriodEndDate == null) {
            throw new IllegalArgumentException(
                    "Fulfillment period dates are required"
            );
        }

        if (!fulfillmentPeriodEndDate.isAfter(
                fulfillmentPeriodStartDate)) {
            throw new IllegalArgumentException(
                    "End date must be after start date"
            );
        }

        if (supplyBatchQuantity == null
                || supplyBatchQuantity <= 0) {
            throw new IllegalArgumentException(
                    "Supply batch quantity must be positive"
            );
        }

        if (supplyBatchUnit == null
                || supplyBatchUnit.isBlank()) {
            throw new IllegalArgumentException(
                    "Supply batch unit is required"
            );
        }

        if (urgencyLevel == null
                || urgencyLevel < 1
                || urgencyLevel > 5) {
            throw new IllegalArgumentException(
                    "Urgency level must be between 1 and 5"
            );
        }

        if (status == null) {
            throw new IllegalArgumentException(
                    "Status cannot be null"
            );
        }
    }
}
