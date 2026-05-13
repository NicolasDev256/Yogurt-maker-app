package com.nicodev.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

public class BatchDTO {
    
    @Data
    @Schema(description = "Solicitud para iniciar un nuevo lote")
    public static class StartBatchRequest {
        @Schema(description = "ID de la receta a utilizar. Debe existir y estar activa.", 
                example = "1", 
                requiredMode = Schema.RequiredMode.REQUIRED)
        private Long recipeId;
        @Schema(description = "Volumen personalizado de leche.", 
                example = "10.0")
        private Double customMilkVolume;
        @Schema(description = "Cantidad personalizada de starter.", 
                example = "0.5")
        private Double customStarterAmount;
    }
    
    @Data
    @Schema(description = "Solicitud para marcar un lote como fallido")
    public static class FailRequest {
        @Schema(description = "Motivo del fallo del lote.", 
                example = "Error en el proceso de incubación")
        private String reason;
    }
}
