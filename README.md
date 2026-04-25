# PetroStackCasanare
Nombre: Michell Tatiana Cruz Parra 
codigo: 1118530054 
Asignatura: Algoritmos II
fecha: 24/04/2026

Descripcion: PetroStack Casanare es una aplicación desarrollada en Java que permite gestionar eventos de inspección en pozos petroleros ubicados en diferentes municipios del departamento de Casanare.
El sistema registra eventos como fugas, mantenimientos, lecturas de presión y cierres de turno, generados por cuadrillas de campo durante sus operaciones. Cada evento contiene información relevante como el código del pozo, municipio, tipo de evento, descripción y fecha-hora. La aplicación permite almacenar, consultar, retirar y listar eventos, siguiendo una lógica eficiente para la gestión operativa. Además, incluye la funcionalidad de deshacer acciones, lo cual resulta fundamental en entornos donde se requiere control y trazabilidad de la información.

Justificacion: El uso de una pila es ideal para modelar este sistema debido a la naturaleza de los eventos de inspección. En el contexto operativo de PetroStack Casanare, el último evento registrado suele ser el más reciente y, por tanto, el más urgente de revisar. Esto implica que el sistema debe priorizar el último evento ingresado, lo cual coincide perfectamente con el comportamiento de una pila. Al utilizar esta estructura, se garantiza que las operaciones de revisión (peek) y retiro (pop) siempre se realicen sobre el evento más reciente.
Adicionalmente, la implementación de una segunda pila permite gestionar la funcionalidad de deshacer (Undo), lo que refuerza la confiabilidad del sistema al permitir revertir acciones recientes sin pérdida de información.
