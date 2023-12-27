/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.MediaSourceStateContainer;
import generated.de.vw.mib.has.containers.MediaSourcesContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainerMarshaller;
import java.util.List;
import org.dsi.ifc.has.HASDataContainer;

public class MediaSourcesContainerMarshaller
extends AbstractContainerMarshaller {
    public MediaSourcesContainerMarshaller() {
        super(33);
    }

    @Override
    public void addChild(HASContainer hASContainer, HASContainer hASContainer2) {
        int n = this.getMarshallerContainerId();
        if (n != hASContainer.getContainerId()) {
            throw HASException.wrongContainerId(n, hASContainer.getContainerId());
        }
        MediaSourcesContainer mediaSourcesContainer = (MediaSourcesContainer)hASContainer;
        int n2 = hASContainer2.getContainerId();
        switch (n2) {
            case 32: {
                this.addSources(mediaSourcesContainer, (MediaSourceStateContainer)hASContainer2);
                break;
            }
            default: {
                throw HASException.invalidChild(n, n2);
            }
        }
    }

    private void addSources(MediaSourcesContainer mediaSourcesContainer, MediaSourceStateContainer mediaSourceStateContainer) {
        MediaSourceStateContainer[] mediaSourceStateContainerArray = mediaSourcesContainer.getSources();
        if (null != mediaSourceStateContainerArray) {
            MediaSourceStateContainer[] mediaSourceStateContainerArray2 = new MediaSourceStateContainer[mediaSourceStateContainerArray.length + 1];
            System.arraycopy((Object)mediaSourceStateContainerArray, 0, (Object)mediaSourceStateContainerArray2, 0, mediaSourceStateContainerArray.length);
            mediaSourceStateContainerArray2[mediaSourceStateContainerArray.length] = mediaSourceStateContainer;
            mediaSourceStateContainerArray = mediaSourceStateContainerArray2;
        } else {
            mediaSourceStateContainerArray = new MediaSourceStateContainer[]{mediaSourceStateContainer};
        }
        mediaSourcesContainer.setSources(mediaSourceStateContainerArray);
    }

    @Override
    public void getChildren(HASContainer hASContainer, List list) {
        int n = this.getMarshallerContainerId();
        if (n != hASContainer.getContainerId()) {
            throw HASException.wrongContainerId(n, hASContainer.getContainerId());
        }
        MediaSourcesContainer mediaSourcesContainer = (MediaSourcesContainer)hASContainer;
        if (mediaSourcesContainer.isSourcesSet()) {
            MediaSourcesContainerMarshaller.add(list, mediaSourcesContainer.getSources());
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

