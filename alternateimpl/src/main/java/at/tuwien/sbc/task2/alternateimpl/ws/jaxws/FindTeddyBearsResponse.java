
package at.tuwien.sbc.task2.alternateimpl.ws.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "findTeddyBearsResponse", namespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findTeddyBearsResponse", namespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService")
public class FindTeddyBearsResponse {

    @XmlElement(name = "return", namespace = "")
    private List<at.tuwien.sbc.task2.xwmodel.TeddyBear> _return;

    /**
     * 
     * @return
     *     returns List<TeddyBear>
     */
    public List<at.tuwien.sbc.task2.xwmodel.TeddyBear> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<at.tuwien.sbc.task2.xwmodel.TeddyBear> _return) {
        this._return = _return;
    }

}
