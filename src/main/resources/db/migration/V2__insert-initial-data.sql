-- Insertar un perfil/rol basico
INSERT INTO perfil(nombre) VALUES('ROLE_USER');

-- Insertar nuestro usuario de prueba con la contraseña ya codificada
-- La contraseña en texto plano es "123456"
-- En su archivo V2__insert-initial-data.sql

INSERT INTO usuario(nombre, correo_electronico, contrasena) VALUES('Test User', 'test.user@forohub.com', '$2a$10$aMtb2agOXw6dby2NX1YlzeqykxV8VI4LsgjQuxY8Wb6sopK0utVWO');

-- Asignar el perfil al usuario
INSERT INTO usuario_perfil(usuario_id, perfil_id) VALUES(1, 1);

-- ... (inserciones de perfil y usuario que ya tiene) ...

-- AÑADIR ESTA LÍNEA SI NO EXISTE
INSERT INTO curso(nombre, categoria) VALUES('Programación con Spring Boot', 'DESARROLLO');