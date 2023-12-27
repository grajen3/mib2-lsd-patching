/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.sourcehandling.helper;

import de.vw.mib.asl.api.devicehandling.Device;
import de.vw.mib.asl.api.devicehandling.Medium;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.common.BufferedPropertyInteger;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.util.Util;

public final class MediaModelController {
    private final BufferedPropertyInteger cd_dvdState = new BufferedPropertyInteger(2589);
    private final BufferedPropertyInteger dvdChangerState = new BufferedPropertyInteger(1046219776);
    private final BufferedPropertyInteger mediathekState = new BufferedPropertyInteger(2590);
    private final BufferedPropertyInteger remoteControlPlayerState = new BufferedPropertyInteger(30);
    private final BufferedPropertyInteger sdCard1State = new BufferedPropertyInteger(2591);
    private final BufferedPropertyInteger sdCard2State = new BufferedPropertyInteger(2592);
    private final BufferedPropertyInteger usbState = new BufferedPropertyInteger(2593);
    private final BufferedPropertyInteger usb2State = new BufferedPropertyInteger(593234944);
    private final BufferedPropertyInteger usb3State = new BufferedPropertyInteger(962333696);
    private final BufferedPropertyInteger usb4State = new BufferedPropertyInteger(979110912);

    private void reportErrorInternalChanger(int n) {
        switch (n) {
            case 0: {
                this.dvdChangerState.force(1);
                break;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 11: {
                this.dvdChangerState.force(2);
                break;
            }
            case 12: {
                this.dvdChangerState.force(3);
                break;
            }
            default: {
                ServiceManager.logger.warn(128).append("Unhandled error type for DVD-Changer: ").append(n).log();
                this.dvdChangerState.force(0);
            }
        }
    }

    private void reportErrorInternalOptical(int n) {
        switch (n) {
            case 0: {
                this.cd_dvdState.force(1);
                break;
            }
            case 1: {
                this.cd_dvdState.force(2);
                break;
            }
            case 2: {
                this.cd_dvdState.force(3);
                break;
            }
            case 3: {
                this.cd_dvdState.force(4);
                break;
            }
            case 5: {
                this.cd_dvdState.force(7);
                break;
            }
            case 6: {
                this.cd_dvdState.force(8);
                break;
            }
            case 4: {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(401);
                break;
            }
            case 11: {
                this.cd_dvdState.force(0);
                break;
            }
            case 12: {
                this.cd_dvdState.force(10);
                break;
            }
            default: {
                ServiceManager.logger.warn(128).append("Unhandled error type for CD/DVD: ").append(n).log();
                this.cd_dvdState.force(0);
            }
        }
    }

    public void reportErrorJukeboxSynchronizing() {
        this.mediathekState.force(5);
    }

    private void reportErrorJukebox(int n) {
        switch (n) {
            case 0: {
                this.mediathekState.force(1);
                break;
            }
            case 1: {
                this.mediathekState.force(2);
                break;
            }
            case 2: {
                this.mediathekState.force(3);
                break;
            }
            case 4: {
                this.mediathekState.force(4);
                break;
            }
            case 3: {
                this.mediathekState.force(5);
                break;
            }
            case 9: {
                this.mediathekState.force(6);
                break;
            }
            default: {
                ServiceManager.logger.warn(128).append("Unhandled error type for jukebox: ").append(n).log();
                this.mediathekState.force(0);
            }
        }
    }

    private void reportErrorRCP(int n) {
        switch (n) {
            case 0: {
                this.remoteControlPlayerState.force(1);
                break;
            }
            case 1: {
                this.remoteControlPlayerState.force(5);
                break;
            }
            case 2: {
                this.remoteControlPlayerState.force(5);
                break;
            }
            case 3: {
                this.remoteControlPlayerState.force(3);
                break;
            }
            case 4: {
                this.remoteControlPlayerState.force(4);
                break;
            }
            case 10: {
                this.remoteControlPlayerState.force(6);
                break;
            }
            default: {
                ServiceManager.logger.warn(128).append("Unhandled error type for RCP: ").append(n).log();
                this.remoteControlPlayerState.force(0);
            }
        }
    }

    private void reportErrorSD1(int n) {
        switch (n) {
            case 0: {
                this.sdCard1State.force(1);
                break;
            }
            case 1: {
                this.sdCard1State.force(2);
                break;
            }
            case 2: {
                this.sdCard1State.force(3);
                break;
            }
            case 3: {
                this.sdCard1State.force(4);
                break;
            }
            case 5: {
                this.sdCard1State.force(5);
                break;
            }
            case 6: {
                this.sdCard1State.force(6);
                break;
            }
            case 4: {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(418);
                break;
            }
            case 11: {
                this.sdCard1State.force(0);
                break;
            }
            default: {
                ServiceManager.logger.warn(128).append("Unhandled error type for SD 1: ").append(n).log();
                this.sdCard1State.force(0);
            }
        }
    }

    private void reportErrorSD2(int n) {
        switch (n) {
            case 0: {
                this.sdCard2State.force(1);
                break;
            }
            case 1: {
                this.sdCard2State.force(2);
                break;
            }
            case 2: {
                this.sdCard2State.force(3);
                break;
            }
            case 3: {
                this.sdCard2State.force(4);
                break;
            }
            case 5: {
                this.sdCard2State.force(5);
                break;
            }
            case 6: {
                this.sdCard2State.force(6);
                break;
            }
            case 4: {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(369);
                break;
            }
            case 11: {
                this.sdCard2State.force(0);
                break;
            }
            default: {
                ServiceManager.logger.warn(128).append("Unhandled error type for SD 2: ").append(n).log();
                this.sdCard2State.force(0);
            }
        }
    }

    private void reportErrorUSB(int n) {
        switch (n) {
            case 0: {
                this.usbState.force(1);
                break;
            }
            case 1: {
                this.usbState.force(2);
                break;
            }
            case 2: {
                this.usbState.force(3);
                break;
            }
            case 3: {
                this.usbState.force(4);
                break;
            }
            case 5: {
                this.usbState.force(5);
                break;
            }
            case 6: {
                this.usbState.force(6);
                break;
            }
            case 10: {
                this.usbState.force(10);
                break;
            }
            case 4: {
                this.usbState.force(8);
                break;
            }
            case 11: {
                this.usbState.force(0);
                break;
            }
            default: {
                ServiceManager.logger.warn(128).append("Unhandled error type for USB: ").append(n).log();
                this.usbState.force(4);
            }
        }
    }

    private static void reportErrorUSB(BufferedPropertyInteger bufferedPropertyInteger, int n) {
        switch (n) {
            case 0: {
                bufferedPropertyInteger.force(1);
                break;
            }
            case 1: {
                bufferedPropertyInteger.force(2);
                break;
            }
            case 2: {
                bufferedPropertyInteger.force(3);
                break;
            }
            case 3: {
                bufferedPropertyInteger.force(4);
                break;
            }
            case 5: {
                bufferedPropertyInteger.force(5);
                break;
            }
            case 6: {
                bufferedPropertyInteger.force(6);
                break;
            }
            case 10: {
                bufferedPropertyInteger.force(10);
                break;
            }
            case 4: {
                bufferedPropertyInteger.force(8);
                break;
            }
            case 11: {
                bufferedPropertyInteger.force(0);
                break;
            }
            default: {
                ServiceManager.logger.warn(128).append("Unhandled error type for USB2: ").append(n).log();
                bufferedPropertyInteger.force(4);
            }
        }
    }

    public void reportMediumError(Medium medium) {
        this.reportMediumError(medium.getParent(), medium.getCurrentState().getErrorType());
    }

    public void reportMediumError(Device device, int n) {
        if (n == 8) {
            this.reportDeviceError(device);
            return;
        }
        if (device.isInternalOptical()) {
            this.reportErrorInternalOptical(n);
            return;
        }
        if (device.isChanger()) {
            this.reportErrorInternalChanger(n);
            return;
        }
        block0 : switch (device.getCurrentInfo().getDeviceType()) {
            case 1: {
                if (device.getSlot() == 0) {
                    this.reportErrorSD1(n);
                    break;
                }
                if (device.getSlot() != 1) break;
                this.reportErrorSD2(n);
                break;
            }
            case 0: {
                this.reportErrorJukebox(n);
                break;
            }
            case 2: {
                switch (device.getSlot()) {
                    case 0: {
                        this.reportErrorUSB(n);
                        break block0;
                    }
                    case 1: {
                        MediaModelController.reportErrorUSB(this.usb2State, n);
                        break block0;
                    }
                    case 2: {
                        MediaModelController.reportErrorUSB(this.usb3State, n);
                        break block0;
                    }
                    case 3: {
                        MediaModelController.reportErrorUSB(this.usb4State, n);
                        break block0;
                    }
                }
                ServiceManager.logger.warn(128).append("Unknown slot ").append(device.getSlot()).append(" for USB, cannot report errorType ").append(n).log();
                break;
            }
            case 8: {
                this.reportErrorRCP(n);
                break;
            }
        }
    }

    public void reportDeviceError(Device device) {
        int n = device.getCurrentInfo().getDeviceType();
        if (device.isOptical()) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(407);
        }
        block0 : switch (n) {
            case 1: {
                if (device.getSlot() == 0) {
                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(415);
                    break;
                }
                if (device.getSlot() != 1) break;
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(366);
                break;
            }
            case 2: {
                switch (device.getSlot()) {
                    case 1: {
                        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(544);
                        break block0;
                    }
                    case 2: {
                        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1479680000);
                        break block0;
                    }
                    case 3: {
                        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(1496457216);
                        break block0;
                    }
                }
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(380);
                break;
            }
            case 8: {
                this.remoteControlPlayerState.force(4);
                break;
            }
            default: {
                ServiceManager.logger.warn(128).append("MediaModelErrorHandling.reportDeviceError() unhandled case! Device: ").append(device).log();
            }
        }
    }

    public void reportMediumImportActive(Device device) {
        if (device.isOptical()) {
            this.cd_dvdState.force(10);
        } else {
            ServiceManager.logger.warn(128).append("MediaModelErrorHandling.reportMediumImportActive() unhandled case! Device Type: ").append(device.getCurrentInfo().deviceType).log();
        }
    }

    public void sendMediumImportActiveEvent(Device device) {
        if (device.isOptical()) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(457);
        } else {
            ServiceManager.logger.warn(128).append("MediaModelErrorHandling.reportMediumImportActive() unhandled case! Device Type: ").append(device.getCurrentInfo().deviceType).log();
        }
    }

    public void reportMediumNotImportable(Device device) {
        int n = device.getCurrentInfo().getDeviceType();
        if (device.isOptical()) {
            this.cd_dvdState.force(9);
            return;
        }
        switch (n) {
            case 1: {
                if (device.getSlot() == 0) {
                    this.sdCard1State.force(7);
                    return;
                }
                if (device.getSlot() != 1) break;
                this.sdCard2State.force(7);
                return;
            }
            case 2: {
                if (device.getSlot() == 0) {
                    this.usbState.force(7);
                    return;
                }
                if (device.getSlot() != 1) break;
                this.usb2State.force(7);
                return;
            }
        }
        ServiceManager.logger.warn(128).append("MediaModelErrorHandling.reportMediumNotImportable() unhandled case! Device: ").append(device).log();
    }

    public void reportDeviceState(Device device) {
        int n = device.getCurrentInfo().getFlags();
        if (Util.isBitSet(32, n)) {
            if (device.isOptical()) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(388);
            }
            switch (device.getCurrentInfo().getDeviceType()) {
                case 0: {
                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(395);
                    break;
                }
            }
        }
        if (Util.isBitSet(16, n)) {
            if (device.isOptical()) {
                ServiceManager.eventDispatcher.createAndSubmitHMIEvent(389);
            }
            switch (device.getCurrentInfo().getDeviceType()) {
                case 0: {
                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(396);
                    break;
                }
            }
        }
    }

    public void reportMediumLoading(Device device) {
        int n = device.getCurrentInfo().getDeviceType();
        if (device.isOptical()) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(404);
            return;
        }
        switch (n) {
            case 1: {
                if (device.getSlot() == 0) {
                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(416);
                    break;
                }
                if (device.getSlot() == 1) {
                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(367);
                    break;
                }
                LogMessage logMessage = ServiceManager.logger.error(128);
                logMessage.append("MediaModelController.reportMediumLoading(").append("device=").append(device).append(") invalid sd card slot=").append(device.getSlot()).log();
                break;
            }
            case 2: {
                break;
            }
            case 8: {
                this.remoteControlPlayerState.force(2);
                break;
            }
        }
    }

    public void reportMediumLoadingFinished(Device device) {
        int n = device.getCurrentInfo().getDeviceType();
        if (device.isOptical()) {
            ServiceManager.eventDispatcher.createAndSubmitHMIEvent(402);
            return;
        }
        switch (n) {
            case 1: {
                if (device.getSlot() == 0) {
                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(417);
                    break;
                }
                if (device.getSlot() == 1) {
                    ServiceManager.eventDispatcher.createAndSubmitHMIEvent(368);
                    break;
                }
                ServiceManager.logger.error(128).append("MediaModelController.reportMediumLoadingFinished()").append("device=").append(device).append(") invalid sd card slot=").append(device.getSlot()).log();
                break;
            }
            case 2: {
                break;
            }
            case 8: {
                this.remoteControlPlayerState.force(1);
                break;
            }
        }
    }

    private void setMediumFormat(int n) {
        switch (n) {
            case 1: 
            case 5: {
                ServiceManager.aslPropertyManager.valueChangedInteger(6, 0);
                break;
            }
            case 2: 
            case 3: 
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(6, 10);
                break;
            }
        }
    }

    public void setCDContentFormat(int n) {
        switch (n) {
            case 1: {
                ServiceManager.aslPropertyManager.valueChangedInteger(3520, 1);
                break;
            }
            case 5: 
            case 6: {
                ServiceManager.aslPropertyManager.valueChangedInteger(3520, 2);
                ServiceManager.aslPropertyManager.valueChangedInteger(136, 2);
                break;
            }
            case 2: {
                ServiceManager.aslPropertyManager.valueChangedInteger(3520, 4);
                ServiceManager.aslPropertyManager.valueChangedInteger(136, 3);
                break;
            }
            case 3: {
                ServiceManager.aslPropertyManager.valueChangedInteger(3520, 3);
                ServiceManager.aslPropertyManager.valueChangedInteger(136, 1);
                break;
            }
        }
        this.setMediumFormat(n);
    }
}

