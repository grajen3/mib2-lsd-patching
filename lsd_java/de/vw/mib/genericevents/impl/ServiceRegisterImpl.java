/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.genericevents.impl;

import de.vw.mib.collections.copyonwrite.CowArray;
import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.ints.IntPairArrayList;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.ServiceRegister;
import de.vw.mib.genericevents.impl.Monitor;
import de.vw.mib.genericevents.impl.ServiceEntry;
import de.vw.mib.genericevents.internal.ServiceManager;
import de.vw.mib.log4mib.Logger;

final class ServiceRegisterImpl
implements ServiceRegister {
    private static final String STR_ERROR_ADDING_OBSERVER;
    private static final String STR_ERROR_REMOVING_OBSERVER;
    private static final String STR_ERROR_REGISTERING_SERVICE;
    private static final String STR_ERROR_UNREGISTERING_SERVICE;
    private static final String STR_ERROR_TRIGGERING_OBSERVER;
    private static final String STR_EVENT;
    private static final String STR_ROUTER;
    private static final String STR_SERVICE;
    private static final String STR_TARGET;
    private static final String STR_CAUSE;
    private static final String STR_INVALID_ARGUMENTS;
    private static final String STR_ALREADY_REGISTERED;
    private static final String STR_SERVICE_NOT_REGISTERED;
    private final GenericEvents eventContext;
    private final Logger logger = ServiceManager.loggerFactory.getLogger(128);
    private int observerCount = 0;
    private final CowArray serviceMonitors = new CowArray();
    private final IntObjectMap services = new IntObjectOptHashMap(2500);

    public ServiceRegisterImpl(GenericEvents genericEvents) {
        this.eventContext = genericEvents;
    }

    @Override
    public void addObserver(int n, int n2) {
        this.addObserverInternal(n, 0, n2, 0);
    }

    @Override
    public void addObserver(int n, int n2, int n3) {
        this.addObserverInternal(n, 0, n2, n3);
    }

    @Override
    public void addObserver(int n, int n2, int n3, int n4) {
        this.addObserverInternal(n, n2, n3, n4);
    }

    @Override
    public void addObserver(int[] nArray, int n) {
        if (nArray == null) {
            this.logger.error(8).append("Error adding observer:").append(" TargetId=").append(n).append(" Cause: ").append("Invalid arguments!").log();
            return;
        }
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.addObserverInternal(nArray[i2], 0, n, 0);
        }
    }

    @Override
    public void addObserver(IntPairArrayList intPairArrayList) {
        if (intPairArrayList == null) {
            this.logger.error(8).append("Error adding observer:").append(" Cause: ").append("Invalid arguments!").log();
            return;
        }
        for (int i2 = 0; i2 < intPairArrayList.size(); ++i2) {
            this.addObserverInternal(intPairArrayList.getRight(i2), 0, intPairArrayList.getLeft(i2), 0);
        }
    }

    @Override
    public void addServiceMonitor(int n, int n2, int n3) {
        this.serviceMonitors.add(new Monitor(n, n2, n3));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean existService(int n) {
        IntObjectMap intObjectMap = this.services;
        synchronized (intObjectMap) {
            return this.services.containsKey(n);
        }
    }

    public void registerService(int n) {
        this.registerServiceInternal(n, 0, 0, 0, false, false, true);
    }

    @Override
    public void registerService(int n, int n2) {
        this.registerServiceInternal(n, 0, n2, 0, false, false, true);
    }

    @Override
    public void registerService(int n, int n2, int n3, boolean bl) {
        this.registerServiceInternal(n, 0, n2, n3, bl, true, true);
    }

    @Override
    public void registerService(int n, int n2, int n3, int n4, boolean bl, boolean bl2) {
        this.registerServiceInternal(n, n2, n3, n4, bl2, bl, true);
    }

    @Override
    public void registerServicesWithoutCheck(int[] nArray, int n, boolean bl) {
        if (nArray == null) {
            this.logger.error(8).append("Error registering service:").append(" TargetId=").append(n).append(" Cause: ").append("Invalid arguments!").log();
            return;
        }
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.registerServiceInternal(nArray[i2], 0, n, 0, bl, false, false);
        }
    }

    @Override
    public void registerServicesWithoutCheck(int[][] nArray, boolean bl, boolean bl2) {
        if (nArray == null) {
            this.logger.error(8).append("Error registering service:").append(" Cause: ").append("Invalid arguments!").log();
            return;
        }
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.registerServiceInternal(nArray[i2][1], 0, nArray[i2][0], 0, bl2, bl, false);
        }
    }

    @Override
    public void registerServicesWithoutCheck(IntPairArrayList intPairArrayList, boolean bl, boolean bl2) {
        if (intPairArrayList == null) {
            this.logger.error(8).append("Error registering service:").append(" Cause: ").append("Invalid arguments!").log();
            return;
        }
        for (int i2 = 0; i2 < intPairArrayList.size(); ++i2) {
            this.registerServiceInternal(intPairArrayList.getRight(i2), 0, intPairArrayList.getLeft(i2), 0, bl2, bl, false);
        }
    }

    @Override
    public void removeObserver(int n, int n2) {
        this.removeObserverInternal(n, 0, n2);
    }

    public void removeObserver(int n, int n2, int n3) {
        this.removeObserverInternal(n, 0, n2);
    }

    @Override
    public void removeObserver(int n, int n2, int n3, int n4) {
        this.removeObserverInternal(n, n2, n3);
    }

    @Override
    public void removeObservers(int[] nArray, int n) {
        if (nArray == null) {
            this.logger.error(8).append("Error removing observer:").append(" TargetId=").append(n).append(" Cause: ").append("Invalid arguments!").log();
        } else {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.removeObserver(nArray[i2], n, 0);
            }
        }
    }

    @Override
    public void removeServiceMonitor(int n, int n2, int n3) {
        Object[] objectArray = this.serviceMonitors.getArray();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            Monitor monitor = (Monitor)objectArray[i2];
            if (!monitor.match(n, n2, n3)) continue;
            this.serviceMonitors.remove(monitor);
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(70);
        stringBuffer.append("ServiceRegister(");
        stringBuffer.append(System.identityHashCode(this.eventContext));
        stringBuffer.append("): ");
        stringBuffer.append(this.services.size());
        stringBuffer.append(" Services, ");
        stringBuffer.append(this.observerCount);
        stringBuffer.append(" Observers, ");
        stringBuffer.append(this.serviceMonitors.size());
        stringBuffer.append(" Monitors");
        return stringBuffer.toString();
    }

    @Override
    public boolean triggerLastEvent(int n) {
        boolean bl;
        if (n == 0) {
            bl = false;
        } else {
            ServiceEntry serviceEntry = this.getServiceEntry(n);
            if (serviceEntry == null) {
                bl = false;
            } else {
                try {
                    bl = serviceEntry.triggerLastEvent();
                }
                catch (GenericEventException genericEventException) {
                    bl = false;
                }
            }
        }
        return bl;
    }

    @Override
    public boolean triggerObserver(int n) {
        return this.triggerObserver(n, null);
    }

    @Override
    public boolean triggerObserver(int n, EventGeneric eventGeneric) {
        boolean bl;
        if (n == 0) {
            this.errorTriggerObserver(n, "Invalid arguments!");
            bl = false;
        } else {
            ServiceEntry serviceEntry = this.getServiceEntry(n);
            if (serviceEntry == null) {
                if (n >= -193) {
                    this.traceMissingAslServiceImplementation(n);
                }
                this.errorTriggerObserver(n, "Service is not registered!");
                bl = false;
            } else {
                try {
                    if (serviceEntry.isEmpty() && n >= -193) {
                        this.traceMissingAslServiceImplementation(n);
                    }
                    serviceEntry.triggerObserver(eventGeneric);
                    bl = true;
                }
                catch (GenericEventException genericEventException) {
                    this.errorTriggerObserver(n, genericEventException.getMessage());
                    bl = false;
                }
            }
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void unregisterService(int n) {
        IntObjectMap intObjectMap = this.services;
        synchronized (intObjectMap) {
            ServiceEntry serviceEntry = this.getServiceEntry(n);
            if (serviceEntry == null) {
                return;
            }
            this.services.remove(n);
            this.triggerServiceMonitor(n, 13, serviceEntry.getOwnerTargetId(), serviceEntry.getOwnerEventId());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void unregisterServices(int[] nArray) {
        if (nArray == null) {
            this.logger.error(8).append("Error unregister service:").append(" Cause: ").append("Invalid arguments!").log();
            return;
        }
        IntObjectMap intObjectMap = this.services;
        synchronized (intObjectMap) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                this.unregisterService(nArray[i2]);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void addObserverInternal(int n, int n2, int n3, int n4) {
        if (n == 0 || n3 == 0) {
            this.errorAddObserver(n, n2, n3, n4, "Invalid arguments!");
            return;
        }
        ServiceEntry serviceEntry = this.getServiceEntry(n);
        if (serviceEntry == null) {
            serviceEntry = new ServiceEntry(this.eventContext, n);
            IntObjectMap intObjectMap = this.services;
            synchronized (intObjectMap) {
                this.services.put(n, serviceEntry);
            }
        }
        try {
            this.observerCount += serviceEntry.addObserver(n2, n3, n4 != 0 ? n4 : n);
            this.triggerServiceMonitor(n, 14, n3, n4);
        }
        catch (GenericEventException genericEventException) {
            this.errorAddObserver(n, n2, n3, n4, genericEventException.getMessage());
        }
    }

    private void errorAddObserver(int n, int n2, int n3, int n4, String string) {
        this.logger.error(8).append("Error adding observer:").append(" ServiceId=").append(n).append(" RouterId=").append(n2).append(" TargetId=").append(n3).append(" EventId=").append(n4).append(" Cause: ").append(string).log();
    }

    private void errorRegisterService(int n, int n2, int n3, int n4, String string) {
        this.logger.error(8).append("Error registering service:").append(" ServiceId=").append(n).append(" RouterId=").append(n2).append(" TargetId=").append(n3).append(" EventId=").append(n4).append(" Cause: ").append(string).log();
    }

    private void errorTriggerObserver(int n, String string) {
        this.logger.error(8).append("Error triggering observer:").append(" ServiceId=").append(n).append(" Cause: ").append(string).log();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void registerServiceInternal(int n, int n2, int n3, int n4, boolean bl, boolean bl2, boolean bl3) {
        if (n == 0) {
            this.errorRegisterService(n, n2, n3, n4, "Invalid arguments!");
            return;
        }
        ServiceEntry serviceEntry = this.getServiceEntry(n);
        if (serviceEntry == null) {
            ServiceEntry serviceEntry2 = new ServiceEntry(this.eventContext, n, n2, n3, n4, bl, bl2);
            IntObjectMap intObjectMap = this.services;
            synchronized (intObjectMap) {
                this.services.put(n, serviceEntry2);
            }
            this.triggerServiceMonitor(n, 12, n3, n4);
            return;
        }
        if (serviceEntry.getOwnerTargetId() != 0 && bl3) {
            this.errorRegisterService(n, n2, n3, n4, "Already registered!");
            return;
        }
        ServiceEntry serviceEntry3 = new ServiceEntry(this.eventContext, n, n2, n3, n4, bl, bl2);
        IntObjectMap intObjectMap = this.services;
        synchronized (intObjectMap) {
            this.services.put(n, serviceEntry3);
            serviceEntry3.addObservers(serviceEntry);
        }
    }

    private void removeObserverInternal(int n, int n2, int n3) {
        ServiceEntry serviceEntry = this.getServiceEntry(n);
        if (serviceEntry != null) {
            this.observerCount -= serviceEntry.removeObserver(n2, n3);
            this.triggerServiceMonitor(n, 15, n3, 0);
        }
    }

    private void traceMissingAslServiceImplementation(int n) {
        this.logger.normal(8).append("asl service ").append(n).append(" is not registered/implemented!").log();
    }

    private void triggerServiceMonitor(int n, int n2, int n3, int n4) {
        Object[] objectArray = this.serviceMonitors.getArray();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            Monitor monitor = (Monitor)objectArray[i2];
            if (monitor.observedId != n) continue;
            EventGeneric eventGeneric = ServiceManager.mEventFactory.newEvent();
            eventGeneric.setSenderTargetId(5001);
            eventGeneric.setReceiverTargetId(monitor.observerTargetId);
            eventGeneric.setReceiverRouterId(monitor.observerRouterId);
            eventGeneric.setReceiverEventId(n2);
            eventGeneric.setInt(0, n);
            eventGeneric.setInt(1, n3);
            eventGeneric.setInt(2, n4);
            this.eventContext.getEventDispatcher().sendSafe(eventGeneric);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected ServiceEntry getServiceEntry(int n) {
        IntObjectMap intObjectMap = this.services;
        synchronized (intObjectMap) {
            return (ServiceEntry)this.services.get(n);
        }
    }
}

