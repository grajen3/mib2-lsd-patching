/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.instance;

import de.esolutions.fw.comm.asi.hmisync.instance.ASIHMISyncInstanceReply;

public interface ASIHMISyncInstanceS {
    default public void requestInstanceId(String string, String string2, ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
    }

    default public void setNotification(ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
    }

    default public void setNotification(long l, ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
    }

    default public void setNotification(long[] lArray, ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
    }

    default public void clearNotification(ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
    }

    default public void clearNotification(long l, ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
    }

    default public void clearNotification(long[] lArray, ASIHMISyncInstanceReply aSIHMISyncInstanceReply) {
    }
}

