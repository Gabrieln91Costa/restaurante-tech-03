package br.com.restaurante.restaurante.useCases;

import br.com.restaurante.restaurante.dto.RestauranteDTO;
import br.com.restaurante.restaurante.entities.Restaurante;
import br.com.restaurante.restaurante.repositories.RestauranteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CriarRestauranteUseCaseTest {

    @Mock
    private RestauranteRepository restauranteRepository;  

    @InjectMocks
    private CriarRestauranteUseCase criarRestauranteUseCase;  

    private RestauranteDTO restauranteDTO;

    @BeforeEach
    void setUp() {
        
        MockitoAnnotations.openMocks(this);

        
        restauranteDTO = new RestauranteDTO();
        restauranteDTO.setNome("Restaurante Teste");
        restauranteDTO.setQuantidadeMesas(10);  
    }

    @Test
    void testCriarRestaurante() {
        
        Restaurante restauranteEsperado = new Restaurante();
        restauranteEsperado.setNome(restauranteDTO.getNome());
        restauranteEsperado.setQuantidadeMesas(restauranteDTO.getQuantidadeMesas());

        
        when(restauranteRepository.save(any(Restaurante.class))).thenReturn(restauranteEsperado);

        
        Restaurante restauranteCriado = criarRestauranteUseCase.criarRestaurante(restauranteDTO);

        
        assertNotNull(restauranteCriado);
        assertEquals("Restaurante Teste", restauranteCriado.getNome());
        assertEquals(10, restauranteCriado.getQuantidadeMesas());

        
        verify(restauranteRepository, times(1)).save(any(Restaurante.class));
    }

    @Test
    void testConsultarRestaurante() {
        
        Restaurante restauranteEsperado = new Restaurante();
        restauranteEsperado.setId(1);
        restauranteEsperado.setNome("Restaurante Teste");
        restauranteEsperado.setQuantidadeMesas(10);

        
        when(restauranteRepository.findById(1)).thenReturn(java.util.Optional.of(restauranteEsperado));

        
        Restaurante restauranteConsultado = criarRestauranteUseCase.consultarRestaurante(1);

        
        assertNotNull(restauranteConsultado);
        assertEquals(1, restauranteConsultado.getId());
        assertEquals("Restaurante Teste", restauranteConsultado.getNome());
        assertEquals(10, restauranteConsultado.getQuantidadeMesas());

        
        verify(restauranteRepository, times(1)).findById(1);
    }

    @Test
    void testConsultarRestauranteNaoEncontrado() {
        
        when(restauranteRepository.findById(1)).thenReturn(java.util.Optional.empty());

        
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            criarRestauranteUseCase.consultarRestaurante(1);
        });

        
        assertEquals("Restaurante não encontrado", exception.getMessage());

        
        verify(restauranteRepository, times(1)).findById(1);
    }
}
