/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.io;

import com.ibm.oti.io.CharBuffer;
import com.ibm.oti.io.NativeCharacterConverter;
import com.ibm.oti.vm.VM;
import java.util.HashMap;

public class CharacterConverter {
    private String name;
    private static byte[] EMPTY = new byte[0];
    private static final boolean useNative = VM.useNatives();
    private static HashMap mappings = new HashMap(350);

    static {
        mappings.put("8859-1", "ISO8859_1");
        mappings.put("ISO8859-1", "ISO8859_1");
        mappings.put("ISO-8859-1", "ISO8859_1");
        mappings.put("ISO-8859-1:1987", "ISO8859_1");
        mappings.put("ISO-IR-100", "ISO8859_1");
        mappings.put("LATIN1", "ISO8859_1");
        mappings.put("CSISOLATIN1", "ISO8859_1");
        mappings.put("CP819", "ISO8859_1");
        mappings.put("IBM-819", "ISO8859_1");
        mappings.put("IBM819", "ISO8859_1");
        mappings.put("L1", "ISO8859_1");
        mappings.put("8859-2", "ISO8859_2");
        mappings.put("ISO8859-2", "ISO8859_2");
        mappings.put("ISO-8859-2", "ISO8859_2");
        mappings.put("ISO-8859-2:1987", "ISO8859_2");
        mappings.put("ISO-IR-101", "ISO8859_2");
        mappings.put("LATIN2", "ISO8859_2");
        mappings.put("CSISOLATIN2", "ISO8859_2");
        mappings.put("CP912", "ISO8859_2");
        mappings.put("IBM-912", "ISO8859_2");
        mappings.put("IBM912", "ISO8859_2");
        mappings.put("L2", "ISO8859_2");
        mappings.put("8859-3", "ISO8859_3");
        mappings.put("ISO8859-3", "ISO8859_3");
        mappings.put("ISO-8859-3", "ISO8859_3");
        mappings.put("ISO-8859-3:1988", "ISO8859_3");
        mappings.put("ISO-IR-109", "ISO8859_3");
        mappings.put("LATIN3", "ISO8859_3");
        mappings.put("CSISOLATIN3", "ISO8859_3");
        mappings.put("CP913", "ISO8859_3");
        mappings.put("IBM-913", "ISO8859_3");
        mappings.put("L3", "ISO8859_3");
        mappings.put("8859-4", "ISO8859_4");
        mappings.put("ISO8859-4", "ISO8859_4");
        mappings.put("ISO-8859-4", "ISO8859_4");
        mappings.put("ISO-8859-4:1988", "ISO8859_4");
        mappings.put("ISO-IR-110", "ISO8859_4");
        mappings.put("LATIN4", "ISO8859_4");
        mappings.put("CSISOLATIN4", "ISO8859_4");
        mappings.put("CP914", "ISO8859_4");
        mappings.put("IBM-914", "ISO8859_4");
        mappings.put("L4", "ISO8859_4");
        mappings.put("8859-5", "ISO8859_5");
        mappings.put("ISO8859-5", "ISO8859_5");
        mappings.put("ISO-8859-5", "ISO8859_5");
        mappings.put("ISO-8859-5:1988", "ISO8859_5");
        mappings.put("ISO-IR-144", "ISO8859_5");
        mappings.put("CYRILLIC", "ISO8859_5");
        mappings.put("CSISOLATINCYRILLIC", "ISO8859_5");
        mappings.put("CP915", "ISO8859_5");
        mappings.put("IBM-915", "ISO8859_5");
        mappings.put("IBM915", "ISO8859_5");
        mappings.put("8859-6", "ISO8859_6");
        mappings.put("ARABIC", "ISO8859_6");
        mappings.put("ASMO-708", "ISO8859_6");
        mappings.put("CP1089", "ISO8859_6");
        mappings.put("CSISOLATINARABIC", "ISO8859_6");
        mappings.put("ECMA-114", "ISO8859_6");
        mappings.put("IBM-1089", "ISO8859_6");
        mappings.put("IBM1089", "ISO8859_6");
        mappings.put("ISO-8859-6", "ISO8859_6");
        mappings.put("ISO-8859-6:1987", "ISO8859_6");
        mappings.put("ISO-IR-127", "ISO8859_6");
        mappings.put("ISO8859-6", "ISO8859_6");
        mappings.put("8859-7", "ISO8859_7");
        mappings.put("CP813", "ISO8859_7");
        mappings.put("ISO-8859-7", "ISO8859_7");
        mappings.put("CSISOLATINGREEK", "ISO8859_7");
        mappings.put("ECMA-118", "ISO8859_7");
        mappings.put("ELOT-928", "ISO8859_7");
        mappings.put("GREEK", "ISO8859_7");
        mappings.put("GREEK8", "ISO8859_7");
        mappings.put("IBM-813", "ISO8859_7");
        mappings.put("IBM813", "ISO8859_7");
        mappings.put("ISO-8859-7:1987", "ISO8859_7");
        mappings.put("ISO-IR-126", "ISO8859_7");
        mappings.put("ISO8859-7", "ISO8859_7");
        mappings.put("8859-8", "ISO8859_8");
        mappings.put("CP916", "ISO8859_8");
        mappings.put("CSISOLATINHEBREW", "ISO8859_8");
        mappings.put("HEBREW", "ISO8859_8");
        mappings.put("IBM-916", "ISO8859_8");
        mappings.put("IBM916", "ISO8859_8");
        mappings.put("ISO-8859-8", "ISO8859_8");
        mappings.put("ISO-8859-8:1988", "ISO8859_8");
        mappings.put("ISO-IR-138", "ISO8859_8");
        mappings.put("ISO8859-8", "ISO8859_8");
        mappings.put("8859-9", "ISO8859_9");
        mappings.put("ISO8859-9", "ISO8859_9");
        mappings.put("ISO-8859-9", "ISO8859_9");
        mappings.put("ISO-IR-148", "ISO8859_9");
        mappings.put("LATIN5", "ISO8859_9");
        mappings.put("CSISOLATIN5", "ISO8859_9");
        mappings.put("CP920", "ISO8859_9");
        mappings.put("IBM-920", "ISO8859_9");
        mappings.put("IBM920", "ISO8859_9");
        mappings.put("L5", "ISO8859_9");
        mappings.put("8859-10", "ISO8859_10");
        mappings.put("ISO-8859-10", "ISO8859_10");
        mappings.put("ISO_8859-10:1992", "ISO8859_10");
        mappings.put("CSISOLATIN6", "ISO8859_10");
        mappings.put("IBM-919", "ISO8859_10");
        mappings.put("ISO-IR-157", "ISO8859_10");
        mappings.put("ISO8859-10", "ISO8859_10");
        mappings.put("L6", "ISO8859_10");
        mappings.put("LATIN6", "ISO8859_10");
        mappings.put("8859-13", "ISO8859_13");
        mappings.put("ISO-8859-13", "ISO8859_13");
        mappings.put("ISO8859-13", "ISO8859_13");
        mappings.put("8859-14", "ISO8859_14");
        mappings.put("ISO-8859-14", "ISO8859_14");
        mappings.put("ISO_8859-14:1998", "ISO8859_14");
        mappings.put("ISO-IR-199", "ISO8859_14");
        mappings.put("ISO8859-14", "ISO8859_14");
        mappings.put("ISOCELTIC", "ISO8859_14");
        mappings.put("L8", "ISO8859_14");
        mappings.put("LATIN8", "ISO8859_14");
        mappings.put("8859-15", "ISO8859_15");
        mappings.put("ISO8859-15", "ISO8859_15");
        mappings.put("ISO-8859-15", "ISO8859_15");
        mappings.put("LATIN0", "ISO8859_15");
        mappings.put("LATIN9", "ISO8859_15");
        mappings.put("CSISOLATIN0", "ISO8859_15");
        mappings.put("CSISOLATIN9", "ISO8859_15");
        mappings.put("CP923", "ISO8859_15");
        mappings.put("IBM-923", "ISO8859_15");
        mappings.put("IBM923", "ISO8859_15");
        mappings.put("ISO8859_15_FDIS", "ISO8859_15");
        mappings.put("L9", "ISO8859_15");
        mappings.put("8859-16", "ISO8859_16");
        mappings.put("ISO-8859-16", "ISO8859_16");
        mappings.put("ISO8859-16", "ISO8859_16");
        mappings.put("SHIFT-JIS", "MS932");
        mappings.put("MS_KANJI", "MS932");
        mappings.put("CSSHIFTJIS", "MS932");
        mappings.put("CSWINDOWS31J", "MS932");
        mappings.put("WINDOWS-31J", "MS932");
        mappings.put("X-SJIS", "MS932");
        mappings.put("WINDOWS-932", "MS932");
        mappings.put("936", "MS936");
        mappings.put("WINDOWS-936", "MS936");
        mappings.put("CP1361", "MS949");
        mappings.put("MS949", "MS949");
        mappings.put("IBM-1361", "MS949");
        mappings.put("IBM1361", "MS949");
        mappings.put("KSC5601-1992", "MS949");
        mappings.put("MS1361", "MS949");
        mappings.put("MS_949", "MS949");
        mappings.put("WINDOWS-949", "MS949");
        mappings.put("X-WINDOWS-949", "MS949");
        mappings.put("950", "MS950");
        mappings.put("WINDOWS-950", "MS950");
        mappings.put("X-WINDOWS-950", "MS950");
        mappings.put("EUCJIS", "EUC_JP");
        mappings.put("CSEUCPKDFMTJAPANESE", "EUC_JP");
        mappings.put("EXTENDED_UNIX_CODE_PACKED_FORMAT_FOR_JAPANESE", "EUC_JP");
        mappings.put("EUC-JP", "EUC_JP");
        mappings.put("EUCJP", "EUC_JP");
        mappings.put("X-EUC-JP", "EUC_JP");
        mappings.put("X-EUCJP", "EUC_JP");
        mappings.put("EUC-JP-LINUX", "EUC_JP");
        mappings.put("KSC5601", "EUC_KR");
        mappings.put("KS_C_5601-1987", "EUC_KR");
        mappings.put("KSC-5601", "EUC_KR");
        mappings.put("EUC-KR", "EUC_KR");
        mappings.put("EUCKR", "EUC_KR");
        mappings.put("KSC5601-1987", "EUC_KR");
        mappings.put("5601", "EUC_KR");
        mappings.put("CP970", "EUC_KR");
        mappings.put("IBM-970", "EUC_KR");
        mappings.put("IBM-EUCKR", "EUC_KR");
        mappings.put("JIS", "ISO2022JP");
        mappings.put("ISO-2022-JP", "ISO2022JP");
        mappings.put("CSISO2022JP", "ISO2022JP");
        mappings.put("JIS-ENCODING", "ISO2022JP");
        mappings.put("CSJISENCODING", "ISO2022JP");
        mappings.put("ISO2022-JP", "ISO2022JP");
        mappings.put("BIG5-HKSCS", "BIG5");
        mappings.put("BIG5-0", "BIG5");
        mappings.put("GB18030-2000", "GB18030");
        mappings.put("IBM-1392", "GB18030");
        mappings.put("WINDOWS-54936", "GB18030");
        mappings.put("IBM-437", "CP437");
        mappings.put("IBM437", "CP437");
        mappings.put("437", "CP437");
        mappings.put("CSPC8CODEPAGE437", "CP437");
        mappings.put("IBM-850", "CP850");
        mappings.put("IBM850", "CP850");
        mappings.put("850", "CP850");
        mappings.put("CSPC850MULTILINGUAL", "CP850");
        mappings.put("IBM-852", "CP852");
        mappings.put("IBM852", "CP852");
        mappings.put("852", "CP852");
        mappings.put("CSPCP852", "CP852");
        mappings.put("IBM-858", "CP858");
        mappings.put("IBM858", "CP858");
        mappings.put("858", "CP858");
        mappings.put("CSPC858MULTILINGUAL", "CP858");
        mappings.put("IBM-860", "CP860");
        mappings.put("IBM860", "CP860");
        mappings.put("860", "CP860");
        mappings.put("CSIBM860", "CP860");
        mappings.put("IBM-863", "CP863");
        mappings.put("IBM863", "CP863");
        mappings.put("863", "CP863");
        mappings.put("CSIBM863", "CP863");
        mappings.put("IBM-865", "CP865");
        mappings.put("IBM865", "CP865");
        mappings.put("865", "CP865");
        mappings.put("CSIBM865", "CP865");
        mappings.put("IBM-866", "CP866");
        mappings.put("IBM866", "CP866");
        mappings.put("866", "CP866");
        mappings.put("IBM-1250", "CP1250");
        mappings.put("WINDOWS-1250", "CP1250");
        mappings.put("IBM-1251", "CP1251");
        mappings.put("WINDOWS-1251", "CP1251");
        mappings.put("IBM-1252", "CP1252");
        mappings.put("WINDOWS-1252", "CP1252");
        mappings.put("IBM-1253", "CP1253");
        mappings.put("WINDOWS-1253", "CP1253");
        mappings.put("IBM-1254", "CP1254");
        mappings.put("WINDOWS-1254", "CP1254");
        mappings.put("IBM-1255", "CP1255");
        mappings.put("WINDOWS-1255", "CP1255");
        mappings.put("IBM-1256", "CP1256");
        mappings.put("WINDOWS-1256", "CP1256");
        mappings.put("IBM-1257", "CP1257");
        mappings.put("WINDOWS-1257", "CP1257");
        mappings.put("IBM-1129", "CP1258");
        mappings.put("IBM-1258", "CP1258");
        mappings.put("WINDOWS-1258", "CP1258");
        mappings.put("UTF-8", "UTF8");
        mappings.put("646", "ASCII");
        mappings.put("ANSI_X3.4-1968", "ASCII");
        mappings.put("ANSI_X3.4-1986", "ASCII");
        mappings.put("CP367", "ASCII");
        mappings.put("ISO-646.IRV:1991", "ASCII");
        mappings.put("ISO646-US", "ASCII");
        mappings.put("US-ASCII", "ASCII");
        mappings.put("ASCII7", "ASCII");
        mappings.put("CSASCII", "ASCII");
        mappings.put("DEFAULT", "ASCII");
        mappings.put("DIRECT", "ASCII");
        mappings.put("IBM-367", "ASCII");
        mappings.put("ISO-646.IRV:1983", "ASCII");
        mappings.put("ISO-IR-6", "ASCII");
        mappings.put("US", "ASCII");
        mappings.put("UTF-16BE", "UNICODEBIGUNMARKED");
        mappings.put("UTF-16LE", "UNICODELITTLEUNMARKED");
        mappings.put("UTF-16", "UTF16");
    }

