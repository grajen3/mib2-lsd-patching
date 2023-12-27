/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.mobilityhorizon;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.mobilityhorizon.DSIMobilityHorizonReply;
import de.esolutions.fw.comm.dsi.mobilityhorizon.impl.DSIMobilityHorizonReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.mobilityhorizon.DSIMobilityHorizonListener;
import org.dsi.ifc.mobilityhorizon.MobilityHorizonLocation;

public class DSIMobilityHorizonDispatcher
extends AbstractDispatcher
implements DSIMobilityHorizonReply {
    private DSIMobilityHorizonReplyService service = new DSIMobilityHorizonReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizonListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIMobilityHorizonDispatcher(int n) {
        super(n, (class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizonListener == null ? (class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizonListener = DSIMobilityHorizonDispatcher.class$("org.dsi.ifc.mobilityhorizon.DSIMobilityHorizonListener")) : class$org$dsi$ifc$mobilityhorizon$DSIMobilityHorizonListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateLocations(MobilityHorizonLocation[] mobilityHorizonLocationArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMobilityHorizonListener dSIMobilityHorizonListener = (DSIMobilityHorizonListener)iterator.next();
                    this.confirmNotificationListener(1, dSIMobilityHorizonListener);
                    dSIMobilityHorizonListener.updateLocations(mobilityHorizonLocationArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMobilityHorizonListener dSIMobilityHorizonListener = (DSIMobilityHorizonListener)iterator.next();
                    dSIMobilityHorizonListener.updateLocations(mobilityHorizonLocationArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateConsideredLocationTypes(int[] nArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIMobilityHorizonListener dSIMobilityHorizonListener = (DSIMobilityHorizonListener)iterator.next();
                    this.confirmNotificationListener(2, dSIMobilityHorizonListener);
                    dSIMobilityHorizonListener.updateConsideredLocationTypes(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIMobilityHorizonListener dSIMobilityHorizonListener = (DSIMobilityHorizonListener)iterator.next();
                    dSIMobilityHorizonListener.updateConsideredLocationTypes(nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDriveTrainMode(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIMobilityHorizonListener dSIMobilityHorizonListener = (DSIMobilityHorizonListener)iterator.next();
                    this.confirmNotificationListener(3, dSIMobilityHorizonListener);
                    dSIMobilityHorizonListener.updateDriveTrainMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIMobilityHorizonListener dSIMobilityHorizonListener = (DSIMobilityHorizonListener)iterator.next();
                    dSIMobilityHorizonListener.updateDriveTrainMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMobilityHorizonStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIMobilityHorizonListener dSIMobilityHorizonListener = (DSIMobilityHorizonListener)iterator.next();
                    this.confirmNotificationListener(4, dSIMobilityHorizonListener);
                    dSIMobilityHorizonListener.updateMobilityHorizonStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIMobilityHorizonListener dSIMobilityHorizonListener = (DSIMobilityHorizonListener)iterator.next();
                    dSIMobilityHorizonListener.updateMobilityHorizonStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void requestLocationRangeLevelResult(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMobilityHorizonListener dSIMobilityHorizonListener = (DSIMobilityHorizonListener)objectArray[i2];
                    dSIMobilityHorizonListener.requestLocationRangeLevelResult(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void locationRangeLevelChanged(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMobilityHorizonListener dSIMobilityHorizonListener = (DSIMobilityHorizonListener)objectArray[i2];
                    dSIMobilityHorizonListener.locationRangeLevelChanged(n);
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
                    DSIMobilityHorizonListener dSIMobilityHorizonListener = (DSIMobilityHorizonListener)objectArray[i2];
                    dSIMobilityHorizonListener.asyncException(n, string, n2);
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
                    DSIMobilityHorizonListener dSIMobilityHorizonListener = (DSIMobilityHorizonListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIMobilityHorizonDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIMobilityHorizonDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIMobilityHorizonListener, new Object[]{string, string2});
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

