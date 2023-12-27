/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIObjectPush;
import org.dsi.ifc.browser.DSIBrowser;
import org.dsi.ifc.browser.TimePeriod;

public final class LR2cfa6daa4
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2123280744: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -2027281984: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1757579450: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1311077470: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1241590684: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1231767277: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 36;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 37;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 38;
                    break;
                }
                n3 = 36;
                break;
            }
            case -1148252404: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -1133832389: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -983448238: {
                if (bl) {
                    if (n2 != 1150548731) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 39;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 40;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 41;
                    break;
                }
                n3 = 39;
                break;
            }
            case -907679422: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -885753461: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -527241625: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -472871593: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -318289102: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -289673578: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -176577089: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -145922494: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 3745352: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 268328177: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 336632094: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 375438219: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 375731279: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 669886913: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 722162398: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 747417817: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 1085589485: {
                if (bl) {
                    if (n2 != 372504021) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 1108652185: {
                if (bl) {
                    if (n2 != -412271469) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1193983002: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1207412866: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 1352338209: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 1357766832: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 1525749317: {
                if (bl) {
                    if (n2 != 252948384) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 1659826135: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1671891297: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case 1676146863: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 1963795155: {
                if (bl) {
                    if (n2 != 261925508) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1603053090: {
                if (bl) {
                    if (n2 != 1204705193) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 47;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 48;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 49;
                    break;
                }
                n3 = 47;
                break;
            }
            case -950164929: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case -948729267: {
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
            case -146443216: {
                if (bl) {
                    if (n2 != -412271469) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case -41085655: {
                if (bl) {
                    if (n2 != -1808580537) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case 1833911964: {
                if (bl) {
                    if (n2 != 372504021) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
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
            case -442388177: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1150835490: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIBrowser)object).downloadFile((String)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 1: {
                ((DSIBrowser)object).setLanguage((String)objectArray[0]);
                return null;
            }
            case 2: {
                ((DSIBrowser)object).getHistory((TimePeriod)objectArray[0]);
                return null;
            }
            case 3: {
                ((DSIBrowser)object).cancelLoading();
                return null;
            }
            case 4: {
                ((DSIBrowser)object).followLink((Boolean)objectArray[0]);
                return null;
            }
            case 5: {
                ((DSIBrowser)object).getPreference(((Number)objectArray[0]).intValue());
                return null;
            }
            case 6: {
                ((DSIBrowser)object).goBack();
                return null;
            }
            case 7: {
                ((DSIBrowser)object).goForward();
                return null;
            }
            case 8: {
                ((DSIBrowser)object).gotoHomeUrl();
                return null;
            }
            case 9: {
                ((DSIBrowser)object).loadUrl((String)objectArray[0]);
                return null;
            }
            case 10: {
                ((DSIBrowser)object).nextFocus(((Number)objectArray[0]).intValue());
                return null;
            }
            case 11: {
                ((DSIBrowser)object).previousFocus(((Number)objectArray[0]).intValue());
                return null;
            }
            case 12: {
                ((DSIBrowser)object).scroll(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((DSIBrowser)object).reloadUrl();
                return null;
            }
            case 14: {
                ((DSIBrowser)object).setPreference(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (String)objectArray[2]);
                return null;
            }
            case 15: {
                ((DSIBrowser)object).stopBrowser();
                return null;
            }
            case 16: {
                ((DSIBrowser)object).zoom(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 17: {
                ((DSIBrowser)object).suspendBrowser();
                return null;
            }
            case 18: {
                ((DSIBrowser)object).resumeBrowser();
                return null;
            }
            case 19: {
                ((DSIBrowser)object).deleteCookies();
                return null;
            }
            case 20: {
                ((DSIBrowser)object).deleteHistory();
                return null;
            }
            case 21: {
                ((DSIBrowser)object).deletePasswords();
                return null;
            }
            case 22: {
                ((DSIBrowser)object).deleteCache();
                return null;
            }
            case 23: {
                ((DSIBrowser)object).enterImageSelectionMode();
                return null;
            }
            case 24: {
                ((DSIBrowser)object).clickOnPosition(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2]);
                return null;
            }
            case 25: {
                ((DSIBrowser)object).javaScriptAlertAck();
                return null;
            }
            case 26: {
                ((DSIBrowser)object).javaScriptConfirmAck((Boolean)objectArray[0]);
                return null;
            }
            case 27: {
                ((DSIBrowser)object).javaScriptPromptAck((String)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 28: {
                ((DSIBrowser)object).bringToFront();
                return null;
            }
            case 29: {
                ((DSIBrowser)object).keyboardInput((String)objectArray[0]);
                return null;
            }
            case 30: {
                ((DSIBrowser)object).setSelection(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 31: {
                ((DSIBrowser)object).resetToFactoryDefaults();
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIBrowser)object).exportBrowserData((String)objectArray[0]);
                return null;
            }
            case 33: {
                ((DSIBrowser)object).importBrowserData((String)objectArray[0]);
                return null;
            }
            case 34: {
                ((DSIBrowser)object).executeJavaScript((String)objectArray[0]);
                return null;
            }
            case 35: {
                ((DSIBrowser)object).touchScroll(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 36: {
                ((DSIBrowser)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 37: {
                ((DSIBrowser)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 38: {
                ((DSIBrowser)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 39: {
                ((DSIBrowser)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 40: {
                ((DSIBrowser)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 41: {
                ((DSIBrowser)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 42: {
                ((DSIObjectPush)object).requestOPPAbortSending();
                return null;
            }
            case 43: {
                ((DSIObjectPush)object).requestOPPAcceptObject((String)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 44: {
                ((DSIObjectPush)object).requestOPPSendContacts((String)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 45: {
                ((DSIObjectPush)object).requestOPPSendMessages((String)objectArray[0], (int[])objectArray[1]);
                return null;
            }
            case 46: {
                ((DSIObjectPush)object).requestOPPSendBinary((String)objectArray[0], (String[])objectArray[1]);
                return null;
            }
            case 47: {
                ((DSIObjectPush)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 48: {
                ((DSIObjectPush)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 49: {
                ((DSIObjectPush)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 50: {
                ((DSIObjectPush)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 51: {
                ((DSIObjectPush)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 52: {
                ((DSIObjectPush)object).clearNotification((DSIListener)objectArray[0]);
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

