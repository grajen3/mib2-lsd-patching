/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.sdssd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.configuration.ConfigurationService;
import de.vw.mib.bap.mqbab2.common.api.configuration.ConfigurationServiceListener;
import de.vw.mib.bap.mqbab2.common.api.speech.SpeechService;
import de.vw.mib.bap.mqbab2.common.api.speech.SpeechServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.api.system.SystemService;
import de.vw.mib.bap.mqbab2.common.api.system.SystemServiceListener;
import de.vw.mib.bap.mqbab2.generated.sdssd.serializer.InfoStates_Status;

public class InfoStates
extends Function
implements Property,
SystemServiceListener,
SpeechServiceListener,
ConfigurationServiceListener {
    protected static final int[] SPEECH_LISTENER_IDS = new int[]{-419233664, -385679232};
    protected static final int[] CONFIGURATION_LISTENER_IDS = new int[]{-1067646848};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$InfoStates_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getSpeechService().addSpeechServiceListener(this, SPEECH_LISTENER_IDS);
        this.getConfigurationService().addConfigurationListener(this, CONFIGURATION_LISTENER_IDS);
        InfoStates_Status infoStates_Status = this.computeInfoStatesStatus();
        this.updateNewInfoStates(new Integer(infoStates_Status.states));
        return this.computeInfoStatesStatus();
    }

    protected InfoStates_Status dequeueBAPEntity() {
        return (InfoStates_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$InfoStates_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$InfoStates_Status = InfoStates.class$("de.vw.mib.bap.mqbab2.generated.sdssd.serializer.InfoStates_Status")) : class$de$vw$mib$bap$mqbab2$generated$sdssd$serializer$InfoStates_Status);
    }

    protected void updateNewInfoStates(Integer n) {
        int[] nArray = new int[]{17};
        this.context.updateStages(this, nArray, n);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 20;
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
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
        this.getSpeechService().removeSpeechServiceListener(this, SPEECH_LISTENER_IDS);
        this.getConfigurationService().removeConfigurationListener(this, CONFIGURATION_LISTENER_IDS);
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
    }

    @Override
    public void process(int n) {
        InfoStates_Status infoStates_Status = this.computeInfoStatesStatus();
        this.sendInfoStatesStatus(infoStates_Status);
    }

    private InfoStates_Status computeInfoStatesStatus() {
        InfoStates_Status infoStates_Status = this.dequeueBAPEntity();
        this.setInfoStatesStatus(infoStates_Status);
        return infoStates_Status;
    }

    protected void setInfoStatesStatus(InfoStates_Status infoStates_Status) {
        ConfigurationService configurationService = this.getConfigurationService();
        SpeechService speechService = this.getSpeechService();
        infoStates_Status.states = this.getSpeechService().isSpeechDomainAvailable() ? (!configurationService.isSpeechFeatureBuiltIn() ? 1 : (configurationService.isSpeechFeatureBuiltIn() && configurationService.isSpeechCoded() && !configurationService.isSpeechFeatureSWAPSelected() ? 4 : (speechService.getSpeechApplicationState() == 3 ? 1 : 0))) : 3;
    }

    protected void sendInfoStatesStatus(InfoStates_Status infoStates_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(infoStates_Status, this);
        this.updateNewInfoStates(new Integer(infoStates_Status.states));
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updateSpeechData(SpeechService speechService, int n) {
        this.process(-1);
    }

    @Override
    public void updateSystemData(SystemService systemService, int n) {
        this.process(-1);
    }

    @Override
    public void updateConfigurationData(ConfigurationService configurationService, int n) {
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

