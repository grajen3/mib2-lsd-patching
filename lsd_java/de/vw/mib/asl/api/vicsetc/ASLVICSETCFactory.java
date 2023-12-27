/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.vicsetc;

import de.vw.mib.asl.api.vicsetc.ASLVICSETCAPI;
import de.vw.mib.asl.framework.api.framework.ASLFactoryBase;

public class ASLVICSETCFactory
extends ASLFactoryBase {
    private static ASLVICSETCAPI apiInstance = null;
    static /* synthetic */ Class class$de$vw$mib$asl$api$vicsetc$ASLVICSETCFactory;
    static /* synthetic */ Class class$de$vw$mib$asl$api$vicsetc$ASLVICSETCAPI;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static ASLVICSETCAPI getVICSETCApi() {
        Class clazz = class$de$vw$mib$asl$api$vicsetc$ASLVICSETCFactory == null ? (class$de$vw$mib$asl$api$vicsetc$ASLVICSETCFactory = ASLVICSETCFactory.class$("de.vw.mib.asl.api.vicsetc.ASLVICSETCFactory")) : class$de$vw$mib$asl$api$vicsetc$ASLVICSETCFactory;
        synchronized (clazz) {
            if (apiInstance == null) {
                apiInstance = (ASLVICSETCAPI)ASLVICSETCFactory.createServiceInstance(class$de$vw$mib$asl$api$vicsetc$ASLVICSETCAPI == null ? (class$de$vw$mib$asl$api$vicsetc$ASLVICSETCAPI = ASLVICSETCFactory.class$("de.vw.mib.asl.api.vicsetc.ASLVICSETCAPI")) : class$de$vw$mib$asl$api$vicsetc$ASLVICSETCAPI, "de.vw.mib.asl.internal.vicsetc.api.impl.ASLVICSETCAPIImpl");
            }
            return apiInstance;
        }
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

