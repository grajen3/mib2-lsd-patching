/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mirrorlink.helper;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;
import org.dsi.ifc.mirrorlink.Application;
import org.dsi.ifc.mirrorlink.Device;
import org.dsi.ifc.mirrorlink.Event;

public final class MirrorlinkHelper {
    private static final String BT_MAC;
    private static final char END_CHAR;
    private static final char EQUALS;

    public static boolean compareApplication(Application application, Application application2) {
        return application != null && application2 != null && application.getAppID() == application2.getAppID();
    }

    public static boolean compareTouchEventCoordinates(Event[] eventArray, Event[] eventArray2) {
        if (eventArray == null && eventArray2 == null) {
            return true;
        }
        if (eventArray == null || eventArray2 == null) {
            return false;
        }
        if (eventArray.length != eventArray2.length) {
            return false;
        }
        boolean bl = true;
        for (int i2 = 0; i2 < eventArray.length; ++i2) {
            bl &= eventArray[i2].getXPosition() == eventArray2[i2].getXPosition() && eventArray[i2].getYPosition() == eventArray2[i2].getYPosition();
        }
        return bl;
    }

    public static int convertCurrentAudiosourceAslGetter2lSetterValue(int n) {
        int n2 = 2;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
        }
        return n2;
    }

    public static int convertDisplayOrientationAslGetter2lSetterValue(int n) {
        int n2 = 0;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
        }
        return n2;
    }

    public static int convertCurrentConnectionTypeAslGetter2lSetterValue(int n) {
        int n2 = 2;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
        }
        return n2;
    }

    public static int convertSpellerAlphabetTypeAslSetter2GetterValue(int n) {
        int n2 = 0;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            default: {
                n2 = -1;
            }
        }
        return n2;
    }

    public static String getBTMACFromDeviceAddress(String string) {
        int n;
        String string2 = "";
        if (!Util.isNullOrEmpty(string) && (n = (string = string.trim()).indexOf("[BT_MAC=")) > -1) {
            string2 = string.substring(n);
            string2 = string2.substring(string2.indexOf(61) + 1, string2.indexOf(93));
        }
        if (ServiceManager.logger2.isTraceEnabled(4)) {
            LogMessage logMessage = ServiceManager.logger2.trace(4);
            logMessage.append("MirrorLinkHelper").append(".getBTMACFromDeviceAddress(").append(string != null ? string : "NULL").append(new StringBuffer().append(" ) -> returns = ").append(string2).toString()).log();
        }
        return string2;
    }

    public static String getBTMACFromDeviceAddress(Device device) {
        if (device != null) {
            return MirrorlinkHelper.getBTMACFromDeviceAddress(device.getDeviceAddress());
        }
        return "";
    }
}

