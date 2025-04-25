-- Table: public.Mineral

-- DROP TABLE IF EXISTS public."Mineral";

CREATE TABLE IF NOT EXISTS public."Mineral"
(
    "nomeMineral" "char"[] NOT NULL,
    "compQuimica" "char"[] NOT NULL,
    dureza integer NOT NULL,
    peso double precision NOT NULL,
    "valorComercial" double precision NOT NULL,
    "Origem" "char"[] NOT NULL,
    "codMineral" integer NOT NULL,
    CONSTRAINT "Mineral_pkey" PRIMARY KEY ("codMineral")
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Mineral"
    OWNER to postgres;