    public int countChars(byte[] byArray, int n, int n2) {
        return n2;
    }

    public char[] convert(byte[] byArray, int n, int n2) {
        int n3 = this.countChars(byArray, n, n2);
        if (n3 == -1) {
            return new char[0];
        }
        char[] cArray = new char[n3];
        this.convert(byArray, n, cArray, 0, n3);
        return cArray;
    }

    public int convert(byte[] byArray, int n, int n2, CharBuffer charBuffer) {
        int n3 = this.countChars(byArray, n, n2);
        if (n3 == -1) {
            return n3;
        }
        if (n3 > charBuffer.getSize()) {
            n3 = charBuffer.getSize();
        }
        int n4 = charBuffer.getOffset();
        int n5 = this.convert(byArray, n, charBuffer.getChars(), n4, n3);
        charBuffer.setPos(n4 + n3);
        charBuffer.setOffset(n4 + n3);
        return n5;
    }

    public int convert(byte[] byArray, int n, char[] cArray, int n2, int n3) {
        if (useNative) {
            return this.convertImpl(byArray, n, cArray, n2, n3);
        }
        int n4 = n3;
        while (--n4 >= 0) {
            cArray[n2++] = (char)(byArray[n++] & 0xFF);
        }
        return n;
    }

    private native int convertImpl(byte[] byArray, int n, char[] cArray, int n2, int n3) {
    }

