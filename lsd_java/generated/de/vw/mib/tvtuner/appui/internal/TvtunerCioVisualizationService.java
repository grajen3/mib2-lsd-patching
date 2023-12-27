/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.tvtuner.appui.internal;

import de.vw.mib.appui.cio.AbstractCioVisualizationService;
import de.vw.mib.cio.CioIntentVisualizationImpl;
import de.vw.mib.cio.framework.CioIdService;
import de.vw.mib.cio.framework.CioIntentVisualization;
import generated.de.vw.mib.global.datapool.SkinDataPool;

public class TvtunerCioVisualizationService
extends AbstractCioVisualizationService {
    private static final int V_MENU_ACTION__VISUALIZATION_TVTUNER_BUTTON;
    private static final int V_MENU_ACTION__VISUALIZATION_TVTUNER_FAV_BUTTON;
    private static final int COUNT;

    public TvtunerCioVisualizationService(String string) {
        super("TVTuner", string, 2);
    }

    @Override
    protected void loadMapping(CioIdService cioIdService) {
        this.putIndexIdMapping(0, cioIdService, "MenuAction", "VisualizationTVTunerButton");
        this.putIndexIdMapping(1, cioIdService, "MenuAction", "VisualizationTVTunerFavButton");
    }

    @Override
    protected CioIntentVisualization getVisualizationByIndex(int n) {
        switch (n) {
            case 0: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(44)), SkinDataPool.getColorVector(89), SkinDataPool.getColorVector(88), this.getI18nString(1884), null, null);
            }
            case 1: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(45)), SkinDataPool.getColorVector(91), SkinDataPool.getColorVector(90), this.getI18nString(1884), null, null);
            }
        }
        return this.visualizationNotAvailable();
    }
}

