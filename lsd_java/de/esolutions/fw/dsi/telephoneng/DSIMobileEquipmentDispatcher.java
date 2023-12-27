/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.telephoneng;

import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.dsi.telephoneng.DSIMobileEquipmentReply;
import de.esolutions.fw.comm.dsi.telephoneng.impl.DSIMobileEquipmentReplyService;
import de.esolutions.fw.dsi.base.AbstractDispatcher;
import java.lang.reflect.Method;
import java.util.Iterator;
import org.dsi.ifc.telephoneng.ActivationStateStruct;
import org.dsi.ifc.telephoneng.CFResponseData;
import org.dsi.ifc.telephoneng.CallDuration;
import org.dsi.ifc.telephoneng.CallInformation;
import org.dsi.ifc.telephoneng.CallStackEntry;
import org.dsi.ifc.telephoneng.DSIMobileEquipmentListener;
import org.dsi.ifc.telephoneng.DisconnectReason;
import org.dsi.ifc.telephoneng.EmergencyCallSetting;
import org.dsi.ifc.telephoneng.EmergencyNumbers;
import org.dsi.ifc.telephoneng.Favorite;
import org.dsi.ifc.telephoneng.LockStateStruct;
import org.dsi.ifc.telephoneng.MailboxDialingNumber;
import org.dsi.ifc.telephoneng.MissedCallIndicator;
import org.dsi.ifc.telephoneng.NADTemperatureStruct;
import org.dsi.ifc.telephoneng.NetworkProvider;
import org.dsi.ifc.telephoneng.NetworkProviderName;
import org.dsi.ifc.telephoneng.PhoneInformation;
import org.dsi.ifc.telephoneng.RegisterStateStruct;
import org.dsi.ifc.telephoneng.SIMAliasInformation;
import org.dsi.ifc.telephoneng.ServiceCodeTypeStruct;
import org.dsi.ifc.telephoneng.ServiceNumbers;
import org.dsi.ifc.telephoneng.ServiceProvider;
import org.dsi.ifc.telephoneng.SuppServiceResponseStruct;

