/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.profilchanger.automat;

public class DsiUtil {
    private DsiUtil() {
    }

    public static String getSimpleClassName(Class clazz) {
        if (clazz == null) {
            return "null";
        }
        String string = clazz.getName();
        int n = string.lastIndexOf(46);
        return string.substring(n + 1);
    }

    public static String getNameOfProfileState(int n) {
        switch (n) {
            case 0: {
                return "PROFILESTATE_ACTION_SUCCESSFUL";
            }
            case 1: {
                return "PROFILESTATE_CHANGE_NOT_READY";
            }
            case 2: {
                return "PROFILESTATE_CHANGE_READY";
            }
            case 1024: {
                return "PROFILESTATE_ERROR";
            }
        }
        return Integer.toString(n);
    }
}

