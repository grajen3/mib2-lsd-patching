/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.RadioPresetContainer;
import generated.de.vw.mib.has.containers.RadioPresetsContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;

public class RadioPresetsContainerMarshaller
extends AbstractContainerMarshaller {
    public RadioPresetsContainerMarshaller() {
        super(41);
    }

    @Override
    public void addChild(HASContainer hASContainer, HASContainer hASContainer2) {
        int n = this.getMarshallerContainerId();
        if (n != hASContainer.getContainerId()) {
            throw HASException.wrongContainerId(n, hASContainer.getContainerId());
        }
        RadioPresetsContainer radioPresetsContainer = (RadioPresetsContainer)hASContainer;
        int n2 = hASContainer2.getContainerId();
        switch (n2) {
            case 40: {
                this.addStations(radioPresetsContainer, (RadioPresetContainer)hASContainer2);
                break;
            }
            default: {
                throw HASException.invalidChild(n, n2);
            }
        }
    }

    private void addStations(RadioPresetsContainer radioPresetsContainer, RadioPresetContainer radioPresetContainer) {
        RadioPresetContainer[] radioPresetContainerArray = radioPresetsContainer.getStations();
        if (null != radioPresetContainerArray) {
            RadioPresetContainer[] radioPresetContainerArray2 = new RadioPresetContainer[radioPresetContainerArray.length + 1];
            System.arraycopy((Object)radioPresetContainerArray, 0, (Object)radioPresetContainerArray2, 0, radioPresetContainerArray.length);
            radioPresetContainerArray2[radioPresetContainerArray.length] = radioPresetContainer;
            radioPresetContainerArray = radioPresetContainerArray2;
        } else {
            radioPresetContainerArray = new RadioPresetContainer[]{radioPresetContainer};
        }
        radioPresetsContainer.setStations(radioPresetContainerArray);
    }

    @Override
    public void getChildren(HASContainer hASContainer, List list) {
        int n = this.getMarshallerContainerId();
        if (n != hASContainer.getContainerId()) {
            throw HASException.wrongContainerId(n, hASContainer.getContainerId());
        }
        RadioPresetsContainer radioPresetsContainer = (RadioPresetsContainer)hASContainer;
        if (radioPresetsContainer.isStationsSet()) {
            RadioPresetsContainerMarshaller.add(list, radioPresetsContainer.getStations());
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

