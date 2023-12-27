/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.debug.service.debuginterface.events;

import de.vw.mib.genericevents.GenericEventException;

public final class CustomEventSlot {
    public static final int TYPE_EMPTY;
    public static final int TYPE_INT;
    public static final int TYPE_BOOLEAN;
    public static final int TYPE_FLOAT;
    public static final int TYPE_DOUBLE;
    public static final int TYPE_STRING;
    public static final int TYPE_BYTE;
    public static final int TYPE_CHAR;
    public static final int TYPE_LONG;
    public static final int TYPE_SHORT;
    public static final String TYPE_STR_EMPTY;
    public static final String TYPE_STR_INT;
    public static final String TYPE_STR_BOOLEAN;
    public static final String TYPE_STR_FLOAT;
    public static final String TYPE_STR_DOUBLE;
    public static final String TYPE_STR_STRING;
    public static final String TYPE_STR_BYTE;
    public static final String TYPE_STR_CHAR;
    public static final String TYPE_STR_LONG;
    public static final String TYPE_STR_SHORT;
    private static final long DEFAULT_DOUBLE_VALUE;
    private static final long DEFAULT_FLOAT_VALUE;
    private int index;
    private int type;
    private Object object;
    private long primitive;

    public CustomEventSlot(int n, int n2, String string) {
        this.index = n;
        this.type = n2;
        this.object = string;
        this.setValue(string);
    }

    public String getTypeAsString(int n) {
        String string;
        switch (n) {
            case 0: {
                string = "empty";
                break;
            }
            case 1: {
                string = "int";
                break;
            }
            case 2: {
                string = "boolean";
                break;
            }
            case 3: {
                string = "float";
                break;
            }
            case 4: {
                string = "double";
                break;
            }
            case 5: {
                string = "string";
                break;
            }
            case 6: {
                string = "byte";
                break;
            }
            case 8: {
                string = "char";
                break;
            }
            case 10: {
                string = "long";
                break;
            }
            case 11: {
                string = "short";
                break;
            }
            default: {
                string = new StringBuffer().append("unknown").append(Integer.toString(n)).toString();
            }
        }
        return string;
    }

    public static int getTypeByString(String string) {
        int n = 0;
        if ("empty".equals(string)) {
            n = 0;
        } else if ("int".equals(string)) {
            n = 1;
        } else if ("boolean".equals(string)) {
            n = 2;
        } else if ("float".equals(string)) {
            n = 3;
        } else if ("double".equals(string)) {
            n = 4;
        } else if ("string".equals(string)) {
            n = 5;
        } else if ("byte".equals(string)) {
            n = 6;
        } else if ("char".equals(string)) {
            n = 8;
        } else if ("long".equals(string)) {
            n = 10;
        } else if ("short".equals(string)) {
            n = 11;
        }
        return n;
    }

    private boolean getBoolean() {
        return this.getPrimitiveData(2, 0L) != 0L;
    }

    private byte getByte() {
        return (byte)this.getPrimitiveData(6, 0L);
    }

    private char getChar() {
        return (char)this.getPrimitiveData(8, 0);
    }

    private double getDouble() {
        return Double.longBitsToDouble((long)this.getPrimitiveData(4, DEFAULT_DOUBLE_VALUE));
    }

    private float getFloat() {
        return Float.intBitsToFloat((int)this.getPrimitiveData(3, DEFAULT_FLOAT_VALUE));
    }

    private int getInt() {
        return (int)this.getPrimitiveData(1, 0L);
    }

    private long getLong() {
        return this.getPrimitiveData(10, 0L);
    }

    private short getShort() {
        return (short)this.getPrimitiveData(11, 0L);
    }

    private String getString() {
        return (String)this.getObjectData(5, "");
    }

    private void setBoolean(boolean bl) {
        this.setValue(null, bl ? 1L : 0L);
    }

    private void setByte(byte by) {
        this.setValue(null, by);
    }

    private void setChar(char c2) {
        this.setValue(null, c2);
    }

    private void setDouble(double d2) {
        this.setValue(null, Double.doubleToLongBits((double)d2));
    }

    private void setFloat(float f2) {
        this.setValue(null, Float.floatToIntBits(f2));
    }

    private void setInt(int n) {
        this.setValue(null, n);
    }

    private void setLong(long l) {
        this.setValue(null, l);
    }

    public void setShort(short s) {
        this.setValue(null, s);
    }

