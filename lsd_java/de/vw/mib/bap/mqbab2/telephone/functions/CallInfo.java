/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.telephone.functions;

import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.datatypes.BAPString;
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
import de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallInfo_Status;
import de.vw.mib.bap.mqbab2.telephone.api.ASLTelephoneConstants;
import de.vw.mib.collections.ints.IntArrayList;
import java.util.Iterator;

public class CallInfo
extends Function
implements TimerNotifier,
Property,
ASLTelephoneConstants,
PhoneServiceListener {
    private static final int CALL_ID_DUMMY;
    private static final int CALL_ID_ONE;
    private static final int CALL_ID_TWO;
    private static final int CALL_ID_THREE;
    private static final int CALL_ID_FOUR;
    private static final int CALL_ID_FIVE;
    private static final int CALL_ID_SIX;
    private static final int CALL_ID_SEVEN;
    private static final int CALL_ID_CONFERENCE;
    private static final int CALL_ID_INVALID;
    private CallInfo_Status lastCallInfoStatus = null;
    private final IntArrayList disconnectedCallIDs = new IntArrayList();
    private Timer updateCallInfoTimer = null;
    private static final int TIMER_CLEAR_OLD_INFO_TIME;
    protected static final int[] PHONE_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallInfo_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getPhoneService().addPhoneServiceListener(this, PHONE_LISTENER_IDS);
        this.updateCallInfoTimer = this.getTimerService().createTimer(this, 2000);
        this.lastCallInfoStatus = new CallInfo_Status();
        return this.lastCallInfoStatus;
    }

    protected CallInfo_Status dequeueBAPEntity() {
        return (CallInfo_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallInfo_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallInfo_Status = CallInfo.class$("de.vw.mib.bap.mqbab2.generated.telephone.serializer.CallInfo_Status")) : class$de$vw$mib$bap$mqbab2$generated$telephone$serializer$CallInfo_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 23;
    }

    private int mapToBAPNumberType(int n) {
        int n2;
        if (n != -1) {
            int n3 = 4896;
            int n4 = n & 0xFFFFECDF;
            switch (n4) {
                case 8: 
                case 2112: {
                    n2 = 0;
                    break;
                }
                case 4: {
                    n2 = 4;
                    break;
                }
                case 64: 
                case 72: {
                    n2 = 2;
                    break;
                }
                case 10: 
                case 2050: {
                    n2 = 3;
                    break;
                }
                case 2: {
                    n2 = 3;
                    break;
                }
                case 16: {
                    n2 = 5;
                    break;
                }
                case 128: {
                    n2 = 6;
                    break;
                }
                case 1024: {
                    n2 = 7;
                    break;
                }
                case 12: 
                case 2052: {
                    n2 = 4;
                    break;
                }
                case 66: {
                    n2 = 0;
                    break;
                }
                case 68: {
                    n2 = 0;
                    break;
                }
                case 20: {
                    n2 = 14;
                    break;
                }
                case 18: {
                    n2 = 13;
                    break;
                }
                default: {
                    if ((n4 & 2) != 0) {
                        n2 = 3;
                        break;
                    }
                    if ((n4 & 4) != 0) {
                        n2 = 4;
                        break;
                    }
                    if ((n4 & 0x40) != 0) {
                        n2 = 2;
                        break;
                    }
                    n2 = 0;
                    break;
                }
            }
        } else {
            n2 = 0;
        }
        return n2;
    }

    private int fillSingleCallInfo(CallInfo_Status callInfo_Status, String string, String string2, int n, int n2, int n3) {
        int n4 = -1;
        int n5 = this.mapToBAPNumberType(n);
        boolean bl = n3 == 6;
        String string3 = string;
        boolean bl2 = !(string3 != null && string3.length() != 0 || string2 != null && string2.length() != 0 || !bl);
        BAPString bAPString = null;
        switch (n2) {
            case 1: {
                callInfo_Status.category0 = n5;
                if (bl2) {
                    callInfo_Status.pbName0.setContent(this.lastCallInfoStatus.pbName0);
                    callInfo_Status.telNumber0.setContent(this.lastCallInfoStatus.telNumber0);
                    break;
                }
                callInfo_Status.pbName0.setContent(string3);
                callInfo_Status.telNumber0.setContent(string2);
                bAPString = callInfo_Status.pbName0;
                break;
            }
            case 2: {
                callInfo_Status.category1 = n5;
                if (bl2) {
                    callInfo_Status.pbName1.setContent(this.lastCallInfoStatus.pbName1);
                    callInfo_Status.telNumber1.setContent(this.lastCallInfoStatus.telNumber1);
                    break;
                }
                callInfo_Status.pbName1.setContent(string3);
                callInfo_Status.telNumber1.setContent(string2);
                bAPString = callInfo_Status.pbName1;
                break;
            }
            case 3: {
                callInfo_Status.category2 = n5;
                if (bl2) {
                    callInfo_Status.pbName2.setContent(this.lastCallInfoStatus.pbName2);
                    callInfo_Status.telNumber2.setContent(this.lastCallInfoStatus.telNumber2);
                    break;
                }
                callInfo_Status.pbName2.setContent(string3);
                callInfo_Status.telNumber2.setContent(string2);
                bAPString = callInfo_Status.pbName2;
                break;
            }
            case 4: {
                callInfo_Status.category3 = n5;
                if (bl2) {
                    callInfo_Status.pbName3.setContent(this.lastCallInfoStatus.pbName3);
                    callInfo_Status.telNumber3.setContent(this.lastCallInfoStatus.telNumber3);
                    break;
                }
                callInfo_Status.pbName3.setContent(string3);
                callInfo_Status.telNumber3.setContent(string2);
                bAPString = callInfo_Status.pbName3;
                break;
            }
            case 5: {
                callInfo_Status.category4 = n5;
                if (bl2) {
                    callInfo_Status.pbName4.setContent(this.lastCallInfoStatus.pbName4);
                    callInfo_Status.telNumber4.setContent(this.lastCallInfoStatus.telNumber4);
                    break;
                }
                callInfo_Status.pbName4.setContent(string3);
                callInfo_Status.telNumber4.setContent(string2);
                bAPString = callInfo_Status.pbName4;
                break;
            }
            case 6: {
                callInfo_Status.category5 = n5;
                if (bl2) {
                    callInfo_Status.pbName5.setContent(this.lastCallInfoStatus.pbName5);
                    callInfo_Status.telNumber5.setContent(this.lastCallInfoStatus.telNumber5);
                    break;
                }
                callInfo_Status.pbName5.setContent(string3);
                callInfo_Status.telNumber5.setContent(string2);
                bAPString = callInfo_Status.pbName5;
                break;
            }
            case 7: {
                callInfo_Status.category6 = n5;
                if (bl2) {
                    callInfo_Status.pbName6.setContent(this.lastCallInfoStatus.pbName6);
                    callInfo_Status.telNumber6.setContent(this.lastCallInfoStatus.telNumber6);
                    break;
                }
                callInfo_Status.pbName6.setContent(string3);
                callInfo_Status.telNumber6.setContent(string2);
                bAPString = callInfo_Status.pbName6;
                break;
            }
            case 254: {
                n4 = n2;
                break;
            }
            case 0: {
                break;
            }
            default: {
                this.getLogger().error(32, "Invalid call ID received");
            }
        }
        if (bAPString != null && (string3 == null || string3.length() == 0)) {
            bAPString.setNullString();
        }
        if (bl && n4 == -1) {
            this.addDisconnectedCallID(n2);
        }
        return n4;
    }

    private int fillCallInfo(CallInfo_Status callInfo_Status) {
        int n = -1;
        Iterator iterator = this.getPhoneService().getCallInformations();
        while (iterator.hasNext()) {
            PhoneCallInformationElement phoneCallInformationElement = (PhoneCallInformationElement)iterator.next();
            int n2 = this.fillSingleCallInfo(callInfo_Status, phoneCallInformationElement.getCallerName(), phoneCallInformationElement.getCallNumber(), phoneCallInformationElement.getCallNumberType(), phoneCallInformationElement.getCallID(), phoneCallInformationElement.getCallState());
            if (n2 == -1) continue;
            n = n2;
        }
        return n;
    }

    private int fillConferenceCallInfo(CallInfo_Status callInfo_Status) {
        int n = -1;
        Iterator iterator = this.getPhoneService().getConferenceCallInformations();
        while (iterator.hasNext()) {
            PhoneConferenceCallInformationsElement phoneConferenceCallInformationsElement = (PhoneConferenceCallInformationsElement)iterator.next();
            int n2 = this.fillSingleCallInfo(callInfo_Status, phoneConferenceCallInformationsElement.getConferenceName(), phoneConferenceCallInformationsElement.getConferenceNumber(), phoneConferenceCallInformationsElement.getConferenceNumberType(), phoneConferenceCallInformationsElement.getConferenceCallId(), phoneConferenceCallInformationsElement.getConferenceCallState());
            if (n2 == -1) continue;
            n = n2;
        }
        return n;
    }

    private void sendCallInformation(CallInfo_Status callInfo_Status) {
        if (this.getDelegate().getPropertyListener(this).statusProperty(callInfo_Status, this)) {
            this.lastCallInfoStatus.category0 = callInfo_Status.category0;
            this.lastCallInfoStatus.category1 = callInfo_Status.category1;
            this.lastCallInfoStatus.category2 = callInfo_Status.category2;
            this.lastCallInfoStatus.category3 = callInfo_Status.category3;
            this.lastCallInfoStatus.category4 = callInfo_Status.category4;
            this.lastCallInfoStatus.category5 = callInfo_Status.category5;
            this.lastCallInfoStatus.category6 = callInfo_Status.category6;
            this.lastCallInfoStatus.pbName0.setContent(callInfo_Status.pbName0);
            this.lastCallInfoStatus.pbName1.setContent(callInfo_Status.pbName1);
            this.lastCallInfoStatus.pbName2.setContent(callInfo_Status.pbName2);
            this.lastCallInfoStatus.pbName3.setContent(callInfo_Status.pbName3);
            this.lastCallInfoStatus.pbName4.setContent(callInfo_Status.pbName4);
            this.lastCallInfoStatus.pbName5.setContent(callInfo_Status.pbName5);
            this.lastCallInfoStatus.pbName6.setContent(callInfo_Status.pbName6);
            this.lastCallInfoStatus.telNumber0.setContent(callInfo_Status.telNumber0);
            this.lastCallInfoStatus.telNumber1.setContent(callInfo_Status.telNumber1);
            this.lastCallInfoStatus.telNumber2.setContent(callInfo_Status.telNumber2);
            this.lastCallInfoStatus.telNumber3.setContent(callInfo_Status.telNumber3);
            this.lastCallInfoStatus.telNumber4.setContent(callInfo_Status.telNumber4);
            this.lastCallInfoStatus.telNumber5.setContent(callInfo_Status.telNumber5);
            this.lastCallInfoStatus.telNumber6.setContent(callInfo_Status.telNumber6);
        }
    }

    protected void computeCallInfo(CallInfo_Status callInfo_Status) {
        this.fillCallInfo(callInfo_Status);
        this.fillConferenceCallInfo(callInfo_Status);
        this.checkDiconnectedCallIDs(callInfo_Status);
    }

    @Override
    public void process(int n) {
        CallInfo_Status callInfo_Status = this.dequeueBAPEntity();
        this.computeCallInfo(callInfo_Status);
        this.sendCallInformation(callInfo_Status);
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
        this.updateCallInfoTimer.stop();
        this.getPhoneService().removePhoneServiceListener(this, PHONE_LISTENER_IDS);
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

    private boolean containsDisconnectedCallID(int n) {
        int n2 = this.disconnectedCallIDs.size();
        boolean bl = false;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (this.disconnectedCallIDs.get(i2) != n) continue;
            bl = true;
            break;
        }
        return bl;
    }

    private void addDisconnectedCallID(int n) {
        if (!this.containsDisconnectedCallID(n)) {
            this.disconnectedCallIDs.add(n);
        }
    }

    private int setLastCallInfoIfNecessary(BAPString bAPString, BAPString bAPString2, int n, BAPString bAPString3, BAPString bAPString4, int n2, int n3) {
        int n4 = n;
        if (bAPString2.isEmptyString() && this.containsDisconnectedCallID(n3)) {
            bAPString.setContent(bAPString3);
            bAPString2.setContent(bAPString4);
            n4 = n2;
            if (!this.updateCallInfoTimer.isRunning()) {
                this.updateCallInfoTimer.retrigger(new Integer(0));
            }
        }
        return n4;
    }

    private void checkDiconnectedCallIDs(CallInfo_Status callInfo_Status) {
        callInfo_Status.category0 = this.setLastCallInfoIfNecessary(callInfo_Status.pbName0, callInfo_Status.telNumber0, callInfo_Status.category0, this.lastCallInfoStatus.pbName0, this.lastCallInfoStatus.telNumber0, this.lastCallInfoStatus.category0, 1);
        callInfo_Status.category1 = this.setLastCallInfoIfNecessary(callInfo_Status.pbName1, callInfo_Status.telNumber1, callInfo_Status.category1, this.lastCallInfoStatus.pbName1, this.lastCallInfoStatus.telNumber1, this.lastCallInfoStatus.category1, 2);
        callInfo_Status.category2 = this.setLastCallInfoIfNecessary(callInfo_Status.pbName2, callInfo_Status.telNumber2, callInfo_Status.category2, this.lastCallInfoStatus.pbName2, this.lastCallInfoStatus.telNumber2, this.lastCallInfoStatus.category2, 3);
        callInfo_Status.category3 = this.setLastCallInfoIfNecessary(callInfo_Status.pbName3, callInfo_Status.telNumber3, callInfo_Status.category3, this.lastCallInfoStatus.pbName3, this.lastCallInfoStatus.telNumber3, this.lastCallInfoStatus.category3, 4);
        callInfo_Status.category4 = this.setLastCallInfoIfNecessary(callInfo_Status.pbName4, callInfo_Status.telNumber4, callInfo_Status.category4, this.lastCallInfoStatus.pbName4, this.lastCallInfoStatus.telNumber4, this.lastCallInfoStatus.category4, 5);
        callInfo_Status.category5 = this.setLastCallInfoIfNecessary(callInfo_Status.pbName5, callInfo_Status.telNumber5, callInfo_Status.category5, this.lastCallInfoStatus.pbName5, this.lastCallInfoStatus.telNumber5, this.lastCallInfoStatus.category5, 6);
        callInfo_Status.category6 = this.setLastCallInfoIfNecessary(callInfo_Status.pbName6, callInfo_Status.telNumber6, callInfo_Status.category6, this.lastCallInfoStatus.pbName6, this.lastCallInfoStatus.telNumber6, this.lastCallInfoStatus.category6, 7);
    }

    @Override
    public void timerFired(Timer timer) {
        this.disconnectedCallIDs.clear();
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
        PHONE_LISTENER_IDS = new int[]{1158, 1160};
    }
}

