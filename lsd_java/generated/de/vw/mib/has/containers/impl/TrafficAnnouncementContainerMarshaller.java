/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.TrafficAnnouncementContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class TrafficAnnouncementContainerMarshaller
extends AbstractContainerMarshaller {
    public TrafficAnnouncementContainerMarshaller() {
        super(51);
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
            TrafficAnnouncementContainer trafficAnnouncementContainer = (TrafficAnnouncementContainer)hASContainer;
            ArrayList arrayList = TrafficAnnouncementContainerMarshaller.borrowArrayList();
            if (trafficAnnouncementContainer.isActiveSet()) {
                TrafficAnnouncementContainerMarshaller.add((List)arrayList, TrafficAnnouncementContainerMarshaller.createBooleanElement(111, trafficAnnouncementContainer.getActive()));
            }
            if (trafficAnnouncementContainer.isStationNameSet()) {
                TrafficAnnouncementContainerMarshaller.add((List)arrayList, TrafficAnnouncementContainerMarshaller.createStringElement(112, trafficAnnouncementContainer.getStationName()));
            }
            if (trafficAnnouncementContainer.isFrequencySet()) {
                TrafficAnnouncementContainerMarshaller.add((List)arrayList, TrafficAnnouncementContainerMarshaller.createLongElement(113, trafficAnnouncementContainer.getFrequency()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            TrafficAnnouncementContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setBooleanElement(HASContainer hASContainer, int n, boolean bl) {
        switch (n) {
            case 111: {
                ((TrafficAnnouncementContainer)hASContainer).setActive(bl);
                break;
            }
            default: {
                super.setBooleanElement(hASContainer, n, bl);
            }
        }
    }

    @Override
    protected void setStringElement(HASContainer hASContainer, int n, String string) {
        switch (n) {
            case 112: {
                ((TrafficAnnouncementContainer)hASContainer).setStationName(string);
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
            case 113: {
                ((TrafficAnnouncementContainer)hASContainer).setFrequency(l);
                break;
            }
            default: {
                super.setLongElement(hASContainer, n, l);
            }
        }
    }
}

