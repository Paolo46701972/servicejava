/*package pe.com.bcp.jms.colasmq.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.com.bcp.jms.colasmq.constants.Constants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
public class FormService {

    public Float disponibilidadInstancia(String estado,  Float horas) {
        log.info("Estado : {}", estado);

        return Constants.PERCENTAGE_TOTAL - ((horas / Constants.DAY_HOUR) * Constants.PERCENTAGE_TOTAL);
    }

    public Float generateHours(Long millisecondDate, String dateAfter, String statusBefore) throws ParseException {
        Long mill = Constants.ZERO_L;

        if(statusBefore.equals(Constants.STOPPED))
            mill = (this.generateMillis(dateAfter) - millisecondDate) < 0 ? 0 :
                    (this.generateMillis(dateAfter) - millisecondDate);

        log.info("Mill : {} ", mill);

        return (float) mill /Constants.MILLISECOND;
    }

    public Long generateMillis(String date) throws ParseException {
        Date fechaLogs = this.formatDate(date);

        return fechaLogs.getTime();
    }

    public Date formatDate(String date) throws ParseException {
        return new SimpleDateFormat(Constants.DATE_FORMAT_3).parse(date);
    }

    public Boolean validateDates(Long date1, String date2) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(Constants.DATE_FORMAT_4);
        Date fecha1 = format.parse(format.format(new Date(date1)));
        Date fecha2 = format.parse(date2.split(Constants.VOID_STRING)[0]);

        return fecha1.compareTo(fecha2) == 0;
    }

}
*/