/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.persistence;

import de.vw.mib.asl.exboxkorea.persistence.ExboxKoreaPersistenceServiceImpl;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeCallback;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;
import de.vw.mib.asl.internal.exboxm.persistence.PersistableExBoxOptions;

public class KoreaProfileChangeListener
implements ProfileChangeListener {
    private final PersistableExBoxOptions persistableService;

    public KoreaProfileChangeListener(PersistableExBoxOptions persistableExBoxOptions) {
        this.persistableService = persistableExBoxOptions;
    }

    @Override
    public void prepareForProfileChange(ProfileChangeCallback profileChangeCallback) {
        profileChangeCallback.notifyReadyForProfileChange();
    }

    @Override
    public void changeProfile(ProfileChangeCallback profileChangeCallback) {
        this.persistableService.changePersistence(ExboxKoreaPersistenceServiceImpl.getInstance().loadExboxKorea());
        profileChangeCallback.notifyProfileChanged(true);
    }
}

