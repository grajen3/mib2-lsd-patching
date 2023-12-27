/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger;

import de.vw.mib.asl.framework.api.persistence2.ProfileChangeCallback;
import de.vw.mib.asl.framework.api.persistence2.ProfileChangeListener;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.AwaitChangeDone;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.ProfileChanger$Context;

class AwaitChangeDone$2
implements ProfileChangeCallback {
    private final /* synthetic */ ProfileChanger$Context val$ctx;
    private final /* synthetic */ ProfileChangeListener val$listener;
    private final /* synthetic */ AwaitChangeDone this$0;

    AwaitChangeDone$2(AwaitChangeDone awaitChangeDone, ProfileChanger$Context profileChanger$Context, ProfileChangeListener profileChangeListener) {
        this.this$0 = awaitChangeDone;
        this.val$ctx = profileChanger$Context;
        this.val$listener = profileChangeListener;
    }

    @Override
    public void notifyReadyForProfileChange() {
    }

    @Override
    public void notifyProfileChanged(boolean bl) {
        this.this$0.onProfileChanged(this.val$ctx, this.val$listener, bl);
    }
}

