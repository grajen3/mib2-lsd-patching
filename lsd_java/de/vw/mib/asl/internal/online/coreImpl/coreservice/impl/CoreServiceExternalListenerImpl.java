/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.impl;

import de.vw.mib.asl.internal.online.coreImpl.coreservice.CoreServiceImplFactory;
import de.vw.mib.asl.internal.online.coreInterfaces.external.CoreServiceExternalListener;
import org.dsi.ifc.global.ResourceLocator;

public class CoreServiceExternalListenerImpl
implements CoreServiceExternalListener {
    @Override
    public void getServiceURLResponse(String string, String string2, int n) {
        CoreServiceImplFactory.getURLHandler().responseServiceURLInfo(n, string, string2);
    }

    @Override
    public void downloadImageResponse(String string, String string2, String string3, ResourceLocator resourceLocator, int n) {
        CoreServiceImplFactory.getLogoHandler().downloadImageResponse(string, string2, string3, resourceLocator, n);
    }

    @Override
    public void calculateSPinHashResponse(String string, String string2, String string3, String string4, int n, String string5, int n2) {
        CoreServiceImplFactory.getAuthentication().calculateSpinHashResponse(string, string2, string3, string4, n, string5, n2);
    }

    @Override
    public void setSPinResponse(String string, int n, int n2) {
        CoreServiceImplFactory.getAuthentication().setSPinResponse(string, n, n2);
    }
}

