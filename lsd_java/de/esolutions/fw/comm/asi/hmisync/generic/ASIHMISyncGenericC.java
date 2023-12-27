/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.generic;

import de.esolutions.fw.comm.asi.hmisync.generic.GenericPacket;

public interface ASIHMISyncGenericC {
    default public void sendDataToUnit(GenericPacket genericPacket) {
    }

    default public void setNotification() {
    }

    default public void setNotification(long l) {
    }

    default public void setNotification(long[] lArray) {
    }

    default public void clearNotification() {
    }

    default public void clearNotification(long l) {
    }

    default public void clearNotification(long[] lArray) {
    }
}

