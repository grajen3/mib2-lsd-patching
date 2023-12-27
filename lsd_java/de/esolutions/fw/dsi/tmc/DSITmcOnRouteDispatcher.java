/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.tmc;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.tmc.DSITmcOnRouteReply;
import de.esolutions.fw.comm.dsi.tmc.impl.DSITmcOnRouteReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.DSITmcOnRouteListener;
import org.dsi.ifc.tmc.SpeedAndFlowSegment;
import org.dsi.ifc.tmc.TmcMessage;

public class DSITmcOnRouteDispatcher
extends AbstractDispatcher
implements DSITmcOnRouteReply {
    private DSITmcOnRouteReplyService service = new DSITmcOnRouteReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmcOnRouteListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSITmcOnRouteDispatcher(int n) {
        super(n, (class$org$dsi$ifc$tmc$DSITmcOnRouteListener == null ? (class$org$dsi$ifc$tmc$DSITmcOnRouteListener = DSITmcOnRouteDispatcher.class$("org.dsi.ifc.tmc.DSITmcOnRouteListener")) : class$org$dsi$ifc$tmc$DSITmcOnRouteListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateTmcMessagesAhead(TmcMessage[] tmcMessageArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSITmcOnRouteListener dSITmcOnRouteListener = (DSITmcOnRouteListener)iterator.next();
                    this.confirmNotificationListener(1, dSITmcOnRouteListener);
                    dSITmcOnRouteListener.updateTmcMessagesAhead(tmcMessageArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSITmcOnRouteListener dSITmcOnRouteListener = (DSITmcOnRouteListener)iterator.next();
                    dSITmcOnRouteListener.updateTmcMessagesAhead(tmcMessageArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateUrgentMessages(TmcMessage[] tmcMessageArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSITmcOnRouteListener dSITmcOnRouteListener = (DSITmcOnRouteListener)iterator.next();
                    this.confirmNotificationListener(2, dSITmcOnRouteListener);
                    dSITmcOnRouteListener.updateUrgentMessages(tmcMessageArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSITmcOnRouteListener dSITmcOnRouteListener = (DSITmcOnRouteListener)iterator.next();
                    dSITmcOnRouteListener.updateUrgentMessages(tmcMessageArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void tmcMessage(TmcMessage tmcMessage) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITmcOnRouteListener dSITmcOnRouteListener = (DSITmcOnRouteListener)objectArray[i2];
                    dSITmcOnRouteListener.tmcMessage(tmcMessage);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTmcMessagesAheadCalculationHorizon(long l, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSITmcOnRouteListener dSITmcOnRouteListener = (DSITmcOnRouteListener)iterator.next();
                    this.confirmNotificationListener(3, dSITmcOnRouteListener);
                    dSITmcOnRouteListener.updateTmcMessagesAheadCalculationHorizon(l, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSITmcOnRouteListener dSITmcOnRouteListener = (DSITmcOnRouteListener)iterator.next();
                    dSITmcOnRouteListener.updateTmcMessagesAheadCalculationHorizon(l, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setTmcWarningModeResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITmcOnRouteListener dSITmcOnRouteListener = (DSITmcOnRouteListener)objectArray[i2];
                    dSITmcOnRouteListener.setTmcWarningModeResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCurrentlyBlockedTMCMessages(long[] lArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSITmcOnRouteListener dSITmcOnRouteListener = (DSITmcOnRouteListener)iterator.next();
                    this.confirmNotificationListener(5, dSITmcOnRouteListener);
                    dSITmcOnRouteListener.updateCurrentlyBlockedTMCMessages(lArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSITmcOnRouteListener dSITmcOnRouteListener = (DSITmcOnRouteListener)iterator.next();
                    dSITmcOnRouteListener.updateCurrentlyBlockedTMCMessages(lArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void blockTMCMessagesResult(long[] lArray, long[] lArray2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITmcOnRouteListener dSITmcOnRouteListener = (DSITmcOnRouteListener)objectArray[i2];
                    dSITmcOnRouteListener.blockTMCMessagesResult(lArray, lArray2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void unblockTMCMessagesResult(long[] lArray, long[] lArray2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITmcOnRouteListener dSITmcOnRouteListener = (DSITmcOnRouteListener)objectArray[i2];
                    dSITmcOnRouteListener.unblockTMCMessagesResult(lArray, lArray2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void unblockAllTMCMessagesResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITmcOnRouteListener dSITmcOnRouteListener = (DSITmcOnRouteListener)objectArray[i2];
                    dSITmcOnRouteListener.unblockAllTMCMessagesResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNaviCoreAvailableToChangeTMCBlockings(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSITmcOnRouteListener dSITmcOnRouteListener = (DSITmcOnRouteListener)iterator.next();
                    this.confirmNotificationListener(4, dSITmcOnRouteListener);
                    dSITmcOnRouteListener.updateNaviCoreAvailableToChangeTMCBlockings(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSITmcOnRouteListener dSITmcOnRouteListener = (DSITmcOnRouteListener)iterator.next();
                    dSITmcOnRouteListener.updateNaviCoreAvailableToChangeTMCBlockings(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicateTrafficEventNoticeMap(TmcMessage tmcMessage, NavRectangle navRectangle, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITmcOnRouteListener dSITmcOnRouteListener = (DSITmcOnRouteListener)objectArray[i2];
                    dSITmcOnRouteListener.indicateTrafficEventNoticeMap(tmcMessage, navRectangle, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSpeedAndFlowAhead(SpeedAndFlowSegment[] speedAndFlowSegmentArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSITmcOnRouteListener dSITmcOnRouteListener = (DSITmcOnRouteListener)iterator.next();
                    this.confirmNotificationListener(6, dSITmcOnRouteListener);
                    dSITmcOnRouteListener.updateSpeedAndFlowAhead(speedAndFlowSegmentArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSITmcOnRouteListener dSITmcOnRouteListener = (DSITmcOnRouteListener)iterator.next();
                    dSITmcOnRouteListener.updateSpeedAndFlowAhead(speedAndFlowSegmentArray, n);
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
                    DSITmcOnRouteListener dSITmcOnRouteListener = (DSITmcOnRouteListener)objectArray[i2];
                    dSITmcOnRouteListener.asyncException(n, string, n2);
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
                    DSITmcOnRouteListener dSITmcOnRouteListener = (DSITmcOnRouteListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSITmcOnRouteDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSITmcOnRouteDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSITmcOnRouteListener, new Object[]{string, string2});
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

