/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details.formatters;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.memory.INavigationContactAddress;
import de.vw.mib.asl.internal.speechnavigation.usecase.application.ApplicationVariant;
import de.vw.mib.asl.internal.speechnavigation.usecase.application.ApplicationVariantImpl;
import de.vw.mib.asl.internal.speechnavigation.usecase.destinationinput.jpn.DestinationInputJpnFormatter;
import de.vw.mib.asl.internal.speechnavigation.usecase.guidance.destination.details.formatters.AddressFormatter;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.FixFormatterFieldDataImpl;
import de.vw.mib.util.StringBuilder;

public class AddressFormatterImpl
implements AddressFormatter {
    private final ApplicationVariant variantService;

    public AddressFormatterImpl(ApplicationVariant applicationVariant) {
        this.variantService = applicationVariant;
    }

    public AddressFormatterImpl() {
        this.variantService = new ApplicationVariantImpl();
    }

    @Override
    public String toShortAddressString(INavigationLocation iNavigationLocation) {
        String[] stringArray;
        String string = "";
        if (this.variantService.isEUVariant()) {
            string = AddressFormatterImpl.isValid(iNavigationLocation.getHousenumber()) ? this.formatAddress(iNavigationLocation, "<city>, <street> <hn>") : this.formatAddress(iNavigationLocation, "<city>, <street> & <crossing>");
        } else if (this.variantService.isNARVariant()) {
            string = AddressFormatterImpl.isValid(iNavigationLocation.getHousenumber()) ? this.formatAddress(iNavigationLocation, "<hn> <street>, <city>") : (AddressFormatterImpl.isValid(iNavigationLocation.getJunction()) ? this.formatAddress(iNavigationLocation, "<street> & <crossing>, <city>") : this.formatAddress(iNavigationLocation, "<street>, <city>"));
        } else if (this.variantService.isCHNVariant()) {
            string = AddressFormatterImpl.isValid(iNavigationLocation.getHousenumber()) ? this.formatAddress(iNavigationLocation, "<district>/<city> <street> <hn>") : this.formatAddress(iNavigationLocation, "<district>/<city> <street> & <crossing>");
        } else if (this.variantService.isTWNVariant()) {
            string = AddressFormatterImpl.isValid(iNavigationLocation.getHousenumber()) ? this.formatAddress(iNavigationLocation, "<area> <street> <hn>") : this.formatAddress(iNavigationLocation, "<area> <street> & <crossing>");
        } else if (this.variantService.isJPNVariant()) {
            stringArray = DestinationInputJpnFormatter.getCompleteMunicipality(iNavigationLocation);
            String string2 = iNavigationLocation.getPlace();
            String string3 = iNavigationLocation.getChome();
            String string4 = iNavigationLocation.getHousenumber();
            string = AddressFormatterImpl.isValid((String)stringArray) ? (AddressFormatterImpl.isValid(string2) ? (AddressFormatterImpl.isValid(string3) ? (AddressFormatterImpl.isValid(string4) ? this.formatAddress(iNavigationLocation, "<prefecture> <municipality> <place> <chome> <hn>") : this.formatAddress(iNavigationLocation, "<prefecture> <municipality> <place> <chome>")) : (AddressFormatterImpl.isValid(string4) ? this.formatAddress(iNavigationLocation, "<prefecture> <municipality> <place> <hn>") : this.formatAddress(iNavigationLocation, "<prefecture> <municipality> <place>"))) : (AddressFormatterImpl.isValid(string3) ? (AddressFormatterImpl.isValid(string4) ? this.formatAddress(iNavigationLocation, "<prefecture> <municipality> <chome> <hn>") : this.formatAddress(iNavigationLocation, "<prefecture> <municipality> <chome>")) : (AddressFormatterImpl.isValid(string4) ? this.formatAddress(iNavigationLocation, "<prefecture> <municipality> <hn>") : this.formatAddress(iNavigationLocation, "<prefecture> <municipality>")))) : (AddressFormatterImpl.isValid(string2) ? (AddressFormatterImpl.isValid(string3) ? (AddressFormatterImpl.isValid(string4) ? this.formatAddress(iNavigationLocation, "<prefecture> <place> <chome> <hn>") : this.formatAddress(iNavigationLocation, "<prefecture> <place> <chome>")) : (AddressFormatterImpl.isValid(string4) ? this.formatAddress(iNavigationLocation, "<prefecture> <place> <hn>") : this.formatAddress(iNavigationLocation, "<prefecture> <place>"))) : (AddressFormatterImpl.isValid(string3) ? (AddressFormatterImpl.isValid(string4) ? this.formatAddress(iNavigationLocation, "<prefecture> <chome> <hn>") : this.formatAddress(iNavigationLocation, "<prefecture> <chome>")) : (AddressFormatterImpl.isValid(string4) ? this.formatAddress(iNavigationLocation, "<prefecture> <hn>") : this.formatAddress(iNavigationLocation, "<prefecture>"))));
        }
        string = this.validateString(string, "&");
        string = this.validateString(string, "/");
        string = this.validateString(string, ",");
        if (string.length() == 0 && !this.variantService.isTWNVariant() && !this.variantService.isCHNVariant()) {
            stringArray = this.getCoordinates(iNavigationLocation.getLatitude(), iNavigationLocation.getLongitude());
            return new StringBuffer().append(stringArray[0]).append(", ").append(stringArray[1]).toString();
        }
        return string;
    }

    @Override
    public String[] toLongAddressString(INavigationLocation iNavigationLocation) {
        String[] stringArray;
        String string = "";
        String string2 = "";
        if (this.variantService.isEUVariant()) {
            string = AddressFormatterImpl.isValid(iNavigationLocation.getHousenumber()) ? this.formatAddress(iNavigationLocation, "<street> <hn>") : this.formatAddress(iNavigationLocation, "<street> & <crossing>");
            String string3 = string2 = AddressFormatterImpl.isValid(iNavigationLocation.getDistrict()) ? this.formatAddress(iNavigationLocation, "<zip> <city>-<district>") : this.formatAddress(iNavigationLocation, "<zip> <city>");
            if (!AddressFormatterImpl.isValid(iNavigationLocation.getHousenumber()) && !AddressFormatterImpl.isValid(iNavigationLocation.getStreet())) {
                string = string2;
                string2 = "";
            }
        } else if (this.variantService.isNARVariant()) {
            string = AddressFormatterImpl.isValid(iNavigationLocation.getHousenumber()) ? this.formatAddress(iNavigationLocation, "<hn> <street>") : this.formatAddress(iNavigationLocation, "<street> & <crossing>");
            string2 = AddressFormatterImpl.isValid(iNavigationLocation.getState()) ? this.formatAddress(iNavigationLocation, "<city>, <state> <zip>") : this.formatAddress(iNavigationLocation, "<city>, <zip>");
        } else if (this.variantService.isCHNVariant()) {
            string = this.formatAddress(iNavigationLocation, "<district>/<city>");
            string2 = AddressFormatterImpl.isValid(iNavigationLocation.getHousenumber()) ? this.formatAddress(iNavigationLocation, "<street> <hn>") : this.formatAddress(iNavigationLocation, "<street> & <crossing>");
        } else if (this.variantService.isTWNVariant()) {
            string = this.formatAddress(iNavigationLocation, "<area>");
            string2 = AddressFormatterImpl.isValid(iNavigationLocation.getHousenumber()) ? this.formatAddress(iNavigationLocation, "<street> <hn>") : this.formatAddress(iNavigationLocation, "<street> & <crossing>");
        } else if (this.variantService.isJPNVariant()) {
            stringArray = DestinationInputJpnFormatter.getCompleteMunicipality(iNavigationLocation);
            String string4 = iNavigationLocation.getPlace();
            String string5 = iNavigationLocation.getChome();
            String string6 = iNavigationLocation.getHousenumber();
            string = AddressFormatterImpl.isValid((String)stringArray) ? this.formatAddress(iNavigationLocation, "<prefecture> <municipality>") : this.formatAddress(iNavigationLocation, "<prefecture>");
            string2 = AddressFormatterImpl.isValid(string4) ? (AddressFormatterImpl.isValid(string5) ? (AddressFormatterImpl.isValid(string6) ? this.formatAddress(iNavigationLocation, "<place> <chome> <hn>") : this.formatAddress(iNavigationLocation, "<place> <chome>")) : (AddressFormatterImpl.isValid(string6) ? this.formatAddress(iNavigationLocation, "<place> <hn>") : this.formatAddress(iNavigationLocation, "<place>"))) : (AddressFormatterImpl.isValid(string5) ? (AddressFormatterImpl.isValid(string6) ? this.formatAddress(iNavigationLocation, "<chome> <hn>") : this.formatAddress(iNavigationLocation, "<chome>")) : (AddressFormatterImpl.isValid(string6) ? this.formatAddress(iNavigationLocation, "<hn>") : ""));
        }
        string = this.validateString(string, "/");
        string2 = this.validateString(string2, "/");
        string = this.validateString(string, "&");
        string2 = this.validateString(string2, "&");
        string2 = this.validateString(string2, "-");
        string2 = this.validateString(string2, ",");
        if (string.length() == 0 && string2.length() == 0 && !this.variantService.isTWNVariant() && !this.variantService.isCHNVariant()) {
            stringArray = this.getCoordinates(iNavigationLocation.getLatitude(), iNavigationLocation.getLongitude());
            return stringArray;
        }
        return new String[]{string, string2};
    }

    private String validateString(String string, String string2) {
        if (string.startsWith(string2)) {
            string = string.substring(1, string.length());
        }
        if (string.endsWith(string2)) {
            string = string.substring(0, string.length() - 1);
        }
        return string.trim();
    }

    @Override
    public String toShortAddressString(INavigationContactAddress iNavigationContactAddress) {
        return this.toLongAddressString(iNavigationContactAddress);
    }

    @Override
    public String toLongAddressString(INavigationContactAddress iNavigationContactAddress) {
        StringBuilder stringBuilder = new StringBuilder();
        if (AddressFormatterImpl.isValid(iNavigationContactAddress.getStreet())) {
            stringBuilder.append(iNavigationContactAddress.getStreet().trim()).append(" ");
        }
        if (AddressFormatterImpl.isValid(iNavigationContactAddress.getLocality())) {
            stringBuilder.append(iNavigationContactAddress.getLocality().trim()).append(" ");
        }
        if (AddressFormatterImpl.isValid(iNavigationContactAddress.getCountry())) {
            stringBuilder.append(iNavigationContactAddress.getCountry().trim()).append(" ");
        }
        if (AddressFormatterImpl.isValid(iNavigationContactAddress.getRegion())) {
            stringBuilder.append(iNavigationContactAddress.getRegion().trim()).append(" ");
        }
        if (AddressFormatterImpl.isValid(iNavigationContactAddress.getPostalCode())) {
            stringBuilder.append(iNavigationContactAddress.getPostalCode().trim());
        }
        return stringBuilder.toString().trim();
    }

    @Override
    public FixFormatterFieldData toFixFormatter(INavigationLocation iNavigationLocation) {
        FixFormatterFieldDataImpl fixFormatterFieldDataImpl = new FixFormatterFieldDataImpl();
        fixFormatterFieldDataImpl.put("Country", AddressFormatterImpl.toString(iNavigationLocation.getCountry()));
        fixFormatterFieldDataImpl.put("State", AddressFormatterImpl.toString(iNavigationLocation.getState()));
        fixFormatterFieldDataImpl.put("City", AddressFormatterImpl.toString(iNavigationLocation.getTown()));
        fixFormatterFieldDataImpl.put("Street", AddressFormatterImpl.toString(iNavigationLocation.getStreet()));
        fixFormatterFieldDataImpl.put("HouseNumber", AddressFormatterImpl.toString(iNavigationLocation.getHousenumber()));
        fixFormatterFieldDataImpl.put("Crossing", AddressFormatterImpl.toString(iNavigationLocation.getJunction()));
        fixFormatterFieldDataImpl.put("ZipCode", AddressFormatterImpl.toString(iNavigationLocation.getZipCode()));
        fixFormatterFieldDataImpl.put("District", AddressFormatterImpl.toString(iNavigationLocation.getDistrict()));
        fixFormatterFieldDataImpl.put("Area", AddressFormatterImpl.toString(iNavigationLocation.getCity()));
        fixFormatterFieldDataImpl.put("TownShip", AddressFormatterImpl.toString(iNavigationLocation.getSubmunicipalTown()));
        return fixFormatterFieldDataImpl;
    }

    private String formatAddress(INavigationLocation iNavigationLocation, String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder = this.trySetValue("<country>", AddressFormatterImpl.toString(iNavigationLocation.getCountry()), string, stringBuilder);
        stringBuilder = this.trySetValue("<state>", AddressFormatterImpl.toString(iNavigationLocation.getState()), string, stringBuilder);
        stringBuilder = this.trySetValue("<city>", AddressFormatterImpl.toString(iNavigationLocation.getTown()), string, stringBuilder);
        stringBuilder = this.trySetValue("<street>", AddressFormatterImpl.toString(iNavigationLocation.getStreet()), string, stringBuilder);
        stringBuilder = this.trySetValue("<hn>", AddressFormatterImpl.toString(iNavigationLocation.getHousenumber()), string, stringBuilder);
        stringBuilder = this.trySetValue("<crossing>", AddressFormatterImpl.toString(iNavigationLocation.getJunction()), string, stringBuilder);
        stringBuilder = this.trySetValue("<zip>", AddressFormatterImpl.toString(iNavigationLocation.getZipCode()), string, stringBuilder);
        stringBuilder = this.trySetValue("<district>", AddressFormatterImpl.toString(iNavigationLocation.getDistrict()), string, stringBuilder);
        stringBuilder = this.trySetValue("<area>", AddressFormatterImpl.toString(iNavigationLocation.getCity()), string, stringBuilder);
        stringBuilder = this.trySetValue("<township>", AddressFormatterImpl.toString(iNavigationLocation.getSubmunicipalTown()), string, stringBuilder);
        stringBuilder = this.trySetValue("<prefecture>", AddressFormatterImpl.toString(iNavigationLocation.getPrefecture()), string, stringBuilder);
        stringBuilder = this.trySetValue("<municipality>", AddressFormatterImpl.toString(DestinationInputJpnFormatter.getCompleteMunicipality(iNavigationLocation)), string, stringBuilder);
        stringBuilder = this.trySetValue("<place>", AddressFormatterImpl.toString(iNavigationLocation.getPlace()), string, stringBuilder);
        stringBuilder = this.trySetValue("<chome>", AddressFormatterImpl.toString(iNavigationLocation.getChome()), string, stringBuilder);
        return stringBuilder.toString().trim();
    }

    private StringBuilder trySetValue(String string, String string2, String string3, StringBuilder stringBuilder) {
        if (string3.indexOf(string) != -1) {
            int n = stringBuilder.indexOf(string);
            stringBuilder = stringBuilder.replace(n, n + string.length(), string2);
        }
        return stringBuilder;
    }

    private static String toString(String string) {
        return AddressFormatterImpl.isValid(string) ? string : "";
    }

    private static boolean isValid(String string) {
        return string != null && string.length() > 0;
    }

    private String[] getCoordinates(double d2, double d3) {
        String string = new StringBuffer().append(this.decimalToDMS(d2)).append(d2 >= 0.0 ? "N" : "S").toString();
        String string2 = new StringBuffer().append(this.decimalToDMS(d3)).append(d3 >= 0.0 ? "E" : "W").toString();
        return new String[]{string, string2};
    }

    private String decimalToDMS(double d2) {
        String string = null;
        d2 = Math.abs(d2);
        double d3 = Math.floor(d2);
        d2 = (d2 - d3) * 60.0;
        double d4 = Math.floor(d2);
        double d5 = (d2 - d4) * 60.0;
        string = new StringBuffer().append((int)d3).append("\u00b0").append((int)d4).append("'").append(this.formatDouble(d5)).append("\"").toString();
        return string;
    }

    private String formatDouble(double d2) {
        String string = Double.toString((double)d2);
        int n = string.indexOf(".");
        return string.substring(0, n + 2);
    }
}

