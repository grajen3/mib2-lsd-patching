/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions.carplay;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.common.api.carplay.CarPlayService;
import de.vw.mib.bap.mqbab2.common.api.carplay.CarPlayServiceListener;
import de.vw.mib.bap.mqbab2.common.api.carplay.datatypes.iterator.elements.CarPlayCall;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallInfo_Status;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;
import java.util.Iterator;

public class CallInfoCarPlay
extends Function
implements Property,
ASLTelephoneConstants,
CarPlayServiceListener {
    private static final int CALL_ID_ONE;
    private static final int CALL_ID_TWO;
    private static final int CALL_ID_THREE;
    private static final int CALL_ID_FOUR;
    private static final int CALL_ID_FIVE;
    private static final int CALL_ID_SIX;
    private static final int CALL_ID_SEVEN;
    private static final int CALL_ID_CONFERENCE;
    private static final int CALL_ID_INVALID;
    private static int MAX_NUMBER_OF_CALLS;
    protected static final int[] CAR_PLAY_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallInfo_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getCarPlayService().addCarPlayServiceListener(this, CAR_PLAY_LISTENER_IDS);
        return this.computeCallInfoStatus();
    }

    protected CallInfo_Status dequeueBAPEntity() {
        return (CallInfo_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallInfo_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallInfo_Status = CallInfoCarPlay.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallInfo_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallInfo_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 23;
    }

    @Override
    public void process(int n) {
        this.sendCallInfoStatus(this.computeCallInfoStatus());
    }

    private void sendCallInfoStatus(CallInfo_Status callInfo_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(callInfo_Status, this);
    }

    private CallInfo_Status computeCallInfoStatus() {
        CallInfo_Status callInfo_Status = this.dequeueBAPEntity();
        this.setCallInfoStatusData(callInfo_Status);
        return callInfo_Status;
    }

    private void setCallInfoStatusData(CallInfo_Status callInfo_Status) {
        Iterator iterator = this.getCarPlayService().getCarPlayCalls();
        CarPlayCall carPlayCall = null;
        block9: while (iterator.hasNext()) {
            carPlayCall = (CarPlayCall)iterator.next();
            switch (carPlayCall.getMappedCallID()) {
                case 0: {
                    callInfo_Status.category0 = 0;
                    if (carPlayCall.getCallerName() != null && !carPlayCall.getCallerName().equals("")) {
                        callInfo_Status.pbName0.setContent(carPlayCall.getCallerName());
                    } else {
                        callInfo_Status.pbName0.setNullString();
                    }
                    callInfo_Status.telNumber0.setContent(carPlayCall.getPhoneNumber());
                    continue block9;
                }
                case 1: {
                    callInfo_Status.category1 = 0;
                    if (carPlayCall.getCallerName() != null && !carPlayCall.getCallerName().equals("")) {
                        callInfo_Status.pbName1.setContent(carPlayCall.getCallerName());
                    } else {
                        callInfo_Status.pbName1.setNullString();
                    }
                    callInfo_Status.telNumber1.setContent(carPlayCall.getPhoneNumber());
                    continue block9;
                }
                case 2: {
                    callInfo_Status.category2 = 0;
                    if (carPlayCall.getCallerName() != null && !carPlayCall.getCallerName().equals("")) {
                        callInfo_Status.pbName2.setContent(carPlayCall.getCallerName());
                    } else {
                        callInfo_Status.pbName2.setNullString();
                    }
                    callInfo_Status.telNumber2.setContent(carPlayCall.getPhoneNumber());
                    continue block9;
                }
                case 3: {
                    callInfo_Status.category3 = 0;
                    if (carPlayCall.getCallerName() != null && !carPlayCall.getCallerName().equals("")) {
                        callInfo_Status.pbName3.setContent(carPlayCall.getCallerName());
                    } else {
                        callInfo_Status.pbName3.setNullString();
                    }
                    callInfo_Status.telNumber3.setContent(carPlayCall.getPhoneNumber());
                    continue block9;
                }
                case 4: {
                    callInfo_Status.category4 = 0;
                    if (carPlayCall.getCallerName() != null && !carPlayCall.getCallerName().equals("")) {
                        callInfo_Status.pbName4.setContent(carPlayCall.getCallerName());
                    } else {
                        callInfo_Status.pbName4.setNullString();
                    }
                    callInfo_Status.telNumber4.setContent(carPlayCall.getPhoneNumber());
                    continue block9;
                }
                case 5: {
                    callInfo_Status.category5 = 0;
                    if (carPlayCall.getCallerName() != null && !carPlayCall.getCallerName().equals("")) {
                        callInfo_Status.pbName5.setContent(carPlayCall.getCallerName());
                    } else {
                        callInfo_Status.pbName5.setNullString();
                    }
                    callInfo_Status.telNumber5.setContent(carPlayCall.getPhoneNumber());
                    continue block9;
                }
                case 6: {
                    callInfo_Status.category6 = 0;
                    if (carPlayCall.getCallerName() != null && !carPlayCall.getCallerName().equals("")) {
                        callInfo_Status.pbName6.setContent(carPlayCall.getCallerName());
                    } else {
                        callInfo_Status.pbName6.setNullString();
                    }
                    callInfo_Status.telNumber6.setContent(carPlayCall.getPhoneNumber());
                    continue block9;
                }
            }
            this.getLogger().error(32, "Invalid call ID received");
        }
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
        this.getCarPlayService().removeCarPlayServiceListener(this, CAR_PLAY_LISTENER_IDS);
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
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
    public void updateCarPlayData(CarPlayService carPlayService, int n) {
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
        MAX_NUMBER_OF_CALLS = 7;
        CAR_PLAY_LISTENER_IDS = new int[]{1126105216};
    }
}

