/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.keypanel.lock;

import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.api.system.valetparking.ValetParkingService;
import de.vw.mib.asl.framework.api.persistence.AslPersistenceSyncApi;
import de.vw.mib.asl.internal.impl.system.powerstate.PropagatingPowerStateService;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.keypanel.lock.KeyLockManager;
import de.vw.mib.asl.internal.system.keypanel.lock.KeyLockService;
import de.vw.mib.asl.internal.system.keypanel.lock.KeyLockServiceImpl;
import de.vw.mib.asl.internal.system.keypanel.lock.components.ChildLockComponent;
import de.vw.mib.asl.internal.system.keypanel.lock.components.EmergencyAnnouncementLockComponent;
import de.vw.mib.asl.internal.system.keypanel.lock.components.FactoryResetComponent;
import de.vw.mib.asl.internal.system.keypanel.lock.components.LscComponent;
import de.vw.mib.asl.internal.system.keypanel.lock.components.PersonalizationKeyLockComponent;
import de.vw.mib.asl.internal.system.keypanel.lock.components.PowerStateLockComponent;
import de.vw.mib.asl.internal.system.keypanel.lock.components.ValetParkingComponent;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.asl.internal.system.util.SystemKeyUtil;
import de.vw.mib.threads.AsyncServiceFactory;
import org.osgi.framework.BundleContext;

public class KeyLockServiceFactory {
    public KeyLockService createKeyLockService(SystemServices systemServices, SystemKeyUtil systemKeyUtil) {
        Preconditions.checkArgumentNotNull(systemServices);
        KeyLockServiceImpl keyLockServiceImpl = new KeyLockServiceImpl(systemServices, systemKeyUtil);
        this.setupKeyLockComponents(systemServices);
        return keyLockServiceImpl;
    }

    private void setupKeyLockComponents(SystemServices systemServices) {
        ValetParkingService valetParkingService = systemServices.getValetParkingService();
        KeyLockManager keyLockManager = systemServices.getKeyLockManager();
        FactoryResetService factoryResetService = systemServices.getFactoryResetService();
        PropagatingPowerStateService propagatingPowerStateService = systemServices.getPowerStateService();
        BundleContext bundleContext = systemServices.getBundleContext();
        AsyncServiceFactory asyncServiceFactory = systemServices.getAsyncServiceFactory();
        AslPersistenceSyncApi aslPersistenceSyncApi = systemServices.getPersistence();
        FactoryResetComponent factoryResetComponent = new FactoryResetComponent();
        factoryResetService.addListener(factoryResetComponent);
        keyLockManager.addComponent(factoryResetComponent);
        keyLockManager.addComponent(new ChildLockComponent(systemServices));
        keyLockManager.addComponent(new ValetParkingComponent(valetParkingService));
        keyLockManager.addComponent(new PowerStateLockComponent(propagatingPowerStateService));
        keyLockManager.addComponent(new LscComponent(bundleContext, asyncServiceFactory));
        keyLockManager.addComponent(new PersonalizationKeyLockComponent(aslPersistenceSyncApi));
        keyLockManager.addComponent(new EmergencyAnnouncementLockComponent(systemServices.getEmergencyAnnouncementService()));
    }
}

