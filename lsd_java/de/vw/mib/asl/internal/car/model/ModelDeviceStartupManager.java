/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.model;

import de.vw.mib.asl.internal.car.model.CarSetupMenu;
import de.vw.mib.asl.internal.car.model.FactorySettingMenu;
import de.vw.mib.asl.internal.car.model.device.ambiencelight.AmbienceLightDevice;
import de.vw.mib.asl.internal.car.model.device.bordcomputer.BordComputerDevice;
import de.vw.mib.asl.internal.car.model.device.climate.ClimateDevice;
import de.vw.mib.asl.internal.car.model.device.driverassistance.AssistantsDevice;
import de.vw.mib.asl.internal.car.model.device.e_traction.E_TractionDevice;
import de.vw.mib.asl.internal.car.model.device.hud.HUDDevice;
import de.vw.mib.asl.internal.car.model.device.light.LightDevice;
import de.vw.mib.asl.internal.car.model.device.mfa.MFADevice;
import de.vw.mib.asl.internal.car.model.device.openclose.OpenCloseDevice;
import de.vw.mib.asl.internal.car.model.device.parking.ParkingDevice;
import de.vw.mib.asl.internal.car.model.device.personal.PersonalizationDevice;
import de.vw.mib.asl.internal.car.model.device.seat.SeatDevice;
import de.vw.mib.asl.internal.car.model.device.service.ServiceDevice;
import de.vw.mib.asl.internal.car.model.device.sight.SightDevice;
import de.vw.mib.asl.internal.car.model.device.timeunitslanguage.TimeUnitsLanguageDevice;

public class ModelDeviceStartupManager {
    private static boolean started;

    private ModelDeviceStartupManager() {
        FactorySettingMenu factorySettingMenu = new FactorySettingMenu();
        CarSetupMenu carSetupMenu = new CarSetupMenu(factorySettingMenu);
        new E_TractionDevice(carSetupMenu);
        new AmbienceLightDevice(carSetupMenu);
        new SightDevice(carSetupMenu);
        new AssistantsDevice(carSetupMenu);
        new HUDDevice(carSetupMenu);
        new MFADevice(carSetupMenu);
        new ServiceDevice(carSetupMenu);
        new PersonalizationDevice(carSetupMenu);
        new OpenCloseDevice(carSetupMenu);
        new ClimateDevice(carSetupMenu);
        new ParkingDevice(carSetupMenu);
        new LightDevice(carSetupMenu);
        new SeatDevice(carSetupMenu);
        new BordComputerDevice();
        new TimeUnitsLanguageDevice(carSetupMenu);
    }

    public static void start() {
        if (!started) {
            started = true;
            new ModelDeviceStartupManager();
        }
    }
}

