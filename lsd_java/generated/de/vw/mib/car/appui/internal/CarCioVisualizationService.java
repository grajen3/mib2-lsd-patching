/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.car.appui.internal;

import de.vw.mib.appui.cio.AbstractCioVisualizationService;
import de.vw.mib.cio.CioIntentVisualizationImpl;
import de.vw.mib.cio.framework.CioIdService;
import de.vw.mib.cio.framework.CioIntentVisualization;
import generated.de.vw.mib.global.datapool.SkinDataPool;

public class CarCioVisualizationService
extends AbstractCioVisualizationService {
    private static final int V_MENU_ACTION__VISUALIZATION_CAR_FAV_BUTTON;
    private static final int V_MENU_ACTION__VISUALIZATION_CAR_HYBRID_FAV_BUTTON;
    private static final int V_MENU_ACTION__VISUALIZATION_CAR_HYBRID_MENU_BUTTON;
    private static final int V_MENU_ACTION__VISUALIZATION_CAR_MENU_BUTTON;
    private static final int COUNT;

    public CarCioVisualizationService(String string) {
        super("Car", string, 4);
    }

    @Override
    protected void loadMapping(CioIdService cioIdService) {
        this.putIndexIdMapping(0, cioIdService, "MenuAction", "VisualizationCarFavButton");
        this.putIndexIdMapping(1, cioIdService, "MenuAction", "VisualizationCarHybridFavButton");
        this.putIndexIdMapping(2, cioIdService, "MenuAction", "VisualizationCarHybridMenuButton");
        this.putIndexIdMapping(3, cioIdService, "MenuAction", "VisualizationCarMenuButton");
    }

    @Override
    protected CioIntentVisualization getVisualizationByIndex(int n) {
        switch (n) {
            case 0: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(30)), SkinDataPool.getColorVector(61), SkinDataPool.getColorVector(60), null, null, null);
            }
            case 1: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(31)), SkinDataPool.getColorVector(63), SkinDataPool.getColorVector(62), null, null, null);
            }
            case 2: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(32)), SkinDataPool.getColorVector(65), SkinDataPool.getColorVector(64), this.getI18nString(71), null, null);
            }
            case 3: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(33)), SkinDataPool.getColorVector(67), SkinDataPool.getColorVector(66), this.getI18nString(72), null, null);
            }
        }
        return this.visualizationNotAvailable();
    }
}

