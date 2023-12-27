/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api.stages;

import de.vw.mib.bap.functions.BAPFunctionControllerDelegate;
import de.vw.mib.bap.mqbab2.common.api.APIFactory;
import de.vw.mib.bap.mqbab2.common.api.addressbook.AddressbookService;
import de.vw.mib.bap.mqbab2.common.api.androidauto.AndroidAutoService;
import de.vw.mib.bap.mqbab2.common.api.car.CarService;
import de.vw.mib.bap.mqbab2.common.api.carlife.CarLifeService;
import de.vw.mib.bap.mqbab2.common.api.carplay.CarPlayService;
import de.vw.mib.bap.mqbab2.common.api.configuration.ConfigurationService;
import de.vw.mib.bap.mqbab2.common.api.connectivity.ConnectivityService;
import de.vw.mib.bap.mqbab2.common.api.exbox.ExboxService;
import de.vw.mib.bap.mqbab2.common.api.media.MediaService;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationService;
import de.vw.mib.bap.mqbab2.common.api.persistence.PersistenceService;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneService;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioService;
import de.vw.mib.bap.mqbab2.common.api.smartphoneintegration.SmartphoneIntegrationService;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundService;
import de.vw.mib.bap.mqbab2.common.api.speech.SpeechService;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageContext;
import de.vw.mib.bap.mqbab2.common.api.system.SystemService;
import de.vw.mib.bap.mqbab2.common.api.timer.TimerService;
import de.vw.mib.bap.mqbab2.common.api.tvtuner.TvTunerService;
import de.vw.mib.bap.mqbab2.common.api.valetparking.ValetParkingService;
import de.vw.mib.format.FixFormat;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.Logger;

public abstract class Function
implements BAPStage {
    protected BAPStageContext context;

    @Override
    public void setDelegate(BAPStageContext bAPStageContext) {
        this.context = bAPStageContext;
    }

    protected final BAPFunctionControllerDelegate getDelegate() {
        return this.context;
    }

    @Override
    public boolean hmiEvent(int n) {
        return false;
    }

    protected AddressbookService getAddressbookService() {
        return APIFactory.getAPIFactory().getAddressbookService();
    }

    protected AndroidAutoService getAndroidAutoService() {
        return APIFactory.getAPIFactory().getAndroidAutoService();
    }

    protected CarService getCarService() {
        return APIFactory.getAPIFactory().getCarService();
    }

    protected CarLifeService getCarLifeService() {
        return APIFactory.getAPIFactory().getCarLifeService();
    }

    protected CarPlayService getCarPlayService() {
        return APIFactory.getAPIFactory().getCarPlayService();
    }

    protected ConnectivityService getConnectivityService() {
        return APIFactory.getAPIFactory().getConnectivityService();
    }

    protected ExboxService getExboxService() {
        return APIFactory.getAPIFactory().getExboxService();
    }

    protected MediaService getMediaService() {
        return APIFactory.getAPIFactory().getMediaService();
    }

    protected NavigationService getNavigationService() {
        return APIFactory.getAPIFactory().getNavigationService();
    }

    protected PhoneService getPhoneService() {
        return APIFactory.getAPIFactory().getPhoneService();
    }

    protected RadioService getRadioService() {
        return APIFactory.getAPIFactory().getRadioService();
    }

    protected SmartphoneIntegrationService getSmartphoneIntegrationService() {
        return APIFactory.getAPIFactory().getSmartphoneIntegrationService();
    }

    protected SoundService getSoundService() {
        return APIFactory.getAPIFactory().getSoundService();
    }

    protected SpeechService getSpeechService() {
        return APIFactory.getAPIFactory().getSpeechService();
    }

    protected SystemService getSystemService() {
        return APIFactory.getAPIFactory().getSystemService();
    }

    protected TvTunerService getTvTunerService() {
        return APIFactory.getAPIFactory().getTvTunerService();
    }

    protected ValetParkingService getValetParkingService() {
        return APIFactory.getAPIFactory().getValetParkingService();
    }

    protected FixFormat getFixFormatter() {
        return APIFactory.getAPIFactory().getFixFormatter();
    }

    protected ConfigurationService getConfigurationService() {
        return APIFactory.getAPIFactory().getConfigurationService();
    }

    protected PersistenceService getPersistenceService() {
        return APIFactory.getAPIFactory().getPersistenceService();
    }

    protected ThreadSwitchingTarget getThreadSwitchingService() {
        return APIFactory.getAPIFactory().getThreadSwitchingService();
    }

    protected TimerService getTimerService() {
        return APIFactory.getAPIFactory().getTimerService();
    }

    protected Logger getLogger() {
        return APIFactory.getAPIFactory().getLogger();
    }
}

