/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.messaging.DSIMessagingServiceConfigurationListener;
import org.dsi.ifc.mirrorlink.Application;
import org.dsi.ifc.mirrorlink.DSIMirrorLinkListener;
import org.dsi.ifc.mirrorlink.Device;
import org.dsi.ifc.mirrorlink.Notification;

public final class LR2202f22ec
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2018983037: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -1900090426: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case -1890539749: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1839054091: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -1810531436: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1775990083: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case -1601297599: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -1480849932: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -1363969719: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -1319759902: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -1213502625: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -776182083: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -711344746: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case -672816201: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -627068590: {
                if (bl) {
                    if (n2 != -1034208512) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -551467305: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -357174810: {
                if (bl) {
                    if (n2 != -838812907) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case -351144954: {
                if (bl) {
                    if (n2 != 984732272) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -214308992: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 127297240: {
                if (bl) {
                    if (n2 != 2077903511) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 162994702: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 230337878: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 348933508: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 498254627: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case 710293104: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 722569761: {
                if (bl) {
                    if (n2 != -606911723) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 851028815: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 1011627752: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 1181477629: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1278425923: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case 1288843957: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 1302496016: {
                if (bl) {
                    if (n2 != -524618624) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 1321509360: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case 1338166375: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 1374423798: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 1391058251: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 1416379609: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1676203300: {
                if (bl) {
                    if (n2 != 2077903511) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1691985058: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1733283972: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 2024448951: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 2062637812: {
                if (bl) {
                    if (n2 != 148318748) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1861500014: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case -1771547468: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case -1715755701: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case -1609043155: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case -1486000879: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case -1390915972: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case -1287864036: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case -1201036409: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case -1175066957: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case -1164141796: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case -1141470539: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case -886778739: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case -54926451: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case 375705273: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case 415098029: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case 454064657: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case 584234004: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case 738425628: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case 893659172: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case 921185590: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case 985691544: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case 1384760779: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case 1505961319: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case 1738376617: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case 1805673737: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case 2063180369: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
        }
        return n3;
    }

    @Override
    public int getIndex(String string, String string2, Class[] classArray) {
        int n;
        boolean bl;
        int n2 = -1;
        int n3 = RuntimeUtil.buildKey(string);
        int n4 = RuntimeUtil.buildKey(string2);
        if (classArray != null) {
            bl = true;
            n = RuntimeUtil.buildKey(classArray);
        } else {
            bl = false;
            n = 0;
        }
        switch (n3) {
            case -1157487763: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case -418443804: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIMirrorLinkListener)object).updateDiscoveredDevices((Device[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSIMirrorLinkListener)object).responseClientCapabilities(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSIMirrorLinkListener)object).responseAccessMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSIMirrorLinkListener)object).responseDayNightMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSIMirrorLinkListener)object).responseUsableViewPort(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 5: {
                ((DSIMirrorLinkListener)object).responseContextVisible((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSIMirrorLinkListener)object).responseConnectDevice(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSIMirrorLinkListener)object).responseDisconnectDevice(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSIMirrorLinkListener)object).responseRotateScreen(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSIMirrorLinkListener)object).responseSoftKeyEvent(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 10: {
                ((DSIMirrorLinkListener)object).responseLaunchApp(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSIMirrorLinkListener)object).responseTerminateApp(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSIMirrorLinkListener)object).responseSpellerResult((String)objectArray[0], (String)objectArray[1], (Boolean)objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 13: {
                ((DSIMirrorLinkListener)object).responseSendString(((Number)objectArray[0]).intValue());
                return null;
            }
            case 14: {
                ((DSIMirrorLinkListener)object).responseAudioOption(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSIMirrorLinkListener)object).responseAudioConnectionAudible(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 16: {
                ((DSIMirrorLinkListener)object).responseSendTouchEvents(((Number)objectArray[0]).intValue());
                return null;
            }
            case 17: {
                ((DSIMirrorLinkListener)object).updateDeviceConnectionStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 18: {
                ((DSIMirrorLinkListener)object).updateDeviceSoftKeys((int[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((DSIMirrorLinkListener)object).updateApplicationStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 20: {
                ((DSIMirrorLinkListener)object).updateScreenOrientation(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 21: {
                ((DSIMirrorLinkListener)object).updateShowKeyboard(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 22: {
                ((DSIMirrorLinkListener)object).updateScreenOrientationAvailable((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((DSIMirrorLinkListener)object).updateScreenRotationAvailable((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 24: {
                ((DSIMirrorLinkListener)object).updateAudioConnectionRequested(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 25: {
                ((DSIMirrorLinkListener)object).responseKeyboardMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 26: {
                ((DSIMirrorLinkListener)object).updateAvailableApplicationsList(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 27: {
                ((DSIMirrorLinkListener)object).responseAvailableApplicationsWindow(((Number)objectArray[0]).intValue(), (Application[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 28: {
                ((DSIMirrorLinkListener)object).updateSingleApplicationMode((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 29: {
                ((DSIMirrorLinkListener)object).responseDisplayKeyboard(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 30: {
                ((DSIMirrorLinkListener)object).responseDismissHMIKeyboard(((Number)objectArray[0]).intValue());
                return null;
            }
            case 31: {
                ((DSIMirrorLinkListener)object).responseFactorySettings(((Number)objectArray[0]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIMirrorLinkListener)object).updatePhoneViewAvailable((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 33: {
                ((DSIMirrorLinkListener)object).responsePhoneView(((Number)objectArray[0]).intValue());
                return null;
            }
            case 34: {
                ((DSIMirrorLinkListener)object).updateUncertifiedContent((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 35: {
                ((DSIMirrorLinkListener)object).updateDeviceStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 36: {
                ((DSIMirrorLinkListener)object).updateSWaPStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 37: {
                ((DSIMirrorLinkListener)object).responseContextSwitched();
                return null;
            }
            case 38: {
                ((DSIMirrorLinkListener)object).updateShowNotification((Notification)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 39: {
                ((DSIMirrorLinkListener)object).updateNotificationServiceEnabled((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 40: {
                ((DSIMirrorLinkListener)object).updateLocationDataServicesEnabled((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 41: {
                ((DSIMirrorLinkListener)object).updateSwitchToClientNativeUI(((Number)objectArray[0]).intValue());
                return null;
            }
            case 42: {
                ((DSIMirrorLinkListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 43: {
                ((DSIMessagingServiceConfigurationListener)object).setSMSCNumberResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 44: {
                ((DSIMessagingServiceConfigurationListener)object).activateStoreSmsOnSentResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 45: {
                ((DSIMessagingServiceConfigurationListener)object).setShortMessageValidityPeriodResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 46: {
                ((DSIMessagingServiceConfigurationListener)object).activateSMSDeliveryReportResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 47: {
                ((DSIMessagingServiceConfigurationListener)object).updateSMSCNumber((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 48: {
                ((DSIMessagingServiceConfigurationListener)object).setPhoneSystemRingingVolumeResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 49: {
                ((DSIMessagingServiceConfigurationListener)object).setPhoneSystemRingingTypeResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 50: {
                ((DSIMessagingServiceConfigurationListener)object).activateEmailIncludeOldMailInReplyResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 51: {
                ((DSIMessagingServiceConfigurationListener)object).activateEmailEmptySubjectNotificationResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 52: {
                ((DSIMessagingServiceConfigurationListener)object).changeFolderViewModeResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 53: {
                ((DSIMessagingServiceConfigurationListener)object).restoreFactorySettingsResponse(((Number)objectArray[0]).intValue());
                return null;
            }
            case 54: {
                ((DSIMessagingServiceConfigurationListener)object).responseSetSmsIndications(((Number)objectArray[0]).intValue());
                return null;
            }
            case 55: {
                ((DSIMessagingServiceConfigurationListener)object).responseSetEmailIndications(((Number)objectArray[0]).intValue());
                return null;
            }
            case 56: {
                ((DSIMessagingServiceConfigurationListener)object).responseSetPushSms(((Number)objectArray[0]).intValue());
                return null;
            }
            case 57: {
                ((DSIMessagingServiceConfigurationListener)object).updateSmsDeliveryReport((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 58: {
                ((DSIMessagingServiceConfigurationListener)object).updateStoreSmsOnSent((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 59: {
                ((DSIMessagingServiceConfigurationListener)object).updateShortMessageValidityPeriod(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 60: {
                ((DSIMessagingServiceConfigurationListener)object).updatePhoneSystemRingingVolume(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 61: {
                ((DSIMessagingServiceConfigurationListener)object).updatePhoneSystemRingingType(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 62: {
                ((DSIMessagingServiceConfigurationListener)object).updateEmailIncludeOldMailInReply((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 63: {
                ((DSIMessagingServiceConfigurationListener)object).updateEmailEmptySubjectNotification((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((DSIMessagingServiceConfigurationListener)object).updateFolderViewMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 65: {
                ((DSIMessagingServiceConfigurationListener)object).updateAccountPreferences(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 66: {
                ((DSIMessagingServiceConfigurationListener)object).updateSmsIndications((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 67: {
                ((DSIMessagingServiceConfigurationListener)object).updateEmailIndications((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 68: {
                ((DSIMessagingServiceConfigurationListener)object).updatePushSms((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 69: {
                ((DSIMessagingServiceConfigurationListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
        }
        return null;
    }

    @Override
    public Object invoke(int n, Object object, Object[] objectArray) {
        try {
            switch (n >> 5) {
                case 0: {
                    return this.f0(n, object, objectArray);
                }
                case 1: {
                    return this.f1(n, object, objectArray);
                }
                case 2: {
                    return this.f2(n, object, objectArray);
                }
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

