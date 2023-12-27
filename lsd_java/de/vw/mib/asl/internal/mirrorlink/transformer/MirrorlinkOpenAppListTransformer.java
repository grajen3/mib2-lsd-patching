/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mirrorlink.transformer;

import de.vw.mib.asl.internal.mirrorlink.transformer.MirrorLinkAppListCollector;
import generated.de.vw.mib.asl.internal.mirrorlink.transformer.AbstractMirrorlinkOpenAppListTransformer;
import org.dsi.ifc.global.ResourceLocator;

public class MirrorlinkOpenAppListTransformer
extends AbstractMirrorlinkOpenAppListTransformer {
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
        if (mirrorLinkAppListCollector != null && n == 1) {
            return mirrorLinkAppListCollector.getApplicationName();
        }
        return "";
    }
}

