-- Create the SubscriptionPlan table
CREATE TABLE subscription_plans (
    id BIGSERIAL NOT NULL,
    name VARCHAR NOT NULL,
    price NUMERIC(38, 2) NOT NULL,
    property_limit INT NOT NULL,
    image_per_property_limit INT NOT NULL,
    features TEXT NOT NULL,
    CONSTRAINT SubscriptionPlan_pkey PRIMARY KEY (id)
);

-- Create the Subscriptions table
CREATE TABLE subscriptions (
    id BIGSERIAL NOT NULL,
    payment_id VARCHAR NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    plan_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    CONSTRAINT Subscriptions_pkey PRIMARY KEY (id),
    CONSTRAINT Subscriptions_planId_fkey FOREIGN KEY (plan_id) REFERENCES subscription_plans(id),
    CONSTRAINT Subscriptions_userId_fkey FOREIGN KEY (user_id) REFERENCES Users(id)
);
