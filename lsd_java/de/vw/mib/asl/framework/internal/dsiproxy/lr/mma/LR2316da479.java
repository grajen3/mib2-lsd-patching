/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.generalvehiclestates.DSIGeneralVehicleStates;
import org.dsi.ifc.generalvehiclestates.TLOInfoElement;
import org.dsi.ifc.has.DSIHAS;
import org.dsi.ifc.has.HASDataContainer;

public final class LR2316da479
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1826057869: {
                if (bl) {
                    if (n2 != -763533660) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 4;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 5;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 6;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1126828932: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 7;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 8;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 9;
                    break;
                }
                n3 = 7;
                break;
            }
            case 1465660520: {
                if (bl) {
                    if (n2 != 1237832130) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 1902197364: {
                if (bl) {
                    if (n2 != 17) break;
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
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 13;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 14;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 15;
                    break;
                }
                n3 = 13;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 16;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 17;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 18;
                    break;
                }
                n3 = 16;
                break;
            }
            case -856788933: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -241376366: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 800807156: {
                if (bl) {
                    if (n2 != -495644786) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
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
            case 1029625071: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1155386963: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIHAS)object).hmiReady();
                return null;
            }
            case 1: {
                ((DSIHAS)object).actionResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (HASDataContainer[])objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 2: {
                ((DSIHAS)object).propertyUpdate(((Number)objectArray[0]).intValue(), (HASDataContainer[])objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 3: {
                ((DSIHAS)object).subscribeResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 4: {
                ((DSIHAS)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 5: {
                ((DSIHAS)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 6: {
                ((DSIHAS)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 7: {
                ((DSIHAS)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 8: {
                ((DSIHAS)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 9: {
                ((DSIHAS)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 10: {
                ((DSIGeneralVehicleStates)object).setDSSSKombiWarning(((Number)objectArray[0]).intValue());
                return null;
            }
            case 11: {
                ((DSIGeneralVehicleStates)object).setTLOData(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), (TLOInfoElement[])objectArray[2]);
                return null;
            }
            case 12: {
                ((DSIGeneralVehicleStates)object).setAppConnectState((Boolean)objectArray[0]);
                return null;
            }
            case 13: {
                ((DSIGeneralVehicleStates)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 14: {
                ((DSIGeneralVehicleStates)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 15: {
                ((DSIGeneralVehicleStates)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 16: {
                ((DSIGeneralVehicleStates)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 17: {
                ((DSIGeneralVehicleStates)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 18: {
                ((DSIGeneralVehicleStates)object).clearNotification((DSIListener)objectArray[0]);
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

