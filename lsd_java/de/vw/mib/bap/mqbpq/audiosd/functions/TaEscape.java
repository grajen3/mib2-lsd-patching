/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.MethodListener;
import de.vw.mib.bap.mqbpq.audiosd.api.stages.TaEscapeStage;
import de.vw.mib.bap.mqbpq.common.api.asl.audio.ASLRadio;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.TaEscape_Result;

public final class TaEscape
extends TaEscapeStage {
    private boolean _running;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        return super.init(bAPStageInitializer);
    }

    private boolean isRunning() {
        return this._running;
    }

    private void setRunning(boolean bl) {
        this._running = bl;
    }

    @Override
    public void initialize(boolean bl) {
        this.setRunning(false);
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public void process(int n) {
        this.checkAnnouncementResult();
    }

    @Override
    public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
        if (this.isRunning()) {
            this.sendResult(1);
        } else if (this.getTrafficAnnouncementActive() || this.getPtyAnnouncementActive() || this.getDabAnnouncementPlaying()) {
            ASLRadio.stopTrafficAnnouncement();
            this.setRunning(true);
        } else if (this.getTrafficInformationActive()) {
            ASLRadio.stopTrafficInformation();
            this.setRunning(true);
        } else {
            this.sendResult(4);
        }
    }

    @Override
    public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
        if (this.isRunning()) {
            this.setRunning(false);
            this.sendResult(methodListener, 3);
        } else {
            methodListener.requestError(80, this);
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

    private void sendResult(MethodListener methodListener, int n) {
        TaEscape_Result taEscape_Result = this.dequeueBAPEntity();
        taEscape_Result.taEscapeResult = n;
        methodListener.result(taEscape_Result, this);
    }

    private void sendResult(int n) {
        TaEscape_Result taEscape_Result = this.dequeueBAPEntity();
        taEscape_Result.taEscapeResult = n;
        this.getDelegate().getMethodListener(this).result(taEscape_Result, this);
    }

    private void checkAnnouncementResult() {
        if (!(!this.isRunning() || this.getTrafficAnnouncementActive() || this.getPtyAnnouncementActive() || this.getDabAnnouncementPlaying() || this.getTrafficInformationActive())) {
            this.sendResult(0);
            this.setRunning(false);
        }
    }
}

