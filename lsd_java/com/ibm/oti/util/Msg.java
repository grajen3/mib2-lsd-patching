/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

import com.ibm.oti.util.PriviAction;
import com.ibm.oti.vm.MsgHelp;
import java.security.AccessController;
import java.util.Hashtable;

public class Msg {
    private static Hashtable messages = null;

    static {
        messages = (Hashtable)AccessController.doPrivileged(PriviAction.loadMessages("com/ibm/oti/util/ExternalMessages"));
    }

    public static String getString(String string) {
        if (messages == null) {
            return string;
        }
        String string2 = (String)messages.get(string);
        if (string2 == null) {
            return string;
        }
        return string2;
    }

    public static String getString(String string, Object object) {
        return Msg.getString(string, new Object[]{object});
    }

    public static String getString(String string, int n) {
        return Msg.getString(string, new Object[]{Integer.toString(n)});
    }

    public static String getString(String string, char c2) {
        return Msg.getString(string, new Object[]{String.valueOf(c2)});
    }

    public static String getString(String string, Object object, Object object2) {
        return Msg.getString(string, new Object[]{object, object2});
    }

    public static String getString(String string, Object[] objectArray) {
        String string2 = string;
        if (messages != null && (string2 = (String)messages.get(string)) == null) {
            string2 = string;
        }
        return MsgHelp.format(string2, objectArray);
    }
}

