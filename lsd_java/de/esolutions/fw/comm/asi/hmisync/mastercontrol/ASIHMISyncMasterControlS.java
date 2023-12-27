/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.mastercontrol;

import de.esolutions.fw.comm.asi.hmisync.mastercontrol.ASIHMISyncMasterControlReply;

public interface ASIHMISyncMasterControlS {
    default public void setNotification(ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
    }

    default public void setNotification(long l, ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
    }

    default public void setNotification(long[] lArray, ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
    }

    default public void clearNotification(ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
    }

    default public void clearNotification(long l, ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
    }

    default public void clearNotification(long[] lArray, ASIHMISyncMasterControlReply aSIHMISyncMasterControlReply) {
    }
}

