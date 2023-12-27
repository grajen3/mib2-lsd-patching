/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package org.elektrobit.json.simple.parser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.elektrobit.json.simple.parser.ParseException;
import org.elektrobit.json.simple.parser.Yytoken;

class Yylex {
    public static final int YYEOF;
    private static final int ZZ_BUFFERSIZE;
    public static final int YYINITIAL;
    public static final int STRING_BEGIN;
    private static final int[] ZZ_LEXSTATE;
    private static final String ZZ_CMAP_PACKED;
    private static final char[] ZZ_CMAP;
    private static final int[] ZZ_ACTION;
    private static final String ZZ_ACTION_PACKED_0;
    private static final int[] ZZ_ROWMAP;
    private static final String ZZ_ROWMAP_PACKED_0;
    private static final int[] ZZ_TRANS;
    private static final int ZZ_UNKNOWN_ERROR;
    private static final int ZZ_NO_MATCH;
    private static final int ZZ_PUSHBACK_2BIG;
    private static final String[] ZZ_ERROR_MSG;
    private static final int[] ZZ_ATTRIBUTE;
    private static final String ZZ_ATTRIBUTE_PACKED_0;
    private Reader zzReader;
    private int zzState;
    private int zzLexicalState = 0;
    private char[] zzBuffer = new char[16384];
    private int zzMarkedPos;
    private int zzCurrentPos;
    private int zzStartRead;
    private int zzEndRead;
    private int yyline;
    private int yychar;
    private int yycolumn;
    private boolean zzAtBOL = true;
    private boolean zzAtEOF;
    private StringBuffer sb = new StringBuffer();

    private static int[] zzUnpackAction() {
        int[] nArray = new int[45];
        int n = 0;
        n = Yylex.zzUnpackAction("\u0002\u0000\u0002\u0001\u0001\u0002\u0001\u0003\u0001\u0004\u0003\u0001\u0001\u0005\u0001\u0006\u0001\u0007\u0001\b\u0001\t\u0001\n\u0001\u000b\u0001\f\u0001\r\u0005\u0000\u0001\f\u0001\u000e\u0001\u000f\u0001\u0010\u0001\u0011\u0001\u0012\u0001\u0013\u0001\u0014\u0001\u0000\u0001\u0015\u0001\u0000\u0001\u0015\u0004\u0000\u0001\u0016\u0001\u0017\u0002\u0000\u0001\u0018", n, nArray);
        return nArray;
    }

    private static int zzUnpackAction(String string, int n, int[] nArray) {
        int n2 = 0;
        int n3 = n;
        int n4 = string.length();
        while (n2 < n4) {
            int n5 = string.charAt(n2++);
            char c2 = string.charAt(n2++);
            do {
                nArray[n3++] = c2;
            } while (--n5 > 0);
        }
        return n3;
    }

    private static int[] zzUnpackRowMap() {
        int[] nArray = new int[45];
        int n = 0;
        n = Yylex.zzUnpackRowMap("\u0000\u0000\u0000\u001b\u00006\u0000Q\u0000l\u0000\u0087\u00006\u0000\u00a2\u0000\u00bd\u0000\u00d8\u00006\u00006\u00006\u00006\u00006\u00006\u0000\u00f3\u0000\u010e\u00006\u0000\u0129\u0000\u0144\u0000\u015f\u0000\u017a\u0000\u0195\u00006\u00006\u00006\u00006\u00006\u00006\u00006\u00006\u0000\u01b0\u0000\u01cb\u0000\u01e6\u0000\u01e6\u0000\u0201\u0000\u021c\u0000\u0237\u0000\u0252\u00006\u00006\u0000\u026d\u0000\u0288\u00006", n, nArray);
        return nArray;
    }

    private static int zzUnpackRowMap(String string, int n, int[] nArray) {
        int n2 = 0;
        int n3 = n;
        int n4 = string.length();
        while (n2 < n4) {
            int n5 = string.charAt(n2++) << 16;
            nArray[n3++] = n5 | string.charAt(n2++);
        }
        return n3;
    }

