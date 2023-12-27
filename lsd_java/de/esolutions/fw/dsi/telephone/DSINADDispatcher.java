/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.telephone;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.telephone.DSINADReply;
import de.esolutions.fw.comm.dsi.telephone.impl.DSINADReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.telephone.ActivationStateStruct;
import org.dsi.ifc.telephone.DSINADListener;
import org.dsi.ifc.telephone.LockStateStruct;
import org.dsi.ifc.telephone.NADTemperatureStruct;
import org.dsi.ifc.telephone.NetworkProvider;
import org.dsi.ifc.telephone.NetworkProviderName;
import org.dsi.ifc.telephone.PhoneInformation;
import org.dsi.ifc.telephone.RegisterStateStruct;
import org.dsi.ifc.telephone.ServiceProvider;

public class DSINADDispatcher
extends AbstractDispatcher
implements DSINADReply {
    private DSINADReplyService service = new DSINADReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$telephone$DSINADListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSINADDispatcher(int n) {
        super(n, (class$org$dsi$ifc$telephone$DSINADListener == null ? (class$org$dsi$ifc$telephone$DSINADListener = DSINADDispatcher.class$("org.dsi.ifc.telephone.DSINADListener")) : class$org$dsi$ifc$telephone$DSINADListener).getName());
    }

    @Override
    public IReplyService getService() {
        return this.service;
    }

    @Override
    public void responseAbortNetworkRegistration(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)objectArray[i2];
                    dSINADListener.responseAbortNetworkRegistration(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseAbortNetworkSearch(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)objectArray[i2];
                    dSINADListener.responseAbortNetworkSearch(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseChangeSIMCode(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)objectArray[i2];
                    dSINADListener.responseChangeSIMCode(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSIMPINRequired(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)objectArray[i2];
                    dSINADListener.responseSIMPINRequired(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSIMPINRequired(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)iterator.next();
                    this.confirmNotificationListener(3, dSINADListener);
                    dSINADListener.updateSIMPINRequired(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)iterator.next();
                    dSINADListener.updateSIMPINRequired(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseNetworkRegistration(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)objectArray[i2];
                    dSINADListener.responseNetworkRegistration(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseNetworkSearch(NetworkProvider[] networkProviderArray, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)objectArray[i2];
                    dSINADListener.responseNetworkSearch(networkProviderArray, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseUnlockSIM(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)objectArray[i2];
                    dSINADListener.responseUnlockSIM(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseCheckSIMPINCode(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)objectArray[i2];
                    dSINADListener.responseCheckSIMPINCode(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseRestoreFactorySettings(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)objectArray[i2];
                    dSINADListener.responseRestoreFactorySettings(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseTelPower(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)objectArray[i2];
                    dSINADListener.responseTelPower(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetAutomaticPinEntryActive(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)objectArray[i2];
                    dSINADListener.responseSetAutomaticPinEntryActive(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateActivationState(ActivationStateStruct activationStateStruct, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)iterator.next();
                    this.confirmNotificationListener(4, dSINADListener);
                    dSINADListener.updateActivationState(activationStateStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)iterator.next();
                    dSINADListener.updateActivationState(activationStateStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAutomaticPinEntryActive(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)iterator.next();
                    this.confirmNotificationListener(5, dSINADListener);
                    dSINADListener.updateAutomaticPinEntryActive(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)iterator.next();
                    dSINADListener.updateAutomaticPinEntryActive(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateLockState(LockStateStruct lockStateStruct, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)iterator.next();
                    this.confirmNotificationListener(16, dSINADListener);
                    dSINADListener.updateLockState(lockStateStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)iterator.next();
                    dSINADListener.updateLockState(lockStateStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNADTemperature(NADTemperatureStruct nADTemperatureStruct, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)iterator.next();
                    this.confirmNotificationListener(19, dSINADListener);
                    dSINADListener.updateNADTemperature(nADTemperatureStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)iterator.next();
                    dSINADListener.updateNADTemperature(nADTemperatureStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePhoneInformation(PhoneInformation phoneInformation, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)iterator.next();
                    this.confirmNotificationListener(20, dSINADListener);
                    dSINADListener.updatePhoneInformation(phoneInformation, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)iterator.next();
                    dSINADListener.updatePhoneInformation(phoneInformation, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNetworkProvider(NetworkProviderName networkProviderName, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)iterator.next();
                    this.confirmNotificationListener(21, dSINADListener);
                    dSINADListener.updateNetworkProvider(networkProviderName, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)iterator.next();
                    dSINADListener.updateNetworkProvider(networkProviderName, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNetworkType(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)iterator.next();
                    this.confirmNotificationListener(22, dSINADListener);
                    dSINADListener.updateNetworkType(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)iterator.next();
                    dSINADListener.updateNetworkType(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateRegisterState(RegisterStateStruct registerStateStruct, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)iterator.next();
                    this.confirmNotificationListener(24, dSINADListener);
                    dSINADListener.updateRegisterState(registerStateStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)iterator.next();
                    dSINADListener.updateRegisterState(registerStateStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSignalQuality(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)iterator.next();
                    this.confirmNotificationListener(27, dSINADListener);
                    dSINADListener.updateSignalQuality(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)iterator.next();
                    dSINADListener.updateSignalQuality(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateServiceProvider(ServiceProvider serviceProvider, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(29);
            while (iterator.hasNext()) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)iterator.next();
                    this.confirmNotificationListener(29, dSINADListener);
                    dSINADListener.updateServiceProvider(serviceProvider, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(29);
            while (iterator.hasNext()) {
                try {
                    DSINADListener dSINADListener = (DSINADListener)iterator.next();
                    dSINADListener.updateServiceProvider(serviceProvider, n);
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
                    DSINADListener dSINADListener = (DSINADListener)objectArray[i2];
                    dSINADListener.asyncException(n, string, n2);
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
                    DSINADListener dSINADListener = (DSINADListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSINADDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSINADDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSINADListener, new Object[]{string, string2});
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

