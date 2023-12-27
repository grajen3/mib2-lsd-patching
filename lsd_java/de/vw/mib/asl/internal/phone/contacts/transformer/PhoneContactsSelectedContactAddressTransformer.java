/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.asl.internal.phone.contacts.transformer;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.phone.util.PhoneUtil;
import de.vw.mib.properties.values.FixFormatterFieldData;
import de.vw.mib.properties.values.FixFormatterFieldDataImpl;
import de.vw.mib.util.Util;
import generated.de.vw.mib.asl.internal.phone.contacts.transformer.AbstractPhoneContactsSelectedContactAddressTransformer;
import org.dsi.ifc.organizer.AddressData;

public class PhoneContactsSelectedContactAddressTransformer
extends AbstractPhoneContactsSelectedContactAddressTransformer {
    @Override
    public String getString(int n, Object object) {
        AddressData addressData = (AddressData)object;
        switch (n) {
            case 0: {
                return PhoneUtil.replaceNullByEmptyString(addressData.getLocality());
            }
            case 1: {
                return PhoneUtil.replaceNullByEmptyString(addressData.getCountry());
            }
            case 2: {
                return PhoneUtil.replaceNullByEmptyString(addressData.getGeoPosition());
            }
            case 3: {
                return PhoneUtil.replaceNullByEmptyString(addressData.getRegion());
            }
            case 4: {
                return PhoneUtil.replaceNullByEmptyString(addressData.getStreet());
            }
            case 5: {
                return PhoneUtil.replaceNullByEmptyString(addressData.getPostalCode());
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }

    private static void put(FixFormatterFieldDataImpl fixFormatterFieldDataImpl, String string, String string2) {
        if (string2 != null && string2.length() > 0) {
            fixFormatterFieldDataImpl.put(string, string2);
        }
    }

    private static double[] parseGeoPosition(String string) {
        int n;
        String string2 = string.trim();
        int n2 = string2.indexOf(58);
        if (n2 != -1) {
            string2 = string2.substring(n2 + 1);
        }
        if ((n = string2.indexOf(";")) == -1) {
            n = string2.indexOf(",");
        }
        double[] dArray = new double[2];
        String string3 = string2.substring(0, n).trim();
        double d2 = 0.0;
        try {
            d2 = Double.valueOf((String)string3);
        }
        catch (NumberFormatException numberFormatException) {
            ServiceManager.logger.trace(4).append(numberFormatException.toString());
        }
        String string4 = string2.substring(n + 1).trim();
        double d3 = 0.0;
        try {
            d3 = Double.valueOf((String)string4);
        }
        catch (NumberFormatException numberFormatException) {
            ServiceManager.logger.trace(4).append(numberFormatException.toString());
        }
        if (Math.abs(d2) > 90.0 || Math.abs(d3) > 180.0) {
            d2 /= 1000000.0;
            d3 /= 1000000.0;
        }
        dArray[0] = d2;
        dArray[1] = d3;
        return dArray;
    }

    private static double[] decimalToDegMinSec(double d2) {
        double d3 = d2;
        boolean bl = false;
        if (d3 < 0.0) {
            bl = true;
            d3 = -d3;
        }
        int n = (int)d3;
        d3 -= (double)n;
        int n2 = (int)(d3 *= 60.0);
        d3 -= (double)n2;
        double d4 = d3 *= 60.0;
        if (!(d4 >= 0.0) || !(d4 < 60.0)) {
            throw new RuntimeException();
        }
        if (bl) {
            n = -n;
            n2 = -n2;
            d4 = -d4;
        }
        return new double[]{n, n2, d4};
    }

    private static FixFormatterFieldData prepareFixFormatterFieldData(AddressData addressData) {
        FixFormatterFieldDataImpl fixFormatterFieldDataImpl = new FixFormatterFieldDataImpl();
        PhoneContactsSelectedContactAddressTransformer.put(fixFormatterFieldDataImpl, "Country", addressData.getCountry());
        PhoneContactsSelectedContactAddressTransformer.put(fixFormatterFieldDataImpl, "State", addressData.getRegion());
        PhoneContactsSelectedContactAddressTransformer.put(fixFormatterFieldDataImpl, "City", addressData.getLocality());
        PhoneContactsSelectedContactAddressTransformer.put(fixFormatterFieldDataImpl, "PostalCode", addressData.getPostalCode());
        PhoneContactsSelectedContactAddressTransformer.put(fixFormatterFieldDataImpl, "Street", addressData.getStreet());
        if (!Util.isNullOrEmpty(addressData.getGeoPosition())) {
            double[] dArray = PhoneContactsSelectedContactAddressTransformer.parseGeoPosition(addressData.getGeoPosition());
            fixFormatterFieldDataImpl.put("LatitudeDegrees", (long)PhoneContactsSelectedContactAddressTransformer.decimalToDegMinSec(dArray[0])[0]);
            fixFormatterFieldDataImpl.put("LatitudeMinutes", (long)PhoneContactsSelectedContactAddressTransformer.decimalToDegMinSec(dArray[0])[1]);
            fixFormatterFieldDataImpl.put("LatitudeSeconds", (long)PhoneContactsSelectedContactAddressTransformer.decimalToDegMinSec(dArray[0])[2]);
            fixFormatterFieldDataImpl.put("LongitudeDegrees", (long)PhoneContactsSelectedContactAddressTransformer.decimalToDegMinSec(dArray[1])[0]);
            fixFormatterFieldDataImpl.put("LongitudeMinutes", (long)PhoneContactsSelectedContactAddressTransformer.decimalToDegMinSec(dArray[1])[1]);
            fixFormatterFieldDataImpl.put("LongitudeSeconds", (long)PhoneContactsSelectedContactAddressTransformer.decimalToDegMinSec(dArray[1])[2]);
        } else {
            fixFormatterFieldDataImpl.put("LatitudeDegrees", 0);
            fixFormatterFieldDataImpl.put("LatitudeMinutes", 0);
            fixFormatterFieldDataImpl.put("LatitudeSeconds", 0);
            fixFormatterFieldDataImpl.put("LongitudeDegrees", 0);
            fixFormatterFieldDataImpl.put("LongitudeMinutes", 0);
            fixFormatterFieldDataImpl.put("LongitudeSeconds", 0);
        }
        return fixFormatterFieldDataImpl;
    }

    @Override
    public FixFormatterFieldData getFixFormatterFieldData(int n, Object object) {
        AddressData addressData = (AddressData)object;
        switch (n) {
            case 7: {
                return PhoneContactsSelectedContactAddressTransformer.prepareFixFormatterFieldData(addressData);
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("column: ").append(n).toString());
    }
}

