
package testing.xsd;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the testing.xsd package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetMultiSchemeBenifitsByHouseholdResponseReturn_QNAME = new QName("http://Testing/xsd", "return");
    private final static QName _GetCitizenNameInforamationMobileNumber_QNAME = new QName("http://Testing/xsd", "mobileNumber");
    private final static QName _DeathDetailsDate_QNAME = new QName("http://Testing/xsd", "Date");
    private final static QName _SPSVerificationUIDNUM_QNAME = new QName("http://Testing/xsd", "UID_NUM");
    private final static QName _GetMultiSchemeBenifitsByHouseholdHouseholdId_QNAME = new QName("http://Testing/xsd", "Household_id");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: testing.xsd
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMultiSchemeBenifitsByHouseholdResponse }
     * 
     */
    public GetMultiSchemeBenifitsByHouseholdResponse createGetMultiSchemeBenifitsByHouseholdResponse() {
        return new GetMultiSchemeBenifitsByHouseholdResponse();
    }

    /**
     * Create an instance of {@link GetMultiSchemeBenifitsByHousehold }
     * 
     */
    public GetMultiSchemeBenifitsByHousehold createGetMultiSchemeBenifitsByHousehold() {
        return new GetMultiSchemeBenifitsByHousehold();
    }

    /**
     * Create an instance of {@link GetCitizenNameInforamation }
     * 
     */
    public GetCitizenNameInforamation createGetCitizenNameInforamation() {
        return new GetCitizenNameInforamation();
    }

    /**
     * Create an instance of {@link DeathDetails }
     * 
     */
    public DeathDetails createDeathDetails() {
        return new DeathDetails();
    }

    /**
     * Create an instance of {@link SPSVerificationResponse }
     * 
     */
    public SPSVerificationResponse createSPSVerificationResponse() {
        return new SPSVerificationResponse();
    }

    /**
     * Create an instance of {@link DeathDetailsResponse }
     * 
     */
    public DeathDetailsResponse createDeathDetailsResponse() {
        return new DeathDetailsResponse();
    }

    /**
     * Create an instance of {@link SPSVerification }
     * 
     */
    public SPSVerification createSPSVerification() {
        return new SPSVerification();
    }

    /**
     * Create an instance of {@link GetCitizenNameInforamationResponse }
     * 
     */
    public GetCitizenNameInforamationResponse createGetCitizenNameInforamationResponse() {
        return new GetCitizenNameInforamationResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Testing/xsd", name = "return", scope = GetMultiSchemeBenifitsByHouseholdResponse.class)
    public JAXBElement<String> createGetMultiSchemeBenifitsByHouseholdResponseReturn(String value) {
        return new JAXBElement<String>(_GetMultiSchemeBenifitsByHouseholdResponseReturn_QNAME, String.class, GetMultiSchemeBenifitsByHouseholdResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Testing/xsd", name = "mobileNumber", scope = GetCitizenNameInforamation.class)
    public JAXBElement<String> createGetCitizenNameInforamationMobileNumber(String value) {
        return new JAXBElement<String>(_GetCitizenNameInforamationMobileNumber_QNAME, String.class, GetCitizenNameInforamation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Testing/xsd", name = "Date", scope = DeathDetails.class)
    public JAXBElement<String> createDeathDetailsDate(String value) {
        return new JAXBElement<String>(_DeathDetailsDate_QNAME, String.class, DeathDetails.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Testing/xsd", name = "UID_NUM", scope = SPSVerification.class)
    public JAXBElement<String> createSPSVerificationUIDNUM(String value) {
        return new JAXBElement<String>(_SPSVerificationUIDNUM_QNAME, String.class, SPSVerification.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Testing/xsd", name = "return", scope = GetCitizenNameInforamationResponse.class)
    public JAXBElement<String> createGetCitizenNameInforamationResponseReturn(String value) {
        return new JAXBElement<String>(_GetMultiSchemeBenifitsByHouseholdResponseReturn_QNAME, String.class, GetCitizenNameInforamationResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Testing/xsd", name = "return", scope = SPSVerificationResponse.class)
    public JAXBElement<String> createSPSVerificationResponseReturn(String value) {
        return new JAXBElement<String>(_GetMultiSchemeBenifitsByHouseholdResponseReturn_QNAME, String.class, SPSVerificationResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Testing/xsd", name = "Household_id", scope = GetMultiSchemeBenifitsByHousehold.class)
    public JAXBElement<String> createGetMultiSchemeBenifitsByHouseholdHouseholdId(String value) {
        return new JAXBElement<String>(_GetMultiSchemeBenifitsByHouseholdHouseholdId_QNAME, String.class, GetMultiSchemeBenifitsByHousehold.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://Testing/xsd", name = "return", scope = DeathDetailsResponse.class)
    public JAXBElement<String> createDeathDetailsResponseReturn(String value) {
        return new JAXBElement<String>(_GetMultiSchemeBenifitsByHouseholdResponseReturn_QNAME, String.class, DeathDetailsResponse.class, value);
    }

}
