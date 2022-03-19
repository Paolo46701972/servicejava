package pe.com.bcp.jms.colasmq.service;

import org.springframework.http.ResponseEntity;
import pe.com.bcp.jms.colasmq.bean.RequestPLot;
import pe.com.bcp.jms.colasmq.bean.ResponseMessage;
import reactor.core.publisher.Mono;

public interface WasService
{
    public Mono<ResponseEntity<ResponseMessage>> generateBody(RequestPLot requestPLot);
}
