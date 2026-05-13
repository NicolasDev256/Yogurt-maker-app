package com.nicodev.demo.domain.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nicodev.demo.domain.model.Recipe;
import com.nicodev.demo.domain.service.RecipeService;
import com.nicodev.demo.dto.RecipeDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/recipes")
@RequiredArgsConstructor
@Tag(name = "Recetas", description = "Gestion de recetas de yogurt - CRUD, búsqueda y activacio n/desactivacion")
public class RecipeController {
    
    private final RecipeService recipeService;
    
    @PostMapping
    @Operation(summary = "Crear nueva receta", 
           description = "Registra una nueva receta con ingredientes y parametros")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Receta creada exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos o nombre de receta duplicado")
    })       
    public ResponseEntity<Recipe> createRecipe(@RequestBody RecipeDTO recipeDTO) {
        Recipe recipe = recipeService.createRecipe(recipeDTO);
        return new ResponseEntity<>(recipe, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar receta", 
           description = "Modifica una receta existente por su ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Receta actualizada exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos"),
        @ApiResponse(responseCode = "404", description = "Receta no encontrada con el ID proporcionado")
    })       
    public ResponseEntity<Recipe> updateRecipe(@PathVariable Long id, @RequestBody RecipeDTO recipeDTO) {
        Recipe recipe = recipeService.updateRecipe(id, recipeDTO);
        return ResponseEntity.ok(recipe);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Obtener receta por ID", 
           description = "Devuelve los detalles completos de una receta")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Receta encontrada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Receta no encontrada con el ID proporcionado")
    })       
    public ResponseEntity<Recipe> getRecipe(@PathVariable Long id) {
        Recipe recipe = recipeService.getRecipe(id);
        return ResponseEntity.ok(recipe);
    }
    
    @GetMapping
    @Operation(summary = "Listar recetas activas", 
           description = "Obtiene todas las recetas que están actualmente activas")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de recetas obtenida exitosamente")
    })
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        return ResponseEntity.ok(recipeService.getAllActiveRecipes());
    }
    
    @GetMapping("/search")
    @Operation(summary = "Buscar recetas", 
           description = "Busca recetas por palabra clave")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Resultados de búsqueda obtenidos exitosamente")
    })
    public ResponseEntity<List<Recipe>> searchRecipes(@RequestParam String keyword) {
        return ResponseEntity.ok(recipeService.searchRecipes(keyword));
    }
    
    @PatchMapping("/{id}/deactivate")
    @Operation(summary = "Desactivar receta", 
           description = "Desactiva una receta para que no pueda usarse en nuevos lotes")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Receta desactivada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Receta no encontrada con el ID proporcionado")
    })
    public ResponseEntity<Void> deactivateRecipe(@PathVariable Long id) {
        recipeService.deactivateRecipe(id);
        return ResponseEntity.ok().build();
    }
    
    @PatchMapping("/{id}/activate")
    @Operation(summary = "Activar receta", 
           description = "Activa una receta para que pueda usarse en nuevos lotes")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Receta activada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Receta no encontrada con el ID proporcionado")
    })
    public ResponseEntity<Void> activateRecipe(@PathVariable Long id) {
        recipeService.activateRecipe(id);
        return ResponseEntity.ok().build();
    }
}
