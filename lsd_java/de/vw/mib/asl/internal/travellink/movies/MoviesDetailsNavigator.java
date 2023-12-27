/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.movies;

import de.vw.mib.asl.api.navigation.map.ASLNavigationMapConfiguration;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import java.util.Arrays;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public class MoviesDetailsNavigator {
    private int currentIndex = 0;
    private GenericPropertyContainer[] movieTheaterArray = new GenericPropertyContainer[0];

    public void requestNextMovieTheaterDetails() {
        try {
            if (null == this.movieTheaterArray || this.movieTheaterArray.length < 1) {
                return;
            }
            ++this.currentIndex;
            if (this.currentIndex < 0 || this.currentIndex >= this.movieTheaterArray.length) {
                this.currentIndex = 0;
            }
            if (ServiceManager.logger2.isTraceEnabled(8)) {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("MoviesDetailsNavigator - requestNextMovieTheaterDetails() - currentIndex = ").append(this.currentIndex).log();
            }
            this.requestMovieTheaterDetails();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestPreviousMovieTheaterDetails() {
        try {
            if (null == this.movieTheaterArray || this.movieTheaterArray.length < 1) {
                return;
            }
            --this.currentIndex;
            if (this.currentIndex < 0 || this.currentIndex >= this.movieTheaterArray.length) {
                this.currentIndex = this.movieTheaterArray.length - 1;
            }
            if (ServiceManager.logger2.isTraceEnabled(8)) {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("MoviesDetailsNavigator - requestPreviousMovieTheaterDetails() - currentIndex = ").append(this.currentIndex).log();
            }
            this.requestMovieTheaterDetails();
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestMovieTheaterDetails() {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("MoviesDetailsNavigator - requestMovieTheaterDetails() - currentIndex = ").append(this.currentIndex).log();
        }
        if (null == this.movieTheaterArray) {
            ServiceManager.logger2.error(8).append("TL <MOVIES> ").append("MoviesDetailsNavigator - requestMovieTheaterDetails() - null == movieTheaterArray").log();
            return;
        }
        if (this.currentIndex >= this.movieTheaterArray.length) {
            ServiceManager.logger2.error(8).append("TL <MOVIES> ").append("MoviesDetailsNavigator - requestMovieTheaterDetails() - currentIndex >= movieTheaterArray.length").log();
            return;
        }
        if (null != this.movieTheaterArray && this.movieTheaterArray.length > this.currentIndex) {
            TLinkServiceManager.getServiceManager().getMovies().setSelectedMovieAndTheaterDetails(this.movieTheaterArray[this.currentIndex]);
            ASLNavigationMapConfiguration aSLNavigationMapConfiguration = TLinkServiceManager.getServiceManager().getAslNavigationMapConfigurationSplitView();
            TLinkServiceManager.getServiceManager().getApiNavigation().setMovieTheaterNavLocation(aSLNavigationMapConfiguration);
            TLinkServiceManager.getServiceManager().getApiNavigation().setMapConfiguration(aSLNavigationMapConfiguration);
        }
    }

    public void setCurrentArrayIndex(int n) {
        if (ServiceManager.logger2.isTraceEnabled(8)) {
            ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("MoviesDetailsNavigator - setCurrentArrayIndex( ").append(n).append(" )").log();
        }
        this.currentIndex = n;
    }

    public void setMovieShowTimesForSelectedTheater(GenericPropertyContainer[] genericPropertyContainerArray) {
        try {
            if (ServiceManager.logger2.isTraceEnabled(8)) {
                ServiceManager.logger2.trace(8).append("TL <MOVIES> ").append("MoviesDetailsNavigator - setMovieShowTimesForSelectedTheater()").log();
            }
            if (null == genericPropertyContainerArray || genericPropertyContainerArray.length < 1) {
                this.movieTheaterArray = new GenericPropertyContainer[0];
            } else {
                this.movieTheaterArray = new GenericPropertyContainer[genericPropertyContainerArray.length];
                for (int i2 = 0; i2 < genericPropertyContainerArray.length; ++i2) {
                    this.movieTheaterArray[i2] = GenericPropertyUtility.getCopy(genericPropertyContainerArray[i2]);
                }
            }
            if (this.movieTheaterArray.length < 2) {
                TLinkServiceManager.getServiceManager().getGuiControllerMain().setButtonEnabled(-448847104, false);
                TLinkServiceManager.getServiceManager().getGuiControllerMain().setButtonEnabled(-482401536, false);
            } else {
                TLinkServiceManager.getServiceManager().getGuiControllerMain().setButtonEnabled(-448847104, true);
                TLinkServiceManager.getServiceManager().getGuiControllerMain().setButtonEnabled(-482401536, true);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void clear() {
        try {
            if (null != this.movieTheaterArray && this.movieTheaterArray.length > 0) {
                Arrays.fill(this.movieTheaterArray, null);
            }
            this.movieTheaterArray = null;
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}

