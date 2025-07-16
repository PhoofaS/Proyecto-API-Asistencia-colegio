-- Seleccionar la base de datos para usar
USE AsistenciaDB;

-- Tabla de Usuarios
CREATE TABLE Usuario (
    UsuarioID INT AUTO_INCREMENT PRIMARY KEY,
    DocumentoIdentidad VARCHAR(20) NOT NULL UNIQUE,
    NombreCompleto VARCHAR(100) NOT NULL,
    Contrasena VARCHAR(100) NOT NULL,
    EsAdministrador BOOLEAN NOT NULL DEFAULT FALSE
);

-- Tabla de Alumnos (usuarios sin administración)
CREATE TABLE Alumno (
    AlumnoID INT PRIMARY KEY,
    FOREIGN KEY (AlumnoID) REFERENCES Usuario(UsuarioID),
    Nombre VARCHAR(50) NOT NULL DEFAULT '',
    Apellido VARCHAR(50) NOT NULL DEFAULT ''
);

-- Tabla de Profesores (usuarios con administración)
CREATE TABLE Profesor (
    ProfesorID INT PRIMARY KEY,
    FOREIGN KEY (ProfesorID) REFERENCES Usuario(UsuarioID),
    Nombre VARCHAR(50) NOT NULL DEFAULT '',
    Apellido VARCHAR(50) NOT NULL DEFAULT '',
    CorreoElectronico VARCHAR(100) NULL,
    Telefono VARCHAR(20) NULL
);

-- Tabla de Cursos
CREATE TABLE Curso (
    CursoID INT AUTO_INCREMENT PRIMARY KEY,
    NombreCurso VARCHAR(100) NOT NULL
);

-- Tabla de Salones
CREATE TABLE Salon (
    SalonID INT AUTO_INCREMENT PRIMARY KEY,
    NombreSalon VARCHAR(50) NOT NULL
);

-- Tabla de asignación de Cursos a Salones con Profesores
CREATE TABLE CursoSalon (
    CursoSalonID INT AUTO_INCREMENT PRIMARY KEY,
    CursoID INT NOT NULL,
    SalonID INT NOT NULL,
    ProfesorID INT NOT NULL,
    FechaAsignacion DATE NOT NULL,
    FOREIGN KEY (CursoID) REFERENCES Curso(CursoID),
    FOREIGN KEY (SalonID) REFERENCES Salon(SalonID),
    FOREIGN KEY (ProfesorID) REFERENCES Profesor(ProfesorID),
    UNIQUE (CursoID, SalonID, FechaAsignacion)
);

-- Tabla de alumnos inscritos en cursos
CREATE TABLE AlumnoCurso (
    AlumnoCursoID INT AUTO_INCREMENT PRIMARY KEY,
    AlumnoID INT NOT NULL,
    CursoID INT NOT NULL,
    FOREIGN KEY (AlumnoID) REFERENCES Alumno(AlumnoID),
    FOREIGN KEY (CursoID) REFERENCES Curso(CursoID),
    UNIQUE (AlumnoID, CursoID)
);

-- Tabla de asistencias
CREATE TABLE Asistencia (
    AsistenciaID INT AUTO_INCREMENT PRIMARY KEY,
    UsuarioID INT NOT NULL,
    CursoSalonID INT NOT NULL,
    Fecha DATE NOT NULL,
    HoraRegistro TIME NOT NULL,
    FOREIGN KEY (UsuarioID) REFERENCES Usuario(UsuarioID),
    FOREIGN KEY (CursoSalonID) REFERENCES CursoSalon(CursoSalonID),
    UNIQUE (UsuarioID, CursoSalonID, Fecha)
);





use asistenciadb;

INSERT INTO Usuario (DocumentoIdentidad, NombreCompleto, Contrasena, EsAdministrador)
VALUES 
('12345678', 'Carlos Martínez', 'pass123', FALSE),
('23456789', 'Ana Gómez', 'pass456', FALSE),
('34567890', 'Luis Pérez', 'pass789', TRUE),
('45678901', 'María Ríos', 'passabc', TRUE);


INSERT INTO Alumno (AlumnoID, Nombre, Apellido)
VALUES
(1, 'Carlos', 'Martínez'),
(2, 'Ana', 'Gómez');


INSERT INTO Profesor (ProfesorID, Nombre, Apellido, CorreoElectronico, Telefono)
VALUES
(3, 'Luis', 'Pérez', 'lperez@colegio.edu', '123456789'),
(4, 'María', 'Ríos', 'mrios@colegio.edu', '987654321');


INSERT INTO Curso (NombreCurso)
VALUES
('Matemáticas'),
('Lengua Española'),
('Ciencias Naturales');


INSERT INTO Salon (NombreSalon)
VALUES
('Salón 101'),
('Salón 102');


INSERT INTO CursoSalon (CursoID, SalonID, ProfesorID, FechaAsignacion)
VALUES
(1, 1, 3, '2025-07-01'), -- Matemáticas en Salón 101 con Luis Pérez
(2, 2, 4, '2025-07-01'); -- Lengua Española en Salón 102 con María Ríos


INSERT INTO AlumnoCurso (AlumnoID, CursoID)
VALUES
(1, 1), -- Carlos en Matemáticas
(2, 1), -- Ana en Matemáticas
(2, 2); -- Ana en Lengua Española


INSERT INTO Asistencia (UsuarioID, CursoSalonID, Fecha, HoraRegistro)
VALUES
(1, 1, '2025-07-08', '08:01:00'), -- Carlos asistió a Matemáticas
(2, 1, '2025-07-08', '08:03:00'), -- Ana asistió a Matemáticas
(2, 2, '2025-07-08', '10:00:00'), -- Ana asistió a Lengua Española
(3, 1, '2025-07-08', '07:50:00'), -- Profesor Luis Pérez registró entrada
(4, 2, '2025-07-08', '09:55:00'); -- Profesora María Ríos registró entrada