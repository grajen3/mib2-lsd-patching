/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.climateseatmenu;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.climate.ClimateConfiguration;
import de.vw.mib.asl.api.car.seat.SeatMassage;
import de.vw.mib.asl.api.car.seat.SeatService;
import de.vw.mib.asl.api.car.seat.SeatServiceListenerAdaptor;
import de.vw.mib.log4mib.Logger;
import generated.de.vw.mib.appadapter.climateseatmenu.MassageModelApiCallback;
import generated.de.vw.mib.appadapter.climateseatmenu.MassageModelApiService;

public class MassageService
extends SeatServiceListenerAdaptor
implements MassageModelApiService {
    private AppAdapterSystemServices systemServices;
    private Logger logger;
    private int modelApiInstance;
    private MassageModelApiCallback massageModelApiCallback;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$climateseatmenu$MassageModelApiCallback;

    public MassageService(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
        this.logger = this.systemServices.createLogger(256);
        this.modelApiInstance = this.systemServices.getAppInstanceId() == 0 ? 0 : 1;
        this.massageModelApiCallback = (MassageModelApiCallback)this.systemServices.createModelApiClient(class$generated$de$vw$mib$appadapter$climateseatmenu$MassageModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$climateseatmenu$MassageModelApiCallback = MassageService.class$("generated.de.vw.mib.appadapter.climateseatmenu.MassageModelApiCallback")) : class$generated$de$vw$mib$appadapter$climateseatmenu$MassageModelApiCallback);
    }

    private SeatService getClimateSeatService() {
        return ASLCarFactory.getSeatApi().getSeatService();
    }

    @Override
    public void updateSeatMassage(SeatMassage seatMassage) {
        if (seatMassage != null) {
            if (seatMassage.getSeatMassageZone() == this.modelApiInstance) {
                this.massageModelApiCallback._update_getSeatMassageActiveProgram(seatMassage.getSeatMassageProgram());
                this.massageModelApiCallback._update_getSeatMassageIntensity(seatMassage.getSeatMassageIntensity());
            } else if (seatMassage.getSeatMassageZone() == 2 || seatMassage.getSeatMassageZone() == 3) {
                this.massageModelApiCallback._update_getRearSeatMassageActiveProgram(seatMassage.getSeatMassageProgram());
                this.massageModelApiCallback._update_getRearSeatMassageIntensity(seatMassage.getSeatMassageIntensity());
            }
        } else {
            this.logger.error(256).append("SeatMassage object is null!").log();
        }
    }

    public void updateClimateConfiguration(ClimateConfiguration climateConfiguration) {
    }

    private int getSetSeatMassageProgramZone(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
        }
        return 0;
    }

    private int getChangeSeatMassageIntensityZone(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
        }
        return 0;
    }

    private int getSetSeatMassageIntensityZone(int n) {
        switch (n) {
            case 0: {
                return 0;
            }
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
        }
        return 0;
    }

    private int getClimateZoneFromRearZone(int n) {
        switch (n) {
            case 1: {
                return 2;
            }
            case 2: {
                return 3;
            }
        }
        return 0;
    }

    public void start() {
        ASLCarFactory.getSeatApi().addSeatServiceListener(this);
        this.massageModelApiCallback._update_getSeatMassageIntensityMaximum(5);
        this.massageModelApiCallback._update_getSeatMassageIntensityMinimum(1);
        if (this.getClimateSeatService().getSeatMassageForZone(this.modelApiInstance) != null) {
            this.massageModelApiCallback._update_getSeatMassageIntensity(this.getClimateSeatService().getSeatMassageForZone(this.modelApiInstance).getSeatMassageIntensity());
            this.massageModelApiCallback._update_getSeatMassageActiveProgram(this.getClimateSeatService().getSeatMassageForZone(this.modelApiInstance).getSeatMassageProgram());
        }
    }

    @Override
    public void _mda_changeSeatMassageIntensity(int n, int n2) {
        if (this.getClimateSeatService().getSeatMassageForZone(this.getChangeSeatMassageIntensityZone(n)) != null) {
            this.logger.error(256).append("_mda_changeSeatMassageIntensity ").append("intensity= ").append(n2).append("zone= ").append(this.getChangeSeatMassageIntensityZone(n)).log();
            this.getClimateSeatService().changeSeatMassage(this.getClimateSeatService().getSeatMassageForZone(this.getChangeSeatMassageIntensityZone(n)).modifySeatMassageIntensity(n2));
        } else {
            this.logger.error(256).append("getClimateSeatService().getSeatMassageForZone( ").append(this.getChangeSeatMassageIntensityZone(n)).append(" ) = null").log();
        }
    }

    @Override
    public void _mda_setSeatMassageIntensity(int n, int n2) {
        if (this.getClimateSeatService().getSeatMassageForZone(this.getSetSeatMassageIntensityZone(n)) != null) {
            switch (n2) {
                case 0: {
                    this.getClimateSeatService().changeSeatMassage(this.getClimateSeatService().getSeatMassageForZone(this.getSetSeatMassageIntensityZone(n)).decreaseMassageIntensity());
                    break;
                }
                case 1: {
                    this.getClimateSeatService().changeSeatMassage(this.getClimateSeatService().getSeatMassageForZone(this.getSetSeatMassageIntensityZone(n)).increaseMassageIntensity());
                    break;
                }
                default: {
                    this.logger.error(256).append("Wrong seatMassageIntensity value: ").append(n2).log();
                    break;
                }
            }
        } else {
            this.logger.error(256).append("SeatMassage = null").log();
        }
    }

    @Override
    public void _mda_setSeatMassageProgram(int n, int n2) {
        if (this.getClimateSeatService().getSeatMassageForZone(this.getSetSeatMassageProgramZone(n)) != null) {
            this.getClimateSeatService().changeSeatMassage(this.getClimateSeatService().getSeatMassageForZone(this.getSetSeatMassageProgramZone(n)).modifySeatMassageProgram(n2));
        } else {
            this.logger.error(256).append("SeatMassage = null").log();
        }
    }

    @Override
    public void _mda_setSeatZone(int n) {
        if (n == 0) {
            SeatMassage seatMassage = this.getClimateSeatService().getSeatMassageForZone(this.modelApiInstance);
            if (seatMassage != null) {
                this.massageModelApiCallback._update_getSeatMassageActiveProgram(seatMassage.getSeatMassageProgram());
                this.massageModelApiCallback._update_getSeatMassageIntensity(seatMassage.getSeatMassageIntensity());
            }
        } else if (n == 1 || n == 2) {
            SeatMassage seatMassage = this.getClimateSeatService().getSeatMassageForZone(this.getClimateZoneFromRearZone(n));
            if (seatMassage != null) {
                this.massageModelApiCallback._update_getRearSeatMassageActiveProgram(seatMassage.getSeatMassageProgram());
                this.massageModelApiCallback._update_getRearSeatMassageIntensity(seatMassage.getSeatMassageIntensity());
            } else {
                this.logger.error(256).append("_mda_setSeatZone called, ").append("currentMassage is null").log();
            }
        } else {
            this.logger.error(256).append("_mda_setSeatZone called, ").append("seatZone parameter isn't 0, 1 or 2").log();
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

