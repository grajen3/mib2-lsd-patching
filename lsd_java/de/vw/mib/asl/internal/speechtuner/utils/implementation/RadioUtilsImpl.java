/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechtuner.utils.implementation;

import de.vw.mib.asl.api.radio.Station;
import de.vw.mib.asl.api.radio.amFm.AmFmStation;
import de.vw.mib.asl.api.radio.sdars.SiriusChannel;
import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerAMFrequency;
import de.vw.mib.asl.internal.speechtuner.data.internal.SpeechTunerFMFrequency;
import de.vw.mib.asl.internal.speechtuner.utils.RadioUtils;
import de.vw.mib.format.FixFormat4Asl;

public class RadioUtilsImpl
implements RadioUtils {
    private final FixFormat4Asl fixFormatter;

    public RadioUtilsImpl(FixFormat4Asl fixFormat4Asl) {
        this.fixFormatter = fixFormat4Asl;
    }

    private String getFMFrequencyString(int n, int n2) {
        return this.getFMFrequencyString(n, n2, -1);
    }

    private String getFMFrequencyString(int n, int n2, int n3) {
        return this.fixFormatter.fmtRadioFmFrequencyOrStationPrompt("", n, n2, n3);
    }

    @Override
    public String getStringFromStationWithoutUnit(AmFmStation amFmStation) {
        return this.getFMFrequencyString(amFmStation.getFrequency(), -1);
    }

    @Override
    public String getStringFromStationWithBand(AmFmStation amFmStation) {
        return this.getFMFrequencyString(amFmStation.getFrequency(), 1);
    }

    @Override
    public String getStringFromStationWithMHz(AmFmStation amFmStation) {
        return this.getFMFrequencyString(amFmStation.getFrequency(), 0);
    }

    @Override
    public String getStringFromFrequencyWithoutUnit(SpeechTunerFMFrequency speechTunerFMFrequency) {
        return this.getFMFrequencyString(speechTunerFMFrequency.getFrequency(), -1);
    }

    @Override
    public String getStringFromFrequencyCombined(SpeechTunerFMFrequency speechTunerFMFrequency) {
        if (speechTunerFMFrequency.isHDOnly()) {
            return this.getFMFrequencyString(speechTunerFMFrequency.getFrequency(), -1, 0);
        }
        return this.getFMFrequencyString(speechTunerFMFrequency.getFrequency(), -1, speechTunerFMFrequency.getConvertedHdSubChannel());
    }

    private String getAMFrequencyString(int n, int n2) {
        return this.fixFormatter.fmtRadioAmFrequencyOrStationPrompt("", n, n2, -1);
    }

    @Override
    public String getStringFromFrequencyWithoutUnit(SpeechTunerAMFrequency speechTunerAMFrequency) {
        return this.getAMFrequencyString(speechTunerAMFrequency.getFrequency(), -1);
    }

    @Override
    public int getOutputHDSubchannelFM(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 4) {
            return 3;
        }
        if (n == 8) {
            return 4;
        }
        if (n == 16) {
            return 5;
        }
        if (n == 32) {
            return 6;
        }
        if (n == 64) {
            return 7;
        }
        if (n == 128) {
            return 8;
        }
        return -1;
    }

    @Override
    public int getInternalHDSubchannel(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        if (n == 4) {
            return 8;
        }
        if (n == 5) {
            return 16;
        }
        if (n == 6) {
            return 32;
        }
        if (n == 7) {
            return 64;
        }
        if (n == 8) {
            return 128;
        }
        return 0;
    }

    @Override
    public int getOutputHDSubchannelAM(int n) {
        if (n == 0) {
            return -1;
        }
        return 0;
    }

    @Override
    public SpeechTunerFMFrequency createInternalFMFrequency(AmFmStation amFmStation, boolean bl) {
        return new SpeechTunerFMFrequency(this, amFmStation.getFrequency(), amFmStation.getHdServiceId(), bl);
    }

    @Override
    public SpeechTunerAMFrequency createInternalAMFrequency(AmFmStation amFmStation) {
        return new SpeechTunerAMFrequency(this, amFmStation.getFrequency(), amFmStation.getHdServiceId());
    }

    @Override
    public long getObjectId(Station station) {
        if (station instanceof SiriusChannel) {
            return ((SiriusChannel)station).getSid();
        }
        if (station.getRadioDbId() <= 0) {
            return station.getHmiUniqueId();
        }
        return this.getStationIdFromDBId(station.getRadioDbId());
    }

    @Override
    public long getStationIdFromDBId(long l) {
        return 0 * l + 1L;
    }
}

