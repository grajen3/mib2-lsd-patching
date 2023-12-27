/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.nav.appui.internal;

import de.vw.mib.appui.cio.AbstractCioVisualizationService;
import de.vw.mib.cio.CioIntentVisualizationImpl;
import de.vw.mib.cio.framework.CioIdService;
import de.vw.mib.cio.framework.CioIntentVisualization;
import generated.de.vw.mib.global.datapool.SkinDataPool;

public class NavCioVisualizationService
extends AbstractCioVisualizationService {
    private static final int V_MENU_ACTION_NAV__VISUALIZATION_NAV_FAV_BUTTON;
    private static final int V_MENU_ACTION_NAV__VISUALIZATION_NAV_MENU_BUTTON;
    private static final int V_MENU_ACTION_TRAFFIC__VISUALIZATION_TRAFFIC_FAV_BUTTON;
    private static final int V_MENU_ACTION_TRAFFIC__VISUALIZATION_TRAFFIC_MENU_BUTTON;
    private static final int COUNT;

    public NavCioVisualizationService(String string) {
        super("Nav", string, 4);
    }

    @Override
    protected void loadMapping(CioIdService cioIdService) {
        this.putIndexIdMapping(0, cioIdService, "MenuActionNav", "VisualizationNavFavButton");
        this.putIndexIdMapping(1, cioIdService, "MenuActionNav", "VisualizationNavMenuButton");
        this.putIndexIdMapping(2, cioIdService, "MenuActionTraffic", "VisualizationTrafficFavButton");
        this.putIndexIdMapping(3, cioIdService, "MenuActionTraffic", "VisualizationTrafficMenuButton");
    }

    @Override
    protected CioIntentVisualization getVisualizationByIndex(int n) {
        switch (n) {
            case 0: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(36)), SkinDataPool.getColorVector(73), SkinDataPool.getColorVector(72), null, null, null);
            }
            case 1: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(37)), SkinDataPool.getColorVector(75), SkinDataPool.getColorVector(74), this.getI18nString(1754), null, null);
            }
            case 2: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(40)), SkinDataPool.getColorVector(81), SkinDataPool.getColorVector(80), null, null, null);
            }
            case 3: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(41)), SkinDataPool.getColorVector(83), SkinDataPool.getColorVector(82), this.getI18nString(1755), null, null);
            }
        }
        return this.visualizationNotAvailable();
    }
}

