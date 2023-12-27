/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.online;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.online.DSIOnlineTrafficLightInfoReply;
import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineTrafficLightInfoReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.global.CarBCSpeed;
import org.dsi.ifc.online.DSIOnlineTrafficLightInfoListener;

public class DSIOnlineTrafficLightInfoDispatcher
extends AbstractDispatcher
implements DSIOnlineTrafficLightInfoReply {
    private DSIOnlineTrafficLightInfoReplyService service = new DSIOnlineTrafficLightInfoReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIOnlineTrafficLightInfoListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIOnlineTrafficLightInfoDispatcher(int n) {
        super(n, (class$org$dsi$ifc$online$DSIOnlineTrafficLightInfoListener == null ? (class$org$dsi$ifc$online$DSIOnlineTrafficLightInfoListener = DSIOnlineTrafficLightInfoDispatcher.class$("org.dsi.ifc.online.DSIOnlineTrafficLightInfoListener")) : class$org$dsi$ifc$online$DSIOnlineTrafficLightInfoListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateTrafficLightInfo(int n, int n2, int[] nArray, int n3, int n4, int n5) {
        if ((n5 & 0x80) == 128) {
            n5 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineTrafficLightInfoListener dSIOnlineTrafficLightInfoListener = (DSIOnlineTrafficLightInfoListener)iterator.next();
                    this.confirmNotificationListener(1, dSIOnlineTrafficLightInfoListener);
                    dSIOnlineTrafficLightInfoListener.updateTrafficLightInfo(n, n2, nArray, n3, n4, n5);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineTrafficLightInfoListener dSIOnlineTrafficLightInfoListener = (DSIOnlineTrafficLightInfoListener)iterator.next();
                    dSIOnlineTrafficLightInfoListener.updateTrafficLightInfo(n, n2, nArray, n3, n4, n5);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTrafficLightSpeed(CarBCSpeed carBCSpeed, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineTrafficLightInfoListener dSIOnlineTrafficLightInfoListener = (DSIOnlineTrafficLightInfoListener)iterator.next();
                    this.confirmNotificationListener(2, dSIOnlineTrafficLightInfoListener);
                    dSIOnlineTrafficLightInfoListener.updateTrafficLightSpeed(carBCSpeed, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineTrafficLightInfoListener dSIOnlineTrafficLightInfoListener = (DSIOnlineTrafficLightInfoListener)iterator.next();
                    dSIOnlineTrafficLightInfoListener.updateTrafficLightSpeed(carBCSpeed, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTrafficLightTime(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineTrafficLightInfoListener dSIOnlineTrafficLightInfoListener = (DSIOnlineTrafficLightInfoListener)iterator.next();
                    this.confirmNotificationListener(3, dSIOnlineTrafficLightInfoListener);
                    dSIOnlineTrafficLightInfoListener.updateTrafficLightTime(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineTrafficLightInfoListener dSIOnlineTrafficLightInfoListener = (DSIOnlineTrafficLightInfoListener)iterator.next();
                    dSIOnlineTrafficLightInfoListener.updateTrafficLightTime(n, n2, n3);
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
                    DSIOnlineTrafficLightInfoListener dSIOnlineTrafficLightInfoListener = (DSIOnlineTrafficLightInfoListener)objectArray[i2];
                    dSIOnlineTrafficLightInfoListener.asyncException(n, string, n2);
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
                    DSIOnlineTrafficLightInfoListener dSIOnlineTrafficLightInfoListener = (DSIOnlineTrafficLightInfoListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIOnlineTrafficLightInfoDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIOnlineTrafficLightInfoDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIOnlineTrafficLightInfoListener, new Object[]{string, string2});
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

