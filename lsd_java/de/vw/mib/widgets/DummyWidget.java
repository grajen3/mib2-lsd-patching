/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Insets;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.models.ViewModel;

public final class DummyWidget
extends AbstractWidget {
    @Override
    protected void reset() {
        super.reset();
    }

    @Override
    public void init(boolean bl, int n, boolean bl2, EasingParams[] easingParamsArray, boolean bl3, int n2, boolean bl4, String string, int n3, Insets insets, boolean bl5, int n4, int n5, int n6) {
        super.init(bl, n, bl2, easingParamsArray, bl3, n2, bl4, string, n3, insets, bl5, n4, n5, n6);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
    }
}