    public void setString(String string) {
        this.setValue(string, 0L);
    }

    private boolean setValue(String string) {
        boolean bl = true;
        try {
            switch (this.type) {
                case 1: {
                    this.setInt(Integer.parseInt(string));
                    break;
                }
                case 2: {
                    boolean bl2 = false;
                    try {
                        int n = Integer.parseInt(string);
                        if (n > 0) {
                            bl2 = true;
                        }
                    }
                    catch (NumberFormatException numberFormatException) {
                        bl2 = Boolean.valueOf(string);
                    }
                    this.setBoolean(bl2);
                    break;
                }
                case 3: {
                    this.setFloat(Float.parseFloat(string));
                    break;
                }
                case 4: {
                    this.setDouble(Double.parseDouble((String)string));
                    break;
                }
                case 5: {
                    this.setString(string);
                    break;
                }
                case 6: {
                    this.setByte(Byte.parseByte(string));
                    break;
                }
                case 8: {
                    this.setChar(string == null ? (char)' ' : string.charAt(0));
                    break;
                }
                case 10: {
                    this.setLong(Long.parseLong(string));
                    break;
                }
                case 11: {
                    this.setShort(Short.parseShort(string));
                    break;
                }
                default: {
                    bl = false;
                    break;
                }
            }
        }
        catch (NumberFormatException numberFormatException) {
            bl = false;
        }
        return bl;
    }

    private long containsAndCheckType(int n, long l, long l2) {
        if (this.type == 0) {
            return l2;
        }
        if (this.type != n) {
            StringBuffer stringBuffer = new StringBuffer(70);
            stringBuffer.append("Wrong parameter access: [parameter ");
            stringBuffer.append(this.index);
            stringBuffer.append("][event contains ");
            stringBuffer.append(this.getTypeAsString(this.type));
            stringBuffer.append("][user expects ");
            stringBuffer.append(this.getTypeAsString(n));
            stringBuffer.append("]");
            throw new GenericEventException(4, stringBuffer.toString());
        }
        return l;
    }

    private Object containsAndCheckType(int n, Object object, Object object2) {
        if (this.type == 0) {
            return object2;
        }
        if (this.type != n) {
            StringBuffer stringBuffer = new StringBuffer(70);
            stringBuffer.append("Wrong parameter access: [parameter ");
            stringBuffer.append(this.index);
            stringBuffer.append("][event contains ");
            stringBuffer.append(this.getTypeAsString(this.type));
            stringBuffer.append("][user expects ");
            stringBuffer.append(this.getTypeAsString(n));
            stringBuffer.append("]");
            throw new GenericEventException(4, stringBuffer.toString());
        }
        return object;
    }

    private Object getObjectData(int n, Object object) {
        return this.containsAndCheckType(n, this.object, object);
    }

    private long getPrimitiveData(int n, long l) {
        return this.containsAndCheckType(n, this.primitive, l);
    }

    public int getType() {
        return this.type;
    }

    public String getValueString() {
        try {
            switch (this.type) {
                case 0: {
                    return "";
                }
                case 1: {
                    int n = this.getInt();
                    return Integer.toString(n);
                }
                case 2: {
                    boolean bl = this.getBoolean();
                    return Boolean.toString(bl);
                }
                case 6: {
                    byte by = this.getByte();
                    return Byte.toString(by);
                }
                case 8: {
                    char c2 = this.getChar();
                    return Character.toString(c2);
                }
                case 10: {
                    long l = this.getLong();
                    return Long.toString(l);
                }
                case 11: {
                    short s = this.getShort();
                    return Short.toString(s);
                }
                case 3: {
                    float f2 = this.getFloat();
                    return Float.toString(f2);
                }
                case 4: {
                    double d2 = this.getDouble();
                    return Double.toString((double)d2);
                }
                case 5: {
                    String string = this.getString();
                    if (string == null) {
                        return "null";
                    }
                    return string.toString();
                }
            }
            return new StringBuffer().append("unknown").append(Integer.toString(this.type)).toString();
        }
        catch (Exception exception) {
            return "Exception in toString()!";
        }
    }

    private void setValue(Object object, long l) {
        this.object = object;
        this.primitive = l;
    }

    public int getIndex() {
        return this.index;
    }

    static {
        DEFAULT_DOUBLE_VALUE = Double.doubleToLongBits((double)0.0);
        DEFAULT_FLOAT_VALUE = Float.floatToIntBits(0.0f);
    }
}

