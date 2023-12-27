/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.navsd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.functions.MethodListener;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationService;
import de.vw.mib.bap.mqbab2.common.api.navigation.NavigationServiceListener;
import de.vw.mib.bap.mqbab2.common.api.sound.SoundService;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.navsd.serializer.RepeatLastNavAnnouncement_Result;
import de.vw.mib.bap.mqbab2.navsd.api.ASLNavSDConstants;

public final class RepeatLastNavAnnouncement
extends Function
implements Method,
ASLNavSDConstants,
NavigationServiceListener {
    private int currentActionStatus = 0;
    private static final int ACTION_STATUS_IDLE;
    private static final int ACTION_STATUS_ACTIVE;
    protected static final int[] NAVIGATION_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$RepeatLastNavAnnouncement_Result;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getNavigationService().addNavigationServiceListener(this, NAVIGATION_LISTENER_IDS);
        return null;
    }

    protected RepeatLastNavAnnouncement_Result dequeueBAPEntity() {
        return (RepeatLastNavAnnouncement_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$RepeatLastNavAnnouncement_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$RepeatLastNavAnnouncement_Result = RepeatLastNavAnnouncement.class$("de.vw.mib.bap.mqbab2.generated.navsd.serializer.RepeatLastNavAnnouncement_Result")) : class$de$vw$mib$bap$mqbab2$generated$navsd$serializer$RepeatLastNavAnnouncement_Result);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 35;
    }

    @Override
    public void process(int n) {
        if (this.currentActionStatus == 1 && this.getNavigationService().getGuidanceAnnouncementActive() == 1) {
            this.sendResult(0);
            this.currentActionStatus = 0;
        }
    }

    @Override
    public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
        if (this.currentActionStatus == 1) {
            this.getNavigationService().stopCurrentNavAnnouncement();
            this.sendResult(methodListener, 2);
            this.currentActionStatus = 0;
        } else {
            methodListener.requestError(80, this);
        }
    }

    @Override
    public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
        NavigationService navigationService = this.getNavigationService();
        SoundService soundService = this.getSoundService();
        if (navigationService.getRouteGuidanceState() == 1 && this.currentActionStatus == 0 && soundService.getVolumeNavi() > soundService.getVolumeNaviMinPopup()) {
            if (navigationService.getGuidanceAnnouncementActive() == 1) {
                this.sendResult(0);
            } else {
                navigationService.repeatLastNavAnnouncement();
                this.currentActionStatus = 1;
            }
        } else {
            this.sendResult(1);
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
        this.currentActionStatus = 0;
    }

    @Override
    public void uninitialize() {
        this.getNavigationService().removeNavigationServiceListener(this, NAVIGATION_LISTENER_IDS);
    }

    private void sendResult(int n) {
        RepeatLastNavAnnouncement_Result repeatLastNavAnnouncement_Result = this.dequeueBAPEntity();
        repeatLastNavAnnouncement_Result.repeatLna_Result = n;
        this.getDelegate().getMethodListener(this).result(repeatLastNavAnnouncement_Result, this);
    }

    private void sendResult(MethodListener methodListener, int n) {
        RepeatLastNavAnnouncement_Result repeatLastNavAnnouncement_Result = this.dequeueBAPEntity();
        repeatLastNavAnnouncement_Result.repeatLna_Result = n;
        methodListener.result(repeatLastNavAnnouncement_Result, this);
    }

    @Override
    public void processHMIEvent(int n) {
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
        NAVIGATION_LISTENER_IDS = new int[]{732, 730};
    }
}

