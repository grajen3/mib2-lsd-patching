/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.font.CursorChangedListener;
import de.vw.mib.graphics.font.CursorManager;
import de.vw.mib.graphics.font.FontAttribs;
import de.vw.mib.graphics.font.layout.TextLayout;
import de.vw.mib.graphics.font.style.GlyphStyle;
import de.vw.mib.graphics.font.style.TextStyle;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.timer.Timer;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.InputField$1;
import de.vw.mib.widgets.TextArea;
import de.vw.mib.widgets.event.AdjustmentListener;
import de.vw.mib.widgets.interfaces.Adjustable;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.models.AbstractSpellerModel;
import de.vw.mib.widgets.models.AbstractTextModel$TextHighlight;
import de.vw.mib.widgets.models.InputFieldModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.speller.InputFieldChangedListener;
import de.vw.mib.widgets.speller.SpellerChangedListener;
import java.util.ArrayList;
import java.util.List;

public final class InputField
extends TextArea
implements InputFieldModel,
SpellerChangedListener,
CursorChangedListener {
    public static final int MATCH_TEXT_DISTANCE;
    private static final int NO_VALUE;
    private static final int COLOR_HIGHLIGHT_INDEX;
    private static final int COLOR_MATCH_INDEX;
    private static final int STYLE_MATCH_INDEX;
    private static final String MATCH_START_TEXT;
    private static final String MATCH_END_TEXT;
    private static final String COMPLETION_START_TEXT;
    private static final String COMPLETION_END_TEXT;
    private static final String EMPTY_INFO_TEXT;
    private static final int CURSOR_BLINKING_TIME;
    private static final boolean CURSOR_BLINKING_ENABLED;
    private static final String TIMER_NAME;
    private Image cursorImage;
    private int cursorMode;
    private int cursorOffset;
    private Color colorHighlightForeground;
    private Color colorHighlightBackground;
    private Color colorMatchForeground;
    private AbstractSpellerModel spellerRef;
    private String hideTypingChar;
    private boolean inputTextIsHighlighted;
    private CowList adjustmentListeners;
    private int adjustmentShadowCounter;
    private int viewPortPosition;
    private Rectangle cursorArea;
    private boolean infoTextVisible;
    private Timer blinkingTimer;
    private boolean cursorVisible;
    private boolean matchTextVisible;
    private TextLayout truncationTextLayout;
    private TextLayout[] matchTextLayout;
    private TextStyle[] matchTextStyle;
    private boolean highlightVisible;
    private CowList inputFieldChangedListeners;
    private CursorManager cursorManager;
    private boolean cursorChangesEnabled;
    private boolean alternateCursorVisible;
    private Rectangle alternateCursorArea;
    private boolean forceSpellerRefCursorChange;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$InputFieldUI;

    public void init(boolean bl, int n, int n2, int n3, boolean bl2, int n4, int n5, int n6, Color color, Color color2, Color color3, Color color4, Color color5, Color color6, Color[] colorArray, Color[] colorArray2, Color color7, Image image, int n7, int n8, int n9, int n10, EasingParams[] easingParamsArray, boolean bl3, FontAttribs fontAttribs, int[] nArray, Color color8, int n11, boolean bl4, int n12, boolean bl5, String string, boolean bl6, boolean bl7, int n13, int n14, String string2, Insets insets, boolean bl8, boolean bl9, AbstractSpellerModel abstractSpellerModel, int n15, String string3, boolean bl10, Insets insets2, boolean bl11, int n16, int n17, int n18, int n19) {
        bl10 = true;
        if (colorArray2 == null || colorArray2.length == 0) {
            colorArray2 = new Color[]{color4, color6, color6};
        }
        if (colorArray == null || colorArray.length == 0) {
            colorArray = new Color[]{color3};
        }
        super.init(bl, n, n2, n3, bl2, n4, n5, n6, color, color2, color5, colorArray, colorArray2, color7, n9, n10, easingParamsArray, bl3, fontAttribs, nArray, color8, n11, bl4, n12, bl7, n13, n14, string2, insets, bl8, bl9, n15, string3, bl10, insets2, bl11, n16, n17, n18, n19);
        this.cursorImage = image;
        this.cursorMode = n7;
        this.cursorOffset = n8;
        this.colorHighlightForeground = color4;
        this.colorHighlightBackground = color3;
        this.colorMatchForeground = color6;
        this.spellerRef = abstractSpellerModel;
        this.hideTypingChar = string;
        this.inputTextIsHighlighted = false;
        this.setInternalStateFlag(14, bl5);
    }

    public void init(boolean bl, int n, int n2, int n3, boolean bl2, int n4, int n5, int n6, Color color, Color color2, Color color3, Color color4, Color color5, Color color6, Color[] colorArray, Color[] colorArray2, Color color7, Image image, int n7, int n8, int n9, EasingParams[] easingParamsArray, boolean bl3, FontAttribs fontAttribs, int[] nArray, Color color8, int n10, boolean bl4, int n11, boolean bl5, String string, boolean bl6, boolean bl7, int n12, int n13, String string2, Insets insets, boolean bl8, boolean bl9, AbstractSpellerModel abstractSpellerModel, int n14, String string3, boolean bl10, Insets insets2, boolean bl11, int n15, int n16, int n17, int n18) {
        this.init(bl, n, n2, n3, bl2, n4, n5, n6, color, color2, color3, color4, color5, color6, colorArray, colorArray2, color7, image, n7, 0, n8, n9, easingParamsArray, bl3, fontAttribs, nArray, color8, n10, bl4, n11, bl5, string, bl6, bl7, n12, n13, string2, insets, bl8, bl9, abstractSpellerModel, n14, string3, bl10, insets2, bl11, n15, n16, n17, n18);
    }

    @Override
    protected void reset() {
        super.reset();
        this.cursorManager = new CursorManager(LOGGER);
        this.cursorArea = new Rectangle();
        this.alternateCursorArea = new Rectangle();
        this.colorHighlightBackground = null;
        this.colorHighlightForeground = null;
        this.colorMatchForeground = null;
        this.spellerRef = null;
        this.cursorImage = null;
        this.hideTypingChar = null;
        this.blinkingTimer = null;
        this.inputFieldChangedListeners = CowList.EMPTY;
        this.cursorChangesEnabled = true;
        this.forceSpellerRefCursorChange = false;
        this.inputTextIsHighlighted = false;
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.cursorImage);
        this.cursorManager.addCursorChangedListener(this);
        this.registerSpellerRefChangedListener();
        this.registerCursorManager();
        this.validate();
    }

    @Override
    public void deInit() {
        this.cursorManager.setTextLayout(null, 0);
        this.cursorManager.removeCursorChangedListener(this);
        this.cursorArea.setBounds(0, 0, 0, 0);
        this.alternateCursorVisible = false;
        this.deregisterSpellerRefChangedListener();
        this.deregisterCursorManager();
        this.stopBlinkingTimer();
        this.clearTruncationTextLayout();
        this.clearMatchTextLayout();
        super.deInit();
    }

    @Override
    public void activate() {
        super.activate();
        this.validate();
    }

    @Override
    public void deActivate() {
        super.deActivate();
    }

    private void initBlinkingTimer() {
        if (this.blinkingTimer == null && CURSOR_BLINKING_ENABLED) {
            this.blinkingTimer = ServiceManager.timerManager.createTimer("InputField.BlinkingTimer", 0, true, new InputField$1(this), ServiceManager.eventDispatcher);
        }
    }

    private void startBlinkingTimer() {
        if (this.blinkingTimer == null && CURSOR_BLINKING_ENABLED && this.is_visible()) {
            this.initBlinkingTimer();
        }
        if (this.blinkingTimer != null && !this.blinkingTimer.isStarted()) {
            this.blinkingTimer.start();
        }
    }

    private void stopBlinkingTimer() {
        if (this.blinkingTimer != null) {
            this.blinkingTimer.stop();
        }
    }

    @Override
    public boolean is_inputTextIsHighlighted() {
        return this.inputTextIsHighlighted;
    }

    @Override
    public void set_inputTextIsHighlighted(boolean bl) {
        boolean bl2 = this.inputTextIsHighlighted;
        if (bl2 != bl) {
            this.inputTextIsHighlighted = bl;
            this.validate();
            this.propertyChanged(52);
        }
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$InputFieldUI == null ? (class$de$vw$mib$widgets$ui$InputFieldUI = InputField.class$("de.vw.mib.widgets.ui.InputFieldUI")) : class$de$vw$mib$widgets$ui$InputFieldUI};
    }

    @Override
    public Image get_cursorImage() {
        return this.cursorImage;
    }

    @Override
    public void set_cursorImage(Image image) {
        Image image2 = this.cursorImage;
        if (image2 == null || !image2.equals(image)) {
            this.cursorImage = image;
            this.cursorImageChanged(image2);
            this.propertyChanged(49);
        }
    }

    @Override
    public int get_cursorMode() {
        return this.cursorMode;
    }

    @Override
    public void set_cursorMode(int n) {
        int n2 = this.cursorMode;
        if (n2 != n) {
            this.cursorMode = n;
            this.cursorModeChanged(n2);
            this.propertyChanged(50);
        }
    }

    @Override
    public int get_cursorOffset() {
        return this.cursorOffset;
    }

    @Override
    public void set_cursorOffset(int n) {
        int n2 = this.cursorOffset;
        if (n2 != n) {
            this.cursorOffset = n;
            this.cursorOffsetChanged(n2);
            this.propertyChanged(51);
        }
    }

    @Override
    public Color get_colorHighlightForeground() {
        return this.colorHighlightForeground;
    }

    @Override
    public void set_colorHighlightForeground(Color color) {
        Color color2 = this.colorHighlightForeground;
        if (color2 == null || !color2.equals(color)) {
            this.colorHighlightForeground = color;
            this.colorHighlightForegroundChanged(color2);
            this.propertyChanged(43);
        }
    }

    @Override
    public Color get_colorHighlightBackground() {
        return this.colorHighlightBackground;
    }

    @Override
    public void set_colorHighlightBackground(Color color) {
        Color color2 = this.colorHighlightBackground;
        if (color2 == null || !color2.equals(color)) {
            this.colorHighlightBackground = color;
            this.colorHighlightBackgroundChanged(color2);
            this.propertyChanged(44);
        }
    }

    @Override
    public Color get_colorMatchForeground() {
        return this.colorMatchForeground;
    }

    @Override
    public Color getMatchColorForeground() {
        Color[] colorArray = this.get_colorsHighlightForeground();
        if (colorArray != null && colorArray.length > 1) {
            return colorArray[1];
        }
        return this.get_colorMatchForeground();
    }

    @Override
    public void set_colorMatchForeground(Color color) {
        Color color2 = this.colorMatchForeground;
        if (color2 == null || !color2.equals(color)) {
            this.colorMatchForeground = color;
            this.colorMatchForegroundChanged(color2);
            this.propertyChanged(45);
        }
    }

    @Override
    public AbstractSpellerModel get_spellerRef() {
        return this.spellerRef;
    }

    @Override
    public void set_spellerRef(AbstractSpellerModel abstractSpellerModel) {
        AbstractSpellerModel abstractSpellerModel2 = this.spellerRef;
        if (abstractSpellerModel2 != abstractSpellerModel) {
            this.spellerRef = abstractSpellerModel;
            this.spellerRefChanged(abstractSpellerModel2);
            this.propertyChanged(46);
        }
    }

    @Override
    public boolean is_hideTyping() {
        return this.getInternalStateFlag(14);
    }

    @Override
    public void set_hideTyping(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(14);
        if (bl2 != bl) {
            this.setInternalStateFlag(14, bl);
            this.hideTypingChanged(bl2);
            this.propertyChanged(47);
        }
    }

    @Override
    public String get_hideTypingChar() {
        return this.hideTypingChar;
    }

    @Override
    public void set_hideTypingChar(String string) {
        String string2 = this.hideTypingChar;
        if (string2 == null || !string2.equals(string)) {
            this.hideTypingChar = string;
            this.hideTypingCharChanged(string2);
            this.propertyChanged(48);
        }
    }

    @Override
    public int getViewPortPosition() {
        return this.viewPortPosition;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setCursorPosition(int n, int n2) {
        if (this.isVertical()) {
            n2 += this.viewPortPosition;
        } else {
            n = this.get_alignmentHorizontal() == 2 ? (n += this.getMaxLineWidth() - this.viewPortPosition - this.get_width()) : (n += this.viewPortPosition);
        }
        n2 -= this.get_baselineOffset();
        this.forceSpellerRefCursorChange = true;
        try {
            this.cursorManager.setCursorByLocation(n, n2);
        }
        finally {
            this.forceSpellerRefCursorChange = false;
        }
    }

    @Override
    public void addInputFieldChangedListener(InputFieldChangedListener inputFieldChangedListener) {
        this.inputFieldChangedListeners = this.inputFieldChangedListeners.addIfAbsent(inputFieldChangedListener);
    }

    @Override
    public void removeInputFieldChangedListener(InputFieldChangedListener inputFieldChangedListener) {
        this.inputFieldChangedListeners = this.inputFieldChangedListeners.remove(inputFieldChangedListener);
    }

    private void setViewPortPosition(int n) {
        this.viewPortPosition = n;
        this.repaint();
    }

    private int getMatchStyle() {
        int[] nArray = this.get_fontStyles();
        if (nArray != null && nArray.length > 1) {
            return nArray[1];
        }
        return this.get_font().getStyle();
    }

    private Color getColorHighlightForeground() {
        Color[] colorArray = this.get_colorsHighlightForeground();
        if (colorArray != null && colorArray.length > 0) {
            return colorArray[0];
        }
        return this.get_colorHighlightForeground();
    }

    private Color getColorHighlightBackground() {
        Color[] colorArray = this.get_colorsHighlightBackground();
        if (colorArray != null && colorArray.length >= 0) {
            return colorArray[0];
        }
        return this.get_colorHighlightBackground();
    }

    @Override
    protected void visibleChanged(boolean bl) {
        super.visibleChanged(bl);
        if (!bl && this.areParentsVisible()) {
            this.registerCursorManager();
            this.validate();
        } else if (bl && this.areParentsVisible()) {
            this.deregisterCursorManager();
        }
    }

    @Override
    protected void parentVisibilityChanged(boolean bl) {
        super.parentVisibilityChanged(bl);
        if (!bl && this.is_visible()) {
            this.registerCursorManager();
            this.validate();
        } else if (bl && this.is_visible()) {
            this.deregisterCursorManager();
        }
    }

    protected void cursorImageChanged(Image image) {
        ServiceManager.imageManager.preloadImageFromCurrentSkin(this.get_cursorImage());
        this.validate();
    }

    protected void cursorModeChanged(int n) {
        this.validate();
    }

    protected void cursorOffsetChanged(int n) {
        this.validate();
    }

    protected void colorHighlightForegroundChanged(Color color) {
        this.validate();
    }

    protected void colorHighlightBackgroundChanged(Color color) {
        this.validate();
    }

    protected void colorMatchForegroundChanged(Color color) {
        this.validate();
    }

    protected void spellerRefChanged(AbstractSpellerModel abstractSpellerModel) {
        if (abstractSpellerModel != null) {
            this.deregisterSpellerRefChangedListener(abstractSpellerModel);
            this.deregisterCursorManager(abstractSpellerModel);
        }
        this.registerSpellerRefChangedListener();
        this.registerCursorManager();
    }

    protected void hideTypingChanged(boolean bl) {
        this.validate();
    }

    protected void hideTypingCharChanged(String string) {
        this.validate();
    }

    @Override
    protected void fontChanged(FontAttribs fontAttribs) {
        super.fontChanged(fontAttribs);
        this.clearMatchTextStyles();
        this.clearTruncationTextLayout();
        this.clearMatchTextLayout();
        this.validate();
    }

    @Override
    protected void textLayoutChanged() {
        super.textLayoutChanged();
        if (!this.infoTextVisible) {
            String string = this.createInputFieldText(false);
            if (string != null) {
                int n = this.spellerRef != null ? this.spellerRef.getCursorPosition() : 0;
                this.cursorManager.setTextLayout(this.createTextLayout(InputField.replaceAllMarkups(string)), n);
            } else {
                this.cursorManager.setTextLayout(null, 0);
            }
        } else {
            this.cursorManager.setTextLayout(null, 0);
        }
        this.validate();
    }

    private void registerCursorManager() {
        if (this.is_visible() && this.areParentsVisible() && this.spellerRef != null && this.spellerRef.getCursorManager() != this.cursorManager) {
            this.spellerRef.setCursorManager(this.cursorManager);
        }
    }

    private void deregisterCursorManager() {
        this.deregisterCursorManager(this.spellerRef);
    }

    private void deregisterCursorManager(AbstractSpellerModel abstractSpellerModel) {
        if (abstractSpellerModel != null && abstractSpellerModel.getCursorManager() == this.cursorManager) {
            abstractSpellerModel.setCursorManager(null);
        }
    }

    private void registerSpellerRefChangedListener() {
        if (this.spellerRef != null) {
            this.spellerRef.addSpellerChangedListener(this);
        }
    }

    private void deregisterSpellerRefChangedListener() {
        this.deregisterSpellerRefChangedListener(this.spellerRef);
    }

    private void deregisterSpellerRefChangedListener(AbstractSpellerModel abstractSpellerModel) {
        if (abstractSpellerModel != null) {
            abstractSpellerModel.removeSpellerChangedListener(this);
        }
    }

    private void clearTruncationTextLayout() {
        if (this.truncationTextLayout != null) {
            this.truncationTextLayout.dispose();
            this.truncationTextLayout = null;
        }
    }

    private void clearMatchTextLayout() {
        if (this.matchTextLayout != null) {
            for (int i2 = 0; i2 < this.matchTextLayout.length; ++i2) {
                this.matchTextLayout[i2].dispose();
                this.matchTextLayout[i2] = null;
            }
            this.matchTextLayout = null;
        }
    }

    @Override
    public void spellerChanged(int n) {
        switch (n) {
            case 2: 
            case 4: 
            case 16: 
            case 32: 
            case 127: {
                this.validate();
                this.notifyInputFieldChangedListener(0);
                break;
            }
            case 1: {
                this.updateCursorPosition();
                this.validateViewport();
                this.notifyInputFieldChangedListener(2);
                break;
            }
            case 64: {
                this.clearTextHighlights();
                break;
            }
        }
        this.repaint();
    }

    @Override
    public void cursorChanged(int n, int n2, int n3, int n4, int n5, boolean bl) {
        if (n == -1 && this.get_alignmentHorizontal() == 2) {
            this.cursorArea.setBounds(Short.MAX_VALUE, n3, n4, n5);
        } else {
            this.cursorArea.setBounds(n2, n3, n4, n5);
        }
        if (!bl) {
            this.cursorChangesEnabled = false;
            int n6 = n == -129 ? this.spellerRef.getEnteredText().length() : n;
            ViewModel viewModel = this.getView();
            if (viewModel != null && viewModel.is_activated() && n >= 0 && this.spellerRef != null && (this.forceSpellerRefCursorChange || this.highlightVisible || this.spellerRef.getCursorPosition() != n6)) {
                this.spellerRef.setCursorPosition(n6);
            }
            this.alternateCursorVisible = this.cursorManager.getAlternateCursorPosition(this.alternateCursorArea);
            if (this.cursorMode == 1 && !this.highlightVisible) {
                this.clearTextHighlights();
            }
            this.cursorChangesEnabled = true;
        }
    }

    @Override
    public void validate() {
        if (this.is_visible() && this.areParentsVisible()) {
            this.updateText();
            boolean bl = false;
            if (this.spellerRef != null) {
                bl = this.spellerRef.getSelectionStart() != this.spellerRef.getSelectionEnd();
                this.set_inputTextIsHighlighted(bl);
            } else {
                bl = false;
                this.set_inputTextIsHighlighted(bl);
            }
            this.getTextLayout();
            this.clearTextHighlights();
            this.updateCursorPosition();
            this.validateViewport();
            this.repaint();
        }
    }

    private void updateText() {
        boolean bl = this.matchTextVisible;
        this.matchTextVisible = false;
        this.clearMatchTextLayout();
        if (this.spellerRef != null) {
            this.setInfoTextVisible(!InputField.isAvailable(this.spellerRef.getEnteredText()) && InputField.isAvailable(this.spellerRef.get_infoText()));
            this.matchTextVisible = InputField.isAvailable(this.spellerRef.getEnteredText()) && !this.isInfoTextVisible() && !this.is_hideTyping() && this.spellerRef.get_mode() == 0 && !InputField.isAvailable(this.spellerRef.getMatchCompletion()) && InputField.isAvailable(this.spellerRef.getMatchText());
            this.set_text(this.createInputFieldText(true));
            if (bl != this.matchTextVisible) {
                this.clearTextLayout();
            }
        }
    }

    private String createInputFieldText(boolean bl) {
        if (this.spellerRef != null) {
            if (this.isInfoTextVisible()) {
                return this.spellerRef.get_infoText();
            }
            String string = this.spellerRef.getEnteredText();
            if (!InputField.isAvailable(string)) {
                return "";
            }
            StringBuilder stringBuilder = new StringBuilder(string.length());
            if (this.is_hideTyping()) {
                for (int i2 = 0; i2 < string.length(); ++i2) {
                    stringBuilder.append(this.hideTypingChar);
                }
            } else {
                String string2;
                stringBuilder.append(string);
                if (!this.matchTextVisible && InputField.isAvailable(string2 = this.spellerRef.getMatchCompletion())) {
                    if (bl) {
                        stringBuilder.append("\u0086\u0012").append(string2).append("\u0087");
                    } else {
                        stringBuilder.append(string2);
                    }
                }
            }
            return stringBuilder.toString();
        }
        return null;
    }

    @Override
    protected int getMaxTextLayoutWidth() {
        int n = this.isVertical() || this.matchTextVisible ? super.getMaxTextLayoutWidth() : Short.MAX_VALUE;
        return n;
    }

    @Override
    protected int getMaxTextLayoutHeight() {
        return this.isVertical() ? 1000 : super.getMaxTextHeight();
    }

    private void updateCursorPosition() {
        this.cursorVisible = true;
        if (this.cursorChangesEnabled && this.is_visible() && this.areParentsVisible()) {
            String string;
            int n = -1;
            if (this.spellerRef != null && (string = this.spellerRef.getEnteredText()) != null) {
                n = this.spellerRef.getCursorPosition();
                n = Util.clamp(n, 0, string.length());
            }
            this.cursorManager.setCursorPositionBySourceIndex(n);
            this.alternateCursorVisible = this.cursorManager.getAlternateCursorPosition(this.alternateCursorArea);
        }
    }

    @Override
    protected List createTextHighlights(String string, TextLayout textLayout) {
        boolean bl = this.highlightVisible = this.spellerRef != null && this.spellerRef.getSelectionStart() != this.spellerRef.getSelectionEnd();
        if (this.highlightVisible) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(new AbstractTextModel$TextHighlight(this.spellerRef.getSelectionStart(), this.spellerRef.getSelectionEnd(), this.getColorHighlightForeground(), this.getColorHighlightBackground()));
            return arrayList;
        }
        if (this.cursorMode == 1 && this.spellerRef != null) {
            int n = this.spellerRef.getCursorPosition();
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(new AbstractTextModel$TextHighlight(n - 1, n, this.getColorHighlightForeground(), this.getColorHighlightBackground()));
            return arrayList;
        }
        return super.createTextHighlights(string, textLayout);
    }

    private void validateViewport() {
        int n = this.viewPortPosition;
        if (this.cursorArea != null) {
            if (this.isVertical()) {
                if (this.cursorArea.y < this.viewPortPosition) {
                    n = this.cursorArea.y;
                } else if (this.cursorArea.y + this.cursorArea.height > this.viewPortPosition + this.get_height()) {
                    n = this.cursorArea.y + this.cursorArea.height - this.get_height();
                }
            } else {
                int n2;
                int n3 = n2 = this.get_alignmentHorizontal() == 2 ? Short.MAX_VALUE - this.cursorArea.x : this.cursorArea.x;
                if (n2 < this.viewPortPosition + this.getTruncationTextlayout().getWidth()) {
                    n = Math.max(0, n2 - this.getTruncationTextlayout().getWidth());
                } else if (n2 + this.cursorArea.width >= this.viewPortPosition + this.get_width() - this.getTruncationTextlayout().getWidth()) {
                    n = n2 + this.cursorArea.width - this.get_width() + this.getTruncationTextlayout().getWidth();
                }
            }
        }
        if (this.viewPortPosition != (n = Util.clamp(n, this.getMinimum(), this.getMaximum()))) {
            this.setViewPortPosition(n);
        }
    }

    @Override
    public Rectangle getCursorArea() {
        return this.cursorArea;
    }

    @Override
    public void getAbsCursorArea(Rectangle rectangle) {
        if (this.get_alignmentHorizontal() == 2) {
            rectangle.setBounds(this.cursorArea.x - Short.MAX_VALUE + this.viewPortPosition + this.get_width(), this.cursorArea.y, this.cursorArea.width, this.cursorArea.height);
        } else {
            rectangle.setBounds(this.cursorArea.x - this.viewPortPosition, this.cursorArea.y, this.cursorArea.width, this.cursorArea.height);
        }
    }

    @Override
    public Rectangle getAlternateCursorArea() {
        return this.alternateCursorArea;
    }

    @Override
    public TextLayout getTruncationTextlayout() {
        if (this.truncationTextLayout == null) {
            this.truncationTextLayout = ServiceManager.textLayoutManager.performTextLayout(this.getMaxLineWidth(), this.get_height(), 1, false, ' ', false, ' ', this.getTextStyles(), "\u2026", this.getFont());
        }
        return this.truncationTextLayout;
    }

    private void clearMatchTextStyles() {
        if (this.matchTextStyle != null) {
            for (int i2 = 0; i2 < this.matchTextStyle.length; ++i2) {
                this.matchTextStyle[i2].dispose();
            }
            this.matchTextStyle = null;
        }
    }

    @Override
    public TextStyle[] getMatchTextStyle() {
        if (this.matchTextStyle == null) {
            FontAttribs fontAttribs = this.get_font();
            GlyphStyle glyphStyle = ServiceManager.textLayoutManager.createGlyphStyle(this.getFont().getFontId(), fontAttribs.getSize(), this.getMatchStyle());
            this.matchTextStyle = new TextStyle[1];
            this.matchTextStyle[0] = ServiceManager.textLayoutManager.createTextStyle(this.get_lineSpacing(), 0, 0, 0, -129, glyphStyle);
        }
        return this.matchTextStyle;
    }

    @Override
    public TextLayout[] getMatchTextLayouts() {
        if (this.matchTextLayout == null && this.matchTextVisible) {
            TextLayout[] textLayoutArray = new TextLayout[3];
            TextLayout textLayout = this.getTextLayout();
            int n = this.getMaxLineWidth() - textLayout.getWidth() - 50;
            textLayoutArray[0] = ServiceManager.textLayoutManager.performTextLayout(n, this.get_height(), 1, false, ' ', false, ' ', this.getMatchTextStyle(), "(", this.getFont());
            textLayoutArray[2] = ServiceManager.textLayoutManager.performTextLayout(n -= textLayoutArray[0].getWidth(), this.get_height(), 1, false, ' ', false, ' ', this.getMatchTextStyle(), ")", this.getFont());
            textLayoutArray[1] = ServiceManager.textLayoutManager.performTextLayout(n -= textLayoutArray[2].getWidth(), this.get_height(), 1, true, '\u2026', false, ' ', this.getMatchTextStyle(), this.spellerRef.getMatchText(), this.getFont());
            this.matchTextLayout = textLayoutArray;
        }
        return this.matchTextLayout;
    }

    private void setInfoTextVisible(boolean bl) {
        boolean bl2;
        boolean bl3 = bl2 = this.is_visible() && this.areParentsVisible();
        if (!bl2) {
            this.stopBlinkingTimer();
        } else {
            this.startBlinkingTimer();
        }
        this.infoTextVisible = bl;
    }

    @Override
    public boolean isInfoTextVisible() {
        return this.infoTextVisible;
    }

    public void setCursorVisible(boolean bl) {
        this.cursorVisible = bl;
    }

    @Override
    public boolean isCursorVisible() {
        return this.cursorVisible;
    }

    @Override
    public boolean isCursorRTL() {
        return this.cursorManager.isRTL();
    }

    @Override
    public boolean isAlternateCursorVisible() {
        return this.alternateCursorVisible;
    }

    @Override
    public boolean isMatchTextVisible() {
        return this.matchTextVisible;
    }

    @Override
    public boolean isVertical() {
        return this.get_lineBreakMode() != 0;
    }

    @Override
    public boolean isHighlightVisible() {
        return this.highlightVisible;
    }

    protected void notifyInputFieldChangedListener(int n) {
        for (CowList cowList = this.inputFieldChangedListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            InputFieldChangedListener inputFieldChangedListener = (InputFieldChangedListener)cowList.head();
            inputFieldChangedListener.inputFieldChanged(n);
        }
    }

    private static boolean isAvailable(String string) {
        return string != null && string.length() > 0;
    }

    @Override
    public void addAdjustmentListener(AdjustmentListener adjustmentListener) {
        this.adjustmentListeners = this.adjustmentListeners.addIfAbsent(adjustmentListener);
        adjustmentListener.adjustmentValueChanged(this, 0);
    }

    @Override
    public void removeAdjustmentListener(AdjustmentListener adjustmentListener) {
        this.adjustmentListeners = this.adjustmentListeners.addIfAbsent(adjustmentListener);
        adjustmentListener.adjustmentValueChanged(this, 0);
    }

    @Override
    public int getValue() {
        return this.viewPortPosition;
    }

    @Override
    public int getMinimum() {
        return 0;
    }

    @Override
    public int getMaximum() {
        int n = 0;
        TextLayout textLayout = this.getTextLayout();
        n = this.isVertical() ? textLayout.getHeight() - this.get_height() : textLayout.getWidth() - this.get_width() + this.cursorArea.width;
        return n < 0 ? 0 : n;
    }

    @Override
    public int getUnitIncrement() {
        return 1;
    }

    @Override
    public int getBlockIncrement() {
        return 1;
    }

    @Override
    public void disableAdjustmentChanged() {
        ++this.adjustmentShadowCounter;
    }

    @Override
    public void enableAdjustmentChanged() {
        --this.adjustmentShadowCounter;
    }

    @Override
    public boolean isAdjustmentEnabled() {
        return this.adjustmentShadowCounter == 0;
    }

    @Override
    public void setBlockIncrement(int n) {
    }

    @Override
    public void setMaximum(int n) {
    }

    @Override
    public void setMinimum(int n) {
    }

    @Override
    public void setUnitIncrement(int n) {
    }

    @Override
    public void setValue(int n) {
        int n2 = this.getMinimum();
        int n3 = this.getMaximum();
        int n4 = Util.clamp(n, n2, n3);
        this.setViewPortPosition(n4);
    }

    @Override
    public void adjustmentValueChanged(Adjustable adjustable, int n) {
        this.disableAdjustmentChanged();
        this.setValue(adjustable.getValue());
        this.enableAdjustmentChanged();
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
        CURSOR_BLINKING_ENABLED = System.getProperty("de.vw.mib.widgets.inputfield.disableblinking") == null;
    }
}

