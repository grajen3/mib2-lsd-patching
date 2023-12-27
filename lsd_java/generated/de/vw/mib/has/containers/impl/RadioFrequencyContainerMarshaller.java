/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.RadioFrequencyContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class RadioFrequencyContainerMarshaller
extends AbstractContainerMarshaller {
    public RadioFrequencyContainerMarshaller() {
        super(43);
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
            RadioFrequencyContainer radioFrequencyContainer = (RadioFrequencyContainer)hASContainer;
            ArrayList arrayList = RadioFrequencyContainerMarshaller.borrowArrayList();
            if (radioFrequencyContainer.isBandSet()) {
                RadioFrequencyContainerMarshaller.add((List)arrayList, RadioFrequencyContainerMarshaller.createIntElement(94, radioFrequencyContainer.getBand()));
            }
            if (radioFrequencyContainer.isFrequencySet()) {
                RadioFrequencyContainerMarshaller.add((List)arrayList, RadioFrequencyContainerMarshaller.createLongElement(95, radioFrequencyContainer.getFrequency()));
            }
            if (radioFrequencyContainer.isFrequencyLabelSet()) {
                RadioFrequencyContainerMarshaller.add((List)arrayList, RadioFrequencyContainerMarshaller.createStringElement(96, radioFrequencyContainer.getFrequencyLabel()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            RadioFrequencyContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setIntElement(HASContainer hASContainer, int n, int n2) {
        switch (n) {
            case 94: {
                ((RadioFrequencyContainer)hASContainer).setBand(n2);
                break;
            }
            default: {
                super.setIntElement(hASContainer, n, n2);
            }
        }
    }

    @Override
    protected void setLongElement(HASContainer hASContainer, int n, long l) {
        switch (n) {
            case 95: {
                ((RadioFrequencyContainer)hASContainer).setFrequency(l);
                break;
            }
            default: {
                super.setLongElement(hASContainer, n, l);
            }
        }
    }

    @Override
    protected void setStringElement(HASContainer hASContainer, int n, String string) {
        switch (n) {
            case 96: {
                ((RadioFrequencyContainer)hASContainer).setFrequencyLabel(string);
                break;
            }
            default: {
                super.setStringElement(hASContainer, n, string);
            }
        }
    }
}

