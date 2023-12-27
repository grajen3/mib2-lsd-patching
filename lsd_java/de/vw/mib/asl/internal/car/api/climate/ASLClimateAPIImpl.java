/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.api.climate;

import de.vw.mib.asl.api.car.climate.ASLClimateAPI;
import de.vw.mib.asl.api.car.climate.ClimateAirDistributionCombined;
import de.vw.mib.asl.api.car.climate.ClimateAirFlowState;
import de.vw.mib.asl.api.car.climate.ClimateAirFlowStyle;
import de.vw.mib.asl.api.car.climate.ClimateConfiguration;
import de.vw.mib.asl.api.car.climate.ClimateFunctionsAvailability;
import de.vw.mib.asl.api.car.climate.ClimateSeatHeater;
import de.vw.mib.asl.api.car.climate.ClimateSeatHeaterBalance;
import de.vw.mib.asl.api.car.climate.ClimateSeatVentilation;
import de.vw.mib.asl.api.car.climate.ClimateSeatVentilatorBalance;
import de.vw.mib.asl.api.car.climate.ClimateService;
import de.vw.mib.asl.api.car.climate.ClimateServiceListener;
import de.vw.mib.asl.api.car.climate.ClimateSystemState;
import de.vw.mib.asl.api.car.climate.ClimateTemperature;
import de.vw.mib.asl.internal.car.api.ServiceClient;
import de.vw.mib.asl.internal.car.api.climate.NotAvailableClimateService;
import de.vw.mib.asl.internal.car.framework.services.ServiceFactory;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ASLClimateAPIImpl
implements ASLClimateAPI,
ServiceClient,
ClimateServiceListener {
    private HashSet registeredCarClients;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$climate$ClimateService;
    static /* synthetic */ Class class$de$vw$mib$asl$api$car$climate$ClimateServiceListener;

    private HashSet getRegisteredCarClients() {
        if (this.registeredCarClients == null) {
            this.registeredCarClients = new HashSet();
        }
        return this.registeredCarClients;
    }

    @Override
    public void addClimateServiceListener(ClimateServiceListener climateServiceListener) {
        this.getRegisteredCarClients().add(climateServiceListener);
    }

    @Override
    public void removeClimateServiceListener(ClimateServiceListener climateServiceListener) {
        this.getRegisteredCarClients().remove(climateServiceListener);
    }

    @Override
    public ClimateService getClimateService() {
        ClimateService climateService = (ClimateService)ServiceFactory.getInstance().getServiceClientRegistry().getServiceProvider(class$de$vw$mib$asl$api$car$climate$ClimateService == null ? (class$de$vw$mib$asl$api$car$climate$ClimateService = ASLClimateAPIImpl.class$("de.vw.mib.asl.api.car.climate.ClimateService")) : class$de$vw$mib$asl$api$car$climate$ClimateService);
        if (climateService == null) {
            climateService = new NotAvailableClimateService();
        }
        return climateService;
    }

    @Override
    public void updateClimateTemperature(ClimateTemperature climateTemperature) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            ClimateServiceListener climateServiceListener = (ClimateServiceListener)iterator.next();
            climateServiceListener.updateClimateTemperature(climateTemperature);
        }
    }

    @Override
    public void updateClimateTemperatureValues(ArrayList arrayList) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            ClimateServiceListener climateServiceListener = (ClimateServiceListener)iterator.next();
            climateServiceListener.updateClimateTemperatureValues(arrayList);
        }
    }

    @Override
    public void updateClimateServiceExisting(boolean bl) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            ClimateServiceListener climateServiceListener = (ClimateServiceListener)iterator.next();
            climateServiceListener.updateClimateServiceExisting(bl);
        }
    }

    @Override
    public void updateClimateServiceAvailable(boolean bl) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            ClimateServiceListener climateServiceListener = (ClimateServiceListener)iterator.next();
            climateServiceListener.updateClimateServiceAvailable(bl);
        }
    }

    @Override
    public void informClientsThatProviderIsAvailable(Class clazz) {
        if (clazz == (class$de$vw$mib$asl$api$car$climate$ClimateService == null ? (class$de$vw$mib$asl$api$car$climate$ClimateService = ASLClimateAPIImpl.class$("de.vw.mib.asl.api.car.climate.ClimateService")) : class$de$vw$mib$asl$api$car$climate$ClimateService)) {
            ServiceFactory.getInstance().getServiceClientRegistry().registerServiceClient(class$de$vw$mib$asl$api$car$climate$ClimateServiceListener == null ? (class$de$vw$mib$asl$api$car$climate$ClimateServiceListener = ASLClimateAPIImpl.class$("de.vw.mib.asl.api.car.climate.ClimateServiceListener")) : class$de$vw$mib$asl$api$car$climate$ClimateServiceListener, this);
            this.updateClimateServiceExisting(true);
        }
    }

    @Override
    public void updateClimateAirFlowStyle(ClimateAirFlowStyle climateAirFlowStyle) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            ClimateServiceListener climateServiceListener = (ClimateServiceListener)iterator.next();
            climateServiceListener.updateClimateAirFlowStyle(climateAirFlowStyle);
        }
    }

    @Override
    public void updateClimateSeatHeater(ClimateSeatHeater climateSeatHeater) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            ClimateServiceListener climateServiceListener = (ClimateServiceListener)iterator.next();
            climateServiceListener.updateClimateSeatHeater(climateSeatHeater);
        }
    }

    @Override
    public void updateClimateSeatVentilation(ClimateSeatVentilation climateSeatVentilation) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            ClimateServiceListener climateServiceListener = (ClimateServiceListener)iterator.next();
            climateServiceListener.updateClimateSeatVentilation(climateSeatVentilation);
        }
    }

    @Override
    public void updateClimateFuntionAvailability(ClimateFunctionsAvailability climateFunctionsAvailability) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            ClimateServiceListener climateServiceListener = (ClimateServiceListener)iterator.next();
            climateServiceListener.updateClimateFuntionAvailability(climateFunctionsAvailability);
        }
    }

    @Override
    public void updateClimateConfiguration(ClimateConfiguration climateConfiguration) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            ClimateServiceListener climateServiceListener = (ClimateServiceListener)iterator.next();
            climateServiceListener.updateClimateConfiguration(climateConfiguration);
        }
    }

    @Override
    public void updateClimateSeatHeaterBalance(ClimateSeatHeaterBalance climateSeatHeaterBalance) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            ClimateServiceListener climateServiceListener = (ClimateServiceListener)iterator.next();
            climateServiceListener.updateClimateSeatHeaterBalance(climateSeatHeaterBalance);
        }
    }

    @Override
    public void updateClimateSeatVentilatorBalance(ClimateSeatVentilatorBalance climateSeatVentilatorBalance) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            ClimateServiceListener climateServiceListener = (ClimateServiceListener)iterator.next();
            climateServiceListener.updateClimateSeatVentilatorBalance(climateSeatVentilatorBalance);
        }
    }

    @Override
    public void updateClimateAirFlowState(ClimateAirFlowState climateAirFlowState) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            ClimateServiceListener climateServiceListener = (ClimateServiceListener)iterator.next();
            climateServiceListener.updateClimateAirFlowState(climateAirFlowState);
        }
    }

    @Override
    public void updateClimateSystemState(ClimateSystemState climateSystemState) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            ClimateServiceListener climateServiceListener = (ClimateServiceListener)iterator.next();
            climateServiceListener.updateClimateSystemState(climateSystemState);
        }
    }

    @Override
    public void updateClamp15State(boolean bl) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            ClimateServiceListener climateServiceListener = (ClimateServiceListener)iterator.next();
            climateServiceListener.updateClamp15State(bl);
        }
    }

    @Override
    public void updateClimateAirDistributionCombined(ClimateAirDistributionCombined climateAirDistributionCombined) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            ClimateServiceListener climateServiceListener = (ClimateServiceListener)iterator.next();
            climateServiceListener.updateClimateAirDistributionCombined(climateAirDistributionCombined);
        }
    }

    @Override
    public void updateAirconFrontWindowHeater(boolean bl) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            ClimateServiceListener climateServiceListener = (ClimateServiceListener)iterator.next();
            climateServiceListener.updateAirconFrontWindowHeater(bl);
        }
    }

    @Override
    public void updateAirconMaxDefrost(boolean bl) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            ClimateServiceListener climateServiceListener = (ClimateServiceListener)iterator.next();
            climateServiceListener.updateAirconMaxDefrost(bl);
        }
    }

    @Override
    public void updateAirconRearWindowHeater(boolean bl) {
        Iterator iterator = this.getRegisteredCarClients().iterator();
        while (iterator.hasNext()) {
            ClimateServiceListener climateServiceListener = (ClimateServiceListener)iterator.next();
            climateServiceListener.updateAirconRearWindowHeater(bl);
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