public class DSIMobileEquipmentDispatcher
extends AbstractDispatcher
implements DSIMobileEquipmentReply {
    private DSIMobileEquipmentReplyService service = new DSIMobileEquipmentReplyService(this);
    static /* synthetic */ Class class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener;
    static /* synthetic */ Class class$java$lang$String;

    public DSIMobileEquipmentDispatcher(int n) {
        super(n, (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener == null ? (class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener = DSIMobileEquipmentDispatcher.class$("org.dsi.ifc.telephoneng.DSIMobileEquipmentListener")) : class$org$dsi$ifc$telephoneng$DSIMobileEquipmentListener).getName());
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseAbortNetworkRegistration(n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseAbortNetworkSearch(n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseAcceptCall(n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseCallForward(cFResponseDataArray, n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseCallWaiting(n, n2);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseChangeSIMCode(n, n2);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseCLIR(n, n2, n3);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseDialNumber(n, suppServiceResponseStruct);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseDialOperator(n, suppServiceResponseStruct);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseSendDTMF(n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(1, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateDTMFTonePlaying(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(1);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateDTMFTonePlaying(string, n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(2, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateEmergencyNumbers(emergencyNumbers, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(2);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateEmergencyNumbers(emergencyNumbers, n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseRemoveOtherSIM(n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseSIMPINRequired(n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(34, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateOtherSIMAvailable(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(34);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateOtherSIMAvailable(bl, n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(3, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateSIMPINRequired(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(3);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateSIMPINRequired(bl, n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseHangupCall(n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseJoinCalls(n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseNetworkRegistration(n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseNetworkSearch(networkProviderArray, n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseUnlockOtherSIM(n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseUnlockSIM(n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseCheckSIMPINCode(n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseRestoreFactorySettings(n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseSetHandsFreeMode(n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseSetAutomaticPinEntryActive(n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseSetAutomaticRedialActive(n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseServiceCodeAbort(n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseSplitCall(n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseSwapCalls(n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseTelPower(n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(4, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateActivationState(activationStateStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(4);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateActivationState(activationStateStruct, n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(5, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateAutomaticPinEntryActive(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(5);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateAutomaticPinEntryActive(bl, n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(6, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateAutomaticRedialActive(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(6);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateAutomaticRedialActive(bl, n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(7, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateBatteryChargeLevel(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(7);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateBatteryChargeLevel(n, n2);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(8, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateCallDurationList(callDurationArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(8);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateCallDurationList(callDurationArray, n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(9, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateCallList(callInformationArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(9);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateCallList(callInformationArray, n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(10, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateCDMAThreeWayCallingSetting(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(10);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateCDMAThreeWayCallingSetting(bl, n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(11, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateCradlePlugInState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(11);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateCradlePlugInState(n, n2);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(12, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateDisconnectReason(disconnectReason, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(12);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateDisconnectReason(disconnectReason, n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(13, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateEmergencyCallActive(emergencyCallSetting, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(13);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateEmergencyCallActive(emergencyCallSetting, n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(14, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateEnhancedPrivacyMode(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(14);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateEnhancedPrivacyMode(bl, n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(15, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateHandsFreeMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(15);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateHandsFreeMode(n, n2);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(16, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateLockState(lockStateStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(16);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateLockState(lockStateStruct, n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(17, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateMailboxContent(mailboxDialingNumberArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(17);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateMailboxContent(mailboxDialingNumberArray, n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(18, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateMICMuteState(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(18);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateMICMuteState(n, n2);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(19, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateNADTemperature(nADTemperatureStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(19);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateNADTemperature(nADTemperatureStruct, n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(20, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updatePhoneInformation(phoneInformation, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(20);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updatePhoneInformation(phoneInformation, n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(21, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateNetworkProvider(networkProviderName, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(21);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateNetworkProvider(networkProviderName, n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(22, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateNetworkType(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(22);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateNetworkType(n, n2);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(23, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updatePrivacyMode(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(23);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updatePrivacyMode(bl, n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(24, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateRegisterState(registerStateStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(24);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateRegisterState(registerStateStruct, n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(25, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateServiceCodeType(serviceCodeTypeStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(25);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateServiceCodeType(serviceCodeTypeStruct, n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(26, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateServiceNumbers(serviceNumbers, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(26);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateServiceNumbers(serviceNumbers, n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(27, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateSignalQuality(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(27);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateSignalQuality(n, n2);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(28, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateSuppServiceResponse(suppServiceResponseStruct, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(28);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateSuppServiceResponse(suppServiceResponseStruct, n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(29, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateServiceProvider(serviceProvider, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(29);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateServiceProvider(serviceProvider, n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(33, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateNADMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(33);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateNADMode(n, n2);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseSetCDMAThreeWayCallingSetting(n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseSetAutomaticEmergencyCallActive(n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseSetMailboxContent(n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseSetPrivacyMode(n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseSetSIMAliases(n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseSetMICMuteState(n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseSetOptimizationMode(n, n2);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseSetNADMode(n, n2);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(31, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateMicGainLevel(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(31);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateMicGainLevel(n, n2);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(30, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateSIMAliasInformation(sIMAliasInformation, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(30);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateSIMAliasInformation(sIMAliasInformation, n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(32, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateOptimizationMode(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(32);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateOptimizationMode(n, n2);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseSetPhoneReminderSetting(n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseSetPrefixActivated(n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseSetPrefixContent(n);
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
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(36);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(36, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updatePhoneReminderSetting(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(36);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updatePhoneReminderSetting(bl, n);
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
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(37);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(37, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updatePrefixActivated(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(37);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updatePrefixActivated(bl, n);
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
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(35);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(35, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updatePrefixContent(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(35);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updatePrefixContent(string, n);
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
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(38);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(38, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateWidebandSpeech(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(38);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateWidebandSpeech(bl, n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseSetPhoneRingtone(n);
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
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(39);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(39, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updatePhoneRingtone(n, string, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(39);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updatePhoneRingtone(n, string, n2);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseSetFavorites(n);
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
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(40);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(40, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateFavorites(favoriteArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(40);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateFavorites(favoriteArray, n);
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
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(41);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(41, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateSAPUpgradeActive(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(41);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateSAPUpgradeActive(bl, n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseSetSIMName(n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseSetESIMActive(n);
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
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(42);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(42, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateEUICCID(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(42);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateEUICCID(string, n);
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
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(43);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(43, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateESIMMSISDN(string, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(43);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateESIMMSISDN(string, n);
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
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(44);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(44, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateESimActive(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(44);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateESimActive(bl, n);
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
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(45);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(45, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateESimB2BMode(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(45);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateESimB2BMode(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateCallstacksIsReverted(boolean bl, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(46);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(46, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateCallstacksIsReverted(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(46);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateCallstacksIsReverted(bl, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateLastAnsweredNumbers(CallStackEntry[] callStackEntryArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(47);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(47, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateLastAnsweredNumbers(callStackEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(47);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateLastAnsweredNumbers(callStackEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateLastDialedNumbers(CallStackEntry[] callStackEntryArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(48);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(48, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateLastDialedNumbers(callStackEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(48);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateLastDialedNumbers(callStackEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMissedNumbers(CallStackEntry[] callStackEntryArray, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(49);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(49, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateMissedNumbers(callStackEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(49);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateMissedNumbers(callStackEntryArray, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMEDataValidity(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(50);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(50, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateMEDataValidity(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(50);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateMEDataValidity(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateMissedCallIndicator(MissedCallIndicator missedCallIndicator, int n) {
        if ((n & 0x80) == 128) {
            n ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(51);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(51, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateMissedCallIndicator(missedCallIndicator, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(51);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateMissedCallIndicator(missedCallIndicator, n);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSpeechRecognitionAvailable(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(52);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(52, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateSpeechRecognitionAvailable(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(52);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateSpeechRecognitionAvailable(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSpeechRecognitionActive(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(53);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(53, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateSpeechRecognitionActive(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(53);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateSpeechRecognitionActive(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void updateSpeechRecognitionType(int n, int n2) {
        if ((n2 & 0x80) == 128) {
            n2 ^= 0x80;
            Iterator iterator = this.getUnconfirmedNotificationListenerIterator(54);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    this.confirmNotificationListener(54, dSIMobileEquipmentListener);
                    dSIMobileEquipmentListener.updateSpeechRecognitionType(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        } else {
            Iterator iterator = this.getNotificationListenerIterator(54);
            while (iterator.hasNext()) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)iterator.next();
                    dSIMobileEquipmentListener.updateSpeechRecognitionType(n, n2);
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseStartSpeechRecognition(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseStartSpeechRecognition(n);
                    continue;
                }
                catch (Exception exception) {
                    this.traceException(exception);
                }
            }
        }
    }

    @Override
    public void responseStopSpeechRecognition(int n) {
        Object[] objectArray = this.getResponseListenerList();
        if (objectArray != null) {
            for (int i2 = 0; i2 < objectArray.length; ++i2) {
                try {
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.responseStopSpeechRecognition(n);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    dSIMobileEquipmentListener.asyncException(n, string, n2);
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
                    DSIMobileEquipmentListener dSIMobileEquipmentListener = (DSIMobileEquipmentListener)objectArray[i2];
                    Method method = super.getClass().getMethod("yyIndication", new Class[]{class$java$lang$String == null ? DSIMobileEquipmentDispatcher.class$("java.lang.String") : class$java$lang$String, class$java$lang$String == null ? DSIMobileEquipmentDispatcher.class$("java.lang.String") : class$java$lang$String});
                    method.invoke(dSIMobileEquipmentListener, new Object[]{string, string2});
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

