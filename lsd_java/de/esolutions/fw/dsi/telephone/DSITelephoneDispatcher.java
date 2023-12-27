/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.telephone;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.telephone.DSITelephoneReply;
import de.esolutions.fw.comm.dsi.telephone.impl.DSITelephoneReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.telephone.ActivationStateStruct;
import org.dsi.ifc.telephone.CFResponseData;
import org.dsi.ifc.telephone.CallDuration;
import org.dsi.ifc.telephone.CallInformation;
import org.dsi.ifc.telephone.DSITelephoneListener;
import org.dsi.ifc.telephone.DisconnectReason;
import org.dsi.ifc.telephone.EmergencyCallSetting;
import org.dsi.ifc.telephone.EmergencyNumbers;
import org.dsi.ifc.telephone.Favorite;
import org.dsi.ifc.telephone.LockStateStruct;
import org.dsi.ifc.telephone.MailboxDialingNumber;
import org.dsi.ifc.telephone.NADTemperatureStruct;
import org.dsi.ifc.telephone.NetworkProvider;
import org.dsi.ifc.telephone.NetworkProviderName;
import org.dsi.ifc.telephone.PhoneInformation;
import org.dsi.ifc.telephone.RegisterStateStruct;
import org.dsi.ifc.telephone.SIMAliasInformation;
import org.dsi.ifc.telephone.ServiceCodeTypeStruct;
import org.dsi.ifc.telephone.ServiceNumbers;
import org.dsi.ifc.telephone.ServiceProvider;
import org.dsi.ifc.telephone.SuppServiceResponseStruct;

