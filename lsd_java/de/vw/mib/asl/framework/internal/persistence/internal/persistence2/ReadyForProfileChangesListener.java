/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2;

import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;

public interface ReadyForProfileChangesListener {
    default public void onReadyForProfileChanges(PersistenceModule persistenceModule) {
    }
}

