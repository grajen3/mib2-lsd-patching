/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.navsd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.generated.navsd.serializer.TurnToInfo_Status;
import de.vw.mib.bap.mqbpq.navsd.api.stages.TurnToInfoStage;

public class TurnToInfo
extends TurnToInfoStage {
    public static String EMPTY_STRING = "";
    public static String LINE_FEED = "\n";

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        return super.init(bAPStageInitializer);
    }

    @Override
    public void process(int n) {
        this.sendTurnToInfoStatus(this.computeTurnToInfoStatus());
    }

    private TurnToInfo_Status computeTurnToInfoStatus() {
        TurnToInfo_Status turnToInfo_Status = this.dequeueBAPEntity();
        this.setTurnToInfoStatusData(turnToInfo_Status);
        return turnToInfo_Status;
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
    }

    @Override
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    private void sendTurnToInfoStatus(TurnToInfo_Status turnToInfo_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(turnToInfo_Status, this);
    }

    protected void setTurnToInfoStatusData(TurnToInfo_Status turnToInfo_Status) {
        String string = this.getTurnToInfoSignPost();
        String string2 = this.getTurnToInfoStreet();
        String string3 = string != null && string.length() > 0 && string2 != null && string2.length() > 0 ? new StringBuffer().append(string2).append(LINE_FEED).append(string).toString() : (string != null && string.length() > 0 ? string : (string2 != null && string2.length() > 0 ? string2 : EMPTY_STRING));
        turnToInfo_Status.turnToInfo.setContent(string3);
    }
}

