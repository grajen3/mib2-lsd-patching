/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.common.probes.configuration;

public final class FilterFlags {
    public static final String[] FILTER_CLASSIFIERS = new String[]{"AUDIO", "BAP", "CAR", "DIAGNOSE", "GENERAL", "MEDIA", "NAVI", "ONLINE", "ORGANIZER_PHONE", "SPEECH", "SWDL_SWAP", "SYSTEM", "TUNER", "FILEBROWSER_PICTURE", "TV-TUNER", "HAS_EXLAP"};
    private static final String[] NO_OBJECT_NAMES = new String[0];
    private static final String[][] OBJECT_NAMES = new String[][]{{"audio", "waveplayer"}, {"bap"}, {"caraircondition", "carauxheatercooler", "carcomfort", "carfriverassistance", "cardrivercharacteristics", "careco", "carhybrid", "carkombi", "carlight", "carparkingsystem", "carseat", "carvehiclestates", "cartimeunitslanguage", "generalvehiclestates", "mobilityhorizon"}, {"diaghmiattribs", "diagnose", "infotainmentrecorder"}, {"global", "modelapi"}, {"albumbrowser", "media"}, {"iconhandling", "komonav", "map", "navigation", "navservicesapi", "tmc", "trafficregulation"}, {"browser", "networking", "online"}, {"bluetooth", "calendar", "messaging", "organizer", "telephone"}, {"phonetic", "speechrec", "tts"}, {"swdldeviceinfo", "swdllogging", "swdlprogress", "swdlselection", "swap"}, {"dighmiattribs", "displaymanagement", "keypanel", "persistence", "powermanagement", "startup", "system"}, {"radio", "sdars", "radiodata"}, {"filebrowser", "picturehandling", "picturestore"}, {"tvtuner"}, {"has", "exlap"}};

    public static String[] getFilterClassNamePrefixes(String string) {
        int n;
        for (n = FILTER_CLASSIFIERS.length - 1; n >= 0 && !FILTER_CLASSIFIERS[n].equalsIgnoreCase(string); --n) {
        }
        if (n < 0) {
            return NO_OBJECT_NAMES;
        }
        return OBJECT_NAMES[n];
    }
}

