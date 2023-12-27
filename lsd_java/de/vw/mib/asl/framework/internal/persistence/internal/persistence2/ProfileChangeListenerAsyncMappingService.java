/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2;

import de.vw.mib.asl.framework.api.persistence2.GlobalProfileChangeListener;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;

public interface ProfileChangeListenerAsyncMappingService {
    default public void addGlobalProfileChangeListener(GlobalProfileChangeListener globalProfileChangeListener, int n) {
    }

    default public void addProfileChangeListener(PersistenceModule persistenceModule, ProfileChangeListener profileChangeListener) {
    }

    default public void removeGlobalProfileChangeListener(GlobalProfileChangeListener globalProfileChangeListener) {
    }

    default public void removeProfileChangeListener(PersistenceModule persistenceModule, ProfileChangeListener profileChangeListener) {
    }
}

