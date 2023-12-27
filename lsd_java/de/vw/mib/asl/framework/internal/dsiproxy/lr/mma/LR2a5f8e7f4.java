/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.DSIMapViewerRouteBlock;
import org.dsi.ifc.map.DSIMapViewerStreetViewCtrl;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.StreetViewThumbnail;

public final class LR2a5f8e7f4
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1349852939: {
                if (bl) {
                    if (n2 != 216567625) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 6;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 7;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 8;
                    break;
                }
                n3 = 6;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 9;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 10;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 11;
                    break;
                }
                n3 = 9;
                break;
            }
            case -816116648: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 961450207: {
                if (bl) {
                    if (n2 != 1372686599) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case 1182998008: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 1909622772: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 2015076042: {
                if (bl) {
                    if (n2 != 571278) break;
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
            case -1834667745: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
                break;
            }
            case -1557841376: {
                if (bl) {
                    if (n2 != 17850877) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case -1485355905: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -1254737777: {
                if (bl) {
                    if (n2 != 1359336183) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1162471198: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 34;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 35;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 36;
                    break;
                }
                n3 = 34;
                break;
            }
            case -948729267: {
                if (bl) {
                    if (n2 == -904616957) {
                        n3 = 37;
                        break;
                    }
                    if (n2 == 1805755651) {
                        n3 = 38;
                        break;
                    }
                    if (n2 != -864245041) break;
                    n3 = 39;
                    break;
                }
                n3 = 37;
                break;
            }
            case -815176690: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case -719832978: {
                if (bl) {
                    if (n2 != -1854609956) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case -569560978: {
                if (bl) {
                    if (n2 != -1854609956) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -505495759: {
                if (bl) {
                    if (n2 != 228217929) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -155113303: {
                if (bl) {
                    if (n2 != 1371138611) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case -78681835: {
                if (bl) {
                    if (n2 != 1359336183) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -34820215: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case -19365565: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 109572186: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 284874809: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case 381559189: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 733273934: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case 748836980: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 1062693642: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 1065213372: {
                if (bl) {
                    if (n2 != -786116603) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 1121501848: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case 1359525181: {
                if (bl) {
                    if (n2 != 17) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 1439561444: {
                if (bl) {
                    if (n2 != 1977223710) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
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
            case -850396076: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case -110529979: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIMapViewerRouteBlock)object).rBMarkNextSegment();
                return null;
            }
            case 1: {
                ((DSIMapViewerRouteBlock)object).rBMarkPreviousSegment();
                return null;
            }
            case 2: {
                ((DSIMapViewerRouteBlock)object).rBSetSegmentScales(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).longValue());
                return null;
            }
            case 3: {
                ((DSIMapViewerRouteBlock)object).rBStartOfSelection();
                return null;
            }
            case 4: {
                ((DSIMapViewerRouteBlock)object).pickSegmentUidsInScreenSpace((Point)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSIMapViewerRouteBlock)object).highLightSegmentUidsInMap((long[])objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 6: {
                ((DSIMapViewerRouteBlock)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 7: {
                ((DSIMapViewerRouteBlock)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 8: {
                ((DSIMapViewerRouteBlock)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 9: {
                ((DSIMapViewerRouteBlock)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 10: {
                ((DSIMapViewerRouteBlock)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 11: {
                ((DSIMapViewerRouteBlock)object).clearNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 12: {
                ((DSIMapViewerStreetViewCtrl)object).snapshot();
                return null;
            }
            case 13: {
                ((DSIMapViewerStreetViewCtrl)object).setPosition((NavLocationWgs84)objectArray[0]);
                return null;
            }
            case 14: {
                ((DSIMapViewerStreetViewCtrl)object).getInfoForScreenPosition((short)((Number)objectArray[0]).intValue(), (short)((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSIMapViewerStreetViewCtrl)object).streetViewEnabled((Boolean)objectArray[0]);
                return null;
            }
            case 16: {
                ((DSIMapViewerStreetViewCtrl)object).streetViewVisible((Boolean)objectArray[0]);
                return null;
            }
            case 17: {
                ((DSIMapViewerStreetViewCtrl)object).streetViewFreeze((Boolean)objectArray[0]);
                return null;
            }
            case 18: {
                ((DSIMapViewerStreetViewCtrl)object).goToView();
                return null;
            }
            case 19: {
                ((DSIMapViewerStreetViewCtrl)object).setStreetViewZoomIndex(((Number)objectArray[0]).intValue());
                return null;
            }
            case 20: {
                ((DSIMapViewerStreetViewCtrl)object).streetViewThumbnails((StreetViewThumbnail[])objectArray[0]);
                return null;
            }
            case 21: {
                ((DSIMapViewerStreetViewCtrl)object).loadStreetView((Boolean)objectArray[0]);
                return null;
            }
            case 22: {
                ((DSIMapViewerStreetViewCtrl)object).rotateView((short)((Number)objectArray[0]).intValue(), (short)((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((DSIMapViewerStreetViewCtrl)object).rotateViewByPolarCoordinates(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 24: {
                ((DSIMapViewerStreetViewCtrl)object).setAzimuth(((Number)objectArray[0]).intValue());
                return null;
            }
            case 25: {
                ((DSIMapViewerStreetViewCtrl)object).setInclination(((Number)objectArray[0]).intValue());
                return null;
            }
            case 26: {
                ((DSIMapViewerStreetViewCtrl)object).setCrossHairsVisibility((Boolean)objectArray[0]);
                return null;
            }
            case 27: {
                ((DSIMapViewerStreetViewCtrl)object).setDayNightView((Boolean)objectArray[0]);
                return null;
            }
            case 28: {
                ((DSIMapViewerStreetViewCtrl)object).setViewRotationByPolarCoordinates(((Number)objectArray[0]).floatValue(), ((Number)objectArray[1]).floatValue());
                return null;
            }
            case 29: {
                ((DSIMapViewerStreetViewCtrl)object).startViewRotationByPolarCoordinates(((Number)objectArray[0]).floatValue(), ((Number)objectArray[1]).floatValue());
                return null;
            }
            case 30: {
                ((DSIMapViewerStreetViewCtrl)object).stopViewRotationByPolarCoordinates();
                return null;
            }
            case 31: {
                ((DSIMapViewerStreetViewCtrl)object).setScreenViewport((Rect)objectArray[0]);
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIMapViewerStreetViewCtrl)object).setCrossHairsPosition((Point)objectArray[0]);
                return null;
            }
            case 33: {
                ((DSIMapViewerStreetViewCtrl)object).setStreetViewZoomLevel(((Number)objectArray[0]).floatValue());
                return null;
            }
            case 34: {
                ((DSIMapViewerStreetViewCtrl)object).setNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 35: {
                ((DSIMapViewerStreetViewCtrl)object).setNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 36: {
                ((DSIMapViewerStreetViewCtrl)object).setNotification((DSIListener)objectArray[0]);
                return null;
            }
            case 37: {
                ((DSIMapViewerStreetViewCtrl)object).clearNotification((int[])objectArray[0], (DSIListener)objectArray[1]);
                return null;
            }
            case 38: {
                ((DSIMapViewerStreetViewCtrl)object).clearNotification(((Number)objectArray[0]).intValue(), (DSIListener)objectArray[1]);
                return null;
            }
            case 39: {
                ((DSIMapViewerStreetViewCtrl)object).clearNotification((DSIListener)objectArray[0]);
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

