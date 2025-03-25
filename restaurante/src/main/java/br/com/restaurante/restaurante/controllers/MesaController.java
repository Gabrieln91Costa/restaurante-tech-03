package br.com.restaurante.restaurante.controllers;

import br.com.restaurante.restaurante.entities.Mesa;
import br.com.restaurante.restaurante.entities.StatusMesa;
import br.com.restaurante.restaurante.useCases.ConsultarMesasUseCase;
import br.com.restaurante.restaurante.useCases.AlterarStatusMesaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mesas")
public class MesaController {

    @Autowired
    private ConsultarMesasUseCase consultarMesasUseCase;

    @Autowired
    private AlterarStatusMesaUseCase alterarStatusMesaUseCase;

    
    @GetMapping("/restaurante/{restauranteId}")
    public List<Mesa> consultarMesas(@PathVariable Integer restauranteId) {
        return consultarMesasUseCase.consultarMesas(restauranteId);
    }

    
    @PutMapping("/{mesaId}/status")
    public ResponseEntity<Mesa> alterarStatusMesa(@PathVariable Integer mesaId, @RequestBody StatusMesa novoStatus) {
        
        Mesa mesaAtualizada = alterarStatusMesaUseCase.alterarStatusMesa(mesaId, novoStatus);

        if (mesaAtualizada != null) {
            return ResponseEntity.ok(mesaAtualizada);
        }

        return ResponseEntity.notFound().build();
    }
}
