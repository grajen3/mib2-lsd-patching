/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence2;

import de.vw.mib.asl.framework.api.persistence2.PersistenceDataHandler;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.log4mib.Logger;

public abstract class AbstractPersistenceDataHandler
implements PersistenceDataHandler {
    private final Logger logger;
    private final IntSet unprocessedFields = new IntOptHashSet();
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$framework$api$persistence2$AbstractPersistenceDataHandler;

    protected AbstractPersistenceDataHandler(Logger logger) {
        if (!$assertionsDisabled && logger == null) {
            throw new AssertionError();
        }
        this.logger = logger;
        this.prepare();
    }

    @Override
    public void finish() {
        if (!this.validate()) {
            this.getLogger().warn(32).append("Validation for persistable ").append(this.getPersistableId()).append("failed. Falling back to default values.").log();
            this.fillUnprocessedFieldsSet();
        }
        IntIterator intIterator = this.unprocessedFields.iterator();
        while (intIterator.hasNext()) {
            this.installDefaultValue(intIterator.next());
        }
    }

    protected abstract int[] getFieldIds() {
    }

    protected abstract void installDefaultValue(int n) {
    }

    protected abstract int getPersistableId() {
    }

    protected abstract boolean validate() {
    }

    protected Logger getLogger() {
        return this.logger;
    }

    protected void prepare() {
        this.fillUnprocessedFieldsSet();
    }

    protected void logUnknownField(int n, String string) {
        if (this.logger.isTraceEnabled(32)) {
            this.logger.trace(32).append("The field \"").append(n).append("\" of type ").append(string).append(" is not known by ").append(super.getClass().getName()).log();
        }
    }

    protected void markAsProcessed(int n) {
        this.unprocessedFields.remove(n);
    }

    protected boolean hasUnprocessedFields() {
        return !this.unprocessedFields.isEmpty();
    }

    private void fillUnprocessedFieldsSet() {
        int[] nArray = this.getFieldIds();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            this.unprocessedFields.add(nArray[i2]);
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
        $assertionsDisabled = !(class$de$vw$mib$asl$framework$api$persistence2$AbstractPersistenceDataHandler == null ? (class$de$vw$mib$asl$framework$api$persistence2$AbstractPersistenceDataHandler = AbstractPersistenceDataHandler.class$("de.vw.mib.asl.framework.api.persistence2.AbstractPersistenceDataHandler")) : class$de$vw$mib$asl$framework$api$persistence2$AbstractPersistenceDataHandler).desiredAssertionStatus();
    }
}

