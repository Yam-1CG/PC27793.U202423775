package com.medisupply.platform.u202423775.procurement.domain.repositories;

import com.medisupply.platform.u202423775.procurement.domain.model.aggregates.SupplyRequest;
import com.medisupply.platform.u202423775.procurement.domain.model.valueobjects.RequestCode;

import java.util.Optional;

public interface SupplyRequestRepository {

    Optional<SupplyRequest> findById(Long id);

    Optional<SupplyRequest> findByRequestCode(RequestCode requestCode);

    boolean existsByRequestCode(RequestCode requestCode);

    SupplyRequest save(SupplyRequest supplyRequest);
}
