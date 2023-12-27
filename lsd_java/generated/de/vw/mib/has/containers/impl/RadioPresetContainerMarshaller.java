/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.RadioPresetContainer;
import generated.de.vw.mib.has.containers.RadioStationInfoContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class RadioPresetContainerMarshaller
extends AbstractContainerMarshaller {
    public RadioPresetContainerMarshaller() {
        super(40);
    }

    @Override
    public void addChild(HASContainer hASContainer, HASContainer hASContainer2) {
        int n = this.getMarshallerContainerId();
        if (n != hASContainer.getContainerId()) {
            throw HASException.wrongContainerId(n, hASContainer.getContainerId());
        }
        RadioPresetContainer radioPresetContainer = (RadioPresetContainer)hASContainer;
        int n2 = hASContainer2.getContainerId();
        switch (n2) {
            case 26: {
                this.addStation(radioPresetContainer, (RadioStationInfoContainer)hASContainer2);
                break;
            }
            default: {
                throw HASException.invalidChild(n, n2);
            }
        }
    }

    private void addStation(RadioPresetContainer radioPresetContainer, RadioStationInfoContainer radioStationInfoContainer) {
        if (radioPresetContainer.isStationSet()) {
            throw HASException.invalidMultipleChildren(this.getMarshallerContainerId(), radioStationInfoContainer.getContainerId());
        }
        radioPresetContainer.setStation(radioStationInfoContainer);
    }

    @Override
    public void getChildren(HASContainer hASContainer, List list) {
        int n = this.getMarshallerContainerId();
        if (n != hASContainer.getContainerId()) {
            throw HASException.wrongContainerId(n, hASContainer.getContainerId());
        }
        RadioPresetContainer radioPresetContainer = (RadioPresetContainer)hASContainer;
        if (radioPresetContainer.isStationSet()) {
            RadioPresetContainerMarshaller.add(list, radioPresetContainer.getStation());
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
            RadioPresetContainer radioPresetContainer = (RadioPresetContainer)hASContainer;
            ArrayList arrayList = RadioPresetContainerMarshaller.borrowArrayList();
            if (radioPresetContainer.isPresetLogoSet()) {
                RadioPresetContainerMarshaller.add((List)arrayList, RadioPresetContainerMarshaller.createResourceLocatorElement(89, radioPresetContainer.getPresetLogo()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            RadioPresetContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setResourceLocatorElement(HASContainer hASContainer, int n, ResourceLocator resourceLocator) {
        switch (n) {
            case 89: {
                ((RadioPresetContainer)hASContainer).setPresetLogo(resourceLocator);
                break;
            }
            default: {
                super.setResourceLocatorElement(hASContainer, n, resourceLocator);
            }
        }
    }
}

