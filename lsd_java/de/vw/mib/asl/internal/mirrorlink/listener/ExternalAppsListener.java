/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mirrorlink.listener;

import de.vw.mib.asl.api.exlap.ExlapService;
import de.vw.mib.asl.api.exlap.callback.ExlapExternalAppsUpdate;
import de.vw.mib.asl.framework.api.framework.component.ASLComponentAPICallbackAdapter;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.mirrorlink.target.MirrorLinkTarget;

public class ExternalAppsListener
extends ASLComponentAPICallbackAdapter
implements ExlapExternalAppsUpdate {
    private String className = "ExternalAppsListener";
    private MirrorLinkTarget target;
    private ExlapService service;
    private static ExternalAppsListener instance;
    private boolean lastAllowed = false;
    static /* synthetic */ Class class$de$vw$mib$asl$api$exlap$ExlapService;

    private ExternalAppsListener(MirrorLinkTarget mirrorLinkTarget) {
        this.target = mirrorLinkTarget;
        this.service = (ExlapService)ServiceManager.componentRegistry.getAPIInstance(class$de$vw$mib$asl$api$exlap$ExlapService == null ? (class$de$vw$mib$asl$api$exlap$ExlapService = ExternalAppsListener.class$("de.vw.mib.asl.api.exlap.ExlapService")) : class$de$vw$mib$asl$api$exlap$ExlapService);
        if (this.service == null) {
            ServiceManager.componentRegistry.requestAPI(class$de$vw$mib$asl$api$exlap$ExlapService == null ? (class$de$vw$mib$asl$api$exlap$ExlapService = ExternalAppsListener.class$("de.vw.mib.asl.api.exlap.ExlapService")) : class$de$vw$mib$asl$api$exlap$ExlapService, this);
        } else {
            this.service.registerExlapExternalAppsUpdates(this);
        }
    }

    public static ExternalAppsListener getInstance(MirrorLinkTarget mirrorLinkTarget) {
        if (instance == null) {
            instance = new ExternalAppsListener(mirrorLinkTarget);
        }
        return instance;
    }

    @Override
    public void onChange(boolean bl) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this.className).append(".onChange( ").append(bl).append(" )").log();
        }
        this.lastAllowed = bl;
        if (this.getTarget().isDSIAvailable()) {
            this.getTarget().getDSIMirrorLink().requestLocationDataServicesEnabled(bl);
        }
    }

    @Override
    public void registered(Class clazz, Object object) {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this.className).append(".registered()").log();
        }
        if (clazz.equals(class$de$vw$mib$asl$api$exlap$ExlapService == null ? (class$de$vw$mib$asl$api$exlap$ExlapService = ExternalAppsListener.class$("de.vw.mib.asl.api.exlap.ExlapService")) : class$de$vw$mib$asl$api$exlap$ExlapService)) {
            this.service = (ExlapService)object;
            this.service.registerExlapExternalAppsUpdates(this);
        }
    }

    public void forceResend() {
        if (this.getTarget().isTraceEnabled()) {
            this.getTarget().trace().append(this.className).append(".forceResend()").log();
        }
        if (this.getTarget().isDSIAvailable()) {
            this.getTarget().getDSIMirrorLink().requestLocationDataServicesEnabled(this.lastAllowed);
        }
    }

    private MirrorLinkTarget getTarget() {
        return this.target;
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

