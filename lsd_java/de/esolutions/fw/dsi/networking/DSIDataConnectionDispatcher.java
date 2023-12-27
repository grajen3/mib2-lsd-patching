/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.networking;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.networking.DSIDataConnectionReply;
import de.esolutions.fw.comm.dsi.networking.impl.DSIDataConnectionReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.networking.ApplicationErrorStruct;
import org.dsi.ifc.networking.ConnectionStateInformationStruct;
import org.dsi.ifc.networking.DSIDataConnectionListener;
import org.dsi.ifc.networking.DataConnectionStateStruct;

public class DSIDataConnectionDispatcher
extends AbstractDispatcher
implements DSIDataConnectionReply {
    private DSIDataConnectionReplyService service = new DSIDataConnectionReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$networking$DSIDataConnectionListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIDataConnectionDispatcher(int n) {
        super(n, (class$org$dsi$ifc$networking$DSIDataConnectionListener == null ? (class$org$dsi$ifc$networking$DSIDataConnectionListener = DSIDataConnectionDispatcher.class$("org.dsi.ifc.networking.DSIDataConnectionListener")) : class$org$dsi$ifc$networking$DSIDataConnectionListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateStateDataConnection(DataConnectionStateStruct dataConnectionStateStruct, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIDataConnectionListener dSIDataConnectionListener = (DSIDataConnectionListener)iterator.next();
                    this.confirmNotificationListener(1, dSIDataConnectionListener);
                    dSIDataConnectionListener.updateStateDataConnection(dataConnectionStateStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIDataConnectionListener dSIDataConnectionListener = (DSIDataConnectionListener)iterator.next();
                    dSIDataConnectionListener.updateStateDataConnection(dataConnectionStateStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateConnectionStateInformation(ConnectionStateInformationStruct connectionStateInformationStruct, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIDataConnectionListener dSIDataConnectionListener = (DSIDataConnectionListener)iterator.next();
                    this.confirmNotificationListener(3, dSIDataConnectionListener);
                    dSIDataConnectionListener.updateConnectionStateInformation(connectionStateInformationStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIDataConnectionListener dSIDataConnectionListener = (DSIDataConnectionListener)iterator.next();
                    dSIDataConnectionListener.updateConnectionStateInformation(connectionStateInformationStruct, n);
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
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIDataConnectionListener dSIDataConnectionListener = (DSIDataConnectionListener)iterator.next();
                    this.confirmNotificationListener(4, dSIDataConnectionListener);
                    dSIDataConnectionListener.updateRoamingState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIDataConnectionListener dSIDataConnectionListener = (DSIDataConnectionListener)iterator.next();
                    dSIDataConnectionListener.updateRoamingState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateErrorState(ApplicationErrorStruct applicationErrorStruct, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIDataConnectionListener dSIDataConnectionListener = (DSIDataConnectionListener)iterator.next();
                    this.confirmNotificationListener(2, dSIDataConnectionListener);
                    dSIDataConnectionListener.updateErrorState(applicationErrorStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIDataConnectionListener dSIDataConnectionListener = (DSIDataConnectionListener)iterator.next();
                    dSIDataConnectionListener.updateErrorState(applicationErrorStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void forceDisconnectResponse(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIDataConnectionListener dSIDataConnectionListener = (DSIDataConnectionListener)objectArray[i2];
                    dSIDataConnectionListener.forceDisconnectResponse(n);
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
                    DSIDataConnectionListener dSIDataConnectionListener = (DSIDataConnectionListener)objectArray[i2];
                    dSIDataConnectionListener.asyncException(n, string, n2);
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
                    DSIDataConnectionListener dSIDataConnectionListener = (DSIDataConnectionListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIDataConnectionDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIDataConnectionDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIDataConnectionListener, new Object[]{string, string2});
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

