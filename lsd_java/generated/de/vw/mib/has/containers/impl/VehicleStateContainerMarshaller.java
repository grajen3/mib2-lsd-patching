/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.VehicleStateContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class VehicleStateContainerMarshaller
extends AbstractContainerMarshaller {
    public VehicleStateContainerMarshaller() {
        super(62);
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
            VehicleStateContainer vehicleStateContainer = (VehicleStateContainer)hASContainer;
            ArrayList arrayList = VehicleStateContainerMarshaller.borrowArrayList();
            if (vehicleStateContainer.isWarnIdSet()) {
                VehicleStateContainerMarshaller.add((List)arrayList, VehicleStateContainerMarshaller.createIntElement(141, vehicleStateContainer.getWarnId()));
            }
            if (vehicleStateContainer.isDynamicValueSet()) {
                VehicleStateContainerMarshaller.add((List)arrayList, VehicleStateContainerMarshaller.createStringElement(142, vehicleStateContainer.getDynamicValue()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            VehicleStateContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setIntElement(HASContainer hASContainer, int n, int n2) {
        switch (n) {
            case 141: {
                ((VehicleStateContainer)hASContainer).setWarnId(n2);
                break;
            }
            default: {
                super.setIntElement(hASContainer, n, n2);
            }
        }
    }

    @Override
    protected void setStringElement(HASContainer hASContainer, int n, String string) {
        switch (n) {
            case 142: {
                ((VehicleStateContainer)hASContainer).setDynamicValue(string);
                break;
            }
            default: {
                super.setStringElement(hASContainer, n, string);
            }
        }
    }
}

