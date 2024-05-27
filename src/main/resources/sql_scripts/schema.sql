-- Table: tb_products
CREATE TABLE IF NOT EXISTS tb_products (
    id UUID NOT NULL,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    price NUMERIC(38, 2) NOT NULL,
    category SMALLINT NOT NULL,
    imageurl VARCHAR(255) NOT NULL,
    CONSTRAINT tb_products_pkey PRIMARY KEY (id)
);

-- Table: tb_clients
CREATE TABLE IF NOT EXISTS tb_clients (
    id UUID NOT NULL,
    name VARCHAR(255) NOT NULL,
    cpf VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    CONSTRAINT tb_clients_pkey PRIMARY KEY (id),
    CONSTRAINT tb_clients_cpf_key UNIQUE (cpf),
    CONSTRAINT tb_clients_email_key UNIQUE (email)
);

-- Table: tb_orders
CREATE TABLE IF NOT EXISTS tb_orders (
    id UUID NOT NULL,
    name VARCHAR(255) NOT NULL,
    status INTEGER NOT NULL,
    is_anonymous BOOLEAN,
    client_id UUID,
    creation_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    last_update_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT tb_orders_pkey PRIMARY KEY (id),
    CONSTRAINT fk_order_client FOREIGN KEY (client_id)
        REFERENCES tb_clients (id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

-- Table: tb_order_items
CREATE TABLE IF NOT EXISTS tb_order_items (
    description VARCHAR(255),
    quantity INTEGER NOT NULL,
    order_id UUID NOT NULL,
    product_id UUID NOT NULL,
    CONSTRAINT tb_order_items_pkey PRIMARY KEY (order_id, product_id),
    CONSTRAINT fk_order_item_order FOREIGN KEY (order_id)
        REFERENCES tb_orders (id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_order_item_product FOREIGN KEY (product_id)
        REFERENCES tb_products (id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);