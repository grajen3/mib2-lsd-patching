/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.map.DSIMapViewerLandmarkPlayerListener;
import org.dsi.ifc.map.DSIMapViewerManeuverViewListener;

public final class LR22e5ec284
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
            case -721197621: {
                if (bl) {
                    if (n2 != -866436352) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -576093061: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 932197723: {
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
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 1826398154: {
                if (bl) {
                    if (n2 != -786116603) break;
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
            case -1296342898: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 1498009715: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIMapViewerManeuverViewListener)object).updateManoeuvreViewActive(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 1: {
                ((DSIMapViewerManeuverViewListener)object).updateManoeuvreViewsAvailable((short[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 2: {
                ((DSIMapViewerManeuverViewListener)object).updateBapExitViewId(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 3: {
                ((DSIMapViewerManeuverViewListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 4: {
                ((DSIMapViewerLandmarkPlayerListener)object).showLandmark(((Number)objectArray[0]).floatValue());
                return null;
            }
            case 5: {
                ((DSIMapViewerLandmarkPlayerListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

