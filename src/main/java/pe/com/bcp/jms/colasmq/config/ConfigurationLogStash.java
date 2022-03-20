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
		int totCad = Constants.SIZE_PLOT;//16
		String ncad;

		if(cad.lastIndexOf(Constants.TARGET_PLOT_START) > -1) {
			int ini = cad.lastIndexOf(Constants.TARGET_PLOT_START);//obtiene el indice inicial del texto buscado <data>
			int fin = cad.lastIndexOf(Constants.TARGET_PLOT_END);//obtiene el indice inicial del texto buscado </data>
			cad = cad.substring(ini + 6, fin);//quita la etiqueta <data> y </data>, toma solo el valor de la trama

			//Ejm.- cad=abcdefghijklmnopq - length=17

			/*Tomar Codigo de Empresa*/
			String empresa = cad.substring(0, 15);//empresa=abcdef
			//cad = cad.substring(15, cad.length()-15);//new cad=ghijklmnopq - toma el resto de la cadena y quita la parte que ya proceso en empresa
			bean.setCodEmpresa(empresa);
			
			/*Tomar Tipo de Operacion*/
			tmp = totCad; //tmp=15
			totCad = totCad + Constants.TYPE_OPER; // 15+6=21 - Tipo Operacion son 6 caracteres
		    ncad = cad.substring(tmp,totCad); //cad.substring(15,21)
		    bean.setTipoOperacion(ncad.trim()); //Elimina espacios iniciales

		    /*Tomar Canal*/
		    tmp = totCad; //tmp=21 - Canal tiene 2 caracteres
			totCad = totCad + Constants.CHANNEL; //totCad=21+2=23
		    ncad = cad.substring(tmp,totCad); //cad.substring(21,23)
		    bean.setCanal(ncad.trim());

		    /*Tomar Nro de Operacion*/
		    tmp = totCad; //tmp=23 - N de operacion tiene 8 caracteres
			totCad = totCad + Constants.NUMBER_OPER; //totCad=23+8=31
		    ncad = cad.substring(tmp,totCad); //cad.substring(23,31)
			bean.setNumOperacion(ncad.trim());

			/*Tomar Fecha de Operacion*/
			tmp = totCad; //tmp=31 - Fecha de operacion tiene 8 caracteres
			totCad = totCad + Constants.DATE_HOUR; //totCad=31+8=39
		    ncad = cad.substring(tmp,totCad); //cad.substring(31,39)
			Date fechaProceso =new SimpleDateFormat(Constants.DATE_FORMAT_1).parse(ncad.trim());
			String fechaProcesoFormato = new SimpleDateFormat(Constants.DATE_FORMAT_2).format(fechaProceso);
		    bean.setFechaHora(fechaProcesoFormato);

		    /*Tomar TimeStamp*/
			tmp = totCad; //tmp=39 - TimeStamp tiene 6 caracteres
			totCad = totCad + Constants.TIME_STAMP; //totCad=39+6=45
		    ncad = cad.substring(tmp,totCad); //cad.substring(39,45)
			fechaProceso =new SimpleDateFormat(Constants.TIME_FORMAT_1).parse(ncad.trim());
			fechaProcesoFormato = new SimpleDateFormat(Constants.TIME_FORMAT_2).format(fechaProceso);
		    bean.setTiempoTrama(fechaProcesoFormato);

		    /*Tomar Codigo de respuesta/estado*/ 
			tmp = totCad; //tmp=45 - Cod Estado tiene 6 caracteres, pero al ser lo ultimo de la trama se toma hasta el ultimo valor
			//totCad = totCad + Constants.COD_ESTADO; 
		    ncad = cad.substring(tmp,cad.length() - 1); 
		    bean.setCodigoEstado(ncad.trim());			
										
		}
		
		return bean;
	}
}
