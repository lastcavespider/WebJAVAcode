package cn.edu.swu.ws.common;

import cn.edu.swu.ws.book.Book;

import java.util.List;

public class PageTool {

    private static String template = "<!DOCTYPE html><html lang=\"en\">" +
        "<head>  " +
        "<meta charset=\"UTF-8\">  " +
        "<title>网上书城</title>  " +
        "<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\" />" +
        "</head>" +
        "<body>" +
        "<div style=\"float:right\">  " +
        "<a href=\"./logout\">退出系统 </a></div>" +
        "<center>  " +
        "<h1 style=\"color:red\">欢迎使用SWU网上书城</h1>" +
        " <hr/> " +
            "<table border=0 style='border:0px'><tr>" +
            "   <td style='border:0px'><a href='./main'>首 页</a></td>" +
            "   <td style='border:0px'><a href='./add.html'>添 加</a></td>" +
            "   <td style='border:0px'><form action='./search' method='post'>" +
            "       <select name='type'>" +
            "          <option value='name'>书 名</option>" +
            "          <option value='author'>作 者</option>" +
            "          <option value='content'>内 容</option>" +
            "       </select>&nbsp;&nbsp;" +
            "       <input type='text' name='key'/>&nbsp;&nbsp;<input type='submit' value='查 询'></form>" +
            "   </td>" +
            "</tr></table><br><br>" +
        "  %s" +
        "</center>\n" +
        "</body></html>";

    public static String wrap(String body) {
        return String.format(template, body);
    }

    public static String wrapBookTable(List<Book> books) {
        StringBuilder table = new StringBuilder();
        table.append("<table class='tb-book'>");
        table.append("<tr><th>ID</th><th>书名</th><th>作者</th><th>价格</th><th>内容</th><th>图片</th><th></th><th></th></tr>");
        for (Book book : books) {
            table.append(String.format(
                "<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td><a href='./image/upload/%s' target=_blank><img class='book-pic' src='./image/upload/%s'/></a></td>" +
                        "<td><a href='./deleteBook?bookId=%s'>删除</a></td>" +
                        "<td><a href='./updateBook.html?bookId=%s'>修改</a></td></tr>",
                book.getId(), book.getName(), book.getAuthor(),
                book.getPrice(), book.getContent(), book.getPicture(), book.getPicture(),
                book.getId(), book.getId()
            ));
        }
        table.append("</table>");
        return table.toString();
    }
}
