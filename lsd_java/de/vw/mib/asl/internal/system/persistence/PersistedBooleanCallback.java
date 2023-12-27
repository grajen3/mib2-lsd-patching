/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.persistence;

import de.vw.mib.asl.systemcommon.persistence.SystemCommon;

public interface PersistedBooleanCallback {
    default public void set(SystemCommon systemCommon, boolean bl) {
    }

    default public boolean get(SystemCommon systemCommon) {
    }

    default public boolean getDefault() {
    }
}

