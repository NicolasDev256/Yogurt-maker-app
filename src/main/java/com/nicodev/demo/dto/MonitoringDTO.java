package com.nicodev.demo.dto;

import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

public class MonitoringDTO {
    
    @Data
    @Builder
    @Schema(description = "Resumen de temperaturas de un lote")
    public static class TemperatureSummary {
        @Schema(description = "Temperatura actual")
        private Double currentTemperature;
        @Schema(description = "Temperatura máxima")
        private Double maximumTemperature;
        @Schema(description = "Temperatura mínima")
        private Double minimumTemperature;
        @Schema(description = "Temperatura promedio")
        private Double averageTemperature;
    }
    
    @Data
    @Builder
    @Schema(description = "Panel de control para el monitoreo")
    public static class Dashboard {
        @Schema(description = "Recuento de lotes por estado")
        private Map<String, Long> batchCounts;
        @Schema(description = "Recuento de lotes activos")
        private Long activeBatchesCount;
        @Schema(description = "Lotes completados hoy")
        private Integer completedToday;
    }
}
