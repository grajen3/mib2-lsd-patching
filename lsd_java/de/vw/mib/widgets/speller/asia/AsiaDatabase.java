/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.asia.AsiaInput;
import de.vw.mib.asia.AsiaListener;
import de.vw.mib.collections.copyonwrite.CowList;
import de.vw.mib.widgets.internal.ServiceManager;
import de.vw.mib.widgets.speller.asia.AsiaCache;
import de.vw.mib.widgets.speller.asia.AsiaDatabase$1;
import de.vw.mib.widgets.speller.asia.AsiaDatabase$10;
import de.vw.mib.widgets.speller.asia.AsiaDatabase$11;
import de.vw.mib.widgets.speller.asia.AsiaDatabase$12;
import de.vw.mib.widgets.speller.asia.AsiaDatabase$13;
import de.vw.mib.widgets.speller.asia.AsiaDatabase$14;
import de.vw.mib.widgets.speller.asia.AsiaDatabase$2;
import de.vw.mib.widgets.speller.asia.AsiaDatabase$3;
import de.vw.mib.widgets.speller.asia.AsiaDatabase$4;
import de.vw.mib.widgets.speller.asia.AsiaDatabase$5;
import de.vw.mib.widgets.speller.asia.AsiaDatabase$6;
import de.vw.mib.widgets.speller.asia.AsiaDatabase$7;
import de.vw.mib.widgets.speller.asia.AsiaDatabase$8;
import de.vw.mib.widgets.speller.asia.AsiaDatabase$9;
import de.vw.mib.widgets.speller.asia.AsiaDatabase$AsiaDatabaseHolder;
import de.vw.mib.widgets.speller.asia.AsiaDatabase$AsiaListenerInterceptor;
import de.vw.mib.widgets.speller.asia.AsiaDatabase$AsiaPhraseBufferHandler;
import de.vw.mib.widgets.speller.asia.AsiaInputInitializer;
import de.vw.mib.widgets.speller.asia.AsiaPhraseBuffer;
import de.vw.mib.widgets.speller.asia.AsiaSymbolBuffer;
import de.vw.mib.widgets.speller.asia.DefaultAsiaPhraseSymbolBuffer;
import de.vw.mib.widgets.speller.asia.ExtendedAsiaAdapter;
import org.dsi.ifc.asiainput.UserDefinedEntry;

public class AsiaDatabase {
    private final AsiaCache asiaCache;
    private AsiaInput asiaInput;
    private AsiaInputInitializer asiaInputInitializer;
    private final AsiaDatabase$AsiaListenerInterceptor asiaListenerInterceptor;
    private CowList asiaListeners;
    private final AsiaPhraseBuffer asiaPhraseBuffer;
    private final AsiaDatabase$AsiaPhraseBufferHandler asiaPhraseBufferHandler;
    private final AsiaSymbolBuffer asiaSymbolBuffer;

    public static AsiaDatabase getAsiaInputWrapper(AsiaInputInitializer asiaInputInitializer) {
        return AsiaDatabase$AsiaDatabaseHolder.ASIA_INPUT_WRAPPER.setAsiaInput(ServiceManager.asiaInput).setAsiaInputInitializer(asiaInputInitializer);
    }

    protected AsiaDatabase() {
        this(new DefaultAsiaPhraseSymbolBuffer());
    }

    protected AsiaDatabase(AsiaPhraseBuffer asiaPhraseBuffer) {
        this(asiaPhraseBuffer, asiaPhraseBuffer instanceof DefaultAsiaPhraseSymbolBuffer ? (AsiaSymbolBuffer)((Object)asiaPhraseBuffer) : new DefaultAsiaPhraseSymbolBuffer());
    }

