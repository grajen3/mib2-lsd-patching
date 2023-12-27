/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.smartphoneintegration.common;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.smartphoneintegration.common.DeviceASLExtended;
import de.vw.mib.asl.internal.smartphoneintegration.common.FeatureSupport;
import de.vw.mib.asl.internal.smartphoneintegration.common.SmartPhoneIntegrationGlobalProperyAccessor;
import de.vw.mib.asl.internal.smartphoneintegration.target.HsmTarget;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import java.util.ArrayList;
import org.dsi.ifc.smartphoneintegration.Device;

public final class SmartPhoneIntegrationHelper {
    public static String classname = "SmartPhoneIntegration.Helper";
    private static HsmTarget target;
    public static final int TESTCASE_OCU_TRIGGERED_DISCONNECT_RECONNECT;
    public static final int TESTCASE_OCU_SERVICECALL_ACTIVE_INACTIVE;
    public static final int TESTCASE_OCU_EMERGENCYCALL_ACTIVE_INACTIVE;

    public static void setTarget(HsmTarget hsmTarget) {
        target = hsmTarget;
    }

    public static HsmTarget getTarget() {
        return target;
    }

    public static DeviceASLExtended getDeviceFromId(int n) {
        DeviceASLExtended[] deviceASLExtendedArray = SmartPhoneIntegrationGlobalProperyAccessor.getInstance().getDsiDevicelistASLExtended();
        if (deviceASLExtendedArray != null) {
            for (int i2 = 0; i2 < deviceASLExtendedArray.length; ++i2) {
                if (deviceASLExtendedArray[i2].getDeviceID() != n) continue;
                return deviceASLExtendedArray[i2];
            }
        }
        return null;
    }

    public static DeviceASLExtended getDeviceFromAdress(String string) {
        DeviceASLExtended[] deviceASLExtendedArray = SmartPhoneIntegrationGlobalProperyAccessor.getInstance().getDsiDevicelistASLExtended();
        if (deviceASLExtendedArray != null) {
            for (int i2 = 0; i2 < deviceASLExtendedArray.length; ++i2) {
                if (!deviceASLExtendedArray[i2].getDeviceAddress().equalsIgnoreCase(string)) continue;
                return deviceASLExtendedArray[i2];
            }
        }
        return null;
    }

    public static DeviceASLExtended getDeviceFromListIndex(int n) {
        DeviceASLExtended[] deviceASLExtendedArray = SmartPhoneIntegrationGlobalProperyAccessor.getInstance().getDsiDevicelistASLExtended();
        if (deviceASLExtendedArray != null && deviceASLExtendedArray.length >= n && !SmartPhoneIntegrationGlobalProperyAccessor.getInstance().isBusResetActive()) {
            return deviceASLExtendedArray[n];
        }
        return null;
    }

    public static DeviceASLExtended findFirstCommonDeviceByAdress(DeviceASLExtended[] deviceASLExtendedArray, DeviceASLExtended[] deviceASLExtendedArray2) {
        for (int i2 = 0; !Util.isNullOrEmpty(deviceASLExtendedArray) && i2 < deviceASLExtendedArray.length; ++i2) {
            for (int i3 = 0; !Util.isNullOrEmpty(deviceASLExtendedArray2) && i3 < deviceASLExtendedArray2.length; ++i3) {
                if (SmartPhoneIntegrationHelper.getTarget().isTraceEnabled()) {
                    SmartPhoneIntegrationHelper.getTarget().trace().append(classname).append(new StringBuffer().append(".findFirstCommonDeviceByAdress(list1[").append(i2).append("] =").toString()).append(deviceASLExtendedArray[i2].getDeviceAddress()).append(new StringBuffer().append(" , list2[").append(i3).append("] =").toString()).append(new StringBuffer().append(SmartPhoneIntegrationHelper.shortAdress(deviceASLExtendedArray2[i3].getDeviceAddress())).append(")").toString()).log();
                }
                if (deviceASLExtendedArray[i2] == null || deviceASLExtendedArray[i2].getDsiDevice() == null || deviceASLExtendedArray2[i3] == null || deviceASLExtendedArray[i2].getDeviceAddress().compareTo(deviceASLExtendedArray2[i3].getDeviceAddress()) != 0) continue;
                deviceASLExtendedArray[i2].getDsiDevice().deviceName = deviceASLExtendedArray2[i3].getDeviceName();
                deviceASLExtendedArray[i2].getDsiDevice().deviceID = deviceASLExtendedArray2[i3].getDeviceID();
                return deviceASLExtendedArray[i2];
            }
        }
        return null;
    }

