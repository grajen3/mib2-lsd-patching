/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.predictivenavigation;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.predictivenavigation.DSIPredictiveNavigationReply;
import de.esolutions.fw.comm.dsi.predictivenavigation.impl.DSIPredictiveNavigationReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.predictivenavigation.DSIPredictiveNavigationListener;
import org.dsi.ifc.predictivenavigation.LikelyDestination;

public class DSIPredictiveNavigationDispatcher
extends AbstractDispatcher
implements DSIPredictiveNavigationReply {
    private DSIPredictiveNavigationReplyService service = new DSIPredictiveNavigationReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigationListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIPredictiveNavigationDispatcher(int n) {
        super(n, (class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigationListener == null ? (class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigationListener = DSIPredictiveNavigationDispatcher.class$("org.dsi.ifc.predictivenavigation.DSIPredictiveNavigationListener")) : class$org$dsi$ifc$predictivenavigation$DSIPredictiveNavigationListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateOperationMode(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIPredictiveNavigationListener dSIPredictiveNavigationListener = (DSIPredictiveNavigationListener)iterator.next();
                    this.confirmNotificationListener(1, dSIPredictiveNavigationListener);
                    dSIPredictiveNavigationListener.updateOperationMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIPredictiveNavigationListener dSIPredictiveNavigationListener = (DSIPredictiveNavigationListener)iterator.next();
                    dSIPredictiveNavigationListener.updateOperationMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateLikelyDestinations(LikelyDestination[] likelyDestinationArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIPredictiveNavigationListener dSIPredictiveNavigationListener = (DSIPredictiveNavigationListener)iterator.next();
                    this.confirmNotificationListener(2, dSIPredictiveNavigationListener);
                    dSIPredictiveNavigationListener.updateLikelyDestinations(likelyDestinationArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIPredictiveNavigationListener dSIPredictiveNavigationListener = (DSIPredictiveNavigationListener)iterator.next();
                    dSIPredictiveNavigationListener.updateLikelyDestinations(likelyDestinationArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMaxPredictions(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIPredictiveNavigationListener dSIPredictiveNavigationListener = (DSIPredictiveNavigationListener)iterator.next();
                    this.confirmNotificationListener(3, dSIPredictiveNavigationListener);
                    dSIPredictiveNavigationListener.updateMaxPredictions(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIPredictiveNavigationListener dSIPredictiveNavigationListener = (DSIPredictiveNavigationListener)iterator.next();
                    dSIPredictiveNavigationListener.updateMaxPredictions(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void clearCacheResult() {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIPredictiveNavigationListener dSIPredictiveNavigationListener = (DSIPredictiveNavigationListener)objectArray[i2];
                    dSIPredictiveNavigationListener.clearCacheResult();
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
                    DSIPredictiveNavigationListener dSIPredictiveNavigationListener = (DSIPredictiveNavigationListener)objectArray[i2];
                    dSIPredictiveNavigationListener.asyncException(n, string, n2);
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
                    DSIPredictiveNavigationListener dSIPredictiveNavigationListener = (DSIPredictiveNavigationListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIPredictiveNavigationDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIPredictiveNavigationDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIPredictiveNavigationListener, new Object[]{string, string2});
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

