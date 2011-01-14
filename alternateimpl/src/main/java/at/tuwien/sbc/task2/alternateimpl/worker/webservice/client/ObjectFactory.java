
package at.tuwien.sbc.task2.alternateimpl.worker.webservice.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the at.tuwien.sbc.task2.alternateimpl.worker.webservice.client package. 
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

    private final static QName _Write_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "write");
    private final static QName _WriteResponse_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "writeResponse");
    private final static QName _FindReadyTeddyBearsResponse_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "findReadyTeddyBearsResponse");
    private final static QName _SayHelloResponse_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "sayHelloResponse");
    private final static QName _TryToAssembleTeddyBearResponse_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "tryToAssembleTeddyBearResponse");
    private final static QName _FindDefectiveTeddyBearsResponse_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "findDefectiveTeddyBearsResponse");
    private final static QName _TransportTeddyBear_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "transportTeddyBear");
    private final static QName _FindDefectiveTeddyBears_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "findDefectiveTeddyBears");
    private final static QName _WritePartResponse_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "writePartResponse");
    private final static QName _FindTeddyPartsResponse_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "findTeddyPartsResponse");
    private final static QName _FindTeddyParts_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "findTeddyParts");
    private final static QName _TransportTeddyBearResponse_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "transportTeddyBearResponse");
    private final static QName _FindReadyTeddyBears_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "findReadyTeddyBears");
    private final static QName _FindTeddyBearsResponse_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "findTeddyBearsResponse");
    private final static QName _TryToTestTeddyBearResponse_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "tryToTestTeddyBearResponse");
    private final static QName _SayHello_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "sayHello");
    private final static QName _WritePart_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "writePart");
    private final static QName _TryToAssembleTeddyBear_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "tryToAssembleTeddyBear");
    private final static QName _FindTeddyBears_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "findTeddyBears");
    private final static QName _TryToTestTeddyBear_QNAME = new QName("http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", "tryToTestTeddyBear");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: at.tuwien.sbc.task2.alternateimpl.worker.webservice.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SayHello }
     * 
     */
    public SayHello createSayHello() {
        return new SayHello();
    }

    /**
     * Create an instance of {@link FindDefectiveTeddyBearsResponse }
     * 
     */
    public FindDefectiveTeddyBearsResponse createFindDefectiveTeddyBearsResponse() {
        return new FindDefectiveTeddyBearsResponse();
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
     * Create an instance of {@link TryToAssembleTeddyBear }
     * 
     */
    public TryToAssembleTeddyBear createTryToAssembleTeddyBear() {
        return new TryToAssembleTeddyBear();
    }

    /**
     * Create an instance of {@link TeddyBear.DoneTests.Entry }
     * 
     */
    public TeddyBear.DoneTests.Entry createTeddyBearDoneTestsEntry() {
        return new TeddyBear.DoneTests.Entry();
    }

    /**
     * Create an instance of {@link TeddyBear.DoneTests }
     * 
     */
    public TeddyBear.DoneTests createTeddyBearDoneTests() {
        return new TeddyBear.DoneTests();
    }

    /**
     * Create an instance of {@link Leg }
     * 
     */
    public Leg createLeg() {
        return new Leg();
    }

    /**
     * Create an instance of {@link TeddyBear }
     * 
     */
    public TeddyBear createTeddyBear() {
        return new TeddyBear();
    }

    /**
     * Create an instance of {@link WritePart }
     * 
     */
    public WritePart createWritePart() {
        return new WritePart();
    }

    /**
     * Create an instance of {@link Head }
     * 
     */
    public Head createHead() {
        return new Head();
    }

    /**
     * Create an instance of {@link SayHelloResponse }
     * 
     */
    public SayHelloResponse createSayHelloResponse() {
        return new SayHelloResponse();
    }

    /**
     * Create an instance of {@link TryToAssembleTeddyBearResponse }
     * 
     */
    public TryToAssembleTeddyBearResponse createTryToAssembleTeddyBearResponse() {
        return new TryToAssembleTeddyBearResponse();
    }

    /**
     * Create an instance of {@link WriteResponse }
     * 
     */
    public WriteResponse createWriteResponse() {
        return new WriteResponse();
    }

    /**
     * Create an instance of {@link TransportTeddyBear }
     * 
     */
    public TransportTeddyBear createTransportTeddyBear() {
        return new TransportTeddyBear();
    }

    /**
     * Create an instance of {@link ProductionElf }
     * 
     */
    public ProductionElf createProductionElf() {
        return new ProductionElf();
    }

    /**
     * Create an instance of {@link FindReadyTeddyBears }
     * 
     */
    public FindReadyTeddyBears createFindReadyTeddyBears() {
        return new FindReadyTeddyBears();
    }

    /**
     * Create an instance of {@link WritePartResponse }
     * 
     */
    public WritePartResponse createWritePartResponse() {
        return new WritePartResponse();
    }

    /**
     * Create an instance of {@link Hand }
     * 
     */
    public Hand createHand() {
        return new Hand();
    }

    /**
     * Create an instance of {@link FindDefectiveTeddyBears }
     * 
     */
    public FindDefectiveTeddyBears createFindDefectiveTeddyBears() {
        return new FindDefectiveTeddyBears();
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
     * Create an instance of {@link Body }
     * 
     */
    public Body createBody() {
        return new Body();
    }

    /**
     * Create an instance of {@link FindTeddyBearsResponse }
     * 
     */
    public FindTeddyBearsResponse createFindTeddyBearsResponse() {
        return new FindTeddyBearsResponse();
    }

    /**
     * Create an instance of {@link FindTeddyPartsResponse }
     * 
     */
    public FindTeddyPartsResponse createFindTeddyPartsResponse() {
        return new FindTeddyPartsResponse();
    }

    /**
     * Create an instance of {@link TransportTeddyBearResponse }
     * 
     */
    public TransportTeddyBearResponse createTransportTeddyBearResponse() {
        return new TransportTeddyBearResponse();
    }

    /**
     * Create an instance of {@link FindReadyTeddyBearsResponse }
     * 
     */
    public FindReadyTeddyBearsResponse createFindReadyTeddyBearsResponse() {
        return new FindReadyTeddyBearsResponse();
    }

    /**
     * Create an instance of {@link TryToTestTeddyBearResponse }
     * 
     */
    public TryToTestTeddyBearResponse createTryToTestTeddyBearResponse() {
        return new TryToTestTeddyBearResponse();
    }

    /**
     * Create an instance of {@link TryToTestTeddyBear }
     * 
     */
    public TryToTestTeddyBear createTryToTestTeddyBear() {
        return new TryToTestTeddyBear();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link FindReadyTeddyBearsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", name = "findReadyTeddyBearsResponse")
    public JAXBElement<FindReadyTeddyBearsResponse> createFindReadyTeddyBearsResponse(FindReadyTeddyBearsResponse value) {
        return new JAXBElement<FindReadyTeddyBearsResponse>(_FindReadyTeddyBearsResponse_QNAME, FindReadyTeddyBearsResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link FindDefectiveTeddyBearsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", name = "findDefectiveTeddyBearsResponse")
    public JAXBElement<FindDefectiveTeddyBearsResponse> createFindDefectiveTeddyBearsResponse(FindDefectiveTeddyBearsResponse value) {
        return new JAXBElement<FindDefectiveTeddyBearsResponse>(_FindDefectiveTeddyBearsResponse_QNAME, FindDefectiveTeddyBearsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransportTeddyBear }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", name = "transportTeddyBear")
    public JAXBElement<TransportTeddyBear> createTransportTeddyBear(TransportTeddyBear value) {
        return new JAXBElement<TransportTeddyBear>(_TransportTeddyBear_QNAME, TransportTeddyBear.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindDefectiveTeddyBears }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", name = "findDefectiveTeddyBears")
    public JAXBElement<FindDefectiveTeddyBears> createFindDefectiveTeddyBears(FindDefectiveTeddyBears value) {
        return new JAXBElement<FindDefectiveTeddyBears>(_FindDefectiveTeddyBears_QNAME, FindDefectiveTeddyBears.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link FindTeddyParts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", name = "findTeddyParts")
    public JAXBElement<FindTeddyParts> createFindTeddyParts(FindTeddyParts value) {
        return new JAXBElement<FindTeddyParts>(_FindTeddyParts_QNAME, FindTeddyParts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransportTeddyBearResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", name = "transportTeddyBearResponse")
    public JAXBElement<TransportTeddyBearResponse> createTransportTeddyBearResponse(TransportTeddyBearResponse value) {
        return new JAXBElement<TransportTeddyBearResponse>(_TransportTeddyBearResponse_QNAME, TransportTeddyBearResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindReadyTeddyBears }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", name = "findReadyTeddyBears")
    public JAXBElement<FindReadyTeddyBears> createFindReadyTeddyBears(FindReadyTeddyBears value) {
        return new JAXBElement<FindReadyTeddyBears>(_FindReadyTeddyBears_QNAME, FindReadyTeddyBears.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link TryToTestTeddyBearResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", name = "tryToTestTeddyBearResponse")
    public JAXBElement<TryToTestTeddyBearResponse> createTryToTestTeddyBearResponse(TryToTestTeddyBearResponse value) {
        return new JAXBElement<TryToTestTeddyBearResponse>(_TryToTestTeddyBearResponse_QNAME, TryToTestTeddyBearResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link WritePart }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", name = "writePart")
    public JAXBElement<WritePart> createWritePart(WritePart value) {
        return new JAXBElement<WritePart>(_WritePart_QNAME, WritePart.class, null, value);
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

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TryToTestTeddyBear }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", name = "tryToTestTeddyBear")
    public JAXBElement<TryToTestTeddyBear> createTryToTestTeddyBear(TryToTestTeddyBear value) {
        return new JAXBElement<TryToTestTeddyBear>(_TryToTestTeddyBear_QNAME, TryToTestTeddyBear.class, null, value);
    }

}
