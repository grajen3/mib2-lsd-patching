/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.entertainmentmanager;

import de.vw.mib.asl.entertainmentmanager.persistence.EntertainmentManagerPersistenceServiceImpl;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeCallback;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;
import de.vw.mib.asl.framework.internal.entertainmentmanager.EntertainmentManagerPersistence;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;

class EntertainmentManagerPersistence$1
implements ProfileChangeListener {
    private final /* synthetic */ EntertainmentManagerPersistence this$0;

    EntertainmentManagerPersistence$1(EntertainmentManagerPersistence entertainmentManagerPersistence) {
        this.this$0 = entertainmentManagerPersistence;
    }

    @Override
    public void prepareForProfileChange(ProfileChangeCallback profileChangeCallback) {
        profileChangeCallback.notifyReadyForProfileChange();
    }

    @Override
    public void changeProfile(ProfileChangeCallback profileChangeCallback) {
        boolean bl = ASLPersistenceFactory.getPersistenceApi().getPersistenceStartupService().getProfileChangeMode() == 0;
        int n = EntertainmentManagerPersistence.access$000(this.this$0).getContext();
        EntertainmentManagerPersistence.access$002(this.this$0, EntertainmentManagerPersistenceServiceImpl.getInstance().loadEntertainmentPersistence());
        if (bl) {
            EntertainmentManagerPersistence.access$100(this.this$0, n);
        }
        int n2 = this.this$0.loadContext();
        this.this$0.setActive(this.this$0.getContextLastmode(n2));
        profileChangeCallback.notifyProfileChanged(true);
        if (ServiceManager.logger2.isTraceEnabled(16)) {
            ServiceManager.logger2.trace(16).append("EntertainmentManagerPersistence.changeProfile: oldContext=").append(n).append(", newContext=").append(n2).append(", isQuickStartChange=").append(bl).log();
        }
    }
}

