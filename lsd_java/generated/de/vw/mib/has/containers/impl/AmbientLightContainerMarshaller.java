/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.AmbientLightContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class AmbientLightContainerMarshaller
extends AbstractContainerMarshaller {
    public AmbientLightContainerMarshaller() {
        super(68);
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
            AmbientLightContainer ambientLightContainer = (AmbientLightContainer)hASContainer;
            ArrayList arrayList = AmbientLightContainerMarshaller.borrowArrayList();
            if (ambientLightContainer.isColorSRGBSet()) {
                AmbientLightContainerMarshaller.add((List)arrayList, AmbientLightContainerMarshaller.createStringElement(176, ambientLightContainer.getColorSRGB()));
            }
            if (ambientLightContainer.isColorHMISet()) {
                AmbientLightContainerMarshaller.add((List)arrayList, AmbientLightContainerMarshaller.createStringElement(177, ambientLightContainer.getColorHMI()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            AmbientLightContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setStringElement(HASContainer hASContainer, int n, String string) {
        switch (n) {
            case 176: {
                ((AmbientLightContainer)hASContainer).setColorSRGB(string);
                break;
            }
            case 177: {
                ((AmbientLightContainer)hASContainer).setColorHMI(string);
                break;
            }
            default: {
                super.setStringElement(hASContainer, n, string);
            }
        }
    }
}

