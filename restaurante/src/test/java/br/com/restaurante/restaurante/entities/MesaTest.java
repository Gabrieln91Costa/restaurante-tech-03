package br.com.restaurante.restaurante.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MesaTest {

    private Mesa mesa;
    private Restaurante restaurante;

    @BeforeEach
    void setUp() {
        
        mesa = new Mesa();
        restaurante = new Restaurante();
        restaurante.setId(1);
        restaurante.setNome("Restaurante Teste");
    }

    @Test
    void testSetAndGetId() {
        
        mesa.setId(1);
        assertEquals(1, mesa.getId());
    }

    @Test
    void testSetAndGetTag() {
        
        mesa.setTag("Mesa-1");
        assertEquals("Mesa-1", mesa.getTag());
    }

    @Test
    void testSetAndGetRestaurante() {
        
        mesa.setRestaurante(restaurante);
        assertNotNull(mesa.getRestaurante());
        assertEquals(1, mesa.getRestaurante().getId());
        assertEquals("Restaurante Teste", mesa.getRestaurante().getNome());
    }

    @Test
    void testSetAndGetStatus() {
        
        mesa.setStatus(StatusMesa.OCUPADA);
        assertEquals(StatusMesa.OCUPADA, mesa.getStatus());
    }

    @Test
    void testMesaConstructor() {
        
        Mesa mesaParametrizada = new Mesa();
        mesaParametrizada.setId(2);
        mesaParametrizada.setTag("Mesa-2");
        mesaParametrizada.setRestaurante(restaurante);
        mesaParametrizada.setStatus(StatusMesa.DISPONIVEL); 
    
        assertEquals(2, mesaParametrizada.getId());
        assertEquals("Mesa-2", mesaParametrizada.getTag());
        assertEquals(1, mesaParametrizada.getRestaurante().getId());
        assertEquals("Restaurante Teste", mesaParametrizada.getRestaurante().getNome());
        assertEquals(StatusMesa.DISPONIVEL, mesaParametrizada.getStatus()); 
    }
    
}
