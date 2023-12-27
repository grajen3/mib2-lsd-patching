/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence;

import de.vw.mib.asl.framework.api.persistence.PersistenceNamespace$1;
import de.vw.mib.asl.framework.api.persistence.PersistenceNsAmFm;
import de.vw.mib.asl.framework.api.persistence.PersistenceNsBAP;
import de.vw.mib.asl.framework.api.persistence.PersistenceNsCar;
import de.vw.mib.asl.framework.api.persistence.PersistenceNsDab;
import de.vw.mib.asl.framework.api.persistence.PersistenceNsDisplay;
import de.vw.mib.asl.framework.api.persistence.PersistenceNsEarly;
import de.vw.mib.asl.framework.api.persistence.PersistenceNsEntManager;
import de.vw.mib.asl.framework.api.persistence.PersistenceNsExBox;
import de.vw.mib.asl.framework.api.persistence.PersistenceNsExLAP;
import de.vw.mib.asl.framework.api.persistence.PersistenceNsITunes;
import de.vw.mib.asl.framework.api.persistence.PersistenceNsInternetBrowser;
import de.vw.mib.asl.framework.api.persistence.PersistenceNsLsc;
import de.vw.mib.asl.framework.api.persistence.PersistenceNsMedia;
import de.vw.mib.asl.framework.api.persistence.PersistenceNsMirrorlink;
import de.vw.mib.asl.framework.api.persistence.PersistenceNsNavHighAsia;
import de.vw.mib.asl.framework.api.persistence.PersistenceNsNavi;
import de.vw.mib.asl.framework.api.persistence.PersistenceNsOnline;
import de.vw.mib.asl.framework.api.persistence.PersistenceNsPhone;
import de.vw.mib.asl.framework.api.persistence.PersistenceNsSdars;
import de.vw.mib.asl.framework.api.persistence.PersistenceNsSmartphoneIntegration;
import de.vw.mib.asl.framework.api.persistence.PersistenceNsSound;
import de.vw.mib.asl.framework.api.persistence.PersistenceNsSpeech;
import de.vw.mib.asl.framework.api.persistence.PersistenceNsTrafficMiniMap;
import de.vw.mib.asl.framework.api.persistence.PersistenceNsTravelLink;
import de.vw.mib.asl.framework.api.persistence.PersistenceNsTv;

public interface PersistenceNamespace {
    public static final int LSC;
    public static final int EARLY;
    public static final int DAB;
    public static final int AMFM;
    public static final int NAVI;
    public static final int MEDIA;
    public static final int PHONE;
    public static final int SPEECH;
    public static final int DISPLAY;
    public static final int ENT_MANAGER;
    public static final int BAP;
    public static final int SDARS;
    public static final int TV;
    public static final int INTERNETBROWSER;
    public static final int EXBOX;
    public static final int MIRRORLINK;
    public static final int ITUNES;
    public static final int NAVHIGHASIA;
    public static final int CAR;
    public static final int ONLINE;
    public static final int TRAVELLINK;
    public static final int HAS;
    public static final int EXLAP;
    public static final int SOUND;
    public static final int TRAFFICMINIMAP;
    public static final int SMARTPHONEINTEGRATION;
    public static final int MIN_PERSISTENCE_NAMESPACE;
    public static final int MAX_PERSISTENCE_NAMESPACE;
    public static final int[][][] NAMESPACES;
    public static final int[] NAMESPACEIDS;
    public static final String[] NAMESPACENAMES;
    public static final Class[] NAMESPACECLASSES;
    public static final int[] DIAG_NAMESPACEIDS;
    public static final String[] DIAG_NAMESPACENAMES;

