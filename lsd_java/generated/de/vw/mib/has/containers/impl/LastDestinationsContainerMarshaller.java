/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.LastDestinationContainer;
import generated.de.vw.mib.has.containers.LastDestinationsContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;

public class LastDestinationsContainerMarshaller
extends AbstractContainerMarshaller {
    public LastDestinationsContainerMarshaller() {
        super(37);
    }

    @Override
    public void addChild(HASContainer hASContainer, HASContainer hASContainer2) {
        int n = this.getMarshallerContainerId();
        if (n != hASContainer.getContainerId()) {
            throw HASException.wrongContainerId(n, hASContainer.getContainerId());
        }
        LastDestinationsContainer lastDestinationsContainer = (LastDestinationsContainer)hASContainer;
        int n2 = hASContainer2.getContainerId();
        switch (n2) {
            case 36: {
                this.addDestinations(lastDestinationsContainer, (LastDestinationContainer)hASContainer2);
                break;
            }
            default: {
                throw HASException.invalidChild(n, n2);
            }
        }
    }

    private void addDestinations(LastDestinationsContainer lastDestinationsContainer, LastDestinationContainer lastDestinationContainer) {
        LastDestinationContainer[] lastDestinationContainerArray = lastDestinationsContainer.getDestinations();
        if (null != lastDestinationContainerArray) {
            LastDestinationContainer[] lastDestinationContainerArray2 = new LastDestinationContainer[lastDestinationContainerArray.length + 1];
            System.arraycopy((Object)lastDestinationContainerArray, 0, (Object)lastDestinationContainerArray2, 0, lastDestinationContainerArray.length);
            lastDestinationContainerArray2[lastDestinationContainerArray.length] = lastDestinationContainer;
            lastDestinationContainerArray = lastDestinationContainerArray2;
        } else {
            lastDestinationContainerArray = new LastDestinationContainer[]{lastDestinationContainer};
        }
        lastDestinationsContainer.setDestinations(lastDestinationContainerArray);
    }

    @Override
    public void getChildren(HASContainer hASContainer, List list) {
        int n = this.getMarshallerContainerId();
        if (n != hASContainer.getContainerId()) {
            throw HASException.wrongContainerId(n, hASContainer.getContainerId());
        }
        LastDestinationsContainer lastDestinationsContainer = (LastDestinationsContainer)hASContainer;
        if (lastDestinationsContainer.isDestinationsSet()) {
            LastDestinationsContainerMarshaller.add(list, lastDestinationsContainer.getDestinations());
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

