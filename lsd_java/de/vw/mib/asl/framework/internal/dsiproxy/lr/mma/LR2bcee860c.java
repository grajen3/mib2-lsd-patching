/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.map.DSIMapViewerLandmarkPlayer;
import org.dsi.ifc.map.DSIMapViewerManeuverView;
import org.dsi.ifc.map.Point;

public final class LR2bcee860c
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1782807587: {
                if (bl) {
                    if (n2 != -633848249) break;
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
            case -1060747038: {
                if (bl) {
                    if (n2 != -1600866162) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
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
            case -129620653: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 824885852: {
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
                        n3 = 12;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 13;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 14;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1054372593: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 15;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 16;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 17;
                    break;
                }
                n3 = 15;
                break;
            }
            case 1826398154: {
                if (bl) {
                    if (n2 != 1839377232) break;
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
            case -858295905: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 2082229434: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIMapViewerManeuverView)object).hideManoeuvreView();
                return null;
            }
            case 1: {
                ((DSIMapViewerManeuverView)object).selectManoeuvreView(((Number)objectArray[0]).intValue(), (Boolean)objectArray[1]);
                return null;
            }
            case 2: {
                ((DSIMapViewerManeuverView)object).setDistanceString((String)objectArray[0]);
                return null;
            }
            case 3: {
                ((DSIMapViewerManeuverView)object).disableManeuverViewGeneration((Boolean)objectArray[0]);
                return null;
            }
            case 4: {
                ((DSIMapViewerManeuverView)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 5: {
                ((DSIMapViewerManeuverView)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 6: {
                ((DSIMapViewerManeuverView)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 7: {
                ((DSIMapViewerManeuverView)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 8: {
                ((DSIMapViewerManeuverView)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 9: {
                ((DSIMapViewerManeuverView)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 10: {
                ((DSIMapViewerLandmarkPlayer)object).hideLandmark();
                return null;
            }
            case 11: {
                ((DSIMapViewerLandmarkPlayer)object).showLandmark((Point)objectArray[0], ((Number)objectArray[1]).longValue());
                return null;
            }
            case 12: {
                ((DSIMapViewerLandmarkPlayer)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 13: {
                ((DSIMapViewerLandmarkPlayer)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 14: {
                ((DSIMapViewerLandmarkPlayer)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 15: {
                ((DSIMapViewerLandmarkPlayer)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 16: {
                ((DSIMapViewerLandmarkPlayer)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 17: {
                ((DSIMapViewerLandmarkPlayer)object).clearNotification((DSIListener)objectArray[0]);
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

