/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.ListPageRequestContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class ListPageRequestContainerMarshaller
extends AbstractContainerMarshaller {
    public ListPageRequestContainerMarshaller() {
        super(0x3000001);
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
            ListPageRequestContainer listPageRequestContainer = (ListPageRequestContainer)hASContainer;
            ArrayList arrayList = ListPageRequestContainerMarshaller.borrowArrayList();
            if (listPageRequestContainer.isOffsetSet()) {
                ListPageRequestContainerMarshaller.add((List)arrayList, ListPageRequestContainerMarshaller.createIntElement(0x8000001, listPageRequestContainer.getOffset()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            ListPageRequestContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setIntElement(HASContainer hASContainer, int n, int n2) {
        switch (n) {
            case 0x1000008: {
                ((ListPageRequestContainer)hASContainer).setOffset(n2);
                break;
            }
            default: {
                super.setIntElement(hASContainer, n, n2);
            }
        }
    }
}

