/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc;

import java.lang.reflect.Field;

public final class VersionInfo {
    static /* synthetic */ Class class$java$lang$String;

    public static String getDSIServiceVersion(Class clazz) {
        try {
            Field field = clazz.getField("VERSION");
            if ((class$java$lang$String == null ? (class$java$lang$String = VersionInfo.class$("java.lang.String")) : class$java$lang$String).equals(field.getType())) {
                return (String)field.get(null);
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return null;
    }

    public static String getName() {
        return "MIB_DSI_2016_KW28";
    }

    public static String getNickname() {
        return "B2.67";
    }

    public static String getVersion() {
        return "16.28.0";
    }

    public static String getBuildDate() {
        return "14.07.2016 15:31";
    }

    public static String getVendor() {
        return "Volkswagen AG";
    }

    public static String asString() {
        return "DSI-16.28.0.E20160714-b2_67";
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

