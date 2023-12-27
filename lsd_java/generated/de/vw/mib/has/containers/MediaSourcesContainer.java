/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers;

import de.vw.mib.has.HASContainer;
import generated.de.vw.mib.has.containers.MediaSourceStateContainer;

public interface MediaSourcesContainer
extends HASContainer {
    default public MediaSourceStateContainer[] getSources() {
    }

    default public boolean isSourcesSet() {
    }

    default public void setSources(MediaSourceStateContainer[] mediaSourceStateContainerArray) {
    }

    default public void unsetSources() {
    }
}

