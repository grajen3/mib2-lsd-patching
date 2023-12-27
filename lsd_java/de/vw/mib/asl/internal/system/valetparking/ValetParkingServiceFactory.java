/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.valetparking;

import de.vw.mib.asl.api.system.valetparking.ValetParkingService;
import de.vw.mib.asl.internal.system.SystemServices;
import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.asl.internal.system.valetparking.ValetParkingNotificationTimer;
import de.vw.mib.asl.internal.system.valetparking.ValetParkingPersistence;
import de.vw.mib.asl.internal.system.valetparking.ValetParkingPopupListener;
import de.vw.mib.asl.internal.system.valetparking.ValetParkingServiceImpl;
import de.vw.mib.asl.systemcommon.persistence.SystemCommonPersistenceService;

public class ValetParkingServiceFactory {
    public ValetParkingService createValetParkingService(SystemServices systemServices, SystemCommonPersistenceService systemCommonPersistenceService) {
        Preconditions.checkArgumentNotNull(systemServices);
        Preconditions.checkArgumentNotNull(systemCommonPersistenceService);
        ValetParkingPersistence valetParkingPersistence = new ValetParkingPersistence(systemCommonPersistenceService);
        boolean bl = valetParkingPersistence.loadPersistedValetParkingActive();
        ValetParkingServiceImpl valetParkingServiceImpl = new ValetParkingServiceImpl(systemServices, new ValetParkingNotificationTimer(systemServices), bl);
        valetParkingServiceImpl.addListener(valetParkingPersistence);
        ValetParkingPopupListener valetParkingPopupListener = new ValetParkingPopupListener(systemServices.getSystemEventDispatcher());
        valetParkingServiceImpl.addListener(valetParkingPopupListener);
        return valetParkingServiceImpl;
    }
}

