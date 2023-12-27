/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.ecall.functions;

import de.vw.mib.asl.api.bap.observer.BAPValueObserver;
import de.vw.mib.asl.api.bap.observer.BAPValueObserverable;
import de.vw.mib.asl.internal.ocu.common.functions.BAPOcuFunctionController;
import de.vw.mib.asl.internal.ocu.common.functions.BAPOcuFunctionControllerDelegate;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import de.vw.mib.log4mib.Logger;

abstract class ECallFunction
implements BAPOcuFunctionController,
BAPValueObserverable {
    private BAPOcuFunctionControllerDelegate _delegate;
    private ObjectObjectOptHashMap _observers;
    static /* synthetic */ Class class$de$vw$mib$log4mib$Logger;

    ECallFunction() {
    }

    protected final Logger getLogger() {
        return (Logger)this.getDelegate().getService(class$de$vw$mib$log4mib$Logger == null ? (class$de$vw$mib$log4mib$Logger = ECallFunction.class$("de.vw.mib.log4mib.Logger")) : class$de$vw$mib$log4mib$Logger);
    }

    protected final BAPOcuFunctionControllerDelegate getDelegate() {
        return this._delegate;
    }

    private ObjectObjectOptHashMap getObservers() {
        if (this._observers == null) {
            this._observers = new ObjectObjectOptHashMap(1);
        }
        return this._observers;
    }

    @Override
    public final void setDelegate(BAPOcuFunctionControllerDelegate bAPOcuFunctionControllerDelegate) {
        this._delegate = bAPOcuFunctionControllerDelegate;
    }

    @Override
    public void addObserver(BAPValueObserver bAPValueObserver, Object object) {
        this.getObservers().put(bAPValueObserver, object);
    }

    @Override
    public void removeObserver(BAPValueObserver bAPValueObserver) {
        this.getObservers().remove(bAPValueObserver);
    }

    protected void didChangeValue(BAPEntity bAPEntity) {
        Object[] objectArray = this.getObservers().keySet().toArray();
        int n = objectArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            BAPValueObserver bAPValueObserver = (BAPValueObserver)objectArray[i2];
            bAPValueObserver.bapValueChanged(this, bAPEntity, null, this.getObservers().get(bAPValueObserver));
        }
    }

    protected void didGotError(int n) {
        Object[] objectArray = this.getObservers().keySet().toArray();
        int n2 = objectArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            BAPValueObserver bAPValueObserver = (BAPValueObserver)objectArray[i2];
            bAPValueObserver.bapValueError(this, n, this.getObservers().get(bAPValueObserver));
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

