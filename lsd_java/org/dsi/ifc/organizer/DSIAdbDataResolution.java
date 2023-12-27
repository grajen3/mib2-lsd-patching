/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.base.DSIBase;

public interface DSIAdbDataResolution
extends DSIBase {
    public static final String VERSION;
    public static final int RT_RESOLVEMAILADDRESSES;
    public static final int RT_RESOLVEPHONENUMBERS;
    public static final int RP_RESOLVEMAILADDRESSRESULT;
    public static final int RP_RESOLVEPHONENUMBERSRESULT;

    default public void resolveMailAddresses(String[] stringArray) {
    }

    default public void resolvePhoneNumbers(String[] stringArray) {
    }
}

