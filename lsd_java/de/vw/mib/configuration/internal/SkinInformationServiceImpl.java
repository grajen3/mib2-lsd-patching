/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.configuration.internal;

import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.configuration.NvListener;
import de.vw.mib.configuration.SkinInformationAsyncValueSetterService;
import de.vw.mib.configuration.SkinInformationReceiver;
import de.vw.mib.configuration.SkinInformationService;
import de.vw.mib.configuration.internal.ServiceManager;
import de.vw.mib.log4mib.Logger;
import java.io.File;
import java.io.IOException;

public class SkinInformationServiceImpl
implements SkinInformationService,
SkinInformationAsyncValueSetterService,
NvListener {
    private static final int COLOR_INVALID;
    private static final int COLOR_RELAY;
    private static final int COLOR_STATIC;
    private static final int INFOTYPE_SKINMODE;
    private static final int INFOTYPE_AMBIENTCOLOR_ENABLED;
    private static final int INFOTYPE_AMBIENTCOLOR;
    private static final int INFOTYPE_AMBIENTHMIANDSRGBCOLOR;
    private static final String AMBIENT_COLOR_NONE_STRING;
    public static final char[] HEX_DIGITS;
    protected Logger logger;
    private ConfigurationManager configurationManager;
    private int currentBapColor;
    private boolean isSetEnabled = false;
    private int nrOfBapColors;
    private int defaultColorIndex;
    private int[] bapColors;
    private int[] displayColors;
    private int[] srgbColors;
    private int[] displayLedColors;
    private int skinMode;
    private boolean ambientColorEnabled;
    private int ambientColor;
    private int ambientInteriorColor;
    private String hmiColorString;
    private String srgbColorString;
    protected CowList skinInformationReceivers;

    public SkinInformationServiceImpl(ConfigurationManager configurationManager) {
        this.configurationManager = configurationManager;
        this.logger = ServiceManager.loggerFactory.getLogger(4);
        this.ambientColorEnabled = false;
        this.ambientColor = 0;
        this.hmiColorString = "none";
        this.srgbColorString = "none";
        this.skinInformationReceivers = CowList.EMPTY;
        this.readAmbienceColorMap();
        this.skinMode = configurationManager.getCurrentSkinMode();
        configurationManager.addNvListener(this, 3);
        configurationManager.addNvListener(this, 1);
    }

    @Override
    public void setIntLightAmbientLightColor(int n, int n2, int n3) {
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("setIntLightAmbientLightColor(").append(n).append(", ").append(n2).append(", ").append(n3).append(")").log();
        }
        if (n == -1) {
            this.isSetEnabled = true;
            return;
        }
        if (this.isSetEnabled) {
            this.currentBapColor = this.getColor(n, n2, n3);
            if (this.bapColors == null) {
                this.ambientColorEnabled = n >= 0;
                this.ambientColor = this.currentBapColor;
                this.ambientInteriorColor = this.currentBapColor;
                this.srgbColorString = this.getColorForHAS(this.ambientColor);
            } else {
                int n4 = this.getMapIndex(this.currentBapColor);
                this.ambientColor = this.getMappedColor(n4, this.currentBapColor, this.displayColors);
                this.ambientInteriorColor = this.getMappedColor(n4, this.currentBapColor, this.displayLedColors);
                this.srgbColorString = this.getColorForHAS(this.getMappedColor(n4, this.currentBapColor, this.srgbColors));
                this.ambientColorEnabled = this.ambientColor != -1;
            }
            this.hmiColorString = this.getColorForHAS(this.ambientColor);
            this.notifySkinInformationReceivers(1);
            this.notifySkinInformationReceivers(2);
            this.notifySkinInformationReceivers(3);
        }
    }

    @Override
    public int getCurrentSkinMode() {
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("getCurrentSkinMode() => ").append(this.skinMode).log();
        }
        return this.skinMode;
    }

    @Override
    public boolean isAmbientColorEnabled() {
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("isAmbientColorEnabled() => ").append(this.ambientColorEnabled).log();
        }
        return this.ambientColorEnabled;
    }

    @Override
    public int getAmbientColor() {
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("getAmbientColor() => ").append(this.getColorAsString(this.ambientColor)).log();
        }
        return this.ambientColor;
    }

    @Override
    public int getAmbientInteriorColor() {
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("getAmbientInteriorColor() => ").append(this.getColorAsString(this.ambientInteriorColor)).log();
        }
        return this.ambientInteriorColor;
    }

    @Override
    public int getAmbientColor(int n) {
        int n2 = this.bapColors == null ? n : this.getMappedColor(this.getMapIndex(n), n, this.displayLedColors);
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("getAmbientColor(").append(this.getColorAsString(n)).append(") => ").append(this.getColorAsString(n2)).log();
        }
        return n2;
    }

    @Override
    public int getAmbientColor(int n, int n2, int n3) {
        return this.getAmbientColor(this.getColor(n, n2, n3));
    }

    private int getColor(int n, int n2, int n3) {
        return n << 16 | n2 << 8 | n3;
    }

    private int getMapIndex(int n) {
        for (int i2 = 0; i2 < this.nrOfBapColors; ++i2) {
            if (this.bapColors[i2] != n) continue;
            return i2;
        }
        return -1;
    }

    private int getMappedColor(int n, int n2, int[] nArray) {
        int n3;
        int n4 = n3 = n < 0 ? -3 : nArray[n];
        if (n3 == -3) {
            n3 = this.defaultColorIndex < 0 ? n2 : nArray[this.defaultColorIndex];
        }
        if (n3 == -2) {
            n3 = n2;
        }
        return n3;
    }

    @Override
    public void addSkinInformationReceiver(SkinInformationReceiver skinInformationReceiver) {
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("addSkinInformationReceiver(").append(skinInformationReceiver).append(")").log();
        }
        this.skinInformationReceivers = this.skinInformationReceivers.add(skinInformationReceiver);
    }

    @Override
    public void removeSkinInformationReceiver(SkinInformationReceiver skinInformationReceiver) {
        if (this.logger.isTraceEnabled(4)) {
            this.logger.trace(4).append("removeSkinInformationReceiver(").append(skinInformationReceiver).append(")").log();
        }
        this.skinInformationReceivers = this.skinInformationReceivers.remove(skinInformationReceiver);
    }

    private void notifySkinInformationReceivers(int n) {
        block6: for (CowList cowList = this.skinInformationReceivers; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            SkinInformationReceiver skinInformationReceiver = (SkinInformationReceiver)cowList.head();
            switch (n) {
                case 0: {
                    if (this.logger.isTraceEnabled(4)) {
                        this.logger.trace(4).append(skinInformationReceiver).append(".receiveCurrentSkinMode(").append(this.skinMode).append(")").log();
                    }
                    skinInformationReceiver.receiveCurrentSkinMode(this.skinMode);
                    continue block6;
                }
                case 1: {
                    if (this.logger.isTraceEnabled(4)) {
                        this.logger.trace(4).append(skinInformationReceiver).append(".receiveAmbientColorEnabled(").append(this.ambientColorEnabled).append(")").log();
                    }
                    skinInformationReceiver.receiveAmbientColorEnabled(this.ambientColorEnabled);
                    continue block6;
                }
                case 2: {
                    if (this.logger.isTraceEnabled(4)) {
                        this.logger.trace(4).append(skinInformationReceiver).append(".receiveAmbientColor(").append(this.getColorAsString(this.ambientColor)).append(")").log();
                    }
                    skinInformationReceiver.receiveAmbientColor(this.ambientColor);
                    continue block6;
                }
                case 3: {
                    if (this.logger.isTraceEnabled(4)) {
                        this.logger.trace(4).append(skinInformationReceiver).append(".receiveAmbientHmiAndSrgbColor(\"").append(this.ambientColorEnabled ? this.hmiColorString : "none").append("\", \"").append(this.ambientColorEnabled ? this.srgbColorString : "none").append("\")").log();
                    }
                    skinInformationReceiver.receiveAmbientHmiAndSrgbColor(this.ambientColorEnabled ? this.hmiColorString : "none", this.ambientColorEnabled ? this.srgbColorString : "none");
                    continue block6;
                }
            }
        }
    }

    private String getColorForHAS(int n) {
        if (n == -1) {
            return "none";
        }
        if (n >= 0 && n < 1) {
            return this.getColorAsString(n);
        }
        throw new IllegalArgumentException(new StringBuffer().append(String.valueOf(n)).append(" is not a valid color for HAS!").toString());
    }

    private String getColorAsString(int n) {
        StringBuffer stringBuffer = new StringBuffer(7);
        stringBuffer.append('#');
        for (int i2 = 5; i2 >= 0; --i2) {
            stringBuffer.append(HEX_DIGITS[n >> 4 * i2 & 0xF]);
        }
        return stringBuffer.toString();
    }

    private void readAmbienceColorMap() {
        this.readAmbienceColorMap(new File(new StringBuffer().append(this.configurationManager.getSkinPath(this.configurationManager.getCurrentSkinId())).append("/").append("ambienceColorMap").append(".res").toString()), this.configurationManager.getEncodedVehicleType());
    }

    private void readAmbienceColorMap(File file, String string) {
        this.bapColors = null;
        this.defaultColorIndex = -1;
        this.nrOfBapColors = 0;
        Object[] objectArray = null;
        if (file.exists()) {
            objectArray = this.readDataFromObjectSwapperFile(file.getPath());
        }
        if (objectArray != null && objectArray.length > 2) {
            String[] stringArray = (String[])objectArray[1];
            int[] nArray = (int[])objectArray[2];
            int n = 0;
            int n2 = nArray[n++];
            this.bapColors = new int[n2];
            this.displayColors = new int[n2];
            this.srgbColors = new int[n2];
            this.displayLedColors = new int[n2];
            for (int i2 = 0; i2 < n2; ++i2) {
                int n3;
                int n4 = nArray[n++];
                int n5 = nArray[n++];
                int n6 = nArray[n++];
                int n7 = nArray[n++];
                int n8 = nArray[n++];
                boolean bl = false;
                for (n3 = 0; n3 < this.nrOfBapColors; ++n3) {
                    if (this.bapColors[n3] != n5) continue;
                    bl = true;
                    break;
                }
                if (bl) {
                    if (n4 < 0 || !this.carIdsMatch(stringArray[n4], string)) continue;
                    if (n5 == -1) {
                        this.defaultColorIndex = n3;
                    }
                    this.bapColors[n3] = n5;
                    this.displayColors[n3] = n6;
                    this.srgbColors[n3] = n7;
                    this.displayLedColors[n3] = n8;
                    continue;
                }
                if (n4 >= 0 && !this.carIdsMatch(stringArray[n4], string)) continue;
                if (n5 == -1) {
                    this.defaultColorIndex = this.nrOfBapColors;
                }
                this.bapColors[this.nrOfBapColors] = n5;
                this.displayColors[this.nrOfBapColors] = n6;
                this.srgbColors[this.nrOfBapColors] = n7;
                this.displayLedColors[this.nrOfBapColors] = n8;
                ++this.nrOfBapColors;
            }
            this.isSetEnabled = true;
        } else {
            this.logger.error(4).append("Couldn't read ambience the color map '").append(file).append("'.").log();
            this.bapColors = new int[0];
        }
    }

    private boolean carIdsMatch(String string, String string2) {
        if (string.length() != string2.length()) {
            return false;
        }
        for (int i2 = string2.length() - 1; i2 >= 0; --i2) {
            char c2;
            char c3 = string.charAt(i2);
            if (c3 == (c2 = string2.charAt(i2)) || c3 == '?') continue;
            return false;
        }
        return true;
    }

    public Object[] readDataFromObjectSwapperFile(String string) {
        File file = new File(string);
        if (ServiceManager.fileManager != null) {
            try {
                Object[] objectArray = ServiceManager.fileManager.readDataFromObjectSwapperFile(file);
                return objectArray;
            }
            catch (IOException iOException) {
                this.logger.warn(2).append("Couldn't read the configuration file '").append(file.getAbsolutePath()).append("'.").attachThrowable(iOException).log();
            }
        }
        return null;
    }

    @Override
    public void notifyNvListener(int n) {
        if (n == 1) {
            this.skinMode = this.configurationManager.getCurrentSkinMode();
            this.notifySkinInformationReceivers(0);
        } else if (n == 3) {
            this.readAmbienceColorMap();
            this.setIntLightAmbientLightColor(this.currentBapColor >> 16 & 0xFF, this.currentBapColor >> 8 & 0xFF, this.currentBapColor & 0xFF);
        }
    }

    static {
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }
}

