/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.genericevents;

import de.vw.mib.collections.ints.IntIntMap$Entry;
import de.vw.mib.collections.ints.IntIntOptHashMap;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntLongOptHashMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.coreapi.ASLDownEvent;
import de.vw.mib.genericevents.EventGeneric$GEExtend;
import de.vw.mib.genericevents.GenericEventException;
import de.vw.mib.genericevents.GenericEventFactory;
import de.vw.mib.genericevents.impl.ArrayUtils;
import de.vw.mib.genericevents.internal.ServiceManager;
import de.vw.mib.log4mib.InvocationContext;
import de.vw.mib.pool.PooledObject;
import de.vw.mib.util.Util;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;

public final class EventGeneric
implements ASLDownEvent,
PooledObject {
    private static final int STD_PARAM_AMOUNT;
    public static final byte TYPE_EMPTY;
    public static final byte TYPE_INT;
    public static final byte TYPE_BOOLEAN;
    public static final byte TYPE_FLOAT;
    public static final byte TYPE_DOUBLE;
    public static final byte TYPE_STRING;
    public static final byte TYPE_BYTE;
    public static final byte TYPE_BYTEARRAY;
    public static final byte TYPE_CHAR;
    public static final byte TYPE_EVENT;
    public static final byte TYPE_LONG;
    public static final byte TYPE_SHORT;
    public static final byte TYPE_OBJECT;
    public static final String TYPE_STR_EMPTY;
    public static final String TYPE_STR_INT;
    public static final String TYPE_STR_BOOLEAN;
    public static final String TYPE_STR_FLOAT;
    public static final String TYPE_STR_DOUBLE;
    public static final String TYPE_STR_STRING;
    public static final String TYPE_STR_BYTE;
    public static final String TYPE_STR_BYTEARRAY;
    public static final String TYPE_STR_CHAR;
    public static final String TYPE_STR_EVENT;
    public static final String TYPE_STR_LONG;
    public static final String TYPE_STR_SHORT;
    public static final String TYPE_STR_OBJECT;
    private static final long DEFAULT_DOUBLE_VALUE;
    private static final long DEFAULT_FLOAT_VALUE;
    private static final String STRING_ENCODING;
    private static final int STREAM_HEADER;
    private transient boolean blocked = false;
    private transient boolean isAnswer = false;
    private int receiverEventId;
    private int receiverTargetId;
    private int senderEventId;
    private int senderTargetId;
    private transient int receiverRouterId = 0;
    private int result = 0;
    private transient int senderRouterId = 0;
    private int serviceId = 0;
    private InvocationContext invocationContext;
    private byte type_0;
    private byte type_1;
    private byte type_2;
    private byte type_3;
    private byte type_4;
    private byte type_5;
    private byte type_6;
    private byte type_7;
    private Object object_0;
    private Object object_1;
    private Object object_2;
    private Object object_3;
    private Object object_4;
    private Object object_5;
    private Object object_6;
    private Object object_7;
    private long primitive_0;
    private long primitive_1;
    private long primitive_2;
    private long primitive_3;
    private long primitive_4;
    private long primitive_5;
    private long primitive_6;
    private long primitive_7;
    private EventGeneric$GEExtend extend;
    private boolean pooled = false;
    private GenericEventFactory factory;

    private static String getTypeAsString(int n) {
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
            case 7: {
                string = "bytearray";
                break;
            }
            case 8: {
                string = "char";
                break;
            }
            case 9: {
                string = "event";
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
            case 12: {
                string = "object";
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
        } else if ("bytearray".equals(string)) {
            n = 7;
        } else if ("char".equals(string)) {
            n = 8;
        } else if ("event".equals(string)) {
            n = 9;
        } else if ("long".equals(string)) {
            n = 10;
        } else if ("short".equals(string)) {
            n = 11;
        } else if ("object".equals(string)) {
            n = 12;
        }
        return n;
    }

    public static String[] getTypeStrings(boolean bl) {
        if (bl) {
            return new String[]{"int", "boolean", "float", "double", "string", "byte", "char", "long", "short"};
        }
        return new String[]{"int", "boolean", "float", "double", "string", "byte", "bytearray", "char", "event", "long", "short", "object"};
    }

    EventGeneric(GenericEventFactory genericEventFactory) {
        this.factory = genericEventFactory;
    }

    public EventGeneric() {
        this.factory = null;
    }

    public EventGeneric(int n) {
        this.serviceId = n;
        this.factory = null;
    }

    public EventGeneric(int n, int n2, int n3) {
        this.setSenderTargetId(n);
        this.setReceiverTargetId(n2);
        this.setReceiverEventId(n3);
        this.factory = null;
    }

    public void avoidPooling() {
        this.factory = null;
    }

    @Override
    public void backToPool() {
        if (this.blocked) {
            new Exception("release a blocked event!").printStackTrace();
        }
        this.clear();
        this.pooled = true;
    }

    public void clear() {
        this.clearHeader();
        this.removeAllParameters();
    }

    private void clearHeader() {
        this.blocked = false;
        this.isAnswer = false;
        this.receiverEventId = 0;
        this.receiverTargetId = 0;
        this.receiverRouterId = 0;
        this.result = 0;
        this.senderEventId = 0;
        this.senderTargetId = 0;
        this.senderRouterId = 0;
        this.serviceId = 0;
    }

    public boolean contains(int n) {
        this.checkIfPooled();
        switch (n) {
            case 0: {
                return this.type_0 != 0;
            }
            case 1: {
                return this.type_1 != 0;
            }
            case 2: {
                return this.type_2 != 0;
            }
            case 3: {
                return this.type_3 != 0;
            }
            case 4: {
                return this.type_4 != 0;
            }
            case 5: {
                return this.type_5 != 0;
            }
            case 6: {
                return this.type_6 != 0;
            }
            case 7: {
                return this.type_7 != 0;
            }
        }
        return this.extend != null ? this.extend.parameterTypes.containsKey(n) : false;
    }

    void release() {
        if (this.factory == null) {
            return;
        }
        if (this.blocked) {
            new Exception("try to release a blocked event!").printStackTrace();
        }
        this.removeAllParameters();
        this.pooled = true;
        this.factory.releaseEvent(this);
    }

    public void fromEvent(EventGeneric eventGeneric) {
        this.serviceId = eventGeneric.serviceId;
        this.senderEventId = eventGeneric.senderEventId;
        this.senderTargetId = eventGeneric.senderTargetId;
        this.receiverEventId = eventGeneric.receiverEventId;
        this.receiverTargetId = eventGeneric.receiverTargetId;
        this.senderRouterId = eventGeneric.senderRouterId;
        this.receiverRouterId = eventGeneric.receiverRouterId;
        this.result = eventGeneric.result;
        this.blocked = eventGeneric.blocked;
        this.isAnswer = eventGeneric.isAnswer;
        this.takeParams(eventGeneric);
    }

    public void fromStream(DataInputStream dataInputStream) {
        this.readHeader(dataInputStream);
        this.readParameters(dataInputStream);
    }

    public boolean getBoolean(int n) {
        return this.getPrimitiveData(n, (byte)2, 0L) != 0L;
    }

    public byte getByte(int n) {
        return (byte)this.getPrimitiveData(n, (byte)6, 0L);
    }

    public byte[] getByteArray(int n) {
        return (byte[])this.getObjectData(n, (byte)7, null);
    }

    public char getChar(int n) {
        return (char)this.getPrimitiveData(n, (byte)8, 0);
    }

    public double getDouble(int n) {
        return Double.longBitsToDouble((long)this.getPrimitiveData(n, (byte)4, DEFAULT_DOUBLE_VALUE));
    }

    public EventGeneric getEvent(int n) {
        return (EventGeneric)this.getObjectData(n, (byte)9, null);
    }

    public float getFloat(int n) {
        return Float.intBitsToFloat((int)this.getPrimitiveData(n, (byte)3, DEFAULT_FLOAT_VALUE));
    }

    public int getInt(int n) {
        return (int)this.getPrimitiveData(n, (byte)1, 0L);
    }

    public long getLong(int n) {
        return this.getPrimitiveData(n, (byte)10, 0L);
    }

    public Object getObject(int n) {
        return this.getObjectData(n, (byte)12, null);
    }

    public short getShort(int n) {
        return (short)this.getPrimitiveData(n, (byte)11, 0L);
    }

    public String getString(int n) {
        return (String)this.getObjectData(n, (byte)5, "");
    }

    public InvocationContext getInvocationContext() {
        return this.invocationContext;
    }

    public String getHeaderString() {
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append("[");
        stringBuffer.append(this.senderRouterId);
        stringBuffer.append(".");
        stringBuffer.append(this.getSenderTargetId());
        stringBuffer.append(".");
        stringBuffer.append(this.getSenderEventId());
        stringBuffer.append("]-->[");
        stringBuffer.append(this.receiverRouterId);
        if (this.serviceId > 0) {
            stringBuffer.append(":");
            stringBuffer.append(this.serviceId);
            stringBuffer.append("]");
        } else {
            stringBuffer.append(".");
            stringBuffer.append(this.getReceiverTargetId());
            stringBuffer.append(".");
            stringBuffer.append(this.getReceiverEventId());
            stringBuffer.append("]");
        }
        if (this.isAnswer) {
            stringBuffer.append("[A");
            stringBuffer.append(this.result);
            stringBuffer.append("]");
        }
        if (this.blocked) {
            stringBuffer.append("[B]");
        }
        return stringBuffer.toString();
    }

    public int getParamCount() {
        int n = 0;
        if (this.type_0 > 0) {
            ++n;
        }
        if (this.type_1 > 0) {
            ++n;
        }
        if (this.type_2 > 0) {
            ++n;
        }
        if (this.type_3 > 0) {
            ++n;
        }
        if (this.type_4 > 0) {
            ++n;
        }
        if (this.type_5 > 0) {
            ++n;
        }
        if (this.type_6 > 0) {
            ++n;
        }
        if (this.type_7 > 0) {
            ++n;
        }
        if (this.extend != null) {
            return n + this.extend.parameterTypes.size();
        }
        return n;
    }

    public IntSet getParamIndexes() {
        IntOptHashSet intOptHashSet = new IntOptHashSet();
        if (this.type_0 != 0) {
            intOptHashSet.add(0);
        }
        if (this.type_1 != 0) {
            intOptHashSet.add(1);
        }
        if (this.type_2 != 0) {
            intOptHashSet.add(2);
        }
        if (this.type_3 != 0) {
            intOptHashSet.add(3);
        }
        if (this.type_4 != 0) {
            intOptHashSet.add(4);
        }
        if (this.type_5 != 0) {
            intOptHashSet.add(5);
        }
        if (this.type_6 != 0) {
            intOptHashSet.add(6);
        }
        if (this.type_7 != 0) {
            intOptHashSet.add(7);
        }
        if (this.extend != null) {
            IntIterator intIterator = this.extend.parameterTypes.keySet().iterator();
            while (intIterator.hasNext()) {
                intOptHashSet.add(intIterator.next());
            }
        }
        return intOptHashSet;
    }

    public String[] getParametersAsStringArray() {
        String[] stringArray = new String[3 * this.getParamCount()];
        int n = 0;
        for (int i2 = 0; i2 < 8; ++i2) {
            byte by = this.getType(i2);
            if (by == 0) continue;
            stringArray[n++] = Integer.toString(i2);
            stringArray[n++] = EventGeneric.getTypeAsString(by);
            stringArray[n++] = this.getValueString(i2);
        }
        if (this.extend != null) {
            Iterator iterator = this.extend.parameterTypes.entrySet().iterator();
            while (iterator.hasNext()) {
                IntIntMap$Entry intIntMap$Entry = (IntIntMap$Entry)iterator.next();
                int n2 = intIntMap$Entry.getKey();
                int n3 = intIntMap$Entry.getValue();
                stringArray[n++] = Integer.toString(intIntMap$Entry.getKey());
                stringArray[n++] = EventGeneric.getTypeAsString(n3);
                stringArray[n++] = this.getValueString(n2);
            }
        }
        return stringArray;
    }

    public String getParamString() {
        if (this.getParamCount() == 0) {
            return "none";
        }
        StringBuffer stringBuffer = new StringBuffer(100);
        for (int i2 = 0; i2 < 8; ++i2) {
            byte by = this.getType(i2);
            if (by == 0) continue;
            stringBuffer.append("[Index ");
            stringBuffer.append(i2);
            stringBuffer.append(":");
            stringBuffer.append(EventGeneric.getTypeAsString(by));
            stringBuffer.append(":");
            stringBuffer.append(this.getValueString(i2));
            stringBuffer.append("]");
        }
        if (this.extend != null) {
            Iterator iterator = this.extend.parameterTypes.entrySet().iterator();
            while (iterator.hasNext()) {
                IntIntMap$Entry intIntMap$Entry = (IntIntMap$Entry)iterator.next();
                int n = intIntMap$Entry.getKey();
                byte by = (byte)intIntMap$Entry.getValue();
                stringBuffer.append("[Index ");
                stringBuffer.append(n);
                stringBuffer.append(":");
                stringBuffer.append(EventGeneric.getTypeAsString(by));
                stringBuffer.append(":");
                stringBuffer.append(this.getValueString(n));
                stringBuffer.append("]");
            }
        }
        return stringBuffer.toString();
    }

    public byte getParamType(int n) {
        switch (n) {
            case 0: {
                return this.type_0;
            }
            case 1: {
                return this.type_1;
            }
            case 2: {
                return this.type_2;
            }
            case 3: {
                return this.type_3;
            }
            case 4: {
                return this.type_4;
            }
            case 5: {
                return this.type_5;
            }
            case 6: {
                return this.type_6;
            }
            case 7: {
                return this.type_7;
            }
        }
        return this.extend != null ? (byte)this.extend.parameterTypes.get(n) : (byte)0;
    }

    public void removeAllParameters() {
        this.checkIfPooled();
        this.type_0 = 0;
        this.type_1 = 0;
        this.type_2 = 0;
        this.type_3 = 0;
        this.type_4 = 0;
        this.type_5 = 0;
        this.type_6 = 0;
        this.type_7 = 0;
        this.object_0 = null;
        this.object_1 = null;
        this.object_2 = null;
        this.object_3 = null;
        this.object_4 = null;
        this.object_5 = null;
        this.object_6 = null;
        this.object_7 = null;
        this.primitive_0 = 0L;
        this.primitive_1 = 0L;
        this.primitive_2 = 0L;
        this.primitive_3 = 0L;
        this.primitive_4 = 0L;
        this.primitive_5 = 0L;
        this.primitive_6 = 0L;
        this.primitive_7 = 0L;
        if (this.extend != null) {
            if (this.extend.parameterTypes != null && !this.extend.parameterTypes.isEmpty()) {
                this.extend.parameterTypes.clear();
                this.extend.primitiveData.clear();
                this.extend.objectData.clear();
            }
            this.extend = null;
        }
    }

    public void removeParameter(int n) {
        this.checkIfPooled();
        if (n > 8) {
            if (this.extend != null) {
                this.extend.parameterTypes.remove(n);
                this.extend.objectData.remove(n);
                this.extend.primitiveData.remove(n);
            }
        } else {
            this.setValue(n, (byte)0, null, 0L);
        }
    }

    public Object getPrimitiveObject(int n) {
        this.checkIfPooled();
        Serializable serializable = null;
        try {
            switch (this.getParamType(n)) {
                case 2: {
                    serializable = this.getBoolean(n);
                    break;
                }
                case 1: {
                    serializable = new Integer(this.getInt(n));
                    break;
                }
                case 11: {
                    serializable = new Short(this.getShort(n));
                    break;
                }
                case 10: {
                    serializable = new Long(this.getLong(n));
                    break;
                }
                case 6: {
                    serializable = new Byte(this.getByte(n));
                    break;
                }
                case 8: {
                    serializable = new Character(this.getChar(n));
                    break;
                }
            }
        }
        catch (GenericEventException genericEventException) {
            serializable = null;
        }
        return serializable;
    }

    public int getReceiverEventId() {
        return this.receiverEventId;
    }

    public int getReceiverRouterId() {
        return this.receiverRouterId;
    }

    public int getReceiverTargetId() {
        return this.receiverTargetId;
    }

    public int getResult() {
        this.checkIfPooled();
        return this.result;
    }

    public int getSenderEventId() {
        return this.senderEventId;
    }

    public int getSenderRouterId() {
        return this.senderRouterId;
    }

    public int getSenderTargetId() {
        return this.senderTargetId;
    }

    @Override
    public int getServiceId() {
        return this.serviceId;
    }

    public int getSlotType(int n) {
        return this.getParamType(n);
    }

    public boolean isAnswer() {
        return this.isAnswer;
    }

    public boolean isBlocked() {
        return this.blocked;
    }

    public boolean isPooled() {
        return this.pooled;
    }

    public void setAnswer(boolean bl) {
        this.isAnswer = bl;
    }

    public void setBlocked(boolean bl) {
        this.checkIfPooled();
        this.blocked = bl;
    }

    @Override
    public void setBoolean(int n, boolean bl) {
        this.setValue(n, (byte)2, null, bl ? 1L : 0L);
    }

    public void setByte(int n, byte by) {
        this.setValue(n, (byte)6, null, by);
    }

    public void setByteArray(int n, byte[] byArray) {
        this.setValue(n, (byte)7, byArray, 0L);
    }

    public void setChar(int n, char c2) {
        this.setValue(n, (byte)8, null, c2);
    }

    public void setDouble(int n, double d2) {
        this.setValue(n, (byte)4, null, Double.doubleToLongBits((double)d2));
    }

    public void setEvent(int n, EventGeneric eventGeneric) {
        this.setValue(n, (byte)9, eventGeneric, 0L);
    }

    public void setFloat(int n, float f2) {
        this.setValue(n, (byte)3, null, Float.floatToIntBits(f2));
    }

    @Override
    public void setInt(int n, int n2) {
        this.setValue(n, (byte)1, null, n2);
    }

    @Override
    public void setLong(int n, long l) {
        this.setValue(n, (byte)10, null, l);
    }

    @Override
    public void setObject(int n, Object object) {
        this.setValue(n, (byte)12, object, 0L);
    }

    public void setShort(int n, short s) {
        this.setValue(n, (byte)11, null, s);
    }

    @Override
    public void setString(int n, String string) {
        this.setValue(n, (byte)5, string, 0L);
    }

    public void setInvocationContext(InvocationContext invocationContext) {
        this.invocationContext = invocationContext;
    }

    public void setPrimitiveByObject(int n, Object object) {
        this.checkIfPooled();
        if (object == null) {
            this.setString(n, null);
        } else if (object instanceof String) {
            this.setString(n, (String)object);
        } else if (object instanceof Double) {
            this.setDouble(n, (Double)object);
        } else if (object instanceof Float) {
            this.setFloat(n, ((Float)object).floatValue());
        } else if (object instanceof Boolean) {
            this.setBoolean(n, (Boolean)object);
        } else if (object instanceof Integer) {
            this.setInt(n, (Integer)object);
        } else if (object instanceof Short) {
            this.setShort(n, (Short)object);
        } else if (object instanceof Byte) {
            this.setByte(n, (Byte)object);
        } else if (object instanceof Character) {
            this.setChar(n, ((Character)object).charValue());
        } else if (object instanceof Long) {
            this.setLong(n, (Long)object);
        } else {
            this.setString(n, object.toString());
        }
    }

    public void setReceiverEventId(int n) {
        this.checkIfPooled();
        this.receiverEventId = n;
    }

    public void setReceiverRouterId(int n) {
        this.checkIfPooled();
        this.receiverRouterId = n;
    }

    public void setReceiverTargetId(int n) {
        this.checkIfPooled();
        this.receiverTargetId = n;
    }

    public void setResult(int n) {
        this.checkIfPooled();
        this.result = n;
    }

    public void setSenderEventId(int n) {
        this.checkIfPooled();
        this.senderEventId = n;
    }

    public void setSenderRouterId(int n) {
        this.checkIfPooled();
        this.senderRouterId = n;
    }

    public void setSenderTargetId(int n) {
        this.checkIfPooled();
        this.senderTargetId = n;
    }

    public void setServiceId(int n) {
        this.checkIfPooled();
        this.serviceId = n;
    }

    public boolean setValue(int n, int n2, String string) {
        this.checkIfPooled();
        boolean bl = true;
        try {
            switch (n2) {
                case 1: {
                    this.setInt(n, Integer.parseInt(string));
                    break;
                }
                case 2: {
                    boolean bl2 = false;
                    try {
                        int n3 = Integer.parseInt(string);
                        if (n3 > 0) {
                            bl2 = true;
                        }
                    }
                    catch (NumberFormatException numberFormatException) {
                        bl2 = Boolean.valueOf(string);
                    }
                    this.setBoolean(n, bl2);
                    break;
                }
                case 3: {
                    this.setFloat(n, Float.parseFloat(string));
                    break;
                }
                case 4: {
                    this.setDouble(n, Double.parseDouble((String)string));
                    break;
                }
                case 5: {
                    this.setString(n, string);
                    break;
                }
                case 6: {
                    this.setByte(n, Byte.parseByte(string));
                    break;
                }
                case 8: {
                    this.setChar(n, string == null ? (char)' ' : string.charAt(0));
                    break;
                }
                case 10: {
                    this.setLong(n, Long.parseLong(string));
                    break;
                }
                case 11: {
                    this.setShort(n, Short.parseShort(string));
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

    public boolean swap() {
        this.checkIfPooled();
        if (this.getSenderTargetId() != 0 && this.getSenderEventId() != 0) {
            int n = this.receiverTargetId;
            this.receiverTargetId = this.senderTargetId;
            this.receiverEventId = this.senderEventId;
            this.senderTargetId = n;
            this.senderEventId = 0;
            this.receiverRouterId = this.senderRouterId;
            this.senderRouterId = 0;
            return true;
        }
        return false;
    }

    public void takeParams(EventGeneric eventGeneric) {
        this.removeAllParameters();
        this.type_0 = eventGeneric.type_0;
        this.type_1 = eventGeneric.type_1;
        this.type_2 = eventGeneric.type_2;
        this.type_3 = eventGeneric.type_3;
        this.type_4 = eventGeneric.type_4;
        this.type_5 = eventGeneric.type_5;
        this.type_6 = eventGeneric.type_6;
        this.type_7 = eventGeneric.type_7;
        this.object_0 = eventGeneric.object_0;
        this.object_1 = eventGeneric.object_1;
        this.object_2 = eventGeneric.object_2;
        this.object_3 = eventGeneric.object_3;
        this.object_4 = eventGeneric.object_4;
        this.object_5 = eventGeneric.object_5;
        this.object_6 = eventGeneric.object_6;
        this.object_7 = eventGeneric.object_7;
        this.primitive_0 = eventGeneric.primitive_0;
        this.primitive_1 = eventGeneric.primitive_1;
        this.primitive_2 = eventGeneric.primitive_2;
        this.primitive_3 = eventGeneric.primitive_3;
        this.primitive_4 = eventGeneric.primitive_4;
        this.primitive_5 = eventGeneric.primitive_5;
        this.primitive_6 = eventGeneric.primitive_6;
        this.primitive_7 = eventGeneric.primitive_7;
        if (eventGeneric.extend != null) {
            this.extend = new EventGeneric$GEExtend(this);
            IntIntOptHashMap.copy(eventGeneric.extend.parameterTypes, this.extend.parameterTypes);
            IntObjectOptHashMap.copy(eventGeneric.extend.objectData, this.extend.objectData);
            IntLongOptHashMap.copy(eventGeneric.extend.primitiveData, this.extend.primitiveData);
        }
    }

    public void toStream(DataOutputStream dataOutputStream) {
        this.writeHeader(dataOutputStream);
        this.writeParameters(dataOutputStream);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        if (this.pooled) {
            stringBuffer.append("pooled ");
        }
        stringBuffer.append("Event{");
        stringBuffer.append(this.getHeaderString());
        if (!this.pooled) {
            stringBuffer.append(this.getParamString());
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    void removeFromPool() {
        this.pooled = false;
        this.clearHeader();
    }

    private void checkIfPooled() {
        if (this.pooled) {
            if (ServiceManager.mLogger == null) {
                new GenericEventException(new StringBuffer().append("Access to a pooled EventGeneric ").append(this).append("!").toString()).printStackTrace();
            } else {
                ServiceManager.mLogger.error(1).append("Access to a pooled EventGeneric ").append(this).append("!").attachThrowable(new GenericEventException("Access to a pooled EventGeneric!")).log();
            }
        }
    }

    private long containsAndCheckType(int n, byte by, byte by2, long l, long l2) {
        if (by == 0) {
            ServiceManager.mLogger.warn(1).append("Access to an empty parameter (index: ").append(n).append(") in EventGeneric ").append(this).append("!").log();
            return l2;
        }
        if (by != by2) {
            StringBuffer stringBuffer = new StringBuffer(70);
            stringBuffer.append("Wrong parameter access: [parameter ");
            stringBuffer.append(n);
            stringBuffer.append("][event contains ");
            stringBuffer.append(EventGeneric.getTypeAsString(by));
            stringBuffer.append("][user expects ");
            stringBuffer.append(EventGeneric.getTypeAsString(by2));
            stringBuffer.append("]");
            throw new GenericEventException(4, stringBuffer.toString());
        }
        return l;
    }

    private Object containsAndCheckType(int n, byte by, byte by2, Object object, Object object2) {
        if (by == 0) {
            ServiceManager.mLogger.warn(1).append("Access to an empty parameter (index: ").append(n).append(") in EventGeneric ").append(this).append("!").log();
            return object2;
        }
        if (by != by2) {
            StringBuffer stringBuffer = new StringBuffer(70);
            stringBuffer.append("Wrong parameter access: [parameter ");
            stringBuffer.append(n);
            stringBuffer.append("][event contains ");
            stringBuffer.append(EventGeneric.getTypeAsString(by));
            stringBuffer.append("][user expects ");
            stringBuffer.append(EventGeneric.getTypeAsString(by2));
            stringBuffer.append("]");
            throw new GenericEventException(4, stringBuffer.toString());
        }
        return object;
    }

    private Object getObjectData(int n, byte by, Object object) {
        this.checkIfPooled();
        switch (n) {
            case 0: {
                return this.containsAndCheckType(n, this.type_0, by, this.object_0, object);
            }
            case 1: {
                return this.containsAndCheckType(n, this.type_1, by, this.object_1, object);
            }
            case 2: {
                return this.containsAndCheckType(n, this.type_2, by, this.object_2, object);
            }
            case 3: {
                return this.containsAndCheckType(n, this.type_3, by, this.object_3, object);
            }
            case 4: {
                return this.containsAndCheckType(n, this.type_4, by, this.object_4, object);
            }
            case 5: {
                return this.containsAndCheckType(n, this.type_5, by, this.object_5, object);
            }
            case 6: {
                return this.containsAndCheckType(n, this.type_6, by, this.object_6, object);
            }
            case 7: {
                return this.containsAndCheckType(n, this.type_7, by, this.object_7, object);
            }
        }
        if (this.extend != null) {
            return this.containsAndCheckType(n, (byte)this.extend.parameterTypes.get(n), by, this.extend.objectData.get(n), object);
        }
        return object;
    }

    private long getPrimitiveData(int n, byte by, long l) {
        this.checkIfPooled();
        switch (n) {
            case 0: {
                return this.containsAndCheckType(n, this.type_0, by, this.primitive_0, l);
            }
            case 1: {
                return this.containsAndCheckType(n, this.type_1, by, this.primitive_1, l);
            }
            case 2: {
                return this.containsAndCheckType(n, this.type_2, by, this.primitive_2, l);
            }
            case 3: {
                return this.containsAndCheckType(n, this.type_3, by, this.primitive_3, l);
            }
            case 4: {
                return this.containsAndCheckType(n, this.type_4, by, this.primitive_4, l);
            }
            case 5: {
                return this.containsAndCheckType(n, this.type_5, by, this.primitive_5, l);
            }
            case 6: {
                return this.containsAndCheckType(n, this.type_6, by, this.primitive_6, l);
            }
            case 7: {
                return this.containsAndCheckType(n, this.type_7, by, this.primitive_7, l);
            }
        }
        return this.extend != null ? this.containsAndCheckType(n, (byte)this.extend.parameterTypes.get(n), by, this.extend.primitiveData.get(n), l) : l;
    }

    private byte getType(int n) {
        switch (n) {
            case 0: {
                return this.type_0;
            }
            case 1: {
                return this.type_1;
            }
            case 2: {
                return this.type_2;
            }
            case 3: {
                return this.type_3;
            }
            case 4: {
                return this.type_4;
            }
            case 5: {
                return this.type_5;
            }
            case 6: {
                return this.type_6;
            }
            case 7: {
                return this.type_7;
            }
        }
        if (this.extend != null && this.extend.parameterTypes.containsKey(n)) {
            return (byte)this.extend.parameterTypes.get(n);
        }
        return 0;
    }

    private String getValueString(int n) {
        byte by = this.getType(n);
        try {
            switch (by) {
                case 0: {
                    return "";
                }
                case 1: {
                    int n2 = this.getInt(n);
                    return Integer.toString(n2);
                }
                case 2: {
                    boolean bl = this.getBoolean(n);
                    return Boolean.toString(bl);
                }
                case 6: {
                    byte by2 = this.getByte(n);
                    return Byte.toString(by2);
                }
                case 8: {
                    char c2 = this.getChar(n);
                    return Character.toString(c2);
                }
                case 10: {
                    long l = this.getLong(n);
                    return Long.toString(l);
                }
                case 11: {
                    short s = this.getShort(n);
                    return Short.toString(s);
                }
                case 3: {
                    float f2 = this.getFloat(n);
                    return Float.toString(f2);
                }
                case 4: {
                    double d2 = this.getDouble(n);
                    return Double.toString((double)d2);
                }
                case 5: {
                    String string = this.getString(n);
                    if (string == null) {
                        return "null";
                    }
                    return string.toString();
                }
                case 9: {
                    EventGeneric eventGeneric = this.getEvent(n);
                    if (eventGeneric == null) {
                        return "null";
                    }
                    return eventGeneric.toString();
                }
                case 7: {
                    byte[] byArray = this.getByteArray(n);
                    if (byArray == null) {
                        return "null";
                    }
                    StringBuffer stringBuffer = new StringBuffer(220);
                    stringBuffer.append("Length=");
                    stringBuffer.append(byArray.length);
                    if (byArray.length > 0) {
                        stringBuffer.append(" - ");
                        stringBuffer.append(Util.toString(byArray, 200));
                    }
                    return stringBuffer.toString();
                }
                case 12: {
                    Object object = this.getObject(n);
                    if (object == null) {
                        return "null";
                    }
                    if (object.getClass().isArray()) {
                        return ArrayUtils.asString(object);
                    }
                    return object.toString();
                }
            }
            return new StringBuffer().append("unknown").append(Integer.toString(by)).toString();
        }
        catch (Exception exception) {
            return "Exception in toString()!";
        }
    }

    private void setValue(int n, byte by, Object object, long l) {
        this.checkIfPooled();
        switch (n) {
            case 0: {
                this.type_0 = by;
                this.object_0 = object;
                this.primitive_0 = l;
                break;
            }
            case 1: {
                this.type_1 = by;
                this.object_1 = object;
                this.primitive_1 = l;
                break;
            }
            case 2: {
                this.type_2 = by;
                this.object_2 = object;
                this.primitive_2 = l;
                break;
            }
            case 3: {
                this.type_3 = by;
                this.object_3 = object;
                this.primitive_3 = l;
                break;
            }
            case 4: {
                this.type_4 = by;
                this.object_4 = object;
                this.primitive_4 = l;
                break;
            }
            case 5: {
                this.type_5 = by;
                this.object_5 = object;
                this.primitive_5 = l;
                break;
            }
            case 6: {
                this.type_6 = by;
                this.object_6 = object;
                this.primitive_6 = l;
                break;
            }
            case 7: {
                this.type_7 = by;
                this.object_7 = object;
                this.primitive_7 = l;
                break;
            }
            default: {
                if (this.extend == null) {
                    this.extend = new EventGeneric$GEExtend(this);
                }
                this.extend.parameterTypes.put(n, by);
                this.extend.objectData.put(n, object);
                this.extend.primitiveData.put(n, l);
            }
        }
    }

    private void writeHeader(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(-1431655766);
        dataOutputStream.writeInt(this.serviceId);
        dataOutputStream.writeInt(this.receiverTargetId);
        dataOutputStream.writeInt(this.receiverEventId);
        dataOutputStream.writeInt(this.senderTargetId);
        dataOutputStream.writeInt(this.senderEventId);
        dataOutputStream.writeBoolean(this.isAnswer);
        dataOutputStream.writeInt(this.result);
        dataOutputStream.writeLong(0L);
        dataOutputStream.writeLong(0L);
        dataOutputStream.writeLong(0L);
        dataOutputStream.writeLong(0L);
    }

    private void readHeader(DataInputStream dataInputStream) {
        int n = dataInputStream.readInt();
        if (n != -1431655766) {
            throw new IOException(new StringBuffer().append("error while reading EventGeneric - read header flag:").append(Integer.toHexString(n)).toString());
        }
        this.serviceId = dataInputStream.readInt();
        this.receiverTargetId = dataInputStream.readInt();
        this.receiverEventId = dataInputStream.readInt();
        this.senderTargetId = dataInputStream.readInt();
        this.senderEventId = dataInputStream.readInt();
        this.isAnswer = dataInputStream.readBoolean();
        this.result = dataInputStream.readInt();
        dataInputStream.readLong();
        dataInputStream.readLong();
        dataInputStream.readLong();
        dataInputStream.readLong();
    }

    private void writeParameters(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.getParamCount());
        this.writeParameter(0, this.type_0, dataOutputStream);
        this.writeParameter(1, this.type_1, dataOutputStream);
        this.writeParameter(2, this.type_2, dataOutputStream);
        this.writeParameter(3, this.type_3, dataOutputStream);
        this.writeParameter(4, this.type_4, dataOutputStream);
        this.writeParameter(5, this.type_5, dataOutputStream);
        this.writeParameter(6, this.type_6, dataOutputStream);
        this.writeParameter(7, this.type_7, dataOutputStream);
        if (this.extend != null) {
            Iterator iterator = this.extend.parameterTypes.entrySet().iterator();
            while (iterator.hasNext()) {
                IntIntMap$Entry intIntMap$Entry = (IntIntMap$Entry)iterator.next();
                int n = intIntMap$Entry.getKey();
                int n2 = intIntMap$Entry.getValue();
                this.writeParameter(n, n2, dataOutputStream);
            }
        }
    }

    private void readParameters(DataInputStream dataInputStream) {
        int n = dataInputStream.readInt();
        for (int i2 = 0; i2 < n; ++i2) {
            this.readParameter(dataInputStream);
        }
    }

    private void writeParameter(int n, int n2, DataOutputStream dataOutputStream) {
        if (n2 == 0) {
            return;
        }
        dataOutputStream.writeInt(n);
        try {
            switch (n2) {
                case 1: {
                    int n3 = this.getInt(n);
                    dataOutputStream.writeByte(n2);
                    dataOutputStream.writeInt(n3);
                    break;
                }
                case 2: {
                    boolean bl = this.getBoolean(n);
                    dataOutputStream.writeByte(n2);
                    dataOutputStream.writeBoolean(bl);
                    break;
                }
                case 3: {
                    float f2 = this.getFloat(n);
                    dataOutputStream.writeByte(n2);
                    dataOutputStream.writeFloat(f2);
                    break;
                }
                case 4: {
                    double d2 = this.getDouble(n);
                    dataOutputStream.writeByte(n2);
                    dataOutputStream.writeDouble(d2);
                    break;
                }
                case 5: {
                    String string = this.getString(n);
                    dataOutputStream.writeByte(n2);
                    this.writeString(dataOutputStream, string);
                    break;
                }
                case 6: {
                    byte by = this.getByte(n);
                    dataOutputStream.writeByte(n2);
                    dataOutputStream.writeByte(by);
                    break;
                }
                case 7: {
                    byte[] byArray = this.getByteArray(n);
                    dataOutputStream.writeByte(n2);
                    this.writeByteArray(dataOutputStream, byArray);
                    break;
                }
                case 8: {
                    char c2 = this.getChar(n);
                    dataOutputStream.writeByte(n2);
                    dataOutputStream.writeChar(c2);
                    break;
                }
                case 9: {
                    EventGeneric eventGeneric = this.getEvent(n);
                    if (eventGeneric != null) {
                        dataOutputStream.writeByte(n2);
                        eventGeneric.toStream(dataOutputStream);
                        break;
                    }
                    dataOutputStream.writeByte(0);
                    break;
                }
                case 10: {
                    long l = this.getLong(n);
                    dataOutputStream.writeByte(n2);
                    dataOutputStream.writeLong(l);
                    break;
                }
                case 11: {
                    short s = this.getShort(n);
                    dataOutputStream.writeByte(n2);
                    dataOutputStream.writeShort(s);
                    break;
                }
                case 12: {
                    Object object = this.getObject(n);
                    dataOutputStream.writeByte(5);
                    if (object != null) {
                        if (object.getClass().isArray()) {
                            this.writeString(dataOutputStream, ArrayUtils.asString(object));
                            break;
                        }
                        this.writeString(dataOutputStream, object.toString());
                        break;
                    }
                    this.writeString(dataOutputStream, null);
                    break;
                }
                default: {
                    dataOutputStream.writeByte(0);
                    break;
                }
            }
        }
        catch (GenericEventException genericEventException) {
            // empty catch block
        }
    }

    private void readParameter(DataInputStream dataInputStream) {
        int n = dataInputStream.readInt();
        byte by = dataInputStream.readByte();
        switch (by) {
            case 0: {
                break;
            }
            case 1: {
                this.setInt(n, dataInputStream.readInt());
                break;
            }
            case 2: {
                this.setBoolean(n, dataInputStream.readBoolean());
                break;
            }
            case 3: {
                this.setFloat(n, dataInputStream.readFloat());
                break;
            }
            case 4: {
                this.setDouble(n, dataInputStream.readDouble());
                break;
            }
            case 5: {
                this.setString(n, this.readString(dataInputStream));
                break;
            }
            case 6: {
                this.setByte(n, dataInputStream.readByte());
                break;
            }
            case 7: {
                this.setByteArray(n, this.readByteArray(dataInputStream));
                break;
            }
            case 8: {
                this.setChar(n, dataInputStream.readChar());
                break;
            }
            case 9: {
                this.setEvent(n, ServiceManager.mEventFactory.newEvent(dataInputStream));
                break;
            }
            case 10: {
                this.setLong(n, dataInputStream.readLong());
                break;
            }
            case 11: {
                this.setShort(n, dataInputStream.readShort());
                break;
            }
            case 12: {
                this.setObject(n, null);
                break;
            }
        }
    }

    private void writeByteArray(DataOutputStream dataOutputStream, byte[] byArray) {
        if (byArray == null) {
            dataOutputStream.writeInt(-1);
        } else {
            dataOutputStream.writeInt(byArray.length);
            if (byArray.length > 0) {
                dataOutputStream.write(byArray);
            }
        }
    }

    private byte[] readByteArray(DataInputStream dataInputStream) {
        int n;
        int n2 = dataInputStream.readInt();
        if (n2 < 0) {
            return null;
        }
        byte[] byArray = new byte[n2];
        int n3 = 0;
        do {
            if ((n = dataInputStream.read(byArray, n3, n2 - n3)) != -1) continue;
            return null;
        } while ((n3 += n) < n2);
        return byArray;
    }

    private void writeString(DataOutputStream dataOutputStream, String string) {
        if (string == null) {
            this.writeByteArray(dataOutputStream, null);
        } else {
            this.writeByteArray(dataOutputStream, string.getBytes("UTF-8"));
        }
    }

    private String readString(DataInputStream dataInputStream) {
        byte[] byArray = this.readByteArray(dataInputStream);
        if (byArray == null) {
            return null;
        }
        if (byArray.length == 0) {
            return "";
        }
        return new String(byArray, "UTF-8");
    }

    static {
        DEFAULT_DOUBLE_VALUE = Double.doubleToLongBits((double)0.0);
        DEFAULT_FLOAT_VALUE = Float.floatToIntBits(0.0f);
    }
}

