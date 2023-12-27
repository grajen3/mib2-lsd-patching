/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.audiosd.functions;

import de.vw.mib.bap.mqbab2.audiosd.functions.SourceList;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListComplete;
import de.vw.mib.bap.mqbab2.generated.audiosd.serializer.SourceList_Data;

public class SourceListNar
extends SourceList {
    @Override
    protected void addAdditionalBroadcastSources(FsgArrayListComplete fsgArrayListComplete) {
        SourceList_Data sourceList_Data = new SourceList_Data(null);
        sourceList_Data.sourceType = 5;
        sourceList_Data.instance_Id = 0;
        sourceList_Data.mediaType = 10;
        sourceList_Data.attributes.builtInAndReadyMediumInserted = true;
        sourceList_Data.attributes.mediumAudioNoError = true;
        sourceList_Data.attributes.mediaIsPlayable = true;
        sourceList_Data.attributes.mediumIsReadable = true;
        sourceList_Data.attributes.mediumIsNotBeingLoaded = true;
        sourceList_Data.attributes.noImportRunning = true;
        sourceList_Data.attributes.mediumSupportBrowserListDf4_2 = true;
        sourceList_Data.name.setContent("");
        fsgArrayListComplete.putElement(-5L, sourceList_Data, 0L);
    }
}

