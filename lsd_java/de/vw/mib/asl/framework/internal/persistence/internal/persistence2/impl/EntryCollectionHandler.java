/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 */
package de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl;

import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceDataHandler;
import edu.emory.mathcs.backport.java.util.AbstractMap$SimpleEntry;
import java.util.Map$Entry;

public class EntryCollectionHandler
implements PersistenceDataHandler {
    private final int fieldId;
    private final PersistenceDataHandler delegate;
    private Map$Entry entry;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$internal$persistence$internal$persistence2$impl$EntryCollectionHandler;

    public EntryCollectionHandler(int n, PersistenceDataHandler persistenceDataHandler) {
        if (!$assertionsDisabled && persistenceDataHandler == null) {
            throw new AssertionError();
        }
        this.fieldId = n;
        this.delegate = persistenceDataHandler;
    }

    @Override
    public void handle(int n, boolean bl) {
        this.handleSingleValue(n, new Boolean(bl));
    }

    @Override
    public void handle(int n, byte by) {
        this.handleSingleValue(n, new Byte(by));
    }

    @Override
    public void handle(int n, char c2) {
        this.handleSingleValue(n, new Character(c2));
    }

    @Override
    public void handle(int n, short s) {
        this.handleSingleValue(n, new Short(s));
    }

    @Override
    public void handle(int n, int n2) {
        this.handleSingleValue(n, new Integer(n2));
    }

    @Override
    public void handle(int n, long l) {
        this.handleSingleValue(n, new Long(l));
    }

    @Override
    public void handle(int n, float f2) {
        this.handleSingleValue(n, new Float(f2));
    }

    @Override
    public void handle(int n, double d2) {
        this.handleSingleValue(n, new Double(d2));
    }

    @Override
    public void handle(int n, String string) {
        this.handleSingleValue(n, string);
    }

    @Override
    public void handle(int n, Persistable persistable) {
        this.handleSingleValue(n, persistable);
    }

    @Override
    public void handle(int n, Map$Entry map$Entry) {
        throw new IllegalArgumentException("It is not allowed to add entries to other entries");
    }

    @Override
    public void handleEmptyCollection(int n) {
        throw new IllegalArgumentException("Entries must not contain collections");
    }

    @Override
    public void finish() {
        throw new IllegalArgumentException("Finished must not be called for the entry collector");
    }

    private void handleSingleValue(int n, Object object) {
        if (this.fieldId != n) {
            throw new IllegalArgumentException(new StringBuffer().append("You can only add values (to map entries) for the field: ").append(this.fieldId).toString());
        }
        if (this.entry == null) {
            this.entry = new AbstractMap$SimpleEntry(object, null);
        } else {
            this.entry.setValue(object);
            this.delegate.handle(this.fieldId, this.entry);
            this.entry = null;
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

    static {
        $assertionsDisabled = !(class$de$vw$mib$asl$framework$internal$persistence$internal$persistence2$impl$EntryCollectionHandler == null ? (class$de$vw$mib$asl$framework$internal$persistence$internal$persistence2$impl$EntryCollectionHandler = EntryCollectionHandler.class$("de.vw.mib.asl.framework.internal.persistence.internal.persistence2.impl.EntryCollectionHandler")) : class$de$vw$mib$asl$framework$internal$persistence$internal$persistence2$impl$EntryCollectionHandler).desiredAssertionStatus();
    }
}

