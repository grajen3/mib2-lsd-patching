/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.entryconditions;

import de.vw.mib.asl.framework.internal.startupv7r.model.ContextWorkUnit;

public interface EntryCondition {
    default public void apply(ContextWorkUnit contextWorkUnit) {
    }

    default public int getBitmask() {
    }
}

