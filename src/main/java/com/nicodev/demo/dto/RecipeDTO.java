package com.nicodev.demo.dto;

import java.util.List;

import com.nicodev.demo.domain.model.Recipe;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "DTO para crear o actualizar una receta de yogurt")
public class RecipeDTO {
    @Schema(description = "Nombre de la receta", example = "Yogurt Natural")
    private String name;
    @Schema(description = "Descripción de la receta", example = "Receta para hacer yogur natural")
    private String description;
    @Schema(description = "Volumen predeterminado de leche", example = "10.0")
    private Double defaultMilkVolume;
    @Schema(description = "Cantidad predeterminada de starter", example = "0.5")
    private Double defaultStarterAmount;
    @Schema(description = "Temperatura de calentamiento", example = "85.0")
    private Double heatingTemperature;
    @Schema(description = "Duración del calentamiento", example = "15")
    private Integer heatingDuration;
    @Schema(description = "Temperatura de inoculación", example = "45.0")
    private Double inoculationTemperature;
    @Schema(description = "Temperatura de incubación", example = "40.0")
    private Double incubationTemperature;
    @Schema(description = "Tiempo mínimo de incubación", example = "60")
    private Integer minIncubationTime;
    @Schema(description = "Tiempo máximo de incubación", example = "120")
    private Integer maxIncubationTime;
    @Schema(description = "Tiempo de refrigeración", example = "24")
    private Integer refrigerationTime;
    @Schema(description = "Nivel de dificultad", example = "MEDIUM")
    private Recipe.DifficultyLevel difficulty;
    @Schema(description = "Consejos para la preparación", example = "Asegúrate de mantener una temperatura constante durante todo el proceso.")
    private String tips;
    @Schema(description = "Lista de ingredientes necesarios para la receta")
    private List<IngredientDTO> ingredients;
}