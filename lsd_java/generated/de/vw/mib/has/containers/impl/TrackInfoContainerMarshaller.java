/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.TrackInfoContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.has.HASDataContainer;
import org.dsi.ifc.has.HASDataElement;

public class TrackInfoContainerMarshaller
extends AbstractContainerMarshaller {
    public TrackInfoContainerMarshaller() {
        super(22);
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
            TrackInfoContainer trackInfoContainer = (TrackInfoContainer)hASContainer;
            ArrayList arrayList = TrackInfoContainerMarshaller.borrowArrayList();
            if (trackInfoContainer.isTitleSet()) {
                TrackInfoContainerMarshaller.add((List)arrayList, TrackInfoContainerMarshaller.createStringElement(39, trackInfoContainer.getTitle()));
            }
            if (trackInfoContainer.isArtistSet()) {
                TrackInfoContainerMarshaller.add((List)arrayList, TrackInfoContainerMarshaller.createStringElement(40, trackInfoContainer.getArtist()));
            }
            if (trackInfoContainer.isAlbumSet()) {
                TrackInfoContainerMarshaller.add((List)arrayList, TrackInfoContainerMarshaller.createStringElement(41, trackInfoContainer.getAlbum()));
            }
            if (trackInfoContainer.isCoverSet()) {
                TrackInfoContainerMarshaller.add((List)arrayList, TrackInfoContainerMarshaller.createResourceLocatorElement(42, trackInfoContainer.getCover()));
            }
            if (trackInfoContainer.isLengthSet()) {
                TrackInfoContainerMarshaller.add((List)arrayList, TrackInfoContainerMarshaller.createIntElement(43, trackInfoContainer.getLength()));
            }
            if (trackInfoContainer.isTrackNumberSet()) {
                TrackInfoContainerMarshaller.add((List)arrayList, TrackInfoContainerMarshaller.createIntElement(67, trackInfoContainer.getTrackNumber()));
            }
            if (0 < arrayList.size()) {
                hASDataContainer.dataElements = (HASDataElement[])arrayList.toArray(new HASDataElement[arrayList.size()]);
            }
            TrackInfoContainerMarshaller.release(arrayList);
        }
        return hASDataContainer;
    }

    @Override
    protected void setStringElement(HASContainer hASContainer, int n, String string) {
        switch (n) {
            case 39: {
                ((TrackInfoContainer)hASContainer).setTitle(string);
                break;
            }
            case 40: {
                ((TrackInfoContainer)hASContainer).setArtist(string);
                break;
            }
            case 41: {
                ((TrackInfoContainer)hASContainer).setAlbum(string);
                break;
            }
            default: {
                super.setStringElement(hASContainer, n, string);
            }
        }
    }

    @Override
    protected void setResourceLocatorElement(HASContainer hASContainer, int n, ResourceLocator resourceLocator) {
        switch (n) {
            case 42: {
                ((TrackInfoContainer)hASContainer).setCover(resourceLocator);
                break;
            }
            default: {
                super.setResourceLocatorElement(hASContainer, n, resourceLocator);
            }
        }
    }

    @Override
    protected void setIntElement(HASContainer hASContainer, int n, int n2) {
        switch (n) {
            case 43: {
                ((TrackInfoContainer)hASContainer).setLength(n2);
                break;
            }
            case 67: {
                ((TrackInfoContainer)hASContainer).setTrackNumber(n2);
                break;
            }
            default: {
                super.setIntElement(hASContainer, n, n2);
            }
        }
    }
}

