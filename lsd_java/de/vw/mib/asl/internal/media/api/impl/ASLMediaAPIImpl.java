/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.api.impl;

import de.vw.mib.asl.api.devicehandling.ASLDeviceHandlingFactory;
import de.vw.mib.asl.api.media.ASLMediaAPI;
import de.vw.mib.asl.api.media.AlphabeticalScrollBarInfo;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.id.PreRegisteredIds;
import de.vw.mib.asl.internal.media.common.HASUtil;
import de.vw.mib.asl.internal.media.sourcehandling.clients.MediaDevices;
import de.vw.mib.asl.internal.media.sourcehandling.helper.MediaDiagnosticHelper;
import de.vw.mib.asl.internal.media.sourcehandling.state.DeviceCollector;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.util.Util;
import java.io.UnsupportedEncodingException;
import org.dsi.ifc.global.CharacterInfo;

public class ASLMediaAPIImpl
implements ASLMediaAPI {
    private MediaDevices mediaDevices;
    private static final int ASCII_CHARS;
    private static final int ASCII_MASK;
    private static final String[] ASCII_CHAR_STRINGS;

    @Override
    public int convertHASSourceIdToAslDeviceId(int n) {
        return HASUtil.convertHASSourceIdASL(n);
    }

    @Override
    public int getASLDeviceIdForDSIDiagnoseSystemId(int n) {
        return MediaDiagnosticHelper.getASLDeviceIdForDSIDiagnoseSystemId(n);
    }

    @Override
    public boolean isASLDeviceIdForDSIDiagnoseSystemIdAvailable(int n) {
        int n2 = MediaDiagnosticHelper.getASLDeviceIdForDSIDiagnoseSystemId(n);
        return this.isASLDeviceIdAvailable(n2);
    }

    private boolean isASLDeviceIdAvailable(int n) {
        if (n == 0) {
            return false;
        }
        if (this.mediaDevices == null) {
            ServiceManager.logger.error(1024).attachThrowable(new IllegalStateException("Call to isDeviceAvailable before media is initialized.")).log();
            return false;
        }
        DeviceCollector deviceCollector = this.mediaDevices.getByAslDeviceId(n);
        if (deviceCollector == DeviceCollector.EMPTY) {
            return false;
        }
        return deviceCollector.getMainPartition().check();
    }

    @Override
    public boolean isASLDeviceIdForSpeechAvailable(int n) {
        return this.isASLDeviceIdAvailable(n);
    }

    public void setMediaDevices(MediaDevices mediaDevices) {
        this.mediaDevices = mediaDevices;
    }

    @Override
    public AlphabeticalScrollBarInfo convertCharacterInfo(CharacterInfo[] characterInfoArray) {
        if (Util.isNullOrEmpty(characterInfoArray)) {
            return new AlphabeticalScrollBarInfo(new String[0], new int[0]);
        }
        int[] nArray = new int[characterInfoArray.length];
        String[] stringArray = new String[characterInfoArray.length];
        int n = characterInfoArray[0].getIndex();
        for (int i2 = 0; i2 < characterInfoArray.length; ++i2) {
            CharacterInfo characterInfo = characterInfoArray[i2];
            nArray[i2] = characterInfo.getIndex() - n;
            stringArray[i2] = ASLMediaAPIImpl.convertUTF8BEIntToString(characterInfo.getValue());
        }
        return new AlphabeticalScrollBarInfo(stringArray, nArray);
    }

    private static String convertUTF8BEIntToString(int n) {
        String string;
        if (n == (n & 0x7F)) {
            string = ASLMediaAPIImpl.charToString((char)n);
        } else {
            byte by = (byte)(n >> 24);
            byte by2 = (byte)(n >> 16);
            byte by3 = (byte)(n >> 8);
            byte by4 = (byte)n;
            byte[] byArray = 0 != by ? new byte[]{by, by2, by3, by4} : (0 != by2 ? new byte[]{by2, by3, by4} : (0 != by3 ? new byte[]{by3, by4} : new byte[]{by4}));
            if (ASLMediaAPIImpl.validateUTF8Sequence(byArray)) {
                try {
                    string = new String(byArray, "UTF8");
                }
                catch (UnsupportedEncodingException unsupportedEncodingException) {
                    throw new RuntimeException("UTF8 conversion failed", unsupportedEncodingException);
                }
            } else if (n < -65536) {
                string = String.valueOf((char)n);
            } else {
                String string2 = "?!";
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Illegal UTF8/16 byte sequence: ");
                ASLMediaAPIImpl.appendSequence(stringBuilder, byArray);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }
        return string;
    }

    private static boolean validateUTF8Sequence(byte[] byArray) {
        int n = byArray.length;
        int n2 = 1 == n ? 128 : -128 >> n & 0xFF;
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            if ((byArray[i2] & n2) != (n2 << 1 & n2)) {
                return false;
            }
            n2 = 192;
        }
        return true;
    }

    private static StringBuilder appendSequence(StringBuilder stringBuilder, byte[] byArray) {
        if (null == byArray) {
            stringBuilder.append("null");
        } else {
            stringBuilder.append("[");
            for (int i2 = 0; i2 < byArray.length; ++i2) {
                if (0 < i2) {
                    stringBuilder.append(" ");
                }
                stringBuilder.append("0x").append(ASLMediaAPIImpl.nibbleToHexChar(byArray[i2] >> 4)).append(ASLMediaAPIImpl.nibbleToHexChar(byArray[i2]));
            }
            stringBuilder.append("]");
        }
        return stringBuilder;
    }

    private static char nibbleToHexChar(int n) {
        return (char)(10 <= (n &= 0xF) ? 48 + n : 87 + n);
    }

    private static String charToString(char c2) {
        String string = c2 < '\u0080' ? ASCII_CHAR_STRINGS[c2] : Character.toString(c2);
        return string;
    }

    static {
        PreRegisteredIds.addServiceOrObserverToArray(0, 1957630720, -1043976960, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 1957630720, -1060754176, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 296686336, -1027199744, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 1957630720, -976868096, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 313463552, -1010422528, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 1957630720, -960090880, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 1957630720, -943313664, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 313463552, -993645312, true);
        PreRegisteredIds.addServiceOrObserverToArray(0, 330240768, -909759232, true);
        ASLDeviceHandlingFactory.getDeviceHandlingApi();
        ASCII_CHAR_STRINGS = new String[128];
        for (char c2 = '\u0000'; c2 < '\u0080'; c2 = (char)(c2 + '\u0001')) {
            ASLMediaAPIImpl.ASCII_CHAR_STRINGS[c2] = Character.toString(c2);
        }
    }
}

