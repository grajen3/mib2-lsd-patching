/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.radio.speech.sirius;

import de.vw.mib.asl.api.radio.sdars.SiriusChannel;
import de.vw.mib.asl.api.radio.speech.TuningResponseListener;
import de.vw.mib.asl.api.radio.speech.sirius.SiriusChannelListListener;

public interface AslRadioSiriusFacade {
    default public void tuneSiriusChannel(SiriusChannel siriusChannel, TuningResponseListener tuningResponseListener) {
    }

    default public SiriusChannel[] registerForSiriusChannelList(SiriusChannelListListener siriusChannelListListener) {
    }
}