    public static boolean listContainsDeviceWithAddress(DeviceASLExtended[] deviceASLExtendedArray, String string) {
        if (Util.isNullOrEmpty(string) || Util.isNullOrEmpty(deviceASLExtendedArray)) {
            return false;
        }
        for (int i2 = 0; i2 < deviceASLExtendedArray.length; ++i2) {
            String string2;
            if (deviceASLExtendedArray[i2] == null || (string2 = deviceASLExtendedArray[i2].getDeviceAddress()) == null || !string.equalsIgnoreCase(string2)) continue;
            return true;
        }
        if (SmartPhoneIntegrationHelper.getTarget().isTraceEnabled()) {
            SmartPhoneIntegrationHelper.getTarget().trace().append(classname).append(".listContainsDeviceWithAddress == false").log();
        }
        return false;
    }

    public static Device findFirstNewDevice(DeviceASLExtended[] deviceASLExtendedArray, Device[] deviceArray) {
        boolean bl = false;
        for (int i2 = 0; !Util.isNullOrEmpty(deviceArray) && i2 < deviceArray.length; ++i2) {
            for (int i3 = 0; !Util.isNullOrEmpty(deviceASLExtendedArray) && i3 < deviceASLExtendedArray.length; ++i3) {
                if (deviceASLExtendedArray[i3].getDeviceAddress().equalsIgnoreCase(deviceArray[i2].getDeviceAddress())) {
                    bl = true;
                    if (deviceASLExtendedArray[i3].getConnectionMethod() != deviceArray[i2].getConnectionMethod()) {
                        bl = false;
                    }
                }
                if (!SmartPhoneIntegrationHelper.getTarget().isTraceEnabled()) continue;
                LogMessage logMessage = SmartPhoneIntegrationHelper.getTarget().trace();
                logMessage.append(classname).append(".findFirstNewDevice( compare: ").append(new StringBuffer().append("olddevices[").append(i3).append("] ").append(deviceASLExtendedArray[i3].toString()).toString()).append(new StringBuffer().append(" == new devices[").append(i2).append("] ").append(deviceArray[i2].toString()).toString()).append(" )").log();
            }
            if (!bl) {
                if (SmartPhoneIntegrationHelper.getTarget().isTraceEnabled()) {
                    LogMessage logMessage = SmartPhoneIntegrationHelper.getTarget().trace();
                    logMessage.append(classname).append(".findFirstNewDevice( found: ").append(deviceArray[i2].toString()).append(" )").log();
                }
                return deviceArray[i2];
            }
            bl = false;
        }
        if (SmartPhoneIntegrationHelper.getTarget().isTraceEnabled()) {
            SmartPhoneIntegrationHelper.getTarget().trace().append(classname).append(".findFirstNewDevice(found null)").log();
        }
        return null;
    }

