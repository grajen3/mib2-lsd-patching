/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mirrorlink.transformer;

import de.vw.mib.asl.internal.mirrorlink.transformer.MirrorLinkSoftKeyListCollector;
import generated.de.vw.mib.asl.internal.mirrorlink.transformer.AbstractMirrorlinkSoftbuttonListTransformer;

public class MirrorlinkSoftbuttonListTransformer
extends AbstractMirrorlinkSoftbuttonListTransformer {
    @Override
    public int getInt(int n, Object object) {
        MirrorLinkSoftKeyListCollector mirrorLinkSoftKeyListCollector = (MirrorLinkSoftKeyListCollector)object;
        if (mirrorLinkSoftKeyListCollector != null && n == 0) {
            return mirrorLinkSoftKeyListCollector.getType();
        }
        return 0;
    }
}

