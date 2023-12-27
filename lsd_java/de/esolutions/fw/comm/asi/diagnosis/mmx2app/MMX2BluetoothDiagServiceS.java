/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sBluetoothDeviceName;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sBluetoothDevices;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sBluetoothMAC;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sBluetoothState;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sConnectedBtDevice;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sConnectedBtDevices;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sLastPairedBtDevices;
import de.esolutions.fw.comm.asi.diagnosis.bluetooth.sPairedBtDevices;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sRoutineResponse;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2BluetoothDiagServiceReply;

public interface MMX2BluetoothDiagServiceS {
    default public void responseErrorBluetooth(sClientResponseError sClientResponseError2, MMX2BluetoothDiagServiceReply mMX2BluetoothDiagServiceReply) {
    }

    default public void responseBluetoothState(sBluetoothState sBluetoothState2, MMX2BluetoothDiagServiceReply mMX2BluetoothDiagServiceReply) {
    }

    default public void responseBluetoothMAC(sBluetoothMAC sBluetoothMAC2, MMX2BluetoothDiagServiceReply mMX2BluetoothDiagServiceReply) {
    }

    default public void responseBluetoothDevices(sBluetoothDevices sBluetoothDevices2, MMX2BluetoothDiagServiceReply mMX2BluetoothDiagServiceReply) {
    }

    default public void responseLastPairedBtDevices(sLastPairedBtDevices sLastPairedBtDevices2, MMX2BluetoothDiagServiceReply mMX2BluetoothDiagServiceReply) {
    }

    default public void responsePairedBtDevices(sPairedBtDevices sPairedBtDevices2, MMX2BluetoothDiagServiceReply mMX2BluetoothDiagServiceReply) {
    }

    default public void responseConnectedBtDevices(sConnectedBtDevices sConnectedBtDevices2, MMX2BluetoothDiagServiceReply mMX2BluetoothDiagServiceReply) {
    }

    default public void responseConnectedBtDevice(sConnectedBtDevice sConnectedBtDevice2, MMX2BluetoothDiagServiceReply mMX2BluetoothDiagServiceReply) {
    }

    default public void responseAutoConnectBtHandset(sRoutineResponse sRoutineResponse2, MMX2BluetoothDiagServiceReply mMX2BluetoothDiagServiceReply) {
    }

    default public void responseBtDeleteLinkKeys(sRoutineResponse sRoutineResponse2, MMX2BluetoothDiagServiceReply mMX2BluetoothDiagServiceReply) {
    }

    default public void responseBtDeviceSearch(long l, MMX2BluetoothDiagServiceReply mMX2BluetoothDiagServiceReply) {
    }

    default public void responseBtDeviceSearchItem(sBluetoothDeviceName[] sBluetoothDeviceNameArray, MMX2BluetoothDiagServiceReply mMX2BluetoothDiagServiceReply) {
    }

    default public void responseConnectionToLastBtDevice(long l, MMX2BluetoothDiagServiceReply mMX2BluetoothDiagServiceReply) {
    }
}

