/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.movies;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.list.GenericPropertyUtility;
import java.util.Arrays;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class MovieTheaterDetailsNavigator {
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
            if (null != this.movieTheaterArray && this.movieTheaterArray.length > this.currentIndex) {
                TLinkServiceManager.getServiceManager().getMovieTheaters().setSelectedMovieTheaterMovieShowTimes(this.movieTheaterArray[this.currentIndex]);
            }
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
            if (null != this.movieTheaterArray && this.movieTheaterArray.length > this.currentIndex) {
                TLinkServiceManager.getServiceManager().getMovieTheaters().setSelectedMovieTheaterMovieShowTimes(this.movieTheaterArray[this.currentIndex]);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void setCurrentArrayIndex(int n) {
        this.currentIndex = n;
    }

    public void setMovieShowTimesForSelectedTheater(GenericPropertyContainer[] genericPropertyContainerArray) {
        try {
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

