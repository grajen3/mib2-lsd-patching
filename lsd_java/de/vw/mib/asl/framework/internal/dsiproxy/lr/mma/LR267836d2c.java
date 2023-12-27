/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIOperatorCall;
import org.dsi.ifc.online.DSIPoiOnlineSearch;
import org.dsi.ifc.online.OperatorCallData;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public final class LR267836d2c
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1840932015: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -1688505355: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1687267137: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
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
            case -682708836: {
                if (bl) {
                    if (n2 != -1924501671) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -147563582: {
                if (bl) {
                    if (n2 != -1851841549) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -55863616: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 261066141: {
                if (bl) {
                    if (n2 != 1115116705) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 375731279: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 749611928: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1004591146: {
                if (bl) {
                    if (n2 != 397160978) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1013928617: {
                if (bl) {
                    if (n2 != 2121623395) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1192162631: {
                if (bl) {
                    if (n2 != -1068662466) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1234836075: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 1947752259: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 23;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 24;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 25;
                    break;
                }
                n3 = 23;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 26;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 27;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 28;
                    break;
                }
                n3 = 26;
                break;
            }
            case -784678077: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -432307591: {
                if (bl) {
                    if (n2 != -1447574640) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 375731279: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
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
            case -1102075019: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case -155437636: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIPoiOnlineSearch)object).setLanguage((String)objectArray[0]);
                return null;
            }
            case 1: {
                ((DSIPoiOnlineSearch)object).setFallbackLanguage((String)objectArray[0]);
                return null;
            }
            case 2: {
                ((DSIPoiOnlineSearch)object).poiStartSelectionZoom((String)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue());
                return null;
            }
            case 3: {
                ((DSIPoiOnlineSearch)object).dynamicPoiStartSelectionZoom(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue(), ((Number)objectArray[6]).intValue());
                return null;
            }
            case 4: {
                ((DSIPoiOnlineSearch)object).poiStartSelection((String)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 5: {
                ((DSIPoiOnlineSearch)object).dynamicPoiStartSelection(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue(), ((Number)objectArray[5]).intValue());
                return null;
            }
            case 6: {
                ((DSIPoiOnlineSearch)object).poiStopSelection();
                return null;
            }
            case 7: {
                ((DSIPoiOnlineSearch)object).poiRequestValueList(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSIPoiOnlineSearch)object).poiStartVoiceSelection(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue(), (Boolean)objectArray[4], ((Number)objectArray[5]).intValue());
                return null;
            }
            case 9: {
                ((DSIPoiOnlineSearch)object).poiRawVoiceDataAvailable((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSIPoiOnlineSearch)object).poiRequestSpellingSuggestion();
                return null;
            }
            case 11: {
                ((DSIPoiOnlineSearch)object).usedPoi((PoiOnlineSearchValuelistElement)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSIPoiOnlineSearch)object).poiVoiceSearchActive();
                return null;
            }
            case 13: {
                ((DSIPoiOnlineSearch)object).precheckDynamicPOICategory(((Number)objectArray[0]).intValue());
                return null;
            }
            case 14: {
                ((DSIPoiOnlineSearch)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 15: {
                ((DSIPoiOnlineSearch)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 16: {
                ((DSIPoiOnlineSearch)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 17: {
                ((DSIPoiOnlineSearch)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 18: {
                ((DSIPoiOnlineSearch)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 19: {
                ((DSIPoiOnlineSearch)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 20: {
                ((DSIOperatorCall)object).setLanguage((String)objectArray[0]);
                return null;
            }
            case 21: {
                ((DSIOperatorCall)object).requestOperatorCallResult((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 22: {
                ((DSIOperatorCall)object).requestOperatorPhoneNumber(((Number)objectArray[0]).intValue(), (OperatorCallData)objectArray[1], (Boolean)objectArray[2]);
                return null;
            }
            case 23: {
                ((DSIOperatorCall)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 24: {
                ((DSIOperatorCall)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 25: {
                ((DSIOperatorCall)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 26: {
                ((DSIOperatorCall)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 27: {
                ((DSIOperatorCall)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 28: {
                ((DSIOperatorCall)object).clearNotification((DSIListener)objectArray[0]);
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

