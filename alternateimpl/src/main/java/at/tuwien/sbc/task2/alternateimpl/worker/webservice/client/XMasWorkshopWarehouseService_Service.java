
package at.tuwien.sbc.task2.alternateimpl.worker.webservice.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "XMasWorkshopWarehouseService", targetNamespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", wsdlLocation = "http://localhost:8080/xmasworkshop?wsdl")
public class XMasWorkshopWarehouseService_Service
    extends Service
{

    private final static URL XMASWORKSHOPWAREHOUSESERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.XMasWorkshopWarehouseService_Service.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = at.tuwien.sbc.task2.alternateimpl.worker.webservice.client.XMasWorkshopWarehouseService_Service.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8080/xmasworkshop?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8080/xmasworkshop?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        XMASWORKSHOPWAREHOUSESERVICE_WSDL_LOCATION = url;
    }

    public XMasWorkshopWarehouseService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public XMasWorkshopWarehouseService_Service() {
        super(XMASWORKSHOPWAREHOUSESERVICE_WSDL_LOCATION, new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "XMasWorkshopWarehouseService"));
    }

    /**
     * 
     * @return
     *     returns XMasWorkshopWarehouseService
     */
    @WebEndpoint(name = "XMasWorkshopWarehouseServicePort")
    public XMasWorkshopWarehouseService getXMasWorkshopWarehouseServicePort() {
        return super.getPort(new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "XMasWorkshopWarehouseServicePort"), XMasWorkshopWarehouseService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns XMasWorkshopWarehouseService
     */
    @WebEndpoint(name = "XMasWorkshopWarehouseServicePort")
    public XMasWorkshopWarehouseService getXMasWorkshopWarehouseServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "XMasWorkshopWarehouseServicePort"), XMasWorkshopWarehouseService.class, features);
    }

}
