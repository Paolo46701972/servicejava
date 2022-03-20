/*package pe.com.bcp.jms.colasmq.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pe.com.bcp.jms.colasmq.bean.Mensaje;
import pe.com.bcp.jms.colasmq.bean.MessageTransport;
import pe.com.bcp.jms.colasmq.bean.RequestPLot;
import pe.com.bcp.jms.colasmq.bean.ResponseMessage;
import pe.com.bcp.jms.colasmq.config.ConfigurationLogStash;
import pe.com.bcp.jms.colasmq.constants.Constants;
import pe.com.bcp.jms.colasmq.constants.Messages;
import pe.com.bcp.jms.colasmq.entity.FormDis;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
public class WasServiceImpl implements WasService {

    public FormDis form = new FormDis();

    @Autowired
    FormService formulas;

    @Value("${host.elk}")
    public String hostSogi;

    @Value("${port.elk.was}")
    public Integer portWas;

    public Mono<ResponseEntity<ResponseMessage>> generateBody(RequestPLot requestPLot){
        MessageTransport response = new MessageTransport();
        Mensaje msg = new Mensaje();
        ResponseMessage responseMessage = new ResponseMessage();

        String[] arr1 = requestPLot.getMessage().split(Constants.COMMA);

        for(int i = 0; i < arr1.length; i++) {
            switch (i) {
                case 0:
                    msg.setNombreInstancia(arr1[i]);
                    break;
                case 1:
                    String[] arr2 = arr1[1].split(Constants.SLASH_SLASH_PLUS);
                    msg.setDatoLogs(arr2);
                    break;
                case 2:
                    msg.setHoraEjecucionLogs(arr1[i]);
                    break;
                case 3:
                    msg.setCodRevisionEstado(arr1[i]);
                    break;
                case 4:
                    msg.setResErrorRevEstado(arr1[i]);
                    break;
                case 5:
                    msg.setEstadoInstancia(arr1[i]);
                    break;

                case 6:
                case 9:
                    msg.setReinicio(arr1[i]);
                    break;
                case 7:
                    msg.setHoraReinicio(arr1[i]);
                    break;
                case 8:
                    msg.setEstadoFinal(arr1[i]);
                    break;
                default:
                    break;
            }

        }

        try {
            if(!Objects.equals(form.getFechaPrimera(), Constants.ZERO_L)){
                if(formulas.validateDates(form.getFechaPrimera(), msg.getHoraEjecucionLogs()))
                    form.setHoras(form.getHoras() +
                            formulas.generateHours(form.getFechaPrimera(), msg.getHoraEjecucionLogs(),
                                    form.getStatus()));
                else
                    form.setHoras(Constants.ZERO_F);
            }

            form.setFechaPrimera(
                    (formulas.generateMillis(msg.getHoraEjecucionLogs().toString()) - form.getFechaPrimera()) < 0 ?
                            form.getFechaPrimera() : formulas.generateMillis(msg.getHoraEjecucionLogs()));

            form.setStatus(msg.getEstadoFinal());

            log.info("Form : {}", form.toString());

            msg.setDisponibilidadInstancia(formulas.disponibilidadInstancia(msg.getEstadoFinal(), form.getHoras()));

            response.setIdentifier(requestPLot.getIdentifier());
            response.setMessage(msg);

            Gson g = new Gson();

            //Envia a Kibana
            ConfigurationLogStash envio = new ConfigurationLogStash();
            envio.conexion(g.toJson(msg), portWas, Constants.WAS, hostSogi);

            responseMessage.setStatus(HttpStatus.OK.value());
            responseMessage.setMessage(Messages.TRAMA_ENVIO_CORRECTA);
            responseMessage.setBody(new ObjectMapper().convertValue(response, Map.class));
        }
        catch (Exception e){
            log.error("Ocurrió un error : {}", e.toString());
            responseMessage.setMessage(Messages.ERROR_INTERNO + "  " + e.getMessage());
            responseMessage.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            e.printStackTrace();
        }

        return Mono.just(this.getResponse(responseMessage));
    }

    public ResponseEntity<ResponseMessage> getResponse(ResponseMessage message){
        return ResponseEntity.status(message.getStatus()).body(message);
    }
}

*/