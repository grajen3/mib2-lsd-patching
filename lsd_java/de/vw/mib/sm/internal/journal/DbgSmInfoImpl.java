/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.sm.internal.journal;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.sm.internal.journal.DbgSmInfo;
import de.vw.mib.sm.internal.journal.DbgSmInfo$DbgEvent;
import de.vw.mib.sm.internal.journal.DbgSmInfo$DbgState;
import de.vw.mib.sm.internal.journal.DbgSmInfo$DbgStatemachine;
import de.vw.mib.sm.internal.journal.DbgSmInfo$DbgSubStatemachine;
import de.vw.mib.sm.internal.journal.DbgSmInfo$DbgTransition;
import de.vw.mib.sm.internal.journal.DbgSmInfo$DbgWithID;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class DbgSmInfoImpl
implements DbgSmInfo {
    private final ClassLoader loader;
    private final Class resourceRef;
    private IntObjectMap events;
    private IntObjectMap statemachines;
    private DbgSmInfo$DbgStatemachine lastStatemachine;
    private DbgSmInfo$DbgSubStatemachine lastSubStatemachine;
    static /* synthetic */ Class class$java$lang$String;
    static /* synthetic */ Class class$de$vw$mib$sm$internal$journal$DbgSmInfo$DbgState;
    static /* synthetic */ Class class$de$vw$mib$sm$internal$journal$DbgSmInfo$DbgEvent;

    public DbgSmInfoImpl(Class clazz) {
        this.resourceRef = clazz;
        this.loader = null;
    }

    public DbgSmInfoImpl(ClassLoader classLoader) {
        this.resourceRef = null;
        this.loader = classLoader;
    }

    @Override
    public DbgSmInfo$DbgEvent getEvent(int n) {
        if (this.shouldLoadEvents()) {
            this.loadEvents();
        }
        return (DbgSmInfo$DbgEvent)this.events.get(n);
    }

    @Override
    public DbgSmInfo$DbgStatemachine getStatemachine(int n) {
        if (this.shouldLoadEvents()) {
            this.loadEvents();
        }
        if (this.shouldLoadStatemachine(n)) {
            this.loadStatemachine(n);
        }
        return (DbgSmInfo$DbgStatemachine)this.statemachines.get(n);
    }

    @Override
    public DbgSmInfo$DbgSubStatemachine getSubStatemachine(DbgSmInfo$DbgStatemachine dbgSmInfo$DbgStatemachine, int n) {
        return dbgSmInfo$DbgStatemachine == null ? null : (DbgSmInfo$DbgSubStatemachine)dbgSmInfo$DbgStatemachine.subStatemachines.get(n);
    }

    @Override
    public DbgSmInfo$DbgState getState(DbgSmInfo$DbgSubStatemachine dbgSmInfo$DbgSubStatemachine, int n) {
        return dbgSmInfo$DbgSubStatemachine == null ? null : (DbgSmInfo$DbgState)dbgSmInfo$DbgSubStatemachine.states.get(n);
    }

    @Override
    public DbgSmInfo$DbgTransition getInternalTransition(DbgSmInfo$DbgSubStatemachine dbgSmInfo$DbgSubStatemachine, int n) {
        return dbgSmInfo$DbgSubStatemachine == null ? null : (DbgSmInfo$DbgTransition)dbgSmInfo$DbgSubStatemachine.internals.get(n);
    }

    @Override
    public DbgSmInfo$DbgTransition getTriggeredTransition(DbgSmInfo$DbgSubStatemachine dbgSmInfo$DbgSubStatemachine, int n) {
        return dbgSmInfo$DbgSubStatemachine == null ? null : (DbgSmInfo$DbgTransition)dbgSmInfo$DbgSubStatemachine.triggereds.get(n);
    }

    @Override
    public DbgSmInfo$DbgTransition getUntriggeredTransition(DbgSmInfo$DbgSubStatemachine dbgSmInfo$DbgSubStatemachine, int n) {
        return dbgSmInfo$DbgSubStatemachine == null ? null : (DbgSmInfo$DbgTransition)dbgSmInfo$DbgSubStatemachine.untriggereds.get(n);
    }

    private boolean shouldLoadEvents() {
        return this.events == null;
    }

    private void loadEvents() {
        this.events = new IntObjectOptHashMap();
        this.load("Events.dbg");
    }

    private boolean shouldLoadStatemachine(int n) {
        if (this.statemachines == null) {
            return true;
        }
        return this.statemachines.get(n) == null;
    }

    private void loadStatemachine(int n) {
        this.statemachines = this.statemachines == null ? new IntObjectOptHashMap() : this.statemachines;
        this.load(new StringBuffer().append("Statemachine.").append(n).append(".dbg").toString());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void load(String string) {
        try {
            InputStream inputStream = this.openStream(string);
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                DbgSmInfo$DbgWithID dbgSmInfo$DbgWithID = null;
                String string2 = null;
                while ((string2 = bufferedReader.readLine()) != null) {
                    int n = string2.indexOf(61);
                    if (n < 0) continue;
                    String string3 = string2.substring(0, n).trim();
                    String string4 = string2.substring(n + 1).trim();
                    if (string3.startsWith("@")) {
                        this.setAttribute(dbgSmInfo$DbgWithID, string3.substring(1), string4);
                        continue;
                    }
                    if (string3.startsWith("!")) {
                        this.lookupAttribute(dbgSmInfo$DbgWithID, string3.substring(1), string4);
                        continue;
                    }
                    dbgSmInfo$DbgWithID = this.addElement(string3, string4);
                }
            }
        }
        catch (IOException iOException) {
        }
        finally {
            this.lastStatemachine = null;
            this.lastSubStatemachine = null;
        }
    }

    private InputStream openStream(String string) {
        InputStream inputStream = this.findStream(string);
        inputStream = inputStream != null ? inputStream : this.findZipStream("statemachine.zip", string);
        return inputStream;
    }

    private InputStream findZipStream(String string, String string2) {
        InputStream inputStream = this.findStream(string);
        if (inputStream != null) {
            ZipInputStream zipInputStream = new ZipInputStream(inputStream);
            ZipEntry zipEntry = zipInputStream.getNextEntry();
            while (zipEntry != null) {
                if (string2.equalsIgnoreCase(zipEntry.getName())) {
                    return zipInputStream;
                }
                zipEntry = zipInputStream.getNextEntry();
            }
        }
        return null;
    }

    private InputStream findStream(String string) {
        InputStream inputStream = null;
        if (this.loader != null) {
            InputStream inputStream2 = inputStream = inputStream != null ? inputStream : this.loader.getResourceAsStream(string);
        }
        if (this.resourceRef != null) {
            inputStream = inputStream != null ? inputStream : this.resourceRef.getResourceAsStream(string);
        }
        inputStream = inputStream != null ? inputStream : ClassLoader.getSystemResourceAsStream(string);
        return inputStream;
    }

    private DbgSmInfo$DbgWithID addElement(String string, String string2) {
        if ("EVENT".equals(string)) {
            DbgSmInfo$DbgEvent dbgSmInfo$DbgEvent = new DbgSmInfo$DbgEvent();
            dbgSmInfo$DbgEvent.ID = Integer.parseInt(string2);
            this.addToMap(this.events, dbgSmInfo$DbgEvent);
            return dbgSmInfo$DbgEvent;
        }
        if ("STATEMACHINE".equals(string)) {
            int n;
            DbgSmInfo$DbgStatemachine dbgSmInfo$DbgStatemachine = new DbgSmInfo$DbgStatemachine();
            dbgSmInfo$DbgStatemachine.ID = n = Integer.parseInt(string2);
            this.addToMap(this.statemachines, dbgSmInfo$DbgStatemachine);
            this.lastStatemachine = dbgSmInfo$DbgStatemachine;
            return dbgSmInfo$DbgStatemachine;
        }
        if ("SUBSTATEMACHINE".equals(string) && this.lastStatemachine != null) {
            DbgSmInfo$DbgSubStatemachine dbgSmInfo$DbgSubStatemachine = new DbgSmInfo$DbgSubStatemachine();
            dbgSmInfo$DbgSubStatemachine.ID = Integer.parseInt(string2);
            this.addToMap(this.lastStatemachine.subStatemachines, dbgSmInfo$DbgSubStatemachine);
            this.lastSubStatemachine = dbgSmInfo$DbgSubStatemachine;
            return dbgSmInfo$DbgSubStatemachine;
        }
        if ("STATE".equals(string) && this.lastSubStatemachine != null) {
            DbgSmInfo$DbgState dbgSmInfo$DbgState = new DbgSmInfo$DbgState();
            dbgSmInfo$DbgState.ID = Integer.parseInt(string2);
            this.addToMap(this.lastSubStatemachine.states, dbgSmInfo$DbgState);
            return dbgSmInfo$DbgState;
        }
        if ("INTERNAL".equals(string) && this.lastSubStatemachine != null) {
            DbgSmInfo$DbgTransition dbgSmInfo$DbgTransition = new DbgSmInfo$DbgTransition();
            dbgSmInfo$DbgTransition.ID = Integer.parseInt(string2);
            dbgSmInfo$DbgTransition.sign = "IT";
            dbgSmInfo$DbgTransition.kind = (char)73;
            this.addToMap(this.lastSubStatemachine.internals, dbgSmInfo$DbgTransition);
            return dbgSmInfo$DbgTransition;
        }
        if ("TRIGGERED".equals(string) && this.lastSubStatemachine != null) {
            DbgSmInfo$DbgTransition dbgSmInfo$DbgTransition = new DbgSmInfo$DbgTransition();
            dbgSmInfo$DbgTransition.ID = Integer.parseInt(string2);
            dbgSmInfo$DbgTransition.sign = "TT";
            dbgSmInfo$DbgTransition.kind = (char)84;
            this.addToMap(this.lastSubStatemachine.triggereds, dbgSmInfo$DbgTransition);
            return dbgSmInfo$DbgTransition;
        }
        if ("UNTRIGGERED".equals(string) && this.lastSubStatemachine != null) {
            DbgSmInfo$DbgTransition dbgSmInfo$DbgTransition = new DbgSmInfo$DbgTransition();
            dbgSmInfo$DbgTransition.ID = Integer.parseInt(string2);
            dbgSmInfo$DbgTransition.sign = "UT";
            dbgSmInfo$DbgTransition.kind = (char)85;
            this.addToMap(this.lastSubStatemachine.untriggereds, dbgSmInfo$DbgTransition);
            return dbgSmInfo$DbgTransition;
        }
        return null;
    }

    private void addToMap(IntObjectMap intObjectMap, DbgSmInfo$DbgWithID dbgSmInfo$DbgWithID) {
        if (dbgSmInfo$DbgWithID.ID >= 0) {
            intObjectMap.put(dbgSmInfo$DbgWithID.ID, dbgSmInfo$DbgWithID);
        }
    }

    private void setAttribute(DbgSmInfo$DbgWithID dbgSmInfo$DbgWithID, String string, String string2) {
        try {
            if (dbgSmInfo$DbgWithID != null) {
                Field field = super.getClass().getField(string);
                if (field.getType().isAssignableFrom(class$java$lang$String == null ? (class$java$lang$String = DbgSmInfoImpl.class$("java.lang.String")) : class$java$lang$String)) {
                    field.set(dbgSmInfo$DbgWithID, string2);
                } else if (field.getType().isAssignableFrom(class$de$vw$mib$sm$internal$journal$DbgSmInfo$DbgState == null ? (class$de$vw$mib$sm$internal$journal$DbgSmInfo$DbgState = DbgSmInfoImpl.class$("de.vw.mib.sm.internal.journal.DbgSmInfo$DbgState")) : class$de$vw$mib$sm$internal$journal$DbgSmInfo$DbgState)) {
                    field.set(dbgSmInfo$DbgWithID, this.findDbgState(string2));
                } else if (field.getType().isAssignableFrom(class$de$vw$mib$sm$internal$journal$DbgSmInfo$DbgEvent == null ? (class$de$vw$mib$sm$internal$journal$DbgSmInfo$DbgEvent = DbgSmInfoImpl.class$("de.vw.mib.sm.internal.journal.DbgSmInfo$DbgEvent")) : class$de$vw$mib$sm$internal$journal$DbgSmInfo$DbgEvent)) {
                    field.set(dbgSmInfo$DbgWithID, this.findDbgEvent(string2));
                }
            }
        }
        catch (SecurityException securityException) {
        }
        catch (NoSuchFieldException noSuchFieldException) {
        }
        catch (IllegalArgumentException illegalArgumentException) {
        }
        catch (IllegalAccessException illegalAccessException) {
            // empty catch block
        }
    }

    private DbgSmInfo$DbgState findDbgState(String string) {
        Iterator iterator = this.lastSubStatemachine.states.valueIterator();
        while (iterator.hasNext()) {
            DbgSmInfo$DbgState dbgSmInfo$DbgState = (DbgSmInfo$DbgState)iterator.next();
            if (dbgSmInfo$DbgState == null || !string.equals(dbgSmInfo$DbgState.SymbolicID)) continue;
            return dbgSmInfo$DbgState;
        }
        return null;
    }

    private DbgSmInfo$DbgEvent findDbgEvent(String string) {
        Iterator iterator = this.events.valueIterator();
        while (iterator.hasNext()) {
            DbgSmInfo$DbgEvent dbgSmInfo$DbgEvent = (DbgSmInfo$DbgEvent)iterator.next();
            if (dbgSmInfo$DbgEvent == null || !string.equals(dbgSmInfo$DbgEvent.SymbolicID)) continue;
            return dbgSmInfo$DbgEvent;
        }
        return null;
    }

    private void lookupAttribute(DbgSmInfo$DbgWithID dbgSmInfo$DbgWithID, String string, String string2) {
        try {
            if (dbgSmInfo$DbgWithID != null) {
                String string3;
                int n = string2.lastIndexOf(46);
                String string4 = string2.substring(0, n);
                Object object = (this.loader != null ? this.loader.loadClass(string4) : Class.forName(string4)).getField(string3 = string2.substring(n + 1)).get(null);
                if (object != null) {
                    Field field = super.getClass().getField(string);
                    field.set(dbgSmInfo$DbgWithID, object);
                }
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
        }
        catch (SecurityException securityException) {
        }
        catch (NoSuchFieldException noSuchFieldException) {
        }
        catch (IllegalArgumentException illegalArgumentException) {
        }
        catch (IllegalAccessException illegalAccessException) {
            // empty catch block
        }
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

