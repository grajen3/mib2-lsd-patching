/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navservicesapi;

import org.dsi.ifc.base.DSIBase;

public interface DSINavAsiaBAPClusterInstrument
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_COMPASSINFO;
    public static final int ATTR_RGSTATUS;
    public static final int ATTR_DISTANCETONEXTMANEUVER;
    public static final int ATTR_CURRENTPOSITIONINFO;
    public static final int ATTR_TURNTOINFO;
    public static final int ATTR_DISTANCETODESTINATION;
    public static final int ATTR_MANEUVERDESCRIPTOR;
    public static final int ATTR_LANEGUIDANCE;
    public static final int ATTR_VOICEGUIDANCESTATE;
    public static final int ATTR_INFOSTATES;
    public static final int ATTR_TRAFFICBLOCKINDICATION;
    public static final int ATTR_DMLASTDESTINATIONSLIST;
    public static final int ATTR_NAVANNOUNCEMENTSTATE;
    public static final int ATTR_TRAFFICINFORMATION;
    public static final int ATTR_NAVIGATIONTIMEINFOTYPE;
    public static final int ATTR_RTT;
    public static final int ATTR_ETA;
    public static final int ATTR_CITYNAME;
    public static final int ATTR_SEMIDYNROUTE;
    public static final int ATTR_TRAFFICOFFSET;
    public static final int RT_STARTROUTEGUIDANCE;
    public static final int RT_STOPROUTEGUIDANCE;
    public static final int RT_REPEATLASTNAVANNOUNCEMENT;
    public static final int RT_SETVOICEGUIDANCESTATE;
    public static final int RT_SETACTIVERGTYPE;
    public static final int RT_CONFIRMTRAFFICINFOMESSAGE;
    public static final int RT_DMLASTDESTINATIONSGET;
    public static final int RT_ABORTCURRENTNAVANNOUNCEMENT;
    public static final int RP_ROUTEGUIDANCEACTDEACTRESULT;
    public static final int RP_REPEATLASTNAVANNOUNCEMENTRESULT;
    public static final int RP_SETACTIVERGTYPERESULT;
    public static final int RP_DMLASTDESTINATIONSGETRESULT;

    default public void startRouteGuidance(int n, long l) {
    }

    default public void stopRouteGuidance() {
    }

    default public void repeatLastNavAnnouncement() {
    }

    default public void abortCurrentNavAnnouncement() {
    }

    default public void setVoiceGuidanceState(int n) {
    }

    default public void setActiveRGType(int n) {
    }

    default public void confirmTrafficInfoMessage(int n) {
    }

    default public void dmLastDestinationsGet(long l) {
    }
}

