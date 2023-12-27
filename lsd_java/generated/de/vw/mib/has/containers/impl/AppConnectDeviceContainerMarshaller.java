/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.AppConnectDeviceContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class AppConnectDeviceContainerMarshaller
extends AbstractContainerMarshaller {
    public AppConnectDeviceContainerMarshaller() {
        super(64);
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
            AppConnectDeviceContainer appConnectDeviceContainer = (AppConnectDeviceContainer)hASContainer;
            ArrayList arrayList = AppConnectDeviceContainerMarshaller.borrowArrayList();
            if (appConnectDeviceContainer.isAvailableSet()) {
                AppConnectDeviceContainerMarshaller.add((List)arrayList, AppConnectDeviceContainerMarshaller.createBooleanElement(146, appConnectDeviceContainer.getAvailable()));
            }
            if (appConnectDeviceContainer.isEntertainmentActiveSet()) {
                AppConnectDeviceContainerMarshaller.add((List)arrayList, AppConnectDeviceContainerMarshaller.createBooleanElement(147, appConnectDeviceContainer.getEntertainmentActive()));
            }
            if (appConnectDeviceContainer.isTypeSet()) {
                AppConnectDeviceContainerMarshaller.add((List)arrayList, AppConnectDeviceContainerMarshaller.createIntElement(148, appConnectDeviceContainer.getType()));
            }
            if (appConnectDeviceContainer.isDeviceNameSet()) {
                AppConnectDeviceContainerMarshaller.add((List)arrayList, AppConnectDeviceContainerMarshaller.createStringElement(149, appConnectDeviceContainer.getDeviceName()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            AppConnectDeviceContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setBooleanElement(HASContainer hASContainer, int n, boolean bl) {
        switch (n) {
            case 146: {
                ((AppConnectDeviceContainer)hASContainer).setAvailable(bl);
                break;
            }
            case 147: {
                ((AppConnectDeviceContainer)hASContainer).setEntertainmentActive(bl);
                break;
            }
            default: {
                super.setBooleanElement(hASContainer, n, bl);
            }
        }
    }

    @Override
    protected void setIntElement(HASContainer hASContainer, int n, int n2) {
        switch (n) {
            case 148: {
                ((AppConnectDeviceContainer)hASContainer).setType(n2);
                break;
            }
            default: {
                super.setIntElement(hASContainer, n, n2);
            }
        }
    }

    @Override
    protected void setStringElement(HASContainer hASContainer, int n, String string) {
        switch (n) {
            case 149: {
                ((AppConnectDeviceContainer)hASContainer).setDeviceName(string);
                break;
            }
            default: {
                super.setStringElement(hASContainer, n, string);
            }
        }
    }
}

