package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store, AutoCloseable {

    private Connection cn;

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            createTable();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    private void createTable() throws Exception {
        String sql = "CREATE TABLE IF NOT EXISTS Items(id serial primary key, name text, created timestamp)";
        try (Statement statement = cn.createStatement()) {
            statement.execute(sql);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        String sql = "INSERT INTO Items(name, created) VALUES (?, ?)";
        Timestamp created = Timestamp.valueOf(item.getCreated());
        try (PreparedStatement ps = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getName());
            ps.setTimestamp(2, created);
            ps.execute();
            try (ResultSet result = ps.getGeneratedKeys()) {
                if (result.next()) {
                    item.setId(result.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        String sql = "UPDATE ITEMS SET NAME = ?, CREATED = ? WHERE ID = ?";
        try (PreparedStatement preparedStatement = cn.prepareStatement(sql)) {
            preparedStatement.setString(1, item.getName());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            preparedStatement.setInt(3, id);
            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        String sql = "DELETE FROM ITEMS WHERE ID = ?";
        try (PreparedStatement preparedStatement = cn.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        String sql = "SELECT * FROM ITEMS";
        List<Item> items = new ArrayList<>();
        try (Statement statement = cn.createStatement()) {
             try (ResultSet result = statement.executeQuery(sql)) {
                 while (result.next()) {
                     items.add(getItemFromResult(result));
                 }
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        String sql = "SELECT * FROM ITEMS WHERE NAME = ?";
        List<Item> items = new ArrayList<>();
        try (PreparedStatement preparedStatement = cn.prepareStatement(sql)) {
            preparedStatement.setString(1, key);
            try (ResultSet result = preparedStatement.executeQuery()) {
                while (result.next()) {
                    items.add(getItemFromResult(result));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        String sql = "SELECT * FROM ITEMS WHERE ID = ?";
        Item rsl = null;
        try (PreparedStatement preparedStatement = cn.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet result = preparedStatement.executeQuery()) {
                if (result.next()) {
                    rsl = getItemFromResult(result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    private Item getItemFromResult(ResultSet result) throws Exception {
        return new Item(
                result.getInt("id"),
                result.getString("name"),
                result.getTimestamp("created").toLocalDateTime()
        );
    }
}
