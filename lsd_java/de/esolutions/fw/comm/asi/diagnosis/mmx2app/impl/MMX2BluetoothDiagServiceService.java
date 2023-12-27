/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl.sBluetoothDeviceNameSerializer;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl.sBluetoothDevicesSerializer;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl.sBluetoothMACSerializer;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl.sBluetoothStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl.sConnectedBtDeviceSerializer;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl.sConnectedBtDevicesSerializer;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl.sLastPairedBtDevicesSerializer;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.impl.sPairedBtDevicesSerializer;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sBluetoothDeviceName;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sBluetoothDevices;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sBluetoothMAC;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sBluetoothState;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sConnectedBtDevice;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sConnectedBtDevices;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sLastPairedBtDevices;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sPairedBtDevices;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sClientResponseErrorSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sRoutineResponseSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sRoutineResponse;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2BluetoothDiagServiceS;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2BluetoothDiagServiceReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2BluetoothDiagServiceService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.diagnosis.mmx2app.MMX2BluetoothDiagService");
    private MMX2BluetoothDiagServiceS p_MMX2BluetoothDiagService;

    public MMX2BluetoothDiagServiceService(int n, MMX2BluetoothDiagServiceS mMX2BluetoothDiagServiceS) {
        super(new ServiceInstanceID("f669c772-a80d-457f-b9af-0eb44581d9e1", n, "95c41391-df54-5fea-80a5-0615f88b8b03", "asi.diagnosis.mmx2app.MMX2BluetoothDiagService"));
        this.p_MMX2BluetoothDiagService = mMX2BluetoothDiagServiceS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new MMX2BluetoothDiagServiceReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 37: {
                    sClientResponseError sClientResponseError2 = sClientResponseErrorSerializer.getOptionalsClientResponseError(iDeserializer);
                    this.p_MMX2BluetoothDiagService.responseErrorBluetooth(sClientResponseError2, (MMX2BluetoothDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 14: {
                    sBluetoothState sBluetoothState2 = sBluetoothStateSerializer.getOptionalsBluetoothState(iDeserializer);
                    this.p_MMX2BluetoothDiagService.responseBluetoothState(sBluetoothState2, (MMX2BluetoothDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 13: {
                    sBluetoothMAC sBluetoothMAC2 = sBluetoothMACSerializer.getOptionalsBluetoothMAC(iDeserializer);
                    this.p_MMX2BluetoothDiagService.responseBluetoothMAC(sBluetoothMAC2, (MMX2BluetoothDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 12: {
                    sBluetoothDevices sBluetoothDevices2 = sBluetoothDevicesSerializer.getOptionalsBluetoothDevices(iDeserializer);
                    this.p_MMX2BluetoothDiagService.responseBluetoothDevices(sBluetoothDevices2, (MMX2BluetoothDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 38: {
                    sLastPairedBtDevices sLastPairedBtDevices2 = sLastPairedBtDevicesSerializer.getOptionalsLastPairedBtDevices(iDeserializer);
                    this.p_MMX2BluetoothDiagService.responseLastPairedBtDevices(sLastPairedBtDevices2, (MMX2BluetoothDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 32: {
                    sPairedBtDevices sPairedBtDevices2 = sPairedBtDevicesSerializer.getOptionalsPairedBtDevices(iDeserializer);
                    this.p_MMX2BluetoothDiagService.responsePairedBtDevices(sPairedBtDevices2, (MMX2BluetoothDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 31: {
                    sConnectedBtDevices sConnectedBtDevices2 = sConnectedBtDevicesSerializer.getOptionalsConnectedBtDevices(iDeserializer);
                    this.p_MMX2BluetoothDiagService.responseConnectedBtDevices(sConnectedBtDevices2, (MMX2BluetoothDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 17: {
                    sConnectedBtDevice sConnectedBtDevice2 = sConnectedBtDeviceSerializer.getOptionalsConnectedBtDevice(iDeserializer);
                    this.p_MMX2BluetoothDiagService.responseConnectedBtDevice(sConnectedBtDevice2, (MMX2BluetoothDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 27: {
                    sRoutineResponse sRoutineResponse2 = sRoutineResponseSerializer.getOptionalsRoutineResponse(iDeserializer);
                    this.p_MMX2BluetoothDiagService.responseAutoConnectBtHandset(sRoutineResponse2, (MMX2BluetoothDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 28: {
                    sRoutineResponse sRoutineResponse3 = sRoutineResponseSerializer.getOptionalsRoutineResponse(iDeserializer);
                    this.p_MMX2BluetoothDiagService.responseBtDeleteLinkKeys(sRoutineResponse3, (MMX2BluetoothDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 16: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2BluetoothDiagService.responseBtDeviceSearch(l, (MMX2BluetoothDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 36: {
                    sBluetoothDeviceName[] sBluetoothDeviceNameArray = sBluetoothDeviceNameSerializer.getOptionalsBluetoothDeviceNameVarArray(iDeserializer);
                    this.p_MMX2BluetoothDiagService.responseBtDeviceSearchItem(sBluetoothDeviceNameArray, (MMX2BluetoothDiagServiceReplyProxy)iProxyFrontend);
                    break;
                }
                case 19: {
                    long l = iDeserializer.getUInt32();
                    this.p_MMX2BluetoothDiagService.responseConnectionToLastBtDevice(l, (MMX2BluetoothDiagServiceReplyProxy)iProxyFrontend);
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

