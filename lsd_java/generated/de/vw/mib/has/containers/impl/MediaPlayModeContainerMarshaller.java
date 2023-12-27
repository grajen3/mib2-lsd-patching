/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.MediaPlayModeContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class MediaPlayModeContainerMarshaller
extends AbstractContainerMarshaller {
    public MediaPlayModeContainerMarshaller() {
        super(24);
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
            MediaPlayModeContainer mediaPlayModeContainer = (MediaPlayModeContainer)hASContainer;
            ArrayList arrayList = MediaPlayModeContainerMarshaller.borrowArrayList();
            if (mediaPlayModeContainer.isRepeatModeSet()) {
                MediaPlayModeContainerMarshaller.add((List)arrayList, MediaPlayModeContainerMarshaller.createIntElement(63, mediaPlayModeContainer.getRepeatMode()));
            }
            if (mediaPlayModeContainer.isMixModeSet()) {
                MediaPlayModeContainerMarshaller.add((List)arrayList, MediaPlayModeContainerMarshaller.createBooleanElement(64, mediaPlayModeContainer.getMixMode()));
            }
            if (mediaPlayModeContainer.isPMLTModeSet()) {
                MediaPlayModeContainerMarshaller.add((List)arrayList, MediaPlayModeContainerMarshaller.createBooleanElement(78, mediaPlayModeContainer.getPMLTMode()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            MediaPlayModeContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setIntElement(HASContainer hASContainer, int n, int n2) {
        switch (n) {
            case 63: {
                ((MediaPlayModeContainer)hASContainer).setRepeatMode(n2);
                break;
            }
            default: {
                super.setIntElement(hASContainer, n, n2);
            }
        }
    }

    @Override
    protected void setBooleanElement(HASContainer hASContainer, int n, boolean bl) {
        switch (n) {
            case 64: {
                ((MediaPlayModeContainer)hASContainer).setMixMode(bl);
                break;
            }
            case 78: {
                ((MediaPlayModeContainer)hASContainer).setPMLTMode(bl);
                break;
            }
            default: {
                super.setBooleanElement(hASContainer, n, bl);
            }
        }
    }
}

