/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.bluetooth.DSIObjectPushListener;
import org.dsi.ifc.browser.DSIBrowserListener;
import org.dsi.ifc.browser.HistoryEntry;
import org.dsi.ifc.browser.KeyboardInfo;
import org.dsi.ifc.browser.SelectionEntry;
import org.dsi.ifc.browser.TimePeriod;

public final class LR252f804f0
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1527011763: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -1036056212: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -723290050: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -617932489: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 982299948: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1257065130: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1629126720: {
                if (bl) {
                    if (n2 != 1775039192) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1979741501: {
                if (bl) {
                    if (n2 != 1150548731) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -1975346266: {
                if (bl) {
                    if (n2 != -412271469) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -1878876572: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -1789805395: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -1216991472: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -1216991471: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1098457345: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -950913501: {
                if (bl) {
                    if (n2 != -1028403557) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -644303896: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -130905973: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 154116872: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 336728391: {
                if (bl) {
                    if (n2 != 1896178379) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 510872180: {
                if (bl) {
                    if (n2 != -412271469) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 616170925: {
                if (bl) {
                    if (n2 != 605116011) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 769985575: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 987769020: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 1177925365: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 1384752747: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1409999925: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1498644385: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 1568636624: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 1699850691: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 1976241952: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 2003125200: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 2078919861: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 2096208016: {
                if (bl) {
                    if (n2 != 1050725274) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
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
            case 957777654: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1172537347: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIObjectPushListener)object).updateOPPIncomingObject((String)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 1: {
                ((DSIObjectPushListener)object).responseOPPAbortSending(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSIObjectPushListener)object).responseOPPAcceptObject(((Number)objectArray[0]).intValue());
                return null;
            }
            case 3: {
                ((DSIObjectPushListener)object).responseOPPSendContacts(((Number)objectArray[0]).intValue());
                return null;
            }
            case 4: {
                ((DSIObjectPushListener)object).responseOPPSendMessages(((Number)objectArray[0]).intValue());
                return null;
            }
            case 5: {
                ((DSIObjectPushListener)object).responseOPPSendBinary(((Number)objectArray[0]).intValue());
                return null;
            }
            case 6: {
                ((DSIObjectPushListener)object).updateVCardsReceived((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSIObjectPushListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 8: {
                ((DSIBrowserListener)object).updateBrowserState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSIBrowserListener)object).updatePageTitle((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSIBrowserListener)object).updateActiveUrl((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSIBrowserListener)object).updateZoomFactor(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSIBrowserListener)object).updateVirtualKeyboardStatus((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((DSIBrowserListener)object).updateEncryption((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSIBrowserListener)object).updateHasFocus((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSIBrowserListener)object).updateButtonState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 16: {
                ((DSIBrowserListener)object).updateProgress(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSIBrowserListener)object).updateScrollbarX(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 18: {
                ((DSIBrowserListener)object).updateScrollbarY(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 19: {
                ((DSIBrowserListener)object).getPreferenceResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (String)objectArray[2]);
                return null;
            }
            case 20: {
                ((DSIBrowserListener)object).resumeBrowserResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 21: {
                ((DSIBrowserListener)object).indicateEfiUrl((String)objectArray[0]);
                return null;
            }
            case 22: {
                ((DSIBrowserListener)object).indicateUnknownMimeType((String)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 23: {
                ((DSIBrowserListener)object).indicateDownloadUrl((String)objectArray[0]);
                return null;
            }
            case 24: {
                ((DSIBrowserListener)object).indicatePopup((String)objectArray[0]);
                return null;
            }
            case 25: {
                ((DSIBrowserListener)object).indicateDownloadProgress((String)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 26: {
                ((DSIBrowserListener)object).javascriptAlert((String)objectArray[0]);
                return null;
            }
            case 27: {
                ((DSIBrowserListener)object).javascriptConfirm((String)objectArray[0]);
                return null;
            }
            case 28: {
                ((DSIBrowserListener)object).javascriptPrompt((String)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 29: {
                ((DSIBrowserListener)object).updateSelectionListContent((SelectionEntry[])objectArray[0], (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 30: {
                ((DSIBrowserListener)object).exportBrowserDataResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 31: {
                ((DSIBrowserListener)object).importBrowserDataResult(((Number)objectArray[0]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIBrowserListener)object).getHistoryResult((TimePeriod)objectArray[0], (HistoryEntry[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 33: {
                ((DSIBrowserListener)object).updateKeyboardDisplay((Boolean)objectArray[0], (KeyboardInfo)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 34: {
                ((DSIBrowserListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

