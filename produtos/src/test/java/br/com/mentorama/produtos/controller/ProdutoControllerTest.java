package br.com.mentorama.produtos.controller;

import br.com.mentorama.produtos.models.Produto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;



import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProdutoControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void deveEnviarRequisicaoComSucessoParaIdJáExistenteERetornarOK() throws Exception{
        Produto produto = new Produto(1,"Celular",999.99,1,0.00);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(produto);

        mvc.perform(MockMvcRequestBuilders.post("/produto")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(status().isCreated());

        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/produto/id/1")
                .contentType(MediaType.APPLICATION_JSON)).andReturn();

        String esperado = "{" +
                "\"id\":1," +
                "\"nome\":\"Celular\"," +
                "\"valor\":999.99," +
                "\"quantidadeEstoque\":1," +
                "\"descontoMaximo\":0.0" +
                "}";

        assertEquals(esperado, result.getResponse().getContentAsString());
    }

    @Test
    public void deveEnviarRequisicaoParaIdNaoCadastradoERetornarNot_Found() throws Exception{
        Produto produto = new Produto(1, "Celular", 999.99,1,0.0);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(produto);

        mvc.perform(MockMvcRequestBuilders.post("/produto")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(status().isCreated());

        mvc.perform(MockMvcRequestBuilders.get("/produto/id/2"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void deveEnviarRequisicaoParaUrlDigitadaErradaERetornarMethod_Not_Allowed() throws Exception{
        Produto produto = new Produto(1, "Celular", 999.99,1,0.00);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(produto);

        mvc.perform(MockMvcRequestBuilders.post("/produto")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(status().isCreated());

        mvc.perform(MockMvcRequestBuilders.get("/produto/1"))
                .andExpect(status().isMethodNotAllowed());
    }

     @Test
    public void  deveCadastraProdutoComSucessoERetorarCreated() throws Exception{
        Produto produto = new Produto(1,"Celular",999.99,1,0.00);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(produto);

        mvc.perform(MockMvcRequestBuilders.post("/produto")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(status().isCreated());
    }

    @Test
    public void deveAlterarCadastroExistententeComSucessoERetornarNo_Content() throws Exception{
        Produto produto = new Produto(1,"Celular",999.99,1,0.00);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(produto);

        mvc.perform(MockMvcRequestBuilders.post("/produto")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(status().isCreated());

        ResultActions result = mvc.perform(MockMvcRequestBuilders.put("/produto")
                .content("{" +
                        "\"id\": 1," +
                        "\"nome\":\"Mouse\"," +
                        "\"valor\": 24.99," +
                        "\"quantidadeEstoque\": 7," +
                        "\"descontoMaximo\": 0.04" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
    }

    @Test
    public void deveApagarProdutoExistenteERetornarNo_Content() throws Exception{
        Produto produto = new Produto(1,"Celular",999.99,1,0.00);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(produto);

        mvc.perform(MockMvcRequestBuilders.post("/produto")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)).andExpect(status().isCreated());

        ResultActions result = mvc.perform(MockMvcRequestBuilders.delete("/produto/1"))
                .andExpect(status().isNoContent());

    }
}