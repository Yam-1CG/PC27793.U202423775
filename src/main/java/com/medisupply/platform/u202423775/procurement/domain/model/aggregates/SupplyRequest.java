package com.medisupply.platform.u202423775.procurement.domain.model.aggregates;

import com.medisupply.platform.u202423775.procurement.domain.model.valueobjects.*;
import com.medisupply.platform.u202423775.shared.domain.model.aggregates.AbstractDomainAggregateRoot;

import java.time.Instant;

public class SupplyRequest
        extends AbstractDomainAggregateRoot<SupplyRequest> {

    private Long id;

    private final RequestCode requestCode;
    private final FacilityId facilityId;
    private final FulfillmentPeriod fulfillmentPeriod;
    private final SupplyBatch supplyBatch;
    private final Integer urgencyLevel;
    private final SupplyRequestStatus status;
    private final String requestNotes;

    private final Instant createdAt;
    private final Instant updatedAt;

    public SupplyRequest(
            RequestCode requestCode,
            FacilityId facilityId,
            FulfillmentPeriod fulfillmentPeriod,
            SupplyBatch supplyBatch,
            Integer urgencyLevel,
            SupplyRequestStatus status,
            String requestNotes
    ) {

        if (requestCode == null
                || facilityId == null
                || fulfillmentPeriod == null
                || supplyBatch == null) {
            throw new IllegalArgumentException(
                    "Required fields cannot be null"
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

        this.requestCode = requestCode;
        this.facilityId = facilityId;
        this.fulfillmentPeriod = fulfillmentPeriod;
        this.supplyBatch = supplyBatch;
        this.urgencyLevel = urgencyLevel;
        this.status = status;
        this.requestNotes = requestNotes;

        this.createdAt = Instant.now();
        this.updatedAt = this.createdAt;
    }

    public Long getId() {
        return id;
    }

    public RequestCode getRequestCode() {
        return requestCode;
    }

    public FacilityId getFacilityId() {
        return facilityId;
    }

    public FulfillmentPeriod getFulfillmentPeriod() {
        return fulfillmentPeriod;
    }

    public SupplyBatch getSupplyBatch() {
        return supplyBatch;
    }

    public Integer getUrgencyLevel() {
        return urgencyLevel;
    }

    public SupplyRequestStatus getStatus() {
        return status;
    }

    public String getRequestNotes() {
        return requestNotes;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