    private static int[] zzUnpackAttribute() {
        int[] nArray = new int[45];
        int n = 0;
        n = Yylex.zzUnpackAttribute("\u0002\u0000\u0001\t\u0003\u0001\u0001\t\u0003\u0001\u0006\t\u0002\u0001\u0001\t\u0005\u0000\b\t\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0004\u0000\u0002\t\u0002\u0000\u0001\t", n, nArray);
        return nArray;
    }

    private static int zzUnpackAttribute(String string, int n, int[] nArray) {
        int n2 = 0;
        int n3 = n;
        int n4 = string.length();
        while (n2 < n4) {
            int n5 = string.charAt(n2++);
            char c2 = string.charAt(n2++);
            do {
                nArray[n3++] = c2;
            } while (--n5 > 0);
        }
        return n3;
    }

    int getPosition() {
        return this.yychar;
    }

    Yylex(Reader reader) {
        this.zzReader = reader;
    }

    Yylex(InputStream inputStream) {
        this(new InputStreamReader(inputStream));
    }

    private static char[] zzUnpackCMap(String string) {
        char[] cArray = new char[256];
        int n = 0;
        int n2 = 0;
        while (n < 90) {
            int n3 = string.charAt(n++);
            char c2 = string.charAt(n++);
            do {
                cArray[n2++] = c2;
            } while (--n3 > 0);
        }
        return cArray;
    }

    private boolean zzRefill() {
        int n;
        if (this.zzStartRead > 0) {
            System.arraycopy((Object)this.zzBuffer, this.zzStartRead, (Object)this.zzBuffer, 0, this.zzEndRead - this.zzStartRead);
            this.zzEndRead -= this.zzStartRead;
            this.zzCurrentPos -= this.zzStartRead;
            this.zzMarkedPos -= this.zzStartRead;
            this.zzStartRead = 0;
        }
        if (this.zzCurrentPos >= this.zzBuffer.length) {
            char[] cArray = new char[this.zzCurrentPos * 2];
            System.arraycopy((Object)this.zzBuffer, 0, (Object)cArray, 0, this.zzBuffer.length);
            this.zzBuffer = cArray;
        }
        if ((n = this.zzReader.read(this.zzBuffer, this.zzEndRead, this.zzBuffer.length - this.zzEndRead)) > 0) {
            this.zzEndRead += n;
            return false;
        }
        if (n == 0) {
            int n2 = this.zzReader.read();
            if (n2 == -1) {
                return true;
            }
            this.zzBuffer[this.zzEndRead++] = (char)n2;
            return false;
        }
        return true;
    }

    public final void yyclose() {
        this.zzAtEOF = true;
        this.zzEndRead = this.zzStartRead;
        if (this.zzReader != null) {
            this.zzReader.close();
        }
    }

    public final void yyreset(Reader reader) {
        this.zzReader = reader;
        this.zzAtBOL = true;
        this.zzAtEOF = false;
        this.zzStartRead = 0;
        this.zzEndRead = 0;
        this.zzMarkedPos = 0;
        this.zzCurrentPos = 0;
        this.yycolumn = 0;
        this.yychar = 0;
        this.yyline = 0;
        this.zzLexicalState = 0;
    }

    public final int yystate() {
        return this.zzLexicalState;
    }

    public final void yybegin(int n) {
        this.zzLexicalState = n;
    }

    public final String yytext() {
        return new String(this.zzBuffer, this.zzStartRead, this.zzMarkedPos - this.zzStartRead);
    }

    public final char yycharat(int n) {
        return this.zzBuffer[this.zzStartRead + n];
    }

    public final int yylength() {
        return this.zzMarkedPos - this.zzStartRead;
    }

    private void zzScanError(int n) {
        String string;
        try {
            string = ZZ_ERROR_MSG[n];
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            string = ZZ_ERROR_MSG[0];
        }
        throw new Error(string);
    }

