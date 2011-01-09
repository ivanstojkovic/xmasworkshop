
package at.tuwien.sbc.task2.alternateimpl.ws.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "findTeddyPartsResponse", namespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "findTeddyPartsResponse", namespace = "http://tuwien.ac.at/sbc/task2/XMasWorkshopWarehouseService")
public class FindTeddyPartsResponse {

    @XmlElement(name = "return", namespace = "")
    private List<at.tuwien.sbc.task2.xwmodel.XMasWorkshopObject> _return;

    /**
     * 
     * @return
     *     returns List<XMasWorkshopObject>
     */
    public List<at.tuwien.sbc.task2.xwmodel.XMasWorkshopObject> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<at.tuwien.sbc.task2.xwmodel.XMasWorkshopObject> _return) {
        this._return = _return;
    }

}