    protected AsiaDatabase(AsiaPhraseBuffer asiaPhraseBuffer, AsiaSymbolBuffer asiaSymbolBuffer) {
        this.asiaPhraseBuffer = asiaPhraseBuffer;
        this.asiaSymbolBuffer = asiaSymbolBuffer;
        this.asiaListeners = CowList.EMPTY;
        this.asiaCache = new AsiaCache(this.asiaSymbolBuffer);
        this.asiaPhraseBufferHandler = new AsiaDatabase$AsiaPhraseBufferHandler(this.asiaPhraseBuffer, this.asiaCache);
        this.asiaListenerInterceptor = new AsiaDatabase$AsiaListenerInterceptor();
        this.asiaListenerInterceptor.addListener(this.asiaPhraseBufferHandler);
    }

    protected final AsiaDatabase setAsiaInput(AsiaInput asiaInput) {
        AsiaInput asiaInput2 = this.asiaInput;
        if (asiaInput2 != asiaInput) {
            this.asiaInput = asiaInput;
            this.asiaInputChanged(asiaInput2, asiaInput);
        }
        return this;
    }

    protected final AsiaDatabase setAsiaInputInitializer(AsiaInputInitializer asiaInputInitializer) {
        AsiaInputInitializer asiaInputInitializer2 = this.asiaInputInitializer;
        if (asiaInputInitializer2 != asiaInputInitializer) {
            this.asiaInputInitializer = asiaInputInitializer;
            this.asiaInputInitializerChanged(asiaInputInitializer2, this.asiaInputInitializer);
        }
        return this;
    }

    protected void asiaInputChanged(AsiaInput asiaInput, AsiaInput asiaInput2) {
        if (asiaInput != null) {
            asiaInput.removeAsiaListener(this.asiaListenerInterceptor);
        }
        if (asiaInput2 != null) {
            asiaInput2.addAsiaListener(this.asiaListenerInterceptor);
        }
    }

    protected void asiaInputInitializerChanged(AsiaInputInitializer asiaInputInitializer, AsiaInputInitializer asiaInputInitializer2) {
        if (asiaInputInitializer != null && asiaInputInitializer.isInitialized()) {
            this.asiaCache.markStateAsDirty((byte)0);
            this.clearInternal();
        }
        if (asiaInputInitializer2 != null && asiaInputInitializer2.isInitialized()) {
            asiaInputInitializer2.reset();
        }
    }

    public final void addAsiaListener(ExtendedAsiaAdapter extendedAsiaAdapter) {
        this.addAsiaListener(extendedAsiaAdapter, true);
    }

    private void addAsiaListener(ExtendedAsiaAdapter extendedAsiaAdapter, boolean bl) {
        this.asiaListenerInterceptor.addListener(extendedAsiaAdapter);
        if (bl) {
            this.asiaListeners = this.asiaListeners.addIfAbsent(extendedAsiaAdapter);
        }
    }

    public final void addPhrase(String string) {
        this.addPhraseInternal(string);
    }

    protected void addPhraseInternal(String string) {
        this.asiaPhraseBuffer.addPhrase(string);
        this.asiaCache.markStateAsDirty((byte)0);
    }

    public final void addSymbol(char c2) {
        if (!this.asiaInputInitializer.isInitialized()) {
            this.asiaInputInitializer.initialize(this.asiaInput, new AsiaDatabase$1(this, c2));
        } else {
            this.addSymbolInternal(c2);
        }
    }

    protected void addSymbolInternal(char c2) {
        this.asiaCache.addSymbols(String.valueOf(c2));
        this.asiaInput.addSymbol(c2);
        this.asiaCache.markMultipleStatesAsDirty((byte)31);
    }

    public final void addSymbols(String string) {
        if (!this.asiaInputInitializer.isInitialized()) {
            this.asiaInputInitializer.initialize(this.asiaInput, new AsiaDatabase$2(this, string));
        } else {
            this.addSymbolsInternal(string);
        }
    }

    protected void addSymbolsInternal(String string) {
        this.asiaCache.addSymbols(string);
        this.asiaInput.addSymbols(string);
        this.asiaCache.markMultipleStatesAsDirty((byte)31);
    }

