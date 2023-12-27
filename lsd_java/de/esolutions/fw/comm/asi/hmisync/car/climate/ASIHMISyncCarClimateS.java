/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.climate;

import de.esolutions.fw.comm.asi.hmisync.car.climate.ASIHMISyncCarClimateReply;

public interface ASIHMISyncCarClimateS {
    default public void setAirconAC(boolean bl, ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply) {
    }

    default public void setNotification(ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply) {
    }

    default public void setNotification(long l, ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply) {
    }

    default public void setNotification(long[] lArray, ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply) {
    }

    default public void clearNotification(ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply) {
    }

    default public void clearNotification(long l, ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply) {
    }

    default public void clearNotification(long[] lArray, ASIHMISyncCarClimateReply aSIHMISyncCarClimateReply) {
    }
}

