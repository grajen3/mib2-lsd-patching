/*
 * Decompiled with CFR 0.152.
 */
package org.json.simple.parser;

public class Yytoken {
    public static final int TYPE_VALUE;
    public static final int TYPE_LEFT_BRACE;
    public static final int TYPE_RIGHT_BRACE;
    public static final int TYPE_LEFT_SQUARE;
    public static final int TYPE_RIGHT_SQUARE;
    public static final int TYPE_COMMA;
    public static final int TYPE_COLON;
    public static final int TYPE_EOF;
    public int type = 0;
    public Object value = null;

    public Yytoken(int n, Object object) {
        this.type = n;
        this.value = object;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        switch (this.type) {
            case 0: {
                stringBuffer.append("VALUE(").append(this.value).append(")");
                break;
            }
            case 1: {
                stringBuffer.append("LEFT BRACE({)");
                break;
            }
            case 2: {
                stringBuffer.append("RIGHT BRACE(})");
                break;
            }
            case 3: {
                stringBuffer.append("LEFT SQUARE([)");
                break;
            }
            case 4: {
                stringBuffer.append("RIGHT SQUARE(])");
                break;
            }
            case 5: {
                stringBuffer.append("COMMA(,)");
                break;
            }
            case 6: {
                stringBuffer.append("COLON(:)");
                break;
            }
            case -1: {
                stringBuffer.append("END OF FILE");
            }
        }
        return stringBuffer.toString();
    }
}

