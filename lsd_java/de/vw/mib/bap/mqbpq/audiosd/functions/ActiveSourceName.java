/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.BAPFunctionListener;
import de.vw.mib.bap.functions.PropertyListener;
import de.vw.mib.bap.mqbpq.audiosd.api.stages.ActiveSourceNameStage;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayList;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.ActiveSourceName_Status;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.SourceList_Data;

public class ActiveSourceName
extends ActiveSourceNameStage {
    private static final String ACTIVE_SOURCE_NAME_IPOD;
    private static final String ACTIVE_SOURCE_NAME_USB;
    private static final String ACTIVE_SOURCE_NAME_WLAN;
    private static final String ACTIVE_SOURCE_NAME_BT_AUDIO;
    private BAPArrayList fullSourceList;
    private int activeSourceListReference;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        super.init(bAPStageInitializer);
        return this.computeActiveSourceNameStatus();
    }

    private String getAvdcActiveSourceName() {
        SourceList_Data sourceList_Data = this.activeSourceListReference == 0 || this.fullSourceList == null ? null : (SourceList_Data)this.fullSourceList.getElement(this.activeSourceListReference);
        String string = sourceList_Data != null ? sourceList_Data.name.toString() : "";
        return string;
    }

    private String retrieveActiveSourceName() {
        String string;
        block0 : switch (this.getCurrentAudioComponent()) {
            case 2: 
            case 3: {
                switch (this.getCurrentAudioSource()) {
                    case 8: 
                    case 13: {
                        string = "\ue07c";
                        break block0;
                    }
                    case 11: {
                        string = "\ufc15";
                        break block0;
                    }
                    case 6: {
                        string = "\uf7fe";
                        break block0;
                    }
                    case 7: 
                    case 14: {
                        string = "\ufb0f";
                        break block0;
                    }
                    case 2: 
                    case 5: 
                    case 10: {
                        string = this.getAvdcActiveSourceName();
                        break block0;
                    }
                }
                string = "";
                break;
            }
            case 6: {
                string = "\ue07c";
                break;
            }
            default: {
                string = "";
            }
        }
        return string;
    }

    @Override
    public void getProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void requestAcknowledge() {
    }

    @Override
    public void indicationError(int n, BAPFunctionListener bAPFunctionListener) {
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
    public void setGetProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void ackProperty(BAPEntity bAPEntity, PropertyListener propertyListener) {
        propertyListener.requestError(65, this);
    }

    @Override
    public void process(int n) {
        ActiveSourceName_Status activeSourceName_Status = this.computeActiveSourceNameStatus();
        this.getDelegate().getPropertyListener(this).statusProperty(activeSourceName_Status, this);
    }

    private ActiveSourceName_Status computeActiveSourceNameStatus() {
        ActiveSourceName_Status activeSourceName_Status = this.dequeueBAPEntity();
        activeSourceName_Status.sourceName.setContent(this.retrieveActiveSourceName());
        return activeSourceName_Status;
    }

    @Override
    protected void setReportedSourceListReference(Integer n) {
        int n2 = n;
        if (this.activeSourceListReference != n2) {
            this.activeSourceListReference = n2;
            this.process(-1);
        }
    }

    @Override
    protected void setFullSourceList(BAPArrayList bAPArrayList) {
        boolean bl = this.fullSourceList != null;
        this.fullSourceList = bAPArrayList;
        if (bl) {
            this.process(-1);
        }
    }
}

