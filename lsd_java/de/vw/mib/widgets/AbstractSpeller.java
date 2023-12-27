/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Graphics3D;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.Point;
import de.vw.mib.graphics.Rectangle;
import de.vw.mib.graphics.font.CursorManager;
import de.vw.mib.graphics.image.BufferImage;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.graphics.image.ScaleImage;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.util.StringUtil;
import de.vw.mib.widgets.AbstractBackgroundContainer;
import de.vw.mib.widgets.AbstractWidget;
import de.vw.mib.widgets.controller.SpellerController;
import de.vw.mib.widgets.controller.WidgetController;
import de.vw.mib.widgets.interfaces.FocusableUI;
import de.vw.mib.widgets.interfaces.WidgetCloneFactory;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.log.Logger;
import de.vw.mib.widgets.log.SpellerLogger;
import de.vw.mib.widgets.models.AbstractSpellerModel;
import de.vw.mib.widgets.models.InactiveAreaModel;
import de.vw.mib.widgets.models.SpellerButtonModel;
import de.vw.mib.widgets.models.StaticImageModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.speller.Alphabet;
import de.vw.mib.widgets.speller.LanguageModifier;
import de.vw.mib.widgets.speller.SecureUpperLower;
import de.vw.mib.widgets.speller.SpellerChangedListener;
import de.vw.mib.widgets.speller.SpellerElement;
import de.vw.mib.widgets.speller.SpellerElementStates;
import de.vw.mib.widgets.speller.SpellerManager;
import de.vw.mib.widgets.speller.data.SpellerDataAdapter;
import edu.emory.mathcs.backport.java.util.ArrayDeque;
import edu.emory.mathcs.backport.java.util.Arrays;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public abstract class AbstractSpeller
extends AbstractBackgroundContainer
implements AbstractSpellerModel {
    private static final int DEFAULT_LANGUAGE;
    private static final String EMPTY_TEXT;
    private int alphabetIndex;
    private String[] alphabetList;
    private int charEncoding;
    private int charMax;
    private int charMin;
    private Image[] imagesSeparator;
    private InactiveAreaModel inactiveAreaRef;
    private String infoText;
    private int languageIndex;
    private String[] languageList;
    private int lowerUpper;
    private int matchCount;
    private int mode;
    private int shiftMode;
    protected SpellerData spellerData;
    private Insets subspellerInsets;
    private int subspellerOffsetX;
    private int subspellerOffsetY;
    private Alphabet alphabet;
    private SpellerButtonModel[] clonedButtons;
    private WidgetCloneFactory cloneFactory;
    private boolean clonesDirty;
    private ArrayDeque cursorManagers;
    private int internalModes;
    private Alphabet oldAlphabet;
    private int shiftState;
    private CowList spellerChangedListeners;
    private int spellerChangedShadowCounter;
    private SpellerElementStates spellerElementStates;
    private Alphabet subAlphabet;
    private SpellerButtonModel[] subClonedButtons;
    private Point subspellerArrowPosition;
    private Rectangle subspellerBounds;
    private boolean suppressAlphabetErrors = true;
    private Set templateSpellerButtons;

    @Override
    protected void reset() {
        super.reset();
        this.spellerChangedListeners = CowList.EMPTY;
        this.alphabetIndex = 0;
        this.alphabetList = null;
        this.charEncoding = 0;
        this.charMax = 0;
        this.charMin = 0;
        this.imagesSeparator = null;
        this.inactiveAreaRef = null;
        this.infoText = null;
        this.languageIndex = -1;
        this.languageList = null;
        this.lowerUpper = 0;
        this.matchCount = 0;
        this.mode = 0;
        this.shiftMode = 0;
        this.spellerData = null;
        this.subspellerInsets = null;
        this.subspellerOffsetX = 0;
        this.subspellerOffsetY = 0;
        this.cloneFactory = null;
    }

    public void init(boolean bl, int n, int n2, String[] stringArray, Image image, boolean bl2, boolean bl3, int n3, int n4, int n5, int n6, int n7, Color[] colorArray, Image[] imageArray, int n8, EasingParams[] easingParamsArray, boolean bl4, int[] nArray, int[] nArray2, Image[] imageArray2, int n9, int n10, Image[] imageArray3, InactiveAreaModel inactiveAreaModel, String string, KeyframeAnimation[] keyframeAnimationArray, int n11, String[] stringArray2, boolean bl5, LayoutAttribs layoutAttribs, int n12, int n13, int n14, String string2, boolean bl6, int n15, Image image2, int n16, boolean bl7, int n17, boolean bl8, SpellerData spellerData, Insets insets, int n18, int n19, int n20, Insets insets2, boolean bl9, int n21, int n22, int n23) {
        super.init(bl, n, image, bl2, bl3, n6, n7, colorArray, imageArray, n8, easingParamsArray, bl4, nArray, nArray2, imageArray2, n9, n10, keyframeAnimationArray, bl5, layoutAttribs, string2, n15, image2, n16, bl7, n20, insets2, bl9, n21, n22, n23);
        this.alphabetIndex = n2;
        this.alphabetList = stringArray;
        this.charEncoding = n3;
        this.charMax = n4;
        this.charMin = n5;
        this.imagesSeparator = imageArray3;
        this.inactiveAreaRef = inactiveAreaModel;
        this.infoText = string;
        this.languageIndex = n11;
        this.languageList = stringArray2;
        this.lowerUpper = n12;
        this.matchCount = n13;
        this.mode = n14;
        this.shiftMode = n17;
        this.spellerData = spellerData;
        this.subspellerInsets = insets;
        this.subspellerOffsetX = n18;
        this.subspellerOffsetY = n19;
        this.setInternalStateFlag(18, bl6);
        this.setInternalStateFlag(19, bl8);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        this.spellerData = SpellerDataAdapter.getAdapter(this.spellerData);
        this.clonesDirty = true;
        this.suppressAlphabetErrors = true;
        this.templateSpellerButtons = new HashSet();
        for (int i2 = 0; i2 < this.getChildCount(); ++i2) {
            WidgetModel widgetModel = this.getChild(i2);
            if (!(widgetModel instanceof SpellerButtonModel)) continue;
            this.templateSpellerButtons.add(widgetModel);
        }
        this.setInternalMode(this.mode);
        this.setDefaultShiftState();
        this.updateAlphabet();
    }

    @Override
    public void deInit() {
        this.resetClonedButtons(this.clonedButtons, this.cloneFactory);
        this.clonedButtons = null;
        this.resetClonedButtons(this.subClonedButtons, this.cloneFactory);
        this.subClonedButtons = null;
        this.templateSpellerButtons = null;
        this.clonesDirty = false;
        this.spellerData = SpellerDataAdapter.removeAdapter(this.spellerData);
        this.alphabet = null;
        this.internalModes = 0;
        this.oldAlphabet = null;
        this.shiftState = 0;
        this.spellerChangedListeners = CowList.EMPTY;
        this.spellerChangedShadowCounter = 0;
        this.spellerElementStates = null;
        this.subAlphabet = null;
        this.subspellerArrowPosition = null;
        this.subspellerBounds = null;
        this.suppressAlphabetErrors = false;
        if (this.cursorManagers != null && !this.cursorManagers.isEmpty()) {
            this.cursorManagers.clear();
        }
        this.cursorManagers = null;
        super.deInit();
    }

    @Override
    public final int get_alphabetIndex() {
        return this.alphabetIndex;
    }

    @Override
    public final void set_alphabetIndex(int n) {
        int n2 = this.alphabetIndex;
        if (n2 != n) {
            this.alphabetIndex = n;
            this.alphabetIndexChanged(n2);
            this.propertyChanged(32);
        }
    }

    @Override
    public final String[] get_alphabetList() {
        return this.alphabetList;
    }

    @Override
    public final void set_alphabetList(String[] stringArray) {
        Object[] objectArray = this.alphabetList;
        if (!java.util.Arrays.equals(objectArray, stringArray)) {
            this.alphabetList = stringArray;
            this.alphabetListChanged((String[])objectArray);
            this.propertyChanged(33);
        }
    }

    @Override
    public final int get_charEncoding() {
        return this.charEncoding;
    }

    @Override
    public final void set_charEncoding(int n) {
        int n2 = this.charEncoding;
        if (n2 != n) {
            this.charEncoding = n;
            this.charEncodingChanged(n2);
            this.propertyChanged(34);
        }
    }

    @Override
    public final int get_charMax() {
        return this.charMax;
    }

    @Override
    public final void set_charMax(int n) {
        int n2 = this.charMax;
        if (n2 != n) {
            this.charMax = n;
            this.charMaxChanged(n2);
            this.propertyChanged(35);
        }
    }

    @Override
    public final int get_charMin() {
        return this.charMin;
    }

    @Override
    public final void set_charMin(int n) {
        int n2 = this.charMin;
        if (n2 != n) {
            this.charMin = n;
            this.charMinChanged(n2);
            this.propertyChanged(36);
        }
    }

    @Override
    public final Image[] get_imagesSeparator() {
        return this.imagesSeparator;
    }

    @Override
    public final void set_imagesSeparator(Image[] imageArray) {
        Object[] objectArray = this.imagesSeparator;
        if (!java.util.Arrays.equals(objectArray, imageArray)) {
            this.imagesSeparator = imageArray;
            this.imagesSeparatorChanged((Image[])objectArray);
            this.propertyChanged(37);
        }
    }

    @Override
    public final InactiveAreaModel get_inactiveAreaRef() {
        return this.inactiveAreaRef;
    }

    @Override
    public final void set_inactiveAreaRef(InactiveAreaModel inactiveAreaModel) {
        InactiveAreaModel inactiveAreaModel2 = this.inactiveAreaRef;
        if (inactiveAreaModel2 != inactiveAreaModel) {
            this.inactiveAreaRef = inactiveAreaModel;
            this.inactiveAreaRefChanged(inactiveAreaModel2);
            this.propertyChanged(38);
        }
    }

    @Override
    public final String get_infoText() {
        return this.infoText;
    }

    @Override
    public final void set_infoText(String string) {
        String string2 = this.infoText;
        if (string2 == null && string != null || string2 != null && !string2.equals(string)) {
            this.infoText = string;
            this.infoTextChanged(string2);
            this.propertyChanged(39);
        }
    }

    @Override
    public final int get_languageIndex() {
        return this.languageIndex;
    }

    @Override
    public final void set_languageIndex(int n) {
        int n2 = this.languageIndex;
        if (n2 != n) {
            this.languageIndex = n;
            this.languageIndexChanged(n2);
            this.propertyChanged(40);
        }
    }

    @Override
    public final String[] get_languageList() {
        return this.languageList;
    }

    @Override
    public final void set_languageList(String[] stringArray) {
        Object[] objectArray = this.languageList;
        if (!java.util.Arrays.equals(objectArray, stringArray = LanguageModifier.modifyLanguageList(stringArray))) {
            this.languageList = stringArray;
            this.languageListChanged((String[])objectArray);
            this.propertyChanged(41);
        }
    }

    @Override
    public final int get_lowerUpper() {
        return this.lowerUpper;
    }

    @Override
    public final void set_lowerUpper(int n) {
        int n2 = this.lowerUpper;
        if (n2 != n) {
            this.lowerUpper = n;
            this.lowerUpperChanged(n2);
            this.propertyChanged(42);
        }
    }

    @Override
    public final int get_matchCount() {
        return this.matchCount;
    }

    @Override
    public final void set_matchCount(int n) {
        int n2 = this.matchCount;
        if (n2 != n) {
            this.matchCount = n;
            this.matchCountChanged(n2);
            this.propertyChanged(43);
        }
    }

    @Override
    public final int get_mode() {
        return this.mode;
    }

    @Override
    public final void set_mode(int n) {
        int n2 = this.mode;
        if (n2 != n) {
            this.mode = n;
            this.modeChanged(n2);
            this.propertyChanged(44);
        }
    }

    @Override
    public final boolean is_okEnabled() {
        return this.getInternalStateFlag(18);
    }

    @Override
    public final void set_okEnabled(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(18);
        if (bl2 != bl) {
            this.setInternalStateFlag(18, bl);
            this.okEnabledChanged(bl2);
            this.propertyChanged(45);
        }
    }

    @Override
    public final boolean is_showSubspeller() {
        return this.getInternalStateFlag(19);
    }

    @Override
    public final void set_showSubspeller(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(19);
        if (bl2 != bl) {
            this.setInternalStateFlag(19, bl);
            this.showSubspellerChanged(bl2);
            this.propertyChanged(47);
        }
    }

    @Override
    public final SpellerData get_spellerData() {
        return this.spellerData;
    }

    @Override
    public final void set_spellerData(SpellerData spellerData) {
        if (this.isTraceEnabled()) {
            this.trace().append("set_spellerData: '").append(spellerData).append("'").log();
        }
        this.spellerData = SpellerDataAdapter.getAdapter(this.spellerData, spellerData);
        this.spellerDataChanged(this.spellerData);
        this.propertyChanged(48);
    }

    @Override
    public final Insets get_subspellerInsets() {
        return this.subspellerInsets;
    }

    @Override
    public final void set_subspellerInsets(Insets insets) {
        Insets insets2 = this.subspellerInsets;
        if (insets2 != insets) {
            this.subspellerInsets = insets;
            this.subspellerInsetsChanged(insets2);
            this.propertyChanged(51);
        }
    }

    @Override
    public final int get_subspellerOffsetX() {
        return this.subspellerOffsetX;
    }

    @Override
    public final void set_subspellerOffsetX(int n) {
        int n2 = this.subspellerOffsetX;
        if (n2 != n) {
            this.subspellerOffsetX = n;
            this.subspellerOffsetXChanged(n2);
            this.propertyChanged(52);
        }
    }

    @Override
    public final int get_subspellerOffsetY() {
        return this.subspellerOffsetY;
    }

    @Override
    public final void set_subspellerOffsetY(int n) {
        int n2 = this.subspellerOffsetY;
        if (n2 != n) {
            this.subspellerOffsetY = n;
            this.subspellerOffsetYChanged(n2);
            this.propertyChanged(53);
        }
    }

    protected void setInternalMode(int n) {
        this.internalModes = 0;
        block0 : switch (n) {
            case 0: {
                this.setInternalModeFlag(0, true);
                this.setInternalModeFlag(2, true);
                break;
            }
            case 1: {
                this.setInternalModeFlag(1, true);
                this.setInternalModeFlag(2, false);
                break;
            }
            default: {
                switch (n ^ 0x100) {
                    case 0: {
                        this.setInternalModeFlag(0, true);
                        this.setInternalModeFlag(2, true);
                        break block0;
                    }
                    case 1: {
                        this.setInternalModeFlag(1, true);
                        this.setInternalModeFlag(2, true);
                        break block0;
                    }
                }
            }
        }
    }

    protected final void setInternalModeFlag(int n, boolean bl) {
        this.internalModes = bl ? this.internalModes | 1 << n : this.internalModes & ~(1 << n);
    }

    protected final boolean getInternalModeFlag(int n) {
        return (this.internalModes & 1 << n) != 0;
    }

    @Override
    public boolean canConsumeHMIEvents() {
        return super.canConsumeHMIEvents() && this.is_visible() && this.areParentsVisible();
    }

    @Override
    public final Alphabet getAlphabet() {
        return this.alphabet;
    }

    protected final void setAlphabet(Alphabet alphabet) {
        Alphabet alphabet2 = this.alphabet;
        if (alphabet2 != alphabet) {
            this.alphabet = alphabet;
            this.alphabetChanged(alphabet2);
        }
    }

    @Override
    public final float getBackgroundAlpha() {
        return 1.0f;
    }

    @Override
    public final float getContentAlpha() {
        return 1.0f;
    }

    @Override
    public Alphabet getCurrentAlphabet() {
        return this.subAlphabet != null ? this.subAlphabet : this.alphabet;
    }

    @Override
    public String getCurrentAlphabetName() {
        if (this.alphabetList != null && this.alphabetIndex >= 0 && this.alphabetIndex < this.alphabetList.length) {
            return this.alphabetList[this.alphabetIndex];
        }
        return "";
    }

    @Override
    public String getCurrentLanguageName() {
        if (this.languageList != null && this.languageIndex >= 0 && this.languageIndex < this.languageList.length) {
            return this.languageList[this.languageIndex];
        }
        return ServiceManager.configurationManager.getCurrentGuiLanguage();
    }

    @Override
    public CursorManager getCursorManager() {
        return this.cursorManagers != null && !this.cursorManagers.isEmpty() ? (CursorManager)this.cursorManagers.peek() : null;
    }

    @Override
    public void setCursorManager(CursorManager cursorManager) {
        if (this.cursorManagers == null) {
            this.cursorManagers = new ArrayDeque();
        }
        if (cursorManager == null) {
            if (!this.cursorManagers.isEmpty()) {
                this.cursorManagers.pop();
            }
        } else {
            this.cursorManagers.push(cursorManager);
        }
    }

    @Override
    public SpellerElementStates getSpellerElementStates() {
        if (this.alphabet != null) {
            int n = this.alphabet.getElementCount(true);
            if (this.spellerElementStates == null || this.spellerElementStates.getSize() < n) {
                this.spellerElementStates = new SpellerElementStates(n);
            }
        } else if (this.spellerElementStates == null) {
            this.spellerElementStates = new SpellerElementStates(0);
        }
        return this.spellerElementStates;
    }

    @Override
    public final Alphabet getSubAlphabet() {
        return this.subAlphabet;
    }

    @Override
    public final void setSubAlphabet(Alphabet alphabet) {
        Alphabet alphabet2 = this.subAlphabet;
        if (alphabet2 != alphabet) {
            this.subAlphabet = alphabet;
            this.subAlphabetChanged(alphabet2);
        }
    }

    protected final boolean isSelectionAvailable() {
        return this.getSpellerElementStates().isAnySelectable();
    }

    @Override
    public boolean isSuppressAlphabetErrors() {
        return this.suppressAlphabetErrors;
    }

    public void setSuppressAlphabetErrors(boolean bl) {
        this.suppressAlphabetErrors = bl;
    }

    @Override
    public boolean isMode(int n) {
        int n2 = this.get_mode();
        switch (n) {
            case 0: {
                if (this.spellerData != null && "\u0007".equals(this.spellerData.getAvailableCharacters())) {
                    return false;
                }
                return this.getInternalModeFlag(0);
            }
            case 1: {
                if (this.spellerData != null && "\u0007".equals(this.spellerData.getAvailableCharacters())) {
                    return true;
                }
                return this.getInternalModeFlag(1);
            }
        }
        switch (n ^ 0x100) {
            case 0: {
                switch (n & 0x100) {
                    case 256: {
                        return this.getInternalModeFlag(2);
                    }
                }
                return this.getInternalModeFlag(0) && this.getInternalModeFlag(2);
            }
            case 1: {
                return this.getInternalModeFlag(1) && this.getInternalModeFlag(2);
            }
        }
        return n2 == n;
    }

    protected void setDefaultShiftState() {
        if (this.isMode(1) && this.get_shiftMode() == 1) {
            this.setShiftState(2);
        } else if (this.get_shiftMode() == 0) {
            this.setShiftState(this.get_lowerUpper());
        } else {
            this.setShiftState(1);
        }
    }

    @Override
    public WidgetCloneFactory getWidgetCloneFactory() {
        return this.cloneFactory;
    }

    @Override
    public void setWidgetCloneFactory(WidgetCloneFactory widgetCloneFactory) {
        this.cloneFactory = widgetCloneFactory;
    }

    @Override
    public final int get_shiftMode() {
        return this.shiftMode;
    }

    @Override
    public final void set_shiftMode(int n) {
        int n2 = this.shiftMode;
        if (n2 != n) {
            this.shiftMode = n;
            this.shiftModeChanged(n2);
            this.propertyChanged(46);
        }
    }

    @Override
    public int getShiftState() {
        return this.shiftState;
    }

    @Override
    public void setShiftState(int n) {
        this.shiftState = n;
    }

    private int getNextShiftState() {
        int n = (this.getShiftState() + 1) % 3;
        return Math.min(2, Math.max(0, n));
    }

    @Override
    public int setNextShiftState() {
        int n = this.getNextShiftState();
        this.setShiftState(n);
        return n;
    }

    protected void alphabetChanged(Alphabet alphabet) {
        this.getSpellerElementStates().resetAll();
        this.calculateAvailableCharacters();
        this.clonesDirty = true;
        this.repaint();
    }

    protected void alphabetIndexChanged(int n) {
        this.updateAlphabet();
        this.onAlphabetSwitched(n, this.oldAlphabet, this.get_alphabetIndex(), this.alphabet);
        this.oldAlphabet = null;
    }

    protected void alphabetListChanged(String[] stringArray) {
        this.adjustAlphabetIndexByAlphabetList(this.get_alphabetIndex(), this.get_alphabetList());
        this.updateAlphabet();
    }

    protected void charMinChanged(int n) {
    }

    protected void charMaxChanged(int n) {
    }

    protected void charEncodingChanged(int n) {
    }

    @Override
    protected void compositeBackgroundImagesChanged(Image[] imageArray) {
        if (this.subAlphabet != null && this.get_compositeBackgroundImages() != null && this.get_compositeBackgroundImages().length >= 5 && this.get_compositeBackgroundImages()[4] != null) {
            ServiceManager.imageManager.preloadImagesFromCurrentSkin(new Image[]{this.get_compositeBackgroundImages()[4]});
            this.calculateSubspellerArrowPosition();
        }
        super.compositeBackgroundImagesChanged(imageArray);
    }

    protected void displayTextChanged(String string) {
    }

    protected void imagesSeparatorChanged(Image[] imageArray) {
    }

    protected void inactiveAreaRefChanged(Object object) {
    }

    protected void infoTextChanged(String string) {
        this.notifySpellerChangedListener(4);
    }

    protected void languageIndexChanged(int n) {
        this.updateAlphabet();
    }

    protected void languageListChanged(String[] stringArray) {
        this.set_languageIndex(-1);
        this.updateAlphabet();
        this.calculateAvailableCharacters();
    }

    protected void lowerUpperChanged(int n) {
        this.updateAlphabet();
        this.updateClones(this.alphabet, false);
        this.repaint();
    }

    protected void matchCompletionChanged(int n) {
    }

    protected void matchCountChanged(int n) {
    }

    protected void matchTextChanged(String string) {
    }

    protected void modeChanged(int n) {
        this.setInternalMode(this.get_mode());
        this.calculateAvailableCharacters();
        this.notifySpellerChangedListener(32);
        this.repaint();
    }

    protected void okEnabledChanged(boolean bl) {
        this.calculateAvailableCharacters();
        this.repaint();
    }

    protected void spellerDataChanged(SpellerData spellerData) {
        if (this.spellerData != null) {
            this.set_matchCount(this.spellerData.getMatchCount());
        }
        this.notifySpellerChangedListener(127);
        this.calculateAvailableCharacters();
        this.repaint();
    }

    protected void shiftModeChanged(int n) {
    }

    protected void showSubspellerChanged(boolean bl) {
        WidgetController widgetController = this.getController();
        if (widgetController != null && this.is_showSubspeller() && this.alphabet != null) {
            for (int i2 = 0; i2 < this.alphabet.getElementCount(); ++i2) {
                Alphabet alphabet = this.alphabet.getElement(i2).getSubAlphabet();
                if (alphabet == null) continue;
                ((SpellerController)widgetController).openSubSpeller(alphabet);
                return;
            }
        } else if (widgetController != null && !this.is_showSubspeller()) {
            ((SpellerController)widgetController).closeSubSpeller();
        }
    }

    protected void subAlphabetChanged(Alphabet alphabet) {
        this.getSpellerElementStates().resetAll();
        this.calculateAvailableCharacters();
        this.calculateSubspellerBounds();
        this.calculateSubspellerArrowPosition();
        this.calculateBackground();
        if (this.subAlphabet != null) {
            this.clonesDirty = true;
            this.updateClones(this.subAlphabet, true);
        }
        this.repaint();
    }

    protected void subspellerInsetsChanged(Insets insets) {
        this.calculateBackground();
        this.repaint();
    }

    protected void subspellerOffsetXChanged(int n) {
        this.calculateBackground();
        this.repaint();
    }

    protected void subspellerOffsetYChanged(int n) {
        this.calculateBackground();
        this.repaint();
    }

    private void adjustAlphabetIndexByAlphabetList(int n, String[] stringArray) {
        if (stringArray != null && n >= stringArray.length) {
            if (this.isTraceEnabled()) {
                this.trace().append("New 'alphabetList' contains less alphabets then the current index will fetch! alphabetIndex=").append(n).append(" alphabetList=").append(Arrays.toString(stringArray)).log();
            }
            this.set_alphabetIndex(0);
        }
    }

    @Override
    protected void calculateArrowPosition() {
        if (this.subspellerArrowPosition != null) {
            this.getArrowPosition().setLocation(this.subspellerArrowPosition);
        }
    }

    protected final void calculateAvailableCharacters() {
        if (this.alphabet != null) {
            this.calculateAvailableCharacters(this.alphabet);
        }
        if (this.subAlphabet != null) {
            this.calculateAvailableCharacters(this.subAlphabet);
        }
    }

    protected final void calculateAvailableCharacters(Alphabet alphabet) {
        for (int i2 = alphabet.getElementCount() - 1; i2 >= 0; --i2) {
            SpellerElement spellerElement = alphabet.getElement(i2);
            this.calculateAvailableCharacter(spellerElement);
        }
    }

    protected void calculateAvailableCharacter(SpellerElement spellerElement) {
        Locale locale = new Locale(ServiceManager.configurationManager.getCurrentGuiLanguage());
        String string = spellerElement.getReturnFunction();
        String string2 = this.spellerData != null ? this.spellerData.getAvailableCharacters() : "";
        boolean bl = false;
        if (string.equalsIgnoreCase("FUNC_NONE")) {
            if (string2 != null && spellerElement.getGraphRep() != null) {
                bl = this.isMode(1) || SecureUpperLower.toSecureLowerCase(string2, locale).indexOf(spellerElement.getGraphRep()) > -1 || SecureUpperLower.toSecureUpperCase(string2, locale).indexOf(spellerElement.getGraphRep()) > -1;
                bl = this.calculateAvailableSubSpellerCharacters(spellerElement, bl, string2, true);
            } else {
                bl = this.isMode(1);
            }
        } else if (string.equalsIgnoreCase("FUNC_OK") || string.equalsIgnoreCase("FUNC_OK2") || string.equalsIgnoreCase("FUNC_OK3")) {
            int n = this.isMode(0) ? Math.max(1, this.charMin) : this.charMin;
            bl = this.is_okEnabled() && this.spellerData != null && this.isInCharBounds(this.spellerData.getEnteredText(), n, this.get_charMax());
        } else if (string.equalsIgnoreCase("FUNC_DEL")) {
            bl = this.spellerData != null && this.spellerData.getEnteredText() != null && this.spellerData.getEnteredText().length() > 0 && this.spellerData.getCursorPosition() > 0;
        } else if (string.equalsIgnoreCase("FUNC_ONLY_SUBSPELLER")) {
            if (spellerElement.getSubAlphabet() != null) {
                SpellerElement[] spellerElementArray = this.getEnabledSubSpellerElements(spellerElement, string2, true);
                bl = spellerElementArray.length > 0;
                this.getSpellerElementStates().setSubSpellerAvailable(spellerElement, bl);
            }
        } else if (string.equalsIgnoreCase("FUNC_LANG")) {
            bl = this.languageList != null && this.languageList.length > 0;
        } else if (string.equalsIgnoreCase("FUNC_CURSOR_LEFT")) {
            bl = this.getCursorManager() != null && this.getCursorManager().canMoveCursorLeft();
        } else if (string.equalsIgnoreCase("FUNC_CURSOR_RIGHT")) {
            int n = this.spellerData != null ? this.spellerData.getCursorPosition() : 0;
            int n2 = this.spellerData != null && this.spellerData.getEnteredText() != null ? this.spellerData.getEnteredText().length() : 0;
            int n3 = this.spellerData != null && this.spellerData.getMatchCompletion() != null ? this.spellerData.getMatchCompletion().length() : 0;
            int n4 = this.spellerData != null ? this.spellerData.getSelectionEnd() : -1;
            boolean bl2 = this.spellerData != null ? this.spellerData.isSelectionActive() : false;
            bl = this.getCursorManager() != null && this.getCursorManager().canMoveCursorRight() || bl2 && n == n4 || n == n2 && n3 > 0;
        } else {
            bl = true;
        }
        this.getSpellerElementStates().setEnabled(spellerElement, bl);
    }

    protected boolean calculateAvailableSubSpellerCharacters(SpellerElement spellerElement, boolean bl, String string, boolean bl2) {
        SpellerElement[] spellerElementArray = this.getEnabledSubSpellerElements(spellerElement, string, bl2);
        boolean bl3 = bl && spellerElementArray.length > 0 || !bl && spellerElementArray.length > 1;
        this.getSpellerElementStates().setSubSpellerAvailable(spellerElement, bl3);
        if (spellerElementArray.length == 0 || spellerElementArray.length != 0 && bl) {
            if (spellerElement.getSubSpellerElement() != null) {
                spellerElement.setSubSpellerElement(null);
                if (!this.clonesDirty) {
                    this.clonesDirty = true;
                }
            }
        } else {
            spellerElement.setSubSpellerElement(spellerElementArray[0]);
            if (!this.clonesDirty) {
                this.clonesDirty = true;
            }
            bl = true;
            this.getSpellerElementStates().setEnabled(spellerElementArray[0], true);
        }
        return bl;
    }

    @Override
    protected void calculateBackgroundArea() {
        if (this.subspellerBounds != null) {
            this.getBackgroundArea().setBounds(this.subspellerBounds);
        }
    }

    @Override
    public void calculateBoundingBox(int n, int n2, Point point, Point point2) {
        if (!this.is_visible()) {
            return;
        }
        int n3 = n + this.get_x();
        int n4 = n2 + this.get_y();
        point.x = Math.min(n3, point.x);
        point.y = Math.min(n4, point.y);
        point2.x = Math.max(n3 + this.get_width(), point2.x);
        point2.y = Math.max(n4 + this.get_height(), point2.y);
    }

    private void calculateSubspellerArrowPosition() {
        int n;
        ScaleImage scaleImage;
        if (this.subAlphabet == null) {
            if (this.subspellerArrowPosition != null) {
                this.subspellerArrowPosition.setLocation(0, 0);
            }
            return;
        }
        SpellerElement spellerElement = this.subAlphabet.getParent();
        if (spellerElement == null) {
            this.error(SpellerLogger.getLogger()).append("Parent speller element is 'null'! [alphabet=").append(this.subAlphabet).append("]").log();
            return;
        }
        if (this.get_compositeBackgroundImages() == null || this.get_compositeBackgroundImages().length != 5) {
            this.error(SpellerLogger.getLogger()).append("Composite background images were not properly initialized!").log();
            return;
        }
        ScaleImage scaleImage2 = scaleImage = this.get_compositeBackgroundImages()[4] != null ? this.get_compositeBackgroundImages()[4].getCurrentImage() : null;
        if (scaleImage != null) {
            BufferImage bufferImage;
            try {
                bufferImage = ServiceManager.imageManager.getImageFromCurrentSkin(scaleImage);
            }
            catch (IOException iOException) {
                this.error(SpellerLogger.getLogger()).append("Unable to calculate sub-speller's arrow position, because getting image from current skin failed!").append("[fileIdentifier='").append(scaleImage.getFileIdentifier()).append("', imageId=").append(scaleImage.getImageId()).append("]").log();
                return;
            }
            int n2 = spellerElement.getAbsX() + (spellerElement.getWidth() - bufferImage.getWidth()) / 2 + this.subspellerOffsetX;
            int n3 = this.subspellerBounds != null ? this.subspellerBounds.y : 0;
            n = this.get_compositeBackgroundMode();
            if (n3 < spellerElement.getAbsY()) {
                n3 += this.subspellerBounds != null ? this.subspellerBounds.height + this.subspellerOffsetY : 0;
                n = 3;
            } else {
                n = 2;
            }
            if (this.subspellerArrowPosition == null) {
                this.subspellerArrowPosition = new Point(n2, n3);
            } else {
                this.subspellerArrowPosition.setLocation(n2, n3);
            }
        } else {
            this.error(SpellerLogger.getLogger()).append("Composite background image is null! [index=").append(4).append("]").log();
            return;
        }
        this.setCompositeBackgroundImagesByMode(n);
    }

    private void calculateSubspellerBounds() {
        boolean bl;
        if (this.subAlphabet == null) {
            if (this.subspellerBounds != null) {
                this.subspellerBounds.setBounds(0, 0, 0, 0);
            }
            return;
        }
        if (this.subspellerBounds == null) {
            this.subspellerBounds = new Rectangle();
        }
        SpellerElement spellerElement = this.subAlphabet.getParent();
        Point point = this.subspellerBounds.getLocation();
        this.calculateSubspellerOrigin(point, spellerElement, this.subAlphabet.getSize().width, this.subAlphabet.getSize().height);
        this.subspellerBounds.setLocation(point);
        boolean bl2 = bl = spellerElement != null && spellerElement.getAbsY() > this.subspellerBounds.y;
        if (bl) {
            this.subAlphabet.setLocation(this.subspellerBounds.x + this.subspellerOffsetX, this.subspellerBounds.y + this.subspellerOffsetY);
        } else {
            this.subAlphabet.setLocation(this.subspellerBounds.x + this.subspellerOffsetX, this.subspellerBounds.y - this.subspellerOffsetY);
        }
        int n = this.subspellerBounds.x - this.subspellerInsets.left + this.subspellerOffsetX;
        int n2 = this.subAlphabet.getSize().width + this.subspellerInsets.left + this.subspellerInsets.right;
        int n3 = this.subAlphabet.getSize().height + this.subspellerInsets.top + this.subspellerInsets.bottom;
        int n4 = this.subspellerBounds.y;
        n4 = bl ? n4 + this.subspellerOffsetY - this.subspellerInsets.top : n4 - this.subspellerOffsetY - this.subspellerInsets.bottom;
        this.subspellerBounds.setBounds(n, n4, n2, n3);
    }

    private void calculateSubspellerOrigin(Point point, SpellerElement spellerElement, int n, int n2) {
        SpellerElement spellerElement2 = spellerElement;
        int n3 = spellerElement.getX();
        int n4 = spellerElement.getY() - n2;
        if (n4 < 0) {
            n4 = spellerElement.getY() + spellerElement.getHeight();
        }
        if ("FUNC_ONLY_SUBSPELLER".equals(spellerElement.getReturnFunction())) {
            SpellerButtonModel spellerButtonModel = this.getButton(spellerElement);
            StaticImageModel staticImageModel = spellerButtonModel.get_imageSubspellerIndicatorRef() != null ? spellerButtonModel.get_imageSubspellerIndicatorRef() : spellerButtonModel.get_imageStateRef();
            n3 = staticImageModel != null ? Math.max(0, spellerElement.getX() + staticImageModel.get_x() + (int)((double)(staticImageModel.get_width() - n) * 0.5)) : Math.max(0, spellerElement.getX() + (int)((double)(spellerElement.getWidth() - n) * 0.5));
            point.setLocation(n3, n4);
            return;
        }
        while (this.get_width() - (n3 + n) <= 0 && (spellerElement = spellerElement.getLeftSpellerElement()) != null) {
            if (spellerElement.getY() == spellerElement2.getY()) {
                n3 = spellerElement.getX();
                continue;
            }
            n3 = Math.max(0, (int)((double)(this.get_width() - this.get_x() - n) * 0.5));
            break;
        }
        point.setLocation(n3, n4);
    }

    private boolean checkBounds(String string, int n, int n2, boolean bl) {
        if (string != null) {
            switch (this.get_charEncoding()) {
                case 1: {
                    if (bl && string.length() < n) break;
                    int n3 = StringUtil.getUtf8ByteLength(string);
                    return n3 <= n2;
                }
                case 2: {
                    int n4 = StringUtil.getUtf8ByteLength(string);
                    if (bl && n4 < n) break;
                    return n4 <= n2;
                }
                default: {
                    if (bl && string.length() < n) break;
                    return string.length() <= n2;
                }
            }
        }
        return false;
    }

    @Override
    public SpellerButtonModel getButton(SpellerElement spellerElement) {
        return this.getButton(spellerElement.getAlphabet(), spellerElement, this.subAlphabet != null, spellerElement.getAlphabet() == this.subAlphabet);
    }

    private int findSpellerElementByReturnFunction(String string, Alphabet alphabet) {
        int n = -1;
        if (alphabet != null) {
            for (int i2 = 0; i2 < alphabet.getElementCount(); ++i2) {
                SpellerElement spellerElement = alphabet.getElement(i2);
                if (!string.equals(spellerElement.getReturnFunction())) continue;
                n = i2;
                break;
            }
        }
        return n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public SpellerButtonModel getButton(Alphabet alphabet, SpellerElement spellerElement, boolean bl, boolean bl2) {
        int n = spellerElement.getIndex();
        SpellerButtonModel spellerButtonModel = null;
        if (this.cloneFactory != null) {
            if (this.clonesDirty) {
                this.updateClones(alphabet, bl2);
            }
            if (bl2) {
                if (this.subClonedButtons != null && n < this.subClonedButtons.length) {
                    spellerButtonModel = this.subClonedButtons[n];
                }
            } else if (this.clonedButtons != null && n < this.clonedButtons.length) {
                spellerButtonModel = this.clonedButtons[n];
            }
        } else {
            SpellerButtonModel spellerButtonModel2 = spellerButtonModel = spellerElement.hasSubSpellerElement() ? this.getTemplateForElement(spellerElement.getSubSpellerElement()) : this.getTemplateForElement(spellerElement);
            if (spellerButtonModel != null) {
                spellerButtonModel.setSpellerElement(spellerElement);
            }
        }
        if (spellerButtonModel == null) {
            return spellerButtonModel;
        }
        SpellerElementStates spellerElementStates = this.getSpellerElementStates();
        boolean bl3 = spellerElementStates.isPressed(spellerElement);
        boolean bl4 = spellerElementStates.isSelected(spellerElement);
        boolean bl5 = spellerElement.hasSubSpellerElement() ? spellerElementStates.isEnabled(spellerElement.getSubSpellerElement()) : spellerElementStates.isEnabled(spellerElement);
        boolean bl6 = spellerElementStates.isSubSpellerAvailable(spellerElement);
        this.disableAnimations();
        try {
            spellerButtonModel.disablePropertyChanged();
            try {
                spellerButtonModel.set_enabled(bl5);
                spellerButtonModel.set_selected(bl4);
                spellerButtonModel.setPressed(bl3);
                spellerButtonModel.setSubspellerEnabled(bl6);
                if (this.get_shiftMode() == 1 && "FUNC_SHIFT".equals(spellerElement.getReturnFunction())) {
                    spellerButtonModel.set_stateOffset(this.getShiftState());
                }
            }
            finally {
                spellerButtonModel.enablePropertyChanged();
            }
        }
        finally {
            this.enableAnimations();
        }
        return spellerButtonModel;
    }

    private SpellerElement[] getEnabledSubSpellerElements(SpellerElement spellerElement, String string, boolean bl) {
        Alphabet alphabet = spellerElement.getSubAlphabet();
        if (alphabet == null) {
            return new SpellerElement[0];
        }
        ArrayList arrayList = new ArrayList(alphabet.getElementCount());
        for (int i2 = 0; i2 < alphabet.getElementCount(); ++i2) {
            SpellerElement spellerElement2 = alphabet.getElement(i2);
            boolean bl2 = this.isSubSpellerElementEnabled(spellerElement2, string, bl);
            if (!bl2) continue;
            arrayList.add(spellerElement2);
        }
        return (SpellerElement[])arrayList.toArray(new SpellerElement[arrayList.size()]);
    }

    @Override
    public SpellerButtonModel getTemplateForElement(SpellerElement spellerElement) {
        WidgetModel[] widgetModelArray = this.getChildren();
        for (int i2 = widgetModelArray.length - 1; i2 >= 0; --i2) {
            SpellerButtonModel spellerButtonModel;
            String string;
            if (!(widgetModelArray[i2] instanceof SpellerButtonModel) || null == (string = (spellerButtonModel = (SpellerButtonModel)widgetModelArray[i2]).get_templateName()) || !string.equals(spellerElement.getTemplateId())) continue;
            return spellerButtonModel;
        }
        return null;
    }

    @Override
    public boolean isCharMaxReached() {
        if (this.spellerData != null && this.spellerData.getEnteredText() != null) {
            return !this.isInCharBounds(this.spellerData.getEnteredText(), this.get_charMax() - 1);
        }
        return false;
    }

    @Override
    public boolean isCharMinReached() {
        if (this.spellerData != null && this.spellerData.getEnteredText() != null) {
            return this.spellerData.getEnteredText().length() >= this.get_charMin();
        }
        return false;
    }

    @Override
    public final boolean isInCharBounds(String string, int n) {
        return this.checkBounds(string, 128, n, false);
    }

    @Override
    public final boolean isInCharBounds(String string, int n, int n2) {
        return this.checkBounds(string, n, n2, true);
    }

    @Override
    public boolean isSelectionDefined() {
        return SpellerDataAdapter.hasAnySelection(this.spellerData);
    }

    private boolean isSpellerChanging() {
        return this.spellerChangedShadowCounter != 0;
    }

    protected boolean isSubSpellerElementEnabled(SpellerElement spellerElement, String string, boolean bl) {
        Locale locale = new Locale(ServiceManager.configurationManager.getCurrentGuiLanguage());
        return this.isMode(1) || SecureUpperLower.toSecureLowerCase(string, locale).indexOf(spellerElement.getGraphRep()) > -1 || SecureUpperLower.toSecureUpperCase(string, locale).indexOf(spellerElement.getGraphRep()) > -1;
    }

    @Override
    public final boolean isSpellerLanguage(String string) {
        if (string == null) {
            return false;
        }
        return string.equals(this.getCurrentLanguageName());
    }

    protected final void onAlphabetSwitched(int n, Alphabet alphabet, int n2, Alphabet alphabet2) {
        if (SpellerLogger.getLogger().isTraceEnabled()) {
            this.trace(SpellerLogger.getLogger()).append("onAlphabetSwitched: oldAlphabetIndex=").append(n).append(" oldAlphabet=").append(alphabet).log();
            this.trace(SpellerLogger.getLogger()).append("onAlphabetSwitched: newAlphabetIndex=").append(n2).append(" newAlphabet=").append(alphabet2).log();
        }
    }

    private void onSpellerChange() {
        ++this.spellerChangedShadowCounter;
    }

    private void onSpellerChanged() {
        --this.spellerChangedShadowCounter;
    }

    @Override
    public void paintFocused(Graphics3D graphics3D, ViewModel viewModel, Rectangle rectangle, Rectangle rectangle2, float f2) {
        FocusableUI focusableUI = (FocusableUI)this.getUI();
        if (focusableUI != null) {
            focusableUI.paintFocused(graphics3D, viewModel, this, rectangle, rectangle2, f2);
        }
    }

    protected void resetClonedButtons(SpellerButtonModel[] spellerButtonModelArray, WidgetCloneFactory widgetCloneFactory) {
        if (spellerButtonModelArray != null) {
            for (int i2 = spellerButtonModelArray.length - 1; i2 >= 0; --i2) {
                if (spellerButtonModelArray[i2] == null) continue;
                spellerButtonModelArray[i2].stopInternalAnimations();
                spellerButtonModelArray[i2].deActivate();
                spellerButtonModelArray[i2].deInit();
                if (!this.templateSpellerButtons.contains(spellerButtonModelArray[i2]) && spellerButtonModelArray[i2].getCloneData() != null) {
                    widgetCloneFactory.destroyWidgetCloneable(spellerButtonModelArray[i2]);
                }
                spellerButtonModelArray[i2] = null;
            }
        }
    }

    public void resetClones(boolean bl) {
        if (this.cloneFactory != null && this.clonesDirty) {
            if (this.clonedButtons != null && !bl) {
                this.resetClonedButtons(this.clonedButtons, this.cloneFactory);
                this.clonedButtons = null;
            }
            if (this.subClonedButtons != null && bl) {
                this.resetClonedButtons(this.subClonedButtons, this.cloneFactory);
                this.subClonedButtons = null;
            }
        }
    }

    @Override
    public void switchAlphabet(int n) {
        if (this.alphabetList != null && n < this.alphabetList.length) {
            this.oldAlphabet = this.getCurrentAlphabet();
            this.set_alphabetIndex(n);
        } else {
            this.warn().append("Unable to switch alphabet! alphabetIndex=").append(n).append(" alphabetList=").append(this.alphabetList).log();
        }
    }

    protected void updateAlphabet() {
        this.setAlphabet(SpellerManager.getAlphabet(this));
    }

    @Override
    public void updateClones(Alphabet alphabet, boolean bl) {
        if (this.cloneFactory == null || alphabet == null) {
            return;
        }
        this.resetClones(bl);
        int n = alphabet.getElementCount();
        SpellerButtonModel[] spellerButtonModelArray = new SpellerButtonModel[n];
        HashSet hashSet = new HashSet();
        for (int i2 = n - 1; i2 >= 0; --i2) {
            SpellerElement spellerElement = alphabet.getElement(i2);
            SpellerButtonModel spellerButtonModel = this.getTemplateForElement(spellerElement);
            boolean bl2 = false;
            if (spellerButtonModel == null) continue;
            String string = spellerButtonModel.get_templateName();
            SpellerButtonModel spellerButtonModel2 = null;
            if (!bl && !hashSet.contains(string)) {
                spellerButtonModel2 = spellerButtonModel;
                hashSet.add(string);
                bl2 = true;
            } else {
                spellerButtonModel2 = (SpellerButtonModel)this.cloneFactory.createWidgetCloneable(spellerButtonModel);
            }
            if (spellerButtonModel2 == null) continue;
            if (!bl2 && spellerButtonModel2 instanceof AbstractWidget) {
                ((AbstractWidget)((Object)spellerButtonModel2)).setParent(this);
            }
            spellerButtonModel2.init(spellerButtonModel.getView());
            spellerButtonModel2.setSpellerElement(spellerElement);
            spellerButtonModelArray[i2] = spellerButtonModel2;
        }
        if (bl) {
            this.subClonedButtons = spellerButtonModelArray;
        } else {
            this.clonedButtons = spellerButtonModelArray;
        }
        this.clonesDirty = false;
    }

    @Override
    public boolean willCharMaxExceed(String string) {
        String string2;
        if (this.spellerData != null && (string2 = this.spellerData.getEnteredText()) != null) {
            return this.willCharMaxExceed(string2, string);
        }
        return false;
    }

    @Override
    public boolean willCharMaxExceed(String string, String string2) {
        String string3 = string.concat(string2);
        return !this.isInCharBounds(string3, this.get_charMax());
    }

    @Override
    public LogMessage error(Logger logger) {
        return logger.error(this);
    }

    @Override
    public LogMessage normal(Logger logger) {
        return logger.normal(this);
    }

    @Override
    public LogMessage trace(Logger logger) {
        return logger.trace(this);
    }

    @Override
    public LogMessage warn(Logger logger) {
        return logger.warn(this);
    }

    protected final boolean isTraceEnabled() {
        return SpellerLogger.getLogger().isTraceEnabled();
    }

    protected LogMessage error() {
        return this.error(SpellerLogger.getLogger());
    }

    protected LogMessage trace() {
        return this.trace(SpellerLogger.getLogger());
    }

    protected LogMessage warn() {
        return this.warn(SpellerLogger.getLogger());
    }

    @Override
    public void addSpellerChangedListener(SpellerChangedListener spellerChangedListener) {
        this.spellerChangedListeners = this.spellerChangedListeners.addIfAbsent(spellerChangedListener);
    }

    @Override
    public void removeSpellerChangedListener(SpellerChangedListener spellerChangedListener) {
        this.spellerChangedListeners = this.spellerChangedListeners.remove(spellerChangedListener);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void notifySpellerChangedListener(int n) {
        for (CowList cowList = this.spellerChangedListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            SpellerChangedListener spellerChangedListener = (SpellerChangedListener)cowList.head();
            this.onSpellerChange();
            try {
                spellerChangedListener.spellerChanged(n);
                continue;
            }
            finally {
                this.onSpellerChanged();
            }
        }
    }

    @Override
    public int getCursorPosition() {
        return this.spellerData != null ? this.spellerData.getCursorPosition() : 0;
    }

    @Override
    public void setCursorPosition(int n) {
        WidgetController widgetController = this.getController();
        if (widgetController != null) {
            boolean bl;
            SpellerController spellerController = (SpellerController)widgetController;
            boolean bl2 = this.getCursorPosition() != n;
            boolean bl3 = bl = this.spellerData != null ? this.spellerData.isSelectionActive() : false;
            if (bl2 || bl) {
                spellerController.fire_cursorPositionChanged(n);
            }
            if (!this.isSpellerChanging()) {
                int n2;
                boolean bl4;
                boolean bl5;
                boolean bl6 = bl5 = this.subAlphabet == null;
                boolean bl7 = !bl5 && !"FUNC_ONLY_SUBSPELLER".equals(this.subAlphabet.getParent() != null ? this.subAlphabet.getParent().getReturnFunction() : "") ? true : (bl4 = false);
                if ((bl5 || bl4) && (n2 = this.findSpellerElementByReturnFunction("FUNC_ONLY_SUBSPELLER", this.alphabet)) >= 0 && n2 < this.alphabet.getElementCount()) {
                    Alphabet alphabet;
                    SpellerElement spellerElement = this.alphabet.getElement(n2);
                    Alphabet alphabet2 = alphabet = spellerElement != null ? spellerElement.getSubAlphabet() : null;
                    if (alphabet != null) {
                        spellerController.openSubSpeller(alphabet);
                    }
                }
            }
        }
    }

    @Override
    public String getEnteredText() {
        return this.spellerData != null ? this.spellerData.getEnteredText() : "";
    }

    @Override
    public String getMatchCompletion() {
        return this.spellerData != null ? this.spellerData.getMatchCompletion() : "";
    }

    @Override
    public String getMatchText() {
        return this.spellerData != null ? this.spellerData.getMatchText() : "";
    }

    @Override
    public int getSelectionEnd() {
        return this.spellerData != null ? this.spellerData.getSelectionEnd() : 0;
    }

    @Override
    public int getSelectionStart() {
        return this.spellerData != null ? this.spellerData.getSelectionStart() : 0;
    }

    @Override
    public void activeContentChanged(int n) {
    }
}

