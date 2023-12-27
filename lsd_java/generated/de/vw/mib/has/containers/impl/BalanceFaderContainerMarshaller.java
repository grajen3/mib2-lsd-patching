/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.BalanceFaderContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class BalanceFaderContainerMarshaller
extends AbstractContainerMarshaller {
    public BalanceFaderContainerMarshaller() {
        super(48);
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
            BalanceFaderContainer balanceFaderContainer = (BalanceFaderContainer)hASContainer;
            ArrayList arrayList = BalanceFaderContainerMarshaller.borrowArrayList();
            if (balanceFaderContainer.isBalanceSet()) {
                BalanceFaderContainerMarshaller.add((List)arrayList, BalanceFaderContainerMarshaller.createIntElement(104, balanceFaderContainer.getBalance()));
            }
            if (balanceFaderContainer.isFaderSet()) {
                BalanceFaderContainerMarshaller.add((List)arrayList, BalanceFaderContainerMarshaller.createIntElement(105, balanceFaderContainer.getFader()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            BalanceFaderContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setIntElement(HASContainer hASContainer, int n, int n2) {
        switch (n) {
            case 104: {
                ((BalanceFaderContainer)hASContainer).setBalance(n2);
                break;
            }
            case 105: {
                ((BalanceFaderContainer)hASContainer).setFader(n2);
                break;
            }
            default: {
                super.setIntElement(hASContainer, n, n2);
            }
        }
    }
}

