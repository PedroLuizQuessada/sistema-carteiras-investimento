INSERT IGNORE INTO usuarios (email, senha) VALUES ("email_1@empresa.com.br", "$2a$10$4ggZV7iqCcAif/KVJwLWQO2fKZdoOWG2689.s4I/HU/TjUwDs3hbG");
INSERT IGNORE INTO usuarios (email, senha) VALUES ("email_2@empresa.com.br", "$2a$10$4ggZV7iqCcAif/KVJwLWQO2fKZdoOWG2689.s4I/HU/TjUwDs3hbG");
INSERT IGNORE INTO roles (nome) VALUES ("ADMIN");
INSERT IGNORE INTO usuario_role (usuario_id, role_id) VALUES (1, 1);
INSERT IGNORE INTO moedas (nome, simbolo) VALUES ("Real", "R$");
INSERT IGNORE INTO moedas (nome, simbolo) VALUES ("Dólar americano", "$");
INSERT IGNORE INTO moedas (nome, simbolo) VALUES ("Peso argentino", "$");
INSERT IGNORE INTO acoes (nome, origem) VALUES ("Petrobrás", "BRA");
INSERT IGNORE INTO acoes (nome, origem) VALUES ("Vale", "BRA");
INSERT IGNORE INTO acoes (nome, origem) VALUES ("Amazon", "USA");
INSERT IGNORE INTO acoes (nome, origem) VALUES ("Meli", "ARG");