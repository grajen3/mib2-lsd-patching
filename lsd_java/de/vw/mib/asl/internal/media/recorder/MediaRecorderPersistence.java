/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.recorder;

import de.vw.mib.asl.framework.api.persistence.AbstractSharedPersistable;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;

class MediaRecorderPersistence
extends AbstractSharedPersistable {
    private static final short VERSION;
    private static final short[] SUPPORTED_VERSIONS;
    private int mUserEncodingQuality;

    public MediaRecorderPersistence() {
        super(5007, 0);
        this.clear();
        ServiceManager.persistence.registerSharedPersistable(this);
        ServiceManager.persistence.loadPersistable(this.getNamespace(), this.getKey(), this);
    }

    @Override
    public void clearUnknownValues(short s) {
    }

    @Override
    public void fromStreamInternal(PersistenceInputStream persistenceInputStream, short s) {
        this.mUserEncodingQuality = persistenceInputStream.readInt();
    }

    @Override
    public short getVersion() {
        return 1;
    }

    @Override
    public short[] getSupportedVersions() {
        return SUPPORTED_VERSIONS;
    }

    @Override
    public void toStreamInternal(PersistenceOutputStream persistenceOutputStream) {
        persistenceOutputStream.writeInt(this.mUserEncodingQuality);
    }

    @Override
    public void clear() {
        this.mUserEncodingQuality = 2;
    }

    public int getUserEncodingQuality() {
        return this.mUserEncodingQuality;
    }

    public void setUserEncodingQuality(int n) {
        this.mUserEncodingQuality = n;
        this.markDirty(true);
    }

    public String toString() {
        return new StringBuffer().append("MediaRecorderPersistence userEncodingQuality=").append(this.mUserEncodingQuality).toString();
    }

    static {
        SUPPORTED_VERSIONS = NO_SUPPORTED_VERSION;
    }
}

