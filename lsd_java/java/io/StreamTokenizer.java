/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package java.io;

import java.io.Reader;

public class StreamTokenizer {
    public double nval;
    public String sval;
    public static final int TT_EOF;
    public static final int TT_EOL;
    public static final int TT_NUMBER;
    public static final int TT_WORD;
    private static final int TT_UNKNOWN;
    public int ttype = -4;
    private byte[] tokenTypes = new byte[256];
    private static final byte TOKEN_COMMENT;
    private static final byte TOKEN_QUOTE;
    private static final byte TOKEN_WHITE;
    private static final byte TOKEN_WORD;
    private static final byte TOKEN_DIGIT;
    private int lineNumber = 1;
    private boolean forceLowercase = false;
    private boolean isEOLSignificant = false;
    private boolean slashStarComments = false;
    private boolean slashSlashComments = false;
    private boolean pushBackToken = false;
    private boolean lastCr = false;
    private Reader inReader;
    private int peekChar = -2;

    private StreamTokenizer() {
        this.wordChars(65, 90);
        this.wordChars(97, 122);
        this.wordChars(160, 255);
        this.whitespaceChars(0, 32);
        this.commentChar(47);
        this.quoteChar(34);
        this.quoteChar(39);
        this.parseNumbers();
    }

    public StreamTokenizer(Reader reader) {
        this();
        if (reader == null) {
            throw new NullPointerException();
        }
        this.inReader = reader;
    }

    public void commentChar(int n) {
        if (n >= 0 && n < this.tokenTypes.length) {
            this.tokenTypes[n] = 1;
        }
    }

    public void eolIsSignificant(boolean bl) {
        this.isEOLSignificant = bl;
    }

    public int lineno() {
        return this.lineNumber;
    }

    public void lowerCaseMode(boolean bl) {
        this.forceLowercase = bl;
    }

    public int nextToken() {
        int n;
        if (this.pushBackToken) {
            this.pushBackToken = false;
            if (this.ttype != -4) {
                return this.ttype;
            }
        }
        this.sval = null;
        int n2 = n = this.peekChar == -2 ? this.read() : this.peekChar;
        if (this.lastCr && n == 10) {
            this.lastCr = false;
            n = this.read();
        }
        if (n == -1) {
            this.ttype = -1;
            return -1;
        }
        int n3 = n > 255 ? 8 : this.tokenTypes[n];
        while ((n3 & 4) != 0) {
            if (n == 13) {
                ++this.lineNumber;
                if (this.isEOLSignificant) {
                    this.lastCr = true;
                    this.peekChar = -2;
                    this.ttype = 10;
                    return 10;
                }
                n = this.read();
                if (n == 10) {
                    n = this.read();
                }
            } else if (n == 10) {
                ++this.lineNumber;
                if (this.isEOLSignificant) {
                    this.peekChar = -2;
                    this.ttype = 10;
                    return 10;
                }
                n = this.read();
            } else {
                n = this.read();
            }
            if (n == -1) {
                this.ttype = -1;
                return -1;
            }
            int n4 = n3 = n > 255 ? 8 : this.tokenTypes[n];
        }
        if ((n3 & 0x10) != 0) {
            boolean bl;
            StringBuffer stringBuffer = new StringBuffer(20);
            boolean bl2 = false;
            boolean bl3 = bl = n == 45;
            do {
                if (n == 46) {
                    bl2 = true;
                }
                stringBuffer.append((char)n);
            } while ((n = this.read()) >= 48 && n <= 57 || !bl2 && n == 46);
            this.peekChar = n;
            if (bl && stringBuffer.length() == 1) {
                this.ttype = 45;
                return 45;
            }
            try {
                this.nval = Double.valueOf((String)stringBuffer.toString());
            }
            catch (NumberFormatException numberFormatException) {
                this.nval = 0.0;
            }
            this.ttype = -2;
            return -2;
        }
        if ((n3 & 8) != 0) {
            StringBuffer stringBuffer = new StringBuffer(20);
            do {
                stringBuffer.append((char)n);
            } while ((n = this.read()) != -1 && (n >= 256 || (this.tokenTypes[n] & 0x18) != 0));
            this.peekChar = n;
            this.sval = this.forceLowercase ? stringBuffer.toString().toLowerCase() : stringBuffer.toString();
            this.ttype = -3;
            return -3;
        }
        if (n3 == 2) {
            int n5 = n;
            StringBuffer stringBuffer = new StringBuffer();
            int n6 = this.read();
            while (n6 >= 0 && n6 != n5 && n6 != 13 && n6 != 10) {
                boolean bl = true;
                if (n6 == 92) {
                    int n7 = this.read();
                    if (n7 <= 55 && n7 >= 48) {
                        int n8 = n7 - 48;
                        n7 = this.read();
                        if (n7 > 55 || n7 < 48) {
                            bl = false;
                        } else {
                            n8 = n8 * 8 + (n7 - 48);
                            n7 = this.read();
                            if (n8 > 31 || n7 > 55 || n7 < 48) {
                                bl = false;
                            } else {
                                n8 = n8 * 8 + (n7 - 48);
                            }
                        }
                        if (!bl) {
                            stringBuffer.append((char)n8);
                            n6 = n7;
                        } else {
                            n6 = n8;
                        }
                    } else {
                        switch (n7) {
                            case 97: {
                                n6 = 7;
                                break;
                            }
                            case 98: {
                                n6 = 8;
                                break;
                            }
                            case 102: {
                                n6 = 12;
                                break;
                            }
                            case 110: {
                                n6 = 10;
                                break;
                            }
                            case 114: {
                                n6 = 13;
                                break;
                            }
                            case 116: {
                                n6 = 9;
                                break;
                            }
                            case 118: {
                                n6 = 11;
                                break;
                            }
                            default: {
                                n6 = n7;
                            }
                        }
                    }
                }
                if (!bl) continue;
                stringBuffer.append((char)n6);
                n6 = this.read();
            }
            if (n6 == n5) {
                n6 = this.read();
            }
            this.peekChar = n6;
            this.ttype = n5;
            this.sval = stringBuffer.toString();
            return this.ttype;
        }
        if (n3 == 1) {
            while ((n = this.read()) >= 0 && n != 13 && n != 10) {
            }
            this.peekChar = n;
            return this.nextToken();
        }
        if (n == 47 && (this.slashSlashComments || this.slashStarComments)) {
            n = this.read();
            if (n == 42 && this.slashStarComments) {
                int n9 = this.read();
                while (true) {
                    n = n9;
                    n9 = this.read();
                    if (n == -1) {
                        this.peekChar = -1;
                        this.ttype = -1;
                        return -1;
                    }
                    if (n == 13) {
                        if (n9 == 10) {
                            n9 = this.read();
                        }
                        ++this.lineNumber;
                        continue;
                    }
                    if (n == 10) {
                        ++this.lineNumber;
                        continue;
                    }
                    if (n == 42 && n9 == 47) break;
                }
                this.peekChar = this.read();
                return this.nextToken();
            }
            if (n == 47 && this.slashSlashComments) {
                while ((n = this.read()) >= 0 && n != 13 && n != 10) {
                }
                this.peekChar = n;
                return this.nextToken();
            }
            this.peekChar = n;
            this.ttype = 47;
            return 47;
        }
        this.peekChar = this.read();
        this.ttype = n;
        return this.ttype;
    }

