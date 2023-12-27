/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.climateseatmenu;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.climate.ClimateConfiguration;
import de.vw.mib.asl.api.car.climate.ClimateSeatHeaterBalance;
import de.vw.mib.asl.api.car.climate.ClimateSeatVentilatorBalance;
import de.vw.mib.asl.api.car.climate.ClimateService;
import de.vw.mib.asl.api.car.climate.ClimateServiceListenerAdaptor;
import de.vw.mib.log4mib.Logger;
import generated.de.vw.mib.appadapter.climateseatmenu.HeatingVentingBalanceModelApiCallback;
import generated.de.vw.mib.appadapter.climateseatmenu.HeatingVentingBalanceModelApiService;

public class HeatingVentingBalanceService
extends ClimateServiceListenerAdaptor
implements HeatingVentingBalanceModelApiService {
    private AppAdapterSystemServices systemServices;
    private Logger logger;
    private int modelApiInstance;
    private HeatingVentingBalanceModelApiCallback heatingVentingBalanceModelApiCallback;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$climateseatmenu$HeatingVentingBalanceModelApiCallback;

    public HeatingVentingBalanceService(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
        this.logger = this.systemServices.createLogger(256);
        this.modelApiInstance = this.systemServices.getAppInstanceId() == 0 ? 0 : 1;
        this.heatingVentingBalanceModelApiCallback = (HeatingVentingBalanceModelApiCallback)this.systemServices.createModelApiClient(class$generated$de$vw$mib$appadapter$climateseatmenu$HeatingVentingBalanceModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$climateseatmenu$HeatingVentingBalanceModelApiCallback = HeatingVentingBalanceService.class$("generated.de.vw.mib.appadapter.climateseatmenu.HeatingVentingBalanceModelApiCallback")) : class$generated$de$vw$mib$appadapter$climateseatmenu$HeatingVentingBalanceModelApiCallback);
    }

    private ClimateService getClimateSeatService() {
        return ASLCarFactory.getClimateApi().getClimateService();
    }

    void start() {
        if (this.logger.isTraceEnabled(256)) {
            this.logger.trace(256).append("HeatingVentingBalanceService started").log();
        }
        ASLCarFactory.getClimateApi().addClimateServiceListener(this);
        this.heatingVentingBalanceModelApiCallback._update_getSeatHeatingMaximum(3);
        this.heatingVentingBalanceModelApiCallback._update_getSeatHeatingMinimum(-3);
        this.heatingVentingBalanceModelApiCallback._update_getSeatVentingMaximum(3);
        this.heatingVentingBalanceModelApiCallback._update_getSeatVentingMinimum(-3);
        if (this.getClimateSeatService().isClimateServiceAvailable()) {
            this.informModelSeatHeating(this.getClimateSeatService().getSeatHeaterBalanceForZone(this.modelApiInstance));
        }
    }

    private void informModelSeatHeating(ClimateSeatHeaterBalance climateSeatHeaterBalance) {
        if (climateSeatHeaterBalance.getZoneMember() == this.modelApiInstance) {
            this.heatingVentingBalanceModelApiCallback._update_getSeatHeating(climateSeatHeaterBalance.getSeatHeatingBalance());
        }
    }

    private void informModelSeatVenting(ClimateSeatVentilatorBalance climateSeatVentilatorBalance) {
        if (climateSeatVentilatorBalance.getZoneMember() == this.modelApiInstance) {
            this.heatingVentingBalanceModelApiCallback._update_getSeatVenting(climateSeatVentilatorBalance.getSeatVentilationBalance());
        }
    }

    private void informModelSeatVentilatorBalanceAvailability(int n) {
        this.heatingVentingBalanceModelApiCallback._update_isSeatVentingAvailable(this.evaluateAvailability(n));
    }

    private void informModelSeatHeatingBalanceAvailability(int n) {
        this.heatingVentingBalanceModelApiCallback._update_isSeatHeatingAvailable(this.evaluateAvailability(n));
    }

    private boolean evaluateAvailability(int n) {
        boolean bl = false;
        bl = n == 2;
        return bl;
    }

    @Override
    public void _mda_setSeatHeating(int n) {
        if (this.getClimateSeatService().isClimateServiceAvailable()) {
            ClimateSeatHeaterBalance climateSeatHeaterBalance = this.getClimateSeatService().getSeatHeaterBalanceForZone(this.modelApiInstance);
            switch (n) {
                case 0: {
                    climateSeatHeaterBalance = climateSeatHeaterBalance.decreaseSeatHeaterBalance();
                    break;
                }
                case 1: {
                    climateSeatHeaterBalance = climateSeatHeaterBalance.increaseSeatHeaterBalance();
                    break;
                }
                default: {
                    this.logger.error(256).append("Wrong increaseDecrease value: ").append(n).log();
                }
            }
            this.getClimateSeatService().changeSeatHeaterBalance(climateSeatHeaterBalance);
        } else {
            this.logger.error(256).append("Climate Seat menu service is not available").log();
        }
    }

    @Override
    public void _mda_changeSeatHeating(int n) {
        if (this.getClimateSeatService().isClimateServiceAvailable()) {
            ClimateSeatHeaterBalance climateSeatHeaterBalance = this.getClimateSeatService().getSeatHeaterBalanceForZone(this.modelApiInstance);
            climateSeatHeaterBalance = climateSeatHeaterBalance.createSeatHeaterBalance(n);
            this.getClimateSeatService().changeSeatHeaterBalance(climateSeatHeaterBalance);
        } else {
            this.logger.error(256).append("Climate Seat Menu service is not available").log();
        }
    }

    @Override
    public void _mda_setSeatVenting(int n) {
        if (this.getClimateSeatService().isClimateServiceAvailable()) {
            ClimateSeatVentilatorBalance climateSeatVentilatorBalance = this.getClimateSeatService().getSeatVentilatorBalanceForZone(this.modelApiInstance);
            switch (n) {
                case 0: {
                    climateSeatVentilatorBalance = climateSeatVentilatorBalance.decreaseSeatVentilatorBalance();
                    break;
                }
                case 1: {
                    climateSeatVentilatorBalance = climateSeatVentilatorBalance.increaseSeatVentilatorBalance();
                    break;
                }
                default: {
                    this.logger.error(256).append("Wrong increaseDecrease value: ").append(n).log();
                }
            }
            this.getClimateSeatService().changeSeatVentilatorBalance(climateSeatVentilatorBalance);
        } else {
            this.logger.error(256).append("Climate Seat Menu service is not available").log();
        }
    }

    @Override
    public void _mda_changeSeatVenting(int n) {
        if (this.getClimateSeatService().isClimateServiceAvailable()) {
            ClimateSeatVentilatorBalance climateSeatVentilatorBalance = this.getClimateSeatService().getSeatVentilatorBalanceForZone(this.modelApiInstance);
            climateSeatVentilatorBalance = climateSeatVentilatorBalance.createSeatVentilatorBalance(n);
            this.getClimateSeatService().changeSeatVentilatorBalance(climateSeatVentilatorBalance);
        } else {
            this.logger.error(256).append("Climate Seat Menu service is not available").log();
        }
    }

    public void _mda_setSeatArmrest(int n) {
    }

    @Override
    public void _mda_changeSeatArmrest(int n) {
    }

    @Override
    public void updateClimateSeatHeaterBalance(ClimateSeatHeaterBalance climateSeatHeaterBalance) {
        if (climateSeatHeaterBalance != null) {
            this.informModelSeatHeating(climateSeatHeaterBalance);
        } else {
            this.logger.error(256).append("ClimateSeatHeaterBalance object is null!").log();
        }
    }

    @Override
    public void updateClimateSeatVentilatorBalance(ClimateSeatVentilatorBalance climateSeatVentilatorBalance) {
        if (climateSeatVentilatorBalance != null) {
            this.informModelSeatVenting(climateSeatVentilatorBalance);
        } else {
            this.logger.error(256).append("ClimateSeatVentilatorBalance object is null!").log();
        }
    }

    @Override
    public void updateClimateConfiguration(ClimateConfiguration climateConfiguration) {
        if (climateConfiguration != null) {
            this.informModelSeatVentilatorBalanceAvailability(climateConfiguration.getConfigurationOfZone(this.modelApiInstance).getSeatVentilationDistributionAvailability());
            this.informModelSeatHeatingBalanceAvailability(climateConfiguration.getConfigurationOfZone(this.modelApiInstance).getSeatHeaterDistributionAvailability());
        } else {
            this.logger.error(256).append("ClimateSeatVentilatorBalance object is null!").log();
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

