/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.radio;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.radio.DSITunerAnnouncementReply;
import de.esolutions.fw.comm.dsi.radio.impl.DSITunerAnnouncementReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.radio.DSITunerAnnouncementListener;

public class DSITunerAnnouncementDispatcher
extends AbstractDispatcher
implements DSITunerAnnouncementReply {
    private DSITunerAnnouncementReplyService service = new DSITunerAnnouncementReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSITunerAnnouncementListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSITunerAnnouncementDispatcher(int n) {
        super(n, (class$org$dsi$ifc$radio$DSITunerAnnouncementListener == null ? (class$org$dsi$ifc$radio$DSITunerAnnouncementListener = DSITunerAnnouncementDispatcher.class$("org.dsi.ifc.radio.DSITunerAnnouncementListener")) : class$org$dsi$ifc$radio$DSITunerAnnouncementListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateFilter(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSITunerAnnouncementListener dSITunerAnnouncementListener = (DSITunerAnnouncementListener)iterator.next();
                    this.confirmNotificationListener(1, dSITunerAnnouncementListener);
                    dSITunerAnnouncementListener.updateFilter(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSITunerAnnouncementListener dSITunerAnnouncementListener = (DSITunerAnnouncementListener)iterator.next();
                    dSITunerAnnouncementListener.updateFilter(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAvailability(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSITunerAnnouncementListener dSITunerAnnouncementListener = (DSITunerAnnouncementListener)iterator.next();
                    this.confirmNotificationListener(2, dSITunerAnnouncementListener);
                    dSITunerAnnouncementListener.updateAvailability(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSITunerAnnouncementListener dSITunerAnnouncementListener = (DSITunerAnnouncementListener)iterator.next();
                    dSITunerAnnouncementListener.updateAvailability(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSITunerAnnouncementListener dSITunerAnnouncementListener = (DSITunerAnnouncementListener)iterator.next();
                    this.confirmNotificationListener(3, dSITunerAnnouncementListener);
                    dSITunerAnnouncementListener.updateStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSITunerAnnouncementListener dSITunerAnnouncementListener = (DSITunerAnnouncementListener)iterator.next();
                    dSITunerAnnouncementListener.updateStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateStationName(String string, int n, long l, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSITunerAnnouncementListener dSITunerAnnouncementListener = (DSITunerAnnouncementListener)iterator.next();
                    this.confirmNotificationListener(4, dSITunerAnnouncementListener);
                    dSITunerAnnouncementListener.updateStationName(string, n, l, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSITunerAnnouncementListener dSITunerAnnouncementListener = (DSITunerAnnouncementListener)iterator.next();
                    dSITunerAnnouncementListener.updateStationName(string, n, l, n2);
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
                    DSITunerAnnouncementListener dSITunerAnnouncementListener = (DSITunerAnnouncementListener)objectArray[i2];
                    dSITunerAnnouncementListener.asyncException(n, string, n2);
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
                    DSITunerAnnouncementListener dSITunerAnnouncementListener = (DSITunerAnnouncementListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSITunerAnnouncementDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSITunerAnnouncementDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSITunerAnnouncementListener, new Object[]{string, string2});
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

