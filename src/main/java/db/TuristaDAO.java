package db;

import clases.Turista;
import enums.Hospedaje;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TuristaDAO {

    public void insert(Turista t) throws SQLException {
        String sql = "INSERT INTO turista (codigo, nombre, pasaporte, fecha_viaje, semanas, motivo, hospedaje) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = ConnectionDB.getConnection().prepareStatement(sql)) {
            stmt.setString(1, t.getCodigo());
            stmt.setString(2, t.getNombre());
            stmt.setString(3, t.getPasaporte());
            stmt.setDate(4, new java.sql.Date(t.getFechaViaje().getTime()));
            stmt.setInt(5, t.getSemanas());
            stmt.setString(6, t.getMotivo());
            stmt.setString(7, t.getHospedaje().name());
            stmt.executeUpdate();
        }
    }

    public Turista getByCode(String codigo) throws SQLException {
        String sql = "SELECT * FROM turista WHERE codigo = ?";
        try (PreparedStatement stmt = ConnectionDB.getConnection().prepareStatement(sql)) {
            stmt.setString(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) return mapResultSet(rs);
        }
        return null;
    }

    public List<Turista> getByName(String nombre) throws SQLException {
        String sql = "SELECT * FROM turista WHERE nombre ILIKE ?";
        List<Turista> lista = new ArrayList<>();
        try (PreparedStatement stmt = ConnectionDB.getConnection().prepareStatement(sql)) {
            stmt.setString(1, "%" + nombre + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(mapResultSet(rs));
            }
        }
        return lista;
    }

    public void update(Turista t) throws SQLException {
        String sql = "UPDATE turista SET nombre=?, pasaporte=?, fecha_viaje=?, semanas=?, motivo=?, hospedaje=? WHERE codigo=?";
        try (PreparedStatement stmt = ConnectionDB.getConnection().prepareStatement(sql)) {
            stmt.setString(1, t.getNombre());
            stmt.setString(2, t.getPasaporte());
            stmt.setDate(3, new java.sql.Date(t.getFechaViaje().getTime()));
            stmt.setInt(4, t.getSemanas());
            stmt.setString(5, t.getMotivo());
            stmt.setString(6, t.getHospedaje().name());
            stmt.setString(7, t.getCodigo());
            stmt.executeUpdate();
        }
    }

    public void delete(String codigo) throws SQLException {
        String sql = "DELETE FROM turista WHERE codigo = ?";
        try (PreparedStatement stmt = ConnectionDB.getConnection().prepareStatement(sql)) {
            stmt.setString(1, codigo);
            stmt.executeUpdate();
        }
    }

    private Turista mapResultSet(ResultSet rs) throws SQLException {
        return new Turista(
                rs.getString("codigo"),
                rs.getString("nombre"),
                rs.getString("pasaporte"),
                rs.getDate("fecha_viaje"),
                rs.getInt("semanas"),
                rs.getString("motivo"),
                Hospedaje.valueOf(rs.getString("hospedaje"))
        );
    }
}