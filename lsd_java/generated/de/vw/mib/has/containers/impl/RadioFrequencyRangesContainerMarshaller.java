/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.RadioFrequencyRangesContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class RadioFrequencyRangesContainerMarshaller
extends AbstractContainerMarshaller {
    public RadioFrequencyRangesContainerMarshaller() {
        super(42);
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
            RadioFrequencyRangesContainer radioFrequencyRangesContainer = (RadioFrequencyRangesContainer)hASContainer;
            ArrayList arrayList = RadioFrequencyRangesContainerMarshaller.borrowArrayList();
            if (radioFrequencyRangesContainer.isAMRangeSet()) {
                RadioFrequencyRangesContainerMarshaller.add((List)arrayList, RadioFrequencyRangesContainerMarshaller.createIntElement(92, radioFrequencyRangesContainer.getAMRange()));
            }
            if (radioFrequencyRangesContainer.isFMRangeSet()) {
                RadioFrequencyRangesContainerMarshaller.add((List)arrayList, RadioFrequencyRangesContainerMarshaller.createIntElement(93, radioFrequencyRangesContainer.getFMRange()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            RadioFrequencyRangesContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setIntElement(HASContainer hASContainer, int n, int n2) {
        switch (n) {
            case 92: {
                ((RadioFrequencyRangesContainer)hASContainer).setAMRange(n2);
                break;
            }
            case 93: {
                ((RadioFrequencyRangesContainer)hASContainer).setFMRange(n2);
                break;
            }
            default: {
                super.setIntElement(hASContainer, n, n2);
            }
        }
    }
}

