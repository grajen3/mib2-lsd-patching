/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.online;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.online.DSIOnlineESIMTrafficNotificationReply;
import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineESIMTrafficNotificationReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.online.DSIOnlineESIMTrafficNotificationListener;

public class DSIOnlineESIMTrafficNotificationDispatcher
extends AbstractDispatcher
implements DSIOnlineESIMTrafficNotificationReply {
    private DSIOnlineESIMTrafficNotificationReplyService service = new DSIOnlineESIMTrafficNotificationReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIOnlineESIMTrafficNotificationListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIOnlineESIMTrafficNotificationDispatcher(int n) {
        super(n, (class$org$dsi$ifc$online$DSIOnlineESIMTrafficNotificationListener == null ? (class$org$dsi$ifc$online$DSIOnlineESIMTrafficNotificationListener = DSIOnlineESIMTrafficNotificationDispatcher.class$("org.dsi.ifc.online.DSIOnlineESIMTrafficNotificationListener")) : class$org$dsi$ifc$online$DSIOnlineESIMTrafficNotificationListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateESIMNotification(String string, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineESIMTrafficNotificationListener dSIOnlineESIMTrafficNotificationListener = (DSIOnlineESIMTrafficNotificationListener)iterator.next();
                    this.confirmNotificationListener(1, dSIOnlineESIMTrafficNotificationListener);
                    dSIOnlineESIMTrafficNotificationListener.updateESIMNotification(string, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIOnlineESIMTrafficNotificationListener dSIOnlineESIMTrafficNotificationListener = (DSIOnlineESIMTrafficNotificationListener)iterator.next();
                    dSIOnlineESIMTrafficNotificationListener.updateESIMNotification(string, n, n2);
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
                    DSIOnlineESIMTrafficNotificationListener dSIOnlineESIMTrafficNotificationListener = (DSIOnlineESIMTrafficNotificationListener)objectArray[i2];
                    dSIOnlineESIMTrafficNotificationListener.asyncException(n, string, n2);
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
                    DSIOnlineESIMTrafficNotificationListener dSIOnlineESIMTrafficNotificationListener = (DSIOnlineESIMTrafficNotificationListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIOnlineESIMTrafficNotificationDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIOnlineESIMTrafficNotificationDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIOnlineESIMTrafficNotificationListener, new Object[]{string, string2});
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

