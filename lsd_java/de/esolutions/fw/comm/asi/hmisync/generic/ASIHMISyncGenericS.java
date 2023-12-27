/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.generic;

import de.esolutions.fw.comm.asi.hmisync.generic.ASIHMISyncGenericReply;
import de.esolutions.fw.comm.asi.hmisync.generic.GenericPacket;

public interface ASIHMISyncGenericS {
    default public void sendDataToUnit(GenericPacket genericPacket, ASIHMISyncGenericReply aSIHMISyncGenericReply) {
    }

    default public void setNotification(ASIHMISyncGenericReply aSIHMISyncGenericReply) {
    }

    default public void setNotification(long l, ASIHMISyncGenericReply aSIHMISyncGenericReply) {
    }

    default public void setNotification(long[] lArray, ASIHMISyncGenericReply aSIHMISyncGenericReply) {
    }

    default public void clearNotification(ASIHMISyncGenericReply aSIHMISyncGenericReply) {
    }

    default public void clearNotification(long l, ASIHMISyncGenericReply aSIHMISyncGenericReply) {
    }

    default public void clearNotification(long[] lArray, ASIHMISyncGenericReply aSIHMISyncGenericReply) {
    }
}

