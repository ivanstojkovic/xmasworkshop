
package at.tuwien.sbc.task2.alternateimpl.worker.webservice.client;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for teddyBearPart.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="teddyBearPart">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="HEAD"/>
 *     &lt;enumeration value="BODY"/>
 *     &lt;enumeration value="ARM"/>
 *     &lt;enumeration value="LEG"/>
 *     &lt;enumeration value="HAT_RED"/>
 *     &lt;enumeration value="HAT_GREEN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "teddyBearPart")
@XmlEnum
public enum TeddyBearPart {

    HEAD,
    BODY,
    ARM,
    LEG,
    HAT_RED,
    HAT_GREEN;

    public String value() {
        return name();
    }

    public static TeddyBearPart fromValue(String v) {
        return valueOf(v);
    }

}
