/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navservicesapi;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.navservicesapi.AddressDataSDIS;

public interface DSINavAsiaSDIS
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_ROUTEGUIDANCEACTIVE;
    public static final int ATTR_CARPOSITION;
    public static final int ATTR_DESTINATIONINFO;
    public static final int ATTR_NEXTDESTINATIONINFO;
    public static final int RT_STARTGUIDANCETODESTINATIONS;
    public static final int RP_STARTGUIDANCETODESTINATIONSRESULT;
    public static final int STARTGUIDANCERESULT_OK;
    public static final int STARTGUIDANCERESULT_NOT_OPERABLE;
    public static final int STARTGUIDANCERESULT_ERROR;
    public static final int STARTGUIDANCERESULT_UNSUPPORTED;

    default public void startGuidanceToDestinations(AddressDataSDIS[] addressDataSDISArray) {
    }
}

