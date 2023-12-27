/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.speech.voiceencoder;

import de.esolutions.fw.comm.asi.speech.voiceencoder.VoiceEncoderReply;

public interface VoiceEncoderS {
    default public void startEncode(int n, String string, String string2, long l, VoiceEncoderReply voiceEncoderReply) {
    }

    default public void cancel(VoiceEncoderReply voiceEncoderReply) {
    }
}

