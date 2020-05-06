CREATE TABLE public.products
(
    id_product bigint NOT NULL,
    acquisition_value numeric(19,2) NOT NULL,
    active boolean NOT NULL,
    amount integer NOT NULL,
    dat_acquisition timestamp without time zone,
    dat_creation timestamp without time zone,
    description character varying(255) COLLATE pg_catalog."default",
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    product_type character varying(50) COLLATE pg_catalog."default" NOT NULL,
    unitary_value numeric(19,2) NOT NULL,
    CONSTRAINT products_pkey PRIMARY KEY (id_product)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.products
    OWNER to postgres;

insert into products (ID_PRODUCT, NAME, AMOUNT, UNITARY_VALUE, ACQUISITION_VALUE, ACTIVE, PRODUCT_TYPE)
values(1, 'TV', 10, 1000, 500, TRUE, 'ELECTRONICS'),
      (2, 'Radio', 5, 100, 50, TRUE, 'ELECTRONICS'),
      (3, 'Alexa', 15, 650, 150, TRUE,'ELECTRONICS');