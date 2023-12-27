/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.streamsink.usecases;

import de.vw.mib.asl.internal.mostkombi.common.sequence.Sequence;
import de.vw.mib.asl.internal.mostkombi.streamsink.usecases.StreamSinkUseCase;
import de.vw.mib.asl.internal.mostkombi.streamsink.usecases.SwitchMapFromABTToKombiSequence;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink;

public class SwitchMapFromABTToKombi
extends StreamSinkUseCase {
    private SwitchMapFromABTToKombiSequence _switchMapFromABTToKombiSequence;
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
        this.getCategoryDelegate().removeDsiServiceResponder(this, class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener == null ? (class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener = SwitchMapFromABTToKombi.class$("org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSinkListener")) : class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener, this.getKomoGfxStreamSinkServiceResponder(), this.KOMO_GFX_STREAM_SINK_SERVICES, (DSIBase)this._komoGfxStreamSink);
        this.clearSwitchMapFromABTToKombiSequence();
    }

    @Override
    public int getIdentifier() {
        return 1522275840;
    }

    private DSIKOMOGfxStreamSink getKomoGfxStreamSink() {
        if (this._komoGfxStreamSink == null) {
            this._komoGfxStreamSink = (DSIKOMOGfxStreamSink)this.getCategoryDelegate().getDsiService(this, class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink == null ? (class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink = SwitchMapFromABTToKombi.class$("org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSink")) : class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSink);
            this._komoGfxStreamSinkServiceResponder = this.getCategoryDelegate().addDsiServiceResponder(this, (DSIBase)this._komoGfxStreamSink, class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener == null ? (class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener = SwitchMapFromABTToKombi.class$("org.dsi.ifc.komogfxstreamsink.DSIKOMOGfxStreamSinkListener")) : class$org$dsi$ifc$komogfxstreamsink$DSIKOMOGfxStreamSinkListener, this.KOMO_GFX_STREAM_SINK_SERVICES);
        }
        return this._komoGfxStreamSink;
    }

    private DSIListener getKomoGfxStreamSinkServiceResponder() {
        return this._komoGfxStreamSinkServiceResponder;
    }

    private SwitchMapFromABTToKombiSequence getSwitchMapFromABTToKombiSequence() {
        if (this._switchMapFromABTToKombiSequence == null) {
            SwitchMapFromABTToKombiSequence switchMapFromABTToKombiSequence = new SwitchMapFromABTToKombiSequence(this._streamSinkDataRate);
            switchMapFromABTToKombiSequence.setDelegate(this.getCategoryDelegate());
            switchMapFromABTToKombiSequence.initialize();
            this._switchMapFromABTToKombiSequence = switchMapFromABTToKombiSequence;
        }
        return this._switchMapFromABTToKombiSequence;
    }

    private void clearSwitchMapFromABTToKombiSequence() {
        if (this._switchMapFromABTToKombiSequence != null) {
            this._switchMapFromABTToKombiSequence.appendToSequence(null);
            this._switchMapFromABTToKombiSequence.uninitialize();
            this._switchMapFromABTToKombiSequence = null;
        }
    }

    @Override
    public void executeSequence() {
        this.getKomoGfxStreamSink();
        if (!this.getSwitchMapFromABTToKombiSequence().isPartOfOtherSequence()) {
            if (this.getCategoryDelegate().getLogger().isTraceEnabled(this.getCategoryDelegate().getSubClassifier())) {
                this.getCategoryDelegate().getLogger().trace(this.getCategoryDelegate().getSubClassifier(), "Start SwitchMapFromABTToKombiSequence.");
            }
            this.clearSwitchMapFromABTToKombiSequence();
            this.getSwitchMapFromABTToKombiSequence().appendToSequence(this);
            this.getSwitchMapFromABTToKombiSequence().executeSequence();
        }
    }

    @Override
    public void sequenceDone(Sequence sequence) {
        this.clearSwitchMapFromABTToKombiSequence();
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
            if (this.getSwitchMapFromABTToKombiSequence().isPartOfOtherSequence()) {
                this.getSwitchMapFromABTToKombiSequence().setStreamSinkDataRate(n);
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

