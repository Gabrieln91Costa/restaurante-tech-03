package br.com.restaurante.restaurante.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class RestauranteTest {

    private Restaurante restaurante;

    @BeforeEach
    void setUp() {
        
        restaurante = new Restaurante();
    }

    @Test
    void testSetAndGetId() {
        
        restaurante.setId(1);
        assertEquals(1, restaurante.getId());
    }

    @Test
    void testSetAndGetNome() {
        
        restaurante.setNome("Restaurante Teste");
        assertEquals("Restaurante Teste", restaurante.getNome());
    }

    @Test
    void testSetAndGetQuantidadeMesas() {
        
        restaurante.setQuantidadeMesas(10);
        assertEquals(10, restaurante.getQuantidadeMesas());
    }

    @Test
    void testSetAndGetMesas() {
        
        List<Mesa> mesas = new ArrayList<>();
        Mesa mesa = new Mesa();
        mesa.setTag("Mesa-1");
        mesa.setRestaurante(restaurante);  
        mesas.add(mesa);
        
        restaurante.setMesas(mesas);
        
        assertNotNull(restaurante.getMesas());
        assertEquals(1, restaurante.getMesas().size());
        assertEquals("Mesa-1", restaurante.getMesas().get(0).getTag());
        assertEquals(restaurante, restaurante.getMesas().get(0).getRestaurante());
    }

    @Test
    void testRestauranteConstructor() {
        
        List<Mesa> mesas = new ArrayList<>();
        Mesa mesa = new Mesa();
        mesa.setTag("Mesa-1");
        mesa.setRestaurante(restaurante);  
        mesas.add(mesa);

        Restaurante restauranteParametrizado = new Restaurante();
        restauranteParametrizado.setId(2);
        restauranteParametrizado.setNome("Restaurante A");
        restauranteParametrizado.setQuantidadeMesas(20);
        restauranteParametrizado.setMesas(mesas);

        assertEquals(2, restauranteParametrizado.getId());
        assertEquals("Restaurante A", restauranteParametrizado.getNome());
        assertEquals(20, restauranteParametrizado.getQuantidadeMesas());
        assertEquals(1, restauranteParametrizado.getMesas().size());
        assertEquals("Mesa-1", restauranteParametrizado.getMesas().get(0).getTag());
    }
}
