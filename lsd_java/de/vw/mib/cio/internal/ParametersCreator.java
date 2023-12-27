/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.cio.internal;

import de.vw.mib.cio.CioActionParameters;
import de.vw.mib.cio.CioIntent;
import de.vw.mib.cio.CioParametersCreator;
import de.vw.mib.cio.CioPayload;
import de.vw.mib.cio.internal.Parameters;

final class ParametersCreator
implements CioParametersCreator {
    private final Parameters parameters = new Parameters();

    ParametersCreator() {
    }

    @Override
    public CioActionParameters finishActionParams() {
        if (!this.validate()) {
            return null;
        }
        return this.parameters;
    }

    @Override
    public CioPayload finishPayload() {
        return this.parameters;
    }

    @Override
    public CioActionParameters finish() {
        return this.finishActionParams();
    }

    @Override
    public CioParametersCreator setBoolean(String string, boolean bl) {
        this.parameters.setBoolean(string, bl);
        return this;
    }

    @Override
    public CioParametersCreator setCioIntent(String string, CioIntent cioIntent) {
        this.parameters.setCioIntent(string, cioIntent);
        return this;
    }

    @Override
    public CioParametersCreator setFloat(String string, float f2) {
        this.parameters.setFloat(string, f2);
        return this;
    }

    @Override
    public CioParametersCreator setInt(String string, int n) {
        this.parameters.setInt(string, n);
        return this;
    }

    @Override
    public CioParametersCreator setLong(String string, long l) {
        this.parameters.setLong(string, l);
        return this;
    }

    @Override
    public CioParametersCreator setObject(String string, Object object) {
        this.parameters.setObject(string, object);
        return this;
    }

    @Override
    public CioParametersCreator setString(String string, String string2) {
        this.parameters.setString(string, string2);
        return this;
    }

    private boolean validate() {
        return true;
    }
}

