/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.keypanel.lock.components;

import de.vw.mib.asl.internal.system.keypanel.lock.components.LscComponent;
import de.vw.mib.lsctng.LscUserInteractionFilterService;

class LscComponent$1
implements LscUserInteractionFilterService {
    private final /* synthetic */ LscComponent this$0;

    LscComponent$1(LscComponent lscComponent) {
        this.this$0 = lscComponent;
    }

    @Override
    public void stopLsChangerFilter() {
        this.this$0.setLocked(false);
    }

    @Override
    public void startLsChangerFilter() {
        this.this$0.setLocked(true);
    }
}

