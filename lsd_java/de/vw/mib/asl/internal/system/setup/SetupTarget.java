/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.setup;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.online.ASLOnlineCoreServices;
import de.vw.mib.asl.api.online.ASLOnlineServiceAvailabilityListener;
import de.vw.mib.asl.internal.impl.system.AbstractSystemTarget;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.setup.SetupTarget$1;
import de.vw.mib.asl.internal.system.setup.SetupTarget$2;
import de.vw.mib.asl.systemcommon.persistence.SystemCommon;
import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioFactory;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioParametersCreator;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.ServiceRegister;

public class SetupTarget
extends AbstractSystemTarget {
    private static final String USAGE_SPEECH_SETUP;
    private static final String USAGE_SETUP_DATE_TIME;
    private static final String USAGE_UNITS_SETUP;
    private static final String LOG_PREFIX;
    private final SystemCommon systemCommon;
    private final SystemServices systemServices;
    private final ASLPropertyManager propertyManager;
    private CioIntent backButtonIntent;

    public SetupTarget(SystemServices systemServices) {
        super(systemServices.getGenericEvents(), systemServices.getAsl1Logger(), -223734528);
        this.systemServices = systemServices;
        this.propertyManager = systemServices.getPropertyManager();
        this.systemCommon = systemServices.getSystemCommonPersistenceService().loadSystemCommon();
        ASLOnlineCoreServices aSLOnlineCoreServices = systemServices.getOnlineCoreServices();
        aSLOnlineCoreServices.registerForOnlineServicesAvailabilityStatus(this.createOnlineAvailabilityListener());
        this.updateOnlineSetupAvailability(aSLOnlineCoreServices.getOnlineServicesAvailabilityStatus());
        this.registerObservers(systemServices.getServiceRegister());
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1075841844: {
                this.processEnterShowSetup("SpeechSetup");
                return;
            }
            case 1075841855: {
                this.processEnterShowSetup("DateTimeSetup");
                return;
            }
            case 1075841856: {
                this.processEnterShowSetup("UnitsSetup");
                return;
            }
            case 1075841848: {
                this.processEnterWizard();
                return;
            }
            case 1075841854: {
                this.showCleanMode();
                return;
            }
        }
    }

    void showSystemSetup() {
        CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowContent", "HMI_SYSTEMSETUP");
        this.systemServices.getCioDispatcher().dispatch(cioIntent);
    }

    void updateOnlineSetupAvailability(int n) {
        boolean bl = this.systemCommon.isOnlineAvailable();
        bl = this.updateOnlineStatusToCurrentAvailability(n, bl);
        this.systemCommon.setOnlineAvailable(bl);
        this.propertyManager.valueChangedBoolean(1630674944, bl);
    }

    private void showCleanMode() {
        CioDictionary cioDictionary = this.systemServices.getCioDictionary();
        CioIntent cioIntent = cioDictionary.getCioIntent("ShowContent", "HMI_CLEANMODE");
        this.systemServices.getCioDispatcher().dispatch(cioIntent);
    }

    private ASLOnlineServiceAvailabilityListener createOnlineAvailabilityListener() {
        return new SetupTarget$1(this);
    }

    private boolean updateOnlineStatusToCurrentAvailability(int n, boolean bl) {
        if (n == 0) {
            bl = true;
        } else if (n == 1) {
            bl = false;
        }
        return bl;
    }

    private void processEnterWizard() {
        this.systemServices.getWizardService().startWizard();
    }

    private void processEnterShowSetup(String string) {
        CioIntent cioIntent = this.systemServices.getCioDictionary().getCioIntent("ShowSetup", string);
        if (cioIntent != null) {
            CioFactory cioFactory = this.systemServices.getCioFactory();
            CioParametersCreator cioParametersCreator = cioFactory.createActionParameters(cioIntent);
            cioParametersCreator.setCioIntent("BackButtonAction", this.retrieveBackButtonIntent(cioFactory));
            CioActionParameters cioActionParameters = cioParametersCreator.finishActionParams();
            this.systemServices.getCioDispatcher().dispatch(cioIntent, cioActionParameters);
        } else {
            this.getLogger().error(2048, new StringBuffer().append("[SetupTarget] Cannot enter >").append(string).append("< because the corresponding CIO is not avaialble.").toString());
        }
    }

    private CioIntent retrieveBackButtonIntent(CioFactory cioFactory) {
        if (this.backButtonIntent == null) {
            SetupTarget$2 setupTarget$2 = new SetupTarget$2(this);
            this.backButtonIntent = cioFactory.createCio("System", "System").finishCallbackCioIntent(setupTarget$2);
        }
        return this.backButtonIntent;
    }

    private void registerObservers(ServiceRegister serviceRegister) {
        serviceRegister.addObserver(1057693760, this.getTargetId());
        serviceRegister.addObserver(1074470976, this.getTargetId());
        serviceRegister.addObserver(873144384, this.getTargetId());
        serviceRegister.addObserver(940253248, this.getTargetId());
        serviceRegister.addObserver(1040916544, this.getTargetId());
    }
}

