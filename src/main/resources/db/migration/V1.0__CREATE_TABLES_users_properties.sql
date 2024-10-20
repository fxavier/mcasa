
CREATE TABLE business_types (
	id BIGSERIAL NOT NULL,
	description varchar NULL,
	CONSTRAINT business_types_pkey PRIMARY KEY (id),
	CONSTRAINT business_types_description_key UNIQUE (description)
);

CREATE TABLE countries (
    id BIGSERIAL NOT NULL,
    name varchar NULL,
    CONSTRAINT countries_pkey PRIMARY KEY (id),
    CONSTRAINT countries_name_key UNIQUE (name)
);

CREATE TABLE currencies (
    id BIGSERIAL NOT NULL,
    name varchar NULL,
	code varchar NULL,
    CONSTRAINT currencies_pkey PRIMARY KEY (id),
    CONSTRAINT currencies_name_key UNIQUE (name),
	CONSTRAINT currencies_code_key UNIQUE (code)
);

CREATE TABLE Users (
	id BIGSERIAL NOT NULL,
	first_name varchar NULL,
	last_name varchar NULL,
	email varchar NULL,
	password varchar NULL,
	created_at timestamp DEFAULT CURRENT_TIMESTAMP,
	updated_at timestamp DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT users_pkey PRIMARY KEY (id)
);

CREATE TABLE user_profiles (
    id BIGSERIAL NOT NULL,
    user_id BIGINT NOT NULL,
    date_of_birth DATE NULL,
    address VARCHAR NULL,
    phone_number VARCHAR NULL,
	email VARCHAR NOT NULL,
    bio TEXT NULL,
    profile_picture_url VARCHAR NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT users_profile_pkey PRIMARY KEY (id),
    CONSTRAINT user_profiles_user_id_fkey FOREIGN KEY (user_id) REFERENCES Users(id)
);


CREATE TABLE property_types (
    id BIGSERIAL NOT NULL,
    description varchar NULL,
    CONSTRAINT property_types_pkey PRIMARY KEY (id),
    CONSTRAINT property_types_description_key UNIQUE (description)
);


CREATE TABLE properties (
    id BIGSERIAL NOT NULL,
	name varchar NOT NULL,
	description varchar NOT NULL,
	price NUMERIC(38, 2) NOT NULL,
	property_type_id BIGINT NOT NULL,
	business_type_id BIGINT NOT NULL,
	user_id BIGINT NOT NULL,
	property_status VARCHAR NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT properties_pkey PRIMARY KEY (id),
    CONSTRAINT properties_property_type_id_fkey FOREIGN KEY (property_type_id) REFERENCES property_types(id),
    CONSTRAINT properties_business_type_id_fkey FOREIGN KEY (business_type_id) REFERENCES business_types(id),
    CONSTRAINT properties_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE property_features (
    id BIGSERIAL NOT NULL,
    description VARCHAR(255) NOT NULL,
	bedrooms INT NOT NULL,
	bathrooms INT NOT NULL,
	diningrooms INT NOT NULL,
	kitchens INT NULL,
	sittingrooms INT NULL,
	wifi INT NULL,
	parking INT NULL,
	swimming_pool INT NULL,
	gym INT NULL,
	balcony INT NULL,
	area NUMERIC(38, 2) NULL,
	property_id BIGINT NOT NULL,
    CONSTRAINT property_features_pkey PRIMARY KEY (id),
    CONSTRAINT property_features_property_id_fkey FOREIGN KEY (property_id) REFERENCES properties(id),
    CONSTRAINT property_features_description_key UNIQUE (description)
);

CREATE TABLE property_images (
    id BIGSERIAL NOT NULL,
    image_url VARCHAR NOT NULL,
	is_cover bool NULL,
    property_id BIGINT NOT NULL,
    CONSTRAINT property_images_pkey PRIMARY KEY (id),
    CONSTRAINT property_images_property_id_fkey FOREIGN KEY (property_id) REFERENCES properties(id)
);

CREATE TABLE property_locations (
    id BIGSERIAL NOT NULL,
	city VARCHAR(255) NULL,
	state VARCHAR(255) NULL,
	zip_code VARCHAR(255) NULL,
	address VARCHAR(255) NULL,
	latitude float8 NULL,
	longitude float8 NULL,
	country_id BIGINT NULL,
    property_id BIGINT NOT NULL,
    CONSTRAINT property_locations_pkey PRIMARY KEY (id),
    CONSTRAINT property_locations_property_id_fkey FOREIGN KEY (property_id) REFERENCES properties(id),
    CONSTRAINT property_locations_country_id_fkey FOREIGN KEY (country_id) REFERENCES countries(id)
);

