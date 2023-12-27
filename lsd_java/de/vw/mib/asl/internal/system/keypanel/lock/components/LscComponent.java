/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.keypanel.lock.components;

import de.vw.mib.asl.internal.system.keypanel.lock.components.AbstractLockStateComponent;
import de.vw.mib.asl.internal.system.keypanel.lock.components.LscComponent$1;
import de.vw.mib.lsctng.LscUserInteractionFilterService;
import de.vw.mib.threads.AsyncServiceFactory;
import org.osgi.framework.BundleContext;

public class LscComponent
extends AbstractLockStateComponent {
    static /* synthetic */ Class class$de$vw$mib$lsctng$LscUserInteractionFilterService;

    public LscComponent(BundleContext bundleContext, AsyncServiceFactory asyncServiceFactory) {
        bundleContext.registerService((class$de$vw$mib$lsctng$LscUserInteractionFilterService == null ? (class$de$vw$mib$lsctng$LscUserInteractionFilterService = LscComponent.class$("de.vw.mib.lsctng.LscUserInteractionFilterService")) : class$de$vw$mib$lsctng$LscUserInteractionFilterService).getName(), (Object)this.createLscUserInteractionFilterService(asyncServiceFactory), null);
    }

    @Override
    protected boolean checkIsKeyApplicable(int n, int n2) {
        return true;
    }

    private LscUserInteractionFilterService createLscUserInteractionFilterService(AsyncServiceFactory asyncServiceFactory) {
        LscComponent$1 lscComponent$1 = new LscComponent$1(this);
        return (LscUserInteractionFilterService)asyncServiceFactory.create(lscComponent$1);
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

