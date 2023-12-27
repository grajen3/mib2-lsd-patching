/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mirrorlink.transformer;

import de.vw.mib.asl.internal.mirrorlink.transformer.MirrorLinkAppListCollector;
import generated.de.vw.mib.asl.internal.mirrorlink.transformer.AbstractMirrorlinkAppListTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class MirrorlinkAppListTransformer
extends AbstractMirrorlinkAppListTransformer {
    @Override
    public boolean getBoolean(int n, Object object) {
        MirrorLinkAppListCollector mirrorLinkAppListCollector = (MirrorLinkAppListCollector)object;
        if (mirrorLinkAppListCollector != null) {
            if (n == 1) {
                return mirrorLinkAppListCollector.isCertifiedApp();
            }
            if (n == 3) {
                return !mirrorLinkAppListCollector.isNotLaunchableRegion();
            }
        }
        return false;
    }

    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        MirrorLinkAppListCollector mirrorLinkAppListCollector = (MirrorLinkAppListCollector)object;
        if (mirrorLinkAppListCollector != null && n == 0) {
            return mirrorLinkAppListCollector.getImageResourceLocator();
        }
        return new ResourceLocator();
    }

    @Override
    public String getString(int n, Object object) {
        MirrorLinkAppListCollector mirrorLinkAppListCollector = (MirrorLinkAppListCollector)object;
        if (mirrorLinkAppListCollector != null && n == 2) {
            return mirrorLinkAppListCollector.getApplicationName();
        }
        return "";
    }
}

