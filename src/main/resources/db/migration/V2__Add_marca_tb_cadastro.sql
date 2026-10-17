-- V2: Migrations para adicionar a coluna de MARCA na tabela de cadastros

ALTER TABLE tb_cadastro
ADD COLUMN marca VARCHAR(255);