/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.bluetooth;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.bluetooth.DiscoveredDevice;
import org.dsi.ifc.bluetooth.MasterRoleRequestStruct;
import org.dsi.ifc.bluetooth.PasskeyStateStruct;
import org.dsi.ifc.bluetooth.ReconnectInfo;
import org.dsi.ifc.bluetooth.RequestIncomingService;
import org.dsi.ifc.bluetooth.ServiceRequestStateStruct;
import org.dsi.ifc.bluetooth.TrustedDevice;

public final class DSIBluetoothTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_DISCOVEREDDEVICE;
    private static final int ID_MASTERROLEREQUESTSTRUCT;
    private static final int ID_PASSKEYSTATESTRUCT;
    private static final int ID_RECONNECTINFO;
    private static final int ID_REQUESTINCOMINGSERVICE;
    private static final int ID_SERVICEREQUESTSTATESTRUCT;
    private static final int ID_TRUSTEDDEVICE;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DiscoveredDevice;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$MasterRoleRequestStruct;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$PasskeyStateStruct;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$ReconnectInfo;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$RequestIncomingService;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$ServiceRequestStateStruct;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$TrustedDevice;

    public DSIBluetoothTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$bluetooth$DiscoveredDevice == null ? (class$org$dsi$ifc$bluetooth$DiscoveredDevice = DSIBluetoothTracer.class$("org.dsi.ifc.bluetooth.DiscoveredDevice")) : class$org$dsi$ifc$bluetooth$DiscoveredDevice, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$bluetooth$MasterRoleRequestStruct == null ? (class$org$dsi$ifc$bluetooth$MasterRoleRequestStruct = DSIBluetoothTracer.class$("org.dsi.ifc.bluetooth.MasterRoleRequestStruct")) : class$org$dsi$ifc$bluetooth$MasterRoleRequestStruct, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$bluetooth$PasskeyStateStruct == null ? (class$org$dsi$ifc$bluetooth$PasskeyStateStruct = DSIBluetoothTracer.class$("org.dsi.ifc.bluetooth.PasskeyStateStruct")) : class$org$dsi$ifc$bluetooth$PasskeyStateStruct, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$bluetooth$ReconnectInfo == null ? (class$org$dsi$ifc$bluetooth$ReconnectInfo = DSIBluetoothTracer.class$("org.dsi.ifc.bluetooth.ReconnectInfo")) : class$org$dsi$ifc$bluetooth$ReconnectInfo, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$bluetooth$RequestIncomingService == null ? (class$org$dsi$ifc$bluetooth$RequestIncomingService = DSIBluetoothTracer.class$("org.dsi.ifc.bluetooth.RequestIncomingService")) : class$org$dsi$ifc$bluetooth$RequestIncomingService, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$bluetooth$ServiceRequestStateStruct == null ? (class$org$dsi$ifc$bluetooth$ServiceRequestStateStruct = DSIBluetoothTracer.class$("org.dsi.ifc.bluetooth.ServiceRequestStateStruct")) : class$org$dsi$ifc$bluetooth$ServiceRequestStateStruct, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$bluetooth$TrustedDevice == null ? (class$org$dsi$ifc$bluetooth$TrustedDevice = DSIBluetoothTracer.class$("org.dsi.ifc.bluetooth.TrustedDevice")) : class$org$dsi$ifc$bluetooth$TrustedDevice, 7);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceDiscoveredDevice(printWriter, (DiscoveredDevice)object);
                break;
            }
            case 2: {
                this.traceMasterRoleRequestStruct(printWriter, (MasterRoleRequestStruct)object);
                break;
            }
            case 3: {
                this.tracePasskeyStateStruct(printWriter, (PasskeyStateStruct)object);
                break;
            }
            case 4: {
                this.traceReconnectInfo(printWriter, (ReconnectInfo)object);
                break;
            }
            case 5: {
                this.traceRequestIncomingService(printWriter, (RequestIncomingService)object);
                break;
            }
            case 6: {
                this.traceServiceRequestStateStruct(printWriter, (ServiceRequestStateStruct)object);
                break;
            }
            case 7: {
                this.traceTrustedDevice(printWriter, (TrustedDevice)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceDiscoveredDevice(PrintWriter printWriter, DiscoveredDevice discoveredDevice) {
        if (discoveredDevice == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(discoveredDevice.deviceName);
        printWriter.print(discoveredDevice.deviceAddress);
        printWriter.print(discoveredDevice.deviceClass);
        printWriter.print(discoveredDevice.serviceTypes);
    }

    private void traceMasterRoleRequestStruct(PrintWriter printWriter, MasterRoleRequestStruct masterRoleRequestStruct) {
        if (masterRoleRequestStruct == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(masterRoleRequestStruct.btDeviceAddress);
        printWriter.print(masterRoleRequestStruct.btDeviceName);
        printWriter.print(masterRoleRequestStruct.requested);
    }

    private void tracePasskeyStateStruct(PrintWriter printWriter, PasskeyStateStruct passkeyStateStruct) {
        if (passkeyStateStruct == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(passkeyStateStruct.btPasskeyState);
        printWriter.print(passkeyStateStruct.btDeviceName);
        printWriter.print(passkeyStateStruct.btDeviceAddress);
        printWriter.print(passkeyStateStruct.btPasskey);
    }

    private void traceReconnectInfo(PrintWriter printWriter, ReconnectInfo reconnectInfo) {
        int n;
        int n2;
        if (reconnectInfo == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(reconnectInfo.reconnectIndicator);
        if (reconnectInfo.deviceNameList == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = reconnectInfo.deviceNameList.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(reconnectInfo.deviceNameList[n]);
            }
        }
        if (reconnectInfo.serviceTypeList == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = reconnectInfo.serviceTypeList.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(reconnectInfo.serviceTypeList[n]);
            }
        }
    }

    private void traceRequestIncomingService(PrintWriter printWriter, RequestIncomingService requestIncomingService) {
        if (requestIncomingService == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(requestIncomingService.btDeviceName);
        printWriter.print(requestIncomingService.btDeviceAddress);
        printWriter.print(requestIncomingService.btServiceType);
    }

    private void traceServiceRequestStateStruct(PrintWriter printWriter, ServiceRequestStateStruct serviceRequestStateStruct) {
        if (serviceRequestStateStruct == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(serviceRequestStateStruct.btServiceRequestState);
        printWriter.print(serviceRequestStateStruct.btDeviceAddress);
        printWriter.print(serviceRequestStateStruct.btDeviceName);
    }

    private void traceTrustedDevice(PrintWriter printWriter, TrustedDevice trustedDevice) {
        if (trustedDevice == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(trustedDevice.deviceName);
        printWriter.print(trustedDevice.deviceAddress);
        printWriter.print(trustedDevice.deviceRole);
        printWriter.print(trustedDevice.deviceClass);
        printWriter.print(trustedDevice.deviceSecurity);
        printWriter.print(trustedDevice.linkMode);
        printWriter.print(trustedDevice.linkkeyStrength);
        printWriter.print(trustedDevice.lastConnectedServiceTypes);
        printWriter.print(trustedDevice.activeServiceTypes);
        printWriter.print(trustedDevice.offeredServiceTypes);
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

