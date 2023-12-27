/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homescreen;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.impl.homescreen.HomeScreenMainTarget;

class HomeScreenMainTarget$1
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ HomeScreenMainTarget this$0;

    HomeScreenMainTarget$1(HomeScreenMainTarget homeScreenMainTarget) {
        this.this$0 = homeScreenMainTarget;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.this$0.resetTileApps();
        factoryResetCallback.notifyResetDone();
    }
}

