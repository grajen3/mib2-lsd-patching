/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.RadioPresetIndexContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class RadioPresetIndexContainerMarshaller
extends AbstractContainerMarshaller {
    public RadioPresetIndexContainerMarshaller() {
        super(45);
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
            RadioPresetIndexContainer radioPresetIndexContainer = (RadioPresetIndexContainer)hASContainer;
            ArrayList arrayList = RadioPresetIndexContainerMarshaller.borrowArrayList();
            if (radioPresetIndexContainer.isBandSet()) {
                RadioPresetIndexContainerMarshaller.add((List)arrayList, RadioPresetIndexContainerMarshaller.createIntElement(100, radioPresetIndexContainer.getBand()));
            }
            if (radioPresetIndexContainer.isIndexSet()) {
                RadioPresetIndexContainerMarshaller.add((List)arrayList, RadioPresetIndexContainerMarshaller.createIntElement(101, radioPresetIndexContainer.getIndex()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            RadioPresetIndexContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setIntElement(HASContainer hASContainer, int n, int n2) {
        switch (n) {
            case 100: {
                ((RadioPresetIndexContainer)hASContainer).setBand(n2);
                break;
            }
            case 101: {
                ((RadioPresetIndexContainer)hASContainer).setIndex(n2);
                break;
            }
            default: {
                super.setIntElement(hASContainer, n, n2);
            }
        }
    }
}

