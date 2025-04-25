-- Table: public.Joia

-- DROP TABLE IF EXISTS public."Joia";

CREATE TABLE IF NOT EXISTS public."Joia"
(
    "valorVenda" double precision NOT NULL,
    "codJoia" integer NOT NULL,
    CONSTRAINT "Joia_pkey" PRIMARY KEY ("codJoia")
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Joia"
    OWNER to postgres;