/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.diagnosis.diagmode.functions;

import de.vw.mib.asl.api.media.ASLMediaFactory;
import de.vw.mib.asl.api.radio.ASLRadioAPI;
import de.vw.mib.asl.framework.internal.diagnosis.diagmode.DiagnosisServices;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.configuration.ConfigurationManagerDiag;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.log4mib.Logger;

public class DiagModeSourceSwitchGeneric {
    private final ASLRadioAPI radioApi;
    private final EventFactory eventFactory;
    private final Logger logger;
    private final ConfigurationManagerDiag configurationManager;
    private final ServiceRegister serviceRegister;
    private final CioDispatcher cioDispatcher;
    private final CioDictionary cioDictionary;

    public DiagModeSourceSwitchGeneric(DiagnosisServices diagnosisServices) {
        this.radioApi = diagnosisServices.getRadioApi();
        this.eventFactory = diagnosisServices.getEventFactory();
        this.logger = diagnosisServices.getLogger();
        this.configurationManager = diagnosisServices.getConfigurationManager();
        this.serviceRegister = diagnosisServices.getServiceRegister();
        this.cioDispatcher = diagnosisServices.getCioDispatcher();
        this.cioDictionary = diagnosisServices.getCioDictionary();
    }

    protected boolean triggerSourceSwitchInternal(int n) {
        boolean bl = false;
        switch (n) {
            case 1: {
                if (!this.radioApi.isWavebandAvailable(0)) break;
                bl = true;
                this.activateRadioBand(0);
                break;
            }
            case 0: {
                if (!this.radioApi.isWavebandAvailable(1)) break;
                bl = true;
                this.activateRadioBand(1);
                break;
            }
            case 2: {
                if (!this.radioApi.isWavebandAvailable(2)) break;
                bl = true;
                this.activateRadioBand(2);
                break;
            }
            case 3: {
                if (!this.radioApi.isWavebandAvailable(3)) break;
                bl = true;
                this.activateRadioBand(3);
                break;
            }
            case 20: {
                break;
            }
            case 17: {
                if (!this.configurationManager.isFeatureFlagSet(425)) break;
                bl = true;
                this.enterTVTuner();
                break;
            }
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 15: 
            case 16: 
            case 18: 
            case 19: 
            case 21: 
            case 22: {
                if (!ASLMediaFactory.getMediaApi().isASLDeviceIdForDSIDiagnoseSystemIdAvailable(n)) break;
                bl = true;
                this.activateMediaSource(n);
                break;
            }
            default: {
                this.logger.error(16384).append("DIAGNOSTIC DiagModeSourceSwitchGeneric - unknown source = ").append(n).log();
            }
        }
        if (!bl) {
            this.logger.info(16384).append("DIAGNOSTIC DiagModeSourceSwitchGeneric Switch to source ").append(n).append(" not available!").log();
        }
        return bl;
    }

    public boolean triggerSourceSwitch(int n) {
        return this.triggerSourceSwitchInternal(n);
    }

    private void activateRadioBand(int n) {
        EventGeneric eventGeneric = this.eventFactory.newEvent();
        eventGeneric.setInt(0, n);
        this.serviceRegister.triggerObserver(-2096889792, eventGeneric);
    }

    private void activateMediaSource(int n) {
        EventGeneric eventGeneric = this.eventFactory.newEvent();
        eventGeneric.setInt(0, ASLMediaFactory.getMediaApi().getASLDeviceIdForDSIDiagnoseSystemId(n));
        this.serviceRegister.triggerObserver(-2091970048, eventGeneric);
    }

    private void enterTVTuner() {
        CioIntent cioIntent = this.cioDictionary.getCioIntent("ShowContent", "HMI_TVTUNER");
        if (cioIntent != null) {
            this.cioDispatcher.dispatch(cioIntent);
        }
    }
}

