/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.splitscreen.overlays;

import de.vw.mib.asl.api.navigation.util.ASLNavigationUtilFactory;
import de.vw.mib.asl.api.navigation.util.IExtLogger;
import de.vw.mib.asl.api.navigation.util.ReloadPersistedDataListener;
import de.vw.mib.asl.api.navigation.util.factoryreset.FactoryResetParticipantWithCallback;
import de.vw.mib.asl.api.navigation.util.factoryreset.TargetForResetNavigation;
import de.vw.mib.asl.internal.navigation.splitscreen.overlays.OverlaysTargetHSM;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.hsm.AbstractHsmState;
import de.vw.mib.genericevents.hsm.HsmState;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.TurnListElement;

public class OverlaysStateWork
extends AbstractHsmState
implements TargetForResetNavigation,
ReloadPersistedDataListener {
    private int currentOverlayIndex = 0;
    private int[] availableOverlays = new int[3];
    private int availableOverlaysCnt;
    private int useableOverlaysCnt;
    private int currentOverlayIndexModel;
    private final IExtLogger logger = ASLNavigationUtilFactory.getNavigationUtilApi().getExtLogger(16384, "[OverlaysTargetHSM - OverlaysStateWork]");
    private OverlaysTargetHSM target;
    TurnListElement[] currentTurnListElements = null;
    private FactoryResetParticipantWithCallback navigationResetParticipant;
    private boolean isMotorwayInfoDisplayable = false;

    public OverlaysStateWork(OverlaysTargetHSM overlaysTargetHSM, String string, HsmState hsmState) {
        super(overlaysTargetHSM.getHsm(), string, hsmState);
        this.target = overlaysTargetHSM;
    }

    @Override
    public HsmState handle(EventGeneric eventGeneric) {
        this.logger.trace(new StringBuffer("handle: event ID: ").append(eventGeneric.getReceiverEventId()).toString());
        switch (eventGeneric.getReceiverEventId()) {
            case 2: {
                this.handleEntry();
                break;
            }
            case 3: {
                this.handleStart();
                break;
            }
            case 4: {
                this.handleExit();
                break;
            }
            case 100100: {
                this.updateMotorwayInfo(eventGeneric);
                break;
            }
            case 1073742393: {
                if (!this.target.datapool.isRGActive()) break;
                this.handleSetCurrentSplScrContent(eventGeneric);
                break;
            }
            case 1073742394: {
                if (this.target.datapool.isRGActive()) break;
                this.handleSetCurrentSplScrContent(eventGeneric);
                break;
            }
            case 1073742395: {
                if (!this.target.datapool.isRGActive()) break;
                this.logger.trace(new StringBuffer("toggle SplScr: G ").append(eventGeneric.getReceiverEventId()).toString());
                this.handleToggleSplitscreen();
                break;
            }
            case 1073742396: {
                if (this.target.datapool.isRGActive()) break;
                this.logger.trace(new StringBuffer("toggle SplScr: NG ").append(eventGeneric.getReceiverEventId()).toString());
                this.handleToggleSplitscreen();
                break;
            }
            case 1074841833: {
                this.toggleOverlay();
                break;
            }
            case 1074841834: {
                this.handleToggleKanbanOverlay(eventGeneric);
                break;
            }
            case 1074841835: {
                this.handleToggleMotorwayInfo(eventGeneric);
                break;
            }
            case 1074841836: {
                this.handleToggleManeuverDetailView(eventGeneric);
                break;
            }
            default: {
                this.handleDefault(eventGeneric);
                return this.myParent;
            }
        }
        return null;
    }

    private void handleSetCurrentSplScrContent(EventGeneric eventGeneric) {
        this.logger.trace("handleSetCurrentSplScrContent");
        if (!this.isDisplayed(1) && this.isInList(1)) {
            this.logger.trace("Put Splitscreen to foreground displaying selected content.");
            this.currentOverlayIndex = 0;
            this.displaySplitScreen();
        }
    }

    private void toggleOverlay() {
        this.logger.trace("toggleOverlay: ");
        ++this.currentOverlayIndex;
        if (this.currentOverlayIndex >= 3) {
            this.logger.trace("Reset: ");
            this.currentOverlayIndex = this.restoreSplScr() ? 0 : 1;
            this.logger.trace(new StringBuffer("Restart List -- Overlay Index Model: ").append(this.currentOverlayIndexModel).toString());
        }
        switch (this.availableOverlays[this.currentOverlayIndex]) {
            case -10000: {
                if (this.useableOverlaysCnt <= 0) break;
                this.toggleOverlay();
                break;
            }
            case 0: {
                this.displayNonAdditionalInfoContent();
                break;
            }
            case 1: {
                this.displaySplitScreen();
                break;
            }
            case 2: {
                if (this.target.datapool.isManeuverDetailViewActive()) {
                    this.displayKDK();
                    break;
                }
                if (this.useableOverlaysCnt <= 0) break;
                this.toggleOverlay();
                break;
            }
            case 3: {
                if (this.target.datapool.isManeuverDetailViewActive()) {
                    this.displayEVJV();
                    break;
                }
                if (this.useableOverlaysCnt <= 0) break;
                this.toggleOverlay();
                break;
            }
            case 4: {
                if (this.target.datapool.isKanbanActive()) {
                    this.displayCanban();
                    break;
                }
                if (this.useableOverlaysCnt <= 0) break;
                this.toggleOverlay();
                break;
            }
            case 5: {
                if (!this.target.datapool.isMotorwayInfoActive()) break;
                this.logger.trace(new StringBuffer("No RG: ").append(this.currentOverlayIndexModel).append(": MOTORWAY INFO:").toString());
                this.displayMotorwayInfo();
                break;
            }
            default: {
                this.logger.error("No Overlay option recognised -- doing nothing!");
            }
        }
    }

    private void calculateCurrentModelIndex() {
        int n = 0;
        int n2 = 0;
        if (this.useableOverlaysCnt == 0) {
            n = 0;
        } else if (this.useableOverlaysCnt == 1) {
            n = 0;
        } else {
            for (int i2 = 0; i2 <= this.currentOverlayIndex; ++i2) {
                if (this.availableOverlays[i2] == -10000 || !(this.availableOverlays[i2] == 1 || this.availableOverlays[i2] == 2 && this.target.datapool.isManeuverDetailViewActive() || this.availableOverlays[i2] == 3 && this.target.datapool.isManeuverDetailViewActive() || this.availableOverlays[i2] == 4 && this.target.datapool.isKanbanActive()) && (this.availableOverlays[i2] != 5 || !this.target.datapool.isMotorwayInfoActive())) continue;
                ++n2;
            }
            n = n2 - 1;
            if (n < 0) {
                n = 0;
            }
        }
        this.currentOverlayIndexModel = n;
    }

    private boolean isInList(int n) {
        boolean bl = false;
        for (int i2 = 0; i2 < 3; ++i2) {
            if (this.availableOverlays[i2] != n) continue;
            bl = true;
        }
        return bl;
    }

    private boolean isDisplayed(int n) {
        if (this.useableOverlaysCnt == 0) {
            return false;
        }
        return this.availableOverlays[this.currentOverlayIndex] == n;
    }

    private boolean restoreSplScr() {
        return this.availableOverlays[0] == 1;
    }

    private void handleStart() {
        this.logger.trace("handleStart()");
        this.initializeDisplay();
    }

    private void initializeDisplay() {
        this.logger.trace(new StringBuffer("Splitscreen display: ").append(this.target.datapool.isSplitscreenActive()).toString());
        this.logger.trace(new StringBuffer("RG Active: ").append(this.target.datapool.isRGActive()).toString());
        this.resetParamsToZero();
        for (int i2 = 0; i2 < 3; ++i2) {
            this.availableOverlays[i2] = -10000;
        }
        if (this.target.datapool.isSplitscreenActive()) {
            this.availableOverlays[0] = 1;
            ++this.availableOverlaysCnt;
            ++this.useableOverlaysCnt;
            this.displaySplitScreen();
        } else {
            this.displayNonAdditionalInfoContent();
        }
        if (this.target.datapool.isMotorwayInfoActive() && this.isMotorwayInfoDisplayable) {
            this.availableOverlays[1] = 5;
            ++this.availableOverlaysCnt;
            ++this.useableOverlaysCnt;
            this.currentOverlayIndex = 1;
            this.displayMotorwayInfo();
            this.logger.trace("CURRENT_OVERLAY__C5_MOTORWAYINFO");
        }
    }

    private void resetParamsToZero() {
        this.availableOverlaysCnt = 0;
        this.useableOverlaysCnt = 0;
        this.currentOverlayIndex = 0;
    }

    private void handleToggleSplitscreen() {
        this.logger.trace("handleToggleSplitscreen()");
        boolean bl = this.target.datapool.isSplitscreenActive();
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("Setting Splitscreen to: ").append(bl).log();
        }
        if (this.isDisplayed(1)) {
            --this.availableOverlaysCnt;
            this.availableOverlays[0] = -10000;
            this.handleSetupToggleCommon();
        } else if (this.isInList(1)) {
            --this.useableOverlaysCnt;
            --this.availableOverlaysCnt;
            this.availableOverlays[0] = -10000;
            this.updateModelDisplay();
        } else {
            ++this.useableOverlaysCnt;
            ++this.availableOverlaysCnt;
            this.availableOverlays[0] = 1;
            this.currentOverlayIndex = 0;
            this.displaySplitScreen();
        }
    }

    private void handleToggleKanbanOverlay(EventGeneric eventGeneric) {
        boolean bl;
        this.logger.trace("handleToggleKanbanOverlay()");
        boolean bl2 = bl = !this.target.datapool.isKanbanActive();
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("Setting Kanban to: ").append(bl).log();
        }
        this.target.datapool.setKanban(bl);
        this.target.notifierModel.notifyKanbanActiveChanged(eventGeneric.getBoolean(0));
        if (this.isDisplayed(4)) {
            this.handleSetupToggleCommon();
        } else if (this.isInList(4)) {
            if (bl) {
                ++this.useableOverlaysCnt;
                this.currentOverlayIndex = 1;
                this.displayCanban();
            } else {
                --this.useableOverlaysCnt;
                this.updateModelDisplay();
            }
        } else {
            this.logger.trace("handleToggleKanbanOverlay() -- Not in list, doing nothing");
            this.traceCurrentOverlayStatus();
        }
    }

    private void handleToggleManeuverDetailView(EventGeneric eventGeneric) {
        boolean bl;
        this.logger.trace("handleToggleManeuverDetailView()");
        boolean bl2 = bl = !this.target.datapool.isManeuverDetailViewActive();
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("Setting Maneuver Detail View to: ").append(bl).log();
        }
        this.target.datapool.setManeuverDetailView(bl);
        this.target.notifierModel.notifyManeuverDetailViewActiveChanged(eventGeneric.getBoolean(0));
        if (this.isDisplayed(2) || this.isDisplayed(3)) {
            this.handleSetupToggleCommon();
            if (!this.restoreSplScr()) {
                this.specialHide();
            }
        } else if (this.isInList(2) || this.isInList(3)) {
            this.logger.trace("KDK -- in list");
            if (bl) {
                ++this.useableOverlaysCnt;
                this.currentOverlayIndex = this.restoreSplScr() ? this.availableOverlaysCnt - 1 : this.availableOverlaysCnt;
                if (this.isInList(2)) {
                    this.displayKDK();
                } else {
                    this.displayEVJV();
                }
            } else {
                --this.useableOverlaysCnt;
                this.updateModelDisplay();
            }
        } else {
            this.logger.trace("handleToggleManeuverDetailView() -- Not in list, doing nothing");
            this.traceCurrentOverlayStatus();
        }
    }

    private void handleToggleMotorwayInfo(EventGeneric eventGeneric) {
        boolean bl;
        this.logger.trace("handleToggleMotorwayInfo()");
        boolean bl2 = bl = !this.target.datapool.isMotorwayInfoActive();
        if (this.logger.isTraceEnabled()) {
            this.logger.makeTrace().append("Setting Motorway Info to: ").append(bl).log();
        }
        this.target.datapool.setMotorwayInfoActive(bl);
        this.target.notifierModel.notifyMotorwayInfoActiveChanged(eventGeneric.getBoolean(0));
        this.target.notifierDSI.enableRgMotorwayInfo(bl);
        if (this.isDisplayed(5)) {
            this.handleSetupToggleCommon();
        } else if (this.isInList(5)) {
            if (bl) {
                ++this.useableOverlaysCnt;
                this.currentOverlayIndex = 1;
                this.displayMotorwayInfo();
            } else {
                --this.useableOverlaysCnt;
                this.updateModelDisplay();
            }
        } else {
            this.logger.trace("handleToggleMotorwayInfo() -- Not in list, doing nothing");
            this.traceCurrentOverlayStatus();
        }
    }

    private void handleSetupToggleCommon() {
        --this.useableOverlaysCnt;
        if (this.useableOverlaysCnt > 0) {
            this.toggleOverlay();
        } else {
            this.displayNonAdditionalInfoContent();
        }
    }

    private void handleDefault(EventGeneric eventGeneric) {
        if (this.target.isTraceEnabled()) {
            this.logger.makeTrace().append("handleDefault(): receiverEventId: ").append(eventGeneric.getReceiverEventId()).append(", Params: ").append(eventGeneric.getParamString()).log();
        }
    }

    private void handleEntry() {
        this.logger.trace("handleEntry()");
        if (this.navigationResetParticipant == null) {
            this.navigationResetParticipant = ASLNavigationUtilFactory.getNavigationUtilApi().createFactoryResetParticipantForNavigationDomainAndAddToService(this);
        }
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().addReloadPersistedDataListener(this);
    }

    private void handleExit() {
        this.logger.trace("handleExit()");
        if (this.navigationResetParticipant != null) {
            ASLNavigationUtilFactory.getNavigationUtilApi().removeNavigationResetParticipantFromService(this.navigationResetParticipant);
            this.navigationResetParticipant = null;
        }
        ASLNavigationUtilFactory.getNavigationUtilApi().getNavigationDp().removeReloadPersistedDataListener(this);
    }

    private void updateMotorwayInfo(EventGeneric eventGeneric) {
        this.logger.trace("dsiNavigationUpdateRgMotorwayInfo");
        boolean bl = this.isDisplayed(2) || this.isDisplayed(3) || this.isDisplayed(4);
        boolean bl2 = this.isInList(2) || this.isInList(3) || this.isInList(4);
        int n = eventGeneric.getInt(0);
        if (n == 1) {
            if (!this.isInList(5)) {
                this.logger.trace("dsiNavigationUpdateRgMotorwayInfo: NOT EMPTY AND NOT IN LIST");
                this.isMotorwayInfoDisplayable = true;
                if (this.availableOverlays[1] == 3) {
                    this.availableOverlays[2] = 3;
                }
                this.availableOverlays[1] = 5;
                this.currentOverlayIndex = 1;
                if (!bl && !bl2) {
                    int n2;
                    this.availableOverlaysCnt = n2 = this.restoreSplScr() ? 2 : 1;
                    this.useableOverlaysCnt = n2;
                    this.displayMotorwayInfo();
                } else {
                    int n3;
                    this.availableOverlaysCnt = n3 = this.restoreSplScr() ? 3 : 2;
                    this.useableOverlaysCnt = n3;
                    this.toggleOverlay();
                }
                this.updateModelDisplayCommon();
            }
        } else {
            this.isMotorwayInfoDisplayable = false;
            this.logger.trace("dsiNavigationUpdateRgMotorwayInfo: EMPTY LIST");
            if (!bl && !bl2) {
                int n4;
                this.availableOverlays[1] = -10000;
                this.availableOverlaysCnt = n4 = this.restoreSplScr() ? 1 : 0;
                this.useableOverlaysCnt = n4;
                this.currentOverlayIndex = 0;
                if (this.restoreSplScr()) {
                    this.displaySplitScreen();
                } else {
                    this.displayNonAdditionalInfoContent();
                }
            } else {
                int n5;
                this.availableOverlays[1] = this.availableOverlays[2];
                this.availableOverlays[2] = -10000;
                this.availableOverlaysCnt = n5 = this.restoreSplScr() ? 2 : 1;
                this.useableOverlaysCnt = n5;
                this.currentOverlayIndex = 0;
                this.toggleOverlay();
                this.updateModelDisplayCommon();
            }
        }
    }

    private void updateModelDisplay() {
        this.logger.trace("updateModelDisplay()");
        this.updateModelDisplayCommon();
        this.target.overlaysTurnListHandler.notifyOverlayDisplayed(this.availableOverlays[this.currentOverlayIndex]);
        this.target.notifierModel.notifyOverlayDisplayed(this.availableOverlays[this.currentOverlayIndex]);
        this.target.notifierOverlaysInternalAPI.notifyOverlayContentUpdate(this.availableOverlays[this.currentOverlayIndex]);
        this.target.notifierModel.notifyHeadlineIconVisibility(this.target.datapool.isRGActive() && this.availableOverlays[this.currentOverlayIndex] == 3);
        this.traceCurrentOverlayStatus();
    }

    private void updateModelDisplay(int n) {
        this.logger.trace("updateModelDisplay( activeASLView )");
        this.updateModelDisplayCommon();
        this.target.overlaysTurnListHandler.notifyOverlayDisplayed(n);
        this.target.notifierModel.notifyOverlayDisplayed(n);
        this.target.notifierOverlaysInternalAPI.notifyOverlayContentUpdate(n);
        this.target.notifierModel.notifyHeadlineIconVisibility(this.target.datapool.isRGActive() && n == 3);
        this.traceCurrentOverlayStatus();
    }

    private void updateModelDisplayCommon() {
        this.target.notifierModel.notifyOverlayCountChanged(this.useableOverlaysCnt);
        this.target.notifierOverlaysInternalAPI.notifyOverlayCountUpdate(this.useableOverlaysCnt);
        this.calculateCurrentModelIndex();
        this.target.notifierModel.notifyOverlayIndexChanged(this.currentOverlayIndexModel);
        this.target.notifierOverlaysInternalAPI.notifyOverlayIndexUpdate(this.currentOverlayIndexModel);
    }

    private void traceCurrentOverlayStatus() {
        this.logger.trace("traceCurrentOverlayStatus():");
        this.logger.trace(new StringBuffer("Overlay Count (model): ").append(this.useableOverlaysCnt).toString());
        this.logger.trace(new StringBuffer("Overlay Index (model): ").append(this.currentOverlayIndexModel).toString());
        this.logger.trace(new StringBuffer("Overlay Count (asl): ").append(this.availableOverlaysCnt).toString());
        this.logger.trace(new StringBuffer("Overlay Index (asl): ").append(this.currentOverlayIndex).toString());
        this.logger.trace(new StringBuffer("Overlay Displayed: ").append(this.availableOverlays[this.currentOverlayIndex]).toString());
    }

    private void displayEnd() {
        this.logger.trace("displayEnd");
        this.target.notifierDSI.hideManoeuvreView();
        this.initializeDisplay();
    }

    private void displayNonAdditionalInfoContent() {
        this.logger.trace("displayNonAdditionalInfoContent");
        this.updateModelDisplay(0);
    }

    private void displaySplitScreen() {
        this.logger.trace("displaySplitScreen");
        this.updateModelDisplay();
    }

    private void displayKDK() {
        this.logger.trace("displayKDK");
        this.target.notifierDSI.selectManoeuvreView(3, true);
        this.updateModelDisplay();
    }

    private void displayEVJV() {
        this.logger.trace("displayEVJV");
        this.target.notifierDSI.selectManoeuvreView(4, true);
        this.updateModelDisplay();
    }

    private void displayCanban() {
        this.logger.trace("displayCanban");
        this.target.notifierDSI.selectManoeuvreView(6, true);
        this.updateModelDisplay();
    }

    private void displayMotorwayInfo() {
        this.logger.trace("displayMotorwayInfo");
        this.updateModelDisplay();
    }

    public void dsiMapViewerManeuverViewUpdateManoeuvreViewsAvailable(short[] sArray, int n) {
        this.logger.trace("dsiMapViewerManeuverViewUpdateManeuverViewsAvailable");
        if (this.target.datapool.isMapExternalConfigured()) {
            this.logger.trace("dsiMapViewerManeuverViewUpdateManeuverViewsAvailable ignored because map is external configured");
            return;
        }
        if (sArray != null && sArray.length > 0 && n == 1) {
            this.availableOverlaysCnt = 0;
            this.useableOverlaysCnt = 0;
            int n2 = 1;
            for (int i2 = 0; i2 < 3; ++i2) {
                this.availableOverlays[i2] = -10000;
            }
            if (this.target.datapool.isSplitscreenActive()) {
                this.availableOverlays[0] = 1;
                ++this.availableOverlaysCnt;
                ++this.useableOverlaysCnt;
                this.currentOverlayIndex = 0;
                this.logger.trace("CURRENT_OVERLAY__C1_SPLITSCREEN");
            }
            if (this.target.datapool.isMotorwayInfoActive() && this.isMotorwayInfoDisplayable) {
                this.availableOverlays[1] = 5;
                ++this.availableOverlaysCnt;
                ++this.useableOverlaysCnt;
                this.currentOverlayIndex = 1;
                ++n2;
                this.logger.trace("CURRENT_OVERLAY__C5_MOTORWAYINFO");
            }
            if (sArray.length == 1) {
                this.processAvailableManoeuvreViews(sArray[0], n2, sArray.length);
            } else if (sArray.length > 1) {
                this.processAvailableManoeuvreViews(sArray);
            }
        }
    }

    private void processAvailableManoeuvreViews(short[] sArray) {
        this.logger.trace("processAvailableManoeuvreViews -- sorting...");
        if (sArray.length <= 2) {
            int n;
            int n2 = -1;
            for (n = 0; n < sArray.length; ++n) {
                if (sArray[n] != 6) continue;
                n2 = n;
            }
            if (n2 != -1) {
                this.processAvailableManoeuvreViews(sArray[n2], 1, sArray.length);
                for (n = 0; n < sArray.length; ++n) {
                    if (n == n2) continue;
                    this.processAvailableManoeuvreViews(sArray[n], 2, sArray.length);
                }
            } else {
                this.logger.error("ERROR: Southside has sent multiple Overlays which cannot be displayed together - see specified Overlay pairings and pass this bug to the Southside.");
            }
        } else {
            this.logger.error("ERROR: MAX_TOGGLEABLE items exceeded by the Southside.");
        }
    }

    private void processAvailableManoeuvreViews(int n, int n2, int n3) {
        this.logger.trace("processAvailableManoeuvreViews -- setting...");
        switch (n) {
            case 3: {
                this.availableOverlays[n2] = 2;
                ++this.availableOverlaysCnt;
                if (this.target.datapool.isManeuverDetailViewActive()) {
                    ++this.useableOverlaysCnt;
                    this.currentOverlayIndex = n2;
                    this.displayKDK();
                }
                this.logger.trace("CURRENT_OVERLAY__C2_INTERSECTION");
                break;
            }
            case 4: {
                this.availableOverlays[n2] = 3;
                ++this.availableOverlaysCnt;
                if (this.target.datapool.isManeuverDetailViewActive()) {
                    ++this.useableOverlaysCnt;
                    this.currentOverlayIndex = n2;
                    this.displayEVJV();
                }
                this.logger.trace("CURRENT_OVERLAY__C3_EXIT");
                break;
            }
            case 6: {
                this.availableOverlays[n2] = 4;
                ++this.availableOverlaysCnt;
                if (this.target.datapool.isKanbanActive()) {
                    ++this.useableOverlaysCnt;
                    if (n3 == 1 || !this.target.datapool.isManeuverDetailViewActive() && n3 > 1) {
                        this.currentOverlayIndex = n2;
                        this.displayCanban();
                    }
                }
                this.logger.trace("CURRENT_OVERLAY__C4_CANBAN");
                break;
            }
            default: {
                this.displayEnd();
                this.updateModelDisplayCommon();
                this.toggleOverlay();
                this.logger.trace("MANOEUVRETYPE_INVALID_MANOEUVRE or UNSUPPORTED MANOEUVRETYPE_*");
            }
        }
    }

    public void dsiMapViewerManeuverViewUpdateManoeuvreViewActive(int n, int n2) {
        this.logger.trace("dsiMapViewerManeuverViewUpdateManoeuvreViewActive");
        if (n2 == 1) {
            StringBuffer stringBuffer = new StringBuffer("Active Manoeuvre View: ").append(n);
            this.logger.trace(stringBuffer.toString());
            this.selectDisplay(n);
        } else {
            this.availableOverlays[this.currentOverlayIndex] = -10000;
            --this.useableOverlaysCnt;
            --this.availableOverlaysCnt;
            this.toggleOverlay();
        }
    }

    private void selectDisplay(int n) {
        switch (n) {
            case 3: {
                if (this.availableOverlays[this.currentOverlayIndex] != 2 || this.useableOverlaysCnt <= 0) break;
                this.updateModelDisplay();
                break;
            }
            case 4: {
                if (this.availableOverlays[this.currentOverlayIndex] != 3 || this.useableOverlaysCnt <= 0) break;
                this.updateModelDisplay();
                break;
            }
            case 6: {
                if (this.availableOverlays[this.currentOverlayIndex] != 4 || this.useableOverlaysCnt <= 0) break;
                this.updateModelDisplay();
                break;
            }
            case 255: {
                this.logger.trace("MANOEUVRETYPE_INVALID_MANOEUVRE returned by: DSIMapViewerManeuverViewListener.updateManoeuvreViewActive(int activeDSIView, int validFlag)");
                break;
            }
        }
    }

    public void dsiNavigationUpdateRgTurnList(TurnListElement[] turnListElementArray, int n) {
        this.logger.trace(".dsiNavigationUpdateRgTurnList: ");
        this.currentTurnListElements = turnListElementArray;
        this.commonDSIUpdateRG(n);
    }

    public void dsiNavigationUpdateRgCurrentRoute(Route route, int n) {
        this.logger.trace(".dsiNavigationUpdateRgCurrentRoute: ");
        this.commonDSIUpdateRG(n);
    }

    public void dsiNavigationUpdateRgDestinationInfo(NavRouteListData[] navRouteListDataArray, int n) {
        this.logger.trace(".dsiNavigationUpdateRgDestinationInfo: ");
        this.commonDSIUpdateRG(n);
    }

    public void dsiNavigationUpdateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination, int n) {
        this.logger.trace(".dsiNavigationUpdateRgInfoForNextDestination: ");
        this.commonDSIUpdateRG(n);
    }

    public void dsiNavigationUpdateRgPoiInfo(NavPoiInfo[] navPoiInfoArray, int n) {
        this.logger.trace(".dsiNavigationUpdateRgPoiInfo: ");
        this.commonDSIUpdateRG(n);
    }

    private void commonDSIUpdateRG(int n) {
        if (n == 1) {
            this.target.overlaysTurnListHandler.updateRgTurnList(this.currentTurnListElements);
            this.target.notifierModel.notifyAdditionalGuidanceInformation();
            this.target.notifierOverlaysInternalAPI.notifyOverlayDataUpdate();
        }
    }

    private void specialHide() {
        if (this.target.datapool.isHIGH() && !this.isDuplicateHide()) {
            this.logger.trace("specialHide");
            this.target.notifierDSI.hideManoeuvreView();
        }
    }

    private boolean isDuplicateHide() {
        return this.restoreSplScr() && this.availableOverlaysCnt == 1;
    }

    @Override
    public void handleNavigationSettingsReset() {
        this.logger.trace("handleNavigationSettingsReset()");
        this.target.datapool.clear();
        this.notifyModelOfCurrentDPValues();
        this.useableOverlaysCnt = 1;
        this.availableOverlaysCnt = 1;
        this.availableOverlays[0] = 1;
        this.currentOverlayIndex = 0;
        this.displaySplitScreen();
        this.target.notifierDSI.enableRgMotorwayInfo(this.target.datapool.isMotorwayInfoActive());
        this.navigationResetParticipant.notifyResetDone();
    }

    private void notifyModelOfCurrentDPValues() {
        this.target.notifierModel.notifyKanbanActiveChanged(this.target.datapool.isKanbanActive());
        this.target.notifierModel.notifyManeuverDetailViewActiveChanged(this.target.datapool.isManeuverDetailViewActive());
        this.target.notifierModel.notifyMotorwayInfoActiveChanged(this.target.datapool.isMotorwayInfoActive());
    }

    @Override
    public void reloadPersistedData() {
        this.notifyModelOfCurrentDPValues();
        this.initializeDisplay();
        this.target.notifierDSI.enableRgMotorwayInfo(this.target.datapool.isMotorwayInfoActive());
    }
}

