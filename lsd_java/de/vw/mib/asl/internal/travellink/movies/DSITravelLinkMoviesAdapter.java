/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.movies;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.travellink.TLinkServiceManager;
import de.vw.mib.asl.internal.travellink.TravelLinkConstants;
import generated.de.vw.mib.asl.internal.ListManager;
import org.dsi.ifc.travellink.GenericProperty;
import org.dsi.ifc.travellink.GenericPropertyContainer;

public final class DSITravelLinkMoviesAdapter {
    public void requestMovieTheatersForOneMovie(int n, int n2, int n3, int n4, int n5, String string, int n6) {
        try {
            int n7 = 31;
            boolean bl = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[6];
            genericPropertyArray[0] = new GenericProperty();
            genericPropertyArray[0].valuesInt = new int[]{n};
            genericPropertyArray[0].key = -2079645696;
            genericPropertyArray[1] = new GenericProperty();
            genericPropertyArray[1].valuesInt = new int[]{n2};
            genericPropertyArray[1].key = -2062868480;
            genericPropertyArray[2] = new GenericProperty();
            genericPropertyArray[2].valuesInt = new int[]{n3};
            genericPropertyArray[2].key = -2046091264;
            genericPropertyArray[3] = new GenericProperty();
            genericPropertyArray[3].valuesInt = new int[0];
            genericPropertyArray[3].key = -1;
            genericPropertyArray[4] = new GenericProperty();
            genericPropertyArray[4].valuesInt = new int[0];
            genericPropertyArray[4].key = -1;
            genericPropertyArray[5] = new GenericProperty();
            genericPropertyArray[5].valuesString = new String[]{string};
            genericPropertyArray[5].key = -1995759616;
            int n8 = 200;
            int n9 = -1;
            boolean bl2 = true;
            boolean bl3 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(31, 1, genericPropertyArray, 200, -1, 1);
            if (!bl3) {
                int n10 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(n6);
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(31, 1, genericPropertyArray, 200, -1, 1, n10);
                ListManager.getGenericASLList(-1338039552).updateList(new GenericPropertyContainer[0]);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestMovieTheaters(int n, int n2, String string, int n3) {
        try {
            int n4 = 35;
            boolean bl = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[7];
            genericPropertyArray[0] = new GenericProperty();
            genericPropertyArray[0].valuesInt = new int[]{n};
            genericPropertyArray[0].key = -2079645696;
            genericPropertyArray[1] = new GenericProperty();
            genericPropertyArray[1].valuesInt = new int[]{1};
            genericPropertyArray[1].key = -2062868480;
            genericPropertyArray[2] = new GenericProperty();
            genericPropertyArray[2].valuesInt = new int[]{n2};
            genericPropertyArray[2].key = -2046091264;
            genericPropertyArray[3] = new GenericProperty();
            genericPropertyArray[3].valuesInt = new int[0];
            genericPropertyArray[3].key = -1;
            genericPropertyArray[4] = new GenericProperty();
            genericPropertyArray[4].valuesInt = new int[0];
            genericPropertyArray[4].key = -1;
            genericPropertyArray[5] = new GenericProperty();
            genericPropertyArray[5].valuesString = new String[]{string};
            genericPropertyArray[5].key = -1995759616;
            genericPropertyArray[6] = new GenericProperty();
            genericPropertyArray[6].valuesBoolean = TravelLinkConstants.GP_BOOLEAN_ARRAY_FALSE;
            genericPropertyArray[6].key = -1978982400;
            int n5 = 200;
            int n6 = -1;
            int n7 = 1;
            if (50 == n3) {
                genericPropertyArray[6].valuesBoolean = TravelLinkConstants.GP_BOOLEAN_ARRAY_TRUE;
                n6 = 5;
                n7 = -1;
                TLinkServiceManager.getServiceManager().getMovies().setMovieTheatersSearchTheatersRequestType(1);
            } else {
                TLinkServiceManager.getServiceManager().getMovies().setMovieTheatersSearchTheatersRequestType(2);
            }
            boolean bl2 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(35, 1, genericPropertyArray, 200, n6, n7);
            if (!bl2) {
                int n8 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(n3);
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(35, 1, genericPropertyArray, 200, n6, n7, n8);
                ListManager.getGenericASLList(-1656806656).updateList(new GenericPropertyContainer[0]);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestMovieDetails(int n, String string) {
        try {
            int n2 = 32;
            boolean bl = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[2];
            genericPropertyArray[0] = new GenericProperty();
            genericPropertyArray[0].valuesInt = new int[]{n};
            genericPropertyArray[0].key = -401924096;
            genericPropertyArray[1] = new GenericProperty();
            genericPropertyArray[1].valuesString = new String[]{string};
            genericPropertyArray[1].key = -385146880;
            int n3 = 100;
            int n4 = -1;
            boolean bl2 = true;
            boolean bl3 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(32, 1, genericPropertyArray, 100, -1, 1);
            if (!bl3) {
                int n5 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(32);
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(32, 1, genericPropertyArray, 100, -1, 1, n5);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestTheaterShowTimes(long l, int n) {
        try {
            int n2 = 33;
            boolean bl = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[]{new GenericProperty()};
            genericPropertyArray[0].valuesLong = new long[]{l};
            genericPropertyArray[0].key = 1275863040;
            int n3 = 100;
            int n4 = -1;
            boolean bl2 = true;
            boolean bl3 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(33, 1, genericPropertyArray, 100, -1, 1);
            if (!bl3) {
                int n5 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(n);
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(33, 1, genericPropertyArray, 100, -1, 1, n5);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }

    public void requestAllMovies(String string) {
        try {
            int n = 36;
            boolean bl = true;
            GenericProperty[] genericPropertyArray = new GenericProperty[]{new GenericProperty()};
            genericPropertyArray[0].valuesString = new String[]{string};
            genericPropertyArray[0].key = -1341382656;
            int n2 = 200;
            int n3 = -1;
            boolean bl2 = true;
            boolean bl3 = TLinkServiceManager.getServiceManager().getDsiProxy().checkIfDsiCallIsRedundant(36, 1, genericPropertyArray, 200, -1, 1);
            if (!bl3) {
                int n4 = TLinkServiceManager.getServiceManager().getSessionManager().getNewSessionId(36);
                TLinkServiceManager.getServiceManager().getDsiProxy().requestToApp(36, 1, genericPropertyArray, 200, -1, 1, n4);
                ListManager.getGenericASLList(-1388371200).updateList(new GenericPropertyContainer[0]);
            }
        }
        catch (Exception exception) {
            ServiceManager.errorHandler.handleError(exception);
        }
    }
}

