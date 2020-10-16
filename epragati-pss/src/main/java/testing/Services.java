
package testing;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "Services", targetNamespace = "http://Testing/", wsdlLocation = "http://pss.ap.gov.in/SPSHouseholdDetails/services/Services?wsdl")
public class Services
    extends Service
{

    private final static URL SERVICES_WSDL_LOCATION;
    private final static WebServiceException SERVICES_EXCEPTION;
    private final static QName SERVICES_QNAME = new QName("http://Testing/", "Services");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://pss.ap.gov.in/SPSHouseholdDetails/services/Services?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SERVICES_WSDL_LOCATION = url;
        SERVICES_EXCEPTION = e;
    }

    public Services() {
        super(__getWsdlLocation(), SERVICES_QNAME);
    }

    public Services(WebServiceFeature... features) {
        super(__getWsdlLocation(), SERVICES_QNAME, features);
    }

    public Services(URL wsdlLocation) {
        super(wsdlLocation, SERVICES_QNAME);
    }

    public Services(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVICES_QNAME, features);
    }

    public Services(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public Services(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ServicesPortType
     */
    @WebEndpoint(name = "ServicesSOAP11port_http")
    public ServicesPortType getServicesSOAP11PortHttp() {
        return super.getPort(new QName("http://Testing/", "ServicesSOAP11port_http"), ServicesPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServicesPortType
     */
    @WebEndpoint(name = "ServicesSOAP11port_http")
    public ServicesPortType getServicesSOAP11PortHttp(WebServiceFeature... features) {
        return super.getPort(new QName("http://Testing/", "ServicesSOAP11port_http"), ServicesPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SERVICES_EXCEPTION!= null) {
            throw SERVICES_EXCEPTION;
        }
        return SERVICES_WSDL_LOCATION;
    }

}
