@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    
    @Autowired
    private VehiculoService vehiculoService;
    
    // LISTAR (El que ya tienes)
    @GetMapping
    public ArrayList<VehiculoModel> getAutos(){
        return this.vehiculoService.getVehiculos();
    }

    // GUARDAR (Para solucionar el error 405 en Postman)
    @PostMapping
    public ResponseEntity<VehiculoModel> guardarVehiculo(@RequestBody VehiculoModel vehiculo) {
        VehiculoModel nuevo = this.vehiculoService.saveVehiculo(vehiculo);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    // ELIMINAR
    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.vehiculoService.deleteVehiculo(id);
        if (ok) {
            return "Vehículo eliminado con éxito";
        } else {
            return "No se pudo eliminar el vehículo";
        }
    }
}
