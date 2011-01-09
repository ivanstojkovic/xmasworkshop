
package at.tuwien.sbc.task2.alternateimpl.worker.webservice.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for teddyBear complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="teddyBear">
 *   &lt;complexContent>
 *     &lt;extension base="{http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService}xMasWorkshopObject">
 *       &lt;sequence>
 *         &lt;element name="body" type="{http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService}body" minOccurs="0"/>
 *         &lt;element name="defective" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="hat" type="{http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService}hat" minOccurs="0"/>
 *         &lt;element name="head" type="{http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService}head" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="leftHand" type="{http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService}hand" minOccurs="0"/>
 *         &lt;element name="leftLeg" type="{http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService}leg" minOccurs="0"/>
 *         &lt;element name="ready" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="rightHand" type="{http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService}hand" minOccurs="0"/>
 *         &lt;element name="rightLeg" type="{http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService}leg" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "teddyBear", propOrder = {
    "body",
    "defective",
    "hat",
    "head",
    "id",
    "leftHand",
    "leftLeg",
    "ready",
    "rightHand",
    "rightLeg"
})
public class TeddyBear
    extends XMasWorkshopObject
{

    protected Body body;
    protected boolean defective;
    protected Hat hat;
    protected Head head;
    protected String id;
    protected Hand leftHand;
    protected Leg leftLeg;
    protected boolean ready;
    protected Hand rightHand;
    protected Leg rightLeg;

    /**
     * Gets the value of the body property.
     * 
     * @return
     *     possible object is
     *     {@link Body }
     *     
     */
    public Body getBody() {
        return body;
    }

    /**
     * Sets the value of the body property.
     * 
     * @param value
     *     allowed object is
     *     {@link Body }
     *     
     */
    public void setBody(Body value) {
        this.body = value;
    }

    /**
     * Gets the value of the defective property.
     * 
     */
    public boolean isDefective() {
        return defective;
    }

    /**
     * Sets the value of the defective property.
     * 
     */
    public void setDefective(boolean value) {
        this.defective = value;
    }

    /**
     * Gets the value of the hat property.
     * 
     * @return
     *     possible object is
     *     {@link Hat }
     *     
     */
    public Hat getHat() {
        return hat;
    }

    /**
     * Sets the value of the hat property.
     * 
     * @param value
     *     allowed object is
     *     {@link Hat }
     *     
     */
    public void setHat(Hat value) {
        this.hat = value;
    }

    /**
     * Gets the value of the head property.
     * 
     * @return
     *     possible object is
     *     {@link Head }
     *     
     */
    public Head getHead() {
        return head;
    }

    /**
     * Sets the value of the head property.
     * 
     * @param value
     *     allowed object is
     *     {@link Head }
     *     
     */
    public void setHead(Head value) {
        this.head = value;
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
     * Gets the value of the leftHand property.
     * 
     * @return
     *     possible object is
     *     {@link Hand }
     *     
     */
    public Hand getLeftHand() {
        return leftHand;
    }

    /**
     * Sets the value of the leftHand property.
     * 
     * @param value
     *     allowed object is
     *     {@link Hand }
     *     
     */
    public void setLeftHand(Hand value) {
        this.leftHand = value;
    }

    /**
     * Gets the value of the leftLeg property.
     * 
     * @return
     *     possible object is
     *     {@link Leg }
     *     
     */
    public Leg getLeftLeg() {
        return leftLeg;
    }

    /**
     * Sets the value of the leftLeg property.
     * 
     * @param value
     *     allowed object is
     *     {@link Leg }
     *     
     */
    public void setLeftLeg(Leg value) {
        this.leftLeg = value;
    }

    /**
     * Gets the value of the ready property.
     * 
     */
    public boolean isReady() {
        return ready;
    }

    /**
     * Sets the value of the ready property.
     * 
     */
    public void setReady(boolean value) {
        this.ready = value;
    }

    /**
     * Gets the value of the rightHand property.
     * 
     * @return
     *     possible object is
     *     {@link Hand }
     *     
     */
    public Hand getRightHand() {
        return rightHand;
    }

    /**
     * Sets the value of the rightHand property.
     * 
     * @param value
     *     allowed object is
     *     {@link Hand }
     *     
     */
    public void setRightHand(Hand value) {
        this.rightHand = value;
    }

    /**
     * Gets the value of the rightLeg property.
     * 
     * @return
     *     possible object is
     *     {@link Leg }
     *     
     */
    public Leg getRightLeg() {
        return rightLeg;
    }

    /**
     * Sets the value of the rightLeg property.
     * 
     * @param value
     *     allowed object is
     *     {@link Leg }
     *     
     */
    public void setRightLeg(Leg value) {
        this.rightLeg = value;
    }

}
