package br.com.restaurante.restaurante.controllers;

import br.com.restaurante.restaurante.entities.Mesa;
import br.com.restaurante.restaurante.entities.StatusMesa;
import br.com.restaurante.restaurante.useCases.ConsultarMesasUseCase;
import br.com.restaurante.restaurante.useCases.AlterarStatusMesaUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MesaController.class)  
class MesaControllerTest {

    @Autowired
    private MockMvc mockMvc;  

    @MockBean
    private ConsultarMesasUseCase consultarMesasUseCase;  

    @MockBean
    private AlterarStatusMesaUseCase alterarStatusMesaUseCase;  

    @BeforeEach
    void setUp() {
        
    }

    @Test
    void testConsultarMesas() throws Exception {
        
        Mesa mesa1 = new Mesa();
        mesa1.setTag("Mesa-1");
        mesa1.setStatus(StatusMesa.ATIVO);

        Mesa mesa2 = new Mesa();
        mesa2.setTag("Mesa-2");
        mesa2.setStatus(StatusMesa.ATIVO);

        List<Mesa> mesas = Arrays.asList(mesa1, mesa2);

        
        when(consultarMesasUseCase.consultarMesas(1)).thenReturn(mesas);

        
        mockMvc.perform(get("/api/mesas/restaurante/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].tag").value("Mesa-1"))
                .andExpect(jsonPath("$[1].tag").value("Mesa-2"))
                .andExpect(jsonPath("$[0].status").value("ATIVO"))
                .andExpect(jsonPath("$[1].status").value("ATIVO"));
    }

    @Test
    void testAlterarStatusMesa() throws Exception {
        
        Mesa mesa = new Mesa();
        mesa.setTag("Mesa-1");
        mesa.setStatus(StatusMesa.ATIVO);  
    
        
        mesa.setStatus(StatusMesa.INATIVO);  
    
        
        when(alterarStatusMesaUseCase.alterarStatusMesa(1, StatusMesa.INATIVO)).thenReturn(mesa);
    
        
        mockMvc.perform(put("/api/mesas/1/status")
                            .contentType("application/json")
                            .content("\"INATIVO\"")) 
                    .andExpect(status().isOk())
                    .andExpect(content().contentType("application/json"))
                    .andExpect(jsonPath("$.tag").value("Mesa-1"))
                    .andExpect(jsonPath("$.status").value("INATIVO"));  
    }

    @Test
    void testAlterarStatusMesaNotFound() throws Exception {
        
        when(alterarStatusMesaUseCase.alterarStatusMesa(1, StatusMesa.INATIVO)).thenReturn(null);

        
        mockMvc.perform(put("/api/mesas/1/status")
                        .contentType("application/json")
                        .content("\"INATIVO\"")) 
                .andExpect(status().isNotFound());
    }

    @Test
    void testAlterarStatusMesaInvalidStatus() throws Exception {
        
        Mesa mesa = new Mesa();
        mesa.setTag("Mesa-1");
        mesa.setStatus(StatusMesa.ATIVO);  

        
        mockMvc.perform(put("/api/mesas/1/status")
                        .contentType("application/json")
                        .content("\"INVALIDO\"")) 
                .andExpect(status().isBadRequest()); 
    }
}
