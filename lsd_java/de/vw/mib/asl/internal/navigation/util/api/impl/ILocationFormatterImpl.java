/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util.api.impl;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.util.ILocationFormatter;
import de.vw.mib.asl.internal.navigation.util.LocationFormatter;
import de.vw.mib.properties.values.FixFormatterFieldData;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.search.SearchResult;

public final class ILocationFormatterImpl
implements ILocationFormatter {
    @Override
    public FixFormatterFieldData prepareFixFormatterFieldData(AddressData addressData, String string, ILocationWrapper iLocationWrapper) {
        return LocationFormatter.prepareFixFormatterFieldData(addressData, string, iLocationWrapper);
    }

    @Override
    public FixFormatterFieldData prepareFixFormatterFieldData(ILocationWrapper iLocationWrapper, String string, String string2, String string3) {
        return LocationFormatter.prepareFixFormatterFieldData(iLocationWrapper, string, string2, string3);
    }

    @Override
    public FixFormatterFieldData prepareFixFormatterFieldData(ILocationWrapper iLocationWrapper, String string, String string2) {
        return LocationFormatter.prepareFixFormatterFieldData(iLocationWrapper, string, string2);
    }

    @Override
    public FixFormatterFieldData prepareFixFormatterFieldData(ILocationWrapper iLocationWrapper) {
        return LocationFormatter.prepareFixFormatterFieldData(iLocationWrapper);
    }

    @Override
    public FixFormatterFieldData prepareFixFormatterFieldData(SearchResult searchResult) {
        return LocationFormatter.prepareFixFormatterFieldData(searchResult);
    }

    @Override
    public String createDetailString(int n, NavLocation navLocation) {
        return LocationFormatter.createDetailString(n, navLocation);
    }

    @Override
    public void fillHomeAddressGetter(NavLocation navLocation) {
        LocationFormatter.fillHomeAddressGetter(navLocation);
    }
}

