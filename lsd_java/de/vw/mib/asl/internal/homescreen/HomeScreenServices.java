/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.homescreen;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.car.pso.PersonalizationService;
import de.vw.mib.asl.api.homescreen.tileselection.TileSelectionAppService;
import de.vw.mib.asl.api.system.DriverDistractionPreventionService;
import de.vw.mib.asl.api.system.clock.DateTimeService;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.homescreen.persistence.HomescreenPersistenceService;
import de.vw.mib.asl.internal.impl.homescreen.model.Tile;
import de.vw.mib.asl.internal.impl.homescreen.tileselection.TileInstaller;
import de.vw.mib.asl.internal.impl.homescreen.tileselection.TileSelectionAppProvider;
import de.vw.mib.asl.internal.impl.homescreen.util.HostedAppBinder;
import de.vw.mib.asl.internal.list.ASLListManager;
import de.vw.mib.cio.CioDictionary;
import de.vw.mib.cio.CioDispatcher;
import de.vw.mib.cio.CioFactory;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.timer.TimerManager;

public interface HomeScreenServices {
    default public GenericEvents getGenericEvents() {
    }

    default public Logger getLogger() {
    }

    default public ASLPropertyManager getASLPropertyManager() {
    }

    default public ServiceRegister getServiceRegister() {
    }

    default public CioDictionary getCioDictionary() {
    }

    default public CioDispatcher getCioDispatcher() {
    }

    default public CioFactory getCioFactory() {
    }

    default public Tile[] getTiles() {
    }

    default public ASLListManager getASLListManager() {
    }

    default public TimerManager getTimerManager() {
    }

    default public ThreadSwitchingTarget getThreadSwitchingTarget() {
    }

    default public HostedAppBinder getHostedAppBinder() {
    }

    default public TileSelectionAppProvider getTileSelectionAppProvider() {
    }

    default public TileSelectionAppService getTileSelectionAppService() {
    }

    default public DateTimeService getDateTimeService() {
    }

    default public PersonalizationService getPersonalizationService() {
    }

    default public HomescreenPersistenceService getHomeScreenPersistenceService() {
    }

    default public FactoryResetService getFactoryResetService() {
    }

    default public TileInstaller getTileInstaller() {
    }

    default public SystemEventDispatcher getSystemEventDispatcher() {
    }

    default public ConfigurationManager getConfigurationManager() {
    }

    default public DriverDistractionPreventionService getDriverDistractionPreventionService() {
    }
}

