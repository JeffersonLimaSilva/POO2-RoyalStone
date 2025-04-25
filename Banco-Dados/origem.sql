-- Table: public.Origem

-- DROP TABLE IF EXISTS public."Origem";

CREATE TABLE IF NOT EXISTS public."Origem"
(
    pais "char"[] NOT NULL,
    cidade "char"[] NOT NULL,
    "tipoExtracao" "char"[] NOT NULL,
    "codOrigem" integer NOT NULL,
    CONSTRAINT "Origem_pkey" PRIMARY KEY ("codOrigem")
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Origem"
    OWNER to postgres;