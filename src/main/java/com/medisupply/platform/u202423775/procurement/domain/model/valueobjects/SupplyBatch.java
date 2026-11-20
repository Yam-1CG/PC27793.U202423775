package com.medisupply.platform.u202423775.procurement.domain.model.valueobjects;

public record SupplyBatch(
        Integer quantity,
        String unit
) {

    public SupplyBatch {
        if (quantity == null || quantity <= 0) {
            throw new IllegalArgumentException(
                    "Quantity must be greater than zero"
            );
        }

        if (unit == null || unit.isBlank()) {
            throw new IllegalArgumentException(
                    "Unit cannot be null or blank"
            );
        }
    }

    public SupplyBatch addUnits(Integer additionalQuantity) {
        if (additionalQuantity == null || additionalQuantity <= 0) {
            throw new IllegalArgumentException(
                    "Additional quantity must be positive"
            );
        }

        long total = (long) quantity + additionalQuantity;

        if (total > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(
                    "Quantity exceeds maximum integer value"
            );
        }

        return new SupplyBatch((int) total, unit);
    }
}
