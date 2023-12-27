/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.generalvehiclestates.AirbagData;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStatesListener;
import org.dsi.ifc.generalvehiclestates.TLOViewOptions;
import org.dsi.ifc.generalvehiclestates.TankInfo;
import org.dsi.ifc.global.CarViewOption;
import org.dsi.ifc.has.DSIHASListener;
import org.dsi.ifc.has.HASDataContainer;

public final class LR2c31321e1
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2099282204: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -2042119305: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -1775989761: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -1720953672: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1690696840: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -1597981250: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case -1480830148: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -958667264: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -934635678: {
                if (bl) {
                    if (n2 != 1030378054) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -874992050: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -741208950: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -623440028: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -582616626: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -498495080: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -210690169: {
                if (bl) {
                    if (n2 != 1030378054) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case -190318126: {
                if (bl) {
                    if (n2 != -1151649024) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 135481442: {
                if (bl) {
                    if (n2 != 1996663052) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 316559126: {
                if (bl) {
                    if (n2 != 785816057) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 381233533: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 667115400: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 1046543968: {
                if (bl) {
                    if (n2 != -1198601806) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 1092381542: {
                if (bl) {
                    if (n2 != 1041280648) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1422538068: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case 1504306225: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 1656881598: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1716368712: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1793885851: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 1840754992: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1972487919: {
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

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1811036690: {
                if (bl) {
                    if (n2 != -1565610619) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -1663524396: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case -573831078: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case 93534009: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case 1567999219: {
                if (bl) {
                    if (n2 != 1687814400) break;
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
            case 522249155: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1129462055: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIGeneralVehicleStatesListener)object).updateAirbagData((AirbagData)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSIGeneralVehicleStatesListener)object).updateTankInfo((TankInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSIGeneralVehicleStatesListener)object).updateDimmedHeadlight((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSIGeneralVehicleStatesListener)object).updateAcousticParkingSystem((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSIGeneralVehicleStatesListener)object).updateReverseGear((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSIGeneralVehicleStatesListener)object).updateVehicleStandstill((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSIGeneralVehicleStatesListener)object).updateCarVelocityThreshold((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSIGeneralVehicleStatesListener)object).updateTVVelocityThreshold((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSIGeneralVehicleStatesListener)object).updateHDDVelocityThreshold((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSIGeneralVehicleStatesListener)object).updateBrowserSlideShowVelocityThreshold((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSIGeneralVehicleStatesListener)object).updateBrowserBordBookVelocityThreshold((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSIGeneralVehicleStatesListener)object).updateBrowserTravelAgentVelocityThreshold((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSIGeneralVehicleStatesListener)object).updateBrowserWebVelocityThreshold((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((DSIGeneralVehicleStatesListener)object).updateBWSVelocityThreshold((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSIGeneralVehicleStatesListener)object).updateRadiotextVelocityThreshold((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSIGeneralVehicleStatesListener)object).updateDisplayDayNightDesign((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSIGeneralVehicleStatesListener)object).updateBTBondingVelocityThreshold((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSIGeneralVehicleStatesListener)object).updateMessagingVelocityThreshold((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                ((DSIGeneralVehicleStatesListener)object).updateDestinationInputVelocityThreshold((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((DSIGeneralVehicleStatesListener)object).updateDSSSViewOption((CarViewOption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSIGeneralVehicleStatesListener)object).updateServiceKeyData((byte[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 21: {
                ((DSIGeneralVehicleStatesListener)object).updateServiceKeyViewOption((CarViewOption)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 22: {
                ((DSIGeneralVehicleStatesListener)object).updatePersonalizationStatus((Boolean)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 23: {
                ((DSIGeneralVehicleStatesListener)object).updateTLOViewOptions((TLOViewOptions)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 24: {
                ((DSIGeneralVehicleStatesListener)object).updateEmergencyAssistVolLowering(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 25: {
                ((DSIGeneralVehicleStatesListener)object).updateParkingBrake((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 26: {
                ((DSIGeneralVehicleStatesListener)object).updateAppConnectTrigger(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 27: {
                ((DSIGeneralVehicleStatesListener)object).updateSTPState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 28: {
                ((DSIGeneralVehicleStatesListener)object).updateAutomaticGearShiftTransMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 29: {
                ((DSIGeneralVehicleStatesListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 30: {
                ((DSIHASListener)object).actionRequest(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (HASDataContainer[])objectArray[2]);
                return null;
            }
            case 31: {
                ((DSIHASListener)object).subscribeRequest(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIHASListener)object).unsubscribeRequest(((Number)objectArray[0]).intValue());
                return null;
            }
            case 33: {
                ((DSIHASListener)object).unsubscribeAllRequest();
                return null;
            }
            case 34: {
                ((DSIHASListener)object).getPropertyRequest(((Number)objectArray[0]).intValue());
                return null;
            }
            case 35: {
                ((DSIHASListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

