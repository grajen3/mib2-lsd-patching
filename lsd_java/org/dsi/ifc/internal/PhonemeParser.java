/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.internal;

import org.dsi.ifc.internal.LocationHelper;
import org.dsi.ifc.navigation.PhonemeData;

public class PhonemeParser {
    private LocationHelper m_Helper = null;
    private static String DatabaseProvider = "x-NAVTEQ-sampa";

    public PhonemeParser(LocationHelper locationHelper) {
        this.m_Helper = locationHelper;
    }

    public PhonemeData getCountryPhoneme() {
        return this.getExonymPhoneme(2050, 2049);
    }

    public PhonemeData getStatePhoneme() {
        return this.getAlternativePhoneme(2046, 2045);
    }

    public PhonemeData getCityPhoneme() {
        return this.getExonymPhoneme(2040, 2039);
    }

    public PhonemeData getStreetPhoneme() {
        return this.getAlternativePhoneme(2044, 2043);
    }

    public PhonemeData getJunctionPhoneme() {
        return this.getAlternativePhoneme(2048, 2047);
    }

    public PhonemeData getSuburbPhoneme() {
        return this.getExonymPhoneme(2042, 2041);
    }

    public PhonemeData getPOIPhoneme() {
        String string = this.getPhonemeStream(2068);
        PhonemeData phonemeData = PhonemeParser.parsePhonemeStream(string);
        return phonemeData;
    }

    private PhonemeData getExonymPhoneme(int n, int n2) {
        String string = this.getPhonemeStream(n);
        String string2 = this.getPhonemeStream(n2);
        PhonemeData phonemeData = null;
        PhonemeData phonemeData2 = null;
        if (string.length() > 0) {
            phonemeData = PhonemeParser.parsePhonemeStream(string);
        }
        phonemeData2 = PhonemeParser.parsePhonemeStream(string2);
        if (null != phonemeData) {
            String[] stringArray = new String[]{phonemeData.phoneme, phonemeData2.phoneme};
            phonemeData2.phoneme = PhonemeParser.mergePhonemeData(stringArray);
        }
        return phonemeData2;
    }

    private PhonemeData getAlternativePhoneme(int n, int n2) {
        String string = this.getPhonemeStream(n);
        String string2 = this.getPhonemeStream(n2);
        PhonemeData phonemeData = null;
        phonemeData = string.length() > 0 ? PhonemeParser.parsePhonemeStream(string) : PhonemeParser.parsePhonemeStream(string2);
        return phonemeData;
    }

    private static String mergePhonemeData(String[] stringArray) {
        String string = new String();
        if (null != stringArray) {
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                if (null == stringArray[i2]) continue;
                if (i2 > 0) {
                    string = new StringBuffer().append(string).append(" ").toString();
                }
                string = new StringBuffer().append(string).append(stringArray[i2]).toString();
            }
        }
        return string;
    }

    private String getPhonemeStream(int n) {
        return this.m_Helper.getDataForInternalType(n);
    }

    private static PhonemeData parsePhonemeStream(String string) {
        int n;
        PhonemeData phonemeData = new PhonemeData();
        if (string.length() > 0 && (n = string.indexOf(")")) > 1) {
            phonemeData.phoneme = string.substring(n + 1);
            String string2 = string.substring(1, n);
            phonemeData.alphabet = new StringBuffer().append(DatabaseProvider).append("_").append(string2).toString();
        }
        return phonemeData;
    }
}

