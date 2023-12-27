/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.ContextStateContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class ContextStateContainerMarshaller
extends AbstractContainerMarshaller {
    public ContextStateContainerMarshaller() {
        super(1);
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
            ContextStateContainer contextStateContainer = (ContextStateContainer)hASContainer;
            ArrayList arrayList = ContextStateContainerMarshaller.borrowArrayList();
            if (contextStateContainer.isContextSet()) {
                ContextStateContainerMarshaller.add((List)arrayList, ContextStateContainerMarshaller.createStringElement(1, contextStateContainer.getContext()));
            }
            if (contextStateContainer.isStateSet()) {
                ContextStateContainerMarshaller.add((List)arrayList, ContextStateContainerMarshaller.createIntElement(0x1000001, contextStateContainer.getState()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            ContextStateContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setStringElement(HASContainer hASContainer, int n, String string) {
        switch (n) {
            case 0x1000000: {
                ((ContextStateContainer)hASContainer).setContext(string);
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
            case 0x1000001: {
                ((ContextStateContainer)hASContainer).setState(n2);
                break;
            }
            default: {
                super.setIntElement(hASContainer, n, n2);
            }
        }
    }
}

