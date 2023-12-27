/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.mqbab2.audiosd.functions.Mute;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioService;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.Mute_Status;

public class MuteNar
extends Mute {
    private static final int SPS_MINIMUM_CHANNEL_NUMBER;

    @Override
    protected void setIbocState(Mute_Status mute_Status) {
        boolean bl;
        boolean bl2;
        RadioService radioService = this.getRadioService();
        int n = radioService.getCurrentStationBand();
        if (n == 1) {
            int n2 = radioService.getFmHdRadioState();
            bl2 = n2 == 1 || n2 == 3;
            bl = n2 == 1 && radioService.getCurrentFMStationInfo().getCurrentFMStationInfoHDChannelNumber() > 1;
        } else {
            int n3;
            bl2 = n == 0 ? (n3 = radioService.getAmHdRadioState()) == 1 || n3 == 3 : false;
            bl = false;
        }
        mute_Status.muteState.ibocIsNotInSyncDigitalSignalCannotBeDecoded = bl2;
        mute_Status.muteState.ibocMutingLowSignal = bl;
    }

    @Override
    protected void setSdarsMuting(Mute_Status mute_Status) {
        RadioService radioService = this.getRadioService();
        mute_Status.muteState.sdarsMutingLowSignal = radioService.getCurrentStationBand() == 3 && radioService.getSatTunerState() == 4;
    }
}

