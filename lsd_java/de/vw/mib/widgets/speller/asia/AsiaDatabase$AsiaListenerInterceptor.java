/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.widgets.speller.asia;

import de.vw.mib.asia.AsiaAdapter;
import de.vw.mib.asia.AsiaListener;
import de.vw.mib.collections.copyonwrite.CowArray;

final class AsiaDatabase$AsiaListenerInterceptor
extends AsiaAdapter {
    private static final char ASIA_INPUT_SEGMENTATION_DELIMITER;
    private static final char HMI_SEGMENTATION_DELIMITER;
    private CowArray asiaListeners = new CowArray();

    public void addListener(AsiaListener asiaListener) {
        this.asiaListeners.addIfNotAlreadyIn(asiaListener);
    }

    @Override
    public void asiaBuiltCandidates(int n) {
        this.forwardBuiltCandidates(n);
    }

    @Override
    public void asiaReceivedCandidates(String[] stringArray) {
        this.forwardCandidates(stringArray);
    }

    @Override
    public void asiaReceivedErrorStatus(int n) {
        this.forwardErrorStatus(n);
    }

    @Override
    public void asiaReceivedSegmentation(String string) {
        String string2 = this.replaceSegmentationDelimiter(string);
        this.forwardSegmentation(string2);
    }

    @Override
    public void asiaReceivedSpelling(String string) {
        this.forwardSpelling(string);
    }

    @Override
    public void asiaReceivedTimeout() {
        this.forwardTimeout();
    }

    @Override
    public void asiaSelectedCandidate(int n) {
        this.forwardSelectedCandidate(n);
    }

    private void forwardBuiltCandidates(int n) {
        for (int i2 = 0; i2 < this.asiaListeners.length(); ++i2) {
            AsiaListener asiaListener = (AsiaListener)this.asiaListeners.get(i2);
            asiaListener.asiaBuiltCandidates(n);
        }
    }

    private void forwardCandidates(String[] stringArray) {
        for (int i2 = 0; i2 < this.asiaListeners.length(); ++i2) {
            AsiaListener asiaListener = (AsiaListener)this.asiaListeners.get(i2);
            asiaListener.asiaReceivedCandidates(stringArray);
        }
    }

    private void forwardErrorStatus(int n) {
        for (int i2 = 0; i2 < this.asiaListeners.length(); ++i2) {
            AsiaListener asiaListener = (AsiaListener)this.asiaListeners.get(i2);
            asiaListener.asiaReceivedErrorStatus(n);
        }
    }

    private void forwardSegmentation(String string) {
        for (int i2 = 0; i2 < this.asiaListeners.length(); ++i2) {
            AsiaListener asiaListener = (AsiaListener)this.asiaListeners.get(i2);
            asiaListener.asiaReceivedSegmentation(string);
        }
    }

    private void forwardSpelling(String string) {
        for (int i2 = 0; i2 < this.asiaListeners.length(); ++i2) {
            AsiaListener asiaListener = (AsiaListener)this.asiaListeners.get(i2);
            asiaListener.asiaReceivedSpelling(string);
        }
    }

    private void forwardTimeout() {
        for (int i2 = 0; i2 < this.asiaListeners.length(); ++i2) {
            AsiaListener asiaListener = (AsiaListener)this.asiaListeners.get(i2);
            asiaListener.asiaReceivedTimeout();
        }
    }

    private void forwardSelectedCandidate(int n) {
        for (int i2 = 0; i2 < this.asiaListeners.length(); ++i2) {
            AsiaListener asiaListener = (AsiaListener)this.asiaListeners.get(i2);
            asiaListener.asiaSelectedCandidate(n);
        }
    }

    public void removeListener(AsiaListener asiaListener) {
        this.asiaListeners.remove(asiaListener);
    }

    private String replaceSegmentationDelimiter(String string) {
        return string.replace('_', ' ');
    }
}

