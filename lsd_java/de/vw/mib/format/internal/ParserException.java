/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.format.internal;

public class ParserException
extends Exception {
    public static final int IDENTIFIER_EXPECTED;
    public static final int INVALID_IDENTIFIER;
    public static final int INVALID_CHAR;
    public static final int RIGHT_PARENTHESIS_EXPECTED;
    public static final int INVALID_OPERAND;
    public static final int INVALID_VARIABLE_TYPE;
    public static final int INVALID_OPERAND_TYPE;
    public static final int LEFT_CURLY_BRACKET_EXPECTED;
    public static final int RIGHT_CURLY_BRACKET_EXPECTED;
    public static final int LEFT_PARENTHESIS_EXPECTED;
    public static final int FIELD_EXPECTED;
    public static final int COMMA_EXPECTED;
    public static final int STRING_EXPECTED;
    protected final String line;
    protected final int symStartPosition;
    protected final int symEndPosition;

    public ParserException(int n, String string, int n2, int n3) {
        super(ParserException.getErrorText(n));
        this.line = string;
        this.symStartPosition = n2;
        this.symEndPosition = n3;
    }

    private static String getErrorText(int n) {
        String string = null;
        switch (n) {
            case 1: {
                string = "Identifier expected!";
                break;
            }
            case 2: {
                string = "Invalid identifier";
                break;
            }
            case 3: {
                string = "Invalid character";
                break;
            }
            case 4: {
                string = "')' expected to close the expression!";
                break;
            }
            case 5: {
                string = "Invalid operand!";
                break;
            }
            case 6: {
                string = "Invalid variable type";
                break;
            }
            case 7: {
                string = "Invalid operand type for operation";
                break;
            }
            case 8: {
                string = "'{' expected!";
                break;
            }
            case 9: {
                string = "'}' expected!";
                break;
            }
            case 10: {
                string = "'(' expected!";
                break;
            }
            case 11: {
                string = "Field expected!";
                break;
            }
            case 12: {
                string = "',' expected!";
                break;
            }
            case 13: {
                string = "String expected!";
                break;
            }
            default: {
                string = "Unknown error!";
            }
        }
        return string;
    }
}