    public final void addUserDefinedEntry(UserDefinedEntry userDefinedEntry) {
        if (!this.asiaInputInitializer.isInitialized()) {
            this.asiaInputInitializer.initialize(this.asiaInput, new AsiaDatabase$3(this, userDefinedEntry));
        } else {
            this.addUserDefinedEntryInternal(userDefinedEntry);
        }
    }

    protected void addUserDefinedEntryInternal(UserDefinedEntry userDefinedEntry) {
        this.asiaInput.addUserDefinedEntry(userDefinedEntry);
    }

    public final void buildCandidates() {
        if (!this.asiaInputInitializer.isInitialized()) {
            this.asiaInputInitializer.initialize(this.asiaInput, new AsiaDatabase$4(this));
        } else {
            this.buildCandidatesInternal();
        }
    }

    protected void buildCandidatesInternal() {
        if (this.asiaCache.isCachingEnabled() && !this.asiaCache.isStateDirty((byte)2)) {
            this.fireBuiltCandidates(this.asiaCache.getCandidatesCount());
            return;
        }
        this.asiaInput.buildCandidates();
    }

    public final void clear() {
        if (this.asiaInputInitializer.isInitialized()) {
            this.clearInternal();
        }
    }

    protected void clearInternal() {
        if (this.asiaCache.isCachingEnabled() && !this.asiaCache.isStateDirty((byte)0)) {
            return;
        }
        this.asiaInput.clear();
        this.asiaInputInitializer.reset();
        this.asiaPhraseBuffer.removeAllPhrases();
        this.asiaSymbolBuffer.removeAllSymbols();
        this.asiaCache.clearCache();
        this.removeAllAsiaListeners();
    }

    public final void clearPredictionContext() {
        if (!this.asiaInputInitializer.isInitialized()) {
            this.asiaInputInitializer.initialize(this.asiaInput, new AsiaDatabase$5(this));
        } else {
            this.clearPredictionContextInternal();
        }
    }

    protected void clearPredictionContextInternal() {
        if (this.asiaCache.isCachingEnabled()) {
            if (this.asiaCache.isStateDirty((byte)4) || this.asiaCache.getPredictionContext().length() != 0) {
                this.asiaCache.setPreditionContext("");
            } else {
                return;
            }
        }
        this.asiaInput.clearPredictionContext();
        this.asiaCache.markMultipleStatesAsDirty((byte)12);
    }

    protected final void fireBuiltCandidates(int n) {
        for (CowList cowList = this.asiaListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            AsiaListener asiaListener = (AsiaListener)cowList.head();
            asiaListener.asiaBuiltCandidates(n);
        }
    }

    protected final void fireReceivedCandidates(String[] stringArray) {
        for (CowList cowList = this.asiaListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            AsiaListener asiaListener = (AsiaListener)cowList.head();
            asiaListener.asiaReceivedCandidates(stringArray);
        }
    }

    protected final void fireReceivedCursorPosition(int n) {
        for (CowList cowList = this.asiaListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            ExtendedAsiaAdapter extendedAsiaAdapter = (ExtendedAsiaAdapter)cowList.head();
            extendedAsiaAdapter.asiaReceivedCursorPosition(n);
        }
    }

    protected final void fireReceivedPhrases(String string) {
        for (CowList cowList = this.asiaListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            ExtendedAsiaAdapter extendedAsiaAdapter = (ExtendedAsiaAdapter)cowList.head();
            extendedAsiaAdapter.asiaReceivedPhrases(string);
        }
    }

    protected final void fireReceivedPredictionContext(String string) {
        for (CowList cowList = this.asiaListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            ExtendedAsiaAdapter extendedAsiaAdapter = (ExtendedAsiaAdapter)cowList.head();
            extendedAsiaAdapter.asiaReceivedPredictionContext(string);
        }
    }

