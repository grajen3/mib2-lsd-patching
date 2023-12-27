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
import de.vw.mib.asl.internal.ocu.ecall.functions.ECallFunction;
import de.vw.mib.asl.internal.ocu.ecall.functions.PhoneDisconnectHandler;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.AudioState_Ack;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.AudioState_SetGet;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.AudioState_Status;
import de.vw.mib.asl.internal.ocu.generated.ecall.serializer.AudioState_StatusAck;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunction;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;

public final class AudioState
extends ECallFunction
implements PropertyListener,
AudioManagementServiceListener,
PhoneServiceListener {
    private int _currentOcuRequestedAudioSource;
    private int _currentOCUAudioSource;
    private int _currentActiveAudioSource;
    private int _currentActiveAudioManagementSource;
    private int _ocuAudioSourceToRestore;
    private boolean _requestViaStatusAckPerformed;
    private boolean _lastRequestNotSent;
    private PhoneDisconnectHandler _phoneDisconnectHandler;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$asl$PhoneService;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$asl$AudioManagementService;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$asl$SmartphoneIntegrationService;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$asl$CarPlayService;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$asl$PhoneServiceListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$ocu$ecall$api$asl$AudioManagementServiceListener;

    private void _resetAudioConnectionStates() {
        this.setCurrentActiveAudioSource(0);
        this.setCurrentOCUAudioSource(0);
        this.setCurrentOcuRequestedAudioSource(0);
    }

    private PhoneService getPhoneService() {
        return (PhoneService)this.getDelegate().getService(class$de$vw$mib$asl$internal$ocu$ecall$api$asl$PhoneService == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$asl$PhoneService = AudioState.class$("de.vw.mib.asl.internal.ocu.ecall.api.asl.PhoneService")) : class$de$vw$mib$asl$internal$ocu$ecall$api$asl$PhoneService);
    }

    private PhoneDisconnectHandler getPhoneDisconnectHandler() {
        if (this._phoneDisconnectHandler == null) {
            this._phoneDisconnectHandler = new PhoneDisconnectHandler(this.getLogger());
        }
        return this._phoneDisconnectHandler;
    }

    private AudioManagementService getAudioManagementService() {
        return (AudioManagementService)this.getDelegate().getService(class$de$vw$mib$asl$internal$ocu$ecall$api$asl$AudioManagementService == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$asl$AudioManagementService = AudioState.class$("de.vw.mib.asl.internal.ocu.ecall.api.asl.AudioManagementService")) : class$de$vw$mib$asl$internal$ocu$ecall$api$asl$AudioManagementService);
    }

    private SmartphoneIntegrationService getSmartphoneIntegrationService() {
        return (SmartphoneIntegrationService)this.getDelegate().getService(class$de$vw$mib$asl$internal$ocu$ecall$api$asl$SmartphoneIntegrationService == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$asl$SmartphoneIntegrationService = AudioState.class$("de.vw.mib.asl.internal.ocu.ecall.api.asl.SmartphoneIntegrationService")) : class$de$vw$mib$asl$internal$ocu$ecall$api$asl$SmartphoneIntegrationService);
    }

    private CarPlayService getCarPlayService() {
        return (CarPlayService)this.getDelegate().getService(class$de$vw$mib$asl$internal$ocu$ecall$api$asl$CarPlayService == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$asl$CarPlayService = AudioState.class$("de.vw.mib.asl.internal.ocu.ecall.api.asl.CarPlayService")) : class$de$vw$mib$asl$internal$ocu$ecall$api$asl$CarPlayService);
    }

    private int getCurrentOcuRequestedAudioSource() {
        return this._currentOcuRequestedAudioSource;
    }

    private void setCurrentOcuRequestedAudioSource(int n) {
        this._currentOcuRequestedAudioSource = n;
    }

    private void setLastRequestNotSent(boolean bl) {
        this._lastRequestNotSent = bl;
    }

    private boolean getLastRequestNotSent() {
        return this._lastRequestNotSent;
    }

    private int getCurrentOCUAudioSource() {
        return this._currentOCUAudioSource;
    }

    private void setCurrentOCUAudioSource(int n) {
        this._currentOCUAudioSource = n;
    }

    private void setCurrentActiveAudioSource(int n) {
        this._currentActiveAudioSource = n;
    }

    private int getCurrentActiveAudioSource() {
        return this._currentActiveAudioSource;
    }

    private void setCurrentActiveAudioManagementSource(int n) {
        this._currentActiveAudioManagementSource = n;
    }

    private int getCurrentActiveAudioManagementSource() {
        return this._currentActiveAudioManagementSource;
    }

    private void setOCUAudioSourceToRestore(int n) {
        this._ocuAudioSourceToRestore = n;
    }

    private int getOCUAudioSourceToRestore() {
        return this._ocuAudioSourceToRestore;
    }

    private void setRequestViaStatusAckPerformed(boolean bl) {
        this._requestViaStatusAckPerformed = bl;
    }

    private boolean getRequestViaStatusAckPerformed() {
        return this._requestViaStatusAckPerformed;
    }

    private void _noSetGetAnswerForAudioStateRequestOcuWorkaround() {
        if (this.getLastRequestNotSent()) {
            this._requestOcuCurrentAudioSource(this.getCurrentActiveAudioSource());
        }
    }

    @Override
    public void initialize(boolean bl) {
        if (!bl) {
            this.getDelegate().registerServiceListener(this, class$de$vw$mib$asl$internal$ocu$ecall$api$asl$PhoneServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$asl$PhoneServiceListener = AudioState.class$("de.vw.mib.asl.internal.ocu.ecall.api.asl.PhoneServiceListener")) : class$de$vw$mib$asl$internal$ocu$ecall$api$asl$PhoneServiceListener, PhoneServiceListener.PHONE_SERVICE_CONSTANTS);
            this.getDelegate().registerServiceListener(this, class$de$vw$mib$asl$internal$ocu$ecall$api$asl$AudioManagementServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$asl$AudioManagementServiceListener = AudioState.class$("de.vw.mib.asl.internal.ocu.ecall.api.asl.AudioManagementServiceListener")) : class$de$vw$mib$asl$internal$ocu$ecall$api$asl$AudioManagementServiceListener, AudioManagementServiceListener.AUDIO_MANAGEMENT_SERVICE_CONSTANTS);
        } else {
            this.getDelegate().registerServiceListener(this, class$de$vw$mib$asl$internal$ocu$ecall$api$asl$AudioManagementServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$asl$AudioManagementServiceListener = AudioState.class$("de.vw.mib.asl.internal.ocu.ecall.api.asl.AudioManagementServiceListener")) : class$de$vw$mib$asl$internal$ocu$ecall$api$asl$AudioManagementServiceListener, AudioManagementServiceListener.AUDIO_MANAGEMENT_SERVICE_CONSTANTS);
            this._getOcuAudioState();
        }
    }

    @Override
    public void uninitialize() {
        if (this.getRequestViaStatusAckPerformed() || this.getCurrentOcuRequestedAudioSource() != 0) {
            this._ocuAudioRelease(this.getCurrentActiveAudioSource());
            if (this.getCurrentOcuRequestedAudioSource() != this.getCurrentActiveAudioSource()) {
                this._ocuAudioRelease(this.getCurrentOcuRequestedAudioSource());
            }
        }
        this.setRequestViaStatusAckPerformed(false);
        this._resetAudioConnectionStates();
        this.getDelegate().unregisterServiceListener(this, class$de$vw$mib$asl$internal$ocu$ecall$api$asl$AudioManagementServiceListener == null ? (class$de$vw$mib$asl$internal$ocu$ecall$api$asl$AudioManagementServiceListener = AudioState.class$("de.vw.mib.asl.internal.ocu.ecall.api.asl.AudioManagementServiceListener")) : class$de$vw$mib$asl$internal$ocu$ecall$api$asl$AudioManagementServiceListener, AudioManagementServiceListener.AUDIO_MANAGEMENT_SERVICE_CONSTANTS);
    }

    @Override
    public int getFunctionId() {
        return 16;
    }

    @Override
    public void requestError(int n, BAPFunction bAPFunction) {
        if (n == 35) {
            this.setLastRequestNotSent(true);
        }
        this.getLogger().warn(512).append("AudioState: Received error=").append(n).log();
    }

    @Override
    public boolean statusProperty(BAPEntity bAPEntity, Property property) {
        AudioState_Status audioState_Status = (AudioState_Status)bAPEntity;
        this.setCurrentOCUAudioSource(audioState_Status.currentAudioSource);
        if (!this.getRequestViaStatusAckPerformed()) {
            boolean bl;
            boolean bl2 = bl = this.getCurrentOcuRequestedAudioSource() != 0 || !AudioState._isOcuConnection(this.getCurrentActiveAudioSource());
            if (bl) {
                this._processOcuAudioRequest(audioState_Status.audioRequest);
            }
            this._noSetGetAnswerForAudioStateRequestOcuWorkaround();
        }
        return true;
    }

    @Override
    public boolean statusAckProperty(BAPEntity bAPEntity, Property property) {
        AudioState_StatusAck audioState_StatusAck = (AudioState_StatusAck)bAPEntity;
        AudioState_Ack audioState_Ack = new AudioState_Ack();
        audioState_Ack.audioRequest = audioState_StatusAck.audioRequest;
        audioState_Ack.currentAudioSource = audioState_StatusAck.currentAudioSource;
        property.ackProperty(audioState_Ack, this);
        this.setCurrentOCUAudioSource(audioState_StatusAck.currentAudioSource);
        this._processOcuAudioRequest(audioState_StatusAck.audioRequest);
        this.setRequestViaStatusAckPerformed(true);
        this._noSetGetAnswerForAudioStateRequestOcuWorkaround();
        return true;
    }

    @Override
    public void phoneCallActive(boolean bl) {
        this.getPhoneDisconnectHandler().phoneCallActive(bl);
    }

    @Override
    public void audioConnectionReleased(int n) {
        this.checkAcnReleasedViaHardwareMute(n);
        if (AudioState._isOcuConnection(AudioState._mapAudioConnectionToOcuAudioSource(n)) && this.getCurrentActiveAudioSource() == AudioState._mapAudioConnectionToOcuAudioSource(n)) {
            this.setCurrentActiveAudioSource(AudioState._mapAudioConnectionToOcuAudioSource(this.getCurrentActiveAudioManagementSource()));
            this._requestOcuCurrentAudioSource(this.getCurrentActiveAudioSource());
        }
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512).append("AudioState: AudioManagement: Connection released audioConnection=").append(n).log();
        }
    }

    private static boolean ignoreAudioConnection(int n) {
        boolean bl;
        switch (n) {
            case 100: 
            case 113: 
            case 137: 
            case 153: 
            case 159: 
            case 163: 
            case 164: 
            case 245: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    @Override
    public void audioConnectionStarted(int n) {
        if (AudioState.ignoreAudioConnection(n)) {
            return;
        }
        if (AudioState._isOcuConnection(AudioState._mapAudioConnectionToOcuAudioSource(n))) {
            this.setCurrentActiveAudioSource(AudioState._mapAudioConnectionToOcuAudioSource(n));
            this._requestOcuCurrentAudioSource(this.getCurrentActiveAudioSource());
            this.setOCUAudioSourceToRestore(0);
            this.checkForAcnStartedViaHardwareMute();
        } else {
            this.setCurrentActiveAudioManagementSource(n);
            if (!AudioState._isOcuConnection(this.getCurrentActiveAudioSource())) {
                this.setCurrentActiveAudioSource(AudioState._mapAudioConnectionToOcuAudioSource(n));
                this._requestOcuCurrentAudioSource(this.getCurrentActiveAudioSource());
            }
        }
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512).append("AudioState: AudioManagement: Connection started audioConnection=").append(n).log();
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
        switch (n) {
            case 0: {
                this._requestOcuCurrentAudioSource(0);
                if (AudioState._isOcuConnection(this.getCurrentActiveAudioSource())) {
                    this.setOCUAudioSourceToRestore(this.getCurrentActiveAudioSource());
                }
                this._resetAudioConnectionStates();
                break;
            }
            case 1: {
                if (!this.getRequestViaStatusAckPerformed() || this.getCurrentOcuRequestedAudioSource() == 0 || this.getCurrentOcuRequestedAudioSource() == this.getCurrentActiveAudioSource()) break;
                this._processOcuAudioRequest(this.getCurrentOcuRequestedAudioSource());
                break;
            }
            case 2: {
                if (this.getOCUAudioSourceToRestore() == 0) break;
                this._ocuAudioRestore(this.getOCUAudioSourceToRestore());
                break;
            }
        }
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512).append("AudioState: AudioManagement: New audioManagmentStatus=").append(n).log();
        }
    }

    @Override
    public void requestConnectionAcknowledge(int n) {
    }

    private void checkAcnReleasedViaHardwareMute(int n) {
        if (AudioState._mapAudioConnectionToOcuAudioSource(n) == 7 && this.getCurrentActiveAudioSource() == 7) {
            this._acnReleased();
        }
    }

    private void checkForAcnStartedViaHardwareMute() {
        if (this.getCurrentActiveAudioSource() == 7 && this.getCurrentOCUAudioSource() != 7) {
            this._ocuAcnRequested();
        }
    }

    private void _getOcuAudioState() {
        this.getDelegate().getProperty(this).getProperty(null, this);
    }

    private void _phoneServiceHangupAllCalls() {
        this.getPhoneService().phoneCallHangupAll();
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512).append("AudioState: PhoneService: request hangup all calls").log();
        }
    }

    private void _phoneServiceActivatePhoneFunctionality() {
        this.getPhoneDisconnectHandler().terminateOrActivatePhoneConnectionOrWaitForCallInactiveAndThenTerminate(true, this.getPhoneService());
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512).append("AudioState: PhoneService: reactivate phone functionality").log();
        }
    }

    private void _phoneServiceDeactivatePhoneFunctionality() {
        this.getPhoneDisconnectHandler().terminateOrActivatePhoneConnectionOrWaitForCallInactiveAndThenTerminate(false, this.getPhoneService());
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512).append("AudioState: PhoneService: deactivate phone functionality").log();
        }
    }

    private void _smartphoneIntegrationServiceHangupAllCalls() {
        this._carPlayServiceHangupAllCalls();
    }

    private void _carPlayServiceHangupAllCalls() {
        this.getCarPlayService().carPlayHangupAllCalls();
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512).append("AudioState: CarPlayService: hangup all calls").log();
        }
    }

    private void _smartphoneIntegrationServiceEstablishConnection() {
        this.getSmartphoneIntegrationService().smartphoneIntegrationEstablishConnection();
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512).append("AudioState: SmarphoneIntegerationService: establish connection").log();
        }
    }

    private void _smartphoneIntegrationServiceQuitConnection() {
        this.getSmartphoneIntegrationService().smartphoneIntegrationQuitConnection();
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512).append("AudioState: SmarphoneIntegerationService: quit connection").log();
        }
    }

    private void _audioManagementRequestConnection(int n) {
        this.getAudioManagementService().requestConnection(n);
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512).append("AudioState: Request AudioManagement connection: audioConnection=").append(n).log();
        }
    }

    private void _audioManagementReleaseConnection(int n) {
        this.getAudioManagementService().releaseConnection(n);
        if (this.getLogger().isTraceEnabled(512)) {
            this.getLogger().trace(512).append("AudioState: Release AudioManagement connection: audioConnection=").append(n).log();
        }
    }

    private void _processOcuAudioRequest(int n) {
        if (n != this.getCurrentOcuRequestedAudioSource() && this.getCurrentOcuRequestedAudioSource() != this.getCurrentActiveAudioSource()) {
            this._ocuAudioRelease(this.getCurrentOcuRequestedAudioSource());
        }
        if (n != this.getCurrentActiveAudioSource() && n != this.getCurrentOcuRequestedAudioSource()) {
            this._ocuAudioRequest(n);
            this.setCurrentOcuRequestedAudioSource(n);
        }
        if (n == 0 || n != this.getCurrentActiveAudioSource()) {
            this._ocuAudioRelease(this.getCurrentActiveAudioSource());
        }
    }

    private void _ocuAcnRequested() {
        this._phoneServiceHangupAllCalls();
        this._phoneServiceDeactivatePhoneFunctionality();
        this._smartphoneIntegrationServiceHangupAllCalls();
        this._smartphoneIntegrationServiceQuitConnection();
    }

    private void _ocuAudioRequest(int n) {
        switch (n) {
            case 2: {
                this._audioManagementRequestConnection(225);
                break;
            }
            case 1: {
                this._audioManagementRequestConnection(228);
                break;
            }
            case 3: {
                this._audioManagementRequestConnection(227);
                this._ocuAcnRequested();
                break;
            }
            case 4: {
                this._audioManagementRequestConnection(226);
                this._phoneServiceHangupAllCalls();
                this._smartphoneIntegrationServiceHangupAllCalls();
                break;
            }
            case 7: {
                this._audioManagementRequestConnection(210);
                this._ocuAcnRequested();
                break;
            }
        }
    }

    private void _ocuAudioRelease(int n) {
        switch (n) {
            case 2: {
                this._audioManagementReleaseConnection(225);
                break;
            }
            case 1: {
                this._audioManagementReleaseConnection(228);
                break;
            }
            case 3: {
                this._audioManagementReleaseConnection(227);
                this._acnReleased();
                break;
            }
            case 4: {
                this._audioManagementReleaseConnection(226);
                break;
            }
            case 7: {
                this._audioManagementReleaseConnection(210);
                this._acnReleased();
                break;
            }
        }
    }

    private void _acnReleased() {
        this._phoneServiceActivatePhoneFunctionality();
        this._smartphoneIntegrationServiceEstablishConnection();
    }

    private void _ocuAudioRestore(int n) {
        this.getLogger().info(512).append("Restoring audio connection after voltage drop bap-connection=").append(n).log();
        switch (n) {
            case 1: {
                this._audioManagementRequestConnection(228);
                break;
            }
            case 2: {
                this._audioManagementRequestConnection(225);
                break;
            }
            case 3: {
                this._audioManagementRequestConnection(227);
                break;
            }
            case 4: {
                this._audioManagementRequestConnection(226);
                break;
            }
            case 7: {
                this._audioManagementRequestConnection(210);
                break;
            }
        }
    }

    private static int _mapAudioConnectionToOcuAudioSource(int n) {
        int n2;
        switch (n) {
            case 225: {
                n2 = 2;
                break;
            }
            case 226: {
                n2 = 4;
                break;
            }
            case 227: {
                n2 = 3;
                break;
            }
            case 228: {
                n2 = 1;
                break;
            }
            case 99: 
            case 104: {
                n2 = 6;
                break;
            }
            case 210: {
                n2 = 7;
                break;
            }
            default: {
                n2 = 5;
            }
        }
        return n2;
    }

    private static boolean _isOcuConnection(int n) {
        boolean bl;
        switch (n) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 7: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    private void _requestOcuCurrentAudioSource(int n) {
        if (this.getCurrentOCUAudioSource() != n) {
            AudioState_SetGet audioState_SetGet = new AudioState_SetGet();
            audioState_SetGet.currentAudioSource = n;
            this.getDelegate().getProperty(this).setGetProperty(audioState_SetGet, this);
            this.setLastRequestNotSent(false);
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

