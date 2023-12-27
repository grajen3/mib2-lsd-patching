/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.MediaPlayInfoContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class MediaPlayInfoContainerMarshaller
extends AbstractContainerMarshaller {
    public MediaPlayInfoContainerMarshaller() {
        super(23);
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
            MediaPlayInfoContainer mediaPlayInfoContainer = (MediaPlayInfoContainer)hASContainer;
            ArrayList arrayList = MediaPlayInfoContainerMarshaller.borrowArrayList();
            if (mediaPlayInfoContainer.isStateSet()) {
                MediaPlayInfoContainerMarshaller.add((List)arrayList, MediaPlayInfoContainerMarshaller.createIntElement(66, mediaPlayInfoContainer.getState()));
            }
            if (mediaPlayInfoContainer.isTrackPositionSet()) {
                MediaPlayInfoContainerMarshaller.add((List)arrayList, MediaPlayInfoContainerMarshaller.createIntElement(45, mediaPlayInfoContainer.getTrackPosition()));
            }
            if (mediaPlayInfoContainer.isEntryTypeSet()) {
                MediaPlayInfoContainerMarshaller.add((List)arrayList, MediaPlayInfoContainerMarshaller.createIntElement(60, mediaPlayInfoContainer.getEntryType()));
            }
            if (mediaPlayInfoContainer.isEntryIdSet()) {
                MediaPlayInfoContainerMarshaller.add((List)arrayList, MediaPlayInfoContainerMarshaller.createLongElement(46, mediaPlayInfoContainer.getEntryId()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            MediaPlayInfoContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setIntElement(HASContainer hASContainer, int n, int n2) {
        switch (n) {
            case 66: {
                ((MediaPlayInfoContainer)hASContainer).setState(n2);
                break;
            }
            case 45: {
                ((MediaPlayInfoContainer)hASContainer).setTrackPosition(n2);
                break;
            }
            case 60: {
                ((MediaPlayInfoContainer)hASContainer).setEntryType(n2);
                break;
            }
            default: {
                super.setIntElement(hASContainer, n, n2);
            }
        }
    }

    @Override
    protected void setLongElement(HASContainer hASContainer, int n, long l) {
        switch (n) {
            case 46: {
                ((MediaPlayInfoContainer)hASContainer).setEntryId(l);
                break;
            }
            default: {
                super.setLongElement(hASContainer, n, l);
            }
        }
    }
}

