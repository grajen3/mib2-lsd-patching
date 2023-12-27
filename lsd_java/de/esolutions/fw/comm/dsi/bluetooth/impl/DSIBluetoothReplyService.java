/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.bluetooth.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.bluetooth.DSIBluetoothReply;
import de.esolutions.fw.comm.dsi.bluetooth.impl.DiscoveredDeviceSerializer;
import de.esolutions.fw.comm.dsi.bluetooth.impl.MasterRoleRequestStructSerializer;
import de.esolutions.fw.comm.dsi.bluetooth.impl.PasskeyStateStructSerializer;
import de.esolutions.fw.comm.dsi.bluetooth.impl.ReconnectInfoSerializer;
import de.esolutions.fw.comm.dsi.bluetooth.impl.RequestIncomingServiceSerializer;
import de.esolutions.fw.comm.dsi.bluetooth.impl.ServiceRequestStateStructSerializer;
import de.esolutions.fw.comm.dsi.bluetooth.impl.TrustedDeviceSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.bluetooth.DiscoveredDevice;
import org.dsi.ifc.bluetooth.MasterRoleRequestStruct;
import org.dsi.ifc.bluetooth.PasskeyStateStruct;
import org.dsi.ifc.bluetooth.ReconnectInfo;
import org.dsi.ifc.bluetooth.RequestIncomingService;
import org.dsi.ifc.bluetooth.ServiceRequestStateStruct;
import org.dsi.ifc.bluetooth.TrustedDevice;

public class DSIBluetoothReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.bluetooth.DSIBluetooth");
    private static int dynamicHandle = 0;
    private DSIBluetoothReply p_DSIBluetoothReply;

    public DSIBluetoothReplyService(DSIBluetoothReply dSIBluetoothReply) {
        super(new ServiceInstanceID("34b09f77-0209-59b5-b249-c330b33effb4", DSIBluetoothReplyService.nextDynamicHandle(), "ad7487e6-9b49-5fc8-9838-2ae2d9bc0388", "dsi.bluetooth.DSIBluetooth"));
        this.p_DSIBluetoothReply = dSIBluetoothReply;
    }

    private static synchronized int nextDynamicHandle() {
        int n = ++dynamicHandle;
        return n;
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 20: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.responseAbortConnectService(n);
                    break;
                }
                case 21: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.responseAbortInquiry(n);
                    break;
                }
                case 22: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.responseAcceptIncomingServiceRequest(n);
                    break;
                }
                case 56: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.responseConnectService(string, string2, n, n2, n3);
                    break;
                }
                case 24: {
                    String string = iDeserializer.getOptionalString();
                    String string3 = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.responseConnectServiceToInstance(string, string3, n, n4, n5);
                    break;
                }
                case 25: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.responseDisconnectService(string, n, n6);
                    break;
                }
                case 26: {
                    String string = iDeserializer.getOptionalString();
                    String string4 = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.responseGetServices(string, string4, n, n7);
                    break;
                }
                case 27: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.responseInquiry(n, n8);
                    break;
                }
                case 28: {
                    String string = iDeserializer.getOptionalString();
                    String string5 = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.responsePasskeyResponse(string, string5, n);
                    break;
                }
                case 30: {
                    String string = iDeserializer.getOptionalString();
                    String string6 = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.responseRemoveAuthentication(string, string6, n);
                    break;
                }
                case 31: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.responseRestoreFactorySettings(n);
                    break;
                }
                case 32: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.responseSetA2DPUserSetting(n);
                    break;
                }
                case 61: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.responseSetAccessibleMode(n);
                    break;
                }
                case 33: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.responseSwitchBTState(n);
                    break;
                }
                case 7: {
                    String string = iDeserializer.getOptionalString();
                    String string7 = iDeserializer.getOptionalString();
                    this.p_DSIBluetoothReply.removeAuthenticationNoSupport(string, string7);
                    break;
                }
                case 41: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.updateAccessibleMode(n, bl, n9);
                    break;
                }
                case 42: {
                    int n = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.updateBTState(n, n10);
                    break;
                }
                case 43: {
                    DiscoveredDevice discoveredDevice = DiscoveredDeviceSerializer.getOptionalDiscoveredDevice(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.updateDiscoveredDevices(discoveredDevice, n);
                    break;
                }
                case 44: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.updateHUCandBTHSState(n, n11);
                    break;
                }
                case 45: {
                    RequestIncomingService requestIncomingService = RequestIncomingServiceSerializer.getOptionalRequestIncomingService(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.updateIncomingServiceRequest(requestIncomingService, n);
                    break;
                }
                case 46: {
                    MasterRoleRequestStruct masterRoleRequestStruct = MasterRoleRequestStructSerializer.getOptionalMasterRoleRequestStruct(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.updateMasterRoleRequestError(masterRoleRequestStruct, n);
                    break;
                }
                case 47: {
                    PasskeyStateStruct passkeyStateStruct = PasskeyStateStructSerializer.getOptionalPasskeyStateStruct(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.updatePasskeyState(passkeyStateStruct, n);
                    break;
                }
                case 48: {
                    ReconnectInfo reconnectInfo = ReconnectInfoSerializer.getOptionalReconnectInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.updateReconnectIndicator(reconnectInfo, n);
                    break;
                }
                case 49: {
                    ServiceRequestStateStruct serviceRequestStateStruct = ServiceRequestStateStructSerializer.getOptionalServiceRequestStateStruct(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.updateServiceRequestState(serviceRequestStateStruct, n);
                    break;
                }
                case 50: {
                    int n = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.updateSupportedBTProfiles(n, n12);
                    break;
                }
                case 57: {
                    TrustedDevice[] trustedDeviceArray = TrustedDeviceSerializer.getOptionalTrustedDeviceVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.updateTrustedDevices(trustedDeviceArray, n);
                    break;
                }
                case 52: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.updateUserFriendlyName(string, n);
                    break;
                }
                case 40: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.updateA2DPUserSetting(bl, n);
                    break;
                }
                case 60: {
                    boolean bl = iDeserializer.getBool();
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.updatePriorizedDeviceReconnect(bl, string, n);
                    break;
                }
                case 6: {
                    String string = iDeserializer.getOptionalString();
                    String string8 = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.deviceDisonnectionInfo(string, string8, n);
                    break;
                }
                case 34: {
                    String string = iDeserializer.getOptionalString();
                    String string9 = iDeserializer.getOptionalString();
                    this.p_DSIBluetoothReply.serviceRejectNoSupport(string, string9);
                    break;
                }
                case 29: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.responseReconnectSuspend(n);
                    break;
                }
                case 59: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.responseSetPriorizedDeviceReconnect(n);
                    break;
                }
                case 2: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n13 = iDeserializer.getInt32();
                    this.p_DSIBluetoothReply.asyncException(n, string, n13);
                    break;
                }
                case 53: {
                    String string = iDeserializer.getOptionalString();
                    String string10 = iDeserializer.getOptionalString();
                    this.p_DSIBluetoothReply.yyIndication(string, string10);
                    break;
                }
                default: {
                    throw new MethodException(new StringBuffer().append("Invalid Method Id ").append(s).toString());
                }
            }
        }
        catch (SerializerException serializerException) {
            throw new MethodException(new StringBuffer().append("Deserialization failed: method=").append(s).append(", error=").append(serializerException.getMessage()).toString());
        }
    }
}

