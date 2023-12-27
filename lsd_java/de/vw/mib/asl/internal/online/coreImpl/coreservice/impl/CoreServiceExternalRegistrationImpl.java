/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreImpl.coreservice.impl;

import de.vw.mib.asl.internal.online.coreInterfaces.external.CoreServiceExternal;
import de.vw.mib.asl.internal.online.coreInterfaces.external.CoreServiceExternalRegistration;
import de.vw.mib.util.Util;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.util.ArrayList;

public class CoreServiceExternalRegistrationImpl
implements CoreServiceExternalRegistration {
    private ArrayList _externalList;

    private ArrayList getExternalList() {
        if (this._externalList == null) {
            this._externalList = new ArrayList();
        }
        return this._externalList;
    }

    @Override
    public void registerExternal(CoreServiceExternal coreServiceExternal) {
        if (coreServiceExternal != null) {
            this.getExternalList().add(coreServiceExternal);
        }
    }

    @Override
    public void unregisterExternal(CoreServiceExternal coreServiceExternal) {
        if (coreServiceExternal != null && !this.getExternalList().isEmpty()) {
            this.getExternalList().remove(coreServiceExternal);
        }
    }

    @Override
    public CoreServiceExternal[] getRegisteredExternals() {
        if (!this.getExternalList().isEmpty()) {
            int n = this.getExternalList().size();
            CoreServiceExternal[] coreServiceExternalArray = new CoreServiceExternal[n];
            for (int i2 = 0; i2 < n; ++i2) {
                coreServiceExternalArray[i2] = (CoreServiceExternal)this.getExternalList().get(i2);
            }
            return coreServiceExternalArray;
        }
        return null;
    }

    @Override
    public CoreServiceExternal[] getExternalsWithSupportedFunction(int n) {
        Object[] objectArray = this.getRegisteredExternals();
        if (n > 0 && !Util.isNullOrEmpty(objectArray)) {
            int n2 = objectArray.length;
            Object[] objectArray2 = null;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!objectArray[i2].isFuntionSupported(n)) continue;
                if (objectArray2 == null) {
                    objectArray2 = new CoreServiceExternal[]{objectArray[i2]};
                    continue;
                }
                objectArray2 = (CoreServiceExternal[])Arrays.copyOf(objectArray2, objectArray2.length + 1);
                objectArray2[objectArray2.length - 1] = objectArray[i2];
            }
            return objectArray2;
        }
        return null;
    }
}

