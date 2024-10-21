# Diseño de BD para la plataforma de blogs

Algunos comentarios que deben ser conocidos sobre este diseño de BD:

- La entidad comentario decidí que fuera intercambiada por la entidad user_post_interaction, debido a que esta entidad me permite no generar demasiadas redundancias paramétricas para conocer qué usuario interactuó y comentó una publicación de un blog.
- Se añaden entidades que permitan trazabilidad de los movimientos del usuario en la plataforma.
- Se mantiene un diseño sencillo pero capaz de explotar funcionalidades a máximos.

# Librería

Debido a la no especificación de una arquitectura para realizar la prueba, este proyecto implementa un sistema de gestión de una librería siguiendo la **Arquitectura Hexagonal (Ports and Adapters)**, lo cual nos permite separar las responsabilidades del sistema y hacerlo más flexible y mantenible.

## Arquitectura Hexagonal

La arquitectura hexagonal se utiliza para desacoplar la lógica central de la aplicación (dominio) de las interacciones con el mundo externo (bases de datos, interfaces de usuario, APIs externas, etc.). Esto nos permite:

- Mantener la lógica de negocio independiente de las capas de infraestructura (como bases de datos o frameworks específicos).
- Facilitar el testing, ya que podemos simular fácilmente los "adapters" para probar la lógica del dominio.
- Extender y modificar las partes externas de la aplicación (por ejemplo, cambiar la base de datos de PostgreSQL a MySQL) sin afectar la lógica central.

### Componentes clave:
1. **Dominio**: Contiene las entidades y reglas de negocio puras. Esta capa es completamente independiente de la infraestructura o detalles técnicos.
2. **Aplicación**: Contiene los casos de uso que definen las acciones posibles en el sistema. Esta capa orquesta la lógica de dominio y llama a los "ports" para interactuar con los adaptadores.
3. **Infraestructura (Adapters)**: Provee la implementación técnica para interactuar con la base de datos (y otros sistemas externos). Se encarga de los detalles de cómo almacenar los datos y cómo comunicar con otros sistemas.

### Justificación del Uso de la Arquitectura Hexagonal:
- **Mantenibilidad**: Gracias a esta arquitectura, es sencillo agregar nuevas funcionalidades o cambiar las dependencias de infraestructura (por ejemplo, migrar de PostgreSQL a MySQL) sin afectar el núcleo del sistema.
- **Flexibilidad**: Podemos cambiar los adaptadores de entrada o salida sin cambiar la lógica central del negocio, lo que facilita la adaptación a nuevas tecnologías o requerimientos.
- **Testabilidad**: Al estar la lógica de negocio separada de la infraestructura, las pruebas unitarias y de integración se simplifican, ya que podemos testear el dominio de manera aislada.

## Requisitos para ejecutar la aplicación

1. **Docker**: Asegúrate de tener Docker instalado en tu máquina.
2. **Docker Compose**: La aplicación utiliza un contenedor de PostgreSQL como base de datos, por lo que es necesario usar Docker Compose para iniciar la infraestructura necesaria.
