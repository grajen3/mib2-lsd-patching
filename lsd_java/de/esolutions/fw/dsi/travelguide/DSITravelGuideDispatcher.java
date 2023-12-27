/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.travelguide;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.travelguide.DSITravelGuideReply;
import de.esolutions.fw.comm.dsi.travelguide.impl.DSITravelGuideReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.travelguide.DSITravelGuideListener;
import org.dsi.ifc.travelguide.TravelGuideMemoryListElement;

public class DSITravelGuideDispatcher
extends AbstractDispatcher
implements DSITravelGuideReply {
    private DSITravelGuideReplyService service = new DSITravelGuideReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$travelguide$DSITravelGuideListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSITravelGuideDispatcher(int n) {
        super(n, (class$org$dsi$ifc$travelguide$DSITravelGuideListener == null ? (class$org$dsi$ifc$travelguide$DSITravelGuideListener = DSITravelGuideDispatcher.class$("org.dsi.ifc.travelguide.DSITravelGuideListener")) : class$org$dsi$ifc$travelguide$DSITravelGuideListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void importTravelGuideResult(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITravelGuideListener dSITravelGuideListener = (DSITravelGuideListener)objectArray[i2];
                    dSITravelGuideListener.importTravelGuideResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTravelGuideMemoryListElement(TravelGuideMemoryListElement travelGuideMemoryListElement, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSITravelGuideListener dSITravelGuideListener = (DSITravelGuideListener)iterator.next();
                    this.confirmNotificationListener(2, dSITravelGuideListener);
                    dSITravelGuideListener.updateTravelGuideMemoryListElement(travelGuideMemoryListElement, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSITravelGuideListener dSITravelGuideListener = (DSITravelGuideListener)iterator.next();
                    dSITravelGuideListener.updateTravelGuideMemoryListElement(travelGuideMemoryListElement, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void deleteTravelGuideResult(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITravelGuideListener dSITravelGuideListener = (DSITravelGuideListener)objectArray[i2];
                    dSITravelGuideListener.deleteTravelGuideResult(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTravelGuideMemoryList(TravelGuideMemoryListElement[] travelGuideMemoryListElementArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSITravelGuideListener dSITravelGuideListener = (DSITravelGuideListener)iterator.next();
                    this.confirmNotificationListener(1, dSITravelGuideListener);
                    dSITravelGuideListener.updateTravelGuideMemoryList(travelGuideMemoryListElementArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSITravelGuideListener dSITravelGuideListener = (DSITravelGuideListener)iterator.next();
                    dSITravelGuideListener.updateTravelGuideMemoryList(travelGuideMemoryListElementArray, n);
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
                    DSITravelGuideListener dSITravelGuideListener = (DSITravelGuideListener)objectArray[i2];
                    dSITravelGuideListener.asyncException(n, string, n2);
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
                    DSITravelGuideListener dSITravelGuideListener = (DSITravelGuideListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSITravelGuideDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSITravelGuideDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSITravelGuideListener, new Object[]{string, string2});
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

