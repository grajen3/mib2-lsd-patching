/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence;

import de.vw.mib.asl.framework.api.persistence.SharedPersistable;
import de.vw.mib.asl.framework.api.persistence2.GlobalProfileChangeListener;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;
import de.vw.mib.asl.framework.api.persistence2.ProfileOperationParticipant;
import de.vw.mib.asl.framework.api.persistence2.dsi.AbstractPersonalizedAppDsiAdapter;
import de.vw.mib.asl.framework.api.persistence2.dsi.DsiAwareProfileChangeListener;

public interface AslPersistenceSyncApi {
    default public void activateProfile(byte by) {
    }

    default public boolean isProfileChangeRunning() {
    }

    default public void addGlobalProfileChangeListener(GlobalProfileChangeListener globalProfileChangeListener) {
    }

    default public void addGlobalProfileChangeListener(GlobalProfileChangeListener globalProfileChangeListener, int n) {
    }

    default public void addProfileChangeListener(PersistenceModule persistenceModule, ProfileChangeListener profileChangeListener) {
    }

    default public void addProfileOperationParticipant(ProfileOperationParticipant profileOperationParticipant) {
    }

    default public ProfileChangeListener createProfileChangeListener(PersistenceModule persistenceModule, DsiAwareProfileChangeListener dsiAwareProfileChangeListener) {
    }

    default public void flushDatabase(boolean bl) {
    }

    default public byte getActiveProfile() {
    }

    default public boolean loadPersistable(int n, long l, de.vw.mib.asl.framework.api.persistence.Persistable persistable) {
    }

    default public Persistable loadPersistable(PersistenceModule persistenceModule, int n) {
    }

    default public long makeKey(long l, long l2) {
    }

    default public boolean readBoolean(int n, long l, boolean bl) {
    }

    default public byte[] readByteArray(int n, long l, byte[] byArray) {
    }

    default public int readInt(int n, long l, int n2) {
    }

    default public String readString(int n, long l, String string) {
    }

    default public String[] readStringArray(int n, long l, String[] stringArray) {
    }

    default public void registerDsiAdapter(PersistenceModule persistenceModule, AbstractPersonalizedAppDsiAdapter abstractPersonalizedAppDsiAdapter) {
    }

    default public void registerSharedPersistable(SharedPersistable sharedPersistable) {
    }

    default public void removeGlobalProfileChangeListener(GlobalProfileChangeListener globalProfileChangeListener) {
    }

    default public void removeProfileChangeListener(PersistenceModule persistenceModule, ProfileChangeListener profileChangeListener) {
    }

    default public void setUser(long l) {
    }

    default public boolean storePersistable(int n, long l, de.vw.mib.asl.framework.api.persistence.Persistable persistable) {
    }

    default public void writeBoolean(int n, long l, boolean bl) {
    }

    default public void writeByteArray(int n, long l, byte[] byArray) {
    }

    default public void writeInt(int n, long l, int n2) {
    }

    default public void writeString(int n, long l, String string) {
    }

    default public void writeStringArray(int n, long l, String[] stringArray) {
    }
}

