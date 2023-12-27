/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.clients.model.transformer;

import de.vw.mib.asl.internal.online.clients.model.common.CoreServiceModelMap;
import de.vw.mib.asl.internal.online.clients.model.common.OnlineServicePackage;

public class CoreServiceModelServicePackageTransformer {
    public boolean getBoolean(int n, Object object) {
        return false;
    }

    public String getString(int n, Object object) {
        return "";
    }

    public int getInt(int n, Object object) {
        OnlineServicePackage onlineServicePackage = (OnlineServicePackage)object;
        switch (n) {
            case 0: {
                return CoreServiceModelMap.getModelPackageID(onlineServicePackage.getPackageID());
            }
            case 1: {
                return onlineServicePackage.getPackageState();
            }
        }
        throw new IllegalArgumentException();
    }
}

