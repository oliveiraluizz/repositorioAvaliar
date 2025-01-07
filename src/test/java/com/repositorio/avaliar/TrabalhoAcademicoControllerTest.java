package com.repositorio.avaliar;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.repositorio.avaliar.controller.TrabalhoAcademicoController;
import com.repositorio.avaliar.model.TrabalhoAcademico;
import com.repositorio.avaliar.service.TrabalhoAcademicoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*; // Importações do Mockito para mocks, spies e verificações
import static org.mockito.ArgumentMatchers.any; // Import específico para "any"
import static org.mockito.ArgumentMatchers.eq;  // Import específico para "eq"
import static org.hamcrest.Matchers.*; // Importações do Hamcrest para verificações
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TrabalhoAcademicoController.class)
public class TrabalhoAcademicoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TrabalhoAcademicoService service;

    @Autowired
    private ObjectMapper objectMapper;

    private TrabalhoAcademico criarTrabalhoAcademico() {
        return new TrabalhoAcademico(
                1L,
                "Trabalho 1",
                "Artigo",
                2022,
                "Autor 1",
                "Orientador 1",
                "Palavras-chave 1",
                "Universidade 1"
        );
    }

    @Test
    public void testListarTrabalhos() throws Exception {
        List<TrabalhoAcademico> trabalhos = Arrays.asList(
                criarTrabalhoAcademico(),
                new TrabalhoAcademico(2L, "Trabalho 2", "Monografia", 2023,
                        "Autor 2", "Orientador 2", "Palavras-chave 2", "Universidade 2")
        );

        // Quando o service.listarTrabalhos() for chamado, retornará nossa lista mockada
        when(service.listarTrabalhos()).thenReturn(trabalhos);

        mockMvc.perform(MockMvcRequestBuilders.get("/trabalhos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].titulo", is("Trabalho 1")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].titulo", is("Trabalho 2")));
    }

    @Test
    public void testBuscarTrabalhoPorId() throws Exception {
        TrabalhoAcademico trabalho = criarTrabalhoAcademico();

        // Quando buscarTrabalhoPorId(1L) for chamado, retorna o trabalho mockado
        when(service.buscarTrabalhoPorId(1L)).thenReturn(trabalho);

        mockMvc.perform(MockMvcRequestBuilders.get("/trabalhos/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.titulo", is("Trabalho 1")));
    }

    @Test
    public void testCriarTrabalho() throws Exception {
        TrabalhoAcademico trabalho = criarTrabalhoAcademico();

        // Quando criarTrabalho(any(TrabalhoAcademico.class)) for chamado, retorna o trabalho mockado
        when(service.criarTrabalho(any(TrabalhoAcademico.class))).thenReturn(trabalho);

        mockMvc.perform(MockMvcRequestBuilders.post("/trabalhos")
                        .content(objectMapper.writeValueAsString(trabalho))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.titulo", is("Trabalho 1")));
    }

    @Test
    public void testAtualizarTrabalho() throws Exception {
        TrabalhoAcademico trabalho = criarTrabalhoAcademico();

        // Quando atualizarTrabalho(1L, trabalho) for chamado, retorna o trabalho mockado
        when(service.atualizarTrabalho(eq(1L), any(TrabalhoAcademico.class))).thenReturn(trabalho);

        mockMvc.perform(MockMvcRequestBuilders.put("/trabalhos/1")
                        .content(objectMapper.writeValueAsString(trabalho))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo", is("Trabalho 1")));
    }

    @Test
    public void testDeletarTrabalho() throws Exception {
        // Não é necessário mockar retorno para métodos void; somente certifique-se de não gerar exceções
        doNothing().when(service).deletarTrabalho(1L);

        mockMvc.perform(MockMvcRequestBuilders.delete("/trabalhos/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
