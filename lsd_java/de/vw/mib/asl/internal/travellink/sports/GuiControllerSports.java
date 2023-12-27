/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.sports;

import de.vw.mib.asl.api.radio.ASLRadioAPI;
import de.vw.mib.asl.api.radio.ASLRadioFactory;
import de.vw.mib.asl.api.radio.RadioSDARSChannelInfo;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.GuiControllerCommon;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSportsFavoriteGamesMainViewCollector;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSportsLeagueNewsCollector;
import de.vw.mib.asl.internal.travellink.transformer.TravelLinkSportsTeamListCollector;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkSportsHeadToHeadGameDetailsCollector;
import generated.de.vw.mib.asl.internal.travellink.transformer.TravelLinkSportsHeadlineCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.travellink.GenericPropertyContainer;
import org.dsi.ifc.travellink.Values;

public final class GuiControllerSports
implements GuiControllerCommon {
    static int folderLevel = 0;

    @Override
    public void setSubscriptionState(int n) {
        if (ServiceManager.logger2.isTraceEnabled(32)) {
            ServiceManager.logger2.trace(32).append("TL <SPORTS> ").append("GuiControllerSports - setSubscriptionState(").append(n).append(")").log();
        }
        if (n == 2) {
            ServiceManager.aslPropertyManager.valueChangedInteger(4155, 1);
        } else if (n == 0) {
            ServiceManager.aslPropertyManager.valueChangedInteger(4155, 2);
        } else {
            ServiceManager.aslPropertyManager.valueChangedInteger(4155, 0);
        }
    }

    public void updateTeamNameToPopup(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            Object[] objectArray = ListManager.getGenericASLList(4111).getDSIObjects();
            if (null == objectArray || objectArray.length < 1) {
                return;
            }
            GenericPropertyContainer[] genericPropertyContainerArray = (GenericPropertyContainer[])objectArray;
            if (null != genericPropertyContainerArray && n > -1 && n < genericPropertyContainerArray.length && null != genericPropertyContainerArray[n]) {
                String string = GenericPropertyUtility.getString(-1080491008, 0, genericPropertyContainerArray[n]);
                int n2 = GenericPropertyUtility.getInt(-1097268224, 0, genericPropertyContainerArray[n]);
                TLinkServiceManager.getServiceManager().getSports().setSelectedTeamIdToDelete(n2);
                int n3 = GenericPropertyUtility.getInt(-1130822656, 0, genericPropertyContainerArray[n]);
                TLinkServiceManager.getServiceManager().getSports().setSelectedAffiliateIdToDelete(n3);
                ServiceManager.aslPropertyManager.valueChangedString(-314629376, string);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateChannelButtonStatus(boolean bl, boolean bl2, boolean bl3) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(32)) {
                ServiceManager.logger2.trace(32).append("GuiControllerSports : updateChannelButtonStatus() : Visitor channel availability - ").append(bl).append(" : Home channel availability - ").append(bl2).append(" : National Channel availability - ").append(bl3).log();
            }
            if (bl) {
                ServiceManager.aslPropertyManager.valueChangedBoolean(-599842048, true);
            } else {
                ServiceManager.aslPropertyManager.valueChangedBoolean(-599842048, false);
            }
            if (bl2) {
                ServiceManager.aslPropertyManager.valueChangedBoolean(-633396480, true);
            } else {
                ServiceManager.aslPropertyManager.valueChangedBoolean(-633396480, false);
            }
            if (bl3) {
                ServiceManager.aslPropertyManager.valueChangedBoolean(-616619264, true);
            } else {
                ServiceManager.aslPropertyManager.valueChangedBoolean(-616619264, false);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateChangeLeagueSelected() {
        try {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(2101289728);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void updateSetupAddFavoriteResultStatus(int n) {
        try {
            if (n == 15) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-2143345920);
                return;
            }
            if (n == 13) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-2059459840);
                return;
            }
            if (n != 14) return;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateSetupSportsFavoriteHeadlineTeamList(EventGeneric eventGeneric) {
        try {
            int n = eventGeneric.getInt(0);
            Object[] objectArray = ListManager.getGenericASLList(-868277504).getDSIObjects();
            if (null == objectArray || objectArray.length < 1) {
                return;
            }
            GenericPropertyContainer[] genericPropertyContainerArray = (GenericPropertyContainer[])objectArray;
            if (null != genericPropertyContainerArray && n > -1 && n < genericPropertyContainerArray.length && null != genericPropertyContainerArray[n]) {
                int n2 = GenericPropertyUtility.getInt(-174586880, 0, genericPropertyContainerArray[n]);
                String string = GenericPropertyUtility.getString(-157809664, 0, genericPropertyContainerArray[n]);
                int n3 = GenericPropertyUtility.getInt(-191364096, 0, genericPropertyContainerArray[n]);
                this.updateSportsHeadline(n2, string);
                TLinkServiceManager.getServiceManager().getSports().setSetupSportsSelectedLeagueId(n3);
                TLinkServiceManager.getServiceManager().getDsiTravelLinkSportsAdapter().requestSportTeamsForFavorites(n3);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateFavoriteTeam(GenericPropertyContainer[] genericPropertyContainerArray, boolean bl) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(32)) {
                ServiceManager.logger2.trace(32).append("GuiControllerSports : updateFavoriteTeam()").log();
            }
            if (genericPropertyContainerArray == null || genericPropertyContainerArray.length < 1) {
                if (bl) {
                    ServiceManager.aslPropertyManager.valueChangedBoolean(-683728128, true);
                    TLinkServiceManager.getServiceManager().getSports().setSetupSportsNumberOfFavoriteTeams(0);
                }
                ListManager.getGenericASLList(4111).updateList(new GenericPropertyContainer[0]);
            } else {
                int n;
                Object[] objectArray = new GenericPropertyContainer[genericPropertyContainerArray.length];
                for (n = 0; n < genericPropertyContainerArray.length; ++n) {
                    objectArray[n] = GenericPropertyUtility.getCopy(genericPropertyContainerArray[n]);
                }
                ListManager.getGenericASLList(4111).updateList(objectArray);
                n = genericPropertyContainerArray.length;
                TLinkServiceManager.getServiceManager().getSports().setSetupSportsNumberOfFavoriteTeams(n);
                if (n >= 20) {
                    ServiceManager.aslPropertyManager.valueChangedBoolean(-683728128, false);
                } else {
                    ServiceManager.aslPropertyManager.valueChangedBoolean(-683728128, true);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateTeamListWithDeleteFavoriteTeam(GenericPropertyContainer[] genericPropertyContainerArray, int n) {
        try {
            if (11 == n) {
                int n2 = TLinkServiceManager.getServiceManager().getSports().getSetupSportsNumberOfFavoriteTeams();
                TLinkServiceManager.getServiceManager().getSports().setSetupSportsNumberOfFavoriteTeams(n2 - 1);
                if (ServiceManager.logger2.isTraceEnabled(32)) {
                    ServiceManager.logger2.trace(32).append("GuiControllerSports : updateTeamListWithDeleteFavoriteTeam()").log();
                }
                if (genericPropertyContainerArray == null || genericPropertyContainerArray.length < 1) {
                    ServiceManager.logger2.error(32).append("GuiControllerSports : updateTeamListWithDeleteFavoriteTeam()").append("There is no deleted team id from application.").log();
                } else {
                    int n3 = GenericPropertyUtility.getInt(-1869085696, 0, genericPropertyContainerArray[0]);
                    Object[] objectArray = ListManager.getGenericASLList(-180411648).getDSIObjects();
                    if (null == objectArray || objectArray.length < 1) {
                        ServiceManager.logger2.error(32).append("GuiControllerSports : updateTeamListWithDeleteFavoriteTeam()").append("No items in the setup team list.").log();
                    } else {
                        Object[] objectArray2 = (TravelLinkSportsTeamListCollector[])objectArray;
                        if (null != objectArray2 && objectArray2.length > 0) {
                            for (int i2 = 0; i2 < objectArray2.length; ++i2) {
                                if (n3 != objectArray2[i2].teamId) continue;
                                ((TravelLinkSportsTeamListCollector)objectArray2[i2]).isTeamFavorite = false;
                            }
                            ListManager.getGenericASLList(-180411648).updateList(objectArray2);
                        }
                    }
                }
            } else {
                ServiceManager.logger2.warn(32).append("GuiControllerSports : updateTeamListWithDeleteFavoriteTeam()").append("Expected response status is ").append(11).append("But, the received response status is ").append(n).log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateTeamListWithAddFavoriteTeam(GenericPropertyContainer[] genericPropertyContainerArray, int n) {
        try {
            if (14 == n) {
                int n2 = TLinkServiceManager.getServiceManager().getSports().getSetupSportsNumberOfFavoriteTeams();
                TLinkServiceManager.getServiceManager().getSports().setSetupSportsNumberOfFavoriteTeams(n2 + 1);
                if (ServiceManager.logger2.isTraceEnabled(32)) {
                    ServiceManager.logger2.trace(32).append("GuiControllerSports : updateTeamListWithAddFavoriteTeam()").log();
                }
                if (genericPropertyContainerArray == null || genericPropertyContainerArray.length < 1) {
                    ServiceManager.logger2.error(32).append("GuiControllerSports : updateTeamListWithAddFavoriteTeam()").append("There is no added team id from application.").log();
                } else {
                    int n3 = GenericPropertyUtility.getInt(748160000, 0, genericPropertyContainerArray[0]);
                    Object[] objectArray = ListManager.getGenericASLList(-180411648).getDSIObjects();
                    if (null == objectArray || objectArray.length < 1) {
                        ServiceManager.logger2.error(32).append("GuiControllerSports : updateTeamListWithAddFavoriteTeam()").append("No items in the setup team list.").log();
                    } else {
                        Object[] objectArray2 = (TravelLinkSportsTeamListCollector[])objectArray;
                        if (null != objectArray2 && objectArray2.length > 0) {
                            for (int i2 = 0; i2 < objectArray2.length; ++i2) {
                                if (objectArray2[i2] == null || n3 != ((TravelLinkSportsTeamListCollector)objectArray2[i2]).teamId) continue;
                                ((TravelLinkSportsTeamListCollector)objectArray2[i2]).isTeamFavorite = true;
                            }
                            ListManager.getGenericASLList(-180411648).updateList(objectArray2);
                        }
                    }
                }
            } else {
                ServiceManager.logger2.warn(32).append("GuiControllerSports : updateTeamListWithAddFavoriteTeam()").append("Expected response status is ").append(14).append("But, the received response status is ").append(n).log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public boolean isFavoriteTeam(int n, int n2, GenericPropertyContainer[] genericPropertyContainerArray) {
        if (null != genericPropertyContainerArray) {
            for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
                int n3 = GenericPropertyUtility.getInt(-1097268224, 0, genericPropertyContainerArray[i2]);
                int n4 = GenericPropertyUtility.getInt(-1130822656, 0, genericPropertyContainerArray[i2]);
                if (n != n3 || n2 != n4) continue;
                return true;
            }
        }
        return false;
    }

    public void updateSetupFavoritTeamListForSelectedLeague(GenericPropertyContainer[] genericPropertyContainerArray) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(32)) {
                ServiceManager.logger2.trace(32).append("GuiControllerSports : updateSetupFavoritTeamListForSelectedLeague()").log();
            }
            if (genericPropertyContainerArray == null || genericPropertyContainerArray.length < 1) {
                ListManager.getGenericASLList(-180411648).updateList(new TravelLinkSportsTeamListCollector[0]);
            } else {
                GenericPropertyContainer[] genericPropertyContainerArray2 = TLinkServiceManager.getServiceManager().getDatapool().get(52);
                Object[] objectArray = new TravelLinkSportsTeamListCollector[genericPropertyContainerArray.length];
                for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
                    objectArray[i2] = new TravelLinkSportsTeamListCollector();
                    ((TravelLinkSportsTeamListCollector)objectArray[i2]).teamName = GenericPropertyUtility.getString(1536754688, 0, genericPropertyContainerArray[i2]);
                    ((TravelLinkSportsTeamListCollector)objectArray[i2]).teamId = GenericPropertyUtility.getInt(1519977472, 0, genericPropertyContainerArray[i2]);
                    int n = GenericPropertyUtility.getInt(1486423040, 0, genericPropertyContainerArray[i2]);
                    ((TravelLinkSportsTeamListCollector)objectArray[i2]).isTeamFavorite = this.isFavoriteTeam(((TravelLinkSportsTeamListCollector)objectArray[i2]).teamId, n, genericPropertyContainerArray2);
                }
                ListManager.getGenericASLList(-180411648).updateList(objectArray);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void setTimeFrame(int n) {
        try {
            if (n >= 0 || n <= 2) {
                ServiceManager.aslPropertyManager.valueChangedInteger(-1153490176, n);
            } else {
                ServiceManager.aslPropertyManager.valueChangedInteger(-1153490176, 0);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateFavoriteTeamAffiliates(GenericPropertyContainer[] genericPropertyContainerArray) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(32)) {
                ServiceManager.logger2.trace(32).append("GuiControllerSports : updateFavoriteTeamAffiliates()").log();
            }
            if (genericPropertyContainerArray == null || genericPropertyContainerArray.length < 1) {
                ListManager.getGenericASLList(-868277504).updateList(new GenericPropertyContainer[0]);
            } else {
                Object[] objectArray = new GenericPropertyContainer[genericPropertyContainerArray.length];
                for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
                    objectArray[i2] = GenericPropertyUtility.getCopy(genericPropertyContainerArray[i2]);
                }
                ListManager.getGenericASLList(-868277504).updateList(objectArray);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateSetupFavoriteTeamTitleInfo(String string) {
        try {
            ServiceManager.aslPropertyManager.valueChangedString(-2059459840, string);
            int n = TLinkServiceManager.getServiceManager().getSports().getFolderLevelSetupFavoriteTeam();
            TLinkServiceManager.getServiceManager().getSports().setFolderLevelSetupFavoriteTeam(++n);
            ServiceManager.aslPropertyManager.valueChangedInteger(-2076237056, n);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateTeamInfoORI(GenericPropertyContainer[] genericPropertyContainerArray) {
        int n = 0;
        if (genericPropertyContainerArray != null && genericPropertyContainerArray.length > 0 && genericPropertyContainerArray[0] != null) {
            Object[] objectArray = new GenericPropertyContainer[genericPropertyContainerArray.length];
            for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
                objectArray[i2] = GenericPropertyUtility.getCopy(genericPropertyContainerArray[i2]);
            }
            n = GenericPropertyUtility.getInt(-191364096, 0, objectArray[0]);
            if (n != -9999) {
                try {
                    if (n == 0) {
                        ListManager.getGenericASLList(-2042682624).updateList(objectArray);
                        ServiceManager.aslPropertyManager.valueChangedInteger(-2076237056, 0);
                    } else if (n > 0) {
                        ListManager.getGenericASLList(4111).updateList(objectArray);
                    }
                }
                catch (Exception exception) {
                    ServiceManager.errorHandler.handleError(exception);
                }
            }
        } else if (ServiceManager.logger2.isTraceEnabled(32)) {
            ServiceManager.logger2.trace(32).append("GuiControllerSports : updateFavoriteTeam : container array is null ").log();
        }
    }

    public void updateSportsLeague(GenericPropertyContainer[] genericPropertyContainerArray) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(32)) {
                ServiceManager.logger2.trace(32).append("GuiControllerSports : updateSportsLeague()").log();
            }
            if (null != genericPropertyContainerArray && genericPropertyContainerArray.length > 0 && null != genericPropertyContainerArray[0]) {
                int n;
                Object[] objectArray = new GenericPropertyContainer[genericPropertyContainerArray.length];
                for (n = 0; n < genericPropertyContainerArray.length; ++n) {
                    objectArray[n] = GenericPropertyUtility.getCopy(genericPropertyContainerArray[n]);
                }
                ListManager.getGenericASLList(-1975573760).updateList(objectArray);
                n = GenericPropertyUtility.getInt(-510458880, 0, genericPropertyContainerArray[0]);
                if (n == -1) {
                    TLinkServiceManager.getServiceManager().getSports().setFolderLevelChangeLeague(0);
                    ServiceManager.aslPropertyManager.valueChangedInteger(-1287707904, 0);
                } else if (n > -1) {
                    int n2 = TLinkServiceManager.getServiceManager().getSports().getFolderLevelChangeLeague();
                    ServiceManager.aslPropertyManager.valueChangedInteger(-1287707904, n2);
                } else if (n == -9999 && ServiceManager.logger2.isTraceEnabled(32)) {
                    ServiceManager.logger2.error(32).append("GuiControllerSports : updateSportsLeague : PARENT AFFILIATE ID is not updated by the application ").log();
                }
            } else {
                ListManager.getGenericASLList(-1975573760).updateList(new GenericPropertyContainer[0]);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateSportsInfo(GenericPropertyContainer[] genericPropertyContainerArray) {
        if (null != genericPropertyContainerArray && genericPropertyContainerArray.length > 0 && null != genericPropertyContainerArray[0]) {
            Object[] objectArray = new GenericPropertyContainer[genericPropertyContainerArray.length];
            for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
                objectArray[i2] = GenericPropertyUtility.getCopy(genericPropertyContainerArray[i2]);
            }
            try {
                ListManager.getGenericASLList(-2042682624).updateList(objectArray);
                ServiceManager.aslPropertyManager.valueChangedInteger(-2076237056, folderLevel);
                if (++folderLevel >= 3) {
                    folderLevel = 0;
                }
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleError(exception);
            }
        }
    }

    public void updateSportsHeadtoHeadFavoritesGamesList(GenericPropertyContainer[] genericPropertyContainerArray, int n) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(32)) {
                ServiceManager.logger2.trace(32).append("GuiControllerSports : updateSportsHeadtoHeadFavoritesGamesList()").log();
            }
            if (7 == n) {
                this.updateSportsLoadingState(2);
                ListManager.getGenericASLList(-1187044608).updateList(new GenericPropertyContainer[0]);
            } else if (null != genericPropertyContainerArray && genericPropertyContainerArray.length > 0 && null != genericPropertyContainerArray[0]) {
                this.updateSportsLoadingState(0);
                Object[] objectArray = new GenericPropertyContainer[genericPropertyContainerArray.length];
                for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
                    objectArray[i2] = GenericPropertyUtility.getCopy(genericPropertyContainerArray[i2]);
                    TLinkServiceManager.getServiceManager().getSports().updateSportsIdFromFavoriteTeamList((GenericPropertyContainer)objectArray[i2]);
                }
                if (0 == TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getListTimeframeForHeadToHeadGames()) {
                    Arrays.sort(objectArray, TLinkServiceManager.getServiceManager().getComparatorSportsFinishedGamesList());
                } else {
                    Arrays.sort(objectArray, TLinkServiceManager.getServiceManager().getComparatorSportsGamesList());
                }
                objectArray = this.removeDoubleEntriesForHeadToHeadGames((GenericPropertyContainer[])objectArray);
                ListManager.getGenericASLList(-1187044608).updateList(objectArray);
            } else {
                this.updateSportsLoadingState(3);
                ListManager.getGenericASLList(-1187044608).updateList(new GenericPropertyContainer[0]);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateFavoriteGamesForMainView(GenericPropertyContainer[] genericPropertyContainerArray, int n) {
        try {
            if (n == 7) {
                this.updateSportsLoadingStateForMainView(3);
            } else if (null != genericPropertyContainerArray && genericPropertyContainerArray.length > 0 && null != genericPropertyContainerArray[0]) {
                this.checkAndupdateFavoriteGamesForMainView(genericPropertyContainerArray);
            } else {
                this.updateSportsLoadingStateForMainView(0);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    private void checkAndupdateFavoriteGamesForMainView(GenericPropertyContainer[] genericPropertyContainerArray) {
        Arrays.sort(genericPropertyContainerArray, TLinkServiceManager.getServiceManager().getComparatorGamesStatus());
        List list = new ArrayList();
        for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
            int n;
            if (genericPropertyContainerArray[i2] == null || (n = GenericPropertyUtility.getInt(345310208, 0, genericPropertyContainerArray[i2])) != 2) continue;
            list.add(genericPropertyContainerArray[i2]);
        }
        if (list.size() < 1) {
            this.updateSportsLoadingStateForMainView(0);
        } else {
            this.updateSportsLoadingStateForMainView(2);
            if (list.size() > 4) {
                list = list.subList(0, 4);
            }
            this.updateFavoriteGamesForMainViewCollector(list);
        }
    }

    public void updateFavoriteGamesForMainViewCollector(List list) {
        int n;
        Object[] objectArray = new TravelLinkSportsFavoriteGamesMainViewCollector[4];
        for (n = 0; n < objectArray.length; ++n) {
            objectArray[n] = new TravelLinkSportsFavoriteGamesMainViewCollector();
        }
        if (null != list) {
            this.removeDoubleEntriesForHeadToHeadGames(list);
            n = 0;
            for (int i2 = 0; i2 < list.size(); ++i2) {
                int n2;
                GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)list.get(i2);
                if (null == genericPropertyContainer || n < 0 || n >= objectArray.length) continue;
                ((TravelLinkSportsFavoriteGamesMainViewCollector)objectArray[n]).gameStatusColumn1 = n2 = GenericPropertyUtility.getInt(345310208, 0, genericPropertyContainer);
                String string = GenericPropertyUtility.getString(311755776, 0, genericPropertyContainer);
                String string2 = GenericPropertyUtility.getString(261424128, 0, genericPropertyContainer);
                ((TravelLinkSportsFavoriteGamesMainViewCollector)objectArray[n]).gameNamesColumn2 = new StringBuffer().append(string2).append("@").append(string).toString();
                if (0 == n2) {
                    byte by = GenericPropertyUtility.getDate(362087424, 0, genericPropertyContainer).getHour();
                    byte by2 = GenericPropertyUtility.getDate(362087424, 0, genericPropertyContainer).getMinute();
                    ((TravelLinkSportsFavoriteGamesMainViewCollector)objectArray[n]).gameScoreOrTimeColumn3 = TLinkServiceManager.getServiceManager().getTravelLinkUtil().getFormattedTime(by, by2);
                } else if (2 == n2 || 3 == n2) {
                    String string3 = GenericPropertyUtility.getString(328532992, 0, genericPropertyContainer);
                    String string4 = GenericPropertyUtility.getString(278201344, 0, genericPropertyContainer);
                    ((TravelLinkSportsFavoriteGamesMainViewCollector)objectArray[n]).gameScoreOrTimeColumn3 = new StringBuffer().append(string4).append(":").append(string3).toString();
                }
                ++n;
            }
        }
        ListManager.getGenericASLList(-532733184).updateList(objectArray);
    }

    public void updateSportMainWithReceivedFavorites() {
    }

    public void updateSportsHeadtoHeadGamesList(GenericPropertyContainer[] genericPropertyContainerArray, int n) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(32)) {
                ServiceManager.logger2.trace(32).append("GuiControllerSports : updateSportsHeadtoHeadGamesList()").log();
            }
            if (8 == n) {
                this.updateSportsLoadingState(4);
                ListManager.getGenericASLList(-1170267392).updateList(new GenericPropertyContainer[0]);
                this.updateLiveBroadcastListStateEmpty(true);
                ListManager.getGenericASLList(-1203821824).updateList(new GenericPropertyContainer[0]);
            } else if (genericPropertyContainerArray != null && genericPropertyContainerArray.length > 0 && null != genericPropertyContainerArray[0]) {
                this.updateSportsLoadingState(0);
                Object[] objectArray = new GenericPropertyContainer[genericPropertyContainerArray.length];
                for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
                    objectArray[i2] = GenericPropertyUtility.getCopy(genericPropertyContainerArray[i2]);
                }
                if (0 == TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getListTimeframeForHeadToHeadGames()) {
                    Arrays.sort(objectArray, TLinkServiceManager.getServiceManager().getComparatorSportsFinishedGamesList());
                } else {
                    Arrays.sort(objectArray, TLinkServiceManager.getServiceManager().getComparatorSportsGamesList());
                }
                ListManager.getGenericASLList(-1170267392).updateList(objectArray);
                Object[] objectArray2 = this.getLiveBroadcastChannelListHeadToHead((GenericPropertyContainer[])objectArray);
                if (objectArray2 != null) {
                    this.updateLiveBroadcastListStateEmpty(false);
                    ListManager.getGenericASLList(-1203821824).updateList(objectArray2);
                } else {
                    this.updateLiveBroadcastListStateEmpty(true);
                    ListManager.getGenericASLList(-1203821824).updateList(new GenericPropertyContainer[0]);
                }
            } else {
                this.updateSportsLoadingState(3);
                this.clearHeadToHeadGameList();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void clearHeadToHeadGameList() {
        ListManager.getGenericASLList(-1170267392).updateList(new GenericPropertyContainer[0]);
        ListManager.getGenericASLList(-1203821824).updateList(new GenericPropertyContainer[0]);
        TLinkServiceManager.getServiceManager().getGuiControllerSports().updateLiveBroadcastListStateEmpty(true);
    }

    public void clearHeadToHeadFavoritesGameList() {
        ListManager.getGenericASLList(-1187044608).updateList(new GenericPropertyContainer[0]);
    }

    public void updateRadioText(ArrayList arrayList) {
        try {
            if (arrayList != null && arrayList.size() > 0) {
                Object[] objectArray = ListManager.getGenericASLList(-1203821824).getDSIObjects();
                if (null == objectArray || objectArray.length < 1) {
                    return;
                }
                Object[] objectArray2 = (GenericPropertyContainer[])objectArray;
                RadioText radioText = null;
                int n = -1;
                int n2 = -1;
                for (int i2 = 0; i2 < arrayList.size(); ++i2) {
                    radioText = (RadioText)arrayList.get(i2);
                    if (null == radioText) continue;
                    n = radioText.getSID();
                    for (int i3 = 0; i3 < objectArray2.length; ++i3) {
                        n2 = GenericPropertyUtility.getInt(596968448, 0, (GenericPropertyContainer)objectArray2[i3]);
                        if (n2 != n || n2 <= -1) continue;
                        ((GenericPropertyContainer)objectArray2[i3]).values[0].valuesString[0] = "";
                        ((GenericPropertyContainer)objectArray2[i3]).values[0].valuesString[0] = null != radioText.getLongProgramTitle() && radioText.getLongProgramTitle().length() < 32 ? radioText.getLongProgramTitle() : (null != radioText.getShortProgramTitle() ? radioText.getShortProgramTitle() : "");
                        ((GenericPropertyContainer)objectArray2[i3]).values[1].valuesString[0] = "";
                        ((GenericPropertyContainer)objectArray2[i3]).values[1].valuesString[0] = null != radioText.getLongArtistName() && radioText.getLongArtistName().length() < 32 ? radioText.getLongArtistName() : (null != radioText.getShortArtistName() ? radioText.getShortArtistName() : "");
                    }
                }
                this.updateLiveBroadcastListStateEmpty(false);
                ListManager.getGenericASLList(-1203821824).updateList(objectArray2);
            } else if (ServiceManager.logger2.isTraceEnabled(32)) {
                ServiceManager.logger2.trace(32).append("TL <SPORTS> ").append("Radio text received from SDARS is null").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public GenericPropertyContainer[] getLiveBroadcastChannelListHeadToHead(GenericPropertyContainer[] genericPropertyContainerArray) {
        try {
            int n = genericPropertyContainerArray.length;
            int n2 = 7;
            ArrayList arrayList = null;
            int n3 = -1;
            int n4 = -1;
            int n5 = -1;
            RadioSDARSChannelInfo radioSDARSChannelInfo = null;
            String string = null;
            int n6 = -1;
            String string2 = null;
            String string3 = null;
            ResourceLocator resourceLocator = null;
            int n7 = 0;
            Object object = null;
            ASLRadioAPI aSLRadioAPI = ASLRadioFactory.getRadioApi();
            ArrayList arrayList2 = new ArrayList();
            GenericPropertyContainer genericPropertyContainer = null;
            for (int i2 = 0; i2 < n; ++i2) {
                ArrayList arrayList3;
                n3 = GenericPropertyUtility.getInt(496305152, 0, genericPropertyContainerArray[i2]);
                n4 = GenericPropertyUtility.getInt(513082368, 0, genericPropertyContainerArray[i2]);
                n5 = GenericPropertyUtility.getInt(529859584, 0, genericPropertyContainerArray[i2]);
                if (n3 <= -1 && n4 <= -1 && n5 <= -1) continue;
                arrayList = new ArrayList();
                if (n3 > -1) {
                    arrayList.add(new Integer(n3));
                }
                if (n4 > -1) {
                    arrayList.add(new Integer(n4));
                }
                if (n5 > -1) {
                    arrayList.add(new Integer(n5));
                }
                if ((arrayList3 = aSLRadioAPI.getSDARSChannelInfo(arrayList)) == null) continue;
                for (int i3 = 0; i3 < arrayList3.size(); ++i3) {
                    object = arrayList3.get(i3);
                    if (object instanceof RadioSDARSChannelInfo) {
                        radioSDARSChannelInfo = (RadioSDARSChannelInfo)object;
                    }
                    if (radioSDARSChannelInfo == null) continue;
                    string = radioSDARSChannelInfo.getChannelName();
                    n6 = radioSDARSChannelInfo.getChannelNumber();
                    string2 = radioSDARSChannelInfo.getArtist();
                    string3 = radioSDARSChannelInfo.getTitle();
                    resourceLocator = radioSDARSChannelInfo.getChannelLogo();
                    n7 = radioSDARSChannelInfo.getServiceID();
                    genericPropertyContainer = new GenericPropertyContainer();
                    genericPropertyContainer.values = new Values[7];
                    genericPropertyContainer.keys = new int[7];
                    genericPropertyContainer.keys[0] = 630522880;
                    genericPropertyContainer.values[0] = new Values();
                    genericPropertyContainer.values[0].valuesString = new String[]{string3};
                    genericPropertyContainer.keys[1] = 647300096;
                    genericPropertyContainer.values[1] = new Values();
                    genericPropertyContainer.values[1].valuesString = new String[]{string2};
                    genericPropertyContainer.keys[2] = 596968448;
                    genericPropertyContainer.values[2] = new Values();
                    genericPropertyContainer.values[2].valuesInt = new int[]{n7};
                    genericPropertyContainer.keys[3] = 546636800;
                    genericPropertyContainer.values[3] = new Values();
                    genericPropertyContainer.values[3].valuesString = new String[]{string};
                    genericPropertyContainer.keys[4] = 563414016;
                    genericPropertyContainer.values[4] = new Values();
                    genericPropertyContainer.values[4].valuesResourceLocator = new ResourceLocator[]{resourceLocator};
                    genericPropertyContainer.keys[5] = 580191232;
                    genericPropertyContainer.values[5] = new Values();
                    if (n7 == n3) {
                        genericPropertyContainer.values[5].valuesInt = new int[]{2};
                        if (ServiceManager.logger2.isTraceEnabled(32)) {
                            ServiceManager.logger2.trace(32).append("Sports : getLiveBroadcastChannelListHeadToHead : Visitor Channel service id is -  ").append(n7).log();
                        }
                    } else if (n7 == n4) {
                        genericPropertyContainer.values[5].valuesInt = new int[]{1};
                        if (ServiceManager.logger2.isTraceEnabled(32)) {
                            ServiceManager.logger2.trace(32).append("Sports : getLiveBroadcastChannelListHeadToHead : Home Channel service id is -  ").append(n7).log();
                        }
                    } else if (n7 == n5) {
                        genericPropertyContainer.values[5].valuesInt = new int[]{0};
                        if (ServiceManager.logger2.isTraceEnabled(32)) {
                            ServiceManager.logger2.trace(32).append("Sports : getLiveBroadcastChannelListHeadToHead : National Channel service id is -  ").append(n7).log();
                        }
                    } else {
                        ServiceManager.logger2.error(32).append("Sports : getLiveBroadcastChannelListHeadToHead :  - Service id received from SDARS - ").append(n7).append(" doesnot match with the visitor channel service id ").append(n3).append(" , Home channel service id ").append(n4).append(" , National channel service id ").append(n5).log();
                    }
                    genericPropertyContainer.keys[6] = 613745664;
                    genericPropertyContainer.values[6] = new Values();
                    genericPropertyContainer.values[6].valuesInt = new int[]{n6};
                    if (ServiceManager.logger2.isTraceEnabled(32)) {
                        ServiceManager.logger2.trace(32).append("Sports : getLiveBroadcastChannelListHeadToHead : Channel Number -  ").append(n6).log();
                    }
                    arrayList2.add(genericPropertyContainer);
                }
            }
            if (arrayList2 == null || arrayList2.size() == 0) {
                return null;
            }
            GenericPropertyContainer[] genericPropertyContainerArray2 = (GenericPropertyContainer[])arrayList2.toArray(new GenericPropertyContainer[arrayList2.size()]);
            return genericPropertyContainerArray2;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public GenericPropertyContainer[] getLiveBroadcastChannelListForRankedList(GenericPropertyContainer[] genericPropertyContainerArray) {
        try {
            int n = genericPropertyContainerArray.length;
            int n2 = 7;
            ArrayList arrayList = new ArrayList();
            int n3 = -1;
            RadioSDARSChannelInfo radioSDARSChannelInfo = null;
            String string = null;
            int n4 = -1;
            String string2 = null;
            String string3 = null;
            ResourceLocator resourceLocator = null;
            int n5 = 0;
            Object object = null;
            Integer n6 = null;
            ASLRadioAPI aSLRadioAPI = ASLRadioFactory.getRadioApi();
            ArrayList arrayList2 = new ArrayList();
            GenericPropertyContainer genericPropertyContainer = null;
            for (int i2 = 0; i2 < n; ++i2) {
                n3 = GenericPropertyUtility.getInt(60228608, 0, genericPropertyContainerArray[i2]);
                if (n3 <= -1 || arrayList.contains(n6 = new Integer(n3))) continue;
                arrayList.add(n6);
            }
            ArrayList arrayList3 = aSLRadioAPI.getSDARSChannelInfo(arrayList);
            if (arrayList3 != null) {
                for (int i3 = 0; i3 < arrayList3.size(); ++i3) {
                    object = arrayList3.get(i3);
                    if (!(object instanceof RadioSDARSChannelInfo) || (radioSDARSChannelInfo = (RadioSDARSChannelInfo)object) == null) continue;
                    string = radioSDARSChannelInfo.getChannelName();
                    n4 = radioSDARSChannelInfo.getChannelNumber();
                    string2 = radioSDARSChannelInfo.getArtist();
                    string3 = radioSDARSChannelInfo.getTitle();
                    resourceLocator = radioSDARSChannelInfo.getChannelLogo();
                    n5 = radioSDARSChannelInfo.getServiceID();
                    genericPropertyContainer = new GenericPropertyContainer();
                    genericPropertyContainer.values = new Values[7];
                    genericPropertyContainer.keys = new int[7];
                    genericPropertyContainer.keys[0] = 630522880;
                    genericPropertyContainer.values[0] = new Values();
                    genericPropertyContainer.values[0].valuesString = new String[]{string3};
                    genericPropertyContainer.keys[1] = 647300096;
                    genericPropertyContainer.values[1] = new Values();
                    genericPropertyContainer.values[1].valuesString = new String[]{string2};
                    genericPropertyContainer.keys[2] = 596968448;
                    genericPropertyContainer.values[2] = new Values();
                    genericPropertyContainer.values[2].valuesInt = new int[]{n5};
                    genericPropertyContainer.keys[3] = 546636800;
                    genericPropertyContainer.values[3] = new Values();
                    genericPropertyContainer.values[3].valuesString = new String[]{string};
                    genericPropertyContainer.keys[4] = 563414016;
                    genericPropertyContainer.values[4] = new Values();
                    genericPropertyContainer.values[4].valuesResourceLocator = new ResourceLocator[]{resourceLocator};
                    genericPropertyContainer.keys[5] = 580191232;
                    genericPropertyContainer.values[5] = new Values();
                    genericPropertyContainer.values[5].valuesInt = new int[]{0};
                    genericPropertyContainer.keys[6] = 613745664;
                    genericPropertyContainer.values[6] = new Values();
                    genericPropertyContainer.values[6].valuesInt = new int[]{n4};
                    arrayList2.add(genericPropertyContainer);
                }
            }
            if (arrayList2 == null || arrayList2.size() == 0) {
                return null;
            }
            GenericPropertyContainer[] genericPropertyContainerArray2 = (GenericPropertyContainer[])arrayList2.toArray(new GenericPropertyContainer[arrayList2.size()]);
            return genericPropertyContainerArray2;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
            return null;
        }
    }

    public void clearSportsRankedEventList() {
        ListManager.getGenericASLList(-1119935744).updateList(new GenericPropertyContainer[0]);
    }

    public void updateSportsRankedEventList(GenericPropertyContainer[] genericPropertyContainerArray, int n) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(32)) {
                ServiceManager.logger2.trace(32).append("GuiControllerSports : updateSportsRankedEventList()").log();
            }
            int n2 = TLinkServiceManager.getServiceManager().getCurrentViewId();
            if (n == 8) {
                ServiceManager.aslPropertyManager.valueChangedInteger(-1623252224, 4);
                if (n2 == 14) {
                    TLinkServiceManager.getServiceManager().getGuiControllerSports().updateChangeLeagueSelected();
                }
                if (n2 == 45 || n2 == 46) {
                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-1942019328);
                }
            } else if (null != genericPropertyContainerArray && genericPropertyContainerArray.length > 0 && null != genericPropertyContainerArray[0]) {
                ServiceManager.aslPropertyManager.valueChangedInteger(-1623252224, 0);
                if (n2 == 14) {
                    TLinkServiceManager.getServiceManager().getGuiControllerSports().updateChangeLeagueSelected();
                }
                if (n2 == 47 || n2 == 46) {
                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-1942019328);
                }
                Object[] objectArray = new GenericPropertyContainer[genericPropertyContainerArray.length];
                for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
                    objectArray[i2] = GenericPropertyUtility.getCopy(genericPropertyContainerArray[i2]);
                    int n3 = GenericPropertyUtility.getInt(-627768320, 0, (GenericPropertyContainer)objectArray[i2]);
                    if (n3 != 4 && n3 != 8) continue;
                    String string = GenericPropertyUtility.getString(-644545536, 0, (GenericPropertyContainer)objectArray[i2]);
                    if (null == ((GenericPropertyContainer)objectArray[i2]).values || ((GenericPropertyContainer)objectArray[i2]).values.length <= 5) continue;
                    ((GenericPropertyContainer)objectArray[i2]).values[5] = new Values();
                    ((GenericPropertyContainer)objectArray[i2]).values[5].valuesString = n3 == 4 ? new String[]{string, "Event delayed"} : new String[]{string, "No info"};
                }
                ListManager.getGenericASLList(-1119935744).updateList(objectArray);
            } else {
                ServiceManager.aslPropertyManager.valueChangedInteger(-1623252224, 3);
                ListManager.getGenericASLList(-1119935744).updateList(new GenericPropertyContainer[0]);
                if (n2 == 14) {
                    TLinkServiceManager.getServiceManager().getGuiControllerSports().updateChangeLeagueSelected();
                }
                if (n2 == 45 || n2 == 47) {
                    int n4 = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getSportsSelectedChangeLeagueSportsId();
                    TLinkServiceManager.getServiceManager().getGuiControllerSports().updateChangeLeagueSportsIdHeadline(n4);
                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(-1942019328);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateSportsRankedListEventRankings(GenericPropertyContainer[] genericPropertyContainerArray) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(32)) {
                ServiceManager.logger2.trace(32).append("GuiControllerSports : updateSportsRankedListEventRankings()").log();
            }
            if (genericPropertyContainerArray == null || genericPropertyContainerArray.length < 1) {
                ListManager.getGenericASLList(-750836992).updateList(new GenericPropertyContainer[0]);
            } else {
                Object[] objectArray = new GenericPropertyContainer[genericPropertyContainerArray.length];
                for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
                    objectArray[i2] = GenericPropertyUtility.getCopy(genericPropertyContainerArray[i2]);
                }
                ListManager.getGenericASLList(-750836992).updateList(objectArray);
                Object[] objectArray2 = this.getLiveBroadcastChannelListForRankedList((GenericPropertyContainer[])objectArray);
                if (objectArray2 != null) {
                    this.updateLiveBroadcastListStateEmpty(false);
                    ListManager.getGenericASLList(-1203821824).updateList(objectArray2);
                } else {
                    this.updateLiveBroadcastListStateEmpty(true);
                    ListManager.getGenericASLList(-1203821824).updateList(new GenericPropertyContainer[0]);
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateSportsRankedListEventRankingsFinal(GenericPropertyContainer[] genericPropertyContainerArray) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(32)) {
                ServiceManager.logger2.trace(32).append("GuiControllerSports : updateSportsRankedListEventRankingsFinal()").log();
            }
            if (genericPropertyContainerArray == null || genericPropertyContainerArray.length < 1) {
                ListManager.getGenericASLList(-734059776).updateList(new GenericPropertyContainer[0]);
            } else {
                Object[] objectArray = new GenericPropertyContainer[genericPropertyContainerArray.length];
                for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
                    objectArray[i2] = GenericPropertyUtility.getCopy(genericPropertyContainerArray[i2]);
                }
                ListManager.getGenericASLList(-734059776).updateList(objectArray);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateSportsRankedListEventInfo(GenericPropertyContainer[] genericPropertyContainerArray) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(32)) {
                ServiceManager.logger2.trace(32).append("GuiControllerSports : updateSportsRankedListEventInfo()").log();
            }
            if (null != genericPropertyContainerArray && genericPropertyContainerArray.length == 1 && null != genericPropertyContainerArray[0] && null != genericPropertyContainerArray[0].values && genericPropertyContainerArray[0].values.length <= 4 && genericPropertyContainerArray[0].values.length >= 3 && null != genericPropertyContainerArray[0].values[2] && null != genericPropertyContainerArray[0].values[3] && null != genericPropertyContainerArray[0].values[2].valuesString && null != genericPropertyContainerArray[0].values[3].valuesString) {
                int n = genericPropertyContainerArray[0].values[2].valuesString.length;
                if (genericPropertyContainerArray[0].values[3].valuesString.length > genericPropertyContainerArray[0].values[2].valuesString.length) {
                    n = genericPropertyContainerArray[0].values[3].valuesString.length;
                }
                Object[] objectArray = new GenericPropertyContainer[n];
                for (int i2 = 0; i2 < n; ++i2) {
                    objectArray[i2] = new GenericPropertyContainer(new int[2], new Values[2]);
                    ((GenericPropertyContainer)objectArray[i2]).keys[0] = -896072704;
                    ((GenericPropertyContainer)objectArray[i2]).keys[1] = -879295488;
                    ((GenericPropertyContainer)objectArray[i2]).values[0] = new Values();
                    ((GenericPropertyContainer)objectArray[i2]).values[0].valuesString = new String[1];
                    ((GenericPropertyContainer)objectArray[i2]).values[0].valuesString[0] = "";
                    if (genericPropertyContainerArray[0].values[2].valuesString.length > i2 && null != genericPropertyContainerArray[0].values[2].valuesString[i2]) {
                        ((GenericPropertyContainer)objectArray[i2]).values[0].valuesString[0] = genericPropertyContainerArray[0].values[2].valuesString[i2];
                    }
                    ((GenericPropertyContainer)objectArray[i2]).values[1] = new Values();
                    ((GenericPropertyContainer)objectArray[i2]).values[1].valuesString = new String[1];
                    ((GenericPropertyContainer)objectArray[i2]).values[1].valuesString[0] = "";
                    if (genericPropertyContainerArray[0].values[3].valuesString.length <= i2 || null == genericPropertyContainerArray[0].values[3].valuesString[i2]) continue;
                    ((GenericPropertyContainer)objectArray[i2]).values[1].valuesString[0] = genericPropertyContainerArray[0].values[3].valuesString[i2];
                }
                ListManager.getGenericASLList(-700505344).updateList(objectArray);
                if (null != genericPropertyContainerArray[0].values[1] && null != genericPropertyContainerArray[0].values[1].valuesString && genericPropertyContainerArray[0].values[1].valuesString.length == 1 && null != genericPropertyContainerArray[0].values[1].valuesString[0]) {
                    ServiceManager.aslPropertyManager.valueChangedString(-717282560, genericPropertyContainerArray[0].values[1].valuesString[0]);
                } else {
                    ServiceManager.aslPropertyManager.valueChangedString(-717282560, "");
                }
            } else {
                ListManager.getGenericASLList(-700505344).updateList(new GenericPropertyContainer[0]);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateSportsNews(GenericPropertyContainer[] genericPropertyContainerArray) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(32)) {
                ServiceManager.logger2.trace(32).append("GuiControllerSports : updateSportsNews()").log();
            }
            if (null != genericPropertyContainerArray && genericPropertyContainerArray.length > 0 && null != genericPropertyContainerArray[0] && genericPropertyContainerArray[0].values != null && genericPropertyContainerArray[0].values.length > 1 && genericPropertyContainerArray[0].values[1] != null && genericPropertyContainerArray[0].values[1].valuesString != null && genericPropertyContainerArray[0].values[1].valuesString.length > 1 && genericPropertyContainerArray[0].values[1].valuesString[1] != null) {
                int n = genericPropertyContainerArray[0].values[1].valuesString.length;
                Object[] objectArray = new TravelLinkSportsLeagueNewsCollector[n];
                for (int i2 = 0; i2 < objectArray.length; ++i2) {
                    objectArray[i2] = new TravelLinkSportsLeagueNewsCollector();
                    ((TravelLinkSportsLeagueNewsCollector)objectArray[i2]).leagueNewsColumn1 = GenericPropertyUtility.getString(-1449917440, i2, genericPropertyContainerArray[0]);
                }
                ListManager.getGenericASLList(-1908464896).updateList(objectArray);
                ServiceManager.aslPropertyManager.valueChangedBoolean(-130080000, false);
            } else {
                ListManager.getGenericASLList(-1908464896).updateList(new TravelLinkSportsLeagueNewsCollector[0]);
                ServiceManager.aslPropertyManager.valueChangedBoolean(-130080000, true);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateLiveBroadcastChannelInfo(GenericPropertyContainer[] genericPropertyContainerArray) {
        boolean bl = true;
        if (genericPropertyContainerArray != null) {
            for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
                if (genericPropertyContainerArray[i2] != null) {
                    bl = false;
                    continue;
                }
                if (ServiceManager.logger2.isTraceEnabled(32)) {
                    ServiceManager.logger2.trace(32).append("GuiControllerSports : updateLiveBroadcastChannelInfo : container array is null ").log();
                }
                bl = true;
            }
            if (!bl) {
                // empty if block
            }
        } else if (ServiceManager.logger2.isTraceEnabled(32)) {
            ServiceManager.logger2.trace(32).append("GuiControllerSports : updateSportsInof : container array is null ").log();
        }
    }

    public void updateChangeLeagueHeadline(String string) {
        try {
            ServiceManager.aslPropertyManager.valueChangedString(-1270930688, string);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateChangeLeagueSportsIdHeadline(int n) {
        try {
            int n2 = TLinkServiceManager.getServiceManager().getSports().getHmiSportId(n);
            ServiceManager.aslPropertyManager.valueChangedInteger(-1254153472, n2);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateSelectedLeaguesWithDsiSportsId(int n) {
        try {
            if (n >= 0 && n <= 24) {
                ServiceManager.aslPropertyManager.valueChangedInteger(-146857216, n);
            } else {
                ServiceManager.aslPropertyManager.valueChangedInteger(-146857216, 0);
                if (ServiceManager.logger2.isTraceEnabled(32)) {
                    ServiceManager.logger2.trace(32).append("GuiControllerSports : updateSelectedLeaguesWithDsiSportsId : Sports id not in range -  ").append(n).log();
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateSelectedLeagueType(int n) {
        try {
            if (n >= 0 && n <= 2) {
                ServiceManager.aslPropertyManager.valueChangedInteger(-1958796544, n);
            } else {
                ServiceManager.aslPropertyManager.valueChangedInteger(-1958796544, 3);
                if (ServiceManager.logger2.isTraceEnabled(32)) {
                    ServiceManager.logger2.trace(32).append("GuiControllerSports : updateSelectedLeague : No change league is selected. The value of change league type is  ").append(n).log();
                }
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateSportsHeadline(int n, String string) {
        try {
            int n2 = TLinkServiceManager.getServiceManager().getSports().getHmiSportId(n);
            Object[] objectArray = new TravelLinkSportsHeadlineCollector[]{new TravelLinkSportsHeadlineCollector()};
            objectArray[0].travellink_sports_headline__sports_id = n2;
            objectArray[0].travellink_sports_headline__name = string != null ? string : "";
            ListManager.getGenericASLList(-784391424).updateList(objectArray);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void prepareAndUpdateGameDetails(GenericPropertyContainer genericPropertyContainer) {
        try {
            Object[] objectArray = new TravelLinkSportsHeadToHeadGameDetailsCollector[]{new TravelLinkSportsHeadToHeadGameDetailsCollector()};
            if (genericPropertyContainer != null) {
                objectArray[0].travellink_sports_head_to_head_game_details__name = GenericPropertyUtility.getString(412419072, 0, genericPropertyContainer);
                objectArray[0].travellink_sports_head_to_head_game_details__status_id = GenericPropertyUtility.getInt(345310208, 0, genericPropertyContainer);
                objectArray[0].travellink_sports_head_to_head_game_details__team_a = GenericPropertyUtility.getString(244646912, 0, genericPropertyContainer);
                objectArray[0].travellink_sports_head_to_head_game_details__team_b = GenericPropertyUtility.getString(294978560, 0, genericPropertyContainer);
                objectArray[0].travellink_sports_head_to_head_game_details__score_team_a__string = GenericPropertyUtility.getString(278201344, 0, genericPropertyContainer);
                objectArray[0].travellink_sports_head_to_head_game_details__score_team_b__string = GenericPropertyUtility.getString(328532992, 0, genericPropertyContainer);
                objectArray[0].travellink_sports_head_to_head_game_details__running_time__string = GenericPropertyUtility.getString(445973504, 0, genericPropertyContainer);
                objectArray[0].travellink_sports_head_to_head_game_details__comment = GenericPropertyUtility.getString(462750720, 0, genericPropertyContainer);
                objectArray[0].travellink_sports_head_to_head_game_details__division_score__line1 = GenericPropertyUtility.getString(462750720, 0, genericPropertyContainer);
                objectArray[0].travellink_sports_head_to_head_game_details__division_score__line2 = GenericPropertyUtility.getString(462750720, 0, genericPropertyContainer);
                objectArray[0].travellink_sports_head_to_head_game_details__division_score__line3 = GenericPropertyUtility.getString(462750720, 0, genericPropertyContainer);
                ListManager.getGenericASLList(-1036049664).updateList(objectArray);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateSportsLoadingStateForMainView(int n) {
        if (ServiceManager.logger2.isTraceEnabled(32)) {
            ServiceManager.logger2.trace(32).append("GuiControllerSports : updateSportsLoadingStateForMainView(), sportsLoadingState = ").append(n).log();
        }
        if (n >= 0 && n <= 3) {
            ServiceManager.aslPropertyManager.valueChangedInteger(-1505811712, n);
        } else if (ServiceManager.logger2.isTraceEnabled(32)) {
            ServiceManager.logger2.error(32).append("GuiControllerSports : updateSportsLoadingStateForMainView(), sportsLoadingState not in range ! ").log();
        }
    }

    public void updateSportsLoadingState(int n) {
        if (ServiceManager.logger2.isTraceEnabled(32)) {
            ServiceManager.logger2.trace(32).append("GuiControllerSports : updateSportsLoadingState(), sportsLoadingState = ").append(n).log();
        }
        if (n >= 0 && n <= 4) {
            ServiceManager.aslPropertyManager.valueChangedInteger(-1623252224, n);
            int n2 = TLinkServiceManager.getServiceManager().getCurrentViewId();
            if (n2 == 14) {
                TLinkServiceManager.getServiceManager().getGuiControllerSports().updateChangeLeagueSelected();
            }
        } else if (ServiceManager.logger2.isTraceEnabled(32)) {
            ServiceManager.logger2.error(32).append("GuiControllerSports : updateSportsLoadingState(), sportsLoadingState not in range ! ").log();
        }
    }

    public void setSportsTeamNameForSetupPopUp(String string) {
        if (null == string) {
            string = "";
        }
        if (ServiceManager.logger2.isTraceEnabled(32)) {
            ServiceManager.logger2.trace(32).append("TL <SPORTS> ").append("GuiControllerSports - setSportsTeamNameForSetupPopUp(").append(string).append(")").log();
        }
        ServiceManager.aslPropertyManager.valueChangedString(-767614208, string);
    }

    public void updateLiveBroadcastListStateEmpty(boolean bl) {
        if (bl && ServiceManager.logger2.isTraceEnabled(32)) {
            ServiceManager.logger2.trace(32).append("GuiControllerSports : updateLiveBroadcastListEmpty(), List is Empty ").log();
        }
        ServiceManager.aslPropertyManager.valueChangedBoolean(88089344, bl);
    }

    public void updateSportsRankedListsEventsRankingHeadline(String string) {
        if (null == string) {
            string = "";
        }
        if (ServiceManager.logger2.isTraceEnabled(32)) {
            ServiceManager.logger2.trace(32).append("TL <SPORTS> ").append("GuiControllerSports - updateSportsRankedListsEventsRankingHeadline(").append(string).append(")").log();
        }
        ServiceManager.aslPropertyManager.valueChangedString(171975424, string);
    }

    public void removeDoubleEntriesForHeadToHeadGames(List list) {
        if (null != list) {
            for (int i2 = 0; i2 < list.size(); ++i2) {
                GenericPropertyContainer genericPropertyContainer = (GenericPropertyContainer)list.get(i2);
                if (null == genericPropertyContainer) continue;
                int n = GenericPropertyUtility.getInt(227869696, 0, genericPropertyContainer);
                for (int i3 = i2 + 1; i3 < list.size(); ++i3) {
                    int n2;
                    GenericPropertyContainer genericPropertyContainer2 = (GenericPropertyContainer)list.get(i3);
                    if (null == genericPropertyContainer2 || n != (n2 = GenericPropertyUtility.getInt(227869696, 0, genericPropertyContainer2))) continue;
                    list.set(i3, null);
                }
            }
        }
    }

    public GenericPropertyContainer[] removeDoubleEntriesForHeadToHeadGames(GenericPropertyContainer[] genericPropertyContainerArray) {
        if (null != genericPropertyContainerArray) {
            int n;
            int n2;
            int n3;
            int n4;
            for (n4 = 0; n4 < genericPropertyContainerArray.length; ++n4) {
                if (null == genericPropertyContainerArray[n4]) continue;
                n3 = GenericPropertyUtility.getInt(227869696, 0, genericPropertyContainerArray[n4]);
                for (n2 = n4 + 1; n2 < genericPropertyContainerArray.length; ++n2) {
                    if (null == genericPropertyContainerArray[n2] || n3 != (n = GenericPropertyUtility.getInt(227869696, 0, genericPropertyContainerArray[n2]))) continue;
                    genericPropertyContainerArray[n2] = null;
                }
            }
            n4 = 0;
            for (n3 = 0; n3 < genericPropertyContainerArray.length; ++n3) {
                if (null == genericPropertyContainerArray[n3]) continue;
                ++n4;
            }
            GenericPropertyContainer[] genericPropertyContainerArray2 = new GenericPropertyContainer[n4];
            n2 = 0;
            for (n = 0; n < genericPropertyContainerArray.length; ++n) {
                if (null == genericPropertyContainerArray[n] || n2 >= genericPropertyContainerArray2.length) continue;
                genericPropertyContainerArray2[n2] = genericPropertyContainerArray[n];
                ++n2;
            }
            return genericPropertyContainerArray2;
        }
        return new GenericPropertyContainer[0];
    }
}

