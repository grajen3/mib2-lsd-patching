/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.diagnose;

import org.dsi.ifc.base.DSIBase;

public interface DSIComponentProtection
extends DSIBase {
    public static final String VERSION;
    public static final int CONSTANTS_CONSTANT1;
    public static final int CONSTANTS_CONSTANT2;
    public static final int ENCRYPTIONOPTION_COMPONENTBASE;
    public static final int ENCRYPTIONOPTION_COMPONENTANDCARBASE;
    public static final int RT_AUTHSTRING;
    public static final int RP_AUTHSTRINGRESPONSE;

    default public void authString(String string, int n, int n2) {
    }
}

