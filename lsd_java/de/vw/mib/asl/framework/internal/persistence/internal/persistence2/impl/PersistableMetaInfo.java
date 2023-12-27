/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;

public class PersistableMetaInfo {
    private final byte profileId;
    private final PersistenceModule module;

    public PersistableMetaInfo(byte by, PersistenceModule persistenceModule) {
        this.profileId = by;
        this.module = persistenceModule;
    }

    public byte getProfileId() {
        return this.profileId;
    }

    public PersistenceModule getModule() {
        return this.module;
    }
}

