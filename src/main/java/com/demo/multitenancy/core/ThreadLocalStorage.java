package com.demo.multitenancy.core;

//The ThreadLocalStorage class wraps a ThreadLocal to store the Tenant data in the current thread context.
public class ThreadLocalStorage {

    private static ThreadLocal<String> tenant = new ThreadLocal<>();

    public static void setTenantName(String tenantName) {
        tenant.set(tenantName);
    }

    public static String getTenantName() {
        return tenant.get();
    }
}
