/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.MediaBrowserEntryContainer;
import generated.de.vw.mib.has.containers.TrackInfoContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class MediaBrowserEntryContainerMarshaller
extends AbstractContainerMarshaller {
    public MediaBrowserEntryContainerMarshaller() {
        super(21);
    }

    @Override
    public void addChild(HASContainer hASContainer, HASContainer hASContainer2) {
        int n = this.getMarshallerContainerId();
        if (n != hASContainer.getContainerId()) {
            throw HASException.wrongContainerId(n, hASContainer.getContainerId());
        }
        MediaBrowserEntryContainer mediaBrowserEntryContainer = (MediaBrowserEntryContainer)hASContainer;
        int n2 = hASContainer2.getContainerId();
        switch (n2) {
            case 22: {
                this.addTrackInfo(mediaBrowserEntryContainer, (TrackInfoContainer)hASContainer2);
                break;
            }
            default: {
                throw HASException.invalidChild(n, n2);
            }
        }
    }

    private void addTrackInfo(MediaBrowserEntryContainer mediaBrowserEntryContainer, TrackInfoContainer trackInfoContainer) {
        if (mediaBrowserEntryContainer.isTrackInfoSet()) {
            throw HASException.invalidMultipleChildren(this.getMarshallerContainerId(), trackInfoContainer.getContainerId());
        }
        mediaBrowserEntryContainer.setTrackInfo(trackInfoContainer);
    }

    @Override
    public void getChildren(HASContainer hASContainer, List list) {
        int n = this.getMarshallerContainerId();
        if (n != hASContainer.getContainerId()) {
            throw HASException.wrongContainerId(n, hASContainer.getContainerId());
        }
        MediaBrowserEntryContainer mediaBrowserEntryContainer = (MediaBrowserEntryContainer)hASContainer;
        if (mediaBrowserEntryContainer.isTrackInfoSet()) {
            MediaBrowserEntryContainerMarshaller.add(list, mediaBrowserEntryContainer.getTrackInfo());
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
            MediaBrowserEntryContainer mediaBrowserEntryContainer = (MediaBrowserEntryContainer)hASContainer;
            ArrayList arrayList = MediaBrowserEntryContainerMarshaller.borrowArrayList();
            if (mediaBrowserEntryContainer.isDisplayTextSet()) {
                MediaBrowserEntryContainerMarshaller.add((List)arrayList, MediaBrowserEntryContainerMarshaller.createStringElement(35, mediaBrowserEntryContainer.getDisplayText()));
            }
            if (mediaBrowserEntryContainer.isEntryTypeSet()) {
                MediaBrowserEntryContainerMarshaller.add((List)arrayList, MediaBrowserEntryContainerMarshaller.createIntElement(36, mediaBrowserEntryContainer.getEntryType()));
            }
            if (mediaBrowserEntryContainer.isEntryIdSet()) {
                MediaBrowserEntryContainerMarshaller.add((List)arrayList, MediaBrowserEntryContainerMarshaller.createLongElement(37, mediaBrowserEntryContainer.getEntryId()));
            }
            if (mediaBrowserEntryContainer.isFilenameSet()) {
                MediaBrowserEntryContainerMarshaller.add((List)arrayList, MediaBrowserEntryContainerMarshaller.createStringElement(99, mediaBrowserEntryContainer.getFilename()));
            }
            if (mediaBrowserEntryContainer.isNotPlayableReasonSet()) {
                MediaBrowserEntryContainerMarshaller.add((List)arrayList, MediaBrowserEntryContainerMarshaller.createIntElement(126, mediaBrowserEntryContainer.getNotPlayableReason()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            MediaBrowserEntryContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setStringElement(HASContainer hASContainer, int n, String string) {
        switch (n) {
            case 35: {
                ((MediaBrowserEntryContainer)hASContainer).setDisplayText(string);
                break;
            }
            case 99: {
                ((MediaBrowserEntryContainer)hASContainer).setFilename(string);
                break;
            }
            default: {
                super.setStringElement(hASContainer, n, string);
            }
        }
    }

    @Override
    protected void setIntElement(HASContainer hASContainer, int n, int n2) {
        switch (n) {
            case 36: {
                ((MediaBrowserEntryContainer)hASContainer).setEntryType(n2);
                break;
            }
            case 126: {
                ((MediaBrowserEntryContainer)hASContainer).setNotPlayableReason(n2);
                break;
            }
            default: {
                super.setIntElement(hASContainer, n, n2);
            }
        }
    }

    @Override
    protected void setLongElement(HASContainer hASContainer, int n, long l) {
        switch (n) {
            case 37: {
                ((MediaBrowserEntryContainer)hASContainer).setEntryId(l);
                break;
            }
            default: {
                super.setLongElement(hASContainer, n, l);
            }
        }
    }
}

