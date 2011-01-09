
package at.tuwien.sbc.task2.connection.webservice.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the at.tuwien.sbc.task2.connection.webservice.client package. 
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

    private final static QName _FindTeddyParts_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "findTeddyParts");
    private final static QName _Write_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "write");
    private final static QName _WriteResponse_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "writeResponse");
    private final static QName _FindTeddyBearsResponse_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "findTeddyBearsResponse");
    private final static QName _SayHello_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "sayHello");
    private final static QName _SayHelloResponse_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "sayHelloResponse");
    private final static QName _TryToAssembleTeddyBearResponse_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "tryToAssembleTeddyBearResponse");
    private final static QName _WritePart_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "writePart");
    private final static QName _WritePartResponse_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "writePartResponse");
    private final static QName _FindTeddyPartsResponse_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "findTeddyPartsResponse");
    private final static QName _TryToAssembleTeddyBear_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "tryToAssembleTeddyBear");
    private final static QName _FindTeddyBears_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "findTeddyBears");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: at.tuwien.sbc.task2.connection.webservice.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindTeddyPartsResponse }
     * 
     */
    public FindTeddyPartsResponse createFindTeddyPartsResponse() {
        return new FindTeddyPartsResponse();
    }

    /**
     * Create an instance of {@link WriteResponse }
     * 
     */
    public WriteResponse createWriteResponse() {
        return new WriteResponse();
    }

    /**
     * Create an instance of {@link Head }
     * 
     */
    public Head createHead() {
        return new Head();
    }

    /**
     * Create an instance of {@link TeddyBear }
     * 
     */
    public TeddyBear createTeddyBear() {
        return new TeddyBear();
    }

    /**
     * Create an instance of {@link FindTeddyBears }
     * 
     */
    public FindTeddyBears createFindTeddyBears() {
        return new FindTeddyBears();
    }

    /**
     * Create an instance of {@link Write }
     * 
     */
    public Write createWrite() {
        return new Write();
    }

    /**
     * Create an instance of {@link SayHelloResponse }
     * 
     */
    public SayHelloResponse createSayHelloResponse() {
        return new SayHelloResponse();
    }

    /**
     * Create an instance of {@link ProductionElf }
     * 
     */
    public ProductionElf createProductionElf() {
        return new ProductionElf();
    }

    /**
     * Create an instance of {@link Body }
     * 
     */
    public Body createBody() {
        return new Body();
    }

    /**
     * Create an instance of {@link Leg }
     * 
     */
    public Leg createLeg() {
        return new Leg();
    }

    /**
     * Create an instance of {@link TryToAssembleTeddyBearResponse }
     * 
     */
    public TryToAssembleTeddyBearResponse createTryToAssembleTeddyBearResponse() {
        return new TryToAssembleTeddyBearResponse();
    }

    /**
     * Create an instance of {@link Hat }
     * 
     */
    public Hat createHat() {
        return new Hat();
    }

    /**
     * Create an instance of {@link FindTeddyParts }
     * 
     */
    public FindTeddyParts createFindTeddyParts() {
        return new FindTeddyParts();
    }

    /**
     * Create an instance of {@link Hand }
     * 
     */
    public Hand createHand() {
        return new Hand();
    }

    /**
     * Create an instance of {@link WritePart }
     * 
     */
    public WritePart createWritePart() {
        return new WritePart();
    }

    /**
     * Create an instance of {@link WritePartResponse }
     * 
     */
    public WritePartResponse createWritePartResponse() {
        return new WritePartResponse();
    }

    /**
     * Create an instance of {@link FindTeddyBearsResponse }
     * 
     */
    public FindTeddyBearsResponse createFindTeddyBearsResponse() {
        return new FindTeddyBearsResponse();
    }

    /**
     * Create an instance of {@link TryToAssembleTeddyBear }
     * 
     */
    public TryToAssembleTeddyBear createTryToAssembleTeddyBear() {
        return new TryToAssembleTeddyBear();
    }

    /**
     * Create an instance of {@link SayHello }
     * 
     */
    public SayHello createSayHello() {
        return new SayHello();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindTeddyParts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", name = "findTeddyParts")
    public JAXBElement<FindTeddyParts> createFindTeddyParts(FindTeddyParts value) {
        return new JAXBElement<FindTeddyParts>(_FindTeddyParts_QNAME, FindTeddyParts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Write }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", name = "write")
    public JAXBElement<Write> createWrite(Write value) {
        return new JAXBElement<Write>(_Write_QNAME, Write.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WriteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", name = "writeResponse")
    public JAXBElement<WriteResponse> createWriteResponse(WriteResponse value) {
        return new JAXBElement<WriteResponse>(_WriteResponse_QNAME, WriteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindTeddyBearsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", name = "findTeddyBearsResponse")
    public JAXBElement<FindTeddyBearsResponse> createFindTeddyBearsResponse(FindTeddyBearsResponse value) {
        return new JAXBElement<FindTeddyBearsResponse>(_FindTeddyBearsResponse_QNAME, FindTeddyBearsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", name = "sayHello")
    public JAXBElement<SayHello> createSayHello(SayHello value) {
        return new JAXBElement<SayHello>(_SayHello_QNAME, SayHello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", name = "sayHelloResponse")
    public JAXBElement<SayHelloResponse> createSayHelloResponse(SayHelloResponse value) {
        return new JAXBElement<SayHelloResponse>(_SayHelloResponse_QNAME, SayHelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TryToAssembleTeddyBearResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", name = "tryToAssembleTeddyBearResponse")
    public JAXBElement<TryToAssembleTeddyBearResponse> createTryToAssembleTeddyBearResponse(TryToAssembleTeddyBearResponse value) {
        return new JAXBElement<TryToAssembleTeddyBearResponse>(_TryToAssembleTeddyBearResponse_QNAME, TryToAssembleTeddyBearResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WritePart }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", name = "writePart")
    public JAXBElement<WritePart> createWritePart(WritePart value) {
        return new JAXBElement<WritePart>(_WritePart_QNAME, WritePart.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WritePartResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", name = "writePartResponse")
    public JAXBElement<WritePartResponse> createWritePartResponse(WritePartResponse value) {
        return new JAXBElement<WritePartResponse>(_WritePartResponse_QNAME, WritePartResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindTeddyPartsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", name = "findTeddyPartsResponse")
    public JAXBElement<FindTeddyPartsResponse> createFindTeddyPartsResponse(FindTeddyPartsResponse value) {
        return new JAXBElement<FindTeddyPartsResponse>(_FindTeddyPartsResponse_QNAME, FindTeddyPartsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TryToAssembleTeddyBear }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", name = "tryToAssembleTeddyBear")
    public JAXBElement<TryToAssembleTeddyBear> createTryToAssembleTeddyBear(TryToAssembleTeddyBear value) {
        return new JAXBElement<TryToAssembleTeddyBear>(_TryToAssembleTeddyBear_QNAME, TryToAssembleTeddyBear.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindTeddyBears }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", name = "findTeddyBears")
    public JAXBElement<FindTeddyBears> createFindTeddyBears(FindTeddyBears value) {
        return new JAXBElement<FindTeddyBears>(_FindTeddyBears_QNAME, FindTeddyBears.class, null, value);
    }

}
