package db;

import clases.Solicitud;
import clases.Trabajo;
import clases.Turista;
import enums.Hospedaje;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SolicitudesDAO {
    public static List<Solicitud> listAll() throws SQLException {
        List<Solicitud> lista = new ArrayList<>();

        // Obtener trabajadores
        String sqlTrabajadores = "SELECT * FROM trabajo";
        try (PreparedStatement stmt = ConnectionDB.getConnection().prepareStatement(sqlTrabajadores);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Trabajo t = new Trabajo(
                        rs.getString("codigo"),
                        rs.getString("nombre"),
                        rs.getString("pasaporte"),
                        rs.getDate("fecha_viaje"),
                        rs.getInt("semanas"),
                        rs.getString("motivo"),
                        rs.getString("entidad_contratadora"),
                        rs.getString("tipo_trabajo"),
                        rs.getInt("tarifa_horas"),
                        rs.getInt("horas_laborables")
                );
                lista.add(t);
            }
        }

        // Obtener turistas
        String sqlTuristas = "SELECT * FROM turista";
        try (PreparedStatement stmt = ConnectionDB.getConnection().prepareStatement(sqlTuristas);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Turista tur = new Turista(
                        rs.getString("codigo"),
                        rs.getString("nombre"),
                        rs.getString("pasaporte"),
                        rs.getDate("fecha_viaje"),
                        rs.getInt("semanas"),
                        rs.getString("motivo"),
                        Hospedaje.valueOf(rs.getString("hospedaje"))
                );
                lista.add(tur);
            }
        }

        return lista;
    }
}
