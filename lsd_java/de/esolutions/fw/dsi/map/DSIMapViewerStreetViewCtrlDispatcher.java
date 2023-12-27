/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.map;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerStreetViewCtrlReply;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerStreetViewCtrlReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.DSIMapViewerStreetViewCtrlListener;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.StreetViewThumbnail;

public class DSIMapViewerStreetViewCtrlDispatcher
extends AbstractDispatcher
implements DSIMapViewerStreetViewCtrlReply {
    private DSIMapViewerStreetViewCtrlReplyService service = new DSIMapViewerStreetViewCtrlReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrlListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIMapViewerStreetViewCtrlDispatcher(int n) {
        super(n, (class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrlListener == null ? (class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrlListener = DSIMapViewerStreetViewCtrlDispatcher.class$("org.dsi.ifc.map.DSIMapViewerStreetViewCtrlListener")) : class$org$dsi$ifc$map$DSIMapViewerStreetViewCtrlListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateStreetViewLoadStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerStreetViewCtrlListener dSIMapViewerStreetViewCtrlListener = (DSIMapViewerStreetViewCtrlListener)iterator.next();
                    this.confirmNotificationListener(1, dSIMapViewerStreetViewCtrlListener);
                    dSIMapViewerStreetViewCtrlListener.updateStreetViewLoadStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerStreetViewCtrlListener dSIMapViewerStreetViewCtrlListener = (DSIMapViewerStreetViewCtrlListener)iterator.next();
                    dSIMapViewerStreetViewCtrlListener.updateStreetViewLoadStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateStreetViewAvailable(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerStreetViewCtrlListener dSIMapViewerStreetViewCtrlListener = (DSIMapViewerStreetViewCtrlListener)iterator.next();
                    this.confirmNotificationListener(2, dSIMapViewerStreetViewCtrlListener);
                    dSIMapViewerStreetViewCtrlListener.updateStreetViewAvailable(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerStreetViewCtrlListener dSIMapViewerStreetViewCtrlListener = (DSIMapViewerStreetViewCtrlListener)iterator.next();
                    dSIMapViewerStreetViewCtrlListener.updateStreetViewAvailable(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateStreetViewZoomListIndex(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerStreetViewCtrlListener dSIMapViewerStreetViewCtrlListener = (DSIMapViewerStreetViewCtrlListener)iterator.next();
                    this.confirmNotificationListener(3, dSIMapViewerStreetViewCtrlListener);
                    dSIMapViewerStreetViewCtrlListener.updateStreetViewZoomListIndex(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerStreetViewCtrlListener dSIMapViewerStreetViewCtrlListener = (DSIMapViewerStreetViewCtrlListener)iterator.next();
                    dSIMapViewerStreetViewCtrlListener.updateStreetViewZoomListIndex(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateStreetViewZoomList(float[] fArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerStreetViewCtrlListener dSIMapViewerStreetViewCtrlListener = (DSIMapViewerStreetViewCtrlListener)iterator.next();
                    this.confirmNotificationListener(4, dSIMapViewerStreetViewCtrlListener);
                    dSIMapViewerStreetViewCtrlListener.updateStreetViewZoomList(fArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerStreetViewCtrlListener dSIMapViewerStreetViewCtrlListener = (DSIMapViewerStreetViewCtrlListener)iterator.next();
                    dSIMapViewerStreetViewCtrlListener.updateStreetViewZoomList(fArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateStreetViewThumbnails(StreetViewThumbnail[] streetViewThumbnailArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerStreetViewCtrlListener dSIMapViewerStreetViewCtrlListener = (DSIMapViewerStreetViewCtrlListener)iterator.next();
                    this.confirmNotificationListener(5, dSIMapViewerStreetViewCtrlListener);
                    dSIMapViewerStreetViewCtrlListener.updateStreetViewThumbnails(streetViewThumbnailArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerStreetViewCtrlListener dSIMapViewerStreetViewCtrlListener = (DSIMapViewerStreetViewCtrlListener)iterator.next();
                    dSIMapViewerStreetViewCtrlListener.updateStreetViewThumbnails(streetViewThumbnailArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void streetViewEnabled(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerStreetViewCtrlListener dSIMapViewerStreetViewCtrlListener = (DSIMapViewerStreetViewCtrlListener)objectArray[i2];
                    dSIMapViewerStreetViewCtrlListener.streetViewEnabled(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void streetViewVisible(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerStreetViewCtrlListener dSIMapViewerStreetViewCtrlListener = (DSIMapViewerStreetViewCtrlListener)objectArray[i2];
                    dSIMapViewerStreetViewCtrlListener.streetViewVisible(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void streetViewFreeze(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerStreetViewCtrlListener dSIMapViewerStreetViewCtrlListener = (DSIMapViewerStreetViewCtrlListener)objectArray[i2];
                    dSIMapViewerStreetViewCtrlListener.streetViewFreeze(bl);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePosition(NavLocationWgs84 navLocationWgs84, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerStreetViewCtrlListener dSIMapViewerStreetViewCtrlListener = (DSIMapViewerStreetViewCtrlListener)iterator.next();
                    this.confirmNotificationListener(6, dSIMapViewerStreetViewCtrlListener);
                    dSIMapViewerStreetViewCtrlListener.updatePosition(navLocationWgs84, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerStreetViewCtrlListener dSIMapViewerStreetViewCtrlListener = (DSIMapViewerStreetViewCtrlListener)iterator.next();
                    dSIMapViewerStreetViewCtrlListener.updatePosition(navLocationWgs84, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRotation(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerStreetViewCtrlListener dSIMapViewerStreetViewCtrlListener = (DSIMapViewerStreetViewCtrlListener)iterator.next();
                    this.confirmNotificationListener(7, dSIMapViewerStreetViewCtrlListener);
                    dSIMapViewerStreetViewCtrlListener.updateRotation(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerStreetViewCtrlListener dSIMapViewerStreetViewCtrlListener = (DSIMapViewerStreetViewCtrlListener)iterator.next();
                    dSIMapViewerStreetViewCtrlListener.updateRotation(n, n2, n3);
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
                    DSIMapViewerStreetViewCtrlListener dSIMapViewerStreetViewCtrlListener = (DSIMapViewerStreetViewCtrlListener)objectArray[i2];
                    dSIMapViewerStreetViewCtrlListener.getInfoForPosition(posInfoArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void snapshotResult(StreetViewThumbnail streetViewThumbnail, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerStreetViewCtrlListener dSIMapViewerStreetViewCtrlListener = (DSIMapViewerStreetViewCtrlListener)objectArray[i2];
                    dSIMapViewerStreetViewCtrlListener.snapshotResult(streetViewThumbnail, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateScreenViewPort(Rect rect, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerStreetViewCtrlListener dSIMapViewerStreetViewCtrlListener = (DSIMapViewerStreetViewCtrlListener)iterator.next();
                    this.confirmNotificationListener(8, dSIMapViewerStreetViewCtrlListener);
                    dSIMapViewerStreetViewCtrlListener.updateScreenViewPort(rect, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerStreetViewCtrlListener dSIMapViewerStreetViewCtrlListener = (DSIMapViewerStreetViewCtrlListener)iterator.next();
                    dSIMapViewerStreetViewCtrlListener.updateScreenViewPort(rect, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateStreetViewZoomLevel(float f2, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerStreetViewCtrlListener dSIMapViewerStreetViewCtrlListener = (DSIMapViewerStreetViewCtrlListener)iterator.next();
                    this.confirmNotificationListener(9, dSIMapViewerStreetViewCtrlListener);
                    dSIMapViewerStreetViewCtrlListener.updateStreetViewZoomLevel(f2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerStreetViewCtrlListener dSIMapViewerStreetViewCtrlListener = (DSIMapViewerStreetViewCtrlListener)iterator.next();
                    dSIMapViewerStreetViewCtrlListener.updateStreetViewZoomLevel(f2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateStreetViewPosition(NavLocationWgs84 navLocationWgs84, boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerStreetViewCtrlListener dSIMapViewerStreetViewCtrlListener = (DSIMapViewerStreetViewCtrlListener)iterator.next();
                    this.confirmNotificationListener(10, dSIMapViewerStreetViewCtrlListener);
                    dSIMapViewerStreetViewCtrlListener.updateStreetViewPosition(navLocationWgs84, bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerStreetViewCtrlListener dSIMapViewerStreetViewCtrlListener = (DSIMapViewerStreetViewCtrlListener)iterator.next();
                    dSIMapViewerStreetViewCtrlListener.updateStreetViewPosition(navLocationWgs84, bl, n);
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
                    DSIMapViewerStreetViewCtrlListener dSIMapViewerStreetViewCtrlListener = (DSIMapViewerStreetViewCtrlListener)objectArray[i2];
                    dSIMapViewerStreetViewCtrlListener.asyncException(n, string, n2);
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
                    DSIMapViewerStreetViewCtrlListener dSIMapViewerStreetViewCtrlListener = (DSIMapViewerStreetViewCtrlListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIMapViewerStreetViewCtrlDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIMapViewerStreetViewCtrlDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIMapViewerStreetViewCtrlListener, new Object[]{string, string2});
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

