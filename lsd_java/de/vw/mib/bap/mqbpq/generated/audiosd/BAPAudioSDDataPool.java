/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.generated.audiosd;

import de.vw.mib.bap.mqbpq.common.HsmContextDelegate;
import de.vw.mib.bap.mqbpq.common.api.adapter.AbstractBAPDataPool;
import de.vw.mib.bap.mqbpq.generated.audiosd.AudioSDBindingFactory;

public class BAPAudioSDDataPool
extends AbstractBAPDataPool {
    private AudioSDBindingFactory _factory;

    public BAPAudioSDDataPool(HsmContextDelegate hsmContextDelegate) {
        super(hsmContextDelegate);
    }

    public AudioSDBindingFactory getFactory() {
        return this._factory;
    }

    public void setFactory(AudioSDBindingFactory audioSDBindingFactory) {
        this._factory = audioSDBindingFactory;
    }

    @Override
    public final void initialize() {
        this.initializeInternal(this._factory);
        super.initialize();
        this._factory = null;
    }

    private void initializeInternal(AudioSDBindingFactory audioSDBindingFactory) {
        this.addStage(audioSDBindingFactory.createNewFunctionListStage(), 3, 1, "FunctionList");
        this.addStage(audioSDBindingFactory.createNewFSGSetupStage(), 0, 1, "FSGSetup");
        this.addStage(audioSDBindingFactory.createNewFSGOperationStateStage(), 0, 1, "FSGOperationState");
        this.addStage(audioSDBindingFactory.createNewActiveSourceStage(), 3, 1, "ActiveSource");
        this.addStage(audioSDBindingFactory.createNewActiveSourceNameStage(), 3, 1, "ActiveSourceName");
        this.addStage(audioSDBindingFactory.createNewCurrentVolumeStage(), 3, 1, "CurrentVolume");
        this.addStage(audioSDBindingFactory.createNewMuteStage(), 0, 1, "Mute");
        this.addStage(audioSDBindingFactory.createNewSourceStateStage(), 0, 1, "SourceState");
        this.addStage(audioSDBindingFactory.createNewCurrentStationInfoStage(), 3, 1, "CurrentStationInfo");
        this.addStage(audioSDBindingFactory.createNewInfoListStage(), 3, 2, "InfoList");
        this.addStage(audioSDBindingFactory.createNewDedicatedAudioControlStage(), 0, 3, "DedicatedAudioControl");
        this.addStage(audioSDBindingFactory.createNewGeneralInfoSwitchesStage(), 0, 1, "GeneralInfoSwitches");
        this.addStage(audioSDBindingFactory.createNewTaInfoStage(), 3, 1, "TaInfo");
        this.addStage(audioSDBindingFactory.createNewTaEscapeStage(), 0, 3, "TaEscape");
        this.addStage(audioSDBindingFactory.createNewInfoStatesStage(), 0, 1, "InfoStates");
        this.addStage(audioSDBindingFactory.createNewInfoListTypeStage(), 0, 1, "InfoListType");
        this.addStage(audioSDBindingFactory.createNewChangeInfoListTypeStage(), 0, 3, "ChangeInfoListType");
        this.addStage(audioSDBindingFactory.createNewSourceListStage(), 3, 2, "SourceList");
    }
}

