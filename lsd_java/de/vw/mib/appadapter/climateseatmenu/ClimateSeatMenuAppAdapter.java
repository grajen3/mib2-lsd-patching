/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.climateseatmenu;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.climateseatmenu.ClimateSeatMenuControlService;
import de.vw.mib.appadapter.climateseatmenu.ExtraCodriverSettingService;
import de.vw.mib.appadapter.climateseatmenu.ExtraHeadrestPositionService;
import de.vw.mib.appadapter.climateseatmenu.ExtraRearSeatClimateService;
import de.vw.mib.appadapter.climateseatmenu.ExtraRestingPositionService;
import de.vw.mib.appadapter.climateseatmenu.ExtraTidyUpService;
import de.vw.mib.appadapter.climateseatmenu.GeneralService;
import de.vw.mib.appadapter.climateseatmenu.HeatingVentingBalanceService;
import de.vw.mib.appadapter.climateseatmenu.MassageService;
import de.vw.mib.appadapter.climateseatmenu.PositionService;
import de.vw.mib.appadapter.climateseatmenu.SetupService;
import de.vw.mib.cio.CioExecutor;

public class ClimateSeatMenuAppAdapter
extends AbstractAppAdapter {
    public static final int SEAT_INSTANCE_LEFT;
    public static final int SEAT_INSTANCE_RIGHT;
    public static final int SEAT_CUSHION_DEPTH;
    public static final int LATERAL_CUSHION;
    public static final int LATERAL_BACK;
    public static final int UPPER_SEAT_BACK;
    private HeatingVentingBalanceService heatingVentingBalanceService;
    private MassageService massageService;
    private SetupService setupService;
    private ClimateSeatMenuControlService climateSeatMenuControlService;
    private ExtraRestingPositionService extraRestingPositionService;
    private ExtraHeadrestPositionService extraHeadrestPositionService;
    private ExtraCodriverSettingService extraCodriverSettingService;
    private ExtraTidyUpService extraTidyUpService;
    private ExtraRearSeatClimateService extraRearSeatClimateService;
    private GeneralService generalService;
    private PositionService positionService;
    private ModelApiService[] apiServices;

    public ClimateSeatMenuAppAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
    }

    private HeatingVentingBalanceService getHeatingVentingBalanceService() {
        if (this.heatingVentingBalanceService == null) {
            this.heatingVentingBalanceService = new HeatingVentingBalanceService(this.systemServices);
        }
        return this.heatingVentingBalanceService;
    }

    private ClimateSeatMenuControlService getClimateSeatMenuControlService() {
        if (this.climateSeatMenuControlService == null) {
            this.climateSeatMenuControlService = new ClimateSeatMenuControlService(this.systemServices);
        }
        return this.climateSeatMenuControlService;
    }

    private MassageService getMassageService() {
        if (this.massageService == null) {
            this.massageService = new MassageService(this.systemServices);
        }
        return this.massageService;
    }

    private SetupService getSetupService() {
        if (this.setupService == null) {
            this.setupService = new SetupService(this.systemServices);
        }
        return this.setupService;
    }

    private ExtraRestingPositionService getExtraRestingPositionService() {
        if (this.extraRestingPositionService == null) {
            this.extraRestingPositionService = new ExtraRestingPositionService(this.systemServices);
        }
        return this.extraRestingPositionService;
    }

    private PositionService getPositionService() {
        if (this.positionService == null) {
            this.positionService = new PositionService(this.systemServices);
        }
        return this.positionService;
    }

    private GeneralService getGeneralService() {
        if (this.generalService == null) {
            this.generalService = new GeneralService(this.systemServices);
        }
        return this.generalService;
    }

    private ExtraHeadrestPositionService getExtraHeadrestPositionService() {
        if (this.extraHeadrestPositionService == null) {
            this.extraHeadrestPositionService = new ExtraHeadrestPositionService(this.systemServices);
        }
        return this.extraHeadrestPositionService;
    }

    private ExtraCodriverSettingService getExtraCodriverSettingService() {
        if (this.extraCodriverSettingService == null) {
            this.extraCodriverSettingService = new ExtraCodriverSettingService(this.systemServices);
        }
        return this.extraCodriverSettingService;
    }

    private ExtraTidyUpService getExtraTidyUpService() {
        if (this.extraTidyUpService == null) {
            this.extraTidyUpService = new ExtraTidyUpService(this.systemServices);
        }
        return this.extraTidyUpService;
    }

    private ExtraRearSeatClimateService getExtraRearSeatClimateService() {
        if (this.extraRearSeatClimateService == null) {
            this.extraRearSeatClimateService = new ExtraRearSeatClimateService(this.systemServices);
        }
        return this.extraRearSeatClimateService;
    }

    @Override
    public CioExecutor getCioExecutor() {
        return this.getClimateSeatMenuControlService();
    }

    @Override
    public ModelApiService[] getModelApiServices() {
        if (this.apiServices == null) {
            this.apiServices = new ModelApiService[]{this.getHeatingVentingBalanceService(), this.getClimateSeatMenuControlService(), this.getMassageService(), this.getSetupService(), this.getExtraRestingPositionService(), this.getExtraHeadrestPositionService(), this.getGeneralService(), this.getPositionService(), this.getExtraCodriverSettingService(), this.getExtraTidyUpService(), this.getExtraRearSeatClimateService()};
        }
        return this.apiServices;
    }

    @Override
    public void init(int n, String string) {
    }

    @Override
    public void ready() {
    }

    @Override
    public void start() {
        this.getClimateSeatMenuControlService().start();
        this.getHeatingVentingBalanceService().start();
        this.getMassageService().start();
        this.getSetupService().start();
        this.getExtraHeadrestPositionService().start();
        this.getExtraRestingPositionService().start();
        this.getGeneralService().start();
        this.getPositionService().start();
        this.getExtraCodriverSettingService().start();
        this.getExtraTidyUpService().start();
        this.getExtraRearSeatClimateService().start();
    }

    @Override
    public void stop() {
    }
}

