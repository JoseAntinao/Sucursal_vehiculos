package com.vehiculos.VehiculosRest.controllers;

import com.vehiculos.VehiculosRest.models.VehiculoModel;
import com.vehiculos.VehiculosRest.services.VehiculoService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    // ESTE YA FUNCIONA (GET)
    @GetMapping
    public ArrayList<VehiculoModel> getAutos(){
        return this.vehiculoService.getVehiculos();
    }

    // ESTE ES EL QUE ELIMINA EL ERROR 405 (POST)
    @PostMapping
    public ResponseEntity<VehiculoModel> guardarVehiculo(@RequestBody VehiculoModel vehiculo) {
        VehiculoModel nuevo = this.vehiculoService.saveVehiculo(vehiculo);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }
}
