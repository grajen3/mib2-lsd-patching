/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.BalanceFaderRangesContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class BalanceFaderRangesContainerMarshaller
extends AbstractContainerMarshaller {
    public BalanceFaderRangesContainerMarshaller() {
        super(49);
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
            BalanceFaderRangesContainer balanceFaderRangesContainer = (BalanceFaderRangesContainer)hASContainer;
            ArrayList arrayList = BalanceFaderRangesContainerMarshaller.borrowArrayList();
            if (balanceFaderRangesContainer.isBalanceLeftSet()) {
                BalanceFaderRangesContainerMarshaller.add((List)arrayList, BalanceFaderRangesContainerMarshaller.createIntElement(106, balanceFaderRangesContainer.getBalanceLeft()));
            }
            if (balanceFaderRangesContainer.isBalanceRightSet()) {
                BalanceFaderRangesContainerMarshaller.add((List)arrayList, BalanceFaderRangesContainerMarshaller.createIntElement(107, balanceFaderRangesContainer.getBalanceRight()));
            }
            if (balanceFaderRangesContainer.isFaderRearSet()) {
                BalanceFaderRangesContainerMarshaller.add((List)arrayList, BalanceFaderRangesContainerMarshaller.createIntElement(108, balanceFaderRangesContainer.getFaderRear()));
            }
            if (balanceFaderRangesContainer.isFaderFrontSet()) {
                BalanceFaderRangesContainerMarshaller.add((List)arrayList, BalanceFaderRangesContainerMarshaller.createIntElement(109, balanceFaderRangesContainer.getFaderFront()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            BalanceFaderRangesContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setIntElement(HASContainer hASContainer, int n, int n2) {
        switch (n) {
            case 106: {
                ((BalanceFaderRangesContainer)hASContainer).setBalanceLeft(n2);
                break;
            }
            case 107: {
                ((BalanceFaderRangesContainer)hASContainer).setBalanceRight(n2);
                break;
            }
            case 108: {
                ((BalanceFaderRangesContainer)hASContainer).setFaderRear(n2);
                break;
            }
            case 109: {
                ((BalanceFaderRangesContainer)hASContainer).setFaderFront(n2);
                break;
            }
            default: {
                super.setIntElement(hASContainer, n, n2);
            }
        }
    }
}

