/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.sse;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.sse.DSISSEReply;
import de.esolutions.fw.comm.dsi.sse.impl.DSISSEReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.sse.DSISSEListener;

public class DSISSEDispatcher
extends AbstractDispatcher
implements DSISSEReply {
    private DSISSEReplyService service = new DSISSEReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$sse$DSISSEListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSISSEDispatcher(int n) {
        super(n, (class$org$dsi$ifc$sse$DSISSEListener == null ? (class$org$dsi$ifc$sse$DSISSEListener = DSISSEDispatcher.class$("org.dsi.ifc.sse.DSISSEListener")) : class$org$dsi$ifc$sse$DSISSEListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void responseSetMode(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISSEListener dSISSEListener = (DSISSEListener)objectArray[i2];
                    dSISSEListener.responseSetMode(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMode(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSISSEListener dSISSEListener = (DSISSEListener)iterator.next();
                    this.confirmNotificationListener(2, dSISSEListener);
                    dSISSEListener.updateMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSISSEListener dSISSEListener = (DSISSEListener)iterator.next();
                    dSISSEListener.updateMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMicGainLevel(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSISSEListener dSISSEListener = (DSISSEListener)iterator.next();
                    this.confirmNotificationListener(1, dSISSEListener);
                    dSISSEListener.updateMicGainLevel(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSISSEListener dSISSEListener = (DSISSEListener)iterator.next();
                    dSISSEListener.updateMicGainLevel(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetMicGainLevel(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISSEListener dSISSEListener = (DSISSEListener)objectArray[i2];
                    dSISSEListener.responseSetMicGainLevel(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMicMuteState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSISSEListener dSISSEListener = (DSISSEListener)iterator.next();
                    this.confirmNotificationListener(3, dSISSEListener);
                    dSISSEListener.updateMicMuteState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSISSEListener dSISSEListener = (DSISSEListener)iterator.next();
                    dSISSEListener.updateMicMuteState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetMicMuteState(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISSEListener dSISSEListener = (DSISSEListener)objectArray[i2];
                    dSISSEListener.responseSetMicMuteState(n);
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
                    DSISSEListener dSISSEListener = (DSISSEListener)objectArray[i2];
                    dSISSEListener.asyncException(n, string, n2);
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
                    DSISSEListener dSISSEListener = (DSISSEListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSISSEDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSISSEDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSISSEListener, new Object[]{string, string2});
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

