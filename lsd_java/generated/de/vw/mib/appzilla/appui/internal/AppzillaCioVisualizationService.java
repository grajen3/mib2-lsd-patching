/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appzilla.appui.internal;

import de.vw.mib.appui.cio.AbstractCioVisualizationService;
import de.vw.mib.cio.framework.CioIdService;
import de.vw.mib.cio.framework.CioIntentVisualization;

public class AppzillaCioVisualizationService
extends AbstractCioVisualizationService {
    private static final int COUNT;

    public AppzillaCioVisualizationService(String string) {
        super("Appzilla", string, 0);
    }

    @Override
    protected void loadMapping(CioIdService cioIdService) {
    }

    @Override
    protected CioIntentVisualization getVisualizationByIndex(int n) {
        switch (n) {
            default: 
        }
        return this.visualizationNotAvailable();
    }
}

