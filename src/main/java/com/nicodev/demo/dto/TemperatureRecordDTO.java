package com.nicodev.demo.dto;

import com.nicodev.demo.domain.model.TemperatureLog;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Registro manual de temperatura para un lote")
public class TemperatureRecordDTO {
    @Schema(description = "Temperatura registrada")
    private Double temperature;
    @Schema(description = "Tipo de registro de temperatura")
    private TemperatureLog.LogType type;
}

