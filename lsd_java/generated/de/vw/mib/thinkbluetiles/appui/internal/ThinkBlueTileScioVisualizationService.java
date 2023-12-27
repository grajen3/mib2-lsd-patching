/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.thinkbluetiles.appui.internal;

import de.vw.mib.appui.cio.AbstractCioVisualizationService;
import de.vw.mib.cio.CioIntentVisualizationImpl;
import de.vw.mib.cio.framework.CioIdService;
import de.vw.mib.cio.framework.CioIntentVisualization;
import generated.de.vw.mib.global.datapool.SkinDataPool;

public class ThinkBlueTileScioVisualizationService
extends AbstractCioVisualizationService {
    private static final int V_CREATE_HOSTED_APP__THINK_BLUE_TILE_SBACK;
    private static final int V_THINK_BLUE_TILE_SHEADER_BUTTON_ACTION__THINK_BLUE_TILE_SHEADER;
    private static final int COUNT;

    public ThinkBlueTileScioVisualizationService(String string) {
        super("ThinkBlueTileS", string, 2);
    }

    @Override
    protected void loadMapping(CioIdService cioIdService) {
        this.putIndexIdMapping(0, cioIdService, "CreateHostedApp", "ThinkBlueTileSBack");
        this.putIndexIdMapping(1, cioIdService, "ThinkBlueTileSHeaderButtonAction", "ThinkBlueTileSHeader");
    }

    @Override
    protected CioIntentVisualization getVisualizationByIndex(int n) {
        switch (n) {
            case 0: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(18)), SkinDataPool.getColorVector(37), SkinDataPool.getColorVector(36), this.getI18nString(5033), null, null);
            }
            case 1: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(54)), SkinDataPool.getColorVector(109), SkinDataPool.getColorVector(108), this.getI18nString(5033), null, null);
            }
        }
        return this.visualizationNotAvailable();
    }
}

