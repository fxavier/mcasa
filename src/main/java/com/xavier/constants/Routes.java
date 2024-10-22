package com.xavier.constants;

public final class Routes {

    /**
     * Country routes
     */

    public static final String COUNTRIES = "/api/v1/countries";
    public static final String COUNTRY = "/{id}";


    /**
     * Business type routes
     */
    public static final String BUSINESS_TYPES = "/api/v1/business-types";
    public static final String BUSINESS_TYPE = "/{id}";
    public static final String BUSINESS_TYPE_BY_DESCRIPTION = "/{description}";

    /**
     * Currency routes
     */

    public static final String CURRENCIES = "/api/v1/currencies";
    public static final String CURRENCY = "/{id}";
    public static final String CURRENCY_BY_NAME = "/{name}";

    /**
     * User routes
     */

    public static final String USERS = "/api/v1/users";
    public static final String USER = "/{id}";
    public static final String USER_BY_EMAIL = "/{email}";



}
