/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.base.DSIBase;

public interface DSIAdbSds
extends DSIBase {
    public static final String VERSION;
    public static final int RT_GETALLVOICETAGS;
    public static final int RT_DELETEVOICETAGS;
    public static final int RP_GETALLVOICETAGSRESULT;
    public static final int RP_DELETEVOICETAGSRESULT;

    default public void getAllVoiceTags() {
    }

    default public void deleteVoiceTags(int[] nArray) {
    }
}

