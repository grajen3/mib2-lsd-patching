/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.framework;

import de.vw.mib.asl.framework.api.framework.component.ASLComponentRegistry;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.log4mib.Logger;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import org.osgi.framework.BundleContext;

public class ASLFactoryBase {
    public static final String FRAMEWORK_API_CLASS_NAME;
    public static final String DSIPROXY_API_CLASS_NAME;
    public static final String CONSOLE_API_IMPL_CLASS_NAME;
    public static final String DIAGNOSIS_API_CLASS_NAME;
    public static final String DISPLAYMANAGEMENT_API_CLASS_NAME;
    public static final String ENTERTAINMENTMANAGER_API_CLASS_NAME;
    public static final String LSC_API_CLASS_NAME;
    public static final String PERSISTENCE_API_CLASS_NAME;
    public static final String STARTUPV7R_API_CLASS_NAME;
    public static final String ASIAINPUT_API_CLASS_NAME;
    public static final String AVDC_API_CLASS_NAME;
    public static final String CAR_API_CLASS_NAME;
    public static final String CLIMATE_API_CLASS_NAME;
    public static final String CONNECTIVITY_API_CLASS_NAME;
    public static final String DOWNLOAD_API_CLASS_NAME;
    public static final String EXBOXM_API_CLASS_NAME;
    public static final String EXLAP_API_CLASS_NAME;
    public static final String FILEBROWSER_API_CLASS_NAME;
    public static final String HAS_API_CLASS_NAME;
    public static final String INFOTAINMENTRECORDER_API_CLASS_NAME;
    public static final String INTERNETBROWSER_API_CLASS_NAME;
    public static final String ITUNES_API_CLASS_NAME;
    public static final String KOMBIPICTURESERVER_API_CLASS_NAME;
    public static final String MEDIA_API_CLASS_NAME;
    public static final String MESSAGES_API_CLASS_NAME;
    public static final String MIRRORLINK_API_CLASS_NAME;
    public static final String MOSTKOMBI_API_CLASS_NAME;
    public static final String NAVASIA_API_CLASS_NAME;
    public static final String NAVBAP_API_CLASS_NAME;
    public static final String NAVIGATION_API_CLASS_NAME;
    public static final String ONLINE_API_CLASS_NAME;
    public static final String ORGANIZER_API_CLASS_NAME;
    public static final String PHONE_API_CLASS_NAME;
    public static final String PICTURESTORE_API_CLASS_NAME;
    public static final String PICTUREVIEWER_API_CLASS_NAME;
    public static final String RADIO_API_CLASS_NAME;
    public static final String SFA_API_CLASS_NAME;
    public static final String SOUND_API_CLASS_NAME;
    public static final String SWAP_API_CLASS_NAME;
    public static final String SYSTEM_API_CLASS_NAME;
    public static final String TESTMODE_API_CLASS_NAME;
    public static final String TRAVELLINK_API_CLASS_NAME;
    public static final String TVTUNER_API_CLASS_NAME;
    public static final String BAPCOMMON_API_CLASS_NAME;
    public static final String IC_MQB_PQ_API_CLASS_NAME;
    public static final String IC_MQB2_API_CLASS_NAME;
    public static final String CAR_UGDO_API_CLASS_NAME;
    public static final String TRAFFICMINIMAP_API_CLASS_NAME;
    public static final String CARPLAY_API_CLASS_NAME;
    public static final String SMARTPHONEINTEGRATION_API_CLASS_NAME;
    public static final String ANDROIDAUTO_API_CLASS_NAME;
    public static final String INTERNETRADIO_API_CLASS_NAME;
    public static final String SYSTEMSETUP_API_CLASS_NAME;
    public static final String FLOWLISTMENU_API_CLASS_NAME;
    public static final String HOMESCREEN_API_CLASS_NAME;
    public static final String HOMEBUTTON_API_CLASS_NAME;
    public static final String GRIDMENU_API_CLASS_NAME;
    public static final String BACKGROUND_API_CLASS_NAME;
    public static final String MEDIACONTROL_API_CLASS_NAME;
    public static final String VICSETC_API_CLASS_NAME;
    public static final String NAVMAPTILE_API_CLASS_NAME;
    public static final String SELECTIONTILES_API_CLASS_NAME;
    public static final String NAVINFOTILE_API_CLASS_NAME;
    public static final String DATEGLOBALWIZARDPAGE_API_CLASS_NAME;
    public static final String SELECTIONTILEL_API_CLASS_NAME;
    public static final String GLOBALSETUPWIZARD_API_CLASS_NAME;
    public static final String STATUSBAR_API_CLASS_NAME;
    public static final String WEBRADIO_API_CLASS_NAME;
    public static final String HOMESCREENLIGHT_API_CLASS_NAME;
    public static final String OFFCLOCK_API_CLASS_NAME;
    public static final String NAVTRAFFICTILES_API_CLASS_NAME;
    public static final String CARLIFE_API_CLASS_NAME;
    public static final String ONLINELOGBOOK_API_CLASS_NAME;
    public static final String GLOBALGOODBYE_API_CLASS_NAME;
    private static Map apiRegistry;
    private static ASLComponentRegistry componentRegistry;
    public static BundleContext bundleContext;
    public static Logger logger;
    public static Logger logger2;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$framework$ASLFactoryBase;
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$de$vw$mib$genericevents$GenericEvents;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$framework$ASLServiceIdRanges;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$framework$ASLTargetIdRanges;

