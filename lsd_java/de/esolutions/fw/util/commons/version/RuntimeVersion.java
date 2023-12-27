/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.version;

import de.esolutions.fw.util.commons.version.VersionTag;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class RuntimeVersion {
    public static String getVersionFromClassAndGetter(String string, String string2) {
        try {
            Class clazz = Class.forName(string);
            Method method = clazz.getMethod(string2, null);
            Object object = method.invoke(null, null);
            if (object instanceof String) {
                return (String)object;
            }
            return null;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    public static VersionTag[] getAllVersionTagsFromClass(String string) {
        try {
            Class clazz = Class.forName(string);
            Field[] fieldArray = clazz.getFields();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < fieldArray.length; ++i2) {
                int n;
                Field field = fieldArray[i2];
                int n2 = field.getModifiers();
                if ((n2 & (n = 25)) != n) continue;
                String string2 = field.getName();
                Object object = field.get(null);
                if (!(object instanceof String)) continue;
                String string3 = (String)object;
                arrayList.add(new VersionTag(string2, string3));
            }
            Object[] objectArray = new VersionTag[arrayList.size()];
            arrayList.toArray(objectArray);
            return objectArray;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    public static String getVersionTagFromClass(String string, String string2) {
        VersionTag[] versionTagArray = RuntimeVersion.getAllVersionTagsFromClass(string);
        if (versionTagArray == null) {
            return null;
        }
        for (int i2 = 0; i2 < versionTagArray.length; ++i2) {
            VersionTag versionTag = versionTagArray[i2];
            if (!versionTag.getName().equals(string2)) continue;
            return versionTag.getValue();
        }
        return null;
    }

    public static String getFWVersion() {
        return RuntimeVersion.getVersionTagFromClass("de.esolutions.fw.util.commons.version.VersionInfo", "FRAMEWORK_VERSION");
    }

    public static String getDSIifcFullVersion() {
        return RuntimeVersion.getVersionFromClassAndGetter("org.dsi.ifc.VersionInfo", "asString");
    }

    public static String getDSIifcBuildDate() {
        return RuntimeVersion.getVersionFromClassAndGetter("org.dsi.ifc.VersionInfo", "getBuildDate");
    }

    public static String getDSIifcVersion() {
        return RuntimeVersion.getVersionFromClassAndGetter("org.dsi.ifc.VersionInfo", "getVersion");
    }

    public static String getDSIifcNickname() {
        return RuntimeVersion.getVersionFromClassAndGetter("org.dsi.ifc.VersionInfo", "getNickname");
    }

    public static String getDSIifcName() {
        return RuntimeVersion.getVersionFromClassAndGetter("org.dsi.ifc.VersionInfo", "getName");
    }

    public static String getDSIifcVendor() {
        return RuntimeVersion.getVersionFromClassAndGetter("org.dsi.ifc.VersionInfo", "getVendor");
    }
}