public class DSITelephoneDispatcher
extends AbstractDispatcher
implements DSITelephoneReply {
    private DSITelephoneReplyService service = new DSITelephoneReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$telephone$DSITelephoneListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSITelephoneDispatcher(int n) {
        super(n, (class$org$dsi$ifc$telephone$DSITelephoneListener == null ? (class$org$dsi$ifc$telephone$DSITelephoneListener = DSITelephoneDispatcher.class$("org.dsi.ifc.telephone.DSITelephoneListener")) : class$org$dsi$ifc$telephone$DSITelephoneListener).getName());
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
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseAbortNetworkRegistration(n);
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
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseAbortNetworkSearch(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseAcceptCall(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseAcceptCall(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseCallForward(CFResponseData[] cFResponseDataArray, int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseCallForward(cFResponseDataArray, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseCallWaiting(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseCallWaiting(n, n2);
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
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseChangeSIMCode(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseCLIR(int n, int n2, int n3) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseCLIR(n, n2, n3);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseDialNumber(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseDialNumber(n, suppServiceResponseStruct);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseDialOperator(int n, SuppServiceResponseStruct suppServiceResponseStruct) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseDialOperator(n, suppServiceResponseStruct);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSendDTMF(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseSendDTMF(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDTMFTonePlaying(String string, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(1, dSITelephoneListener);
                    dSITelephoneListener.updateDTMFTonePlaying(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateDTMFTonePlaying(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateEmergencyNumbers(EmergencyNumbers emergencyNumbers, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(2, dSITelephoneListener);
                    dSITelephoneListener.updateEmergencyNumbers(emergencyNumbers, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateEmergencyNumbers(emergencyNumbers, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseRemoveOtherSIM(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseRemoveOtherSIM(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseAbortAlternatePhoneActivity(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseAbortAlternatePhoneActivity(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseTogglePrioritizedPhoneDevice(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseTogglePrioritizedPhoneDevice(n);
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
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseSIMPINRequired(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateOtherSIMAvailable(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(34);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(34, dSITelephoneListener);
                    dSITelephoneListener.updateOtherSIMAvailable(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(34);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateOtherSIMAvailable(bl, n);
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
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(3, dSITelephoneListener);
                    dSITelephoneListener.updateSIMPINRequired(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateSIMPINRequired(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseHangupCall(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseHangupCall(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseJoinCalls(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseJoinCalls(n);
                    continue;
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
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseNetworkRegistration(n);
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
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseNetworkSearch(networkProviderArray, n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseUnlockOtherSIM(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseUnlockOtherSIM(n);
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
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseUnlockSIM(n);
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
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseCheckSIMPINCode(n);
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
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseRestoreFactorySettings(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetHandsFreeMode(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseSetHandsFreeMode(n);
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
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseSetAutomaticPinEntryActive(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetAutomaticRedialActive(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseSetAutomaticRedialActive(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseServiceCodeAbort(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseServiceCodeAbort(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSplitCall(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseSplitCall(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSwapCalls(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseSwapCalls(n);
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
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseTelPower(n);
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
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(4, dSITelephoneListener);
                    dSITelephoneListener.updateActivationState(activationStateStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateActivationState(activationStateStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateActivationStateAssociated(ActivationStateStruct activationStateStruct, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(38);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(38, dSITelephoneListener);
                    dSITelephoneListener.updateActivationStateAssociated(activationStateStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(38);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateActivationStateAssociated(activationStateStruct, n);
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
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(5, dSITelephoneListener);
                    dSITelephoneListener.updateAutomaticPinEntryActive(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateAutomaticPinEntryActive(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAutomaticRedialActive(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(6, dSITelephoneListener);
                    dSITelephoneListener.updateAutomaticRedialActive(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateAutomaticRedialActive(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateBatteryChargeLevel(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(7, dSITelephoneListener);
                    dSITelephoneListener.updateBatteryChargeLevel(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateBatteryChargeLevel(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCallDurationList(CallDuration[] callDurationArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(8, dSITelephoneListener);
                    dSITelephoneListener.updateCallDurationList(callDurationArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateCallDurationList(callDurationArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCallList(CallInformation[] callInformationArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(9, dSITelephoneListener);
                    dSITelephoneListener.updateCallList(callInformationArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateCallList(callInformationArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCDMAThreeWayCallingSetting(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(10, dSITelephoneListener);
                    dSITelephoneListener.updateCDMAThreeWayCallingSetting(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateCDMAThreeWayCallingSetting(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCradlePlugInState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(11, dSITelephoneListener);
                    dSITelephoneListener.updateCradlePlugInState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateCradlePlugInState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateDisconnectReason(DisconnectReason disconnectReason, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(12, dSITelephoneListener);
                    dSITelephoneListener.updateDisconnectReason(disconnectReason, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateDisconnectReason(disconnectReason, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateEmergencyCallActive(EmergencyCallSetting emergencyCallSetting, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(13, dSITelephoneListener);
                    dSITelephoneListener.updateEmergencyCallActive(emergencyCallSetting, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateEmergencyCallActive(emergencyCallSetting, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateEnhancedPrivacyMode(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(14, dSITelephoneListener);
                    dSITelephoneListener.updateEnhancedPrivacyMode(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateEnhancedPrivacyMode(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateHandsFreeMode(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(15, dSITelephoneListener);
                    dSITelephoneListener.updateHandsFreeMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateHandsFreeMode(n, n2);
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
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(16, dSITelephoneListener);
                    dSITelephoneListener.updateLockState(lockStateStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateLockState(lockStateStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMailboxContent(MailboxDialingNumber[] mailboxDialingNumberArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(17, dSITelephoneListener);
                    dSITelephoneListener.updateMailboxContent(mailboxDialingNumberArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateMailboxContent(mailboxDialingNumberArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMICMuteState(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(18, dSITelephoneListener);
                    dSITelephoneListener.updateMICMuteState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateMICMuteState(n, n2);
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
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(19, dSITelephoneListener);
                    dSITelephoneListener.updateNADTemperature(nADTemperatureStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateNADTemperature(nADTemperatureStruct, n);
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
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(20, dSITelephoneListener);
                    dSITelephoneListener.updatePhoneInformation(phoneInformation, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updatePhoneInformation(phoneInformation, n);
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
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(21, dSITelephoneListener);
                    dSITelephoneListener.updateNetworkProvider(networkProviderName, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateNetworkProvider(networkProviderName, n);
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
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(22, dSITelephoneListener);
                    dSITelephoneListener.updateNetworkType(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateNetworkType(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePrivacyMode(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(23, dSITelephoneListener);
                    dSITelephoneListener.updatePrivacyMode(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updatePrivacyMode(bl, n);
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
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(24, dSITelephoneListener);
                    dSITelephoneListener.updateRegisterState(registerStateStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateRegisterState(registerStateStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateServiceCodeType(ServiceCodeTypeStruct serviceCodeTypeStruct, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(25, dSITelephoneListener);
                    dSITelephoneListener.updateServiceCodeType(serviceCodeTypeStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateServiceCodeType(serviceCodeTypeStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateServiceNumbers(ServiceNumbers serviceNumbers, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(26, dSITelephoneListener);
                    dSITelephoneListener.updateServiceNumbers(serviceNumbers, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateServiceNumbers(serviceNumbers, n);
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
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(27, dSITelephoneListener);
                    dSITelephoneListener.updateSignalQuality(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateSignalQuality(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSuppServiceResponse(SuppServiceResponseStruct suppServiceResponseStruct, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(28, dSITelephoneListener);
                    dSITelephoneListener.updateSuppServiceResponse(suppServiceResponseStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateSuppServiceResponse(suppServiceResponseStruct, n);
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
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(29, dSITelephoneListener);
                    dSITelephoneListener.updateServiceProvider(serviceProvider, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(29);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateServiceProvider(serviceProvider, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateNADMode(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(33);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(33, dSITelephoneListener);
                    dSITelephoneListener.updateNADMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(33);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateNADMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateAlternatePhoneActivity(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(35);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(35, dSITelephoneListener);
                    dSITelephoneListener.updateAlternatePhoneActivity(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(35);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateAlternatePhoneActivity(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetCDMAThreeWayCallingSetting(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseSetCDMAThreeWayCallingSetting(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetAutomaticEmergencyCallActive(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseSetAutomaticEmergencyCallActive(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetMailboxContent(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseSetMailboxContent(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetPrivacyMode(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseSetPrivacyMode(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetSIMAliases(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseSetSIMAliases(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetMICMuteState(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseSetMICMuteState(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetOptimizationMode(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseSetOptimizationMode(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetNADMode(int n, int n2) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseSetNADMode(n, n2);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMicGainLevel(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(31, dSITelephoneListener);
                    dSITelephoneListener.updateMicGainLevel(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateMicGainLevel(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSIMAliasInformation(SIMAliasInformation sIMAliasInformation, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(30, dSITelephoneListener);
                    dSITelephoneListener.updateSIMAliasInformation(sIMAliasInformation, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateSIMAliasInformation(sIMAliasInformation, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateOptimizationMode(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(32, dSITelephoneListener);
                    dSITelephoneListener.updateOptimizationMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateOptimizationMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetPhoneReminderSetting(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseSetPhoneReminderSetting(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetPrefixActivated(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseSetPrefixActivated(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetPrefixContent(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseSetPrefixContent(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePhoneReminderSetting(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(37);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(37, dSITelephoneListener);
                    dSITelephoneListener.updatePhoneReminderSetting(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(37);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updatePhoneReminderSetting(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePrefixActivated(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(39);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(39, dSITelephoneListener);
                    dSITelephoneListener.updatePrefixActivated(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(39);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updatePrefixActivated(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePrefixContent(String string, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(36);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(36, dSITelephoneListener);
                    dSITelephoneListener.updatePrefixContent(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(36);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updatePrefixContent(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateWidebandSpeech(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(40);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(40, dSITelephoneListener);
                    dSITelephoneListener.updateWidebandSpeech(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(40);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateWidebandSpeech(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetPhoneRingtone(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseSetPhoneRingtone(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updatePhoneRingtone(int n, String string, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(41);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(41, dSITelephoneListener);
                    dSITelephoneListener.updatePhoneRingtone(n, string, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(41);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updatePhoneRingtone(n, string, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetFavorites(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseSetFavorites(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateFavorites(Favorite[] favoriteArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(42);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(42, dSITelephoneListener);
                    dSITelephoneListener.updateFavorites(favoriteArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(42);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateFavorites(favoriteArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSAPUpgradeActive(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(43);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(43, dSITelephoneListener);
                    dSITelephoneListener.updateSAPUpgradeActive(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(43);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateSAPUpgradeActive(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetSIMName(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseSetSIMName(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseSetESIMActive(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.responseSetESIMActive(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateEUICCID(String string, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(44);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(44, dSITelephoneListener);
                    dSITelephoneListener.updateEUICCID(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(44);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateEUICCID(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateESIMMSISDN(String string, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(45);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(45, dSITelephoneListener);
                    dSITelephoneListener.updateESIMMSISDN(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(45);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateESIMMSISDN(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateESimActive(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(46);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(46, dSITelephoneListener);
                    dSITelephoneListener.updateESimActive(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(46);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateESimActive(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateESimB2BMode(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(47);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    this.confirmNotificationListener(47, dSITelephoneListener);
                    dSITelephoneListener.updateESimB2BMode(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(47);
            while (iterator.hasNext()) {
                try {
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)iterator.next();
                    dSITelephoneListener.updateESimB2BMode(bl, n);
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
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    dSITelephoneListener.asyncException(n, string, n2);
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
                    DSITelephoneListener dSITelephoneListener = (DSITelephoneListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSITelephoneDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSITelephoneDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSITelephoneListener, new Object[]{string, string2});
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

