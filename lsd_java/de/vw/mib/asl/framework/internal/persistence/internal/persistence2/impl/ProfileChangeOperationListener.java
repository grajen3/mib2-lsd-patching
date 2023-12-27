/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;

public interface ProfileChangeOperationListener {
    default public void onProfileChangeCompleted(PersistenceModule persistenceModule) {
    }
}

