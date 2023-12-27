/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.movies;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import de.vw.mib.genericevents.EventGeneric;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class MovieTheaters {
    private GenericPropertyContainer selectedTheaterForMovieTheaters = null;
    private GenericPropertyContainer selectedMovieTheaterMovieShowTimes = null;
    private GenericPropertyContainer closestTheaterForMovieTheatersMainView = null;

    public void setSelectedMovieTheaterMovieShowTimes(EventGeneric eventGeneric) {
        try {
            GenericPropertyContainer[] genericPropertyContainerArray;
            if (ServiceManager.logger2.isTraceEnabled(8)) {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("MovieTheaters - setSelectedMovieTheaterMovieShowTimes( final EventGeneric genericEvent )").log();
            }
            int n = eventGeneric.getInt(0);
            Object[] objectArray = ListManager.getGenericASLList(-1589697792).getDSIObjects();
            if (null != objectArray && objectArray.length > 0 && null != (genericPropertyContainerArray = (GenericPropertyContainer[])objectArray) && n > -1 && n < genericPropertyContainerArray.length && null != genericPropertyContainerArray[n]) {
                TLinkServiceManager.getServiceManager().getMovieTheaterDetailsNavigator().setMovieShowTimesForSelectedTheater(genericPropertyContainerArray);
                TLinkServiceManager.getServiceManager().getMovieTheaterDetailsNavigator().setCurrentArrayIndex(n);
                this.setSelectedMovieTheaterMovieShowTimes(genericPropertyContainerArray[n]);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void setSelectedMovieTheaterMovieShowTimes(GenericPropertyContainer genericPropertyContainer) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(8)) {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("MovieTheaters - setSelectedMovieTheaterMovieShowTimes( final GenericPropertyContainer genericPropertyContainer )").log();
            }
            if (null != genericPropertyContainer) {
                this.selectedMovieTheaterMovieShowTimes = GenericPropertyUtility.getCopy(genericPropertyContainer);
                TLinkServiceManager.getServiceManager().getGuiControllerMovieTheaters().prepareAndUpdateSelectedMovieDetails(this.selectedMovieTheaterMovieShowTimes);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestTheaterShowTimes() {
        try {
            if (ServiceManager.logger2.isTraceEnabled(8)) {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("MovieTheaters - requestTheaterShowTimes()").log();
            }
            ListManager.getGenericASLList(-1589697792).updateList(new GenericPropertyContainer[0]);
            if (null != this.selectedTheaterForMovieTheaters) {
                long l = GenericPropertyUtility.getLong(75956480, 0, this.selectedTheaterForMovieTheaters);
                TLinkServiceManager.getServiceManager().getDsiTravelLinkMoviesAdapter().requestTheaterShowTimes(l, 33);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void setSelectedMovieTheater(EventGeneric eventGeneric) {
        try {
            GenericPropertyContainer[] genericPropertyContainerArray;
            if (ServiceManager.logger2.isTraceEnabled(8)) {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("MovieTheaters - setSelectedMovieTheater()").log();
            }
            int n = eventGeneric.getInt(0);
            Object[] objectArray = ListManager.getGenericASLList(-1656806656).getDSIObjects();
            if (null != objectArray && objectArray.length > 0 && null != (genericPropertyContainerArray = (GenericPropertyContainer[])objectArray) && n > -1 && n < genericPropertyContainerArray.length && null != genericPropertyContainerArray[n]) {
                this.setSelectedTheaterForMovieTheaters(GenericPropertyUtility.getCopy(genericPropertyContainerArray[n]));
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void setSelectedTheaterForMovieTheaters(GenericPropertyContainer genericPropertyContainer) {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("MovieTheaters - setSelectedTheaterForMovieTheaters()").log();
        }
        if (null != genericPropertyContainer) {
            this.selectedTheaterForMovieTheaters = genericPropertyContainer;
            TLinkServiceManager.getServiceManager().getGuiControllerMovies().updateSelectedMovieTheater(this.selectedTheaterForMovieTheaters);
            String string = GenericPropertyUtility.getString(126288128, 0, this.selectedTheaterForMovieTheaters);
            TLinkServiceManager.getServiceManager().getGuiControllerMovieTheaters().setMovieTheatersHeadline(string);
        }
    }

    public GenericPropertyContainer getSelectedTheaterForMovieTheaters() {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("MovieTheaters - getSelectedTheaterForMovieTheaters()").log();
        }
        return this.selectedTheaterForMovieTheaters;
    }

    public void updateSelectedMovieTheater() {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("MovieTheaters - updateSelectedMovieTheater()").log();
        }
        TLinkServiceManager.getServiceManager().getGuiControllerMovies().updateSelectedMovieTheater(this.selectedTheaterForMovieTheaters);
    }

    public void storeContact() {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("MovieTheaters - storeContact()").log();
        }
        TLinkServiceManager.getServiceManager().getMovies().storeContact(this.selectedTheaterForMovieTheaters);
    }

    public void startGuidance() {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("MovieTheaters - startGuidance()").log();
        }
        TLinkServiceManager.getServiceManager().getMovies().startGuidance(this.selectedTheaterForMovieTheaters);
    }

    public GenericPropertyContainer getClosestTheaterForMovieTheaters() {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("MovieTheaters - getClosestTheaterForMovieTheaters()").log();
        }
        return this.closestTheaterForMovieTheatersMainView;
    }

    public void setClosestTheaterForMovieTheaters(GenericPropertyContainer genericPropertyContainer) {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("MovieTheaters - setClosestTheaterForMovieTheaters()").log();
        }
        this.closestTheaterForMovieTheatersMainView = genericPropertyContainer;
    }
}