    protected final void fireReceivedSegmentation(String string) {
        for (CowList cowList = this.asiaListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            AsiaListener asiaListener = (AsiaListener)cowList.head();
            asiaListener.asiaReceivedSegmentation(string);
        }
    }

    protected final void fireReceivedSpelling(String string) {
        for (CowList cowList = this.asiaListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            AsiaListener asiaListener = (AsiaListener)cowList.head();
            asiaListener.asiaReceivedSpelling(string);
        }
    }

    public final AsiaCache getCache() {
        return this.asiaCache;
    }

    public final void getCandidates(int n) {
        if (!this.asiaInputInitializer.isInitialized()) {
            this.asiaInputInitializer.initialize(this.asiaInput, new AsiaDatabase$6(this, n));
        } else {
            this.getCandidatesInternal(n);
        }
    }

    protected void getCandidatesInternal(int n) {
        if (this.asiaCache.isCachingEnabled() && !this.asiaCache.isStateDirty((byte)3)) {
            this.fireReceivedCandidates(this.asiaCache.getCandidates());
            return;
        }
        if (n <= 0) {
            this.fireReceivedCandidates(new String[0]);
            return;
        }
        this.asiaInput.getCandidates(n);
    }

    public final void getCursorPosition() {
        this.getCursorPositionInternal();
    }

    protected void getCursorPositionInternal() {
        int n = this.asiaPhraseBuffer.getCursorPosition();
        this.fireReceivedCursorPosition(n);
    }

    public final void getPhrases() {
        this.getPhrasesInternal();
    }

    protected void getPhrasesInternal() {
        String string = this.asiaPhraseBuffer.getPhrases();
        this.fireReceivedPhrases(string);
    }

    public final void getPredictionContext() {
        this.getPredictionContextInternal();
    }

    protected void getPredictionContextInternal() {
        String string = this.asiaPhraseBuffer.getPredictionContext();
        this.fireReceivedPredictionContext(string);
    }

    public final void getSegmentation(String string) {
        if (!this.asiaInputInitializer.isInitialized()) {
            this.asiaInputInitializer.initialize(this.asiaInput, new AsiaDatabase$7(this, string));
        } else {
            this.getSegmentationInternal(string);
        }
    }

    protected void getSegmentationInternal(String string) {
        if (string == null || string.length() == 0) {
            this.fireReceivedSegmentation("");
            return;
        }
        this.asiaInput.getSegmentation(string);
    }

    public final void getSpelling() {
        if (!this.asiaInputInitializer.isInitialized()) {
            this.asiaInputInitializer.initialize(this.asiaInput, new AsiaDatabase$8(this));
        } else {
            this.getSpellingInternal();
        }
    }

    protected void getSpellingInternal() {
        if (this.asiaCache.isCachingEnabled() && !this.asiaCache.isStateDirty((byte)1)) {
            this.fireReceivedSpelling(this.asiaCache.getSpelling());
            return;
        }
        this.asiaInput.getSpelling();
    }

    public final void initialize() {
        if (!this.asiaInputInitializer.isInitialized()) {
            this.asiaInputInitializer.initialize(this.asiaInput, new AsiaDatabase$9(this));
        }
    }

    public final boolean isInitialized() {
        return this.asiaInputInitializer.isInitialized();
    }

    public final void removeAllPhrases() {
        this.removeAllPhrasesInternal();
    }

    protected void removeAllPhrasesInternal() {
        if (this.asiaPhraseBuffer.getNumberOfPhrases() > 0) {
            this.asiaPhraseBuffer.removeAllPhrases();
        }
    }

    public final void removeAllSymbols() {
        if (!this.asiaInputInitializer.isInitialized()) {
            this.asiaInputInitializer.initialize(this.asiaInput, new AsiaDatabase$10(this));
        } else {
            this.removeAllSymbolsInternal();
        }
    }

    protected void removeAllSymbolsInternal() {
        this.asiaSymbolBuffer.removeAllSymbols();
        this.asiaCache.clearSymbols();
        this.asiaInput.removeAllSymbols();
        this.asiaCache.markMultipleStatesAsDirty((byte)31);
    }

