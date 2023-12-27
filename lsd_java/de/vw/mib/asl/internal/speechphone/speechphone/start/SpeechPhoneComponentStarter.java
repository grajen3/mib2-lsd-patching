/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechphone.speechphone.start;

import de.vw.mib.asl.internal.speechphone.speechphone.start.SpeechPhoneActivator;
import de.vw.mib.asl.internal.speechphone.speechphone.start.SpeechPhoneInternalStartTarget;
import de.vw.mib.asl.internal.speechphone.speechphone.start.SpeechPhoneParameters;

public class SpeechPhoneComponentStarter
implements SpeechPhoneActivator {
    @Override
    public void activate(SpeechPhoneParameters speechPhoneParameters) {
        new SpeechPhoneInternalStartTarget(speechPhoneParameters);
    }
}

