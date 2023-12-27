/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.climateseatmenu;

import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.asl.api.car.ASLCarFactory;
import de.vw.mib.asl.api.car.climate.ClimateSeatHeater;
import de.vw.mib.asl.api.car.climate.ClimateSeatVentilation;
import de.vw.mib.asl.api.car.climate.ClimateServiceListenerAdaptor;
import generated.de.vw.mib.appadapter.climateseatmenu.ExtraRearSeatClimateModelApiCallback;
import generated.de.vw.mib.appadapter.climateseatmenu.ExtraRearSeatClimateModelApiService;

public class ExtraRearSeatClimateService
extends ClimateServiceListenerAdaptor
implements ExtraRearSeatClimateModelApiService {
    private AppAdapterSystemServices systemServices;
    static /* synthetic */ Class class$generated$de$vw$mib$appadapter$climateseatmenu$ExtraRearSeatClimateModelApiCallback;

    public ExtraRearSeatClimateService(AppAdapterSystemServices appAdapterSystemServices) {
        this.systemServices = appAdapterSystemServices;
    }

    @Override
    public void _mda_heatingValueChanged(int n, int n2) {
        ClimateSeatHeater climateSeatHeater;
        if (n == 0) {
            climateSeatHeater = ASLCarFactory.getClimateApi().getClimateService().getClimateSeatHeaterForZone(2);
            climateSeatHeater = climateSeatHeater.createSeatHeater(n2);
            ASLCarFactory.getClimateApi().getClimateService().changeClimateSeatHeater(climateSeatHeater);
        }
        if (n == 1) {
            climateSeatHeater = ASLCarFactory.getClimateApi().getClimateService().getClimateSeatHeaterForZone(3);
            climateSeatHeater = climateSeatHeater.createSeatHeater(n2);
            ASLCarFactory.getClimateApi().getClimateService().changeClimateSeatHeater(climateSeatHeater);
        }
    }

    @Override
    public void _mda_ventilationValueChanged(int n, int n2) {
        Object object;
        if (n == 0) {
            object = ASLCarFactory.getClimateApi().getClimateService();
            ClimateSeatVentilation climateSeatVentilation = object.getClimateSeatVentilationForZone(2);
            if (climateSeatVentilation != null) {
                climateSeatVentilation = climateSeatVentilation.createSeatVentilation(n2);
                ASLCarFactory.getClimateApi().getClimateService().changeClimateSeatVentilation(climateSeatVentilation);
            } else {
                this.systemServices.getLogger(256).error(256).append("_mda_ventilationValueChanged: rearLeftSeatVentilation=null").append(n2).log();
            }
        }
        if (n == 1) {
            object = ASLCarFactory.getClimateApi().getClimateService().getClimateSeatVentilationForZone(3);
            object = object.createSeatVentilation(n2);
            ASLCarFactory.getClimateApi().getClimateService().changeClimateSeatVentilation((ClimateSeatVentilation)object);
        }
    }

    public void start() {
        ASLCarFactory.getClimateApi().addClimateServiceListener(this);
    }

    private ExtraRearSeatClimateModelApiCallback getExtraRearSeatClimateModelApiCallback() {
        return (ExtraRearSeatClimateModelApiCallback)this.systemServices.getModelApiClient(class$generated$de$vw$mib$appadapter$climateseatmenu$ExtraRearSeatClimateModelApiCallback == null ? (class$generated$de$vw$mib$appadapter$climateseatmenu$ExtraRearSeatClimateModelApiCallback = ExtraRearSeatClimateService.class$("generated.de.vw.mib.appadapter.climateseatmenu.ExtraRearSeatClimateModelApiCallback")) : class$generated$de$vw$mib$appadapter$climateseatmenu$ExtraRearSeatClimateModelApiCallback);
    }

    @Override
    public void updateClimateSeatHeater(ClimateSeatHeater climateSeatHeater) {
        if (climateSeatHeater.getSeatHeaterZone() == 2) {
            this.getExtraRearSeatClimateModelApiCallback()._update_getLeftHeatingSide(climateSeatHeater.getSeatHeater());
        } else if (climateSeatHeater.getSeatHeaterZone() == 3) {
            this.getExtraRearSeatClimateModelApiCallback()._update_getLeftHeatingSide(climateSeatHeater.getSeatHeater());
        }
    }

    @Override
    public void updateClimateSeatVentilation(ClimateSeatVentilation climateSeatVentilation) {
        if (climateSeatVentilation.getSeatVentilationZone() == 2) {
            this.getExtraRearSeatClimateModelApiCallback()._update_getLeftVentilationSide(climateSeatVentilation.getSeatVentilation());
        } else if (climateSeatVentilation.getSeatVentilationZone() == 3) {
            this.getExtraRearSeatClimateModelApiCallback()._update_getRightVentilationSide(climateSeatVentilation.getSeatVentilation());
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

