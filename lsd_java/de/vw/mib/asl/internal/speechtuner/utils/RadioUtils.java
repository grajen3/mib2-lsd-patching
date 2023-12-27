/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.utils;

import de.vw.mib.asl.api.radio.Station;
import de.vw.mib.asl.api.radio.amFm.AmFmStation;
import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerAMFrequency;
import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerFMFrequency;

public interface RadioUtils {
    public static final int INVALID_RADIODB_ID;
    public static final int HD_ONLY_SUBCHANNEL;
    public static final int FREQUENCY_STRING_NOUNIT;
    public static final int FREQUENCY_STRING_MHZ;
    public static final int FREQUENCY_STRING_FM;

    default public String getStringFromStationWithoutUnit(AmFmStation amFmStation) {
    }

    default public String getStringFromStationWithBand(AmFmStation amFmStation) {
    }

    default public String getStringFromStationWithMHz(AmFmStation amFmStation) {
    }

    default public String getStringFromFrequencyWithoutUnit(SpeechTunerFMFrequency speechTunerFMFrequency) {
    }

    default public String getStringFromFrequencyCombined(SpeechTunerFMFrequency speechTunerFMFrequency) {
    }

    default public String getStringFromFrequencyWithoutUnit(SpeechTunerAMFrequency speechTunerAMFrequency) {
    }

    default public int getOutputHDSubchannelFM(int n) {
    }

    default public int getInternalHDSubchannel(int n) {
    }

    default public int getOutputHDSubchannelAM(int n) {
    }

    default public SpeechTunerFMFrequency createInternalFMFrequency(AmFmStation amFmStation, boolean bl) {
    }

    default public SpeechTunerAMFrequency createInternalAMFrequency(AmFmStation amFmStation) {
    }

    default public long getObjectId(Station station) {
    }

    default public long getStationIdFromDBId(long l) {
    }
}

