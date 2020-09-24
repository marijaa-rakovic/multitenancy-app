package com.demo.multitenancy.routing.config;

import com.demo.multitenancy.core.ThreadLocalStorage;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

// Uses the Tenant Identifier to identify the database of this tenant
public class TenantAwareRoutingSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return ThreadLocalStorage.getTenantName();
    }
}
