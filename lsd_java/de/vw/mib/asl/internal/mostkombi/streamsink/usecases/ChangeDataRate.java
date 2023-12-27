/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.streamsink.usecases;

import de.vw.mib.asl.internal.mostkombi.common.api.adaption.asl.AdaptationService;
import de.vw.mib.asl.internal.mostkombi.common.sequence.Sequence;
import de.vw.mib.asl.internal.mostkombi.common.sequence.SequenceDelegate;
import de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl.DisplayManagementService;
import de.vw.mib.asl.internal.mostkombi.streamsink.usecases.ChangeDataRateSequence;
import de.vw.mib.asl.internal.mostkombi.streamsink.usecases.StreamSinkUseCase;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink;

public class ChangeDataRate
extends StreamSinkUseCase {
    private DSIKOMOGfxStreamSink _komoGfxStreamSink;
    private int[] KOMO_GFX_STREAM_SINK_SERVICES = new int[]{3};
    private DSIListener _komoGfxStreamSinkServiceResponder;
    private DisplayManagementService _displayManagementService;
    private ChangeDataRateSequence _changeDataRateSequence;
    private static final int STREAM_SINK_DATA_RATE_INVALID;
    private int _streamSinkDataRate = -1;
    static /* synthetic */ Class class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink;
    static /* synthetic */ Class class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$mostkombi$common$api$adaption$asl$AdaptationService;

    private DSIKOMOGfxStreamSink getKomoGfxStreamSink() {
        if (this._komoGfxStreamSink == null) {
            this._komoGfxStreamSink = (DSIKOMOGfxStreamSink)this.getCategoryDelegate().getDsiService(this, class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink == null ? (class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink = ChangeDataRate.class$("org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink")) : class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink);
            this._komoGfxStreamSinkServiceResponder = this.getCategoryDelegate().addDsiServiceResponder(this, (DSIBase)this._komoGfxStreamSink, class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener == null ? (class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener = ChangeDataRate.class$("org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSinkListener")) : class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener, this.KOMO_GFX_STREAM_SINK_SERVICES);
        }
        return this._komoGfxStreamSink;
    }

    private DSIListener getKomoGfxStreamSinkServiceResponder() {
        return this._komoGfxStreamSinkServiceResponder;
    }

    private DisplayManagementService getDisplayManagementService() {
        if (this._displayManagementService == null) {
            this._displayManagementService = (DisplayManagementService)this.getCategoryDelegate().getService(this, class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService == null ? (class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService = ChangeDataRate.class$("de.vw.mib.asl.internal.mostkombi.streamsink.api.displaymanagement.asl.DisplayManagementService")) : class$de$vw$mib$asl$internal$mostkombi$streamsink$api$displaymanagement$asl$DisplayManagementService);
        }
        return this._displayManagementService;
    }

    private AdaptationService getAdaptationService() {
        return (AdaptationService)this.getCategoryDelegate().getService(this, class$de$vw$mib$asl$internal$mostkombi$common$api$adaption$asl$AdaptationService == null ? (class$de$vw$mib$asl$internal$mostkombi$common$api$adaption$asl$AdaptationService = ChangeDataRate.class$("de.vw.mib.asl.internal.mostkombi.common.api.adaption.asl.AdaptationService")) : class$de$vw$mib$asl$internal$mostkombi$common$api$adaption$asl$AdaptationService);
    }

    private ChangeDataRateSequence getChangeDataRateSequence() {
        if (this._changeDataRateSequence == null) {
            ChangeDataRateSequence changeDataRateSequence = new ChangeDataRateSequence(this.getStreamSinkDataRate());
            changeDataRateSequence.setDelegate(this.getCategoryDelegate());
            changeDataRateSequence.initialize();
            this._changeDataRateSequence = changeDataRateSequence;
        }
        return this._changeDataRateSequence;
    }

    private void clearChangeDataRateSequence() {
        if (this._changeDataRateSequence != null) {
            this._changeDataRateSequence.appendToSequence(null);
            this._changeDataRateSequence.uninitialize();
            this._changeDataRateSequence = null;
        }
    }

    @Override
    public void initialize() {
    }

    @Override
    public void uninitialize() {
        this.getCategoryDelegate().removeDsiServiceResponder(this, class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener == null ? (class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener = ChangeDataRate.class$("org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSinkListener")) : class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener, this.getKomoGfxStreamSinkServiceResponder(), this.KOMO_GFX_STREAM_SINK_SERVICES, (DSIBase)this._komoGfxStreamSink);
        this.clearChangeDataRateSequence();
    }

    @Override
    public void appendToSequence(SequenceDelegate sequenceDelegate) {
        super.appendToSequence(sequenceDelegate);
        if (sequenceDelegate != null) {
            this.clearChangeDataRateSequence();
        }
        this.getKomoGfxStreamSink();
    }

    @Override
    public int getIdentifier() {
        return 1421612544;
    }

    @Override
    public void executeSequence() {
        this.getKomoGfxStreamSink();
        if (!this.getChangeDataRateSequence().isPartOfOtherSequence()) {
            this._executeChangeDataRateSequence();
        } else {
            this._executeChangeDataRateSequence();
            if (this.getCategoryDelegate().getLogger().isTraceEnabled(this.getCategoryDelegate().getSubClassifier())) {
                this.getCategoryDelegate().getLogger().trace(this.getCategoryDelegate().getSubClassifier()).append("Restart sequence: ").append(this.getChangeDataRateSequence().getSequenceName()).append(", although sequence didn't finished yet").log();
            }
        }
    }

    @Override
    public void sequenceDone(Sequence sequence) {
        boolean bl = this.getChangeDataRateSequence().getStreamSinkDataRate() != this.getStreamSinkDataRate();
        this.clearChangeDataRateSequence();
        if (bl) {
            this.executeSequence();
        } else if (this.isPartOfOtherSequence()) {
            this.getSequenceDelegate().sequenceDone(this);
        } else if (this.getCategoryDelegate().getLogger().isTraceEnabled(this.getCategoryDelegate().getSubClassifier())) {
            this.getCategoryDelegate().getLogger().trace(this.getCategoryDelegate().getSubClassifier()).append(sequence.getSequenceName()).append(" Sequence done without delegate").log();
        }
    }

    @Override
    public int sequenceStepFailed(Sequence sequence, int n, String string) {
        if (this.getCategoryDelegate().getLogger().isTraceEnabled(this.getCategoryDelegate().getSubClassifier())) {
            this.getCategoryDelegate().getLogger().error(this.getCategoryDelegate().getSubClassifier()).append(sequence.getSequenceName()).append(": step failed: ").append(string).append(" step-number=").append(n).log();
        }
        return 0;
    }

    private void _executeChangeDataRateSequence() {
        this.clearChangeDataRateSequence();
        this.getChangeDataRateSequence().appendToSequence(this);
        this.getChangeDataRateSequence().executeSequence();
    }

    private void setStreamSinkDataRate(int n) {
        this._streamSinkDataRate = n;
    }

    private int getStreamSinkDataRate() {
        return this._streamSinkDataRate;
    }

    public void dsiKOMOGfxStreamSinkUpdateDataRate(int n, int n2) {
        if (this.getStreamSinkDataRate() != n && (this.getDisplayManagementService().getKombiDisplay() != -1 || this.getAdaptationService().isNavigationMapSwitchSupported())) {
            this.setStreamSinkDataRate(n);
            if (!this.isPartOfOtherSequence() && !this.getChangeDataRateSequence().isPartOfOtherSequence() || this.getChangeDataRateSequence().getStreamSinkDataRate() == -1) {
                this.executeSequence();
            }
        } else {
            this.setStreamSinkDataRate(n);
        }
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

