/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.internal;

import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioIntentChangeListener;
import de.vw.mib.cio.CioPayload;
import de.vw.mib.cio.ContentInformationObject;
import de.vw.mib.cio.framework.diag.CioIntentDiag;
import de.vw.mib.cio.internal.Dictionary;
import de.vw.mib.cio.internal.ScriptWidgetService;
import de.vw.mib.collections.copyonwrite.CowArray;

public abstract class AbstractCio
implements CioIntent,
CioIntentDiag,
ContentInformationObject {
    static final int UNSPECIFIED_ACTION;
    static final String UNSPECIFIED_CIO_NAME;
    private final int actionId;
    private boolean available = true;
    private final String cioName;
    private final Object data;
    private final Dictionary dictionary;
    private final String intentClass;
    private final long intentId;
    private final String intentName;
    private final CowArray listeners;
    private final CioPayload payload;
    private final int rank;
    private final String usage;
    private final long[] visualizationIds;
    private int visualizationIndex = 0;
    final String appName;
    final String appInstanceName;
    final ScriptWidgetService scriptWidgetService;

    AbstractCio(String string, String string2, String string3, int n, String string4, String string5, String string6, int n2, long l, long[] lArray, Dictionary dictionary, ScriptWidgetService scriptWidgetService) {
        this(string, string2, string3, n, string4, string5, string6, n2, null, null, l, lArray, dictionary, scriptWidgetService);
    }

    AbstractCio(String string, String string2, String string3, int n, String string4, String string5, String string6, int n2, CioPayload cioPayload, Object object, long l, long[] lArray, Dictionary dictionary, ScriptWidgetService scriptWidgetService) {
        this.appName = string;
        this.appInstanceName = string2;
        this.cioName = string3;
        this.actionId = n;
        this.intentClass = string5;
        this.intentName = string4;
        this.usage = string6;
        this.rank = n2;
        this.data = object;
        this.payload = cioPayload;
        this.intentId = l;
        this.visualizationIds = lArray;
        this.dictionary = dictionary;
        this.listeners = new CowArray();
        this.scriptWidgetService = scriptWidgetService;
    }

    @Override
    public void addCioIntentChangeListener(CioIntentChangeListener cioIntentChangeListener) {
        this.listeners.addIfNotAlreadyIn(cioIntentChangeListener);
    }

    @Override
    public final int getActionId() {
        return this.actionId;
    }

    @Override
    public final String getAppName() {
        return this.appName;
    }

    @Override
    public final String getAppInstanceName() {
        return this.appInstanceName;
    }

    @Override
    public String getCioExecutor() {
        return "AppFramework";
    }

    @Override
    public final String getCioIntentClass() {
        return this.intentClass;
    }

    @Override
    public final long getCioIntentId() {
        return this.intentId;
    }

    @Override
    public final String getCioIntentName() {
        return this.intentName;
    }

    @Override
    public final String getCioName() {
        return this.cioName;
    }

    @Override
    public final CioPayload getPayload() {
        return this.payload;
    }

    @Override
    public final Object getPayloadData() {
        return this.data;
    }

    @Override
    public final int getRank() {
        return this.rank;
    }

    @Override
    public final String getUsage() {
        return this.usage;
    }

    @Override
    public final long getVisualizationId() {
        return this.visualizationIds[this.visualizationIndex];
    }

    @Override
    public int getActiveVisualizationIndex() {
        return this.visualizationIndex;
    }

    @Override
    public void setActiveVisualizationIndex(int n) {
        this.visualizationIndex = n;
        this.scriptWidgetService.notifyCioVisualizationChange(this.getCioIntentId());
    }

    @Override
    public boolean isAvailable() {
        return this.available;
    }

    @Override
    public final boolean isRegistered() {
        return this.dictionary.isCioRegistered(this);
    }

    @Override
    public final void register() {
        this.dictionary.registerCio(this);
    }

    @Override
    public void removeCioIntentChangeListener(CioIntentChangeListener cioIntentChangeListener) {
        this.listeners.remove(cioIntentChangeListener);
    }

    @Override
    public final void setAvailable(boolean bl) {
        this.available = bl;
        this.dictionary.onCioIntentChanged(this);
        this.onCioAvailabilityChanged(bl);
    }

    @Override
    public final void unregister() {
        this.dictionary.unregisterCio(this);
    }

    abstract void execute(CioActionParameters cioActionParameters) {
    }

    final long[] getVisualizationIds() {
        return this.visualizationIds;
    }

    final boolean hasSameProvider(AbstractCio abstractCio) {
        if (abstractCio == null) {
            return false;
        }
        return this.appName.equals(abstractCio.appName) && this.appInstanceName.equals(abstractCio.appInstanceName);
    }

    private void onCioAvailabilityChanged(boolean bl) {
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((CioIntentChangeListener)objectArray[i2]).cioAvailabilityStateChanged(this, bl);
        }
    }

    static {
        UNSPECIFIED_CIO_NAME = null;
    }
}

