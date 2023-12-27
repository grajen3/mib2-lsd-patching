/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.list;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import org.dsi.ifc.travellink.GenericProperty;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class GenericPropertyTraces {
    public static String getData(GenericPropertyContainer[] genericPropertyContainerArray) {
        if (genericPropertyContainerArray != null && genericPropertyContainerArray.length > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
                if (genericPropertyContainerArray[i2] == null) continue;
                stringBuffer.append(genericPropertyContainerArray[i2].toString());
            }
            return stringBuffer.toString();
        }
        return "Data is null !";
    }

    public static String getData(GenericProperty[] genericPropertyArray) {
        if (genericPropertyArray != null && genericPropertyArray.length > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < genericPropertyArray.length; ++i2) {
                if (genericPropertyArray[i2] == null) continue;
                stringBuffer.append(genericPropertyArray[i2].toString());
            }
            return stringBuffer.toString();
        }
        return "Data is null !";
    }

    public static void printData(GenericProperty[] genericPropertyArray) {
        if (genericPropertyArray != null && genericPropertyArray.length > 0) {
            for (int i2 = 0; i2 < genericPropertyArray.length; ++i2) {
                if (genericPropertyArray[i2] == null || !ServiceManager.logger2.isTraceEnabled(2)) continue;
                ServiceManager.logger2.trace(2).append(genericPropertyArray[i2].toString()).log();
            }
        } else if (genericPropertyArray == null && ServiceManager.logger2.isTraceEnabled(2)) {
            ServiceManager.logger2.error(2).append("Parameter is null !").log();
        }
    }

    public static void printData(GenericPropertyContainer[] genericPropertyContainerArray) {
        if (ServiceManager.logger2.isTraceEnabled(2) || ServiceManager.logger2.isTraceEnabled(8)) {
            if (genericPropertyContainerArray != null && genericPropertyContainerArray.length > 0) {
                for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
                    if (genericPropertyContainerArray[i2] == null) continue;
                    ServiceManager.logger2.trace(2).append(genericPropertyContainerArray[i2].toString()).log();
                }
            } else {
                ServiceManager.logger2.error(2).append("Received Data is null !").log();
            }
        }
    }
}

