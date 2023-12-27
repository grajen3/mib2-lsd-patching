/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.streamsink.usecases;

import de.vw.mib.asl.internal.mostkombi.common.sequence.Sequence;
import de.vw.mib.asl.internal.mostkombi.common.sequence.SequenceDelegate;
import de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl.DisplayManagementDelegate;
import de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl.DisplayManagementService;
import de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl.NavigationMapDelegate;
import de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl.NavigationMapService;
import de.vw.mib.asl.internal.mostkombi.streamsink.usecases.StreamSinkSequence;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink;

public class SwitchMapFromKombiToABTSequence
extends StreamSinkSequence
implements NavigationMapDelegate,
DisplayManagementDelegate {
    private DSIKOMOGfxStreamSink _komoGfxStreamSink;
    private DSIListener _komoGfxStreamSinkServiceResponder;
    private NavigationMapService _navigationMapService;
    private static final int[] NAVIGATION_MAP_SERVICES = NavigationMapDelegate.NAVIGATION_MAP_KOMBI_MAP_PROPERTIES;
    private DisplayManagementService _displayManagementService;
    private static final int[] DISPLAY_MANAGEMENT_SERVICES = new int[]{993140736};
    private static final int STREAM_SINK_DATA_RATE_INVALID;
    private int _streamSinkDataRate;
    private static final int STEP_SET_MAP_SWITCH_STATE_TO_ABT;
    private static final int STEP_FADE_OUT;
    private static final int STEP_WAIT_GFX_STREAM_SINK_UPDATE_DATARATE;
    private static final int STEP_SET_DISPLAY_MANAGEMENT_UPDATE_DATARATE;
    private static final int STEP_SET_MAP_SWITCH_STATE_TO_SHOW_MAP_IN_ABT;
    private static final int STEP_WAIT_MAP_VISIBLE_IN_ABT;
    private static final int STEP_SET_MAP_SWITCH_STATE_VISIBLE_IN_ABT;
    private static final int STEP_FADE_IN;
    private static final int STEP_DONE;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService;
    static /* synthetic */ Class class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener;
    static /* synthetic */ Class class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink;

    public SwitchMapFromKombiToABTSequence(int n) {
        this.setStreamSinkDataRate(n);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void uninitialize() {
        this._streamSinkDataRate = -1;
        this.getCategoryDelegate().removeServiceListener(this, class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService = SwitchMapFromKombiToABTSequence.class$("de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl.DisplayManagementService")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService, DISPLAY_MANAGEMENT_SERVICES);
        this.getCategoryDelegate().removeServiceListener(this, class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService = SwitchMapFromKombiToABTSequence.class$("de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl.NavigationMapService")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService, NAVIGATION_MAP_SERVICES);
        this.getCategoryDelegate().removeDsiServiceResponder(this, class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener == null ? (class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener = SwitchMapFromKombiToABTSequence.class$("org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSinkListener")) : class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener, this.getKomoGfxStreamSinkServiceResponder(), null, (DSIBase)this._komoGfxStreamSink);
        if (this.getSequenceDelegate() != null && this.getSequence(this, 1421612544).isPartOfSequence(this)) {
            this.getSequence(this, 1421612544).appendToSequence(null);
        }
    }

    private DSIKOMOGfxStreamSink getKomoGfxStreamSink() {
        if (this._komoGfxStreamSink == null) {
            this._komoGfxStreamSink = (DSIKOMOGfxStreamSink)this.getCategoryDelegate().getDsiService(this, class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink == null ? (class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink = SwitchMapFromKombiToABTSequence.class$("org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink")) : class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink);
            this._komoGfxStreamSinkServiceResponder = this.getCategoryDelegate().addDsiServiceResponder(this, (DSIBase)this._komoGfxStreamSink, class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener == null ? (class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener = SwitchMapFromKombiToABTSequence.class$("org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSinkListener")) : class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener, null);
        }
        return this._komoGfxStreamSink;
    }

    private DSIListener getKomoGfxStreamSinkServiceResponder() {
        return this._komoGfxStreamSinkServiceResponder;
    }

    private NavigationMapService getNavigationMapService() {
        if (this._navigationMapService == null) {
            this._navigationMapService = (NavigationMapService)this.getCategoryDelegate().getService(this, class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService = SwitchMapFromKombiToABTSequence.class$("de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl.NavigationMapService")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService);
            this.getCategoryDelegate().registerServiceListener(this, class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService = SwitchMapFromKombiToABTSequence.class$("de.vw.mib.asl.internal.mostkombi.streamsink.api.navimap.asl.NavigationMapService")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$api$navimap$asl$NavigationMapService, NAVIGATION_MAP_SERVICES);
        }
        return this._navigationMapService;
    }

    private DisplayManagementService getDisplayManagementService() {
        if (this._displayManagementService == null) {
            this._displayManagementService = (DisplayManagementService)this.getCategoryDelegate().getService(this, class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService = SwitchMapFromKombiToABTSequence.class$("de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl.DisplayManagementService")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService);
            this.getCategoryDelegate().registerServiceListener(this, class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService = SwitchMapFromKombiToABTSequence.class$("de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl.DisplayManagementService")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService, DISPLAY_MANAGEMENT_SERVICES);
        }
        return this._displayManagementService;
    }

    public int getStreamSinkDataRate() {
        return this._streamSinkDataRate;
    }

    public void setStreamSinkDataRate(int n) {
        this._streamSinkDataRate = n;
        if (this.getCurrentStep() == 2 && n == 0) {
            this.stepDone();
        }
    }

    @Override
    public int getIdentifier() {
        return 1572607488;
    }

    @Override
    public void appendToSequence(SequenceDelegate sequenceDelegate) {
        super.appendToSequence(sequenceDelegate);
        if (sequenceDelegate != null) {
            this.prepareSequence();
        }
    }

    private void prepareSequence() {
        this.getSequence(this, 1421612544).appendToSequence(this);
    }

    @Override
    public void executeSequence() {
        this.stepDone();
    }

    @Override
    public void sequenceDone(Sequence sequence) {
    }

    @Override
    public void updateDisplayManagement(DisplayManagementService displayManagementService, int n) {
        if (this.getCurrentStep() == 3 && n == 993140736) {
            this.stepDone();
        }
    }

    @Override
    public void updateNavigationMap(NavigationMapService navigationMapService, int n) {
        switch (n) {
            case -2147482645: {
                if (this.getCurrentStep() == 0 && this.getNavigationMapService().getMapSwitchState() == 3) {
                    this.stepDone();
                    break;
                }
                if (this.getCurrentStep() == 4 && this.getNavigationMapService().getMapSwitchState() == 4) {
                    this.stepDone();
                    break;
                }
                if (this.getCurrentStep() != 6 || this.getNavigationMapService().getMapSwitchState() != 1) break;
                this.stepDone();
                break;
            }
            case -2147482646: {
                if (this.getCurrentStep() != 5 || this.getNavigationMapService().getMapInAbtVisibility() != 1) break;
                this.stepDone();
                break;
            }
        }
    }

    @Override
    protected String getStepDescription(int n) {
        String string;
        switch (this.getCurrentStep()) {
            case 0: {
                string = "STEP_SET_MAP_SWITCH_STATE_TO_ABT";
                break;
            }
            case 1: {
                string = "STEP_FADE_OUT";
                break;
            }
            case 2: {
                string = "STEP_WAIT_GFX_STREAM_SINK_UPDATE_DATARATE";
                break;
            }
            case 3: {
                string = "STEP_SET_DISPLAY_MANAGEMENT_UPDATE_DATARATE";
                break;
            }
            case 4: {
                string = "STEP_SET_MAP_SWITCH_STATE_TO_SHOW_MAP_IN_ABT";
                break;
            }
            case 5: {
                string = "STEP_WAIT_MAP_VISIBLE_IN_ABT";
                break;
            }
            case 6: {
                string = "STEP_SET_MAP_SWITCH_STATE_VISIBLE_IN_ABT";
                break;
            }
            case 7: {
                string = "STEP_FADE_IN";
                break;
            }
            case 8: {
                string = "STEP_DONE";
                break;
            }
            default: {
                string = "Unknown";
            }
        }
        return string;
    }

    @Override
    protected boolean executeNextStep() {
        boolean bl = true;
        if (this.getCategoryDelegate().getLogger().isTraceEnabled(this.getCategoryDelegate().getSubClassifier())) {
            this.getCategoryDelegate().getLogger().trace(this.getCategoryDelegate().getSubClassifier(), new StringBuffer().append("Starting Step SwitchMapFromKombiToABT#").append(this.getStepDescription(this.getCurrentStep())).toString());
        }
        switch (this.getCurrentStep()) {
            case 0: {
                this._stepSetMapSwitchStateToABT();
                break;
            }
            case 1: {
                this.getKomoGfxStreamSink().fadeOut(1);
                break;
            }
            case 2: {
                if (this.getStreamSinkDataRate() != 0) break;
                this.stepDone();
                break;
            }
            case 3: {
                this._stepChangeDataRateToOff();
                break;
            }
            case 4: {
                this._stepSetMapStateShowInABT();
                break;
            }
            case 5: {
                break;
            }
            case 6: {
                this._stepSetMapStateVisibleInABT();
                break;
            }
            case 7: {
                this.getKomoGfxStreamSink().fadeIn(1, 0, 0);
                break;
            }
            case 8: {
                bl = false;
                this.sequenceFinished();
                break;
            }
        }
        return bl;
    }

    private void _stepSetMapSwitchStateToABT() {
        this.getNavigationMapService().setMapSwitchState(3);
    }

    private void _stepChangeDataRateToOff() {
        this.getDisplayManagementService().setDataFrameRate(0);
    }

    private void _stepSetMapStateShowInABT() {
        this.getNavigationMapService().setMapSwitchState(4);
    }

    private void _stepSetMapStateVisibleInABT() {
        this.getNavigationMapService().setMapSwitchState(1);
    }

    public void dsiKOMOGfxStreamSinkFadeOutResult() {
        this.stepDone();
    }

    public void dsiKOMOGfxStreamSinkFadeInResult() {
        this.stepDone();
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

