/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal;

import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAdapter;
import de.vw.mib.has.HAS;
import de.vw.mib.log4mib.Logger;

public class HASComponentImpl
extends ASLComponentAdapter {
    private static final String COMPONENT_NAME;
    private Services services;
    static /* synthetic */ Class class$de$vw$mib$has$HASAPI;

    @Override
    public String getName() {
        return "HAS";
    }

    @Override
    public void init(Logger logger, Services services) {
        this.services = services;
    }

    @Override
    public void start() {
        this.services.getASLComponentRegistry().registerAPI(class$de$vw$mib$has$HASAPI == null ? (class$de$vw$mib$has$HASAPI = HASComponentImpl.class$("de.vw.mib.has.HASAPI")) : class$de$vw$mib$has$HASAPI, HAS.getInstance());
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

