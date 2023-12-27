/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc.fmtext.transformer;

import generated.de.vw.mib.asl.internal.vicsetc.fmtext.transformer.AbstractVICSETCFmTextMessageImagesRLTransformer;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;
import org.dsi.ifc.global.ResourceLocator;

public class VICSETCFmTextMessageImagesRLTransformer
extends AbstractVICSETCFmTextMessageImagesRLTransformer {
    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        if (n == 0) {
            ResourceInformation resourceInformation = (ResourceInformation)object;
            return resourceInformation.resourceLocator;
        }
        throw new IllegalArgumentException();
    }
}

