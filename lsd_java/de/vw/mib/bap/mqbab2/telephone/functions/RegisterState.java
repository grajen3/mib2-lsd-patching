/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions;

import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneService;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.RegisterState_Status;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;

public final class RegisterState
extends Function
implements TimerNotifier,
Property,
ASLTelephoneConstants,
PhoneServiceListener {
    private static final int REGISTER_STATE_UNREGISTERED;
    private static final int REGISTER_STATE_WAIT_FOR_NETWORK_PROVIDER_NAME;
    private static final int REGISTER_STATE_REGISTERING;
    private static final int REGISTER_STATE_REGISTERED;
    private static final int REGISTER_STATE_UNREGISTERING;
    private int registerState = 0;
    private String currentNetworkProviderName = "";
    private Timer waitForNetworkNameTimer = null;
    private static final int TIMER_WAIT_FOR_NETWORK_NAME_TIME;
    protected static final int[] PHONE_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$RegisterState_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        this.waitForNetworkNameTimer = this.getTimerService().createTimer(this, 200);
        return this.computeRegisterStateStatus();
    }

    protected void setNetworkProviderName(String string) {
        int[] nArray = new int[]{20};
        this.context.updateStages(this, nArray, string);
    }

    protected RegisterState_Status dequeueBAPEntity() {
        return (RegisterState_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$RegisterState_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$RegisterState_Status = RegisterState.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.RegisterState_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$RegisterState_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        switch (bAPStage.getFunctionId()) {
            case 20: {
                this.setNetworkProviderSend((String)object);
                break;
            }
        }
    }

    @Override
    public int getFunctionId() {
        return 18;
    }

    private void sendRegisterState(RegisterState_Status registerState_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(registerState_Status, this);
    }

    private void setRegistrationState(RegisterState_Status registerState_Status) {
        PhoneService phoneService = this.getPhoneService();
        switch (phoneService.getNetworkState()) {
            case 4: 
            case 5: {
                registerState_Status.registerState = 3;
                break;
            }
            case 1: {
                registerState_Status.registerState = 1;
                break;
            }
            case 3: {
                registerState_Status.registerState = 2;
                break;
            }
            case 2: {
                registerState_Status.registerState = 4;
                break;
            }
            case 0: {
                if (phoneService.getCurrentPhoneProfile() == 2) {
                    registerState_Status.registerState = 255;
                    break;
                }
                registerState_Status.registerState = 0;
                break;
            }
            default: {
                registerState_Status.registerState = 3;
            }
        }
    }

    private void setNetworkType(RegisterState_Status registerState_Status) {
        switch (this.getPhoneService().getNetworkType()) {
            case 1: {
                registerState_Status.networkType = 1;
                break;
            }
            case 2: {
                registerState_Status.networkType = 2;
                break;
            }
            case 3: {
                registerState_Status.networkType = 4;
                break;
            }
            default: {
                registerState_Status.networkType = 0;
            }
        }
    }

    private void setPacketDataNetworkType(RegisterState_Status registerState_Status) {
        registerState_Status.packetDataNetworkType = 0;
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(128, this);
    }

    @Override
    public void requestAcknowledge() {
        this.registerStateSend();
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.waitForNetworkNameTimer.stop();
        this.getPhoneService().removePhoneServiceListener(this, PHONE_LISTENER_IDS);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(128, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void process(int n) {
        if (!this.waitForNetworkNameTimer.isRunning()) {
            RegisterState_Status registerState_Status = this.computeRegisterStateStatus();
            if (this.setRegisterStateForCurrentHMIRegisterState(registerState_Status.registerState == 1)) {
                this.sendRegisterState(registerState_Status);
            }
        }
    }

    private RegisterState_Status computeRegisterStateStatus() {
        RegisterState_Status registerState_Status = this.dequeueBAPEntity();
        this.setRegistrationState(registerState_Status);
        this.setNetworkType(registerState_Status);
        this.setPacketDataNetworkType(registerState_Status);
        return registerState_Status;
    }

    protected void setNetworkProviderSend(String string) {
        switch (this.getRegisterState()) {
            case 2: {
                this.sendRegisterState(this.computeRegisterStateStatus());
                this.setRegisterState(3);
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                break;
            }
            case 1: {
                break;
            }
        }
        this.currentNetworkProviderName = string;
    }

    private int getRegisterState() {
        return this.registerState;
    }

    private void setRegisterState(int n) {
        this.registerState = n;
    }

    private void registerStateSend() {
        switch (this.getRegisterState()) {
            case 2: {
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                this.setNetworkProviderName(this.getPhoneService().getNetworkName());
                this.setRegisterState(0);
                break;
            }
            case 1: {
                break;
            }
        }
    }

    private boolean setRegisterStateForCurrentHMIRegisterState(boolean bl) {
        boolean bl2;
        PhoneService phoneService = this.getPhoneService();
        switch (this.getRegisterState()) {
            case 2: {
                this.setNetworkProviderName(phoneService.getNetworkName());
                if (!bl) {
                    this.setRegisterState(0);
                    bl2 = true;
                    break;
                }
                bl2 = false;
                break;
            }
            case 3: {
                if (!bl) {
                    this.setRegisterState(4);
                } else {
                    this.setNetworkProviderName(phoneService.getNetworkName());
                }
                bl2 = true;
                break;
            }
            case 4: {
                if (bl) {
                    this.setNetworkProviderName(phoneService.getNetworkName());
                    this.setRegisterState(3);
                }
                bl2 = true;
                break;
            }
            case 1: {
                if (bl) {
                    String string = phoneService.getNetworkName();
                    if (string.length() != 0 && this.currentNetworkProviderName.compareTo(string) != 0) {
                        this.setNetworkProviderName(string);
                        this.setRegisterState(2);
                        bl2 = false;
                        break;
                    }
                    bl2 = true;
                    this.setRegisterState(3);
                    break;
                }
                this.setRegisterState(0);
                this.setNetworkProviderName(phoneService.getNetworkName());
                bl2 = true;
                break;
            }
            default: {
                if (bl) {
                    String string = phoneService.getNetworkName();
                    if (string.length() != 0 && this.currentNetworkProviderName.compareTo(string) != 0) {
                        this.setNetworkProviderName(string);
                        this.setRegisterState(2);
                        bl2 = false;
                        break;
                    }
                    bl2 = false;
                    this.setRegisterState(1);
                    this.waitForNetworkNameTimer.retrigger(new Integer(0));
                    break;
                }
                this.setNetworkProviderName(phoneService.getNetworkName());
                bl2 = true;
            }
        }
        return bl2;
    }

    @Override
    public void timerFired(Timer timer) {
        this.process(-1);
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updatePhoneData(PhoneService phoneService, int n) {
        this.process(-1);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        PHONE_LISTENER_IDS = new int[]{1084, 1086, 1085, 1118};
    }
}

