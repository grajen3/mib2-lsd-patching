/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.navigation;

import de.esolutions.fw.comm.asi.hmisync.navigation.ASIHMISyncNavigationReply;
import de.esolutions.fw.comm.asi.hmisync.navigation.DestinationInfo;

public interface ASIHMISyncNavigationS {
    default public void startGuidanceToDestinations(DestinationInfo[] destinationInfoArray, ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
    }

    default public void setNotification(ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
    }

    default public void setNotification(long l, ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
    }

    default public void setNotification(long[] lArray, ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
    }

    default public void clearNotification(ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
    }

    default public void clearNotification(long l, ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
    }

    default public void clearNotification(long[] lArray, ASIHMISyncNavigationReply aSIHMISyncNavigationReply) {
    }
}

