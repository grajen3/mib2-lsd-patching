/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.radiodata;

public class CountryRegionData {
    public int crId;
    public int macroRegionId;
    public String ioc;
    public int countryId;
    public String countryNameInternational;
    public String countryNameOriginal;
    public String iocCountryNameInternational;
    public int countryEcc;
    public int countryPi;
    public int[] countryNeighborPi = null;
    public String gpsMode;
    public String[] gpsp = null;
    public int flagId;
    public int amSupport;
    public int fmSupport;
    public int dabSupport;
    public int speechSupport;
    public int nurGenehmigteLogos;
    public int requestStrategy;
    public int useDatabaseNameInHmi;
    public String nativeLanguage;
    public String[] extraString = null;
    public int[] extraInt = null;

    public CountryRegionData() {
        this.crId = -1;
        this.macroRegionId = -1;
        this.ioc = "";
        this.countryId = -1;
        this.countryNameInternational = "";
        this.countryNameOriginal = "";
        this.iocCountryNameInternational = "";
        this.countryEcc = -1;
        this.countryPi = -1;
        this.countryNeighborPi = new int[16];
        this.gpsMode = "";
        this.gpsp = new String[4];
        this.flagId = -1;
        this.amSupport = -1;
        this.fmSupport = -1;
        this.dabSupport = -1;
        this.speechSupport = -1;
        this.nurGenehmigteLogos = -1;
        this.requestStrategy = -1;
        this.useDatabaseNameInHmi = -1;
        this.nativeLanguage = "";
        this.extraString = new String[5];
        this.extraInt = new int[5];
    }

    public CountryRegionData(int n, int n2, String string, int n3, String string2, String string3, String string4, int n4, int n5, int[] nArray, String string5, String[] stringArray, int n6, int n7, int n8, int n9, int n10, int n11, int n12, int n13, String string6, String[] stringArray2, int[] nArray2) {
        this.crId = n;
        this.macroRegionId = n2;
        this.ioc = string;
        this.countryId = n3;
        this.countryNameInternational = string2;
        this.countryNameOriginal = string3;
        this.iocCountryNameInternational = string4;
        this.countryEcc = n4;
        this.countryPi = n5;
        this.countryNeighborPi = nArray;
        this.gpsMode = string5;
        this.gpsp = stringArray;
        this.flagId = n6;
        this.amSupport = n7;
        this.fmSupport = n8;
        this.dabSupport = n9;
        this.speechSupport = n10;
        this.nurGenehmigteLogos = n11;
        this.requestStrategy = n12;
        this.useDatabaseNameInHmi = n13;
        this.nativeLanguage = string6;
        this.extraString = stringArray2;
        this.extraInt = nArray2;
    }

    public int getCrId() {
        return this.crId;
    }

    public int getMacroRegionId() {
        return this.macroRegionId;
    }

    public String getIoc() {
        return this.ioc;
    }

    public int getCountryId() {
        return this.countryId;
    }

    public String getCountryNameInternational() {
        return this.countryNameInternational;
    }

    public String getCountryNameOriginal() {
        return this.countryNameOriginal;
    }

    public String getIocCountryNameInternational() {
        return this.iocCountryNameInternational;
    }

    public int getCountryEcc() {
        return this.countryEcc;
    }

    public int getCountryPi() {
        return this.countryPi;
    }

    public int[] getCountryNeighborPi() {
        return this.countryNeighborPi;
    }

    public String getGpsMode() {
        return this.gpsMode;
    }

    public String[] getGpsp() {
        return this.gpsp;
    }

    public int getFlagId() {
        return this.flagId;
    }

    public int getAmSupport() {
        return this.amSupport;
    }

    public int getFmSupport() {
        return this.fmSupport;
    }

    public int getDabSupport() {
        return this.dabSupport;
    }

    public int getSpeechSupport() {
        return this.speechSupport;
    }

