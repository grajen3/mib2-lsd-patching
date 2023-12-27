/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.appconnecttilesmedia.appui.internal;

import de.vw.mib.appui.cio.AbstractCioVisualizationService;
import de.vw.mib.cio.CioIntentVisualizationImpl;
import de.vw.mib.cio.framework.CioIdService;
import de.vw.mib.cio.framework.CioIntentVisualization;
import generated.de.vw.mib.global.datapool.SkinDataPool;

public class AppConnectTileSmediaCioVisualizationService
extends AbstractCioVisualizationService {
    private static final int V_APP_CONNECT_TILE_SHEADER_BUTTON_ACTION__ANDROID_AUTO_TILE_HEADER;
    private static final int V_APP_CONNECT_TILE_SHEADER_BUTTON_ACTION__APP_CONNECT_TILE_HEADER;
    private static final int V_APP_CONNECT_TILE_SHEADER_BUTTON_ACTION__CAR_LIFE_TILE_HEADER;
    private static final int V_APP_CONNECT_TILE_SHEADER_BUTTON_ACTION__CAR_PLAY_TILE_HEADER;
    private static final int V_APP_CONNECT_TILE_SHEADER_BUTTON_ACTION__MIRRORLINK_TILE_HEADER;
    private static final int V_CREATE_HOSTED_APP__CREATE_HOSTED_APP_BIG_APP_CONNECT_VISUALIZATION;
    private static final int V_CREATE_HOSTED_APP__CREATE_HOSTED_APP_SMALL_APP_CONNECT_VISUALIZATION;
    private static final int COUNT;

    public AppConnectTileSmediaCioVisualizationService(String string) {
        super("AppConnectTileS", string, 7);
    }

    @Override
    protected void loadMapping(CioIdService cioIdService) {
        this.putIndexIdMapping(0, cioIdService, "AppConnectTileSHeaderButtonAction", "AndroidAutoTileHeader");
        this.putIndexIdMapping(1, cioIdService, "AppConnectTileSHeaderButtonAction", "AppConnectTileHeader");
        this.putIndexIdMapping(2, cioIdService, "AppConnectTileSHeaderButtonAction", "CarLifeTileHeader");
        this.putIndexIdMapping(3, cioIdService, "AppConnectTileSHeaderButtonAction", "CarPlayTileHeader");
        this.putIndexIdMapping(4, cioIdService, "AppConnectTileSHeaderButtonAction", "MirrorlinkTileHeader");
        this.putIndexIdMapping(5, cioIdService, "CreateHostedApp", "CreateHostedAppBigAppConnectVisualization");
        this.putIndexIdMapping(6, cioIdService, "CreateHostedApp", "CreateHostedAppSmallAppConnectVisualization");
    }

    @Override
    protected CioIntentVisualization getVisualizationByIndex(int n) {
        switch (n) {
            case 0: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(0)), SkinDataPool.getColorVector(1), SkinDataPool.getColorVector(0), this.getI18nString(1747), null, null);
            }
            case 1: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(1)), SkinDataPool.getColorVector(3), SkinDataPool.getColorVector(2), this.getI18nString(1748), null, null);
            }
            case 2: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(2)), SkinDataPool.getColorVector(5), SkinDataPool.getColorVector(4), this.getI18nString(1749), null, null);
            }
            case 3: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(3)), SkinDataPool.getColorVector(7), SkinDataPool.getColorVector(6), this.getI18nString(1750), null, null);
            }
            case 4: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(4)), SkinDataPool.getColorVector(9), SkinDataPool.getColorVector(8), this.getI18nString(1751), null, null);
            }
            case 5: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(9)), SkinDataPool.getColorVector(19), SkinDataPool.getColorVector(18), this.getI18nString(1748), null, null);
            }
            case 6: {
                return new CioIntentVisualizationImpl(null, this.getImageArray(SkinDataPool.getImageVector(10)), SkinDataPool.getColorVector(21), SkinDataPool.getColorVector(20), this.getI18nString(1748), null, null);
            }
        }
        return this.visualizationNotAvailable();
    }
}

