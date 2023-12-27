/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.functions.ArrayListener;
import de.vw.mib.bap.mqbab2.audiosd.functions.MediaBrowser;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioService;
import de.vw.mib.bap.mqbab2.common.api.radio.RadioServiceListener;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStage;
import de.vw.mib.bap.mqbab2.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListComplete;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayRequestData;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.MediaBrowser_ChangedArray;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.MediaBrowser_Data;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.MediaBrowser_GetArray;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.MediaBrowser_StatusArray;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.RadioTV_PresetList_ChangedArray;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.RadioTV_PresetList_Data;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.ReceptionList_ChangedArray;

public class MediaBrowserNar
extends MediaBrowser
implements RadioServiceListener {
    private FsgArrayListComplete _fullPresetList;
    protected static final int[] RADIO_LISTENER_IDS = new int[]{1412};
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$common$arrays$FsgArrayListComplete;
    static /* synthetic */ Class class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$RadioTV_PresetList_ChangedArray;
    static /* synthetic */ Class class$java$lang$Boolean;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        this.getRadioService().addRadioServiceListener(this, RADIO_LISTENER_IDS);
        return super.init(bAPStageInitializer);
    }

    @Override
    public void setFunctionData(BAPStage bAPStage, Object object) {
        if (bAPStage.getFunctionId() == 33) {
            if (object.getClass() == (class$de$vw$mib$bap$mqbab2$common$arrays$FsgArrayListComplete == null ? (class$de$vw$mib$bap$mqbab2$common$arrays$FsgArrayListComplete = MediaBrowserNar.class$("de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListComplete")) : class$de$vw$mib$bap$mqbab2$common$arrays$FsgArrayListComplete)) {
                this.setFullPresetList((FsgArrayListComplete)object);
            } else if (object.getClass() == (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$RadioTV_PresetList_ChangedArray == null ? (class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$RadioTV_PresetList_ChangedArray = MediaBrowserNar.class$("de.vw.mib.bap.mqbab2.generated.audiosd.serializer.RadioTV_PresetList_ChangedArray")) : class$de$vw$mib$bap$mqbab2$generated$audiosd$serializer$RadioTV_PresetList_ChangedArray)) {
                this.setRadioTvPresetListChangedArray((RadioTV_PresetList_ChangedArray)object);
            }
        } else if (bAPStage.getFunctionId() == 40) {
            if (object.getClass() == (class$java$lang$Boolean == null ? (class$java$lang$Boolean = MediaBrowserNar.class$("java.lang.Boolean")) : class$java$lang$Boolean)) {
                this.mediaBrowserListChanged();
            }
        } else {
            super.setFunctionData(bAPStage, object);
        }
    }

    @Override
    public void uninitialize() {
        this.getRadioService().removeRadioServiceListener(this, RADIO_LISTENER_IDS);
        super.uninitialize();
    }

    protected void setFullPresetList(FsgArrayListComplete fsgArrayListComplete) {
        this._fullPresetList = fsgArrayListComplete;
    }

    protected FsgArrayListComplete getFullPresetList() {
        return this._fullPresetList;
    }

    private boolean shallPresetListShown() {
        return this.getSoundService().getCurrentAudioComponent() == 1 && this.getRadioService().getScopeOfArrowKeyMode() == 0 || this.getSoundService().getCurrentAudioComponent() == 5 && this.getTvTunerService().getTvScopeOfArrowKeyMode() == 0;
    }

    @Override
    protected void setReceptionListChangedArray(ReceptionList_ChangedArray receptionList_ChangedArray) {
        if (!this.shallPresetListShown()) {
            super.setReceptionListChangedArray(receptionList_ChangedArray);
        }
    }

    protected void setRadioTvPresetListChangedArray(RadioTV_PresetList_ChangedArray radioTV_PresetList_ChangedArray) {
        if (!this.isMediaBrowserActive() && this.shallPresetListShown()) {
            if (radioTV_PresetList_ChangedArray.getArrayHeader().isFullRangeUpdate()) {
                this.mediaBrowserListChanged();
            } else if (!this.getMediaBrowserActionRunning()) {
                MediaBrowser_ChangedArray mediaBrowser_ChangedArray = this.dequeueBAPEntity();
                BAPEntity bAPEntity = radioTV_PresetList_ChangedArray.getArrayHeader();
                BAPEntity bAPEntity2 = mediaBrowser_ChangedArray.getArrayHeader();
                ((ArrayHeader)bAPEntity2).setRecordAddress(2, ((ArrayHeader)bAPEntity).getSerializationRecordAddress());
                ((ArrayHeader)bAPEntity2).start = ((ArrayHeader)bAPEntity).start;
                ((ArrayHeader)bAPEntity2).elements = ((ArrayHeader)bAPEntity).elements;
                ((ArrayHeader)bAPEntity2).mode.arrayDirectionIsBackward = ((ArrayHeader)bAPEntity).mode.arrayDirectionIsBackward;
                ((ArrayHeader)bAPEntity2).mode.arrayPositionIsTransmitted = ((ArrayHeader)bAPEntity).mode.arrayPositionIsTransmitted;
                ((ArrayHeader)bAPEntity2).mode.indexSize16BitForStartElements = ((ArrayHeader)bAPEntity).mode.indexSize16BitForStartElements;
                ((ArrayHeader)bAPEntity2).mode.shift = ((ArrayHeader)bAPEntity).mode.shift;
                bAPEntity = radioTV_PresetList_ChangedArray.getArrayData();
                bAPEntity2 = mediaBrowser_ChangedArray.getArrayData();
                int n = radioTV_PresetList_ChangedArray.getArrayData().size();
                for (int i2 = 0; i2 < n; ++i2) {
                    ((BAPArrayData)bAPEntity2).add(this.transformPresetListDataElement((RadioTV_PresetList_Data)((BAPArrayData)bAPEntity).get(i2), (MediaBrowser_Data)mediaBrowser_ChangedArray.createArrayElement()));
                }
                this.getArrayRequestTracker().reportChangedArray(mediaBrowser_ChangedArray);
            }
        }
    }

    @Override
    protected void getArrayRadioList(MediaBrowser_GetArray mediaBrowser_GetArray, ArrayListener arrayListener) {
        if (this.getSoundService().getCurrentAudioComponent() == 5) {
            switch (this.getTvTunerService().getTvScopeOfArrowKeyMode()) {
                case 0: {
                    this.getArrayPresetList(this.getFullPresetList(), mediaBrowser_GetArray, arrayListener);
                    break;
                }
                default: {
                    this.getArrayReceptionList(this.getFullReceptionList(), mediaBrowser_GetArray, arrayListener);
                    break;
                }
            }
        } else {
            switch (this.getRadioService().getScopeOfArrowKeyMode()) {
                case 0: {
                    this.getArrayPresetList(this.getFullPresetList(), mediaBrowser_GetArray, arrayListener);
                    break;
                }
                default: {
                    this.getArrayReceptionList(this.getFullReceptionList(), mediaBrowser_GetArray, arrayListener);
                }
            }
        }
    }

    protected void getArrayPresetList(FsgArrayListComplete fsgArrayListComplete, MediaBrowser_GetArray mediaBrowser_GetArray, ArrayListener arrayListener) {
        if (this.getArrayRequestTracker().requestGetArray(mediaBrowser_GetArray)) {
            FsgArrayRequestData fsgArrayRequestData = FsgArrayRequestData.computeArrayRequestData(mediaBrowser_GetArray.getArrayHeader(), fsgArrayListComplete, MediaBrowser.maximumElementsForRecordAddress(mediaBrowser_GetArray.getArrayHeader().getRecordAddress()));
            MediaBrowser_StatusArray mediaBrowser_StatusArray = new MediaBrowser_StatusArray();
            fsgArrayRequestData.setStatusArrayHeaderDataAndFillRequestData(mediaBrowser_StatusArray, mediaBrowser_GetArray, fsgArrayListComplete);
            mediaBrowser_StatusArray.activeListPos = -1;
            fsgArrayRequestData.setTransmissionPosForArbitraryArray(mediaBrowser_StatusArray);
            int n = mediaBrowser_StatusArray.getArrayData().size();
            for (int i2 = 0; i2 < n; ++i2) {
                RadioTV_PresetList_Data radioTV_PresetList_Data = (RadioTV_PresetList_Data)mediaBrowser_StatusArray.getArrayData().get(i2);
                mediaBrowser_StatusArray.getArrayData().replace(i2, this.transformPresetListDataElement(radioTV_PresetList_Data, (MediaBrowser_Data)mediaBrowser_StatusArray.createArrayElement()));
            }
            super.transmitStatus(mediaBrowser_StatusArray);
        }
    }

    private MediaBrowser_Data transformPresetListDataElement(RadioTV_PresetList_Data radioTV_PresetList_Data, MediaBrowser_Data mediaBrowser_Data) {
        mediaBrowser_Data.setPos(radioTV_PresetList_Data.getPos());
        mediaBrowser_Data.fileName.setContent(radioTV_PresetList_Data.name);
        mediaBrowser_Data.fileType = 2;
        return mediaBrowser_Data;
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

