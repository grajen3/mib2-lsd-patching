/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.StartGuidanceResultContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class StartGuidanceResultContainerMarshaller
extends AbstractContainerMarshaller {
    public StartGuidanceResultContainerMarshaller() {
        super(67);
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
            StartGuidanceResultContainer startGuidanceResultContainer = (StartGuidanceResultContainer)hASContainer;
            ArrayList arrayList = StartGuidanceResultContainerMarshaller.borrowArrayList();
            if (startGuidanceResultContainer.isResultSet()) {
                StartGuidanceResultContainerMarshaller.add((List)arrayList, StartGuidanceResultContainerMarshaller.createIntElement(175, startGuidanceResultContainer.getResult()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            StartGuidanceResultContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setIntElement(HASContainer hASContainer, int n, int n2) {
        switch (n) {
            case 175: {
                ((StartGuidanceResultContainer)hASContainer).setResult(n2);
                break;
            }
            default: {
                super.setIntElement(hASContainer, n, n2);
            }
        }
    }
}

