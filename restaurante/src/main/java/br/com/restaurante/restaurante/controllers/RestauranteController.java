package br.com.restaurante.restaurante.controllers;

import br.com.restaurante.restaurante.dto.RestauranteDTO;
import br.com.restaurante.restaurante.entities.Restaurante;
import br.com.restaurante.restaurante.useCases.CriarRestauranteUseCase;
import br.com.restaurante.restaurante.useCases.CriarMesasUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restaurantes")
public class RestauranteController {

    @Autowired
    private CriarRestauranteUseCase criarRestauranteUseCase;

    @Autowired
    private CriarMesasUseCase criarMesasUseCase;

    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurante criarRestaurante(@RequestBody RestauranteDTO restauranteDTO) {
        
        Restaurante restaurante = criarRestauranteUseCase.criarRestaurante(restauranteDTO);

        
        criarMesasUseCase.criarMesas(restaurante);

        return restaurante;
    }

    
    @GetMapping("/{id}")
    public Restaurante consultarRestaurante(@PathVariable Integer id) {
        
        return criarRestauranteUseCase.consultarRestaurante(id);
    }
}
