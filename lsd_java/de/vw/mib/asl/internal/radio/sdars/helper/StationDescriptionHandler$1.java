/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import de.vw.mib.asl.internal.radio.sat.transformer.SimilarContentCollector;
import de.vw.mib.asl.internal.radio.sdars.helper.StationDescriptionHandler;
import java.util.Comparator;

class StationDescriptionHandler$1
implements Comparator {
    private final /* synthetic */ StationDescriptionHandler this$0;

    StationDescriptionHandler$1(StationDescriptionHandler stationDescriptionHandler) {
        this.this$0 = stationDescriptionHandler;
    }

    @Override
    public int compare(Object object, Object object2) {
        SimilarContentCollector similarContentCollector = (SimilarContentCollector)object;
        SimilarContentCollector similarContentCollector2 = (SimilarContentCollector)object2;
        if (similarContentCollector.mChannel.stationNumber > similarContentCollector2.mChannel.stationNumber) {
            return 1;
        }
        if (similarContentCollector.mChannel.stationNumber < similarContentCollector2.mChannel.stationNumber) {
            return -1;
        }
        return 0;
    }
}

