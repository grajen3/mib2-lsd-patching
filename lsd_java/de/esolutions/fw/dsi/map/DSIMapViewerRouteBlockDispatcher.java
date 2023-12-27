/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.map;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerRouteBlockReply;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerRouteBlockReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.map.DSIMapViewerRouteBlockListener;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.RouteBrowserInfo;

public class DSIMapViewerRouteBlockDispatcher
extends AbstractDispatcher
implements DSIMapViewerRouteBlockReply {
    private DSIMapViewerRouteBlockReplyService service = new DSIMapViewerRouteBlockReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerRouteBlockListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIMapViewerRouteBlockDispatcher(int n) {
        super(n, (class$org$dsi$ifc$map$DSIMapViewerRouteBlockListener == null ? (class$org$dsi$ifc$map$DSIMapViewerRouteBlockListener = DSIMapViewerRouteBlockDispatcher.class$("org.dsi.ifc.map.DSIMapViewerRouteBlockListener")) : class$org$dsi$ifc$map$DSIMapViewerRouteBlockListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateRBInfoOfSelectedSegments(RouteBrowserInfo routeBrowserInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerRouteBlockListener dSIMapViewerRouteBlockListener = (DSIMapViewerRouteBlockListener)iterator.next();
                    this.confirmNotificationListener(1, dSIMapViewerRouteBlockListener);
                    dSIMapViewerRouteBlockListener.updateRBInfoOfSelectedSegments(routeBrowserInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerRouteBlockListener dSIMapViewerRouteBlockListener = (DSIMapViewerRouteBlockListener)iterator.next();
                    dSIMapViewerRouteBlockListener.updateRBInfoOfSelectedSegments(routeBrowserInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void pickSegmentUidsInScreenSpaceResult(Point point, int n, long[] lArray, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerRouteBlockListener dSIMapViewerRouteBlockListener = (DSIMapViewerRouteBlockListener)objectArray[i2];
                    dSIMapViewerRouteBlockListener.pickSegmentUidsInScreenSpaceResult(point, n, lArray, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void highLightSegmentUidsInMapResult(long[] lArray, boolean bl, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerRouteBlockListener dSIMapViewerRouteBlockListener = (DSIMapViewerRouteBlockListener)objectArray[i2];
                    dSIMapViewerRouteBlockListener.highLightSegmentUidsInMapResult(lArray, bl, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void rBStartOfSelectionResult(long l, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerRouteBlockListener dSIMapViewerRouteBlockListener = (DSIMapViewerRouteBlockListener)objectArray[i2];
                    dSIMapViewerRouteBlockListener.rBStartOfSelectionResult(l, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void rBMarkNextSegmentResult(long l, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerRouteBlockListener dSIMapViewerRouteBlockListener = (DSIMapViewerRouteBlockListener)objectArray[i2];
                    dSIMapViewerRouteBlockListener.rBMarkNextSegmentResult(l, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void rBMarkPreviousSegmentResult(long l, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMapViewerRouteBlockListener dSIMapViewerRouteBlockListener = (DSIMapViewerRouteBlockListener)objectArray[i2];
                    dSIMapViewerRouteBlockListener.rBMarkPreviousSegmentResult(l, n);
                    continue;
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
                    DSIMapViewerRouteBlockListener dSIMapViewerRouteBlockListener = (DSIMapViewerRouteBlockListener)objectArray[i2];
                    dSIMapViewerRouteBlockListener.asyncException(n, string, n2);
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
                    DSIMapViewerRouteBlockListener dSIMapViewerRouteBlockListener = (DSIMapViewerRouteBlockListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIMapViewerRouteBlockDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIMapViewerRouteBlockDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIMapViewerRouteBlockListener, new Object[]{string, string2});
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

