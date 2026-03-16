# TESTING (Caja negra) — Clase Empleado

Objetivo: validar los tres atributos de Empleado mediante pruebas de caja negra:
- nombre
- cargo
- salario

Convenio salarial definido para las pruebas: 15000 (valor mínimo aceptable).

Criterios de aceptación
- Nombre: no vacío; contiene al menos dos palabras (dos tokens separados por espacio).
- Cargo: debe pertenecer a la lista de cargos gestionada por la clase Cargos (comparación case-insensitive).
- Salario: valor numérico provisto; no negativo; no inferior al salario de convenio (>= 15000).

Técnicas usadas: particiones de equivalencia y análisis de valores límite (BVA).

---

## 1) Análisis de parámetros (particiones)

| Parámetro | Tipo | Dominio válido | Restricciones / criterio de aceptación | Particiones válidas | Particiones inválidas |
|---|---:|---|---|---|---|
| nombre | String | Cadenas de texto | No vacío; al menos 2 palabras separadas por espacio | >1 palabra; contiene letras (p.ej. "Ana María") | Vacío ""; 1 palabra ("Juan"); null; solo espacios |
| cargo | String | Elemento del conjunto definido en Cargos (Desarrollador, Diseñadora, Gerente) | Coincidir con alguno de los cargos (case-insensitive) | Nombre exacto o distinto case (p.ej. "desarrollador") | Texto no listado ("Dev", "GerenteX"); null; cadena vacía |
| salario | double | Números reales | Proporcionado; >= 0; >= convenio (15000) | >=15000 (incluido) | <15000; negativo; NaN (si aplicable); no proporcionado |

---

## 2) Casos válidos (deben aceptarse / crear Empleado correctamente)

| ID | Nombre | Cargo | Salario | Resultado esperado |
|---:|---|---|---:|---|
| V1 | "Juan Pérez" | "Desarrollador" | 50000.00 | Aceptado; empleado creado; salario ajustable |
| V2 | "María López" | "diseñadora" (minúsculas) | 45000.00 | Aceptado (case-insensitive); empleado creado |
| V3 | "Ana María" | "Gerente" | 15000.00 | Aceptado (igual convenio) |
| V4 | "José Luis García" | "Gerente" | 15000.01 | Aceptado (justo por encima del convenio) |
| V5 | "  Luis Gómez  " (con espacios alrededor) | "Desarrollador" | 20000.00 | Aceptado (debería tolerarse/trim); empleado creado |

Notas: para V5 se espera que la validación realice trim o acepte espacios extra; si no, documentar comportamiento.

---

## 3) Casos no válidos (deben rechazarse / producir error o no crear)

| ID | Nombre | Cargo | Salario | Defecto esperado / Mensaje |
|---:|---|---|---:|---|
| I1 | "" (cadena vacía) | "Desarrollador" | 20000.00 | Rechazado: nombre vacío |
| I2 | "Juan" (una sola palabra) | "Desarrollador" | 20000.00 | Rechazado: nombre no contiene al menos dos palabras |
| I3 | "María López" | "Dev" | 30000.00 | Rechazado: cargo no válido (no está en Cargos) |
| I4 | "Pedro Martínez" | "Desarrolador" (typo) | 40000.00 | Rechazado: cargo inválido (ortografía incorrecta) |
| I5 | "Ana Ruiz" | "Gerente" | -1000.00 | Rechazado: salario negativo |
| I6 | "Luis Campos" | "Diseñadora" | 10000.00 | Rechazado: salario por debajo del convenio (10000 < 15000) |
| I7 | null | "Desarrollador" | 20000.00 | Rechazado: nombre nulo |
| I8 | "Sofía Martín" | null | 20000.00 | Rechazado: cargo nulo |
| I9 | "Carlos Díaz" | "Gerente" | NaN (no-numérico) | Rechazado: salario no válido (NaN) |
| I10 | " " (solo espacios) | "Desarrollador" | 20000.00 | Rechazado: nombre considerado vacío |

---