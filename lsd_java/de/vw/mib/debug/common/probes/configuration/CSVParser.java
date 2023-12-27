/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.common.probes.configuration;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

public final class CSVParser {
    public static String createIntCSV(Set set) {
        if (set == null || set.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(100);
        Iterator iterator = set.iterator();
        stringBuffer.append(iterator.next());
        while (iterator.hasNext()) {
            stringBuffer.append(", ").append(iterator.next());
        }
        return stringBuffer.toString();
    }

    public static String createIntCSV(int[] nArray) {
        if (nArray == null || nArray.length == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append(nArray[0]);
        for (int i2 = 1; i2 < nArray.length; ++i2) {
            stringBuffer.append(", ").append(nArray[i2]);
        }
        return stringBuffer.toString();
    }

    public static Set parseIntCSV(String string) {
        HashSet hashSet = new HashSet();
        if (string == null) {
            return hashSet;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
        if (stringTokenizer != null && stringTokenizer.countTokens() > 0) {
            int n = stringTokenizer.countTokens();
            for (int i2 = 0; i2 < n; ++i2) {
                String string2 = stringTokenizer.nextToken().trim();
                hashSet.add(new Integer(Integer.parseInt(string2)));
            }
        }
        return hashSet;
    }

    public static int[] parseToArrayIDs(Properties properties, String string) {
        if (properties == null || properties.isEmpty()) {
            return null;
        }
        Set set = CSVParser.parseToIntSetIDs(properties, string);
        int[] nArray = new int[set.size()];
        Iterator iterator = set.iterator();
        for (int i2 = 0; iterator.hasNext() && i2 < nArray.length; ++i2) {
            Integer n = (Integer)iterator.next();
            nArray[i2] = n;
        }
        return nArray;
    }

    public static Set parseToIntSetIDs(Properties properties, String string) {
        StringTokenizer stringTokenizer;
        if (properties == null || properties.isEmpty()) {
            return null;
        }
        HashSet hashSet = new HashSet();
        String string2 = properties.getProperty(string);
        if (string2 != null && (stringTokenizer = new StringTokenizer(string2 = string2.replace(';', ','), ",")) != null && stringTokenizer.countTokens() > 0) {
            int n = stringTokenizer.countTokens();
            for (int i2 = 0; i2 < n; ++i2) {
                StringTokenizer stringTokenizer2;
                String string3 = stringTokenizer.nextToken().trim();
                if (string3.indexOf("-") > -1) {
                    int n2;
                    stringTokenizer2 = new StringTokenizer(string3, "-");
                    if (stringTokenizer2 == null || stringTokenizer2.countTokens() != 2) continue;
                    int n3 = Integer.parseInt(stringTokenizer2.nextToken().trim());
                    if (n2 <= 0 || n3 <= n2) continue;
                    for (n2 = Integer.parseInt(stringTokenizer2.nextToken().trim()); n2 <= n3; ++n2) {
                        hashSet.add(new Integer(n2));
                    }
                    continue;
                }
                if (string3.indexOf("+") > -1) {
                    stringTokenizer2 = new StringTokenizer(string3, "+");
                    if (stringTokenizer2 == null || stringTokenizer2.countTokens() != 2) continue;
                    Integer n4 = new Integer(Integer.parseInt(stringTokenizer2.nextToken().trim()));
                    Integer n5 = new Integer(Integer.parseInt(stringTokenizer2.nextToken().trim()));
                    hashSet.add(n4);
                    hashSet.add(n5);
                    continue;
                }
                hashSet.add(new Integer(Integer.parseInt(string3)));
            }
        }
        return hashSet;
    }

    private CSVParser() {
    }

    public static Set parseToHashSetStrings(Properties properties, String string) {
        StringTokenizer stringTokenizer;
        if (properties == null || properties.isEmpty()) {
            return null;
        }
        HashSet hashSet = new HashSet();
        String string2 = properties.getProperty(string);
        if (string2 != null && (stringTokenizer = new StringTokenizer(string2 = string2.replace(';', ','), ",")) != null && stringTokenizer.countTokens() > 0) {
            int n = stringTokenizer.countTokens();
            for (int i2 = 0; i2 < n; ++i2) {
                String string3 = stringTokenizer.nextToken().trim();
                hashSet.add(string3);
            }
        }
        return hashSet;
    }

    public static String createStringCSV(Set set) {
        if (set == null || set.isEmpty()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(100);
        Iterator iterator = set.iterator();
        stringBuffer.append(iterator.next());
        while (iterator.hasNext()) {
            stringBuffer.append(", ").append(iterator.next());
        }
        return stringBuffer.toString();
    }
}

