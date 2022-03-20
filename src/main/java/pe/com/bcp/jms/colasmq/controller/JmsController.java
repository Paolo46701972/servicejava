/*package pe.com.bcp.jms.colasmq.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.mq.jms.MQQueue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.bcp.jms.colasmq.bean.ResponseMessage;
import pe.com.bcp.jms.colasmq.bean.RequestPLot;
import pe.com.bcp.jms.colasmq.constants.Constants;
import pe.com.bcp.jms.colasmq.constants.Messages;
import reactor.core.publisher.Mono;

import javax.jms.JMSException;
import java.util.Map;

@RestController
@RequestMapping("/jms/mq")
@Slf4j
public class JmsController
{
    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("")
    public Mono<ResponseEntity<ResponseMessage>> createOrder(@RequestBody Mono<RequestPLot> trama){
        return trama.flatMap(requestPLot -> {

            log.info("Enviando mensaje...");
            ResponseMessage response = new ResponseMessage();

            try {
                log.info("Enviando a request...");
                MQQueue orderRequestQueue = new MQQueue(Constants.QUEUE_REQUEST);
                jmsTemplate.convertAndSend(orderRequestQueue, requestPLot.toString());

                log.info("Enviando a response...");
                MQQueue orderRequestQueue2 = new MQQueue(Constants.QUEUE_RESPONSE);
                jmsTemplate.convertAndSend(orderRequestQueue2, requestPLot.toString());

                response.setStatus(HttpStatus.ACCEPTED.value());
                response.setMessage(Messages.TRAMA_ENVIO_CORRECTA);
                response.setBody(new ObjectMapper().convertValue(requestPLot, Map.class));

            }
            catch (JMSException e) {
                log.error("Ocurrió un error : {}", e.toString());
                e.printStackTrace();
                response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
                response.setMessage(Messages.ERROR_INTERNO + e);
            }

            return Mono.just(this.getResponse(response));
        }).defaultIfEmpty(getResponse(new ResponseMessage(Messages.TRAMA_NOT_FOUND, HttpStatus.NOT_FOUND.value())));
    }

    public ResponseEntity<ResponseMessage> getResponse(ResponseMessage message){
        return ResponseEntity.status(message.getStatus()).body(message);
    }
}
*/