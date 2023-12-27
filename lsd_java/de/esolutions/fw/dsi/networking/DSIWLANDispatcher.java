/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.networking;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.networking.DSIWLANReply;
import de.esolutions.fw.comm.dsi.networking.impl.DSIWLANReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.networking.DSIWLANListener;
import org.dsi.ifc.networking.DiscoveredNetwork;
import org.dsi.ifc.networking.Node;
import org.dsi.ifc.networking.Profile;

public class DSIWLANDispatcher
extends AbstractDispatcher
implements DSIWLANReply {
    private DSIWLANReplyService service = new DSIWLANReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$networking$DSIWLANListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIWLANDispatcher(int n) {
        super(n, (class$org$dsi$ifc$networking$DSIWLANListener == null ? (class$org$dsi$ifc$networking$DSIWLANListener = DSIWLANDispatcher.class$("org.dsi.ifc.networking.DSIWLANListener")) : class$org$dsi$ifc$networking$DSIWLANListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void updateRole(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)iterator.next();
                    this.confirmNotificationListener(1, dSIWLANListener);
                    dSIWLANListener.updateRole(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)iterator.next();
                    dSIWLANListener.updateRole(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRFActive(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)iterator.next();
                    this.confirmNotificationListener(12, dSIWLANListener);
                    dSIWLANListener.updateRFActive(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)iterator.next();
                    dSIWLANListener.updateRFActive(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNodeList(Node[] nodeArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)iterator.next();
                    this.confirmNotificationListener(13, dSIWLANListener);
                    dSIWLANListener.updateNodeList(nodeArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)iterator.next();
                    dSIWLANListener.updateNodeList(nodeArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateProfile(Profile profile, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)iterator.next();
                    this.confirmNotificationListener(22, dSIWLANListener);
                    dSIWLANListener.updateProfile(profile, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)iterator.next();
                    dSIWLANListener.updateProfile(profile, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateWlanEnabled(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)iterator.next();
                    this.confirmNotificationListener(17, dSIWLANListener);
                    dSIWLANListener.updateWlanEnabled(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)iterator.next();
                    dSIWLANListener.updateWlanEnabled(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateStartupState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)iterator.next();
                    this.confirmNotificationListener(18, dSIWLANListener);
                    dSIWLANListener.updateStartupState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)iterator.next();
                    dSIWLANListener.updateStartupState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateTrustedNetworks(String[] stringArray, String[] stringArray2, int[] nArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)iterator.next();
                    this.confirmNotificationListener(21, dSIWLANListener);
                    dSIWLANListener.updateTrustedNetworks(stringArray, stringArray2, nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)iterator.next();
                    dSIWLANListener.updateTrustedNetworks(stringArray, stringArray2, nArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDiscoveredNetwork(DiscoveredNetwork discoveredNetwork, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)iterator.next();
                    this.confirmNotificationListener(19, dSIWLANListener);
                    dSIWLANListener.updateDiscoveredNetwork(discoveredNetwork, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)iterator.next();
                    dSIWLANListener.updateDiscoveredNetwork(discoveredNetwork, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateConnectedNetwork(String string, String string2, int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)iterator.next();
                    this.confirmNotificationListener(20, dSIWLANListener);
                    dSIWLANListener.updateConnectedNetwork(string, string2, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)iterator.next();
                    dSIWLANListener.updateConnectedNetwork(string, string2, n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseFactoryReset(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)objectArray[i2];
                    dSIWLANListener.responseFactoryReset(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetRole(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)objectArray[i2];
                    dSIWLANListener.responseSetRole(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetRFActive(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)objectArray[i2];
                    dSIWLANListener.responseSetRFActive(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetProfile(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)objectArray[i2];
                    dSIWLANListener.responseSetProfile(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseNetworkSearch(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)objectArray[i2];
                    dSIWLANListener.responseNetworkSearch(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseAbortSearch(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)objectArray[i2];
                    dSIWLANListener.responseAbortSearch(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseConnectNetwork(String string, String string2, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)objectArray[i2];
                    dSIWLANListener.responseConnectNetwork(string, string2, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseDisconnectNetwork(String string, String string2, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)objectArray[i2];
                    dSIWLANListener.responseDisconnectNetwork(string, string2, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseDeleteTrustedNetwork(String string, String string2, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)objectArray[i2];
                    dSIWLANListener.responseDeleteTrustedNetwork(string, string2, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseActivateWps(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)objectArray[i2];
                    dSIWLANListener.responseActivateWps(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateWPSRunning(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)iterator.next();
                    this.confirmNotificationListener(23, dSIWLANListener);
                    dSIWLANListener.updateWPSRunning(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)iterator.next();
                    dSIWLANListener.updateWPSRunning(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateWPSStoppedAndConnecting(String string, String string2, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)iterator.next();
                    this.confirmNotificationListener(24, dSIWLANListener);
                    dSIWLANListener.updateWPSStoppedAndConnecting(string, string2, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)iterator.next();
                    dSIWLANListener.updateWPSStoppedAndConnecting(string, string2, n);
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
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)objectArray[i2];
                    dSIWLANListener.asyncException(n, string, n2);
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
                    DSIWLANListener dSIWLANListener = (DSIWLANListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIWLANDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIWLANDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIWLANListener, new Object[]{string, string2});
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

