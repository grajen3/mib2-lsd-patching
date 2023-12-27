/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.MediaCapabilitiesContainer;
import generated.de.vw.mib.has.containers.MediaSourceStateContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class MediaSourceStateContainerMarshaller
extends AbstractContainerMarshaller {
    public MediaSourceStateContainerMarshaller() {
        super(32);
    }

    @Override
    public void addChild(HASContainer hASContainer, HASContainer hASContainer2) {
        int n = this.getMarshallerContainerId();
        if (n != hASContainer.getContainerId()) {
            throw HASException.wrongContainerId(n, hASContainer.getContainerId());
        }
        MediaSourceStateContainer mediaSourceStateContainer = (MediaSourceStateContainer)hASContainer;
        int n2 = hASContainer2.getContainerId();
        switch (n2) {
            case 66: {
                this.addCapabilities(mediaSourceStateContainer, (MediaCapabilitiesContainer)hASContainer2);
                break;
            }
            default: {
                throw HASException.invalidChild(n, n2);
            }
        }
    }

    private void addCapabilities(MediaSourceStateContainer mediaSourceStateContainer, MediaCapabilitiesContainer mediaCapabilitiesContainer) {
        if (mediaSourceStateContainer.isCapabilitiesSet()) {
            throw HASException.invalidMultipleChildren(this.getMarshallerContainerId(), mediaCapabilitiesContainer.getContainerId());
        }
        mediaSourceStateContainer.setCapabilities(mediaCapabilitiesContainer);
    }

    @Override
    public void getChildren(HASContainer hASContainer, List list) {
        int n = this.getMarshallerContainerId();
        if (n != hASContainer.getContainerId()) {
            throw HASException.wrongContainerId(n, hASContainer.getContainerId());
        }
        MediaSourceStateContainer mediaSourceStateContainer = (MediaSourceStateContainer)hASContainer;
        if (mediaSourceStateContainer.isCapabilitiesSet()) {
            MediaSourceStateContainerMarshaller.add(list, mediaSourceStateContainer.getCapabilities());
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
            MediaSourceStateContainer mediaSourceStateContainer = (MediaSourceStateContainer)hASContainer;
            ArrayList arrayList = MediaSourceStateContainerMarshaller.borrowArrayList();
            if (mediaSourceStateContainer.isSourceSet()) {
                MediaSourceStateContainerMarshaller.add((List)arrayList, MediaSourceStateContainerMarshaller.createIntElement(69, mediaSourceStateContainer.getSource()));
            }
            if (mediaSourceStateContainer.isStateSet()) {
                MediaSourceStateContainerMarshaller.add((List)arrayList, MediaSourceStateContainerMarshaller.createIntElement(70, mediaSourceStateContainer.getState()));
            }
            if (mediaSourceStateContainer.isDatabaseSupportedSet()) {
                MediaSourceStateContainerMarshaller.add((List)arrayList, MediaSourceStateContainerMarshaller.createBooleanElement(124, mediaSourceStateContainer.getDatabaseSupported()));
            }
            if (mediaSourceStateContainer.isDatabaseSyncedSet()) {
                MediaSourceStateContainerMarshaller.add((List)arrayList, MediaSourceStateContainerMarshaller.createBooleanElement(125, mediaSourceStateContainer.getDatabaseSynced()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            MediaSourceStateContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setIntElement(HASContainer hASContainer, int n, int n2) {
        switch (n) {
            case 69: {
                ((MediaSourceStateContainer)hASContainer).setSource(n2);
                break;
            }
            case 70: {
                ((MediaSourceStateContainer)hASContainer).setState(n2);
                break;
            }
            default: {
                super.setIntElement(hASContainer, n, n2);
            }
        }
    }

    @Override
    protected void setBooleanElement(HASContainer hASContainer, int n, boolean bl) {
        switch (n) {
            case 124: {
                ((MediaSourceStateContainer)hASContainer).setDatabaseSupported(bl);
                break;
            }
            case 125: {
                ((MediaSourceStateContainer)hASContainer).setDatabaseSynced(bl);
                break;
            }
            default: {
                super.setBooleanElement(hASContainer, n, bl);
            }
        }
    }
}

