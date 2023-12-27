/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.SoundVolumeContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class SoundVolumeContainerMarshaller
extends AbstractContainerMarshaller {
    public SoundVolumeContainerMarshaller() {
        super(27);
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
            SoundVolumeContainer soundVolumeContainer = (SoundVolumeContainer)hASContainer;
            ArrayList arrayList = SoundVolumeContainerMarshaller.borrowArrayList();
            if (soundVolumeContainer.isSourceSet()) {
                SoundVolumeContainerMarshaller.add((List)arrayList, SoundVolumeContainerMarshaller.createIntElement(55, soundVolumeContainer.getSource()));
            }
            if (soundVolumeContainer.isVolumeSet()) {
                SoundVolumeContainerMarshaller.add((List)arrayList, SoundVolumeContainerMarshaller.createIntElement(56, soundVolumeContainer.getVolume()));
            }
            if (soundVolumeContainer.isEntertainmentMutedSet()) {
                SoundVolumeContainerMarshaller.add((List)arrayList, SoundVolumeContainerMarshaller.createBooleanElement(59, soundVolumeContainer.getEntertainmentMuted()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            SoundVolumeContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setIntElement(HASContainer hASContainer, int n, int n2) {
        switch (n) {
            case 55: {
                ((SoundVolumeContainer)hASContainer).setSource(n2);
                break;
            }
            case 56: {
                ((SoundVolumeContainer)hASContainer).setVolume(n2);
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
            case 59: {
                ((SoundVolumeContainer)hASContainer).setEntertainmentMuted(bl);
                break;
            }
            default: {
                super.setBooleanElement(hASContainer, n, bl);
            }
        }
    }
}