    static {
        NAMESPACES = new int[][][]{PersistenceNsLsc.NS, PersistenceNsEarly.NS, PersistenceNsDab.NS, PersistenceNsAmFm.NS, PersistenceNsNavi.NS, PersistenceNsMedia.NS, PersistenceNsPhone.NS, PersistenceNsSpeech.NS, PersistenceNsDisplay.NS, PersistenceNsEntManager.NS, PersistenceNsBAP.NS, PersistenceNsSdars.NS, PersistenceNsTv.NS, PersistenceNsInternetBrowser.NS, PersistenceNsExBox.NS, PersistenceNsMirrorlink.NS, PersistenceNsITunes.NS, PersistenceNsNavHighAsia.NS, PersistenceNsCar.NS, PersistenceNsOnline.NS, PersistenceNsTravelLink.NS, PersistenceNsExLAP.NS, PersistenceNsSound.NS, PersistenceNsTrafficMiniMap.NS, PersistenceNsSmartphoneIntegration.NS};
        NAMESPACEIDS = new int[]{1101, 5000, 5003, 5005, 5006, 5007, 5008, 5009, 5010, 5011, 5012, 5013, 5014, 5016, 5017, 5018, 5019, 5020, 5021, 5022, 5023, 5025, 5026, 5027, 5028};
        NAMESPACENAMES = new String[]{"LSC", "EARLY", "DAB", "AMFM", "NAVI", "MEDIA", "PHONE", "SPEECH", "DISPLAY", "ENTERTAINMENT_MANAGER", "BAP", "SDARS", "TV", "INTERNETBROWSER", "EXBOX", "MIRRORLINK", "ITUNES", "NAVHIGHASIA", "CAR", "ONLINE", "TRAVELLINK", "EXLAP", "SOUND", "TRAFFICMINIMAP", "SMARTPHONEINTEGRATION"};
        NAMESPACECLASSES = new Class[]{PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsLsc == null ? (PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsLsc = PersistenceNamespace$1.class$("de.vw.mib.asl.framework.api.persistence.PersistenceNsLsc")) : PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsLsc, PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsEarly == null ? (PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsEarly = PersistenceNamespace$1.class$("de.vw.mib.asl.framework.api.persistence.PersistenceNsEarly")) : PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsEarly, PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsDab == null ? (PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsDab = PersistenceNamespace$1.class$("de.vw.mib.asl.framework.api.persistence.PersistenceNsDab")) : PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsDab, PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsAmFm == null ? (PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsAmFm = PersistenceNamespace$1.class$("de.vw.mib.asl.framework.api.persistence.PersistenceNsAmFm")) : PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsAmFm, PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsNavi == null ? (PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsNavi = PersistenceNamespace$1.class$("de.vw.mib.asl.framework.api.persistence.PersistenceNsNavi")) : PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsNavi, PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsMedia == null ? (PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsMedia = PersistenceNamespace$1.class$("de.vw.mib.asl.framework.api.persistence.PersistenceNsMedia")) : PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsMedia, PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsPhone == null ? (PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsPhone = PersistenceNamespace$1.class$("de.vw.mib.asl.framework.api.persistence.PersistenceNsPhone")) : PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsPhone, PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsSpeech == null ? (PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsSpeech = PersistenceNamespace$1.class$("de.vw.mib.asl.framework.api.persistence.PersistenceNsSpeech")) : PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsSpeech, PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsDisplay == null ? (PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsDisplay = PersistenceNamespace$1.class$("de.vw.mib.asl.framework.api.persistence.PersistenceNsDisplay")) : PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsDisplay, PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsEntManager == null ? (PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsEntManager = PersistenceNamespace$1.class$("de.vw.mib.asl.framework.api.persistence.PersistenceNsEntManager")) : PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsEntManager, PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsBAP == null ? (PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsBAP = PersistenceNamespace$1.class$("de.vw.mib.asl.framework.api.persistence.PersistenceNsBAP")) : PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsBAP, PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsSdars == null ? (PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsSdars = PersistenceNamespace$1.class$("de.vw.mib.asl.framework.api.persistence.PersistenceNsSdars")) : PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsSdars, PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsTv == null ? (PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsTv = PersistenceNamespace$1.class$("de.vw.mib.asl.framework.api.persistence.PersistenceNsTv")) : PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsTv, PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsInternetBrowser == null ? (PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsInternetBrowser = PersistenceNamespace$1.class$("de.vw.mib.asl.framework.api.persistence.PersistenceNsInternetBrowser")) : PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsInternetBrowser, PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsExBox == null ? (PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsExBox = PersistenceNamespace$1.class$("de.vw.mib.asl.framework.api.persistence.PersistenceNsExBox")) : PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsExBox, PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsMirrorlink == null ? (PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsMirrorlink = PersistenceNamespace$1.class$("de.vw.mib.asl.framework.api.persistence.PersistenceNsMirrorlink")) : PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsMirrorlink, PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsITunes == null ? (PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsITunes = PersistenceNamespace$1.class$("de.vw.mib.asl.framework.api.persistence.PersistenceNsITunes")) : PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsITunes, PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsNavHighAsia == null ? (PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsNavHighAsia = PersistenceNamespace$1.class$("de.vw.mib.asl.framework.api.persistence.PersistenceNsNavHighAsia")) : PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsNavHighAsia, PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsCar == null ? (PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsCar = PersistenceNamespace$1.class$("de.vw.mib.asl.framework.api.persistence.PersistenceNsCar")) : PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsCar, PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsOnline == null ? (PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsOnline = PersistenceNamespace$1.class$("de.vw.mib.asl.framework.api.persistence.PersistenceNsOnline")) : PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsOnline, PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsTravelLink == null ? (PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsTravelLink = PersistenceNamespace$1.class$("de.vw.mib.asl.framework.api.persistence.PersistenceNsTravelLink")) : PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsTravelLink, PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsExLAP == null ? (PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsExLAP = PersistenceNamespace$1.class$("de.vw.mib.asl.framework.api.persistence.PersistenceNsExLAP")) : PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsExLAP, PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsSound == null ? (PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsSound = PersistenceNamespace$1.class$("de.vw.mib.asl.framework.api.persistence.PersistenceNsSound")) : PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsSound, PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsTrafficMiniMap == null ? (PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsTrafficMiniMap = PersistenceNamespace$1.class$("de.vw.mib.asl.framework.api.persistence.PersistenceNsTrafficMiniMap")) : PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsTrafficMiniMap, PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsSmartphoneIntegration == null ? (PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsSmartphoneIntegration = PersistenceNamespace$1.class$("de.vw.mib.asl.framework.api.persistence.PersistenceNsSmartphoneIntegration")) : PersistenceNamespace$1.class$de$vw$mib$asl$framework$api$persistence$PersistenceNsSmartphoneIntegration};
        DIAG_NAMESPACEIDS = new int[]{0, -687821311, -536825343, 906042371, 553765890, -1945800920, 570543106, 671206402, 604097538, 654429186, 637651970, 587320322, 620874754};
        DIAG_NAMESPACENAMES = new String[]{"GENERIC", "CODING", "ADAPTATION", "UP_DOWNLOAD", "IDENT", "INFO", "CU_BT", "CU_GRACENOTE", "CU_MIRRORLINK", "CU_NAVCARUPDATE", "CU_PERSONALPOI", "CU_STATIONDB", "CU_USBSURFSTICK"};
    }
}

