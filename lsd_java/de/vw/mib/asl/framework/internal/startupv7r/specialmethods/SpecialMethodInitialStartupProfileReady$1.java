/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.startupv7r.specialmethods;

import de.vw.mib.asl.framework.api.persistence2.startup.PersistenceStartupAdapter;
import de.vw.mib.asl.framework.internal.startupv7r.specialmethods.SpecialMethodInitialStartupProfileReady;

class SpecialMethodInitialStartupProfileReady$1
extends PersistenceStartupAdapter {
    private final /* synthetic */ SpecialMethodInitialStartupProfileReady this$0;

    SpecialMethodInitialStartupProfileReady$1(SpecialMethodInitialStartupProfileReady specialMethodInitialStartupProfileReady) {
        this.this$0 = specialMethodInitialStartupProfileReady;
    }

    @Override
    public void notifyInitialStartupProfileSet() {
        SpecialMethodInitialStartupProfileReady.access$000(this.this$0, "[SpecialMethodInitialStartupProfileReady] Initial profile was received.");
        SpecialMethodInitialStartupProfileReady.access$100(this.this$0);
    }
}

