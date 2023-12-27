/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2;

import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;

public interface PersistenceTracing {
    default public String retrieveName(ProfileChangeListener profileChangeListener) {
    }

    default public void registerListener(ProfileChangeListener profileChangeListener, String string) {
    }
}

