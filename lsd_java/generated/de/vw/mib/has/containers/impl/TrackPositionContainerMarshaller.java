/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.TrackPositionContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class TrackPositionContainerMarshaller
extends AbstractContainerMarshaller {
    public TrackPositionContainerMarshaller() {
        super(31);
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
            TrackPositionContainer trackPositionContainer = (TrackPositionContainer)hASContainer;
            ArrayList arrayList = TrackPositionContainerMarshaller.borrowArrayList();
            if (trackPositionContainer.isPositionSet()) {
                TrackPositionContainerMarshaller.add((List)arrayList, TrackPositionContainerMarshaller.createIntElement(68, trackPositionContainer.getPosition()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            TrackPositionContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setIntElement(HASContainer hASContainer, int n, int n2) {
        switch (n) {
            case 68: {
                ((TrackPositionContainer)hASContainer).setPosition(n2);
                break;
            }
            default: {
                super.setIntElement(hASContainer, n, n2);
            }
        }
    }
}

