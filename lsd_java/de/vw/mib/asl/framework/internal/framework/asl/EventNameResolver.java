/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.asl.framework.internal.framework.asl;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEventException;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class EventNameResolver {
    static IntObjectOptHashMap evtIdMap = new IntObjectOptHashMap();
    static ObjectObjectOptHashMap evtNameMap = new ObjectObjectOptHashMap();
    private static int lastUsedPrivateEvent = 75956480;
    static /* synthetic */ Class array$B;
    static /* synthetic */ Class class$de$vw$mib$genericevents$EventGeneric;
    static /* synthetic */ Class class$java$lang$System;
    static /* synthetic */ Class class$generated$de$vw$mib$asl$internal$navigation$ASLNavigationServiceConstants;
    static /* synthetic */ Class class$generated$de$vw$mib$asl$internal$navigation$bap$ASLNavigationBapServiceConstants;
    static /* synthetic */ Class class$generated$de$vw$mib$asl$internal$navigation$dualscreen$ASLNavigationDualScreenServiceConstants;
    static /* synthetic */ Class class$generated$de$vw$mib$asl$internal$navigation$destinput$ASLNavigationDestInputServiceConstants;
    static /* synthetic */ Class class$generated$de$vw$mib$asl$internal$navigation$destinput$destlist$ASLNavigationDestInputDestListServiceConstants;
    static /* synthetic */ Class class$generated$de$vw$mib$asl$internal$navigation$guidance$ASLNavigationGuidanceServiceConstants;
    static /* synthetic */ Class class$generated$de$vw$mib$asl$internal$navigation$homedestinput$ASLNavigationHomeDestInputServiceConstants;
    static /* synthetic */ Class class$generated$de$vw$mib$asl$internal$navigation$locationinput$ASLNavigationLocationInputServiceConstants;
    static /* synthetic */ Class class$generated$de$vw$mib$asl$internal$navigation$locationinput$inputfield$ASLNavigationLocationInputInputFieldServiceConstants;
    static /* synthetic */ Class class$generated$de$vw$mib$asl$internal$navigation$crosshairmode$ASLNavigationCrosshairModeServiceConstants;
    static /* synthetic */ Class class$generated$de$vw$mib$asl$internal$navigation$map$ASLNavigationMapServiceConstants;
    static /* synthetic */ Class class$generated$de$vw$mib$asl$internal$navigation$map$setup$ASLNavigationMapSetupServiceConstants;
    static /* synthetic */ Class class$generated$de$vw$mib$asl$internal$navigation$map$ss$ASLNavigationMapSSServiceConstants;
    static /* synthetic */ Class class$generated$de$vw$mib$asl$internal$navigation$map$view$ASLNavigationMapViewServiceConstants;
    static /* synthetic */ Class class$generated$de$vw$mib$asl$internal$navigation$memory$ASLNavigationMemoryServiceConstants;
    static /* synthetic */ Class class$generated$de$vw$mib$asl$internal$navigation$memory$sd$ASLNavigationMemorySDServiceConstants;
    static /* synthetic */ Class class$generated$de$vw$mib$asl$internal$navigation$poi$ASLNavigationPOIServiceConstants;
    static /* synthetic */ Class class$generated$de$vw$mib$asl$internal$navigation$poi$setup$ASLNavigationPOISetupServiceConstants;
    static /* synthetic */ Class class$generated$de$vw$mib$asl$internal$navigation$routeoptions$ASLNavigationRouteOptionsServiceConstants;
    static /* synthetic */ Class class$generated$de$vw$mib$asl$internal$navigation$setup$ASLNavigationSetupServiceConstants;
    static /* synthetic */ Class class$generated$de$vw$mib$asl$internal$navigation$speech$ASLNavigationSpeechServiceConstants;
    static /* synthetic */ Class class$generated$de$vw$mib$asl$internal$navigation$traffic$ASLNavigationTrafficServiceConstants;
    static /* synthetic */ Class class$generated$de$vw$mib$asl$internal$navigation$tourmode$ASLNavigationTourModeServiceConstants;
    static /* synthetic */ Class class$generated$de$vw$mib$asl$internal$navigation$via$ASLNavigationViaServiceConstants;
    static /* synthetic */ Class class$generated$de$vw$mib$asl$internal$navigation$pnav$ASLNavigationPnavServiceConstants;

    public static int makeNewEvent(String string) {
        int n = lastUsedPrivateEvent++;
        EventNameResolver.putEventMap(n, string);
        return n;
    }

    public static boolean putEventMap(int n, String string) {
        evtNameMap.put(string, new Integer(n));
        if (!evtIdMap.containsKey(n)) {
            evtIdMap.put(n, string);
            return true;
        }
        String string2 = (String)evtIdMap.get(n);
        if (string.length() < string2.length()) {
            evtIdMap.put(n, string);
            return true;
        }
        return false;
    }

    public static void registerDevice(String string, Class clazz) {
        Field[] fieldArray = clazz.getFields();
        for (int i2 = 0; i2 < fieldArray.length; ++i2) {
            try {
                int n = fieldArray[i2].getInt(null);
                String string2 = new StringBuffer().append(string).append(fieldArray[i2].getName()).toString();
                if ("ASL_TARGET_ID".equals(fieldArray[i2].getName())) continue;
                EventNameResolver.putEventMap(n, string2);
                continue;
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleStartupError(exception);
            }
        }
    }

    public static void printDevice(String string, Class clazz, PrintStream printStream) {
        Field[] fieldArray = clazz.getFields();
        for (int i2 = 0; i2 < fieldArray.length; ++i2) {
            try {
                String string2 = new StringBuffer().append(string).append(fieldArray[i2].getName()).toString();
                if ("ASL_TARGET_ID".equals(fieldArray[i2].getName())) continue;
                printStream.println(new StringBuffer().append("\tEventNameResolver.putEventMap(").append(clazz.getName()).append(".").append(fieldArray[i2].getName()).append(", \"").append(string2).append("\");").toString());
                continue;
            }
            catch (Exception exception) {
                ServiceManager.errorHandler.handleStartupError(exception);
            }
        }
    }

    public static String resolveEventName(int n) {
        String string = (String)evtIdMap.get(n);
        if (string == null) {
            ServiceManager.logger.error(16384, new StringBuffer().append("event id: ").append(n).append(" could not be resolved!!!").toString());
            string = "";
        }
        return string;
    }

    public static int resolveEventId(String string) {
        Integer n = (Integer)evtNameMap.get(string);
        if (n == null) {
            ServiceManager.logger.error(16384, new StringBuffer().append("event: ").append(string).append(" could not be resolved!!!").toString());
            return 0;
        }
        return n;
    }

    public static void convertEventData(EventGeneric eventGeneric, Class[] classArray, Object[] objectArray, int n) {
        for (int i2 = 0; i2 < objectArray.length - n; ++i2) {
            try {
                switch (eventGeneric.getParamType(i2)) {
                    case 1: {
                        classArray[i2 + n] = Integer.TYPE;
                        objectArray[i2 + n] = eventGeneric.getPrimitiveObject(i2);
                        break;
                    }
                    case 2: {
                        classArray[i2 + n] = Boolean.TYPE;
                        objectArray[i2 + n] = eventGeneric.getPrimitiveObject(i2);
                        break;
                    }
                    case 3: {
                        classArray[i2 + n] = Float.TYPE;
                        objectArray[i2 + n] = eventGeneric.getPrimitiveObject(i2);
                        break;
                    }
                    case 4: {
                        classArray[i2 + n] = Double.TYPE;
                        objectArray[i2 + n] = eventGeneric.getPrimitiveObject(i2);
                        break;
                    }
                    case 5: {
                        classArray[i2 + n] = Byte.TYPE;
                        objectArray[i2 + n] = eventGeneric.getString(i2);
                        break;
                    }
                    case 7: {
                        classArray[i2 + n] = array$B == null ? EventNameResolver.class$("[B") : array$B;
                        objectArray[i2 + n] = eventGeneric.getPrimitiveObject(i2);
                        break;
                    }
                    case 8: {
                        classArray[i2 + n] = Character.TYPE;
                        objectArray[i2 + n] = eventGeneric.getPrimitiveObject(i2);
                        break;
                    }
                    case 9: {
                        classArray[i2 + n] = class$de$vw$mib$genericevents$EventGeneric == null ? EventNameResolver.class$("de.vw.mib.genericevents.EventGeneric") : class$de$vw$mib$genericevents$EventGeneric;
                        objectArray[i2 + n] = eventGeneric.getPrimitiveObject(i2);
                        break;
                    }
                    case 10: {
                        classArray[i2 + n] = Long.TYPE;
                        objectArray[i2 + n] = eventGeneric.getPrimitiveObject(i2);
                        break;
                    }
                    case 11: {
                        classArray[i2 + n] = Short.TYPE;
                        objectArray[i2 + n] = eventGeneric.getPrimitiveObject(i2);
                        break;
                    }
                    default: {
                        objectArray[i2 + n] = eventGeneric.getObject(i2);
                        classArray[i2 + n] = objectArray[i2 + n].getClass();
                        break;
                    }
                }
                continue;
            }
            catch (GenericEventException genericEventException) {
                ServiceManager.errorHandler.handleError(genericEventException);
            }
        }
    }

    public static void main(String[] stringArray) {
        PrintStream printStream = (PrintStream)(class$java$lang$System == null ? (class$java$lang$System = EventNameResolver.class$("java.lang.System")) : class$java$lang$System).getField("out").get(null);
        EventNameResolver.printDevice("ASL_NAVIGATION_", class$generated$de$vw$mib$asl$internal$navigation$ASLNavigationServiceConstants == null ? (class$generated$de$vw$mib$asl$internal$navigation$ASLNavigationServiceConstants = EventNameResolver.class$("generated.de.vw.mib.asl.internal.navigation.ASLNavigationServiceConstants")) : class$generated$de$vw$mib$asl$internal$navigation$ASLNavigationServiceConstants, printStream);
        EventNameResolver.printDevice("ASL_NAVIGATION_BAP_", class$generated$de$vw$mib$asl$internal$navigation$bap$ASLNavigationBapServiceConstants == null ? (class$generated$de$vw$mib$asl$internal$navigation$bap$ASLNavigationBapServiceConstants = EventNameResolver.class$("generated.de.vw.mib.asl.internal.navigation.bap.ASLNavigationBapServiceConstants")) : class$generated$de$vw$mib$asl$internal$navigation$bap$ASLNavigationBapServiceConstants, printStream);
        EventNameResolver.printDevice("ASL_NAVIGATION_DUALSCREEN_", class$generated$de$vw$mib$asl$internal$navigation$dualscreen$ASLNavigationDualScreenServiceConstants == null ? (class$generated$de$vw$mib$asl$internal$navigation$dualscreen$ASLNavigationDualScreenServiceConstants = EventNameResolver.class$("generated.de.vw.mib.asl.internal.navigation.dualscreen.ASLNavigationDualScreenServiceConstants")) : class$generated$de$vw$mib$asl$internal$navigation$dualscreen$ASLNavigationDualScreenServiceConstants, printStream);
        EventNameResolver.printDevice("ASL_NAVIGATION_DESTINPUT_", class$generated$de$vw$mib$asl$internal$navigation$destinput$ASLNavigationDestInputServiceConstants == null ? (class$generated$de$vw$mib$asl$internal$navigation$destinput$ASLNavigationDestInputServiceConstants = EventNameResolver.class$("generated.de.vw.mib.asl.internal.navigation.destinput.ASLNavigationDestInputServiceConstants")) : class$generated$de$vw$mib$asl$internal$navigation$destinput$ASLNavigationDestInputServiceConstants, printStream);
        EventNameResolver.printDevice("ASL_NAVIGATION_DESTINPUT_DESTLIST_", class$generated$de$vw$mib$asl$internal$navigation$destinput$destlist$ASLNavigationDestInputDestListServiceConstants == null ? (class$generated$de$vw$mib$asl$internal$navigation$destinput$destlist$ASLNavigationDestInputDestListServiceConstants = EventNameResolver.class$("generated.de.vw.mib.asl.internal.navigation.destinput.destlist.ASLNavigationDestInputDestListServiceConstants")) : class$generated$de$vw$mib$asl$internal$navigation$destinput$destlist$ASLNavigationDestInputDestListServiceConstants, printStream);
        EventNameResolver.printDevice("ASL_NAVIGATION_GUIDANCE_", class$generated$de$vw$mib$asl$internal$navigation$guidance$ASLNavigationGuidanceServiceConstants == null ? (class$generated$de$vw$mib$asl$internal$navigation$guidance$ASLNavigationGuidanceServiceConstants = EventNameResolver.class$("generated.de.vw.mib.asl.internal.navigation.guidance.ASLNavigationGuidanceServiceConstants")) : class$generated$de$vw$mib$asl$internal$navigation$guidance$ASLNavigationGuidanceServiceConstants, printStream);
        EventNameResolver.printDevice("ASL_NAVIGATION_HOMEDESTINPUT_", class$generated$de$vw$mib$asl$internal$navigation$homedestinput$ASLNavigationHomeDestInputServiceConstants == null ? (class$generated$de$vw$mib$asl$internal$navigation$homedestinput$ASLNavigationHomeDestInputServiceConstants = EventNameResolver.class$("generated.de.vw.mib.asl.internal.navigation.homedestinput.ASLNavigationHomeDestInputServiceConstants")) : class$generated$de$vw$mib$asl$internal$navigation$homedestinput$ASLNavigationHomeDestInputServiceConstants, printStream);
        EventNameResolver.printDevice("ASL_NAVIGATION_LOCATIONINPUT_", class$generated$de$vw$mib$asl$internal$navigation$locationinput$ASLNavigationLocationInputServiceConstants == null ? (class$generated$de$vw$mib$asl$internal$navigation$locationinput$ASLNavigationLocationInputServiceConstants = EventNameResolver.class$("generated.de.vw.mib.asl.internal.navigation.locationinput.ASLNavigationLocationInputServiceConstants")) : class$generated$de$vw$mib$asl$internal$navigation$locationinput$ASLNavigationLocationInputServiceConstants, printStream);
        EventNameResolver.printDevice("ASL_NAVIGATION_LOCATIONINPUT_INPUTFIELD_", class$generated$de$vw$mib$asl$internal$navigation$locationinput$inputfield$ASLNavigationLocationInputInputFieldServiceConstants == null ? (class$generated$de$vw$mib$asl$internal$navigation$locationinput$inputfield$ASLNavigationLocationInputInputFieldServiceConstants = EventNameResolver.class$("generated.de.vw.mib.asl.internal.navigation.locationinput.inputfield.ASLNavigationLocationInputInputFieldServiceConstants")) : class$generated$de$vw$mib$asl$internal$navigation$locationinput$inputfield$ASLNavigationLocationInputInputFieldServiceConstants, printStream);
        EventNameResolver.printDevice("ASL_NAVIGATION_CROSSHAIRMODE_", class$generated$de$vw$mib$asl$internal$navigation$crosshairmode$ASLNavigationCrosshairModeServiceConstants == null ? (class$generated$de$vw$mib$asl$internal$navigation$crosshairmode$ASLNavigationCrosshairModeServiceConstants = EventNameResolver.class$("generated.de.vw.mib.asl.internal.navigation.crosshairmode.ASLNavigationCrosshairModeServiceConstants")) : class$generated$de$vw$mib$asl$internal$navigation$crosshairmode$ASLNavigationCrosshairModeServiceConstants, printStream);
        EventNameResolver.printDevice("ASL_NAVIGATION_MAP_", class$generated$de$vw$mib$asl$internal$navigation$map$ASLNavigationMapServiceConstants == null ? (class$generated$de$vw$mib$asl$internal$navigation$map$ASLNavigationMapServiceConstants = EventNameResolver.class$("generated.de.vw.mib.asl.internal.navigation.map.ASLNavigationMapServiceConstants")) : class$generated$de$vw$mib$asl$internal$navigation$map$ASLNavigationMapServiceConstants, printStream);
        EventNameResolver.printDevice("ASL_NAVIGATION_MAP_SETUP_", class$generated$de$vw$mib$asl$internal$navigation$map$setup$ASLNavigationMapSetupServiceConstants == null ? (class$generated$de$vw$mib$asl$internal$navigation$map$setup$ASLNavigationMapSetupServiceConstants = EventNameResolver.class$("generated.de.vw.mib.asl.internal.navigation.map.setup.ASLNavigationMapSetupServiceConstants")) : class$generated$de$vw$mib$asl$internal$navigation$map$setup$ASLNavigationMapSetupServiceConstants, printStream);
        EventNameResolver.printDevice("ASL_NAVIGATION_MAP_SS_", class$generated$de$vw$mib$asl$internal$navigation$map$ss$ASLNavigationMapSSServiceConstants == null ? (class$generated$de$vw$mib$asl$internal$navigation$map$ss$ASLNavigationMapSSServiceConstants = EventNameResolver.class$("generated.de.vw.mib.asl.internal.navigation.map.ss.ASLNavigationMapSSServiceConstants")) : class$generated$de$vw$mib$asl$internal$navigation$map$ss$ASLNavigationMapSSServiceConstants, printStream);
        EventNameResolver.printDevice("ASL_NAVIGATION_MAP_VIEW_", class$generated$de$vw$mib$asl$internal$navigation$map$view$ASLNavigationMapViewServiceConstants == null ? (class$generated$de$vw$mib$asl$internal$navigation$map$view$ASLNavigationMapViewServiceConstants = EventNameResolver.class$("generated.de.vw.mib.asl.internal.navigation.map.view.ASLNavigationMapViewServiceConstants")) : class$generated$de$vw$mib$asl$internal$navigation$map$view$ASLNavigationMapViewServiceConstants, printStream);
        EventNameResolver.printDevice("ASL_NAVIGATION_MEMORY_", class$generated$de$vw$mib$asl$internal$navigation$memory$ASLNavigationMemoryServiceConstants == null ? (class$generated$de$vw$mib$asl$internal$navigation$memory$ASLNavigationMemoryServiceConstants = EventNameResolver.class$("generated.de.vw.mib.asl.internal.navigation.memory.ASLNavigationMemoryServiceConstants")) : class$generated$de$vw$mib$asl$internal$navigation$memory$ASLNavigationMemoryServiceConstants, printStream);
        EventNameResolver.printDevice("ASL_NAVIGATION_MEMORY_SD_", class$generated$de$vw$mib$asl$internal$navigation$memory$sd$ASLNavigationMemorySDServiceConstants == null ? (class$generated$de$vw$mib$asl$internal$navigation$memory$sd$ASLNavigationMemorySDServiceConstants = EventNameResolver.class$("generated.de.vw.mib.asl.internal.navigation.memory.sd.ASLNavigationMemorySDServiceConstants")) : class$generated$de$vw$mib$asl$internal$navigation$memory$sd$ASLNavigationMemorySDServiceConstants, printStream);
        EventNameResolver.printDevice("ASL_NAVIGATION_POI_", class$generated$de$vw$mib$asl$internal$navigation$poi$ASLNavigationPOIServiceConstants == null ? (class$generated$de$vw$mib$asl$internal$navigation$poi$ASLNavigationPOIServiceConstants = EventNameResolver.class$("generated.de.vw.mib.asl.internal.navigation.poi.ASLNavigationPOIServiceConstants")) : class$generated$de$vw$mib$asl$internal$navigation$poi$ASLNavigationPOIServiceConstants, printStream);
        EventNameResolver.printDevice("ASL_NAVIGATION_POI_SETUP_", class$generated$de$vw$mib$asl$internal$navigation$poi$setup$ASLNavigationPOISetupServiceConstants == null ? (class$generated$de$vw$mib$asl$internal$navigation$poi$setup$ASLNavigationPOISetupServiceConstants = EventNameResolver.class$("generated.de.vw.mib.asl.internal.navigation.poi.setup.ASLNavigationPOISetupServiceConstants")) : class$generated$de$vw$mib$asl$internal$navigation$poi$setup$ASLNavigationPOISetupServiceConstants, printStream);
        EventNameResolver.printDevice("ASL_NAVIGATION_ROUTEOPTIONS_", class$generated$de$vw$mib$asl$internal$navigation$routeoptions$ASLNavigationRouteOptionsServiceConstants == null ? (class$generated$de$vw$mib$asl$internal$navigation$routeoptions$ASLNavigationRouteOptionsServiceConstants = EventNameResolver.class$("generated.de.vw.mib.asl.internal.navigation.routeoptions.ASLNavigationRouteOptionsServiceConstants")) : class$generated$de$vw$mib$asl$internal$navigation$routeoptions$ASLNavigationRouteOptionsServiceConstants, printStream);
        EventNameResolver.printDevice("ASL_NAVIGATION_SETUP_", class$generated$de$vw$mib$asl$internal$navigation$setup$ASLNavigationSetupServiceConstants == null ? (class$generated$de$vw$mib$asl$internal$navigation$setup$ASLNavigationSetupServiceConstants = EventNameResolver.class$("generated.de.vw.mib.asl.internal.navigation.setup.ASLNavigationSetupServiceConstants")) : class$generated$de$vw$mib$asl$internal$navigation$setup$ASLNavigationSetupServiceConstants, printStream);
        EventNameResolver.printDevice("ASL_NAVIGATION_SPEECH_", class$generated$de$vw$mib$asl$internal$navigation$speech$ASLNavigationSpeechServiceConstants == null ? (class$generated$de$vw$mib$asl$internal$navigation$speech$ASLNavigationSpeechServiceConstants = EventNameResolver.class$("generated.de.vw.mib.asl.internal.navigation.speech.ASLNavigationSpeechServiceConstants")) : class$generated$de$vw$mib$asl$internal$navigation$speech$ASLNavigationSpeechServiceConstants, printStream);
        EventNameResolver.printDevice("ASL_NAVIGATION_TRAFFIC_", class$generated$de$vw$mib$asl$internal$navigation$traffic$ASLNavigationTrafficServiceConstants == null ? (class$generated$de$vw$mib$asl$internal$navigation$traffic$ASLNavigationTrafficServiceConstants = EventNameResolver.class$("generated.de.vw.mib.asl.internal.navigation.traffic.ASLNavigationTrafficServiceConstants")) : class$generated$de$vw$mib$asl$internal$navigation$traffic$ASLNavigationTrafficServiceConstants, printStream);
        EventNameResolver.printDevice("ASL_NAVIGATION_TOURMODE_", class$generated$de$vw$mib$asl$internal$navigation$tourmode$ASLNavigationTourModeServiceConstants == null ? (class$generated$de$vw$mib$asl$internal$navigation$tourmode$ASLNavigationTourModeServiceConstants = EventNameResolver.class$("generated.de.vw.mib.asl.internal.navigation.tourmode.ASLNavigationTourModeServiceConstants")) : class$generated$de$vw$mib$asl$internal$navigation$tourmode$ASLNavigationTourModeServiceConstants, printStream);
        EventNameResolver.printDevice("ASL_NAVIGATION_VIA_", class$generated$de$vw$mib$asl$internal$navigation$via$ASLNavigationViaServiceConstants == null ? (class$generated$de$vw$mib$asl$internal$navigation$via$ASLNavigationViaServiceConstants = EventNameResolver.class$("generated.de.vw.mib.asl.internal.navigation.via.ASLNavigationViaServiceConstants")) : class$generated$de$vw$mib$asl$internal$navigation$via$ASLNavigationViaServiceConstants, printStream);
        EventNameResolver.printDevice("ASL_NAVIGATION_PNAV_", class$generated$de$vw$mib$asl$internal$navigation$pnav$ASLNavigationPnavServiceConstants == null ? (class$generated$de$vw$mib$asl$internal$navigation$pnav$ASLNavigationPnavServiceConstants = EventNameResolver.class$("generated.de.vw.mib.asl.internal.navigation.pnav.ASLNavigationPnavServiceConstants")) : class$generated$de$vw$mib$asl$internal$navigation$pnav$ASLNavigationPnavServiceConstants, printStream);
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
        EventNameResolver.putEventMap(2, "HSM_ENTRY");
        EventNameResolver.putEventMap(3, "HSM_START");
        EventNameResolver.putEventMap(4, "HSM_EXIT");
        EventNameResolver.putEventMap(8, "NOTIFY_TARGET_REGISTERED");
        EventNameResolver.putEventMap(107, "POWER_OFF");
        EventNameResolver.putEventMap(106, "POWER_ON");
        EventNameResolver.putEventMap(-1937112832, "NAVI_STARTUP_TARGET_TIMEOUT");
        EventNameResolver.putEventMap(-1953890048, "NAVI_STARTUP_TARGET_PREPARE_ON");
        EventNameResolver.putEventMap(-1987444480, "NAVI_STARTUP_TARGET_GO_ON");
        EventNameResolver.putEventMap(-1970667264, "NAVI_STARTUP_TARGET_PREPARE_OFF");
        EventNameResolver.putEventMap(-2004221696, "NAVI_STARTUP_TARGET_GO_OFF");
    }
}