    public void ordinaryChar(int n) {
        if (n >= 0 && n < this.tokenTypes.length) {
            this.tokenTypes[n] = 0;
        }
    }

    public void ordinaryChars(int n, int n2) {
        if (n < 0) {
            n = 0;
        }
        if (n2 > this.tokenTypes.length) {
            n2 = this.tokenTypes.length - 1;
        }
        int n3 = n;
        while (n3 <= n2) {
            this.tokenTypes[n3] = 0;
            ++n3;
        }
    }

    public void parseNumbers() {
        int n = 48;
        while (n <= 57) {
            int n2 = n++;
            this.tokenTypes[n2] = (byte)(this.tokenTypes[n2] | 0x10);
        }
        this.tokenTypes[46] = (byte)(this.tokenTypes[46] | 0x10);
        this.tokenTypes[45] = (byte)(this.tokenTypes[45] | 0x10);
    }

    public void pushBack() {
        this.pushBackToken = true;
    }

    public void quoteChar(int n) {
        if (n >= 0 && n < this.tokenTypes.length) {
            this.tokenTypes[n] = 2;
        }
    }

    private int read() {
        return this.inReader.read();
    }

    public void resetSyntax() {
        int n = 0;
        while (n < 256) {
            this.tokenTypes[n] = 0;
            ++n;
        }
    }

    public void slashSlashComments(boolean bl) {
        this.slashSlashComments = bl;
    }

    public void slashStarComments(boolean bl) {
        this.slashStarComments = bl;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Token[");
        switch (this.ttype) {
            case -1: {
                stringBuffer.append("EOF");
                break;
            }
            case 10: {
                stringBuffer.append("EOL");
                break;
            }
            case -2: {
                stringBuffer.append("n=");
                stringBuffer.append(this.nval);
                break;
            }
            case -3: {
                stringBuffer.append(this.sval);
                break;
            }
            default: {
                if (this.ttype >= 0 && this.ttype <= 255 && this.tokenTypes[this.ttype] == 2) {
                    stringBuffer.append(this.sval);
                    break;
                }
                stringBuffer.append('\'');
                stringBuffer.append((char)this.ttype);
                stringBuffer.append('\'');
            }
        }
        stringBuffer.append("], line ");
        stringBuffer.append(this.lineNumber);
        return stringBuffer.toString();
    }

    public void whitespaceChars(int n, int n2) {
        if (n < 0) {
            n = 0;
        }
        if (n2 > this.tokenTypes.length) {
            n2 = this.tokenTypes.length - 1;
        }
        int n3 = n;
        while (n3 <= n2) {
            this.tokenTypes[n3] = 4;
            ++n3;
        }
    }

    public void wordChars(int n, int n2) {
        if (n < 0) {
            n = 0;
        }
        if (n2 > this.tokenTypes.length) {
            n2 = this.tokenTypes.length - 1;
        }
        int n3 = n;
        while (n3 <= n2) {
            int n4 = n3++;
            this.tokenTypes[n4] = (byte)(this.tokenTypes[n4] | 8);
        }
    }
}

