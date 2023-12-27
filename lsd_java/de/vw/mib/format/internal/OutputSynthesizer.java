/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.format.internal;

import de.vw.mib.format.FixFormat;
import de.vw.mib.format.internal.ParserException;
import de.vw.mib.format.internal.ServiceManager;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.properties.values.FixFormatterFieldData;
import java.util.HashMap;
import java.util.Map;

public class OutputSynthesizer {
    private Logger logger;
    private String expression;
    private int position;
    private char ch;
    private int sym;
    private int symStartPosition;
    private int symEndPosition;
    private int pushedBackSym;
    private String identifier;
    private String string;
    private StringBuffer result;
    private Map variables;
    private HashMap fieldtypes;
    private FixFormatterFieldData fields;
    private FixFormat fixFormat;

    public OutputSynthesizer(Logger logger) {
        this.logger = logger;
    }

    private void getCh() {
        this.ch = this.position < this.expression.length() ? this.expression.charAt(this.position++) : (char)'\u0000';
    }

    private boolean isIdentifierStart(char c2) {
        return Character.isLetter(c2) || c2 == '_';
    }

    private boolean isIdentifierPart(char c2) {
        return Character.isLetterOrDigit(c2) || c2 == '_';
    }

    private int findSymbol(String string) {
        if (string.toLowerCase().equals("fmtgeocoordinateslatitude")) {
            return 13;
        }
        if (string.toLowerCase().equals("fmtgeocoordinateslongitude")) {
            return 14;
        }
        if (string.toLowerCase().equals("fmttimestamp")) {
            return 15;
        }
        return 0;
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
            StringBuffer stringBuffer = new StringBuffer();
            do {
                stringBuffer.append(this.ch);
                this.getCh();
            } while (this.ch != '\u0000' && this.isIdentifierPart(this.ch));
            this.symEndPosition = this.position - 1;
            String string = stringBuffer.toString();
            int n = this.findSymbol(string);
            if (n != 0) {
                this.sym = n;
            } else {
                this.identifier = string;
                this.sym = 2;
            }
        } else if (this.ch == '\"') {
            StringBuffer stringBuffer = new StringBuffer();
            this.getCh();
            while (this.ch != '\"' && this.ch != '\u0000') {
                if (this.ch == '\\') {
                    this.getCh();
                    if (this.ch == '\u0000') break;
                }
                stringBuffer.append(this.ch);
                this.getCh();
            }
            this.symEndPosition = this.position - 1;
            if (this.ch == '\u0000') {
                this.error(3);
            }
            this.getCh();
            this.sym = 1;
            this.string = stringBuffer.toString();
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
                case '[': {
                    this.sym = 7;
                    this.getCh();
                    break;
                }
                case ']': {
                    this.sym = 8;
                    this.getCh();
                    break;
                }
                case '<': {
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
                    this.sym = 9;
                    this.getCh();
                    break;
                }
                case '{': {
                    this.sym = 10;
                    this.getCh();
                    break;
                }
                case '}': {
                    this.sym = 11;
                    this.getCh();
                    break;
                }
                case ':': {
                    this.sym = 12;
                    this.getCh();
                    break;
                }
                case ',': {
                    this.sym = 16;
                    this.getCh();
                    break;
                }
                default: {
                    this.error(3);
                }
            }
        }
    }

    private void error(int n) {
        throw new ParserException(n, this.expression, this.symStartPosition, this.symEndPosition);
    }

    private void skipWhiteSpace() {
        while (this.ch == ' ') {
            this.getCh();
        }
    }

    public String evaluate(String string, FixFormatterFieldData fixFormatterFieldData, HashMap hashMap, FixFormat fixFormat) {
        this.expression = string;
        this.position = 0;
        this.variables = null;
        this.fields = fixFormatterFieldData;
        this.fieldtypes = hashMap;
        this.fixFormat = fixFormat;
        this.pushedBackSym = 0;
        this.getCh();
        try {
            this.getSym();
            return this.evaluate();
        }
        catch (ParserException parserException) {
            ServiceManager.loggerFactory.getLogger(8).error(2, new StringBuffer().append("Error parsing the output template '").append(string).append("'.").toString(), parserException);
            return null;
        }
    }

    public String evaluate(String string, Map map, FixFormat fixFormat) {
        this.expression = string;
        this.position = 0;
        this.variables = map;
        this.fields = null;
        this.fieldtypes = null;
        this.fixFormat = fixFormat;
        this.pushedBackSym = 0;
        this.getCh();
        try {
            this.getSym();
            return this.evaluate();
        }
        catch (ParserException parserException) {
            ServiceManager.loggerFactory.getLogger(8).error(2, new StringBuffer().append("Error parsing the output template '").append(string).append("'.").toString(), parserException);
            return null;
        }
    }

    private String evaluate() {
        this.result = new StringBuffer();
        this.process();
        return this.result.toString();
    }

    private void process() {
        while (this.sym == 1 || this.sym == 7 || this.sym == 13 || this.sym == 14 || this.sym == 15 || this.sym == 9) {
            this.processTerm();
        }
    }

    private void processTerm() {
        boolean bl = this.processFactor(false);
        while (this.sym == 4) {
            this.getSym();
            if (!this.processFactor(bl)) continue;
            bl = true;
        }
    }

    private void expect(int n, int n2) {
        if (this.sym != n) {
            this.error(n2);
        }
        this.getSym();
    }

    private int getInteger() {
        if (this.sym == 9) {
            this.getSym();
        }
        if (this.sym != 2) {
            this.error(11);
        }
        int n = 0;
        if (this.variables != null) {
            String string = (String)this.variables.get(this.identifier);
            if (string == null) {
                this.logger.warn(2).append("Value for field '").append(this.identifier).append("' is missing!").log();
            } else {
                try {
                    n = Integer.parseInt(string);
                }
                catch (NumberFormatException numberFormatException) {
                    this.logger.warn(2).append("Illegal value (").append(string).append(") in field '").append(this.identifier).append("'!").log();
                }
            }
        } else {
            Integer n2 = this.fields.getInt(this.identifier);
            if (n2 == null) {
                this.logger.warn(2).append("Value for field '").append(this.identifier).append("' is missing!").log();
            } else {
                n = n2;
            }
        }
        this.getSym();
        return n;
    }

    private long getLong() {
        if (this.sym == 9) {
            this.getSym();
        }
        if (this.sym != 2) {
            this.error(11);
        }
        long l = 0L;
        if (this.variables != null) {
            String string = (String)this.variables.get(this.identifier);
            if (string == null) {
                this.logger.warn(2).append("Value for field '").append(this.identifier).append("' is missing!").log();
            } else {
                try {
                    l = Long.parseLong(string);
                }
                catch (NumberFormatException numberFormatException) {
                    this.logger.warn(2).append("Illegal value (").append(string).append(") in field '").append(this.identifier).append("'!").log();
                }
            }
        } else {
            Long l2 = this.fields.getLong(this.identifier);
            if (l2 == null) {
                this.logger.warn(2).append("Value for field '").append(this.identifier).append("' is missing!").log();
            } else {
                l = l2;
            }
        }
        this.getSym();
        return l;
    }

    private String getString() {
        String string = "";
        if (this.sym != 1) {
            this.error(13);
        }
        string = this.string;
        this.getSym();
        return string;
    }

    private void processFmtGeoCoordinatesLatitude() {
        this.expect(5, 10);
        int n = this.getInteger();
        this.expect(16, 12);
        int n2 = this.getInteger();
        this.expect(16, 12);
        int n3 = this.getInteger();
        this.expect(16, 12);
        String string = this.getString();
        this.expect(16, 12);
        String string2 = this.getString();
        this.expect(6, 4);
        this.result.append(this.fixFormat.fmtGeoCoordinatesLatitude(n, n2, n3, string, string2));
    }

    private void processFmtGeoCoordinatesLongitude() {
        this.expect(5, 10);
        int n = this.getInteger();
        this.expect(16, 12);
        int n2 = this.getInteger();
        this.expect(16, 12);
        int n3 = this.getInteger();
        this.expect(16, 12);
        String string = this.getString();
        this.expect(16, 12);
        String string2 = this.getString();
        this.expect(6, 4);
        this.result.append(this.fixFormat.fmtGeoCoordinatesLongitude(n, n2, n3, string, string2));
    }

    private void processFmtTimestamp() {
        this.expect(5, 10);
        long l = this.getLong();
        this.expect(16, 12);
        int n = this.getInteger();
        this.expect(16, 12);
        int n2 = this.getInteger();
        this.expect(6, 4);
        this.result.append(this.fixFormat.formatTimestamp(l, n, n2));
    }

    private String getFieldValue() {
        String string = null;
        int[][] nArray = null;
        if (this.variables != null) {
            string = (String)this.variables.get(this.identifier);
            nArray = (int[][])this.variables.get(new StringBuffer().append(this.identifier).append(".hi").toString());
        } else {
            Integer n = (Integer)this.fieldtypes.get(this.identifier);
            if (n != null && n == 0) {
                string = this.fields.getString(this.identifier);
                nArray = this.fields.get2dIntArray(new StringBuffer().append(this.identifier).append(".hi").toString());
            }
        }
        return this.fixFormat.getHighlightedString(this.identifier, string, nArray);
    }

    private boolean processFactor(boolean bl) {
        if (this.sym == 1) {
            if (!bl) {
                this.result.append(this.string);
            }
            this.getSym();
            return true;
        }
        if (this.sym == 9) {
            this.getSym();
            if (this.sym == 2) {
                String string = this.getFieldValue();
                if (string != null && string.length() >= 1) {
                    this.result.append(string);
                }
                this.getSym();
                return true;
            }
            this.error(1);
        } else if (this.sym == 13) {
            this.getSym();
            this.processFmtGeoCoordinatesLatitude();
        } else if (this.sym == 14) {
            this.getSym();
            this.processFmtGeoCoordinatesLongitude();
        } else if (this.sym == 15) {
            this.getSym();
            this.processFmtTimestamp();
        } else if (this.sym == 7) {
            boolean bl2 = true;
            StringBuffer stringBuffer = new StringBuffer();
            this.getSym();
            if (this.sym == 3) {
                this.getSym();
                if (this.sym != 1) {
                    this.error(5);
                }
                stringBuffer.append(this.string);
                this.getSym();
            } else if (this.sym == 1) {
                if (this.result.length() > 0 && !this.endsResultWithNewLineMarker()) {
                    stringBuffer.append(this.string);
                }
                this.getSym();
            }
            while (this.sym == 9 || this.sym == 1 || this.sym == 2) {
                if (this.sym == 1) {
                    stringBuffer.append(this.string);
                } else if (this.sym == 2 || this.sym == 9) {
                    String string;
                    if (this.sym == 9) {
                        this.getSym();
                    }
                    if ((string = this.getFieldValue()) == null || string.length() < 1) {
                        bl2 = false;
                    } else {
                        stringBuffer.append(string);
                    }
                }
                this.getSym();
            }
            if (this.sym != 8) {
                this.error(5);
            }
            this.getSym();
            if (bl2 && !bl) {
                this.result.append(stringBuffer);
            }
            return bl2;
        }
        return false;
    }

    private boolean endsResultWithNewLineMarker() {
        int n = this.result.length() - 1;
        if (n >= 0) {
            return this.result.charAt(n--) == 'n' && this.result.charAt(n) == '\\';
        }
        return false;
    }
}

