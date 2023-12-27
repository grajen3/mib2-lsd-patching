/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.DSIMapViewerRouteBlockListener;
import org.dsi.ifc.map.DSIMapViewerStreetViewCtrlListener;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.RouteBrowserInfo;
import org.dsi.ifc.map.StreetViewThumbnail;

public final class LR2fa9f2e50
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1990187699: {
                if (bl) {
                    if (n2 != 1948796446) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -1900074634: {
                if (bl) {
                    if (n2 != 120771) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case -1853607505: {
                if (bl) {
                    if (n2 != 407939732) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1717387369: {
                if (bl) {
                    if (n2 != -1084540160) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case -1699536395: {
                if (bl) {
                    if (n2 != -797832442) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
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
            case -1485355905: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -574069947: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case -554706704: {
                if (bl) {
                    if (n2 != 1342645812) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -503311170: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case 70234051: {
                if (bl) {
                    if (n2 != 393196160) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case 226670925: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case 733273934: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 748836980: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 829871580: {
                if (bl) {
                    if (n2 != 1043255048) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case 1617977223: {
                if (bl) {
                    if (n2 != 6200573) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
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
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case -1190862607: {
                if (bl) {
                    if (n2 != -266965504) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case 67494901: {
                if (bl) {
                    if (n2 != -266965504) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case 82430766: {
                if (bl) {
                    if (n2 != 1493684582) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case 205305138: {
                if (bl) {
                    if (n2 != -297599610) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case 639303495: {
                if (bl) {
                    if (n2 != -615691881) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 822708821: {
                if (bl) {
                    if (n2 != -266965504) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
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
            case -130299111: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 435869224: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIMapViewerStreetViewCtrlListener)object).getInfoForPosition((PosInfo[])objectArray[0]);
                return null;
            }
            case 1: {
                ((DSIMapViewerStreetViewCtrlListener)object).streetViewEnabled((Boolean)objectArray[0]);
                return null;
            }
            case 2: {
                ((DSIMapViewerStreetViewCtrlListener)object).streetViewVisible((Boolean)objectArray[0]);
                return null;
            }
            case 3: {
                ((DSIMapViewerStreetViewCtrlListener)object).streetViewFreeze((Boolean)objectArray[0]);
                return null;
            }
            case 4: {
                ((DSIMapViewerStreetViewCtrlListener)object).updateStreetViewLoadStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 5: {
                ((DSIMapViewerStreetViewCtrlListener)object).updateStreetViewAvailable((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSIMapViewerStreetViewCtrlListener)object).updateStreetViewZoomListIndex(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSIMapViewerStreetViewCtrlListener)object).updateStreetViewZoomList((float[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSIMapViewerStreetViewCtrlListener)object).updateStreetViewThumbnails((StreetViewThumbnail[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSIMapViewerStreetViewCtrlListener)object).updatePosition((NavLocationWgs84)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSIMapViewerStreetViewCtrlListener)object).updateRotation(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 11: {
                ((DSIMapViewerStreetViewCtrlListener)object).snapshotResult((StreetViewThumbnail)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSIMapViewerStreetViewCtrlListener)object).updateScreenViewPort((Rect)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((DSIMapViewerStreetViewCtrlListener)object).updateStreetViewZoomLevel(((Number)objectArray[0]).floatValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSIMapViewerStreetViewCtrlListener)object).updateStreetViewPosition((NavLocationWgs84)objectArray[0], (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 15: {
                ((DSIMapViewerStreetViewCtrlListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 16: {
                ((DSIMapViewerRouteBlockListener)object).updateRBInfoOfSelectedSegments((RouteBrowserInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSIMapViewerRouteBlockListener)object).pickSegmentUidsInScreenSpaceResult((Point)objectArray[0], ((Number)objectArray[1]).intValue(), (long[])objectArray[2], ((Number)objectArray[3]).intValue());
                return null;
            }
            case 18: {
                ((DSIMapViewerRouteBlockListener)object).highLightSegmentUidsInMapResult((long[])objectArray[0], (Boolean)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 19: {
                ((DSIMapViewerRouteBlockListener)object).rBStartOfSelectionResult(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSIMapViewerRouteBlockListener)object).rBMarkNextSegmentResult(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 21: {
                ((DSIMapViewerRouteBlockListener)object).rBMarkPreviousSegmentResult(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 22: {
                ((DSIMapViewerRouteBlockListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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

