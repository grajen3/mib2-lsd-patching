/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn;

import de.vw.mib.asl.api.navigation.INavigationLocation;

public class DestinationInputJpnFormatter {
    public static String getCompleteMunicipality(INavigationLocation iNavigationLocation) {
        if (iNavigationLocation.getWard() != null && iNavigationLocation.getWard().length() > 0) {
            if (iNavigationLocation.getMunicipality() != null && iNavigationLocation.getMunicipality().length() > 0) {
                return new StringBuffer().append(iNavigationLocation.getMunicipality()).append(" ").append(iNavigationLocation.getWard()).toString();
            }
            return iNavigationLocation.getWard();
        }
        return iNavigationLocation.getMunicipality();
    }
}

