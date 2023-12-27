/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence;

import de.vw.mib.asl.framework.api.persistence.VersionedPersistable;

public interface SharedPersistable
extends VersionedPersistable {
    default public void markDirty(boolean bl) {
    }

    default public boolean isDirty() {
    }

    default public int getNamespace() {
    }

    default public long getKey() {
    }

    default public boolean isCompressionEnabled() {
    }
}

