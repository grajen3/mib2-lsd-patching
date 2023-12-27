/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.ListStateContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class ListStateContainerMarshaller
extends AbstractContainerMarshaller {
    public ListStateContainerMarshaller() {
        super(0x2000001);
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
            ListStateContainer listStateContainer = (ListStateContainer)hASContainer;
            ArrayList arrayList = ListStateContainerMarshaller.borrowArrayList();
            if (listStateContainer.isPageSizeSet()) {
                ListStateContainerMarshaller.add((List)arrayList, ListStateContainerMarshaller.createIntElement(0x4000001, listStateContainer.getPageSize()));
            }
            if (listStateContainer.isListSizeSet()) {
                ListStateContainerMarshaller.add((List)arrayList, ListStateContainerMarshaller.createIntElement(0x5000001, listStateContainer.getListSize()));
            }
            if (listStateContainer.isModCountSet()) {
                ListStateContainerMarshaller.add((List)arrayList, ListStateContainerMarshaller.createIntElement(0x6000001, listStateContainer.getModCount()));
            }
            if (listStateContainer.isStateSet()) {
                ListStateContainerMarshaller.add((List)arrayList, ListStateContainerMarshaller.createIntElement(0xD000001, listStateContainer.getState()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            ListStateContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setIntElement(HASContainer hASContainer, int n, int n2) {
        switch (n) {
            case 0x1000004: {
                ((ListStateContainer)hASContainer).setPageSize(n2);
                break;
            }
            case 0x1000005: {
                ((ListStateContainer)hASContainer).setListSize(n2);
                break;
            }
            case 0x1000006: {
                ((ListStateContainer)hASContainer).setModCount(n2);
                break;
            }
            case 0x100000D: {
                ((ListStateContainer)hASContainer).setState(n2);
                break;
            }
            default: {
                super.setIntElement(hASContainer, n, n2);
            }
        }
    }
}

