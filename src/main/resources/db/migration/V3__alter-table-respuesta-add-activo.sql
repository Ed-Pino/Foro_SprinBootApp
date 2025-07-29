ALTER TABLE respuesta ADD COLUMN activo BOOLEAN;
UPDATE respuesta SET activo = TRUE;