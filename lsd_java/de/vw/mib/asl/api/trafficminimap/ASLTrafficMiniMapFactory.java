/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.trafficminimap;

import de.vw.mib.asl.api.trafficminimap.ASLTrafficMiniMapAPI;
import de.vw.mib.asl.api.trafficminimap.ASLTrafficMiniMapServices;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLTrafficMiniMapFactory
extends ASLFactoryBase {
    private static ASLTrafficMiniMapAPI apiInstance = null;
    private static ASLTrafficMiniMapServices _services = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$trafficminimap$ASLTrafficMiniMapAPI;
    static /* synthetic */ Class class$de$vw$mib$asl$api$trafficminimap$ASLTrafficMiniMapServices;

    public static ASLTrafficMiniMapAPI getTrafficMiniMapApi() {
        if (apiInstance == null) {
            apiInstance = (ASLTrafficMiniMapAPI)ASLTrafficMiniMapFactory.createServiceInstance(class$de$vw$mib$asl$api$trafficminimap$ASLTrafficMiniMapAPI == null ? (class$de$vw$mib$asl$api$trafficminimap$ASLTrafficMiniMapAPI = ASLTrafficMiniMapFactory.class$("de.vw.mib.asl.api.trafficminimap.ASLTrafficMiniMapAPI")) : class$de$vw$mib$asl$api$trafficminimap$ASLTrafficMiniMapAPI, "de.vw.mib.asl.internal.trafficminimap.api.impl.ASLTrafficMiniMapAPIImpl");
        }
        return apiInstance;
    }

    public static ASLTrafficMiniMapServices getOnlineCoreServices() {
        if (_services == null) {
            String string = (class$de$vw$mib$asl$api$trafficminimap$ASLTrafficMiniMapServices == null ? (class$de$vw$mib$asl$api$trafficminimap$ASLTrafficMiniMapServices = ASLTrafficMiniMapFactory.class$("de.vw.mib.asl.api.trafficminimap.ASLTrafficMiniMapServices")) : class$de$vw$mib$asl$api$trafficminimap$ASLTrafficMiniMapServices).getName();
            int n = string.lastIndexOf(46);
            string = new StringBuffer().append("de.vw.mib.asl.internal.trafficminimap.control").append(string.substring(n)).append("Impl").toString();
            _services = (ASLTrafficMiniMapServices)ASLTrafficMiniMapFactory.createInstance(class$de$vw$mib$asl$api$trafficminimap$ASLTrafficMiniMapServices == null ? (class$de$vw$mib$asl$api$trafficminimap$ASLTrafficMiniMapServices = ASLTrafficMiniMapFactory.class$("de.vw.mib.asl.api.trafficminimap.ASLTrafficMiniMapServices")) : class$de$vw$mib$asl$api$trafficminimap$ASLTrafficMiniMapServices, string);
        }
        return _services;
    }

    private static Object createInstance(Class clazz, String string) {
        Object object = null;
        try {
            Class clazz2 = Class.forName(string);
            object = clazz2.newInstance();
        }
        catch (Exception exception) {
            object = null;
        }
        return object;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

