/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.map;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerZoomEngineReply;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerZoomEngineReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.map.DSIMapViewerZoomEngineListener;

public class DSIMapViewerZoomEngineDispatcher
extends AbstractDispatcher
implements DSIMapViewerZoomEngineReply {
    private DSIMapViewerZoomEngineReplyService service = new DSIMapViewerZoomEngineReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerZoomEngineListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIMapViewerZoomEngineDispatcher(int n) {
        super(n, (class$org$dsi$ifc$map$DSIMapViewerZoomEngineListener == null ? (class$org$dsi$ifc$map$DSIMapViewerZoomEngineListener = DSIMapViewerZoomEngineDispatcher.class$("org.dsi.ifc.map.DSIMapViewerZoomEngineListener")) : class$org$dsi$ifc$map$DSIMapViewerZoomEngineListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateAutoZoomEnabled(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerZoomEngineListener dSIMapViewerZoomEngineListener = (DSIMapViewerZoomEngineListener)iterator.next();
                    this.confirmNotificationListener(1, dSIMapViewerZoomEngineListener);
                    dSIMapViewerZoomEngineListener.updateAutoZoomEnabled(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerZoomEngineListener dSIMapViewerZoomEngineListener = (DSIMapViewerZoomEngineListener)iterator.next();
                    dSIMapViewerZoomEngineListener.updateAutoZoomEnabled(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateManoeuvreZoomEnabled(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerZoomEngineListener dSIMapViewerZoomEngineListener = (DSIMapViewerZoomEngineListener)iterator.next();
                    this.confirmNotificationListener(2, dSIMapViewerZoomEngineListener);
                    dSIMapViewerZoomEngineListener.updateManoeuvreZoomEnabled(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerZoomEngineListener dSIMapViewerZoomEngineListener = (DSIMapViewerZoomEngineListener)iterator.next();
                    dSIMapViewerZoomEngineListener.updateManoeuvreZoomEnabled(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRecommendedZoom(float f2, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerZoomEngineListener dSIMapViewerZoomEngineListener = (DSIMapViewerZoomEngineListener)iterator.next();
                    this.confirmNotificationListener(3, dSIMapViewerZoomEngineListener);
                    dSIMapViewerZoomEngineListener.updateRecommendedZoom(f2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerZoomEngineListener dSIMapViewerZoomEngineListener = (DSIMapViewerZoomEngineListener)iterator.next();
                    dSIMapViewerZoomEngineListener.updateRecommendedZoom(f2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateZoomEngineState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerZoomEngineListener dSIMapViewerZoomEngineListener = (DSIMapViewerZoomEngineListener)iterator.next();
                    this.confirmNotificationListener(4, dSIMapViewerZoomEngineListener);
                    dSIMapViewerZoomEngineListener.updateZoomEngineState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerZoomEngineListener dSIMapViewerZoomEngineListener = (DSIMapViewerZoomEngineListener)iterator.next();
                    dSIMapViewerZoomEngineListener.updateZoomEngineState(n, n2);
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
                    DSIMapViewerZoomEngineListener dSIMapViewerZoomEngineListener = (DSIMapViewerZoomEngineListener)objectArray[i2];
                    dSIMapViewerZoomEngineListener.asyncException(n, string, n2);
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
                    DSIMapViewerZoomEngineListener dSIMapViewerZoomEngineListener = (DSIMapViewerZoomEngineListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIMapViewerZoomEngineDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIMapViewerZoomEngineDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIMapViewerZoomEngineListener, new Object[]{string, string2});
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

