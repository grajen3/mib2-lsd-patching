/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.ooc.app;

import de.esolutions.fw.comm.asi.ooc.app.IOocApplicationReply;

public interface IOocApplicationS {
    default public void setCarWakeup(boolean bl, IOocApplicationReply iOocApplicationReply) {
    }

    default public void setCallActive(boolean bl, IOocApplicationReply iOocApplicationReply) {
    }

    default public void setPhonePowerDelay(boolean bl, IOocApplicationReply iOocApplicationReply) {
    }

    default public void setNavigationPowerDelay(boolean bl, IOocApplicationReply iOocApplicationReply) {
    }

    default public void setApplicationState(int n, int n2, IOocApplicationReply iOocApplicationReply) {
    }

    default public void setZrActive(boolean bl, IOocApplicationReply iOocApplicationReply) {
    }

    default public void registerPowerEventListener(IOocApplicationReply iOocApplicationReply) {
    }

    default public void shutdownResponseFinal(int n, IOocApplicationReply iOocApplicationReply) {
    }
}