    public static synchronized void transferAPIs(ASLComponentRegistry aSLComponentRegistry) {
        if (null != apiRegistry) {
            Iterator iterator = apiRegistry.entrySet().iterator();
            while (iterator.hasNext()) {
                Map$Entry map$Entry = (Map$Entry)iterator.next();
                aSLComponentRegistry.registerAPI((Class)map$Entry.getKey(), map$Entry.getValue());
            }
            apiRegistry = null;
            componentRegistry = aSLComponentRegistry;
        }
    }

    private static Object getAPI(Class clazz) {
        return null != apiRegistry ? apiRegistry.get(clazz) : componentRegistry.getAPIInstance(clazz);
    }

    protected static Object getAPIInstance(Class clazz) {
        return ASLFactoryBase.getAPI(clazz);
    }

    protected static void registerAPIService(Class clazz, Object object) {
        ASLFactoryBase.storeAPI(clazz, object);
    }

    private static void storeAPI(Class clazz, Object object) {
        if (null != apiRegistry) {
            apiRegistry.put(clazz, object);
        } else {
            componentRegistry.registerAPI(clazz, object);
        }
    }

    protected static synchronized Object createServiceInstance(Class clazz, String string) {
        Object object = ASLFactoryBase.getAPI(clazz);
        if (object == null) {
            try {
                object = Class.forName(string).newInstance();
                ASLFactoryBase.storeAPI(clazz, object);
            }
            catch (Exception exception) {
                if (null != logger) {
                    logger.error(1).append("ASLFactoryBase#createServiceInstance, impl=").append(string).attachThrowable(exception).log();
                }
                exception.printStackTrace();
            }
        }
        return object;
    }

    protected static synchronized Object createServiceInstance(Class clazz, String string, Class[] classArray, Object[] objectArray) {
        Object object = ASLFactoryBase.getAPI(clazz);
        if (object == null) {
            try {
                object = Class.forName(string).getConstructor(classArray).newInstance(objectArray);
                ASLFactoryBase.storeAPI(clazz, object);
            }
            catch (Exception exception) {
                if (null != logger) {
                    logger.error(1).append("ASLFactoryBase#createServiceInstance, impl=").append(string).attachThrowable(exception).log();
                }
                exception.printStackTrace();
            }
        }
        return object;
    }

