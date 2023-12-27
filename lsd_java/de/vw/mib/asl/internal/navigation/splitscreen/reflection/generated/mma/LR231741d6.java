/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.splitscreen.reflection.generated.mma;

import de.vw.mib.asl.internal.navigation.caching.IconKey;
import de.vw.mib.asl.internal.navigation.splitscreen.SplitScreenTargetHSM;
import de.vw.mib.asl.internal.navigation.splitscreen.SplitscreenInternalAPINotifier;
import de.vw.mib.asl.internal.navigation.splitscreen.Target10Plus0Box;
import de.vw.mib.asl.internal.navigation.splitscreen.Target3Plus1Box;
import de.vw.mib.asl.internal.navigation.splitscreen.TargetMotorwayInfo;
import de.vw.mib.asl.internal.navigation.splitscreen.overlays.OverlaysTargetHSM;
import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navigation.BapTurnToInfo;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.tmc.SpeedAndFlowSegment;
import org.dsi.ifc.tmc.TmcMessage;

public final class LR231741d6
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2113556074: {
                if (bl) {
                    if (n2 != 1599334026) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -1759405099: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 25224473: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 868282914: {
                if (bl) {
                    if (n2 != 17) break;
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
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1670077371: {
                if (bl) {
                    if (n2 != 1587919693) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1077557351: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 269677393: {
                if (bl) {
                    if (n2 != -912290783) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 679260092: {
                if (bl) {
                    if (n2 != 293113262) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 693221473: {
                if (bl) {
                    if (n2 != -585071033) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 727335687: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 977070273: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1244919775: {
                if (bl) {
                    if (n2 != -1985511187) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 1358541925: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 1832634497: {
                if (bl) {
                    if (n2 != -141377623) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 1946910398: {
                if (bl) {
                    if (n2 == 1113590989) {
                        n3 = 18;
                        break;
                    }
                    if (n2 != -1666704538) break;
                    n3 = 19;
                    break;
                }
                n3 = 18;
                break;
            }
            case 2097630595: {
                if (bl) {
                    if (n2 != 2010712203) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
        }
        return n3;
    }

    private int a2(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -1077557351: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case -204611399: {
                if (bl) {
                    if (n2 != -866436352) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 269677393: {
                if (bl) {
                    if (n2 != -912290783) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 598678267: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case 679260092: {
                if (bl) {
                    if (n2 != 293113262) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case 693221473: {
                if (bl) {
                    if (n2 != -585071033) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 727335687: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case 884561737: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case 977070273: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 1244919775: {
                if (bl) {
                    if (n2 != -1985511187) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case 1832634497: {
                if (bl) {
                    if (n2 != -141377623) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case 1948306687: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case 2025850229: {
                if (bl) {
                    if (n2 != -1145889529) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 2097630595: {
                if (bl) {
                    if (n2 != 2010712203) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
        }
        return n3;
    }

    private int a3(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1993944238: {
                if (bl) {
                    if (n2 != -585071033) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case -1869930249: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case -1077557351: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case 251692112: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case 261900585: {
                if (bl) {
                    if (n2 != -141377623) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case 509450677: {
                if (bl) {
                    if (n2 != 896829670) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case 693221473: {
                if (bl) {
                    if (n2 != -585071033) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case 977070273: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case 1244919775: {
                if (bl) {
                    if (n2 != -1985511187) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case 2097630595: {
                if (bl) {
                    if (n2 != 2010712203) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
        }
        return n3;
    }

    private int a4(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2133313908: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case 108404676: {
                if (bl) {
                    if (n2 != 589980844) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
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
            case -1909164674: {
                n2 = this.a2(n4, bl, n);
                break;
            }
            case -1906607067: {
                n2 = this.a4(n4, bl, n);
                break;
            }
            case -1786570553: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -965304261: {
                n2 = this.a3(n4, bl, n);
                break;
            }
            case 1794668173: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((SplitScreenTargetHSM)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 1: {
                ((SplitScreenTargetHSM)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((SplitScreenTargetHSM)object).notifyModel();
                return null;
            }
            case 3: {
                ((SplitScreenTargetHSM)object).reloadPersistedData();
                return null;
            }
            case 4: {
                return ((SplitScreenTargetHSM)object).getInternalAPINotifier();
            }
            case 5: {
                ((SplitScreenTargetHSM)object).setInternalAPINotifier((SplitscreenInternalAPINotifier)objectArray[0]);
                return null;
            }
            case 6: {
                ((SplitScreenTargetHSM)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((Target10Plus0Box)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 8: {
                ((Target10Plus0Box)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((Target10Plus0Box)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((Target10Plus0Box)object).traceState((String)objectArray[0]);
                return null;
            }
            case 11: {
                ((Target10Plus0Box)object).dsiNavigationUpdateRgActive((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((Target10Plus0Box)object).dsiNavigationUpdateRgInfoForNextDestination((RgInfoForNextDestination)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((Target10Plus0Box)object).dsiNavigationUpdateRgDestinationInfo((NavRouteListData[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((Target10Plus0Box)object).dsiNavigationUpdateRgCurrentRoute((Route)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((Target10Plus0Box)object).dsiNavigationUpdateRgTurnList((TurnListElement[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((Target10Plus0Box)object).dsiNavigationUpdateRgPoiInfo((NavPoiInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((Target10Plus0Box)object).dsiTmcOnRouteUpdateTmcMessagesAhead((TmcMessage[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                return ((Target10Plus0Box)object).createManeuverListElement((TurnListElement)objectArray[0]);
            }
            case 19: {
                return ((Target10Plus0Box)object).createManeuverListElement((TmcMessage)objectArray[0]);
            }
            case 20: {
                return ((Target10Plus0Box)object).getDefaultIcon();
            }
            case 21: {
                ((Target10Plus0Box)object).handleIconCacheUpdate((IconKey)objectArray[0], (ResourceLocator)objectArray[1], objectArray[2]);
                return null;
            }
            case 22: {
                ((Target10Plus0Box)object).handleNavigationSettingsReset();
                return null;
            }
            case 23: {
                ((Target3Plus1Box)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 24: {
                return Target3Plus1Box.getLogger();
            }
            case 25: {
                ((Target3Plus1Box)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 26: {
                ((Target3Plus1Box)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 27: {
                ((Target3Plus1Box)object).traceState((String)objectArray[0]);
                return null;
            }
            case 28: {
                ((Target3Plus1Box)object).dsiNavigationUpdateRgActive((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 29: {
                ((Target3Plus1Box)object).dsiNavigationUpdateRgInfoForNextDestination((RgInfoForNextDestination)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 30: {
                ((Target3Plus1Box)object).dsiNavigationUpdateRgCurrentRoute((Route)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 31: {
                ((Target3Plus1Box)object).dsiNavigationUpdateRgTurnList((TurnListElement[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((Target3Plus1Box)object).dsiNavigationUpdateRgPoiInfo((NavPoiInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 33: {
                ((Target3Plus1Box)object).dsiTmcOnRouteUpdateTmcMessagesAhead((TmcMessage[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 34: {
                return ((Target3Plus1Box)object).getDefaultIcon();
            }
            case 35: {
                ((Target3Plus1Box)object).handleIconCacheUpdate((IconKey)objectArray[0], (ResourceLocator)objectArray[1], objectArray[2]);
                return null;
            }
            case 36: {
                ((Target3Plus1Box)object).initDSI();
                return null;
            }
            case 37: {
                ((Target3Plus1Box)object).dsiMapViewerManeuverViewUpdateManoeuvreViewsAvailable((short[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 38: {
                ((Target3Plus1Box)object).dsiMapViewerManeuverViewUpdateManoeuvreViewActive(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 39: {
                ((Target3Plus1Box)object).dsiNavigationUpdateBapTurnToInfo((BapTurnToInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 40: {
                ((TargetMotorwayInfo)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 41: {
                ((TargetMotorwayInfo)object).registered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 42: {
                ((TargetMotorwayInfo)object).unregistered((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 43: {
                ((TargetMotorwayInfo)object).traceState((String)objectArray[0]);
                return null;
            }
            case 44: {
                ((TargetMotorwayInfo)object).dsiNavigationUpdateRgInfoForNextDestination((RgInfoForNextDestination)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 45: {
                ((TargetMotorwayInfo)object).dsiTmcOnRouteUpdateTmcMessagesAhead((TmcMessage[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 46: {
                return ((TargetMotorwayInfo)object).getDefaultIcon();
            }
            case 47: {
                ((TargetMotorwayInfo)object).handleIconCacheUpdate((IconKey)objectArray[0], (ResourceLocator)objectArray[1], objectArray[2]);
                return null;
            }
            case 48: {
                ((TargetMotorwayInfo)object).dsiTmcOnRouteUpdateSpeedAndFlowAhead((SpeedAndFlowSegment[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 49: {
                ((TargetMotorwayInfo)object).dsiNavigationUpdateRgMotorwayInfo((NavPoiInfo[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 50: {
                ((TargetMotorwayInfo)object).dsiNavigationUpdateRgVirtualDestinationInfo((RgInfoForNextDestination)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 51: {
                ((OverlaysTargetHSM)object).reset((HashMap)objectArray[0]);
                return null;
            }
            case 52: {
                ((OverlaysTargetHSM)object).registerDSI();
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

