/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.bap.mqbpq.audiosd.functions.ActiveSource;
import de.vw.mib.bap.mqbpq.audiosd.functions.ActiveSourceName;
import de.vw.mib.bap.mqbpq.audiosd.functions.ChangeInfoListType;
import de.vw.mib.bap.mqbpq.audiosd.functions.CurrentStationInfo;
import de.vw.mib.bap.mqbpq.audiosd.functions.CurrentVolume;
import de.vw.mib.bap.mqbpq.audiosd.functions.DedicatedAudioControl;
import de.vw.mib.bap.mqbpq.audiosd.functions.FSGOperationStateHandling;
import de.vw.mib.bap.mqbpq.audiosd.functions.FSGSetup;
import de.vw.mib.bap.mqbpq.audiosd.functions.FunctionList;
import de.vw.mib.bap.mqbpq.audiosd.functions.GeneralInfoSwitches;
import de.vw.mib.bap.mqbpq.audiosd.functions.InfoList;
import de.vw.mib.bap.mqbpq.audiosd.functions.InfoListType;
import de.vw.mib.bap.mqbpq.audiosd.functions.InfoStates;
import de.vw.mib.bap.mqbpq.audiosd.functions.Mute;
import de.vw.mib.bap.mqbpq.audiosd.functions.SourceList;
import de.vw.mib.bap.mqbpq.audiosd.functions.SourceState;
import de.vw.mib.bap.mqbpq.audiosd.functions.TaEscape;
import de.vw.mib.bap.mqbpq.audiosd.functions.TaInfo;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbpq.generated.audiosd.AudioSDBindingFactory;

public class AudioSDBindingFactoryAll
implements AudioSDBindingFactory {
    @Override
    public BAPStage createNewFunctionListStage() {
        return new FunctionList();
    }

    @Override
    public BAPStage createNewFSGSetupStage() {
        return new FSGSetup();
    }

    @Override
    public BAPStage createNewFSGOperationStateStage() {
        return new FSGOperationStateHandling();
    }

    @Override
    public BAPStage createNewActiveSourceStage() {
        return new ActiveSource();
    }

    @Override
    public BAPStage createNewActiveSourceNameStage() {
        return new ActiveSourceName();
    }

    @Override
    public BAPStage createNewCurrentVolumeStage() {
        return new CurrentVolume();
    }

    @Override
    public BAPStage createNewMuteStage() {
        return new Mute();
    }

    @Override
    public BAPStage createNewSourceStateStage() {
        return new SourceState();
    }

    @Override
    public BAPStage createNewCurrentStationInfoStage() {
        return new CurrentStationInfo();
    }

    @Override
    public BAPStage createNewInfoListStage() {
        return new InfoList();
    }

    @Override
    public BAPStage createNewDedicatedAudioControlStage() {
        return new DedicatedAudioControl();
    }

    @Override
    public BAPStage createNewGeneralInfoSwitchesStage() {
        return new GeneralInfoSwitches();
    }

    @Override
    public BAPStage createNewTaInfoStage() {
        return new TaInfo();
    }

    @Override
    public BAPStage createNewTaEscapeStage() {
        return new TaEscape();
    }

    @Override
    public BAPStage createNewInfoStatesStage() {
        return new InfoStates();
    }

    @Override
    public BAPStage createNewInfoListTypeStage() {
        return new InfoListType();
    }

    @Override
    public BAPStage createNewChangeInfoListTypeStage() {
        return new ChangeInfoListType();
    }

    @Override
    public BAPStage createNewSourceListStage() {
        return new SourceList();
    }
}