    public static DeviceASLExtended[] findAllNewDevices(DeviceASLExtended[] deviceASLExtendedArray, Device[] deviceArray) {
        boolean bl = false;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; !Util.isNullOrEmpty(deviceArray) && i2 < deviceArray.length; ++i2) {
            for (int i3 = 0; !Util.isNullOrEmpty(deviceASLExtendedArray) && i3 < deviceASLExtendedArray.length; ++i3) {
                if (deviceASLExtendedArray[i3].getDeviceAddress().equalsIgnoreCase(deviceArray[i2].getDeviceAddress())) {
                    bl = true;
                    if (deviceASLExtendedArray[i3].getConnectionMethod() != deviceArray[i2].getConnectionMethod()) {
                        bl = false;
                    }
                }
                if (!SmartPhoneIntegrationHelper.getTarget().isTraceEnabled()) continue;
                LogMessage logMessage = SmartPhoneIntegrationHelper.getTarget().trace();
                logMessage.append(classname).append(".findAllNewDevices( compare: ").append(new StringBuffer().append("olddevices[").append(i3).append("] ").append(deviceASLExtendedArray[i3].toString()).toString()).append(new StringBuffer().append(" == new devices[").append(i2).append("] ").append(deviceArray[i2].toString()).toString()).append(" )").log();
            }
            if (!bl) {
                if (SmartPhoneIntegrationHelper.getTarget().isTraceEnabled()) {
                    LogMessage logMessage = SmartPhoneIntegrationHelper.getTarget().trace();
                    logMessage.append(classname).append(".findAllNewDevices( found: ").append(deviceArray[i2].toString()).append(" )").log();
                }
                arrayList.add(new DeviceASLExtended(deviceArray[i2]));
            }
            bl = false;
        }
        if (SmartPhoneIntegrationHelper.getTarget().isTraceEnabled()) {
            SmartPhoneIntegrationHelper.getTarget().trace().append(classname).append(new StringBuffer().append(".findAllNewDevices(Result: found ").append(arrayList.size()).append(" new devices )").toString()).log();
        }
        Object[] objectArray = new DeviceASLExtended[arrayList.size()];
        return (DeviceASLExtended[])arrayList.toArray(objectArray);
    }

    public static boolean checkLastNewDeviceRemoved(Device device, Device[] deviceArray) {
        if (device == null || device.deviceID == -1) {
            if (SmartPhoneIntegrationHelper.getTarget().isTraceEnabled()) {
                LogMessage logMessage = SmartPhoneIntegrationHelper.getTarget().trace();
                logMessage.append(classname).append(".checkLastNewDeviceRemoved( null: ").append(" )").log();
            }
            return false;
        }
        for (int i2 = 0; !Util.isNullOrEmpty(deviceArray) && i2 < deviceArray.length; ++i2) {
            if (SmartPhoneIntegrationHelper.getTarget().isTraceEnabled()) {
                LogMessage logMessage = SmartPhoneIntegrationHelper.getTarget().trace();
                logMessage.append(classname).append(".checkLastNewDeviceRemoved( compare: ").append(new StringBuffer().append(" == new devices[").append(i2).append("] ").append(deviceArray[i2].toString()).toString()).append(new StringBuffer().append("lastnewdevice ").append(SmartPhoneIntegrationHelper.shortAdress(device.getDeviceAddress())).toString()).append(" )").log();
            }
            if (!device.getDeviceAddress().equalsIgnoreCase(deviceArray[i2].getDeviceAddress())) continue;
            return false;
        }
        return true;
    }

    public static boolean isAppleDevice(DeviceASLExtended deviceASLExtended) {
        return SmartPhoneIntegrationHelper.isConnectionMethodSupported(deviceASLExtended.getConnectionMethod(), 2) || SmartPhoneIntegrationHelper.isConnectionMethodSupported(deviceASLExtended.getConnectionMethod(), 4) || SmartPhoneIntegrationHelper.isConnectionMethodSupported(deviceASLExtended.getConnectionMethod(), 16);
    }

    public static boolean isConnectionMethodSupported(int n, int n2) {
        return (n & n2) == n2;
    }

    public static boolean isSWaPSupported(int n, int n2) {
        return (n & n2) == n2;
    }

    public static int convertConnectionMethod(int n) {
        switch (n) {
            case 2: {
                return 2;
            }
            case 4: {
                return 2;
            }
            case 8: {
                return 3;
            }
            case 1: {
                return 1;
            }
            case 32: {
                return 4;
            }
        }
        return 0;
    }

    public static String shortAdress(String string) {
        if (string.length() == 0) {
            return "empty";
        }
        return (String)string.subSequence(string.length() > 5 ? string.length() - 5 : 0, string.length());
    }

    public static boolean checkForNotVerifiedCarPlayDevices(Device[] deviceArray) {
        if (SmartPhoneIntegrationHelper.getTarget().isTraceEnabled()) {
            LogMessage logMessage = SmartPhoneIntegrationHelper.getTarget().trace();
            logMessage.append(classname).append(".checkForNotVerifiedCarPlayDevices( )").log();
        }
        for (int i2 = 0; i2 < deviceArray.length; ++i2) {
            Device device = deviceArray[i2];
            if (device.connectionMethod != 2) continue;
            if (SmartPhoneIntegrationHelper.getTarget().isTraceEnabled()) {
                LogMessage logMessage = SmartPhoneIntegrationHelper.getTarget().trace();
                logMessage.append(classname).append(".checkForNotVerifiedCarPlayDevices(found:  ").append(device.getDeviceName()).append(" )").log();
            }
            return true;
        }
        return false;
    }

    public static EventGeneric TestASLInterfaceCommunication(int n, int n2) {
        EventGeneric eventGeneric = null;
        switch (n) {
            case 0: {
                if (n2 == 0) {
                    if (SmartPhoneIntegrationHelper.getTarget().isTraceEnabled()) {
                        LogMessage logMessage = SmartPhoneIntegrationHelper.getTarget().trace();
                        logMessage.append(classname).append(".TestASLEWCommunication(trigger ASL_SMARTPHONEINTEGRATION_OCU_DISCONNECT_CURRENT_DEVICE )").log();
                    }
                    eventGeneric = ServiceManager.mGenericEventFactory.newEvent(705977600);
                    break;
                }
                if (n2 != 1) break;
                if (SmartPhoneIntegrationHelper.getTarget().isTraceEnabled()) {
                    LogMessage logMessage = SmartPhoneIntegrationHelper.getTarget().trace();
                    logMessage.append(classname).append(".TestASLEWCommunication(trigger ASL_SMARTPHONEINTEGRATION_OCU_RECONNECT_CURRENT_DEVICE )").log();
                }
                eventGeneric = ServiceManager.mGenericEventFactory.newEvent(689200384);
                break;
            }
            case 1: {
                if (SmartPhoneIntegrationHelper.getTarget().isTraceEnabled()) {
                    LogMessage logMessage = SmartPhoneIntegrationHelper.getTarget().trace();
                    logMessage.append(classname).append(".TestASLEWCommunication(trigger ASL_SOUND_AUDIO_CONNECTION_STARTED/RELEASED_P0_CONNECTION )").log();
                }
                if (n2 == 0) {
                    eventGeneric = ServiceManager.mGenericEventFactory.newEvent(403258624);
                    eventGeneric.setInt(0, 227);
                    break;
                }
                if (n2 != 1) break;
                eventGeneric = ServiceManager.mGenericEventFactory.newEvent(252263680);
                eventGeneric.setInt(0, 227);
                break;
            }
        }
        return eventGeneric;
    }

    public static int convertModelToDsiConnectionmethod(int n) {
        if (n == 0) {
            return 8;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 4;
        }
        if (n == 3) {
            return 32;
        }
        return -1;
    }

    public static Device[] filterDSIDeviceList(Device[] deviceArray, FeatureSupport featureSupport) {
        if (SmartPhoneIntegrationHelper.getTarget().isTraceEnabled()) {
            SmartPhoneIntegrationHelper.getTarget().trace().append(new StringBuffer().append("SmartPhoneIntegrationHelper.filterDSIDeviceList(list.length=").append(deviceArray.length).append(", ").toString()).append(featureSupport.toString()).log();
        }
        if (!Util.isNullOrEmpty(deviceArray)) {
            int n;
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < deviceArray.length; ++i2) {
                n = 0;
                if (SmartPhoneIntegrationHelper.isConnectionMethodSupported(deviceArray[i2].getConnectionMethod(), 4) || SmartPhoneIntegrationHelper.isConnectionMethodSupported(deviceArray[i2].getConnectionMethod(), 2)) {
                    n = 1;
                    if (!featureSupport.getCarplay().isCoded()) {
                        deviceArray[i2].connectionMethod &= 0xFFFFFFFD;
                        deviceArray[i2].connectionMethod &= 0xFFFFFFFB;
                    }
                }
                if (SmartPhoneIntegrationHelper.getTarget().isTraceEnabled()) {
                    SmartPhoneIntegrationHelper.getTarget().trace().append("CheckCarLifeSupport!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                }
                if (SmartPhoneIntegrationHelper.isConnectionMethodSupported(deviceArray[i2].getConnectionMethod(), 32)) {
                    if (n != 0) {
                        if (!featureSupport.getCarlifeIOS().isCoded()) {
                            deviceArray[i2].connectionMethod &= 0xFFFFFFDF;
                        }
                    } else if (!featureSupport.getCarlifeAndroid().isCoded()) {
                        deviceArray[i2].connectionMethod &= 0xFFFFFFDF;
                    }
                }
                if (SmartPhoneIntegrationHelper.isConnectionMethodSupported(deviceArray[i2].getConnectionMethod(), 8) && !featureSupport.getGal().isCoded()) {
                    deviceArray[i2].connectionMethod &= 0xFFFFFFF7;
                }
                if (SmartPhoneIntegrationHelper.isConnectionMethodSupported(deviceArray[i2].getConnectionMethod(), 1) && !featureSupport.getMirrorlink().isCoded()) {
                    deviceArray[i2].connectionMethod &= 0xFFFFFFFE;
                }
                if (!(SmartPhoneIntegrationHelper.isConnectionMethodSupported(deviceArray[i2].getConnectionMethod(), 8) || SmartPhoneIntegrationHelper.isConnectionMethodSupported(deviceArray[i2].getConnectionMethod(), 1) || SmartPhoneIntegrationHelper.isConnectionMethodSupported(deviceArray[i2].getConnectionMethod(), 2) || SmartPhoneIntegrationHelper.isConnectionMethodSupported(deviceArray[i2].getConnectionMethod(), 4) || SmartPhoneIntegrationHelper.isConnectionMethodSupported(deviceArray[i2].getConnectionMethod(), 32))) {
                    if (!SmartPhoneIntegrationHelper.getTarget().isTraceEnabled()) continue;
                    SmartPhoneIntegrationHelper.getTarget().trace().append(new StringBuffer().append("SmartPhoneIntegrationHelper.filterDSIDeviceList(list=").append(deviceArray[i2].getDeviceName()).append(" ").append(deviceArray[i2].getConnectionMethod()).toString()).append(" was removed ").log();
                    continue;
                }
                arrayList.add(deviceArray[i2]);
            }
            Device[] deviceArray2 = new Device[arrayList.size()];
            for (n = 0; n < arrayList.size(); ++n) {
                deviceArray2[n] = (Device)arrayList.get(n);
                if (!SmartPhoneIntegrationHelper.getTarget().isTraceEnabled()) continue;
                SmartPhoneIntegrationHelper.getTarget().trace().append(new StringBuffer().append("SmartPhoneIntegrationHelper.filterDSIDeviceList(list=").append(deviceArray2[n].getDeviceName()).append(" ").append(deviceArray2[n].getConnectionMethod()).toString()).log();
            }
            return deviceArray2;
        }
        return deviceArray;
    }

    public static int numberOfTechnologySupportedDevices(int n, DeviceASLExtended[] deviceASLExtendedArray) {
        int n2 = 0;
        if (deviceASLExtendedArray == null || deviceASLExtendedArray.length == 0) {
            return 0;
        }
        for (int i2 = 0; i2 < deviceASLExtendedArray.length; ++i2) {
            if (deviceASLExtendedArray[i2] == null || !SmartPhoneIntegrationHelper.isConnectionMethodSupported(deviceASLExtendedArray[i2].getConnectionMethod(), n)) continue;
            ++n2;
        }
        if (SmartPhoneIntegrationHelper.getTarget().isTraceEnabled()) {
            SmartPhoneIntegrationHelper.getTarget().trace().append(classname).append(new StringBuffer().append(".numberOfTechnologySupportedDevices(").append(n2).append(")").toString()).log();
        }
        return n2;
    }
}

