package br.com.restaurante.restaurante.useCases;

import br.com.restaurante.restaurante.entities.Mesa;
import br.com.restaurante.restaurante.repositories.MesaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConsultarMesasUseCaseTest {

    @Mock
    private MesaRepository mesaRepository;  

    @InjectMocks
    private ConsultarMesasUseCase consultarMesasUseCase;  

    private Mesa mesa1;
    private Mesa mesa2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);  

        
        mesa1 = new Mesa();
        mesa1.setId(1);
        mesa1.setTag("Mesa-1");

        mesa2 = new Mesa();
        mesa2.setId(2);
        mesa2.setTag("Mesa-2");
    }

    @Test
    void testConsultarMesas() {
        
        List<Mesa> mesas = Arrays.asList(mesa1, mesa2);

        
        Mockito.when(mesaRepository.findAllByRestauranteId(1)).thenReturn(mesas);

        
        List<Mesa> mesasConsultadas = consultarMesasUseCase.consultarMesas(1);

        
        assertNotNull(mesasConsultadas);
        assertEquals(2, mesasConsultadas.size());
        assertEquals("Mesa-1", mesasConsultadas.get(0).getTag());
        assertEquals("Mesa-2", mesasConsultadas.get(1).getTag());
    }

    @Test
    void testConsultarMesasSemMesas() {
        
        Mockito.when(mesaRepository.findAllByRestauranteId(1)).thenReturn(Arrays.asList());

        
        List<Mesa> mesasConsultadas = consultarMesasUseCase.consultarMesas(1);

        
        assertNotNull(mesasConsultadas);
        assertTrue(mesasConsultadas.isEmpty());
    }
}
