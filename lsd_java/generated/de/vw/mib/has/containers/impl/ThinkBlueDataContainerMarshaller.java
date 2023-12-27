/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.ThinkBlueDataContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class ThinkBlueDataContainerMarshaller
extends AbstractContainerMarshaller {
    public ThinkBlueDataContainerMarshaller() {
        super(44);
    }

    @Override
    public HASDataContainer marshal(HASContainer hASContainer) {
        HASDataContainer hASDataContainer;
        int n = this.getMarshallerContainerId();
        if (null == hASContainer) {
            hASDataContainer = null;
        } else {
            if (n != hASContainer.getContainerId()) {
                throw HASException.wrongContainerId(n, hASContainer.getContainerId());
            }
            hASDataContainer = new HASDataContainer();
            hASDataContainer.containerId = n;
            hASDataContainer.elementId = hASContainer.getElementId();
            ThinkBlueDataContainer thinkBlueDataContainer = (ThinkBlueDataContainer)hASContainer;
            ArrayList arrayList = ThinkBlueDataContainerMarshaller.borrowArrayList();
            if (thinkBlueDataContainer.isAvgShortSet()) {
                ThinkBlueDataContainerMarshaller.add((List)arrayList, ThinkBlueDataContainerMarshaller.createIntElement(97, thinkBlueDataContainer.getAvgShort()));
            }
            if (thinkBlueDataContainer.isAvgTripSet()) {
                ThinkBlueDataContainerMarshaller.add((List)arrayList, ThinkBlueDataContainerMarshaller.createIntElement(98, thinkBlueDataContainer.getAvgTrip()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            ThinkBlueDataContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setIntElement(HASContainer hASContainer, int n, int n2) {
        switch (n) {
            case 97: {
                ((ThinkBlueDataContainer)hASContainer).setAvgShort(n2);
                break;
            }
            case 98: {
                ((ThinkBlueDataContainer)hASContainer).setAvgTrip(n2);
                break;
            }
            default: {
                super.setIntElement(hASContainer, n, n2);
            }
        }
    }
}

