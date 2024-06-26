package com.ejercicios; // Definición del paquete

import java.util.Collections; // Importación de la clase Collections
import java.util.Comparator; // Importación de la clase Comparator
import java.util.List; // Importación de la clase List
import java.util.Map; // Importación de la clase Map

public class Operaciones { // Declaración de la clase Operaciones

    public static void ordenarTurnos(Map<String, List<String>> turnosPorEspecialidad) { // Método para ordenar turnos por horario dentro de cada especialidad
        for (List<String> turnos : turnosPorEspecialidad.values()) { // Itera sobre cada lista de turnos en el mapa
            Collections.sort(turnos, new Comparator<String>() { // Ordena la lista de turnos
                @Override
                public int compare(String t1, String t2) { // Define el método de comparación
                    String horario1 = t1.split(" - ")[1].replace("hs", "").trim(); // Extrae y limpia el horario del primer turno
                    String horario2 = t2.split(" - ")[1].replace("hs", "").trim(); // Extrae y limpia el horario del segundo turno
                    return horario1.compareTo(horario2); // Compara los horarios
                }
            });
        }
    }

    public static void imprimirTurnosPorEspecialidad(Map<String, List<String>> turnosPorEspecialidad) { // Método para imprimir turnos por especialidad
        for (String especialidadPaciente : turnosPorEspecialidad.keySet()) { // Itera sobre cada especialidad en el mapa
            System.out.println(especialidadPaciente + ":"); // Imprime el nombre de la especialidad
            for (String turno : turnosPorEspecialidad.get(especialidadPaciente)) { // Itera sobre cada turno de la especialidad
                System.out.println(turno); // Imprime el turno
            }
            System.out.println(); // Agrega una línea en blanco después de cada especialidad para una mejor visualización
        }
    }

    public static void imprimirTurnosConDetalles(Map<String, List<String>> turnosPorEspecialidad, Map<String, Integer> consultorios, Map<String, String> especialistas) { // Método para imprimir turnos con detalles de consultorio y especialista
        for (String especialidadPaciente : turnosPorEspecialidad.keySet()) { // Itera sobre cada especialidad en el mapa
            Integer consultorio = consultorios.get(especialidadPaciente); // Obtiene el número de consultorio
            String especialista = especialistas.get(especialidadPaciente); // Obtiene el nombre del especialista
            System.out.println(especialidadPaciente + " - Consultorio " + consultorio + " Especialista " + especialista + ":"); // Imprime el nombre de la especialidad, número de consultorio y nombre del especialista
            for (String turno : turnosPorEspecialidad.get(especialidadPaciente)) { // Itera sobre cada turno de la especialidad
                System.out.println(turno); // Imprime el turno
            }
            System.out.println(); // Agrega una línea en blanco después de cada especialidad para una mejor visualización
        }
    }

    public static void imprimirCantidadDePacientes(Map<String, Integer> pacientesPorEspecialidad) { // Método para imprimir la cantidad de pacientes por especialidad
        for (String especialidadPaciente : pacientesPorEspecialidad.keySet()) { // Itera sobre cada especialidad en el mapa
            System.out.println(especialidadPaciente + ": " + pacientesPorEspecialidad.get(especialidadPaciente) + " pacientes."); // Imprime el nombre de la especialidad y la cantidad de pacientes
        }
    }
}

    


