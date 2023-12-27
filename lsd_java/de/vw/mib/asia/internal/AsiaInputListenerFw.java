/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asia.internal;

import de.vw.mib.asia.AsiaInputListener;
import de.vw.mib.asia.AsiaListener;
import de.vw.mib.collections.copyonwrite.CowArray;

final class AsiaInputListenerFw
implements AsiaInputListener {
    final CowArray listeners = new CowArray();

    AsiaInputListenerFw() {
    }

    @Override
    public void builtCandidates(int n) {
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((AsiaListener)objectArray[i2]).asiaBuiltCandidates(n);
        }
    }

    @Override
    public void indicateDataInvalidated(int n) {
    }

    @Override
    public void indicateErrorStatus(int n) {
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((AsiaListener)objectArray[i2]).asiaReceivedErrorStatus(n);
        }
    }

    @Override
    public void indicateTimeout() {
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((AsiaListener)objectArray[i2]).asiaReceivedTimeout();
        }
    }

    @Override
    public void initialized() {
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((AsiaListener)objectArray[i2]).asiaInitialized();
        }
    }

    @Override
    public void receivedBooleanParameter(int n, boolean bl) {
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((AsiaListener)objectArray[i2]).asiaReceivedBooleanParameter(n, bl);
        }
    }

    @Override
    public void receivedCandidates(String[] stringArray) {
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((AsiaListener)objectArray[i2]).asiaReceivedCandidates(stringArray);
        }
    }

    @Override
    public void receivedIntParameter(int n, int n2) {
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((AsiaListener)objectArray[i2]).asiaReceivedIntParameter(n, n2);
        }
    }

    @Override
    public void receivedSegmentation(String string) {
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((AsiaListener)objectArray[i2]).asiaReceivedSegmentation(string);
        }
    }

    @Override
    public void receivedSpelling(String string) {
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((AsiaListener)objectArray[i2]).asiaReceivedSpelling(string);
        }
    }

    @Override
    public void receivedStringParameter(int n, String string) {
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((AsiaListener)objectArray[i2]).asiaReceivedStringParameter(n, string);
        }
    }

    @Override
    public void selectedCandidate(int n) {
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((AsiaListener)objectArray[i2]).asiaSelectedCandidate(n);
        }
    }

    @Override
    public void setAdditionalWordDatabasesResult() {
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((AsiaListener)objectArray[i2]).asiaSetAdditionalWordDatabases();
        }
    }

    @Override
    public void setBooleanParameterResult(int n) {
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((AsiaListener)objectArray[i2]).asiaSetBooleanParameter(n);
        }
    }

    @Override
    public void setIntParameterResult(int n) {
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((AsiaListener)objectArray[i2]).asiaSetIntParameter(n);
        }
    }

    @Override
    public void setStringParameterResult(int n) {
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((AsiaListener)objectArray[i2]).asiaSetStringParameter(n);
        }
    }

    @Override
    public void setUserDatabaseStateResult(int n, int n2) {
        Object[] objectArray = this.listeners.getArray();
        for (int i2 = objectArray.length - 1; i2 >= 0; --i2) {
            ((AsiaListener)objectArray[i2]).asiaSetUserDatabaseState(n, n2);
        }
    }

    void addAsiaListener(AsiaListener asiaListener) {
        this.listeners.addIfNotAlreadyIn(asiaListener);
    }

    void removeAsiaListener(AsiaListener asiaListener) {
        this.listeners.remove(asiaListener);
    }
}

