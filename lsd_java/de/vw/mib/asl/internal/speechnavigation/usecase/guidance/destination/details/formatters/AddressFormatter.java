/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details.formatters;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.memory.INavigationContactAddress;
import de.vw.mib.properties.values.FixFormatterFieldData;

public interface AddressFormatter {
    public static final String TOWNSHIP;
    public static final String DISTRICT;
    public static final String AREA;
    public static final String ZIP;
    public static final String CROSSING;
    public static final String HN;
    public static final String STREET;
    public static final String CITY;
    public static final String COUNTRY;
    public static final String STATE;
    public static final String PREFECTURE;
    public static final String MUNICIPALITY;
    public static final String PLACE;
    public static final String CHOME;

    default public String toShortAddressString(INavigationLocation iNavigationLocation) {
    }

    default public String[] toLongAddressString(INavigationLocation iNavigationLocation) {
    }

    default public String toShortAddressString(INavigationContactAddress iNavigationContactAddress) {
    }

    default public String toLongAddressString(INavigationContactAddress iNavigationContactAddress) {
    }

    default public FixFormatterFieldData toFixFormatter(INavigationLocation iNavigationLocation) {
    }
}

