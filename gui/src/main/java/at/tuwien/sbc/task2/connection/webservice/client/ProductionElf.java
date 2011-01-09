
package at.tuwien.sbc.task2.connection.webservice.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for productionElf complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="productionElf">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="errorRate" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="function" type="{http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService}teddyBearPart" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "productionElf", propOrder = {
    "errorRate",
    "function",
    "id",
    "quantity"
})
public class ProductionElf {

    protected int errorRate;
    protected TeddyBearPart function;
    protected String id;
    protected int quantity;

    /**
     * Gets the value of the errorRate property.
     * 
     */
    public int getErrorRate() {
        return errorRate;
    }

    /**
     * Sets the value of the errorRate property.
     * 
     */
    public void setErrorRate(int value) {
        this.errorRate = value;
    }

    /**
     * Gets the value of the function property.
     * 
     * @return
     *     possible object is
     *     {@link TeddyBearPart }
     *     
     */
    public TeddyBearPart getFunction() {
        return function;
    }

    /**
     * Sets the value of the function property.
     * 
     * @param value
     *     allowed object is
     *     {@link TeddyBearPart }
     *     
     */
    public void setFunction(TeddyBearPart value) {
        this.function = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     */
    public void setQuantity(int value) {
        this.quantity = value;
    }

}
