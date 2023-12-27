/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger;

import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.AwaitChangeDone;
import de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.ProfileChanger$Context;

class AwaitChangeDone$1
implements Runnable {
    private final /* synthetic */ ProfileChanger$Context val$ctx;
    private final /* synthetic */ AwaitChangeDone this$0;

    AwaitChangeDone$1(AwaitChangeDone awaitChangeDone, ProfileChanger$Context profileChanger$Context) {
        this.this$0 = awaitChangeDone;
        this.val$ctx = profileChanger$Context;
    }

    @Override
    public void run() {
        this.this$0.onTimeout(this.val$ctx);
    }
}

