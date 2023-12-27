/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.networking;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.networking.DSIDataConfigurationReply;
import de.esolutions.fw.comm.dsi.networking.impl.DSIDataConfigurationReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.networking.CDataProfile;
import org.dsi.ifc.networking.CPacketCounter;
import org.dsi.ifc.networking.DSIDataConfigurationListener;

public class DSIDataConfigurationDispatcher
extends AbstractDispatcher
implements DSIDataConfigurationReply {
    private DSIDataConfigurationReplyService service = new DSIDataConfigurationReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$networking$DSIDataConfigurationListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIDataConfigurationDispatcher(int n) {
        super(n, (class$org$dsi$ifc$networking$DSIDataConfigurationListener == null ? (class$org$dsi$ifc$networking$DSIDataConfigurationListener = DSIDataConfigurationDispatcher.class$("org.dsi.ifc.networking.DSIDataConfigurationListener")) : class$org$dsi$ifc$networking$DSIDataConfigurationListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateAvailableProfiles(CDataProfile[] cDataProfileArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIDataConfigurationListener dSIDataConfigurationListener = (DSIDataConfigurationListener)iterator.next();
                    this.confirmNotificationListener(1, dSIDataConfigurationListener);
                    dSIDataConfigurationListener.updateAvailableProfiles(cDataProfileArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIDataConfigurationListener dSIDataConfigurationListener = (DSIDataConfigurationListener)iterator.next();
                    dSIDataConfigurationListener.updateAvailableProfiles(cDataProfileArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateActiveProfile(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIDataConfigurationListener dSIDataConfigurationListener = (DSIDataConfigurationListener)iterator.next();
                    this.confirmNotificationListener(2, dSIDataConfigurationListener);
                    dSIDataConfigurationListener.updateActiveProfile(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIDataConfigurationListener dSIDataConfigurationListener = (DSIDataConfigurationListener)iterator.next();
                    dSIDataConfigurationListener.updateActiveProfile(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRoamingState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIDataConfigurationListener dSIDataConfigurationListener = (DSIDataConfigurationListener)iterator.next();
                    this.confirmNotificationListener(3, dSIDataConfigurationListener);
                    dSIDataConfigurationListener.updateRoamingState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIDataConfigurationListener dSIDataConfigurationListener = (DSIDataConfigurationListener)iterator.next();
                    dSIDataConfigurationListener.updateRoamingState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateConnectionMode(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIDataConfigurationListener dSIDataConfigurationListener = (DSIDataConfigurationListener)iterator.next();
                    this.confirmNotificationListener(4, dSIDataConfigurationListener);
                    dSIDataConfigurationListener.updateConnectionMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIDataConfigurationListener dSIDataConfigurationListener = (DSIDataConfigurationListener)iterator.next();
                    dSIDataConfigurationListener.updateConnectionMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDataRequest(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIDataConfigurationListener dSIDataConfigurationListener = (DSIDataConfigurationListener)iterator.next();
                    this.confirmNotificationListener(6, dSIDataConfigurationListener);
                    dSIDataConfigurationListener.updateDataRequest(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIDataConfigurationListener dSIDataConfigurationListener = (DSIDataConfigurationListener)iterator.next();
                    dSIDataConfigurationListener.updateDataRequest(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRequestSetting(int n, int n2, int n3) {
        if ((n3 & 0x80) == 128) {
            n3 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIDataConfigurationListener dSIDataConfigurationListener = (DSIDataConfigurationListener)iterator.next();
                    this.confirmNotificationListener(9, dSIDataConfigurationListener);
                    dSIDataConfigurationListener.updateRequestSetting(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIDataConfigurationListener dSIDataConfigurationListener = (DSIDataConfigurationListener)iterator.next();
                    dSIDataConfigurationListener.updateRequestSetting(n, n2, n3);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setDataProfileResponse(CDataProfile cDataProfile, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDataConfigurationListener dSIDataConfigurationListener = (DSIDataConfigurationListener)objectArray[i2];
                    dSIDataConfigurationListener.setDataProfileResponse(cDataProfile, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void automaticProfileResponse(int n, CDataProfile cDataProfile, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDataConfigurationListener dSIDataConfigurationListener = (DSIDataConfigurationListener)objectArray[i2];
                    dSIDataConfigurationListener.automaticProfileResponse(n, cDataProfile, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setRoamingStateResponse(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDataConfigurationListener dSIDataConfigurationListener = (DSIDataConfigurationListener)objectArray[i2];
                    dSIDataConfigurationListener.setRoamingStateResponse(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setConnectionModeResponse(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDataConfigurationListener dSIDataConfigurationListener = (DSIDataConfigurationListener)objectArray[i2];
                    dSIDataConfigurationListener.setConnectionModeResponse(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void setRequestSettingResponse(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDataConfigurationListener dSIDataConfigurationListener = (DSIDataConfigurationListener)objectArray[i2];
                    dSIDataConfigurationListener.setRequestSettingResponse(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void acceptDataRequestResponse(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDataConfigurationListener dSIDataConfigurationListener = (DSIDataConfigurationListener)objectArray[i2];
                    dSIDataConfigurationListener.acceptDataRequestResponse(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void resetPacketCounterResponse(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDataConfigurationListener dSIDataConfigurationListener = (DSIDataConfigurationListener)objectArray[i2];
                    dSIDataConfigurationListener.resetPacketCounterResponse(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void restoreFactorySettingsResponse(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDataConfigurationListener dSIDataConfigurationListener = (DSIDataConfigurationListener)objectArray[i2];
                    dSIDataConfigurationListener.restoreFactorySettingsResponse(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePacketCounter(CPacketCounter cPacketCounter, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSIDataConfigurationListener dSIDataConfigurationListener = (DSIDataConfigurationListener)iterator.next();
                    this.confirmNotificationListener(12, dSIDataConfigurationListener);
                    dSIDataConfigurationListener.updatePacketCounter(cPacketCounter, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSIDataConfigurationListener dSIDataConfigurationListener = (DSIDataConfigurationListener)iterator.next();
                    dSIDataConfigurationListener.updatePacketCounter(cPacketCounter, n);
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
                    DSIDataConfigurationListener dSIDataConfigurationListener = (DSIDataConfigurationListener)objectArray[i2];
                    dSIDataConfigurationListener.asyncException(n, string, n2);
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
                    DSIDataConfigurationListener dSIDataConfigurationListener = (DSIDataConfigurationListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIDataConfigurationDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIDataConfigurationDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIDataConfigurationListener, new Object[]{string, string2});
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

