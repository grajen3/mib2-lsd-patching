/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.diag;

import de.esolutions.fw.comm.agent.diag.IInfoBase;
import de.esolutions.fw.comm.agent.diag.InfoStream;
import de.esolutions.fw.comm.agent.diag.InfoUtils$1;
import de.esolutions.fw.comm.agent.diag.PrintUtils;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.ServiceUUID;
import de.esolutions.fw.util.commons.Buffer;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class InfoUtils {
    public static boolean matchServiceUUID(String string, ServiceUUID serviceUUID) {
        String string2;
        if (serviceUUID == null) {
            return false;
        }
        if (string == null) {
            return true;
        }
        String string3 = serviceUUID.toString().toLowerCase();
        if (string3.equals(string2 = string.toLowerCase())) {
            return true;
        }
        return string3.startsWith(string2);
    }

    public static boolean matchServiceInstanceID(String string, ServiceInstanceID serviceInstanceID) {
        if (serviceInstanceID == null) {
            return false;
        }
        if (string == null) {
            return true;
        }
        if (InfoUtils.matchServiceUUID(string, serviceInstanceID.getServiceUUID())) {
            return true;
        }
        String string2 = serviceInstanceID.getDescription();
        if (string2 != null) {
            String string3;
            String string4 = string2.toLowerCase();
            if (string4.equals(string3 = string.toLowerCase())) {
                return true;
            }
            if (string4.indexOf(string3) != -1) {
                return true;
            }
        }
        return false;
    }

    public static boolean matchInfo(String string, IInfoBase iInfoBase) {
        if (iInfoBase == null) {
            return false;
        }
        if (string == null || string.length() == 0) {
            return true;
        }
        try {
            int n = Integer.parseInt(string);
            if (n == iInfoBase.getID()) {
                return true;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        ServiceInstanceID serviceInstanceID = iInfoBase.getServiceInstanceID();
        return serviceInstanceID != null && InfoUtils.matchServiceInstanceID(string, serviceInstanceID);
    }

    public static IInfoBase[] pickInfos(String[] stringArray, IInfoBase[] iInfoBaseArray) {
        if (iInfoBaseArray == null) {
            return null;
        }
        if (stringArray == null || stringArray.length == 0) {
            return iInfoBaseArray;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            String string = stringArray[i2];
            for (int i3 = 0; i3 < iInfoBaseArray.length; ++i3) {
                IInfoBase iInfoBase = iInfoBaseArray[i3];
                if (!InfoUtils.matchInfo(string, iInfoBase)) continue;
                arrayList.add(iInfoBase);
            }
        }
        Object[] objectArray = new IInfoBase[arrayList.size()];
        arrayList.toArray(objectArray);
        return objectArray;
    }

    public static void printInfos(IInfoBase[] iInfoBaseArray, InfoStream infoStream) {
        if (iInfoBaseArray != null && iInfoBaseArray.length > 0) {
            infoStream.begin(new StringBuffer().append(iInfoBaseArray[0].getSimpleClassName()).append(": total=").append(iInfoBaseArray.length).toString());
            if (infoStream.isBrief()) {
                String[] stringArray = InfoUtils.getFieldNames(super.getClass());
                for (int i2 = 0; i2 < stringArray.length; ++i2) {
                    infoStream.print(new StringBuffer().append(i2).append("=").append(stringArray[i2]).toString());
                }
            }
            for (int i3 = 0; i3 < iInfoBaseArray.length; ++i3) {
                iInfoBaseArray[i3].write(infoStream);
            }
            infoStream.end();
        } else {
            infoStream.print("No entries found.");
        }
    }

    private static String[] getFieldNames(Class clazz) {
        Field[] fieldArray = clazz.getFields();
        String[] stringArray = new String[fieldArray.length];
        for (int i2 = 0; i2 < fieldArray.length; ++i2) {
            String string;
            Field field = fieldArray[i2];
            stringArray[i2] = string = field.getName();
        }
        return stringArray;
    }

    public static void printInfoIDs(IInfoBase[] iInfoBaseArray, PrintStream printStream) {
        Buffer buffer = new Buffer();
        PrintUtils.printArrayToBuffer(buffer, iInfoBaseArray, new InfoUtils$1());
        printStream.println(buffer.toString());
    }
}

