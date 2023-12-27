/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.impl.homescreen;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.internal.impl.homescreen.HomeScreenInfoTarget;

class HomeScreenInfoTarget$3
extends AbstractFactoryResetParticipant {
    private final /* synthetic */ HomeScreenInfoTarget this$0;

    HomeScreenInfoTarget$3(HomeScreenInfoTarget homeScreenInfoTarget) {
        this.this$0 = homeScreenInfoTarget;
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        this.this$0.resetHomeScreen();
        factoryResetCallback.notifyResetDone();
    }
}

