/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

import com.ibm.oti.vm.MsgHelp;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.security.Policy;
import java.security.PrivilegedAction;
import java.security.Security;
import java.util.Locale;
import java.util.ResourceBundle;

public class PriviAction
implements PrivilegedAction {
    private int action;
    private static final int GET_SYSTEM_PROPERTY;
    private static final int GET_SECURITY_POLICY;
    private static final int SET_ACCESSIBLE;
    private static final int GET_SECURITY_PROPERTY;
    private static final int LOAD_MESSAGES;
    private static final int GET_BUNDLE;
    private String stringArg1;
    private String stringArg2;
    private AccessibleObject accessible;
    private Locale locale;

    public static PrivilegedAction getSecurityProperty(String string) {
        return new PriviAction(4, string);
    }

    public static PrivilegedAction loadMessages(String string) {
        return new PriviAction(5, string);
    }

    private PriviAction(int n, String string) {
        this.action = n;
        this.stringArg1 = string;
    }

    public PriviAction() {
        this.action = 2;
    }

    public PriviAction(AccessibleObject accessibleObject) {
        this.action = 3;
        this.accessible = accessibleObject;
    }

    public PriviAction(String string) {
        this.action = 1;
        this.stringArg1 = string;
    }

    public PriviAction(String string, String string2) {
        this.action = 1;
        this.stringArg1 = string;
        this.stringArg2 = string2;
    }

    public PriviAction(String string, Locale locale) {
        this.action = 6;
        this.stringArg1 = string;
        this.locale = locale;
    }

    @Override
    public Object run() {
        switch (this.action) {
            case 1: {
                return System.getProperty(this.stringArg1, this.stringArg2);
            }
            case 4: {
                return Security.getProperty(this.stringArg1);
            }
            case 2: {
                return Policy.getPolicy();
            }
            case 5: {
                try {
                    return MsgHelp.loadMessages(this.stringArg1);
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                    return null;
                }
            }
            case 6: {
                return ResourceBundle.getBundle(this.stringArg1, this.locale);
            }
            case 3: {
                this.accessible.setAccessible(true);
            }
        }
        return null;
    }
}

