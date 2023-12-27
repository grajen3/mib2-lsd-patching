/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.Property;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbab2.audiosd.api.ASLAudioSDConstants;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioService;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioServiceListener;
import de.vw.mib.bap.mqbab2.common.api.radio.datatypes.iterator.elements.RadioTrafficMessageElement;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.api.stages.Function;
import de.vw.mib.bap.mqbab2.common.api.system.SystemService;
import de.vw.mib.bap.mqbab2.common.api.system.SystemServiceListener;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.TpMemoInfo_Status;
import java.util.Iterator;

public final class TpMemoInfo
extends Function
implements Property,
ASLAudioSDConstants,
SystemServiceListener,
RadioServiceListener {
    private TpMemoInfo_Status lastTpMemoInfoStatus = null;
    private static final int MSG_NUMBER_OFFSET;
    protected static final int[] SYSTEM_LISTENER_IDS;
    protected static final int[] RADIO_LISTENER_IDS;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$TpMemoInfo_Status;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getSystemService().addSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        this.getRadioService().addRadioServiceListener(this, RADIO_LISTENER_IDS);
        return this.computeTpMemoInfoStatus();
    }

    protected TpMemoInfo_Status dequeueBAPEntity() {
        return (TpMemoInfo_Status)this.context.dequeueBAPEntity(this, class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$TpMemoInfo_Status == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$TpMemoInfo_Status = TpMemoInfo.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.TpMemoInfo_Status")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$TpMemoInfo_Status);
    }

    protected void setCurrentTPMemoInfoSend(TpMemoInfo_Status tpMemoInfo_Status) {
        int[] nArray = new int[]{24};
        this.context.updateStages(this, nArray, tpMemoInfo_Status);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
    }

    @Override
    public int getFunctionId() {
        return 26;
    }

    private void setTpCounters(TpMemoInfo_Status tpMemoInfo_Status, int n) {
        tpMemoInfo_Status.tpCounters.currentMsgNumber = n;
        int n2 = 0;
        Iterator iterator = this.getRadioService().getTrafficMessages();
        while (iterator.hasNext()) {
            ++n2;
            iterator.next();
        }
        tpMemoInfo_Status.tpCounters.totalMsgNumber = n2;
        if (tpMemoInfo_Status.tpCounters.totalMsgNumber > 0) {
            ++tpMemoInfo_Status.tpCounters.currentMsgNumber;
        }
    }

    private void setMessageTime(TpMemoInfo_Status tpMemoInfo_Status, int n) {
        Iterator iterator = this.getRadioService().getTrafficMessages();
        int n2 = 0;
        while (iterator.hasNext()) {
            RadioTrafficMessageElement radioTrafficMessageElement = (RadioTrafficMessageElement)iterator.next();
            if (n2 == n) {
                tpMemoInfo_Status.messageTime.hour = radioTrafficMessageElement.getTrafficMessageHour();
                tpMemoInfo_Status.messageTime.minute = radioTrafficMessageElement.getTrafficMessageMinute();
                break;
            }
            ++n2;
        }
    }

    private void setStationName(TpMemoInfo_Status tpMemoInfo_Status, int n) {
        Iterator iterator = this.getRadioService().getTrafficMessages();
        int n2 = 0;
        while (iterator.hasNext()) {
            RadioTrafficMessageElement radioTrafficMessageElement = (RadioTrafficMessageElement)iterator.next();
            if (n2 == n) {
                tpMemoInfo_Status.stationName.setContent(radioTrafficMessageElement.getTrafficMessageStationName());
                break;
            }
            ++n2;
        }
    }

    private void sendTpMemoInfoStatus(TpMemoInfo_Status tpMemoInfo_Status) {
        this.getDelegate().getPropertyListener(this).statusProperty(tpMemoInfo_Status, this);
        this.lastTpMemoInfoStatus = tpMemoInfo_Status;
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void requestAcknowledge() {
        this.setCurrentTPMemoInfoSend(this.lastTpMemoInfoStatus);
    }

    @Override
    public void errorAcknowledge() {
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
        this.getSystemService().removeSystemServiceListener(this, SYSTEM_LISTENER_IDS);
        this.getRadioService().removeRadioServiceListener(this, RADIO_LISTENER_IDS);
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

    @Override
    public void process(int n) {
        this.sendTpMemoInfoStatus(this.computeTpMemoInfoStatus());
    }

    private TpMemoInfo_Status computeTpMemoInfoStatus() {
        TpMemoInfo_Status tpMemoInfo_Status = this.dequeueBAPEntity();
        if (this.getSystemService().getCurrentMainContext() == 10) {
            int n = this.getRadioService().getTpMemoListSelectedIndex();
            this.setTpCounters(tpMemoInfo_Status, n);
            if (tpMemoInfo_Status.tpCounters.totalMsgNumber > 0) {
                this.setMessageTime(tpMemoInfo_Status, n);
                this.setStationName(tpMemoInfo_Status, n);
            }
        }
        return tpMemoInfo_Status;
    }

    @Override
    public void processHMIEvent(int n) {
    }

    @Override
    public void updateRadioData(RadioService radioService, int n) {
        this.process(-1);
    }

    @Override
    public void updateSystemData(SystemService systemService, int n) {
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
        SYSTEM_LISTENER_IDS = new int[]{1612};
        RADIO_LISTENER_IDS = new int[]{1421};
    }
}

