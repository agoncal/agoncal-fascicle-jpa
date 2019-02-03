package org.agoncal.fascicle.jpa.understanding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */
public class MainJDBC {

  public static void main(String[] args) throws SQLException, ClassNotFoundException {

    persistBook(new Book(5000L, "H2G2", "Best IT Scifi Book", 12.5f, "1234-5678-5678", 247, true));

    Book book = findBook(5000L);

    System.out.println("# " + book);
  }

  /**
   * Gets a database connection
   */
  static {
    try {
      Class.forName("org.h2.Driver");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  private static Connection getConnection() throws SQLException {
    return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/cdbookstoreDB");
  }

  /**
   * Persists the book to the database
   */
  private static void persistBook(Book book) throws SQLException {

    // tag::adocPersist[]
    String query = "INSERT INTO BOOK (ID, TITLE, DESCRIPTION, PRICE, ISBN) VALUES (?, ?, ?, ?, ?)";

    try (PreparedStatement stmt = getConnection().prepareStatement(query)) {

      stmt.setLong(1, book.getId());
      stmt.setString(2, book.getTitle());
      stmt.setString(3, book.getDescription());
      stmt.setFloat(4, book.getPrice());
      stmt.setString(5, book.getIsbn());

      stmt.executeUpdate();
    }
    // end::adocPersist[]
  }

  /**
   * Finds the book from the database
   */
  private static Book findBook(Long id) throws SQLException {

    Book book = new Book();
    // tag::adocFind[]
    String query = "SELECT ID, TITLE, DESCRIPTION, PRICE FROM BOOK WHERE ID = ?";

    try (PreparedStatement stmt = getConnection().prepareStatement(query)) {

      stmt.setLong(1, id);

      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        book.setId(rs.getLong("ID"));
        book.setTitle(rs.getString("TITLE"));
        book.setDescription(rs.getString("DESCRIPTION"));
        book.setPrice(rs.getFloat("PRICE"));
      }
    }
    // end::adocFind[]
    return book;
  }
}


