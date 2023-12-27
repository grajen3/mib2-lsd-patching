/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Method;
import de.vw.mib.bap.functions.MethodListener;
import de.vw.mib.bap.mqbab2.audiosd.api.ASLAudioSDConstants;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioService;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.AnnouncementEscape_Result;

public class AnnouncementEscape
extends Function
implements Method,
ASLAudioSDConstants,
RadioServiceListener {
    private boolean announcementEscapeRunning = false;
    protected static final int[] RADIO_LISTENER_IDS = new int[]{1448, 1429, 1441, 2482};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$AnnouncementEscape_Result;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getRadioService().addRadioServiceListener(this, RADIO_LISTENER_IDS);
        return null;
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    protected final AnnouncementEscape_Result dequeueBAPEntity() {
        return (AnnouncementEscape_Result)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$AnnouncementEscape_Result == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$AnnouncementEscape_Result = AnnouncementEscape.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.AnnouncementEscape_Result")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$AnnouncementEscape_Result);
    }

    @Override
    public int getFunctionId() {
        return 29;
    }

    @Override
    public void process(int n) {
        this.checkAnnouncementResult();
    }

    private void checkAnnouncementResult() {
        RadioService radioService;
        if (!(!this.announcementEscapeRunning || (radioService = this.getRadioService()).isTrafficAnnouncementActive() || radioService.isPTYAnnouncementActive() || radioService.isDABAnnouncementActive() || radioService.isTrafficInformationActive())) {
            this.sendResult(0);
            this.announcementEscapeRunning = false;
        }
    }

    private void sendResult(int n) {
        AnnouncementEscape_Result announcementEscape_Result = this.dequeueBAPEntity();
        announcementEscape_Result.announcementEscapeResult = n;
        this.getDelegate().getMethodListener(this).result(announcementEscape_Result, this);
    }

    private void sendResult(MethodListener methodListener, int n) {
        AnnouncementEscape_Result announcementEscape_Result = this.dequeueBAPEntity();
        announcementEscape_Result.announcementEscapeResult = n;
        methodListener.result(announcementEscape_Result, this);
    }

    @Override
    public void abortResult(BAPEntity bAPEntity, MethodListener methodListener) {
        if (this.announcementEscapeRunning) {
            this.announcementEscapeRunning = false;
            this.sendResult(methodListener, 3);
        } else {
            methodListener.requestError(80, this);
        }
    }

    @Override
    public void startResult(BAPEntity bAPEntity, MethodListener methodListener) {
        if (this.announcementEscapeRunning) {
            this.sendResult(1);
        } else {
            RadioService radioService = this.getRadioService();
            if (radioService.isTrafficAnnouncementActive() || radioService.isPTYAnnouncementActive() || radioService.isDABAnnouncementActive()) {
                radioService.stopTrafficAnnouncement();
                this.announcementEscapeRunning = true;
            } else if (radioService.isTrafficInformationActive()) {
                radioService.stopTrafficInformation();
                this.announcementEscapeRunning = true;
            } else {
                this.sendResult(4);
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
        this.announcementEscapeRunning = false;
    }

    @Override
    public void uninitialize() {
        this.getRadioService().removeRadioServiceListener(this, RADIO_LISTENER_IDS);
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updateRadioData(RadioService radioService, int n) {
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
}

