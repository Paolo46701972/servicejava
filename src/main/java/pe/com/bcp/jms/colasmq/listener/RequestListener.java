package pe.com.bcp.jms.colasmq.listener;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import pe.com.bcp.jms.colasmq.bean.CamposBean;
import pe.com.bcp.jms.colasmq.config.ConfigurationLogStash;
import pe.com.bcp.jms.colasmq.constants.Constants;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.text.ParseException;

@Slf4j
@Component
public class RequestListener
{
    @Value("${port.elk.sogi}")
    public Integer portSogi;

    @Value("${host.elk}")
    public String hostSogi;

    @JmsListener(destination = Constants.QUEUE_REQUEST)
    public void receiveRequest(Message message) throws JMSException, ParseException {
        ConfigurationLogStash envio = new ConfigurationLogStash();
        TextMessage textMessage = (TextMessage) message;

        String msg = textMessage.getText();
        log.info("Mensaje eliminado temporalmente: {}", msg);
        /*GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        CamposBean bean = envio.manageMsg(msg, Constants.REQUEST);

        envio.conexion(gson.toJson(bean), portSogi, Constants.REQUEST, hostSogi);*/
    }
}
