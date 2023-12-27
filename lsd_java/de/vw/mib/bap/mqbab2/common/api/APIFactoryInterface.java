/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.api;

import de.vw.mib.asl.api.bap.dispatcher.BAPDispatcher;
import de.vw.mib.bap.mqbab2.common.api.addressbook.AddressbookService;
import de.vw.mib.bap.mqbab2.common.api.androidauto.AndroidAutoService;
import de.vw.mib.bap.mqbab2.common.api.car.CarService;
import de.vw.mib.bap.mqbab2.common.api.carlife.CarLifeService;
import de.vw.mib.bap.mqbab2.common.api.carplay.CarPlayService;
import de.vw.mib.bap.mqbab2.common.api.configuration.ConfigurationService;
import de.vw.mib.bap.mqbab2.common.api.connectivity.ConnectivityService;
import de.vw.mib.bap.mqbab2.common.api.exbox.ExboxService;
import de.vw.mib.bap.mqbab2.common.api.hmi.HMIEventService;
import de.vw.mib.bap.mqbab2.common.api.media.MediaService;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationService;
import de.vw.mib.bap.mqbab2.common.api.persistence.PersistenceService;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneService;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioService;
import de.vw.mib.bap.mqbab2.common.api.smartphoneintegration.SmartphoneIntegrationService;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundService;
import de.vw.mib.bap.mqbab2.common.api.speech.SpeechService;
import de.vw.mib.bap.mqbab2.common.api.system.SystemService;
import de.vw.mib.bap.mqbab2.common.api.timer.TimerService;
import de.vw.mib.bap.mqbab2.common.api.tvtuner.TvTunerService;
import de.vw.mib.bap.mqbab2.common.api.valetparking.ValetParkingService;
import de.vw.mib.bap.stream.BitStreamTransformer;
import de.vw.mib.format.FixFormat;
import de.vw.mib.genericevents.EventFactory;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.Logger;

public interface APIFactoryInterface {
    default public AddressbookService getAddressbookService() {
    }

    default public AndroidAutoService getAndroidAutoService() {
    }

    default public CarService getCarService() {
    }

    default public CarLifeService getCarLifeService() {
    }

    default public CarPlayService getCarPlayService() {
    }

    default public ConnectivityService getConnectivityService() {
    }

    default public ExboxService getExboxService() {
    }

    default public HMIEventService getHMIEventService() {
    }

    default public MediaService getMediaService() {
    }

    default public NavigationService getNavigationService() {
    }

    default public PhoneService getPhoneService() {
    }

    default public RadioService getRadioService() {
    }

    default public SmartphoneIntegrationService getSmartphoneIntegrationService() {
    }

    default public SoundService getSoundService() {
    }

    default public SpeechService getSpeechService() {
    }

    default public SystemService getSystemService() {
    }

    default public TvTunerService getTvTunerService() {
    }

    default public ValetParkingService getValetParkingService() {
    }

    default public BAPDispatcher getBapDispatcher() {
    }

    default public BitStreamTransformer getBitStreamTransformer() {
    }

    default public PersistenceService getPersistenceService() {
    }

    default public Logger getLogger() {
    }

    default public GenericEvents getGenericEventsService() {
    }

    default public EventFactory getEventFactory() {
    }

    default public FixFormat getFixFormatter() {
    }

    default public ConfigurationService getConfigurationService() {
    }

    default public ThreadSwitchingTarget getThreadSwitchingService() {
    }

    default public TimerService getTimerService() {
    }
}

