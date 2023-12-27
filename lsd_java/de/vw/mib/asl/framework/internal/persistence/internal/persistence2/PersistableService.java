/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2;

import de.vw.mib.asl.framework.api.persistence2.GlobalProfileChangeListener;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PreChangeOperation;

public interface PersistableService {
    public static final int CURRENT_ACTION__NONE;
    public static final int CURRENT_ACTION__PROFILE_CHANGE;
    public static final int CURRENT_ACTION__PROFILE_RESET;
    public static final int CURRENT_ACTION__PROFILE_RESET_ALL;
    public static final byte DEFAULT_PROFILE;

    default public void activateProfile(byte by) {
    }

    default public void addGlobalProfileChangeListener(GlobalProfileChangeListener globalProfileChangeListener, int n) {
    }

    default public void addProfileChangeListener(PersistenceModule persistenceModule, ProfileChangeListener profileChangeListener) {
    }

    default public byte getActiveProfile() {
    }

    default public int getCurrentAction() {
    }

    default public boolean isProfileSwitchOngoing() {
    }

    default public Persistable loadPersistable(PersistenceModule persistenceModule, int n) {
    }

    default public void removeGlobalProfileChangeListener(GlobalProfileChangeListener globalProfileChangeListener) {
    }

    default public void removeProfileChangeListener(PersistenceModule persistenceModule, ProfileChangeListener profileChangeListener) {
    }

    default public void setupInitialProfile(byte by) {
    }

    default public byte getInitialProfile() {
    }

    default public void updateProfile(PreChangeOperation preChangeOperation) {
    }

    default public void writeDirtyRecords() {
    }
}

