package cn.edu.swu.ws.book;

import cn.edu.swu.ws.db.BaseRepo;
import cn.edu.swu.ws.db.ResultSetVisitor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepo extends BaseRepo {

    private static BookRepo instance = new BookRepo();

    public static BookRepo getInstance() {
        return instance;
    }

    private BookRepo() {}

    public boolean addBook(Book book) throws SQLException {
        String insertTemplate = "insert into book(name, author, price, content, picture) values ('%s', '%s', %s, '%s', '%s')";
        String sql = String.format(insertTemplate,
                book.getName(), book.getAuthor(), book.getPrice(), book.getContent(), book.getPicture());
        return this.execute(sql);
    }

    public boolean updateBook(Book book) throws SQLException {
        String sql = null;
        if (book.getPicture() != null) {
            String template = "update book set " +
                    "name='%s', author='%s', price=%s, content='%s', picture='%s' where id=%s";
            sql = String.format(template,
                    book.getName(), book.getAuthor(), book.getPrice(), book.getContent(), book.getPicture(),
                    book.getId());
        } else {
            String template = "update book set " +
                    "name='%s', author='%s', price=%s, content='%s' where id=%s";
            sql = String.format(template,
                    book.getName(), book.getAuthor(), book.getPrice(), book.getContent(),
                    book.getId());
        }
        return this.execute(sql);
    }

    public boolean deleteBookById(Integer id) throws SQLException {
        String template = "delete from book where id=%s";
        String sql = String.format(template, id);
        return this.execute(sql);
    }

    public List<Book> queryBook(String sql) throws SQLException {
        final List<Book> books = new ArrayList<>();
        this.query(sql, new ResultSetVisitor() {
            @Override
            public void visit(ResultSet resultSet) {
                Book book = new Book();
                try {
                    book.setId(resultSet.getInt("id"));
                    book.setName(resultSet.getString("name"));
                    book.setAuthor(resultSet.getString("author"));
                    book.setPrice(resultSet.getFloat("price"));
                    book.setContent(resultSet.getString("content"));
                    book.setPicture(resultSet.getString("picture"));
                    books.add(book);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return books;
    }

    public Book getBookById(String id) throws SQLException {
        String template = "select * from book where id=%s";
        List<Book> books = this.queryBook(String.format(template, id));
        return books.size() > 0 ? books.get(0) : null;
    }

    public int totalBooks() throws SQLException {
        String sql = "select count(*) from book";
        final int[] total = {0};
        this.query(sql, new ResultSetVisitor() {
            @Override
            public void visit(ResultSet resultSet) {
                try {
                    total[0] = resultSet.getInt(1);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return total[0];
    }

    public int totalPagesOfBook(int pageSize) throws SQLException {
        String sql = "select ceil(count(*) / 4) as pages from book";
        final int[] pages = {0};
        this.query(sql, new ResultSetVisitor() {
            @Override
            public void visit(ResultSet resultSet) {
                try {
                    pages[0] = resultSet.getInt("pages");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return pages[0];
    }
}
