/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.mqbpq.ServiceManager;
import de.vw.mib.bap.mqbpq.audiosd.api.stages.SourceListStage;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.BooleanIterator;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.IntegerIterator;
import de.vw.mib.bap.mqbpq.common.api.adapter.properties.StringIterator;
import de.vw.mib.bap.mqbpq.common.api.asl.audio.ASLAVDCAudio;
import de.vw.mib.bap.mqbpq.common.api.asl.audio.ASLRadio;
import de.vw.mib.bap.mqbpq.common.api.asl.audio.ASLSound;
import de.vw.mib.bap.mqbpq.common.api.stages.BAPStageInitializer;
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayList;
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayList$BAPArrayElementComparator;
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayList$BAPArrayListIterator;
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayListGenericIDGenerator;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.SourceList_Data;

public class SourceList
extends SourceListStage
implements BAPArrayList$BAPArrayElementComparator {
    private BAPArrayList fullSourceList = new BAPArrayList(new BAPArrayListGenericIDGenerator(255, 1));
    private int requestedSourceListReference = 0;
    private static final int MIN_BAP_ID;
    private static final int MAX_BAP_ID;

    @Override
    public BAPEntity init(BAPStageInitializer bAPStageInitializer) {
        super.init(bAPStageInitializer);
        this.computeFullSourceList(this.fullSourceList);
        this.setFullSourceList(this.fullSourceList);
        return null;
    }

    @Override
    public void initialize(boolean bl) {
    }

    @Override
    public void uninitialize() {
    }

    @Override
    public void process(int n) {
        this.fullSourceList.clear();
        this.computeFullSourceList(this.fullSourceList);
        this.requestedSourceListReference = this.findSourceListReference();
        this.setReportedSourceListReference(new Integer(this.requestedSourceListReference));
    }

    private static void setSourceName(SourceList_Data sourceList_Data, String string) {
        if (string != null) {
            sourceList_Data.name.setContent(string);
        } else {
            sourceList_Data.name.setContent("");
        }
    }

    private void fillSourceAttributes(SourceList_Data sourceList_Data, int n, int n2, boolean bl, String string) {
        boolean bl2 = n != 10 && n != 13 && n != 12 && n != 0;
        boolean bl3 = (n2 & 0x100) != 256;
        boolean bl4 = bl2 && (n2 & 0x1000) != 4096 && (n2 & 0x800) != 2048 && n != 11 && n != 15 && n != 19 && n != 17;
        boolean bl5 = bl4 && (n2 & 0x400) != 1024 && (n2 & 1) != 1;
        boolean bl6 = n != 12;
        boolean bl7 = (n2 & 0x10) != 16;
        sourceList_Data.attributes.builtInAndReady = bl && bl2;
        sourceList_Data.attributes.mediumAudioNoError = bl3;
        sourceList_Data.attributes.mediaIsPlayable = bl5;
        sourceList_Data.attributes.mediumIsReadable = bl4;
        sourceList_Data.attributes.mediumIsNotBeingLoaded = bl6;
        sourceList_Data.attributes.noImportRunning = bl7;
        SourceList.setSourceName(sourceList_Data, string);
    }

    private void setSourceTypeMediaTypeAttributesName(int n, SourceList_Data sourceList_Data, String string, boolean bl, int n2, int n3) {
        this.fillSourceAttributes(sourceList_Data, n2, n3, bl, string);
        switch (n) {
            case 3: {
                sourceList_Data.sourceType = 13;
                sourceList_Data.mediaType = 8;
                break;
            }
            case 6: {
                if (n2 == 9 && this.getMetaInfoRequestSupported()) {
                    sourceList_Data.sourceType = 22;
                    sourceList_Data.mediaType = 9;
                    break;
                }
                sourceList_Data.sourceType = 21;
                sourceList_Data.mediaType = 0;
                break;
            }
            case 4: {
                if (n2 == 2) {
                    sourceList_Data.sourceType = 18;
                    sourceList_Data.mediaType = 2;
                    break;
                }
                if (n2 == 6) {
                    sourceList_Data.sourceType = 18;
                    sourceList_Data.mediaType = 6;
                    break;
                }
                sourceList_Data.sourceType = 7;
                sourceList_Data.mediaType = 1;
                break;
            }
            case 1: {
                if (n2 == 2) {
                    sourceList_Data.sourceType = 8;
                    sourceList_Data.mediaType = 2;
                    break;
                }
                if (n2 == 3) {
                    sourceList_Data.sourceType = 8;
                    sourceList_Data.mediaType = 3;
                    break;
                }
                if (n2 == 6) {
                    sourceList_Data.sourceType = 8;
                    sourceList_Data.mediaType = 6;
                    break;
                }
                sourceList_Data.sourceType = 6;
                sourceList_Data.mediaType = 1;
                break;
            }
            case 5: {
                sourceList_Data.sourceType = 10;
                sourceList_Data.mediaType = 7;
                boolean bl2 = (n3 & 0x100) == 256;
                sourceList_Data.attributes.mediaIsPlayable &= bl2;
                break;
            }
            case 7: {
                sourceList_Data.sourceType = 16;
                sourceList_Data.mediaType = 12;
                break;
            }
            case 2: {
                sourceList_Data.sourceType = 11;
                sourceList_Data.mediaType = 7;
                sourceList_Data.instance_Id = ServiceManager.serviceManager.configurationManager.getNumberOfSDSlots() <= 1 ? 0 : 1;
                break;
            }
            case 10: {
                sourceList_Data.sourceType = 11;
                sourceList_Data.mediaType = 7;
                sourceList_Data.instance_Id = 2;
                break;
            }
            case 8: {
                sourceList_Data.sourceType = 19;
                sourceList_Data.mediaType = 7;
                sourceList_Data.instance_Id = this.getSecondUsbSocketAvailable() ? 1 : 0;
                break;
            }
            case 13: {
                sourceList_Data.sourceType = 19;
                sourceList_Data.mediaType = 7;
                sourceList_Data.instance_Id = 2;
                break;
            }
            case 9: 
            case 12: {
                if (bl) {
                    sourceList_Data.sourceType = 14;
                    sourceList_Data.mediaType = 8;
                    break;
                }
                sourceList_Data.sourceType = 15;
                sourceList_Data.mediaType = 255;
                break;
            }
            case 11: {
                sourceList_Data.sourceType = 28;
                sourceList_Data.mediaType = 9;
                break;
            }
            default: {
                sourceList_Data.sourceType = 255;
                sourceList_Data.mediaType = 0;
                sourceList_Data.attributes.builtInAndReady = false;
                sourceList_Data.attributes.mediumAudioNoError = true;
                sourceList_Data.attributes.mediaIsPlayable = false;
                sourceList_Data.attributes.mediumIsReadable = false;
                sourceList_Data.attributes.mediumIsNotBeingLoaded = true;
                sourceList_Data.attributes.noImportRunning = true;
                sourceList_Data.name.setContent("");
            }
        }
    }

    private void setDataForMediaSources(BAPArrayList bAPArrayList) {
        IntegerIterator integerIterator = this.getAvailableAudioSources();
        BooleanIterator booleanIterator = this.getAvailableAudioSourcesEnabled();
        StringIterator stringIterator = this.getAvailableAudioSourcesSourceName();
        IntegerIterator integerIterator2 = this.getAvailableAudioSourcesMediaFlag();
        IntegerIterator integerIterator3 = this.getAvailableAudioSourcesMediaType();
        int n = integerIterator.size();
        for (int i2 = 0; i2 < n; ++i2) {
            int n2 = integerIterator.nextInteger();
            String string = stringIterator.nextString();
            boolean bl = booleanIterator.nextBoolean();
            int n3 = integerIterator2.nextInteger();
            int n4 = integerIterator3.nextInteger();
            SourceList_Data sourceList_Data = new SourceList_Data(null);
            this.setSourceTypeMediaTypeAttributesName(n2, sourceList_Data, string, bl, n4, n3);
            if (sourceList_Data.sourceType == 255) continue;
            bAPArrayList.putElement(n2, sourceList_Data, n2);
        }
    }

    protected void addAdditionalBroadcastSources(BAPArrayList bAPArrayList) {
    }

    protected void addAdditionalVideoSources(BAPArrayList bAPArrayList) {
        if (ServiceManager.serviceManager.configurationManager.isFeatureFlagSet(425)) {
            SourceList_Data sourceList_Data = new SourceList_Data(null);
            sourceList_Data.sourceType = 9;
            sourceList_Data.instance_Id = 0;
            sourceList_Data.mediaType = 11;
            sourceList_Data.attributes.builtInAndReady = true;
            sourceList_Data.attributes.mediumAudioNoError = true;
            sourceList_Data.attributes.mediaIsPlayable = true;
            sourceList_Data.attributes.mediumIsReadable = true;
            sourceList_Data.attributes.mediumIsNotBeingLoaded = true;
            sourceList_Data.attributes.noImportRunning = true;
            sourceList_Data.name.setContent("");
            bAPArrayList.putElement(-6L, sourceList_Data, 0L);
        }
    }

    private void computeFullSourceList(BAPArrayList bAPArrayList) {
        SourceList_Data sourceList_Data;
        if (this.getDabAvailable()) {
            sourceList_Data = new SourceList_Data(null);
            sourceList_Data.sourceType = 3;
            sourceList_Data.instance_Id = 0;
            sourceList_Data.mediaType = 10;
            sourceList_Data.attributes.builtInAndReady = true;
            sourceList_Data.attributes.mediumAudioNoError = true;
            sourceList_Data.attributes.mediaIsPlayable = true;
            sourceList_Data.attributes.mediumIsReadable = true;
            sourceList_Data.attributes.mediumIsNotBeingLoaded = true;
            sourceList_Data.attributes.noImportRunning = true;
            sourceList_Data.name.setContent("");
            bAPArrayList.putElement(-4L, sourceList_Data, 0L);
        }
        sourceList_Data = new SourceList_Data(null);
        sourceList_Data.sourceType = 1;
        sourceList_Data.instance_Id = 0;
        sourceList_Data.mediaType = 10;
        sourceList_Data.attributes.builtInAndReady = true;
        sourceList_Data.attributes.mediumAudioNoError = true;
        sourceList_Data.attributes.mediaIsPlayable = true;
        sourceList_Data.attributes.mediumIsReadable = true;
        sourceList_Data.attributes.mediumIsNotBeingLoaded = true;
        sourceList_Data.attributes.noImportRunning = true;
        sourceList_Data.name.setContent("");
        bAPArrayList.putElement(-2L, sourceList_Data, 0L);
        if (this.getAmAvailable()) {
            sourceList_Data = new SourceList_Data(null);
            sourceList_Data.sourceType = 2;
            sourceList_Data.instance_Id = 0;
            sourceList_Data.mediaType = 10;
            sourceList_Data.attributes.builtInAndReady = true;
            sourceList_Data.attributes.mediumAudioNoError = true;
            sourceList_Data.attributes.mediaIsPlayable = true;
            sourceList_Data.attributes.mediumIsReadable = true;
            sourceList_Data.attributes.mediumIsNotBeingLoaded = true;
            sourceList_Data.attributes.noImportRunning = true;
            sourceList_Data.name.setContent("");
            bAPArrayList.putElement(-3L, sourceList_Data, 0L);
        }
        this.addAdditionalBroadcastSources(bAPArrayList);
        this.setDataForMediaSources(bAPArrayList);
        this.addAdditionalVideoSources(bAPArrayList);
    }

    @Override
    public int compare(BAPArrayElement bAPArrayElement, BAPArrayElement bAPArrayElement2, int n) {
        SourceList_Data sourceList_Data = (SourceList_Data)bAPArrayElement;
        SourceList_Data sourceList_Data2 = (SourceList_Data)bAPArrayElement2;
        boolean bl = sourceList_Data.mediaType == sourceList_Data2.mediaType;
        boolean bl2 = sourceList_Data.attributes.builtInAndReady == sourceList_Data2.attributes.builtInAndReady && sourceList_Data.attributes.mediumAudioNoError == sourceList_Data2.attributes.mediumAudioNoError && sourceList_Data.attributes.mediaIsPlayable == sourceList_Data2.attributes.mediaIsPlayable && sourceList_Data.attributes.mediumIsNotBeingLoaded == sourceList_Data2.attributes.mediumIsNotBeingLoaded && sourceList_Data.attributes.noImportRunning == sourceList_Data2.attributes.noImportRunning;
        boolean bl3 = sourceList_Data.name.toString().intern() == sourceList_Data2.name.toString().intern();
        boolean bl4 = sourceList_Data.sourceType == sourceList_Data2.sourceType;
        boolean bl5 = sourceList_Data.instance_Id == sourceList_Data2.instance_Id;
        int n2 = 0;
        switch (n) {
            case -1: {
                if (!bl4 || !bl5 || !bl3 && !bl2 || !bl3 && !bl || !bl2 && !bl) {
                    if (!bl3) {
                        n2 = 0;
                        break;
                    }
                    n2 = 1;
                    break;
                }
                if (!bl) {
                    n2 = 4;
                    break;
                }
                if (!bl2) {
                    n2 = 3;
                    break;
                }
                if (!bl3) {
                    n2 = 2;
                    break;
                }
                n2 = -1;
                break;
            }
            case 0: {
                if (!(bl5 && bl4 && bl3 && bl2 && bl)) {
                    n2 = n;
                    break;
                }
                n2 = -1;
                break;
            }
            case 1: {
                if (!bl3) {
                    n2 = 0;
                    break;
                }
                if (!(bl5 && bl4 && bl3 && bl2 && bl)) {
                    n2 = n;
                    break;
                }
                n2 = -1;
                break;
            }
            default: {
                if (!(bl5 && bl4 && bl3 && bl2 && bl)) {
                    if (!bl3) {
                        n2 = 0;
                        break;
                    }
                    n2 = 1;
                    break;
                }
                n2 = -1;
            }
        }
        return n2;
    }

    private int findSourceListReferenceForTv() {
        int n = 0;
        if (this.fullSourceList != null) {
            n = this.fullSourceList.getBapPosID(-6L);
        }
        return n;
    }

    private int findFirstUSBSourceListReference() {
        int n = 0;
        if (this.fullSourceList != null) {
            BAPArrayList$BAPArrayListIterator bAPArrayList$BAPArrayListIterator = this.fullSourceList.getForwardIteratorStartingAt(this.fullSourceList.getBapPosID(-2L));
            while (bAPArrayList$BAPArrayListIterator.hasNext()) {
                SourceList_Data sourceList_Data = (SourceList_Data)bAPArrayList$BAPArrayListIterator.next();
                if (sourceList_Data.sourceType != 19) continue;
                n = sourceList_Data.getPos();
                break;
            }
        }
        return n;
    }

    private int findSourceListReference() {
        int n;
        block0 : switch (this.getCurrentAudioComponent()) {
            case 1: {
                if (this.fullSourceList != null) {
                    switch (this.getCurrentStationInfoBand()) {
                        case 1: {
                            n = this.fullSourceList.getBapPosID(-2L);
                            break block0;
                        }
                        case 0: {
                            n = this.fullSourceList.getBapPosID(-3L);
                            break block0;
                        }
                        case 2: {
                            n = this.fullSourceList.getBapPosID(-4L);
                            break block0;
                        }
                        case 3: {
                            n = this.fullSourceList.getBapPosID(-5L);
                            break block0;
                        }
                    }
                    n = 0;
                    break;
                }
                n = 0;
                break;
            }
            case 2: {
                if (this.fullSourceList != null) {
                    int n2 = this.getCurrentAudioSource();
                    n = this.fullSourceList.getBapPosID(n2);
                    break;
                }
                n = 0;
                break;
            }
            case 3: {
                n = this.findSourceListReferenceForTv();
                break;
            }
            case 4: {
                n = 0;
                break;
            }
            case 5: {
                n = this.findSourceListReferenceForTv();
                break;
            }
            case 6: {
                n = this.findFirstUSBSourceListReference();
                break;
            }
            default: {
                n = 0;
            }
        }
        return n;
    }

    private boolean canPerformSwitchSource(SourceList_Data sourceList_Data) {
        return sourceList_Data != null && sourceList_Data.attributes.builtInAndReady && sourceList_Data.attributes.mediumIsReadable && sourceList_Data.attributes.mediaIsPlayable;
    }

    private SourceList_Data findSourceListData(int n) {
        return this.fullSourceList != null ? (SourceList_Data)this.fullSourceList.getElement(n) : null;
    }

    private void activateRadioBand(int n) {
        ASLRadio.activateBand(n);
        if (this.getCurrentAudioComponent() != 1) {
            ASLSound.setCurrentAudioComponent(1);
        }
    }

    private boolean performSwitchSource(SourceList_Data sourceList_Data, int n) {
        boolean bl = true;
        switch (sourceList_Data.sourceType) {
            case 2: {
                this.activateRadioBand(0);
                break;
            }
            case 1: {
                this.activateRadioBand(1);
                break;
            }
            case 3: {
                this.activateRadioBand(2);
                break;
            }
            case 4: 
            case 5: {
                this.activateRadioBand(3);
                break;
            }
            case 12: {
                ASLRadio.tpMemoEntered();
                break;
            }
            case 9: {
                ASLSound.setCurrentAudioComponent(5);
                break;
            }
            case 6: 
            case 7: 
            case 8: 
            case 10: 
            case 11: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 18: 
            case 19: 
            case 21: 
            case 22: 
            case 29: {
                ASLAVDCAudio.activateAudioSourceByID(n);
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    @Override
    protected void nextAudioSource() {
        SourceList_Data sourceList_Data;
        int n = this.requestedSourceListReference;
        do {
            if ((n = this.fullSourceList.nextBapPosID(n)) != 0) continue;
            n = this.fullSourceList.firstBAPPosID();
        } while (!this.canPerformSwitchSource(sourceList_Data = this.findSourceListData(n)));
        this.performSwitchSource(sourceList_Data, (int)this.fullSourceList.getElementAnchorID(n));
        this.requestedSourceListReference = n;
    }

    protected void nextAudioComponentFromMedia() {
        if (ServiceManager.serviceManager.configurationManager.isFeatureFlagSet(425)) {
            ASLSound.activateTvSource();
        } else {
            ASLSound.activateRadioSource();
        }
    }

    @Override
    protected void nextAudioComponent() {
        int n = this.getCurrentAudioComponent();
        switch (n) {
            case 1: {
                ASLSound.activateMediaSource();
                break;
            }
            case 2: {
                this.nextAudioComponentFromMedia();
                break;
            }
            case 5: {
                ASLSound.activateRadioSource();
                break;
            }
            default: {
                ASLSound.activateRadioSource();
            }
        }
    }
}

