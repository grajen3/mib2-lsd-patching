/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.RadioBandContainer;
import generated.de.vw.mib.has.containers.RadioBandsContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;

public class RadioBandsContainerMarshaller
extends AbstractContainerMarshaller {
    public RadioBandsContainerMarshaller() {
        super(35);
    }

    @Override
    public void addChild(HASContainer hASContainer, HASContainer hASContainer2) {
        int n = this.getMarshallerContainerId();
        if (n != hASContainer.getContainerId()) {
            throw HASException.wrongContainerId(n, hASContainer.getContainerId());
        }
        RadioBandsContainer radioBandsContainer = (RadioBandsContainer)hASContainer;
        int n2 = hASContainer2.getContainerId();
        switch (n2) {
            case 30: {
                this.addBands(radioBandsContainer, (RadioBandContainer)hASContainer2);
                break;
            }
            default: {
                throw HASException.invalidChild(n, n2);
            }
        }
    }

    private void addBands(RadioBandsContainer radioBandsContainer, RadioBandContainer radioBandContainer) {
        RadioBandContainer[] radioBandContainerArray = radioBandsContainer.getBands();
        if (null != radioBandContainerArray) {
            RadioBandContainer[] radioBandContainerArray2 = new RadioBandContainer[radioBandContainerArray.length + 1];
            System.arraycopy((Object)radioBandContainerArray, 0, (Object)radioBandContainerArray2, 0, radioBandContainerArray.length);
            radioBandContainerArray2[radioBandContainerArray.length] = radioBandContainer;
            radioBandContainerArray = radioBandContainerArray2;
        } else {
            radioBandContainerArray = new RadioBandContainer[]{radioBandContainer};
        }
        radioBandsContainer.setBands(radioBandContainerArray);
    }

    @Override
    public void getChildren(HASContainer hASContainer, List list) {
        int n = this.getMarshallerContainerId();
        if (n != hASContainer.getContainerId()) {
            throw HASException.wrongContainerId(n, hASContainer.getContainerId());
        }
        RadioBandsContainer radioBandsContainer = (RadioBandsContainer)hASContainer;
        if (radioBandsContainer.isBandsSet()) {
            RadioBandsContainerMarshaller.add(list, radioBandsContainer.getBands());
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

