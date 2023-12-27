/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.system;

import de.vw.mib.asl.api.system.ASLSystemAPI;
import de.vw.mib.asl.api.system.ASLSystemKeyPanelHandling;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;
import de.vw.mib.genericevents.GenericEvents;

public class ASLSystemFactory
extends ASLFactoryBase {
    private static final String SYSTEM_KEY_PANEL_HANDLING_CLASS_NAME;
    private static final Class[] SYSTEM_KEY_PANEL_HANDLING_PARAMETER_TYPES;
    private static ASLSystemAPI systemApiInstance;
    private static ASLSystemKeyPanelHandling systemKeyPanelHandlingInstance;
    static /* synthetic */ Class class$de$vw$mib$genericevents$GenericEvents;
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$de$vw$mib$asl$api$system$ASLSystemAPI;
    static /* synthetic */ Class class$de$vw$mib$asl$api$system$ASLSystemKeyPanelHandling;

    public static ASLSystemAPI getSystemApi() {
        if (systemApiInstance == null) {
            systemApiInstance = (ASLSystemAPI)ASLSystemFactory.createServiceInstance(class$de$vw$mib$asl$api$system$ASLSystemAPI == null ? (class$de$vw$mib$asl$api$system$ASLSystemAPI = ASLSystemFactory.class$("de.vw.mib.asl.api.system.ASLSystemAPI")) : class$de$vw$mib$asl$api$system$ASLSystemAPI, "de.vw.mib.asl.internal.system.api.impl.ASLSystemAPIImpl");
        }
        return systemApiInstance;
    }

    public static ASLSystemKeyPanelHandling getSystemKeyPanelHandling(GenericEvents genericEvents, int n, String string) {
        if (systemKeyPanelHandlingInstance == null) {
            systemKeyPanelHandlingInstance = (ASLSystemKeyPanelHandling)ASLSystemFactory.createServiceInstance(class$de$vw$mib$asl$api$system$ASLSystemKeyPanelHandling == null ? (class$de$vw$mib$asl$api$system$ASLSystemKeyPanelHandling = ASLSystemFactory.class$("de.vw.mib.asl.api.system.ASLSystemKeyPanelHandling")) : class$de$vw$mib$asl$api$system$ASLSystemKeyPanelHandling, "de.vw.mib.asl.internal.system.AslTargetSystemKeyPanelHandling", SYSTEM_KEY_PANEL_HANDLING_PARAMETER_TYPES, new Object[]{genericEvents, new Integer(n), string});
        }
        return systemKeyPanelHandlingInstance;
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
        SYSTEM_KEY_PANEL_HANDLING_PARAMETER_TYPES = new Class[]{class$de$vw$mib$genericevents$GenericEvents == null ? (class$de$vw$mib$genericevents$GenericEvents = ASLSystemFactory.class$("de.vw.mib.genericevents.GenericEvents")) : class$de$vw$mib$genericevents$GenericEvents, Integer.TYPE, class$java$lang$String == null ? (class$java$lang$String = ASLSystemFactory.class$("java.lang.String")) : class$java$lang$String};
        systemApiInstance = null;
        systemKeyPanelHandlingInstance = null;
    }
}

