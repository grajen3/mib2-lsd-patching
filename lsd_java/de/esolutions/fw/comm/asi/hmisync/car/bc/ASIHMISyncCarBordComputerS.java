/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.bc;

import de.esolutions.fw.comm.asi.hmisync.car.bc.ASIHMISyncCarBordComputerReply;

public interface ASIHMISyncCarBordComputerS {
    default public void setNotification(ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply) {
    }

    default public void setNotification(long l, ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply) {
    }

    default public void setNotification(long[] lArray, ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply) {
    }

    default public void clearNotification(ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply) {
    }

    default public void clearNotification(long l, ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply) {
    }

    default public void clearNotification(long[] lArray, ASIHMISyncCarBordComputerReply aSIHMISyncCarBordComputerReply) {
    }
}

