/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.format.internal;

import de.vw.mib.format.internal.ParserException;
import de.vw.mib.format.internal.ServiceManager;
import de.vw.mib.properties.values.FixFormatterFieldData;
import java.util.HashMap;
import java.util.Map;

public class ConditionEvaluator {
    private String expression;
    private int position;
    private char ch;
    private int sym;
    private int symStartPosition;
    private int symEndPosition;
    private int pushedBackSym;
    private String identifier;
    private Map variables;
    private HashMap fieldtypes;
    private FixFormatterFieldData fields;

    private void getCh() {
        this.ch = this.position < this.expression.length() ? this.expression.charAt(this.position++) : (char)'\u0000';
    }

    private boolean isIdentifierStart(char c2) {
        return Character.isLetter(c2) || c2 == '_';
    }

    private boolean isIdentifierPart(char c2) {
        return Character.isLetterOrDigit(c2) || c2 == '_';
    }

    private void getSym() {
        if (this.pushedBackSym != 0) {
            this.sym = this.pushedBackSym;
            this.pushedBackSym = 0;
            return;
        }
        this.skipWhiteSpace();
        this.symStartPosition = this.position - 1;
        if (this.isIdentifierStart(this.ch)) {
            String string;
            StringBuffer stringBuffer = new StringBuffer();
            do {
                stringBuffer.append(this.ch);
                this.getCh();
            } while (this.ch != '\u0000' && this.isIdentifierPart(this.ch));
            this.symEndPosition = this.position - 1;
            this.identifier = string = stringBuffer.toString();
            this.sym = 1;
        } else {
            switch (this.ch) {
                case '\u0000': {
                    this.sym = 0;
                    this.getCh();
                    break;
                }
                case '(': {
                    this.sym = 5;
                    this.getCh();
                    break;
                }
                case ')': {
                    this.sym = 6;
                    this.getCh();
                    break;
                }
                case '!': {
                    this.sym = 7;
                    this.getCh();
                    break;
                }
                case '&': {
                    this.sym = 2;
                    this.getCh();
                    break;
                }
                case '^': {
                    this.sym = 3;
                    this.getCh();
                    break;
                }
                case '|': {
                    this.sym = 4;
                    this.getCh();
                    break;
                }
                case '$': {
                    this.sym = 8;
                    this.getCh();
                    break;
                }
                default: {
                    throw new ParserException(3, this.expression, this.symStartPosition, this.symEndPosition);
                }
            }
        }
    }

    private void skipWhiteSpace() {
        while (this.ch == ' ') {
            this.getCh();
        }
    }

    public Boolean evaluate(String string, FixFormatterFieldData fixFormatterFieldData, HashMap hashMap) {
        this.expression = string;
        this.position = 0;
        this.variables = null;
        this.fields = fixFormatterFieldData;
        this.fieldtypes = hashMap;
        this.pushedBackSym = 0;
        this.getCh();
        try {
            this.getSym();
            return this.evaluate();
        }
        catch (ParserException parserException) {
            ServiceManager.loggerFactory.getLogger(8).error(2, new StringBuffer().append("Error parsing the condition '").append(string).append("'.").toString(), parserException);
            return null;
        }
    }

    public Boolean evaluate(String string, Map map) {
        this.expression = string;
        this.position = 0;
        this.variables = map;
        this.fields = null;
        this.fieldtypes = null;
        this.pushedBackSym = 0;
        this.getCh();
        try {
            this.getSym();
            return this.evaluate();
        }
        catch (ParserException parserException) {
            ServiceManager.loggerFactory.getLogger(8).error(2, new StringBuffer().append("Error parsing the condition '").append(string).append("'.").toString(), parserException);
            return null;
        }
    }

    private boolean evaluate() {
        return this.process();
    }

    private boolean process() {
        boolean bl = this.processXorTerm();
        while (this.sym == 4) {
            this.getSym();
            boolean bl2 = this.processXorTerm();
            bl = bl || bl2;
        }
        return bl;
    }

    private boolean processXorTerm() {
        boolean bl = this.processAndTerm();
        while (this.sym == 3) {
            this.getSym();
            boolean bl2 = this.processAndTerm();
            bl ^= bl2;
        }
        return bl;
    }

    private boolean processAndTerm() {
        boolean bl = this.processFactor();
        while (this.sym == 2) {
            this.getSym();
            boolean bl2 = this.processFactor();
            bl = bl && bl2;
        }
        return bl;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean processFactor() {
        boolean bl = true;
        boolean bl2 = false;
        if (this.sym == 7) {
            bl2 = true;
            this.getSym();
        }
        if (this.sym == 8 || this.sym == 1) {
            if (this.sym == 8) {
                this.getSym();
            }
            bl = false;
            if (this.variables != null) {
                Object object = this.variables.get(this.identifier);
                if (object != null) {
                    if (object instanceof Boolean) {
                        bl = (Boolean)object;
                    } else {
                        if (!(object instanceof String)) throw new ParserException(6, this.expression, this.symStartPosition, this.symEndPosition);
                        bl = ((String)object).length() > 0;
                    }
                }
            } else if (this.fields != null && this.fields.contains(this.identifier)) {
                int n = (Integer)this.fieldtypes.get(this.identifier);
                switch (n) {
                    case 0: {
                        String string = this.fields.getString(this.identifier);
                        if (string == null) break;
                        bl = string.length() > 0;
                        break;
                    }
                    case 1: {
                        Boolean bl3 = this.fields.getBoolean(this.identifier);
                        if (bl3 == null) break;
                        bl = bl3;
                        break;
                    }
                    default: {
                        bl = true;
                    }
                }
            }
            this.getSym();
        } else if (this.sym == 5) {
            this.getSym();
            bl = this.process();
            if (this.sym != 6) {
                throw new ParserException(4, this.expression, this.symStartPosition, this.symEndPosition);
            }
            this.getSym();
        }
        if (bl2) {
            if (bl) return false;
            return true;
        }
        boolean bl4 = bl;
        return bl4;
    }
}

