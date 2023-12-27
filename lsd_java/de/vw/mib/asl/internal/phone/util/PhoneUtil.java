/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.util;

import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.ASLPhoneData;
import de.vw.mib.asl.internal.phone.bluetooth.ConnectedDevice;
import de.vw.mib.asl.internal.phone.bluetooth.ConnectedDeviceASL;
import de.vw.mib.asl.internal.phone.bluetooth.transformer.PhoneBluetoothBondingProfileSelectionCollector;
import de.vw.mib.asl.internal.phone.call.CallHandling$MobileEquipmentListener;
import de.vw.mib.asl.internal.phone.call.transformer.PhoneCallInformationCollector;
import de.vw.mib.asl.internal.phone.callstacks.transformer.PhoneCallstacksCallstacksCollector;
import de.vw.mib.asl.internal.phone.contacts.transformer.PhoneContactsSelectedContactNumberCollector;
import de.vw.mib.asl.internal.phone.selection.phone.transformer.PhoneSelectionPhonePhoneSelectionCollector;
import de.vw.mib.asl.internal.phone.setup.call.transformer.PhoneSetupCallCallForwardingsCollector;
import de.vw.mib.asl.internal.phone.util.PhoneUtil$CallStackComparator;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.phone.bluetooth.transformer.PhoneBluetoothBondingErrorCollector;
import generated.de.vw.mib.asl.internal.phone.contacts.ASLPhoneContactsPropertyManager;
import generated.de.vw.mib.asl.internal.phone.contacts.transformer.PhoneContactsSelectedContactCollector;
import generated.de.vw.mib.asl.internal.phone.setup.call.transformer.PhoneSetupCallCallSettingsCollector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.dsi.ifc.bluetooth.DiscoveredDevice;
import org.dsi.ifc.bluetooth.TrustedDevice;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.organizer.DSIAdbList;
import org.dsi.ifc.organizer.EmailData;
import org.dsi.ifc.organizer.PhoneData;
import org.dsi.ifc.telephoneng.CFRequestData;
import org.dsi.ifc.telephoneng.CFResponseData;
import org.dsi.ifc.telephoneng.CallInformation;
import org.dsi.ifc.telephoneng.DSIMobileEquipment;
import org.dsi.ifc.telephoneng.EmergencyNumbers;

public final class PhoneUtil {
    private static final int MAX_DISC_DEVICES;
    private static final HashMap DISC_DEV_LIST;
    private static int discDeviceCount;
    private static ArrayList discDeviceAddressList;
    public static int requestedPhoneAudioConnection;
    public static boolean initialRequestWasSent;
    private static int setTelephoneListStyleFilter;
    private static int setTelephoneListStyleLine1;
    private static int setTelephoneListStyleLine2;
    private static String currentBTBondingErrorDeviceAddress;
    private static int sendBTInquiryRunningCounter;

    private PhoneUtil() {
    }

    public static void resetDiscoveredDevices() {
        DISC_DEV_LIST.clear();
        discDeviceCount = 0;
        discDeviceAddressList = new ArrayList(50);
    }

    public static DiscoveredDevice[] updateDiscoveredDevices(DiscoveredDevice discoveredDevice) {
        Object object;
        Object[] objectArray = PhoneUtil.getProfilesFromServiceList(discoveredDevice.getServiceTypes(), discoveredDevice.getDeviceAddress(), ASLPhoneData.getInstance().deviceTypeSearchFilter);
        if (!Util.isNullOrEmpty(objectArray) || discoveredDevice.getServiceTypes() == 0) {
            if (discoveredDevice.getDeviceName().equals("") && DISC_DEV_LIST.containsKey(discoveredDevice.deviceAddress)) {
                object = (DiscoveredDevice)DISC_DEV_LIST.get(discoveredDevice.deviceAddress);
                discoveredDevice.deviceName = ((DiscoveredDevice)object).getDeviceName();
            }
            if (DISC_DEV_LIST.put(discoveredDevice.deviceAddress, discoveredDevice) == null) {
                if (discDeviceCount == 50) {
                    DISC_DEV_LIST.remove(discDeviceAddressList.get(discDeviceCount));
                    discDeviceAddressList.remove(discDeviceCount);
                }
                discDeviceAddressList.add(discDeviceCount, discoveredDevice.deviceAddress);
                ++discDeviceCount;
            }
        }
        object = new DiscoveredDevice[DISC_DEV_LIST.size()];
        for (int i2 = 0; i2 < DISC_DEV_LIST.size(); ++i2) {
            object[i2] = (DiscoveredDevice)DISC_DEV_LIST.get(discDeviceAddressList.get(i2));
        }
        return object;
    }

    public static boolean isServiceInFilter(int n) {
        return PhoneUtil.isServiceInFilter(n, ASLPhoneData.getInstance().deviceTypeSearchFilter);
    }

    public static boolean isServiceInFilter(int[] nArray) {
        boolean bl = false;
        for (int i2 = 0; i2 < nArray.length && !bl; ++i2) {
            bl = PhoneUtil.isServiceInFilter(nArray[i2], ASLPhoneData.getInstance().deviceTypeSearchFilter);
        }
        return bl;
    }

