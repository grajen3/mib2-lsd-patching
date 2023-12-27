/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.VehicleStateContainer;
import generated.de.vw.mib.has.containers.VehicleStatesContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;

public class VehicleStatesContainerMarshaller
extends AbstractContainerMarshaller {
    public VehicleStatesContainerMarshaller() {
        super(63);
    }

    @Override
    public void addChild(HASContainer hASContainer, HASContainer hASContainer2) {
        int n = this.getMarshallerContainerId();
        if (n != hASContainer.getContainerId()) {
            throw HASException.wrongContainerId(n, hASContainer.getContainerId());
        }
        VehicleStatesContainer vehicleStatesContainer = (VehicleStatesContainer)hASContainer;
        int n2 = hASContainer2.getContainerId();
        switch (n2) {
            case 62: {
                this.addStates(vehicleStatesContainer, (VehicleStateContainer)hASContainer2);
                break;
            }
            default: {
                throw HASException.invalidChild(n, n2);
            }
        }
    }

    private void addStates(VehicleStatesContainer vehicleStatesContainer, VehicleStateContainer vehicleStateContainer) {
        VehicleStateContainer[] vehicleStateContainerArray = vehicleStatesContainer.getStates();
        if (null != vehicleStateContainerArray) {
            VehicleStateContainer[] vehicleStateContainerArray2 = new VehicleStateContainer[vehicleStateContainerArray.length + 1];
            System.arraycopy((Object)vehicleStateContainerArray, 0, (Object)vehicleStateContainerArray2, 0, vehicleStateContainerArray.length);
            vehicleStateContainerArray2[vehicleStateContainerArray.length] = vehicleStateContainer;
            vehicleStateContainerArray = vehicleStateContainerArray2;
        } else {
            vehicleStateContainerArray = new VehicleStateContainer[]{vehicleStateContainer};
        }
        vehicleStatesContainer.setStates(vehicleStateContainerArray);
    }

    @Override
    public void getChildren(HASContainer hASContainer, List list) {
        int n = this.getMarshallerContainerId();
        if (n != hASContainer.getContainerId()) {
            throw HASException.wrongContainerId(n, hASContainer.getContainerId());
        }
        VehicleStatesContainer vehicleStatesContainer = (VehicleStatesContainer)hASContainer;
        if (vehicleStatesContainer.isStatesSet()) {
            VehicleStatesContainerMarshaller.add(list, vehicleStatesContainer.getStates());
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

