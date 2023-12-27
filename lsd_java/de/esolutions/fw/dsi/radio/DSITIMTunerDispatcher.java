/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.radio;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.radio.DSITIMTunerReply;
import de.esolutions.fw.comm.dsi.radio.impl.DSITIMTunerReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.radio.DSITIMTunerListener;
import org.dsi.ifc.radio.TIMMemoUsage;
import org.dsi.ifc.radio.TIMMessage;
import org.dsi.ifc.radio.TIMStatus;

public class DSITIMTunerDispatcher
extends AbstractDispatcher
implements DSITIMTunerReply {
    private DSITIMTunerReplyService service = new DSITIMTunerReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSITIMTunerListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSITIMTunerDispatcher(int n) {
        super(n, (class$org$dsi$ifc$radio$DSITIMTunerListener == null ? (class$org$dsi$ifc$radio$DSITIMTunerListener = DSITIMTunerDispatcher.class$("org.dsi.ifc.radio.DSITIMTunerListener")) : class$org$dsi$ifc$radio$DSITIMTunerListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateTIMMessageList(TIMMessage[] tIMMessageArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSITIMTunerListener dSITIMTunerListener = (DSITIMTunerListener)iterator.next();
                    this.confirmNotificationListener(1, dSITIMTunerListener);
                    dSITIMTunerListener.updateTIMMessageList(tIMMessageArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSITIMTunerListener dSITIMTunerListener = (DSITIMTunerListener)iterator.next();
                    dSITIMTunerListener.updateTIMMessageList(tIMMessageArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTIMStatus(TIMStatus tIMStatus, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSITIMTunerListener dSITIMTunerListener = (DSITIMTunerListener)iterator.next();
                    this.confirmNotificationListener(3, dSITIMTunerListener);
                    dSITIMTunerListener.updateTIMStatus(tIMStatus, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSITIMTunerListener dSITIMTunerListener = (DSITIMTunerListener)iterator.next();
                    dSITIMTunerListener.updateTIMStatus(tIMStatus, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTIMMemoUsage(TIMMemoUsage tIMMemoUsage, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSITIMTunerListener dSITIMTunerListener = (DSITIMTunerListener)iterator.next();
                    this.confirmNotificationListener(4, dSITIMTunerListener);
                    dSITIMTunerListener.updateTIMMemoUsage(tIMMemoUsage, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSITIMTunerListener dSITIMTunerListener = (DSITIMTunerListener)iterator.next();
                    dSITIMTunerListener.updateTIMMemoUsage(tIMMemoUsage, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTIMAvailable(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSITIMTunerListener dSITIMTunerListener = (DSITIMTunerListener)iterator.next();
                    this.confirmNotificationListener(5, dSITIMTunerListener);
                    dSITIMTunerListener.updateTIMAvailable(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSITIMTunerListener dSITIMTunerListener = (DSITIMTunerListener)iterator.next();
                    dSITIMTunerListener.updateTIMAvailable(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void playback(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITIMTunerListener dSITIMTunerListener = (DSITIMTunerListener)objectArray[i2];
                    dSITIMTunerListener.playback(n);
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
                    DSITIMTunerListener dSITIMTunerListener = (DSITIMTunerListener)objectArray[i2];
                    dSITIMTunerListener.asyncException(n, string, n2);
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
                    DSITIMTunerListener dSITIMTunerListener = (DSITIMTunerListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSITIMTunerDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSITIMTunerDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSITIMTunerListener, new Object[]{string, string2});
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

