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

public interface MMX2BluetoothDiagServiceC {
    default public void responseErrorBluetooth(sClientResponseError sClientResponseError2) {
    }

    default public void responseBluetoothState(sBluetoothState sBluetoothState2) {
    }

    default public void responseBluetoothMAC(sBluetoothMAC sBluetoothMAC2) {
    }

    default public void responseBluetoothDevices(sBluetoothDevices sBluetoothDevices2) {
    }

    default public void responseLastPairedBtDevices(sLastPairedBtDevices sLastPairedBtDevices2) {
    }

    default public void responsePairedBtDevices(sPairedBtDevices sPairedBtDevices2) {
    }

    default public void responseConnectedBtDevices(sConnectedBtDevices sConnectedBtDevices2) {
    }

    default public void responseConnectedBtDevice(sConnectedBtDevice sConnectedBtDevice2) {
    }

    default public void responseAutoConnectBtHandset(sRoutineResponse sRoutineResponse2) {
    }

    default public void responseBtDeleteLinkKeys(sRoutineResponse sRoutineResponse2) {
    }

    default public void responseBtDeviceSearch(long l) {
    }

    default public void responseBtDeviceSearchItem(sBluetoothDeviceName[] sBluetoothDeviceNameArray) {
    }

    default public void responseConnectionToLastBtDevice(long l) {
    }
}

