/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger;

import de.vw.mib.asl.framework.api.persistence2.ProfileChangeCallback;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.AwaitPreparationDone;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.ProfileChanger$Context;

class AwaitPreparationDone$2
implements ProfileChangeCallback {
    private final /* synthetic */ ProfileChangeListener val$listener;
    private final /* synthetic */ ProfileChanger$Context val$ctx;
    private final /* synthetic */ AwaitPreparationDone this$0;

    AwaitPreparationDone$2(AwaitPreparationDone awaitPreparationDone, ProfileChangeListener profileChangeListener, ProfileChanger$Context profileChanger$Context) {
        this.this$0 = awaitPreparationDone;
        this.val$listener = profileChangeListener;
        this.val$ctx = profileChanger$Context;
    }

    @Override
    public void notifyReadyForProfileChange() {
        this.this$0.onReadyForProfileChange(this.val$listener, this.val$ctx);
    }

    @Override
    public void notifyProfileChanged(boolean bl) {
    }
}

