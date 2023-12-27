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
import de.vw.mib.bap.mqbab2.common.api.addressbook.datatypes.iterator.elements.AddressbookNavBookElement;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationService;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationServiceListener;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.iterator.elements.NavigationFavoriteDestinationElement;
import de.vw.mib.bap.mqbab2.common.api.navigation.datatypes.iterator.elements.NavigationLastDestinationElement;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListComplete;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.RG_ActDeact_Result;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.RG_ActDeact_StartResult;
import de.vw.mib.bap.mqbab2.navsd.api.ASLNavSDConstants;
import java.util.Iterator;

public final class RGActDeact
extends Function
implements TimerNotifier,
Method,
ASLNavSDConstants,
NavigationServiceListener {
    private static final int ACTION_STATUS_NO_ACTION;
    private static final int ACTION_STATUS_ABORTING;
    private static final int ACTION_STATUS_BEEING_STARTING;
    private static final int ACTION_STATUS_STARTING;
    int currentActionState = 0;
    private static final int INVALID_NUMBER;
    private static final int NUMBER_NOT_SET;
    private static final int POS_OFFSET;
    private FsgArrayListComplete fullLastDestList = null;
    private boolean currentAlternativeRouteCalcSetting = false;
    private Timer timer = null;
    private static final int TIMER_UPDATE_TIME;
    private static final int TIMER_ACTION_TIME_OUT_ACTION_FAILED;
    protected static final int[] NAVIGATION_LISTENER_IDS;
    protected static final int[] NAVIGATION_LISTENER_HMI_EVENT_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$RG_ActDeact_Result;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getNavigationService().addNavigationServiceListener(this, NAVIGATION_LISTENER_IDS);
        this.getNavigationService().addHMIEventListener(this, NAVIGATION_LISTENER_HMI_EVENT_IDS);
        this.timer = this.getTimerService().createTimer(this, -1059847936);
        return null;
    }

    protected RG_ActDeact_Result dequeueBAPEntity() {
        return (RG_ActDeact_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$RG_ActDeact_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$RG_ActDeact_Result = RGActDeact.class$("de.vw.mib.bap.mqbab2.generated.navsd.serializer.RG_ActDeact_Result")) : class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$RG_ActDeact_Result);
    }

    protected void setActionStateRunning(Boolean bl) {
        int[] nArray = new int[]{17};
        this.context.updateStages(this, nArray, bl);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        switch (bAPStage.getFunctionId()) {
            case 29: {
                this.setFullLastDestList((FsgArrayListComplete)object);
                break;
            }
        }
    }

    @Override
    public int getFunctionId() {
        return 34;
    }

    @Override
    public void process(int n) {
        this.checkCurrentRGStatusActive(this.getNavigationService().getRouteGuidanceState() == 1);
    }

    @Override
    public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
        if (this.currentActionState == 3 || this.currentActionState == 2) {
            this.getNavigationService().stopRouteGuidance();
            this.sendResult(methodListener, 2);
        } else {
            methodListener.requestError(80, this);
        }
        this.setCurrentActionState(0);
    }

    @Override
    public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
        int n;
        int n2 = 0;
        if (this.currentActionState != 0) {
            n = 1;
        } else {
            RG_ActDeact_StartResult rG_ActDeact_StartResult = (RG_ActDeact_StartResult)bAPEntity;
            switch (rG_ActDeact_StartResult.controlType) {
                case 1: {
                    n = this.stopRouteGuidance();
                    if (n != 0) break;
                    this.setCurrentActionState(1);
                    break;
                }
                case 0: {
                    long l;
                    int n3;
                    int n4 = 6;
                    switch (rG_ActDeact_StartResult.ci_Type) {
                        case 1: {
                            n3 = 2;
                            l = this.findLastDestIdFromPos(rG_ActDeact_StartResult.controlInformation);
                            break;
                        }
                        case 2: {
                            n3 = 3;
                            l = this.findFavoriteDestIdFormPos(rG_ActDeact_StartResult.controlInformation);
                            break;
                        }
                        case 3: {
                            n3 = -1;
                            l = -1L;
                            break;
                        }
                        case 4: {
                            n3 = 0;
                            l = 0L;
                            break;
                        }
                        case 5: {
                            n3 = 1;
                            l = this.findNavBookIdFromPos(rG_ActDeact_StartResult.controlInformation);
                            break;
                        }
                        case 0: {
                            n3 = -1;
                            l = -1L;
                            break;
                        }
                        default: {
                            methodListener.requestError(65, this);
                            return;
                        }
                    }
                    if (l != -1L) {
                        n = this.startRouteGuidance(n3, l);
                        if (n != 0) break;
                        this.setCurrentActionState(2);
                        break;
                    }
                    n = n4;
                    n2 = 65;
                    break;
                }
                default: {
                    n = 0;
                    n2 = 65;
                }
            }
        }
        if (n != 0) {
            this.sendResult(n);
        } else if (n2 != 0) {
            methodListener.requestError(n2, this);
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
        this.currentActionState = 0;
    }

    @Override
    public void uninitialize() {
        this.timer.stop();
        this.getNavigationService().removeNavigationServiceListener(this, NAVIGATION_LISTENER_IDS);
        this.getNavigationService().removeHMIEventListener(this, NAVIGATION_LISTENER_HMI_EVENT_IDS);
    }

    private int startRouteGuidance(int n, long l) {
        int n2;
        NavigationService navigationService = this.getNavigationService();
        block0 : switch (navigationService.getRouteGuidanceState()) {
            case 0: {
                switch (navigationService.getNavigationStatus()) {
                    case 1: 
                    case 2: {
                        n2 = 1;
                        break block0;
                    }
                }
                this.storeAlternativeRouteSetting();
                navigationService.startRouteGuidance(n, l);
                n2 = 0;
                this.timer.retrigger(new Integer(0));
                break;
            }
            case 1: 
            case 2: {
                n2 = 5;
                break;
            }
            default: {
                n2 = 1;
            }
        }
        return n2;
    }

    private int stopRouteGuidance() {
        int n;
        NavigationService navigationService = this.getNavigationService();
        switch (navigationService.getRouteGuidanceState()) {
            case 0: {
                n = 4;
                break;
            }
            case 1: 
            case 2: {
                navigationService.stopRouteGuidance();
                n = 0;
                this.timer.retrigger(new Integer(0));
                break;
            }
            default: {
                n = 1;
            }
        }
        return n;
    }

    private void sendResult(int n) {
        RG_ActDeact_Result rG_ActDeact_Result = this.dequeueBAPEntity();
        rG_ActDeact_Result.rg_ActDeact_Result = n;
        this.getDelegate().getMethodListener(this).result(rG_ActDeact_Result, this);
        this.restoreAlternativeRouteSetting();
    }

    private void sendResult(MethodListener methodListener, int n) {
        RG_ActDeact_Result rG_ActDeact_Result = this.dequeueBAPEntity();
        rG_ActDeact_Result.rg_ActDeact_Result = n;
        methodListener.result(rG_ActDeact_Result, this);
        this.restoreAlternativeRouteSetting();
    }

    private void setCurrentActionState(int n) {
        this.currentActionState = n;
        switch (n) {
            case 1: {
                this.setActionStateRunning(Boolean.FALSE);
                break;
            }
            case 3: {
                this.setActionStateRunning(Boolean.TRUE);
                break;
            }
            default: {
                this.setActionStateRunning(null);
            }
        }
    }

    private long findLastDestIdFromPos(int n) {
        Iterator iterator;
        NavigationService navigationService = this.getNavigationService();
        int n2 = (int)this.fullLastDestList.getInternalUserId(n);
        long l = n2 < 0 || n2 >= navigationService.getNumberOfElementsInLastDestinations() ? -1L : ((iterator = navigationService.getWindowedLastDestinations(new int[]{n2})).hasNext() ? ((NavigationLastDestinationElement)iterator.next()).getContactEntryId() : -1L);
        return l;
    }

    private long findFavoriteDestIdFormPos(int n) {
        Iterator iterator = this.getNavigationService().getWindowedCachedFavoriteDestinations(new int[]{n - 1});
        if (iterator.hasNext()) {
            return ((NavigationFavoriteDestinationElement)iterator.next()).getContactEntryId();
        }
        return -1L;
    }

    private long findNavBookIdFromPos(int n) {
        Iterator iterator = this.getAddressbookService().getWindowedCachedNavBook(new int[]{n - 1});
        if (iterator.hasNext()) {
            return ((AddressbookNavBookElement)iterator.next()).getEntryId();
        }
        return -1L;
    }

    @Override
    public void timerFired(Timer timer) {
        if (this.currentActionState != 0) {
            this.setCurrentActionState(0);
            this.sendResult(1);
        }
    }

    private void storeAlternativeRouteSetting() {
        NavigationService navigationService = this.getNavigationService();
        this.currentAlternativeRouteCalcSetting = navigationService.getSuggestAlternativeRouteCalculation();
        if (this.currentAlternativeRouteCalcSetting) {
            navigationService.setAlternativeRouteCalcSetting(false);
        }
    }

    private void restoreAlternativeRouteSetting() {
        if (this.currentAlternativeRouteCalcSetting) {
            this.getNavigationService().setAlternativeRouteCalcSetting(true);
            this.currentAlternativeRouteCalcSetting = false;
        }
    }

    private void checkCurrentRGStatusActive(boolean bl) {
        switch (this.currentActionState) {
            case 1: {
                if (bl) break;
                this.sendResult(0);
                this.setCurrentActionState(0);
                break;
            }
            case 2: 
            case 3: {
                if (this.getNavigationService().getNavigationStatus() != 0) {
                    this.sendResult(1);
                    this.setCurrentActionState(0);
                    break;
                }
                if (!bl) break;
                this.sendResult(0);
                this.setCurrentActionState(0);
                break;
            }
        }
    }

    protected void setFullLastDestList(FsgArrayListComplete fsgArrayListComplete) {
        this.fullLastDestList = fsgArrayListComplete;
    }

    protected void navigationBapRGNotSuccessful() {
        switch (this.currentActionState) {
            case 3: {
                this.sendResult(1);
                this.setCurrentActionState(0);
                break;
            }
            case 2: {
                this.sendResult(7);
                this.setCurrentActionState(0);
                break;
            }
        }
    }

    protected void navigationBapRgErrorHomeAddressNotSpecified() {
        switch (this.currentActionState) {
            case 2: 
            case 3: {
                this.sendResult(8);
                this.setCurrentActionState(0);
                break;
            }
        }
    }

    protected void navigationBapRgStarting() {
        switch (this.currentActionState) {
            case 1: {
                this.sendResult(1);
                this.setCurrentActionState(0);
                break;
            }
            case 2: {
                this.setCurrentActionState(3);
                break;
            }
        }
    }

    @Override
    public void processHMIEvent(int n) {
        switch (n) {
            case 75: {
                this.navigationBapRGNotSuccessful();
                break;
            }
            case 74: {
                this.navigationBapRgErrorHomeAddressNotSpecified();
                break;
            }
            case 76: {
                this.navigationBapRgStarting();
                break;
            }
        }
    }

    @Override
    public void updateNavigationData(NavigationService navigationService, int n) {
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
        NAVIGATION_LISTENER_IDS = new int[]{732, 737, 733};
        NAVIGATION_LISTENER_HMI_EVENT_IDS = new int[]{75, 74, 76};
    }
}

