/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.sound;

import de.esolutions.fw.comm.asi.hmisync.sound.ASIHMISyncSoundReply;

public interface ASIHMISyncSoundS {
    default public void setBassValue(int n, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
    }

    default public void setTrebleValue(int n, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
    }

    default public void setBalanceValue(int n, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
    }

    default public void setFaderValue(int n, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
    }

    default public void setSubwooferValue(int n, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
    }

    default public void setSurroundValue(int n, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
    }

    default public void setNoiseCompensationValue(int n, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
    }

    default public void setThreeDModeValue(int n, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
    }

    default public void setPresetPosition(int n, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
    }

    default public void setPresetEQ(int n, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
    }

    default public void setNotification(ASIHMISyncSoundReply aSIHMISyncSoundReply) {
    }

    default public void setNotification(long l, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
    }

    default public void setNotification(long[] lArray, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
    }

    default public void clearNotification(ASIHMISyncSoundReply aSIHMISyncSoundReply) {
    }

    default public void clearNotification(long l, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
    }

    default public void clearNotification(long[] lArray, ASIHMISyncSoundReply aSIHMISyncSoundReply) {
    }
}

