package tests;

import services.database.Configuration;

import java.sql.Connection;

public class TestDAO0 {
    private Connection cnt;

    public void testDatabase() {
        Configuration conf = Configuration.getInstance();
    }

    //
//    @BeforeEach
//    public void initialize() throws SQLException {
//        // TO create a table in in-memory database
//        this.cnt = DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "username", "password");
//        PreparedStatement preparedStatement = cnt.prepareStatement("CREATE TABLE IF NOT EXISTS contact (firstName VARCHAR(255), lastName VARCHAR(255), phone1 VARCHAR(255), phone VARCHAR(255), email VARCHAR(255), state VARCHAR(255))");
//        preparedStatement.execute();
//    }

//
//    @Test
//    public void test() throws SQLException {
//
//        Connection connection = cnt;
//        ResultSet resultSet = connection.prepareStatement("select * from contact where name = 'test'").executeQuery();
//        String retrievedName = null;
//
//        while (resultSet.next()) {
//            retrievedName = resultSet.getString("name");
//        }
//
//        if (retrievedName == null) {
//            throw new RuntimeException("Name test was not found, expected to be not null");
//        }
//    }
//

}
