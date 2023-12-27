/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.swdlprogress;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.swdlprogress.DSISwdlProgressReply;
import de.esolutions.fw.comm.dsi.swdlprogress.impl.DSISwdlProgressReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.swdlprogress.DSISwdlProgressListener;
import org.dsi.ifc.swdlprogress.DeviceOverviewProgress;
import org.dsi.ifc.swdlprogress.GeneralProgress;

public class DSISwdlProgressDispatcher
extends AbstractDispatcher
implements DSISwdlProgressReply {
    private DSISwdlProgressReplyService service = new DSISwdlProgressReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$swdlprogress$DSISwdlProgressListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSISwdlProgressDispatcher(int n) {
        super(n, (class$org$dsi$ifc$swdlprogress$DSISwdlProgressListener == null ? (class$org$dsi$ifc$swdlprogress$DSISwdlProgressListener = DSISwdlProgressDispatcher.class$("org.dsi.ifc.swdlprogress.DSISwdlProgressListener")) : class$org$dsi$ifc$swdlprogress$DSISwdlProgressListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateGeneralProgress(GeneralProgress generalProgress, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSISwdlProgressListener dSISwdlProgressListener = (DSISwdlProgressListener)iterator.next();
                    this.confirmNotificationListener(1, dSISwdlProgressListener);
                    dSISwdlProgressListener.updateGeneralProgress(generalProgress, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSISwdlProgressListener dSISwdlProgressListener = (DSISwdlProgressListener)iterator.next();
                    dSISwdlProgressListener.updateGeneralProgress(generalProgress, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDevicesOverviewProgress(DeviceOverviewProgress[] deviceOverviewProgressArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSISwdlProgressListener dSISwdlProgressListener = (DSISwdlProgressListener)iterator.next();
                    this.confirmNotificationListener(2, dSISwdlProgressListener);
                    dSISwdlProgressListener.updateDevicesOverviewProgress(deviceOverviewProgressArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSISwdlProgressListener dSISwdlProgressListener = (DSISwdlProgressListener)iterator.next();
                    dSISwdlProgressListener.updateDevicesOverviewProgress(deviceOverviewProgressArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTriggerPanel(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSISwdlProgressListener dSISwdlProgressListener = (DSISwdlProgressListener)iterator.next();
                    this.confirmNotificationListener(3, dSISwdlProgressListener);
                    dSISwdlProgressListener.updateTriggerPanel(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSISwdlProgressListener dSISwdlProgressListener = (DSISwdlProgressListener)iterator.next();
                    dSISwdlProgressListener.updateTriggerPanel(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateLostDevices(String[] stringArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSISwdlProgressListener dSISwdlProgressListener = (DSISwdlProgressListener)iterator.next();
                    this.confirmNotificationListener(4, dSISwdlProgressListener);
                    dSISwdlProgressListener.updateLostDevices(stringArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSISwdlProgressListener dSISwdlProgressListener = (DSISwdlProgressListener)iterator.next();
                    dSISwdlProgressListener.updateLostDevices(stringArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateOverviewStatus(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSISwdlProgressListener dSISwdlProgressListener = (DSISwdlProgressListener)iterator.next();
                    this.confirmNotificationListener(5, dSISwdlProgressListener);
                    dSISwdlProgressListener.updateOverviewStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSISwdlProgressListener dSISwdlProgressListener = (DSISwdlProgressListener)iterator.next();
                    dSISwdlProgressListener.updateOverviewStatus(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateActiveDevices(String[] stringArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSISwdlProgressListener dSISwdlProgressListener = (DSISwdlProgressListener)iterator.next();
                    this.confirmNotificationListener(6, dSISwdlProgressListener);
                    dSISwdlProgressListener.updateActiveDevices(stringArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSISwdlProgressListener dSISwdlProgressListener = (DSISwdlProgressListener)iterator.next();
                    dSISwdlProgressListener.updateActiveDevices(stringArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getStaticProgressDetails(int n, int n2, short s, String string) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlProgressListener dSISwdlProgressListener = (DSISwdlProgressListener)objectArray[i2];
                    dSISwdlProgressListener.getStaticProgressDetails(n, n2, s, string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void getDynamicProgressDetails(int n, byte by, String string) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlProgressListener dSISwdlProgressListener = (DSISwdlProgressListener)objectArray[i2];
                    dSISwdlProgressListener.getDynamicProgressDetails(n, by, string);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicatePopUp(int n, String string, byte by, int n2, int n3, String string2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlProgressListener dSISwdlProgressListener = (DSISwdlProgressListener)objectArray[i2];
                    dSISwdlProgressListener.indicatePopUp(n, string, by, n2, n3, string2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void indicateDismissPopUp(int n, String string) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSISwdlProgressListener dSISwdlProgressListener = (DSISwdlProgressListener)objectArray[i2];
                    dSISwdlProgressListener.indicateDismissPopUp(n, string);
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
                    DSISwdlProgressListener dSISwdlProgressListener = (DSISwdlProgressListener)objectArray[i2];
                    dSISwdlProgressListener.asyncException(n, string, n2);
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
                    DSISwdlProgressListener dSISwdlProgressListener = (DSISwdlProgressListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSISwdlProgressDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSISwdlProgressDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSISwdlProgressListener, new Object[]{string, string2});
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

