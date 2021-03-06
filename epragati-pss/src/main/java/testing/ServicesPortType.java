
package testing;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import testing.xsd.ObjectFactory;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ServicesPortType", targetNamespace = "http://Testing/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ServicesPortType {


    /**
     * 
     * @param mobileNumber
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "urn:getCitizenNameInforamation")
    @WebResult(targetNamespace = "http://Testing/xsd")
    @RequestWrapper(localName = "getCitizenNameInforamation", targetNamespace = "http://Testing/xsd", className = "testing.xsd.GetCitizenNameInforamation")
    @ResponseWrapper(localName = "getCitizenNameInforamationResponse", targetNamespace = "http://Testing/xsd", className = "testing.xsd.GetCitizenNameInforamationResponse")
    public String getCitizenNameInforamation(
        @WebParam(name = "mobileNumber", targetNamespace = "http://Testing/xsd")
        String mobileNumber);

    /**
     * 
     * @param date
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "Death_Details", action = "urn:Death_Details")
    @WebResult(targetNamespace = "http://Testing/xsd")
    @RequestWrapper(localName = "Death_Details", targetNamespace = "http://Testing/xsd", className = "testing.xsd.DeathDetails")
    @ResponseWrapper(localName = "Death_DetailsResponse", targetNamespace = "http://Testing/xsd", className = "testing.xsd.DeathDetailsResponse")
    public String deathDetails(
        @WebParam(name = "Date", targetNamespace = "http://Testing/xsd")
        String date);

    /**
     * 
     * @param uidNUM
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "SPSVerification", action = "urn:SPSVerification")
    @WebResult(targetNamespace = "http://Testing/xsd")
    @RequestWrapper(localName = "SPSVerification", targetNamespace = "http://Testing/xsd", className = "testing.xsd.SPSVerification")
    @ResponseWrapper(localName = "SPSVerificationResponse", targetNamespace = "http://Testing/xsd", className = "testing.xsd.SPSVerificationResponse")
    public String spsVerification(
        @WebParam(name = "UID_NUM", targetNamespace = "http://Testing/xsd")
        String uidNUM);

    /**
     * 
     * @param householdId
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetMultiSchemeBenifitsByHousehold", action = "urn:GetMultiSchemeBenifitsByHousehold")
    @WebResult(targetNamespace = "http://Testing/xsd")
    @RequestWrapper(localName = "GetMultiSchemeBenifitsByHousehold", targetNamespace = "http://Testing/xsd", className = "testing.xsd.GetMultiSchemeBenifitsByHousehold")
    @ResponseWrapper(localName = "GetMultiSchemeBenifitsByHouseholdResponse", targetNamespace = "http://Testing/xsd", className = "testing.xsd.GetMultiSchemeBenifitsByHouseholdResponse")
    public String getMultiSchemeBenifitsByHousehold(
        @WebParam(name = "Household_id", targetNamespace = "http://Testing/xsd")
        String householdId);

}
