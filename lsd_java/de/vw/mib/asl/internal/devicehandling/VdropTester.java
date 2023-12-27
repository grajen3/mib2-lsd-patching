/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.devicehandling;

import de.vw.mib.asl.framework.internal.framework.AbstractASLTarget;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.devicehandling.DevicesImpl;
import de.vw.mib.asl.internal.devicehandling.api.impl.ASLDeviceHandlingAPIImpl;
import de.vw.mib.genericevents.EventGeneric;
import org.dsi.ifc.media.DeviceInfo;
import org.dsi.ifc.media.MediaCapabilities;
import org.dsi.ifc.media.MediaInfo;

public final class VdropTester {
    private final AbstractASLTarget logger;
    private DeviceInfo[] lastInfo;
    static MediaInfo[] mediaList;

    public VdropTester(AbstractASLTarget abstractASLTarget) {
        this.logger = abstractASLTarget;
    }

    void handleTestVdrop(String string) {
        this.logger.info(new StringBuffer().append("vdrop-test ").append(string).toString());
        block18: for (int i2 = 0; i2 < string.length(); ++i2) {
            switch (string.charAt(i2)) {
                case 'A': {
                    this.audioUnavail();
                    continue block18;
                }
                case 'a': {
                    this.audioAvail();
                    continue block18;
                }
                case 'D': {
                    this.allUnavail();
                    continue block18;
                }
                case 'd': {
                    this.allAvail();
                    continue block18;
                }
                case 'S': {
                    this.devtypeUnavail(1, 1);
                    continue block18;
                }
                case 's': {
                    this.devtypeAvail(1, 1);
                    continue block18;
                }
                case 'J': {
                    this.devtypeUnavail(0, 1);
                    continue block18;
                }
                case 'j': {
                    this.devtypeAvail(0, 1);
                    continue block18;
                }
                case 'U': {
                    this.devtypeUnavail(2, -1);
                    continue block18;
                }
                case 'u': {
                    this.devtypeAvail(2, -1);
                    continue block18;
                }
                case 'O': {
                    this.opticals(8);
                    continue block18;
                }
                case 'o': {
                    this.opticals(0);
                    continue block18;
                }
                case 'B': {
                    this.browsingAvail(false);
                    continue block18;
                }
                case 'b': {
                    this.browsingAvail(true);
                    continue block18;
                }
                case '+': 
                case '-': {
                    int n;
                    int n2 = n = string.charAt(i2) == '-' ? 8 : 0;
                    if (i2 + 3 < string.length()) {
                        int n3 = Character.digit(string.charAt(++i2), 10);
                        n3 = n3 * 10 + Character.digit(string.charAt(++i2), 10);
                        int n4 = Character.digit(string.charAt(++i2), 10);
                        this.devtype(n3, n4, n);
                        continue block18;
                    }
                    this.logger.warn("VdropTester: not enough characters after '+'/'-'. expect 2 digits for deviceType and one for slot.");
                    continue block18;
                }
                case '!': {
                    this.sendDeviceList(this.lastInfo);
                    continue block18;
                }
                default: {
                    this.logger.warn().append("unknown subtest character in sequence \"").append(string).append("\" at character ").append(i2).append(": '").append(string.charAt(i2)).append('\'').log();
                }
            }
        }
    }

