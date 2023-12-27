/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.media;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.media.DSIMediaOnlineReply;
import de.esolutions.fw.comm.dsi.media.impl.DSIMediaOnlineReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.media.DSIMediaOnlineListener;

public class DSIMediaOnlineDispatcher
extends AbstractDispatcher
implements DSIMediaOnlineReply {
    private DSIMediaOnlineReplyService service = new DSIMediaOnlineReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaOnlineListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIMediaOnlineDispatcher(int n) {
        super(n, (class$org$dsi$ifc$media$DSIMediaOnlineListener == null ? (class$org$dsi$ifc$media$DSIMediaOnlineListener = DSIMediaOnlineDispatcher.class$("org.dsi.ifc.media.DSIMediaOnlineListener")) : class$org$dsi$ifc$media$DSIMediaOnlineListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateBufferState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMediaOnlineListener dSIMediaOnlineListener = (DSIMediaOnlineListener)iterator.next();
                    this.confirmNotificationListener(1, dSIMediaOnlineListener);
                    dSIMediaOnlineListener.updateBufferState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMediaOnlineListener dSIMediaOnlineListener = (DSIMediaOnlineListener)iterator.next();
                    dSIMediaOnlineListener.updateBufferState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBufferFillInfo(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIMediaOnlineListener dSIMediaOnlineListener = (DSIMediaOnlineListener)iterator.next();
                    this.confirmNotificationListener(2, dSIMediaOnlineListener);
                    dSIMediaOnlineListener.updateBufferFillInfo(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIMediaOnlineListener dSIMediaOnlineListener = (DSIMediaOnlineListener)iterator.next();
                    dSIMediaOnlineListener.updateBufferFillInfo(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAudioSettings(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIMediaOnlineListener dSIMediaOnlineListener = (DSIMediaOnlineListener)iterator.next();
                    this.confirmNotificationListener(3, dSIMediaOnlineListener);
                    dSIMediaOnlineListener.updateAudioSettings(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIMediaOnlineListener dSIMediaOnlineListener = (DSIMediaOnlineListener)iterator.next();
                    dSIMediaOnlineListener.updateAudioSettings(n, n2, n3);
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
                    DSIMediaOnlineListener dSIMediaOnlineListener = (DSIMediaOnlineListener)objectArray[i2];
                    dSIMediaOnlineListener.asyncException(n, string, n2);
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
                    DSIMediaOnlineListener dSIMediaOnlineListener = (DSIMediaOnlineListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIMediaOnlineDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIMediaOnlineDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIMediaOnlineListener, new Object[]{string, string2});
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

