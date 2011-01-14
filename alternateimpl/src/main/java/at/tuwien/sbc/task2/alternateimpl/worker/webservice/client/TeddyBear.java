
package at.tuwien.sbc.task2.alternateimpl.worker.webservice.client;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="doneTests">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="entry" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *                             &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "doneTests",
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
    @XmlElement(required = true)
    protected TeddyBear.DoneTests doneTests;
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
     * Gets the value of the doneTests property.
     * 
     * @return
     *     possible object is
     *     {@link TeddyBear.DoneTests }
     *     
     */
    public TeddyBear.DoneTests getDoneTests() {
        return doneTests;
    }

    /**
     * Sets the value of the doneTests property.
     * 
     * @param value
     *     allowed object is
     *     {@link TeddyBear.DoneTests }
     *     
     */
    public void setDoneTests(TeddyBear.DoneTests value) {
        this.doneTests = value;
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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="entry" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
     *                   &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "entry"
    })
    public static class DoneTests {

        protected List<TeddyBear.DoneTests.Entry> entry;

        /**
         * Gets the value of the entry property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the entry property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEntry().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link TeddyBear.DoneTests.Entry }
         * 
         * 
         */
        public List<TeddyBear.DoneTests.Entry> getEntry() {
            if (entry == null) {
                entry = new ArrayList<TeddyBear.DoneTests.Entry>();
            }
            return this.entry;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
         *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "key",
            "value"
        })
        public static class Entry {

            protected String key;
            protected Boolean value;

            /**
             * Gets the value of the key property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getKey() {
                return key;
            }

            /**
             * Sets the value of the key property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setKey(String value) {
                this.key = value;
            }

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link Boolean }
             *     
             */
            public Boolean isValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link Boolean }
             *     
             */
            public void setValue(Boolean value) {
                this.value = value;
            }

        }

    }

}
