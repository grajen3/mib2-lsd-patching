/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents;

import de.vw.mib.genericevents.EventGeneric;

public interface TimerServer {
    default public boolean isTimerActive(int n, int n2) {
    }

    default public boolean isTimerSuspended(int n, int n2) {
    }

    default public void restartOrStartTimedEvent(EventGeneric eventGeneric, long l, boolean bl) {
    }

    default public void restartOrStartTimedEvent(int n, int n2, long l, boolean bl) {
    }

    default public void restartTimedEvent(int n, int n2) {
    }

    default public void resumeTimedEvent(int n, int n2) {
    }

    default public void sendTimedEvent(EventGeneric eventGeneric, long l, boolean bl) {
    }

    default public void sendTimedEvent(EventGeneric eventGeneric, long l, boolean bl, boolean bl2) {
    }

    default public void sendTimedEvent(int n, int n2, long l, boolean bl) {
    }

    default public void stopTimedEvent(int n, int n2) {
    }

    default public void suspendTimedEvent(int n, int n2) {
    }
}

