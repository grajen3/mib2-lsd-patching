/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.sports;

import de.vw.mib.asl.api.radio.ASLRadioAPI;
import de.vw.mib.asl.api.radio.ASLRadioFactory;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.DataProcessor;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import de.vw.mib.asl.internal.travellink.sports.Team;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.ArrayList;
import java.util.Iterator;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.travellink.GenericPropertyContainer;
import org.dsi.ifc.travellink.TravelLinkDate;
import org.dsi.ifc.travellink.Values;

public final class Sports
implements DataProcessor {
    public static final int SPORTS_TEAM_INVALID_ID;
    private final int CHANGELEAGUE_MAXIMUM_LEVEL;
    private int folderLevelSetupFavoriteTeam = -1;
    private int folderLevelChangeLeague = -1;
    private int[] changeLeagueID = new int[10];
    private String[] changeLeagueName = new String[10];
    private int gameListSelectedIndex = 0;
    private int selectedSportsIDForRankedEventList = -1;
    private int gameTypeRequested = -1;
    public static final int CHANGE_LEAGUE_FOLDER_LEVEL_1;
    public static final int CHANGE_LEAGUE_FOLDER_LEVEL_ROOT;
    public static final int CHANGELEAGUE_AFFILATE_ID_FOR_GROUNDLEVEL_ROOT;
    public static final String CHANGELEAGUE_AFFILATE_NAME_FOR_GROUNDLEVEL_ROOT;
    public static final int FAVORITES_HEAD_TO_HEAD_GAMES_AFFILATE_ID;
    public static final int HEAD_TO_HEAD_GAMES_GAME_ID_FOR_ALL_GAMES;
    public static final int HEAD_TO_HEAD_GAMES_GAME_ID_FOR_FAVORITE_GAMES;
    public static final boolean HEAD_TO_HEAD_GAMES_FAVORITES;
    public static final boolean HEAD_TO_HEAD_GAMES_NOT_FAVORITES;
    public static final int NUMBER_OF_ELEMENTS_IN_MAIN_VIEW;
    public static final int HEAD_TO_HEAD_GAMES_REQUESTED_UNKNOWN;
    public static final int HEAD_TO_HEAD_GAMES_REQUESTED_FAVORITES;
    public static final int HEAD_TO_HEAD_GAMES_REQUESTED_FAVORITES_MAIN_VIEW;
    public static final int HEAD_TO_HEAD_GAMES_REQUESTED_HEAD_TO_HEAD;
    private int selectedRankedEventId = -1;
    private int selectedTeamIdToDelete = -1;
    private int selectedAffiliateIdToDelete = -1;
    public static final int SETUP_SPORTS_SELECTED_LEAGUE_ID_UNKNOWN;
    private int setupSportsSelectedLeagueId = -1;
    public static final int SETUP_SPORTS_REQUESTSTATUS_PROGRESS;
    public static final int SETUP_SPORTS_REQUESTSTATUS_COMPLETED;
    private int setupSportsRequestStatus = 2;
    public static final int SETUP_SPORTS_NUMBEROFFAVORITETEAM_UNKNOWN;
    private int setupSportsNumberOfFavoriteTeams = -1;
    public static final int MAIN_SPORTS_ENTRY_UNKNOWN;
    public static final int MAIN_SPORTS_ENTRY_FAVORITES;
    public static final int MAIN_SPORTS_ENTRY_FOOTER;
    public int sportsEntry = 0;
    private boolean sportsRankedEventDataReceived = false;
    ArrayList favoriteTeamList = new ArrayList();

    public Sports() {
        this.CHANGELEAGUE_MAXIMUM_LEVEL = 10;
    }

    @Override
    public void processAndUpdate(int n, GenericPropertyContainer[] genericPropertyContainerArray, int n2, int n3) {
        switch (n) {
            case 15: {
                TLinkServiceManager.getServiceManager().getSports().setSetupSportsRequestStatus(2);
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateSetupAddFavoriteResultStatus(n2);
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateTeamListWithAddFavoriteTeam(genericPropertyContainerArray, n2);
                break;
            }
            case 14: {
                TLinkServiceManager.getServiceManager().getSports().setSetupSportsRequestStatus(2);
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateTeamListWithDeleteFavoriteTeam(genericPropertyContainerArray, n2);
                TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestFavoriteTeams();
                break;
            }
            case 52: {
                TLinkServiceManager.getServiceManager().getDatapool().put(52, genericPropertyContainerArray);
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateFavoriteTeam(genericPropertyContainerArray, true);
                this.updateFavoriteTeamIcons(genericPropertyContainerArray);
                break;
            }
            case 37: {
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateFavoriteTeamAffiliates(genericPropertyContainerArray);
                break;
            }
            case 38: {
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateSetupFavoritTeamListForSelectedLeague(genericPropertyContainerArray);
                break;
            }
            case 12: {
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateSportsLeague(genericPropertyContainerArray);
                break;
            }
            case 11: {
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateSportsNews(genericPropertyContainerArray);
                break;
            }
            case 46: {
                int n4 = TLinkServiceManager.getServiceManager().getSports().getGameTypeRequested();
                if (1 != n4) break;
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateSportsHeadtoHeadFavoritesGamesList(genericPropertyContainerArray, n2);
                break;
            }
            case 53: {
                int n5 = TLinkServiceManager.getServiceManager().getSports().getGameTypeRequested();
                if (2 != n5) break;
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateFavoriteGamesForMainView(genericPropertyContainerArray, n2);
                break;
            }
            case 45: {
                int n6 = TLinkServiceManager.getServiceManager().getSports().getGameTypeRequested();
                if (3 != n6) break;
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateSportsHeadtoHeadGamesList(genericPropertyContainerArray, n2);
                break;
            }
            case 5: {
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateSportsRankedEventList(genericPropertyContainerArray, n2);
                break;
            }
            case 6: {
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateSportsRankedListEventRankings(genericPropertyContainerArray);
                break;
            }
            case 7: {
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateSportsRankedListEventRankingsFinal(genericPropertyContainerArray);
                break;
            }
            case 8: {
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateSportsRankedListEventInfo(genericPropertyContainerArray);
                break;
            }
            default: {
                if (!ServiceManager.logger2.isTraceEnabled(32)) break;
                ServiceManager.logger2.error(32).append("Sports : processAndUpdate : RequestType is not handled. RequestTypeID --> ").append(n).log();
            }
        }
    }

    public int getDsiTimeFrameValues(int n) {
        if (n == 0) {
            return 3;
        }
        if (n == 1) {
            return 2;
        }
        if (n == 2) {
            return 0;
        }
        return 3;
    }

    public void requestAndUpdateGameListWithTimeFrame(int n) {
        int n2 = TLinkServiceManager.getServiceManager().getCurrentViewId();
        int n3 = TLinkServiceManager.getServiceManager().getSports().getSportsEntry();
        TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setListTimeFrameForHeadToHeadGames(n);
        TLinkServiceManager.getServiceManager().getGuiControllerSports().setTimeFrame(n);
        int n4 = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getSportsSelectedChangeLeagueType();
        if (ServiceManager.logger2.isTraceEnabled(32)) {
            ServiceManager.logger2.trace(32).append("Sports : requestAndUpdateSportsTimeFrame : Time frame value is  ").append(n).log();
        }
        int n5 = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getSportsSelectedChangeLeagueSportsId();
        int n6 = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getSportsSelectedChangeLeague();
        String string = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getSportsSelectedChangeLeagueName();
        if (32 == n2 && 1 == n3) {
            TLinkServiceManager.getServiceManager().getSports().requestAndUpdateGameListForMiniViewEntryToFavoriteList(n);
            TLinkServiceManager.getServiceManager().getGuiControllerSports().setTimeFrame(n);
        } else {
            TLinkServiceManager.getServiceManager().getSports().requestAndUpdateGameListWithAllGameType(n, n5, string, n4, n6);
        }
    }

    public void requestAndUpdateGameListForMiniViewEntryToFavoriteList(int n) {
        TLinkServiceManager.getServiceManager().getGuiControllerSports().setTimeFrame(n);
        TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestSportHeadToHeadGames(n, -1, true, -1);
        if (ServiceManager.logger2.isTraceEnabled(32)) {
            ServiceManager.logger2.trace(32).append("Sports : requestAndUpdateGameListForMiniViewEntryToFavoriteList : Favorite Head to Head game list requested ").log();
        }
    }

    public void requestAndUpdateGameListWithAllGameType() {
        int n = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getListTimeframeForHeadToHeadGames();
        TLinkServiceManager.getServiceManager().getGuiControllerSports().setTimeFrame(n);
        int n2 = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getSportsSelectedChangeLeagueSportsId();
        int n3 = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getSportsSelectedChangeLeague();
        String string = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getSportsSelectedChangeLeagueName();
        int n4 = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getSportsSelectedChangeLeagueType();
        TLinkServiceManager.getServiceManager().getSports().requestAndUpdateGameListWithAllGameType(n, n2, string, n4, n3);
        if (ServiceManager.logger2.isTraceEnabled(32)) {
            ServiceManager.logger2.trace(32).append("Enter sport view through sports button in the footer").log();
        }
    }

    public void requestAndUpdateGameListWithAllGameType(int n, int n2, String string, int n3, int n4) {
        if (ServiceManager.logger2.isTraceEnabled(32)) {
            ServiceManager.logger2.trace(32).append("Sports : requestAndUpdateGameListWithAllGameType :  timeFrame - ").append(n).log();
            ServiceManager.logger2.trace(32).append("sportsId - ").append(n2).log();
            ServiceManager.logger2.trace(32).append("leagueName - ").append(string).log();
            ServiceManager.logger2.trace(32).append("leagueType - ").append(n3).log();
            ServiceManager.logger2.trace(32).append("leagueId - ").append(n4).log();
        }
        TLinkServiceManager.getServiceManager().getGuiControllerSports().setTimeFrame(n);
        TLinkServiceManager.getServiceManager().getGuiControllerSports().updateSportsHeadline(n2, string);
        if (n3 == 1) {
            TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestSportHeadToHeadGames(n, n4, false, -1);
            if (ServiceManager.logger2.isTraceEnabled(32)) {
                ServiceManager.logger2.trace(32).append("Sports : requestAndUpdateGameListWithAllGameType : Head to Head game list requested ").log();
            }
        } else if (n3 == 0) {
            TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestSportHeadToHeadGames(n, -1, true, -1);
            if (ServiceManager.logger2.isTraceEnabled(32)) {
                ServiceManager.logger2.trace(32).append("Sports : requestAndUpdateGameListWithAllGameType : Favorite Head to Head game list requested ").log();
            }
        } else if (n3 == 2) {
            TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestSportRankedEventList(n, n3, n4);
            if (ServiceManager.logger2.isTraceEnabled(32)) {
                ServiceManager.logger2.trace(32).append("Sports : requestAndUpdateGameListWithAllGameType : Ranked events list requested ").log();
            }
        } else if (n3 == 3) {
            TLinkServiceManager.getServiceManager().getGuiControllerSports().updateSelectedLeagueType(3);
        }
    }

    public void requestAndUpdateSelectedId(EventGeneric eventGeneric) {
        try {
            if (this.folderLevelChangeLeague + 1 < this.changeLeagueID.length && this.folderLevelChangeLeague + 1 < this.changeLeagueName.length) {
                int n = eventGeneric.getInt(0);
                Object[] objectArray = ListManager.getGenericASLList(-1975573760).getDSIObjects();
                if (null == objectArray || objectArray.length < 1) {
                    return;
                }
                GenericPropertyContainer[] genericPropertyContainerArray = (GenericPropertyContainer[])objectArray;
                if (null != genericPropertyContainerArray && n > -1 && n < genericPropertyContainerArray.length && null != genericPropertyContainerArray[n]) {
                    boolean bl = GenericPropertyUtility.getBoolean(-460127232, 0, genericPropertyContainerArray[n]);
                    int n2 = GenericPropertyUtility.getInt(-443350016, 0, genericPropertyContainerArray[n]);
                    int n3 = GenericPropertyUtility.getInt(-527236096, 0, genericPropertyContainerArray[n]);
                    int n4 = GenericPropertyUtility.getInt(-493681664, 0, genericPropertyContainerArray[n]);
                    String string = GenericPropertyUtility.getString(-476904448, 0, genericPropertyContainerArray[n]);
                    if (bl) {
                        this.setFolderLevelChangeLeague(this.getFolderLevelChangeLeague() + 1);
                        TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestSportChangeLeague(n3);
                        TLinkServiceManager.getServiceManager().getGuiControllerSports().updateChangeLeagueHeadline(string);
                        TLinkServiceManager.getServiceManager().getGuiControllerSports().updateChangeLeagueSportsIdHeadline(n4);
                        TLinkServiceManager.getServiceManager().getGuiControllerSports().updateSportsHeadline(n4, string);
                        this.setLeagueIdForLevel(this.getFolderLevelChangeLeague(), n3);
                        this.setLeagueNameForLevel(this.getFolderLevelChangeLeague(), string);
                    } else {
                        TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setSportsSelectedChangeLeagueType(n2);
                        TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setSportsSelectedChangeLeague(n3);
                        TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setSportsSelectedChangeLeagueSportsId(n4);
                        TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setSportsSelectedChangeLeagueName(string);
                        TLinkServiceManager.getServiceManager().getGuiControllerSports().updateSelectedLeagueType(n2);
                        int n5 = TLinkServiceManager.getServiceManager().getSports().getOldDsiSportId(n4);
                        TLinkServiceManager.getServiceManager().getGuiControllerSports().updateSelectedLeaguesWithDsiSportsId(n5);
                        int n6 = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getListTimeframeForHeadToHeadGames();
                        TLinkServiceManager.getServiceManager().getSports().requestAndUpdateGameListWithAllGameType(n6, n4, string, n2, n3);
                    }
                }
            } else if (ServiceManager.logger2.isTraceEnabled(32)) {
                ServiceManager.logger2.error(32).append(" Folder level exceed 10 level in change league ").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateRankedListEventListHeadline() {
        int n = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getSportsSelectedChangeLeagueSportsId();
        String string = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getSportsSelectedChangeLeagueName();
        TLinkServiceManager.getServiceManager().getGuiControllerSports().updateSportsHeadline(n, string);
    }

    public void clearRankedListEventListHeadline() {
        int n = TLinkServiceManager.getServiceManager().getCurrentViewId();
        if (39 == n || 40 == n || 41 == n || 45 == n || 46 == n || 47 == n) {
            return;
        }
        int n2 = -1;
        String string = "";
        TLinkServiceManager.getServiceManager().getGuiControllerSports().updateSportsHeadline(-1, "");
    }

    public void updateSportsRankedListsEventsRankingHeadline(String string) {
        TLinkServiceManager.getServiceManager().getGuiControllerSports().updateSportsRankedListsEventsRankingHeadline(string);
    }

    public void clearSportsRankedListsEventsRankingHeadline() {
        int n = TLinkServiceManager.getServiceManager().getCurrentViewId();
        if (39 == n || 40 == n || 41 == n || 45 == n || 46 == n || 47 == n) {
            return;
        }
        String string = "";
        TLinkServiceManager.getServiceManager().getGuiControllerSports().updateSportsRankedListsEventsRankingHeadline("");
    }

    public void requestChangeLeagueLevel(int n) {
        this.setFolderLevelChangeLeague(n);
        n = this.getFolderLevelChangeLeague();
        if (null == this.changeLeagueID && null == this.changeLeagueName) {
            if (ServiceManager.logger2.isTraceEnabled(32)) {
                ServiceManager.logger2.error(32).append(" requestChangeLeagueLevel() - null == changeLeagueID or null == changeLeagueName, folderLevel = ").append(n).log();
            }
            return;
        }
        if (this.changeLeagueID.length > n && n > -1) {
            int n2 = this.changeLeagueID[n];
            TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestSportChangeLeague(n2);
        } else if (ServiceManager.logger2.isTraceEnabled(32)) {
            ServiceManager.logger2.error(32).append(" requestChangeLeagueLevel() - changeLeagueID.length <= folderLevel, folderLevel = ").append(n).log();
        }
        if (this.changeLeagueName.length > n && n > -1) {
            String string = this.changeLeagueName[n];
            if (null != string) {
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateChangeLeagueHeadline(string);
            }
        } else if (ServiceManager.logger2.isTraceEnabled(32)) {
            ServiceManager.logger2.error(32).append(" requestChangeLeagueLevel() - changeLeagueName.length <= folderLevel, folderLevel = ").append(n).log();
        }
    }

    public void requestSportChangeLeague() {
        this.setFolderLevelChangeLeague(0);
        this.setLeagueIdForLevel(0, -1);
        this.setLeagueNameForLevel(0, "Sports");
        TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestSportChangeLeague(-1);
    }

    public void updateSportsDetails(EventGeneric eventGeneric) {
        try {
            int n;
            this.gameListSelectedIndex = n = eventGeneric.getInt(0);
            GenericPropertyContainer[] genericPropertyContainerArray = null;
            int n2 = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getSportsSelectedChangeLeagueType();
            Object[] objectArray = null;
            objectArray = n2 == 1 ? ListManager.getGenericASLList(-1170267392).getDSIObjects() : ListManager.getGenericASLList(-1187044608).getDSIObjects();
            if (null == objectArray || objectArray.length < 1) {
                return;
            }
            genericPropertyContainerArray = (GenericPropertyContainer[])objectArray;
            if (null != genericPropertyContainerArray && n > -1 && n < genericPropertyContainerArray.length && null != genericPropertyContainerArray[n]) {
                TLinkServiceManager.getServiceManager().getGuiControllerSports().prepareAndUpdateGameDetails(genericPropertyContainerArray[n]);
                int n3 = GenericPropertyUtility.getInt(513082368, 0, genericPropertyContainerArray[0]);
                int n4 = GenericPropertyUtility.getInt(496305152, 0, genericPropertyContainerArray[0]);
                int n5 = GenericPropertyUtility.getInt(529859584, 0, genericPropertyContainerArray[0]);
                if (ServiceManager.logger2.isTraceEnabled(32)) {
                    ServiceManager.logger2.trace(32).append("Sports : updateSportsDetails() : Visitor channel service id - ").append(n4).append(" : Home channel service id - ").append(n3).append(" : National Channel service id - ").append(n5).log();
                }
                ASLRadioAPI aSLRadioAPI = ASLRadioFactory.getRadioApi();
                boolean bl = false;
                boolean bl2 = false;
                boolean bl3 = false;
                if (n3 != -1) {
                    bl = aSLRadioAPI.isChannelAvailable(n3);
                }
                if (n4 != -1) {
                    bl2 = aSLRadioAPI.isChannelAvailable(n4);
                }
                if (n5 != -1) {
                    bl3 = aSLRadioAPI.isChannelAvailable(n5);
                }
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateChannelButtonStatus(bl2, bl, bl3);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestRankingInfo() {
        TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestSportRankedListEventInfo(this.getSelectedRankedEventId());
    }

    public void requestRankingInfo(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            Object[] objectArray = ListManager.getGenericASLList(-1119935744).getDSIObjects();
            if (null == objectArray || objectArray.length < 1) {
                return;
            }
            GenericPropertyContainer[] genericPropertyContainerArray = (GenericPropertyContainer[])objectArray;
            if (null != genericPropertyContainerArray && n > -1 && n < genericPropertyContainerArray.length && null != genericPropertyContainerArray[n]) {
                int n2 = GenericPropertyUtility.getInt(-627768320, 0, genericPropertyContainerArray[n]);
                int n3 = GenericPropertyUtility.getInt(-728431616, 0, genericPropertyContainerArray[n]);
                this.selectedSportsIDForRankedEventList = GenericPropertyUtility.getInt(-728431616, 0, genericPropertyContainerArray[n]);
                String string = GenericPropertyUtility.getString(-661322752, 0, genericPropertyContainerArray[n]);
                this.updateSportsRankedListsEventsRankingHeadline(string);
                int n4 = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getSportsSelectedChangeLeagueSportsId();
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateSportsHeadline(n4, string);
                this.setSelectedRankedEventId(n3);
                if (n2 == 2) {
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestSportRankedListEventRankings(n3);
                } else if (n2 == 3) {
                    TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestSportRankedListEventRankingsFinal(n3);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestandUpdateSelectedSportDetails(EventGeneric eventGeneric) {
        try {
            int n = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getSportsSelectedChangeLeagueType();
            if (n == 0 || n == 1) {
                this.updateSportsDetails(eventGeneric);
            } else if (n == 2) {
                this.requestRankingInfo(eventGeneric);
            } else if (ServiceManager.logger2.isTraceEnabled(32)) {
                ServiceManager.logger2.error(32).append(" Change League type value doesn't match the GUI enums ").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void playChannelWithChannelType(int n) {
        try {
            Object[] objectArray = null;
            int n2 = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getSportsSelectedChangeLeagueType();
            objectArray = n2 == 1 ? ListManager.getGenericASLList(-1170267392).getDSIObjects() : ListManager.getGenericASLList(-1187044608).getDSIObjects();
            if (null == objectArray || objectArray.length < 1) {
                return;
            }
            GenericPropertyContainer[] genericPropertyContainerArray = (GenericPropertyContainer[])objectArray;
            if (null != genericPropertyContainerArray && this.gameListSelectedIndex >= 0 && this.gameListSelectedIndex < genericPropertyContainerArray.length && null != genericPropertyContainerArray[this.gameListSelectedIndex]) {
                int n3 = 0;
                if (n == 0) {
                    n3 = GenericPropertyUtility.getInt(496305152, 0, genericPropertyContainerArray[this.gameListSelectedIndex]);
                } else if (n == 1) {
                    n3 = GenericPropertyUtility.getInt(513082368, 0, genericPropertyContainerArray[this.gameListSelectedIndex]);
                } else if (n == 2) {
                    n3 = GenericPropertyUtility.getInt(529859584, 0, genericPropertyContainerArray[this.gameListSelectedIndex]);
                }
                this.playChannelWithServiceId(n3);
            } else if (ServiceManager.logger2.isTraceEnabled(32)) {
                ServiceManager.logger2.trace(32).append("Gamelist is null. So, Cann't play the selected channel").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void playChannel(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            Object[] objectArray = ListManager.getGenericASLList(-1203821824).getDSIObjects();
            if (null == objectArray || objectArray.length < 1) {
                return;
            }
            GenericPropertyContainer[] genericPropertyContainerArray = (GenericPropertyContainer[])objectArray;
            if (null != genericPropertyContainerArray && n > -1 && n < genericPropertyContainerArray.length && null != genericPropertyContainerArray[n]) {
                int n2 = GenericPropertyUtility.getInt(596968448, 0, genericPropertyContainerArray[n]);
                this.playChannelWithServiceId(n2);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void playChannelWithServiceId(int n) {
        ASLRadioAPI aSLRadioAPI = ASLRadioFactory.getRadioApi();
        boolean bl = aSLRadioAPI.isChannelAvailable(n);
        if (ServiceManager.logger2.isTraceEnabled(32)) {
            ServiceManager.logger2.trace(32).append("Sports : playChannelWithServiceId() : Service id selected for playing the channel - ").append(n).log();
            ServiceManager.logger2.trace(32).append("Sports : playChannelWithServiceId() : Channel availability for service id - ").append(bl).log();
        }
        if (bl) {
            aSLRadioAPI.tuneSDARSStation(n);
            if (ServiceManager.logger2.isTraceEnabled(32)) {
                ServiceManager.logger2.trace(32).append("Sports : playChannelWithServiceId() : tune station with service id - ").append(n).log();
            }
        } else {
            ServiceManager.logger2.error(32).append(" Sports : playChannelWithServiceId() : Channel with service id ").append(n).append(" cannot be played. Because, Channel not available in SDARS ").log();
        }
    }

    public int getFolderLevelChangeLeague() {
        return this.folderLevelChangeLeague;
    }

    public void setFolderLevelChangeLeague(int n) {
        if (n < 0) {
            n = 0;
        }
        this.folderLevelChangeLeague = n;
        if (ServiceManager.logger2.isTraceEnabled(32)) {
            ServiceManager.logger2.trace(32).append("Sports : setFolderLevelChangeLeague(), folderLevelChangeLeague = ").append(this.folderLevelChangeLeague).log();
        }
    }

    public int getFolderLevelSetupFavoriteTeam() {
        return this.folderLevelSetupFavoriteTeam;
    }

    public void setFolderLevelSetupFavoriteTeam(int n) {
        this.folderLevelSetupFavoriteTeam = n;
    }

    public int getGameListSelectedIndex() {
        return this.gameListSelectedIndex;
    }

    public void setGameListSelectedIndex(int n) {
        this.gameListSelectedIndex = n;
    }

    public int getSelectedSportsIDForRankedEventList() {
        return this.selectedSportsIDForRankedEventList;
    }

    private void setLeagueIdForLevel(int n, int n2) {
        if (n < this.changeLeagueID.length && n >= 0) {
            this.changeLeagueID[n] = n2;
        }
    }

    private void setLeagueNameForLevel(int n, String string) {
        if (n < this.changeLeagueName.length && n >= 0) {
            this.changeLeagueName[n] = string;
        }
    }

    public void requestSportsNews() {
        int n = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getSportsSelectedChangeLeague();
        if (n != -1) {
            TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestSportsNews(n);
        } else if (ServiceManager.logger2.isTraceEnabled(32)) {
            ServiceManager.logger2.error(32, "No league is selected in the change league");
        }
    }

    public void requestSportHeadToHeadGamesForMiniView() {
        TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestSportHeadToHeadGames(4, -1, true, -1);
    }

    public int getSelectedRankedEventId() {
        return this.selectedRankedEventId;
    }

    public void setSelectedRankedEventId(int n) {
        this.selectedRankedEventId = n;
    }

    public void setGameTypeRequested(int n) {
        this.gameTypeRequested = n;
    }

    public int getGameTypeRequested() {
        return this.gameTypeRequested;
    }

    public int getSelectedTeamIdToDelete() {
        return this.selectedTeamIdToDelete;
    }

    public void setSelectedTeamIdToDelete(int n) {
        this.selectedTeamIdToDelete = n;
    }

    public int getSelectedAffiliateIdToDelete() {
        return this.selectedAffiliateIdToDelete;
    }

    public void setSelectedAffiliateIdToDelete(int n) {
        this.selectedAffiliateIdToDelete = n;
    }

    public int getHmiSportId(int n) {
        if (ServiceManager.logger2.isTraceEnabled(32)) {
            ServiceManager.logger2.trace(32).append("Sports - getHMISportId( ").append(n).append(" )").log();
        }
        switch (n) {
            case 1: {
                return 5;
            }
            case 2: {
                return 6;
            }
            case 3: {
                return 7;
            }
            case 4: {
                return 12;
            }
            case 5: {
                return 14;
            }
            case 6: {
                return 20;
            }
            case 7: {
                return 2;
            }
            case 8: {
                return 1;
            }
            case 9: {
                return 26;
            }
        }
        return -1;
    }

    public int getOldDsiSportId(int n) {
        switch (n) {
            case 1: {
                return 1;
            }
            case 2: {
                return 4;
            }
            case 3: {
                return 6;
            }
            case 4: {
                return 11;
            }
            case 5: {
                return 13;
            }
            case 6: {
                return 19;
            }
            case 7: {
                return 23;
            }
            case 8: {
                return 255;
            }
        }
        ServiceManager.logger2.error(32, "Sports : getHMISportId : Sports id from DSI not in range. So, Tennis icon will be displayed ! ");
        return 255;
    }

    public int getSetupSportsSelectedLeagueId() {
        return this.setupSportsSelectedLeagueId;
    }

    public void setSetupSportsSelectedLeagueId(int n) {
        this.setupSportsSelectedLeagueId = n;
    }

    public int getSetupSportsRequestStatus() {
        return this.setupSportsRequestStatus;
    }

    public void setSetupSportsRequestStatus(int n) {
        this.setupSportsRequestStatus = n;
    }

    public int getSetupSportsNumberOfFavoriteTeams() {
        return this.setupSportsNumberOfFavoriteTeams;
    }

    public void setSetupSportsNumberOfFavoriteTeams(int n) {
        this.setupSportsNumberOfFavoriteTeams = n;
    }

    public int getSportsEntry() {
        return this.sportsEntry;
    }

    public void setSportsEntry(int n) {
        this.sportsEntry = n;
    }

    public boolean isSportsRankedEventDataReceived() {
        return this.sportsRankedEventDataReceived;
    }

    public void setSportsRankedEventDataReceived(boolean bl) {
        this.sportsRankedEventDataReceived = bl;
    }

    public void updateFavoriteTeamIcons(GenericPropertyContainer[] genericPropertyContainerArray) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(32)) {
                ServiceManager.logger2.trace(32).append("Sports : updateFavoriteTeam()").log();
            }
            if (genericPropertyContainerArray == null || genericPropertyContainerArray.length < 1) {
                if (ServiceManager.logger2.isTraceEnabled(32)) {
                    ServiceManager.logger2.trace(32).append("Sports : updateFavoriteTeam(): The received data is either null or empty").log();
                }
            } else {
                this.favoriteTeamList.clear();
                for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
                    if (null == genericPropertyContainerArray[i2]) continue;
                    int n = TLinkServiceManager.getServiceManager().getSports().getHmiSportId(GenericPropertyUtility.getInt(-1114045440, 0, genericPropertyContainerArray[i2]));
                    String string = GenericPropertyUtility.getString(-1080491008, 0, genericPropertyContainerArray[i2]);
                    this.favoriteTeamList.add(new Team(n, string));
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public ArrayList getFavoriteTeamList() {
        return this.favoriteTeamList;
    }

    public void setFavoriteTeamList(ArrayList arrayList) {
        this.favoriteTeamList = arrayList;
    }

    public void prepareAndUpdateRadioText(boolean bl) {
        try {
            Object[] objectArray = ListManager.getGenericASLList(-1203821824).getDSIObjects();
            if (null == objectArray || objectArray.length < 1) {
                return;
            }
            ASLRadioAPI aSLRadioAPI = ASLRadioFactory.getRadioApi();
            if (null != aSLRadioAPI) {
                aSLRadioAPI.prepareRadioText(bl, new ArrayList());
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateSportsIdFromFavoriteTeamList(GenericPropertyContainer genericPropertyContainer) {
        try {
            Object object;
            Iterator iterator;
            int n = -1;
            String string = GenericPropertyUtility.getString(244646912, 0, genericPropertyContainer);
            String string2 = GenericPropertyUtility.getString(294978560, 0, genericPropertyContainer);
            if (null != this.favoriteTeamList && null != (iterator = this.favoriteTeamList.iterator())) {
                while (iterator.hasNext()) {
                    Team team = (Team)iterator.next();
                    if (null == team || null == (object = (Object)team.getTeamName()) || !((String)object).equals(string) && !((String)object).equals(string2)) continue;
                    n = team.getSportsId();
                    break;
                }
            }
            boolean bl = true;
            int n2 = genericPropertyContainer.keys.length + 1;
            object = new int[n2];
            object[n2 - 1] = 680854528;
            Values[] valuesArray = new Values[n2];
            valuesArray[n2 - 1] = new Values();
            valuesArray[n2 - 1].valuesInt = new int[]{n};
            for (int i2 = 0; i2 < genericPropertyContainer.keys.length && i2 < genericPropertyContainer.values.length; ++i2) {
                object[i2] = genericPropertyContainer.keys[i2];
                valuesArray[i2] = new Values();
                if (genericPropertyContainer.values[i2] != null && genericPropertyContainer.values[i2].valuesInt != null && genericPropertyContainer.values[i2].valuesInt.length > 0) {
                    valuesArray[i2].valuesInt = new int[]{genericPropertyContainer.values[i2].valuesInt[0]};
                }
                if (genericPropertyContainer.values[i2] != null && genericPropertyContainer.values[i2].valuesString != null && genericPropertyContainer.values[i2].valuesString.length > 0) {
                    valuesArray[i2].valuesString = new String[]{genericPropertyContainer.values[i2].valuesString[0]};
                }
                if (genericPropertyContainer.values[i2] != null && genericPropertyContainer.values[i2].valuesBoolean != null && genericPropertyContainer.values[i2].valuesBoolean.length > 0) {
                    valuesArray[i2].valuesBoolean = new boolean[]{genericPropertyContainer.values[i2].valuesBoolean[0]};
                }
                if (genericPropertyContainer.values[i2] != null && genericPropertyContainer.values[i2].valuesDate != null && genericPropertyContainer.values[i2].valuesDate.length > 0) {
                    valuesArray[i2].valuesDate = new TravelLinkDate[]{genericPropertyContainer.values[i2].valuesDate[0]};
                }
                if (genericPropertyContainer.values[i2] != null && genericPropertyContainer.values[i2].valuesDouble != null && genericPropertyContainer.values[i2].valuesDouble.length > 0) {
                    valuesArray[i2].valuesDouble = new double[]{genericPropertyContainer.values[i2].valuesDouble[0]};
                }
                if (genericPropertyContainer.values[i2] != null && genericPropertyContainer.values[i2].valuesFloat != null && genericPropertyContainer.values[i2].valuesFloat.length > 0) {
                    valuesArray[i2].valuesFloat = new float[]{genericPropertyContainer.values[i2].valuesFloat[0]};
                }
                if (genericPropertyContainer.values[i2] != null && genericPropertyContainer.values[i2].valuesLong != null && genericPropertyContainer.values[i2].valuesLong.length > 0) {
                    valuesArray[i2].valuesLong = new long[]{genericPropertyContainer.values[i2].valuesLong[0]};
                }
                if (genericPropertyContainer.values[i2] == null || genericPropertyContainer.values[i2].valuesResourceLocator == null || genericPropertyContainer.values[i2].valuesResourceLocator.length <= 0) continue;
                valuesArray[i2].valuesResourceLocator = new ResourceLocator[]{genericPropertyContainer.values[i2].valuesResourceLocator[0]};
            }
            genericPropertyContainer.keys = (int[])object;
            genericPropertyContainer.values = valuesArray;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}

