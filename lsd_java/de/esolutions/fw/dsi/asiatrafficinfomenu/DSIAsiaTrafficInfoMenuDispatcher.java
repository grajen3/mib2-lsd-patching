/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.asiatrafficinfomenu;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.asiatrafficinfomenu.DSIAsiaTrafficInfoMenuReply;
import de.esolutions.fw.comm.dsi.asiatrafficinfomenu.impl.DSIAsiaTrafficInfoMenuReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenuListener;
import org.dsi.ifc.asiatrafficinfomenu.Interrupt;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformation;
import org.dsi.ifc.asiatrafficinfomenu.TrafficInformationDetails;
import org.dsi.ifc.asiatrafficinfomenu.TunerData;
import org.dsi.ifc.global.DateTime;

public class DSIAsiaTrafficInfoMenuDispatcher
extends AbstractDispatcher
implements DSIAsiaTrafficInfoMenuReply {
    private DSIAsiaTrafficInfoMenuReplyService service = new DSIAsiaTrafficInfoMenuReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIAsiaTrafficInfoMenuDispatcher(int n) {
        super(n, (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener == null ? (class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener = DSIAsiaTrafficInfoMenuDispatcher.class$("org.dsi.ifc.asiatrafficinfomenu.DSIAsiaTrafficInfoMenuListener")) : class$org$dsi$ifc$asiatrafficinfomenu$DSIAsiaTrafficInfoMenuListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateActiveInterrupts(Interrupt[] interruptArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIAsiaTrafficInfoMenuListener dSIAsiaTrafficInfoMenuListener = (DSIAsiaTrafficInfoMenuListener)iterator.next();
                    this.confirmNotificationListener(1, dSIAsiaTrafficInfoMenuListener);
                    dSIAsiaTrafficInfoMenuListener.updateActiveInterrupts(interruptArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIAsiaTrafficInfoMenuListener dSIAsiaTrafficInfoMenuListener = (DSIAsiaTrafficInfoMenuListener)iterator.next();
                    dSIAsiaTrafficInfoMenuListener.updateActiveInterrupts(interruptArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTrafficType(TrafficInformation[] trafficInformationArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIAsiaTrafficInfoMenuListener dSIAsiaTrafficInfoMenuListener = (DSIAsiaTrafficInfoMenuListener)iterator.next();
                    this.confirmNotificationListener(2, dSIAsiaTrafficInfoMenuListener);
                    dSIAsiaTrafficInfoMenuListener.updateTrafficType(trafficInformationArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIAsiaTrafficInfoMenuListener dSIAsiaTrafficInfoMenuListener = (DSIAsiaTrafficInfoMenuListener)iterator.next();
                    dSIAsiaTrafficInfoMenuListener.updateTrafficType(trafficInformationArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePrefecture(String string, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIAsiaTrafficInfoMenuListener dSIAsiaTrafficInfoMenuListener = (DSIAsiaTrafficInfoMenuListener)iterator.next();
                    this.confirmNotificationListener(3, dSIAsiaTrafficInfoMenuListener);
                    dSIAsiaTrafficInfoMenuListener.updatePrefecture(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIAsiaTrafficInfoMenuListener dSIAsiaTrafficInfoMenuListener = (DSIAsiaTrafficInfoMenuListener)iterator.next();
                    dSIAsiaTrafficInfoMenuListener.updatePrefecture(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateProbeDataSetting(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIAsiaTrafficInfoMenuListener dSIAsiaTrafficInfoMenuListener = (DSIAsiaTrafficInfoMenuListener)iterator.next();
                    this.confirmNotificationListener(4, dSIAsiaTrafficInfoMenuListener);
                    dSIAsiaTrafficInfoMenuListener.updateProbeDataSetting(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIAsiaTrafficInfoMenuListener dSIAsiaTrafficInfoMenuListener = (DSIAsiaTrafficInfoMenuListener)iterator.next();
                    dSIAsiaTrafficInfoMenuListener.updateProbeDataSetting(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateFrequency(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIAsiaTrafficInfoMenuListener dSIAsiaTrafficInfoMenuListener = (DSIAsiaTrafficInfoMenuListener)iterator.next();
                    this.confirmNotificationListener(5, dSIAsiaTrafficInfoMenuListener);
                    dSIAsiaTrafficInfoMenuListener.updateFrequency(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIAsiaTrafficInfoMenuListener dSIAsiaTrafficInfoMenuListener = (DSIAsiaTrafficInfoMenuListener)iterator.next();
                    dSIAsiaTrafficInfoMenuListener.updateFrequency(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateReceptionStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIAsiaTrafficInfoMenuListener dSIAsiaTrafficInfoMenuListener = (DSIAsiaTrafficInfoMenuListener)iterator.next();
                    this.confirmNotificationListener(6, dSIAsiaTrafficInfoMenuListener);
                    dSIAsiaTrafficInfoMenuListener.updateReceptionStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIAsiaTrafficInfoMenuListener dSIAsiaTrafficInfoMenuListener = (DSIAsiaTrafficInfoMenuListener)iterator.next();
                    dSIAsiaTrafficInfoMenuListener.updateReceptionStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateReceptionDate(DateTime dateTime, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIAsiaTrafficInfoMenuListener dSIAsiaTrafficInfoMenuListener = (DSIAsiaTrafficInfoMenuListener)iterator.next();
                    this.confirmNotificationListener(8, dSIAsiaTrafficInfoMenuListener);
                    dSIAsiaTrafficInfoMenuListener.updateReceptionDate(dateTime, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIAsiaTrafficInfoMenuListener dSIAsiaTrafficInfoMenuListener = (DSIAsiaTrafficInfoMenuListener)iterator.next();
                    dSIAsiaTrafficInfoMenuListener.updateReceptionDate(dateTime, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void requestResourceInformationResponse(int n, ResourceInformation resourceInformation) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAsiaTrafficInfoMenuListener dSIAsiaTrafficInfoMenuListener = (DSIAsiaTrafficInfoMenuListener)objectArray[i2];
                    dSIAsiaTrafficInfoMenuListener.requestResourceInformationResponse(n, resourceInformation);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void requestTrafficInformationDetailsResponse(int n, TrafficInformationDetails[] trafficInformationDetailsArray) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAsiaTrafficInfoMenuListener dSIAsiaTrafficInfoMenuListener = (DSIAsiaTrafficInfoMenuListener)objectArray[i2];
                    dSIAsiaTrafficInfoMenuListener.requestTrafficInformationDetailsResponse(n, trafficInformationDetailsArray);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateReceivableStations(TunerData[] tunerDataArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIAsiaTrafficInfoMenuListener dSIAsiaTrafficInfoMenuListener = (DSIAsiaTrafficInfoMenuListener)iterator.next();
                    this.confirmNotificationListener(7, dSIAsiaTrafficInfoMenuListener);
                    dSIAsiaTrafficInfoMenuListener.updateReceivableStations(tunerDataArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIAsiaTrafficInfoMenuListener dSIAsiaTrafficInfoMenuListener = (DSIAsiaTrafficInfoMenuListener)iterator.next();
                    dSIAsiaTrafficInfoMenuListener.updateReceivableStations(tunerDataArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setLanguageResponse(boolean bl) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIAsiaTrafficInfoMenuListener dSIAsiaTrafficInfoMenuListener = (DSIAsiaTrafficInfoMenuListener)objectArray[i2];
                    dSIAsiaTrafficInfoMenuListener.setLanguageResponse(bl);
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
                    DSIAsiaTrafficInfoMenuListener dSIAsiaTrafficInfoMenuListener = (DSIAsiaTrafficInfoMenuListener)objectArray[i2];
                    dSIAsiaTrafficInfoMenuListener.asyncException(n, string, n2);
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
                    DSIAsiaTrafficInfoMenuListener dSIAsiaTrafficInfoMenuListener = (DSIAsiaTrafficInfoMenuListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIAsiaTrafficInfoMenuDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIAsiaTrafficInfoMenuDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIAsiaTrafficInfoMenuListener, new Object[]{string, string2});
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