    public static void loadAllFactoryImplClasses() {
        Field[] fieldArray = (class$de$vw$mib$asl$framework$api$framework$ASLFactoryBase == null ? (class$de$vw$mib$asl$framework$api$framework$ASLFactoryBase = ASLFactoryBase.class$("de.vw.mib.asl.framework.api.framework.ASLFactoryBase")) : class$de$vw$mib$asl$framework$api$framework$ASLFactoryBase).getFields();
        for (int i2 = 0; i2 < fieldArray.length; ++i2) {
            Field field = fieldArray[i2];
            if (field.getType() != (class$java$lang$String == null ? ASLFactoryBase.class$("java.lang.String") : class$java$lang$String) || !field.getName().endsWith("CLASS_NAME")) continue;
            try {
                String string = (String)fieldArray[i2].get(null);
                Class.forName(string);
                continue;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public static void registerAllIds(GenericEvents genericEvents) {
        Class[] classArray = new Class[]{class$de$vw$mib$genericevents$GenericEvents == null ? (class$de$vw$mib$genericevents$GenericEvents = ASLFactoryBase.class$("de.vw.mib.genericevents.GenericEvents")) : class$de$vw$mib$genericevents$GenericEvents};
        Object[] objectArray = new Object[]{genericEvents};
        Field[] fieldArray = (class$de$vw$mib$asl$framework$api$framework$ASLFactoryBase == null ? (class$de$vw$mib$asl$framework$api$framework$ASLFactoryBase = ASLFactoryBase.class$("de.vw.mib.asl.framework.api.framework.ASLFactoryBase")) : class$de$vw$mib$asl$framework$api$framework$ASLFactoryBase).getFields();
        for (int i2 = 0; i2 < fieldArray.length; ++i2) {
            Field field = fieldArray[i2];
            if (field.getType() != (class$java$lang$String == null ? ASLFactoryBase.class$("java.lang.String") : class$java$lang$String) || !field.getName().endsWith("CLASS_NAME")) continue;
            try {
                String string = (String)fieldArray[i2].get(null);
                Class clazz = Class.forName(string);
                clazz.getMethod("registerIds", classArray).invoke(null, objectArray);
                continue;
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    private static void checkRanges(Class clazz) {
        int n;
        Field[] fieldArray = clazz.getFields();
        int n2 = 0;
        for (n = 0; n < fieldArray.length; ++n) {
            if (!fieldArray[n].getName().endsWith("RANGE_SIZE")) continue;
            n2 = fieldArray[n].getInt(null);
            break;
        }
        for (n = 0; n < fieldArray.length; ++n) {
            if (fieldArray[n].getName().endsWith("_END")) {
                if (fieldArray[n - 1].getInt(null) + n2 - 1 == fieldArray[n].getInt(null)) continue;
                System.err.println(new StringBuffer().append("range: ").append(fieldArray[n - 1].getName()).append(" - ").append(fieldArray[n].getName()).append(" wrong").toString());
                continue;
            }
            if (!fieldArray[n].getName().endsWith("_BEGIN") || !fieldArray[n - 1].getName().endsWith("_END") || fieldArray[n - 1].getInt(null) + 1 == fieldArray[n].getInt(null)) continue;
            System.err.println(new StringBuffer().append("distance: ").append(fieldArray[n - 1].getName()).append(" - ").append(fieldArray[n].getName()).append(" wrong").toString());
        }
    }

    public static void main(String[] stringArray) {
        ASLFactoryBase.checkRanges(class$de$vw$mib$asl$framework$api$framework$ASLServiceIdRanges == null ? (class$de$vw$mib$asl$framework$api$framework$ASLServiceIdRanges = ASLFactoryBase.class$("de.vw.mib.asl.framework.api.framework.ASLServiceIdRanges")) : class$de$vw$mib$asl$framework$api$framework$ASLServiceIdRanges);
        ASLFactoryBase.checkRanges(class$de$vw$mib$asl$framework$api$framework$ASLTargetIdRanges == null ? (class$de$vw$mib$asl$framework$api$framework$ASLTargetIdRanges = ASLFactoryBase.class$("de.vw.mib.asl.framework.api.framework.ASLTargetIdRanges")) : class$de$vw$mib$asl$framework$api$framework$ASLTargetIdRanges);
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
        apiRegistry = new HashMap();
    }
}

