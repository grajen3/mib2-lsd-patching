/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc.popups.transformer;

import generated.de.vw.mib.asl.internal.vicsetc.popups.transformer.AbstractVICSETCPopupsMessageGraphicRLTransformer;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;
import org.dsi.ifc.global.ResourceLocator;

public class VICSETCPopupsMessageGraphicRLTransformer
extends AbstractVICSETCPopupsMessageGraphicRLTransformer {
    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        if (n == 0) {
            ResourceInformation resourceInformation = (ResourceInformation)object;
            return resourceInformation.resourceLocator;
        }
        throw new IllegalArgumentException();
    }
}