    private static boolean isServiceInFilter(int n, int n2) {
        boolean bl;
        if (n == 0) {
            return true;
        }
        switch (n2) {
            case 0: {
                bl = true;
                break;
            }
            case 1: {
                bl = PhoneUtil.isPhoneProfile(n);
                break;
            }
            case 2: {
                bl = PhoneUtil.isPhoneDeviceProfile(n);
                break;
            }
            case 3: {
                bl = PhoneUtil.isPhoneEquipProfile(n);
                break;
            }
            case 4: {
                bl = PhoneUtil.isMediaProfile(n);
                break;
            }
            case 5: {
                bl = PhoneUtil.isMediaDeviceProfile(n);
                break;
            }
            case 6: {
                bl = PhoneUtil.isMediaEquipProfile(n);
                break;
            }
            case 11: {
                bl = PhoneUtil.isPhonebookProfile(n);
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    public static int convertPhoneTypeDSI2ASLCombined(int n) {
        if (n != -1) {
            if (Util.isBitSet(64, n)) {
                return 1;
            }
            if (Util.isBitSet(16, n)) {
                if (Util.isBitSet(4, n)) {
                    return 7;
                }
                if (Util.isBitSet(2, n)) {
                    return 11;
                }
                return 3;
            }
            if (Util.isBitSet(2, n)) {
                return 8;
            }
            if (Util.isBitSet(4, n)) {
                return 4;
            }
        }
        return 0;
    }

    public static PhoneData[] ripADBPhoneData(PhoneData[] phoneDataArray) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < phoneDataArray.length; ++i2) {
            PhoneData phoneData = phoneDataArray[i2];
            if (Util.isNullOrEmpty(phoneData.getNumber())) continue;
            arrayList.add(phoneData);
        }
        return (PhoneData[])arrayList.toArray(new PhoneData[arrayList.size()]);
    }

    public static AddressData[] ripADBAddressData(AddressData[] addressDataArray) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < addressDataArray.length; ++i2) {
            AddressData addressData = addressDataArray[i2];
            if (Util.isNullOrEmpty(addressData.getCountry()) && Util.isNullOrEmpty(addressData.getGeoPosition()) && Util.isNullOrEmpty(addressData.getLocality()) && Util.isNullOrEmpty(addressData.getPostalCode()) && Util.isNullOrEmpty(addressData.getRegion()) && Util.isNullOrEmpty(addressData.getStreet())) continue;
            arrayList.add(addressData);
        }
        return (AddressData[])arrayList.toArray(new AddressData[arrayList.size()]);
    }

    public static EmailData[] ripADBEmailData(EmailData[] emailDataArray) {
        ArrayList arrayList = new ArrayList();
        if (!Util.isNullOrEmpty(emailDataArray)) {
            for (int i2 = 0; i2 < emailDataArray.length; ++i2) {
                EmailData emailData = emailDataArray[i2];
                if (Util.isNullOrEmpty(emailData.getEmailAddr())) continue;
                arrayList.add(emailData);
            }
        }
        return (EmailData[])arrayList.toArray(new EmailData[arrayList.size()]);
    }

    public static PhoneBluetoothBondingProfileSelectionCollector[] getProfilesFromServiceList(int n, String string, int n2) {
        ArrayList arrayList = new ArrayList();
        boolean bl = false;
        for (int i2 = 1; i2 <= n && i2 != 0; i2 <<= 1) {
            boolean bl2;
            if (!Util.isBitSet(i2, n)) continue;
            PhoneBluetoothBondingProfileSelectionCollector phoneBluetoothBondingProfileSelectionCollector = new PhoneBluetoothBondingProfileSelectionCollector();
            switch (n2) {
                case 0: {
                    bl = PhoneUtil.isPhoneProfile(i2) || PhoneUtil.isPhonebookProfile(i2) || PhoneUtil.isMediaDeviceProfile(i2) || PhoneUtil.isMAPProfile(i2);
                    break;
                }
                case 1: {
                    bl = PhoneUtil.isPhoneProfile(i2);
                    break;
                }
                case 2: {
                    bl = PhoneUtil.isPhoneDeviceProfile(i2);
                    break;
                }
                case 3: {
                    bl = PhoneUtil.isPhoneEquipProfile(i2);
                    break;
                }
                case 4: {
                    bl = PhoneUtil.isMediaProfile(i2);
                    break;
                }
                case 5: {
                    bl = PhoneUtil.isMediaDeviceProfile(i2);
                    break;
                }
                case 6: {
                    bl = PhoneUtil.isMediaEquipProfile(i2);
                    break;
                }
                case 11: {
                    bl = PhoneUtil.isPhonebookProfile(i2);
                    break;
                }
            }
            if (!bl) continue;
            ConnectedDevice connectedDevice = (ConnectedDevice)ASLPhoneData.getInstance().trustedBTDevices.get(string);
            boolean bl3 = !PhoneUtil.isPhonebookProfile(i2) || ASLPhoneData.getInstance().internalSIMConnected && (connectedDevice == null || !PhoneUtil.isPhoneProfile(connectedDevice.device.getActiveServiceTypes()));
            boolean bl4 = bl2 = !PhoneUtil.isPhoneDeviceProfile(i2) || connectedDevice == null || !ASLPhoneData.getInstance().internalSIMConnected || ASLPhoneData.getInstance().internalSIMConnected && connectedDevice != null && !PhoneUtil.isPhonebookProfile(connectedDevice.device.getActiveServiceTypes()) || connectedDevice != null && PhoneUtil.isPhoneProfile(connectedDevice.device.getActiveServiceTypes());
            if (!bl3 || !bl2) continue;
            phoneBluetoothBondingProfileSelectionCollector.profileDSI = i2;
            phoneBluetoothBondingProfileSelectionCollector.profileASL = PhoneUtil.convertServiceTypeDSI2ASL(i2);
            phoneBluetoothBondingProfileSelectionCollector.connected = PhoneUtil.isDeviceConnected(string, i2);
            arrayList.add(phoneBluetoothBondingProfileSelectionCollector);
            bl = false;
        }
        Collections.sort(arrayList);
        return (PhoneBluetoothBondingProfileSelectionCollector[])arrayList.toArray(new PhoneBluetoothBondingProfileSelectionCollector[arrayList.size()]);
    }

    public static int convertServiceTypeDSI2ASL(int n) {
        if (Util.isBitSet(4, n)) {
            return 1;
        }
        if (Util.isBitSet(2, n)) {
            return 2;
        }
        if (Util.isBitSet(512, n)) {
            return 3;
        }
        if (Util.isBitSet(16, n)) {
            return 4;
        }
        if (Util.isBitSet(256, n)) {
            return 5;
        }
        if (Util.isBitSet(0x800000, n)) {
            return 6;
        }
        if (Util.isBitSet(2048, n)) {
            return 7;
        }
        if (Util.isBitSet(512, n)) {
            return 8;
        }
        if (Util.isBitSet(8192, n)) {
            return 10;
        }
        if (Util.isBitSet(8192, n)) {
            return 12;
        }
        if (Util.isBitSet(32, n)) {
            return 13;
        }
        if (Util.isBitSet(128, n)) {
            return 14;
        }
        if (Util.isBitSet(1024, n)) {
            return 15;
        }
        if (Util.isBitSet(16384, n)) {
            return 16;
        }
        return 0;
    }

    public static int convertNetworkTypeDSI2ASL(int n) {
        switch (n) {
            case 1: 
            case 2: {
                return 1;
            }
            case 3: 
            case 4: {
                return 2;
            }
            case 5: {
                return 3;
            }
        }
        return 0;
    }

    public static int convertServiceTypeDSI2PhoneASL(int n) {
        if (Util.isBitSet(4, n)) {
            return 1;
        }
        if (Util.isBitSet(2, n)) {
            return 2;
        }
        if (Util.isBitSet(512, n)) {
            return 3;
        }
        if (Util.isBitSet(16, n)) {
            return 4;
        }
        return 0;
    }

    public static int convertServiceTypeDSI2MediaASL(int n) {
        if (Util.isBitSet(256, n)) {
            return 1;
        }
        if (Util.isBitSet(0x800000, n)) {
            return 2;
        }
        return 0;
    }

    public static int convertServiceTypeDSI2PhoneContactsASL(int n) {
        if (Util.isBitSet(32, n) && !Util.isAnyBitSet(6, n)) {
            return 1;
        }
        return 0;
    }

    public static int convertServiceTypeDSI2OtherASL(int n) {
        if (Util.isBitSet(2048, n)) {
            return 1;
        }
        if (Util.isBitSet(512, n)) {
            return 2;
        }
        if ((0x1C00 & n) != 0) {
            return 3;
        }
        if (Util.isBitSet(8192, n)) {
            return 4;
        }
        if (Util.isBitSet(16384, n)) {
            return 5;
        }
        if (Util.isBitSet(8192, n)) {
            return 6;
        }
        if (Util.isBitSet(128, n)) {
            return 8;
        }
        if (Util.isBitSet(1024, n)) {
            return 9;
        }
        if (Util.isBitSet(16384, n)) {
            return 10;
        }
        return 0;
    }

    private static boolean isDeviceConnected(String string, int n) {
        Iterator iterator = ASLPhoneData.getInstance().trustedBTDevices.values().iterator();
        boolean bl = false;
        while (iterator.hasNext() && !bl) {
            ConnectedDevice connectedDevice = (ConnectedDevice)iterator.next();
            for (int i2 = 0; connectedDevice.device.deviceAddress.equals(string) && i2 < connectedDevice.connectedServices.length && !bl; ++i2) {
                if (connectedDevice.connectedServices[i2] != n) continue;
                bl = true;
            }
        }
        return bl;
    }

    public static boolean isPhoneProfile(int n) {
        return PhoneUtil.isPhoneDeviceProfile(n) || PhoneUtil.isPhoneEquipProfile(n);
    }

    public static boolean isPhoneDeviceProfile(int n) {
        return Util.isAnyBitSet(22, n);
    }

    public static boolean isPhoneEquipProfile(int n) {
        return Util.isAnyBitSet(0x8000200, n);
    }

    public static boolean isMediaProfile(int n) {
        return PhoneUtil.isMediaDeviceProfile(n) || PhoneUtil.isMediaEquipProfile(n);
    }

    public static boolean isMediaDeviceProfile(int n) {
        return Util.isBitSet(256, n);
    }

    public static boolean isMediaEquipProfile(int n) {
        return Util.isBitSet(0x800000, n);
    }

    public static boolean isPhonebookProfile(int n) {
        return Util.isBitSet(32, n);
    }

    public static boolean isOtherProfile(int n) {
        return PhoneUtil.isPhonebookProfile(n) || PhoneUtil.isMAPProfile(n);
    }

    public static boolean isMAPProfile(int n) {
        return false;
    }

    public static int getPhoneProfile(int n) {
        for (int i2 = 1; i2 <= n && i2 != 0; i2 <<= 1) {
            if (!Util.isBitSet(i2, n) || !PhoneUtil.isPhoneDeviceProfile(i2)) continue;
            return i2;
        }
        return 0;
    }

    public static int getMediaProfile(int n) {
        for (int i2 = 1; i2 <= n && i2 != 0; i2 <<= 1) {
            if (!Util.isBitSet(i2, n) || !PhoneUtil.isMediaDeviceProfile(i2)) continue;
            return i2;
        }
        return 0;
    }

    public static int getADRDLProfile(int n) {
        for (int i2 = 1; i2 <= n && i2 != 0; i2 <<= 1) {
            if (!Util.isBitSet(i2, n) || !Util.isBitSet(32, i2)) continue;
            return i2;
        }
        return 0;
    }

    public static int getAllProfileCount(int n) {
        int n2 = 0;
        for (int i2 = 1; i2 <= n && i2 != 0; i2 <<= 1) {
            if (!Util.isBitSet(i2, n)) continue;
            if (PhoneUtil.isPhoneProfile(i2)) {
                ++n2;
                if (PhoneUtil.isPhoneDeviceProfile(i2)) {
                    ++n2;
                    continue;
                }
                if (!PhoneUtil.isPhoneEquipProfile(i2)) continue;
                ++n2;
                continue;
            }
            if (PhoneUtil.isMediaProfile(i2)) {
                ++n2;
                if (PhoneUtil.isMediaProfile(i2) && PhoneUtil.isMediaDeviceProfile(i2)) {
                    ++n2;
                }
                if (!PhoneUtil.isMediaProfile(i2) || !PhoneUtil.isMediaEquipProfile(i2)) continue;
                ++n2;
                continue;
            }
            if (i2 == 1 || i2 == 0) continue;
            ++n2;
        }
        return n2;
    }

    public static int getMediaProfileCount(int n) {
        int n2 = 0;
        for (int i2 = 1; i2 <= n && i2 != 0; i2 <<= 1) {
            if (!Util.isBitSet(i2, n) || !PhoneUtil.isMediaProfile(i2)) continue;
            ++n2;
        }
        return n2;
    }

    public static int getMediaDeviceProfileCount(int n) {
        int n2 = 0;
        for (int i2 = 1; i2 <= n && i2 != 0; i2 <<= 1) {
            if (!Util.isBitSet(i2, n) || !PhoneUtil.isMediaDeviceProfile(i2)) continue;
            ++n2;
        }
        return n2;
    }

    public static int getMediaEquipProfileCount(int n) {
        int n2 = 0;
        for (int i2 = 1; i2 <= n && i2 != 0; i2 <<= 1) {
            if (!Util.isBitSet(i2, n) || !PhoneUtil.isMediaEquipProfile(i2)) continue;
            ++n2;
        }
        return n2;
    }

    public static int getPhoneProfileCount(int n) {
        int n2 = 0;
        for (int i2 = 1; i2 <= n && i2 != 0; i2 <<= 1) {
            if (!Util.isBitSet(i2, n) || !PhoneUtil.isPhoneProfile(i2)) continue;
            ++n2;
        }
        return n2;
    }

    public static int getPhoneDeviceProfileCount(int n) {
        int n2 = 0;
        for (int i2 = 1; i2 <= n && i2 != 0; i2 <<= 1) {
            if (!Util.isBitSet(i2, n) || !PhoneUtil.isPhoneDeviceProfile(i2)) continue;
            ++n2;
        }
        return n2;
    }

    public static int getPhoneEquipProfileCount(int n) {
        int n2 = 0;
        for (int i2 = 1; i2 <= n && i2 != 0; i2 <<= 1) {
            if (!Util.isBitSet(i2, n) || !PhoneUtil.isPhoneEquipProfile(i2)) continue;
            ++n2;
        }
        return n2;
    }

    public static int getPhoneBookProfileCount(int n) {
        return PhoneUtil.isPhonebookProfile(n) ? 1 : 0;
    }

    public static int getMapProfileCount(int n) {
        return PhoneUtil.isMAPProfile(n) ? 1 : 0;
    }

    public static int getOtherProfileCount(int n) {
        return PhoneUtil.getPhoneBookProfileCount(n) + PhoneUtil.getMapProfileCount(n);
    }

    public static boolean contains(int[] nArray, int n) {
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            int n2 = nArray[i2];
            if (n2 != n) continue;
            return true;
        }
        return false;
    }

    public static void filterBluetoothPairedDeviceList() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < ASLPhoneData.getInstance().trustedBTDevicesAddresses.size(); ++i2) {
            boolean bl;
            boolean bl2 = false;
            ConnectedDevice connectedDevice = (ConnectedDevice)ASLPhoneData.getInstance().trustedBTDevices.get(ASLPhoneData.getInstance().trustedBTDevicesAddresses.get(i2));
            switch (ASLPhoneData.getInstance().deviceTypePairedDevicesFilter) {
                case 0: {
                    bl2 = true;
                    break;
                }
                case 1: {
                    bl2 = PhoneUtil.isPhoneProfile(connectedDevice.device.offeredServiceTypes);
                    break;
                }
                case 2: {
                    bl2 = PhoneUtil.isPhoneDeviceProfile(connectedDevice.device.offeredServiceTypes);
                    break;
                }
                case 3: {
                    bl2 = PhoneUtil.isPhoneEquipProfile(connectedDevice.device.offeredServiceTypes);
                    break;
                }
                case 4: {
                    bl2 = PhoneUtil.isMediaProfile(connectedDevice.device.offeredServiceTypes);
                    break;
                }
                case 5: {
                    bl2 = PhoneUtil.isMediaDeviceProfile(connectedDevice.device.offeredServiceTypes);
                    break;
                }
                case 6: {
                    bl2 = PhoneUtil.isMediaEquipProfile(connectedDevice.device.offeredServiceTypes);
                    break;
                }
                case 11: {
                    bl2 = PhoneUtil.isPhonebookProfile(connectedDevice.device.offeredServiceTypes);
                    break;
                }
            }
            if (!bl2) continue;
            boolean bl3 = ASLPhoneData.getInstance().deviceTypePairedDevicesFilter != 11 || ASLPhoneData.getInstance().internalSIMConnected && connectedDevice != null && !PhoneUtil.isPhoneProfile(connectedDevice.device.getActiveServiceTypes());
            boolean bl4 = bl = ASLPhoneData.getInstance().deviceTypePairedDevicesFilter != 1 || ASLPhoneData.getInstance().internalSIMConnected && connectedDevice != null && !PhoneUtil.isPhonebookProfile(connectedDevice.device.getActiveServiceTypes());
            if (!bl3 || !bl) continue;
            arrayList.add(connectedDevice);
        }
        ListManager.getGenericASLList(1204).updateList(arrayList.toArray(new ConnectedDevice[arrayList.size()]));
    }

    public static int convertBTErrorCodesDSI2ASL(int n) {
        int n2 = 1;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 2: {
                n2 = 0;
                break;
            }
            case 1: {
                break;
            }
            case 13: {
                n2 = 13;
                break;
            }
            case 14: {
                break;
            }
            case 11: {
                break;
            }
            case 3: {
                break;
            }
            case 12: {
                break;
            }
            case 17: {
                break;
            }
            case 8: {
                n2 = 6;
                break;
            }
            case 4: {
                n2 = 2;
                break;
            }
            case 5: {
                n2 = 3;
                break;
            }
            case 6: {
                n2 = 4;
                break;
            }
            case 19: {
                break;
            }
            case 7: {
                n2 = 5;
                break;
            }
            case 18: {
                break;
            }
            case 20: {
                n2 = 10;
                break;
            }
            case 23: {
                n2 = 14;
                break;
            }
            case 22: {
                n2 = 15;
                break;
            }
        }
        return n2;
    }

    public static void checkNumber(String string, boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedString(1151, string);
        if (Util.isNullOrEmpty(string)) {
            ServiceManager.aslPropertyManager.valueChangedInteger(bl ? -27105792 : 1152, 0);
            return;
        }
        boolean bl2 = PhoneUtil.numbersEqual(string, ASLPhoneData.getInstance().emergencyNumbers.mainEmergencyNumber);
        if (ASLPhoneData.getInstance().emergencyNumbers.additionalEmergencyNumber != null) {
            for (int i2 = 0; i2 < ASLPhoneData.getInstance().emergencyNumbers.additionalEmergencyNumber.length; ++i2) {
                String string2 = ASLPhoneData.getInstance().emergencyNumbers.additionalEmergencyNumber[i2];
                if (!PhoneUtil.numbersEqual(string, string2)) continue;
                bl2 = true;
            }
        }
        if (bl2) {
            ServiceManager.aslPropertyManager.valueChangedInteger(bl ? -27105792 : 1152, 2);
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(bl ? -27105792 : 1152, 1);
        }
    }

    public static int getLastConnectedTelephonyService(TrustedDevice trustedDevice) {
        for (int i2 = 1; i2 <= trustedDevice.lastConnectedServiceTypes && i2 != 0; i2 <<= 1) {
            if (!PhoneUtil.isPhoneDeviceProfile(i2) || !Util.isBitSet(i2, trustedDevice.lastConnectedServiceTypes) || i2 == 4 && (ASLPhoneData.getInstance().nadEnabledPhone != 1 || ASLPhoneData.getInstance().telModeNad == 0)) continue;
            return i2;
        }
        if (Util.isBitSet(4, trustedDevice.offeredServiceTypes) && ASLPhoneData.getInstance().nadEnabledPhone == 1 && ASLPhoneData.getInstance().telModeNad != 0) {
            return 4;
        }
        if (Util.isBitSet(2, trustedDevice.offeredServiceTypes)) {
            return 2;
        }
        throw new IllegalArgumentException(new StringBuffer().append("Trusted device has no last connected telephony service set! : ").append(trustedDevice.deviceName).toString());
    }

    public static EventGeneric createSingleEntryEvent(int n, int n2, long l) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(n, 5270, -1601830656);
        eventGeneric.setSenderEventId(n2);
        eventGeneric.setLong(0, l);
        return eventGeneric;
    }

    public static CFRequestData fillRequestCallForward(int n, int n2, String string, short s) {
        CFRequestData cFRequestData = new CFRequestData();
        cFRequestData.telCFMode = n;
        cFRequestData.telCFCondition = n2;
        cFRequestData.telClass = s;
        cFRequestData.telCFNumber = !Util.isNullOrEmpty(string) ? string : "";
        return cFRequestData;
    }

    public static int convertCallStateDSI2ASL(PhoneCallInformationCollector phoneCallInformationCollector) {
        int n = phoneCallInformationCollector.conferenceCallState != -1 ? phoneCallInformationCollector.conferenceCallState : phoneCallInformationCollector.callInformation.telCallState;
        switch (n) {
            case 0: {
                return 0;
            }
            case 4: {
                return 5;
            }
            case 2: {
                return 2;
            }
            case 1: {
                return 1;
            }
            case 5: {
                return 6;
            }
            case 6: {
                return 7;
            }
            case 3: {
                return 3;
            }
            case 8: {
                return 4;
            }
        }
        return 4;
    }

    public static int convertEntryTypeDSI2ASLCallTypeBAP(int n) {
        switch (n) {
            case 0: {
                return 3;
            }
            case 2: {
                return 1;
            }
            case 1: {
                return 2;
            }
            case 3: {
                return 0;
            }
        }
        return 0;
    }

    public static int convertEntryTypeDSI2ASLCallType(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 2: {
                return 2;
            }
            case 1: {
                return 1;
            }
        }
        return 0;
    }

    public static int convertCallTypeDSI2ASL(CallInformation callInformation) {
        if (!Util.isNullOrEmpty(ASLPhoneData.getInstance().mailboxNumber) && callInformation.getTelRemNumber() != null && callInformation.getTelRemEntryId() == 0L && callInformation.getTelRemNumber().equals(ASLPhoneData.getInstance().mailboxNumber)) {
            return 7;
        }
        switch (callInformation.telCallType) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 6: {
                return 4;
            }
            case 5: {
                return 5;
            }
            case 4: {
                return 6;
            }
            case 8: {
                return 7;
            }
            case 7: {
                return 8;
            }
        }
        return 0;
    }

    public static int convertRegisterStateDSI2ASL(int n) {
        switch (n) {
            case 5: {
                return 4;
            }
            case 4: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
            case 0: {
                return 0;
            }
        }
        return 0;
    }

    public static int convertDisconnectReasonDSI2ASL(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 2;
            }
            case 2: {
                return 3;
            }
            case 3: {
                return 4;
            }
            case 4: {
                return 5;
            }
            case 5: {
                return 6;
            }
            case 6: {
                return 7;
            }
            case 7: {
                return 8;
            }
            case 9: {
                return 9;
            }
            case 8: {
                return 10;
            }
            case 10: {
                return 11;
            }
            case 11: {
                return 12;
            }
            case 12: {
                return 13;
            }
            case 13: {
                return 14;
            }
            case 14: {
                return 15;
            }
        }
        return 13;
    }

    public static void setNADFeatures(boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(1098, bl);
        ServiceManager.aslPropertyManager.valueChangedBoolean(1207, bl);
        ServiceManager.aslPropertyManager.valueChangedBoolean(1208, bl);
        Object[] objectArray = (PhoneSetupCallCallSettingsCollector[])ListManager.getGenericASLList(1211).getDSIObjects();
        if (objectArray != null && objectArray[0] != null) {
            objectArray[0].phone_setup_call_call_setting_call_waiting_available = bl;
            objectArray[0].phone_setup_call_call_setting_send_calling_id_available = bl;
            ListManager.getGenericASLList(1211).updateList(objectArray);
        }
    }

    public static void enablePINSettings() {
        if ((ASLPhoneData.getInstance().telMode == 0 || ASLPhoneData.getInstance().telMode == 2) && ASLPhoneData.getInstance().lockState == 2) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(1228, true);
        } else {
            ServiceManager.aslPropertyManager.valueChangedBoolean(1228, false);
        }
    }

    public static ArrayList sortCallStacks(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
        ArrayList arrayList4 = new ArrayList(arrayList.size() + arrayList3.size() + arrayList.size());
        arrayList4.addAll(arrayList);
        arrayList4.addAll(arrayList2);
        arrayList4.addAll(arrayList3);
        Collections.sort(arrayList4, PhoneUtil$CallStackComparator.INSTANCE);
        return arrayList4;
    }

    public static ArrayList sortCallStacks(ArrayList arrayList) {
        Collections.sort(arrayList, PhoneUtil$CallStackComparator.INSTANCE);
        return arrayList;
    }

    public static boolean updateContactsSize(int n) {
        if (n != ASLPhoneData.getInstance().phoneContactsSize) {
            ListManager.getGenericASLList(1190).setSizeClearCache(n);
            ASLPhoneData.getInstance().phoneContactsSize = n;
            return true;
        }
        return false;
    }

    public static void updateShortDialMatchingSize(int n) {
        ListManager.getGenericASLList(1169).setSizeClearCache(n);
        ASLPhoneData.getInstance().phoneShortDialMatchingSize = n;
    }

    public static void requestPhoneAudioConnection(AbstractTarget abstractTarget, boolean bl, CallHandling$MobileEquipmentListener callHandling$MobileEquipmentListener) {
        abstractTarget.trace("RequestPhoneAudioConnection Entered");
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(34159872);
        int n = 0;
        initialRequestWasSent = true;
        if (bl) {
            boolean bl2 = requestedPhoneAudioConnection == 99 || ASLPhoneData.getInstance().activePhoneAudioConnection == 99 || requestedPhoneAudioConnection == 104 || ASLPhoneData.getInstance().activePhoneAudioConnection == 104;
            abstractTarget.trace().append("RequestPhoneAudioConnection delay: ").append(bl2).log();
            if (callHandling$MobileEquipmentListener.isOutband()) {
                if (requestedPhoneAudioConnection != 98 && ASLPhoneData.getInstance().activePhoneAudioConnection != 98) {
                    if (bl2) {
                        PhoneUtil.releaseAudioConnection(abstractTarget, false);
                    }
                    n = 98;
                    eventGeneric.setBoolean(1, true);
                    requestedPhoneAudioConnection = 98;
                    abstractTarget.trace(new StringBuffer().append("RequestPhoneAudioConnection - requestedPhoneAudioConnection set to: ").append(requestedPhoneAudioConnection).toString());
                }
            } else if (requestedPhoneAudioConnection != 103 && ASLPhoneData.getInstance().activePhoneAudioConnection != 103) {
                if (bl2) {
                    PhoneUtil.releaseAudioConnection(abstractTarget, false);
                }
                n = 103;
                requestedPhoneAudioConnection = 103;
                abstractTarget.trace(new StringBuffer().append("RequestPhoneAudioConnection - requestedPhoneAudioConnection set to: ").append(requestedPhoneAudioConnection).toString());
            }
        } else if (callHandling$MobileEquipmentListener.getTelMode() == 0 || callHandling$MobileEquipmentListener.getTelMode() == 2) {
            if (requestedPhoneAudioConnection != 99 && ASLPhoneData.getInstance().activePhoneAudioConnection != 99) {
                n = 99;
                requestedPhoneAudioConnection = 99;
                abstractTarget.trace(new StringBuffer().append("RequestPhoneAudioConnection - requestedPhoneAudioConnection set to: ").append(requestedPhoneAudioConnection).toString());
            }
        } else if (callHandling$MobileEquipmentListener.getTelMode() == 3) {
            if (requestedPhoneAudioConnection != 104 && ASLPhoneData.getInstance().activePhoneAudioConnection != 104) {
                n = 104;
                requestedPhoneAudioConnection = 104;
                abstractTarget.trace(new StringBuffer().append("RequestPhoneAudioConnection - requestedPhoneAudioConnection set to: ").append(requestedPhoneAudioConnection).toString());
            }
        } else {
            abstractTarget.warn("Trying to set a telephone audio connection, but telMode is neither HFP nor SIM/SIMAP! Assuming emergency call...");
            if (requestedPhoneAudioConnection != 99 && ASLPhoneData.getInstance().activePhoneAudioConnection != 99) {
                n = 99;
                requestedPhoneAudioConnection = 99;
                abstractTarget.trace(new StringBuffer().append("RequestPhoneAudioConnection - requestedPhoneAudioConnection set to: ").append(requestedPhoneAudioConnection).toString());
            }
        }
        if (n != 0) {
            abstractTarget.trace(new StringBuffer().append("RequestPhoneAudioConnection - Connection to request is: ").append(n).toString());
            eventGeneric.setInt(0, n);
            eventGeneric.setBoolean(2, true);
            eventGeneric.setSenderEventId(-1729219072);
            eventGeneric.setSenderTargetId(abstractTarget.getTargetId());
            abstractTarget.sendSafe(eventGeneric);
            if (n == 99 || n == 104) {
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(34159872);
                eventGeneric2.setInt(0, 100);
                abstractTarget.sendSafe(eventGeneric2);
            }
        }
        abstractTarget.trace("RequestPhoneAudioConnection Left");
    }

    public static boolean restoreAudioConnection(AbstractTarget abstractTarget) {
        abstractTarget.trace("RestoreAudioConnection Entered");
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(34159872);
        int n = 0;
        if (requestedPhoneAudioConnection > 0) {
            n = ASLPhoneData.getInstance().activePhoneAudioConnection;
        }
        if (requestedPhoneAudioConnection == 98) {
            n = 98;
            eventGeneric.setBoolean(1, true);
        }
        abstractTarget.trace(new StringBuffer().append("RestoreAudioConnection - try to restore audio connection: ").append(n).toString());
        if (n != 0) {
            eventGeneric.setInt(0, n);
            eventGeneric.setSenderEventId(-1729219072);
            eventGeneric.setSenderTargetId(abstractTarget.getTargetId());
            abstractTarget.sendSafe(eventGeneric);
            if (n == 99 || n == 104) {
                EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(34159872);
                eventGeneric2.setInt(0, 100);
                abstractTarget.sendSafe(eventGeneric2);
            }
            return true;
        }
        return false;
    }

    public static void setActiveAudioConnection(int n) {
        requestedPhoneAudioConnection = n;
        ASLPhoneData.getInstance().activePhoneAudioConnection = n;
    }

    public static void releaseAudioConnection(AbstractTarget abstractTarget, boolean bl) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(67714304);
        int n = 0;
        abstractTarget.trace(new StringBuffer().append("ReleasePhoneAudioConnection Entered - activeAudioConnection is ").append(ASLPhoneData.getInstance().activePhoneAudioConnection).toString());
        if (initialRequestWasSent) {
            if (bl) {
                if (ASLPhoneData.getInstance().activePhoneAudioConnection == 98) {
                    n = ASLPhoneData.getInstance().activePhoneAudioConnection;
                    ASLPhoneData.getInstance().activePhoneAudioConnection = 0;
                    requestedPhoneAudioConnection = 0;
                    abstractTarget.trace(new StringBuffer().append("ReleasePhoneAudioConnection - requestedPhoneAudioConnection set to: ").append(requestedPhoneAudioConnection).toString());
                }
            } else if (requestedPhoneAudioConnection > 0) {
                n = requestedPhoneAudioConnection;
                ASLPhoneData.getInstance().activePhoneAudioConnection = 0;
                requestedPhoneAudioConnection = 0;
                abstractTarget.trace(new StringBuffer().append("ReleasePhoneAudioConnection - requestedPhoneAudioConnection set to: ").append(requestedPhoneAudioConnection).toString());
            } else if (ASLPhoneData.getInstance().activePhoneAudioConnection > 0) {
                n = ASLPhoneData.getInstance().activePhoneAudioConnection;
                ASLPhoneData.getInstance().activePhoneAudioConnection = 0;
                requestedPhoneAudioConnection = 0;
                abstractTarget.trace(new StringBuffer().append("ReleasePhoneAudioConnection - requestedPhoneAudioConnection set to: ").append(requestedPhoneAudioConnection).toString());
            }
            EventGeneric eventGeneric2 = ServiceManager.mGenericEventFactory.newEvent(-2031208960);
            abstractTarget.sendSafe(eventGeneric2);
            abstractTarget.trace(new StringBuffer().append("Release Connection: ").append(n).toString());
            if (n != 0) {
                if (n == 99 || n == 104) {
                    EventGeneric eventGeneric3 = ServiceManager.mGenericEventFactory.newEvent(67714304);
                    eventGeneric3.setInt(0, 100);
                    abstractTarget.sendSafe(eventGeneric3);
                }
                eventGeneric.setInt(0, n);
                abstractTarget.sendSafe(eventGeneric);
            }
        }
    }

    public static int convertDSIEntryType2ASLStorageType(int n) {
        int n2;
        switch (n) {
            case 0: 
            case 3: 
            case 4: {
                n2 = 2;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 0;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    public static void updateSelectedContactData(AdbEntry adbEntry, AbstractTarget abstractTarget) {
        PhoneContactsSelectedContactCollector phoneContactsSelectedContactCollector = new PhoneContactsSelectedContactCollector();
        if (adbEntry != null) {
            int n;
            PhoneData[] phoneDataArray = PhoneUtil.ripADBPhoneData(adbEntry.phoneData);
            Object[] objectArray = new PhoneContactsSelectedContactNumberCollector[phoneDataArray.length];
            for (n = 0; n < objectArray.length; ++n) {
                objectArray[n] = new PhoneContactsSelectedContactNumberCollector();
                ((PhoneContactsSelectedContactNumberCollector)objectArray[n]).phoneData = phoneDataArray[n];
                ((PhoneContactsSelectedContactNumberCollector)objectArray[n]).isNumberLocationUnique = false;
                ((PhoneContactsSelectedContactNumberCollector)objectArray[n]).isNumberTypeUnique = false;
            }
            ListManager.getGenericASLList(1189).updateList(objectArray);
            phoneContactsSelectedContactCollector.phone_contacts_selected_contact_company = !Util.isNullOrEmpty(adbEntry.getPersonalData().getOrganization()) ? adbEntry.getPersonalData().getOrganization() : "";
            phoneContactsSelectedContactCollector.phone_contacts_selected_contact_entry_id = adbEntry.getEntryId();
            phoneContactsSelectedContactCollector.phone_contacts_selected_contact_name = !Util.isNullOrEmpty(adbEntry.getCombinedName()) ? adbEntry.getCombinedName() : "";
            phoneContactsSelectedContactCollector.phone_contacts_selected_contact_picture = adbEntry.getPersonalData().getContactPicture();
            phoneContactsSelectedContactCollector.phone_contacts_selected_contact_storage_type = PhoneUtil.convertDSIEntryType2ASLStorageType(adbEntry.getEntryType());
            phoneContactsSelectedContactCollector.phone_contacts_selected_contact_phonetics = "";
            n = !Util.isNullOrEmpty(adbEntry.getPersonalData().getFirstNameSound()) ? 1 : 0;
            boolean bl = !Util.isNullOrEmpty(adbEntry.getPersonalData().getLastNameSound());
            switch (ASLPhoneData.getInstance().addressbookSortOrder) {
                case 2: {
                    phoneContactsSelectedContactCollector.phone_contacts_selected_contact_phonetics = new StringBuffer().append(n != 0 ? adbEntry.getPersonalData().getFirstNameSound() : "").append(n != 0 && bl ? " " : "").append(bl ? adbEntry.getPersonalData().getLastNameSound() : "").toString();
                    break;
                }
                case 1: {
                    phoneContactsSelectedContactCollector.phone_contacts_selected_contact_phonetics = new StringBuffer().append(bl ? adbEntry.getPersonalData().getLastNameSound() : "").append(n != 0 && bl ? " " : "").append(n != 0 ? adbEntry.getPersonalData().getFirstNameSound() : "").toString();
                    break;
                }
                case 3: {
                    phoneContactsSelectedContactCollector.phone_contacts_selected_contact_phonetics = new StringBuffer().append(bl ? adbEntry.getPersonalData().getLastNameSound() : "").append(n != 0 && bl ? ", " : "").append(n != 0 ? adbEntry.getPersonalData().getFirstNameSound() : "").toString();
                    break;
                }
                default: {
                    phoneContactsSelectedContactCollector.phone_contacts_selected_contact_phonetics = "";
                    abstractTarget.error("ADB sorting type not set correctly. Phonetics cannot be concatenated.");
                }
            }
        }
        ListManager.getGenericASLList(1188).updateList(new PhoneContactsSelectedContactCollector[]{phoneContactsSelectedContactCollector});
        ListManager.getGenericASLList(1187).updateList(adbEntry != null ? PhoneUtil.ripADBAddressData(adbEntry.getAddressData()) : new AddressData[]{});
        ListManager.getGenericASLList(1186).updateList(adbEntry != null ? PhoneUtil.ripADBEmailData(adbEntry.getEmailData()) : new EmailData[]{});
        AbstractASLHsmTarget.writeBooleanToDatapool(3229, true);
        if (abstractTarget.isTraceEnabled()) {
            abstractTarget.trace().append("PHONE_CONTACTS_SELECTED_CONTACT_UPDATED_BOOLEAN set to true!").log();
        }
    }

    public static void updateCWStatus(int n) {
        Object[] objectArray = (PhoneSetupCallCallSettingsCollector[])ListManager.getGenericASLList(1211).getDSIObjects();
        switch (n) {
            case 1: {
                objectArray[0].phone_setup_call_call_setting_state_call_waiting = 2;
                break;
            }
            case 0: {
                objectArray[0].phone_setup_call_call_setting_state_call_waiting = 3;
                break;
            }
            default: {
                objectArray[0].phone_setup_call_call_setting_state_call_waiting = 0;
            }
        }
        ListManager.getGenericASLList(1211).updateList(objectArray);
    }

    public static void updateCWStatusRequesting() {
        Object[] objectArray = (PhoneSetupCallCallSettingsCollector[])ListManager.getGenericASLList(1211).getDSIObjects();
        objectArray[0].phone_setup_call_call_setting_state_call_waiting = 1;
        ListManager.getGenericASLList(1211).updateList(objectArray);
    }

    public static void updateCLIRStatus(int n, int n2) {
        Object[] objectArray = (PhoneSetupCallCallSettingsCollector[])ListManager.getGenericASLList(1211).getDSIObjects();
        block0 : switch (n) {
            case 2: {
                objectArray[0].phone_setup_call_call_setting_state_send_calling_id__1 = 2;
                break;
            }
            case 1: {
                objectArray[0].phone_setup_call_call_setting_state_send_calling_id__1 = 3;
                break;
            }
            case 3: {
                objectArray[0].phone_setup_call_call_setting_state_send_calling_id__1 = 1;
                break;
            }
            case 0: {
                switch (n2) {
                    case 4: {
                        objectArray[0].phone_setup_call_call_setting_state_send_calling_id__1 = 2;
                        break block0;
                    }
                    case 3: {
                        objectArray[0].phone_setup_call_call_setting_state_send_calling_id__1 = 3;
                        break block0;
                    }
                }
                objectArray[0].phone_setup_call_call_setting_state_send_calling_id__1 = 0;
                break;
            }
            default: {
                objectArray[0].phone_setup_call_call_setting_state_send_calling_id__1 = 0;
            }
        }
        ListManager.getGenericASLList(1211).updateList(objectArray);
    }

    public static void updateCLIRStatusRequesting() {
        Object[] objectArray = (PhoneSetupCallCallSettingsCollector[])ListManager.getGenericASLList(1211).getDSIObjects();
        objectArray[0].phone_setup_call_call_setting_state_send_calling_id__1 = 1;
        ListManager.getGenericASLList(1211).updateList(objectArray);
    }

    public static void updateCFStatus(CFResponseData[] cFResponseDataArray, CFRequestData[] cFRequestDataArray) {
        if (!Util.isNullOrEmpty(cFResponseDataArray) && !Util.isNullOrEmpty(cFRequestDataArray)) {
            for (int i2 = 0; i2 < cFRequestDataArray.length; ++i2) {
                int n = PhoneUtil.getCallForwardListIdFromDSICFCondition(cFRequestDataArray[i2].getTelCFCondition());
                PhoneSetupCallCallForwardingsCollector phoneSetupCallCallForwardingsCollector = (PhoneSetupCallCallForwardingsCollector)ListManager.getGenericASLList(1210).getRowItem(n);
                if (cFResponseDataArray[i2].result == 4 || cFResponseDataArray[i2].telCFStatus == 2) {
                    phoneSetupCallCallForwardingsCollector.state = 0;
                } else {
                    phoneSetupCallCallForwardingsCollector.number = Util.isNullOrEmpty(cFResponseDataArray[i2].getTelCFNumber()) ? "" : cFResponseDataArray[i2].getTelCFNumber();
                    phoneSetupCallCallForwardingsCollector.state = cFResponseDataArray[i2].telCFStatus == 1 ? 2 : 3;
                }
                ListManager.getGenericASLList(1210).updateListItem(n, phoneSetupCallCallForwardingsCollector);
                if (0 != n) continue;
                AbstractASLHsmTarget.writeBooleanToDatapool(478418176, cFResponseDataArray[i2].telCFStatus == 1);
            }
        }
    }

    public static void updateCFStatus(CFResponseData[] cFResponseDataArray) {
        if (!Util.isNullOrEmpty(cFResponseDataArray)) {
            for (int i2 = 0; i2 < cFResponseDataArray.length; ++i2) {
                int n = PhoneUtil.getCallForwardListIdFromDSICFCondition(cFResponseDataArray[i2].getTelCFCondition());
                if (n == -1) continue;
                PhoneSetupCallCallForwardingsCollector phoneSetupCallCallForwardingsCollector = (PhoneSetupCallCallForwardingsCollector)ListManager.getGenericASLList(1210).getRowItem(n);
                phoneSetupCallCallForwardingsCollector.number = Util.isNullOrEmpty(cFResponseDataArray[i2].getTelCFNumber()) ? "" : cFResponseDataArray[i2].getTelCFNumber();
                phoneSetupCallCallForwardingsCollector.state = cFResponseDataArray[i2].telCFStatus == 1 ? 2 : 3;
                ListManager.getGenericASLList(1210).updateListItem(n, phoneSetupCallCallForwardingsCollector);
            }
        }
    }

    public static void updateCFStatusRequesting(CFRequestData[] cFRequestDataArray) {
        if (!Util.isNullOrEmpty(cFRequestDataArray)) {
            for (int i2 = 0; i2 < cFRequestDataArray.length; ++i2) {
                int n = PhoneUtil.getCallForwardListIdFromDSICFCondition(cFRequestDataArray[i2].getTelCFCondition());
                if (n == -1) continue;
                PhoneSetupCallCallForwardingsCollector phoneSetupCallCallForwardingsCollector = (PhoneSetupCallCallForwardingsCollector)ListManager.getGenericASLList(1210).getRowItem(n);
                phoneSetupCallCallForwardingsCollector.state = 1;
                ListManager.getGenericASLList(1210).updateListItem(n, phoneSetupCallCallForwardingsCollector);
            }
        }
    }

    public static int getCallForwardListIdFromDSICFCondition(int n) {
        int n2 = -1;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            case 3: {
                n2 = 2;
                break;
            }
            case 2: {
                n2 = 3;
                break;
            }
        }
        return n2;
    }

    public static void setMicMuteState(DSIMobileEquipment dSIMobileEquipment, int n) {
        if (n != ASLPhoneData.getInstance().micMuteState) {
            dSIMobileEquipment.requestSetMICMuteState(n);
        }
    }

    public static boolean setTelephoneListStyle(DSIAdbList dSIAdbList, int n, int n2, int n3, boolean bl) {
        if (!bl || n != setTelephoneListStyleFilter || n2 != setTelephoneListStyleLine1 || n3 != setTelephoneListStyleLine2) {
            dSIAdbList.setListStyle(n, n2, n3);
            setTelephoneListStyleFilter = n;
            setTelephoneListStyleLine1 = n2;
            setTelephoneListStyleLine2 = n3;
            return true;
        }
        return false;
    }

    public static void getContactsDetails(AbstractTarget abstractTarget, int n, int n2, long l, boolean bl) {
        if (bl) {
            AbstractASLHsmTarget.writeBooleanToDatapool(3229, false);
            if (abstractTarget.isTraceEnabled()) {
                abstractTarget.trace().append("PHONE_CONTACTS_SELECTED_CONTACT_UPDATED_BOOLEAN set to false!").log();
            }
            PhoneUtil.emptySelectedContact();
        }
        if (abstractTarget.isTraceEnabled()) {
            abstractTarget.trace().append("Contact Details for entry ").append(l).append(" are requested via DSI.").log();
        }
        abstractTarget.send(PhoneUtil.createSingleEntryEvent(n, n2, l));
    }

    public static void emptySelectedContact() {
        PhoneContactsSelectedContactCollector phoneContactsSelectedContactCollector = new PhoneContactsSelectedContactCollector();
        phoneContactsSelectedContactCollector.phone_contacts_selected_contact_company = "";
        phoneContactsSelectedContactCollector.phone_contacts_selected_contact_entry_id = 0L;
        phoneContactsSelectedContactCollector.phone_contacts_selected_contact_name = "";
        phoneContactsSelectedContactCollector.phone_contacts_selected_contact_picture = ASLPhoneContactsPropertyManager.SELECTED_CONTACT__SELECTED_CONTACT_PICTURE__DEFAULT_VALUE;
        phoneContactsSelectedContactCollector.phone_contacts_selected_contact_storage_type = 0;
        ListManager.getGenericASLList(1188).updateList(new PhoneContactsSelectedContactCollector[]{phoneContactsSelectedContactCollector});
        ListManager.getGenericASLList(1189).updateList(new PhoneData[0]);
        ListManager.getGenericASLList(1187).updateList(new AddressData[0]);
        ListManager.getGenericASLList(1186).updateList(new EmailData[0]);
    }

    public static boolean numbersEqual(String string, String string2) {
        return PhoneUtil.trimNumber(string).equals(PhoneUtil.trimNumber(string2));
    }

    public static void setDeviceName(String string) {
        ServiceManager.logger.trace(4, new StringBuffer().append("PhoneUtil.setDeviceName: ").append(string).toString());
        AbstractASLTarget.writeStringToDatapool(3606, string);
        if (!ASLPhoneData.getInstance().adrdlConnected) {
            AbstractASLTarget.writeStringToDatapool(1131, string);
        }
    }

    public static String trimNumber(String string) {
        StringBuilder stringBuilder = new StringBuilder(string.length());
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (string.charAt(i2) == ' ') continue;
            stringBuilder.append(string.charAt(i2));
        }
        return stringBuilder.toString();
    }

    public static void setBTBondingError(int n, String string, String string2, int n2) {
        String string3;
        PhoneBluetoothBondingErrorCollector phoneBluetoothBondingErrorCollector = (PhoneBluetoothBondingErrorCollector)ListManager.getGenericASLList(2855).getRowItem(0);
        phoneBluetoothBondingErrorCollector.phone_bluetooth_bonding_error__7 = n2;
        String string4 = string3 = Util.isNullOrEmpty(string2) ? string : string2;
        if (!Util.isNullOrEmpty(string) && string.equals(currentBTBondingErrorDeviceAddress)) {
            if (!Util.isNullOrEmpty(string2) && phoneBluetoothBondingErrorCollector.phone_bluetooth_bonding_error_device_name.equals("")) {
                phoneBluetoothBondingErrorCollector.phone_bluetooth_bonding_error_device_name = string3;
            }
        } else {
            phoneBluetoothBondingErrorCollector.phone_bluetooth_bonding_error_device_name = string3;
        }
        if (phoneBluetoothBondingErrorCollector.phone_bluetooth_bonding_error_device_name == null) {
            phoneBluetoothBondingErrorCollector.phone_bluetooth_bonding_error_device_name = string3 == null ? "" : string3;
        }
        currentBTBondingErrorDeviceAddress = string;
        phoneBluetoothBondingErrorCollector.phone_bluetooth_bonding_error_profile = (n & n - 1) == 0 ? PhoneUtil.convertServiceTypeDSI2ASL(n) : 0;
        ListManager.getGenericASLList(2855).updateList(new PhoneBluetoothBondingErrorCollector[]{phoneBluetoothBondingErrorCollector});
    }

    public static void checkForKnownNumber(PhoneCallstacksCallstacksCollector phoneCallstacksCallstacksCollector) {
        if (Util.isNullOrEmpty(phoneCallstacksCallstacksCollector.callListEntry.getClNumber())) {
            phoneCallstacksCallstacksCollector.callListEntry.clName = ASLPhoneData.getInstance().localizedUnknownCall;
            return;
        }
        if (phoneCallstacksCallstacksCollector.callListEntry.getAdbEntryID() != 0L && phoneCallstacksCallstacksCollector.callListEntry.getAdbNumberType() != -1 && Util.isBitSet(16, phoneCallstacksCallstacksCollector.callListEntry.getAdbNumberType())) {
            phoneCallstacksCallstacksCollector.callType = 2;
        }
        boolean bl = PhoneUtil.numbersEqual(phoneCallstacksCallstacksCollector.callListEntry.getClNumber(), ASLPhoneData.getInstance().emergencyNumbers.mainEmergencyNumber);
        if (!Util.isNullOrEmpty(ASLPhoneData.getInstance().emergencyNumbers.additionalEmergencyNumber)) {
            for (int i2 = 0; i2 < ASLPhoneData.getInstance().emergencyNumbers.additionalEmergencyNumber.length; ++i2) {
                String string = ASLPhoneData.getInstance().emergencyNumbers.additionalEmergencyNumber[i2];
                if (!PhoneUtil.numbersEqual(phoneCallstacksCallstacksCollector.callListEntry.getClNumber(), string)) continue;
                bl = true;
            }
        }
        if (bl) {
            phoneCallstacksCallstacksCollector.callListEntry.clName = ASLPhoneData.getInstance().localizedEmergencyCall;
            phoneCallstacksCallstacksCollector.callType = 3;
            return;
        }
        if (!Util.isNullOrEmpty(ASLPhoneData.getInstance().mailboxNumber) && PhoneUtil.numbersEqual(phoneCallstacksCallstacksCollector.callListEntry.getClNumber(), ASLPhoneData.getInstance().mailboxNumber) && phoneCallstacksCallstacksCollector.callListEntry.adbEntryID == 0L) {
            phoneCallstacksCallstacksCollector.callListEntry.clName = ASLPhoneData.getInstance().localizedMailboxCall;
            phoneCallstacksCallstacksCollector.callType = 6;
        } else if (ASLPhoneData.getInstance().serviceNumbers != null) {
            if (PhoneUtil.numbersEqual(phoneCallstacksCallstacksCollector.callListEntry.getClNumber(), ASLPhoneData.getInstance().serviceNumbers.breakdownNumber) || PhoneUtil.numbersEqual(phoneCallstacksCallstacksCollector.callListEntry.getClNumber(), ASLPhoneData.getInstance().serviceNumbers.breakdownNumberRoaming)) {
                phoneCallstacksCallstacksCollector.callListEntry.clName = ASLPhoneData.getInstance().localizedServiceCall;
                phoneCallstacksCallstacksCollector.callType = 4;
                return;
            }
            if (PhoneUtil.numbersEqual(phoneCallstacksCallstacksCollector.callListEntry.getClNumber(), ASLPhoneData.getInstance().serviceNumbers.infonumber) || PhoneUtil.numbersEqual(phoneCallstacksCallstacksCollector.callListEntry.getClNumber(), ASLPhoneData.getInstance().serviceNumbers.infonumberRoaming)) {
                phoneCallstacksCallstacksCollector.callListEntry.clName = ASLPhoneData.getInstance().localizedInfoCall;
                phoneCallstacksCallstacksCollector.callType = 5;
                return;
            }
        }
    }

    public static void refreshPhoneSelectionList() {
        ArrayList arrayList = new ArrayList();
        if (ASLPhoneData.getInstance().internalSIMConnected) {
            arrayList.add(new PhoneSelectionPhonePhoneSelectionCollector(null, ASLPhoneData.getInstance().isOtherSIMAvailable ? 1 : 0, 3));
            if (ASLPhoneData.getInstance().isOtherSIMAvailable) {
                arrayList.add(new PhoneSelectionPhonePhoneSelectionCollector(null, 2, 3));
            }
        }
        ConnectedDevice[] connectedDeviceArray = new ConnectedDevice[ASLPhoneData.getInstance().trustedBTDevicesAddresses.size()];
        Collections.sort(ASLPhoneData.getInstance().trustedBTDevicesAddresses);
        Iterator iterator = ASLPhoneData.getInstance().trustedBTDevicesAddresses.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            connectedDeviceArray[n] = (ConnectedDevice)ASLPhoneData.getInstance().trustedBTDevices.get(iterator.next());
            ++n;
        }
        Iterator iterator2 = ASLPhoneData.getInstance().trustedBTDevices.values().iterator();
        String string = "";
        while (iterator2.hasNext()) {
            ConnectedDevice connectedDevice = (ConnectedDevice)iterator2.next();
            if (!PhoneUtil.contains(connectedDevice.connectedServices, 2) && !PhoneUtil.contains(connectedDevice.connectedServices, 4)) continue;
            string = connectedDevice.device.deviceAddress;
        }
        for (int i2 = 0; i2 < connectedDeviceArray.length; ++i2) {
            if ((!PhoneUtil.isPhoneDeviceProfile(connectedDeviceArray[i2].device.getOfferedServiceTypes()) || PhoneUtil.isPhonebookProfile(connectedDeviceArray[i2].device.getActiveServiceTypes()) && !PhoneUtil.isPhoneDeviceProfile(connectedDeviceArray[i2].device.getActiveServiceTypes())) && !connectedDeviceArray[i2].device.deviceAddress.equals(string)) continue;
            int n2 = 0;
            if (Util.isAnyBitSet(4, connectedDeviceArray[i2].device.activeServiceTypes)) {
                n2 = ASLPhoneData.getInstance().isOtherSIMAvailable ? 1 : 0;
            }
            PhoneSelectionPhonePhoneSelectionCollector phoneSelectionPhonePhoneSelectionCollector = new PhoneSelectionPhonePhoneSelectionCollector(connectedDeviceArray[i2], n2, Util.isAnyBitSet(4, connectedDeviceArray[i2].device.activeServiceTypes) ? 2 : 1);
            if (phoneSelectionPhonePhoneSelectionCollector.deviceType == 2 && phoneSelectionPhonePhoneSelectionCollector.simMode != 2) {
                if ((ASLPhoneData.getInstance().telMode == 2 || ASLPhoneData.getInstance().telModeAssociated == 2) && ASLPhoneData.getInstance().isOtherSIMAvailable) {
                    phoneSelectionPhonePhoneSelectionCollector.simMode = 1;
                    arrayList.add(new PhoneSelectionPhonePhoneSelectionCollector(phoneSelectionPhonePhoneSelectionCollector.connectedDevice, 2, 2));
                } else {
                    phoneSelectionPhonePhoneSelectionCollector.simMode = 0;
                }
            }
            if (ServiceManager.logger.isTraceEnabled(4)) {
                ServiceManager.logger.trace(4).append("add to phone profile list: ").append(connectedDeviceArray[i2].device.getDeviceName()).append(": activeProfiles: 0x").append(Integer.toHexString(connectedDeviceArray[i2].device.getActiveServiceTypes())).log();
            }
            arrayList.add(phoneSelectionPhonePhoneSelectionCollector);
        }
        ListManager.getGenericASLList(1198).updateList(arrayList.toArray(new PhoneSelectionPhonePhoneSelectionCollector[arrayList.size()]));
    }

    public static int removeADRDLProfileIfSIMNotInserted(int n, String string) {
        ConnectedDevice connectedDevice = (ConnectedDevice)ASLPhoneData.getInstance().trustedBTDevices.get(string);
        if (ASLPhoneData.getInstance().internalSIMConnected && connectedDevice != null && !PhoneUtil.isPhoneProfile(connectedDevice.device.getActiveServiceTypes())) {
            return n;
        }
        if (Util.isBitSet(32, n)) {
            n -= 32;
        }
        return n;
    }

    public static void setFreeLine() {
        ASLPhoneData.getInstance().maxCallLines = Util.isBitSet(8, ASLPhoneData.getInstance().getCurrentCallsTelFeat()) ? 2 : 1;
        AbstractASLHsmTarget.writeBooleanToDatapool(1157, ASLPhoneData.getInstance().usedCallLines < ASLPhoneData.getInstance().maxCallLines);
    }

    public static boolean getFreeLine() {
        ASLPhoneData.getInstance().maxCallLines = Util.isBitSet(8, ASLPhoneData.getInstance().getCurrentCallsTelFeat()) ? 2 : 1;
        return ASLPhoneData.getInstance().usedCallLines < ASLPhoneData.getInstance().maxCallLines;
    }

    public static void setNetworkingAvailable() {
        boolean bl;
        boolean bl2 = false;
        boolean bl3 = bl = ASLPhoneData.getInstance().nadLockState == 2 || ASLPhoneData.getInstance().nadLockState == 3 || ASLPhoneData.getInstance().nadLockState == 5 || ASLPhoneData.getInstance().nadLockState == 1 || ASLPhoneData.getInstance().nadLockState == 11;
        if (ASLPhoneData.getInstance().nadMode == 1 && ASLPhoneData.getInstance().lockState == 2 || ASLPhoneData.getInstance().nadMode == 2 && bl) {
            bl2 = true;
        }
        AbstractASLHsmTarget.writeBooleanToDatapool(3697, bl2);
    }

    public static void reportDeviceConnected(AbstractTarget abstractTarget) {
        ASLPhoneData.getInstance().requestedService = 1;
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(139);
        abstractTarget.sendSafe(ServiceManager.mGenericEventFactory.newEvent(abstractTarget.getTargetId(), 5259, -1762773504));
    }

    public static int getDeviceRole(int n, int n2) {
        if (n2 == 2 || n2 == 4) {
            return n == 1 || ASLPhoneData.getInstance().nadPrimary && ASLPhoneData.getInstance().internalSIMConnected || PhoneUtil.isAssociatedPhoneSameAsTheOneToBeConnected() ? 2 : 1;
        }
        return 0;
    }

    public static void sendBluetoothInquiryRunning(AbstractTarget abstractTarget, boolean bl) {
        if (bl) {
            if (sendBTInquiryRunningCounter++ == 0) {
                abstractTarget.trace(new StringBuffer().append("send BT_INQUIRY_RUNNING (").append(bl).append(")").toString());
                EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1745996288);
                eventGeneric.setBoolean(0, bl);
                abstractTarget.send(eventGeneric);
            }
        } else if (--sendBTInquiryRunningCounter == 0) {
            abstractTarget.trace(new StringBuffer().append("send BT_INQUIRY_RUNNING (").append(bl).append(")").toString());
            EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1745996288);
            eventGeneric.setBoolean(0, bl);
            abstractTarget.send(eventGeneric);
        }
        if (sendBTInquiryRunningCounter < 0) {
            abstractTarget.error("More BT_INQUIRY_RUNNING sent with false, than with true! Counter reset to 0");
            sendBTInquiryRunningCounter = 0;
        }
    }

    public static boolean isAdditionalConnectionPossibleAndFreeToConnect(int n) {
        return 2 == n && !PhoneUtil.isAssocPhoneConnected() && !PhoneUtil.isInsertedSimAssociated() || 4 == n && !PhoneUtil.isAssocPhoneConnected() && !ASLPhoneData.getInstance().internalSIMConnected;
    }

    public static boolean setConnectionPossibleDPValues(int n) {
        boolean bl = PhoneUtil.isServiceFreeToConnect(n);
        AbstractASLHsmTarget.writeBooleanToDatapool(1139, bl);
        boolean bl2 = PhoneUtil.isAdditionalConnectionPossibleAndFreeToConnect(n);
        AbstractASLHsmTarget.writeBooleanToDatapool(-712829696, bl2);
        if (ServiceManager.logger.isTraceEnabled(4)) {
            ServiceManager.logger.trace(4).append("SELECTED_PROFILE_CONNECTION_POSSIBLE: ").append(bl).append(", SELECTED_PROFILE_SECOND_CONNECTION_POSSIBLE: ").append(bl2).log();
        }
        return bl;
    }

    public static boolean isServiceFreeToConnect(int n) {
        if (PhoneUtil.isMediaProfile(n)) {
            return !PhoneUtil.isMediaConnected();
        }
        if (PhoneUtil.isPhonebookProfile(n)) {
            return !PhoneUtil.isPhonebookConnected();
        }
        if (PhoneUtil.isPhoneProfile(n)) {
            return !PhoneUtil.isPrioPhoneConnected() && !PhoneUtil.isInsertedSimPrimary() || !PhoneUtil.isAssocPhoneConnected() && PhoneUtil.isInsertedSimPrimary() || PhoneUtil.isAssociatedPhoneSameAsTheOneToBeConnected() || PhoneUtil.isPrimaryPhoneSameAsTheOneToBeConnected();
        }
        return false;
    }

    private static boolean isAssociatedPhoneSameAsTheOneToBeConnected() {
        IntObjectOptHashMap intObjectOptHashMap = ASLPhoneData.getInstance().connectedBTDevicesASL;
        return intObjectOptHashMap.containsKey(3) && ASLPhoneData.getInstance().selectedDeviceMAC.equals(((ConnectedDeviceASL)intObjectOptHashMap.get((int)3)).currentlyConnectedMAC);
    }

    private static boolean isPrimaryPhoneSameAsTheOneToBeConnected() {
        IntObjectOptHashMap intObjectOptHashMap = ASLPhoneData.getInstance().connectedBTDevicesASL;
        return intObjectOptHashMap.containsKey(0) && ASLPhoneData.getInstance().selectedDeviceMAC.equals(((ConnectedDeviceASL)intObjectOptHashMap.get((int)0)).currentlyConnectedMAC);
    }

    private static boolean isInsertedSimPrimary() {
        return ASLPhoneData.getInstance().nadPrimary && ASLPhoneData.getInstance().internalSIMConnected;
    }

    private static boolean isInsertedSimAssociated() {
        return ASLPhoneData.getInstance().nadSecondary && ASLPhoneData.getInstance().internalSIMConnected;
    }

    private static boolean isPhonebookConnected() {
        IntObjectOptHashMap intObjectOptHashMap = ASLPhoneData.getInstance().connectedBTDevicesASL;
        if (intObjectOptHashMap == null) {
            return false;
        }
        return intObjectOptHashMap.containsKey(2);
    }

    private static boolean isMediaConnected() {
        IntObjectOptHashMap intObjectOptHashMap = ASLPhoneData.getInstance().connectedBTDevicesASL;
        if (intObjectOptHashMap == null) {
            return false;
        }
        return intObjectOptHashMap.containsKey(1);
    }

    private static boolean isPrioPhoneConnected() {
        IntObjectOptHashMap intObjectOptHashMap = ASLPhoneData.getInstance().connectedBTDevicesASL;
        if (intObjectOptHashMap == null) {
            return false;
        }
        return intObjectOptHashMap.containsKey(0) && !ASLPhoneData.getInstance().selectedDeviceMAC.equals(((ConnectedDeviceASL)intObjectOptHashMap.get((int)0)).currentlyConnectedMAC);
    }

    private static boolean isAssocPhoneConnected() {
        IntObjectOptHashMap intObjectOptHashMap = ASLPhoneData.getInstance().connectedBTDevicesASL;
        if (intObjectOptHashMap == null) {
            return false;
        }
        return intObjectOptHashMap.containsKey(3) && !ASLPhoneData.getInstance().selectedDeviceMAC.equals(((ConnectedDeviceASL)intObjectOptHashMap.get((int)3)).currentlyConnectedMAC);
    }

    private static boolean isAssocPhoneSimap() {
        IntObjectOptHashMap intObjectOptHashMap = ASLPhoneData.getInstance().connectedBTDevicesASL;
        if (intObjectOptHashMap == null) {
            return false;
        }
        return intObjectOptHashMap.containsKey(3) && Util.isBitSet(4, ((ConnectedDeviceASL)intObjectOptHashMap.get((int)3)).currentlyConnectedService);
    }

    private static boolean isPrioPhoneSimap() {
        IntObjectOptHashMap intObjectOptHashMap = ASLPhoneData.getInstance().connectedBTDevicesASL;
        if (intObjectOptHashMap == null) {
            return false;
        }
        return intObjectOptHashMap.containsKey(0) && Util.isBitSet(4, ((ConnectedDeviceASL)intObjectOptHashMap.get((int)0)).currentlyConnectedService);
    }

    public static String replaceNullByEmptyString(String string) {
        return string == null ? "" : string;
    }

    public static boolean hasCurrentHfpPhoneEnhancedCallCapability(int n) {
        return Util.isBitSet(16, ASLPhoneData.getInstance().getCurrentCallsTelFeat()) || Util.isBitSet(64, ASLPhoneData.getInstance().getCurrentCallsTelFeat()) || Util.isBitSet(8, ASLPhoneData.getInstance().getCurrentCallsTelFeat()) || n != 3;
    }

    public static boolean isSimapTemporarilyAvailable() {
        return ASLPhoneData.getInstance().nadEnabledPhone > 0 && (Util.isBitSet(4, ASLPhoneData.getInstance().supportedProfiles) || ASLPhoneData.getInstance().carPlayConnected);
    }

    public static String getNadModeStr(int n) {
        switch (n) {
            case 0: {
                return "INVALID";
            }
            case 1: {
                return "VOICE_DATA";
            }
            case 2: {
                return "DATA_ONLY";
            }
            case 3: {
                return "VOICE_ONLY";
            }
        }
        return new StringBuffer().append("UNKNOWN (").append(Integer.toString(n)).append(", should not happen)").toString();
    }

    public static int getCallBoxFirstButtonState(PhoneCallInformationCollector phoneCallInformationCollector) {
        CallInformation callInformation = phoneCallInformationCollector.callInformation;
        if (callInformation.getTelCallType() == 4) {
            switch (phoneCallInformationCollector.conferenceCallState) {
                case 4: {
                    return 4;
                }
                case 6: {
                    return 1;
                }
                case 8: {
                    return 5;
                }
            }
            return 0;
        }
        switch (callInformation.telCallState) {
            case 3: {
                if (phoneCallInformationCollector.replace && !PhoneUtil.hasCurrentHfpPhoneEnhancedCallCapability(phoneCallInformationCollector.mobileEquipment.getTelMode())) {
                    return 2;
                }
                if (ASLPhoneData.getInstance().carPlayCallActive && ASLPhoneData.getInstance().carPlayConnected) {
                    return 2;
                }
                return 0;
            }
            case 6: {
                return 1;
            }
            case 4: {
                if (phoneCallInformationCollector.joinPossible && !ASLPhoneData.getInstance().conferenceCallMaxedOut && (Util.isBitSet(16, ASLPhoneData.getInstance().getCurrentCallsTelFeat()) || Util.isBitSet(64, ASLPhoneData.getInstance().getCurrentCallsTelFeat()) || phoneCallInformationCollector.mobileEquipment.getTelMode() != 3)) {
                    return 3;
                }
                return 4;
            }
        }
        return 0;
    }

    public static int getCallBoxSecondButtonState(PhoneCallInformationCollector phoneCallInformationCollector) {
        switch (phoneCallInformationCollector.callInformation.telCallState) {
            case 3: {
                return Util.isBitSet(4, ASLPhoneData.getInstance().getCurrentCallsTelFeat()) ? 3 : 0;
            }
            case 1: 
            case 2: 
            case 4: {
                if (phoneCallInformationCollector.mobileEquipment.isHandsFreeMode() || phoneCallInformationCollector.mobileEquipment.getTelMode() != 3) {
                    return 1;
                }
                return 2;
            }
        }
        return 0;
    }

    public static boolean isCallBoxHangupButtonAvailable(PhoneCallInformationCollector phoneCallInformationCollector) {
        return ASLPhoneData.getInstance().getCurrentCallsTelMode() != 3 || phoneCallInformationCollector.callInformation.getTelCallState() != 6 || ASLPhoneData.getInstance().numberOfCallBoxes <= 1;
    }

    public static boolean isCallBoxSecondButtonAvailable(PhoneCallInformationCollector phoneCallInformationCollector) {
        switch (phoneCallInformationCollector.callInformation.telCallState) {
            case 3: {
                return !ASLPhoneData.getInstance().callInformationCollectors.isMultipleCalls() && !ASLPhoneData.getInstance().carPlayCallActive;
            }
            case 4: {
                return true;
            }
        }
        return false;
    }

    public static String[] filterDuplicatedEmergencyNumbers(EmergencyNumbers emergencyNumbers) {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < emergencyNumbers.additionalEmergencyNumber.length; ++i2) {
            if (hashSet.contains(emergencyNumbers.additionalEmergencyNumber[i2]) || emergencyNumbers.mainEmergencyNumber.equals(emergencyNumbers.additionalEmergencyNumber[i2])) continue;
            hashSet.add(emergencyNumbers.additionalEmergencyNumber[i2]);
        }
        return (String[])hashSet.toArray(new String[hashSet.size()]);
    }

    public static String filterWidgetMarkers(String string) {
        StringBuilder stringBuilder = new StringBuilder(string.length());
        for (int i2 = 0; i2 < string.length(); ++i2) {
            if (string.charAt(i2) == '\u0086' || string.charAt(i2) == '\u0087') continue;
            stringBuilder.append(string.charAt(i2));
        }
        return stringBuilder.toString();
    }

    static {
        DISC_DEV_LIST = new HashMap();
        discDeviceCount = 0;
        discDeviceAddressList = new ArrayList(50);
        requestedPhoneAudioConnection = 0;
        initialRequestWasSent = false;
        setTelephoneListStyleFilter = -1;
        setTelephoneListStyleLine1 = -1;
        setTelephoneListStyleLine2 = -1;
        currentBTBondingErrorDeviceAddress = "";
        sendBTInquiryRunningCounter = 0;
    }
}

