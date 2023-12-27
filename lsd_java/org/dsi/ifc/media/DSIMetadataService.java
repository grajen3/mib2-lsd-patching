/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.media.CoverartInfo;

public interface DSIMetadataService
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_ONLINELOOKUPSTATUS;
    public static final int RT_REQUESTCOVERART;
    public static final int RT_DISABLEONLINELOOKUP;
    public static final int RT_ENABLEONLINELOOKUP;
    public static final int RP_RESPONSECOVERART;
    public static final int ONLINELOOKUP_UNKNOWN;
    public static final int ONLINELOOKUP_ENABLED;
    public static final int ONLINELOOKUP_DISABLED;

    default public void requestCoverArt(int n, CoverartInfo coverartInfo) {
    }

    default public void disableOnlineLookup() {
    }

    default public void enableOnlineLookup() {
    }
}

