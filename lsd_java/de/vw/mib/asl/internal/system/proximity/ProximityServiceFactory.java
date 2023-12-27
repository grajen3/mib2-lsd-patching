/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.proximity;

import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.proximity.LegacyAslEventSender;
import de.vw.mib.asl.internal.system.proximity.ProximityEnablementManager;
import de.vw.mib.asl.internal.system.proximity.ProximityInstallerImpl;
import de.vw.mib.asl.internal.system.proximity.ProximityModelPauseHandler;
import de.vw.mib.asl.internal.system.proximity.ProximityModelUpdater;
import de.vw.mib.asl.internal.system.proximity.ProximityServiceImpl;
import de.vw.mib.asl.internal.system.proximity.component.DefaultProximityUserInteractionComponent;
import de.vw.mib.asl.internal.system.proximity.component.LongRunningProximityUserInteractionComponent;
import de.vw.mib.asl.internal.system.proximity.component.ProximitySensorComponent;
import de.vw.mib.asl.internal.system.proximity.component.TouchComponent;
import de.vw.mib.asl.internal.system.proximity.filter.EnablementProximityFilter;
import de.vw.mib.asl.internal.system.proximity.filter.PauseProximityFilter;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.proximation.ProximityInstaller;
import org.osgi.framework.BundleContext;

public class ProximityServiceFactory {
    static /* synthetic */ Class class$de$vw$mib$proximation$ProximityInstaller;

    public ProximityServiceImpl createProximityService(SystemServices systemServices) {
        ProximityServiceImpl proximityServiceImpl = new ProximityServiceImpl();
        proximityServiceImpl.addListener(new ProximityModelUpdater(systemServices, proximityServiceImpl));
        proximityServiceImpl.addListener(new LegacyAslEventSender(systemServices.getEventDispatcher(), systemServices.getEventFactory()));
        EnablementProximityFilter enablementProximityFilter = new EnablementProximityFilter(proximityServiceImpl);
        PauseProximityFilter pauseProximityFilter = new PauseProximityFilter(proximityServiceImpl);
        new ProximitySensorComponent(systemServices, proximityServiceImpl);
        new TouchComponent(systemServices, proximityServiceImpl);
        IntObjectMap intObjectMap = this.createUserInteractionComponentMapping(systemServices, proximityServiceImpl);
        new ProximityEnablementManager(systemServices, enablementProximityFilter);
        BundleContext bundleContext = systemServices.getBundleContext();
        ProximityInstallerImpl proximityInstallerImpl = new ProximityInstallerImpl(intObjectMap, pauseProximityFilter, systemServices.getAsl1Logger());
        ProximityInstaller proximityInstaller = (ProximityInstaller)systemServices.getAsyncServiceFactory().create(proximityInstallerImpl);
        bundleContext.registerService((class$de$vw$mib$proximation$ProximityInstaller == null ? (class$de$vw$mib$proximation$ProximityInstaller = ProximityServiceFactory.class$("de.vw.mib.proximation.ProximityInstaller")) : class$de$vw$mib$proximation$ProximityInstaller).getName(), (Object)proximityInstaller, null);
        new ProximityModelPauseHandler(systemServices, proximityInstallerImpl);
        return proximityServiceImpl;
    }

    private IntObjectMap createUserInteractionComponentMapping(SystemServices systemServices, ProximityServiceImpl proximityServiceImpl) {
        IntObjectOptHashMap intObjectOptHashMap = new IntObjectOptHashMap();
        intObjectOptHashMap.put(ProximityInstallerImpl.INTERNAL_INTERACTION_TYPE_OTHER, new DefaultProximityUserInteractionComponent(systemServices, proximityServiceImpl));
        intObjectOptHashMap.put(ProximityInstallerImpl.INTERNAL_INTERACTION_TYPE_VIEW_CHANGE, new LongRunningProximityUserInteractionComponent(systemServices, proximityServiceImpl));
        return intObjectOptHashMap;
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