    public byte[] convert(char[] cArray, int n, int n2) {
        if (useNative) {
            return this.convertImpl(cArray, n, n2);
        }
        int n3 = n + n2;
        int n4 = 0;
        byte[] byArray = new byte[n2];
        while (n < n3) {
            char c2;
            if ((c2 = cArray[n++]) > '\u00ff') {
                if (c2 >= '\ud80000' && c2 < '\udc0000' && n < n3 && cArray[n] >= '\udc0000' && cArray[n] < '\ue00000') {
                    ++n;
                }
                byArray[n4++] = 63;
                continue;
            }
            byArray[n4++] = (byte)c2;
        }
        if (n4 < byArray.length) {
            byte[] byArray2 = new byte[n4];
            System.arraycopy((Object)byArray, 0, (Object)byArray2, 0, n4);
            return byArray2;
        }
        return byArray;
    }

    private native byte[] convertImpl(char[] cArray, int n, int n2) {
    }

    public static CharacterConverter getConverter(String string) {
        Class clazz = null;
        char[] cArray = new char[string.length()];
        int n = 0;
        while (n < cArray.length) {
            cArray[n] = Character.toUpperCase(string.charAt(n));
            ++n;
        }
        string = new String(cArray);
        String string2 = (String)mappings.get(string);
        if (string2 == null) {
            int n2 = 0;
            while (n2 < cArray.length) {
                if (cArray[n2] == '_') {
                    cArray[n2] = 45;
                }
                ++n2;
            }
            string = new String(cArray);
            string2 = (String)mappings.get(string);
        }
        if (string2 != null) {
            string = string2;
        }
        try {
            clazz = Class.forName(new StringBuffer("com.ibm.oti.io.CharacterConverter_").append(string).toString());
        }
        catch (ClassNotFoundException classNotFoundException) {
            return CharacterConverter.getNativeConverter(string);
        }
        try {
            CharacterConverter characterConverter = (CharacterConverter)clazz.newInstance();
            characterConverter.setName(string);
            return characterConverter;
        }
        catch (IllegalAccessException illegalAccessException) {
            return null;
        }
        catch (InstantiationException instantiationException) {
            return null;
        }
    }

    private static CharacterConverter getNativeConverter(String string) {
        boolean bl = NativeCharacterConverter.supportsNativeConversion();
        NativeCharacterConverter nativeCharacterConverter = null;
        if (bl) {
            nativeCharacterConverter = new NativeCharacterConverter();
            bl = nativeCharacterConverter.supportsCodePage(string);
        }
        if (bl) {
            nativeCharacterConverter.setJavaEncoding(string);
            nativeCharacterConverter.setName(string);
            return nativeCharacterConverter;
        }
        return null;
    }

    public static CharacterConverter getDefaultConverter(String string) {
        CharacterConverter characterConverter = CharacterConverter.getConverter(string);
        if (characterConverter == null) {
            characterConverter = CharacterConverter.getConverter("ISO8859_1");
        }
        if (characterConverter == null) {
            return new CharacterConverter();
        }
        return characterConverter;
    }

    public boolean isCalled(String string) {
        if (this.name == null) {
            return false;
        }
        return this.name.equals(string);
    }

    public void setName(String string) {
        this.name = string;
    }

    public CharacterConverter getModeless() {
        return this;
    }

    public byte[] getClosingBytes() {
        return EMPTY;
    }
}

