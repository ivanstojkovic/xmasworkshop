
package at.tuwien.sbc.task2.alternateimpl.jaxws;

import java.util.ArrayList;
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
    private ArrayList<at.tuwien.sbc.task2.interfaces.TeddyPart> _return;

    /**
     * 
     * @return
     *     returns ArrayList<TeddyPart>
     */
    public ArrayList<at.tuwien.sbc.task2.interfaces.TeddyPart> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<at.tuwien.sbc.task2.interfaces.TeddyPart> _return) {
        this._return = _return;
    }

}
