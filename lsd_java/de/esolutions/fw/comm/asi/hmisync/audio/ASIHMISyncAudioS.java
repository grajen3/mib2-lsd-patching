/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.audio;

import de.esolutions.fw.comm.asi.hmisync.audio.ASIHMISyncAudioReply;

public interface ASIHMISyncAudioS {
    default public void setAudioContext(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
    }

    default public void forceFrontAudioContext(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
    }

    default public void requestEnableA2LS(String string, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
    }

    default public void disableA2LS(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
    }

    default public void setVolume(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
    }

    default public void increaseVolume(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
    }

    default public void decreaseVolume(int n, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
    }

    default public void setNotification(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
    }

    default public void setNotification(long l, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
    }

    default public void setNotification(long[] lArray, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
    }

    default public void clearNotification(ASIHMISyncAudioReply aSIHMISyncAudioReply) {
    }

    default public void clearNotification(long l, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
    }

    default public void clearNotification(long[] lArray, ASIHMISyncAudioReply aSIHMISyncAudioReply) {
    }
}