    private void audioUnavail() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1338698496, 279909120, 352926976);
        eventGeneric.setInt(0, 0);
        this.logger.triggerObserver(352926976, eventGeneric);
    }

    private void audioAvail() {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(-1338698496, 279909120, 352926976);
        eventGeneric.setInt(0, 2);
        this.logger.triggerObserver(352926976, eventGeneric);
    }

    private void allUnavail() {
        DeviceInfo[] deviceInfoArray = this.cloneDeviceList();
        for (int i2 = 0; i2 < deviceInfoArray.length; ++i2) {
            deviceInfoArray[i2].flags |= 8;
        }
        this.sendDeviceList(deviceInfoArray);
    }

    private void allAvail() {
        DeviceInfo[] deviceInfoArray = this.cloneDeviceList();
        for (int i2 = 0; i2 < deviceInfoArray.length; ++i2) {
            deviceInfoArray[i2].flags &= 0xFFFFFFF7;
        }
        this.sendDeviceList(deviceInfoArray);
    }

    private void devtypeUnavail(int n, int n2) {
        DeviceInfo[] deviceInfoArray = this.cloneDeviceList();
        for (int i2 = 0; i2 < deviceInfoArray.length; ++i2) {
            if (deviceInfoArray[i2].deviceType != n) continue;
            deviceInfoArray[i2].flags |= 8;
            if (--n2 == 0) break;
        }
        this.sendDeviceList(deviceInfoArray);
    }

    private void devtypeAvail(int n, int n2) {
        DeviceInfo[] deviceInfoArray = this.cloneDeviceList();
        for (int i2 = 0; i2 < deviceInfoArray.length; ++i2) {
            if (deviceInfoArray[i2].deviceType != n) continue;
            deviceInfoArray[i2].flags &= 0xFFFFFFF7;
            if (--n2 == 0) break;
        }
        this.sendDeviceList(deviceInfoArray);
    }

    private void devtype(int n, int n2, int n3) {
        DeviceInfo[] deviceInfoArray = this.cloneDeviceList();
        for (int i2 = 0; i2 < deviceInfoArray.length; ++i2) {
            if (deviceInfoArray[i2].deviceType != n || n2-- != 0) continue;
            deviceInfoArray[i2].flags &= 0xFFFFFFF7;
            deviceInfoArray[i2].flags |= n3;
        }
        this.lastInfo = deviceInfoArray;
    }

    private void opticals(int n) {
        DeviceInfo[] deviceInfoArray = this.cloneDeviceList();
        for (int i2 = 0; i2 < deviceInfoArray.length; ++i2) {
            if (deviceInfoArray[i2].deviceType != 13 && deviceInfoArray[i2].deviceType != 5 && deviceInfoArray[i2].deviceType != 4 && deviceInfoArray[i2].deviceType != 6 && deviceInfoArray[i2].deviceType != 3) continue;
            deviceInfoArray[i2].flags &= 0xFFFFFFF7;
            deviceInfoArray[i2].flags |= n;
        }
        this.sendDeviceList(deviceInfoArray);
    }

    private DeviceInfo[] cloneDeviceList() {
        if (this.lastInfo == null) {
            this.lastInfo = ((DevicesImpl)ASLDeviceHandlingAPIImpl.getInstance().getDevices()).deviceList;
        }
        return this.cloneDeviceList(this.lastInfo);
    }

    private DeviceInfo[] cloneDeviceList(DeviceInfo[] deviceInfoArray) {
        DeviceInfo[] deviceInfoArray2 = new DeviceInfo[deviceInfoArray.length];
        for (int i2 = 0; i2 < deviceInfoArray.length; ++i2) {
            DeviceInfo deviceInfo = deviceInfoArray[i2];
            deviceInfoArray2[i2] = new DeviceInfo(deviceInfo.deviceID, deviceInfo.deviceType, deviceInfo.numSlots, deviceInfo.flags);
        }
        return deviceInfoArray2;
    }

    private MediaInfo[] cloneMediaList(MediaInfo[] mediaInfoArray) {
        MediaInfo[] mediaInfoArray2 = new MediaInfo[mediaInfoArray.length];
        for (int i2 = 0; i2 < mediaInfoArray.length; ++i2) {
            MediaInfo mediaInfo = mediaInfoArray[i2];
            mediaInfoArray2[i2] = new MediaInfo(mediaInfo.deviceID, mediaInfo.mediaID, mediaInfo.mediaType, mediaInfo.uniqueMediaID, mediaInfo.name, mediaInfo.mountPoint, mediaInfo.flags, this.cloneMediaCapabilities(mediaInfo.mediaCaps));
        }
        return mediaInfoArray2;
    }

    private MediaCapabilities cloneMediaCapabilities(MediaCapabilities mediaCapabilities) {
        if (mediaCapabilities == null) {
            return null;
        }
        return new MediaCapabilities(mediaCapabilities.playerCoverArt, mediaCapabilities.browserCoverArt, mediaCapabilities.albumBrowser, mediaCapabilities.searchEntries, mediaCapabilities.importData, mediaCapabilities.rawBrowser, mediaCapabilities.favorites, mediaCapabilities.playbackModes, mediaCapabilities.contentBrowser, mediaCapabilities.videoSupport, mediaCapabilities.remoteApps);
    }

    private void sendDeviceList(DeviceInfo[] deviceInfoArray) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1957630720, 1957630720, 2094148864);
        eventGeneric.setObject(0, deviceInfoArray);
        this.logger.sendSafe(eventGeneric);
        this.lastInfo = deviceInfoArray;
    }

    private void browsingAvail(boolean bl) {
        MediaInfo[] mediaInfoArray = this.cloneMediaList(mediaList);
        for (int i2 = 0; i2 < mediaInfoArray.length; ++i2) {
            if (mediaInfoArray[i2].mediaCaps == null) continue;
            mediaInfoArray[i2].mediaCaps.contentBrowser = false;
            mediaInfoArray[i2].mediaCaps.rawBrowser = bl;
        }
        this.sendMediaList(mediaInfoArray);
    }

    private void sendMediaList(MediaInfo[] mediaInfoArray) {
        EventGeneric eventGeneric = ServiceManager.mGenericEventFactory.newEvent(1957630720, 1957630720, 2110926080);
        eventGeneric.setObject(0, mediaInfoArray);
        this.logger.sendSafe(eventGeneric);
    }
}

