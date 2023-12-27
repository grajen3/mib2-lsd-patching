/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSportsLeagueNewsCollector;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkSelectedLeagueNewsTransformer;

public final class TravelLinkSelectedLeagueNewsTransformer
extends AbstractTravelLinkSelectedLeagueNewsTransformer {
    @Override
    public String getString(int n, Object object) {
        TravelLinkSportsLeagueNewsCollector travelLinkSportsLeagueNewsCollector = (TravelLinkSportsLeagueNewsCollector)object;
        switch (n) {
            case 0: {
                return travelLinkSportsLeagueNewsCollector.leagueNewsColumn1;
            }
        }
        throw new IllegalArgumentException();
    }
}

