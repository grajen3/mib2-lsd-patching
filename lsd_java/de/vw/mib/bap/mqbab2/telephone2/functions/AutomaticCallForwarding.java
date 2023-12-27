/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone2.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneService;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneServiceListener;
import de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.elements.PhoneCallForwardingsElement;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone2.serializer.AutomaticCallForwarding_Status;
import de.vw.mib.bap.mqbab2.generated.telephone2.serializer.AutomaticCallForwarding_Status$DivertState;
import de.vw.mib.bap.mqbab2.telephone2.api.ASLTelephone2Constants;
import java.util.Iterator;

public final class AutomaticCallForwarding
extends Function
implements Property,
ASLTelephone2Constants,
PhoneServiceListener {
    protected static final int[] PHONE_LISTENER_IDS = new int[]{1207, 1210};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$AutomaticCallForwarding_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        return this.computeAutomaticCallForwardingStatus();
    }

    protected AutomaticCallForwarding_Status dequeueBAPEntity() {
        return (AutomaticCallForwarding_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$AutomaticCallForwarding_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$AutomaticCallForwarding_Status = AutomaticCallForwarding.class$("de.vw.mib.bap.mqbab2.generated.telephone2.serializer.AutomaticCallForwarding_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone2$serializer$AutomaticCallForwarding_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 25;
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getPhoneService().removePhoneServiceListener(this, PHONE_LISTENER_IDS);
    }

    @Override
    public void process(int n) {
        this.getDelegate().getPropertyListener(this).statusProperty(this.computeAutomaticCallForwardingStatus(), this);
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(69, this);
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(69, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void errorAcknowledge() {
    }

    public AutomaticCallForwarding_Status computeAutomaticCallForwardingStatus() {
        AutomaticCallForwarding_Status automaticCallForwarding_Status = this.dequeueBAPEntity();
        automaticCallForwarding_Status.divertState.forwardingStateValid = this.getBapForwardingValid();
        this.setBapDivertState(automaticCallForwarding_Status.divertState);
        return automaticCallForwarding_Status;
    }

    private boolean getBapForwardingValid() {
        return this.getPhoneService().isCallForwardingAvailable();
    }

    private void setBapDivertState(AutomaticCallForwarding_Status$DivertState automaticCallForwarding_Status$DivertState) {
        Iterator iterator = this.getPhoneService().getCallForwardings();
        while (iterator.hasNext()) {
            PhoneCallForwardingsElement phoneCallForwardingsElement = (PhoneCallForwardingsElement)iterator.next();
            int n = phoneCallForwardingsElement.getCallForwardingId();
            int n2 = phoneCallForwardingsElement.getCallForwardingState();
            boolean bl = n2 == 2;
            switch (n) {
                case 0: {
                    automaticCallForwarding_Status$DivertState.forwardingAllVoiceCalls = bl;
                    break;
                }
                case 1: {
                    automaticCallForwarding_Status$DivertState.forwardingIfBusy = bl;
                    break;
                }
                case 2: {
                    automaticCallForwarding_Status$DivertState.forwardingIfOutOfReach = bl;
                    break;
                }
                case 3: {
                    automaticCallForwarding_Status$DivertState.forwardingIfNotAnswered = bl;
                    break;
                }
            }
        }
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
}

