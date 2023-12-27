/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.datatypes;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;
import java.io.UnsupportedEncodingException;

public class BAPString
implements BAPEntity {
    private static final int OVERFLOW_BIT_LENGTH;
    private static final int OVERFLOW_BIT_VALUE;
    private static final int SHORT_LEN_IDENTIFIER_BYTES;
    private static final int MAX_SHORT_LEN_IDETIFIER_VALUE;
    private static final int BYTE_BITS_SIZE;
    private static final int SHORT_LEN_IDENTIFIER_BITSIZE;
    private static final int LONG_LEN_IDENTIFIER_BYES;
    private static final int LONG_LEN_IDENTIFIER_BITSIZE;
    private static final int MAXIMUM_NUMBER_OF_BYTES_OF_ONE_UTF8_CHAR;
    private static final String DOT_DOT_POSTFIX;
    private static final int DOT_DOT_UTF8_SIZE;
    private static final int MIN_SIZE_OF_STRING_MAX_SIZE_VALUE;
    private static final int MAX_TRANSMITTED_BYTE_STRING_LENGTH;
    private static final String STRING_ENCODING_TYPE;
    private static final String STRING_ENCODING_TYPE_RAW;
    private static final int BAP_NULL_STRING_BYTE_SIZE;
    private static final String BAP_NULL_STRING_PAYLOAD;
    private String content = "";
    private final int maxSize;
    private boolean reverseTrim;
    private int typeOfStringEncoding;
    private static final int TYPE_OF_STRING_ENCODING_MAX_BYTE_LENGTH;
    private static final int TYPE_OF_STRING_ENCODING_RAW_STRING;
    private static final int TYPE_OF_STRING_ENCODING_LIMIT_BY_CHARACTERS;
    private static final char ARABIC_BASIC_BEGIN;
    private static final char ARABIC_BASIC_END;

    public BAPString(int n) {
        this.maxSize = n;
        this.reverseTrim = false;
        this.typeOfStringEncoding = 0;
    }

    @Override
    public void reset() {
        this.setContent("");
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        BAPString bAPString = (BAPString)bAPEntity;
        return this.maxSize == bAPString.maxSize && this.typeOfStringEncoding == bAPString.typeOfStringEncoding && this.content.compareTo(bAPString.content) == 0;
    }

    @Override
    public void deserialize(BitStream bitStream) {
        String string;
        block5: {
            int n = this.deserializeStringLength(bitStream);
            if (n != 0) {
                byte[] byArray = bitStream.popFrontBytes(n);
                try {
                    if (this.typeOfStringEncoding == 1) {
                        string = new String(byArray, "ISO8859_1");
                        break block5;
                    }
                    string = new String(byArray, "UTF-8");
                }
                catch (UnsupportedEncodingException unsupportedEncodingException) {
                    string = "";
                }
            } else {
                string = "";
            }
        }
        this._setContent(string);
    }

    @Override
    public void serialize(BitStream bitStream) {
        byte[] byArray = this.getEncodedBytes();
        this.serializeStringLength(byArray.length, bitStream);
        bitStream.pushBytes(byArray);
    }

    @Override
    public String toString() {
        return this.content;
    }

    @Override
    public int bitSize() {
        int n = this.getEncodedBytes().length;
        int n2 = n % Short.MAX_VALUE;
        int n3 = n > 127 ? n2 * 8 + 16 : n2 * 8 + 8;
        return n3;
    }

    private int serializeStringLength(int n, BitStream bitStream) {
        int n2 = n % Short.MAX_VALUE;
        if (n > 127) {
            bitStream.pushBits(1, 1);
            bitStream.pushBits(15, n2);
        } else {
            bitStream.pushBits(8, n2);
        }
        return n2;
    }

    private int deserializeStringLength(BitStream bitStream) {
        int n = 0;
        int n2 = bitStream.bitSize();
        if (n2 > 16) {
            n = bitStream.popFrontBits(8);
            if (n > 127) {
                n <<= 8;
                n |= bitStream.popFrontBits(8);
                n &= Short.MAX_VALUE;
            }
            return n;
        }
        if (n2 > 8) {
            return bitStream.popFrontBits(8);
        }
        return n;
    }

    private int computeMaximalStringPayloadByteLength() {
        if (this.maxSize > 127) {
            return this.maxSize - 2;
        }
        if (this.maxSize > 1) {
            return this.maxSize - 1;
        }
        return this.maxSize;
    }

    private int computeMaximalStringPayloadCharacterLength() {
        return this.computeMaximalStringPayloadByteLength() / 3;
    }

    private String transformContent(String string) {
        String string2;
        switch (this.typeOfStringEncoding) {
            case 1: {
                if (string.length() > Short.MAX_VALUE) {
                    string2 = string.substring(0, Short.MAX_VALUE);
                    break;
                }
                string2 = string;
                break;
            }
            case 2: {
                string2 = this.transformContentByCharacterLength(string, this.reverseTrim);
                break;
            }
            default: {
                string2 = this.transformContentByByteLength(string, this.reverseTrim);
            }
        }
        return string2;
    }

    private String transformContentByByteLength(String string, boolean bl) {
        String string2 = string.trim();
        try {
            boolean bl2 = false;
            boolean bl3 = false;
            int n = this.computeMaximalStringPayloadByteLength();
            int n2 = string2.getBytes("UTF-8").length;
            while (n2 > n) {
                int n3 = n2 - n;
                int n4 = (int)Math.ceil((double)(string2.length() * n3) / (double)n2);
                string2 = bl ? string2.substring(n4) : string2.substring(0, string2.length() - n4);
                n2 = string2.getBytes("UTF-8").length;
                if (!bl3 && n2 > 3) {
                    n -= 3;
                    bl2 = true;
                }
                bl3 = true;
            }
            if (bl2) {
                string2 = bl ? new StringBuffer().append("\ue009").append(string2).toString() : new StringBuffer().append(string2).append("\ue009").toString();
            }
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            string2 = "";
        }
        return string2;
    }

    private String transformContentByCharacterLength(String string, boolean bl) {
        String string2 = string.trim();
        int n = this.computeMaximalStringPayloadCharacterLength();
        if (string2.length() > n) {
            if (n <= "\ue009".length()) {
                string2 = string2.substring(0, n);
            } else {
                int n2 = n - "\ue009".length();
                string2 = bl ? new StringBuffer().append("\ue009").append(string2.substring(string2.length() - n2)).toString() : new StringBuffer().append(string2.substring(0, n2)).append("\ue009").toString();
            }
        }
        return string2;
    }

    public void setContent(String string) {
        if (string == null || string.length() == 0) {
            this._setContent("");
        } else {
            this._setContent(this.transformContent(string));
        }
    }

    private void _setContent(String string) {
        this.content = string;
    }

    public void setContent(BAPString bAPString) {
        this.typeOfStringEncoding = bAPString.typeOfStringEncoding;
        if (bAPString.isNullString()) {
            this.setNullString();
        } else {
            this.setContent(bAPString.content);
        }
    }

    public void setRawContent() {
        this.typeOfStringEncoding = 1;
    }

    public void setLimitingLengthByCharacters() {
        this.typeOfStringEncoding = 2;
    }

    public void setReverseTrim() {
        this.reverseTrim = true;
    }

    public void setNullString() {
        this._setContent("\u0000");
    }

    public void setEmptyString() {
        this._setContent("");
    }

    private static byte[] charactersToBytes(char[] cArray) {
        int n = cArray.length;
        byte[] byArray = new byte[n];
        for (int i2 = 0; i2 < n; ++i2) {
            byArray[i2] = (byte)cArray[i2];
        }
        return byArray;
    }

    private byte[] getEncodedBytes() {
        byte[] byArray;
        block5: {
            if (this.typeOfStringEncoding != 1) {
                try {
                    byte[] byArray2 = this.content.getBytes("UTF-8");
                    if (byArray2.length > Short.MAX_VALUE) {
                        byte[] byArray3 = new byte[Short.MAX_VALUE];
                        System.arraycopy((Object)byArray2, 0, (Object)byArray3, 0, Short.MAX_VALUE);
                        byArray = byArray3;
                        break block5;
                    }
                    byArray = byArray2;
                }
                catch (UnsupportedEncodingException unsupportedEncodingException) {
                    byArray = new byte[]{};
                }
            } else {
                byArray = BAPString.charactersToBytes(this.content.toCharArray());
            }
        }
        return byArray;
    }

    public boolean isEmptyString() {
        return this.content.length() == 0;
    }

    public boolean isNullString() {
        return this.content.length() == 1 && this.content.endsWith("\u0000");
    }

    public boolean isArabic() {
        return BAPString._isArabic(this.toString());
    }

    private static boolean _isArabic(String string) {
        boolean bl = false;
        int n = string.length();
        for (int i2 = 0; i2 < n; ++i2) {
            char c2 = string.charAt(i2);
            if (c2 < '\u0600' || c2 > '\u06ff') continue;
            bl = true;
            break;
        }
        return bl;
    }

    public static boolean isArabic(String string) {
        return string != null ? BAPString._isArabic(string) : false;
    }
}

