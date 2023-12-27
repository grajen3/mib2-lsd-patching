/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.SoundVolumeRangeContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class SoundVolumeRangeContainerMarshaller
extends AbstractContainerMarshaller {
    public SoundVolumeRangeContainerMarshaller() {
        super(28);
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
            SoundVolumeRangeContainer soundVolumeRangeContainer = (SoundVolumeRangeContainer)hASContainer;
            ArrayList arrayList = SoundVolumeRangeContainerMarshaller.borrowArrayList();
            if (soundVolumeRangeContainer.isSourceSet()) {
                SoundVolumeRangeContainerMarshaller.add((List)arrayList, SoundVolumeRangeContainerMarshaller.createIntElement(61, soundVolumeRangeContainer.getSource()));
            }
            if (soundVolumeRangeContainer.isMinVolumeSet()) {
                SoundVolumeRangeContainerMarshaller.add((List)arrayList, SoundVolumeRangeContainerMarshaller.createIntElement(57, soundVolumeRangeContainer.getMinVolume()));
            }
            if (soundVolumeRangeContainer.isMaxVolumeSet()) {
                SoundVolumeRangeContainerMarshaller.add((List)arrayList, SoundVolumeRangeContainerMarshaller.createIntElement(58, soundVolumeRangeContainer.getMaxVolume()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            SoundVolumeRangeContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setIntElement(HASContainer hASContainer, int n, int n2) {
        switch (n) {
            case 61: {
                ((SoundVolumeRangeContainer)hASContainer).setSource(n2);
                break;
            }
            case 57: {
                ((SoundVolumeRangeContainer)hASContainer).setMinVolume(n2);
                break;
            }
            case 58: {
                ((SoundVolumeRangeContainer)hASContainer).setMaxVolume(n2);
                break;
            }
            default: {
                super.setIntElement(hASContainer, n, n2);
            }
        }
    }
}

