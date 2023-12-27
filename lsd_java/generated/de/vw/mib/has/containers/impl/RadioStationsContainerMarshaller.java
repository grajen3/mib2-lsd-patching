/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.RadioStationInfoContainer;
import generated.de.vw.mib.has.containers.RadioStationsContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;

public class RadioStationsContainerMarshaller
extends AbstractContainerMarshaller {
    public RadioStationsContainerMarshaller() {
        super(39);
    }

    @Override
    public void addChild(HASContainer hASContainer, HASContainer hASContainer2) {
        int n = this.getMarshallerContainerId();
        if (n != hASContainer.getContainerId()) {
            throw HASException.wrongContainerId(n, hASContainer.getContainerId());
        }
        RadioStationsContainer radioStationsContainer = (RadioStationsContainer)hASContainer;
        int n2 = hASContainer2.getContainerId();
        switch (n2) {
            case 26: {
                this.addStations(radioStationsContainer, (RadioStationInfoContainer)hASContainer2);
                break;
            }
            default: {
                throw HASException.invalidChild(n, n2);
            }
        }
    }

    private void addStations(RadioStationsContainer radioStationsContainer, RadioStationInfoContainer radioStationInfoContainer) {
        RadioStationInfoContainer[] radioStationInfoContainerArray = radioStationsContainer.getStations();
        if (null != radioStationInfoContainerArray) {
            RadioStationInfoContainer[] radioStationInfoContainerArray2 = new RadioStationInfoContainer[radioStationInfoContainerArray.length + 1];
            System.arraycopy((Object)radioStationInfoContainerArray, 0, (Object)radioStationInfoContainerArray2, 0, radioStationInfoContainerArray.length);
            radioStationInfoContainerArray2[radioStationInfoContainerArray.length] = radioStationInfoContainer;
            radioStationInfoContainerArray = radioStationInfoContainerArray2;
        } else {
            radioStationInfoContainerArray = new RadioStationInfoContainer[]{radioStationInfoContainer};
        }
        radioStationsContainer.setStations(radioStationInfoContainerArray);
    }

    @Override
    public void getChildren(HASContainer hASContainer, List list) {
        int n = this.getMarshallerContainerId();
        if (n != hASContainer.getContainerId()) {
            throw HASException.wrongContainerId(n, hASContainer.getContainerId());
        }
        RadioStationsContainer radioStationsContainer = (RadioStationsContainer)hASContainer;
        if (radioStationsContainer.isStationsSet()) {
            RadioStationsContainerMarshaller.add(list, radioStationsContainer.getStations());
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

