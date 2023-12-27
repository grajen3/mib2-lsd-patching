/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.clients;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.Devices;
import de.vw.mib.asl.api.devicehandling.clients.DeviceChangeListener;
import de.vw.mib.asl.api.devicehandling.clients.DeviceFilter;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.sourcehandling.SourceHandlingPersistence;
import de.vw.mib.asl.internal.media.sourcehandling.state.DeviceCollector;

public final class AslDeviceIdDeterminator
extends DeviceChangeListener {
    public AslDeviceIdDeterminator(DeviceFilter deviceFilter) {
        super(deviceFilter);
    }

    public static void updateDevice(Device device) {
        int n = device.getMainMedium().getCurrentInfo().getMediaType();
        String string = device.getMainMedium().getCurrentInfo().getName();
        int n2 = device.getCurrentInfo().getDeviceType();
        DeviceCollector deviceCollector = DeviceCollector.get(device);
        block0 : switch (n2) {
            case 3: 
            case 4: 
            case 13: {
                deviceCollector.setAslDeviceID(1);
                break;
            }
            case 5: 
            case 6: {
                deviceCollector.setAslDeviceID(4);
                break;
            }
            case 1: {
                if (device.getSlot() == 0) {
                    deviceCollector.setAslDeviceID(2);
                    if (n != 19) {
                        ServiceManager.aslPropertyManager.valueChangedBoolean(1688, deviceCollector.getMainPartition().isUserAvailable());
                        break;
                    }
                    ServiceManager.aslPropertyManager.valueChangedBoolean(1688, true);
                    deviceCollector.setModelDeviceId(15);
                    break;
                }
                if (device.getSlot() == 1) {
                    deviceCollector.setAslDeviceID(10);
                    if (n != 19) {
                        ServiceManager.aslPropertyManager.valueChangedBoolean(1686, deviceCollector.getMainPartition().isUserAvailable());
                        break;
                    }
                    ServiceManager.aslPropertyManager.valueChangedBoolean(1686, true);
                    deviceCollector.setModelDeviceId(16);
                    break;
                }
                ServiceManager.logger.error(128).append("AslDeviceIdDeterminator.updateMediaSources() invalid sd card slot=").append(device.getSlot()).log();
                break;
            }
            case 10: {
                deviceCollector.setAslDeviceID(6);
                ServiceManager.aslPropertyManager.valueChangedBoolean(2857, deviceCollector.isDevicePlayable());
                ServiceManager.aslPropertyManager.valueChangedString(3086, string);
                break;
            }
            case 8: {
                deviceCollector.setAslDeviceID(3);
                break;
            }
            case 0: {
                deviceCollector.setAslDeviceID(5);
                break;
            }
            case 9: {
                deviceCollector.setAslDeviceID(11);
                break;
            }
            case 2: {
                boolean bl = device.getCurrentState().isMediaInSlot();
                switch (device.getSlot()) {
                    case 0: {
                        deviceCollector.setAslDeviceID(8);
                        ServiceManager.aslPropertyManager.valueChangedBoolean(1712, bl);
                        break block0;
                    }
                    case 1: {
                        deviceCollector.setAslDeviceID(13);
                        ServiceManager.aslPropertyManager.valueChangedBoolean(3816, bl);
                        break block0;
                    }
                    case 2: {
                        deviceCollector.setAslDeviceID(17);
                        break block0;
                    }
                    case 3: {
                        deviceCollector.setAslDeviceID(18);
                        break block0;
                    }
                }
                break;
            }
        }
    }

    @Override
    public void onChange(Device device) {
        AslDeviceIdDeterminator.updateDevice(device);
    }

    @Override
    public void onUpdate(Devices devices) {
        super.onUpdate(devices);
        Device device = devices.getInternalOptical();
        if (device != null) {
            if (device.getCurrentState().isPlayable()) {
                SourceHandlingPersistence.getInstance().setOpticalContentType(device.getMainMedium().getCurrentInfo().getMediaType());
            } else if (device.getCurrentState().isMediaInSlot()) {
                SourceHandlingPersistence.getInstance().setOpticalContentType(1);
            }
        }
    }
}

