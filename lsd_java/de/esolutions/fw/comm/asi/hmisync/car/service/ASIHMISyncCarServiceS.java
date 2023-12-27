/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service;

import de.esolutions.fw.comm.asi.hmisync.car.service.ASIHMISyncCarServiceReply;

public interface ASIHMISyncCarServiceS {
    default public void setNotification(ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
    }

    default public void setNotification(long l, ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
    }

    default public void setNotification(long[] lArray, ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
    }

    default public void clearNotification(ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
    }

    default public void clearNotification(long l, ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
    }

    default public void clearNotification(long[] lArray, ASIHMISyncCarServiceReply aSIHMISyncCarServiceReply) {
    }
}

