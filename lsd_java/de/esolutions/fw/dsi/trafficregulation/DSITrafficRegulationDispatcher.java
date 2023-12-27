/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.trafficregulation;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.trafficregulation.DSITrafficRegulationReply;
import de.esolutions.fw.comm.dsi.trafficregulation.impl.DSITrafficRegulationReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.trafficregulation.DSITrafficRegulationListener;
import org.dsi.ifc.trafficregulation.RoadClassSpeedInfo;
import org.dsi.ifc.trafficregulation.TrafficSignInformation;
import org.dsi.ifc.trafficregulation.TrafficSignInformationOnRoute;

public class DSITrafficRegulationDispatcher
extends AbstractDispatcher
implements DSITrafficRegulationReply {
    private DSITrafficRegulationReplyService service = new DSITrafficRegulationReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSITrafficRegulationDispatcher(int n) {
        super(n, (class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener == null ? (class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener = DSITrafficRegulationDispatcher.class$("org.dsi.ifc.trafficregulation.DSITrafficRegulationListener")) : class$org$dsi$ifc$trafficregulation$DSITrafficRegulationListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateCountrySpeedInformation(RoadClassSpeedInfo[] roadClassSpeedInfoArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSITrafficRegulationListener dSITrafficRegulationListener = (DSITrafficRegulationListener)iterator.next();
                    this.confirmNotificationListener(2, dSITrafficRegulationListener);
                    dSITrafficRegulationListener.updateCountrySpeedInformation(roadClassSpeedInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSITrafficRegulationListener dSITrafficRegulationListener = (DSITrafficRegulationListener)iterator.next();
                    dSITrafficRegulationListener.updateCountrySpeedInformation(roadClassSpeedInfoArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCurrentTrafficSign(TrafficSignInformation trafficSignInformation, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSITrafficRegulationListener dSITrafficRegulationListener = (DSITrafficRegulationListener)iterator.next();
                    this.confirmNotificationListener(3, dSITrafficRegulationListener);
                    dSITrafficRegulationListener.updateCurrentTrafficSign(trafficSignInformation, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSITrafficRegulationListener dSITrafficRegulationListener = (DSITrafficRegulationListener)iterator.next();
                    dSITrafficRegulationListener.updateCurrentTrafficSign(trafficSignInformation, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTrafficSignOnRoute(TrafficSignInformationOnRoute[] trafficSignInformationOnRouteArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSITrafficRegulationListener dSITrafficRegulationListener = (DSITrafficRegulationListener)iterator.next();
                    this.confirmNotificationListener(4, dSITrafficRegulationListener);
                    dSITrafficRegulationListener.updateTrafficSignOnRoute(trafficSignInformationOnRouteArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSITrafficRegulationListener dSITrafficRegulationListener = (DSITrafficRegulationListener)iterator.next();
                    dSITrafficRegulationListener.updateTrafficSignOnRoute(trafficSignInformationOnRouteArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void requestRoadClassSpeedInfoForCountryResult(RoadClassSpeedInfo[] roadClassSpeedInfoArray, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITrafficRegulationListener dSITrafficRegulationListener = (DSITrafficRegulationListener)objectArray[i2];
                    dSITrafficRegulationListener.requestRoadClassSpeedInfoForCountryResult(roadClassSpeedInfoArray, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTrailerStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSITrafficRegulationListener dSITrafficRegulationListener = (DSITrafficRegulationListener)iterator.next();
                    this.confirmNotificationListener(5, dSITrafficRegulationListener);
                    dSITrafficRegulationListener.updateTrailerStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSITrafficRegulationListener dSITrafficRegulationListener = (DSITrafficRegulationListener)iterator.next();
                    dSITrafficRegulationListener.updateTrailerStatus(n, n2);
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
                    DSITrafficRegulationListener dSITrafficRegulationListener = (DSITrafficRegulationListener)objectArray[i2];
                    dSITrafficRegulationListener.asyncException(n, string, n2);
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
                    DSITrafficRegulationListener dSITrafficRegulationListener = (DSITrafficRegulationListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSITrafficRegulationDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSITrafficRegulationDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSITrafficRegulationListener, new Object[]{string, string2});
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

