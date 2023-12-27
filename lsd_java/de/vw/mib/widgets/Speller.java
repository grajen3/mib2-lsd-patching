/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.timer.Timer;
import de.vw.mib.widgets.AbstractSpeller;
import de.vw.mib.widgets.Speller$ReferenceContainerHandler;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.ContainerModel;
import de.vw.mib.widgets.models.InactiveAreaModel;
import de.vw.mib.widgets.models.SpellerButtonModel;
import de.vw.mib.widgets.models.SpellerModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.speller.Alphabet;
import de.vw.mib.widgets.speller.SpellerElement;

public final class Speller
extends AbstractSpeller
implements SpellerModel {
    private static final String TIMER_NAME;
    private ContainerModel languageIndicatorRef;
    private int languageIndicatorDelay;
    private Timer timerContainerHandler;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$SpellerUI;

    public void init(boolean bl, int n, int n2, String[] stringArray, Image image, boolean bl2, boolean bl3, int n3, int n4, int n5, int n6, int n7, Color[] colorArray, Image[] imageArray, int n8, EasingParams[] easingParamsArray, boolean bl4, int[] nArray, int[] nArray2, Image[] imageArray2, int n9, int n10, Image[] imageArray3, InactiveAreaModel inactiveAreaModel, String string, KeyframeAnimation[] keyframeAnimationArray, int n11, int n12, ContainerModel containerModel, String[] stringArray2, boolean bl5, LayoutAttribs layoutAttribs, int n13, int n14, int n15, String string2, boolean bl6, int n16, Image image2, int n17, boolean bl7, int n18, boolean bl8, SpellerData spellerData, Insets insets, int n19, int n20, int n21, Insets insets2, boolean bl9, int n22, int n23, int n24) {
        super.init(bl, n, n2, stringArray, image, bl2, bl3, n3, n4, n5, n6, n7, colorArray, imageArray, n8, easingParamsArray, bl4, nArray, nArray2, imageArray2, n9, n10, imageArray3, inactiveAreaModel, string, keyframeAnimationArray, n11, stringArray2, bl5, layoutAttribs, n13, n14, n15, string2, bl6, n16, image2, n17, bl7, n18, bl8, spellerData, insets, n19, n20, n21, insets2, bl9, n22, n23, n24);
        this.languageIndicatorDelay = n12;
        this.languageIndicatorRef = containerModel;
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
    }

    @Override
    public void deInit() {
        if (this.timerContainerHandler != null) {
            this.timerContainerHandler.stop();
            this.timerContainerHandler = null;
        }
        super.deInit();
    }

    @Override
    protected void reset() {
        super.reset();
        this.languageIndicatorDelay = 1000;
        this.languageIndicatorRef = null;
        this.timerContainerHandler = null;
    }

    @Override
    public int get_languageIndicatorDelay() {
        return this.languageIndicatorDelay;
    }

    @Override
    public void set_languageIndicatorDelay(int n) {
        int n2 = this.languageIndicatorDelay;
        if (n2 != n) {
            this.languageIndicatorDelay = n;
            this.languageIndicatorDelayChanged(n2);
            this.propertyChanged(55);
        }
    }

    @Override
    public ContainerModel get_languageIndicatorRef() {
        return this.languageIndicatorRef;
    }

    @Override
    public void set_languageIndicatorRef(ContainerModel containerModel) {
        ContainerModel containerModel2 = this.languageIndicatorRef;
        if (containerModel2 != containerModel) {
            this.languageIndicatorRef = containerModel;
            this.languageIndicatorRefChanged(containerModel2);
            this.propertyChanged(54);
        }
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$SpellerUI == null ? (class$de$vw$mib$widgets$ui$SpellerUI = Speller.class$("de.vw.mib.widgets.ui.SpellerUI")) : class$de$vw$mib$widgets$ui$SpellerUI};
    }

    @Override
    public SpellerButtonModel getButton(Alphabet alphabet, SpellerElement spellerElement, boolean bl, boolean bl2) {
        SpellerButtonModel spellerButtonModel = super.getButton(alphabet, spellerElement, bl, bl2);
        this.disableAnimations();
        if (spellerElement != null && spellerElement.getReturnFunction().equalsIgnoreCase("FUNC_LANG") && this.get_languageIndicatorRef() != null && this.get_languageIndicatorRef().is_visible()) {
            int n = spellerButtonModel.get_x();
            int n2 = spellerButtonModel.get_width();
            int n3 = this.get_languageIndicatorRef().get_width();
            int n4 = n + (int)((double)n2 * 0.5 - (double)n3 * 0.5);
            this.get_languageIndicatorRef().set_x(n4);
        }
        this.enableAnimations();
        return spellerButtonModel;
    }

    protected void languageIndicatorDelayChanged(int n) {
    }

    protected void languageIndicatorRefChanged(Object object) {
    }

    @Override
    public void handleLanguageFlagContainer() {
        if (this.get_languageIndicatorRef() != null) {
            if (!this.get_languageIndicatorRef().is_visible()) {
                this.get_languageIndicatorRef().set_visible(true);
                this.timerContainerHandler = ServiceManager.timerManager.createTimer("Speller.TimerWidget", this.languageIndicatorDelay, false, new Speller$ReferenceContainerHandler(this.get_languageIndicatorRef()), ServiceManager.eventDispatcher);
                this.timerContainerHandler.start();
            } else {
                this.timerContainerHandler.setDelayFromNow(0);
            }
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

