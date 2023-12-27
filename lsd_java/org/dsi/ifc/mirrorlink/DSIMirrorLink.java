/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.mirrorlink;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.mirrorlink.ClientCapabilities;
import org.dsi.ifc.mirrorlink.Event;

public interface DSIMirrorLink
extends DSIBase {
    public static final String VERSION;
    public static final int ATTR_DISCOVEREDDEVICES;
    public static final int ATTR_DEVICECONNECTIONSTATUS;
    public static final int ATTR_DEVICESOFTKEYS;
    public static final int ATTR_APPLICATIONSTATUS;
    public static final int ATTR_SCREENORIENTATION;
    public static final int ATTR_SHOWKEYBOARD;
    public static final int ATTR_SCREENORIENTATIONAVAILABLE;
    public static final int ATTR_SCREENROTATIONAVAILABLE;
    public static final int ATTR_AUDIOCONNECTIONREQUESTED;
    public static final int ATTR_AVAILABLEAPPLICATIONSLIST;
    public static final int ATTR_SINGLEAPPLICATIONMODE;
    public static final int ATTR_PHONEVIEWAVAILABLE;
    public static final int ATTR_UNCERTIFIEDCONTENT;
    public static final int ATTR_DEVICESTATUS;
    public static final int ATTR_SWAPSTATUS;
    public static final int ATTR_SHOWNOTIFICATION;
    public static final int ATTR_NOTIFICATIONSERVICEENABLED;
    public static final int ATTR_LOCATIONDATASERVICESENABLED;
    public static final int ATTR_SWITCHTOCLIENTNATIVEUI;
    public static final int RT_REQUESTCLIENTCAPABILITIES;
    public static final int RT_REQUESTACCESSMODE;
    public static final int RT_REQUESTDAYNIGHTMODE;
    public static final int RT_REQUESTUSABLEVIEWPORT;
    public static final int RT_REQUESTCONNECTDEVICE;
    public static final int RT_REQUESTDISCONNECTDEVICE;
    public static final int RT_REQUESTROTATESCREEN;
    public static final int RT_REQUESTCHANGEORIENTATION;
    public static final int RT_REQUESTSOFTKEYEVENT;
    public static final int RT_REQUESTLAUNCHAPP;
    public static final int RT_REQUESTTERMINATEAPP;
    public static final int RT_REQUESTSTARTSPELLER;
    public static final int RT_REQUESTADDSPELLERCHARS;
    public static final int RT_REQUESTREMOVESPELLERCHAR;
    public static final int RT_REQUESTCLEARSPELLER;
    public static final int RT_REQUESTSENDSTRING;
    public static final int RT_REQUESTAUDIOOPTION;
    public static final int RT_REQUESTAUDIOCONNECTIONAUDIBLE;
    public static final int RT_REQUESTSENDTOUCHEVENTS;
    public static final int RT_REQUESTCONTEXTVISIBLE;
    public static final int RT_REQUESTKEYBOARDMODE;
    public static final int RT_REQUESTAVAILABLEAPPLICATIONSWINDOW;
    public static final int RT_REQUESTDISPLAYKEYBOARD;
    public static final int RT_REQUESTDISMISSHMIKEYBOARD;
    public static final int RT_REQUESTFACTORYSETTINGS;
    public static final int RT_REQUESTPHONEVIEW;
    public static final int RT_REQUESTCONTEXTSWITCHED;
    public static final int RT_INVOKENOTIACTION;
    public static final int RT_REQUESTNOTIFICATIONSERVICEENABLED;
    public static final int RT_REQUESTLOCATIONDATASERVICESENABLED;
    public static final int RP_RESPONSECLIENTCAPABILITIES;
    public static final int RP_RESPONSEACCESSMODE;
    public static final int RP_RESPONSEDAYNIGHTMODE;
    public static final int RP_RESPONSEUSABLEVIEWPORT;
    public static final int RP_RESPONSECONTEXTVISIBLE;
    public static final int RP_RESPONSECONNECTDEVICE;
    public static final int RP_RESPONSEDISCONNECTDEVICE;
    public static final int RP_RESPONSEROTATESCREEN;
    public static final int RP_RESPONSESOFTKEYEVENT;
    public static final int RP_RESPONSELAUNCHAPP;
    public static final int RP_RESPONSETERMINATEAPP;
    public static final int RP_RESPONSESPELLERRESULT;
    public static final int RP_RESPONSESENDSTRING;
    public static final int RP_RESPONSEAUDIOOPTION;
    public static final int RP_RESPONSEAUDIOCONNECTIONAUDIBLE;
    public static final int RP_RESPONSESENDTOUCHEVENTS;
    public static final int RP_RESPONSEKEYBOARDMODE;
    public static final int RP_RESPONSEAVAILABLEAPPLICATIONSWINDOW;
    public static final int RP_RESPONSEDISPLAYKEYBOARD;
    public static final int RP_RESPONSEDISMISSHMIKEYBOARD;
    public static final int RP_RESPONSEFACTORYSETTINGS;
    public static final int RP_RESPONSEPHONEVIEW;
    public static final int RP_RESPONSECONTEXTSWITCHED;

    default public void requestClientCapabilities(ClientCapabilities clientCapabilities) {
    }

    default public void requestAccessMode(int n) {
    }

    default public void requestDayNightMode(int n) {
    }

    default public void requestUsableViewport(int n, int n2, int n3, int n4) {
    }

    default public void requestContextVisible(boolean bl) {
    }

    default public void requestConnectDevice(int n) {
    }

    default public void requestDisconnectDevice(int n) {
    }

    default public void requestRotateScreen(int n) {
    }

    default public void requestChangeOrientation(int n) {
    }

    default public void requestSoftKeyEvent(int n, int n2) {
    }

    default public void requestLaunchApp(int n) {
    }

    default public void requestTerminateApp(int n) {
    }

    default public void requestStartSpeller(String string) {
    }

    default public void requestAddSpellerChars(String string) {
    }

    default public void requestRemoveSpellerChar() {
    }

    default public void requestClearSpeller() {
    }

    default public void requestSendString(String string) {
    }

    default public void requestAudioOption(int n) {
    }

    default public void requestAudioConnectionAudible(int n, boolean bl) {
    }

    default public void requestSendTouchEvents(Event[] eventArray, int n) {
    }

    default public void requestKeyboardMode(int n) {
    }

    default public void requestAvailableApplicationsWindow(int n, int n2) {
    }

    default public void requestDisplayKeyboard() {
    }

    default public void requestDismissHMIKeyboard() {
    }

    default public void requestFactorySettings() {
    }

    default public void requestPhoneView() {
    }

    default public void requestContextSwitched(boolean bl) {
    }

    default public void invokeNotiAction(int n, int n2) {
    }

    default public void requestNotificationServiceEnabled(boolean bl, int n, int n2, int n3, int n4) {
    }

    default public void requestLocationDataServicesEnabled(boolean bl) {
    }
}

