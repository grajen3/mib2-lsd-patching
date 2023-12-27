/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.transformer;

import de.vw.mib.asl.internal.online.common.uota.OnlineUotAPackage;
import generated.de.vw.mib.asl.internal.online.transformer.AbstractOnlineOnlineUpdatePackageListTransformer;

public class OnlineOnlineUpdatePackageListTransformer
extends AbstractOnlineOnlineUpdatePackageListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        OnlineUotAPackage onlineUotAPackage = (OnlineUotAPackage)object;
        switch (n) {
            case 2: {
                return onlineUotAPackage.isPackageEnabled();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int getInt(int n, Object object) {
        OnlineUotAPackage onlineUotAPackage = (OnlineUotAPackage)object;
        switch (n) {
            case 1: {
                return onlineUotAPackage.getPackageState();
            }
            case 3: {
                return onlineUotAPackage.getProgressState();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public String getString(int n, Object object) {
        OnlineUotAPackage onlineUotAPackage = (OnlineUotAPackage)object;
        switch (n) {
            case 0: {
                return onlineUotAPackage.getLabel();
            }
        }
        throw new IllegalArgumentException();
    }
}

