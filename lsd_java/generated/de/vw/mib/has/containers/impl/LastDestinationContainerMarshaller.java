/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.LastDestinationContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class LastDestinationContainerMarshaller
extends AbstractContainerMarshaller {
    public LastDestinationContainerMarshaller() {
        super(36);
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
            LastDestinationContainer lastDestinationContainer = (LastDestinationContainer)hASContainer;
            ArrayList arrayList = LastDestinationContainerMarshaller.borrowArrayList();
            if (lastDestinationContainer.isDescriptorSet()) {
                LastDestinationContainerMarshaller.add((List)arrayList, LastDestinationContainerMarshaller.createStringElement(74, lastDestinationContainer.getDescriptor()));
            }
            if (lastDestinationContainer.isIdSet()) {
                LastDestinationContainerMarshaller.add((List)arrayList, LastDestinationContainerMarshaller.createIntElement(75, lastDestinationContainer.getId()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            LastDestinationContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setStringElement(HASContainer hASContainer, int n, String string) {
        switch (n) {
            case 74: {
                ((LastDestinationContainer)hASContainer).setDescriptor(string);
                break;
            }
            default: {
                super.setStringElement(hASContainer, n, string);
            }
        }
    }

    @Override
    protected void setIntElement(HASContainer hASContainer, int n, int n2) {
        switch (n) {
            case 75: {
                ((LastDestinationContainer)hASContainer).setId(n2);
                break;
            }
            default: {
                super.setIntElement(hASContainer, n, n2);
            }
        }
    }
}

