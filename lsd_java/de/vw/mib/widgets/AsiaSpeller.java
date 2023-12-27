/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets;

import de.vw.mib.animation.animations.KeyframeAnimation;
import de.vw.mib.animation.easing.EasingParams;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.graphics.Color;
import de.vw.mib.graphics.Insets;
import de.vw.mib.graphics.image.Image;
import de.vw.mib.list.EmptyListItemControl;
import de.vw.mib.list.ListItemControl;
import de.vw.mib.properties.values.LayoutAttribs;
import de.vw.mib.properties.values.SpellerData;
import de.vw.mib.util.StringBuilder;
import de.vw.mib.widgets.AbstractSpeller;
import de.vw.mib.widgets.AsiaSpeller$AsiaListItemControl;
import de.vw.mib.widgets.AsiaSpeller$AsiaOutEventListener;
import de.vw.mib.widgets.AsiaSpeller$CandidateSelectedHandler;
import de.vw.mib.widgets.AsiaSpeller$ListItemTransferDelegate;
import de.vw.mib.widgets.AsiaSpeller$ListRefsWidgetCloneFactory;
import de.vw.mib.widgets.AsiaSpeller$PredictionListItemControl;
import de.vw.mib.widgets.AsiaSpeller$PredictionSelectedHandler;
import de.vw.mib.widgets.AsiaSpeller$PreviewLineListItemControl;
import de.vw.mib.widgets.Button;
import de.vw.mib.widgets.controller.AsiaSpellerController;
import de.vw.mib.widgets.controller.WidgetController;
import de.vw.mib.widgets.event.OutEventListener;
import de.vw.mib.widgets.interfaces.WidgetCloneFactory;
import de.vw.mib.widgets.list.ListItemTransfer;
import de.vw.mib.widgets.models.AbstractButtonModel;
import de.vw.mib.widgets.models.AsiaSpellerModel;
import de.vw.mib.widgets.models.ContainerModel;
import de.vw.mib.widgets.models.InactiveAreaModel;
import de.vw.mib.widgets.models.ListItemModel;
import de.vw.mib.widgets.models.TemplateListModel;
import de.vw.mib.widgets.models.TextAreaModel;
import de.vw.mib.widgets.models.TouchAreaModel;
import de.vw.mib.widgets.models.ViewModel;
import de.vw.mib.widgets.models.WidgetModel;
import de.vw.mib.widgets.speller.SpellerElement;
import de.vw.mib.widgets.speller.SpellerElementStates;
import de.vw.mib.widgets.speller.asia.AsiaInputInitializer;
import de.vw.mib.widgets.speller.asia.DefaultAsiaSpellerStrategy;
import de.vw.mib.widgets.speller.asia.china.ChinaSpellerStrategy;
import de.vw.mib.widgets.speller.asia.japan.HiraganaFreeTextConverter;
import de.vw.mib.widgets.speller.asia.japan.JapanSpellerStrategy;
import de.vw.mib.widgets.speller.asia.korea.KoreaSpellerStrategy;
import java.util.Arrays;

