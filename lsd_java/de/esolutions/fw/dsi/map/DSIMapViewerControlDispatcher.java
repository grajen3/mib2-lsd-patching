/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.map;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerControlReply;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerControlReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.AvailableRoute;
import org.dsi.ifc.map.DSIMapViewerControlListener;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.RouteBrowserInfo;
import org.dsi.ifc.map.ViewPort;

public class DSIMapViewerControlDispatcher
extends AbstractDispatcher
implements DSIMapViewerControlReply {
    private DSIMapViewerControlReplyService service = new DSIMapViewerControlReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerControlListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIMapViewerControlDispatcher(int n) {
        super(n, (class$org$dsi$ifc$map$DSIMapViewerControlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerControlListener = DSIMapViewerControlDispatcher.class$("org.dsi.ifc.map.DSIMapViewerControlListener")) : class$org$dsi$ifc$map$DSIMapViewerControlListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateReady(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(1, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateReady(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateReady(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCurrentViewType(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(3, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateCurrentViewType(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateCurrentViewType(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDayNightView(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(4, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateDayNightView(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateDayNightView(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateViewScreenViewPort(Rect rect, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(6, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateViewScreenViewPort(rect, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateViewScreenViewPort(rect, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateViewScreenViewPortMaximum(Rect rect, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(43);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(43, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateViewScreenViewPortMaximum(rect, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(43);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateViewScreenViewPortMaximum(rect, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateViewVisible(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(7, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateViewVisible(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateViewVisible(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateViewFreeze(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(8, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateViewFreeze(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateViewFreeze(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateZoomLevel(float f2, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(9, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateZoomLevel(f2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateZoomLevel(f2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateZoomList(float[] fArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(10, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateZoomList(fArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateZoomList(fArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateZoomListIndex(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(11, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateZoomListIndex(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateZoomListIndex(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMapRotation(short s, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(12, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateMapRotation(s, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateMapRotation(s, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMapPosition(NavLocationWgs84 navLocationWgs84, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(13, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateMapPosition(navLocationWgs84, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateMapPosition(navLocationWgs84, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMapOrientation(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(14, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateMapOrientation(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateMapOrientation(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCarPosition(Point point, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(15, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateCarPosition(point, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateCarPosition(point, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTmcVisible(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(16, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateTmcVisible(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateTmcVisible(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMapMode(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(18, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateMapMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateMapMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSelectedPoi(PosInfo posInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(19, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateSelectedPoi(posInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateSelectedPoi(posInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSpeedAndFlowVisible(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(20, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateSpeedAndFlowVisible(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateSpeedAndFlowVisible(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAvailableRoutes(AvailableRoute[] availableRouteArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(21, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateAvailableRoutes(availableRouteArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateAvailableRoutes(availableRouteArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateViewPort(ViewPort viewPort, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(22, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateViewPort(viewPort, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateViewPort(viewPort, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSoftJumpEnabled(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(23, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateSoftJumpEnabled(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateSoftJumpEnabled(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSoftRotationEnabled(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(24, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateSoftRotationEnabled(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateSoftRotationEnabled(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSoftTiltEnabled(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(25, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateSoftTiltEnabled(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateSoftTiltEnabled(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSoftZoomEnabled(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(26, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateSoftZoomEnabled(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateSoftZoomEnabled(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSoftJumpRunning(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(32, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateSoftJumpRunning(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateSoftJumpRunning(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSoftRotationRunning(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(33);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(33, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateSoftRotationRunning(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(33);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateSoftRotationRunning(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSoftTiltRunning(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(34);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(34, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateSoftTiltRunning(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(34);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateSoftTiltRunning(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSoftZoomRunning(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(35);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(35, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateSoftZoomRunning(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(35);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateSoftZoomRunning(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRouteCalcModeEnabled(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(27, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateRouteCalcModeEnabled(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateRouteCalcModeEnabled(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRBInfoOfSelectedSegments(RouteBrowserInfo routeBrowserInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(28, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateRBInfoOfSelectedSegments(routeBrowserInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateRBInfoOfSelectedSegments(routeBrowserInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void configureFlags(long[] lArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)objectArray[i2];
                    dSIMapViewerControlListener.configureFlags(lArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getInfoForPosition(PosInfo[] posInfoArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)objectArray[i2];
                    dSIMapViewerControlListener.getInfoForPosition(posInfoArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getNumberOfPOIs(long l) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)objectArray[i2];
                    dSIMapViewerControlListener.getNumberOfPOIs(l);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void unpackPOIContainerResult(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)objectArray[i2];
                    dSIMapViewerControlListener.unpackPOIContainerResult(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCurrentLanduseStyle(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(30, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateCurrentLanduseStyle(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateCurrentLanduseStyle(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCurrentMetricSystem(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(31, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateCurrentMetricSystem(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateCurrentMetricSystem(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setViewFocusOnBlockResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)objectArray[i2];
                    dSIMapViewerControlListener.setViewFocusOnBlockResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void startToDrawNewRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84, NavLocationWgs84 navLocationWgs842) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)objectArray[i2];
                    dSIMapViewerControlListener.startToDrawNewRectangleInMapResult(n, navLocationWgs84, navLocationWgs842);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setSouthWestCornerOfRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)objectArray[i2];
                    dSIMapViewerControlListener.setSouthWestCornerOfRectangleInMapResult(n, navLocationWgs84);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setNorthEastCornerOfRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)objectArray[i2];
                    dSIMapViewerControlListener.setNorthEastCornerOfRectangleInMapResult(n, navLocationWgs84);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void finishDrawRectangleInMapResult(int n, NavLocationWgs84 navLocationWgs84, NavLocationWgs84 navLocationWgs842) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)objectArray[i2];
                    dSIMapViewerControlListener.finishDrawRectangleInMapResult(n, navLocationWgs84, navLocationWgs842);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCityModelMode(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(36);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(36, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateCityModelMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(36);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateCityModelMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void displayRemainingRangeOfVehicleResult(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)objectArray[i2];
                    dSIMapViewerControlListener.displayRemainingRangeOfVehicleResult(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void touchApproachResult(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)objectArray[i2];
                    dSIMapViewerControlListener.touchApproachResult(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setBrandIconStyleResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)objectArray[i2];
                    dSIMapViewerControlListener.setBrandIconStyleResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setGuidanceSymbolResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)objectArray[i2];
                    dSIMapViewerControlListener.setGuidanceSymbolResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setHOVLaneVisibilityResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)objectArray[i2];
                    dSIMapViewerControlListener.setHOVLaneVisibilityResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void rbGetIDOfSelectedSegmentResult(long l, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)objectArray[i2];
                    dSIMapViewerControlListener.rbGetIDOfSelectedSegmentResult(l, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void rbGetRRDToSelectedSegmentResult(long l, int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)objectArray[i2];
                    dSIMapViewerControlListener.rbGetRRDToSelectedSegmentResult(l, n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setTollRoadHighLightingResult(boolean bl, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)objectArray[i2];
                    dSIMapViewerControlListener.setTollRoadHighLightingResult(bl, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setMountainPeakMarkerResult(boolean bl, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)objectArray[i2];
                    dSIMapViewerControlListener.setMountainPeakMarkerResult(bl, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void suspendMapViewerResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)objectArray[i2];
                    dSIMapViewerControlListener.suspendMapViewerResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void wakeupMapViewerResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)objectArray[i2];
                    dSIMapViewerControlListener.wakeupMapViewerResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void isDetailedMapMaterialAvailable(NavLocationWgs84 navLocationWgs84, boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)objectArray[i2];
                    dSIMapViewerControlListener.isDetailedMapMaterialAvailable(navLocationWgs84, bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMapViewerRunLevel(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(37);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(37, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateMapViewerRunLevel(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(37);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateMapViewerRunLevel(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMapViewerSuspensionSupported(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(38);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(38, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateMapViewerSuspensionSupported(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(38);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateMapViewerSuspensionSupported(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMapViewerSuspensionAndWakeUpProgress(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(39);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(39, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateMapViewerSuspensionAndWakeUpProgress(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(39);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateMapViewerSuspensionAndWakeUpProgress(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAvailableCountryOverviews(String[] stringArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(41);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(41, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateAvailableCountryOverviews(stringArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(41);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateAvailableCountryOverviews(stringArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateGeneralPoiVisibility(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(40);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(40, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateGeneralPoiVisibility(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(40);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateGeneralPoiVisibility(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateHorizonMarkerVisibility(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(42);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(42, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateHorizonMarkerVisibility(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(42);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateHorizonMarkerVisibility(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDragRoutePosition(NavLocationWgs84 navLocationWgs84, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(44);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(44, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateDragRoutePosition(navLocationWgs84, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(44);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateDragRoutePosition(navLocationWgs84, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateEhCategoryVisibility(int[] nArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(45);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(45, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateEhCategoryVisibility(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(45);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateEhCategoryVisibility(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setMapOverlaysResult(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)objectArray[i2];
                    dSIMapViewerControlListener.setMapOverlaysResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMapLayerAvailable(int[] nArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(46);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(46, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateMapLayerAvailable(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(46);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateMapLayerAvailable(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMapLayerVisible(int[] nArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(47);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(47, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateMapLayerVisible(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(47);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateMapLayerVisible(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTemperatureScale(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(48);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(48, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateTemperatureScale(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(48);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateTemperatureScale(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSpeedAndFlowRoadClass(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(49);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(49, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateSpeedAndFlowRoadClass(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(49);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateSpeedAndFlowRoadClass(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRouteVisibility(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(50);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(50, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateRouteVisibility(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(50);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateRouteVisibility(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSoftAnimationSpeed(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(51);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    this.confirmNotificationListener(51, dSIMapViewerControlListener);
                    dSIMapViewerControlListener.updateSoftAnimationSpeed(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(51);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)iterator.next();
                    dSIMapViewerControlListener.updateSoftAnimationSpeed(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)objectArray[i2];
                    dSIMapViewerControlListener.asyncException(n, string, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void yyIndication(String string, String string2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerControlListener dSIMapViewerControlListener = (DSIMapViewerControlListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIMapViewerControlDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIMapViewerControlDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIMapViewerControlListener, new Object[]{string, string2});
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

