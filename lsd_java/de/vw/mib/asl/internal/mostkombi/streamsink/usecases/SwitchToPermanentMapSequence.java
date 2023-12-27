/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.streamsink.usecases;

import de.vw.mib.asl.internal.mostkombi.common.sequence.Sequence;
import de.vw.mib.asl.internal.mostkombi.common.sequence.SequenceDelegate;
import de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl.DisplayManagementDelegate;
import de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl.DisplayManagementService;
import de.vw.mib.asl.internal.mostkombi.streamsink.usecases.StreamSinkSequence;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink;

public class SwitchToPermanentMapSequence
extends StreamSinkSequence
implements DisplayManagementDelegate {
    private DSIKOMOGfxStreamSink _komoGfxStreamSink;
    private DSIListener _komoGfxStreamSinkServiceResponder;
    private DisplayManagementService _displayManagementService;
    private static final int[] DISPLAY_MANAGEMENT_SERVICES = new int[]{976363520};
    private static final int STEP_FADE_OUT;
    private static final int STEP_SWITCH_KOMBI_MAP_CONTEXT;
    private static final int STEP_RG_SELECT;
    private static final int STEP_WAIT_FOR_DATA_RATE;
    private static final int STEP_SET_MAP_LAYER_ALPHA_MASK;
    private static final int STEP_FADE_IN;
    private static final int STEP_DONE;
    static /* synthetic */ Class class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink;
    static /* synthetic */ Class class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService;

    private DSIKOMOGfxStreamSink getKomoGfxStreamSink() {
        if (this._komoGfxStreamSink == null) {
            this._komoGfxStreamSink = (DSIKOMOGfxStreamSink)this.getCategoryDelegate().getDsiService(this, class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink == null ? (class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink = SwitchToPermanentMapSequence.class$("org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink")) : class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink);
            this._komoGfxStreamSinkServiceResponder = this.getCategoryDelegate().addDsiServiceResponder(this, (DSIBase)this._komoGfxStreamSink, class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener == null ? (class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener = SwitchToPermanentMapSequence.class$("org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSinkListener")) : class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener, null);
        }
        return this._komoGfxStreamSink;
    }

    private DSIListener getKomoGfxStreamSinkServiceResponder() {
        return this._komoGfxStreamSinkServiceResponder;
    }

    private DisplayManagementService getDisplayManagementService() {
        if (this._displayManagementService == null) {
            this._displayManagementService = (DisplayManagementService)this.getCategoryDelegate().getService(this, class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService = SwitchToPermanentMapSequence.class$("de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl.DisplayManagementService")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService);
            this.getCategoryDelegate().registerServiceListener(this, class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService = SwitchToPermanentMapSequence.class$("de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl.DisplayManagementService")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService, DISPLAY_MANAGEMENT_SERVICES);
        }
        return this._displayManagementService;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void uninitialize() {
        this.getCategoryDelegate().removeDsiServiceResponder(this, class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener == null ? (class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener = SwitchToPermanentMapSequence.class$("org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSinkListener")) : class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener, this.getKomoGfxStreamSinkServiceResponder(), null, (DSIBase)this._komoGfxStreamSink);
        this.getCategoryDelegate().removeServiceListener(this, class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService = SwitchToPermanentMapSequence.class$("de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl.DisplayManagementService")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService, DISPLAY_MANAGEMENT_SERVICES);
        this.sequenceAbort();
    }

    @Override
    public int getIdentifier() {
        return 1471944192;
    }

    @Override
    public void appendToSequence(SequenceDelegate sequenceDelegate) {
        super.appendToSequence(sequenceDelegate);
        if (sequenceDelegate != null) {
            this.prepareSequence();
        }
    }

    @Override
    public void executeSequence() {
        this.stepDone();
    }

    @Override
    public void sequenceDone(Sequence sequence) {
        sequence.appendToSequence(null);
        this.stepDone();
    }

    private void prepareSequence() {
        this.getSequence(this, 1874597376).appendToSequence(this);
        this.getSequence(this, 1421612544).appendToSequence(this);
    }

    @Override
    protected boolean executeNextStep() {
        boolean bl = true;
        switch (this.getCurrentStep()) {
            case 0: {
                this.getKomoGfxStreamSink().fadeOut(1);
                break;
            }
            case 1: {
                if (this.getDisplayManagementService().getKombiDisplay() == -1) {
                    this.getDisplayManagementService().switchToKombiDisplayContext(70);
                    break;
                }
                this.stepDone();
                break;
            }
            case 2: {
                this.getSequence(this, 1874597376).executeSequence();
                break;
            }
            case 3: {
                bl = false;
                this.getSequence(this, 1421612544).executeSequence();
                break;
            }
            case 4: {
                this.getKomoGfxStreamSink().setFGLayer(3);
                break;
            }
            case 5: {
                this.getKomoGfxStreamSink().fadeIn(1, 0, 0);
                break;
            }
            case 6: {
                bl = false;
                this.sequenceFinished();
                break;
            }
        }
        return bl;
    }

    @Override
    protected String getStepDescription(int n) {
        String string;
        switch (n) {
            case 0: {
                string = "STEP_FADE_OUT";
                break;
            }
            case 1: {
                string = "STEP_SWITCH_KOMBI_MAP_CONTEXT";
                break;
            }
            case 2: {
                string = "STEP_RG_SELECT";
                break;
            }
            case 3: {
                string = "STEP_WAIT_FOR_DATA_RATE";
                break;
            }
            case 4: {
                string = "STEP_SET_MAP_LAYER_ALPHA_MASK";
                break;
            }
            case 5: {
                string = "STEP_FADE_IN";
                break;
            }
            default: {
                string = "Unknown";
            }
        }
        return string;
    }

    public void dsiKOMOGfxStreamSinkFadeOutResult() {
        this.stepDone();
    }

    public void dsiKOMOGfxStreamSinkSetFGLayerResult(int n) {
        this.stepDone();
    }

    public void dsiKOMOGfxStreamSinkFadeInResult() {
        this.stepDone();
    }

    @Override
    public void updateDisplayManagement(DisplayManagementService displayManagementService, int n) {
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

