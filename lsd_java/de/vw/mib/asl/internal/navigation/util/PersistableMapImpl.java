/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.asl.internal.navigation.util;

import de.vw.mib.asl.api.navigation.util.PersistableMap;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import de.vw.mib.asl.framework.api.persistence.SharedPersistable;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdAddChar;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdCancelSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdDmLastDestinationsDeleteAll;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdDmLastDestinationsGet;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLastCityHistoryEntry;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLastStreetHistoryEntry;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLocationDescriptionTransform;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetLocationFromLiValueListElement;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdGetMatchingNVC;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdHistoryAddLocation;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLastCityHistoryAdd;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLastStateHistoryAdd;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLastStreetHistoryAdd;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdLiGetState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdNavLocationToStream;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdPoiGetXt9LDBs;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdPoiSelectSelectionCriteria;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdPoiStartSpellerAlongRoute;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdPoiStartSpellerAlongRouteAdvanced;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRequestValueListByListIndex;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRestoreState;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRmRouteAdd;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdRmRouteDelete;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectByCategoryUid;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectByMultipleCategoryUids;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItem;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItemByIdent;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSelectListItemPoi;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetCountryForCityAndStreetHistory;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetCurrentLD;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetInput;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetLiValueListWindowSize;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdSetNVCRange;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStartSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStopSpeller;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStreamToNavLocation;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdStripLocation;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdTransformAndStrip;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdTransformAndToStream;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdTryBestMatch;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdTryMatchLocation;
import de.vw.mib.asl.internal.navigation.gateway.command.CmdUndoChar;
import de.vw.mib.asl.internal.navigation.gateway.command.NavGatewayListener;
import de.vw.mib.asl.internal.navigation.util.ExtLoggerHelper;
import de.vw.mib.log4mib.LogMessage;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public class PersistableMapImpl
implements NavGatewayListener,
PersistableMap {
    private static final int EXTENDED_DATA_TYPE_START;
    private static final int EXTENDED_DATA_TYPE_NULL;
    private static final int EXTENDED_DATA_TYPE_BOOLEAN;
    private static final int EXTENDED_DATA_TYPE_BYTE;
    private static final int EXTENDED_DATA_TYPE_SHORT;
    private static final int EXTENDED_DATA_TYPE_CHAR;
    private static final int EXTENDED_DATA_TYPE_INT;
    private static final int EXTENDED_DATA_TYPE_LONG;
    private static final int EXTENDED_DATA_TYPE_FLOAT;
    private static final int EXTENDED_DATA_TYPE_DOUBLE;
    private static final int EXTENDED_DATA_TYPE_STRING;
    private static final int EXTENDED_DATA_TYPE_BYTEARRAY;
    private static final int EXTENDED_DATA_TYPE_NAVLOCATION;
    private static final int EXTENDED_DATA_TYPE_INTARRAY;
    private static final int EXTENDED_DATA_TYPE_PMAP;
    private static final int EXTENDED_DATA_TYPE_POINT;
    private static final int EXTENDED_DATA_TYPE_RECT;
    private static final int EXTENDED_DATA_TYPE_SURVIVING;
    private static final int EXTENDED_DATA_TYPE_END;
    private SharedPersistable container;
    private Hashtable tmp = new Hashtable();
    private Hashtable back = new Hashtable();
    private Hashtable data = new Hashtable();
    private HashSet surviving = new HashSet();
    static /* synthetic */ Class class$java$lang$Boolean;
    static /* synthetic */ Class class$java$lang$Integer;
    static /* synthetic */ Class class$java$lang$Long;
    static /* synthetic */ Class class$java$lang$Float;
    static /* synthetic */ Class class$java$lang$Double;
    static /* synthetic */ Class class$java$lang$Short;
    static /* synthetic */ Class class$java$lang$Character;
    static /* synthetic */ Class class$java$lang$Byte;
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$org$dsi$ifc$map$Point;
    static /* synthetic */ Class class$org$dsi$ifc$map$Rect;
    static /* synthetic */ Class class$org$dsi$ifc$global$NavLocation;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$navigation$util$PersistableMapImpl;
    static /* synthetic */ Class array$I;
    static /* synthetic */ Class array$B;

    public PersistableMapImpl(SharedPersistable sharedPersistable) {
        this.container = sharedPersistable;
    }

    public void markDirty(boolean bl) {
        this.container.markDirty(bl);
    }

    public void writeData(PersistenceOutputStream persistenceOutputStream) {
        Object object;
        Object object2;
        Enumeration enumeration = this.data.keys();
        persistenceOutputStream.writeByte(0);
        while (enumeration.hasMoreElements()) {
            int n;
            object2 = (String)enumeration.nextElement();
            object = this.data.get(object2);
            if (object == null) {
                persistenceOutputStream.writeByte(1);
                persistenceOutputStream.writeString((String)object2);
                continue;
            }
            if (object instanceof Boolean) {
                persistenceOutputStream.writeByte(2);
                persistenceOutputStream.writeString((String)object2);
                persistenceOutputStream.writeBoolean((Boolean)object);
                continue;
            }
            if (object instanceof Byte) {
                persistenceOutputStream.writeByte(3);
                persistenceOutputStream.writeString((String)object2);
                persistenceOutputStream.writeByte(((Byte)object).byteValue());
                continue;
            }
            if (object instanceof Short) {
                persistenceOutputStream.writeByte(4);
                persistenceOutputStream.writeString((String)object2);
                persistenceOutputStream.writeShort(((Short)object).shortValue());
                continue;
            }
            if (object instanceof Character) {
                persistenceOutputStream.writeByte(5);
                persistenceOutputStream.writeString((String)object2);
                persistenceOutputStream.writeChar(((Character)object).charValue());
                continue;
            }
            if (object instanceof Integer) {
                persistenceOutputStream.writeByte(6);
                persistenceOutputStream.writeString((String)object2);
                persistenceOutputStream.writeInt((Integer)object);
                continue;
            }
            if (object instanceof Long) {
                persistenceOutputStream.writeByte(7);
                persistenceOutputStream.writeString((String)object2);
                persistenceOutputStream.writeLong((Long)object);
                continue;
            }
            if (object instanceof Float) {
                persistenceOutputStream.writeByte(8);
                persistenceOutputStream.writeString((String)object2);
                persistenceOutputStream.writeFloat(((Float)object).floatValue());
                continue;
            }
            if (object instanceof Double) {
                persistenceOutputStream.writeByte(9);
                persistenceOutputStream.writeString((String)object2);
                persistenceOutputStream.writeDouble((Double)object);
                continue;
            }
            if (object instanceof String) {
                persistenceOutputStream.writeByte(10);
                persistenceOutputStream.writeString((String)object2);
                persistenceOutputStream.writeString((String)object);
                continue;
            }
            if (object instanceof byte[]) {
                persistenceOutputStream.writeByte(11);
                persistenceOutputStream.writeString((String)object2);
                persistenceOutputStream.writeInt(((byte[])object).length);
                persistenceOutputStream.write((byte[])object);
                continue;
            }
            if (object instanceof NavLocation) {
                object = this.back.get(object2);
                if (object == null || !(object instanceof byte[])) continue;
                persistenceOutputStream.writeByte(12);
                persistenceOutputStream.writeString((String)object2);
                persistenceOutputStream.writeInt(((byte[])object).length);
                persistenceOutputStream.write((byte[])object);
                continue;
            }
            if (object instanceof int[]) {
                persistenceOutputStream.writeByte(13);
                persistenceOutputStream.writeString((String)object2);
                persistenceOutputStream.writeInt(((int[])object).length);
                for (n = 0; n < ((int[])object).length; ++n) {
                    persistenceOutputStream.writeInt(((int[])object)[n]);
                }
                continue;
            }
            if (object instanceof PersistableMapImpl) {
                persistenceOutputStream.writeByte(14);
                persistenceOutputStream.writeString((String)object2);
                ((PersistableMapImpl)object).writeData(persistenceOutputStream);
                continue;
            }
            if (object instanceof Rect) {
                object = this.back.get(object2);
                if (object == null || !(object instanceof int[])) continue;
                persistenceOutputStream.writeByte(16);
                persistenceOutputStream.writeString((String)object2);
                persistenceOutputStream.writeInt(((int[])object).length);
                for (n = 0; n < ((int[])object).length; ++n) {
                    persistenceOutputStream.writeInt(((int[])object)[n]);
                }
                continue;
            }
            if (!(object instanceof Point) || (object = this.back.get(object2)) == null || !(object instanceof int[])) continue;
            persistenceOutputStream.writeByte(15);
            persistenceOutputStream.writeString((String)object2);
            persistenceOutputStream.writeInt(((int[])object).length);
            for (n = 0; n < ((int[])object).length; ++n) {
                persistenceOutputStream.writeInt(((int[])object)[n]);
            }
        }
        object2 = this.surviving.iterator();
        while (object2.hasNext()) {
            object = (String)object2.next();
            persistenceOutputStream.writeByte(17);
            persistenceOutputStream.writeString((String)object);
        }
        persistenceOutputStream.writeByte(255);
    }

    public void readData(PersistenceInputStream persistenceInputStream) {
        if (persistenceInputStream.available() > 0) {
            int n = 0;
            block21: while (n != 255) {
                n = persistenceInputStream.readByte() & 0xFF;
                switch (n) {
                    case 0: {
                        continue block21;
                    }
                    case 1: {
                        String string = persistenceInputStream.readString();
                        this.data.put(string, null);
                        continue block21;
                    }
                    case 2: {
                        String string = persistenceInputStream.readString();
                        boolean bl = persistenceInputStream.readBoolean();
                        this.data.put(string, new Boolean(bl));
                        continue block21;
                    }
                    case 3: {
                        String string = persistenceInputStream.readString();
                        byte by = persistenceInputStream.readByte();
                        this.data.put(string, new Byte(by));
                        continue block21;
                    }
                    case 4: {
                        String string = persistenceInputStream.readString();
                        short s = persistenceInputStream.readShort();
                        this.data.put(string, new Short(s));
                        continue block21;
                    }
                    case 5: {
                        String string = persistenceInputStream.readString();
                        char c2 = persistenceInputStream.readChar();
                        this.data.put(string, new Character(c2));
                        continue block21;
                    }
                    case 6: {
                        String string = persistenceInputStream.readString();
                        int n2 = persistenceInputStream.readInt();
                        this.data.put(string, new Integer(n2));
                        continue block21;
                    }
                    case 7: {
                        String string = persistenceInputStream.readString();
                        long l = persistenceInputStream.readLong();
                        this.data.put(string, new Long(l));
                        continue block21;
                    }
                    case 8: {
                        String string = persistenceInputStream.readString();
                        float f2 = persistenceInputStream.readFloat();
                        this.data.put(string, new Float(f2));
                        continue block21;
                    }
                    case 9: {
                        String string = persistenceInputStream.readString();
                        double d2 = persistenceInputStream.readDouble();
                        this.data.put(string, new Double(d2));
                        continue block21;
                    }
                    case 10: {
                        String string = persistenceInputStream.readString();
                        String string2 = persistenceInputStream.readString();
                        this.data.put(string, string2);
                        continue block21;
                    }
                    case 11: {
                        String string = persistenceInputStream.readString();
                        int n3 = persistenceInputStream.readInt();
                        Object[] objectArray = new byte[n3];
                        persistenceInputStream.readFully((byte[])objectArray);
                        this.data.put(string, objectArray);
                        continue block21;
                    }
                    case 12: {
                        String string = persistenceInputStream.readString();
                        int n4 = persistenceInputStream.readInt();
                        Object[] objectArray = new byte[n4];
                        persistenceInputStream.readFully((byte[])objectArray);
                        this.back.put(string, objectArray);
                        CmdStreamToNavLocation cmdStreamToNavLocation = new CmdStreamToNavLocation(this, 0, (byte[])objectArray);
                        this.tmp.put(cmdStreamToNavLocation, string);
                        cmdStreamToNavLocation.execute();
                        continue block21;
                    }
                    case 255: {
                        continue block21;
                    }
                    case 13: {
                        String string = persistenceInputStream.readString();
                        int n5 = persistenceInputStream.readInt();
                        Object[] objectArray = new int[n5];
                        for (int i2 = 0; i2 < n5; ++i2) {
                            objectArray[i2] = persistenceInputStream.readInt();
                        }
                        this.data.put(string, objectArray);
                        continue block21;
                    }
                    case 14: {
                        String string = persistenceInputStream.readString();
                        PersistableMapImpl persistableMapImpl = (PersistableMapImpl)this.getPersistableMap(string);
                        persistableMapImpl.readData(persistenceInputStream);
                        this.data.put(string, persistableMapImpl);
                        continue block21;
                    }
                    case 16: {
                        String string = persistenceInputStream.readString();
                        int n6 = persistenceInputStream.readInt();
                        Object[] objectArray = new int[n6];
                        for (int i3 = 0; i3 < n6; ++i3) {
                            objectArray[i3] = persistenceInputStream.readInt();
                        }
                        if (n6 != 4) continue block21;
                        this.back.put(string, objectArray);
                        this.data.put(string, new Rect(objectArray[0], objectArray[1], objectArray[2], objectArray[3]));
                        continue block21;
                    }
                    case 15: {
                        String string = persistenceInputStream.readString();
                        int n7 = persistenceInputStream.readInt();
                        Object[] objectArray = new int[n7];
                        for (int i4 = 0; i4 < n7; ++i4) {
                            objectArray[i4] = persistenceInputStream.readInt();
                        }
                        if (n7 != 2) continue block21;
                        this.back.put(string, objectArray);
                        this.data.put(string, new Point(objectArray[0], objectArray[1]));
                        continue block21;
                    }
                    case 17: {
                        String string = persistenceInputStream.readString();
                        this.surviving.add(string);
                        continue block21;
                    }
                }
            }
        }
    }

    @Override
    public boolean hasKey(String string) {
        return this.data.containsKey(string);
    }

    @Override
    public int getType(String string) {
        Object object = this.data.get(string);
        if (object == null) {
            this.logIfTraceEnabled(string, "getType", 1);
            return 1;
        }
        if (object instanceof Boolean) {
            this.logIfTraceEnabled(string, "getType", 2);
            return 2;
        }
        if (object instanceof Byte) {
            this.logIfTraceEnabled(string, "getType", 3);
            return 3;
        }
        if (object instanceof Short) {
            this.logIfTraceEnabled(string, "getType", 4);
            return 4;
        }
        if (object instanceof Character) {
            this.logIfTraceEnabled(string, "getType", 5);
            return 5;
        }
        if (object instanceof Integer) {
            this.logIfTraceEnabled(string, "getType", 6);
            return 6;
        }
        if (object instanceof Long) {
            this.logIfTraceEnabled(string, "getType", 7);
            return 7;
        }
        if (object instanceof Float) {
            this.logIfTraceEnabled(string, "getType", 8);
            return 8;
        }
        if (object instanceof Double) {
            this.logIfTraceEnabled(string, "getType", 9);
            return 9;
        }
        if (object instanceof String) {
            this.logIfTraceEnabled(string, "getType", 10);
            return 10;
        }
        if (object instanceof byte[]) {
            this.logIfTraceEnabled(string, "getType", 11);
            return 11;
        }
        if (object instanceof NavLocation) {
            this.logIfTraceEnabled(string, "getType", 12);
            return 12;
        }
        if (object instanceof int[]) {
            this.logIfTraceEnabled(string, "getType", 13);
            return 13;
        }
        if (object instanceof PersistableMapImpl) {
            this.logIfTraceEnabled(string, "getType", 14);
            return 14;
        }
        if (object instanceof Rect) {
            this.logIfTraceEnabled(string, "getType", 16);
            return 16;
        }
        if (object instanceof Point) {
            this.logIfTraceEnabled(string, "getType", 15);
            return 15;
        }
        this.logIfTraceEnabled(string, "getType", 1);
        return 1;
    }

    @Override
    public void setBoolean(String string, boolean bl) {
        this.logIfTraceEnabled(string, "Boolean", new Boolean(bl));
        this.data.put(string, new Boolean(bl));
        this.markDirty(true);
    }

    @Override
    public boolean getBoolean(String string, boolean bl) {
        Object object = this.data.get(string);
        if (object != null && object instanceof Boolean) {
            this.logIfTraceEnabled(string, "Boolean", object, true);
            return (Boolean)object;
        }
        this.logIfTraceEnabled(string, "Boolean", new Boolean(bl), false);
        return bl;
    }

    @Override
    public void setInt(String string, int n) {
        this.logIfTraceEnabled(string, "Int", new Integer(n));
        this.data.put(string, new Integer(n));
        this.markDirty(true);
    }

    @Override
    public int getInt(String string, int n) {
        Object object = this.data.get(string);
        if (object != null && object instanceof Number) {
            this.logIfTraceEnabled(string, "Int", object, true);
            return (Integer)object;
        }
        this.logIfTraceEnabled(string, "Int", new Integer(n), false);
        return n;
    }

    @Override
    public int[] getIntArray(String string, int[] nArray) {
        Object object = this.data.get(string);
        if (object != null && object instanceof int[]) {
            this.logIfTraceEnabled(string, "IntArray", object, true);
            return (int[])object;
        }
        this.logIfTraceEnabled(string, "IntArray", nArray, false);
        return nArray;
    }

    @Override
    public void setNavLocation(String string, NavLocation navLocation) {
        if (navLocation == null) {
            this.data.remove(string);
            this.markDirty(true);
        } else {
            this.data.put(string, navLocation);
            CmdNavLocationToStream cmdNavLocationToStream = new CmdNavLocationToStream(this, 0, navLocation);
            this.tmp.put(cmdNavLocationToStream, string);
            cmdNavLocationToStream.execute();
        }
        this.logIfTraceEnabled(string, "NavLocation", navLocation);
    }

    @Override
    public NavLocation getNavLocation(String string, NavLocation navLocation) {
        Object object = this.data.get(string);
        if (object != null && object instanceof NavLocation) {
            this.logIfTraceEnabled(string, "NavLocation", object, true);
            return (NavLocation)object;
        }
        this.logIfTraceEnabled(string, "NavLocation", navLocation, false);
        return navLocation;
    }

    @Override
    public void setString(String string, String string2) {
        if (string2 == null) {
            this.data.remove(string);
        } else {
            this.data.put(string, string2);
        }
        this.logIfTraceEnabled(string, "String", string2);
        this.markDirty(true);
    }

    @Override
    public void setIntArray(String string, int[] nArray) {
        if (nArray == null) {
            this.data.remove(string);
        } else {
            this.data.put(string, nArray);
        }
        this.logIfTraceEnabled(string, "IntArray", nArray);
        this.markDirty(true);
    }

    @Override
    public byte[] getByteArray(String string) {
        Object object = this.data.get(string);
        if (object != null && object instanceof byte[]) {
            this.logIfTraceEnabled(string, "ByteArray", object, true);
            return (byte[])object;
        }
        this.logIfTraceEnabled(string, "ByteArray", null, false);
        return null;
    }

    @Override
    public void setByteArray(String string, byte[] byArray) {
        if (byArray == null) {
            this.data.remove(string);
        } else {
            this.data.put(string, byArray);
        }
        this.logIfTraceEnabled(string, "ByteArray", byArray);
        this.markDirty(true);
    }

    @Override
    public String getString(String string, String string2) {
        Object object = this.data.get(string);
        if (object != null && object instanceof String) {
            this.logIfTraceEnabled(string, "String", object, true);
            return (String)object;
        }
        this.logIfTraceEnabled(string, "String", string2, false);
        return string2;
    }

    @Override
    public void setByte(String string, byte by) {
        this.logIfTraceEnabled(string, "Byte", new Byte(by));
        this.data.put(string, new Byte(by));
        this.markDirty(true);
    }

    @Override
    public byte getByte(String string, byte by) {
        Object object = this.data.get(string);
        if (object != null && object instanceof Number) {
            this.logIfTraceEnabled(string, "Byte", object, true);
            return ((Number)object).byteValue();
        }
        this.logIfTraceEnabled(string, "Byte", new Byte(by), false);
        return by;
    }

    @Override
    public void setChar(String string, char c2) {
        this.logIfTraceEnabled(string, "Char", new Character(c2));
        this.data.put(string, new Character(c2));
        this.markDirty(true);
    }

    @Override
    public char getChar(String string, char c2) {
        Object object = this.data.get(string);
        if (object != null && object instanceof Character) {
            this.logIfTraceEnabled(string, "Char", object, true);
            return ((Character)object).charValue();
        }
        this.logIfTraceEnabled(string, "Char", new Character(c2), false);
        return c2;
    }

    @Override
    public void setDouble(String string, double d2) {
        this.logIfTraceEnabled(string, "Double", new Double(d2));
        this.data.put(string, new Double(d2));
        this.markDirty(true);
    }

    @Override
    public double getDouble(String string, double d2) {
        Object object = this.data.get(string);
        if (object != null && object instanceof Number) {
            this.logIfTraceEnabled(string, "Double", object, true);
            return ((Number)object).doubleValue();
        }
        this.logIfTraceEnabled(string, "Double", new Double(d2), false);
        return d2;
    }

    @Override
    public void setFloat(String string, float f2) {
        this.logIfTraceEnabled(string, "Float", new Float(f2));
        this.data.put(string, new Float(f2));
        this.markDirty(true);
    }

    @Override
    public float getFloat(String string, float f2) {
        Object object = this.data.get(string);
        if (object != null && object instanceof Number) {
            this.logIfTraceEnabled(string, "Float", object, true);
            return ((Number)object).floatValue();
        }
        this.logIfTraceEnabled(string, "Float", new Float(f2), false);
        return f2;
    }

    @Override
    public void setLong(String string, long l) {
        this.logIfTraceEnabled(string, "Long", new Long(l));
        this.data.put(string, new Long(l));
        this.markDirty(true);
    }

    @Override
    public long getLong(String string, long l) {
        Object object = this.data.get(string);
        if (object != null && object instanceof Number) {
            this.logIfTraceEnabled(string, "Long", object, true);
            return ((Number)object).longValue();
        }
        this.logIfTraceEnabled(string, "Long", new Long(l), false);
        return l;
    }

    @Override
    public void setShort(String string, short s) {
        this.logIfTraceEnabled(string, "Short", new Short(s));
        this.data.put(string, new Short(s));
        this.markDirty(true);
    }

    @Override
    public short getShort(String string, short s) {
        Object object = this.data.get(string);
        if (object != null && object instanceof Number) {
            this.logIfTraceEnabled(string, "Short", object, true);
            return ((Number)object).shortValue();
        }
        this.logIfTraceEnabled(string, "Short", new Short(s), false);
        return s;
    }

    @Override
    public PersistableMap getPersistableMap(String string) {
        Object object = this.data.get(string);
        if (object == null) {
            object = new PersistableMapImpl(this.container);
            this.data.put(string, object);
            this.setSurviving(string, true);
            this.markDirty(true);
        }
        if (object instanceof PersistableMapImpl) {
            this.logIfTraceEnabled(string, "PersistableMap", object, true);
            return (PersistableMap)object;
        }
        this.logIfTraceEnabled(string, "PersistableMap", null, false);
        return null;
    }

    @Override
    public Enumeration keys() {
        return this.data.keys();
    }

    @Override
    public void handleCommandCmdStartSpeller(CmdStartSpeller cmdStartSpeller) {
    }

    @Override
    public void handleCommandCmdPoiStartSpellerAlongRoute(CmdPoiStartSpellerAlongRoute cmdPoiStartSpellerAlongRoute) {
    }

    @Override
    public void handleCommandCmdStopSpeller(CmdStopSpeller cmdStopSpeller) {
    }

    @Override
    public void handleCommandCmdCancelSpeller(CmdCancelSpeller cmdCancelSpeller) {
    }

    @Override
    public void handleCommandCmdAddChar(CmdAddChar cmdAddChar) {
    }

    @Override
    public void handleCommandCmdUndoChar(CmdUndoChar cmdUndoChar) {
    }

    @Override
    public void handleCommandCmdSelectListItem(CmdSelectListItem cmdSelectListItem) {
    }

    @Override
    public void handleCommandCmdSelectListItemByIdent(CmdSelectListItemByIdent cmdSelectListItemByIdent) {
    }

    @Override
    public void handleCommandCmdSelectByCategoryUid(CmdSelectByCategoryUid cmdSelectByCategoryUid) {
    }

    @Override
    public void handleCommandCmdSelectByMultipleCategoryUids(CmdSelectByMultipleCategoryUids cmdSelectByMultipleCategoryUids) {
    }

    @Override
    public void handleCommandCmdSelectListItemPoi(CmdSelectListItemPoi cmdSelectListItemPoi) {
    }

    @Override
    public void handleCommandCmdPoiSelectSelectionCriteria(CmdPoiSelectSelectionCriteria cmdPoiSelectSelectionCriteria) {
    }

    @Override
    public void handleCommandCmdRestoreState(CmdRestoreState cmdRestoreState) {
    }

    @Override
    public void handleCommandCmdLiGetState(CmdLiGetState cmdLiGetState) {
    }

    @Override
    public void handleCommandCmdSetInput(CmdSetInput cmdSetInput) {
    }

    @Override
    public void handleCommandCmdSetCurrentLD(CmdSetCurrentLD cmdSetCurrentLD) {
    }

    @Override
    public void handleCommandCmdTryBestMatch(CmdTryBestMatch cmdTryBestMatch) {
    }

    @Override
    public void handleCommandCmdRequestValueListByListIndex(CmdRequestValueListByListIndex cmdRequestValueListByListIndex) {
    }

    @Override
    public void handleCommandCmdDmLastDestinationsGet(CmdDmLastDestinationsGet cmdDmLastDestinationsGet) {
    }

    @Override
    public void handleCommandCmdLastCityHistoryAdd(CmdLastCityHistoryAdd cmdLastCityHistoryAdd) {
    }

    @Override
    public void handleCommandCmdLastStreetHistoryAdd(CmdLastStreetHistoryAdd cmdLastStreetHistoryAdd) {
    }

    @Override
    public void handleCommandCmdSetCountryForCityAndStreetHistory(CmdSetCountryForCityAndStreetHistory cmdSetCountryForCityAndStreetHistory) {
    }

    @Override
    public void handleCommandCmdNavLocationToStream(CmdNavLocationToStream cmdNavLocationToStream) {
        String string = (String)this.tmp.get(cmdNavLocationToStream);
        if (string != null) {
            if (cmdNavLocationToStream.isResultSuccess()) {
                this.back.put(string, cmdNavLocationToStream.getStreamOfLocation());
            }
            this.tmp.remove(cmdNavLocationToStream);
        }
        this.markDirty(true);
    }

    @Override
    public void handleCommandCmdStreamToNavLocation(CmdStreamToNavLocation cmdStreamToNavLocation) {
        String string = (String)this.tmp.get(cmdStreamToNavLocation);
        if (string != null) {
            if (cmdStreamToNavLocation.isResultSuccess()) {
                this.data.put(string, cmdStreamToNavLocation.getLocationToStream());
            }
            this.tmp.remove(cmdStreamToNavLocation);
        }
    }

    @Override
    public void handleCommandCmdGetLocationDescriptionTransform(CmdGetLocationDescriptionTransform cmdGetLocationDescriptionTransform) {
    }

    @Override
    public void handleCommandCmdStripLocation(CmdStripLocation cmdStripLocation) {
    }

    @Override
    public void handleCommandCmdGetLastCityHistoryEntry(CmdGetLastCityHistoryEntry cmdGetLastCityHistoryEntry) {
    }

    @Override
    public void handleCommandCmdRmRouteDelete(CmdRmRouteDelete cmdRmRouteDelete) {
    }

    @Override
    public void handleCommandCmdRmRouteAdd(CmdRmRouteAdd cmdRmRouteAdd) {
    }

    @Override
    public void handleCommandCmdGetLastStreetHistoryEntry(CmdGetLastStreetHistoryEntry cmdGetLastStreetHistoryEntry) {
    }

    @Override
    public void handleCommandCmdSetLiValueListWindowSize(CmdSetLiValueListWindowSize cmdSetLiValueListWindowSize) {
    }

    @Override
    public void handleCommandCmdGetMatchingNVC(CmdGetMatchingNVC cmdGetMatchingNVC) {
    }

    @Override
    public void handleCommandCmdSetNVCRange(CmdSetNVCRange cmdSetNVCRange) {
    }

    @Override
    public void handleCommandCmdHistoryAddLocation(CmdHistoryAddLocation cmdHistoryAddLocation) {
    }

    @Override
    public void handleCommandCmdTransformAndToStream(CmdTransformAndToStream cmdTransformAndToStream) {
    }

    public String toString() {
        return this.data.toString();
    }

    @Override
    public void clear() {
        Hashtable hashtable = this.data;
        this.data = new Hashtable();
        Hashtable hashtable2 = this.back;
        this.back = new Hashtable();
        Iterator iterator = this.surviving.iterator();
        while (iterator.hasNext()) {
            Object object;
            String string = (String)iterator.next();
            if (hashtable.containsKey(string)) {
                object = hashtable.get(string);
                this.data.put(string, object);
                if (object instanceof PersistableMap) {
                    ((PersistableMap)object).clear();
                }
            }
            if (!hashtable2.containsKey(string)) continue;
            object = hashtable2.get(string);
            this.back.put(string, object);
        }
        this.tmp.clear();
    }

    @Override
    public void setRect(String string, Rect rect) {
        this.logIfTraceEnabled(string, "Rect", rect);
        this.data.put(string, rect);
        this.back.put(string, new int[]{rect.getKordX(), rect.getKordY(), rect.getDiffX(), rect.getDiffY()});
        this.markDirty(true);
    }

    @Override
    public Rect getRect(String string, Rect rect) {
        Object object = this.data.get(string);
        if (object instanceof Rect) {
            this.logIfTraceEnabled(string, "Rect", object, true);
            return (Rect)object;
        }
        this.logIfTraceEnabled(string, "Rect", rect, false);
        return rect;
    }

    @Override
    public void setPoint(String string, Point point) {
        this.logIfTraceEnabled(string, "Point", point);
        this.data.put(string, point);
        this.back.put(string, new int[]{point.xPos, point.yPos});
        this.markDirty(true);
    }

    @Override
    public Point getPoint(String string, Point point) {
        Object object = this.data.get(string);
        if (object instanceof Point) {
            this.logIfTraceEnabled(string, "Point", object, true);
            return (Point)object;
        }
        this.logIfTraceEnabled(string, "Point", point, false);
        return point;
    }

    @Override
    public void setSurviving(String string, boolean bl) {
        if (bl) {
            this.surviving.add(string);
        } else {
            this.surviving.remove(string);
        }
        this.logIfTraceEnabled(string, "Surviving", new Boolean(bl));
    }

    @Override
    public boolean isSurviving(String string) {
        return this.surviving.contains(string);
    }

    @Override
    public Object removeKey(String string) {
        Object object = this.data.get(string);
        if (this.data.containsKey(string)) {
            this.data.remove(string);
            this.surviving.remove(string);
            this.back.remove(string);
            this.markDirty(true);
        }
        return object;
    }

    private boolean traceStatus() {
        return ServiceManager.logger.isTraceEnabled(this.getSubClassifier());
    }

    public int getSubClassifier() {
        return 32;
    }

    private LogMessage getLogMsg() {
        LogMessage logMessage = ServiceManager.logger.trace(this.getSubClassifier());
        logMessage.append("Persistence: ");
        return logMessage;
    }

    private LogMessage appendByteArrayToLog(LogMessage logMessage, byte[] byArray) {
        logMessage.append("[");
        for (int i2 = 0; i2 < byArray.length; ++i2) {
            logMessage.append(" ").append(byArray[i2]);
        }
        logMessage.append(" ]");
        return logMessage;
    }

    private LogMessage appendIntArrayToLog(LogMessage logMessage, int[] nArray) {
        logMessage.append("[");
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            logMessage.append(" ").append(nArray[i2]);
        }
        logMessage.append(" ]");
        return logMessage;
    }

    private void logIfTraceEnabled(String string, String string2, Object object, boolean bl) {
        if (this.traceStatus()) {
            LogMessage logMessage = this.getLogMsg();
            logMessage.append("get").append(string2).append(" : ");
            logMessage = this.logInformation(string, object, logMessage);
            logMessage.append(" : ").append(bl ? "PERSISTED" : "DEFAULT");
            logMessage.log();
        }
    }

    private void logIfTraceEnabled(String string, String string2, Object object) {
        if (this.traceStatus()) {
            LogMessage logMessage = this.getLogMsg();
            logMessage.append("set").append(string2).append(" : ");
            logMessage = this.logInformation(string, object, logMessage);
            logMessage.log();
        }
    }

    private void logIfTraceEnabled(String string, String string2, int n) {
        if (this.traceStatus()) {
            LogMessage logMessage = this.getLogMsg();
            logMessage.append(string2).append(" : ");
            logMessage = ExtLoggerHelper.getInstance().appendInt(logMessage, string, n);
            logMessage.log();
        }
    }

    @Override
    public void handleCommandCmdDmLastDestinationsDeleteAll(CmdDmLastDestinationsDeleteAll cmdDmLastDestinationsDeleteAll) {
    }

    private LogMessage logInformation(String string, Object object, LogMessage logMessage) {
        if (object == null) {
            logMessage.append(string).append(" = null");
        } else if (object.getClass().equals(class$java$lang$Boolean == null ? (class$java$lang$Boolean = PersistableMapImpl.class$("java.lang.Boolean")) : class$java$lang$Boolean)) {
            logMessage = ExtLoggerHelper.getInstance().appendBool(logMessage, string, (Boolean)object);
        } else if (object.getClass().equals(class$java$lang$Integer == null ? (class$java$lang$Integer = PersistableMapImpl.class$("java.lang.Integer")) : class$java$lang$Integer)) {
            logMessage = ExtLoggerHelper.getInstance().appendInt(logMessage, string, (Integer)object);
        } else if (object.getClass().equals(class$java$lang$Long == null ? (class$java$lang$Long = PersistableMapImpl.class$("java.lang.Long")) : class$java$lang$Long)) {
            logMessage = ExtLoggerHelper.getInstance().appendLong(logMessage, string, (Long)object);
        } else if (object.getClass().equals(class$java$lang$Float == null ? (class$java$lang$Float = PersistableMapImpl.class$("java.lang.Float")) : class$java$lang$Float)) {
            logMessage.append(string).append(" = ").append(((Float)object).floatValue());
        } else if (object.getClass().equals(class$java$lang$Double == null ? (class$java$lang$Double = PersistableMapImpl.class$("java.lang.Double")) : class$java$lang$Double)) {
            logMessage.append(string).append(" = ").append(((Double)object).shortValue());
        } else if (object.getClass().equals(class$java$lang$Short == null ? (class$java$lang$Short = PersistableMapImpl.class$("java.lang.Short")) : class$java$lang$Short)) {
            logMessage.append(string).append(" = ").append(((Short)object).shortValue());
        } else if (object.getClass().equals(class$java$lang$Character == null ? (class$java$lang$Character = PersistableMapImpl.class$("java.lang.Character")) : class$java$lang$Character)) {
            logMessage.append(string).append(" = ").append(((Character)object).charValue());
        } else if (object.getClass().equals(class$java$lang$Byte == null ? (class$java$lang$Byte = PersistableMapImpl.class$("java.lang.Byte")) : class$java$lang$Byte)) {
            logMessage.append(string).append(" = ").append(((Byte)object).byteValue());
        } else if (object.getClass().equals(class$java$lang$String == null ? (class$java$lang$String = PersistableMapImpl.class$("java.lang.String")) : class$java$lang$String)) {
            logMessage.append(string).append(" = ").append((String)object);
        } else if (object.getClass().equals(class$org$dsi$ifc$map$Point == null ? (class$org$dsi$ifc$map$Point = PersistableMapImpl.class$("org.dsi.ifc.map.Point")) : class$org$dsi$ifc$map$Point)) {
            logMessage.append(string).append(" = ").append(((Point)object).toString());
        } else if (object.getClass().equals(class$org$dsi$ifc$map$Rect == null ? (class$org$dsi$ifc$map$Rect = PersistableMapImpl.class$("org.dsi.ifc.map.Rect")) : class$org$dsi$ifc$map$Rect)) {
            logMessage.append(string).append(" = ").append(((Rect)object).toString());
        } else if (object.getClass().equals(class$org$dsi$ifc$global$NavLocation == null ? (class$org$dsi$ifc$global$NavLocation = PersistableMapImpl.class$("org.dsi.ifc.global.NavLocation")) : class$org$dsi$ifc$global$NavLocation)) {
            logMessage.append(string).append(" = ");
            logMessage = ExtLoggerHelper.getInstance().appendLocation(logMessage, (NavLocation)object);
        } else if (object.getClass().equals(class$de$vw$mib$asl$internal$navigation$util$PersistableMapImpl == null ? (class$de$vw$mib$asl$internal$navigation$util$PersistableMapImpl = PersistableMapImpl.class$("de.vw.mib.asl.internal.navigation.util.PersistableMapImpl")) : class$de$vw$mib$asl$internal$navigation$util$PersistableMapImpl)) {
            logMessage.append(string).append(" = ").append(((PersistableMapImpl)object).toString());
        } else if (object.getClass().equals(array$I == null ? (array$I = PersistableMapImpl.class$("[I")) : array$I)) {
            logMessage.append(string).append(" = ");
            logMessage = this.appendIntArrayToLog(logMessage, (int[])object);
        } else if (object.getClass().equals(array$B == null ? (array$B = PersistableMapImpl.class$("[B")) : array$B)) {
            logMessage.append(string).append(" = ");
            logMessage = this.appendByteArrayToLog(logMessage, (byte[])object);
        } else {
            logMessage.append(" = NONE RECOGNISED!");
        }
        return logMessage;
    }

    @Override
    public void handleCommandCmdTransformAndStrip(CmdTransformAndStrip cmdTransformAndStrip) {
    }

    @Override
    public void handleCommandCmdPoiGetXt9LDBs(CmdPoiGetXt9LDBs cmdPoiGetXt9LDBs) {
    }

    @Override
    public boolean isLoaded() {
        return false;
    }

    @Override
    public void handleCommandCmdTryMatchLocation(CmdTryMatchLocation cmdTryMatchLocation) {
    }

    @Override
    public void handleCommandCmdGetLocationFromLiValueListElement(CmdGetLocationFromLiValueListElement cmdGetLocationFromLiValueListElement) {
    }

    @Override
    public void handleCommandCmdLastStateHistoryAdd(CmdLastStateHistoryAdd cmdLastStateHistoryAdd) {
    }

    @Override
    public void handleCommandCmdPoiStartSpellerAlongRouteAdvanced(CmdPoiStartSpellerAlongRouteAdvanced cmdPoiStartSpellerAlongRouteAdvanced) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

