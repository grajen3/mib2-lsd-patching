/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

import java.io.IOException;
import java.io.InputStreamReader;

class DefaultPolicy$PolicyTokenizer {
    private static final int EOL;
    static final int TOK_CHAR;
    static final int TOK_STRING;
    static final int TOK_QUOTEDSTRING;
    private InputStreamReader policyData;
    private char[] inbuf = new char[1024];
    private int inbufCount = 0;
    private int inbufPos = 0;
    private boolean endOfFile = false;
    String sval;
    char cval;
    private char[] buf = new char[120];

    DefaultPolicy$PolicyTokenizer(InputStreamReader inputStreamReader) {
        this.policyData = inputStreamReader;
    }

    private void ignoreToEOL() {
        do {
            if (this.inbufPos != this.inbufCount) continue;
            this.inbufCount = this.policyData.read(this.inbuf);
            if (this.inbufCount == -1) {
                this.inbufPos = -1;
                this.endOfFile = true;
                break;
            }
            this.inbufPos = 0;
        } while (this.inbuf[this.inbufPos++] != '\n');
    }

    private void findEndOfComment() {
        char c2 = '\u0000';
        while (true) {
            char c3;
            if (this.inbufPos == this.inbufCount) {
                this.inbufCount = this.policyData.read(this.inbuf);
                if (this.inbufCount == -1) {
                    this.inbufPos = -1;
                    this.endOfFile = true;
                    break;
                }
                this.inbufPos = 0;
            }
            if ((c3 = this.inbuf[this.inbufPos++]) == '/' && c2 == '*') break;
            c2 = c3;
        }
    }

    boolean isAtEOF() {
        return this.endOfFile;
    }

    int nextToken() {
        boolean bl = false;
        int n = 32;
        int n2 = 0;
        try {
            while (true) {
                int n3;
                if (this.inbufPos == this.inbufCount) {
                    this.inbufCount = this.policyData.read(this.inbuf);
                    if (this.inbufCount == -1) {
                        this.inbufPos = -1;
                        this.endOfFile = true;
                        break;
                    }
                    this.inbufPos = 0;
                }
                if ((n3 = this.inbuf[this.inbufPos++]) == 10 || n3 == 13 || n3 == 9) {
                    n3 = 32;
                }
                if (n3 == 92 && n == 92) {
                    n = 32;
                    continue;
                }
                if (bl) {
                    if (n3 == 34 && n != 92) {
                        break;
                    }
                } else {
                    if (n3 == 32) {
                        if (n2 == 0) {
                            continue;
                        }
                        break;
                    }
                    if (n3 == 59 || n3 == 44 || n3 == 123 || n3 == 125) {
                        if (n2 == 0) {
                            this.cval = (char)n3;
                            return 0;
                        }
                        --this.inbufPos;
                        break;
                    }
                    if (n3 == 34 && n != 92) {
                        if (n2 > 0) {
                            --this.inbufPos;
                            break;
                        }
                        bl = true;
                        continue;
                    }
                    if (n3 == 47 && n == 47) {
                        n2 = 0;
                        this.ignoreToEOL();
                        n = 32;
                        continue;
                    }
                    if (n3 == 42 && n == 47) {
                        --n2;
                        n = n3;
                        this.findEndOfComment();
                        continue;
                    }
                }
                if (n2 == this.buf.length) {
                    char[] cArray = new char[this.buf.length * 2];
                    System.arraycopy((Object)this.buf, 0, (Object)cArray, 0, n2);
                    this.buf = cArray;
                }
                this.buf[n2++] = n3;
                n = n3;
            }
        }
        catch (IOException iOException) {
            this.endOfFile = true;
        }
        this.sval = new String(this.buf, 0, n2);
        if (bl) {
            return 2;
        }
        return 1;
    }

    void skipTokens(char c2) {
        while (!this.endOfFile) {
            if (this.nextToken() == 0 && this.cval == c2) break;
        }
    }
}

