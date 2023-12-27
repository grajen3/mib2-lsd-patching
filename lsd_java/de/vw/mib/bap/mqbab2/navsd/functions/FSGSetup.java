/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.configuration.ConfigurationService;
import de.vw.mib.bap.mqbab2.common.api.configuration.ConfigurationServiceListener;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationService;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.FSG_Setup_Status;
import de.vw.mib.bap.mqbab2.navsd.api.ASLNavSDConstants;

public class FSGSetup
extends Function
implements Property,
ASLNavSDConstants,
NavigationServiceListener,
ConfigurationServiceListener {
    protected static final int[] NAVIGATION_LISTENER_IDS = new int[]{128};
    protected static final int[] CONFIGURATION_LISTENER_IDS = new int[]{-1050869632};
    private boolean waitingForActiveRgTypeAck = false;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$FSG_Setup_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getNavigationService().addNavigationServiceListener(this, NAVIGATION_LISTENER_IDS);
        this.getConfigurationService().addConfigurationListener(this, CONFIGURATION_LISTENER_IDS);
        return this.computeFSGStatus();
    }

    protected FSG_Setup_Status dequeueBAPEntity() {
        return (FSG_Setup_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$FSG_Setup_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$FSG_Setup_Status = FSGSetup.class$("de.vw.mib.bap.mqbab2.generated.navsd.serializer.FSG_Setup_Status")) : class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$FSG_Setup_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        switch (bAPStage.getFunctionId()) {
            case 39: {
                this.waitingForActiveRgTypeAck = (Boolean)object;
                this.process(-1);
                break;
            }
        }
    }

    @Override
    public int getFunctionId() {
        return 53;
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getNavigationService().removeNavigationServiceListener(this, NAVIGATION_LISTENER_IDS);
        this.getConfigurationService().removeConfigurationListener(this, CONFIGURATION_LISTENER_IDS);
    }

    @Override
    public void process(int n) {
        if (!this.waitingForActiveRgTypeAck) {
            this.sendFSGSetupStatus(this.computeFSGStatus());
        }
    }

    public FSG_Setup_Status computeFSGStatus() {
        FSG_Setup_Status fSG_Setup_Status = this.dequeueBAPEntity();
        this.setFunctionSupport(fSG_Setup_Status);
        return fSG_Setup_Status;
    }

    public void setFunctionSupport(FSG_Setup_Status fSG_Setup_Status) {
        NavigationService navigationService = this.getNavigationService();
        fSG_Setup_Status.functionSupport.activationDeactivationOfTheVideoNavigationSupported = (navigationService.getMapSwitchState() == 1 || navigationService.getMapSwitchState() == 2) && !navigationService.isMapTemporarilyInABT() ? this.getConfigurationService().isMapSwitchingFeatureSelected() : false;
    }

    private void sendFSGSetupStatus(FSG_Setup_Status fSG_Setup_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(fSG_Setup_Status, this);
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.statusProperty(this.computeFSGStatus(), this);
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.statusProperty(this.computeFSGStatus(), this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updateNavigationData(NavigationService navigationService, int n) {
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

