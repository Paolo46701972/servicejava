package pe.com.bcp.jms.colasmq.config;

import lombok.extern.slf4j.Slf4j;
import pe.com.bcp.jms.colasmq.bean.CamposBean;
import pe.com.bcp.jms.colasmq.constants.Constants;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class ConfigurationLogStash {

	public void conexion(String mensaje, int puerto, String type, String host) {
		log.info("Entrado: {}, - a {}", mensaje, type);
		
		try (Socket socket = new Socket(host, puerto)){
			DataOutputStream os = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			os.writeBytes(mensaje);
			os.flush();
		}
		catch (IOException e) {
			log.error("Ocurrió un error : {} ", e.toString());
			e.printStackTrace();
		}

	}
	
	public CamposBean manageMsg(String cad, String type) throws ParseException {
		CamposBean bean = new CamposBean();
		int tmp;
		int totCad = Constants.SIZE_PLOT;
		String ncad;

		if(cad.lastIndexOf(Constants.TARGET_PLOT_START) > -1) {
			int ini = cad.lastIndexOf(Constants.TARGET_PLOT_START);
			int fin = cad.lastIndexOf(Constants.TARGET_PLOT_END);
			cad = cad.substring(ini + 6, fin);
						
			tmp = totCad;
			totCad = totCad + Constants.START_COD_ENTERPRISE;
		    ncad = cad.substring(tmp,totCad);
		    bean.setCodEmpresa(ncad.trim());
			
			tmp = totCad;
			totCad = totCad + Constants.TYPE_OPER;
		    ncad = cad.substring(tmp,totCad);
		    bean.setTipoOperacion(ncad.trim());
			
			tmp = totCad;
			totCad = totCad + Constants.DATE_HOUR;
		    ncad = cad.substring(tmp,totCad);
			Date fechaProceso =new SimpleDateFormat(Constants.DATE_FORMAT_1).parse(ncad.trim());
			String fechaProcesoFormato = new SimpleDateFormat(Constants.DATE_FORMAT_2).format(fechaProceso);
		    bean.setFechaHora(fechaProcesoFormato);
			
			tmp = totCad;
			totCad = totCad + Constants.CHANNEL;
		    ncad = cad.substring(tmp,totCad);
		    bean.setCanal(ncad.trim());
			
			tmp = totCad;
			totCad = totCad + Constants.NUMBER_OPER;
		    ncad = cad.substring(tmp,totCad);
			bean.setNumOperacion(ncad.trim());
		}
		
		return bean;
	}
}
