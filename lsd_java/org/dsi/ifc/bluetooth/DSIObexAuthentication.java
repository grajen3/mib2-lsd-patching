/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.bluetooth;

import org.dsi.ifc.base.DSIBase;

public interface DSIObexAuthentication
extends DSIBase {
    public static final String VERSION;
    public static final int RT_SETAUTHENTICATIONINFO;
    public static final int IN_AUTHENTICATIONREQUIRED;
    public static final int IN_INDAUTHENTICATION;

    default public void setAuthenticationInfo(int n, String string, String string2) {
    }
}

