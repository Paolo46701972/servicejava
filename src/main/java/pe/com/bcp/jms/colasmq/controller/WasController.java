/*package pe.com.bcp.jms.colasmq.controller;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.bcp.jms.colasmq.bean.ResponseMessage;
import pe.com.bcp.jms.colasmq.bean.RequestPLot;
import pe.com.bcp.jms.colasmq.service.WasService;
import reactor.core.publisher.Mono;

@RequestMapping("/was/status")
@RestController
@Slf4j
public class WasController
{
    @Autowired
    WasService wasService;

    @PostMapping("")
    public Mono<ResponseEntity<ResponseMessage>> createOrder(@RequestBody Mono<RequestPLot> requestPlot){
        return requestPlot.flatMap(requestPLot -> wasService.generateBody(requestPLot));
    }

}
*/