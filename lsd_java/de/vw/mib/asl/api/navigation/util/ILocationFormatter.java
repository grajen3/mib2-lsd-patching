/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.util;

import de.vw.mib.asl.api.navigation.ILocationWrapper;
import de.vw.mib.asl.api.navigation.util.ILocationFormatterConstants;
import de.vw.mib.properties.values.FixFormatterFieldData;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.organizer.AddressData;
import org.dsi.ifc.search.SearchResult;

public interface ILocationFormatter
extends ILocationFormatterConstants {
    default public String createDetailString(int n, NavLocation navLocation) {
    }

    default public FixFormatterFieldData prepareFixFormatterFieldData(SearchResult searchResult) {
    }

    default public FixFormatterFieldData prepareFixFormatterFieldData(ILocationWrapper iLocationWrapper) {
    }

    default public FixFormatterFieldData prepareFixFormatterFieldData(ILocationWrapper iLocationWrapper, String string, String string2) {
    }

    default public FixFormatterFieldData prepareFixFormatterFieldData(ILocationWrapper iLocationWrapper, String string, String string2, String string3) {
    }

    default public FixFormatterFieldData prepareFixFormatterFieldData(AddressData addressData, String string, ILocationWrapper iLocationWrapper) {
    }

    default public void fillHomeAddressGetter(NavLocation navLocation) {
    }
}

