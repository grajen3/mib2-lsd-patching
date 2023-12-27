/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.lsctng;

public interface LscData {
    public static final String NOT_INTERESTED_IN_LANGUAGE_UPDATES;
    public static final String NO_LANGUAGE;
    public static final String INTERESTED_IN_LOCALIZED_LANGUAGES;
    public static final int NOT_INTERESTED_IN_SKIN_UPDATES;
    public static final int NO_SKIN;
    public static final int SKINID_1;
    public static final int SKINID_2;
    public static final int SKINID_3;
    public static final int NOT_INTERESTED_IN_SKINMODE_UPDATES;
    public static final int NO_SKINMODE;
    public static final int SKINMODE_DAY;
    public static final int SKINMODE_NIGHT;
    public static final int NOT_INTERESTED_IN_PROMPTMODE_UPDATES;
    public static final int NO_PROMPTMODE;
    public static final int PROMPTMODE_NOVICE;
    public static final int PROMPTMODE_EXPERT;
    public static final int NOT_INTERESTED_IN_VOICETYPE_UPDATES;
    public static final int NO_VOICETYPE;
    public static final int VOICETYPE_MALE;
    public static final int VOICETYPE_FEMALE;
    public static final int VOICETYPE_VADER;

    static {
        INTERESTED_IN_LOCALIZED_LANGUAGES = new String("NO_LANGUAGE").intern();
    }
}

