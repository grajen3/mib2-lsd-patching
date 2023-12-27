/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.kombipictureserver.usecaces;

import de.vw.mib.asl.internal.kombipictureserver.common.category.Category;
import de.vw.mib.asl.internal.kombipictureserver.common.category.CategoryDelegate;
import de.vw.mib.asl.internal.kombipictureserver.common.sequence.Sequence;
import de.vw.mib.genericevents.EventGeneric;
import de.vw.mib.genericevents.GenericEvents;
import de.vw.mib.genericevents.Target;

abstract class PictureServerUseCase
implements Category,
Sequence,
Target {
    private CategoryDelegate _categoryDelegate;

    PictureServerUseCase() {
    }

    protected final CategoryDelegate getCategoryDelegate() {
        return this._categoryDelegate;
    }

    @Override
    public final void setDelegate(CategoryDelegate categoryDelegate) {
        this._categoryDelegate = categoryDelegate;
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
}

