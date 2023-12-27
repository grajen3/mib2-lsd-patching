/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.functions;

import de.vw.mib.bap.array.timer.Timer;
import de.vw.mib.bap.array.timer.TimerNotifier;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.functions.MethodListener;
import de.vw.mib.bap.mqbab2.common.api.addressbook.AddressbookService;
import de.vw.mib.bap.mqbab2.common.api.addressbook.AddressbookServiceListener;
import de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.NavBookSpellerResult;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.NbSpeller_Result;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.NbSpeller_StartResult;
import de.vw.mib.bap.mqbab2.navsd.api.ASLNavSDConstants;

public final class NbSpeller
extends Function
implements TimerNotifier,
Method,
ASLNavSDConstants,
AddressbookServiceListener {
    private static final int CURRENT_SPELLER_STATE_IDLE;
    private static final int CURRENT_SPELLER_STATE_IDLE_WAIT_FOR_ACKNOWLEDGE;
    private static final int CURRENT_SPELLER_STATE_IDLE_ABORTING;
    private static final int CURRENT_SPELLER_STATE_RUNNING;
    private static final int CURRENT_SPELLER_STATE_RUNNING_WAIT_FOR_ACKNOWLEDGE;
    private static final int CURRENT_SPELLER_STATE_RUNNING_ABORTING;
    private static final int CURRENT_SPELLER_STATE_RUNNING_STOPPING;
    private int currentSpellerState = 0;
    private String currentSpellerValidChars = "";
    private NbSpeller_StartResult lastStartSpellerRequest = null;
    private Timer aslRequestTimer = null;
    private static final int TIMER_ASL_UPDATE_TIME;
    private static final int TIMER_ASL_ACTION_NOTHING;
    private static final int TIMER_ASL_ACTION_WAIT_START_SPELLER;
    private static final int TIMER_ASL_ACTION_WAIT_MATCH_SPELLER;
    private static final int TIMER_ASL_ACTION_WAIT_STOP_SPELLER;
    private Timer aslKeepSpellerInstanceOpen = null;
    private static final int TIMER_SPELLER_OPEN_TIME;
    private static final int TIMER_SPELLER_ACTION_CLOSE_SPELLER;
    private static final int DIRECTION_FORWARD;
    private static final int DIRECTION_BACKWARD;
    private static final int END_OF_SEARCH_STRING_REACHED;
    protected static final int[] ADDRESSBOOK_LISTENER_HMI_EVENT_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$NbSpeller_Result;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getAddressbookService().addHMIEventListener(this, ADDRESSBOOK_LISTENER_HMI_EVENT_IDS);
        this.aslRequestTimer = this.getTimerService().createTimer(this, 2000);
        this.aslKeepSpellerInstanceOpen = this.getTimerService().createTimer(this, 30000);
        return null;
    }

    protected NbSpeller_Result dequeueBAPEntity() {
        return (NbSpeller_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$NbSpeller_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$NbSpeller_Result = NbSpeller.class$("de.vw.mib.bap.mqbab2.generated.navsd.serializer.NbSpeller_Result")) : class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$NbSpeller_Result);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 42;
    }

    @Override
    public void process(int n) {
    }

    @Override
    public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
        switch (this.currentSpellerState) {
            case 0: 
            case 3: 
            case 6: {
                methodListener.requestError(80, this);
                break;
            }
            case 4: {
                this.lastStartSpellerRequest = null;
                this.currentSpellerState = 5;
                break;
            }
            case 1: {
                this.lastStartSpellerRequest = null;
                this.currentSpellerState = 2;
                break;
            }
            case 2: 
            case 5: {
                break;
            }
            default: {
                this.sendMethodResult(methodListener, 3);
            }
        }
    }

    @Override
    public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
        NbSpeller_StartResult nbSpeller_StartResult = (NbSpeller_StartResult)bAPEntity;
        if (NbSpeller.isStartResultParameterModeMatchInvalid(nbSpeller_StartResult.mode)) {
            methodListener.requestError(65, this);
        } else {
            int n = this.validateStartMethodPreconditions();
            if (n == 0 && (n = this.validateStartResultInputParameters(nbSpeller_StartResult)) == 0) {
                if (this.currentSpellerState == 0) {
                    this.currentSpellerState = 1;
                    this.startSpeller();
                } else {
                    this.currentSpellerState = 4;
                    this.matchString(nbSpeller_StartResult);
                }
                this.lastStartSpellerRequest = nbSpeller_StartResult;
            }
            if (n != 0) {
                this.sendMethodResult(n);
            }
        }
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

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.aslRequestTimer.stop();
        this.aslKeepSpellerInstanceOpen.stop();
        this.getAddressbookService().removeHMIEventListener(this, ADDRESSBOOK_LISTENER_HMI_EVENT_IDS);
    }

    private void sendMethodResult(int n, int n2, int n3) {
        NbSpeller_Result nbSpeller_Result = this.dequeueBAPEntity();
        nbSpeller_Result.nbSpeller_Result = n;
        nbSpeller_Result.matchingEntries = n2;
        nbSpeller_Result.pos = n3;
        this.getDelegate().getMethodListener(this).result(nbSpeller_Result, this);
    }

    private void sendMethodResult(int n) {
        this.sendMethodResult(n, 0, 0);
    }

    private void sendMethodResult(MethodListener methodListener, int n) {
        NbSpeller_Result nbSpeller_Result = this.dequeueBAPEntity();
        nbSpeller_Result.nbSpeller_Result = n;
        methodListener.result(nbSpeller_Result, this);
    }

    private int validateStartMethodPreconditions() {
        int n;
        switch (this.currentSpellerState) {
            case 1: 
            case 2: 
            case 4: 
            case 5: 
            case 6: {
                n = 1;
                break;
            }
            default: {
                n = 0;
            }
        }
        return n;
    }

    private static boolean isStartResultParameterModeMatchInvalid(int n) {
        return n != 0 && n != 1 && n != 2;
    }

    private int validateStartResultInputParameters(NbSpeller_StartResult nbSpeller_StartResult) {
        int n = nbSpeller_StartResult.searchString.isEmptyString() || NbSpeller.isStartResultParameterModeMatchInvalid(nbSpeller_StartResult.mode) ? 1 : 0;
        return n;
    }

    private int searchForNextCharacter(char c2, int n) {
        char c3 = Character.toUpperCase(c2);
        char[] cArray = this.currentSpellerValidChars.toUpperCase().toCharArray();
        int n2 = cArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n3 = c3 - cArray[i2];
            if (n3 >= n || n3 == 0) continue;
            return this.currentSpellerValidChars.charAt(i2);
        }
        return -1;
    }

    private String computeTheCharactersToMatchForRequest(NbSpeller_StartResult nbSpeller_StartResult) {
        String string;
        switch (nbSpeller_StartResult.mode) {
            case 0: {
                string = nbSpeller_StartResult.searchString.toString();
                break;
            }
            case 1: {
                int n = this.searchForNextCharacter(nbSpeller_StartResult.searchString.toString().charAt(0), 1);
                if (n == -1) {
                    this.sendMethodResult(1);
                    this.currentSpellerState = 3;
                    string = "";
                    break;
                }
                char[] cArray = new char[]{(char)n};
                string = new String(cArray);
                break;
            }
            case 2: {
                int n = this.searchForNextCharacter(nbSpeller_StartResult.searchString.toString().charAt(0), -1);
                if (n == -1) {
                    this.sendMethodResult(1);
                    this.currentSpellerState = 3;
                    string = "";
                    break;
                }
                char[] cArray = new char[]{(char)n};
                string = new String(cArray);
                break;
            }
            default: {
                string = "";
            }
        }
        return string;
    }

    private void completeStartSpellerRequest() {
        NavBookSpellerResult navBookSpellerResult = this.getAddressbookService().getNavBookSpellerResult();
        this.sendMethodResult(0, navBookSpellerResult.getNavBookSpellerResultNumberOfEntries(), navBookSpellerResult.getNavBookSpellerResultPositionOfFirstEntry());
        this.lastStartSpellerRequest = null;
    }

    private void matchString(NbSpeller_StartResult nbSpeller_StartResult) {
        String string = this.computeTheCharactersToMatchForRequest(nbSpeller_StartResult);
        if (string.length() != 0) {
            this.getAddressbookService().matchStringWithNavBookSpeller(this.computeTheCharactersToMatchForRequest(nbSpeller_StartResult));
            this.aslRequestTimer.retrigger(new Integer(2));
        }
    }

    private void startSpeller() {
        this.getAddressbookService().startNavBookSpeller();
        this.aslRequestTimer.retrigger(new Integer(1));
        this.aslKeepSpellerInstanceOpen.retrigger(new Integer(129));
    }

    private void stopSpeller() {
        this.getAddressbookService().stopNavBookSpeller();
        this.aslRequestTimer.retrigger(new Integer(3));
    }

    @Override
    public void timerFired(Timer timer) {
        int n = (Integer)timer.getUserInfo();
        block0 : switch (n) {
            case 1: 
            case 2: {
                this.spellerFailure();
                break;
            }
            case 129: {
                switch (this.currentSpellerState) {
                    case 3: {
                        this.currentSpellerState = 6;
                        this.stopSpeller();
                        break block0;
                    }
                    case 1: 
                    case 2: 
                    case 4: 
                    case 5: 
                    case 6: {
                        this.currentSpellerState = 0;
                        break block0;
                    }
                }
                break;
            }
        }
    }

    protected void spellerStopAcknowledge() {
        if (this.aslRequestTimer.isRunning()) {
            this.aslRequestTimer.stop();
        }
        this.lastStartSpellerRequest = null;
        this.currentSpellerValidChars = "";
        this.currentSpellerState = 0;
        this.aslRequestTimer.setUserInfo(new Integer(0));
    }

    protected void spellerResultAcknowledge() {
        switch (this.currentSpellerState) {
            case 2: 
            case 5: {
                this.currentSpellerState = 3;
                this.sendMethodResult(2);
                break;
            }
            case 1: {
                this.currentSpellerValidChars = this.getAddressbookService().getNavBookSpellerResult().getNavBookSpellerResultValidChars();
                this.currentSpellerState = 4;
                this.matchString(this.lastStartSpellerRequest);
                break;
            }
            case 4: {
                this.currentSpellerState = 3;
                this.completeStartSpellerRequest();
                this.aslRequestTimer.setUserInfo(new Integer(0));
                break;
            }
            case 6: {
                break;
            }
            default: {
                this.getLogger().error(16, "Invalid state of NbSpeller");
            }
        }
    }

    protected void spellerFailure() {
        switch (this.currentSpellerState) {
            case 2: 
            case 5: {
                this.sendMethodResult(2);
                this.currentSpellerState = 6;
                this.stopSpeller();
                break;
            }
            case 1: 
            case 4: {
                this.sendMethodResult(1);
                this.currentSpellerState = 6;
                this.stopSpeller();
                break;
            }
            case 3: {
                this.currentSpellerState = 6;
                this.stopSpeller();
                break;
            }
        }
    }

    @Override
    public void processHMIEvent(int n) {
        switch (n) {
            case 70: {
                this.spellerFailure();
                break;
            }
            case 71: {
                this.spellerResultAcknowledge();
                break;
            }
            case 72: {
                this.spellerStopAcknowledge();
                break;
            }
        }
    }

    @Override
    public void updateAddressbookData(AddressbookService addressbookService, int n) {
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
        ADDRESSBOOK_LISTENER_HMI_EVENT_IDS = new int[]{70, 71, 72};
    }
}

