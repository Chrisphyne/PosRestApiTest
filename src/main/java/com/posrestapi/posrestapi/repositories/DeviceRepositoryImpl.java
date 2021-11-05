package com.posrestapi.posrestapi.repositories;

import com.posrestapi.posrestapi.domain.Device;
import com.posrestapi.posrestapi.exceptions.PosAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class DeviceRepositoryImpl implements DeviceRepository{

    private static final String SQL_CREATE = "INSERT INTO POS_DEVICE(DEVICE_ID, DEVICE_NAME," +
            " SERIAL_NUMBER, MODEL_TYPE) VALUES(NEXTVAL('POS_DEVICE_SEQUENCE'), ?, ?, ?";
    private static final String SQL_COUNT_BY_NAME = "SELECT COUNT(*) FROM POS_DEVICE WHERE NAME = ?";
    private static final String SQL_FIND_BY_ID = "SELECT DEVICE_ID, DEVICE_NAME, SERIAL_NUMBER, " +
            "MODEL_TYPE FROM POS_DEVICE WHERE DEVICE_ID = ?";


    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Integer create(String name, String model, String serialNumber) throws PosAuthException {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, name);
                ps.setString(1, model);
                ps.setString(1, serialNumber);
                return ps;
            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("DEVICE_ID");
        }catch (Exception e) {
            throw new PosAuthException("Invalid details. Failed to register device!!");
        }
    }

    @Override
    public Device findByNameAndSerialNumber(String name, String serialNumber) throws PosAuthException {
        return null;
    }

    @Override
    public Integer getCountByName(String name) {
        return jdbcTemplate.queryForObject(SQL_COUNT_BY_NAME, new Object[]{name}, Integer.class);
    }

    @Override
    public Device findById(Integer deviceId) {
        return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{deviceId}, deviceRowMapper);
    }

    private RowMapper<Device> deviceRowMapper = ((rs, rowNum) -> {
        return new Device(rs.getInt("DEVICE_ID"),
                rs.getString("DEVICE_NAME"),
                rs.getString("SERIAL_NUMBER"),
                rs.getString("MODEL_TYPE"));
    });
}
