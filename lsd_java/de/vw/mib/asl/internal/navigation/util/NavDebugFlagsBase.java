/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.datapool.ASLDatapool;
import java.lang.reflect.Field;
import org.osgi.framework.ServiceReference;

public class NavDebugFlagsBase {
    private static ASLDatapool dpInstance;
    static /* synthetic */ Class class$generated$de$vw$mib$asl$internal$navigation$debug$ASLNavigationDebugListenerConstants;
    static /* synthetic */ Class class$de$vw$mib$datapool$ASLDatapool;

    private static ASLDatapool getDatapool() {
        if (dpInstance == null) {
            ServiceReference serviceReference = ServiceManager.bundleContext.getServiceReference((class$de$vw$mib$datapool$ASLDatapool == null ? (class$de$vw$mib$datapool$ASLDatapool = NavDebugFlagsBase.class$("de.vw.mib.datapool.ASLDatapool")) : class$de$vw$mib$datapool$ASLDatapool).getName());
            if (serviceReference == null) {
                return null;
            }
            dpInstance = (ASLDatapool)ServiceManager.bundleContext.getService(serviceReference);
        }
        return dpInstance;
    }

    public static boolean getAPIDebugFlag(int n) {
        ASLDatapool aSLDatapool = NavDebugFlagsBase.getDatapool();
        if (aSLDatapool != null) {
            return aSLDatapool.getBoolean(n, false);
        }
        return false;
    }

    public static void setAPIDebugFlag(int n, boolean bl) {
        ServiceManager.aslPropertyManager.valueChangedBoolean(n, bl);
    }

    public static void setASLDebugFlag(String string, boolean bl) {
        System.setProperty(string, bl ? "true" : "false");
    }

    public static boolean getASLDebugFlag(String string) {
        return "true".equals(System.getProperty(string));
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        Field[] fieldArray = (class$generated$de$vw$mib$asl$internal$navigation$debug$ASLNavigationDebugListenerConstants == null ? (class$generated$de$vw$mib$asl$internal$navigation$debug$ASLNavigationDebugListenerConstants = NavDebugFlagsBase.class$("generated.de.vw.mib.asl.internal.navigation.debug.ASLNavigationDebugListenerConstants")) : class$generated$de$vw$mib$asl$internal$navigation$debug$ASLNavigationDebugListenerConstants).getFields();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < fieldArray.length; ++i2) {
            stringBuffer.setLength(0);
            stringBuffer.append("NAV_DEBUG_FLAG_");
            stringBuffer.append(fieldArray[i2].getName());
            String string = stringBuffer.toString();
            if (System.getProperty(string) == null) continue;
            try {
                int n = fieldArray[i2].getInt(null);
                if ("true".equals(System.getProperty(string))) {
                    ServiceManager.aslPropertyManager.valueChangedBoolean(n, true);
                    continue;
                }
                if (!"false".equals(System.getProperty(string))) continue;
                ServiceManager.aslPropertyManager.valueChangedBoolean(n, false);
                continue;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        dpInstance = null;
    }
}

