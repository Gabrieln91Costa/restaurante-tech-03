package br.com.restaurante.restaurante.useCases;

import br.com.restaurante.restaurante.entities.Mesa;
import br.com.restaurante.restaurante.repositories.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultarMesasUseCase {

    @Autowired
    private MesaRepository mesaRepository;

    
    public List<Mesa> consultarMesas(Integer restauranteId) {
        
        return mesaRepository.findAllByRestauranteId(restauranteId);
    }
}
