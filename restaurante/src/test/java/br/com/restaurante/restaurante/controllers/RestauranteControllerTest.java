package br.com.restaurante.restaurante.controllers;

import br.com.restaurante.restaurante.dto.RestauranteDTO;
import br.com.restaurante.restaurante.entities.Restaurante;
import br.com.restaurante.restaurante.useCases.CriarRestauranteUseCase;
import br.com.restaurante.restaurante.useCases.CriarMesasUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RestauranteController.class)
public class RestauranteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CriarRestauranteUseCase criarRestauranteUseCase;

    @MockBean
    private CriarMesasUseCase criarMesasUseCase;

    private RestauranteDTO restauranteDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        restauranteDTO = new RestauranteDTO();
        restauranteDTO.setNome("Restaurante Teste");
        restauranteDTO.setQuantidadeMesas(10);
    }

    @Test
    void criarRestauranteTest() throws Exception {
        
        Restaurante restauranteMock = new Restaurante();
        restauranteMock.setId(1);
        restauranteMock.setNome("Restaurante Teste");
        restauranteMock.setQuantidadeMesas(10);

        
        when(criarRestauranteUseCase.criarRestaurante(any(RestauranteDTO.class))).thenReturn(restauranteMock);
        
        
        mockMvc.perform(post("/api/restaurantes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"nome\":\"Restaurante Teste\", \"quantidadeMesas\":10}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nome").value("Restaurante Teste"))
                .andExpect(jsonPath("$.quantidadeMesas").value(10));

        
        verify(criarRestauranteUseCase, times(1)).criarRestaurante(any(RestauranteDTO.class));
    }

    @Test
    void consultarRestauranteTest() throws Exception {
        
        Restaurante restauranteMock = new Restaurante();
        restauranteMock.setId(1);
        restauranteMock.setNome("Restaurante Teste");
        restauranteMock.setQuantidadeMesas(10);

        when(criarRestauranteUseCase.consultarRestaurante(1)).thenReturn(restauranteMock);

        
        mockMvc.perform(get("/api/restaurantes/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nome").value("Restaurante Teste"))
                .andExpect(jsonPath("$.quantidadeMesas").value(10));

        
        verify(criarRestauranteUseCase, times(1)).consultarRestaurante(1);
    }
}
