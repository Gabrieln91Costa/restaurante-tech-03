package br.com.restaurante.restaurante.useCases;

import br.com.restaurante.restaurante.entities.Mesa;
import br.com.restaurante.restaurante.entities.StatusMesa;  
import br.com.restaurante.restaurante.repositories.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlterarStatusMesaUseCase {

    @Autowired
    private MesaRepository mesaRepository;

    
    public Mesa alterarStatusMesa(Integer mesaId, StatusMesa novoStatus) {
        
        Optional<Mesa> mesaOptional = mesaRepository.findById(mesaId);
        
        if (mesaOptional.isPresent()) {
            Mesa mesa = mesaOptional.get();  
            
            
            mesa.setStatus(novoStatus);
            
            
            return mesaRepository.save(mesa);
        }
        
        
        return null; 
    }
}
