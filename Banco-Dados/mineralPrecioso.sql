-- Table: public.mineralPrecioso

-- DROP TABLE IF EXISTS public."mineralPrecioso";

CREATE TABLE IF NOT EXISTS public."mineralPrecioso"
(
    certificado "char"[] NOT NULL,
    refinamento "char"[] NOT NULL,
    "codMP" integer NOT NULL,
    CONSTRAINT "mineralPrecioso_pkey" PRIMARY KEY ("codMP")
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."mineralPrecioso"
    OWNER to postgres;