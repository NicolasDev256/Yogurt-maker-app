package com.nicodev.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO para ingredientes de una receta")
public class IngredientDTO {
    @Schema(description = "Nombre del ingrediente")
    private String name;
    @Schema(description = "Cantidad del ingrediente")
    private Double quantity;
    @Schema(description = "Unidad de medida")
    private String unit;
    @Schema(description = "Notas sobre el ingrediente")
    private String notes;
        private Boolean optional;
}
