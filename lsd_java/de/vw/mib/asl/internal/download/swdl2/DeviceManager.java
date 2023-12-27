/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.download.swdl2;

import de.vw.mib.log4mib.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import org.dsi.ifc.swdldeviceinfo.DSISwdlDeviceInfo;

public class DeviceManager {
    private static final String[] DEVICE_PATTERN = new String[]{"device", "device2", "device3", "device4", "device5", "device6", "device7", "device8", "device9"};
    private static final String EOL = System.getProperty("line.separator");
    private final DSISwdlDeviceInfo deviceInfo;
    private final Logger logger;

    public DeviceManager(DSISwdlDeviceInfo dSISwdlDeviceInfo, Logger logger) {
        this.deviceInfo = dSISwdlDeviceInfo;
        this.logger = logger;
    }

    public String[] extractDeviceNames(String string) {
        if (this.checkIsFileValid(string)) {
            String string2 = this.readInfoFile(string);
            if (string2 != null) {
                return this.parseDeviceName(string2);
            }
        } else {
            this.logger.error(4096, new StringBuffer().append("The file could not be found >").append(string).append("<").toString());
        }
        return null;
    }

    public boolean checkIsDeviceNameInInfoFile(String[] stringArray, String[] stringArray2) {
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            if (!this.findDeviceName(stringArray[i2], stringArray2)) continue;
            return true;
        }
        return false;
    }

    private boolean findDeviceName(String string, String[] stringArray) {
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            if (!string.equalsIgnoreCase(stringArray[i2])) continue;
            return true;
        }
        return false;
    }

    public void selectDevice(int n, String string, int[] nArray) {
        switch (nArray[n]) {
            case 1: 
            case 5: 
            case 6: {
                this.logger.info(4096).append("Selecting >").append(string).append("< is not needed!").log();
                this.deviceInfo.getModules(n);
                break;
            }
            case 2: 
            case 14: {
                this.logger.info(4096).append("Select device >").append(string).append("<").log();
                this.deviceInfo.setDeviceSelection(n, 1);
                this.deviceInfo.getModules(n);
                break;
            }
            default: {
                this.logger.warn(4096).append("Selection is not possible >").append(nArray[n]).append("<").log();
            }
        }
    }

    public void deSelectDevice(int n, String string, int[] nArray) {
        switch (nArray[n]) {
            case 0: 
            case 2: 
            case 3: 
            case 4: 
            case 14: {
                this.logger.info(4096).append("Deselection is not needed >").append(string).append("<").log();
                this.deviceInfo.getModules(n);
                break;
            }
            default: {
                this.logger.trace(4096).append("Cancel selection for device >").append(string).append("<").log();
                this.deviceInfo.setDeviceSelection(n, 0);
                this.deviceInfo.getModules(n);
            }
        }
    }

    private String[] parseDeviceName(String string) {
        int n = this.getNumberOfDeviceNames(string);
        String[] stringArray = new String[n];
        for (int i2 = 0; i2 < n; ++i2) {
            String string2 = DEVICE_PATTERN[i2];
            int n2 = string.indexOf(string2);
            stringArray[i2] = string.substring(n2 + string2.length() + 1, string.indexOf(EOL, n2));
        }
        return stringArray;
    }

    private int getNumberOfDeviceNames(String string) {
        int n = 9;
        int n2 = 0;
        for (int i2 = 0; i2 < n; ++i2) {
            if (string.indexOf(DEVICE_PATTERN[i2]) == -1) {
                return n2;
            }
            ++n2;
        }
        return n2;
    }

    private String readInfoFile(String string) {
        StringBuffer stringBuffer = new StringBuffer(1024);
        try {
            String string2;
            FileReader fileReader = new FileReader(string);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((string2 = bufferedReader.readLine()) != null) {
                if (string2 == null) continue;
                stringBuffer.append(string2).append(EOL);
            }
            bufferedReader.close();
            fileReader.close();
        }
        catch (Exception exception) {
            this.logger.error(4096).append("An unforeseen issue occurred while reading the data file >").append(string).append("<.");
            return null;
        }
        return stringBuffer.toString();
    }

    private boolean checkIsFileValid(String string) {
        return new File(string).exists();
    }
}

