-- Table: public.Endereco

-- DROP TABLE IF EXISTS public."Endereco";

CREATE TABLE IF NOT EXISTS public."Endereco"
(
    rua "char"[],
    cidade "char"[],
    cep integer[] NOT NULL,
    CONSTRAINT "Endereco_pkey" PRIMARY KEY (cep)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Endereco"
    OWNER to postgres;