/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSportsTeamListCollector;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkSetupSportsSelectteamLevelOneListTransformer;

public class TravelLinkSetupSportsSelectteamLevelOneListTransformer
extends AbstractTravelLinkSetupSportsSelectteamLevelOneListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        TravelLinkSportsTeamListCollector travelLinkSportsTeamListCollector = (TravelLinkSportsTeamListCollector)object;
        switch (n) {
            case 1: {
                return travelLinkSportsTeamListCollector.isTeamFavorite;
            }
        }
        throw new IllegalArgumentException();
    }

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

