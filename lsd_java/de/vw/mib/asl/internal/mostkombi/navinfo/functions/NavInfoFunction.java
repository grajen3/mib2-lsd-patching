/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.mostkombi.navinfo.functions;

import de.vw.mib.asl.internal.mostkombi.common.category.Category;
import de.vw.mib.asl.internal.mostkombi.common.category.CategoryDelegate;
import de.vw.mib.asl.internal.mostkombi.common.sequence.Sequence;
import de.vw.mib.asl.internal.mostkombi.common.sequence.SequenceDelegate;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;
import de.vw.mib.log4mib.Logger;

abstract class NavInfoFunction
implements Category,
Sequence,
Target {
    private CategoryDelegate _categoryDelegate;
    private SequenceDelegate _sequenceStepDelegate;
    static /* synthetic */ Class class$de$vw$mib$log4mib$Logger;

    NavInfoFunction() {
    }

    protected final Logger getLogger() {
        return (Logger)((Object)this.getCategoryDelegate().getDsiService(this, class$de$vw$mib$log4mib$Logger == null ? (class$de$vw$mib$log4mib$Logger = NavInfoFunction.class$("de.vw.mib.log4mib.Logger")) : class$de$vw$mib$log4mib$Logger));
    }

    protected final CategoryDelegate getCategoryDelegate() {
        return this._categoryDelegate;
    }

    protected final SequenceDelegate getSequenceDelegate() {
        return this._sequenceStepDelegate;
    }

    @Override
    public final void setDelegate(CategoryDelegate categoryDelegate) {
        this._categoryDelegate = categoryDelegate;
    }

    @Override
    public final void appendToSequence(SequenceDelegate sequenceDelegate) {
        this._sequenceStepDelegate = sequenceDelegate;
    }

    @Override
    public boolean isPartOfOtherSequence() {
        return this.getSequenceDelegate() != null;
    }

    @Override
    public boolean isPartOfSequence(SequenceDelegate sequenceDelegate) {
        return this.getSequenceDelegate() == sequenceDelegate;
    }

    @Override
    public final String getSequenceName() {
        String string = super.getClass().getName();
        int n = string.lastIndexOf(46);
        if (n >= 0) {
            return string.substring(n + 1);
        }
        return "";
    }

    @Override
    public final GenericEvents getMainObject() {
        return null;
    }

    @Override
    public final int getTargetId() {
        return this.getIdentifier();
    }

    @Override
    public final void gotEvent(EventGeneric eventGeneric) {
    }

    @Override
    public final void setTargetId(int n) {
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

