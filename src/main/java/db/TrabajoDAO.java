package db;

import clases.Trabajo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrabajoDAO {

    public static void insert(Trabajo t) throws SQLException {
        String sql = "INSERT INTO trabajo (codigo, nombre, pasaporte, fecha_viaje, semanas, motivo, entidad_contratadora, tipo_trabajo, tarifa_horas, horas_laborables) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = ConnectionDB.getConnection().prepareStatement(sql)) {
            stmt.setString(1, t.getCodigo());
            stmt.setString(2, t.getNombre());
            stmt.setString(3, t.getPasaporte());
            stmt.setDate(4, new java.sql.Date(t.getFechaViaje().getTime()));
            stmt.setInt(5, t.getSemanas());
            stmt.setString(6, t.getMotivo());
            stmt.setString(7, t.getEntidadContratadora());
            stmt.setString(8, t.getTipoTrabajo());
            stmt.setInt(9, t.getTarifaHoras());
            stmt.setInt(10, t.getHorasLaborables());
            stmt.executeUpdate();
        }
    }

    public Trabajo getByCode(String codigo) throws SQLException {
        String sql = "SELECT * FROM trabajo WHERE codigo = ?";
        try (PreparedStatement stmt = ConnectionDB.getConnection().prepareStatement(sql)) {
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return mapResultSet(rs);
        }
        return null;
    }

    public List<Trabajo> getByName(String nombre) throws SQLException {
        String sql = "SELECT * FROM trabajo WHERE nombre ILIKE ?";
        List<Trabajo> lista = new ArrayList<>();
        try (PreparedStatement stmt = ConnectionDB.getConnection().prepareStatement(sql)) {
            stmt.setString(1, "%" + nombre + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(mapResultSet(rs));
            }
        }
        return lista;
    }

    public void update(Trabajo t) throws SQLException {
        String sql = "UPDATE trabajo SET nombre=?, pasaporte=?, fecha_viaje=?, semanas=?, motivo=?, entidad_contratadora=?, tipo_trabajo=?, tarifa_horas=?, horas_laborables=? WHERE codigo=?";
        try (PreparedStatement stmt = ConnectionDB.getConnection().prepareStatement(sql)) {
            stmt.setString(1, t.getNombre());
            stmt.setString(2, t.getPasaporte());
            stmt.setDate(3, new java.sql.Date(t.getFechaViaje().getTime()));
            stmt.setInt(4, t.getSemanas());
            stmt.setString(5, t.getMotivo());
            stmt.setString(6, t.getEntidadContratadora());
            stmt.setString(7, t.getTipoTrabajo());
            stmt.setInt(8, t.getTarifaHoras());
            stmt.setInt(9, t.getHorasLaborables());
            stmt.setString(10, t.getCodigo());
            stmt.executeUpdate();
        }
    }

    public void delete(String codigo) throws SQLException {
        String sql = "DELETE FROM trabajo WHERE codigo = ?";
        try (PreparedStatement stmt = ConnectionDB.getConnection().prepareStatement(sql)) {
            stmt.setString(1, codigo);
            stmt.executeUpdate();
        }
    }

    private Trabajo mapResultSet(ResultSet rs) throws SQLException {
        return new Trabajo(
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
    }
}
