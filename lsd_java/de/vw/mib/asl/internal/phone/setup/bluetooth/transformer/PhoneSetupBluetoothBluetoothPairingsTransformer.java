/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.setup.bluetooth.transformer;

import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.bluetooth.ConnectedDevice;
import de.vw.mib.asl.internal.phone.bluetooth.transformer.PhoneBluetoothBondingProfileSelectionCollector;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import generated.de.vw.mib.asl.internal.phone.setup.bluetooth.transformer.AbstractPhoneSetupBluetoothBluetoothPairingsTransformer;

public class PhoneSetupBluetoothBluetoothPairingsTransformer
extends AbstractPhoneSetupBluetoothBluetoothPairingsTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        ConnectedDevice connectedDevice = (ConnectedDevice)object;
        switch (n) {
            case 4: {
                return PhoneUtil.getMediaProfileCount(connectedDevice.device.offeredServiceTypes) > 0;
            }
            case 6: {
                return PhoneUtil.getOtherProfileCount(PhoneUtil.removeADRDLProfileIfSIMNotInserted(connectedDevice.device.getOfferedServiceTypes(), connectedDevice.device.getDeviceAddress())) > 0;
            }
            case 8: {
                return PhoneUtil.getProfilesFromServiceList(connectedDevice.device.offeredServiceTypes, connectedDevice.device.deviceAddress, 1).length > 0;
            }
            case 3: {
                return PhoneUtil.getMediaProfileCount(connectedDevice.device.activeServiceTypes) > 0;
            }
            case 5: {
                return PhoneUtil.getOtherProfileCount(PhoneUtil.removeADRDLProfileIfSIMNotInserted(connectedDevice.device.getActiveServiceTypes(), connectedDevice.device.getDeviceAddress())) > 0;
            }
            case 7: {
                return PhoneUtil.getProfilesFromServiceList(connectedDevice.device.activeServiceTypes, connectedDevice.device.deviceAddress, 1).length > 0;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public int getInt(int n, Object object) {
        ConnectedDevice connectedDevice = (ConnectedDevice)object;
        int n2 = ASLPhoneData.getInstance().deviceTypePairedDevicesFilter;
        PhoneBluetoothBondingProfileSelectionCollector[] phoneBluetoothBondingProfileSelectionCollectorArray = PhoneUtil.getProfilesFromServiceList(connectedDevice.device.offeredServiceTypes, connectedDevice.device.deviceAddress, n2);
        switch (n) {
            case 1: {
                if (phoneBluetoothBondingProfileSelectionCollectorArray.length < 1) {
                    return 0;
                }
                return phoneBluetoothBondingProfileSelectionCollectorArray[0].profileASL;
            }
            case 2: {
                return phoneBluetoothBondingProfileSelectionCollectorArray.length;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public String getString(int n, Object object) {
        ConnectedDevice connectedDevice = (ConnectedDevice)object;
        switch (n) {
            case 0: {
                return connectedDevice.device.deviceName;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

