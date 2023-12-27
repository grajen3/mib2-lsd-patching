/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence;

import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import de.vw.mib.asl.framework.api.persistence.SharedPersistable;
import java.io.IOException;

public abstract class AbstractSharedPersistable
implements SharedPersistable {
    private final int mNamespace;
    private final long mKey;
    private boolean mDirty;
    private final boolean mIsCompressionEnabled;
    private boolean mEvaluateVersion = true;

    public AbstractSharedPersistable(int n, long l) {
        this.mNamespace = n;
        this.mKey = l;
        this.mIsCompressionEnabled = true;
    }

    public AbstractSharedPersistable(int n, long l, boolean bl, boolean bl2) {
        this(n, l, bl);
        this.mEvaluateVersion = bl2;
    }

    public AbstractSharedPersistable(int n, long l, boolean bl) {
        this.mNamespace = n;
        this.mKey = l;
        this.mIsCompressionEnabled = bl;
    }

    @Override
    public boolean isCompressionEnabled() {
        return this.mIsCompressionEnabled;
    }

    @Override
    public long getKey() {
        return this.mKey;
    }

    @Override
    public int getNamespace() {
        return this.mNamespace;
    }

    @Override
    public boolean isDirty() {
        return this.mDirty;
    }

    @Override
    public void markDirty(boolean bl) {
        this.mDirty = bl;
        if (this.mDirty) {
            ASLPersistenceFactory.getPersistenceApi().writeViaDsi();
        }
    }

    @Override
    public final short getCorrectOrSupportedVersion(PersistenceInputStream persistenceInputStream) {
        short s = persistenceInputStream.readShort();
        if (s == this.getVersion()) {
            return s;
        }
        short[] sArray = this.retrieveSupportedVersions();
        boolean bl = false;
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            if (s != sArray[i2]) continue;
            bl = true;
            break;
        }
        if (bl) {
            return s;
        }
        throw new IOException(new StringBuffer().append("Persistable Version not supported! Found version: ").append(s).toString());
    }

    @Override
    public final void fromStream(PersistenceInputStream persistenceInputStream) {
        if (this.mEvaluateVersion) {
            short s = this.getCorrectOrSupportedVersion(persistenceInputStream);
            if (s != -1) {
                this.fromStreamInternal(persistenceInputStream, s);
            }
        } else {
            this.fromStreamInternal(persistenceInputStream, (short)0);
        }
    }

    @Override
    public final void toStream(PersistenceOutputStream persistenceOutputStream) {
        if (this.mEvaluateVersion) {
            persistenceOutputStream.writeShort(this.getVersion());
        }
        this.toStreamInternal(persistenceOutputStream);
    }

    private short[] retrieveSupportedVersions() {
        short[] sArray = this.getSupportedVersions();
        if (sArray == null) {
            sArray = new short[]{};
        }
        return sArray;
    }
}

