package br.com.restaurante.restaurante.useCases;

import br.com.restaurante.restaurante.entities.Mesa;
import br.com.restaurante.restaurante.entities.StatusMesa;
import br.com.restaurante.restaurante.repositories.MesaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

class AlterarStatusMesaUseCaseTest {

    @Mock
    private MesaRepository mesaRepository;  

    @InjectMocks
    private AlterarStatusMesaUseCase alterarStatusMesaUseCase;  

    private Mesa mesa;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);  

        
        mesa = new Mesa();
        mesa.setId(1);
        mesa.setTag("Mesa-1");
        mesa.setStatus(StatusMesa.DISPONIVEL);
    }

    @Test
    void testAlterarStatusMesa() {
        

        
        Mockito.when(mesaRepository.findById(1)).thenReturn(Optional.of(mesa));
        Mockito.when(mesaRepository.save(mesa)).thenReturn(mesa);

        
        Mesa mesaAtualizada = alterarStatusMesaUseCase.alterarStatusMesa(1, StatusMesa.OCUPADA);

        
        assertNotNull(mesaAtualizada);
        assertEquals(StatusMesa.OCUPADA, mesaAtualizada.getStatus());
    }

    @Test
    void testAlterarStatusMesaMesaNaoEncontrada() {
        

        
        Mockito.when(mesaRepository.findById(2)).thenReturn(Optional.empty());

        
        Mesa mesaAtualizada = alterarStatusMesaUseCase.alterarStatusMesa(2, StatusMesa.RESERVADA);

        
        assertNull(mesaAtualizada);
    }
}
