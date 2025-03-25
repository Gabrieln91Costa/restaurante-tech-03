package br.com.restaurante.restaurante.repositories;

import br.com.restaurante.restaurante.entities.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Integer> {
    
    List<Mesa> findAllByRestauranteId(Integer restauranteId);
}
