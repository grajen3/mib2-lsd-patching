/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence2;

import de.vw.mib.asl.framework.api.persistence2.Persistable;

public interface PersistableSerializer {
    public static final short SERIALIZER_FORMAT_VERSION;

    default public byte[] serializeCommonData(Persistable persistable) {
    }

    default public byte[] serializeUserSpecificData(Persistable persistable) {
    }
}

