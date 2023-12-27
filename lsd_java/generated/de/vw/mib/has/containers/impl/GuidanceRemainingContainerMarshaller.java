/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.GuidanceRemainingContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class GuidanceRemainingContainerMarshaller
extends AbstractContainerMarshaller {
    public GuidanceRemainingContainerMarshaller() {
        super(25);
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
            GuidanceRemainingContainer guidanceRemainingContainer = (GuidanceRemainingContainer)hASContainer;
            ArrayList arrayList = GuidanceRemainingContainerMarshaller.borrowArrayList();
            if (guidanceRemainingContainer.isTimeToDestinationSet()) {
                GuidanceRemainingContainerMarshaller.add((List)arrayList, GuidanceRemainingContainerMarshaller.createIntElement(49, guidanceRemainingContainer.getTimeToDestination()));
            }
            if (guidanceRemainingContainer.isDistanceToDestinationSet()) {
                GuidanceRemainingContainerMarshaller.add((List)arrayList, GuidanceRemainingContainerMarshaller.createIntElement(50, guidanceRemainingContainer.getDistanceToDestination()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            GuidanceRemainingContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setIntElement(HASContainer hASContainer, int n, int n2) {
        switch (n) {
            case 49: {
                ((GuidanceRemainingContainer)hASContainer).setTimeToDestination(n2);
                break;
            }
            case 50: {
                ((GuidanceRemainingContainer)hASContainer).setDistanceToDestination(n2);
                break;
            }
            default: {
                super.setIntElement(hASContainer, n, n2);
            }
        }
    }
}

