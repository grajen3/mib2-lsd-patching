/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.internetbrowser.reflection.generated.mma;

import de.vw.mib.asl.internal.internetbrowser.states.IBrowserStateActive;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.browser.HistoryEntry;
import org.dsi.ifc.browser.KeyboardInfo;
import org.dsi.ifc.browser.SelectionEntry;
import org.dsi.ifc.browser.TimePeriod;

public final class LR2575da4fd
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2114502538: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -2045784234: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -1713501187: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -1510793265: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1033195698: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -913229634: {
                if (bl) {
                    if (n2 != 1050725274) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -894608670: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -786605867: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -696127774: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -689816620: {
                if (bl) {
                    if (n2 != -412271469) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -554148807: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -277050464: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 68538174: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 68538175: {
                if (bl) {
                    if (n2 != -448335035) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 564526186: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 661242971: {
                if (bl) {
                    if (n2 != 605116011) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 682974681: {
                if (bl) {
                    if (n2 != 1896178379) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 754682531: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 931745553: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 1094688028: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1174373959: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1305531349: {
                if (bl) {
                    if (n2 != 1150548731) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1350830234: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 1843293895: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
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
            case 1465754877: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                return RuntimeUtil.valueOf(((IBrowserStateActive)object).getTimeout());
            }
            case 1: {
                ((IBrowserStateActive)object).setSpeedPopup((Boolean)objectArray[0]);
                return null;
            }
            case 2: {
                ((IBrowserStateActive)object).dsiBrowserIndicateEfiUrl((String)objectArray[0]);
                return null;
            }
            case 3: {
                ((IBrowserStateActive)object).dsiBrowserUpdateBrowserState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((IBrowserStateActive)object).dsiBrowserUpdatePageTitle((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((IBrowserStateActive)object).dsiBrowserUpdateActiveUrl((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((IBrowserStateActive)object).dsiBrowserUpdateZoomFactor(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((IBrowserStateActive)object).dsiBrowserUpdateVirtualKeyboardStatus((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((IBrowserStateActive)object).dsiBrowserUpdateEncryption((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((IBrowserStateActive)object).dsiBrowserUpdateHasFocus((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((IBrowserStateActive)object).dsiBrowserUpdateButtonState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 11: {
                ((IBrowserStateActive)object).dsiBrowserUpdateProgress(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((IBrowserStateActive)object).dsiBrowserUpdateScrollbarX(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 13: {
                ((IBrowserStateActive)object).dsiBrowserUpdateScrollbarY(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 14: {
                ((IBrowserStateActive)object).dsiBrowserUpdateKeyboardDisplay((Boolean)objectArray[0], (KeyboardInfo)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 15: {
                ((IBrowserStateActive)object).dsiBrowserGetPreferenceResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (String)objectArray[2]);
                return null;
            }
            case 16: {
                ((IBrowserStateActive)object).dsiBrowserJavascriptAlert((String)objectArray[0]);
                return null;
            }
            case 17: {
                ((IBrowserStateActive)object).dsiBrowserJavascriptConfirm((String)objectArray[0]);
                return null;
            }
            case 18: {
                ((IBrowserStateActive)object).dsiBrowserJavascriptPrompt((String)objectArray[0], (String)objectArray[1]);
                return null;
            }
            case 19: {
                ((IBrowserStateActive)object).dsiBrowserUpdateSelectionListContent((SelectionEntry[])objectArray[0], (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 20: {
                ((IBrowserStateActive)object).dsiBrowserExportBrowserDataResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 21: {
                ((IBrowserStateActive)object).dsiBrowserImportBrowserDataResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 22: {
                ((IBrowserStateActive)object).dsiBrowserGetHistoryResult((TimePeriod)objectArray[0], (HistoryEntry[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 23: {
                ((IBrowserStateActive)object).dsiBrowserAsyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

