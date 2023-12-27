/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.bluetooth.transformer;

import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.bluetooth.ConnectedDevice;
import de.vw.mib.asl.internal.phone.bluetooth.transformer.PhoneBluetoothBondingProfileSelectionCollector;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.phone.bluetooth.transformer.AbstractPhoneBluetoothBondingSearchResultTransformer;
import org.dsi.ifc.bluetooth.DiscoveredDevice;

public class PhoneBluetoothBondingSearchResultTransformer
extends AbstractPhoneBluetoothBondingSearchResultTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        boolean bl;
        DiscoveredDevice discoveredDevice = (DiscoveredDevice)object;
        switch (n) {
            case 3: {
                bl = this.checkForDevicePaired(discoveredDevice.deviceAddress);
                break;
            }
            case 6: {
                bl = this.checkForDeviceConnected(discoveredDevice.deviceAddress, n);
                break;
            }
            case 7: {
                bl = PhoneUtil.getMediaProfileCount(discoveredDevice.serviceTypes) > 0;
                break;
            }
            case 8: {
                bl = this.checkForDeviceConnected(discoveredDevice.deviceAddress, n);
                break;
            }
            case 9: {
                bl = PhoneUtil.getOtherProfileCount(PhoneUtil.removeADRDLProfileIfSIMNotInserted(discoveredDevice.serviceTypes, discoveredDevice.getDeviceName())) > 0;
                break;
            }
            case 10: {
                bl = this.checkForDeviceConnected(discoveredDevice.deviceAddress, n);
                break;
            }
            case 11: {
                bl = PhoneUtil.getPhoneProfileCount(discoveredDevice.serviceTypes) > 0;
                break;
            }
            case 4: {
                PhoneBluetoothBondingProfileSelectionCollector[] phoneBluetoothBondingProfileSelectionCollectorArray = PhoneUtil.getProfilesFromServiceList(discoveredDevice.serviceTypes, discoveredDevice.deviceAddress, ASLPhoneData.getInstance().deviceTypeSearchFilter);
                if (phoneBluetoothBondingProfileSelectionCollectorArray != null && phoneBluetoothBondingProfileSelectionCollectorArray.length == 1) {
                    bl = phoneBluetoothBondingProfileSelectionCollectorArray[0].connected;
                    break;
                }
                bl = false;
                break;
            }
            case 5: {
                PhoneBluetoothBondingProfileSelectionCollector[] phoneBluetoothBondingProfileSelectionCollectorArray = PhoneUtil.getProfilesFromServiceList(discoveredDevice.serviceTypes, discoveredDevice.deviceAddress, ASLPhoneData.getInstance().deviceTypeSearchFilter);
                if (phoneBluetoothBondingProfileSelectionCollectorArray != null && phoneBluetoothBondingProfileSelectionCollectorArray.length == 1) {
                    bl = Util.isBitSet(phoneBluetoothBondingProfileSelectionCollectorArray[0].profileDSI, ASLPhoneData.getInstance().supportedProfiles);
                    break;
                }
                bl = false;
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
            }
        }
        return bl;
    }

    private boolean checkForDeviceConnected(String string, int n) {
        ConnectedDevice connectedDevice = (ConnectedDevice)ASLPhoneData.getInstance().trustedBTDevices.get(string);
        if (connectedDevice != null && connectedDevice.connectedServiceCount != 0 && PhoneUtil.isServiceInFilter(connectedDevice.connectedServices)) {
            switch (n) {
                case 6: {
                    return PhoneUtil.isMediaProfile(connectedDevice.device.activeServiceTypes);
                }
                case 8: {
                    return PhoneUtil.isOtherProfile(connectedDevice.device.activeServiceTypes);
                }
                case 10: {
                    return PhoneUtil.isPhoneProfile(connectedDevice.device.activeServiceTypes);
                }
            }
            throw new IllegalArgumentException();
        }
        return false;
    }

    private boolean checkForDevicePaired(String string) {
        return ASLPhoneData.getInstance().trustedBTDevices.containsKey(string);
    }

    @Override
    public int getInt(int n, Object object) {
        DiscoveredDevice discoveredDevice = (DiscoveredDevice)object;
        switch (n) {
            case 2: {
                switch (ASLPhoneData.getInstance().deviceTypeSearchFilter) {
                    case 0: {
                        return PhoneUtil.getAllProfileCount(discoveredDevice.serviceTypes);
                    }
                    case 1: {
                        return PhoneUtil.getPhoneProfileCount(discoveredDevice.serviceTypes);
                    }
                    case 2: {
                        return PhoneUtil.getPhoneDeviceProfileCount(discoveredDevice.serviceTypes);
                    }
                    case 3: {
                        return PhoneUtil.getPhoneEquipProfileCount(discoveredDevice.serviceTypes);
                    }
                    case 4: {
                        return PhoneUtil.getMediaProfileCount(discoveredDevice.serviceTypes);
                    }
                    case 5: {
                        return PhoneUtil.getMediaDeviceProfileCount(discoveredDevice.serviceTypes);
                    }
                    case 6: {
                        return PhoneUtil.getMediaEquipProfileCount(discoveredDevice.serviceTypes);
                    }
                    case 11: {
                        return PhoneUtil.getPhoneBookProfileCount(discoveredDevice.serviceTypes);
                    }
                }
                return 0;
            }
            case 0: {
                PhoneBluetoothBondingProfileSelectionCollector[] phoneBluetoothBondingProfileSelectionCollectorArray = PhoneUtil.getProfilesFromServiceList(discoveredDevice.serviceTypes, discoveredDevice.deviceAddress, ASLPhoneData.getInstance().deviceTypeSearchFilter);
                if (phoneBluetoothBondingProfileSelectionCollectorArray != null && phoneBluetoothBondingProfileSelectionCollectorArray.length == 1) {
                    return phoneBluetoothBondingProfileSelectionCollectorArray[0].profileASL;
                }
                return 0;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public String getString(int n, Object object) {
        DiscoveredDevice discoveredDevice = (DiscoveredDevice)object;
        switch (n) {
            case 1: {
                return Util.isNullOrEmpty(discoveredDevice.deviceName) ? discoveredDevice.deviceAddress : discoveredDevice.deviceName;
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    @Override
    public boolean[] getFlagVector(int n, Object object) {
        throw new IllegalArgumentException();
    }
}

