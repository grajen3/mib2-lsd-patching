/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.SoundVolumeRangeContainer;
import generated.de.vw.mib.has.containers.SoundVolumeRangesContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;

public class SoundVolumeRangesContainerMarshaller
extends AbstractContainerMarshaller {
    public SoundVolumeRangesContainerMarshaller() {
        super(29);
    }

    @Override
    public void addChild(HASContainer hASContainer, HASContainer hASContainer2) {
        int n = this.getMarshallerContainerId();
        if (n != hASContainer.getContainerId()) {
            throw HASException.wrongContainerId(n, hASContainer.getContainerId());
        }
        SoundVolumeRangesContainer soundVolumeRangesContainer = (SoundVolumeRangesContainer)hASContainer;
        int n2 = hASContainer2.getContainerId();
        switch (n2) {
            case 28: {
                this.addVolumeRanges(soundVolumeRangesContainer, (SoundVolumeRangeContainer)hASContainer2);
                break;
            }
            default: {
                throw HASException.invalidChild(n, n2);
            }
        }
    }

    private void addVolumeRanges(SoundVolumeRangesContainer soundVolumeRangesContainer, SoundVolumeRangeContainer soundVolumeRangeContainer) {
        SoundVolumeRangeContainer[] soundVolumeRangeContainerArray = soundVolumeRangesContainer.getVolumeRanges();
        if (null != soundVolumeRangeContainerArray) {
            SoundVolumeRangeContainer[] soundVolumeRangeContainerArray2 = new SoundVolumeRangeContainer[soundVolumeRangeContainerArray.length + 1];
            System.arraycopy((Object)soundVolumeRangeContainerArray, 0, (Object)soundVolumeRangeContainerArray2, 0, soundVolumeRangeContainerArray.length);
            soundVolumeRangeContainerArray2[soundVolumeRangeContainerArray.length] = soundVolumeRangeContainer;
            soundVolumeRangeContainerArray = soundVolumeRangeContainerArray2;
        } else {
            soundVolumeRangeContainerArray = new SoundVolumeRangeContainer[]{soundVolumeRangeContainer};
        }
        soundVolumeRangesContainer.setVolumeRanges(soundVolumeRangeContainerArray);
    }

    @Override
    public void getChildren(HASContainer hASContainer, List list) {
        int n = this.getMarshallerContainerId();
        if (n != hASContainer.getContainerId()) {
            throw HASException.wrongContainerId(n, hASContainer.getContainerId());
        }
        SoundVolumeRangesContainer soundVolumeRangesContainer = (SoundVolumeRangesContainer)hASContainer;
        if (soundVolumeRangesContainer.isVolumeRangesSet()) {
            SoundVolumeRangesContainerMarshaller.add(list, soundVolumeRangesContainer.getVolumeRanges());
        }
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
        }
        return hASDataContainer;
    }
}

