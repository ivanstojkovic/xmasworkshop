
package at.tuwien.sbc.task2.alternateimpl.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "writePart", namespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "writePart", namespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService", propOrder = {
    "arg0",
    "arg1",
    "arg2"
})
public class WritePart {

    @XmlElement(name = "arg0", namespace = "")
    private at.tuwien.sbc.task2.worker.production.ProductionElf arg0;
    @XmlElement(name = "arg1", namespace = "")
    private int arg1;
    @XmlElement(name = "arg2", namespace = "")
    private boolean arg2;

    /**
     * 
     * @return
     *     returns ProductionElf
     */
    public at.tuwien.sbc.task2.worker.production.ProductionElf getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(at.tuwien.sbc.task2.worker.production.ProductionElf arg0) {
        this.arg0 = arg0;
    }

    /**
     * 
     * @return
     *     returns int
     */
    public int getArg1() {
        return this.arg1;
    }

    /**
     * 
     * @param arg1
     *     the value for the arg1 property
     */
    public void setArg1(int arg1) {
        this.arg1 = arg1;
    }

    /**
     * 
     * @return
     *     returns boolean
     */
    public boolean isArg2() {
        return this.arg2;
    }

    /**
     * 
     * @param arg2
     *     the value for the arg2 property
     */
    public void setArg2(boolean arg2) {
        this.arg2 = arg2;
    }

}
