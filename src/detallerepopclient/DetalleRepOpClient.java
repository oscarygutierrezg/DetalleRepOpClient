/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detallerepopclient;

import com.siebel.fins.OCSDetalledeDocumentosWS;
import com.siebel.fins.OcsDetalleDocumento;
import com.siebel.xml.ocs_20detalle_20documento_20io.ListOfOcsDetalleDocumentoIoTopElmt;
import java.util.Map;
import javax.jws.WebParam;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Holder;

/**
 *
 * @author oscar
 */
public class DetalleRepOpClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        OcsDetalleDocumento service = new OcsDetalleDocumento();
        OCSDetalledeDocumentosWS port = service.getOCSDetalledeDocumentosWS();

        BindingProvider bp = (BindingProvider) port;
        Map<String, Object> rc = bp.getRequestContext();
        rc.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://lasiewebsit.ccaf.andes:8080/enterprise/EntDetalleDocumentoService?WSDL");

        String actionId="1-1BSUGWN";
        Holder<String> errorCode = new Holder<String>();

        Holder<String> errorMessage = new Holder<String>();
        Holder<ListOfOcsDetalleDocumentoIoTopElmt> responseSpcIO= new  Holder<ListOfOcsDetalleDocumentoIoTopElmt>();
        port.ocsSpcDetalleSpcdeSpcDocumentosSpcWF(actionId, errorCode, errorMessage, responseSpcIO);

        System.out.println("Codigo " + errorCode.value);
        System.out.println("Mensaje " + errorMessage.value);
        System.out.println("Mensaje " + responseSpcIO.value.getListOfOcsDetalleDocumentoIo().getListOfAction().getAction().size());
    }

}
