/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.ListPageDataContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class ListPageDataContainerMarshaller
extends AbstractContainerMarshaller {
    public ListPageDataContainerMarshaller() {
        super(0x4000001);
    }

    @Override
    public void addChild(HASContainer hASContainer, HASContainer hASContainer2) {
        int n = this.getMarshallerContainerId();
        if (n != hASContainer.getContainerId()) {
            throw HASException.wrongContainerId(n, hASContainer.getContainerId());
        }
        ListPageDataContainer listPageDataContainer = (ListPageDataContainer)hASContainer;
        int n2 = hASContainer2.getContainerId();
        switch (n2) {
            default: 
        }
        this.addPageData(listPageDataContainer, hASContainer2);
    }

    private void addPageData(ListPageDataContainer listPageDataContainer, HASContainer hASContainer) {
        HASContainer[] hASContainerArray = listPageDataContainer.getPageData();
        if (null != hASContainerArray) {
            HASContainer[] hASContainerArray2 = new HASContainer[hASContainerArray.length + 1];
            System.arraycopy((Object)hASContainerArray, 0, (Object)hASContainerArray2, 0, hASContainerArray.length);
            hASContainerArray2[hASContainerArray.length] = hASContainer;
            hASContainerArray = hASContainerArray2;
        } else {
            hASContainerArray = new HASContainer[]{hASContainer};
        }
        listPageDataContainer.setPageData(hASContainerArray);
    }

    @Override
    public void getChildren(HASContainer hASContainer, List list) {
        int n = this.getMarshallerContainerId();
        if (n != hASContainer.getContainerId()) {
            throw HASException.wrongContainerId(n, hASContainer.getContainerId());
        }
        ListPageDataContainer listPageDataContainer = (ListPageDataContainer)hASContainer;
        if (listPageDataContainer.isPageDataSet()) {
            ListPageDataContainerMarshaller.add(list, listPageDataContainer.getPageData());
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
            ListPageDataContainer listPageDataContainer = (ListPageDataContainer)hASContainer;
            ArrayList arrayList = ListPageDataContainerMarshaller.borrowArrayList();
            if (listPageDataContainer.isModCountSet()) {
                ListPageDataContainerMarshaller.add((List)arrayList, ListPageDataContainerMarshaller.createIntElement(0xA000001, listPageDataContainer.getModCount()));
            }
            if (listPageDataContainer.isOffsetSet()) {
                ListPageDataContainerMarshaller.add((List)arrayList, ListPageDataContainerMarshaller.createIntElement(0xB000001, listPageDataContainer.getOffset()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            ListPageDataContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setIntElement(HASContainer hASContainer, int n, int n2) {
        switch (n) {
            case 0x100000A: {
                ((ListPageDataContainer)hASContainer).setModCount(n2);
                break;
            }
            case 0x100000B: {
                ((ListPageDataContainer)hASContainer).setOffset(n2);
                break;
            }
            default: {
                super.setIntElement(hASContainer, n, n2);
            }
        }
    }
}

