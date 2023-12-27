/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence;

import de.vw.mib.asl.framework.api.persistence.Persistable;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;

public interface VersionedPersistable
extends Persistable {
    public static final short INVALID_VERSION;
    public static final short NO_VERSION;
    public static final short[] NO_SUPPORTED_VERSION;

    default public void fromStreamInternal(PersistenceInputStream persistenceInputStream, short s) {
    }

    default public void toStreamInternal(PersistenceOutputStream persistenceOutputStream) {
    }

    default public void clearUnknownValues(short s) {
    }

    default public short[] getSupportedVersions() {
    }

    default public short getVersion() {
    }

    default public short getCorrectOrSupportedVersion(PersistenceInputStream persistenceInputStream) {
    }

    static {
        NO_SUPPORTED_VERSION = new short[0];
    }
}

