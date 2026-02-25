package com.vehiculos.VehiculosRest.services;

import com.vehiculos.VehiculosRest.models.VehiculoModel;
import com.vehiculos.VehiculosRest.repositories.IVehiculoRepository; // Asegúrate de tener tu repo
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiculoService {

    @Autowired
    IVehiculoRepository vehiculoRepository;

    // Listar (Este ya lo tienes)
    public ArrayList<VehiculoModel> getVehiculos(){
        return (ArrayList<VehiculoModel>) vehiculoRepository.findAll();
    }

    // GUARDAR (¡ESTE ES EL QUE TE FALTA!)
    public VehiculoModel saveVehiculo(VehiculoModel vehiculo){
        return vehiculoRepository.save(vehiculo);
    }
    
    // ELIMINAR (Opcional, pero recomendado)
    public boolean deleteVehiculo(Long id) {
        try {
            vehiculoRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
