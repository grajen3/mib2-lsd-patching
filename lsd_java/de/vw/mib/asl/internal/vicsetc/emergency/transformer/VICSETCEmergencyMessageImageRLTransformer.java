/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc.emergency.transformer;

import generated.de.vw.mib.asl.internal.vicsetc.emergency.transformer.AbstractVICSETCEmergencyMessageImageRLTransformer;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;
import org.dsi.ifc.global.ResourceLocator;

public class VICSETCEmergencyMessageImageRLTransformer
extends AbstractVICSETCEmergencyMessageImageRLTransformer {
    @Override
    public ResourceLocator getResourceLocator(int n, Object object) {
        if (n == 0) {
            ResourceInformation resourceInformation = (ResourceInformation)object;
            return resourceInformation.resourceLocator;
        }
        throw new IllegalArgumentException();
    }
}

