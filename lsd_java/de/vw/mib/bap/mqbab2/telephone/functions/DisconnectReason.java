/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneService;
import de.vw.mib.bap.mqbab2.common.api.phone.PhoneServiceListener;
import de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.elements.PhoneCallInformationElement;
import de.vw.mib.bap.mqbab2.common.api.phone.datatypes.iterator.elements.PhoneConferenceCallInformationsElement;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.DisconnectReason_Status;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;
import java.util.Iterator;

public final class DisconnectReason
extends Function
implements Property,
ASLTelephoneConstants,
PhoneServiceListener {
    private int[] _currentCallStates;
    private static final int CALL_ID_ONE;
    private static final int NO_DISCONNECT_REASON_AVAILABLE;
    protected static final int[] PHONE_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$DisconnectReason_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        return this.dequeueBAPEntity();
    }

    protected DisconnectReason_Status dequeueBAPEntity() {
        return (DisconnectReason_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$DisconnectReason_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$DisconnectReason_Status = DisconnectReason.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.DisconnectReason_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$DisconnectReason_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        switch (bAPStage.getFunctionId()) {
            case 22: {
                this.setCurrentCallStates(object);
                break;
            }
        }
    }

    @Override
    public int getFunctionId() {
        return 25;
    }

    @Override
    public void process(int n) {
        this._checkCallStates();
    }

    private int computeBAPDisconnectReason(int n) {
        int n2;
        switch (n) {
            case 9: {
                n2 = 10;
                break;
            }
            case 0: 
            case 1: {
                n2 = 0;
                break;
            }
            case 7: {
                n2 = 7;
                break;
            }
            case 2: {
                n2 = 1;
                break;
            }
            case 8: 
            case 15: {
                n2 = 8;
                break;
            }
            case 11: {
                n2 = 11;
                break;
            }
            case 5: {
                n2 = 5;
                break;
            }
            case 6: {
                n2 = 6;
                break;
            }
            case 12: {
                n2 = 12;
                break;
            }
            case 4: {
                n2 = 4;
                break;
            }
            case 10: {
                n2 = 9;
                break;
            }
            case 13: {
                n2 = 13;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
            default: {
                n2 = 14;
            }
        }
        return n2;
    }

    private int findDisconnectReason(int n) {
        Iterator iterator = this.getPhoneService().getCallInformations();
        int n2 = -1;
        while (iterator.hasNext()) {
            PhoneCallInformationElement phoneCallInformationElement = (PhoneCallInformationElement)iterator.next();
            if (phoneCallInformationElement.getCallID() != n) continue;
            n2 = phoneCallInformationElement.getCallDisconnectionReason();
            break;
        }
        return n2;
    }

    private int findDisconnectReasonForConference(int n) {
        Iterator iterator = this.getPhoneService().getConferenceCallInformations();
        int n2 = -1;
        while (iterator.hasNext()) {
            PhoneConferenceCallInformationsElement phoneConferenceCallInformationsElement = (PhoneConferenceCallInformationsElement)iterator.next();
            if (phoneConferenceCallInformationsElement.getConferenceCallId() != n) continue;
            n2 = phoneConferenceCallInformationsElement.getConferenceDisconnectReason();
            break;
        }
        return n2;
    }

    private DisconnectReason_Status getDisconnectReasonForCall(int n) {
        int n2 = this.findDisconnectReason(n);
        if (n2 == -1) {
            n2 = this.findDisconnectReasonForConference(n);
        }
        DisconnectReason_Status disconnectReason_Status = this.dequeueBAPEntity();
        disconnectReason_Status.disconnectReason = this.computeBAPDisconnectReason(n2);
        return disconnectReason_Status;
    }

    private void sendDisconnectReason(DisconnectReason_Status disconnectReason_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(disconnectReason_Status, this);
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(69, this);
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
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

    private void _checkCallStates() {
        int[] nArray = this.getCurrentCallStates();
        boolean bl = false;
        int n = 0;
        int n2 = 1;
        int n3 = nArray.length;
        while (n < n3) {
            if (nArray[n] == 4) {
                this.sendDisconnectReason(this.getDisconnectReasonForCall(n2));
                bl = true;
                break;
            }
            ++n;
            ++n2;
        }
        if (!bl) {
            DisconnectReason_Status disconnectReason_Status = this.dequeueBAPEntity();
            disconnectReason_Status.disconnectReason = 14;
            this.sendDisconnectReason(disconnectReason_Status);
        }
    }

    protected void setCurrentCallStates(Object object) {
        this._currentCallStates = (int[])object;
        this._checkCallStates();
    }

    private int[] getCurrentCallStates() {
        if (this._currentCallStates == null) {
            this._currentCallStates = new int[0];
        }
        return this._currentCallStates;
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
        PHONE_LISTENER_IDS = new int[]{1158};
    }
}

