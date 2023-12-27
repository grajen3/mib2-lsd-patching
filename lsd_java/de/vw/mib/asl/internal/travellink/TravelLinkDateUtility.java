/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink;

import de.vw.mib.asl.internal.travellink.movies.MovieShowTime;
import org.dsi.ifc.travellink.TravelLinkDate;

public final class TravelLinkDateUtility {
    public int getMovieShowTime(int n, TravelLinkDate[] travelLinkDateArray, TravelLinkDate[] travelLinkDateArray2, boolean bl) {
        int n2;
        int n3 = 0;
        if (null != travelLinkDateArray) {
            for (n2 = 0; n2 < travelLinkDateArray.length; ++n2) {
                if (null == travelLinkDateArray[n2] || travelLinkDateArray[n2].hour <= -1 || travelLinkDateArray[n2].minute <= -1) continue;
                if (n3 == n) {
                    if (bl) {
                        return travelLinkDateArray[n2].minute;
                    }
                    return travelLinkDateArray[n2].hour;
                }
                ++n3;
            }
        }
        if (null != travelLinkDateArray2) {
            for (n2 = 0; n2 < travelLinkDateArray2.length; ++n2) {
                if (null == travelLinkDateArray2[n2] || travelLinkDateArray2[n2].hour <= -1 || travelLinkDateArray2[n2].minute <= -1) continue;
                if (n3 == n) {
                    if (bl) {
                        return travelLinkDateArray2[n2].minute;
                    }
                    return travelLinkDateArray2[n2].hour;
                }
                ++n3;
            }
        }
        return -9999;
    }

    public MovieShowTime getMovieShowTime(int n, TravelLinkDate[] travelLinkDateArray, TravelLinkDate[] travelLinkDateArray2) {
        int n2;
        int n3 = 0;
        if (null != travelLinkDateArray) {
            for (n2 = 0; n2 < travelLinkDateArray.length; ++n2) {
                if (null == travelLinkDateArray[n2] || travelLinkDateArray[n2].hour <= -1 || travelLinkDateArray[n2].minute <= -1) continue;
                if (n3 == n) {
                    return new MovieShowTime(travelLinkDateArray[n2].hour, travelLinkDateArray[n2].minute, false);
                }
                ++n3;
            }
        }
        if (null != travelLinkDateArray2) {
            for (n2 = 0; n2 < travelLinkDateArray2.length; ++n2) {
                if (null == travelLinkDateArray2[n2] || travelLinkDateArray2[n2].hour <= -1 || travelLinkDateArray2[n2].minute <= -1) continue;
                if (n3 == n) {
                    return new MovieShowTime(travelLinkDateArray2[n2].hour, travelLinkDateArray2[n2].minute, true);
                }
                ++n3;
            }
        }
        return null;
    }

    public TravelLinkDate getfirstMovieShowTime(TravelLinkDate[] travelLinkDateArray, TravelLinkDate[] travelLinkDateArray2) {
        int n;
        if (null != travelLinkDateArray) {
            for (n = 0; n < travelLinkDateArray.length; ++n) {
                if (null == travelLinkDateArray[n]) continue;
                return travelLinkDateArray[n];
            }
        }
        if (null != travelLinkDateArray2) {
            for (n = 0; n < travelLinkDateArray2.length; ++n) {
                if (null == travelLinkDateArray2[n]) continue;
                return travelLinkDateArray2[n];
            }
        }
        return null;
    }
}

