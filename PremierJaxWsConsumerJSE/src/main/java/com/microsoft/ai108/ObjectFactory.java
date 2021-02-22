
package com.microsoft.ai108;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.microsoft.ai108 package. 
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

    private final static QName _SerialTestResponse_QNAME = new QName("http://ai108.microsoft.com", "serialTestResponse");
    private final static QName _SerialTest_QNAME = new QName("http://ai108.microsoft.com", "serialTest");
    private final static QName _Person_QNAME = new QName("http://ai108.microsoft.com", "person");
    private final static QName _AdditionResponse_QNAME = new QName("http://ai108.microsoft.com", "additionResponse");
    private final static QName _Pow_QNAME = new QName("http://ai108.microsoft.com", "pow");
    private final static QName _Addition_QNAME = new QName("http://ai108.microsoft.com", "addition");
    private final static QName _PowResponse_QNAME = new QName("http://ai108.microsoft.com", "powResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.microsoft.ai108
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SerialTestResponse }
     * 
     */
    public SerialTestResponse createSerialTestResponse() {
        return new SerialTestResponse();
    }

    /**
     * Create an instance of {@link AdditionResponse }
     * 
     */
    public AdditionResponse createAdditionResponse() {
        return new AdditionResponse();
    }

    /**
     * Create an instance of {@link Personne }
     * 
     */
    public Personne createPersonne() {
        return new Personne();
    }

    /**
     * Create an instance of {@link SerialTest }
     * 
     */
    public SerialTest createSerialTest() {
        return new SerialTest();
    }

    /**
     * Create an instance of {@link Pow }
     * 
     */
    public Pow createPow() {
        return new Pow();
    }

    /**
     * Create an instance of {@link PowResponse }
     * 
     */
    public PowResponse createPowResponse() {
        return new PowResponse();
    }

    /**
     * Create an instance of {@link Addition }
     * 
     */
    public Addition createAddition() {
        return new Addition();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SerialTestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ai108.microsoft.com", name = "serialTestResponse")
    public JAXBElement<SerialTestResponse> createSerialTestResponse(SerialTestResponse value) {
        return new JAXBElement<SerialTestResponse>(_SerialTestResponse_QNAME, SerialTestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SerialTest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ai108.microsoft.com", name = "serialTest")
    public JAXBElement<SerialTest> createSerialTest(SerialTest value) {
        return new JAXBElement<SerialTest>(_SerialTest_QNAME, SerialTest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Personne }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ai108.microsoft.com", name = "person")
    public JAXBElement<Personne> createPerson(Personne value) {
        return new JAXBElement<Personne>(_Person_QNAME, Personne.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdditionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ai108.microsoft.com", name = "additionResponse")
    public JAXBElement<AdditionResponse> createAdditionResponse(AdditionResponse value) {
        return new JAXBElement<AdditionResponse>(_AdditionResponse_QNAME, AdditionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Pow }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ai108.microsoft.com", name = "pow")
    public JAXBElement<Pow> createPow(Pow value) {
        return new JAXBElement<Pow>(_Pow_QNAME, Pow.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Addition }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ai108.microsoft.com", name = "addition")
    public JAXBElement<Addition> createAddition(Addition value) {
        return new JAXBElement<Addition>(_Addition_QNAME, Addition.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PowResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ai108.microsoft.com", name = "powResponse")
    public JAXBElement<PowResponse> createPowResponse(PowResponse value) {
        return new JAXBElement<PowResponse>(_PowResponse_QNAME, PowResponse.class, null, value);
    }

}
