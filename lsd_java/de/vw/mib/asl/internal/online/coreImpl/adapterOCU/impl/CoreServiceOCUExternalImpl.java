/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.adapterOCU.impl;

import de.vw.mib.asl.internal.online.coreImpl.adapterOCU.CoreServiceOCUFactory;
import de.vw.mib.asl.internal.online.coreImpl.adapterOCU.states.CoreServiceOCUTarget;
import de.vw.mib.asl.internal.online.coreInterfaces.external.CoreServiceExternal;
import de.vw.mib.asl.internal.online.coreInterfaces.external.CoreServiceExternalListener;
import de.vw.mib.util.Util;

public class CoreServiceOCUExternalImpl
implements CoreServiceExternal {
    final int[] SUPPORTED_FUNCTIONS = new int[]{3};
    private final CoreServiceOCUTarget _target;

    public CoreServiceOCUExternalImpl(CoreServiceOCUTarget coreServiceOCUTarget) {
        this._target = coreServiceOCUTarget;
    }

    @Override
    public void getServiceURL(String string, CoreServiceExternalListener coreServiceExternalListener) {
    }

    @Override
    public void downloadImage(String string, String string2, String string3, boolean bl, CoreServiceExternalListener coreServiceExternalListener) {
    }

    @Override
    public void setTrackingServicesUpdateValid(boolean bl) {
        CoreServiceOCUFactory.getController(this._target).setTrackingServicesUpdateRequired(bl);
    }

    @Override
    public void calculateSPinHash(String string, String string2, String string3, String string4, int n, CoreServiceExternalListener coreServiceExternalListener) {
    }

    @Override
    public void setSPin(String string, String string2, CoreServiceExternalListener coreServiceExternalListener) {
    }

    @Override
    public int[] getSupportedFunctions() {
        return this.SUPPORTED_FUNCTIONS;
    }

    @Override
    public boolean isFuntionSupported(int n) {
        if (!Util.isNullOrEmpty(this.SUPPORTED_FUNCTIONS)) {
            int n2 = this.SUPPORTED_FUNCTIONS.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (this.SUPPORTED_FUNCTIONS[i2] != n) continue;
                return true;
            }
        }
        return false;
    }
}

