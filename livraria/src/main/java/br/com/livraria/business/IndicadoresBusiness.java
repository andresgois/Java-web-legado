package br.com.livraria.business;

import java.util.Date;
import java.util.List;

import javax.json.JsonObject;

import org.jboss.logging.Logger;

import br.com.livraria.util.enums.TussEnum;
import br.com.livraria.webservices.rest.clients.RestClient;

public class IndicadoresBusiness {
    
    private final Logger LOGGER = Logger.getLogger(getClass().getName());
    
    public JsonObject getDadosIndicadores(Date dataInicio, Date dataFim, List<TussEnum> tussenum) throws Exception{
        String resposta = "";
        JsonObject jsonResposta= null;
       try {
           RestClient restClient = new RestClient();
            resposta = "{\"Sucesso\":true,\"CodigoMensagem\":200,\"Retorno\":{\"Resultados\":[{\"DataExame\":\"05/11/2020 21:00:00\",\"Valor\":\"15,6\",\"CodigoTUSS\":40304361,\"DescricaoTUSS\":\"HEMOGLOBINA\",\"UnidadeMedida\":\"g/dL\"},{\"DataExame\":\"05/11/2020 21:00:00\",\"Valor\":\"1,09\",\"CodigoTUSS\":40301630,\"DescricaoTUSS\":\"CREATININA\",\"UnidadeMedida\":\"mg/dL\"}]}}";
            jsonResposta = restClient.stringToJsonObject(resposta);
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
            throw new Exception("NAO_FOI_POSSIVEL_CARREGAR_OS_DADOS_INDICADORES_DO_PACIENTE");
        }
        return jsonResposta;
    }
}
