/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.map.DSIMapViewerZoomEngine;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.media.DSIMediaBase;

public final class LR2abab5721
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2049324529: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1421940745: {
                if (bl) {
                    if (n2 != 1371138611) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1393066421: {
                if (bl) {
                    if (n2 != -790938727) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -1162471198: {
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
            case -1109785482: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 10;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 11;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 12;
                    break;
                }
                n3 = 10;
                break;
            }
            case -882432560: {
                if (bl) {
                    if (n2 != 228217929) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -625641286: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1154726317: {
                if (bl) {
                    if (n2 != -242842362) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
        }
        return n3;
    }

    private int a1(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -2108791390: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -1526929106: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 22;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 23;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 24;
                    break;
                }
                n3 = 22;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 25;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 26;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 27;
                    break;
                }
                n3 = 25;
                break;
            }
            case -675127325: {
                if (bl) {
                    if (n2 != 847005443) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -283450096: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 177189683: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case 232088363: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 288217627: {
                if (bl) {
                    if (n2 != 1372686599) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 570853676: {
                if (bl) {
                    if (n2 != -633848249) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 1211451291: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
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
            case -2047808906: {
                n2 = this.a0(n4, bl, n);
                break;
            }
            case 1177909408: {
                n2 = this.a1(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIMapViewerZoomEngine)object).setCarPosition((Point)objectArray[0]);
                return null;
            }
            case 1: {
                ((DSIMapViewerZoomEngine)object).setViewType(((Number)objectArray[0]).intValue());
                return null;
            }
            case 2: {
                ((DSIMapViewerZoomEngine)object).setZoomArea((Rect)objectArray[0]);
                return null;
            }
            case 3: {
                ((DSIMapViewerZoomEngine)object).autoZoomEnable((Boolean)objectArray[0]);
                return null;
            }
            case 4: {
                ((DSIMapViewerZoomEngine)object).manoeuvreZoomEnable((Boolean)objectArray[0]);
                return null;
            }
            case 5: {
                ((DSIMapViewerZoomEngine)object).setMapRotation((short)((Number)objectArray[0]).intValue());
                return null;
            }
            case 6: {
                ((DSIMapViewerZoomEngine)object).setMapOrientation(((Number)objectArray[0]).intValue(), (Point)objectArray[1]);
                return null;
            }
            case 7: {
                ((DSIMapViewerZoomEngine)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 8: {
                ((DSIMapViewerZoomEngine)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 9: {
                ((DSIMapViewerZoomEngine)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 10: {
                ((DSIMapViewerZoomEngine)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 11: {
                ((DSIMapViewerZoomEngine)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 12: {
                ((DSIMapViewerZoomEngine)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 13: {
                ((DSIMediaBase)object).profileChange(((Number)objectArray[0]).intValue());
                return null;
            }
            case 14: {
                ((DSIMediaBase)object).profileCopy(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSIMediaBase)object).profileReset(((Number)objectArray[0]).intValue());
                return null;
            }
            case 16: {
                ((DSIMediaBase)object).profileResetAll();
                return null;
            }
            case 17: {
                ((DSIMediaBase)object).setPreferredLanguage((String)objectArray[0]);
                return null;
            }
            case 18: {
                ((DSIMediaBase)object).setParentalML(((Number)objectArray[0]).intValue());
                return null;
            }
            case 19: {
                ((DSIMediaBase)object).ejectMedium(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue());
                return null;
            }
            case 20: {
                ((DSIMediaBase)object).requestResetFactorySettings(((Number)objectArray[0]).intValue());
                return null;
            }
            case 21: {
                ((DSIMediaBase)object).launchApp(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue(), (String)objectArray[2]);
                return null;
            }
            case 22: {
                ((DSIMediaBase)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 23: {
                ((DSIMediaBase)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 24: {
                ((DSIMediaBase)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 25: {
                ((DSIMediaBase)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 26: {
                ((DSIMediaBase)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 27: {
                ((DSIMediaBase)object).clearNotification((DSIListener)objectArray[0]);
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

