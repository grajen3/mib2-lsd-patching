/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.ecall.functions;

import de.vw.mib.asl.internal.ocu.ecall.api.asl.AudioManagementService;
import de.vw.mib.asl.internal.ocu.ecall.api.asl.AudioManagementServiceListener;
import de.vw.mib.asl.internal.ocu.ecall.api.asl.CarPlayService;
import de.vw.mib.asl.internal.ocu.ecall.api.asl.PhoneService;
import de.vw.mib.asl.internal.ocu.ecall.api.asl.PhoneServiceListener;
import de.vw.mib.asl.internal.ocu.ecall.api.asl.SmartphoneIntegrationService;
import de.vw.mib.asl.internal.ocu.ecall.api.model.ModelPhoneOcuCallListener;
import de.vw.mib.asl.internal.ocu.ecall.functions.ECallFunction;
import de.vw.mib.asl.internal.ocu.ecall.functions.PhoneDisconnectHandler;
import de.vw.mib.asl.internal.ocu.ecall.functions.SupportedServices;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.CallState_Ack;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.CallState_Status;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.CallState_StatusAck;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;

public final class CallState
extends ECallFunction
implements PropertyListener,
PhoneServiceListener,
AudioManagementServiceListener {
    private static final int[] OCU_CALL_TYPES_ACN = new int[]{8};
    private static final int[] OCU_CALL_TYPES_CALLS = new int[]{6, 7, 1, 9, 4};
    private static final int INVALID_CALL_TYPE;
    private int _ocuAudioConnectionType;
    private static final int OCU_AUDIO_CONNECTION_TYPE_NONE;
    private static final int OCU_AUDIO_CONNECTION_TYPE_CALL;
    private static final int OCU_AUDIO_CONNECTION_TYPE_EMERGENCY;
    private boolean _audioManagementUnAvailable;
    private boolean _lastAudioRequestSinceAmNotAvailable;
    private boolean _ocuAcnCallActive;
    private int _ocuCallActiveType;
    private int _modelOcuCallType;
    private int _modelOcuCallState;
    private int[] _callStates = new int[0];
    private boolean _hangupAllowed;
    private boolean _eCallManual112Present;
    private PhoneDisconnectHandler _phoneDisconnectHandler;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$asl$PhoneService;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$asl$AudioManagementService;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$asl$SmartphoneIntegrationService;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$asl$CarPlayService;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneOcuCallListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$asl$PhoneServiceListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$asl$AudioManagementServiceListener;

    private PhoneDisconnectHandler getPhoneDisconnectHandler() {
        if (this._phoneDisconnectHandler == null) {
            this._phoneDisconnectHandler = new PhoneDisconnectHandler(this.getLogger());
        }
        return this._phoneDisconnectHandler;
    }

    private PhoneService getPhoneService() {
        return (PhoneService)this.getDelegate().getService(class$de$vw$mib$asl$internal$ocu$ecall$api$asl$PhoneService == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$asl$PhoneService = CallState.class$("de.vw.mib.asl.internal.ocu.ecall.api.asl.PhoneService")) : class$de$vw$mib$asl$internal$ocu$ecall$api$asl$PhoneService);
    }

    private AudioManagementService getAudioManagementService() {
        return (AudioManagementService)this.getDelegate().getService(class$de$vw$mib$asl$internal$ocu$ecall$api$asl$AudioManagementService == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$asl$AudioManagementService = CallState.class$("de.vw.mib.asl.internal.ocu.ecall.api.asl.AudioManagementService")) : class$de$vw$mib$asl$internal$ocu$ecall$api$asl$AudioManagementService);
    }

    private SmartphoneIntegrationService getSmartphoneIntegrationService() {
        return (SmartphoneIntegrationService)this.getDelegate().getService(class$de$vw$mib$asl$internal$ocu$ecall$api$asl$SmartphoneIntegrationService == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$asl$SmartphoneIntegrationService = CallState.class$("de.vw.mib.asl.internal.ocu.ecall.api.asl.SmartphoneIntegrationService")) : class$de$vw$mib$asl$internal$ocu$ecall$api$asl$SmartphoneIntegrationService);
    }

    private CarPlayService getCarPlayService() {
        return (CarPlayService)this.getDelegate().getService(class$de$vw$mib$asl$internal$ocu$ecall$api$asl$CarPlayService == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$asl$CarPlayService = CallState.class$("de.vw.mib.asl.internal.ocu.ecall.api.asl.CarPlayService")) : class$de$vw$mib$asl$internal$ocu$ecall$api$asl$CarPlayService);
    }

    private ModelPhoneOcuCallListener getModelPhoneOcuCallListener() {
        return (ModelPhoneOcuCallListener)this.getDelegate().getService(class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneOcuCallListener == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneOcuCallListener = CallState.class$("de.vw.mib.asl.internal.ocu.ecall.api.model.ModelPhoneOcuCallListener")) : class$de$vw$mib$asl$internal$ocu$ecall$api$model$ModelPhoneOcuCallListener);
    }

    private void setAudioManagementUnAvailable(boolean bl) {
        if (this._audioManagementUnAvailable != bl) {
            this._audioManagementUnAvailable = bl;
            if (bl) {
                this.setOcuAudioConnectionType(0);
                this._updateModelOcuPopupState();
            } else if (this.isLastAudioRequestSinceAmNotAvailable()) {
                this._activateOrDeactivateOcuAcnCall(this.isOcuAcnCallActive());
                this._requestOcuCallActiveType(this.getOcuCallActiveType());
            }
        }
    }

    private boolean isAudioManagementUnvailable() {
        return this._audioManagementUnAvailable;
    }

    private boolean isLastAudioRequestSinceAmNotAvailable() {
        return this._lastAudioRequestSinceAmNotAvailable;
    }

    private void setLastAudioRequestSinceAmNotAvailable(boolean bl) {
        this._lastAudioRequestSinceAmNotAvailable = bl;
    }

    private int getOcuAudioConnectionType() {
        return this._ocuAudioConnectionType;
    }

    private void setOcuAudioConnectionType(int n) {
        this._ocuAudioConnectionType = n;
    }

    private void _updateOcuAcnCallActive(boolean bl) {
        if (this.isOcuAcnCallActive() != bl) {
            this._setOcuAcnCallActive(bl);
            this._activateOrDeactivateOcuAcnCall(bl);
        }
    }

    private void _setOcuAcnCallActive(boolean bl) {
        if (this._ocuAcnCallActive != bl) {
            this._ocuAcnCallActive = bl;
        }
    }

    boolean isOcuAcnCallActive() {
        return this._ocuAcnCallActive;
    }

    private void _setOcuCallActiveType(int n) {
        if (this._ocuCallActiveType != n) {
            this._ocuCallActiveType = n;
        }
    }

    private int getOcuCallActiveType() {
        return this._ocuCallActiveType;
    }

    private void _requestOcuCallActiveType(int n) {
        if (!this.isAudioManagementUnvailable()) {
            boolean bl;
            boolean bl2 = bl = this.getOcuAudioConnectionType() != 1 && n != -1 || this.getOcuAudioConnectionType() == 1 && n == -1;
            if (bl) {
                boolean bl3 = n != -1;
                this._activateOrDeactivateOcuCall(bl3);
            } else {
                this._updateModelOcuPopupState();
            }
            this.setLastAudioRequestSinceAmNotAvailable(false);
        } else {
            this.setLastAudioRequestSinceAmNotAvailable(true);
        }
    }

    private void _updateOcuCallActiveType(int n) {
        if (this.getOcuCallActiveType() != n) {
            this._setOcuCallActiveType(n);
            this._requestOcuCallActiveType(n);
        }
    }

    private void setModelOcuCallType(int n) {
        if (this._modelOcuCallType != n) {
            this._modelOcuCallType = n;
            this.getModelPhoneOcuCallListener().updateOcuCallType(n);
            if (this.getLogger().isTraceEnabled(512)) {
                this.getLogger().trace(512).append("CallState: Inform model about model OCU call type: modelOcuCallType=").append(n).log();
            }
        }
    }

    private void setModelOcuCallState(int n) {
        if (this._modelOcuCallState != n) {
            this._modelOcuCallState = n;
            this.getModelPhoneOcuCallListener().updateOcuCallState(n);
            if (this.getLogger().isTraceEnabled(512)) {
                this.getLogger().trace(512).append("CallState: Inform model about call state modelOcuCallState=").append(n).log();
            }
        }
    }

    private void setModelECallManual112Present(boolean bl) {
        if (this._eCallManual112Present != bl) {
            this._eCallManual112Present = bl;
            this.getModelPhoneOcuCallListener().updateOcuManualECall112Present(bl);
            if (this.getLogger().isTraceEnabled(512)) {
                this.getLogger().trace(512).append("CallState: Inform model about model OCU manual 112 present: eCallManual112Present=").append(bl).log();
            }
        }
    }

    boolean isECallManual112Present() {
        return this._eCallManual112Present;
    }

    int[] getOcuCallStates() {
        return this._callStates;
    }

    private int getOcuCallState() {
        return this.getOcuCallStates().length > 0 ? this.getOcuCallStates()[0] : 0;
    }

    private void _setCallStates(int[] nArray) {
        this._callStates = nArray;
    }

    private boolean isOcu2Available() {
        return ((SupportedServices)this.getDelegate().getBAPFunctionListener(27)).isOcu2Available();
    }

    private void _setHangupAllowed(boolean bl) {
        this._hangupAllowed = this.isOcu2Available() ? bl : true;
    }

    private boolean getHangupAllowed() {
        return this._hangupAllowed;
    }

    @Override
    public void initialize(boolean bl) {
        if (!bl) {
            this.getDelegate().registerServiceListener(this, class$de$vw$mib$asl$internal$ocu$ecall$api$asl$PhoneServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$asl$PhoneServiceListener = CallState.class$("de.vw.mib.asl.internal.ocu.ecall.api.asl.PhoneServiceListener")) : class$de$vw$mib$asl$internal$ocu$ecall$api$asl$PhoneServiceListener, PhoneServiceListener.PHONE_SERVICE_CONSTANTS);
            this.getDelegate().registerServiceListener(this, class$de$vw$mib$asl$internal$ocu$ecall$api$asl$AudioManagementServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$asl$AudioManagementServiceListener = CallState.class$("de.vw.mib.asl.internal.ocu.ecall.api.asl.AudioManagementServiceListener")) : class$de$vw$mib$asl$internal$ocu$ecall$api$asl$AudioManagementServiceListener, AudioManagementServiceListener.AUDIO_MANAGEMENT_SERVICE_CONSTANTS);
        } else {
            this._getOcuCallState();
        }
    }

    @Override
    public void uninitialize() {
        this._updateOcuAcnCallActive(false);
        this._setCallStates(new int[0]);
        this._updateOcuCallActiveType(-1);
    }

    @Override
    public int getFunctionId() {
        return 17;
    }

    @Override
    public void requestError(int n, BAPFunction bAPFunction) {
        this.getLogger().warn(512).append("CallState: Received error=").append(n).log();
    }

    @Override
    public boolean statusProperty(BAPEntity bAPEntity, Property property) {
        CallState_Status callState_Status = (CallState_Status)bAPEntity;
        int[] nArray = new int[]{callState_Status.callType0, callState_Status.callType1, callState_Status.callType2, callState_Status.callType3, callState_Status.callType4, callState_Status.callType5, callState_Status.callType6};
        this._setOcuAcnCallActive(CallState._isOcuAcnCallActive(nArray));
        this._setOcuCallActiveType(CallState._getOcuCallActiveType(nArray));
        int[] nArray2 = new int[]{callState_Status.callState0, callState_Status.callState1, callState_Status.callState2, callState_Status.callState3, callState_Status.callState4, callState_Status.callState5, callState_Status.callState6};
        this._setCallStates(nArray2);
        this._setHangupAllowed(callState_Status.additionalStates.hangupCallAllowedDf3_1 || callState_Status.extension == 1);
        if (this.getOcuAudioConnectionType() != 0 || this.isOcu2Available()) {
            this._updateModelOcuPopupState();
        }
        return true;
    }

    @Override
    public boolean statusAckProperty(BAPEntity bAPEntity, Property property) {
        CallState_StatusAck callState_StatusAck = (CallState_StatusAck)bAPEntity;
        CallState_Ack callState_Ack = new CallState_Ack();
        callState_Ack.callState0 = callState_StatusAck.callState0;
        callState_Ack.callType0 = callState_StatusAck.callType0;
        callState_Ack.callState1 = callState_StatusAck.callState1;
        callState_Ack.callType1 = callState_StatusAck.callType1;
        callState_Ack.callState2 = callState_StatusAck.callState2;
        callState_Ack.callType2 = callState_StatusAck.callType2;
        callState_Ack.callState3 = callState_StatusAck.callState3;
        callState_Ack.callType3 = callState_StatusAck.callType3;
        callState_Ack.callState4 = callState_StatusAck.callState4;
        callState_Ack.callType4 = callState_StatusAck.callType4;
        callState_Ack.callState5 = callState_StatusAck.callState5;
        callState_Ack.callType5 = callState_StatusAck.callType5;
        callState_Ack.callState6 = callState_StatusAck.callState6;
        callState_Ack.callType6 = callState_StatusAck.callType6;
        callState_Ack.additionalStates.hangupCallAllowedDf3_1 = callState_StatusAck.additionalStates.hangupCallAllowedDf3_1;
        callState_Ack.extension = callState_StatusAck.extension;
        property.ackProperty(callState_Ack, this);
        int[] nArray = new int[]{callState_StatusAck.callType0, callState_StatusAck.callType1, callState_StatusAck.callType2, callState_StatusAck.callType3, callState_StatusAck.callType4, callState_StatusAck.callType5, callState_StatusAck.callType6};
        this._updateOcuAcnCallActive(CallState._isOcuAcnCallActive(nArray));
        this._updateOcuCallActiveType(CallState._getOcuCallActiveType(nArray));
        int[] nArray2 = new int[]{callState_StatusAck.callState0, callState_StatusAck.callState1, callState_StatusAck.callState2, callState_StatusAck.callState3, callState_StatusAck.callState4, callState_StatusAck.callState5, callState_StatusAck.callState6};
        this._setCallStates(nArray2);
        this._setHangupAllowed(callState_StatusAck.additionalStates.hangupCallAllowedDf3_1 || callState_StatusAck.extension == 1);
        return true;
    }

    @Override
    public void phoneCallActive(boolean bl) {
        this.getPhoneDisconnectHandler().phoneCallActive(bl);
    }

    @Override
    public void audioConnectionReleased(int n) {
        int n2 = CallState._getOcuAudioConnectionType(n);
        if (n2 != 0 && this.getOcuAudioConnectionType() == n2) {
            this.setOcuAudioConnectionType(0);
            this._updateModelOcuPopupState();
        }
    }

    @Override
    public void audioConnectionStarted(int n) {
        int n2 = CallState._getOcuAudioConnectionType(n);
        if (n2 != 0) {
            this.setOcuAudioConnectionType(n2);
            this._updateModelOcuPopupState();
        }
    }

    @Override
    public void audioUserMuteIsActive(boolean bl, boolean bl2) {
        if (bl && bl2) {
            this.audioConnectionStarted(8);
        }
    }

    @Override
    public void audioManagementStatus(int n) {
        this.setAudioManagementUnAvailable(n == 0);
    }

    @Override
    public void requestConnectionAcknowledge(int n) {
    }

    private static int _getOcuAudioConnectionType(int n) {
        int n2;
        switch (n) {
            case 226: {
                n2 = 1;
                break;
            }
            case 227: {
                n2 = 2;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    private void _updateModelOcuCallState() {
        int n;
        int n2 = this.getOcuCallState();
        switch (n2) {
            case 0: {
                n = 0;
                break;
            }
            case 1: {
                n = 3;
                break;
            }
            case 2: 
            case 6: {
                n = 5;
                break;
            }
            case 3: {
                n = 1;
                break;
            }
            case 4: 
            case 7: {
                n = 6;
                break;
            }
            case 5: {
                n = 7;
                break;
            }
            case 8: {
                n = 4;
                break;
            }
            default: {
                n = 0;
                this.getLogger().warn(512).append("CallState: Got unknown call state=").append(n2).log();
            }
        }
        this.setModelOcuCallState(n);
    }

    private void _updateModelOcuHangupAvailable() {
        boolean bl = this.getHangupAllowed();
        this.getModelPhoneOcuCallListener().updateHangupAvailable(bl);
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512).append("CallState: Inform model about model OCU hangupAvailable=").append(bl).log();
        }
    }

    private static int _mapOcuCallTypeToModel(int n) {
        int n2;
        switch (n) {
            case 1: 
            case 6: {
                n2 = 3;
                break;
            }
            case 7: {
                n2 = 4;
                break;
            }
            case 8: {
                n2 = 1;
                break;
            }
            case 4: 
            case 9: 
            case 10: {
                n2 = 2;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    private void _updateModelOcuCallType() {
        int n;
        if (!this.isOcu2Available()) {
            switch (this.getOcuAudioConnectionType()) {
                case 1: {
                    n = CallState._mapOcuCallTypeToModel(this.getOcuCallActiveType());
                    break;
                }
                case 2: {
                    n = 1;
                    break;
                }
                default: {
                    n = 0;
                    break;
                }
            }
        } else {
            n = 0;
        }
        this.setModelOcuCallType(n);
    }

    private void _updateModelECallManual112Present() {
        this.setModelECallManual112Present(this.getOcuCallActiveType() == 4 && this.getOcuCallState() != 4);
    }

    private void _updateModelOcuPopupState() {
        this._updateModelOcuCallState();
        this._updateModelOcuHangupAvailable();
        this._updateModelOcuCallType();
        this._updateModelECallManual112Present();
    }

    private void _activateOrDeactivateOcuAcnCall(boolean bl) {
        if (!this.isAudioManagementUnvailable()) {
            if (bl) {
                this._audioManagementRequestOcuAcnCallConnection();
                this._phoneServiceHangupAllCalls();
                this._phoneServiceDeactivatePhoneFunctionality();
                this._smartphoneIntegrationServiceHangupAllCalls();
                this._smartphoneIntegrationServiceQuitConnection();
            } else {
                this._audioManagementReleaseOcuAcnCallConnection();
                this._phoneServiceActivatePhoneFunctionality();
                this._smartphoneIntegrationServiceEstablishConnection();
            }
            this.setLastAudioRequestSinceAmNotAvailable(false);
        } else {
            this.setLastAudioRequestSinceAmNotAvailable(true);
        }
    }

    private void _activateOrDeactivateOcuCall(boolean bl) {
        if (bl) {
            this._audioManagementRequestOcuCallConnection();
            this._phoneServiceHangupAllCalls();
            this._smartphoneIntegrationServiceHangupAllCalls();
        } else {
            this._audioManagementReleaseOcuCallConnection();
        }
    }

    private void _getOcuCallState() {
        this.getDelegate().getProperty(this).getProperty(null, this);
    }

    private void _phoneServiceHangupAllCalls() {
        this.getPhoneService().phoneCallHangupAll();
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512).append("CallState: PhoneService: request hangup all calls").log();
        }
    }

    private void _phoneServiceActivatePhoneFunctionality() {
        this.getPhoneDisconnectHandler().terminateOrActivatePhoneConnectionOrWaitForCallInactiveAndThenTerminate(true, this.getPhoneService());
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512).append("CallState: PhoneService: reactivate phone functionality").log();
        }
    }

    private void _phoneServiceDeactivatePhoneFunctionality() {
        this.getPhoneDisconnectHandler().terminateOrActivatePhoneConnectionOrWaitForCallInactiveAndThenTerminate(false, this.getPhoneService());
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512).append("CallState: PhoneService: deactivate phone functionality").log();
        }
    }

    private void _smartphoneIntegrationServiceHangupAllCalls() {
        this._carPlayServiceHangupAllCalls();
    }

    private void _carPlayServiceHangupAllCalls() {
        this.getCarPlayService().carPlayHangupAllCalls();
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512).append("CallState: CarPlayService: hangup all calls").log();
        }
    }

    private void _smartphoneIntegrationServiceEstablishConnection() {
        this.getSmartphoneIntegrationService().smartphoneIntegrationEstablishConnection();
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512).append("CallState: SmarphoneIntegerationService: establish connection").log();
        }
    }

    private void _smartphoneIntegrationServiceQuitConnection() {
        this.getSmartphoneIntegrationService().smartphoneIntegrationQuitConnection();
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512).append("CallState: SmarphoneIntegerationService: quit connection").log();
        }
    }

    private void _audioManagementRequestOcuAcnCallConnection() {
        this.getAudioManagementService().requestConnection(227);
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512).append("CallState: Request AudioManagement connection: audioConnection=").append(227).log();
        }
    }

    private void _audioManagementReleaseOcuAcnCallConnection() {
        this.getAudioManagementService().releaseConnection(227);
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512).append("CallState: Release AudioManagement connection: audioConnection=").append(227).log();
        }
    }

    private void _audioManagementRequestOcuCallConnection() {
        this.getAudioManagementService().requestConnection(226);
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512).append("CallState: Request AudioManagement connection: audioConnection=").append(226).log();
        }
    }

    private void _audioManagementReleaseOcuCallConnection() {
        this.getAudioManagementService().releaseConnection(226);
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512).append("CallState: Release AudioManagement connection: audioConnection=").append(226).log();
        }
    }

    private static int _checkCallStateTypes(int[] nArray, int[] nArray2) {
        int n = -1;
        block0: for (int n2 : nArray) {
            int n3 = nArray2.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                if (n2 != nArray2[i2]) continue;
                n = n2;
                continue block0;
            }
        }
        return n;
    }

    private static boolean _isOcuAcnCallActive(int[] nArray) {
        return CallState._checkCallStateTypes(nArray, OCU_CALL_TYPES_ACN) != -1;
    }

    private static int _getOcuCallActiveType(int[] nArray) {
        return CallState._checkCallStateTypes(nArray, OCU_CALL_TYPES_CALLS);
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

