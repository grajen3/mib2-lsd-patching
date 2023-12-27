/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.map;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerManeuverViewReply;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerManeuverViewReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.map.DSIMapViewerManeuverViewListener;

public class DSIMapViewerManeuverViewDispatcher
extends AbstractDispatcher
implements DSIMapViewerManeuverViewReply {
    private DSIMapViewerManeuverViewReplyService service = new DSIMapViewerManeuverViewReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIMapViewerManeuverViewDispatcher(int n) {
        super(n, (class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener == null ? (class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener = DSIMapViewerManeuverViewDispatcher.class$("org.dsi.ifc.map.DSIMapViewerManeuverViewListener")) : class$org$dsi$ifc$map$DSIMapViewerManeuverViewListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateManoeuvreViewActive(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerManeuverViewListener dSIMapViewerManeuverViewListener = (DSIMapViewerManeuverViewListener)iterator.next();
                    this.confirmNotificationListener(1, dSIMapViewerManeuverViewListener);
                    dSIMapViewerManeuverViewListener.updateManoeuvreViewActive(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerManeuverViewListener dSIMapViewerManeuverViewListener = (DSIMapViewerManeuverViewListener)iterator.next();
                    dSIMapViewerManeuverViewListener.updateManoeuvreViewActive(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateManoeuvreViewsAvailable(short[] sArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerManeuverViewListener dSIMapViewerManeuverViewListener = (DSIMapViewerManeuverViewListener)iterator.next();
                    this.confirmNotificationListener(2, dSIMapViewerManeuverViewListener);
                    dSIMapViewerManeuverViewListener.updateManoeuvreViewsAvailable(sArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerManeuverViewListener dSIMapViewerManeuverViewListener = (DSIMapViewerManeuverViewListener)iterator.next();
                    dSIMapViewerManeuverViewListener.updateManoeuvreViewsAvailable(sArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBapExitViewId(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerManeuverViewListener dSIMapViewerManeuverViewListener = (DSIMapViewerManeuverViewListener)iterator.next();
                    this.confirmNotificationListener(3, dSIMapViewerManeuverViewListener);
                    dSIMapViewerManeuverViewListener.updateBapExitViewId(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIMapViewerManeuverViewListener dSIMapViewerManeuverViewListener = (DSIMapViewerManeuverViewListener)iterator.next();
                    dSIMapViewerManeuverViewListener.updateBapExitViewId(n, n2);
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
                    DSIMapViewerManeuverViewListener dSIMapViewerManeuverViewListener = (DSIMapViewerManeuverViewListener)objectArray[i2];
                    dSIMapViewerManeuverViewListener.asyncException(n, string, n2);
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
                    DSIMapViewerManeuverViewListener dSIMapViewerManeuverViewListener = (DSIMapViewerManeuverViewListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIMapViewerManeuverViewDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIMapViewerManeuverViewDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIMapViewerManeuverViewListener, new Object[]{string, string2});
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

