/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.powermanagement.ClampSignal;
import org.dsi.ifc.powermanagement.DSIPowerManagementListener;
import org.dsi.ifc.predictivenavigation.DSIPredictiveNavigationListener;
import org.dsi.ifc.predictivenavigation.LikelyDestination;

public final class LR26bd1bbbb
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1975977634: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1889326041: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -134641977: {
                if (bl) {
                    if (n2 != -372683487) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 39174102: {
                if (bl) {
                    if (n2 != 1676164096) break;
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
            case -2136959697: {
                if (bl) {
                    if (n2 != 1810428024) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -2133906895: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -2127679480: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -2027001795: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -1158153293: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1035212667: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -220233537: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -123088129: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 1021492431: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case 1263379239: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
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
            case -1906780125: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -654671583: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIPredictiveNavigationListener)object).updateOperationMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSIPredictiveNavigationListener)object).updateLikelyDestinations((LikelyDestination[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSIPredictiveNavigationListener)object).updateMaxPredictions(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSIPredictiveNavigationListener)object).clearCacheResult();
                return null;
            }
            case 4: {
                ((DSIPredictiveNavigationListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 5: {
                ((DSIPowerManagementListener)object).updatePowerManagementState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 6: {
                ((DSIPowerManagementListener)object).updatePowerManagementStateRight(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 7: {
                ((DSIPowerManagementListener)object).updateBEMState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSIPowerManagementListener)object).updateTelMaxPopup((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSIPowerManagementListener)object).updateTStandbyPopup((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSIPowerManagementListener)object).updateClampSignal((ClampSignal)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSIPowerManagementListener)object).updateRVCActive((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSIPowerManagementListener)object).updateChildLockState(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((DSIPowerManagementListener)object).updateLastOn(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSIPowerManagementListener)object).updateSplashScreenAnimation(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSIPowerManagementListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

