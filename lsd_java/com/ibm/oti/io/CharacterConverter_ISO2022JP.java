/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.io;

import com.ibm.oti.io.CharacterConverter;
import com.ibm.oti.io.CharacterConverter_EUC_JP;
import com.ibm.oti.util.BinarySearch;
import java.io.ByteArrayOutputStream;

class CharacterConverter_ISO2022JP
extends CharacterConverter {
    private boolean isModal = true;
    private int countMode = 1;
    private int byteMode = 1;
    private int charMode = 1;
    private static final int UNKOWN;
    private static final int ASCII;
    private static final int ROMAN;
    private static final int JIS6226;
    private static final int JIS208;
    private static final int JIS201;
    private static final byte[] EMPTY;
    private static final byte[] ESC_ASCII;
    private static final byte[] ESC_ROMAN;
    private static final byte[] ESC_JIS6226;
    private static final byte[] ESC_JIS208;
    private static final byte[] ESC_JIS201;

    static {
        EMPTY = new byte[0];
        ESC_ASCII = new byte[]{27, 40, 66};
        ESC_ROMAN = new byte[]{27, 40, 74};
        ESC_JIS6226 = new byte[]{27, 36, 64};
        ESC_JIS208 = new byte[]{27, 36, 66};
        ESC_JIS201 = new byte[]{27, 40, 73};
    }

    CharacterConverter_ISO2022JP() {
    }

    @Override
    public CharacterConverter getModeless() {
        this.isModal = false;
        return this;
    }

    @Override
    public int countChars(byte[] byArray, int n, int n2) {
        if (n2 < 0) {
            throw new StringIndexOutOfBoundsException();
        }
        int n3 = 1;
        if (this.isModal) {
            n3 = this.countMode;
        }
        int n4 = n + n2;
        int n5 = 0;
        while (n < n4) {
            int n6;
            if ((n6 = byArray[n++] & 0xFF) == 27) {
                if (n + 1 >= n4) break;
                if (byArray[n] == 40) {
                    if (byArray[n + 1] == 66) {
                        n3 = 1;
                        n += 2;
                        continue;
                    }
                    if (byArray[n + 1] == 74) {
                        n3 = 2;
                        n += 2;
                        continue;
                    }
                    if (byArray[n + 1] == 73) {
                        n3 = 5;
                        n += 2;
                        continue;
                    }
                } else if (byArray[n] == 36) {
                    if (byArray[n + 1] == 64) {
                        n3 = 3;
                        n += 2;
                        continue;
                    }
                    if (byArray[n + 1] == 66) {
                        n3 = 4;
                        n += 2;
                        continue;
                    }
                }
            }
            if (n3 == 3 || n3 == 4 && n6 >= 32) {
                if (n >= n4) break;
                ++n;
            }
            ++n5;
        }
        if (this.isModal) {
            this.countMode = n3;
        }
        return n5;
    }

    @Override
    public int convert(byte[] byArray, int n, char[] cArray, int n2, int n3) {
        int n4 = 1;
        if (this.isModal) {
            n4 = this.byteMode;
        }
        n3 += n2;
        while (n2 < n3) {
            int n5;
            if ((n5 = byArray[n++] & 0xFF) == 27 && n + 1 < byArray.length) {
                if (byArray[n] == 40) {
                    if (byArray[n + 1] == 66) {
                        n4 = 1;
                        n += 2;
                        continue;
                    }
                    if (byArray[n + 1] == 74) {
                        n4 = 2;
                        n += 2;
                        continue;
                    }
                    if (byArray[n + 1] == 73) {
                        n4 = 5;
                        n += 2;
                        continue;
                    }
                } else if (byArray[n] == 36) {
                    if (byArray[n + 1] == 64) {
                        n4 = 3;
                        n += 2;
                        continue;
                    }
                    if (byArray[n + 1] == 66) {
                        n4 = 4;
                        n += 2;
                        continue;
                    }
                }
            }
            if (n4 == 1) {
                if (n5 >= 128) continue;
                cArray[n2++] = (char)n5;
                continue;
            }
            if (n4 == 2) {
                if (n5 == 92) {
                    cArray[n2++] = 165;
                    continue;
                }
                if (n5 == 126) {
                    cArray[n2++] = 8254;
                    continue;
                }
                if (n5 >= 128) continue;
                cArray[n2++] = (char)n5;
                continue;
            }
            if (n4 == 5) {
                if (n5 < 33 || n5 > 95) continue;
                cArray[n2++] = (char)(0x40FF0000 + n5);
                continue;
            }
            if (n5 >= 33 && n5 <= 126) {
                int n6;
                if ((n6 = byArray[n++] & 0xFF) >= 33 && n6 <= 126) {
                    cArray[n2++] = CharacterConverter_EUC_JP.jis208.charAt((n5 - 33) * 94 + n6 - 33);
                    continue;
                }
                cArray[n2++] = -33619968;
                continue;
            }
            if (n5 >= 32) {
                ++n;
            }
            cArray[n2++] = -33619968;
        }
        if (this.isModal) {
            this.byteMode = n4;
        }
        return n;
    }

    @Override
    public byte[] convert(char[] cArray, int n, int n2) {
        int n3 = 1;
        if (this.isModal) {
            n3 = this.charMode;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(n2 += n);
        int n4 = n;
        while (n4 < n2) {
            char c2 = cArray[n4];
            if (c2 < '\u0080') {
                if (n3 != 1) {
                    byteArrayOutputStream.write(ESC_ASCII, 0, ESC_ASCII.length);
                    n3 = 1;
                }
                byteArrayOutputStream.write(c2);
            } else if (c2 == '\u00a5' || c2 == '\u203e') {
                if (n3 != 2) {
                    byteArrayOutputStream.write(ESC_ROMAN, 0, ESC_ROMAN.length);
                    n3 = 2;
                }
                if (c2 == '\u00a5') {
                    byteArrayOutputStream.write(92);
                } else {
                    byteArrayOutputStream.write(126);
                }
            } else {
                int n5 = BinarySearch.binarySearch(CharacterConverter_EUC_JP.keys, cArray[n4]);
                if (n5 == -1) {
                    if (n3 != 1) {
                        byteArrayOutputStream.write(ESC_ASCII, 0, ESC_ASCII.length);
                        n3 = 1;
                    }
                    byteArrayOutputStream.write(63);
                } else {
                    char c3 = CharacterConverter_EUC_JP.values.charAt(n5);
                    byte by = (byte)(c3 >> 8);
                    if (by < 0 && by >= -96) {
                        if (n3 != 4) {
                            byteArrayOutputStream.write(ESC_JIS208, 0, ESC_JIS208.length);
                            n3 = 4;
                        }
                        byteArrayOutputStream.write(by - 128);
                        byteArrayOutputStream.write(c3 - 128);
                    } else if (by == -114) {
                        if (n3 != 5) {
                            byteArrayOutputStream.write(ESC_JIS201, 0, ESC_JIS201.length);
                            n3 = 5;
                        }
                        byteArrayOutputStream.write(c3 - 128);
                    } else {
                        if (n3 != 1) {
                            byteArrayOutputStream.write(ESC_ASCII, 0, ESC_ASCII.length);
                            n3 = 1;
                        }
                        byteArrayOutputStream.write(63);
                    }
                }
            }
            ++n4;
        }
        if (this.isModal) {
            this.charMode = n3;
        } else if (n3 != 1) {
            byteArrayOutputStream.write(ESC_ASCII, 0, ESC_ASCII.length);
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public byte[] getClosingBytes() {
        if (this.charMode != 1) {
            return ESC_ASCII;
        }
        return EMPTY;
    }
}

