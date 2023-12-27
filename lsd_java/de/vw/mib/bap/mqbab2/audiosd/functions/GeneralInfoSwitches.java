/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.audiosd.api.ASLAudioSDConstants;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioService;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.api.system.SystemService;
import de.vw.mib.bap.mqbab2.common.api.system.SystemServiceListener;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.GeneralInfoSwitches_SetGet;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.GeneralInfoSwitches_Status;

public final class GeneralInfoSwitches
extends Function
implements Property,
ASLAudioSDConstants,
RadioServiceListener,
SystemServiceListener {
    protected static final int[] RADIO_LISTENER_IDS = new int[]{1422, 1410, 1444};
    protected static final int[] SYSTEM_LISTENER_IDS = new int[]{1676};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$GeneralInfoSwitches_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getRadioService().addRadioServiceListener(this, RADIO_LISTENER_IDS);
        this.getSystemService().addSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        return this.computeGeneralInfoSwitchesStatus();
    }

    protected GeneralInfoSwitches_Status dequeueBAPEntity() {
        return (GeneralInfoSwitches_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$GeneralInfoSwitches_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$GeneralInfoSwitches_Status = GeneralInfoSwitches.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.GeneralInfoSwitches_Status")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$GeneralInfoSwitches_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 25;
    }

    private void setGeneralInfoSwitches(GeneralInfoSwitches_SetGet generalInfoSwitches_SetGet, PropertyListener propertyListener) {
        RadioService radioService = this.getRadioService();
        boolean bl = false;
        if (generalInfoSwitches_SetGet.onOffSwitches.tpTaOn != radioService.isTpSetupOptionEnabled()) {
            radioService.setTpState(generalInfoSwitches_SetGet.onOffSwitches.tpTaOn);
            bl = true;
        }
        if (generalInfoSwitches_SetGet.onOffSwitches.rdsOn != radioService.isRDSSetupOptionEnabled() && radioService.isRDSSetupOptionAvailable()) {
            radioService.setRDSSetupOptionState(generalInfoSwitches_SetGet.onOffSwitches.rdsOn);
            bl = true;
        }
        if (!bl) {
            propertyListener.statusProperty(this.computeGeneralInfoSwitchesStatus(), this);
        }
    }

    private void setOnOffSwitches(GeneralInfoSwitches_Status generalInfoSwitches_Status) {
        boolean bl;
        RadioService radioService = this.getRadioService();
        generalInfoSwitches_Status.onOffSwitches.rdsOn = bl = radioService.isRDSSetupOptionEnabled();
        generalInfoSwitches_Status.onOffSwitches.tpTaOn = generalInfoSwitches_Status.onOffSwitches.rdsOn ? radioService.isTpSetupOptionEnabled() : false;
        generalInfoSwitches_Status.onOffSwitches.tmcOn = bl && this.getSystemService().getNavigationDomainAvailable() == 1;
    }

    private void setModification(GeneralInfoSwitches_Status generalInfoSwitches_Status) {
        generalInfoSwitches_Status.modification.tpTaOnCanBeModified = true;
        generalInfoSwitches_Status.modification.rdsOnOffCanBeModified = true;
        generalInfoSwitches_Status.modification.tmcOnOffCanBeModfied = false;
    }

    private void sendGeneralInfoSwitches(GeneralInfoSwitches_Status generalInfoSwitches_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(generalInfoSwitches_Status, this);
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        this.setGeneralInfoSwitches((GeneralInfoSwitches_SetGet)bAPEntity, propertyListener);
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getRadioService().removeRadioServiceListener(this, RADIO_LISTENER_IDS);
        this.getSystemService().removeSystemServiceListener(this, SYSTEM_LISTENER_IDS);
    }

    @Override
    public void process(int n) {
        this.sendGeneralInfoSwitches(this.computeGeneralInfoSwitchesStatus());
    }

    private GeneralInfoSwitches_Status computeGeneralInfoSwitchesStatus() {
        GeneralInfoSwitches_Status generalInfoSwitches_Status = this.dequeueBAPEntity();
        this.setOnOffSwitches(generalInfoSwitches_Status);
        this.setModification(generalInfoSwitches_Status);
        return generalInfoSwitches_Status;
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updateSystemData(SystemService systemService, int n) {
        this.process(-1);
    }

    @Override
    public void updateRadioData(RadioService radioService, int n) {
        this.process(-1);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

