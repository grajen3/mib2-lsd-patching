/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.streamsink.usecases;

import de.vw.mib.asl.internal.mostkombi.common.sequence.Sequence;
import de.vw.mib.asl.internal.mostkombi.streamsink.usecases.StreamSinkUseCase;
import de.vw.mib.asl.internal.mostkombi.streamsink.usecases.SwitchMapFromKombiToABTSequence;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink;

public class SwitchMapFromKombiToABT
extends StreamSinkUseCase {
    private SwitchMapFromKombiToABTSequence _switchMapFromKombiToABTSequence;
    private DSIKOMOGfxStreamSink _komoGfxStreamSink;
    private int[] KOMO_GFX_STREAM_SINK_SERVICES = new int[]{3};
    private DSIListener _komoGfxStreamSinkServiceResponder;
    private static final int STREAM_SINK_DATA_RATE_INVALID;
    private int _streamSinkDataRate = -1;
    static /* synthetic */ Class class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener;
    static /* synthetic */ Class class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink;

    @Override
    public void initialize() {
    }

    @Override
    public void uninitialize() {
        this.getCategoryDelegate().removeDsiServiceResponder(this, class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener == null ? (class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener = SwitchMapFromKombiToABT.class$("org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSinkListener")) : class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener, this.getKomoGfxStreamSinkServiceResponder(), this.KOMO_GFX_STREAM_SINK_SERVICES, (DSIBase)this._komoGfxStreamSink);
        this.clearSwitchMapFromKombiToABTSequence();
    }

    @Override
    public int getIdentifier() {
        return 1555830272;
    }

    private DSIKOMOGfxStreamSink getKomoGfxStreamSink() {
        if (this._komoGfxStreamSink == null) {
            this._komoGfxStreamSink = (DSIKOMOGfxStreamSink)this.getCategoryDelegate().getDsiService(this, class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink == null ? (class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink = SwitchMapFromKombiToABT.class$("org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink")) : class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink);
            this._komoGfxStreamSinkServiceResponder = this.getCategoryDelegate().addDsiServiceResponder(this, (DSIBase)this._komoGfxStreamSink, class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener == null ? (class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener = SwitchMapFromKombiToABT.class$("org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSinkListener")) : class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener, this.KOMO_GFX_STREAM_SINK_SERVICES);
        }
        return this._komoGfxStreamSink;
    }

    private DSIListener getKomoGfxStreamSinkServiceResponder() {
        return this._komoGfxStreamSinkServiceResponder;
    }

    private SwitchMapFromKombiToABTSequence getSwitchMapFromKombiToABTSequence() {
        if (this._switchMapFromKombiToABTSequence == null) {
            SwitchMapFromKombiToABTSequence switchMapFromKombiToABTSequence = new SwitchMapFromKombiToABTSequence(this._streamSinkDataRate);
            switchMapFromKombiToABTSequence.setDelegate(this.getCategoryDelegate());
            switchMapFromKombiToABTSequence.initialize();
            this._switchMapFromKombiToABTSequence = switchMapFromKombiToABTSequence;
        }
        return this._switchMapFromKombiToABTSequence;
    }

    private void clearSwitchMapFromKombiToABTSequence() {
        if (this._switchMapFromKombiToABTSequence != null) {
            this._switchMapFromKombiToABTSequence.uninitialize();
            this._switchMapFromKombiToABTSequence.appendToSequence(null);
            this._switchMapFromKombiToABTSequence = null;
        }
    }

    @Override
    public void executeSequence() {
        this.getKomoGfxStreamSink();
        if (!this.getSwitchMapFromKombiToABTSequence().isPartOfOtherSequence()) {
            if (this.getCategoryDelegate().getLogger().isTraceEnabled(this.getCategoryDelegate().getSubClassifier())) {
                this.getCategoryDelegate().getLogger().trace(this.getCategoryDelegate().getSubClassifier(), "Start SwitchMapFromKombiToABTSequence.");
            }
            this.clearSwitchMapFromKombiToABTSequence();
            this.getSwitchMapFromKombiToABTSequence().appendToSequence(this);
            this.getSwitchMapFromKombiToABTSequence().executeSequence();
        }
    }

    @Override
    public void sequenceDone(Sequence sequence) {
        this.clearSwitchMapFromKombiToABTSequence();
        if (this.getCategoryDelegate().getLogger().isTraceEnabled(this.getCategoryDelegate().getSubClassifier())) {
            this.getCategoryDelegate().getLogger().trace(this.getCategoryDelegate().getSubClassifier()).append(sequence.getSequenceName()).append(" Sequence done").log();
        }
    }

    @Override
    public int sequenceStepFailed(Sequence sequence, int n, String string) {
        if (this.getCategoryDelegate().getLogger().isTraceEnabled(this.getCategoryDelegate().getSubClassifier())) {
            this.getCategoryDelegate().getLogger().error(this.getCategoryDelegate().getSubClassifier()).append(sequence.getSequenceName()).append(": step failed: ").append(string).append(" step-number=").append(n).log();
        }
        return 0;
    }

    public void dsiKOMOGfxStreamSinkUpdateDataRate(int n, int n2) {
        if (this._streamSinkDataRate != n) {
            this._streamSinkDataRate = n;
            if (this.getSwitchMapFromKombiToABTSequence().isPartOfOtherSequence()) {
                this.getSwitchMapFromKombiToABTSequence().setStreamSinkDataRate(n);
            }
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

