/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.navservicesapi.AddressData;
import org.dsi.ifc.navservicesapi.BapManeuverDescriptor;
import org.dsi.ifc.navservicesapi.DSINavAsiaBAPClusterInstrumentListener;
import org.dsi.ifc.navservicesapi.DSINavAsiaMapControlListener;
import org.dsi.ifc.navservicesapi.LDListElement;
import org.dsi.ifc.navservicesapi.NavLaneGuidanceData;
import org.dsi.ifc.navservicesapi.TrafficInfo;

public final class LR2a50a0ba2
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2141920119: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -2101226386: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -1949223298: {
                if (bl) {
                    if (n2 != 401010404) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1949210786: {
                if (bl) {
                    if (n2 != -266965504) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1866473536: {
                if (bl) {
                    if (n2 != 662227646) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -1847638235: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -1760160313: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1681399998: {
                if (bl) {
                    if (n2 != -1263650931) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -1575834166: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1510832436: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -1238307643: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -1160512316: {
                if (bl) {
                    if (n2 != -1028403557) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -1145982982: {
                if (bl) {
                    if (n2 != -642053452) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -551509772: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -380241750: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -359920826: {
                if (bl) {
                    if (n2 != 1956540882) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -309884644: {
                if (bl) {
                    if (n2 != -550307285) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 527273349: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 629468860: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 891663083: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 1325043556: {
                if (bl) {
                    if (n2 != -1626327342) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1410694546: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 1608399996: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 1676444173: {
                if (bl) {
                    if (n2 != -575291835) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1635806712: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -1454592227: {
                if (bl) {
                    if (n2 != -797832442) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case -739932358: {
                if (bl) {
                    if (n2 != -797832442) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 2066033117: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 2117904410: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
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
            case -628493780: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 253365691: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSINavAsiaBAPClusterInstrumentListener)object).updateCompassInfo(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 1: {
                ((DSINavAsiaBAPClusterInstrumentListener)object).updateDistanceToNextManeuver(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (Boolean)objectArray[2], ((Number)objectArray[3]).intValue(), ((Number)objectArray[4]).intValue());
                return null;
            }
            case 2: {
                ((DSINavAsiaBAPClusterInstrumentListener)object).dmLastDestinationsGetResult(((Number)objectArray[0]).intValue(), (AddressData[])objectArray[1]);
                return null;
            }
            case 3: {
                ((DSINavAsiaBAPClusterInstrumentListener)object).updateRGStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSINavAsiaBAPClusterInstrumentListener)object).updateCurrentPositionInfo((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSINavAsiaBAPClusterInstrumentListener)object).updateTurnToInfo((String)objectArray[0], (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 6: {
                ((DSINavAsiaBAPClusterInstrumentListener)object).updateDistanceToDestination(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 7: {
                ((DSINavAsiaBAPClusterInstrumentListener)object).updateNavigationTimeInfoType(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSINavAsiaBAPClusterInstrumentListener)object).updateRTT(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSINavAsiaBAPClusterInstrumentListener)object).updateETA(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).longValue(), (Boolean)objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 10: {
                ((DSINavAsiaBAPClusterInstrumentListener)object).updateCityName((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSINavAsiaBAPClusterInstrumentListener)object).updateSemiDynRoute((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSINavAsiaBAPClusterInstrumentListener)object).updateTrafficOffset(((Number)objectArray[0]).intValue(), (short)((Number)objectArray[1]).intValue(), (short)((Number)objectArray[2]).intValue(), (short)((Number)objectArray[3]).intValue(), (Boolean)objectArray[4], ((Number)objectArray[5]).intValue());
                return null;
            }
            case 13: {
                ((DSINavAsiaBAPClusterInstrumentListener)object).updateManeuverDescriptor((BapManeuverDescriptor[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSINavAsiaBAPClusterInstrumentListener)object).updateLaneGuidance((Boolean)objectArray[0], (NavLaneGuidanceData[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 15: {
                ((DSINavAsiaBAPClusterInstrumentListener)object).updateTrafficInformation((TrafficInfo[])objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 16: {
                ((DSINavAsiaBAPClusterInstrumentListener)object).updateDMLastDestinationsList((LDListElement[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSINavAsiaBAPClusterInstrumentListener)object).routeGuidanceActDeactResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 18: {
                ((DSINavAsiaBAPClusterInstrumentListener)object).repeatLastNavAnnouncementResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 19: {
                ((DSINavAsiaBAPClusterInstrumentListener)object).updateNavAnnouncementState((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSINavAsiaBAPClusterInstrumentListener)object).updateVoiceGuidanceState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 21: {
                ((DSINavAsiaBAPClusterInstrumentListener)object).updateInfoStates(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 22: {
                ((DSINavAsiaBAPClusterInstrumentListener)object).setActiveRGTypeResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 23: {
                ((DSINavAsiaBAPClusterInstrumentListener)object).updateTrafficBlockIndication(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 24: {
                ((DSINavAsiaBAPClusterInstrumentListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 25: {
                ((DSINavAsiaMapControlListener)object).updateDataRate(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 26: {
                ((DSINavAsiaMapControlListener)object).updateZoomLevel(((Number)objectArray[0]).floatValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 27: {
                ((DSINavAsiaMapControlListener)object).updateRecommendedZoom(((Number)objectArray[0]).floatValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 28: {
                ((DSINavAsiaMapControlListener)object).updateMapStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 29: {
                ((DSINavAsiaMapControlListener)object).updateViewType(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 30: {
                ((DSINavAsiaMapControlListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

