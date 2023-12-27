/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.headunit;

import de.esolutions.fw.comm.asi.hmisync.headunit.ASIHMISyncHeadUnitReply;

public interface ASIHMISyncHeadUnitS {
    default public void setNotification(ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply) {
    }

    default public void setNotification(long l, ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply) {
    }

    default public void setNotification(long[] lArray, ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply) {
    }

    default public void clearNotification(ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply) {
    }

    default public void clearNotification(long l, ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply) {
    }

    default public void clearNotification(long[] lArray, ASIHMISyncHeadUnitReply aSIHMISyncHeadUnitReply) {
    }
}

