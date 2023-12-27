/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.proximity.component;

import de.vw.mib.asl.internal.system.proximity.component.AbstractProximityComponent;

class AbstractProximityComponent$1
implements Runnable {
    private final /* synthetic */ AbstractProximityComponent this$0;

    AbstractProximityComponent$1(AbstractProximityComponent abstractProximityComponent) {
        this.this$0 = abstractProximityComponent;
    }

    @Override
    public void run() {
        this.this$0.setApproximated(false);
    }
}

