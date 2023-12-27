/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.appadapter.connectivitywlan;

import de.vw.mib.app.appadapter.AbstractAppAdapter;
import de.vw.mib.app.appadapter.AppAdapterSystemServices;
import de.vw.mib.app.appadapter.modelapi.ModelApiService;
import de.vw.mib.appadapter.connectivitywlan.ConnectivityWlanAdapter$1;
import de.vw.mib.appadapter.connectivitywlan.modelapi.InformationModelApiServiceImpl;
import de.vw.mib.cio.CioExecutor;

public class ConnectivityWlanAdapter
extends AbstractAppAdapter {
    final InformationModelApiServiceImpl apiServiceImpl;
    private final ModelApiService[] arrApiServices;

    public ConnectivityWlanAdapter(AppAdapterSystemServices appAdapterSystemServices) {
        super(appAdapterSystemServices);
        this.apiServiceImpl = new InformationModelApiServiceImpl(appAdapterSystemServices);
        this.arrApiServices = new ModelApiService[]{this.apiServiceImpl};
    }

    @Override
    public CioExecutor getCioExecutor() {
        return new ConnectivityWlanAdapter$1(this);
    }

    @Override
    public ModelApiService[] getModelApiServices() {
        return this.arrApiServices;
    }

    @Override
    public void init(int n, String string) {
    }

    @Override
    public void start() {
    }

    @Override
    public void ready() {
    }

    @Override
    public void stop() {
    }

    static /* synthetic */ AppAdapterSystemServices access$000(ConnectivityWlanAdapter connectivityWlanAdapter) {
        return connectivityWlanAdapter.systemServices;
    }

    static /* synthetic */ AppAdapterSystemServices access$100(ConnectivityWlanAdapter connectivityWlanAdapter) {
        return connectivityWlanAdapter.systemServices;
    }
}

