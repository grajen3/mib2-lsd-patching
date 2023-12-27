/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.online.DSIOperatorCallListener;
import org.dsi.ifc.online.DSIPoiOnlineSearchListener;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.OperatorCallResult;
import org.dsi.ifc.online.PoiOnlineSearchValuelist;

public final class LR2290ad3a8
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1464558475: {
                if (bl) {
                    if (n2 != -794511114) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -33763449: {
                if (bl) {
                    if (n2 != -645867850) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1893260892: {
                if (bl) {
                    if (n2 != 554665125) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 749996412: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1267834301: {
                if (bl) {
                    if (n2 != 845722233) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1758198010: {
                if (bl) {
                    if (n2 != 2014368050) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
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
            case -2136091575: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -1880414320: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIOperatorCallListener)object).responseOperatorCallResult(((Number)objectArray[0]).intValue(), (OperatorCallResult[])objectArray[1]);
                return null;
            }
            case 1: {
                ((DSIOperatorCallListener)object).responseOperatorPhoneNumber(((Number)objectArray[0]).intValue(), (String)objectArray[1], (String[])objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 2: {
                ((DSIOperatorCallListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 3: {
                ((DSIPoiOnlineSearchListener)object).poiValueList(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (PoiOnlineSearchValuelist)objectArray[2], ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 4: {
                ((DSIPoiOnlineSearchListener)object).poiResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 5: {
                ((DSIPoiOnlineSearchListener)object).poiSpellingSuggestion(((Number)objectArray[0]).intValue(), (String)objectArray[1], (String[])objectArray[2]);
                return null;
            }
            case 6: {
                ((DSIPoiOnlineSearchListener)object).precheckDynamicPOICategoryResponse(((Number)objectArray[0]).intValue(), (OSRServiceState)objectArray[1]);
                return null;
            }
            case 7: {
                ((DSIPoiOnlineSearchListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

