package br.com.restaurante.restaurante.useCases;

import br.com.restaurante.restaurante.entities.Mesa;
import br.com.restaurante.restaurante.entities.Restaurante;
import br.com.restaurante.restaurante.entities.StatusMesa;  
import br.com.restaurante.restaurante.repositories.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CriarMesasUseCase {

    @Autowired
    private MesaRepository mesaRepository;

    
    public List<Mesa> criarMesas(Restaurante restaurante) {
        List<Mesa> mesas = new ArrayList<>();

        
        for (int i = 1; i <= restaurante.getQuantidadeMesas(); i++) {
            Mesa mesa = new Mesa();
            mesa.setRestaurante(restaurante);
            mesa.setTag("Mesa-" + i);  
            mesa.setStatus(StatusMesa.ATIVO);  
            mesas.add(mesa);
        }

        
        return mesaRepository.saveAll(mesas);
    }
}
