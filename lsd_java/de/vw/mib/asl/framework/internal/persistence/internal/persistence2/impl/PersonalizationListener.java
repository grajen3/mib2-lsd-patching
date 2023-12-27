/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.api.persistence2.GlobalProfileChangeListener;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.PersistableService;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.ProfileCopyService;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.ProfileResetService;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PersonalizationListener$1;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PersonalizationListener$CopyProfileDesc;
import de.vw.mib.asl.framework.internal.persistence.internal.servicesprovider.PersistenceServices;
import org.dsi.ifc.personalization.DSIPersonalizationListener;

public class PersonalizationListener
implements DSIPersonalizationListener {
    private static final byte NO_PROFILE_RESET_PENDING;
    PersonalizationListener$CopyProfileDesc pendingCopyProfileInvokation;
    byte pendingProfileReset = (byte)-1;
    boolean isResetAllProfilesPending;
    private final ProfileCopyService profileCopyService;
    private final ProfileResetService profileResetService;
    private final PersistableService persistenceService;

    public PersonalizationListener(PersistenceServices persistenceServices) {
        this.profileCopyService = persistenceServices.getProfileCopyService();
        this.profileResetService = persistenceServices.getProfileResetService();
        this.persistenceService = persistenceServices.getPersistableService();
        this.persistenceService.addGlobalProfileChangeListener(this.createGlobalProfileChangeListener(), 0);
    }

    @Override
    public void copyProfile(int n, int n2) {
        if (!this.persistenceService.isProfileSwitchOngoing()) {
            this.profileCopyService.copyProfile((byte)n, (byte)n2);
        } else {
            this.pendingCopyProfileInvokation = new PersonalizationListener$CopyProfileDesc(this, (byte)n, (byte)n2);
        }
    }

    @Override
    public void resetProfile(int n) {
        if (!this.persistenceService.isProfileSwitchOngoing()) {
            this.profileResetService.resetProfile((byte)n);
        } else {
            this.pendingProfileReset = (byte)n;
        }
    }

    @Override
    public void resetAllProfiles() {
        if (!this.persistenceService.isProfileSwitchOngoing()) {
            this.profileResetService.resetAllProfiles();
        } else {
            this.isResetAllProfilesPending = true;
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    private GlobalProfileChangeListener createGlobalProfileChangeListener() {
        ProfileCopyService profileCopyService = this.profileCopyService;
        ProfileResetService profileResetService = this.profileResetService;
        return new PersonalizationListener$1(this, profileCopyService, profileResetService);
    }
}

