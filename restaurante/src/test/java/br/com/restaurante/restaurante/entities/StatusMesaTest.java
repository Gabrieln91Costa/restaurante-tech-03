package br.com.restaurante.restaurante.entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StatusMesaTest {

    @Test
    void testEnumValues() {
        
        StatusMesa[] expectedValues = StatusMesa.values();
        assertEquals(5, expectedValues.length); 
        assertEquals(StatusMesa.DISPONIVEL, expectedValues[0]);
        assertEquals(StatusMesa.OCUPADA, expectedValues[1]);
        assertEquals(StatusMesa.RESERVADA, expectedValues[2]);
        assertEquals(StatusMesa.INATIVO, expectedValues[3]);
        assertEquals(StatusMesa.ATIVO, expectedValues[4]);
    }

    @Test
    void testEnumValueOf() {
        
        assertEquals(StatusMesa.DISPONIVEL, StatusMesa.valueOf("DISPONIVEL"));
        assertEquals(StatusMesa.OCUPADA, StatusMesa.valueOf("OCUPADA"));
        assertEquals(StatusMesa.RESERVADA, StatusMesa.valueOf("RESERVADA"));
        assertEquals(StatusMesa.INATIVO, StatusMesa.valueOf("INATIVO"));
        assertEquals(StatusMesa.ATIVO, StatusMesa.valueOf("ATIVO"));
    }

    @Test
    void testEnumToString() {
        
        assertEquals("DISPONIVEL", StatusMesa.DISPONIVEL.toString());
        assertEquals("OCUPADA", StatusMesa.OCUPADA.toString());
        assertEquals("RESERVADA", StatusMesa.RESERVADA.toString());
        assertEquals("INATIVO", StatusMesa.INATIVO.toString());
        assertEquals("ATIVO", StatusMesa.ATIVO.toString());
    }

    @Test
    void testEnumFromString() {
        
        StatusMesa status = StatusMesa.valueOf("ATIVO");
        assertNotNull(status);
        assertEquals(StatusMesa.ATIVO, status);
    }

    @Test
    void testEnumComparison() {
        
        StatusMesa status1 = StatusMesa.DISPONIVEL;
        StatusMesa status2 = StatusMesa.DISPONIVEL;
        StatusMesa status3 = StatusMesa.OCUPADA;

        assertTrue(status1 == status2);  
        assertFalse(status1 == status3); 
    }
}
