/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.id;

import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.collections.ints.IntPairArrayList;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;

public final class PreRegisteredIds {
    private static IntPairArrayList SERVICES_FOR_OBSERVER_LIST = new IntPairArrayList(130);
    private static IntPairArrayList SERVICES_FOR_OBSERVER_STORE_LAST_EVENT_LIST = new IntPairArrayList(100);
    private static IntPairArrayList SERVICES_FOR_OWNER_LIST = new IntPairArrayList(50);
    private static IntPairArrayList SERVICES_FOR_OWNER_STORE_LAST_EVENT_LIST = new IntPairArrayList(30);
    private static IntPairArrayList OBSERVER_LIST = new IntPairArrayList(550);
    public static final int ID_SERVICES_FOR_OBSERVER;
    public static final int ID_SERVICES_FOR_OWNER;
    public static final int ID_OBSERVER;
    public static final boolean IS_ASL_RADIO_DAB_INCLUDED;
    public static final boolean IS_ASL_PHONE_INCLUDED;

    private PreRegisteredIds() {
    }

    public static void addServiceOrObserverToArray(int n, int n2, int n3) {
        switch (n) {
            case 2: {
                OBSERVER_LIST.add(n2, n3);
                break;
            }
            case 0: {
                SERVICES_FOR_OBSERVER_LIST.add(n2, n3);
                break;
            }
            case 1: {
                SERVICES_FOR_OWNER_LIST.add(n2, n3);
                break;
            }
        }
    }

    public static void addServiceOrObserverToArray(int n, int n2, int n3, boolean bl) {
        if (!bl) {
            switch (n) {
                case 2: {
                    OBSERVER_LIST.add(n2, n3);
                    break;
                }
                case 0: {
                    SERVICES_FOR_OBSERVER_LIST.add(n2, n3);
                    break;
                }
                case 1: {
                    SERVICES_FOR_OWNER_LIST.add(n2, n3);
                    break;
                }
            }
        } else {
            switch (n) {
                case 2: {
                    ServiceManager.loggerFWCore.error().append("storeLastEvent not applicable for ID_OBSERVER! targetId=").append(n2).append(", serviceId=").append(n3).log();
                    break;
                }
                case 0: {
                    SERVICES_FOR_OBSERVER_STORE_LAST_EVENT_LIST.add(n2, n3);
                    break;
                }
                case 1: {
                    SERVICES_FOR_OWNER_STORE_LAST_EVENT_LIST.add(n2, n3);
                    break;
                }
            }
        }
    }

    public static void registerServices(GenericEvents genericEvents) {
        ServiceRegister serviceRegister = genericEvents.getServiceRegister();
        serviceRegister.registerServicesWithoutCheck(SERVICES_FOR_OBSERVER_LIST, false, false);
        serviceRegister.registerServicesWithoutCheck(SERVICES_FOR_OBSERVER_STORE_LAST_EVENT_LIST, false, true);
        serviceRegister.registerServicesWithoutCheck(SERVICES_FOR_OWNER_LIST, true, false);
        serviceRegister.registerServicesWithoutCheck(SERVICES_FOR_OWNER_STORE_LAST_EVENT_LIST, true, true);
    }

    public static void registerIds(GenericEvents genericEvents) {
        ServiceRegister serviceRegister = genericEvents.getServiceRegister();
        serviceRegister.registerServicesWithoutCheck(SERVICES_FOR_OBSERVER_LIST, false, false);
        serviceRegister.registerServicesWithoutCheck(SERVICES_FOR_OWNER_LIST, true, false);
        serviceRegister.registerServicesWithoutCheck(SERVICES_FOR_OBSERVER_STORE_LAST_EVENT_LIST, false, true);
        serviceRegister.registerServicesWithoutCheck(SERVICES_FOR_OWNER_STORE_LAST_EVENT_LIST, true, true);
        ASLFactoryBase.registerAllIds(genericEvents);
        serviceRegister.addObserver(OBSERVER_LIST);
    }

    static {
        ASLFactoryBase.loadAllFactoryImplClasses();
    }
}

