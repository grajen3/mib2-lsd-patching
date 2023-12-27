/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentTopologyListener;
import org.dsi.ifc.tmc.AreaWarningInfo;
import org.dsi.ifc.tmc.DSITmcListener;
import org.dsi.ifc.tmc.LocalHazardInformation;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TrafficSource;

public final class LR24589f17b
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -582718259: {
                if (bl) {
                    if (n2 != -1034208512) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -81295155: {
                if (bl) {
                    if (n2 != -1034208512) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 252012373: {
                if (bl) {
                    if (n2 != 1687814400) break;
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
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -1584453067: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -1364113950: {
                if (bl) {
                    if (n2 != 220435470) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -581901267: {
                if (bl) {
                    if (n2 != 1172734531) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -502791041: {
                if (bl) {
                    if (n2 != -1034208512) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -488430065: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -464014132: {
                if (bl) {
                    if (n2 != 857119746) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -146072681: {
                if (bl) {
                    if (n2 != 1274089556) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 528840366: {
                if (bl) {
                    if (n2 != 3524) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 1151513074: {
                if (bl) {
                    if (n2 != 1385999773) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 1155319933: {
                if (bl) {
                    if (n2 != -266965504) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1475905256: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1623646813: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1642717644: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 1895659579: {
                if (bl) {
                    if (n2 != -940610354) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 2001618343: {
                if (bl) {
                    if (n2 != 1188005321) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 2040852485: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 2071249272: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
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
            case -175715647: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1081002435: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIMobileEquipmentTopologyListener)object).responseChangeTopology(((Number)objectArray[0]).intValue());
                return null;
            }
            case 1: {
                ((DSIMobileEquipmentTopologyListener)object).updateTopology((int[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSIMobileEquipmentTopologyListener)object).updateUsage((int[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSIMobileEquipmentTopologyListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 4: {
                ((DSITmcListener)object).updateCurrentLanguage((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSITmcListener)object).updateEventsOnRoute(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSITmcListener)object).updateEventsTotal(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), ((Number)objectArray[2]).longValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 7: {
                ((DSITmcListener)object).updateTmcState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSITmcListener)object).updateActiveTrafficSources((int[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSITmcListener)object).updateIsEngineeringMode((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSITmcListener)object).updateIsTmcProAvailable((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSITmcListener)object).windowChange(((Number)objectArray[0]).intValue());
                return null;
            }
            case 12: {
                ((DSITmcListener)object).tmcWindowResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (TmcListElement[])objectArray[2]);
                return null;
            }
            case 13: {
                ((DSITmcListener)object).setMessageFilterResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSITmcListener)object).getMessageIdsForListElementResult((long[])objectArray[0]);
                return null;
            }
            case 15: {
                ((DSITmcListener)object).getBoundingRectangleForTrafficMessagesResult((NavRectangle)objectArray[0]);
                return null;
            }
            case 16: {
                ((DSITmcListener)object).updateAreaWarning((AreaWarningInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSITmcListener)object).updateAreaWarnings((AreaWarningInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                ((DSITmcListener)object).updateLocalHazardInformation((LocalHazardInformation[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((DSITmcListener)object).updateTrafficFlowStatisticsStatus((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSITmcListener)object).updateTrafficSourceInformation((TrafficSource[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 21: {
                ((DSITmcListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

