/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.exboxm;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.exboxm.ConnectionControl;
import org.dsi.ifc.exboxm.MobileDeviceLinkStatus;
import org.dsi.ifc.exboxm.PublicDeviceAddress;

public interface DSIExBoxM
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_AUDIOREQUEST;
    public static final int ATTR_DISPLAYREQUEST;
    public static final int ATTR_OPERATIONSTATE;
    public static final int ATTR_ACTIVESOURCETYPE;
    public static final int ATTR_CURRENTSTATIONINFO;
    public static final int ATTR_MOBILEDEVICELINKSTATUS;
    public static final int ATTR_PUBLICDEVICEADDRESS;
    public static final int RT_DISPLAYCONTROL;
    public static final int RT_DISPLAYCURRENTVOLUME;
    public static final int RT_AUDIOREQUESTREJECTED;
    public static final int RT_DISPLAYREQUESTREJECTED;
    public static final int RT_VOLUMERANGE;
    public static final int RT_RESETTOFACTORY;
    public static final int RT_SETMOBILEDEVICELINK;
    public static final int RT_REQUESTCONNECTIONCONTROL;
    public static final int RP_RESPONSEDISPLAYCONTROL;
    public static final int RP_RESPONSEVOLUMERANGE;
    public static final int RP_RESPONSERESETTOFACTORY;
    public static final int RP_RESPONSECONNECTIONCONTROL;

    default public void displayControl(int n) {
    }

    default public void displayCurrentVolume(int n, int n2) {
    }

    default public void audioRequestRejected(int n, int n2) {
    }

    default public void displayRequestRejected(int n) {
    }

    default public void volumeRange(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
    }

    default public void resetToFactory() {
    }

    default public void setMobileDeviceLink(MobileDeviceLinkStatus mobileDeviceLinkStatus) {
    }

    default public void requestConnectionControl(ConnectionControl connectionControl, PublicDeviceAddress publicDeviceAddress) {
    }
}

