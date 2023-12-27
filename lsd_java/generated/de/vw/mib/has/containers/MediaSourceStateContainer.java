/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers;

import de.vw.mib.has.HASContainer;
import generated.de.vw.mib.has.containers.MediaCapabilitiesContainer;

public interface MediaSourceStateContainer
extends HASContainer {
    default public int getSource() {
    }

    default public int getState() {
    }

    default public boolean getDatabaseSupported() {
    }

    default public boolean getDatabaseSynced() {
    }

    default public MediaCapabilitiesContainer getCapabilities() {
    }

    default public boolean isSourceSet() {
    }

    default public boolean isStateSet() {
    }

    default public boolean isDatabaseSupportedSet() {
    }

    default public boolean isDatabaseSyncedSet() {
    }

    default public boolean isCapabilitiesSet() {
    }

    default public void setSource(int n) {
    }

    default public void setState(int n) {
    }

    default public void setDatabaseSupported(boolean bl) {
    }

    default public void setDatabaseSynced(boolean bl) {
    }

    default public void setCapabilities(MediaCapabilitiesContainer mediaCapabilitiesContainer) {
    }

    default public void unsetSource() {
    }

    default public void unsetState() {
    }

    default public void unsetDatabaseSupported() {
    }

    default public void unsetDatabaseSynced() {
    }

    default public void unsetCapabilities() {
    }
}

