/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.base.DSIBase;

public interface DSIAdbInit
extends DSIBase {
    public static final String VERSION;
    public static final int RT_SETDEFAULTPUBLICPROFILEVISIBILITY;
    public static final int RT_SETMAXLOCALENTRIES;
    public static final int RT_SETMAXPHONEENTRIES;
    public static final int RT_SETMAXTOPDESTENTRIES;
    public static final int RT_SETMAXSPEEDDIALENTRIES;
    public static final int RT_SETNUMERICALSPELLERENABLED;
    public static final int RT_SETAUTOPROFILEALLOCATION;
    public static final int RT_FINALIZECONFIGURATION;
    public static final int RT_SETSPEEDDIALTYPE;
    public static final int RT_SETPROFILEHANDLINGTYPE;
    public static final int RT_SETDEFAULTSORTORDER;
    public static final int RT_SETONLINEDESTINATIONENABLED;
    public static final int RT_SETDEFAULTSOSBUTTON;
    public static final int ATTR_DEFAULTPUBLICPROFILEVISIBILITY;
    public static final int ATTR_MAXLOCALENTRIES;
    public static final int ATTR_MAXPHONEENTRIES;
    public static final int ATTR_MAXTOPDESTENTRIES;
    public static final int ATTR_MAXSPEEDDIALENTRIES;
    public static final int ATTR_AUTOPROFILEALLOCATION;
    public static final int ATTR_DEFAULTSOSBUTTON;
    public static final int RP_SETDEFAULTPUBLICPROFILEVISIBILITYRESULT;
    public static final int RP_SETMAXLOCALENTRIESRESULT;
    public static final int RP_SETMAXPHONEENTRIESRESULT;
    public static final int RP_SETMAXTOPDESTENTRIESRESULT;
    public static final int RP_SETMAXSPEEDDIALENTRIESRESULT;
    public static final int RP_SETAUTOPROFILEALLOCATIONRESULT;
    public static final int RP_SETNUMERICALSPELLERENABLEDRESULT;
    public static final int RP_SETSPEEDDIALTYPERESULT;
    public static final int RP_SETPROFILEHANDLINGTYPE;
    public static final int RP_SETDEFAULTSORTORDERRESULT;
    public static final int RP_SETONLINEDESTINATIONENABLEDRESULT;
    public static final int RP_SETDEFAULTSOSBUTTONRESULT;

    default public void setDefaultPublicProfileVisibility(boolean bl) {
    }

    default public void setMaxLocalEntries(int n) {
    }

    default public void setMaxPhoneEntries(int n) {
    }

    default public void setMaxTopDestEntries(int n) {
    }

    default public void setMaxSpeedDialEntries(int n) {
    }

    default public void setNumericalSpellerEnabled(boolean bl) {
    }

    default public void setAutoProfileAllocation(boolean bl) {
    }

    default public void finalizeConfiguration() {
    }

    default public void setSpeedDialType(int n) {
    }

    default public void setProfileHandlingType(int n) {
    }

    default public void setDefaultSortOrder(int n) {
    }

    default public void setOnlineDestinationEnabled(boolean bl) {
    }

    default public void setDefaultSOSButton(boolean bl) {
    }
}

