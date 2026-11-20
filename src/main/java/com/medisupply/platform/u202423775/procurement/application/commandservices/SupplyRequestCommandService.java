package com.medisupply.platform.u202423775.procurement.application.commandservices;

import com.medisupply.platform.u202423775.procurement.application.commands.CreateSupplyRequestCommand;
import com.medisupply.platform.u202423775.procurement.domain.model.aggregates.SupplyRequest;
import com.medisupply.platform.u202423775.shared.application.result.ApplicationError;
import com.medisupply.platform.u202423775.shared.application.result.Result;

public interface SupplyRequestCommandService {

    Result<SupplyRequest, ApplicationError> handle(
            CreateSupplyRequestCommand command
    );
}
