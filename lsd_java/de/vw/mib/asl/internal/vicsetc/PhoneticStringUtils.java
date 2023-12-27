/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.vicsetc;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.util.StringUtil;
import de.vw.mib.asl.internal.vicsetc.VicsTarget;
import de.vw.mib.util.StringBuilder;

public class PhoneticStringUtils {
    private static final String XML_START_ELEMENT;
    private static final String XML_END_ELEMENT;
    private static final String PHONEME_ATTRIBUTE_TAG;
    private static final String ALPHABET_ATTRIBUTE_TAG;
    private static final char QUOTE_CHAR;
    private static final char XML_START_TAG_CHAR;
    private static final String[] XML_TAG_STRINGS;
    private static final String[] XML_TAG_CONVERTED_STRINGS;

    public static String extractPhonemeString(String string, VicsTarget vicsTarget) {
        if (ServiceManager.logger.isTraceEnabled(16)) {
            ServiceManager.logger.trace(16, new StringBuffer().append("extractPhonemeString ( toProcess = ").append(string).append(" )").toString());
        }
        if (string != null && PhoneticStringUtils.isXMLFormat(string) && vicsTarget.isLanguageJP()) {
            return PhoneticStringUtils.decodePhoneticString(PhoneticStringUtils.extractTag(string, "ph="));
        }
        return "";
    }

    public static String extractPhonemeAlphabet(String string, VicsTarget vicsTarget) {
        if (ServiceManager.logger.isTraceEnabled(16)) {
            ServiceManager.logger.trace(16, new StringBuffer().append("extractPhonemeAlphabet ( toProcess = ").append(string).append(" )").toString());
        }
        if (string != null && PhoneticStringUtils.isXMLFormat(string) && vicsTarget.isLanguageJP()) {
            return PhoneticStringUtils.extractTag(string, "alphabet=");
        }
        return "";
    }

    private static boolean isXMLFormat(String string) {
        if (ServiceManager.logger.isTraceEnabled(16)) {
            ServiceManager.logger.trace(16, new StringBuffer().append("isXMLFormat ( toProcess = ").append(string).append(" )").toString());
        }
        if (StringUtil.isEmpty(string)) {
            return false;
        }
        int n = string.indexOf("<phoneme ");
        int n2 = string.indexOf("></phoneme>");
        return 0 <= n && 0 <= n2 && n < n2;
    }

    private static String extractTag(String string, String string2) {
        if (ServiceManager.logger.isTraceEnabled(16)) {
            ServiceManager.logger.trace(16, new StringBuffer().append("extractTag ( toExtract = ").append(string).append(" TAG_TO_EXTRACT= ").append(string2).append(")").toString());
        }
        if (string == null || string2 == null) {
            if (ServiceManager.logger.isTraceEnabled(16)) {
                ServiceManager.logger.trace(16, "extractTag() null parameter");
            }
            return "";
        }
        char[] cArray = string.toCharArray();
        int n = string.indexOf(new StringBuffer().append(string2).append('\"').toString());
        if (n == -1 && ServiceManager.logger.isTraceEnabled(16)) {
            ServiceManager.logger.trace(16, "extractTag() Tag was not found!");
            return "";
        }
        int n2 = n + string2.length() + "\"".length();
        int n3 = -1;
        for (int i2 = n2; i2 < cArray.length; ++i2) {
            if (cArray[i2] != '\"') continue;
            n3 = i2;
            break;
        }
        if (n2 < n3) {
            String string3 = String.copyValueOf(cArray, n2, n3 - n2);
            if (ServiceManager.logger.isTraceEnabled(16)) {
                ServiceManager.logger.trace(16, new StringBuffer().append("extractTag() : ").append(string3).toString());
            }
            return string3;
        }
        if (ServiceManager.logger.isTraceEnabled(16)) {
            ServiceManager.logger.trace(16, "extractTag() - empty");
        }
        return "";
    }

    private static String decodePhoneticString(String string) {
        if (ServiceManager.logger.isTraceEnabled(16)) {
            ServiceManager.logger.trace(16, new StringBuffer().append("decodePhoneticString ( encoded = ").append(string).append(" )").toString());
        }
        if (string == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        char[] cArray = string.toCharArray();
        int n = 0;
        while (n < cArray.length) {
            if (cArray[n] == '&') {
                boolean bl = true;
                for (int i2 = 0; i2 < XML_TAG_STRINGS.length; ++i2) {
                    if (!string.startsWith(XML_TAG_STRINGS[i2], n)) continue;
                    stringBuilder.append(XML_TAG_CONVERTED_STRINGS[i2]);
                    bl = false;
                    n += XML_TAG_STRINGS[i2].length();
                    break;
                }
                if (!bl) continue;
                stringBuilder.append(cArray[n]);
                ++n;
                continue;
            }
            stringBuilder.append(cArray[n]);
            ++n;
        }
        String string2 = stringBuilder.toString();
        if (ServiceManager.logger.isTraceEnabled(16)) {
            ServiceManager.logger.trace(16, new StringBuffer().append("decodePhoneticString() : ").append(string2).toString());
        }
        return string2;
    }

    static {
        XML_TAG_STRINGS = new String[]{"&amp;", "&apos;", "&quot;", "&lt;", "&gt;"};
        XML_TAG_CONVERTED_STRINGS = new String[]{"&", "'", "\"", "<", ">"};
    }
}

