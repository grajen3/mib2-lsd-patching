/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.MediaBrowserEntryContainer;
import generated.de.vw.mib.has.containers.MediaBrowserPathContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;

public class MediaBrowserPathContainerMarshaller
extends AbstractContainerMarshaller {
    public MediaBrowserPathContainerMarshaller() {
        super(50);
    }

    @Override
    public void addChild(HASContainer hASContainer, HASContainer hASContainer2) {
        int n = this.getMarshallerContainerId();
        if (n != hASContainer.getContainerId()) {
            throw HASException.wrongContainerId(n, hASContainer.getContainerId());
        }
        MediaBrowserPathContainer mediaBrowserPathContainer = (MediaBrowserPathContainer)hASContainer;
        int n2 = hASContainer2.getContainerId();
        switch (n2) {
            case 21: {
                this.addEntries(mediaBrowserPathContainer, (MediaBrowserEntryContainer)hASContainer2);
                break;
            }
            default: {
                throw HASException.invalidChild(n, n2);
            }
        }
    }

    private void addEntries(MediaBrowserPathContainer mediaBrowserPathContainer, MediaBrowserEntryContainer mediaBrowserEntryContainer) {
        MediaBrowserEntryContainer[] mediaBrowserEntryContainerArray = mediaBrowserPathContainer.getEntries();
        if (null != mediaBrowserEntryContainerArray) {
            MediaBrowserEntryContainer[] mediaBrowserEntryContainerArray2 = new MediaBrowserEntryContainer[mediaBrowserEntryContainerArray.length + 1];
            System.arraycopy((Object)mediaBrowserEntryContainerArray, 0, (Object)mediaBrowserEntryContainerArray2, 0, mediaBrowserEntryContainerArray.length);
            mediaBrowserEntryContainerArray2[mediaBrowserEntryContainerArray.length] = mediaBrowserEntryContainer;
            mediaBrowserEntryContainerArray = mediaBrowserEntryContainerArray2;
        } else {
            mediaBrowserEntryContainerArray = new MediaBrowserEntryContainer[]{mediaBrowserEntryContainer};
        }
        mediaBrowserPathContainer.setEntries(mediaBrowserEntryContainerArray);
    }

    @Override
    public void getChildren(HASContainer hASContainer, List list) {
        int n = this.getMarshallerContainerId();
        if (n != hASContainer.getContainerId()) {
            throw HASException.wrongContainerId(n, hASContainer.getContainerId());
        }
        MediaBrowserPathContainer mediaBrowserPathContainer = (MediaBrowserPathContainer)hASContainer;
        if (mediaBrowserPathContainer.isEntriesSet()) {
            MediaBrowserPathContainerMarshaller.add(list, mediaBrowserPathContainer.getEntries());
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

