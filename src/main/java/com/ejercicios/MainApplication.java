package com.ejercicios; // Definición del paquete

import java.util.ArrayList; // Importación de la clase ArrayList
import java.util.HashMap; // Importación de la clase HashMap
import java.util.List; // Importación de la clase List
import java.util.Map; // Importación de la clase Map

public class MainApplication { // Declaración de la clase principal

    public static void main(String[] args) { // Método main, punto de entrada del programa

        // Mapas para almacenar los datos
        Map<Integer, String> carnetNombre = new HashMap<>(); // Mapa para nombres de pacientes por carnet
        Map<Integer, String> especialidad = new HashMap<>(); // Mapa para especialidades por carnet
        Map<Integer, String> horario = new HashMap<>(); // Mapa para horarios de citas por carnet
        Map<String, Integer> consultorios = new HashMap<>(); // Mapa para números de consultorios por especialidad
        Map<String, String> especialistas = new HashMap<>(); // Mapa para nombres de especialistas por especialidad
        Map<String, List<String>> turnosPorEspecialidad = new HashMap<>(); // Mapa para turnos por especialidad
        Map<String, Integer> pacientesPorEspecialidad = new HashMap<>(); // Mapa para cantidad de pacientes por especialidad

        // Llenar los mapas con los datos proporcionados
        llenarMapas(carnetNombre, especialidad, horario, consultorios, especialistas); // Llama a método para llenar los mapas

        // Llenar el mapa de turnos por especialidad y contar pacientes por especialidad
        procesarTurnos(carnetNombre, especialidad, horario, turnosPorEspecialidad, pacientesPorEspecialidad); // Procesa turnos y cuenta pacientes

        // Ordenar los turnos por horario dentro de cada especialidad
        Operaciones.ordenarTurnos(turnosPorEspecialidad); // Llama a método para ordenar turnos por horario

        // Imprimir los turnos agrupados por especialidad
        Operaciones.imprimirTurnosPorEspecialidad(turnosPorEspecialidad); // Llama a método para imprimir turnos por especialidad

        // Imprimir los turnos agrupados por especialidad con consultorio y especialista
        Operaciones.imprimirTurnosConDetalles(turnosPorEspecialidad, consultorios, especialistas); // Llama a método para imprimir turnos con detalles

        // Imprimir la cantidad de pacientes por especialidad
        Operaciones.imprimirCantidadDePacientes(pacientesPorEspecialidad); // Llama a método para imprimir cantidad de pacientes por especialidad
    }

    public static void llenarMapas(Map<Integer, String> carnetNombre, Map<Integer, String> especialidad, Map<Integer, String> horario, 
                                    Map<String, Integer> consultorios, Map<String, String> especialistas) { // Método para llenar mapas con datos

        // Llenando el mapa de nombres por carnet
        carnetNombre.put(12345, "Juan Perez"); 
        carnetNombre.put(23451, "Ana Lisa Sosa");
        carnetNombre.put(34512, "Debora Lopez");
        carnetNombre.put(45123, "Carlos Marquez");
        carnetNombre.put(54321, "Marcelo Diaz");
        carnetNombre.put(21345, "Carmen Salcedo");
        carnetNombre.put(32145, "Juan Carrillo");
        carnetNombre.put(43125, "Elvio Garcia");
        carnetNombre.put(31245, "Rocio Gomez");
        carnetNombre.put(52341, "Gonzalo Paez");

        // Llenando el mapa de especialidades por carnet
        especialidad.put(12345, "Oftalmologia");
        especialidad.put(23451, "Cardiologia");
        especialidad.put(34512, "Clinica Medica");
        especialidad.put(45123, "Cardiologia");
        especialidad.put(54321, "Neurologia");
        especialidad.put(21345, "Oftalmologia");
        especialidad.put(32145, "Neurologia");
        especialidad.put(43125, "Cardiologia");
        especialidad.put(31245, "Clinica Medica");
        especialidad.put(52341, "Neurologia");

        // Llenando el mapa de horarios por carnet
        horario.put(12345, "12:00hs");
        horario.put(23451, "12:00hs");
        horario.put(34512, "12:30hs");
        horario.put(45123, "11:30hs");
        horario.put(54321, "10:00hs");
        horario.put(21345, "11:00hs");
        horario.put(32145, "12:00hs");
        horario.put(43125, "13:00hs");
        horario.put(31245, "12:00hs");
        horario.put(52341, "11:00hs");

        // Llenando el mapa de consultorios por especialidad
        consultorios.put("Neurologia", 5);
        consultorios.put("Cardiologia", 7);
        consultorios.put("Oftalmologia", 1);
        consultorios.put("Clinica Medica", 4);

        // Llenando el mapa de especialistas por especialidad
        especialistas.put("Neurologia", "Dra. Sabrina Lopez");
        especialistas.put("Cardiologia", "Dra. Juliana Garcia");
        especialistas.put("Oftalmologia", "Dr. Roberto Perez");
        especialistas.put("Clinica Medica", "Dra. Monica Guzman");
    }

    public static void procesarTurnos(Map<Integer, String> carnetNombre, Map<Integer, String> especialidad, Map<Integer, String> horario,
                                      Map<String, List<String>> turnosPorEspecialidad, Map<String, Integer> pacientesPorEspecialidad) { // Método para procesar turnos y contar pacientes
        for (Integer carnet : carnetNombre.keySet()) { // Itera sobre cada carnet en el mapa de nombres
            String especialidadPaciente = especialidad.get(carnet); // Obtiene la especialidad del paciente
            String horarioPaciente = horario.get(carnet); // Obtiene el horario del paciente
            String turno = carnetNombre.get(carnet) + " - " + horarioPaciente; // Crea un string con el nombre y horario del paciente

            if (!turnosPorEspecialidad.containsKey(especialidadPaciente)) { // Si la especialidad no está en el mapa de turnos
                turnosPorEspecialidad.put(especialidadPaciente, new ArrayList<>()); // Añade la especialidad al mapa con una lista vacía
                pacientesPorEspecialidad.put(especialidadPaciente, 0); // Inicializa el contador de pacientes para esa especialidad
            }

            turnosPorEspecialidad.get(especialidadPaciente).add(turno); // Añade el turno a la lista de turnos de la especialidad
            pacientesPorEspecialidad.put(especialidadPaciente, pacientesPorEspecialidad.get(especialidadPaciente) + 1); // Incrementa el contador de pacientes para esa especialidad
        }
    }
}




		
		

	






	


    


    