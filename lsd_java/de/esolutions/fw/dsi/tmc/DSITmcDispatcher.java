/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.tmc;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.tmc.DSITmcReply;
import de.esolutions.fw.comm.dsi.tmc.impl.DSITmcReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.tmc.AreaWarningInfo;
import org.dsi.ifc.tmc.DSITmcListener;
import org.dsi.ifc.tmc.LocalHazardInformation;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TrafficSource;

public class DSITmcDispatcher
extends AbstractDispatcher
implements DSITmcReply {
    private DSITmcReplyService service = new DSITmcReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$tmc$DSITmcListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSITmcDispatcher(int n) {
        super(n, (class$org$dsi$ifc$tmc$DSITmcListener == null ? (class$org$dsi$ifc$tmc$DSITmcListener = DSITmcDispatcher.class$("org.dsi.ifc.tmc.DSITmcListener")) : class$org$dsi$ifc$tmc$DSITmcListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateEventsOnRoute(long l, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSITmcListener dSITmcListener = (DSITmcListener)iterator.next();
                    this.confirmNotificationListener(1, dSITmcListener);
                    dSITmcListener.updateEventsOnRoute(l, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSITmcListener dSITmcListener = (DSITmcListener)iterator.next();
                    dSITmcListener.updateEventsOnRoute(l, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateEventsTotal(int n, long l, long l2, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSITmcListener dSITmcListener = (DSITmcListener)iterator.next();
                    this.confirmNotificationListener(2, dSITmcListener);
                    dSITmcListener.updateEventsTotal(n, l, l2, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSITmcListener dSITmcListener = (DSITmcListener)iterator.next();
                    dSITmcListener.updateEventsTotal(n, l, l2, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTmcState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSITmcListener dSITmcListener = (DSITmcListener)iterator.next();
                    this.confirmNotificationListener(5, dSITmcListener);
                    dSITmcListener.updateTmcState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSITmcListener dSITmcListener = (DSITmcListener)iterator.next();
                    dSITmcListener.updateTmcState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateActiveTrafficSources(int[] nArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSITmcListener dSITmcListener = (DSITmcListener)iterator.next();
                    this.confirmNotificationListener(11, dSITmcListener);
                    dSITmcListener.updateActiveTrafficSources(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSITmcListener dSITmcListener = (DSITmcListener)iterator.next();
                    dSITmcListener.updateActiveTrafficSources(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIsEngineeringMode(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSITmcListener dSITmcListener = (DSITmcListener)iterator.next();
                    this.confirmNotificationListener(6, dSITmcListener);
                    dSITmcListener.updateIsEngineeringMode(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSITmcListener dSITmcListener = (DSITmcListener)iterator.next();
                    dSITmcListener.updateIsEngineeringMode(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCurrentLanguage(String string, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSITmcListener dSITmcListener = (DSITmcListener)iterator.next();
                    this.confirmNotificationListener(7, dSITmcListener);
                    dSITmcListener.updateCurrentLanguage(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSITmcListener dSITmcListener = (DSITmcListener)iterator.next();
                    dSITmcListener.updateCurrentLanguage(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateIsTmcProAvailable(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSITmcListener dSITmcListener = (DSITmcListener)iterator.next();
                    this.confirmNotificationListener(8, dSITmcListener);
                    dSITmcListener.updateIsTmcProAvailable(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSITmcListener dSITmcListener = (DSITmcListener)iterator.next();
                    dSITmcListener.updateIsTmcProAvailable(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void windowChange(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITmcListener dSITmcListener = (DSITmcListener)objectArray[i2];
                    dSITmcListener.windowChange(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void tmcWindowResult(int n, int n2, TmcListElement[] tmcListElementArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITmcListener dSITmcListener = (DSITmcListener)objectArray[i2];
                    dSITmcListener.tmcWindowResult(n, n2, tmcListElementArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setMessageFilterResult(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITmcListener dSITmcListener = (DSITmcListener)objectArray[i2];
                    dSITmcListener.setMessageFilterResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getMessageIdsForListElementResult(long[] lArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITmcListener dSITmcListener = (DSITmcListener)objectArray[i2];
                    dSITmcListener.getMessageIdsForListElementResult(lArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getBoundingRectangleForTrafficMessagesResult(NavRectangle navRectangle) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITmcListener dSITmcListener = (DSITmcListener)objectArray[i2];
                    dSITmcListener.getBoundingRectangleForTrafficMessagesResult(navRectangle);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAreaWarning(AreaWarningInfo areaWarningInfo, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSITmcListener dSITmcListener = (DSITmcListener)iterator.next();
                    this.confirmNotificationListener(12, dSITmcListener);
                    dSITmcListener.updateAreaWarning(areaWarningInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSITmcListener dSITmcListener = (DSITmcListener)iterator.next();
                    dSITmcListener.updateAreaWarning(areaWarningInfo, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAreaWarnings(AreaWarningInfo[] areaWarningInfoArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSITmcListener dSITmcListener = (DSITmcListener)iterator.next();
                    this.confirmNotificationListener(13, dSITmcListener);
                    dSITmcListener.updateAreaWarnings(areaWarningInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSITmcListener dSITmcListener = (DSITmcListener)iterator.next();
                    dSITmcListener.updateAreaWarnings(areaWarningInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateLocalHazardInformation(LocalHazardInformation[] localHazardInformationArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSITmcListener dSITmcListener = (DSITmcListener)iterator.next();
                    this.confirmNotificationListener(14, dSITmcListener);
                    dSITmcListener.updateLocalHazardInformation(localHazardInformationArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSITmcListener dSITmcListener = (DSITmcListener)iterator.next();
                    dSITmcListener.updateLocalHazardInformation(localHazardInformationArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTrafficFlowStatisticsStatus(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSITmcListener dSITmcListener = (DSITmcListener)iterator.next();
                    this.confirmNotificationListener(15, dSITmcListener);
                    dSITmcListener.updateTrafficFlowStatisticsStatus(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSITmcListener dSITmcListener = (DSITmcListener)iterator.next();
                    dSITmcListener.updateTrafficFlowStatisticsStatus(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTrafficSourceInformation(TrafficSource[] trafficSourceArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSITmcListener dSITmcListener = (DSITmcListener)iterator.next();
                    this.confirmNotificationListener(16, dSITmcListener);
                    dSITmcListener.updateTrafficSourceInformation(trafficSourceArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSITmcListener dSITmcListener = (DSITmcListener)iterator.next();
                    dSITmcListener.updateTrafficSourceInformation(trafficSourceArray, n);
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
                    DSITmcListener dSITmcListener = (DSITmcListener)objectArray[i2];
                    dSITmcListener.asyncException(n, string, n2);
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
                    DSITmcListener dSITmcListener = (DSITmcListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSITmcDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSITmcDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSITmcListener, new Object[]{string, string2});
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

