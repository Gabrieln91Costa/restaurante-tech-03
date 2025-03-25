package br.com.restaurante.restaurante.useCases;


import br.com.restaurante.restaurante.entities.Mesa;
import br.com.restaurante.restaurante.entities.Restaurante;
import br.com.restaurante.restaurante.entities.StatusMesa;
import br.com.restaurante.restaurante.repositories.MesaRepository;
import br.com.restaurante.restaurante.useCases.CriarMesasUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CriarMesasUseCaseTest {

    @Mock
    private MesaRepository mesaRepository;

    @InjectMocks
    private CriarMesasUseCase criarMesasUseCase;

    private Restaurante restaurante;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        
        restaurante = new Restaurante();
        restaurante.setQuantidadeMesas(3);
    }

    @Test
    void testCriarMesas() {
        
        Mesa mesa1 = new Mesa();
        mesa1.setTag("Mesa-1");
        mesa1.setStatus(StatusMesa.ATIVO);
        mesa1.setRestaurante(restaurante);

        Mesa mesa2 = new Mesa();
        mesa2.setTag("Mesa-2");
        mesa2.setStatus(StatusMesa.ATIVO);
        mesa2.setRestaurante(restaurante);

        Mesa mesa3 = new Mesa();
        mesa3.setTag("Mesa-3");
        mesa3.setStatus(StatusMesa.ATIVO);
        mesa3.setRestaurante(restaurante);

        
        Mockito.when(mesaRepository.saveAll(Mockito.anyList())).thenReturn(Arrays.asList(mesa1, mesa2, mesa3));

        
        List<Mesa> mesasCriadas = criarMesasUseCase.criarMesas(restaurante);

        
        assertNotNull(mesasCriadas);
        assertEquals(3, mesasCriadas.size());
        assertEquals("Mesa-1", mesasCriadas.get(0).getTag());
        assertEquals("Mesa-2", mesasCriadas.get(1).getTag());
        assertEquals("Mesa-3", mesasCriadas.get(2).getTag());
        assertEquals(StatusMesa.ATIVO, mesasCriadas.get(0).getStatus());
        assertEquals(StatusMesa.ATIVO, mesasCriadas.get(1).getStatus());
        assertEquals(StatusMesa.ATIVO, mesasCriadas.get(2).getStatus());

        
        Mockito.verify(mesaRepository, Mockito.times(1)).saveAll(Mockito.anyList());
    }
}
