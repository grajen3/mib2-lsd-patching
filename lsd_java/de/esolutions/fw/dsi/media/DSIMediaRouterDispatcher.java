/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.media;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.media.DSIMediaRouterReply;
import de.esolutions.fw.comm.dsi.media.impl.DSIMediaRouterReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.media.AudioRoute;
import org.dsi.ifc.media.DSIMediaRouterListener;

public class DSIMediaRouterDispatcher
extends AbstractDispatcher
implements DSIMediaRouterReply {
    private DSIMediaRouterReplyService service = new DSIMediaRouterReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaRouterListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIMediaRouterDispatcher(int n) {
        super(n, (class$org$dsi$ifc$media$DSIMediaRouterListener == null ? (class$org$dsi$ifc$media$DSIMediaRouterListener = DSIMediaRouterDispatcher.class$("org.dsi.ifc.media.DSIMediaRouterListener")) : class$org$dsi$ifc$media$DSIMediaRouterListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void responseConfiguration(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMediaRouterListener dSIMediaRouterListener = (DSIMediaRouterListener)objectArray[i2];
                    dSIMediaRouterListener.responseConfiguration(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseClientStatus(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMediaRouterListener dSIMediaRouterListener = (DSIMediaRouterListener)objectArray[i2];
                    dSIMediaRouterListener.responseClientStatus(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateStreamingStatus(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMediaRouterListener dSIMediaRouterListener = (DSIMediaRouterListener)iterator.next();
                    this.confirmNotificationListener(1, dSIMediaRouterListener);
                    dSIMediaRouterListener.updateStreamingStatus(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMediaRouterListener dSIMediaRouterListener = (DSIMediaRouterListener)iterator.next();
                    dSIMediaRouterListener.updateStreamingStatus(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateActiveAudioRoutes(AudioRoute[] audioRouteArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIMediaRouterListener dSIMediaRouterListener = (DSIMediaRouterListener)iterator.next();
                    this.confirmNotificationListener(2, dSIMediaRouterListener);
                    dSIMediaRouterListener.updateActiveAudioRoutes(audioRouteArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIMediaRouterListener dSIMediaRouterListener = (DSIMediaRouterListener)iterator.next();
                    dSIMediaRouterListener.updateActiveAudioRoutes(audioRouteArray, n);
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
                    DSIMediaRouterListener dSIMediaRouterListener = (DSIMediaRouterListener)objectArray[i2];
                    dSIMediaRouterListener.asyncException(n, string, n2);
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
                    DSIMediaRouterListener dSIMediaRouterListener = (DSIMediaRouterListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIMediaRouterDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIMediaRouterDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIMediaRouterListener, new Object[]{string, string2});
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