    public final void removeAllAsiaListeners() {
        for (CowList cowList = this.asiaListeners; cowList != CowList.EMPTY; cowList = cowList.tail()) {
            ExtendedAsiaAdapter extendedAsiaAdapter = (ExtendedAsiaAdapter)cowList.head();
            this.removeAsiaListener(extendedAsiaAdapter);
        }
    }

    public final void removeAsiaListener(ExtendedAsiaAdapter extendedAsiaAdapter) {
        this.asiaListenerInterceptor.removeListener(extendedAsiaAdapter);
        this.asiaListeners = this.asiaListeners.remove(extendedAsiaAdapter);
    }

    public final void removePhrase() {
        this.removePhraseInternal();
    }

    protected void removePhraseInternal() {
        this.asiaPhraseBuffer.removePhrase();
        this.asiaCache.markStateAsDirty((byte)0);
    }

    public final void removeSymbol() {
        if (!this.asiaInputInitializer.isInitialized()) {
            this.asiaInputInitializer.initialize(this.asiaInput, new AsiaDatabase$11(this));
        } else {
            this.removeSymbolInternal();
        }
    }

    protected void removeSymbolInternal() {
        this.asiaSymbolBuffer.removeSymbol();
        this.asiaInput.removeSymbol();
        this.asiaCache.markMultipleStatesAsDirty((byte)31);
    }

    public final void selectCandidate(int n) {
        if (!this.asiaInputInitializer.isInitialized()) {
            this.asiaInputInitializer.initialize(this.asiaInput, new AsiaDatabase$12(this, n));
        } else {
            this.selectCandidateInternal(n);
        }
    }

    protected void selectCandidateInternal(int n) {
        this.asiaInput.selectCandidate(n);
        this.asiaCache.markMultipleStatesAsDirty((byte)31);
    }

    public final void selectCandidate(String string) {
        if (!this.asiaInputInitializer.isInitialized()) {
            this.asiaInputInitializer.initialize(this.asiaInput, new AsiaDatabase$13(this, string));
        } else {
            this.selectCandidateInternal(string);
        }
    }

    protected void selectCandidateInternal(String string) {
        this.asiaInput.removeAllSymbols();
        this.asiaPhraseBuffer.addPhrase(string);
        this.asiaCache.markMultipleStatesAsDirty((byte)31);
    }

    public final void setCursorPosition(int n) {
        this.setCursorPositionInternal(n);
    }

    protected void setCursorPositionInternal(int n) {
        this.asiaPhraseBuffer.setCursorPosition(n);
    }

    public final void setPhrases(String string) {
        String string2 = this.asiaPhraseBuffer.getPhrases();
        if (string2 != null && !string2.equals(string)) {
            this.removeAllPhrases();
            int n = string.length();
            if (n > 0) {
                this.addPhrase(string);
                this.setCursorPosition(n);
            }
        }
    }

    public final void setPredictionContext(String string) {
        if (!this.asiaInputInitializer.isInitialized()) {
            this.asiaInputInitializer.initialize(this.asiaInput, new AsiaDatabase$14(this, string));
        } else {
            this.setPredictionContextInternal(string);
        }
    }

    protected void setPredictionContextInternal(String string) {
        if (this.asiaCache.isCachingEnabled()) {
            if (this.asiaCache.isStateDirty((byte)4) || !this.asiaCache.getPredictionContext().equals(string)) {
                this.asiaCache.setPreditionContext(string);
            } else {
                return;
            }
        }
        this.asiaInput.setPredictionContext(string);
        this.asiaCache.markMultipleStatesAsDirty((byte)13);
    }

    public final void setSymbols(String string) {
        this.removeAllSymbols();
        for (int i2 = 0; i2 < string.length(); ++i2) {
            this.addSymbol(string.charAt(i2));
        }
    }
}

