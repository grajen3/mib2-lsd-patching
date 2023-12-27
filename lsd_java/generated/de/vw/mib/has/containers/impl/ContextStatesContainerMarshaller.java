/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.ContextStateContainer;
import generated.de.vw.mib.has.containers.ContextStatesContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;

public class ContextStatesContainerMarshaller
extends AbstractContainerMarshaller {
    public ContextStatesContainerMarshaller() {
        super(0x1000001);
    }

    @Override
    public void addChild(HASContainer hASContainer, HASContainer hASContainer2) {
        int n = this.getMarshallerContainerId();
        if (n != hASContainer.getContainerId()) {
            throw HASException.wrongContainerId(n, hASContainer.getContainerId());
        }
        ContextStatesContainer contextStatesContainer = (ContextStatesContainer)hASContainer;
        int n2 = hASContainer2.getContainerId();
        switch (n2) {
            case 0x1000000: {
                this.addStates(contextStatesContainer, (ContextStateContainer)hASContainer2);
                break;
            }
            default: {
                throw HASException.invalidChild(n, n2);
            }
        }
    }

    private void addStates(ContextStatesContainer contextStatesContainer, ContextStateContainer contextStateContainer) {
        ContextStateContainer[] contextStateContainerArray = contextStatesContainer.getStates();
        if (null != contextStateContainerArray) {
            ContextStateContainer[] contextStateContainerArray2 = new ContextStateContainer[contextStateContainerArray.length + 1];
            System.arraycopy((Object)contextStateContainerArray, 0, (Object)contextStateContainerArray2, 0, contextStateContainerArray.length);
            contextStateContainerArray2[contextStateContainerArray.length] = contextStateContainer;
            contextStateContainerArray = contextStateContainerArray2;
        } else {
            contextStateContainerArray = new ContextStateContainer[]{contextStateContainer};
        }
        contextStatesContainer.setStates(contextStateContainerArray);
    }

    @Override
    public void getChildren(HASContainer hASContainer, List list) {
        int n = this.getMarshallerContainerId();
        if (n != hASContainer.getContainerId()) {
            throw HASException.wrongContainerId(n, hASContainer.getContainerId());
        }
        ContextStatesContainer contextStatesContainer = (ContextStatesContainer)hASContainer;
        if (contextStatesContainer.isStatesSet()) {
            ContextStatesContainerMarshaller.add(list, contextStatesContainer.getStates());
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

