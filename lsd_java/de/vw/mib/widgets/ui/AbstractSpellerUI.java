/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.ui;

import de.vw.mib.graphics.Color4f;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.drawable.image.ScaleImageDrawable;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.image.ScaleImage;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.FeatureToggles;
import de.vw.mib.widgets.event.PropertyChangedListener;
import de.vw.mib.widgets.interfaces.FocusableUI;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.log.SpellerLogger;
import de.vw.mib.widgets.models.AbstractSpellerModel;
import de.vw.mib.widgets.models.SpellerButtonModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.speller.Alphabet;
import de.vw.mib.widgets.speller.SeparatorElement;
import de.vw.mib.widgets.speller.SpellerElement;
import de.vw.mib.widgets.ui.AbstractBackgroundContainerUI;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.io.IOException;

public abstract class AbstractSpellerUI
extends AbstractBackgroundContainerUI
implements FocusableUI,
PropertyChangedListener {
    private static final boolean SHOW_SPELLER_ALPHABET = System.getProperty("de.vw.mib.widgets.speller.showAlphabet") != null;
    private static final int SEPARATORS_MAIN_ALPHABET;
    private static final int SEPARATORS_SUB_ALPHABET;
    private static final int SEPARATORS_COUNT;
    private Rectangle childBounds;
    private boolean errMsgAlreadyLogged = false;
    private ScaleImageDrawable[][] imagesSeparatorDrawables;

    @Override
    public void init() {
        super.init();
        WidgetModel widgetModel = this.getWidget();
        if (widgetModel != null) {
            widgetModel.addPropertyChangedListener(this);
        }
    }

    @Override
    public void deInit() {
        WidgetModel widgetModel = this.getWidget();
        if (widgetModel != null) {
            widgetModel.removePropertyChangedListener(this);
        }
        this.errMsgAlreadyLogged = false;
        AbstractSpellerUI.disposeDrawables(this.imagesSeparatorDrawables);
        super.deInit();
    }

    @Override
    protected void reset() {
        super.reset();
        if (this.childBounds == null) {
            this.childBounds = new Rectangle();
        } else {
            this.childBounds.setBounds(0, 0, 0, 0);
        }
        this.errMsgAlreadyLogged = false;
        this.imagesSeparatorDrawables = new ScaleImageDrawable[2][];
    }

    @Override
    public void paint(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        AbstractSpellerModel abstractSpellerModel = (AbstractSpellerModel)widgetModel;
        Alphabet alphabet = abstractSpellerModel.getAlphabet();
        if (alphabet != null) {
            this.paintAlphabet(graphics3D, viewModel, abstractSpellerModel, rectangle, rectangle2, f2, alphabet);
            this.paintSeparators(graphics3D, viewModel, abstractSpellerModel, alphabet, f2, 0);
            if (abstractSpellerModel.is_showSubspeller()) {
                this.paintFocused(graphics3D, viewModel, abstractSpellerModel, rectangle, rectangle2, f2);
            }
            if (IS_DEVELOPMENT_BUILD && (SHOW_SPELLER_ALPHABET || FeatureToggles.isFeatureToggleEnabled("de.vw.mib.widgets.speller.show.alphabet.enabled"))) {
                StringBuilder stringBuilder = new StringBuilder(alphabet.getName()).append(" <").append(alphabet.getFileName()).append(">");
                this.drawDebugText(graphics3D, abstractSpellerModel.get_x(), abstractSpellerModel.get_y() + 12, stringBuilder.toString(), Color4f.GREEN);
            }
        } else if (IS_DEVELOPMENT_BUILD) {
            this.paintUnavailable(graphics3D, abstractSpellerModel);
            this.paintDebugInfo(graphics3D, abstractSpellerModel, "No alphabet layout available!");
        }
        if (abstractSpellerModel.getSubAlphabet() == null) {
            this.paintRegularChildren(graphics3D, viewModel, abstractSpellerModel, rectangle, rectangle2, f2);
        }
    }

    private void paintAlphabet(Graphics3D graphics3D, ViewModel viewModel, AbstractSpellerModel abstractSpellerModel, Rectangle rectangle, Rectangle rectangle2, float f2, Alphabet alphabet) {
        boolean bl = viewModel.is_renderBoundingBoxes();
        for (int i2 = alphabet.getElementCount() - 1; i2 >= 0; --i2) {
            SpellerElement spellerElement = alphabet.getElement(i2);
            SpellerButtonModel spellerButtonModel = abstractSpellerModel.getButton(spellerElement);
            if (spellerButtonModel != null) {
                spellerButtonModel.getBounds(this.childBounds);
                this.childBounds.x += rectangle2.x;
                this.childBounds.y += rectangle2.y;
                this.paintChild(graphics3D, viewModel, spellerButtonModel, rectangle, this.childBounds, rectangle2, f2, bl);
                if (!IS_DEVELOPMENT_BUILD || !SHOW_SPELLER_ALPHABET && !FeatureToggles.isFeatureToggleEnabled("de.vw.mib.widgets.speller.show.alphabet.enabled")) continue;
                this.drawDebugText(graphics3D, (int)((float)this.childBounds.x + (float)this.childBounds.width * 0x6666E63E), (int)((float)this.childBounds.y + (float)this.childBounds.height * -842249154), String.valueOf(spellerElement.getIndex()), Color4f.GREEN);
                char[] cArray = spellerElement.getGraphRep().toCharArray();
                int n = (int)((float)this.childBounds.y + (float)this.childBounds.height * 0x3333733F - (float)((cArray.length - 1) * 12));
                for (int i3 = 0; i3 < cArray.length; ++i3) {
                    this.drawDebugText(graphics3D, (int)((float)this.childBounds.x + (float)this.childBounds.width * -842249154), n + i3 * 12, "0x".concat(Integer.toHexString(spellerElement.getGraphRep().charAt(i3))), Color4f.MAGENTA);
                }
                continue;
            }
            if (!IS_DEVELOPMENT_BUILD || spellerElement == null) continue;
            this.paintUnavailableSpellerButton(graphics3D, spellerElement);
        }
    }

    private void paintDebugInfo(Graphics3D graphics3D, AbstractSpellerModel abstractSpellerModel, String string) {
        int n = abstractSpellerModel.get_x();
        int n2 = abstractSpellerModel.get_height() >> 1;
        this.drawDebugText(graphics3D, n, n2, string, Color4f.RED);
        this.drawDebugText(graphics3D, n, n2 + 24, "alphabetList=".concat(Arrays.toString(abstractSpellerModel.get_alphabetList())), Color4f.GRAY);
        this.drawDebugText(graphics3D, n, n2 + 36, "alphabet='".concat(abstractSpellerModel.getCurrentAlphabetName()).concat("'"), Color4f.LIGHT_GRAY);
        this.drawDebugText(graphics3D, n, n2 + 48, "languageList=".concat(Arrays.toString(abstractSpellerModel.get_languageList())), Color4f.GRAY);
        this.drawDebugText(graphics3D, n, n2 + 60, "language='".concat(abstractSpellerModel.getCurrentLanguageName()).concat("'"), Color4f.LIGHT_GRAY);
    }

    @Override
    public void paintFocused(Graphics3D graphics3D, ViewModel viewModel, WidgetModel widgetModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        AbstractSpellerModel abstractSpellerModel = (AbstractSpellerModel)widgetModel;
        Alphabet alphabet = abstractSpellerModel.getSubAlphabet();
        if (alphabet != null) {
            this.paintSubAlphabet(graphics3D, viewModel, abstractSpellerModel, rectangle, rectangle2, f2, alphabet);
        } else if (IS_DEVELOPMENT_BUILD) {
            int n = -842216387;
            float f3 = abstractSpellerModel.get_height() >> 2;
            int n2 = -842216387;
            float f4 = (float)(abstractSpellerModel.get_height() >> 1) + f3;
            float f5 = abstractSpellerModel.get_width();
            float f6 = f3;
            float f7 = f5;
            float f8 = (float)(abstractSpellerModel.get_height() >> 1) + f6;
            this.drawDebugRectangle(graphics3D, 0, (int)f3, abstractSpellerModel.get_width(), abstractSpellerModel.get_height() >> 1, Color4f.BLACK);
            this.drawDebugLine(graphics3D, -842216387, f3, f7, f8, Color4f.RED);
            this.drawDebugLine(graphics3D, -842216387, f4, f5, f6, Color4f.RED);
            this.paintDebugInfo(graphics3D, abstractSpellerModel, "No sub alphabet layout available!");
        }
    }

    protected void paintRegularChildren(Graphics3D graphics3D, ViewModel viewModel, AbstractSpellerModel abstractSpellerModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        WidgetModel[] widgetModelArray = abstractSpellerModel.getChildren();
        boolean bl = viewModel.is_renderBoundingBoxes();
        for (int i2 = 0; i2 < widgetModelArray.length; ++i2) {
            WidgetModel widgetModel = widgetModelArray[i2];
            if (widgetModel instanceof SpellerButtonModel) continue;
            widgetModel.getBounds(this.childBounds);
            this.childBounds.x += rectangle2.x;
            this.childBounds.y += rectangle2.y;
            this.paintChild(graphics3D, viewModel, widgetModel, rectangle, this.childBounds, rectangle2, f2, bl);
        }
    }

    private void paintSeparators(Graphics3D graphics3D, ViewModel viewModel, AbstractSpellerModel abstractSpellerModel, Alphabet alphabet, float f2, int n) {
        Image[] imageArray = abstractSpellerModel.get_imagesSeparator();
        if (imageArray == null || imageArray.length <= 0) {
            return;
        }
        if (abstractSpellerModel.isInvalid() && this.imagesSeparatorDrawables[n] != null) {
            AbstractSpellerUI.disposeDrawables(this.imagesSeparatorDrawables[n]);
            this.imagesSeparatorDrawables[n] = null;
        }
        int n2 = alphabet.getSeparatorCount();
        if (this.imagesSeparatorDrawables[n] == null || this.imagesSeparatorDrawables[n].length != n2) {
            if (this.imagesSeparatorDrawables[n] != null) {
                AbstractSpellerUI.disposeDrawables(this.imagesSeparatorDrawables[n]);
                this.imagesSeparatorDrawables[n] = null;
            }
            this.imagesSeparatorDrawables[n] = new ScaleImageDrawable[n2];
        }
        boolean bl = false;
        for (int i2 = n2 - 1; i2 >= 0; --i2) {
            SeparatorElement separatorElement = alphabet.getSeparator(i2);
            int n3 = separatorElement.getImageId();
            int n4 = separatorElement.getAbsX();
            int n5 = separatorElement.getAbsY();
            int n6 = separatorElement.getWidth();
            int n7 = separatorElement.getHeight();
            try {
                if (this.imagesSeparatorDrawables[n][i2] == null) {
                    ScaleImage scaleImage = imageArray[n3].getCurrentImage();
                    BufferImage bufferImage = null;
                    try {
                        bufferImage = ServiceManager.imageManager.getImageFromCurrentSkin(scaleImage);
                    }
                    catch (IOException iOException) {
                        abstractSpellerModel.warn(SpellerLogger.getLogger()).append("Unable to load separator image!").log();
                        continue;
                    }
                    ScaleImageDrawable scaleImageDrawable = graphics3D.getDrawableManager().createScaleImageDrawable();
                    scaleImageDrawable.setImage(bufferImage);
                    scaleImageDrawable.setScaleImage(scaleImage);
                    scaleImageDrawable.setWidth(n6);
                    scaleImageDrawable.setHeight(n7);
                    this.imagesSeparatorDrawables[n][i2] = scaleImageDrawable;
                }
                if (this.imagesSeparatorDrawables[n][i2] == null) continue;
                this.imagesSeparatorDrawables[n][i2].setAlpha(f2);
                this.imagesSeparatorDrawables[n][i2].draw(n4, n5);
                continue;
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                if (IS_DEVELOPMENT_BUILD) {
                    this.drawDebugRectangle(graphics3D, n4, n5, n6, n7, Color4f.RED);
                }
                if (this.errMsgAlreadyLogged) continue;
                abstractSpellerModel.error(SpellerLogger.getLogger()).append("No separator image defined in 'imagesSeparator' at index [").append(n3).append("] for separator '").append(separatorElement).append("'").log();
                bl = true;
            }
        }
        if (bl) {
            this.errMsgAlreadyLogged = true;
        }
    }

    private void paintSubAlphabet(Graphics3D graphics3D, ViewModel viewModel, AbstractSpellerModel abstractSpellerModel, Rectangle rectangle, Rectangle rectangle2, float f2, Alphabet alphabet) {
        this.paintCompositeBackground(graphics3D, abstractSpellerModel, rectangle, rectangle2, f2);
        this.paintAlphabet(graphics3D, viewModel, abstractSpellerModel, rectangle, rectangle2, f2, alphabet);
        this.paintSeparators(graphics3D, viewModel, abstractSpellerModel, alphabet, f2, 1);
        this.paintRegularChildren(graphics3D, viewModel, abstractSpellerModel, rectangle, rectangle2, f2);
    }

    private void paintUnavailableSpellerButton(Graphics3D graphics3D, SpellerElement spellerElement) {
        int n = spellerElement.getAbsX();
        int n2 = spellerElement.getAbsY();
        int n3 = spellerElement.getWidth();
        int n4 = spellerElement.getHeight();
        this.drawDebugRectangle(graphics3D, n, n2, n3, n4, Color4f.BLACK);
        this.drawDebugLine(graphics3D, n, n2, n + n3, n2, Color4f.RED);
        this.drawDebugLine(graphics3D, n, n2, n, n2 + n4, Color4f.RED);
        this.drawDebugLine(graphics3D, n + n3, n2, n + n3, n2 + n4, Color4f.RED);
        this.drawDebugLine(graphics3D, n, n2 + n4, n + n3, n2 + n4, Color4f.RED);
        this.drawDebugLine(graphics3D, n, n2, n + n3, n2 + n4, Color4f.RED);
        this.drawDebugLine(graphics3D, n, n2 + n4, n + n3, n2, Color4f.RED);
    }

    @Override
    public void propertyChanged(WidgetModel widgetModel, int n) {
        switch (n) {
            case 32: 
            case 33: 
            case 37: 
            case 40: 
            case 41: 
            case 42: 
            case 44: {
                this.errMsgAlreadyLogged = false;
                break;
            }
            default: {
                super.propertyChanged(widgetModel, n);
            }
        }
    }
}

