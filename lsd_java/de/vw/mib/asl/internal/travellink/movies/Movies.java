/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.movies;

import de.vw.mib.asl.api.navigation.NavAddress;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.DataProcessor;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;
import java.util.Arrays;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.organizer.PersonalData;
import org.dsi.ifc.organizer.PhoneData;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class Movies
implements DataProcessor {
    private int selectedMovieId = -1;
    private GenericPropertyContainer selectedTheaterForMovies = null;
    private GenericPropertyContainer selectedMovie = null;
    public static final int REQUESTTYPE_TL_MOVIETHEATERS_SEARCH_THEATERS_UNKNOWN;
    public static final int REQUESTTYPE_TL_MOVIETHEATERS_SEARCH_THEATERS_CLOSEST;
    public static final int REQUESTTYPE_TL_MOVIETHEATERS_SEARCH_THEATERS_USER_SELECTION;
    private int movieTheatersSearchTheatersRequestType = 0;

    @Override
    public void processAndUpdate(int n, GenericPropertyContainer[] genericPropertyContainerArray, int n2, int n3) {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("Movies - processAndUpdate() - requestType = ").append(n).append(")").log();
        }
        switch (n) {
            case 55: {
                if (null != this.selectedTheaterForMovies) break;
                TLinkServiceManager.getServiceManager().getGuiControllerMovies().prepareAndUpdateNearestTheaterForOneMovie(genericPropertyContainerArray);
                break;
            }
            case 31: {
                TLinkServiceManager.getServiceManager().getDatapool().put(31, genericPropertyContainerArray);
                TLinkServiceManager.getServiceManager().getGuiControllerMovies().prepareAndUpdateTheaterListForOneMovie(genericPropertyContainerArray);
                break;
            }
            case 50: {
                if (1 != this.getMovieTheatersSearchTheatersRequestType()) break;
                TLinkServiceManager.getServiceManager().getGuiControllerMovies().prepareAndUpdateClosestMovieTheater(genericPropertyContainerArray);
                int n4 = TLinkServiceManager.getServiceManager().getCurrentViewId();
                if (0 == n4) {
                    TLinkServiceManager.getServiceManager().getGuiControllerMovieTheaters().prepareAndUpdateMovieTheatersResultsList(genericPropertyContainerArray);
                }
                genericPropertyContainerArray = null;
                break;
            }
            case 35: {
                if (2 != this.getMovieTheatersSearchTheatersRequestType()) break;
                TLinkServiceManager.getServiceManager().getDatapool().put(35, genericPropertyContainerArray);
                TLinkServiceManager.getServiceManager().getGuiControllerMovieTheaters().prepareAndUpdateMovieTheatersResultsList(genericPropertyContainerArray);
                break;
            }
            case 33: {
                TLinkServiceManager.getServiceManager().getGuiControllerMovieTheaters().prepareAndUpdateMovieTheaterShowTimes(genericPropertyContainerArray);
                break;
            }
            case 54: {
                TLinkServiceManager.getServiceManager().getGuiControllerMovies().prepareAndUpdateMovieTheaterShowTimes(genericPropertyContainerArray);
                int n5 = TLinkServiceManager.getServiceManager().getCurrentViewId();
                if (0 != n5) break;
                TLinkServiceManager.getServiceManager().getGuiControllerMovieTheaters().prepareAndUpdateMovieTheaterShowTimes(genericPropertyContainerArray);
                break;
            }
            case 36: {
                TLinkServiceManager.getServiceManager().getGuiControllerMovies().prepareAndUpdateSelectMovieList(genericPropertyContainerArray);
                break;
            }
            case 32: {
                TLinkServiceManager.getServiceManager().getGuiControllerMovies().updateSelectedMovie(genericPropertyContainerArray);
                this.setSelectedMovie(genericPropertyContainerArray);
                break;
            }
            default: {
                if (!ServiceManager.logger2.isTraceEnabled(8)) break;
                ServiceManager.logger2.error(8).append("Movies : processAndUpdate : RequestType is not handled. RequestTypeID --> ").append(n).log();
            }
        }
    }

    public void setSelectedListSortOrderForMoviesResult(EventGeneric eventGeneric) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(8)) {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("Movies - setSelectedListSortOrderForMoviesResult()").log();
            }
            int n = eventGeneric.getInt(0);
            TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setListSortOrderForMoviesResult(n);
            TLinkServiceManager.getServiceManager().getGuiControllerMovies().setListSortOrderForMoviesResult(n);
            Object[] objectArray = ListManager.getGenericASLList(-1338039552).getDSIObjects();
            if (null == objectArray || objectArray.length < 1) {
                return;
            }
            Object[] objectArray2 = (GenericPropertyContainer[])objectArray;
            if (null != objectArray2 && objectArray2.length > 0 && null != objectArray2[0]) {
                Arrays.sort(objectArray2, TLinkServiceManager.getServiceManager().getComparatorTheaterListForOneMovie());
                ListManager.getGenericASLList(-1338039552).updateList(objectArray2);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void setMovieTheatersShowTimesListSortOrder(EventGeneric eventGeneric) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(8)) {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("Movies - setMovieTheatersShowTimesListSortOrder()").log();
            }
            int n = eventGeneric.getInt(0);
            TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setListSortOrderForMovieTheaterShowTimes(n);
            TLinkServiceManager.getServiceManager().getGuiControllerMovies().setMovieTheaterShowTimesListSortOrder(n);
            Object[] objectArray = ListManager.getGenericASLList(-1589697792).getDSIObjects();
            if (null == objectArray || objectArray.length < 1) {
                return;
            }
            Object[] objectArray2 = (GenericPropertyContainer[])objectArray;
            if (null != objectArray2 && objectArray2.length > 0 && null != objectArray2[0]) {
                Arrays.sort(objectArray2, TLinkServiceManager.getServiceManager().getComparatorMovieShowTimes());
                ListManager.getGenericASLList(-1589697792).updateList(objectArray2);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void setMovieTheatersResultListSortOrder(EventGeneric eventGeneric) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(8)) {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("Movies - setMovieTheatersResultListSortOrder()").log();
            }
            int n = eventGeneric.getInt(0);
            TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setListSortOrderForMovieTheaterResult(n);
            TLinkServiceManager.getServiceManager().getGuiControllerMovieTheaters().setMovieTheatersResultListSortOrder(n);
            Object[] objectArray = ListManager.getGenericASLList(-1656806656).getDSIObjects();
            if (null == objectArray || objectArray.length < 1) {
                return;
            }
            Object[] objectArray2 = (GenericPropertyContainer[])objectArray;
            if (null != objectArray2 && objectArray2.length > 0 && null != objectArray2[0]) {
                Arrays.sort(objectArray2, TLinkServiceManager.getServiceManager().getComparatorMovieTheatersResultsList());
                ListManager.getGenericASLList(-1656806656).updateList(objectArray2);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void setMovieTheatersSearchArea(EventGeneric eventGeneric) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(8)) {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("Movies - setMovieTheatersSearchArea()").log();
            }
            int n = eventGeneric.getInt(0);
            TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setMovieTheatersSearchArea(n);
            TLinkServiceManager.getServiceManager().getGuiControllerMovies().setMovieTheatersSearchArea(n);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void setMoviesSearchArea(EventGeneric eventGeneric) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(8)) {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("Movies - setMoviesSearchArea()").log();
            }
            int n = eventGeneric.getInt(0);
            TLinkServiceManager.getServiceManager().getTravelLinkPersistable().setMoviesSearchArea(n);
            TLinkServiceManager.getServiceManager().getGuiControllerMovies().setMoviesSearchArea(n);
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void setSelectedMovie(EventGeneric eventGeneric) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(8)) {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("Movies - setSelectedMovie()").log();
            }
            int n = eventGeneric.getInt(0);
            Object[] objectArray = ListManager.getGenericASLList(-1388371200).getDSIObjects();
            if (null == objectArray || objectArray.length < 1) {
                return;
            }
            GenericPropertyContainer[] genericPropertyContainerArray = (GenericPropertyContainer[])objectArray;
            if (null != genericPropertyContainerArray && n > -1 && n < genericPropertyContainerArray.length && null != genericPropertyContainerArray[n]) {
                this.setSelectedMovieId(GenericPropertyUtility.getInt(814219520, 0, genericPropertyContainerArray[n]));
                String string = GenericPropertyUtility.getString(830996736, 0, genericPropertyContainerArray[n]);
                TLinkServiceManager.getServiceManager().getGuiControllerMovies().prepareAndUpdateSelectedMovieName(string);
                TLinkServiceManager.getServiceManager().getGuiControllerMovies().setMoviesHeadline(string);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestMovieDetails() {
        try {
            if (ServiceManager.logger2.isTraceEnabled(8)) {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("Movies - requestMovieDetails()").log();
            }
            if (this.selectedMovieId > -1) {
                TLinkServiceManager.getServiceManager().getDsiTravelLinkMoviesAdapter().requestMovieDetails(this.selectedMovieId, "");
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void setSelectedMovieAndTheaterDetails(EventGeneric eventGeneric) {
        try {
            GenericPropertyContainer[] genericPropertyContainerArray;
            if (ServiceManager.logger2.isTraceEnabled(8)) {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("Movies - setSelectedMovieAndTheaterDetails()").log();
            }
            int n = eventGeneric.getInt(0);
            Object[] objectArray = ListManager.getGenericASLList(-1338039552).getDSIObjects();
            if (null != objectArray && objectArray.length > 0 && null != (genericPropertyContainerArray = (GenericPropertyContainer[])objectArray) && n > -1 && n < genericPropertyContainerArray.length && null != genericPropertyContainerArray[n]) {
                TLinkServiceManager.getServiceManager().getMoviesDetailsNavigator().setMovieShowTimesForSelectedTheater(genericPropertyContainerArray);
                TLinkServiceManager.getServiceManager().getMoviesDetailsNavigator().setCurrentArrayIndex(n);
                this.setSelectedMovieAndTheaterDetails(genericPropertyContainerArray[n]);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void setSelectedMovieAndTheaterDetails(GenericPropertyContainer genericPropertyContainer) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(8)) {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("Movies - setSelectedMovieAndTheaterDetails()").log();
            }
            if (null != genericPropertyContainer) {
                this.selectedTheaterForMovies = GenericPropertyUtility.getCopy(genericPropertyContainer);
                String string = GenericPropertyUtility.getString(126288128, 0, genericPropertyContainer);
                TLinkServiceManager.getServiceManager().getGuiControllerMovieTheaters().setMovieTheatersHeadline(string);
                TLinkServiceManager.getServiceManager().getGuiControllerMovies().updateSelectedMovieTheater(genericPropertyContainer);
                TLinkServiceManager.getServiceManager().getGuiControllerMovies().updateSelectedMovieTheaterUpcomingStartingTimes(genericPropertyContainer);
                this.updateSelectedMovie();
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public GenericPropertyContainer getSelectedMovieTheater() {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("Movies - getSelectedMovieTheater()").log();
        }
        return this.selectedTheaterForMovies;
    }

    public int getSelectedMovieId() {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("Movies - getSelectedMovieId() : ").append(this.selectedMovieId).log();
        }
        return this.selectedMovieId;
    }

    public void setSelectedMovieId(int n) {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("Movies - setSelectedMovieId( ").append(n).append(" )").log();
        }
        this.selectedMovieId = n;
    }

    public void requestMovieTheatersForOneMovie(int n) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(8)) {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("Movies - requestMovieTheatersForOneMovie( ").append(n).append(" )").log();
            }
            if (n == 55 && null != this.selectedTheaterForMovies) {
                return;
            }
            int n2 = TLinkServiceManager.getServiceManager().getTravelLinkPersistable().getMoviesSearchArea();
            TLinkServiceManager.getServiceManager().getDsiTravelLinkMoviesAdapter().requestMovieTheatersForOneMovie(this.selectedMovieId, 1, n2, -1, -1, TLinkServiceManager.getServiceManager().getFreeSpeller().getEnteredText(), n);
            TLinkServiceManager.getServiceManager().getFreeSpeller().clear();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void updateSelectedMovieTheater() {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("Movies - updateSelectedMovieTheater()").log();
        }
        TLinkServiceManager.getServiceManager().getGuiControllerMovies().updateSelectedMovieTheater(this.selectedTheaterForMovies);
    }

    public void updateSelectedMovie() {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("Movies - updateSelectedMovie()").log();
        }
        TLinkServiceManager.getServiceManager().getGuiControllerMovies().updateSelectedMovie(new GenericPropertyContainer[]{this.selectedMovie});
    }

    public void setSelectedMovie(GenericPropertyContainer[] genericPropertyContainerArray) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(8)) {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("Movies - setSelectedMovie()").log();
            }
            if (null != genericPropertyContainerArray && genericPropertyContainerArray.length > 0 && null != genericPropertyContainerArray[0]) {
                this.selectedMovie = GenericPropertyUtility.getCopy(genericPropertyContainerArray[0]);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void startGuidance() {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("Movies - startGuidance()").log();
        }
        this.startGuidance(this.selectedTheaterForMovies);
    }

    public void startGuidance(GenericPropertyContainer genericPropertyContainer) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(8)) {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("Movies - startGuidance( final GenericPropertyContainer movieTheater )").log();
            }
            if (null != genericPropertyContainer) {
                String string = GenericPropertyUtility.getString(126288128, 0, genericPropertyContainer);
                String string2 = GenericPropertyUtility.getString(260505856, 0, genericPropertyContainer);
                String string3 = GenericPropertyUtility.getString(277283072, 0, genericPropertyContainer);
                String string4 = GenericPropertyUtility.getString(294060288, 0, genericPropertyContainer);
                String string5 = GenericPropertyUtility.getString(310837504, 0, genericPropertyContainer);
                String string6 = GenericPropertyUtility.getString(344391936, 0, genericPropertyContainer);
                String string7 = GenericPropertyUtility.getString(327614720, 0, genericPropertyContainer);
                double d2 = GenericPropertyUtility.getDouble(226951424, 0, genericPropertyContainer);
                double d3 = GenericPropertyUtility.getDouble(243728640, 0, genericPropertyContainer);
                NavAddress navAddress = new NavAddress();
                navAddress.setName(string);
                navAddress.setStreet(string2);
                navAddress.setHousenumber(string3);
                navAddress.setZip(string4);
                navAddress.setCity(string5);
                navAddress.setState(string6);
                navAddress.setPhoneNumber(string7);
                navAddress.setLongitude(d3);
                navAddress.setLatitude(d2);
                TLinkServiceManager.getServiceManager().getApiNavigation().startGuidance(navAddress);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void storeContact() {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("Movies - storeContact( )").log();
        }
        this.storeContact(this.selectedTheaterForMovies);
    }

    public void storeContact(GenericPropertyContainer genericPropertyContainer) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(8)) {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("Movies - storeContact( final GenericPropertyContainer movieTheater )").log();
            }
            if (null != genericPropertyContainer) {
                String string = GenericPropertyUtility.getString(126288128, 0, genericPropertyContainer);
                String string2 = GenericPropertyUtility.getString(260505856, 0, genericPropertyContainer);
                String string3 = GenericPropertyUtility.getString(277283072, 0, genericPropertyContainer);
                String string4 = GenericPropertyUtility.getString(294060288, 0, genericPropertyContainer);
                String string5 = GenericPropertyUtility.getString(310837504, 0, genericPropertyContainer);
                String string6 = GenericPropertyUtility.getString(327614720, 0, genericPropertyContainer);
                double d2 = GenericPropertyUtility.getDouble(226951424, 0, genericPropertyContainer);
                double d3 = GenericPropertyUtility.getDouble(243728640, 0, genericPropertyContainer);
                String string7 = "";
                if (null != string2 && string2.length() > 0 && null != string3 && string3.length() > 0) {
                    string7 = new StringBuffer().append(string3).append(" ").append(string2).toString();
                } else if (null != string2 && string2.length() > 0) {
                    string7 = string2;
                } else if (null != string3 && string3.length() > 0) {
                    string7 = string3;
                }
                AddressData addressData = new AddressData();
                addressData.street = string7;
                addressData.postalCode = string4;
                addressData.locality = string5;
                addressData.geoPosition = TLinkServiceManager.getServiceManager().getTravelLinkUtil().formatGeoPosition(d2, d3);
                PersonalData personalData = new PersonalData();
                personalData.lastName = TLinkServiceManager.getServiceManager().getFreeSpeller().getEnteredText();
                TLinkServiceManager.getServiceManager().getFreeSpeller().clear();
                personalData.organization = string;
                PhoneData phoneData = new PhoneData();
                phoneData.number = string6;
                AdbEntry adbEntry = new AdbEntry();
                adbEntry.personalData = personalData;
                adbEntry.addressData = new AddressData[]{addressData};
                adbEntry.phoneData = new PhoneData[]{phoneData};
                adbEntry.combinedName = "";
                TLinkServiceManager.getServiceManager().getApiNavigation().storeContact(adbEntry);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public int getMovieTheatersSearchTheatersRequestType() {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("Movies - getMovieTheatersSearchTheatersRequestType() : ").append(this.movieTheatersSearchTheatersRequestType).log();
        }
        return this.movieTheatersSearchTheatersRequestType;
    }

    public void setMovieTheatersSearchTheatersRequestType(int n) {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("Movies - setMovieTheatersSearchTheatersRequestType( ").append(n).append(" )").log();
        }
        this.movieTheatersSearchTheatersRequestType = n;
    }

    public void updateTheaterListForOneMovie() {
        GenericPropertyContainer[] genericPropertyContainerArray = TLinkServiceManager.getServiceManager().getDatapool().get(31);
        TLinkServiceManager.getServiceManager().getGuiControllerMovies().prepareAndUpdateTheaterListForOneMovie(genericPropertyContainerArray);
    }

    public void updateMovieTheatersResultsList() {
        GenericPropertyContainer[] genericPropertyContainerArray = TLinkServiceManager.getServiceManager().getDatapool().get(35);
        TLinkServiceManager.getServiceManager().getGuiControllerMovieTheaters().prepareAndUpdateMovieTheatersResultsList(genericPropertyContainerArray);
    }
}

