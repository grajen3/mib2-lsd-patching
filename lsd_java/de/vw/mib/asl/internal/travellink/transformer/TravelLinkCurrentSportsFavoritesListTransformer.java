/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSportsFavoriteGamesMainViewCollector;
import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkCurrentSportsFavoritesListTransformer;

public class TravelLinkCurrentSportsFavoritesListTransformer
extends AbstractTravelLinkCurrentSportsFavoritesListTransformer {
    @Override
    public int getInt(int n, Object object) {
        TravelLinkSportsFavoriteGamesMainViewCollector travelLinkSportsFavoriteGamesMainViewCollector = (TravelLinkSportsFavoriteGamesMainViewCollector)object;
        switch (n) {
            case 1: {
                return travelLinkSportsFavoriteGamesMainViewCollector.gameStatusColumn1;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        TravelLinkSportsFavoriteGamesMainViewCollector travelLinkSportsFavoriteGamesMainViewCollector = (TravelLinkSportsFavoriteGamesMainViewCollector)object;
        switch (n) {
            case 2: {
                return travelLinkSportsFavoriteGamesMainViewCollector.gameScoreOrTimeColumn3;
            }
            case 0: {
                return travelLinkSportsFavoriteGamesMainViewCollector.gameNamesColumn2;
            }
        }
        throw new IllegalArgumentException();
    }
}

