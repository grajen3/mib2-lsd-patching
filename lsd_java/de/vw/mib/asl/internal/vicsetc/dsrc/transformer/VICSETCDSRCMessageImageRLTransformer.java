/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc.dsrc.transformer;

import generated.de.vw.mib.asl.internal.vicsetc.dsrc.transformer.AbstractVICSETCDSRCMessageImageRLTransformer;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;
import org.dsi.ifc.global.ResourceLocator;

public class VICSETCDSRCMessageImageRLTransformer
extends AbstractVICSETCDSRCMessageImageRLTransformer {
    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        if (n == 0) {
            ResourceInformation resourceInformation = (ResourceInformation)object;
            return resourceInformation.resourceLocator;
        }
        throw new IllegalArgumentException();
    }
}

