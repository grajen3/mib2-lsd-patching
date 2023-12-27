/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car;

import de.esolutions.fw.comm.asi.hmisync.car.ASIHMISyncCarGenericReply;

public interface ASIHMISyncCarGenericS {
    default public void setNotification(ASIHMISyncCarGenericReply aSIHMISyncCarGenericReply) {
    }

    default public void setNotification(long l, ASIHMISyncCarGenericReply aSIHMISyncCarGenericReply) {
    }

    default public void setNotification(long[] lArray, ASIHMISyncCarGenericReply aSIHMISyncCarGenericReply) {
    }

    default public void clearNotification(ASIHMISyncCarGenericReply aSIHMISyncCarGenericReply) {
    }

    default public void clearNotification(long l, ASIHMISyncCarGenericReply aSIHMISyncCarGenericReply) {
    }

    default public void clearNotification(long[] lArray, ASIHMISyncCarGenericReply aSIHMISyncCarGenericReply) {
    }
}