    public void yypushback(int n) {
        if (n > this.yylength()) {
            this.zzScanError(2);
        }
        this.zzMarkedPos -= n;
    }

    public Yytoken yylex() {
        int n = this.zzEndRead;
        char[] cArray = this.zzBuffer;
        char[] cArray2 = ZZ_CMAP;
        int[] nArray = ZZ_TRANS;
        int[] nArray2 = ZZ_ROWMAP;
        int[] nArray3 = ZZ_ATTRIBUTE;
        block51: while (true) {
            int n2;
            int n3;
            int n4 = this.zzMarkedPos;
            this.yychar += n4 - this.zzStartRead;
            int n5 = -1;
            this.zzCurrentPos = this.zzStartRead = n4;
            int n6 = this.zzStartRead;
            this.zzState = ZZ_LEXSTATE[this.zzLexicalState];
            while (true) {
                if (n6 < n) {
                    n3 = cArray[n6++];
                } else {
                    if (this.zzAtEOF) {
                        n3 = -1;
                        break;
                    }
                    this.zzCurrentPos = n6;
                    this.zzMarkedPos = n4;
                    n2 = this.zzRefill();
                    n6 = this.zzCurrentPos;
                    n4 = this.zzMarkedPos;
                    cArray = this.zzBuffer;
                    n = this.zzEndRead;
                    if (n2 != 0) {
                        n3 = -1;
                        break;
                    }
                    n3 = cArray[n6++];
                }
                n2 = nArray[nArray2[this.zzState] + cArray2[n3]];
                if (n2 == -1) break;
                this.zzState = n2;
                int n7 = nArray3[this.zzState];
                if ((n7 & 1) != 1) continue;
                n5 = this.zzState;
                n4 = n6;
                if ((n7 & 8) == 8) break;
            }
            this.zzMarkedPos = n4;
            switch (n5 < 0 ? n5 : ZZ_ACTION[n5]) {
                case 11: {
                    this.sb.append(this.yytext());
                }
                case 25: {
                    continue block51;
                }
                case 4: {
                    this.sb.delete(0, this.sb.length());
                    this.yybegin(2);
                }
                case 26: {
                    continue block51;
                }
                case 16: {
                    this.sb.append('\b');
                }
                case 27: {
                    continue block51;
                }
                case 6: {
                    return new Yytoken(2, null);
                }
                case 28: {
                    continue block51;
                }
                case 23: {
                    Boolean bl = Boolean.valueOf(this.yytext());
                    return new Yytoken(0, bl);
                }
                case 29: {
                    continue block51;
                }
                case 22: {
                    return new Yytoken(0, null);
                }
                case 30: {
                    continue block51;
                }
                case 13: {
                    this.yybegin(0);
                    return new Yytoken(0, this.sb.toString());
                }
                case 31: {
                    continue block51;
                }
                case 12: {
                    this.sb.append('\\');
                }
                case 32: {
                    continue block51;
                }
                case 21: {
                    Double d2 = Double.valueOf((String)this.yytext());
                    return new Yytoken(0, d2);
                }
                case 33: {
                    continue block51;
                }
                case 1: {
                    throw new ParseException(this.yychar, 0, new Character(this.yycharat(0)));
                }
                case 34: {
                    continue block51;
                }
                case 8: {
                    return new Yytoken(4, null);
                }
                case 35: {
                    continue block51;
                }
                case 19: {
                    this.sb.append('\r');
                }
                case 36: {
                    continue block51;
                }
                case 15: {
                    this.sb.append('/');
                }
                case 37: {
                    continue block51;
                }
                case 10: {
                    return new Yytoken(6, null);
                }
                case 38: {
                    continue block51;
                }
                case 14: {
                    this.sb.append('\"');
                }
                case 39: {
                    continue block51;
                }
                case 5: {
                    return new Yytoken(1, null);
                }
                case 40: {
                    continue block51;
                }
                case 17: {
                    this.sb.append('\f');
                }
                case 41: {
                    continue block51;
                }
                case 24: {
                    try {
                        n2 = Integer.parseInt(this.yytext().substring(2), 16);
                        this.sb.append((char)n2);
                    }
                    catch (Exception exception) {
                        throw new ParseException(this.yychar, 2, exception);
                    }
                }
                case 42: {
                    continue block51;
                }
                case 20: {
                    this.sb.append('\t');
                }
                case 43: {
                    continue block51;
                }
                case 7: {
                    return new Yytoken(3, null);
                }
                case 44: {
                    continue block51;
                }
                case 2: {
                    Long l = Long.valueOf(this.yytext());
                    return new Yytoken(0, l);
                }
                case 45: {
                    continue block51;
                }
                case 18: {
                    this.sb.append('\n');
                }
                case 46: {
                    continue block51;
                }
                case 9: {
                    return new Yytoken(5, null);
                }
                case 47: {
                    continue block51;
                }
                case 3: 
                case 48: {
                    continue block51;
                }
            }
            if (n3 == -1 && this.zzStartRead == this.zzCurrentPos) {
                this.zzAtEOF = true;
                return null;
            }
            this.zzScanError(1);
        }
    }

