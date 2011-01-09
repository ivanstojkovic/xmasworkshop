
package at.tuwien.sbc.task2.alternateimpl.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "write", namespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "write", namespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService")
public class Write {

    @XmlElement(name = "arg0", namespace = "")
    private at.tuwien.sbc.task2.interfaces.XMasWorkshopEntry arg0;

    /**
     * 
     * @return
     *     returns XMasWorkshopEntry
     */
    public at.tuwien.sbc.task2.interfaces.XMasWorkshopEntry getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(at.tuwien.sbc.task2.interfaces.XMasWorkshopEntry arg0) {
        this.arg0 = arg0;
    }

}
