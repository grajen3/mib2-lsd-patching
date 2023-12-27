/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger;

import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.AwaitPreparationDone;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.ProfileChanger$Context;

class AwaitPreparationDone$1
implements Runnable {
    private final /* synthetic */ ProfileChanger$Context val$ctx;
    private final /* synthetic */ AwaitPreparationDone this$0;

    AwaitPreparationDone$1(AwaitPreparationDone awaitPreparationDone, ProfileChanger$Context profileChanger$Context) {
        this.this$0 = awaitPreparationDone;
        this.val$ctx = profileChanger$Context;
    }

    @Override
    public void run() {
        this.this$0.onPreparationTimeout(this.val$ctx);
    }
}

