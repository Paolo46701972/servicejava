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
import java.util.Random;

@Component
@Slf4j
public class ResponseListener
{
    @Value("${port.elk.sogi}")
    public Integer portSogi;

    @Value("${host.elk}")
    public String hostSogi;

    @JmsListener(destination = Constants.QUEUE_RESPONSE)
    public void receiveSendResponse(Message message) throws JMSException, ParseException {
        ConfigurationLogStash envio = new ConfigurationLogStash();
        TextMessage textMessage = (TextMessage) message;

        String msg = textMessage.getText();

        /*Random random = new Random();
        int posRandom = random.nextInt(Constants.CODIGOS_ESTADO.length);
        String nuevaCadena = this.insertString(msg, Constants.CODIGOS_ESTADO[posRandom], Constants.INDEX_RESPONSE);*/

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        CamposBean bean = envio.manageMsg(msg, Constants.RESPONSE);

        envio.conexion(gson.toJson(bean), portSogi, Constants.RESPONSE, hostSogi);
    }

    /*public String insertString(String originalString, String stringToBeInserted, Integer index)
    {
        StringBuilder newString = new StringBuilder();

        for (int i = 0; i < originalString.length(); i++) {
            newString.append(originalString.charAt(i));

            if (i == index) newString.append(stringToBeInserted);
        }

        return newString.toString();
    }*/
}