    static {
        ZZ_LEXSTATE = new int[]{0, 0, 1, 1};
        ZZ_CMAP = Yylex.zzUnpackCMap("\t\u0000\u0001\u0007\u0001\u0007\u0002\u0000\u0001\u0007\u0012\u0000\u0001\u0007\u0001\u0000\u0001\t\b\u0000\u0001\u0006\u0001\u0019\u0001\u0002\u0001\u0004\u0001\n\n\u0003\u0001\u001a\u0006\u0000\u0004\u0001\u0001\u0005\u0001\u0001\u0014\u0000\u0001\u0017\u0001\b\u0001\u0018\u0003\u0000\u0001\u0012\u0001\u000b\u0002\u0001\u0001\u0011\u0001\f\u0005\u0000\u0001\u0013\u0001\u0000\u0001\r\u0003\u0000\u0001\u000e\u0001\u0014\u0001\u000f\u0001\u0010\u0005\u0000\u0001\u0015\u0001\u0000\u0001\u0016\uff82\u0000");
        ZZ_ACTION = Yylex.zzUnpackAction();
        ZZ_ROWMAP = Yylex.zzUnpackRowMap();
        ZZ_TRANS = new int[]{2, 2, 3, 4, 2, 2, 2, 5, 2, 6, 2, 2, 7, 8, 2, 9, 2, 2, 2, 2, 2, 10, 11, 12, 13, 14, 15, 16, 16, 16, 16, 16, 16, 16, 16, 17, 18, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 4, 19, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 21, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 22, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 23, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, 16, -1, -1, -1, -1, -1, -1, -1, -1, 24, 25, 26, 27, 28, 29, 30, 31, 32, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 34, 35, -1, -1, 34, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 37, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 39, -1, 39, -1, 39, -1, -1, -1, -1, -1, 39, 39, -1, -1, -1, -1, 39, 39, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 33, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 35, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 38, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 40, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 41, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 42, -1, 42, -1, 42, -1, -1, -1, -1, -1, 42, 42, -1, -1, -1, -1, 42, 42, -1, -1, -1, -1, -1, -1, -1, -1, -1, 43, -1, 43, -1, 43, -1, -1, -1, -1, -1, 43, 43, -1, -1, -1, -1, 43, 43, -1, -1, -1, -1, -1, -1, -1, -1, -1, 44, -1, 44, -1, 44, -1, -1, -1, -1, -1, 44, 44, -1, -1, -1, -1, 44, 44, -1, -1, -1, -1, -1, -1, -1, -1};
        ZZ_ERROR_MSG = new String[]{"Unkown internal scanner error", "Error: could not match input", "Error: pushback value was too large"};
        ZZ_ATTRIBUTE = Yylex.zzUnpackAttribute();
    }
}

