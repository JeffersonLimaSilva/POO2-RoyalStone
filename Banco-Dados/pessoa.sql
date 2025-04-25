-- Table: public.Pessoa

-- DROP TABLE IF EXISTS public."Pessoa";

CREATE TABLE IF NOT EXISTS public."Pessoa"
(
    nome "char"[] NOT NULL,
    cpf "char"[] NOT NULL,
    "dataNasc" date NOT NULL,
    telefone integer NOT NULL,
    email "char"[] NOT NULL,
    senha "char"[] NOT NULL,
    endereco "char"[] NOT NULL,
    CONSTRAINT "Pessoa_pkey" PRIMARY KEY (cpf)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."Pessoa"
    OWNER to postgres;