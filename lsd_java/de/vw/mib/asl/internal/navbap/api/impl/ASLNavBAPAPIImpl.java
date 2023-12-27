/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navbap.api.impl;

import de.vw.mib.asl.api.navbap.ASLNavBAPAPI;
import de.vw.mib.asl.api.navbap.IBapTurnToInfoNavBap;
import de.vw.mib.asl.api.navbap.ILDListElementNavBap;
import de.vw.mib.asl.api.navbap.ILocationAccessorNavBap;
import de.vw.mib.asl.api.navbap.INavLaneGuidanceDataNavBap;
import de.vw.mib.asl.api.navbap.IRouteNavBap;
import de.vw.mib.asl.api.system.ASLSystemFactory;
import de.vw.mib.asl.framework.internal.framework.GenericCollector;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.list.ASLListElementFetcher;
import de.vw.mib.asl.internal.list.impl.ASLListItemSoftCacheImpl;
import de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapTMCinfoCollector;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.ListManager;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapCompassInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapCurrentAltitudeCollector;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapDestinationInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapDistanceToDestinationCollector;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapDistanceToNextManeuverCollector;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapMapScaleCollector;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapNavBookSpellerResultCollector;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapRemainingTravelTimeCollector;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapStopoverInfoCollector;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapTimeToDestinationCollector;
import generated.de.vw.mib.asl.internal.navigation.bap.transformer.NavigationBapTurnToInfoCollector;
import java.util.Calendar;
import java.util.Vector;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.organizer.DataSet;
import org.dsi.ifc.organizer.PersonalData;
import org.dsi.ifc.tmc.TmcMessage;

