/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.EncodedVehicleTypeContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class EncodedVehicleTypeContainerMarshaller
extends AbstractContainerMarshaller {
    public EncodedVehicleTypeContainerMarshaller() {
        super(53);
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
            EncodedVehicleTypeContainer encodedVehicleTypeContainer = (EncodedVehicleTypeContainer)hASContainer;
            ArrayList arrayList = EncodedVehicleTypeContainerMarshaller.borrowArrayList();
            if (encodedVehicleTypeContainer.isTypeSet()) {
                EncodedVehicleTypeContainerMarshaller.add((List)arrayList, EncodedVehicleTypeContainerMarshaller.createStringElement(123, encodedVehicleTypeContainer.getType()));
            }
            if (encodedVehicleTypeContainer.isStickerBitsSet()) {
                EncodedVehicleTypeContainerMarshaller.add((List)arrayList, EncodedVehicleTypeContainerMarshaller.createIntElement(145, encodedVehicleTypeContainer.getStickerBits()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            EncodedVehicleTypeContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setStringElement(HASContainer hASContainer, int n, String string) {
        switch (n) {
            case 123: {
                ((EncodedVehicleTypeContainer)hASContainer).setType(string);
                break;
            }
            default: {
                super.setStringElement(hASContainer, n, string);
            }
        }
    }

    @Override
    protected void setIntElement(HASContainer hASContainer, int n, int n2) {
        switch (n) {
            case 145: {
                ((EncodedVehicleTypeContainer)hASContainer).setStickerBits(n2);
                break;
            }
            default: {
                super.setIntElement(hASContainer, n, n2);
            }
        }
    }
}

