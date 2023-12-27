/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.containers.impl;

import generated.de.vw.mib.has.containers.MediaCapabilitiesContainer;
import generated.de.vw.mib.has.containers.MediaSourceStateContainer;
import generated.de.vw.mib.has.containers.impl.AbstractContainer;

public class MediaSourceStateContainerImpl
extends AbstractContainer
implements MediaSourceStateContainer {
    private static final byte ELEMENT_SOURCE;
    private static final byte ELEMENT_STATE;
    private static final byte ELEMENT_DATABASE_SUPPORTED;
    private static final byte ELEMENT_DATABASE_SYNCED;
    private static final byte ELEMENT_CAPABILITIES;
    private int attrSource;
    private int attrState;
    private boolean attrDatabaseSupported;
    private boolean attrDatabaseSynced;
    private MediaCapabilitiesContainer attrCapabilities;

    @Override
    public int getContainerId() {
        return 32;
    }

    @Override
    public boolean isValid() {
        return this.isSourceSet() && this.isStateSet();
    }

    @Override
    public int getSource() {
        return this.attrSource;
    }

    @Override
    public int getState() {
        return this.attrState;
    }

    @Override
    public boolean getDatabaseSupported() {
        return this.attrDatabaseSupported;
    }

    @Override
    public boolean getDatabaseSynced() {
        return this.attrDatabaseSynced;
    }

    @Override
    public MediaCapabilitiesContainer getCapabilities() {
        return this.attrCapabilities;
    }

    @Override
    public boolean isSourceSet() {
        return this._isElementSet((byte)0);
    }

    @Override
    public boolean isStateSet() {
        return this._isElementSet((byte)1);
    }

    @Override
    public boolean isDatabaseSupportedSet() {
        return this._isElementSet((byte)2);
    }

    @Override
    public boolean isDatabaseSyncedSet() {
        return this._isElementSet((byte)3);
    }

    @Override
    public boolean isCapabilitiesSet() {
        return this._isElementSet((byte)4);
    }

    @Override
    public void setSource(int n) {
        this.attrSource = n;
        this._setElement((byte)0, true);
    }

    @Override
    public void setState(int n) {
        this.attrState = n;
        this._setElement((byte)1, true);
    }

    @Override
    public void setDatabaseSupported(boolean bl) {
        this.attrDatabaseSupported = bl;
        this._setElement((byte)2, true);
    }

    @Override
    public void setDatabaseSynced(boolean bl) {
        this.attrDatabaseSynced = bl;
        this._setElement((byte)3, true);
    }

    @Override
    public void setCapabilities(MediaCapabilitiesContainer mediaCapabilitiesContainer) {
        this.attrCapabilities = mediaCapabilitiesContainer;
        this._setElement((byte)4, null != mediaCapabilitiesContainer);
        if (null != mediaCapabilitiesContainer) {
            mediaCapabilitiesContainer.setElementId(151);
        }
    }

    @Override
    public void unsetSource() {
        this.attrSource = 0;
        this._setElement((byte)0, false);
    }

    @Override
    public void unsetState() {
        this.attrState = 0;
        this._setElement((byte)1, false);
    }

    @Override
    public void unsetDatabaseSupported() {
        this.attrDatabaseSupported = false;
        this._setElement((byte)2, false);
    }

    @Override
    public void unsetDatabaseSynced() {
        this.attrDatabaseSynced = false;
        this._setElement((byte)3, false);
    }

    @Override
    public void unsetCapabilities() {
        this.attrCapabilities = null;
        this._setElement((byte)4, false);
    }
}

