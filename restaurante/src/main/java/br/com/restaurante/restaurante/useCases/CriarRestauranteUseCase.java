package br.com.restaurante.restaurante.useCases;

import br.com.restaurante.restaurante.dto.RestauranteDTO;
import br.com.restaurante.restaurante.entities.Restaurante;
import br.com.restaurante.restaurante.repositories.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarRestauranteUseCase {

    @Autowired
    private RestauranteRepository restauranteRepository;

    
    public Restaurante criarRestaurante(RestauranteDTO restauranteDTO) {
        
        Restaurante restaurante = new Restaurante();
        restaurante.setNome(restauranteDTO.getNome());
        restaurante.setQuantidadeMesas(restauranteDTO.getQuantidadeMesas());

        
        return restauranteRepository.save(restaurante);
    }

    
    public Restaurante consultarRestaurante(Integer id) {
        return restauranteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurante não encontrado"));
    }
}
