/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.global.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationDescriptorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationDescriptor;

public class NavLocationSerializer {
    public static void putOptionalNavLocation(ISerializer iSerializer, NavLocation navLocation) {
        boolean bl = navLocation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = navLocation.getVersion();
            iSerializer.putOptionalString(string);
            boolean bl2 = navLocation.isVersionOfLocationStructureValid();
            iSerializer.putBool(bl2);
            boolean bl3 = navLocation.isPositionValid();
            iSerializer.putBool(bl3);
            int n = navLocation.getLongitude();
            iSerializer.putInt32(n);
            int n2 = navLocation.getLatitude();
            iSerializer.putInt32(n2);
            int n3 = navLocation.getAltitude();
            iSerializer.putInt32(n3);
            String string2 = navLocation.getCountry();
            iSerializer.putOptionalString(string2);
            String string3 = navLocation.getCountryAbbreviation();
            iSerializer.putOptionalString(string3);
            String string4 = navLocation.getHousenumber();
            iSerializer.putOptionalString(string4);
            String string5 = navLocation.getJunction();
            iSerializer.putOptionalString(string5);
            String string6 = navLocation.getStreet();
            iSerializer.putOptionalString(string6);
            String string7 = navLocation.getStreetRefinement();
            iSerializer.putOptionalString(string7);
            String string8 = navLocation.getTown();
            iSerializer.putOptionalString(string8);
            String string9 = navLocation.getTowncenter();
            iSerializer.putOptionalString(string9);
            String string10 = navLocation.getTownRefinement();
            iSerializer.putOptionalString(string10);
            String string11 = navLocation.getZipCode();
            iSerializer.putOptionalString(string11);
            NavLocationDescriptor[] navLocationDescriptorArray = navLocation.getProprietaryData();
            NavLocationDescriptorSerializer.putOptionalNavLocationDescriptorVarArray(iSerializer, navLocationDescriptorArray);
        }
    }

    public static void putOptionalNavLocationVarArray(ISerializer iSerializer, NavLocation[] navLocationArray) {
        boolean bl = navLocationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(navLocationArray.length);
            for (int i2 = 0; i2 < navLocationArray.length; ++i2) {
                NavLocationSerializer.putOptionalNavLocation(iSerializer, navLocationArray[i2]);
            }
        }
    }

    public static NavLocation getOptionalNavLocation(IDeserializer iDeserializer) {
        NavLocation navLocation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            String string4;
            String string5;
            String string6;
            String string7;
            String string8;
            String string9;
            String string10;
            int n;
            int n2;
            int n3;
            boolean bl2;
            boolean bl3;
            String string11;
            navLocation = new NavLocation();
            navLocation.version = string11 = iDeserializer.getOptionalString();
            navLocation.versionOfLocationStructureValid = bl3 = iDeserializer.getBool();
            navLocation.positionValid = bl2 = iDeserializer.getBool();
            navLocation.longitude = n3 = iDeserializer.getInt32();
            navLocation.latitude = n2 = iDeserializer.getInt32();
            navLocation.altitude = n = iDeserializer.getInt32();
            navLocation.country = string10 = iDeserializer.getOptionalString();
            navLocation.countryAbbreviation = string9 = iDeserializer.getOptionalString();
            navLocation.housenumber = string8 = iDeserializer.getOptionalString();
            navLocation.junction = string7 = iDeserializer.getOptionalString();
            navLocation.street = string6 = iDeserializer.getOptionalString();
            navLocation.streetRefinement = string5 = iDeserializer.getOptionalString();
            navLocation.town = string4 = iDeserializer.getOptionalString();
            navLocation.towncenter = string3 = iDeserializer.getOptionalString();
            navLocation.townRefinement = string2 = iDeserializer.getOptionalString();
            navLocation.zipCode = string = iDeserializer.getOptionalString();
            NavLocationDescriptor[] navLocationDescriptorArray = NavLocationDescriptorSerializer.getOptionalNavLocationDescriptorVarArray(iDeserializer);
            navLocation.proprietaryData = navLocationDescriptorArray;
        }
        return navLocation;
    }

    public static NavLocation[] getOptionalNavLocationVarArray(IDeserializer iDeserializer) {
        NavLocation[] navLocationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            navLocationArray = new NavLocation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                navLocationArray[i2] = NavLocationSerializer.getOptionalNavLocation(iDeserializer);
            }
        }
        return navLocationArray;
    }
}

