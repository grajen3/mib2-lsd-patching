/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.driving;

import de.esolutions.fw.comm.asi.hmisync.car.driving.ASIHMISyncCarDrivingReply;

public interface ASIHMISyncCarDrivingS {
    default public void setNotification(ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
    }

    default public void setNotification(long l, ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
    }

    default public void setNotification(long[] lArray, ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
    }

    default public void clearNotification(ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
    }

    default public void clearNotification(long l, ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
    }

    default public void clearNotification(long[] lArray, ASIHMISyncCarDrivingReply aSIHMISyncCarDrivingReply) {
    }
}

