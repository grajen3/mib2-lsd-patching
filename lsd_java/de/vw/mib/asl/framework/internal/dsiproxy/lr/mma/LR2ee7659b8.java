/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.messaging.DSIMessagingServiceConfiguration;
import org.dsi.ifc.mirrorlink.ClientCapabilities;
import org.dsi.ifc.mirrorlink.DSIMirrorLink;
import org.dsi.ifc.mirrorlink.Event;

public final class LR2ee7659b8
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1774668542: {
                if (bl) {
                    if (n2 != 1909456715) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -1472521178: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -1428724258: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1424733218: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1389528618: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -1285454555: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 14;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 15;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 16;
                    break;
                }
                n3 = 14;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 17;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 18;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 19;
                    break;
                }
                n3 = 17;
                break;
            }
            case -664727932: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -276907135: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 42962767: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 168636898: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 513739283: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 749277265: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 1293798451: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1664636227: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2047377303: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -2019820012: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -1995891645: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -1984836490: {
                if (bl) {
                    if (n2 != 1400527966) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case -1967784854: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case -1900497191: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case -1590637947: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case -1199143249: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 50;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 51;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 52;
                    break;
                }
                n3 = 50;
                break;
            }
            case -1024450765: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 53;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 54;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 55;
                    break;
                }
                n3 = 53;
                break;
            }
            case -708828158: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case -371146546: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case -169915059: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -134497912: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case -62724878: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case 7064197: {
                if (bl) {
                    if (n2 != -979803021) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 73500324: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case 74359035: {
                if (bl) {
                    if (n2 != 1101726752) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case 121977739: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 859648081: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case 1019345575: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 1024640075: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 1550711855: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 1572458423: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case 1614953382: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 1666557090: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 1683091308: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case 1714010422: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 1749188637: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case 1917438982: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 1921328601: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
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
            case -477777904: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1281842841: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIMessagingServiceConfiguration)object).setPhoneSystemRingingVolumeRequest(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSIMessagingServiceConfiguration)object).setPhoneSystemRingingTypeRequest(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSIMessagingServiceConfiguration)object).setSMSCNumberRequest((String)objectArray[0]);
                return null;
            }
            case 3: {
                ((DSIMessagingServiceConfiguration)object).activateSmsDeliveryReportRequest((Boolean)objectArray[0]);
                return null;
            }
            case 4: {
                ((DSIMessagingServiceConfiguration)object).activateStoreSmsOnSentRequest((Boolean)objectArray[0]);
                return null;
            }
            case 5: {
                ((DSIMessagingServiceConfiguration)object).setShortMessageValidityPeriodRequest(((Number)objectArray[0]).intValue());
                return null;
            }
            case 6: {
                ((DSIMessagingServiceConfiguration)object).activateEmailIncludeOldMailInReplyRequest((Boolean)objectArray[0]);
                return null;
            }
            case 7: {
                ((DSIMessagingServiceConfiguration)object).activateEmailEmptySubjectNotificationRequest((Boolean)objectArray[0]);
                return null;
            }
            case 8: {
                ((DSIMessagingServiceConfiguration)object).changeFolderViewModeRequest(((Number)objectArray[0]).intValue());
                return null;
            }
            case 9: {
                ((DSIMessagingServiceConfiguration)object).restoreFactorySettingsRequest();
                return null;
            }
            case 10: {
                ((DSIMessagingServiceConfiguration)object).setAccountPreferences(((Number)objectArray[0]).intValue(), (String)objectArray[1]);
                return null;
            }
            case 11: {
                ((DSIMessagingServiceConfiguration)object).requestSetSmsIndications((Boolean)objectArray[0]);
                return null;
            }
            case 12: {
                ((DSIMessagingServiceConfiguration)object).requestSetEmailIndications((Boolean)objectArray[0]);
                return null;
            }
            case 13: {
                ((DSIMessagingServiceConfiguration)object).requestSetPushSms((Boolean)objectArray[0]);
                return null;
            }
            case 14: {
                ((DSIMessagingServiceConfiguration)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 15: {
                ((DSIMessagingServiceConfiguration)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 16: {
                ((DSIMessagingServiceConfiguration)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 17: {
                ((DSIMessagingServiceConfiguration)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 18: {
                ((DSIMessagingServiceConfiguration)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 19: {
                ((DSIMessagingServiceConfiguration)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 20: {
                ((DSIMirrorLink)object).requestClientCapabilities((ClientCapabilities)objectArray[0]);
                return null;
            }
            case 21: {
                ((DSIMirrorLink)object).requestAccessMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 22: {
                ((DSIMirrorLink)object).requestDayNightMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 23: {
                ((DSIMirrorLink)object).requestUsableViewport(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 24: {
                ((DSIMirrorLink)object).requestContextVisible((Boolean)objectArray[0]);
                return null;
            }
            case 25: {
                ((DSIMirrorLink)object).requestConnectDevice(((Number)objectArray[0]).intValue());
                return null;
            }
            case 26: {
                ((DSIMirrorLink)object).requestDisconnectDevice(((Number)objectArray[0]).intValue());
                return null;
            }
            case 27: {
                ((DSIMirrorLink)object).requestRotateScreen(((Number)objectArray[0]).intValue());
                return null;
            }
            case 28: {
                ((DSIMirrorLink)object).requestChangeOrientation(((Number)objectArray[0]).intValue());
                return null;
            }
            case 29: {
                ((DSIMirrorLink)object).requestSoftKeyEvent(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 30: {
                ((DSIMirrorLink)object).requestLaunchApp(((Number)objectArray[0]).intValue());
                return null;
            }
            case 31: {
                ((DSIMirrorLink)object).requestTerminateApp(((Number)objectArray[0]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIMirrorLink)object).requestStartSpeller((String)objectArray[0]);
                return null;
            }
            case 33: {
                ((DSIMirrorLink)object).requestAddSpellerChars((String)objectArray[0]);
                return null;
            }
            case 34: {
                ((DSIMirrorLink)object).requestRemoveSpellerChar();
                return null;
            }
            case 35: {
                ((DSIMirrorLink)object).requestClearSpeller();
                return null;
            }
            case 36: {
                ((DSIMirrorLink)object).requestSendString((String)objectArray[0]);
                return null;
            }
            case 37: {
                ((DSIMirrorLink)object).requestAudioOption(((Number)objectArray[0]).intValue());
                return null;
            }
            case 38: {
                ((DSIMirrorLink)object).requestAudioConnectionAudible(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 39: {
                ((DSIMirrorLink)object).requestSendTouchEvents((Event[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 40: {
                ((DSIMirrorLink)object).requestKeyboardMode(((Number)objectArray[0]).intValue());
                return null;
            }
            case 41: {
                ((DSIMirrorLink)object).requestAvailableApplicationsWindow(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 42: {
                ((DSIMirrorLink)object).requestDisplayKeyboard();
                return null;
            }
            case 43: {
                ((DSIMirrorLink)object).requestDismissHMIKeyboard();
                return null;
            }
            case 44: {
                ((DSIMirrorLink)object).requestFactorySettings();
                return null;
            }
            case 45: {
                ((DSIMirrorLink)object).requestPhoneView();
                return null;
            }
            case 46: {
                ((DSIMirrorLink)object).requestContextSwitched((Boolean)objectArray[0]);
                return null;
            }
            case 47: {
                ((DSIMirrorLink)object).invokeNotiAction(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 48: {
                ((DSIMirrorLink)object).requestNotificationServiceEnabled((Boolean)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 49: {
                ((DSIMirrorLink)object).requestLocationDataServicesEnabled((Boolean)objectArray[0]);
                return null;
            }
            case 50: {
                ((DSIMirrorLink)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 51: {
                ((DSIMirrorLink)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 52: {
                ((DSIMirrorLink)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 53: {
                ((DSIMirrorLink)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 54: {
                ((DSIMirrorLink)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 55: {
                ((DSIMirrorLink)object).clearNotification((DSIListener)objectArray[0]);
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
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

