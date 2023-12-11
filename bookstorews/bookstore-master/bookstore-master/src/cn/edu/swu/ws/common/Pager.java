package cn.edu.swu.ws.common;

public class Pager {

    private String url;
    private int total;
    private int pageSize;
    private int currentPage;


    public Pager() {
    }

    public Pager(String url, int total, int pageSize, int currentPage) {
        this.url = url;
        this.total = total;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
    }

    public String toHtml() {
        System.out.println(String.format("%s %s %s %s", this.total, this.pageSize, this.currentPage, this.getTotalPage()));

        StringBuilder sb = new StringBuilder();
        sb.append("<div class='pager'>");
        sb.append(String.format("第%s页 / 共%s页, &nbsp;&nbsp;", this.getCurrentPage(), this.getTotalPage()));
        sb.append(this.getCurrentPage() > 1 ?
                String.format("<a href='%spage=%s&pageSize=%s'>前一页</a>",
                    this.getUrl(), this.getCurrentPage()-1, this.getPageSize()) : "");
        for(int i=1, t = this.getTotalPage(); i<=t; i++) {
            sb.append(String.format("&nbsp;&nbsp;<a href='%spage=%s&pageSize=%s'>&nbsp;%s&nbsp;</a>",
                    this.getUrl(), i, this.getPageSize() , i));
        }
        sb.append(this.getCurrentPage() < this.getTotalPage() ?
                String.format("&nbsp;&nbsp;<a href='%spage=%s&pageSize=%s'>后一页</a>",
                    this.getUrl(), this.getCurrentPage()+1, this.getPageSize()) : "");
        sb.append("</div>");
        return sb.toString();
    }

    public int getTotalPage() {
        return Double.valueOf(Math.ceil(this.getTotal() * 1.0 / this.getPageSize())).intValue();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
