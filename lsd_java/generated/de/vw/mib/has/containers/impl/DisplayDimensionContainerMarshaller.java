/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.DisplayDimensionContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class DisplayDimensionContainerMarshaller
extends AbstractContainerMarshaller {
    public DisplayDimensionContainerMarshaller() {
        super(13);
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
            DisplayDimensionContainer displayDimensionContainer = (DisplayDimensionContainer)hASContainer;
            ArrayList arrayList = DisplayDimensionContainerMarshaller.borrowArrayList();
            if (displayDimensionContainer.isHorizontalResolutionSet()) {
                DisplayDimensionContainerMarshaller.add((List)arrayList, DisplayDimensionContainerMarshaller.createIntElement(25, displayDimensionContainer.getHorizontalResolution()));
            }
            if (displayDimensionContainer.isVerticalResolutionSet()) {
                DisplayDimensionContainerMarshaller.add((List)arrayList, DisplayDimensionContainerMarshaller.createIntElement(26, displayDimensionContainer.getVerticalResolution()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            DisplayDimensionContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setIntElement(HASContainer hASContainer, int n, int n2) {
        switch (n) {
            case 25: {
                ((DisplayDimensionContainer)hASContainer).setHorizontalResolution(n2);
                break;
            }
            case 26: {
                ((DisplayDimensionContainer)hASContainer).setVerticalResolution(n2);
                break;
            }
            default: {
                super.setIntElement(hASContainer, n, n2);
            }
        }
    }
}

