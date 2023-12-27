/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.persistence;

import org.dsi.ifc.base.DSIBase;

public interface DSIPersistence
extends DSIBase {
    public static final String VERSION;
    public static final int IN_VALUECHANGEDINT;
    public static final int IN_VALUECHANGEDSTRING;
    public static final int IN_VALUECHANGEDARRAY;
    public static final int IN_VALUECHANGEDSTRINGARRAY;
    public static final int IN_VALUECHANGEDBUFFER;
    public static final int ATTR_ACTIVESQLDATABASEMEDIUM;
    public static final int ERRORCODE_NO_ERRORS;
    public static final int ERRORCODE_INVALID_NAMESPACE;
    public static final int ERRORCODE_INVALID_KEY;
    public static final int ERRORCODE_NOSPACE;
    public static final int ERRORCODE_TRANSACTION_FAILED;
    public static final int ERRORCODE_CORRUPT_DATA;
    public static final int ERRORCODE_NO_DEVICE_AVAILABLE;
    public static final int ERRORCODE_WRONG_PARAMETER_LENGTH;
    public static final int ERRORCODE_STATUS_TIME_OUT;
    public static final int ERRORCODE_DEVICE_BUSY;
    public static final int ERRORCODE_DUMMY_DATA;
    public static final int ERRORCODE_NOT_NOTIFIED;
    public static final int ERRORCODE_INVALID_TIMEOUT;
    public static final int ERRORCODE_ALREADY_PENDING;
    public static final int ERRORCODE_NOT_SUBSCRIBED;
    public static final int ERRORCODE_OVERLOAD;
    public static final int IMPORTANCE_ESSENTIAL;
    public static final int IMPORTANCE_DISPENSABLE;
    public static final int NAMESPACE_SIS;
    public static final int NAMESPACE_ENGINEERING;
    public static final int NAMESPACE_EEPROM;
    public static final int NAMESPACE_IOC;
    public static final int NAMESPACE_DATABASE;
    public static final int NAMESPACE_IRC;
    public static final int NAMESPACE_RAC;
    public static final int NAMESPACE_NDR;
    public static final int MEDIUM_RAM;
    public static final int MEDIUM_FLASH;
    public static final int ENGINEERINGSESSIONHOST_OTHER;
    public static final int ENGINEERINGSESSIONHOST_GREEN_MENU;
    public static final int ENGINEERINGSESSIONHOST_DIAGNOSIS;
    public static final int DIAGNOSEMODE_UNDEFINED;
    public static final int DIAGNOSEMODE_START;
    public static final int DIAGNOSEMODE_STOP;
    public static final int DIAGNOSE_FERNSTEUERUNGS_MODE_START;
    public static final int DIAGNOSE_FERNSTEUERUNGS_MODE_STOP;
    public static final int TYPE_BYTEARRAY;
    public static final int TYPE_INTEGER;
    public static final int TYPE_INTEGERARRAY;
    public static final int TYPE_STRING;
    public static final int TYPE_STRINGARRAY;
    public static final int RT_WRITEINT;
    public static final int RT_READINT;
    public static final int RT_WRITEBUFFER;
    public static final int RT_READBUFFER;
    public static final int RT_WRITESTRING;
    public static final int RT_READSTRING;
    public static final int RT_WRITEARRAY;
    public static final int RT_READARRAY;
    public static final int RT_WRITESTRINGARRAY;
    public static final int RT_READSTRINGARRAY;
    public static final int RT_ENTERENGINEERINGSESSION;
    public static final int RT_EXITENGINEERINGSESSION;
    public static final int RT_GETVISIBLESYSTEMLANGUAGES;
    public static final int RT_FLUSHSQLDATABASE;
    public static final int RT_SETSQLDATABASEMEDIUM;
    public static final int RT_BEGINTRANSACTION;
    public static final int RT_ENDTRANSACTION;
    public static final int RT_READINTTIMEOUT;
    public static final int RT_READBUFFERTIMEOUT;
    public static final int RT_READSTRINGTIMEOUT;
    public static final int RT_READARRAYTIMEOUT;
    public static final int RT_READSTRINGARRAYTIMEOUT;
    public static final int RT_SUBSCRIBE;
    public static final int RT_UNSUBSCRIBE;
    public static final int RT_UNSUBSCRIBEALL;
    public static final int RP_WRITEINT;
    public static final int RP_READINT;
    public static final int RP_WRITEBUFFER;
    public static final int RP_READBUFFER;
    public static final int RP_WRITESTRING;
    public static final int RP_READSTRING;
    public static final int RP_WRITEARRAY;
    public static final int RP_READARRAY;
    public static final int RP_WRITESTRINGARRAY;
    public static final int RP_READSTRINGARRAY;
    public static final int RP_GETVISIBLESYSTEMLANGUAGES;
    public static final int RP_FLUSHSQLDATABASE;
    public static final int RP_BEGINTRANSACTION;
    public static final int RP_ENDTRANSACTION;
    public static final int RP_UNSUBSCRIBE;

    default public void writeInt(int n, long l, int n2) {
    }

    default public void readInt(int n, long l) {
    }

    default public void readIntTimeout(int n, long l, int n2) {
    }

    default public void writeBuffer(int n, long l, byte[] byArray) {
    }

    default public void readBuffer(int n, long l) {
    }

    default public void readBufferTimeout(int n, long l, int n2) {
    }

    default public void writeString(int n, long l, String string) {
    }

    default public void readString(int n, long l) {
    }

    default public void readStringTimeout(int n, long l, int n2) {
    }

    default public void writeArray(int n, long l, int[] nArray) {
    }

    default public void readArray(int n, long l) {
    }

    default public void readArrayTimeout(int n, long l, int n2) {
    }

    default public void writeStringArray(int n, long l, String[] stringArray) {
    }

    default public void readStringArray(int n, long l) {
    }

    default public void readStringArrayTimeout(int n, long l, int n2) {
    }

    default public void enterEngineeringSession(int n) {
    }

    default public void exitEngineeringSession(int n) {
    }

    default public void getVisibleSystemLanguages() {
    }

    default public void flushSQLDatabase() {
    }

    default public void setSQLDatabaseMedium(int n) {
    }

    default public void beginTransaction(int n) {
    }

    default public void endTransaction(int n, boolean bl) {
    }

    default public void subscribe(int n, int[] nArray, long[] lArray, int n2) {
    }

    default public void unsubscribe(int n, int[] nArray, long[] lArray) {
    }

    default public void unsubscribeAll(int n) {
    }
}

