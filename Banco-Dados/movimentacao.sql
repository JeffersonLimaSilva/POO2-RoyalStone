-- Table: public.movimentacao

-- DROP TABLE IF EXISTS public.movimentacao;

CREATE TABLE IF NOT EXISTS public.movimentacao
(
    valor double precision NOT NULL,
    data date NOT NULL,
    joia "char"[] NOT NULL,
    cliente "char"[] NOT NULL,
    "codMovimentacao" integer NOT NULL,
    CONSTRAINT movimentacao_pkey PRIMARY KEY ("codMovimentacao")
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.movimentacao
    OWNER to postgres;