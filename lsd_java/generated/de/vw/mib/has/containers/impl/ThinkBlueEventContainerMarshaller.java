/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.ThinkBlueEventContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class ThinkBlueEventContainerMarshaller
extends AbstractContainerMarshaller {
    public ThinkBlueEventContainerMarshaller() {
        super(54);
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
            ThinkBlueEventContainer thinkBlueEventContainer = (ThinkBlueEventContainer)hASContainer;
            ArrayList arrayList = ThinkBlueEventContainerMarshaller.borrowArrayList();
            if (thinkBlueEventContainer.isDescriptionSet()) {
                ThinkBlueEventContainerMarshaller.add((List)arrayList, ThinkBlueEventContainerMarshaller.createStringElement(121, thinkBlueEventContainer.getDescription()));
            }
            if (thinkBlueEventContainer.isTimeStampSet()) {
                ThinkBlueEventContainerMarshaller.add((List)arrayList, ThinkBlueEventContainerMarshaller.createLongElement(122, thinkBlueEventContainer.getTimeStamp()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            ThinkBlueEventContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setStringElement(HASContainer hASContainer, int n, String string) {
        switch (n) {
            case 121: {
                ((ThinkBlueEventContainer)hASContainer).setDescription(string);
                break;
            }
            default: {
                super.setStringElement(hASContainer, n, string);
            }
        }
    }

    @Override
    protected void setLongElement(HASContainer hASContainer, int n, long l) {
        switch (n) {
            case 122: {
                ((ThinkBlueEventContainer)hASContainer).setTimeStamp(l);
                break;
            }
            default: {
                super.setLongElement(hASContainer, n, l);
            }
        }
    }
}

