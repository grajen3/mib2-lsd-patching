/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appui.dispatcher.internal;

import de.vw.mib.appui.cio.CioIdServiceUser;
import de.vw.mib.cio.framework.CioIdService;
import de.vw.mib.hmi.utils.OsgiUtil;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;

public class CioIdServiceListener
implements ServiceListener {
    private final CioIdServiceUser cioIdServiceUser;
    private final BundleContext bundleContext;
    private final String serviceName = (class$de$vw$mib$cio$framework$CioIdService == null ? (class$de$vw$mib$cio$framework$CioIdService = CioIdServiceListener.class$("de.vw.mib.cio.framework.CioIdService")) : class$de$vw$mib$cio$framework$CioIdService).getName();
    static /* synthetic */ Class class$de$vw$mib$cio$framework$CioIdService;

    public static void registerAsCioIdServiceListener(BundleContext bundleContext, CioIdServiceUser cioIdServiceUser) {
        new CioIdServiceListener(bundleContext, cioIdServiceUser);
    }

    CioIdServiceListener(BundleContext bundleContext, CioIdServiceUser cioIdServiceUser) {
        this.bundleContext = bundleContext;
        this.cioIdServiceUser = cioIdServiceUser;
        try {
            String string = new StringBuffer().append("(objectClass=").append(this.serviceName).append(")").toString();
            bundleContext.addServiceListener(this, string);
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
            throw new RuntimeException(invalidSyntaxException);
        }
    }

    @Override
    public void serviceChanged(ServiceEvent serviceEvent) {
        if (serviceEvent.getType() == 1 || serviceEvent.getType() == 2) {
            CioIdService cioIdService = (CioIdService)OsgiUtil.getService(this.bundleContext, this.serviceName);
            this.cioIdServiceUser.setCioIdService(cioIdService);
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

