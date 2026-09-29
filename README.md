# 📘 Agenda de Contactos en Java

Una aplicación de consola robusta desarrollada en **Java** que permite gestionar una agenda telefónica con un límite de almacenamiento configurable. El proyecto implementa la búsqueda, el ordenamiento alfabético, y validaciones estrictas para evitar registros duplicados o incompletos.

---

## ✨ Funcionalidades Principales

El sistema expone una interfaz de menú por consola con las siguientes opciones:

1. **Añadir Contacto (`añadirContacto`)**: Agrega un nuevo registro validando que los campos obligatorios no estén vacíos, que haya espacio disponible y que no exista un duplicado (mismo nombre y apellido).
2. **Verificar Existencia (`existeContacto`)**: Comprueba de forma automática si una persona ya se encuentra registrada en el sistema.
3. **Listar Contactos (`listarContactos`)**: Muestra la lista completa ordenada de forma alfabética, por nombre y apellido con el formato `Nombre Apellido - Teléfono`.
4. **Buscar Contacto (`buscaContacto`)**: Localiza a una persona por sus criterios de identidad y extrae su número telefónico.
5. **Eliminar Contacto (`eliminarContacto`)**: Remueve permanentemente a un usuario notificando si la operación fue exitosa.
6. **Modificar Teléfono (`modificarTelefono`)**: Actualiza el número de contacto de un registro existente.
7. **Estado de Capacidad (`agendaLlena` / `espacioLibres`)**: Monitorea el espacio disponible con base en el límite máximo de memoria definido.

---

## 🛠️ Requisitos Técnicos y Reglas de Negocio

Para asegurar el comportamiento esperado del sistema, las clases base deben cumplir con los siguientes lineamientos de diseño de software en Java:

* **Validación de Identidad:** Dos contactos se consideran iguales si coinciden exactamente en **Nombre** y **Apellido**, sin importar que tengan teléfonos distintos. Para lograr esto de forma nativa en Java, la clase `Contacto` debe sobrescribir obligatoriamente los métodos `equals()` y `hashCode()`.
* **Ordenamiento Alfabético:** La visualización de los contactos requiere un orden estructurado. La clase `Contacto` debe implementar la interfaz `Comparable<Contacto>`.
* **Reglas de Campos:** No se permiten inserciones con cadenas vacías u omitidas en las propiedades de identidad (`Nombre` o `Apellido`).

---

## 🚀 Instrucciones de Ejecución

### 1. Clonar el repositorio
```bash
git clone git@github.com:velazquez-diego-ant/Agenda-Telefonica-CH71.git
cd Agenda-Telefonica-CH71
```

### 2. Compilar los archivos de origen
Asegúrate de tener instalado el **JDK 8 o superior** en tu entorno de desarrollo.
```bash
javac Main.java Agenda.java Contacto.java InvalidData.java
```

### 3. Ejecutar la aplicación
```bash
java Main
```

---
