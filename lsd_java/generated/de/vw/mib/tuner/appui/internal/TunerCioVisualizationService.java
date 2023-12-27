/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.tuner.appui.internal;

import de.vw.mib.appui.cio.AbstractCioVisualizationService;
import de.vw.mib.cio.CioIntentVisualizationImpl;
import de.vw.mib.cio.framework.CioIdService;
import de.vw.mib.cio.framework.CioIntentVisualization;
import generated.de.vw.mib.global.datapool.SkinDataPool;

public class TunerCioVisualizationService
extends AbstractCioVisualizationService {
    private static final int V_MENU_ACTION__VISUALIZATION_RADIO_FAV_BUTTON;
    private static final int V_MENU_ACTION__VISUALIZATION_RADIO_MENU_BUTTON;
    private static final int COUNT;

    public TunerCioVisualizationService(String string) {
        super("Tuner", string, 2);
    }

    @Override
    protected void loadMapping(CioIdService cioIdService) {
        this.putIndexIdMapping(0, cioIdService, "MenuAction", "VisualizationRadioFavButton");
        this.putIndexIdMapping(1, cioIdService, "MenuAction", "VisualizationRadioMenuButton");
    }

    @Override
    protected CioIntentVisualization getVisualizationByIndex(int n) {
        switch (n) {
            case 0: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(42)), SkinDataPool.getColorVector(85), SkinDataPool.getColorVector(84), null, null, null);
            }
            case 1: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(43)), SkinDataPool.getColorVector(87), SkinDataPool.getColorVector(86), this.getI18nString(6222), null, null);
            }
        }
        return this.visualizationNotAvailable();
    }
}