    public int getNurGenehmigteLogos() {
        return this.nurGenehmigteLogos;
    }

    public int getRequestStrategy() {
        return this.requestStrategy;
    }

    public int getUseDatabaseNameInHmi() {
        return this.useDatabaseNameInHmi;
    }

    public String getNativeLanguage() {
        return this.nativeLanguage;
    }

    public String[] getExtraString() {
        return this.extraString;
    }

    public int[] getExtraInt() {
        return this.extraInt;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(1500);
        stringBuffer.append("CountryRegionData");
        stringBuffer.append('(');
        stringBuffer.append("crId");
        stringBuffer.append('=');
        stringBuffer.append(this.crId);
        stringBuffer.append(',');
        stringBuffer.append("macroRegionId");
        stringBuffer.append('=');
        stringBuffer.append(this.macroRegionId);
        stringBuffer.append(',');
        stringBuffer.append("ioc");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.ioc);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("countryId");
        stringBuffer.append('=');
        stringBuffer.append(this.countryId);
        stringBuffer.append(',');
        stringBuffer.append("countryNameInternational");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.countryNameInternational);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("countryNameOriginal");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.countryNameOriginal);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("iocCountryNameInternational");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.iocCountryNameInternational);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("countryEcc");
        stringBuffer.append('=');
        stringBuffer.append(this.countryEcc);
        stringBuffer.append(',');
        stringBuffer.append("countryPi");
        stringBuffer.append('=');
        stringBuffer.append(this.countryPi);
        stringBuffer.append(',');
        stringBuffer.append("countryNeighborPi");
        stringBuffer.append('[');
        if (this.countryNeighborPi != null) {
            stringBuffer.append(this.countryNeighborPi.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.countryNeighborPi != null) {
            n3 = this.countryNeighborPi.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.countryNeighborPi[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.countryNeighborPi);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("gpsMode");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.gpsMode);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("gpsp");
        stringBuffer.append('[');
        if (this.gpsp != null) {
            stringBuffer.append(this.gpsp.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.gpsp != null) {
            n3 = this.gpsp.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.gpsp[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.gpsp);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("flagId");
        stringBuffer.append('=');
        stringBuffer.append(this.flagId);
        stringBuffer.append(',');
        stringBuffer.append("amSupport");
        stringBuffer.append('=');
        stringBuffer.append(this.amSupport);
        stringBuffer.append(',');
        stringBuffer.append("fmSupport");
        stringBuffer.append('=');
        stringBuffer.append(this.fmSupport);
        stringBuffer.append(',');
        stringBuffer.append("dabSupport");
        stringBuffer.append('=');
        stringBuffer.append(this.dabSupport);
        stringBuffer.append(',');
        stringBuffer.append("speechSupport");
        stringBuffer.append('=');
        stringBuffer.append(this.speechSupport);
        stringBuffer.append(',');
        stringBuffer.append("nurGenehmigteLogos");
        stringBuffer.append('=');
        stringBuffer.append(this.nurGenehmigteLogos);
        stringBuffer.append(',');
        stringBuffer.append("requestStrategy");
        stringBuffer.append('=');
        stringBuffer.append(this.requestStrategy);
        stringBuffer.append(',');
        stringBuffer.append("useDatabaseNameInHmi");
        stringBuffer.append('=');
        stringBuffer.append(this.useDatabaseNameInHmi);
        stringBuffer.append(',');
        stringBuffer.append("nativeLanguage");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.nativeLanguage);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("extraString");
        stringBuffer.append('[');
        if (this.extraString != null) {
            stringBuffer.append(this.extraString.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.extraString != null) {
            n3 = this.extraString.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.extraString[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.extraString);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("extraInt");
        stringBuffer.append('[');
        if (this.extraInt != null) {
            stringBuffer.append(this.extraInt.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.extraInt != null) {
            n3 = this.extraInt.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.extraInt[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.extraInt);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

