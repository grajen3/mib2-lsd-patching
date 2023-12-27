/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.carstopwatch;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.carstopwatch.DSICarStopWatchReply;
import de.esolutions.fw.comm.dsi.carstopwatch.impl.DSICarStopWatchReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.carstopwatch.DSICarStopWatchListener;
import org.dsi.ifc.carstopwatch.StopWatchTime;
import org.dsi.ifc.carstopwatch.StopWatchViewOptions;

public class DSICarStopWatchDispatcher
extends AbstractDispatcher
implements DSICarStopWatchReply {
    private DSICarStopWatchReplyService service = new DSICarStopWatchReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$carstopwatch$DSICarStopWatchListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSICarStopWatchDispatcher(int n) {
        super(n, (class$org$dsi$ifc$carstopwatch$DSICarStopWatchListener == null ? (class$org$dsi$ifc$carstopwatch$DSICarStopWatchListener = DSICarStopWatchDispatcher.class$("org.dsi.ifc.carstopwatch.DSICarStopWatchListener")) : class$org$dsi$ifc$carstopwatch$DSICarStopWatchListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateStopWatchViewOptions(StopWatchViewOptions stopWatchViewOptions, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICarStopWatchListener dSICarStopWatchListener = (DSICarStopWatchListener)iterator.next();
                    this.confirmNotificationListener(1, dSICarStopWatchListener);
                    dSICarStopWatchListener.updateStopWatchViewOptions(stopWatchViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSICarStopWatchListener dSICarStopWatchListener = (DSICarStopWatchListener)iterator.next();
                    dSICarStopWatchListener.updateStopWatchViewOptions(stopWatchViewOptions, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateStopWatchState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSICarStopWatchListener dSICarStopWatchListener = (DSICarStopWatchListener)iterator.next();
                    this.confirmNotificationListener(2, dSICarStopWatchListener);
                    dSICarStopWatchListener.updateStopWatchState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSICarStopWatchListener dSICarStopWatchListener = (DSICarStopWatchListener)iterator.next();
                    dSICarStopWatchListener.updateStopWatchState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateStopWatchCurrentLapNumber(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICarStopWatchListener dSICarStopWatchListener = (DSICarStopWatchListener)iterator.next();
                    this.confirmNotificationListener(3, dSICarStopWatchListener);
                    dSICarStopWatchListener.updateStopWatchCurrentLapNumber(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSICarStopWatchListener dSICarStopWatchListener = (DSICarStopWatchListener)iterator.next();
                    dSICarStopWatchListener.updateStopWatchCurrentLapNumber(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateStopWatchTotalTime(StopWatchTime stopWatchTime, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICarStopWatchListener dSICarStopWatchListener = (DSICarStopWatchListener)iterator.next();
                    this.confirmNotificationListener(4, dSICarStopWatchListener);
                    dSICarStopWatchListener.updateStopWatchTotalTime(stopWatchTime, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSICarStopWatchListener dSICarStopWatchListener = (DSICarStopWatchListener)iterator.next();
                    dSICarStopWatchListener.updateStopWatchTotalTime(stopWatchTime, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateStopWatchLastSplitTime(int n, StopWatchTime stopWatchTime, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSICarStopWatchListener dSICarStopWatchListener = (DSICarStopWatchListener)iterator.next();
                    this.confirmNotificationListener(5, dSICarStopWatchListener);
                    dSICarStopWatchListener.updateStopWatchLastSplitTime(n, stopWatchTime, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSICarStopWatchListener dSICarStopWatchListener = (DSICarStopWatchListener)iterator.next();
                    dSICarStopWatchListener.updateStopWatchLastSplitTime(n, stopWatchTime, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateStopWatchCurrentLapTime(StopWatchTime stopWatchTime, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICarStopWatchListener dSICarStopWatchListener = (DSICarStopWatchListener)iterator.next();
                    this.confirmNotificationListener(6, dSICarStopWatchListener);
                    dSICarStopWatchListener.updateStopWatchCurrentLapTime(stopWatchTime, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSICarStopWatchListener dSICarStopWatchListener = (DSICarStopWatchListener)iterator.next();
                    dSICarStopWatchListener.updateStopWatchCurrentLapTime(stopWatchTime, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateStopWatchLastLapTime(StopWatchTime stopWatchTime, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICarStopWatchListener dSICarStopWatchListener = (DSICarStopWatchListener)iterator.next();
                    this.confirmNotificationListener(7, dSICarStopWatchListener);
                    dSICarStopWatchListener.updateStopWatchLastLapTime(stopWatchTime, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSICarStopWatchListener dSICarStopWatchListener = (DSICarStopWatchListener)iterator.next();
                    dSICarStopWatchListener.updateStopWatchLastLapTime(stopWatchTime, n);
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
                    DSICarStopWatchListener dSICarStopWatchListener = (DSICarStopWatchListener)objectArray[i2];
                    dSICarStopWatchListener.asyncException(n, string, n2);
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
                    DSICarStopWatchListener dSICarStopWatchListener = (DSICarStopWatchListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSICarStopWatchDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSICarStopWatchDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSICarStopWatchListener, new Object[]{string, string2});
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

