/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller;

import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.speller.LCID;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public final class LCIDs {
    private static final String LCID_FILENAME;
    private static final String LCID_DELIMITER;
    private static final List LCIDS;
    static /* synthetic */ Class class$de$vw$mib$widgets$speller$LCIDs;

    public static String convertIsoToLcid(String string) {
        Iterator iterator = LCIDs.iterator();
        while (iterator.hasNext()) {
            LCID lCID = (LCID)iterator.next();
            if (string == null || !string.equalsIgnoreCase(lCID.getISO())) continue;
            return lCID.getLCID();
        }
        throw new IllegalArgumentException(new StringBuffer().append("Unknown ISO language code passed! [iso='").append(string).append("']").toString());
    }

    public static String convertLcidToIso(String string) {
        Iterator iterator = LCIDs.iterator();
        while (iterator.hasNext()) {
            LCID lCID = (LCID)iterator.next();
            if (string == null || !string.equalsIgnoreCase(lCID.getLCID())) continue;
            return lCID.getISO();
        }
        throw new IllegalArgumentException(new StringBuffer().append("Unknown locale id passed! [lcid='").append(string).append("']").toString());
    }

    public static String[] getAllLanguages() {
        ArrayList arrayList = new ArrayList(LCIDs.size());
        Iterator iterator = LCIDs.iterator();
        while (iterator.hasNext()) {
            LCID lCID = (LCID)iterator.next();
            arrayList.add(lCID.getName());
        }
        return (String[])arrayList.toArray(new String[LCIDs.size()]);
    }

    public static String[] getAllLCIDs() {
        ArrayList arrayList = new ArrayList(LCIDs.size());
        Iterator iterator = LCIDs.iterator();
        while (iterator.hasNext()) {
            LCID lCID = (LCID)iterator.next();
            arrayList.add(lCID.getLCID());
        }
        return (String[])arrayList.toArray(new String[LCIDs.size()]);
    }

    public static String[] getAllISOs() {
        ArrayList arrayList = new ArrayList(LCIDs.size());
        Iterator iterator = LCIDs.iterator();
        while (iterator.hasNext()) {
            LCID lCID = (LCID)iterator.next();
            arrayList.add(lCID.getISO());
        }
        return (String[])arrayList.toArray(new String[LCIDs.size()]);
    }

    public static String getIsoByLanguage(String string) {
        Iterator iterator = LCIDs.iterator();
        while (iterator.hasNext()) {
            LCID lCID = (LCID)iterator.next();
            if (string == null || !string.equalsIgnoreCase(lCID.getName())) continue;
            return lCID.getISO();
        }
        throw new IllegalArgumentException(new StringBuffer().append("Unknown language passed! [language='").append(string).append("']").toString());
    }

    public static String getLanguageByIso(String string) {
        Iterator iterator = LCIDs.iterator();
        while (iterator.hasNext()) {
            LCID lCID = (LCID)iterator.next();
            if (string == null || !string.equalsIgnoreCase(lCID.getISO())) continue;
            return lCID.getName();
        }
        throw new IllegalArgumentException(new StringBuffer().append("Unknown ISO language code passed! [iso='").append(string).append("']").toString());
    }

    public static String getLanguageByLcid(String string) {
        Iterator iterator = LCIDs.iterator();
        while (iterator.hasNext()) {
            LCID lCID = (LCID)iterator.next();
            if (string == null || !string.equalsIgnoreCase(lCID.getLCID())) continue;
            return lCID.getName();
        }
        throw new IllegalArgumentException(new StringBuffer().append("Unknown locale id passed! [lcid='").append(string).append("']").toString());
    }

    public static String getLcidByLanguage(String string) {
        Iterator iterator = LCIDs.iterator();
        while (iterator.hasNext()) {
            LCID lCID = (LCID)iterator.next();
            if (string == null || !string.equalsIgnoreCase(lCID.getName())) continue;
            return lCID.getLCID();
        }
        throw new IllegalArgumentException(new StringBuffer().append("Unknown language passed! [language='").append(string).append("']").toString());
    }

    public static Iterator iterator() {
        return LCIDS.iterator();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void readLCIDs(String string) {
        Object object;
        InputStream inputStream = (class$de$vw$mib$widgets$speller$LCIDs == null ? (class$de$vw$mib$widgets$speller$LCIDs = LCIDs.class$("de.vw.mib.widgets.speller.LCIDs")) : class$de$vw$mib$widgets$speller$LCIDs).getResourceAsStream(string);
        if (inputStream == null) {
            throw new IllegalArgumentException(new StringBuffer().append("Unknown locale id file name passed! [fileName='").append(string).append("']").toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            int n;
            while ((n = inputStream.available()) != 0) {
                object = new byte[n];
                int n2 = inputStream.read((byte[])object);
                if (n2 <= 0) continue;
                stringBuilder.append(new String((byte[])object));
            }
        }
        catch (IOException iOException) {
        }
        finally {
            try {
                inputStream.close();
            }
            catch (IOException iOException) {}
        }
        StringTokenizer stringTokenizer = new StringTokenizer(stringBuilder.toString(), ";\r\n");
        while (stringTokenizer.hasMoreTokens()) {
            object = stringTokenizer.nextToken();
            String string2 = stringTokenizer.nextToken();
            String string3 = stringTokenizer.nextToken();
            LCIDS.add(new LCID((String)object, string2, string3));
        }
    }

    public static int size() {
        return LCIDS.size();
    }

    private LCIDs() {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        LCIDS = new LinkedList();
        LCIDs.readLCIDs("lcid.csv");
    }
}

