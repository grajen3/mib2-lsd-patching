/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence2;

import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.framework.api.persistence2.ModulePersistenceService;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;
import de.vw.mib.asl.framework.api.persistence2.dsi.DsiAwareProfileChangeListener;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractModulePersistenceService
implements ModulePersistenceService {
    private final Map mapDsiAwareListener2AdaptedListener = new HashMap();
    private final AslPersistenceSyncApi persistenceApi;

    protected AbstractModulePersistenceService(AslPersistenceSyncApi aslPersistenceSyncApi) {
        this.persistenceApi = aslPersistenceSyncApi;
    }

    @Override
    public void addProfileChangeListener(DsiAwareProfileChangeListener dsiAwareProfileChangeListener) {
        ProfileChangeListener profileChangeListener = this.persistenceApi.createProfileChangeListener(this.getPersistenceModule(), dsiAwareProfileChangeListener);
        this.mapDsiAwareListener2AdaptedListener.put(dsiAwareProfileChangeListener, profileChangeListener);
        this.addProfileChangeListener(profileChangeListener);
    }

    @Override
    public void addProfileChangeListener(ProfileChangeListener profileChangeListener) {
        this.persistenceApi.addProfileChangeListener(this.getPersistenceModule(), profileChangeListener);
    }

    @Override
    public void removeProfileChangeListener(DsiAwareProfileChangeListener dsiAwareProfileChangeListener) {
        ProfileChangeListener profileChangeListener = (ProfileChangeListener)this.mapDsiAwareListener2AdaptedListener.get(dsiAwareProfileChangeListener);
        this.removeProfileChangeListener(profileChangeListener);
    }

    @Override
    public void removeProfileChangeListener(ProfileChangeListener profileChangeListener) {
        this.persistenceApi.removeProfileChangeListener(this.getPersistenceModule(), profileChangeListener);
    }

    protected abstract PersistenceModule getPersistenceModule() {
    }
}

