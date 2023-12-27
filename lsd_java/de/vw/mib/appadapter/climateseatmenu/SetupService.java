/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.climateseatmenu;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.seat.SeatService;
import de.vw.mib.asl.api.car.seat.SeatServiceListenerAdaptor;
import de.vw.mib.asl.api.car.seat.SeatSetupSetting;
import de.vw.mib.log4mib.Logger;
import generated.de.vw.mib.appadapter.climateseatmenu.SetupModelApiCallback;
import generated.de.vw.mib.appadapter.climateseatmenu.SetupModelApiService;

public class SetupService
extends SeatServiceListenerAdaptor
implements SetupModelApiService {
    private AppAdapterSystemServices systemServices;
    private Logger logger;
    private SetupModelApiCallback setupModelApiCallback;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$climateseatmenu$SetupModelApiCallback;

    public SetupService(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
        this.logger = this.systemServices.createLogger(256);
        this.setupModelApiCallback = (SetupModelApiCallback)this.systemServices.createModelApiClient(class$generated$de$vw$mib$appadapter$climateseatmenu$SetupModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$climateseatmenu$SetupModelApiCallback = SetupService.class$("generated.de.vw.mib.appadapter.climateseatmenu.SetupModelApiCallback")) : class$generated$de$vw$mib$appadapter$climateseatmenu$SetupModelApiCallback);
    }

    private SeatService getClimateSeatService() {
        return ASLCarFactory.getSeatApi().getSeatService();
    }

    @Override
    public void _mda_toggleActivateRadioKey() {
        SeatSetupSetting seatSetupSetting = this.getClimateSeatService().getSeatSetupSetting(this.getClimateSeatService().getSeatDriverPosition(), 2);
        this.getClimateSeatService().changeSeatSetupSetting(seatSetupSetting.modifySeatSetupSettingValue(!seatSetupSetting.getSeatSettingValue()));
    }

    @Override
    public void _mda_toggleCodriversSeat() {
        SeatSetupSetting seatSetupSetting = this.getClimateSeatService().getSeatSetupSetting(this.getClimateSeatService().getSeatFrontPassengerPosition(), 3);
        this.getClimateSeatService().changeSeatSetupSetting(seatSetupSetting.modifySeatSetupSettingValue(!seatSetupSetting.getSeatSettingValue()));
    }

    @Override
    public void _mda_toggleDriversSeat() {
        SeatSetupSetting seatSetupSetting = this.getClimateSeatService().getSeatSetupSetting(this.getClimateSeatService().getSeatDriverPosition(), 3);
        this.getClimateSeatService().changeSeatSetupSetting(seatSetupSetting.modifySeatSetupSettingValue(!seatSetupSetting.getSeatSettingValue()));
    }

    @Override
    public void _mda_toggleEasyEntryDriver() {
        SeatSetupSetting seatSetupSetting = this.getClimateSeatService().getSeatSetupSetting(this.getClimateSeatService().getSeatDriverPosition(), 1);
        this.getClimateSeatService().changeSeatSetupSetting(seatSetupSetting.modifySeatSetupSettingValue(!seatSetupSetting.getSeatSettingValue()));
    }

    @Override
    public void _mda_toggleEasyExitCodriver() {
        SeatSetupSetting seatSetupSetting = this.getClimateSeatService().getSeatSetupSetting(this.getClimateSeatService().getSeatFrontPassengerPosition(), 1);
        this.getClimateSeatService().changeSeatSetupSetting(seatSetupSetting.modifySeatSetupSettingValue(!seatSetupSetting.getSeatSettingValue()));
    }

    @Override
    public void _mda_toggleEasyExitRear() {
        SeatSetupSetting seatSetupSetting = this.getClimateSeatService().getSeatSetupSetting(2, 1);
        this.getClimateSeatService().changeSeatSetupSetting(seatSetupSetting.modifySeatSetupSettingValue(!seatSetupSetting.getSeatSettingValue()));
        SeatSetupSetting seatSetupSetting2 = this.getClimateSeatService().getSeatSetupSetting(3, 1);
        this.getClimateSeatService().changeSeatSetupSetting(seatSetupSetting2.modifySeatSetupSettingValue(!seatSetupSetting2.getSeatSettingValue()));
    }

    @Override
    public void _mda_toggleRearSeatAtCodriversSide() {
        int n = this.getClimateSeatService().getSeatFrontPassengerPosition() == 1 ? 3 : 2;
        SeatSetupSetting seatSetupSetting = this.getClimateSeatService().getSeatSetupSetting(n, 3);
        this.getClimateSeatService().changeSeatSetupSetting(seatSetupSetting.modifySeatSetupSettingValue(!seatSetupSetting.getSeatSettingValue()));
    }

    @Override
    public void _mda_toggleRearSeatAtDriversSide() {
        int n = this.getClimateSeatService().getSeatDriverPosition() == 0 ? 2 : 3;
        SeatSetupSetting seatSetupSetting = this.getClimateSeatService().getSeatSetupSetting(n, 3);
        this.getClimateSeatService().changeSeatSetupSetting(seatSetupSetting.modifySeatSetupSettingValue(!seatSetupSetting.getSeatSettingValue()));
    }

    @Override
    public void updateSeatSetupSetting(SeatSetupSetting seatSetupSetting) {
        if (seatSetupSetting != null) {
            switch (seatSetupSetting.getSeatSettingType()) {
                case 1: {
                    this.setEasyEntryAndExit(seatSetupSetting);
                    break;
                }
                case 2: {
                    this.setupModelApiCallback._update_isActivateRadioKeyActive(seatSetupSetting.getSeatSettingValue());
                    break;
                }
                case 3: {
                    this.setSeatBeltPretension(seatSetupSetting);
                    break;
                }
                case 0: {
                    this.logger.error(256).append("updateSeatSetupSetting: SEAT_SETTINGS_TYPE_UNKOWN").log();
                    break;
                }
                default: {
                    this.logger.error(256).append("updateSeatSetupSetting: Not a valid type: ").append(seatSetupSetting.getSeatSettingType()).log();
                    break;
                }
            }
        } else {
            this.logger.error(256).append("SeatSetupSetting object is null!").log();
        }
    }

    private void setEasyEntryAndExit(SeatSetupSetting seatSetupSetting) {
        switch (seatSetupSetting.getSeatPosition()) {
            case 0: {
                this.setupModelApiCallback._update_isEasyEntryDriverActive(seatSetupSetting.getSeatSettingValue());
                break;
            }
            case 1: {
                this.setupModelApiCallback._update_isEasyExitCodriverActive(seatSetupSetting.getSeatSettingValue());
                break;
            }
            case 2: 
            case 3: {
                this.setupModelApiCallback._update_isEasyExitRearActive(seatSetupSetting.getSeatSettingValue());
                break;
            }
            default: {
                this.logger.error(256).append("SeatSetupSetting object is null!").log();
            }
        }
    }

    private void setSeatBeltPretension(SeatSetupSetting seatSetupSetting) {
        switch (seatSetupSetting.getSeatPosition()) {
            case 0: {
                this.setupModelApiCallback._update_isDriversSeatActive(seatSetupSetting.getSeatSettingValue());
                break;
            }
            case 1: {
                this.setupModelApiCallback._update_isCodriversSeatActive(seatSetupSetting.getSeatSettingValue());
                break;
            }
            case 2: {
                this.setupModelApiCallback._update_isRearSeatAtDriversSideActive(seatSetupSetting.getSeatSettingValue());
                break;
            }
            case 3: {
                this.setupModelApiCallback._update_isRearSeatAtCodriversActive(seatSetupSetting.getSeatSettingValue());
                break;
            }
            default: {
                this.logger.error(256).append("SeatSetupSetting object is null!").log();
            }
        }
    }

    public void start() {
        ASLCarFactory.getSeatApi().addSeatServiceListener(this);
        if (this.getClimateSeatService().getSeatMassageForAllZones() != null) {
            this.setupModelApiCallback._update_isEasyEntryDriverActive(this.getClimateSeatService().getSeatSetupSetting(this.getClimateSeatService().getSeatDriverPosition(), 1).getSeatSettingValue());
            this.setupModelApiCallback._update_isEasyExitCodriverActive(this.getClimateSeatService().getSeatSetupSetting(this.getClimateSeatService().getSeatFrontPassengerPosition(), 1).getSeatSettingValue());
            this.setupModelApiCallback._update_isEasyExitRearActive(this.getClimateSeatService().getSeatSetupSetting(2, 1).getSeatSettingValue());
            this.setupModelApiCallback._update_isActivateRadioKeyActive(this.getClimateSeatService().getSeatSetupSetting(this.getClimateSeatService().getSeatDriverPosition(), 2).getSeatSettingValue());
            this.setupModelApiCallback._update_isDriversSeatActive(this.getClimateSeatService().getSeatSetupSetting(this.getClimateSeatService().getSeatDriverPosition(), 3).getSeatSettingValue());
            this.setupModelApiCallback._update_isCodriversSeatActive(this.getClimateSeatService().getSeatSetupSetting(this.getClimateSeatService().getSeatFrontPassengerPosition(), 3).getSeatSettingValue());
            if (this.getClimateSeatService().getSeatDriverPosition() == 0) {
                this.setupModelApiCallback._update_isRearSeatAtDriversSideActive(this.getClimateSeatService().getSeatSetupSetting(2, 3).getSeatSettingValue());
                this.setupModelApiCallback._update_isRearSeatAtCodriversActive(this.getClimateSeatService().getSeatSetupSetting(3, 3).getSeatSettingValue());
            } else {
                this.setupModelApiCallback._update_isRearSeatAtDriversSideActive(this.getClimateSeatService().getSeatSetupSetting(3, 3).getSeatSettingValue());
                this.setupModelApiCallback._update_isRearSeatAtCodriversActive(this.getClimateSeatService().getSeatSetupSetting(2, 3).getSeatSettingValue());
            }
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