public class AsiaSpeller
extends AbstractSpeller
implements AsiaSpellerModel,
ListItemTransfer {
    private static final int LIST_ITEM_DATA_HISTORY;
    private static final int LIST_ITEM_DATA_PREVIEW;
    private static final int LIST_ITEM_DATA_RESULT;
    private static final int LIST_ITEM_DATA_PREDICTION;
    private static final int LIST_ITEM_DATA_NVC;
    private static final int LIST_ITEM_DATA_RECCHARS;
    private int[] alphabetMapping;
    private int filterId;
    private TouchAreaModel hwrAreaRef;
    private ContainerModel[] hwrHiddenContentRefs;
    private WidgetModel[] hwrInfoTextRefs;
    private int hwrMode;
    private ContainerModel[] hwrVisibleContentRefs;
    private int inputType;
    private int[] listItemLimitations;
    private boolean[] listItemNotifications;
    private int[] listItemRefContents;
    private ListItemModel[] listItemRefs;
    private TemplateListModel[] listRefs;
    private DefaultAsiaSpellerStrategy asiaSpellerStrategy;
    private AsiaSpeller$ListItemTransferDelegate listItemTransferDelegate;
    private IntObjectOptHashMap listItemListControlMap;
    private AsiaSpeller$AsiaOutEventListener[] listItemRefSelectedHandlers;
    private String spelling;
    private int spellingPosition;
    private String[] wordDatabaseNames;
    static /* synthetic */ Class class$de$vw$mib$widgets$ui$AsiaSpellerUI;

    @Override
    protected void reset() {
        super.reset();
        this.alphabetMapping = null;
        this.filterId = 0;
        this.hwrAreaRef = null;
        this.hwrHiddenContentRefs = null;
        this.hwrInfoTextRefs = null;
        this.hwrMode = 0;
        this.hwrVisibleContentRefs = null;
        this.inputType = 0;
        this.initSpellerStrategyByInputType(this.inputType);
        this.listItemLimitations = null;
        this.listItemNotifications = null;
        this.listItemRefContents = null;
        this.listItemRefs = null;
        this.listRefs = null;
        this.setInternalStateFlag(20, false);
        this.setInternalStateFlag(21, false);
        this.setInternalStateFlag(23, false);
        this.setInternalStateFlag(24, false);
        this.setInternalStateFlag(25, false);
        this.setInternalStateFlag(26, false);
        this.setInternalStateFlag(27, false);
    }

    public void init(boolean bl, int n, int n2, String[] stringArray, int[] nArray, Image image, boolean bl2, boolean bl3, boolean bl4, int n3, int n4, int n5, int n6, int n7, Color[] colorArray, Image[] imageArray, int n8, EasingParams[] easingParamsArray, boolean bl5, int n9, boolean bl6, int[] nArray2, int[] nArray3, Image[] imageArray2, int n10, int n11, TouchAreaModel touchAreaModel, boolean bl7, ContainerModel[] containerModelArray, WidgetModel[] widgetModelArray, int n12, ContainerModel[] containerModelArray2, Image[] imageArray3, InactiveAreaModel inactiveAreaModel, String string, int n13, KeyframeAnimation[] keyframeAnimationArray, int n14, String[] stringArray2, boolean bl8, LayoutAttribs layoutAttribs, int[] nArray4, boolean[] blArray, int[] nArray5, ListItemModel[] listItemModelArray, TemplateListModel[] templateListModelArray, int n15, int n16, int n17, String string2, boolean bl9, boolean bl10, int n18, Image image2, int n19, boolean bl11, int n20, boolean bl12, SpellerData spellerData, Insets insets, int n21, int n22, boolean bl13, int n23, Insets insets2, boolean bl14, boolean bl15, int n24, boolean bl16, int n25, int n26) {
        super.init(bl, n, n2, stringArray, image, bl2, bl4, n3, n4, n5, n6, n7, colorArray, imageArray, n8, easingParamsArray, bl5, nArray2, nArray3, imageArray2, n10, n11, imageArray3, inactiveAreaModel, string, keyframeAnimationArray, n14, stringArray2, bl8, layoutAttribs, n15, n16, n17, string2, bl10, n18, image2, n19, bl11, n20, bl12, spellerData, insets, n21, n22, n23, insets2, bl15, n24, n25, n26);
        this.alphabetMapping = nArray;
        this.filterId = n9;
        this.hwrAreaRef = touchAreaModel;
        this.hwrHiddenContentRefs = containerModelArray;
        this.hwrInfoTextRefs = widgetModelArray;
        this.hwrMode = n12;
        this.hwrVisibleContentRefs = containerModelArray2;
        this.inputType = n13;
        this.initSpellerStrategyByInputType(this.inputType);
        this.listItemLimitations = nArray4;
        this.listItemNotifications = blArray;
        this.listItemRefContents = nArray5;
        this.listItemRefs = listItemModelArray;
        this.listRefs = templateListModelArray;
        this.setInternalStateFlag(20, bl3);
        this.setInternalStateFlag(21, bl7);
        this.setInternalStateFlag(23, bl6);
        this.setInternalStateFlag(24, bl9);
        this.setInternalStateFlag(25, bl13);
        this.setInternalStateFlag(26, bl14);
        this.setInternalStateFlag(27, bl16);
    }

    @Override
    public void init(ViewModel viewModel) {
        super.init(viewModel);
        if (this.listRefs != null) {
            this.initListRefs(this.listRefs);
        }
        if (this.listItemRefs != null) {
            this.initListItemRefs(this.listItemRefs);
        }
        this.controlContentVisibility();
    }

    @Override
    public void deInit() {
        if (this.listRefs != null) {
            this.deInitListRefs(this.listRefs);
        }
        if (this.listItemRefs != null) {
            this.deInitListItemRefs(this.listItemRefs);
        }
        this.spelling = null;
        this.spellingPosition = 0;
        this.setInternalStateFlag(22, false);
        this.wordDatabaseNames = null;
        super.deInit();
    }

    @Override
    public final int[] get_alphabetMapping() {
        return this.alphabetMapping;
    }

    @Override
    public final void set_alphabetMapping(int[] nArray) {
        int[] nArray2 = this.alphabetMapping;
        if (!Arrays.equals(nArray2, nArray)) {
            this.alphabetMapping = nArray;
            this.alphabetMappingChanged(nArray2);
            this.propertyChanged(54);
        }
    }

    @Override
    public final boolean is_asiaConversionEnabled() {
        return this.getInternalStateFlag(20);
    }

    @Override
    public final void set_asiaConversionEnabled(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(20);
        if (bl2 != bl) {
            this.setInternalStateFlag(20, bl);
            this.asiaConversionEnabledChanged(bl2);
            this.propertyChanged(55);
        }
    }

    @Override
    public final int get_filterId() {
        return this.filterId;
    }

    @Override
    public final void set_filterId(int n) {
        int n2 = this.filterId;
        if (n2 != n) {
            this.filterId = n;
            this.filterIdChanged(n2);
            this.propertyChanged(56);
        }
    }

    @Override
    public final boolean is_firstLetterInput() {
        return true;
    }

    @Override
    public final void set_firstLetterInput(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(23);
        if (bl2 != bl) {
            this.setInternalStateFlag(23, bl);
            this.firstLetterInputChanged(bl2);
            this.propertyChanged(69);
        }
    }

    @Override
    public final TouchAreaModel get_hwrAreaRef() {
        return this.hwrAreaRef;
    }

    @Override
    public final void set_hwrAreaRef(TouchAreaModel touchAreaModel) {
        TouchAreaModel touchAreaModel2 = this.hwrAreaRef;
        if (touchAreaModel2 != touchAreaModel) {
            this.hwrAreaRef = touchAreaModel;
            this.hwrAreaRefChanged(touchAreaModel2);
            this.propertyChanged(57);
        }
    }

    @Override
    public final boolean is_hwrEnabled() {
        return this.getInternalStateFlag(21);
    }

    @Override
    public final void set_hwrEnabled(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(21);
        if (bl2 != bl) {
            this.setInternalStateFlag(21, bl);
            this.hwrEnabledChanged(bl2);
            this.propertyChanged(58);
        }
    }

    @Override
    public final ContainerModel[] get_hwrHiddenContentRefs() {
        return this.hwrHiddenContentRefs;
    }

    @Override
    public final void set_hwrHiddenContentRefs(ContainerModel[] containerModelArray) {
        Object[] objectArray = this.hwrHiddenContentRefs;
        if (!Arrays.equals(objectArray, containerModelArray)) {
            this.hwrHiddenContentRefs = containerModelArray;
            this.hwrHiddenContentRefsChanged((ContainerModel[])objectArray);
            this.propertyChanged(59);
        }
    }

    @Override
    public final int get_hwrMode() {
        return this.hwrMode;
    }

    @Override
    public final void set_hwrMode(int n) {
        int n2 = this.hwrMode;
        if (n2 != n) {
            this.hwrMode = n;
            this.hwrModeChanged(n2);
            this.propertyChanged(61);
        }
    }

    @Override
    public final ContainerModel[] get_hwrVisibleContentRefs() {
        return this.hwrVisibleContentRefs;
    }

    @Override
    public final void set_hwrVisibleContentRefs(ContainerModel[] containerModelArray) {
        Object[] objectArray = this.hwrVisibleContentRefs;
        if (!Arrays.equals(objectArray, containerModelArray)) {
            this.hwrVisibleContentRefs = containerModelArray;
            this.hwrVisibleContentRefsChanged((ContainerModel[])objectArray);
            this.propertyChanged(62);
        }
    }

    @Override
    public final WidgetModel[] get_hwrInfoTextRefs() {
        return this.hwrInfoTextRefs;
    }

    @Override
    public final void set_hwrInfoTextRefs(WidgetModel[] widgetModelArray) {
        Object[] objectArray = this.hwrInfoTextRefs;
        if (!Arrays.equals(objectArray, widgetModelArray)) {
            this.hwrInfoTextRefs = widgetModelArray;
            this.hwrInfoTextRefsChanged((WidgetModel[])objectArray);
            this.propertyChanged(60);
        }
    }

    @Override
    public final int get_inputType() {
        return this.inputType;
    }

    @Override
    public final void set_inputType(int n) {
        int n2 = this.inputType;
        if (n2 != n) {
            this.inputType = n;
            this.inputTypeChanged(n2);
            this.propertyChanged(63);
        }
    }

    @Override
    public final int[] get_listItemLimitations() {
        return this.listItemLimitations;
    }

    @Override
    public final void set_listItemLimitations(int[] nArray) {
        int[] nArray2 = this.listItemLimitations;
        if (!Arrays.equals(nArray2, nArray)) {
            this.listItemLimitations = nArray;
            this.listItemLimitationsChanged(nArray2);
            this.propertyChanged(64);
        }
    }

    @Override
    public final boolean[] get_listItemNotifications() {
        return this.listItemNotifications;
    }

    @Override
    public final void set_listItemNotifications(boolean[] blArray) {
        boolean[] blArray2 = this.listItemNotifications;
        if (!Arrays.equals(blArray2, blArray)) {
            this.listItemNotifications = blArray;
            this.listItemNotificationsChanged(blArray2);
            this.propertyChanged(65);
        }
    }

    @Override
    public final ListItemModel[] get_listItemRefs() {
        return this.listItemRefs;
    }

    @Override
    public final void set_listItemRefs(ListItemModel[] listItemModelArray) {
        Object[] objectArray = this.listItemRefs;
        if (!Arrays.equals(objectArray, listItemModelArray)) {
            this.listItemRefs = listItemModelArray;
            this.listItemRefsChanged((ListItemModel[])objectArray);
            this.propertyChanged(67);
        }
    }

    @Override
    public final int[] get_listItemRefContents() {
        return this.listItemRefContents;
    }

    @Override
    public final void set_listItemRefContents(int[] nArray) {
        int[] nArray2 = this.listItemRefContents;
        if (!Arrays.equals(nArray2, nArray)) {
            this.listItemRefContents = nArray;
            this.listItemRefContentsChanged(nArray2);
            this.propertyChanged(66);
        }
    }

    @Override
    public final TemplateListModel[] get_listRefs() {
        return this.listRefs;
    }

    @Override
    public final void set_listRefs(TemplateListModel[] templateListModelArray) {
        Object[] objectArray = this.listRefs;
        if (!Arrays.equals(objectArray, templateListModelArray)) {
            this.listRefs = templateListModelArray;
            this.listRefsChanged((TemplateListModel[])objectArray);
            this.propertyChanged(68);
        }
    }

    @Override
    public final boolean is_nameInput() {
        return this.getInternalStateFlag(24);
    }

    @Override
    public final void set_nameInput(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(24);
        if (bl2 != bl) {
            this.setInternalStateFlag(24, bl);
            this.nameInputChanged(bl2);
            this.propertyChanged(70);
        }
    }

    @Override
    public final boolean is_syllablewiseInput() {
        return this.getInternalStateFlag(25);
    }

    @Override
    public final void set_syllablewiseInput(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(25);
        if (bl2 != bl) {
            this.setInternalStateFlag(25, bl);
            this.syllablewiseInputChanged(bl2);
            this.propertyChanged(71);
        }
    }

    @Override
    public final boolean is_userDatabaseEnabled() {
        return this.getInternalStateFlag(26);
    }

    @Override
    public final void set_userDatabaseEnabled(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(26);
        if (bl2 != bl) {
            this.setInternalStateFlag(26, bl);
            this.userDatabaseEnabledChanged(bl2);
            this.propertyChanged(72);
        }
    }

    @Override
    public final boolean is_wordSegmentationEnabled() {
        return this.getInternalStateFlag(27);
    }

    @Override
    public final void set_wordSegmentationEnabled(boolean bl) {
        boolean bl2 = this.getInternalStateFlag(27);
        if (bl2 != bl) {
            this.setInternalStateFlag(27, bl);
            this.wordSegmentationEnabledChanged(bl2);
            this.propertyChanged(73);
        }
    }

    @Override
    public final AsiaInputInitializer getAsiaInputInitializer() {
        return this.asiaSpellerStrategy.getAsiaInputInitializer();
    }

    private int excludeLocalModesAndExtensions(int n) {
        return this.excludeLocalModesAndExtensions(n, new int[]{4, 8, 16});
    }

    protected final int excludeLocalModesAndExtensions(int n, int[] nArray) {
        int n2 = n;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if ((n2 & nArray[i2]) != nArray[i2]) continue;
            n2 ^= nArray[i2];
        }
        return n2;
    }

    @Override
    protected void setInternalMode(int n) {
        int n2 = this.excludeLocalModesAndExtensions(n);
        super.setInternalMode(n2);
        switch (n) {
            case 0: 
            case 256: {
                this.setInternalModeFlag(3, true);
                break;
            }
            case 1: 
            case 257: {
                this.setInternalModeFlag(4, true);
                break;
            }
            default: {
                this.setInternalModeFlag(3, (n & 4) == 4);
                this.setInternalModeFlag(4, (n & 8) == 8);
                this.setInternalModeFlag(5, (n & 0x10) == 16);
            }
        }
    }

    @Override
    public boolean isMode(int n) {
        switch (n) {
            case 4: {
                return this.getInternalModeFlag(3);
            }
            case 8: {
                return this.getInternalModeFlag(4);
            }
            case 16: {
                return this.getInternalModeFlag(5);
            }
        }
        int n2 = this.excludeLocalModesAndExtensions(n);
        boolean bl = super.isMode(n2);
        if ((n & 4) == 4) {
            bl &= this.getInternalModeFlag(3);
        }
        if ((n & 8) == 8) {
            bl &= this.getInternalModeFlag(4);
        }
        if ((n & 0x10) == 16) {
            bl &= this.getInternalModeFlag(5);
        }
        return bl;
    }

    @Override
    public final boolean isInHiraganaAlphabet() {
        return this.isInSpecialAlphabet(0);
    }

    @Override
    public final boolean isInHwrAlphabet() {
        return this.isInSpecialAlphabet(3) || this.isInSpecialAlphabet(5);
    }

    @Override
    public boolean isInJamoAlphabet() {
        return this.isInSpecialAlphabet(6) || this.isInSpecialAlphabet(7);
    }

    @Override
    public final boolean isInLatinAlphabet() {
        return !this.isInHwrAlphabet() && !this.isInPinyinAlphabet() && !this.isInZhuyinAlphabet() && !this.isInHiraganaAlphabet() && !this.isInRomajiAlphabet();
    }

    @Override
    public final boolean isInPinyinAlphabet() {
        return this.isInSpecialAlphabet(2);
    }

    @Override
    public final boolean isInRomajiAlphabet() {
        return this.isInSpecialAlphabet(1);
    }

    @Override
    public final boolean isInZhuyinAlphabet() {
        return this.isInSpecialAlphabet(4);
    }

    public final boolean isInSpecialAlphabet(int n) {
        return this.isInSpecialAlphabet(n, this.get_alphabetIndex());
    }

    public final boolean isInSpecialAlphabet(int n, int n2) {
        return this.alphabetMapping != null && this.alphabetMapping.length > n ? n2 == this.alphabetMapping[n] : false;
    }

    @Override
    public void setCandidates(String[] stringArray) {
        this.traceListItemData("setCandidates:", stringArray);
        this.setListItemData(stringArray, 7);
    }

    @Override
    public void setNextValidCharacters(String[] stringArray) {
        this.traceListItemData("setNextValidCharacters:", stringArray);
        this.setListItemData(stringArray, 16);
    }

    @Override
    public void setPrediction(String[] stringArray) {
        this.traceListItemData("setPrediction:", stringArray);
        this.setListItemData(stringArray, 8);
    }

    @Override
    public void setRecognizedCharacters(String[] stringArray) {
        this.traceListItemData("setRecognizedCharacters:", stringArray);
        this.setListItemData(stringArray, 32);
    }

    private void setListItemData(String[] stringArray, int n) {
        if (this.listItemRefs != null) {
            block5: for (int i2 = 0; i2 < this.listItemRefs.length; ++i2) {
                AsiaSpeller$AsiaListItemControl asiaSpeller$AsiaListItemControl;
                if (this.listItemRefs[i2] == null) continue;
                ListItemControl listItemControl = this.listItemRefs[i2].getListItemControl();
                if ((n & 7) != 0) {
                    if (!(listItemControl instanceof AsiaSpeller$PreviewLineListItemControl)) continue;
                    asiaSpeller$AsiaListItemControl = (AsiaSpeller$PreviewLineListItemControl)listItemControl;
                    ((AsiaSpeller$PreviewLineListItemControl)asiaSpeller$AsiaListItemControl).setCandidates(stringArray);
                    continue;
                }
                if ((n & 0x38) == 0 || !(listItemControl instanceof AsiaSpeller$PredictionListItemControl)) continue;
                asiaSpeller$AsiaListItemControl = (AsiaSpeller$PredictionListItemControl)listItemControl;
                switch (n) {
                    case 8: {
                        ((AsiaSpeller$PredictionListItemControl)asiaSpeller$AsiaListItemControl).setPrediction(stringArray);
                        continue block5;
                    }
                    case 32: {
                        ((AsiaSpeller$PredictionListItemControl)asiaSpeller$AsiaListItemControl).setRecognizedChars(stringArray);
                        continue block5;
                    }
                    case 16: {
                        ((AsiaSpeller$PredictionListItemControl)asiaSpeller$AsiaListItemControl).setNextValidCharacters(stringArray);
                        continue block5;
                    }
                }
            }
        }
    }

    private void traceListItemData(Object object, String[] stringArray) {
        if (this.isTraceEnabled() && stringArray != null && stringArray.length > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                if (i2 > 0) {
                    stringBuilder.append(" ");
                }
                stringBuilder.append("[").append(stringArray[i2]).append("]");
            }
            this.trace().append(object).append(" String[").append(stringArray.length).append("]: '").append(stringBuilder.toString()).append("'").log();
        }
    }

    @Override
    public Class[] getCompatibleUIClasses() {
        return new Class[]{class$de$vw$mib$widgets$ui$AsiaSpellerUI == null ? (class$de$vw$mib$widgets$ui$AsiaSpellerUI = AsiaSpeller.class$("de.vw.mib.widgets.ui.AsiaSpellerUI")) : class$de$vw$mib$widgets$ui$AsiaSpellerUI};
    }

    @Override
    public int getCursorPosition() {
        return this.asiaSpellerStrategy.getCursorPosition();
    }

    @Override
    protected void setDefaultShiftState() {
        if (this.get_shiftMode() == 1 && this.isInPinyinAlphabet()) {
            this.setShiftState(1);
            return;
        }
        super.setDefaultShiftState();
    }

    @Override
    public String getEnteredText() {
        return this.asiaSpellerStrategy.getEnteredText();
    }

    @Override
    public int getSelectionEnd() {
        return this.asiaSpellerStrategy.getSelectionEnd();
    }

    @Override
    public int getSelectionStart() {
        return this.asiaSpellerStrategy.getSelectionStart();
    }

    @Override
    public final String getSpelling() {
        return this.spelling != null ? this.spelling : "";
    }

    protected final void setSpelling(String string) {
        if (this.isTraceEnabled()) {
            this.trace().append("setSpelling: '").append(string).append("'").log();
        }
        this.spelling = string;
    }

    @Override
    public int getSpellingPosition() {
        return this.spellingPosition;
    }

    protected final void setSpellingPosition(int n) {
        if (this.isTraceEnabled()) {
            this.trace().append("setSpellingPosition: '").append(n).append("'").log();
        }
        this.spellingPosition = n;
    }

    @Override
    public final String[] getWordDatabaseNames() {
        return this.wordDatabaseNames;
    }

    public final void setWordDatabaseNames(String[] stringArray) {
        Object[] objectArray = this.wordDatabaseNames;
        if (!Arrays.equals(objectArray, stringArray)) {
            this.wordDatabaseNames = stringArray;
            this.wordDatabaseNamesChanged(this.wordDatabaseNames);
        }
    }

    @Override
    protected void alphabetIndexChanged(int n) {
        this.asiaSpellerStrategy.alphabetIndexChanged(n);
        super.alphabetIndexChanged(n);
        this.controlContentVisibility();
        this.repaint();
    }

    protected void alphabetMappingChanged(int[] nArray) {
        this.calculateAvailableCharacters();
        this.controlContentVisibility();
        this.repaint();
    }

    protected void asiaConversionEnabledChanged(boolean bl) {
        this.setDefaultShiftState();
    }

    protected void filterIdChanged(int n) {
    }

    protected void firstLetterInputChanged(boolean bl) {
        this.asiaSpellerStrategy.firstLetterInputChanged(bl);
    }

    protected void hwrAreaRefChanged(TouchAreaModel touchAreaModel) {
    }

    protected void hwrEnabledChanged(boolean bl) {
        this.calculateAvailableCharacters();
        this.controlContentVisibility();
        this.repaint();
    }

    protected void hwrHiddenContentRefsChanged(ContainerModel[] containerModelArray) {
        this.controlContentVisibility();
        this.repaint();
    }

    protected void hwrInfoTextRefsChanged(WidgetModel[] widgetModelArray) {
        this.repaint();
    }

    protected void hwrModeChanged(int n) {
    }

    protected void hwrVisibleContentRefsChanged(ContainerModel[] containerModelArray) {
        this.controlContentVisibility();
        this.repaint();
    }

    protected void inputTypeChanged(int n) {
        this.initSpellerStrategyByInputType(this.inputType);
    }

    protected void listItemLimitationsChanged(int[] nArray) {
        if (this.listItemLimitations != null && this.listItemRefs != null) {
            for (int i2 = 0; i2 < this.listItemRefs.length; ++i2) {
                ListItemControl listItemControl;
                if (this.listItemRefs[i2] == null || !((listItemControl = this.listItemRefs[i2].getListItemControl()) instanceof AsiaSpeller$PreviewLineListItemControl)) continue;
                AsiaSpeller$PreviewLineListItemControl asiaSpeller$PreviewLineListItemControl = (AsiaSpeller$PreviewLineListItemControl)listItemControl;
                if (i2 >= this.listItemLimitations.length || this.listItemLimitations[i2] < 0) continue;
                asiaSpeller$PreviewLineListItemControl.setListItemLimitation(this.listItemLimitations[i2]);
            }
        }
    }

    protected void listItemNotificationsChanged(boolean[] blArray) {
        if (this.listItemNotifications != null && this.listItemRefs != null) {
            for (int i2 = 0; i2 < this.listItemRefs.length; ++i2) {
                ListItemControl listItemControl;
                if (this.listItemRefs[i2] == null || !((listItemControl = this.listItemRefs[i2].getListItemControl()) instanceof AsiaSpeller$PreviewLineListItemControl)) continue;
                AsiaSpeller$PreviewLineListItemControl asiaSpeller$PreviewLineListItemControl = (AsiaSpeller$PreviewLineListItemControl)listItemControl;
                if (i2 >= this.listItemNotifications.length) continue;
                asiaSpeller$PreviewLineListItemControl.setListItemNotification(this.listItemNotifications[i2]);
            }
        }
    }

    protected void listItemRefsChanged(ListItemModel[] listItemModelArray) {
        if (listItemModelArray != null) {
            this.deInitListItemRefs(listItemModelArray);
        }
        if (this.listItemRefs != null) {
            this.initListItemRefs(this.listItemRefs);
        }
    }

    protected void listItemRefContentsChanged(int[] nArray) {
    }

    protected void listRefsChanged(TemplateListModel[] templateListModelArray) {
        if (templateListModelArray != null) {
            this.deInitListRefs(templateListModelArray);
        }
        if (this.listRefs != null) {
            this.initListRefs(this.listRefs);
        }
    }

    protected void nameInputChanged(boolean bl) {
        this.asiaSpellerStrategy.nameInputChanged(bl);
    }

    protected void syllablewiseInputChanged(boolean bl) {
    }

    @Override
    protected void spellerDataChanged(SpellerData spellerData) {
        this.asiaSpellerStrategy.spellerDataChanged(spellerData);
        super.spellerDataChanged(spellerData);
    }

    protected void userDatabaseEnabledChanged(boolean bl) {
        this.asiaSpellerStrategy.userDatabaseEnabledChanged(bl);
    }

    protected void wordDatabaseNamesChanged(String[] stringArray) {
        this.asiaSpellerStrategy.wordDatabaseNamesChanged(stringArray);
    }

    protected void wordSegmentationEnabledChanged(boolean bl) {
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    protected void calculateAvailableCharacter(SpellerElement spellerElement) {
        Object object;
        boolean bl;
        block22: {
            SpellerData spellerData;
            String string;
            block20: {
                String string2;
                String string3;
                block23: {
                    block21: {
                        bl = false;
                        string = spellerElement.getReturnFunction();
                        spellerData = this.get_spellerData();
                        if (!string.equalsIgnoreCase("FUNC_NONE")) break block20;
                        object = spellerData != null ? spellerData.getAvailableCharacters() : "";
                        string3 = spellerData != null ? spellerData.getUnavailableCharacters() : "";
                        string2 = spellerElement.getGraphRep();
                        if (!this.isInHwrAlphabet()) break block21;
                        bl = this.isMode(8) || string2 == null || ((String)object).indexOf(string2) > -1;
                        break block22;
                    }
                    if (!(this.isInHiraganaAlphabet() || this.isInRomajiAlphabet() || this.isInJamoAlphabet())) {
                        super.calculateAvailableCharacter(spellerElement);
                        return;
                    }
                    boolean bl2 = bl = this.isMode(1) && !this.isInRomajiAlphabet() && !this.isInJamoAlphabet();
                    if (bl || "".equals(object)) break block23;
                    boolean bl3 = string2 != null ? ((String)object).indexOf(string2) > -1 : (bl = bl);
                    if (this.isInHiraganaAlphabet() || this.isInJamoAlphabet()) {
                        bl = this.calculateAvailableSubSpellerCharacters(spellerElement, bl, (String)object, true);
                    }
                    break block22;
                }
                if (!"".equals(string3)) {
                    boolean bl4 = string2 != null ? string3.indexOf(string2) < 0 : (bl = bl);
                    if (this.isInHiraganaAlphabet() || this.isInJamoAlphabet()) {
                        bl = this.calculateAvailableSubSpellerCharacters(spellerElement, bl, string3, false);
                    }
                    break block22;
                } else if (this.isInHiraganaAlphabet() || this.isInJamoAlphabet()) {
                    bl = this.calculateAvailableSubSpellerCharacters(spellerElement, bl, (String)object, true);
                }
                break block22;
            }
            if (string.equalsIgnoreCase("FUNC_DEL")) {
                bl = spellerData != null && spellerData.getEnteredText() != null && spellerData.getEnteredText().length() > 0 && this.spellerData.getCursorPosition() > 0;
                bl = bl || this.spelling != null && this.spelling.length() > 0;
            } else if (string.toUpperCase().startsWith("FUNC_HWR")) {
                bl = this.is_hwrEnabled() && !this.isInHwrAlphabet();
            } else if (string.startsWith("FUNC_OK")) {
                bl = this.is_okEnabled() && this.isInCharBounds(this.getEnteredText(), this.get_charMin(), this.get_charMax() + this.getSpelling().length());
            } else if (string.equalsIgnoreCase("FUNC_HIRAGANA")) {
                if (!this.isInHiraganaAlphabet()) {
                    bl = true;
                }
            } else if (string.equalsIgnoreCase("FUNC_ROMAJI")) {
                if (!this.isInRomajiAlphabet()) {
                    bl = true;
                }
            } else {
                if (!string.equalsIgnoreCase("FUNC_SHIFT")) {
                    super.calculateAvailableCharacter(spellerElement);
                    return;
                }
                if (!this.isInHiraganaAlphabet()) {
                    super.calculateAvailableCharacter(spellerElement);
                    return;
                }
                char c2 = this.getSpelling().length() > 0 ? this.getSpelling().charAt(this.getSpelling().length() - 1) : (char)'\u0000';
                bl = HiraganaFreeTextConverter.isSmallKanaAvailable(c2) || HiraganaFreeTextConverter.isLargeKanaAvailable(c2);
            }
        }
        object = this.getSpellerElementStates();
        ((SpellerElementStates)object).setEnabled(spellerElement, bl);
    }

    @Override
    public void clearHwrArea() {
        TouchAreaModel touchAreaModel = this.hwrAreaRef;
        if (touchAreaModel != null) {
            touchAreaModel.clearTouchTrajectories();
        }
    }

    protected void controlContentVisibility() {
        if (this.is_hwrEnabled() && this.isInHwrAlphabet()) {
            this.showWidgetRefs(this.hwrHiddenContentRefs, false);
            this.showWidgetRefs(this.hwrVisibleContentRefs, true);
            return;
        }
        this.showWidgetRefs(this.hwrHiddenContentRefs, true);
        this.showWidgetRefs(this.hwrVisibleContentRefs, false);
    }

    protected final void showWidgetRefs(WidgetModel[] widgetModelArray, boolean bl) {
        if (widgetModelArray != null) {
            for (int i2 = widgetModelArray.length - 1; i2 >= 0; --i2) {
                if (widgetModelArray[i2] == null) continue;
                widgetModelArray[i2].set_visible(bl);
            }
        }
    }

    private ListItemControl createListItemControl(int n) {
        EmptyListItemControl emptyListItemControl = null;
        boolean bl = this.listItemLimitations != null && n < this.listItemLimitations.length && this.listItemLimitations[n] >= 0;
        boolean bl2 = this.listItemNotifications != null && n < this.listItemNotifications.length;
        boolean bl3 = this.listItemRefContents != null && n < this.listItemRefContents.length;
        int n2 = 0;
        if (bl3) {
            n2 = this.listItemRefContents[n];
        }
        switch (n2) {
            case 0: 
            case 1: 
            case 2: 
            case 3: {
                emptyListItemControl = new AsiaSpeller$PreviewLineListItemControl(this);
                break;
            }
            case 4: {
                emptyListItemControl = new AsiaSpeller$PredictionListItemControl(this);
                break;
            }
            default: {
                emptyListItemControl = new EmptyListItemControl();
            }
        }
        if (emptyListItemControl instanceof AsiaSpeller$AsiaListItemControl) {
            AsiaSpeller$AsiaListItemControl asiaSpeller$AsiaListItemControl = (AsiaSpeller$AsiaListItemControl)emptyListItemControl;
            if (bl) {
                asiaSpeller$AsiaListItemControl.setListItemLimitation(this.listItemLimitations[n]);
            }
            if (bl2) {
                asiaSpeller$AsiaListItemControl.setListItemNotification(this.listItemNotifications[n]);
            }
        }
        return emptyListItemControl;
    }

    private OutEventListener createListItemOutEventListener(int n, ListItemControl listItemControl) {
        boolean bl = this.listItemRefContents != null && n < this.listItemRefContents.length;
        int n2 = 0;
        if (bl) {
            n2 = this.listItemRefContents[n];
        }
        if (this.listItemRefSelectedHandlers == null) {
            this.listItemRefSelectedHandlers = new AsiaSpeller$AsiaOutEventListener[this.listItemRefs.length];
        }
        switch (n2) {
            case 0: 
            case 1: 
            case 2: 
            case 3: {
                this.listItemRefSelectedHandlers[n] = new AsiaSpeller$CandidateSelectedHandler(this, (AsiaSpeller$PreviewLineListItemControl)listItemControl);
                break;
            }
            case 4: {
                this.listItemRefSelectedHandlers[n] = new AsiaSpeller$PredictionSelectedHandler(this, (AsiaSpeller$PredictionListItemControl)listItemControl);
                break;
            }
        }
        return this.listItemRefSelectedHandlers != null && n >= 0 && n < this.listItemRefSelectedHandlers.length ? this.listItemRefSelectedHandlers[n] : null;
    }

    protected final void deInitListItemRefs(ListItemModel[] listItemModelArray) {
        for (int i2 = 0; i2 < listItemModelArray.length; ++i2) {
            if (listItemModelArray[i2] == null) continue;
            listItemModelArray[i2].setListItemControl(null);
            if (this.listItemListControlMap != null) {
                this.listItemListControlMap.remove(listItemModelArray[i2].get_targetId());
            }
            AsiaSpeller$AsiaOutEventListener[][] asiaSpeller$AsiaOutEventListenerArrayArray = new AsiaSpeller$AsiaOutEventListener[][]{this.listItemRefSelectedHandlers};
            WidgetController widgetController = listItemModelArray[i2].getController();
            if (widgetController == null) continue;
            for (int i3 = asiaSpeller$AsiaOutEventListenerArrayArray.length - 1; i3 >= 0; --i3) {
                if (asiaSpeller$AsiaOutEventListenerArrayArray[i3] == null) continue;
                widgetController.removeOutEventListener(asiaSpeller$AsiaOutEventListenerArrayArray[i3][i2]);
                asiaSpeller$AsiaOutEventListenerArrayArray[i3][i2] = null;
            }
        }
        this.listItemListControlMap = null;
        this.listItemRefSelectedHandlers = null;
    }

    protected final void deInitListRefs(TemplateListModel[] templateListModelArray) {
        for (int i2 = 0; i2 < templateListModelArray.length; ++i2) {
            if (templateListModelArray[i2] == null) continue;
            templateListModelArray[i2].setListItemTransfer(this.listItemTransferDelegate.getTransferViewHandler());
        }
        this.listItemTransferDelegate = null;
    }

    protected final void initSpellerStrategyByInputType(int n) {
        switch (n) {
            case 1: {
                this.asiaSpellerStrategy = new ChinaSpellerStrategy(this);
                break;
            }
            case 2: {
                this.asiaSpellerStrategy = new JapanSpellerStrategy(this);
                break;
            }
            case 3: {
                this.asiaSpellerStrategy = new KoreaSpellerStrategy(this);
                break;
            }
            default: {
                this.asiaSpellerStrategy = new DefaultAsiaSpellerStrategy(this);
            }
        }
    }

    protected final void initListItemRefs(ListItemModel[] listItemModelArray) {
        for (int i2 = 0; i2 < listItemModelArray.length; ++i2) {
            if (listItemModelArray[i2] == null) continue;
            ListItemControl listItemControl = this.createListItemControl(i2);
            listItemModelArray[i2].setListItemControl(listItemControl);
            if (this.listItemListControlMap == null) {
                this.listItemListControlMap = new IntObjectOptHashMap(listItemModelArray.length);
            }
            this.listItemListControlMap.put(listItemModelArray[i2].get_targetId(), listItemControl);
            OutEventListener outEventListener = this.createListItemOutEventListener(i2, listItemControl);
            WidgetController widgetController = listItemModelArray[i2].getController();
            if (widgetController == null || outEventListener == null) continue;
            widgetController.addOutEventListener(outEventListener);
        }
    }

    protected final void initListRefs(TemplateListModel[] templateListModelArray) {
        for (int i2 = 0; i2 < templateListModelArray.length; ++i2) {
            if (templateListModelArray[i2] == null) continue;
            if (this.listItemTransferDelegate == null) {
                this.listItemTransferDelegate = new AsiaSpeller$ListItemTransferDelegate(this.listRefs[i2].getListItemTransfer(), this);
            }
            templateListModelArray[i2].setListItemTransfer(this.listItemTransferDelegate);
            WidgetCloneFactory widgetCloneFactory = templateListModelArray[i2].getWidgetCloneFactory();
            if (widgetCloneFactory == null) continue;
            templateListModelArray[i2].setWidgetCloneFactory(new AsiaSpeller$ListRefsWidgetCloneFactory(this, widgetCloneFactory));
        }
    }

    @Override
    protected boolean isSubSpellerElementEnabled(SpellerElement spellerElement, String string, boolean bl) {
        if (string != null && spellerElement.getGraphRep() != null) {
            if (bl) {
                return this.isMode(1) || string.toLowerCase().indexOf(spellerElement.getGraphRep()) >= 0 || string.toUpperCase().indexOf(spellerElement.getGraphRep()) >= 0;
            }
            return string.indexOf(spellerElement.getGraphRep()) < 0;
        }
        return false;
    }

    @Override
    public boolean transferData(ListItemModel listItemModel, int n, int n2) {
        Button button;
        TextAreaModel[] textAreaModelArray;
        AbstractButtonModel[] abstractButtonModelArray;
        AsiaSpeller$AsiaListItemControl asiaSpeller$AsiaListItemControl;
        String string;
        boolean bl = false;
        Object object = listItemModel.getListItemControl();
        if (object == null && this.listItemListControlMap != null) {
            object = this.listItemListControlMap.get(listItemModel.get_targetId());
        }
        if (object instanceof AsiaSpeller$AsiaListItemControl && (string = (asiaSpeller$AsiaListItemControl = (AsiaSpeller$AsiaListItemControl)object).getCharacter(n2)) != null && (abstractButtonModelArray = listItemModel.get_activatedButtonRefs()) != null && abstractButtonModelArray.length > 0 && abstractButtonModelArray[0] instanceof Button && (textAreaModelArray = (button = (Button)abstractButtonModelArray[0]).get_textAreaRefs()) != null && textAreaModelArray.length > 0 && textAreaModelArray[0] != null) {
            TextAreaModel textAreaModel = textAreaModelArray[0];
            textAreaModel.set_text(string);
            bl = true;
        }
        return bl;
    }

    @Override
    public void updateInputField(String string, String string2, int n) {
        int n2 = this.getSelectionStart();
        int n3 = this.getSelectionEnd();
        this.updateInputField(string, string2, n, n2, n3);
    }

    @Override
    public void updateInputField(String string, String string2, int n, int n2, int n3) {
        this.updateInputField(string, string2, n, n + string2.length(), n2, n3);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateInputField(String string, String string2, int n, int n2, int n3, int n4) {
        boolean bl;
        int n5 = -1;
        boolean bl2 = !this.getSpelling().equals(string2);
        boolean bl3 = bl = this.getSpellingPosition() != n;
        if (bl2) {
            this.setSpelling(string2);
        }
        if (bl) {
            this.setSpellingPosition(n);
        }
        if (bl2 || bl) {
            n5 = 2;
        }
        SpellerData spellerData = this.get_spellerData();
        boolean bl4 = false;
        if (spellerData != null) {
            int n6;
            String string3 = spellerData.getEnteredText();
            if (string3 != null && !string3.equals(string)) {
                spellerData.setEnteredText(string);
                bl4 |= true;
            }
            if ((n6 = spellerData.getCursorPosition()) != n2) {
                spellerData.setCursorPosition(n2);
                bl4 |= true;
            }
            int n7 = spellerData.getSelectionStart();
            int n8 = spellerData.getSelectionEnd();
            if (n7 != n3) {
                spellerData.setSelectionStart(n3);
                bl4 |= true;
            }
            if (n8 != n4) {
                spellerData.setSelectionEnd(n4);
                bl4 |= true;
            }
            if (bl4) {
                this.disablePropertyChanged();
                try {
                    this.set_spellerData(spellerData);
                }
                finally {
                    this.enablePropertyChanged();
                }
            }
        }
        if (n5 > -1 && !bl4) {
            this.notifySpellerChangedListener(n5);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateSpellerButtons(String string, String string2) {
        SpellerData spellerData = this.get_spellerData();
        if (spellerData != null) {
            spellerData.setAvailableCharacters(string);
            spellerData.setUnavailableCharacters(string2);
            this.disablePropertyChanged();
            try {
                this.set_spellerData(spellerData);
            }
            finally {
                this.enablePropertyChanged();
            }
        }
    }

    @Override
    public final void activeContentChanged(int n) {
        AsiaSpellerController asiaSpellerController = (AsiaSpellerController)this.getController();
        if (asiaSpellerController != null) {
            switch (n) {
                case 2: {
                    this.setInternalStateFlag(22, true);
                    asiaSpellerController.onPreviewLineExpanded();
                    break;
                }
                default: {
                    if (!this.getInternalStateFlag(22)) break;
                    asiaSpellerController.onPreviewLineCollapsed();
                    this.setInternalStateFlag(22, false);
                }
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

