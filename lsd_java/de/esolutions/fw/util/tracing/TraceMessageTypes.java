/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing;

public class TraceMessageTypes {
    public static final short STRING_OLD;
    public static final short STRING_UTF8;
    public static final short PROBE;
    public static final short COMM;
    public static final short MLP;
    public static final short APP;
    public static final short CKCM;
    public static final short BT_HCI;
    public static final short TPEG;
    public static final short ANNOTATION;
    public static final short AISIN_NAVPOS;
    public static final short ESOPOSPROVIDER;
    public static final short FPK_PROFILE_CHANNEL;
    public static final short USER;
    public static final short VW;
    public static final short[] ALL_MESSAGE_TYPES;
    public static final String[] MESSAGE_TYPE_NAMES;

    public static String getName(short s) {
        switch (s) {
            case 0: {
                return "ESO_TXT_OLD";
            }
            case 1: {
                return "ESO_TXT";
            }
            case 2: {
                return "ESO_PROBE";
            }
            case 3: {
                return "ESO_COMM";
            }
            case 4: {
                return "MLP";
            }
            case 128: {
                return "APP_CKCM";
            }
            case 129: {
                return "APP_BT_HCI";
            }
            case 130: {
                return "TPEG";
            }
            case 131: {
                return "ANNOTATION";
            }
            case 132: {
                return "AISIN_NAVPOS";
            }
            case 133: {
                return "ESOPOSPROVIDER";
            }
            case 134: {
                return "FPK_PROFILE_CHANNEL";
            }
            case 22103: {
                return "VW";
            }
        }
        return null;
    }

    static {
        ALL_MESSAGE_TYPES = new short[]{0, 1, 2, 3, 4, 128, 129, 130, 131, 132, 133, 134, 22103};
        MESSAGE_TYPE_NAMES = new String[]{"STRING_OLD", "STRING_UTF8", "PROBE", "COMM", "MLP", "CKCM", "BT_HCI", "TPEG", "ANNOTATION", "AISIN_NAVPOS", "ESOPOSPROVIDER", "FPK_PROFILE_CHANNEL", "VW"};
    }
}

