/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.api.persistence2.GlobalProfileChangeListener;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.ProfileCopyService;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.ProfileResetService;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.PersonalizationListener;

class PersonalizationListener$1
implements GlobalProfileChangeListener {
    private final /* synthetic */ ProfileCopyService val$internalProfileCopyService;
    private final /* synthetic */ ProfileResetService val$internalProfileRestService;
    private final /* synthetic */ PersonalizationListener this$0;

    PersonalizationListener$1(PersonalizationListener personalizationListener, ProfileCopyService profileCopyService, ProfileResetService profileResetService) {
        this.this$0 = personalizationListener;
        this.val$internalProfileCopyService = profileCopyService;
        this.val$internalProfileRestService = profileResetService;
    }

    @Override
    public void onProfileChangeStarted() {
    }

    @Override
    public void onProfileChangeCompleted() {
        boolean bl;
        boolean bl2 = bl = this.this$0.pendingCopyProfileInvokation != null;
        if (bl) {
            this.val$internalProfileCopyService.copyProfile(this.this$0.pendingCopyProfileInvokation.getSourceProfile(), this.this$0.pendingCopyProfileInvokation.getDestinationProfile());
            this.this$0.pendingCopyProfileInvokation = null;
        }
        if (this.this$0.pendingProfileReset != -1) {
            this.val$internalProfileRestService.resetProfile(this.this$0.pendingProfileReset);
            this.this$0.pendingProfileReset = (byte)-1;
        }
        if (this.this$0.isResetAllProfilesPending) {
            this.val$internalProfileRestService.resetAllProfiles();
            this.this$0.isResetAllProfilesPending = false;
        }
    }
}

