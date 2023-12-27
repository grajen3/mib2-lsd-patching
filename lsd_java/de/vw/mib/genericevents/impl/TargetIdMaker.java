/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents.impl;

import de.vw.mib.genericevents.EventDispatcherHSM;

final class TargetIdMaker {
    private int nextTargetId = -2137614336;
    private final EventDispatcherHSM dispatcher;

    TargetIdMaker(EventDispatcherHSM eventDispatcherHSM) {
        this.dispatcher = eventDispatcherHSM;
    }

    int next() {
        int n = 0;
        do {
            int n2 = this.nextTargetId++;
            if (this.nextTargetId >= -129) {
                this.nextTargetId = -2137614336;
            }
            if (this.dispatcher.isTargetRegistered(n2)) continue;
            n = n2;
        } while (n == 0);
        return n;
    }
}

