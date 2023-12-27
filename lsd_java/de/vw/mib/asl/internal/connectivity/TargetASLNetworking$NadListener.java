/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.connectivity;

import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.connectivity.TargetASLNetworking;
import de.vw.mib.asl.internal.connectivity.TargetASLNetworking$1;
import de.vw.mib.asl.internal.connectivity.transformer.ConnectivityNetworkProviderListCollector;
import de.vw.mib.asl.internal.phone.util.DefaultDSIMobileEquipmentListener;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.telephoneng.LockStateStruct;
import org.dsi.ifc.telephoneng.NetworkProvider;
import org.dsi.ifc.telephoneng.RegisterStateStruct;

class TargetASLNetworking$NadListener
extends DefaultDSIMobileEquipmentListener {
    private final /* synthetic */ TargetASLNetworking this$0;

    private TargetASLNetworking$NadListener(TargetASLNetworking targetASLNetworking) {
        this.this$0 = targetASLNetworking;
    }

    @Override
    public void updateNetworkType(int n, int n2) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1013899008);
        eventGeneric.setInt(0, TargetASLNetworking.access$100(n));
        this.this$0.triggerObserver(-1013899008, eventGeneric);
        AbstractASLTarget.writeIntegerToDatapool(1664353024, TargetASLNetworking.access$200(n));
    }

    @Override
    public void updateSignalQuality(int n, int n2) {
        int n3 = TargetASLNetworking.access$300(this.this$0, n);
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-997121792);
        eventGeneric.setInt(0, n3);
        this.this$0.triggerObserver(-997121792, eventGeneric);
        AbstractASLTarget.writeIntegerToDatapool(1614021376, n3);
    }

    @Override
    public void responseNetworkSearch(NetworkProvider[] networkProviderArray, int n) {
        TargetASLNetworking.access$402(this.this$0, false);
        AbstractASLTarget.writeBooleanToDatapool(1362363136, false);
        Object[] objectArray = new ConnectivityNetworkProviderListCollector[networkProviderArray.length];
        for (int i2 = 0; i2 < networkProviderArray.length; ++i2) {
            objectArray[i2] = new ConnectivityNetworkProviderListCollector();
            ((ConnectivityNetworkProviderListCollector)objectArray[i2]).networkProvider = networkProviderArray[i2];
        }
        ListManager.getGenericASLList(1379140352).updateList(objectArray);
    }

    @Override
    public void updateAutomaticPinEntryActive(boolean bl, int n) {
    }

    @Override
    public void responseUnlockSIM(int n) {
        if (this.this$0.isTraceEnabled()) {
            this.this$0.trace().append("responseUnlockSIM(").append(n).append(')').log();
        }
        if (n == 0) {
            this.this$0.sendHMIEvent(588);
        } else {
            this.this$0.sendHMIEvent(589);
        }
    }

    @Override
    public void updateNADMode(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        if (n == 3) {
            this.this$0.error("NAD mode voice not supported! Expect undefined behavior!");
        }
        TargetASLNetworking.access$502(this.this$0, n);
        AbstractASLTarget.writeBooleanToDatapool(4032, n == 2);
        TargetASLNetworking.access$600(this.this$0);
        TargetASLNetworking.access$700(this.this$0);
    }

    @Override
    public void updateLockState(LockStateStruct lockStateStruct, int n) {
        TargetASLNetworking.access$802(this.this$0, lockStateStruct.getTelLockState());
        switch (TargetASLNetworking.access$800(this.this$0)) {
            case 2: {
                AbstractASLTarget.writeIntegerToDatapool(4029, 2);
                AbstractASLTarget.writeIntegerToDatapool(4030, 2);
                EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-913235712);
                this.this$0.sendSafe(eventGeneric);
                break;
            }
            case 3: {
                TargetASLNetworking.access$902(this.this$0, false);
                AbstractASLTarget.writeIntegerToDatapool(4088, 0);
                AbstractASLTarget.writeIntegerToDatapool(4029, 1);
                AbstractASLTarget.writeIntegerToDatapool(4030, 1);
                AbstractASLTarget.writeIntegerToDatapool(4031, 3);
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(30)) {
                    this.this$0.sendHMIEvent(1362363136);
                }
                EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-913235712);
                this.this$0.sendSafe(eventGeneric);
                AbstractASLTarget.writeIntegerToDatapool(4089, lockStateStruct.getTelRetryCounter());
                break;
            }
            case 5: {
                TargetASLNetworking.access$902(this.this$0, true);
                AbstractASLTarget.writeIntegerToDatapool(4088, 1);
                AbstractASLTarget.writeIntegerToDatapool(4029, 1);
                AbstractASLTarget.writeIntegerToDatapool(4030, 1);
                AbstractASLTarget.writeIntegerToDatapool(4031, 4);
                if (ServiceManager.configManagerDiag.isFeatureFlagSet(30)) {
                    this.this$0.sendHMIEvent(1362363136);
                }
                EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-913235712);
                this.this$0.sendSafe(eventGeneric);
                AbstractASLTarget.writeIntegerToDatapool(4089, lockStateStruct.getTelRetryCounter());
                break;
            }
            case 1: {
                AbstractASLTarget.writeIntegerToDatapool(4029, 1);
                AbstractASLTarget.writeIntegerToDatapool(4030, 1);
                AbstractASLTarget.writeIntegerToDatapool(4031, 3);
                break;
            }
            case 11: {
                AbstractASLTarget.writeIntegerToDatapool(4029, 1);
                AbstractASLTarget.writeIntegerToDatapool(4030, 1);
                AbstractASLTarget.writeIntegerToDatapool(4031, 0);
                break;
            }
            case 0: {
                AbstractASLTarget.writeIntegerToDatapool(4029, 0);
                AbstractASLTarget.writeIntegerToDatapool(4030, 0);
                TargetASLNetworking.access$1000(this.this$0);
                break;
            }
            default: {
                AbstractASLTarget.writeIntegerToDatapool(4029, 0);
                AbstractASLTarget.writeIntegerToDatapool(4030, 0);
                this.this$0.warn(new StringBuffer().append("unhandled NadLockState ").append(TargetASLNetworking.access$800(this.this$0)).toString());
            }
        }
        TargetASLNetworking.access$700(this.this$0);
        TargetASLNetworking.access$600(this.this$0);
    }

    @Override
    public void responseNetworkRegistration(int n) {
        Object[] objectArray = (ConnectivityNetworkProviderListCollector[])ListManager.getGenericASLList(1379140352).getDSIObjects();
        if (n == 0) {
            this.this$0.sendHMIEvent(1429472000);
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                if (objectArray[i2].networkProvider.getTelProviderState() == 1) {
                    ((ConnectivityNetworkProviderListCollector)objectArray[i2]).networkProvider.telProviderState = 3;
                }
                if (!((ConnectivityNetworkProviderListCollector)objectArray[i2]).isLoading) continue;
                ((ConnectivityNetworkProviderListCollector)objectArray[i2]).isLoading = false;
                ((ConnectivityNetworkProviderListCollector)objectArray[i2]).networkProvider.telProviderState = 1;
            }
        } else {
            for (int i3 = 0; i3 < objectArray.length; ++i3) {
                if (objectArray[i3].networkProvider.getTelProviderState() == 1) {
                    ((ConnectivityNetworkProviderListCollector)objectArray[i3]).networkProvider.telProviderState = 3;
                }
                if (!((ConnectivityNetworkProviderListCollector)objectArray[i3]).isLoading) continue;
                ((ConnectivityNetworkProviderListCollector)objectArray[i3]).isLoading = false;
            }
            if (n == 12) {
                this.this$0.sendHMIEvent(1412694784);
            } else {
                this.this$0.sendHMIEvent(1446249216);
            }
        }
        ListManager.getGenericASLList(1379140352).updateList(objectArray);
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        if (n2 == 1011 || n2 == 1010) {
            TargetASLNetworking.access$402(this.this$0, false);
            AbstractASLTarget.writeBooleanToDatapool(1362363136, false);
        } else if (n2 == 1008) {
            this.this$0.error("Network registration took too long and timed out, therefore RESULT_ERROR_NO_NW_REPLY was sent internally!");
            this.responseNetworkRegistration(12);
        }
    }

    @Override
    public void updateRegisterState(RegisterStateStruct registerStateStruct, int n) {
        Object[] objectArray;
        AbstractASLTarget.writeStringToDatapool(1395917568, registerStateStruct.telLongProviderName);
        AbstractASLTarget.writeBooleanToDatapool(1731461888, registerStateStruct.telRegMode == 1);
        if (registerStateStruct.telRegisterState != 1 && !Util.isNullOrEmpty(objectArray = ListManager.getGenericASLList(1379140352).getDSIObjects())) {
            ConnectivityNetworkProviderListCollector[] connectivityNetworkProviderListCollectorArray = (ConnectivityNetworkProviderListCollector[])objectArray;
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                if (connectivityNetworkProviderListCollectorArray[i2].networkProvider.getTelProviderState() != 1) continue;
                connectivityNetworkProviderListCollectorArray[i2].networkProvider.telProviderState = 3;
            }
        }
    }

    /* synthetic */ TargetASLNetworking$NadListener(TargetASLNetworking targetASLNetworking, TargetASLNetworking$1 targetASLNetworking$1) {
        this(targetASLNetworking);
    }
}

