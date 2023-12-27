/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.dsiproxy.lr.mma;

import de.vw.mib.reflection.MultipleMethodAccessibleObject;
import de.vw.mib.reflection.RuntimeUtil;
import java.lang.reflect.InvocationTargetException;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.AvailableRoute;
import org.dsi.ifc.map.DSIMapViewerControlListener;
import org.dsi.ifc.map.DSIMapViewerGoogleCtrlListener;
import org.dsi.ifc.map.LayerProperty;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.RouteBrowserInfo;
import org.dsi.ifc.map.ViewPort;

public final class LR223d4f5c2
extends MultipleMethodAccessibleObject {
    private int a0(int n, boolean bl, int n2) {
        int n3 = -1;
        switch (n) {
            case -1867954458: {
                if (bl) {
                    if (n2 != -254492666) break;
                    n3 = 15;
                    break;
                }
                n3 = 15;
                break;
            }
            case -1855030556: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 52;
                    break;
                }
                n3 = 52;
                break;
            }
            case -1813151420: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 46;
                    break;
                }
                n3 = 46;
                break;
            }
            case -1803275698: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 32;
                    break;
                }
                n3 = 32;
                break;
            }
            case -1791706510: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 17;
                    break;
                }
                n3 = 17;
                break;
            }
            case -1741431948: {
                if (bl) {
                    if (n2 != -238538240) break;
                    n3 = 2;
                    break;
                }
                n3 = 2;
                break;
            }
            case -1711224895: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 55;
                    break;
                }
                n3 = 55;
                break;
            }
            case -1622541400: {
                if (bl) {
                    if (n2 != 1276482132) break;
                    n3 = 69;
                    break;
                }
                n3 = 69;
                break;
            }
            case -1472376458: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 56;
                    break;
                }
                n3 = 56;
                break;
            }
            case -1454592227: {
                if (bl) {
                    if (n2 != -797832442) break;
                    n3 = 12;
                    break;
                }
                n3 = 12;
                break;
            }
            case -1409738139: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 4;
                    break;
                }
                n3 = 4;
                break;
            }
            case -1324501899: {
                if (bl) {
                    if (n2 != 1342645812) break;
                    n3 = 9;
                    break;
                }
                n3 = 9;
                break;
            }
            case -1236005503: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 53;
                    break;
                }
                n3 = 53;
                break;
            }
            case -1215980901: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 35;
                    break;
                }
                n3 = 35;
                break;
            }
            case -1175715463: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 45;
                    break;
                }
                n3 = 45;
                break;
            }
            case -1150632538: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 27;
                    break;
                }
                n3 = 27;
                break;
            }
            case -1123607443: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 14;
                    break;
                }
                n3 = 14;
                break;
            }
            case -1084238076: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 37;
                    break;
                }
                n3 = 37;
                break;
            }
            case -1079848815: {
                if (bl) {
                    if (n2 != 6200573) break;
                    n3 = 16;
                    break;
                }
                n3 = 16;
                break;
            }
            case -1061115217: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 38;
                    break;
                }
                n3 = 38;
                break;
            }
            case -988660295: {
                if (bl) {
                    if (n2 != -1178098921) break;
                    n3 = 57;
                    break;
                }
                n3 = 57;
                break;
            }
            case -939430645: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 68;
                    break;
                }
                n3 = 68;
                break;
            }
            case -919222373: {
                if (bl) {
                    if (n2 != -1636744121) break;
                    n3 = 21;
                    break;
                }
                n3 = 21;
                break;
            }
            case -916923885: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 59;
                    break;
                }
                n3 = 59;
                break;
            }
            case -874403565: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 54;
                    break;
                }
                n3 = 54;
                break;
            }
            case -852492384: {
                if (bl) {
                    if (n2 != 350750879) break;
                    n3 = 40;
                    break;
                }
                n3 = 40;
                break;
            }
            case -761229935: {
                if (bl) {
                    if (n2 != -1034208512) break;
                    n3 = 61;
                    break;
                }
                n3 = 61;
                break;
            }
            case -756890787: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 50;
                    break;
                }
                n3 = 50;
                break;
            }
            case -707343415: {
                if (bl) {
                    if (n2 != -1034208512) break;
                    n3 = 64;
                    break;
                }
                n3 = 64;
                break;
            }
            case -682540039: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 10;
                    break;
                }
                n3 = 10;
                break;
            }
            case -668686384: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 28;
                    break;
                }
                n3 = 28;
                break;
            }
            case -667499942: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 36;
                    break;
                }
                n3 = 36;
                break;
            }
            case -659430773: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 20;
                    break;
                }
                n3 = 20;
                break;
            }
            case -585905969: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 5;
                    break;
                }
                n3 = 5;
                break;
            }
            case -187883915: {
                if (bl) {
                    if (n2 != 1342645812) break;
                    n3 = 8;
                    break;
                }
                n3 = 8;
                break;
            }
            case -174257457: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 62;
                    break;
                }
                n3 = 62;
                break;
            }
            case -142115402: {
                if (bl) {
                    if (n2 != 3524) break;
                    n3 = 0;
                    break;
                }
                n3 = 0;
                break;
            }
            case -13234144: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 22;
                    break;
                }
                n3 = 22;
                break;
            }
            case 70234051: {
                if (bl) {
                    if (n2 != 393196160) break;
                    n3 = 1;
                    break;
                }
                n3 = 1;
                break;
            }
            case 82430766: {
                if (bl) {
                    if (n2 != 1493684582) break;
                    n3 = 34;
                    break;
                }
                n3 = 34;
                break;
            }
            case 87187907: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 30;
                    break;
                }
                n3 = 30;
                break;
            }
            case 138130052: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 6;
                    break;
                }
                n3 = 6;
                break;
            }
            case 252466579: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 29;
                    break;
                }
                n3 = 29;
                break;
            }
            case 389853961: {
                if (bl) {
                    if (n2 != 216567625) break;
                    n3 = 18;
                    break;
                }
                n3 = 18;
                break;
            }
            case 392980884: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 65;
                    break;
                }
                n3 = 65;
                break;
            }
            case 420467097: {
                if (bl) {
                    if (n2 != -2078140517) break;
                    n3 = 39;
                    break;
                }
                n3 = 39;
                break;
            }
            case 544454048: {
                if (bl) {
                    if (n2 != -1034208512) break;
                    n3 = 63;
                    break;
                }
                n3 = 63;
                break;
            }
            case 635011473: {
                if (bl) {
                    if (n2 != -2078140517) break;
                    n3 = 42;
                    break;
                }
                n3 = 42;
                break;
            }
            case 665649770: {
                if (bl) {
                    if (n2 != 6200573) break;
                    n3 = 60;
                    break;
                }
                n3 = 60;
                break;
            }
            case 676969150: {
                if (bl) {
                    if (n2 != -1653679357) break;
                    n3 = 44;
                    break;
                }
                n3 = 44;
                break;
            }
            case 774734266: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 11;
                    break;
                }
                n3 = 11;
                break;
            }
            case 822466598: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 19;
                    break;
                }
                n3 = 19;
                break;
            }
            case 939271450: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 51;
                    break;
                }
                n3 = 51;
                break;
            }
            case 940791421: {
                if (bl) {
                    if (n2 != 1687814400) break;
                    n3 = 47;
                    break;
                }
                n3 = 47;
                break;
            }
            case 966880734: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 33;
                    break;
                }
                n3 = 33;
                break;
            }
            case 1221777221: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 26;
                    break;
                }
                n3 = 26;
                break;
            }
            case 1257705717: {
                if (bl) {
                    if (n2 != 1024071820) break;
                    n3 = 3;
                    break;
                }
                n3 = 3;
                break;
            }
            case 1330914157: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 43;
                    break;
                }
                n3 = 43;
                break;
            }
            case 1331101734: {
                if (bl) {
                    if (n2 != 350750879) break;
                    n3 = 41;
                    break;
                }
                n3 = 41;
                break;
            }
            case 1345162066: {
                if (bl) {
                    if (n2 != -266965504) break;
                    n3 = 48;
                    break;
                }
                n3 = 48;
                break;
            }
            case 1360644575: {
                if (bl) {
                    if (n2 != 1183213157) break;
                    n3 = 23;
                    break;
                }
                n3 = 23;
                break;
            }
            case 1387055893: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 25;
                    break;
                }
                n3 = 25;
                break;
            }
            case 1420173479: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 67;
                    break;
                }
                n3 = 67;
                break;
            }
            case 1650390513: {
                if (bl) {
                    if (n2 != -883163127) break;
                    n3 = 49;
                    break;
                }
                n3 = 49;
                break;
            }
            case 1706124198: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 66;
                    break;
                }
                n3 = 66;
                break;
            }
            case 1754197359: {
                if (bl) {
                    if (n2 != -1084540160) break;
                    n3 = 13;
                    break;
                }
                n3 = 13;
                break;
            }
            case 1907678335: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 7;
                    break;
                }
                n3 = 7;
                break;
            }
            case 2006134226: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 58;
                    break;
                }
                n3 = 58;
                break;
            }
            case 2009745444: {
                if (bl) {
                    if (n2 != -1665395196) break;
                    n3 = 31;
                    break;
                }
                n3 = 31;
                break;
            }
            case 2065904420: {
                if (bl) {
                    if (n2 != 853462710) break;
                    n3 = 24;
                    break;
                }
                n3 = 24;
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
                    n3 = 76;
                    break;
                }
                n3 = 76;
                break;
            }
            case 302468796: {
                if (bl) {
                    if (n2 != -765076359) break;
                    n3 = 75;
                    break;
                }
                n3 = 75;
                break;
            }
            case 392312432: {
                if (bl) {
                    if (n2 != -1178098921) break;
                    n3 = 72;
                    break;
                }
                n3 = 72;
                break;
            }
            case 625040512: {
                if (bl) {
                    if (n2 != -1034208512) break;
                    n3 = 71;
                    break;
                }
                n3 = 71;
                break;
            }
            case 1176045527: {
                if (bl) {
                    if (n2 != -1299105535) break;
                    n3 = 70;
                    break;
                }
                n3 = 70;
                break;
            }
            case 1623646813: {
                if (bl) {
                    if (n2 != -645498553) break;
                    n3 = 73;
                    break;
                }
                n3 = 73;
                break;
            }
            case 2004687027: {
                if (bl) {
                    if (n2 != 1676164096) break;
                    n3 = 74;
                    break;
                }
                n3 = 74;
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
            case 116913049: {
                n2 = this.a1(n4, bl, n);
                break;
            }
            case 570344218: {
                n2 = this.a0(n4, bl, n);
                break;
            }
        }
        return n2;
    }

    private Object f0(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 0: {
                ((DSIMapViewerControlListener)object).configureFlags((long[])objectArray[0]);
                return null;
            }
            case 1: {
                ((DSIMapViewerControlListener)object).getInfoForPosition((PosInfo[])objectArray[0]);
                return null;
            }
            case 2: {
                ((DSIMapViewerControlListener)object).getNumberOfPOIs(((Number)objectArray[0]).longValue());
                return null;
            }
            case 3: {
                ((DSIMapViewerControlListener)object).isDetailedMapMaterialAvailable((NavLocationWgs84)objectArray[0], (Boolean)objectArray[1]);
                return null;
            }
            case 4: {
                ((DSIMapViewerControlListener)object).setBrandIconStyleResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 5: {
                ((DSIMapViewerControlListener)object).updateReady((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 6: {
                ((DSIMapViewerControlListener)object).updateCurrentViewType(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 7: {
                ((DSIMapViewerControlListener)object).updateDayNightView((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 8: {
                ((DSIMapViewerControlListener)object).updateViewScreenViewPort((Rect)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 9: {
                ((DSIMapViewerControlListener)object).updateViewScreenViewPortMaximum((Rect)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 10: {
                ((DSIMapViewerControlListener)object).updateViewVisible((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 11: {
                ((DSIMapViewerControlListener)object).updateViewFreeze((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 12: {
                ((DSIMapViewerControlListener)object).updateZoomLevel(((Number)objectArray[0]).floatValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 13: {
                ((DSIMapViewerControlListener)object).updateZoomList((float[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 14: {
                ((DSIMapViewerControlListener)object).updateZoomListIndex(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 15: {
                ((DSIMapViewerControlListener)object).updateMapRotation((short)((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 16: {
                ((DSIMapViewerControlListener)object).updateMapPosition((NavLocationWgs84)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 17: {
                ((DSIMapViewerControlListener)object).updateMapOrientation(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 18: {
                ((DSIMapViewerControlListener)object).updateCarPosition((Point)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 19: {
                ((DSIMapViewerControlListener)object).updateTmcVisible((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 20: {
                ((DSIMapViewerControlListener)object).updateMapMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 21: {
                ((DSIMapViewerControlListener)object).updateSelectedPoi((PosInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 22: {
                ((DSIMapViewerControlListener)object).updateSpeedAndFlowVisible((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 23: {
                ((DSIMapViewerControlListener)object).updateAvailableRoutes((AvailableRoute[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 24: {
                ((DSIMapViewerControlListener)object).updateViewPort((ViewPort)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 25: {
                ((DSIMapViewerControlListener)object).updateSoftJumpEnabled((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 26: {
                ((DSIMapViewerControlListener)object).updateSoftRotationEnabled((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 27: {
                ((DSIMapViewerControlListener)object).updateSoftTiltEnabled((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 28: {
                ((DSIMapViewerControlListener)object).updateSoftZoomEnabled((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 29: {
                ((DSIMapViewerControlListener)object).updateSoftJumpRunning((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 30: {
                ((DSIMapViewerControlListener)object).updateSoftRotationRunning((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 31: {
                ((DSIMapViewerControlListener)object).updateSoftTiltRunning((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f1(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 32: {
                ((DSIMapViewerControlListener)object).updateSoftZoomRunning((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 33: {
                ((DSIMapViewerControlListener)object).updateRouteCalcModeEnabled((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 34: {
                ((DSIMapViewerControlListener)object).updateRBInfoOfSelectedSegments((RouteBrowserInfo)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 35: {
                ((DSIMapViewerControlListener)object).unpackPOIContainerResult((Boolean)objectArray[0]);
                return null;
            }
            case 36: {
                ((DSIMapViewerControlListener)object).updateCurrentLanduseStyle(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 37: {
                ((DSIMapViewerControlListener)object).updateCurrentMetricSystem(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 38: {
                ((DSIMapViewerControlListener)object).setViewFocusOnBlockResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 39: {
                ((DSIMapViewerControlListener)object).startToDrawNewRectangleInMapResult(((Number)objectArray[0]).intValue(), (NavLocationWgs84)objectArray[1], (NavLocationWgs84)objectArray[2]);
                return null;
            }
            case 40: {
                ((DSIMapViewerControlListener)object).setSouthWestCornerOfRectangleInMapResult(((Number)objectArray[0]).intValue(), (NavLocationWgs84)objectArray[1]);
                return null;
            }
            case 41: {
                ((DSIMapViewerControlListener)object).setNorthEastCornerOfRectangleInMapResult(((Number)objectArray[0]).intValue(), (NavLocationWgs84)objectArray[1]);
                return null;
            }
            case 42: {
                ((DSIMapViewerControlListener)object).finishDrawRectangleInMapResult(((Number)objectArray[0]).intValue(), (NavLocationWgs84)objectArray[1], (NavLocationWgs84)objectArray[2]);
                return null;
            }
            case 43: {
                ((DSIMapViewerControlListener)object).updateCityModelMode(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 44: {
                ((DSIMapViewerControlListener)object).displayRemainingRangeOfVehicleResult((Boolean)objectArray[0]);
                return null;
            }
            case 45: {
                ((DSIMapViewerControlListener)object).touchApproachResult((Boolean)objectArray[0]);
                return null;
            }
            case 46: {
                ((DSIMapViewerControlListener)object).setGuidanceSymbolResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 47: {
                ((DSIMapViewerControlListener)object).setHOVLaneVisibilityResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 48: {
                ((DSIMapViewerControlListener)object).rbGetIDOfSelectedSegmentResult(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 49: {
                ((DSIMapViewerControlListener)object).rbGetRRDToSelectedSegmentResult(((Number)objectArray[0]).longValue(), ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue());
                return null;
            }
            case 50: {
                ((DSIMapViewerControlListener)object).setTollRoadHighLightingResult((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 51: {
                ((DSIMapViewerControlListener)object).setMountainPeakMarkerResult((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 52: {
                ((DSIMapViewerControlListener)object).suspendMapViewerResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 53: {
                ((DSIMapViewerControlListener)object).wakeupMapViewerResult(((Number)objectArray[0]).intValue());
                return null;
            }
            case 54: {
                ((DSIMapViewerControlListener)object).updateMapViewerRunLevel(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 55: {
                ((DSIMapViewerControlListener)object).updateMapViewerSuspensionSupported(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 56: {
                ((DSIMapViewerControlListener)object).updateMapViewerSuspensionAndWakeUpProgress(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 57: {
                ((DSIMapViewerControlListener)object).updateAvailableCountryOverviews((String[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 58: {
                ((DSIMapViewerControlListener)object).updateGeneralPoiVisibility((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 59: {
                ((DSIMapViewerControlListener)object).updateHorizonMarkerVisibility((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 60: {
                ((DSIMapViewerControlListener)object).updateDragRoutePosition((NavLocationWgs84)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 61: {
                ((DSIMapViewerControlListener)object).updateEhCategoryVisibility((int[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 62: {
                ((DSIMapViewerControlListener)object).setMapOverlaysResult(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 63: {
                ((DSIMapViewerControlListener)object).updateMapLayerAvailable((int[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
        }
        return null;
    }

    private Object f2(int n, Object object, Object[] objectArray) {
        switch (n) {
            case 64: {
                ((DSIMapViewerControlListener)object).updateMapLayerVisible((int[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 65: {
                ((DSIMapViewerControlListener)object).updateTemperatureScale(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 66: {
                ((DSIMapViewerControlListener)object).updateSpeedAndFlowRoadClass(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 67: {
                ((DSIMapViewerControlListener)object).updateRouteVisibility((Boolean)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 68: {
                ((DSIMapViewerControlListener)object).updateSoftAnimationSpeed(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 69: {
                ((DSIMapViewerControlListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
                return null;
            }
            case 70: {
                ((DSIMapViewerGoogleCtrlListener)object).updateAvailableLayers((LayerProperty[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 71: {
                ((DSIMapViewerGoogleCtrlListener)object).updateVisibleLayers((int[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 72: {
                ((DSIMapViewerGoogleCtrlListener)object).updateAvailableLanguages((String[])objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 73: {
                ((DSIMapViewerGoogleCtrlListener)object).updateCurrentLanguage((String)objectArray[0], ((Number)objectArray[1]).intValue());
                return null;
            }
            case 74: {
                ((DSIMapViewerGoogleCtrlListener)object).updateGoogleDataStatus(((Number)objectArray[0]).intValue(), ((Number)objectArray[1]).intValue());
                return null;
            }
            case 75: {
                ((DSIMapViewerGoogleCtrlListener)object).updateCopyrightPosition((Rect)objectArray[0], ((Number)objectArray[1]).intValue(), ((Number)objectArray[2]).intValue(), ((Number)objectArray[3]).intValue());
                return null;
            }
            case 76: {
                ((DSIMapViewerGoogleCtrlListener)object).asyncException(((Number)objectArray[0]).intValue(), (String)objectArray[1], ((Number)objectArray[2]).intValue());
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
                case 2: {
                    return this.f2(n, object, objectArray);
                }
            }
            return null;
        }
        catch (Throwable throwable) {
            throw new InvocationTargetException(throwable);
        }
    }
}

