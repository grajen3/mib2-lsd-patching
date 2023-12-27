/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.result.handling;

import de.vw.mib.asl.api.speechengine.result.handling.ResultSession;
import de.vw.mib.asl.api.speechengine.result.model.ResultCollection;
import de.vw.mib.asl.api.speechengine.result.model.ResultItem;
import de.vw.mib.collections.ObjectArrayList;

public class ResultSessionImpl
implements ResultSession {
    private final ObjectArrayList history = new ObjectArrayList(3);
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$internal$speechengine$result$handling$ResultSessionImpl;

    @Override
    public void add(ResultCollection resultCollection) {
        if (ResultSessionImpl.needReset(resultCollection)) {
            this.history.clear();
        }
        this.history.add(resultCollection);
    }

    @Override
    public ResultCollection getResultList() {
        if (this.history.size() > 0) {
            return (ResultCollection)this.history.get(0);
        }
        return null;
    }

    @Override
    public ResultItem getLastCommand() {
        if (this.history.size() >= 1) {
            ResultCollection resultCollection = (ResultCollection)this.history.get(this.history.size() - 1);
            if (!$assertionsDisabled && resultCollection == null) {
                throw new AssertionError();
            }
            return resultCollection.getItem();
        }
        return null;
    }

    private static boolean needReset(ResultCollection resultCollection) {
        if (ResultSessionImpl.isAmbiguous(resultCollection)) {
            return true;
        }
        int n = resultCollection.getItem().getIdentifier().getId();
        return n != 61 && n != -1;
    }

    private static boolean isAmbiguous(ResultCollection resultCollection) {
        return resultCollection.getSize() > 1;
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
        $assertionsDisabled = !(class$de$vw$mib$asl$internal$speechengine$result$handling$ResultSessionImpl == null ? (class$de$vw$mib$asl$internal$speechengine$result$handling$ResultSessionImpl = ResultSessionImpl.class$("de.vw.mib.asl.internal.speechengine.result.handling.ResultSessionImpl")) : class$de$vw$mib$asl$internal$speechengine$result$handling$ResultSessionImpl).desiredAssertionStatus();
    }
}

