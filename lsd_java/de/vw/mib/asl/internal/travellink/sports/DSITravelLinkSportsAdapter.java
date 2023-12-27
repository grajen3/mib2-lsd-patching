/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.sports;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSportsTeamListCollector;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.travellink.GenericProperty;

public final class DSITravelLinkSportsAdapter {
    public void requestSportChangeLeague(int n) {
        try {
            int n2 = 12;
            boolean bl = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[]{new GenericProperty()};
            genericPropertyArray[0].valuesInt = new int[]{n};
            genericPropertyArray[0].key = 1612194560;
            int n3 = 200;
            int n4 = -1;
            boolean bl2 = true;
            boolean bl3 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(12, 1, genericPropertyArray, 200, -1, 1);
            if (!bl3) {
                int n5 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(12);
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(12, 1, genericPropertyArray, 200, -1, 1, n5);
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateSportsLeague(null);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestFavoriteTeams() {
        try {
            int n = 52;
            boolean bl = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[]{};
            int n2 = 20;
            int n3 = -1;
            boolean bl2 = true;
            boolean bl3 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(52, 1, genericPropertyArray, 20, -1, 1);
            if (!bl3) {
                int n4 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(52);
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(52, 1, genericPropertyArray, 20, -1, 1, n4);
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateFavoriteTeam(null, false);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestSportHeadToHeadGames(int n, int n2, boolean bl, int n3) {
        try {
            int n4 = 2;
            boolean bl2 = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[4];
            genericPropertyArray[0] = new GenericProperty();
            genericPropertyArray[0].valuesInt = new int[]{n};
            genericPropertyArray[0].key = -1944509696;
            genericPropertyArray[1] = new GenericProperty();
            genericPropertyArray[1].valuesInt = new int[]{n2};
            genericPropertyArray[1].key = -1927732480;
            genericPropertyArray[2] = new GenericProperty();
            genericPropertyArray[2].valuesBoolean = new boolean[]{bl};
            genericPropertyArray[2].key = -1910955264;
            genericPropertyArray[3] = new GenericProperty();
            genericPropertyArray[3].valuesInt = new int[]{n3};
            genericPropertyArray[3].key = -1894178048;
            int n5 = 200;
            int n6 = 20;
            int n7 = -1;
            int n8 = -1;
            boolean bl3 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(2, 1, genericPropertyArray, 200, 20, -1);
            if (n == 4) {
                TLinkServiceManager.getServiceManager().getSports().setGameTypeRequested(2);
            } else if (bl) {
                TLinkServiceManager.getServiceManager().getSports().setGameTypeRequested(1);
            } else {
                TLinkServiceManager.getServiceManager().getSports().setGameTypeRequested(3);
            }
            if (!bl3) {
                if (TLinkServiceManager.getServiceManager().getDsiProxy().isUpdateActive(5)) {
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkMainAdapter().requestStopUpdates(new int[]{5});
                }
                if (n == 4) {
                    n8 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(53);
                    TLinkServiceManager.getServiceManager().getGuiControllerSports().updateFavoriteGamesForMainViewCollector(null);
                    TLinkServiceManager.getServiceManager().getGuiControllerSports().updateSportsLoadingStateForMainView(1);
                } else if (bl) {
                    n8 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(46);
                    TLinkServiceManager.getServiceManager().getGuiControllerSports().clearHeadToHeadFavoritesGameList();
                } else {
                    n8 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(45);
                    TLinkServiceManager.getServiceManager().getGuiControllerSports().clearHeadToHeadGameList();
                }
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(2, 1, genericPropertyArray, 200, 20, -1, n8);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestStopUpdatesForSportsNews() {
        int[] nArray = new int[]{11};
        TLinkServiceManager.getServiceManager().getDsiTravelLinkMainAdapter().requestStopUpdates(nArray);
    }

    public void requestStopUpdatesForRankedListEventList() {
        int[] nArray = new int[]{5};
        TLinkServiceManager.getServiceManager().getDsiTravelLinkMainAdapter().requestStopUpdates(nArray);
    }

    public void requestStopUpdatesForRankedListEventRankings() {
        int[] nArray = new int[]{6};
        TLinkServiceManager.getServiceManager().getDsiTravelLinkMainAdapter().requestStopUpdates(nArray);
    }

    public void requestStopUpdatesForRankedListEventRankingsFinal() {
        int[] nArray = new int[]{7};
        TLinkServiceManager.getServiceManager().getDsiTravelLinkMainAdapter().requestStopUpdates(nArray);
    }

    public void requestStopUpdatesForRankedListEventInfo() {
        int[] nArray = new int[]{8};
        TLinkServiceManager.getServiceManager().getDsiTravelLinkMainAdapter().requestStopUpdates(nArray);
    }

    public void requestStopUpdatesForHeadToHeadGameList() {
        int[] nArray = new int[]{2};
        TLinkServiceManager.getServiceManager().getDsiTravelLinkMainAdapter().requestStopUpdates(nArray);
    }

    public void requestStopUpdatesForChangeLeague() {
        int[] nArray = new int[]{12};
        TLinkServiceManager.getServiceManager().getDsiTravelLinkMainAdapter().requestStopUpdates(nArray);
    }

    public void requestSportRankedEventList(int n, int n2, int n3) {
        try {
            int n4 = 5;
            boolean bl = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[2];
            genericPropertyArray[0] = new GenericProperty();
            genericPropertyArray[0].valuesInt = new int[]{n};
            genericPropertyArray[0].key = 1410999040;
            genericPropertyArray[1] = new GenericProperty();
            genericPropertyArray[1].valuesInt = new int[]{n3};
            genericPropertyArray[1].key = 1427776256;
            int n5 = 100;
            int n6 = 20;
            int n7 = -1;
            boolean bl2 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(5, 1, genericPropertyArray, 100, 20, -1);
            if (!bl2) {
                if (TLinkServiceManager.getServiceManager().getDsiProxy().isUpdateActive(2)) {
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkMainAdapter().requestStopUpdates(new int[]{2});
                }
                int n8 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(5);
                TLinkServiceManager.getServiceManager().getGuiControllerSports().clearSportsRankedEventList();
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(5, 1, genericPropertyArray, 100, 20, -1, n8);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestSportRankedListEventRankings(int n) {
        try {
            int n2 = 6;
            boolean bl = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[]{new GenericProperty()};
            genericPropertyArray[0].valuesInt = new int[]{n};
            genericPropertyArray[0].key = -2145705216;
            int n3 = 100;
            int n4 = 20;
            int n5 = -1;
            boolean bl2 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(6, 1, genericPropertyArray, 100, 20, -1);
            if (!bl2) {
                int n6 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(6);
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(6, 1, genericPropertyArray, 100, 20, -1, n6);
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateSportsRankedListEventRankings(null);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestSportAddFavoriteTeam(int n, int n2) {
        try {
            int n3 = 15;
            boolean bl = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[2];
            genericPropertyArray[0] = new GenericProperty();
            genericPropertyArray[0].valuesInt = new int[]{n};
            genericPropertyArray[0].key = -1407442176;
            genericPropertyArray[1] = new GenericProperty();
            genericPropertyArray[1].valuesInt = new int[]{n2};
            genericPropertyArray[1].key = -1373887744;
            boolean bl2 = true;
            int n4 = -1;
            boolean bl3 = true;
            boolean bl4 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(15, 1, genericPropertyArray, 1, -1, 1);
            if (!bl4) {
                int n5 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(15);
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(15, 1, genericPropertyArray, 1, -1, 1, n5);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestSportAddOrDeleteFavoriteTeam(EventGeneric eventGeneric) {
        try {
            int n = TLinkServiceManager.getServiceManager().getSports().getSetupSportsRequestStatus();
            if (2 == n) {
                int n2 = eventGeneric.getInt(0);
                Object[] objectArray = ListManager.getGenericASLList(-180411648).getDSIObjects();
                if (null == objectArray || objectArray.length < 1) {
                    return;
                }
                TravelLinkSportsTeamListCollector[] travelLinkSportsTeamListCollectorArray = (TravelLinkSportsTeamListCollector[])objectArray;
                if (null != travelLinkSportsTeamListCollectorArray && n2 > -1 && n2 < travelLinkSportsTeamListCollectorArray.length && null != travelLinkSportsTeamListCollectorArray[n2]) {
                    int n3 = travelLinkSportsTeamListCollectorArray[n2].teamId;
                    boolean bl = travelLinkSportsTeamListCollectorArray[n2].isTeamFavorite;
                    String string = travelLinkSportsTeamListCollectorArray[n2].teamName;
                    TLinkServiceManager.getServiceManager().getGuiControllerSports().setSportsTeamNameForSetupPopUp(string);
                    if (bl) {
                        TLinkServiceManager.getServiceManager().getSports().setSetupSportsRequestStatus(1);
                        this.requestSportDeleteFavoriteTeam(n3, TLinkServiceManager.getServiceManager().getSports().getSetupSportsSelectedLeagueId());
                    } else {
                        int n4 = TLinkServiceManager.getServiceManager().getSports().getSetupSportsNumberOfFavoriteTeams();
                        if (n4 < 20 && n4 >= -1) {
                            TLinkServiceManager.getServiceManager().getSports().setSetupSportsRequestStatus(1);
                            this.requestSportAddFavoriteTeam(n3, TLinkServiceManager.getServiceManager().getSports().getSetupSportsSelectedLeagueId());
                        } else if (n4 == 20) {
                            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-1824578816);
                        }
                    }
                }
            } else {
                ServiceManager.logger2.error(32).append("DSITravelLinkSportsAdapter - requestSportAddOrDeleteFavoriteTeam ").append("HMI is waiting for response from application").append(")").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestSportAddFavoriteTeam(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            Object[] objectArray = ListManager.getGenericASLList(-180411648).getDSIObjects();
            if (null == objectArray || objectArray.length < 1) {
                return;
            }
            TravelLinkSportsTeamListCollector[] travelLinkSportsTeamListCollectorArray = (TravelLinkSportsTeamListCollector[])objectArray;
            if (null != travelLinkSportsTeamListCollectorArray && n > -1 && n < travelLinkSportsTeamListCollectorArray.length && null != travelLinkSportsTeamListCollectorArray[n]) {
                int n2 = travelLinkSportsTeamListCollectorArray[n].teamId;
                String string = travelLinkSportsTeamListCollectorArray[n].teamName;
                TLinkServiceManager.getServiceManager().getGuiControllerSports().setSportsTeamNameForSetupPopUp(string);
                this.requestSportAddFavoriteTeam(n2, TLinkServiceManager.getServiceManager().getSports().getSetupSportsSelectedLeagueId());
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestSportDeleteFavoriteTeam(int n, int n2) {
        try {
            int n3 = 14;
            boolean bl = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[2];
            genericPropertyArray[0] = new GenericProperty();
            genericPropertyArray[0].valuesInt = new int[]{n};
            genericPropertyArray[0].key = 270344960;
            genericPropertyArray[1] = new GenericProperty();
            genericPropertyArray[1].valuesInt = new int[]{n2};
            genericPropertyArray[1].key = 287122176;
            boolean bl2 = true;
            int n4 = -1;
            boolean bl3 = true;
            boolean bl4 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(14, 1, genericPropertyArray, 1, -1, 1);
            if (!bl4) {
                int n5 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(14);
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(14, 1, genericPropertyArray, 1, -1, 1, n5);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestSportDeleteFavoriteTeam() {
        try {
            int n = TLinkServiceManager.getServiceManager().getSports().getSelectedTeamIdToDelete();
            int n2 = TLinkServiceManager.getServiceManager().getSports().getSelectedAffiliateIdToDelete();
            if (-1 != n && -1 != n2) {
                this.requestSportDeleteFavoriteTeam(n, n2);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestSportLeagueForFavorites() {
        try {
            int n = 37;
            boolean bl = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[]{};
            int n2 = 100;
            int n3 = -1;
            boolean bl2 = true;
            boolean bl3 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(37, 1, genericPropertyArray, 100, -1, 1);
            if (!bl3) {
                int n4 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(37);
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(37, 1, genericPropertyArray, 100, -1, 1, n4);
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateFavoriteTeamAffiliates(null);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestSportTeamsForFavorites(int n) {
        try {
            int n2 = 38;
            boolean bl = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[]{new GenericProperty()};
            genericPropertyArray[0].valuesInt = new int[]{n};
            genericPropertyArray[0].key = -669179136;
            int n3 = 100;
            int n4 = -1;
            boolean bl2 = true;
            boolean bl3 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(38, 1, genericPropertyArray, 100, -1, 1);
            if (!bl3) {
                int n5 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(38);
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(38, 1, genericPropertyArray, 100, -1, 1, n5);
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateSetupFavoritTeamListForSelectedLeague(null);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestSportRankedListEventRankingsFinal(int n) {
        try {
            int n2 = 7;
            boolean bl = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[]{new GenericProperty()};
            genericPropertyArray[0].valuesInt = new int[]{n};
            genericPropertyArray[0].key = -467983616;
            int n3 = 100;
            int n4 = 20;
            int n5 = -1;
            boolean bl2 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(7, 1, genericPropertyArray, 100, 20, -1);
            if (!bl2) {
                int n6 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(7);
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(7, 1, genericPropertyArray, 100, 20, -1, n6);
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateSportsRankedListEventRankingsFinal(null);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestSportRankedListEventInfo(int n) {
        try {
            int n2 = 8;
            boolean bl = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[]{new GenericProperty()};
            genericPropertyArray[0].valuesInt = new int[]{n};
            genericPropertyArray[0].key = 1209803520;
            boolean bl2 = true;
            int n3 = 20;
            int n4 = -1;
            boolean bl3 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(8, 1, genericPropertyArray, 1, 20, -1);
            if (!bl3) {
                int n5 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(8);
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(8, 1, genericPropertyArray, 1, 20, -1, n5);
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateSportsRankedListEventInfo(null);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestSportsNews(int n) {
        try {
            int n2 = 11;
            boolean bl = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[]{new GenericProperty()};
            genericPropertyArray[0].valuesInt = new int[]{n};
            genericPropertyArray[0].key = 672736000;
            int n3 = 200;
            int n4 = 20;
            int n5 = -1;
            boolean bl2 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(11, 1, genericPropertyArray, 200, 20, -1);
            if (!bl2) {
                int n6 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(11);
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(11, 1, genericPropertyArray, 200, 20, -1, n6);
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateSportsNews(null);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}