public class ASLNavBAPAPIImpl
implements ASLNavBAPAPI {
    private static final int YEAR_TAUSEND;
    private NavigationBapCurrentAltitudeCollector[] myAltitudeCollector = new NavigationBapCurrentAltitudeCollector[]{new NavigationBapCurrentAltitudeCollector()};
    private NavigationBapCompassInfoCollector[] collectorCompassInfo = new NavigationBapCompassInfoCollector[]{new NavigationBapCompassInfoCollector()};
    private NavigationBapDistanceToDestinationCollector[] distanceCollector = new NavigationBapDistanceToDestinationCollector[]{new NavigationBapDistanceToDestinationCollector()};
    private NavigationBapDistanceToNextManeuverCollector[] distanceTnmCollector = new NavigationBapDistanceToNextManeuverCollector[]{new NavigationBapDistanceToNextManeuverCollector()};
    private NavigationBapTimeToDestinationCollector[] timeToDestCollector = new NavigationBapTimeToDestinationCollector[]{new NavigationBapTimeToDestinationCollector()};
    private NavigationBapTurnToInfoCollector[] turnToInfoCollector = new NavigationBapTurnToInfoCollector[]{new NavigationBapTurnToInfoCollector()};
    private NavigationBapRemainingTravelTimeCollector[] remainingTravelTimeCollector = new NavigationBapRemainingTravelTimeCollector[]{new NavigationBapRemainingTravelTimeCollector()};
    private final NavigationBapMapScaleCollector[] mapScaleCollector = new NavigationBapMapScaleCollector[]{new NavigationBapMapScaleCollector()};

    private static char[] bytesToCharacters(byte[] byArray) {
        int n = byArray.length;
        char[] cArray = new char[n];
        for (int i2 = 0; i2 < n; ++i2) {
            cArray[i2] = (char)(byArray[i2] & 0xFF);
        }
        return cArray;
    }

    private String splitTurnToInfoStreet(String string) {
        String string2;
        int n = string.indexOf(10);
        if (n == -1) {
            string2 = string;
        } else if (n != 0) {
            string2 = string.substring(0, n);
        } else {
            int n2;
            int n3 = string.length();
            for (n2 = n; n2 < n3 && string.charAt(n2) == '\n'; ++n2) {
            }
            if (n2 != n3) {
                int n4 = string.indexOf(10, n2);
                n4 = n4 == -1 ? n3 : n4;
                string2 = string.substring(n2, n4);
            } else {
                string2 = "";
            }
        }
        return string2;
    }

    @Override
    public void updateBapCompassInfo(int n, int n2) {
        ServiceManager.logger.trace(16384, new StringBuffer().append("CompassInfo angle=").append(n).append(" direction=").append(n2).toString());
        this.collectorCompassInfo[0].navigation_bap_compass_info_angle = n;
        this.collectorCompassInfo[0].navigation_bap_compass_info_direction = n2;
        ListManager.getGenericASLList(748).updateList(this.collectorCompassInfo);
    }

    @Override
    public void updateBapDistanceToDestination(int n, int n2) {
        ServiceManager.logger.trace(16384, new StringBuffer().append("DistanceToDestination distance=").append(n).append(" unit=").append(n2).toString());
        this.distanceCollector[0].navigation_bap_distance_to_destination_distance = n;
        this.distanceCollector[0].navigation_bap_distance_to_destination_unit = n2;
        ListManager.getGenericASLList(749).updateList(this.distanceCollector);
    }

    @Override
    public void updateBapDistanceToDestination(int n, int n2, boolean bl) {
        ServiceManager.logger.trace(16384, new StringBuffer().append("DistanceToDestination distance=").append(n).append(" unit=").append(n2).toString());
        this.distanceCollector[0].navigation_bap_distance_to_destination_distance = n;
        this.distanceCollector[0].navigation_bap_distance_to_destination_unit = n2;
        this.distanceCollector[0].navigation_bap_distance_to_destination_type = bl ? 1 : 0;
        ListManager.getGenericASLList(749).updateList(this.distanceCollector);
    }

    @Override
    public void updateBapDistanceToNextManeuver(int n, int n2, boolean bl, int n3) {
        ServiceManager.logger.trace(16384, new StringBuffer().append("UpdateDistanceToNextManeuver distance=").append(n).append(" unit=").append(n2).append(" bargraphEnabled=").append(bl).append(" bargraphValue=").append(n3).toString());
        this.distanceTnmCollector[0].navigation_bap_next_manuever_bargraph = n3;
        this.distanceTnmCollector[0].navigation_bap_next_manuever_bargraph_on_off = bl ? 1 : 0;
        this.distanceTnmCollector[0].navigation_bap_next_manuever_distance = n;
        this.distanceTnmCollector[0].navigation_bap_next_manuever_distance_unit = n2;
        ListManager.getGenericASLList(741).updateList(this.distanceTnmCollector);
    }

    @Override
    public void updateBapTimeToDestination(int n, int n2, long l) {
        this.timeToDestCollector[0].navigation_bap_time_to_destination_time_info = n == 1 ? 1 : 0;
        this.timeToDestCollector[0].navigation_bap_time_to_destination_time_format = n2 == 1 ? 1 : 0;
        this.updateBapETA(l);
    }

    @Override
    public void updateBapTurnToInfo(String string, String string2) {
        this.turnToInfoCollector[0].navigation_bap_turn_to_info_street = string;
        this.turnToInfoCollector[0].navigation_bap_turn_to_info_sign_post = string2;
        ListManager.getGenericASLList(744).updateList(this.turnToInfoCollector);
    }

    @Override
    public void updateBapAltitudeCollector(int n, int n2) {
        this.myAltitudeCollector[0].navigation_bap_current_altitude = n;
        this.myAltitudeCollector[0].navigation_bap_current_altitude_unit = n2;
        ListManager.getGenericASLList(3801).updateList(this.myAltitudeCollector);
    }

    private void updateBapRTT(int n, int n2) {
        if (n < 0 || n2 < 0) {
            this.remainingTravelTimeCollector[0].navigation_bap_remaining_travel_time_validity = false;
            this.remainingTravelTimeCollector[0].navigation_bap_remaining_travel_time_minute = -1;
            this.remainingTravelTimeCollector[0].navigation_bap_remaining_travel_time_hour = -1;
        } else {
            this.remainingTravelTimeCollector[0].navigation_bap_remaining_travel_time_validity = true;
            this.remainingTravelTimeCollector[0].navigation_bap_remaining_travel_time_minute = n2;
            this.remainingTravelTimeCollector[0].navigation_bap_remaining_travel_time_hour = n;
        }
        ListManager.getGenericASLList(753930240).updateList(this.remainingTravelTimeCollector);
    }

    private void updateBapETA(int n, int n2) {
        if (n < 0 || n2 < 0) {
            this.timeToDestCollector[0].navigation_bap_time_to_destination_validity = false;
            this.timeToDestCollector[0].navigation_bap_time_to_destination_minute = -1;
            this.timeToDestCollector[0].navigation_bap_time_to_destination_hour = -1;
            this.timeToDestCollector[0].navigation_bap_time_to_destination_day = -1;
            this.timeToDestCollector[0].navigation_bap_time_to_destination_month = -1;
            this.timeToDestCollector[0].navigation_bap_time_to_destination_year = -1;
        } else {
            Calendar calendar = ASLSystemFactory.getSystemApi().getCurrentCalendar((n2 + n * 60) * 60 * 1000);
            this.timeToDestCollector[0].navigation_bap_time_to_destination_validity = true;
            this.timeToDestCollector[0].navigation_bap_time_to_destination_minute = calendar.get(12);
            this.timeToDestCollector[0].navigation_bap_time_to_destination_hour = calendar.get(11);
            this.timeToDestCollector[0].navigation_bap_time_to_destination_day = calendar.get(5);
            this.timeToDestCollector[0].navigation_bap_time_to_destination_month = calendar.get(2) + 1;
            this.timeToDestCollector[0].navigation_bap_time_to_destination_year = calendar.get(1) % 1000;
        }
        ListManager.getGenericASLList(750).updateList(this.timeToDestCollector);
    }

    private void updateBapETA(long l) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l);
        this.timeToDestCollector[0].navigation_bap_time_to_destination_validity = true;
        this.timeToDestCollector[0].navigation_bap_time_to_destination_month = calendar.get(2) + 1;
        this.timeToDestCollector[0].navigation_bap_time_to_destination_day = calendar.get(5);
        this.timeToDestCollector[0].navigation_bap_time_to_destination_hour = calendar.get(11);
        this.timeToDestCollector[0].navigation_bap_time_to_destination_minute = calendar.get(12);
        this.timeToDestCollector[0].navigation_bap_time_to_destination_year = calendar.get(1) % 1000;
        ListManager.getGenericASLList(750).updateList(this.timeToDestCollector);
    }

    @Override
    public void updateBapTimeToDestination2(int n, int n2, int n3) {
        this.updateBapRTT(n, n2);
        this.updateBapETA(n, n2);
    }

    private static int calculateRttMinutes(long l) {
        return (int)(l % 0 / 0);
    }

    private static int calculateRttHours(long l) {
        return (int)(l / 0);
    }

    @Override
    public void updateBapTimeToDestinationRTT(long l) {
        int n = ASLNavBAPAPIImpl.calculateRttMinutes(l);
        int n2 = ASLNavBAPAPIImpl.calculateRttHours(l);
        this.updateBapRTT(n2, n);
        this.updateBapETA(n2, n);
    }

    @Override
    public void updateBapTimeToDestinationRTTandETA(long l, long l2) {
        this.updateBapRTT(ASLNavBAPAPIImpl.calculateRttHours(l), ASLNavBAPAPIImpl.calculateRttMinutes(l));
        this.updateBapETA(l2);
    }

    @Override
    public void updateBapTMCInfo(TmcMessage tmcMessage) {
        Object[] objectArray = new NavigationBapTMCinfoCollector[]{new NavigationBapTMCinfoCollector(tmcMessage)};
        ListManager.getGenericASLList(743).updateList(objectArray);
    }

    @Override
    public void navBookInit(ASLListElementFetcher aSLListElementFetcher, int n) {
        ListManager.getGenericASLList(746).enableWindowing(new ASLListItemSoftCacheImpl(), aSLListElementFetcher, n, 1);
        ListManager.getGenericASLList(746).setColumn4ObjectId(0);
    }

    @Override
    public void navBookUpdate(int n, DataSet[] dataSetArray, int n2) {
        if (n == 0) {
            DataSet[] dataSetArray2 = dataSetArray;
            int n3 = dataSetArray2.length;
            if (n3 > 0) {
                Object[] objectArray = new GenericCollector[n3];
                for (int i2 = 0; i2 < n3; ++i2) {
                    GenericCollector genericCollector;
                    objectArray[i2] = genericCollector = new GenericCollector();
                    genericCollector.setLongItem(0, dataSetArray2[i2].entryId);
                    genericCollector.setIntItem(1, dataSetArray2[i2].getEntryPosition());
                    genericCollector.setStringItem(2, dataSetArray2[i2].getGeneralDescription1());
                    genericCollector.setStringItem(3, dataSetArray2[i2].getGeneralDescription2());
                }
                ListManager.getGenericASLList(746).updateListItems(dataSetArray[0].entryPosition, objectArray);
            }
            ListManager.getGenericASLList(746).setSize(n2);
        }
    }

    @Override
    public void favoriteDestinationInit(ASLListElementFetcher aSLListElementFetcher, int n) {
        ListManager.getGenericASLList(740).enableWindowing(new ASLListItemSoftCacheImpl(), aSLListElementFetcher, n, 1);
        ListManager.getGenericASLList(740).setColumn4ObjectId(0);
    }

    @Override
    public void favoriteDestinationUpdate(int n, DataSet[] dataSetArray, int n2) {
        if (n == 0) {
            int n3 = dataSetArray.length;
            Object[] objectArray = new GenericCollector[n3];
            for (int i2 = 0; i2 < n3; ++i2) {
                GenericCollector genericCollector;
                objectArray[i2] = genericCollector = new GenericCollector();
                genericCollector.setLongItem(0, dataSetArray[i2].getEntryId());
                genericCollector.setStringItem(1, dataSetArray[i2].getGeneralDescription1());
                genericCollector.setIntItem(2, dataSetArray[i2].getEntryPosition());
                genericCollector.setIntItem(3, 0);
            }
            ListManager.getGenericASLList(740).setSize(n2);
            if (n3 > 0) {
                ListManager.getGenericASLList(740).updateListItems(dataSetArray[0].entryPosition, objectArray);
            }
        }
    }

    @Override
    public void navBookSpellerResult(int n, int n2, DataSet[] dataSetArray, int n3, String string, String string2) {
        if (n == 2) {
            NavigationBapNavBookSpellerResultCollector navigationBapNavBookSpellerResultCollector = new NavigationBapNavBookSpellerResultCollector();
            navigationBapNavBookSpellerResultCollector.navigation_bap_nav_book_speller_id_of_first_entry = -1;
            navigationBapNavBookSpellerResultCollector.navigation_bap_nav_book_speller_position_of_first_entry = -1;
            navigationBapNavBookSpellerResultCollector.navigation_bap_nav_book_speller_number_of_entries = n3;
            navigationBapNavBookSpellerResultCollector.navigation_bap_nav_book_speller_valid_chars = string == null ? "" : string;
            ListManager.getGenericASLList(747).updateList(new NavigationBapNavBookSpellerResultCollector[]{navigationBapNavBookSpellerResultCollector});
        } else {
            NavigationBapNavBookSpellerResultCollector navigationBapNavBookSpellerResultCollector = new NavigationBapNavBookSpellerResultCollector();
            if (!Util.isNullOrEmpty(dataSetArray)) {
                navigationBapNavBookSpellerResultCollector.navigation_bap_nav_book_speller_id_of_first_entry = (int)dataSetArray[0].getEntryId();
                navigationBapNavBookSpellerResultCollector.navigation_bap_nav_book_speller_position_of_first_entry = dataSetArray[0].getEntryPosition();
            } else {
                navigationBapNavBookSpellerResultCollector.navigation_bap_nav_book_speller_id_of_first_entry = -1;
                navigationBapNavBookSpellerResultCollector.navigation_bap_nav_book_speller_position_of_first_entry = -1;
            }
            navigationBapNavBookSpellerResultCollector.navigation_bap_nav_book_speller_number_of_entries = n3;
            navigationBapNavBookSpellerResultCollector.navigation_bap_nav_book_speller_valid_chars = string == null ? "" : string;
            ListManager.getGenericASLList(747).updateList(new NavigationBapNavBookSpellerResultCollector[]{navigationBapNavBookSpellerResultCollector});
        }
    }

    @Override
    public void addrListUpdate(AdbEntry[] adbEntryArray) {
        AdbEntry[] adbEntryArray2 = adbEntryArray;
        Object[] objectArray = new GenericCollector[adbEntryArray2.length];
        for (int i2 = 0; i2 < adbEntryArray2.length; ++i2) {
            AddressData[] addressDataArray;
            GenericCollector genericCollector = new GenericCollector();
            objectArray[i2] = genericCollector;
            genericCollector.setIntItem(0, adbEntryArray2[i2].entryType);
            PersonalData personalData = adbEntryArray2[i2].personalData;
            if (personalData != null) {
                genericCollector.setStringItem(7, personalData.getLastName());
                genericCollector.setStringItem(6, personalData.getFirstName());
            }
            if ((addressDataArray = adbEntryArray2[i2].getAddressData()) == null || addressDataArray.length == 0) continue;
            AddressData addressData = addressDataArray[0];
            genericCollector.setStringItem(12, addressData.getStreet());
            genericCollector.setStringItem(2, addressData.getLocality());
            genericCollector.setStringItem(11, addressData.getRegion());
            genericCollector.setStringItem(10, addressData.getPostalCode());
            genericCollector.setStringItem(4, addressData.getCountry());
        }
        ListManager.getGenericASLList(739).updateList(objectArray);
    }

    @Override
    public void updateBapTurnToInfo(IBapTurnToInfoNavBap[] iBapTurnToInfoNavBapArray) {
        Object[] objectArray = new NavigationBapTurnToInfoCollector[1];
        for (int i2 = 0; i2 < 1; ++i2) {
            NavigationBapTurnToInfoCollector navigationBapTurnToInfoCollector = new NavigationBapTurnToInfoCollector();
            navigationBapTurnToInfoCollector.navigation_bap_turn_to_info_sign_post = iBapTurnToInfoNavBapArray[i2].getSignPost();
            navigationBapTurnToInfoCollector.navigation_bap_turn_to_info_street = this.splitTurnToInfoStreet(iBapTurnToInfoNavBapArray[i2].getTurnToInfo());
            objectArray[i2] = navigationBapTurnToInfoCollector;
        }
        ListManager.getGenericASLList(744).updateList(objectArray);
    }

    @Override
    public Object createDetailListCollector(ILocationAccessorNavBap iLocationAccessorNavBap, String string) {
        GenericCollector genericCollector = new GenericCollector();
        genericCollector.setStringItem(12, string);
        genericCollector.setStringItem(2, iLocationAccessorNavBap.getTown());
        genericCollector.setStringItem(10, iLocationAccessorNavBap.getZipCode());
        genericCollector.setStringItem(4, iLocationAccessorNavBap.getCountry());
        genericCollector.setStringItem(8, iLocationAccessorNavBap.getPoiCategory());
        genericCollector.setIntItem(9, iLocationAccessorNavBap.getPoiCategoryNumber());
        return genericCollector;
    }

    @Override
    public void updateRgCurrentRoute(IRouteNavBap iRouteNavBap, ILocationAccessorNavBap iLocationAccessorNavBap) {
        Object object;
        NavLocation navLocation = iRouteNavBap.getRoutelist()[iRouteNavBap.getRoutelist().length - 1].getRouteLocation();
        StringBuffer stringBuffer = new StringBuffer();
        if (iLocationAccessorNavBap.getStreet() != null) {
            stringBuffer.append(iLocationAccessorNavBap.getStreet());
            object = iLocationAccessorNavBap.getHousenumber();
            if (object != null) {
                stringBuffer.append(" ");
                stringBuffer.append((String)object);
            }
        }
        object = new NavigationBapDestinationInfoCollector();
        ((NavigationBapDestinationInfoCollector)object).navigation_bap_latitude = (int)((double)iLocationAccessorNavBap.getLatitude() / 1.1930464E7 * 1000000.0);
        ((NavigationBapDestinationInfoCollector)object).navigation_bap_longitude = (int)((double)iLocationAccessorNavBap.getLongitude() / 1.1930464E7 * 1000000.0);
        ((NavigationBapDestinationInfoCollector)object).navigation_bap_poi = iLocationAccessorNavBap.getPoiCategoryNumber();
        ((NavigationBapDestinationInfoCollector)object).navigation_bap_poi_description = iLocationAccessorNavBap.getPoiCategory();
        ((NavigationBapDestinationInfoCollector)object).navigation_bap_street = stringBuffer.toString();
        ((NavigationBapDestinationInfoCollector)object).navigation_bap_town = iLocationAccessorNavBap.getTown();
        try {
            ((NavigationBapDestinationInfoCollector)object).navigation_bap_state = iLocationAccessorNavBap.getState();
        }
        catch (Throwable throwable) {
            ServiceManager.errorHandler.handleError(throwable);
            ((NavigationBapDestinationInfoCollector)object).navigation_bap_state = "";
        }
        ((NavigationBapDestinationInfoCollector)object).navigation_bap_postal_code = iLocationAccessorNavBap.getZipCode();
        ((NavigationBapDestinationInfoCollector)object).navigation_bap_country = iLocationAccessorNavBap.getCountry();
        NavigationBapStopoverInfoCollector navigationBapStopoverInfoCollector = new NavigationBapStopoverInfoCollector();
        navigationBapStopoverInfoCollector.navigation_bap_current_stopover = (int)iRouteNavBap.getIndexOfCurrentDestination();
        navigationBapStopoverInfoCollector.navigation_bap_total_number_of_stopovers = iRouteNavBap.getRoutelist().length;
        ListManager.getGenericASLList(3800).updateListItem(0, navigationBapStopoverInfoCollector);
        ListManager.getGenericASLList(3799).updateListItem(0, object);
    }

    @Override
    public void lastDestListUpdate(ILDListElementNavBap[] iLDListElementNavBapArray) {
        ILDListElementNavBap[] iLDListElementNavBapArray2 = iLDListElementNavBapArray;
        if (iLDListElementNavBapArray2 == null) {
            iLDListElementNavBapArray2 = new ILDListElementNavBap[]{};
        }
        Object[] objectArray = new GenericCollector[iLDListElementNavBapArray2.length];
        for (int i2 = 0; i2 < iLDListElementNavBapArray2.length; ++i2) {
            GenericCollector genericCollector = new GenericCollector();
            objectArray[i2] = genericCollector;
            genericCollector.setStringItem(1, iLDListElementNavBapArray2[i2].getTitle());
            genericCollector.setLongItem(0, iLDListElementNavBapArray2[i2].getId());
            genericCollector.setIntItem(2, 0);
        }
        ListManager.getGenericASLList(745).updateList(objectArray);
    }

    @Override
    public void updateBapLaneGuidance(INavLaneGuidanceDataNavBap[] iNavLaneGuidanceDataNavBapArray, boolean bl) {
        INavLaneGuidanceDataNavBap[] iNavLaneGuidanceDataNavBapArray2 = iNavLaneGuidanceDataNavBapArray;
        if (iNavLaneGuidanceDataNavBapArray2 == null || !bl) {
            iNavLaneGuidanceDataNavBapArray2 = new INavLaneGuidanceDataNavBap[]{};
        }
        Object[] objectArray = new GenericCollector[iNavLaneGuidanceDataNavBapArray2.length];
        Vector vector = new Vector();
        for (int i2 = 0; i2 < iNavLaneGuidanceDataNavBapArray2.length; ++i2) {
            GenericCollector genericCollector = new GenericCollector();
            genericCollector.setIntItem(0, iNavLaneGuidanceDataNavBapArray2[i2].getLaneDirection());
            genericCollector.setIntItem(6, iNavLaneGuidanceDataNavBapArray2[i2].getGuidanceInfo());
            genericCollector.setIntItem(5, iNavLaneGuidanceDataNavBapArray2[i2].getLaneDescription());
            genericCollector.setIntItem(3, iNavLaneGuidanceDataNavBapArray2[i2].getLaneMarkingLeft());
            genericCollector.setIntItem(4, iNavLaneGuidanceDataNavBapArray2[i2].getLaneMarkingRight());
            genericCollector.setIntItem(2, iNavLaneGuidanceDataNavBapArray2[i2].getLaneType());
            String string = "";
            byte[] byArray = iNavLaneGuidanceDataNavBapArray2[i2].getLaneSideStreets();
            if (byArray != null) {
                string = new String(ASLNavBAPAPIImpl.bytesToCharacters(byArray));
            }
            genericCollector.setStringItem(1, string);
            objectArray[i2] = genericCollector;
            vector.add(genericCollector);
        }
        ListManager.getGenericASLList(742).updateList(objectArray);
    }

    @Override
    public void updateMapsScale(int n, int n2) {
        ServiceManager.logger.trace(16384, new StringBuffer().append("MapScale zoomLevel=").append(n).append(" unit=").append(n2).append(" ").toString());
        this.updateMapsScale(n, n2, 0);
    }

    @Override
    public void updateMapsScale(int n, int n2, int n3) {
        ServiceManager.logger.trace(16384, new StringBuffer().append("MapScale zoomLevel=").append(n).append(" unit=").append(n2).append(" ").toString());
        this.mapScaleCollector[0].navigation_bap_map_scale = n;
        this.mapScaleCollector[0].navigation_bap_map_scale_unit = n2;
        this.mapScaleCollector[0].navigation_bap_map_scale_autozoom = n3;
        ListManager.getGenericASLList(3798).updateList(this.mapScaleCollector);
    }
}

