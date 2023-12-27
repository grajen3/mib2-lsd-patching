/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSportsTeamListCollector;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkSetSpoAddNewFavSelLea_TeaNam2310095Transformer;

public final class TravelLinkSetSpoAddNewFavSelLea_TeaNam2310095Transformer
extends AbstractTravelLinkSetSpoAddNewFavSelLea_TeaNam2310095Transformer {
    @Override
    public String getString(int n, Object object) {
        TravelLinkSportsTeamListCollector travelLinkSportsTeamListCollector = (TravelLinkSportsTeamListCollector)object;
        switch (n) {
            case 0: {
                return travelLinkSportsTeamListCollector.teamName;
            }
        }
        throw new IllegalArgumentException();
    }
}

