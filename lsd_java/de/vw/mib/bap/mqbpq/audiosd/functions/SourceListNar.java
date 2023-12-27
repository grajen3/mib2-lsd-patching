/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.audiosd.functions;

import de.vw.mib.bap.mqbpq.audiosd.functions.SourceList;
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayList;
import de.vw.mib.bap.mqbpq.generated.audiosd.serializer.SourceList_Data;

public class SourceListNar
extends SourceList {
    @Override
    protected void addAdditionalBroadcastSources(BAPArrayList bAPArrayList) {
        SourceList_Data sourceList_Data = new SourceList_Data(null);
        sourceList_Data.sourceType = 5;
        sourceList_Data.instance_Id = 0;
        sourceList_Data.mediaType = 10;
        sourceList_Data.attributes.builtInAndReady = true;
        sourceList_Data.attributes.mediumAudioNoError = true;
        sourceList_Data.attributes.mediaIsPlayable = true;
        sourceList_Data.attributes.mediumIsReadable = true;
        sourceList_Data.attributes.mediumIsNotBeingLoaded = true;
        sourceList_Data.attributes.noImportRunning = true;
        sourceList_Data.name.setContent("");
        bAPArrayList.putElement(-5L, sourceList_Data, 0L);
    }
}

