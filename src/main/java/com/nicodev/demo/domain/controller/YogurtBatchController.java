package com.nicodev.demo.domain.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nicodev.demo.domain.model.YogurtBatch;
import com.nicodev.demo.domain.service.YogurtMakingService;
import com.nicodev.demo.dto.BatchDTO;
import com.nicodev.demo.dto.TemperatureRecordDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/batches")
@RequiredArgsConstructor
@Tag (name = "Lotes de Yogurt", description = "Gestion de producción de lotes - crear lotes, control de temperaturas y cambios de estado")
public class YogurtBatchController {
    
    private final YogurtMakingService yogurtMakingService;
    
    @PostMapping
    @Operation(summary = "Iniciar nuevo lote", 
           description = "Crea un nuevo lote usando una receta existente")    
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Lote creado exitosamente"),
        @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    public ResponseEntity<YogurtBatch> startNewBatch(@RequestBody BatchDTO.StartBatchRequest request) {
        YogurtBatch batch = yogurtMakingService.startNewBatch(
            request.getRecipeId(), 
            request.getCustomMilkVolume(), 
            request.getCustomStarterAmount()
        );
        return new ResponseEntity<>(batch, HttpStatus.CREATED);
    }
    
    @PostMapping("/{batchId}/heating")
    @Operation(summary = "Iniciar proceso de calentamiento", 
           description = "Inicia el proceso de calentamiento para un lote específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Proceso de calentamiento iniciado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Lote no encontrado con el ID proporcionado")
    })
    public ResponseEntity<YogurtBatch> startHeating(@PathVariable Long batchId) {
        YogurtBatch batch = yogurtMakingService.startHeating(batchId);
        return ResponseEntity.ok(batch);
    }
    
    @PostMapping("/{batchId}/inoculating")
    @Operation(summary = "Iniciar inoculación", 
           description = "Añade el cultivo iniciador a la leche enfriada")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Inoculación iniciada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Lote no encontrado con el ID proporcionado")
    })
    public ResponseEntity<YogurtBatch> startInoculating(@PathVariable Long batchId) {
        YogurtBatch batch = yogurtMakingService.startInoculating(batchId);
        return ResponseEntity.ok(batch);
    }
    
    @PostMapping("/{batchId}/incubation")
    @Operation(summary = "Iniciar incubación", 
           description = "Comienza el período de fermentación controlada")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Incubación iniciada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Lote no encontrado con el ID proporcionado")
    })
    public ResponseEntity<YogurtBatch> startIncubation(@PathVariable Long batchId) {
        YogurtBatch batch = yogurtMakingService.startIncubation(batchId);
        return ResponseEntity.ok(batch);
    }
    
    @PostMapping("/{batchId}/refrigeration")
    @Operation(summary = "Iniciar refrigeración", 
           description = "Comienza el proceso de refrigeración para un lote específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Refrigeración iniciada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Lote no encontrado con el ID proporcionado")
    })
    public ResponseEntity<YogurtBatch> startRefrigeration(@PathVariable Long batchId) {
        YogurtBatch batch = yogurtMakingService.startRefrigeration(batchId);
        return ResponseEntity.ok(batch);
    }
    
    @PostMapping("/{batchId}/complete")
    @Operation(summary = "Completar lote", 
           description = "Marca un lote como completado")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lote completado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Lote no encontrado con el ID proporcionado")
    })
    public ResponseEntity<YogurtBatch> completeBatch(@PathVariable Long batchId) {
        YogurtBatch batch = yogurtMakingService.completeBatch(batchId);
        return ResponseEntity.ok(batch);
    }
    
    @PostMapping("/{batchId}/fail")
    @Operation(summary = "Marcar como fallido", 
           description = "Marca un lote como fallido con una razón específica")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lote marcado como fallido exitosamente"),
        @ApiResponse(responseCode = "404", description = "Lote no encontrado con el ID proporcionado")
    })
    public ResponseEntity<YogurtBatch> markAsFailed(
            @PathVariable Long batchId, 
            @RequestBody BatchDTO.FailRequest request) {
        YogurtBatch batch = yogurtMakingService.markAsFailed(batchId, request.getReason());
        return ResponseEntity.ok(batch);
    }
    
    @GetMapping
    @Operation(summary = "Obtener todos los lotes", 
           description = "Devuelve una lista de todos los lotes de yogur")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de lotes obtenida exitosamente")
    })
    public ResponseEntity<List<YogurtBatch>> getAllBatches(
            @RequestParam(required = false) YogurtBatch.BatchStatus status) {
        if (status != null) {
            return ResponseEntity.ok(yogurtMakingService.getBatchesByStatus(status));
        }
        return ResponseEntity.ok(yogurtMakingService.getAllBatches());
    }
    
    @GetMapping("/{batchId}")
    @Operation(summary = "Obtener lote específico", 
           description = "Devuelve información detallada de un lote de yogur")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lote encontrado exitosamente"),
        @ApiResponse(responseCode = "404", description = "Lote no encontrado con el ID proporcionado")
    })
    public ResponseEntity<YogurtBatch> getBatch(@PathVariable Long batchId) {
        YogurtBatch batch = yogurtMakingService.getBatch(batchId);
        return ResponseEntity.ok(batch);
    }
    
    @PostMapping("/{batchId}/temperature")
    @Operation(summary = "Registrar temperatura", 
           description = "Añade un registro de temperatura para un lote específico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Temperatura registrada exitosamente"),
        @ApiResponse(responseCode = "404", description = "Lote no encontrado con el ID proporcionado")
    })
    public ResponseEntity<Void> recordTemperature(
            @PathVariable Long batchId, 
            @RequestBody TemperatureRecordDTO request) {
        yogurtMakingService.recordTemperature(batchId, request.getTemperature(), request.getType());
        return ResponseEntity.ok().build();
    }
}
